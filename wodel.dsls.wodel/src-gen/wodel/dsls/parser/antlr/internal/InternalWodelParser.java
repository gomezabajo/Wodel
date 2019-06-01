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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'with'", "'blocks'", "'{'", "'}'", "'commands'", "'constraints'", "'library'", "'for'", "'metamodel'", "'generate'", "'exhaustive'", "'mutants'", "'in'", "'from'", "'resources'", "','", "'description'", "'='", "'repeat'", "'['", "'..'", "']'", "'context'", "':'", "'::'", "';'", "'<>'", "'.'", "'->'", "'collect'", "'('", "'|'", "'or'", "'and'", "')'", "'iterate'", "'$'", "'exists'", "'forAll'", "'true'", "'false'", "'import'", "'-'", "'E'", "'e'", "'self'", "'container'", "'null'", "'remove'", "'one'", "'reference'", "'all'", "'create'", "'select'", "'sample'", "'modify'", "'to'", "'source'", "'target'", "'deep'", "'clone'", "'retype'", "'as'", "'unset'", "'swap'", "'copy'", "'reverse'", "'+'", "'swapref'", "'where'", "'closure'", "'other'", "'typed'", "'random-boolean'", "'random-string'", "'upper'", "'catstart'", "'catend'", "'lower'", "'replace'", "'random-double'", "'min'", "'max'", "'random-int'", "'random-int-string'", "'random'", "'*'", "'is'", "'not'", "'>='", "'<='", "'>'", "'<'", "'/'", "'%'", "'yes'", "'no'", "'equals'", "'distinct'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalWodelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWodelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWodelParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWodel.g"; }



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
    // InternalWodel.g:65:1: entryRuleMutatorEnvironment returns [EObject current=null] : iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF ;
    public final EObject entryRuleMutatorEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorEnvironment = null;


        try {
            // InternalWodel.g:65:59: (iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF )
            // InternalWodel.g:66:2: iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF
            {
             newCompositeNode(grammarAccess.getMutatorEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMutatorEnvironment=ruleMutatorEnvironment();

            state._fsp--;

             current =iv_ruleMutatorEnvironment; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:72:1: ruleMutatorEnvironment returns [EObject current=null] : ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? ) ;
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
            // InternalWodel.g:78:2: ( ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? ) )
            // InternalWodel.g:79:2: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? )
            {
            // InternalWodel.g:79:2: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? )
            // InternalWodel.g:80:3: ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )?
            {
            // InternalWodel.g:80:3: ( (lv_load_0_0= ruleLoad ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==52) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWodel.g:81:4: (lv_load_0_0= ruleLoad )
            	    {
            	    // InternalWodel.g:81:4: (lv_load_0_0= ruleLoad )
            	    // InternalWodel.g:82:5: lv_load_0_0= ruleLoad
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getLoadLoadParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_load_0_0=ruleLoad();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"load",
            	    						lv_load_0_0,
            	    						"wodel.dsls.Wodel.Load");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalWodel.g:99:3: ( (lv_definition_1_0= ruleDefinition ) )
            // InternalWodel.g:100:4: (lv_definition_1_0= ruleDefinition )
            {
            // InternalWodel.g:100:4: (lv_definition_1_0= ruleDefinition )
            // InternalWodel.g:101:5: lv_definition_1_0= ruleDefinition
            {

            					newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getDefinitionDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_definition_1_0=ruleDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_1_0,
            						"wodel.dsls.Wodel.Definition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getMutatorEnvironmentAccess().getWithKeyword_2());
            		
            // InternalWodel.g:122:3: ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) )
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
                    // InternalWodel.g:123:4: (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' )
                    {
                    // InternalWodel.g:123:4: (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' )
                    // InternalWodel.g:124:5: otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_6); 

                    					newLeafNode(otherlv_3, grammarAccess.getMutatorEnvironmentAccess().getBlocksKeyword_3_0_0());
                    				
                    otherlv_4=(Token)match(input,13,FOLLOW_7); 

                    					newLeafNode(otherlv_4, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_0_1());
                    				
                    // InternalWodel.g:132:5: ( (lv_blocks_5_0= ruleBlock ) )
                    // InternalWodel.g:133:6: (lv_blocks_5_0= ruleBlock )
                    {
                    // InternalWodel.g:133:6: (lv_blocks_5_0= ruleBlock )
                    // InternalWodel.g:134:7: lv_blocks_5_0= ruleBlock
                    {

                    							newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getBlocksBlockParserRuleCall_3_0_2_0());
                    						
                    pushFollow(FOLLOW_8);
                    lv_blocks_5_0=ruleBlock();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    							}
                    							add(
                    								current,
                    								"blocks",
                    								lv_blocks_5_0,
                    								"wodel.dsls.Wodel.Block");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalWodel.g:151:5: ( (lv_blocks_6_0= ruleBlock ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalWodel.g:152:6: (lv_blocks_6_0= ruleBlock )
                    	    {
                    	    // InternalWodel.g:152:6: (lv_blocks_6_0= ruleBlock )
                    	    // InternalWodel.g:153:7: lv_blocks_6_0= ruleBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getBlocksBlockParserRuleCall_3_0_3_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_blocks_6_0=ruleBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"blocks",
                    	    								lv_blocks_6_0,
                    	    								"wodel.dsls.Wodel.Block");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,14,FOLLOW_9); 

                    					newLeafNode(otherlv_7, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:176:4: (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' )
                    {
                    // InternalWodel.g:176:4: (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' )
                    // InternalWodel.g:177:5: otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}'
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_6); 

                    					newLeafNode(otherlv_8, grammarAccess.getMutatorEnvironmentAccess().getCommandsKeyword_3_1_0());
                    				
                    otherlv_9=(Token)match(input,13,FOLLOW_10); 

                    					newLeafNode(otherlv_9, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_1_1());
                    				
                    // InternalWodel.g:185:5: ( (lv_commands_10_0= ruleMutator ) )
                    // InternalWodel.g:186:6: (lv_commands_10_0= ruleMutator )
                    {
                    // InternalWodel.g:186:6: (lv_commands_10_0= ruleMutator )
                    // InternalWodel.g:187:7: lv_commands_10_0= ruleMutator
                    {

                    							newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_3_1_2_0());
                    						
                    pushFollow(FOLLOW_11);
                    lv_commands_10_0=ruleMutator();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    							}
                    							add(
                    								current,
                    								"commands",
                    								lv_commands_10_0,
                    								"wodel.dsls.Wodel.Mutator");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalWodel.g:204:5: ( (lv_commands_11_0= ruleMutator ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==30||LA3_0==59||LA3_0==63||LA3_0==66||(LA3_0>=70 && LA3_0<=72)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalWodel.g:205:6: (lv_commands_11_0= ruleMutator )
                    	    {
                    	    // InternalWodel.g:205:6: (lv_commands_11_0= ruleMutator )
                    	    // InternalWodel.g:206:7: lv_commands_11_0= ruleMutator
                    	    {

                    	    							newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_3_1_3_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_commands_11_0=ruleMutator();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"commands",
                    	    								lv_commands_11_0,
                    	    								"wodel.dsls.Wodel.Mutator");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,14,FOLLOW_9); 

                    					newLeafNode(otherlv_12, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_1_4());
                    				

                    }


                    }
                    break;

            }

            // InternalWodel.g:229:3: (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalWodel.g:230:4: otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getMutatorEnvironmentAccess().getConstraintsKeyword_4_0());
                    			
                    otherlv_14=(Token)match(input,13,FOLLOW_12); 

                    				newLeafNode(otherlv_14, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalWodel.g:238:4: ( (lv_constraints_15_0= ruleConstraint ) )
                    // InternalWodel.g:239:5: (lv_constraints_15_0= ruleConstraint )
                    {
                    // InternalWodel.g:239:5: (lv_constraints_15_0= ruleConstraint )
                    // InternalWodel.g:240:6: lv_constraints_15_0= ruleConstraint
                    {

                    						newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getConstraintsConstraintParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_constraints_15_0=ruleConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    						}
                    						add(
                    							current,
                    							"constraints",
                    							lv_constraints_15_0,
                    							"wodel.dsls.Wodel.Constraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWodel.g:257:4: ( (lv_constraints_16_0= ruleConstraint ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==33) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalWodel.g:258:5: (lv_constraints_16_0= ruleConstraint )
                    	    {
                    	    // InternalWodel.g:258:5: (lv_constraints_16_0= ruleConstraint )
                    	    // InternalWodel.g:259:6: lv_constraints_16_0= ruleConstraint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getConstraintsConstraintParserRuleCall_4_3_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_constraints_16_0=ruleConstraint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"constraints",
                    	    							lv_constraints_16_0,
                    	    							"wodel.dsls.Wodel.Constraint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,14,FOLLOW_2); 

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
    // InternalWodel.g:285:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalWodel.g:285:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalWodel.g:286:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:292:1: ruleDefinition returns [EObject current=null] : (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_Library_0 = null;

        EObject this_Program_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:298:2: ( (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) )
            // InternalWodel.g:299:2: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
            {
            // InternalWodel.g:299:2: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
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
                    // InternalWodel.g:300:3: this_Library_0= ruleLibrary
                    {

                    			newCompositeNode(grammarAccess.getDefinitionAccess().getLibraryParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Library_0=ruleLibrary();

                    state._fsp--;


                    			current = this_Library_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:309:3: this_Program_1= ruleProgram
                    {

                    			newCompositeNode(grammarAccess.getDefinitionAccess().getProgramParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:321:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // InternalWodel.g:321:48: (iv_ruleLibrary= ruleLibrary EOF )
            // InternalWodel.g:322:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:328:1: ruleLibrary returns [EObject current=null] : ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_metamodel_4_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:334:2: ( ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) )
            // InternalWodel.g:335:2: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            {
            // InternalWodel.g:335:2: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            // InternalWodel.g:336:3: () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) )
            {
            // InternalWodel.g:336:3: ()
            // InternalWodel.g:337:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLibraryAccess().getLibraryAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getLibraryAccess().getLibraryKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getForKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getMetamodelKeyword_3());
            		
            // InternalWodel.g:355:3: ( (lv_metamodel_4_0= ruleEString ) )
            // InternalWodel.g:356:4: (lv_metamodel_4_0= ruleEString )
            {
            // InternalWodel.g:356:4: (lv_metamodel_4_0= ruleEString )
            // InternalWodel.g:357:5: lv_metamodel_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLibraryAccess().getMetamodelEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_metamodel_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLibraryRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_4_0,
            						"wodel.dsls.Wodel.EString");
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
    // InternalWodel.g:378:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalWodel.g:378:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalWodel.g:379:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:385:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'generate' ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )? otherlv_4= 'mutants' otherlv_5= 'in' ( (lv_output_6_0= ruleEString ) ) otherlv_7= 'from' ( (lv_source_8_0= ruleSource ) ) otherlv_9= 'metamodel' ( (lv_metamodel_10_0= ruleEString ) ) (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )? (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )? ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_exhaustive_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_num_2_0 = null;

        AntlrDatatypeRuleToken lv_output_6_0 = null;

        EObject lv_source_8_0 = null;

        AntlrDatatypeRuleToken lv_metamodel_10_0 = null;

        EObject lv_resources_15_0 = null;

        EObject lv_resources_19_0 = null;

        AntlrDatatypeRuleToken lv_description_22_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:391:2: ( ( () otherlv_1= 'generate' ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )? otherlv_4= 'mutants' otherlv_5= 'in' ( (lv_output_6_0= ruleEString ) ) otherlv_7= 'from' ( (lv_source_8_0= ruleSource ) ) otherlv_9= 'metamodel' ( (lv_metamodel_10_0= ruleEString ) ) (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )? (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )? ) )
            // InternalWodel.g:392:2: ( () otherlv_1= 'generate' ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )? otherlv_4= 'mutants' otherlv_5= 'in' ( (lv_output_6_0= ruleEString ) ) otherlv_7= 'from' ( (lv_source_8_0= ruleSource ) ) otherlv_9= 'metamodel' ( (lv_metamodel_10_0= ruleEString ) ) (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )? (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )? )
            {
            // InternalWodel.g:392:2: ( () otherlv_1= 'generate' ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )? otherlv_4= 'mutants' otherlv_5= 'in' ( (lv_output_6_0= ruleEString ) ) otherlv_7= 'from' ( (lv_source_8_0= ruleSource ) ) otherlv_9= 'metamodel' ( (lv_metamodel_10_0= ruleEString ) ) (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )? (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )? )
            // InternalWodel.g:393:3: () otherlv_1= 'generate' ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )? otherlv_4= 'mutants' otherlv_5= 'in' ( (lv_output_6_0= ruleEString ) ) otherlv_7= 'from' ( (lv_source_8_0= ruleSource ) ) otherlv_9= 'metamodel' ( (lv_metamodel_10_0= ruleEString ) ) (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )? (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )?
            {
            // InternalWodel.g:393:3: ()
            // InternalWodel.g:394:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProgramAccess().getProgramAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getGenerateKeyword_1());
            		
            // InternalWodel.g:404:3: ( ( (lv_num_2_0= ruleEInt ) ) | ( (lv_exhaustive_3_0= 'exhaustive' ) ) )?
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||LA8_0==53) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            switch (alt8) {
                case 1 :
                    // InternalWodel.g:405:4: ( (lv_num_2_0= ruleEInt ) )
                    {
                    // InternalWodel.g:405:4: ( (lv_num_2_0= ruleEInt ) )
                    // InternalWodel.g:406:5: (lv_num_2_0= ruleEInt )
                    {
                    // InternalWodel.g:406:5: (lv_num_2_0= ruleEInt )
                    // InternalWodel.g:407:6: lv_num_2_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getProgramAccess().getNumEIntParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_num_2_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProgramRule());
                    						}
                    						set(
                    							current,
                    							"num",
                    							lv_num_2_0,
                    							"wodel.dsls.Wodel.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:425:4: ( (lv_exhaustive_3_0= 'exhaustive' ) )
                    {
                    // InternalWodel.g:425:4: ( (lv_exhaustive_3_0= 'exhaustive' ) )
                    // InternalWodel.g:426:5: (lv_exhaustive_3_0= 'exhaustive' )
                    {
                    // InternalWodel.g:426:5: (lv_exhaustive_3_0= 'exhaustive' )
                    // InternalWodel.g:427:6: lv_exhaustive_3_0= 'exhaustive'
                    {
                    lv_exhaustive_3_0=(Token)match(input,21,FOLLOW_18); 

                    						newLeafNode(lv_exhaustive_3_0, grammarAccess.getProgramAccess().getExhaustiveExhaustiveKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProgramRule());
                    						}
                    						setWithLastConsumed(current, "exhaustive", true, "exhaustive");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getProgramAccess().getMutantsKeyword_3());
            		
            otherlv_5=(Token)match(input,23,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getInKeyword_4());
            		
            // InternalWodel.g:448:3: ( (lv_output_6_0= ruleEString ) )
            // InternalWodel.g:449:4: (lv_output_6_0= ruleEString )
            {
            // InternalWodel.g:449:4: (lv_output_6_0= ruleEString )
            // InternalWodel.g:450:5: lv_output_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getProgramAccess().getOutputEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_20);
            lv_output_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_6_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,24,FOLLOW_16); 

            			newLeafNode(otherlv_7, grammarAccess.getProgramAccess().getFromKeyword_6());
            		
            // InternalWodel.g:471:3: ( (lv_source_8_0= ruleSource ) )
            // InternalWodel.g:472:4: (lv_source_8_0= ruleSource )
            {
            // InternalWodel.g:472:4: (lv_source_8_0= ruleSource )
            // InternalWodel.g:473:5: lv_source_8_0= ruleSource
            {

            					newCompositeNode(grammarAccess.getProgramAccess().getSourceSourceParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_15);
            lv_source_8_0=ruleSource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_8_0,
            						"wodel.dsls.Wodel.Source");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,19,FOLLOW_16); 

            			newLeafNode(otherlv_9, grammarAccess.getProgramAccess().getMetamodelKeyword_8());
            		
            // InternalWodel.g:494:3: ( (lv_metamodel_10_0= ruleEString ) )
            // InternalWodel.g:495:4: (lv_metamodel_10_0= ruleEString )
            {
            // InternalWodel.g:495:4: (lv_metamodel_10_0= ruleEString )
            // InternalWodel.g:496:5: lv_metamodel_10_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_21);
            lv_metamodel_10_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_10_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:513:3: (otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==11) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==25) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalWodel.g:514:4: otherlv_11= 'with' otherlv_12= 'resources' otherlv_13= 'from' otherlv_14= '{' ( (lv_resources_15_0= ruleResource ) ) otherlv_16= '}' (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )*
                    {
                    otherlv_11=(Token)match(input,11,FOLLOW_22); 

                    				newLeafNode(otherlv_11, grammarAccess.getProgramAccess().getWithKeyword_10_0());
                    			
                    otherlv_12=(Token)match(input,25,FOLLOW_20); 

                    				newLeafNode(otherlv_12, grammarAccess.getProgramAccess().getResourcesKeyword_10_1());
                    			
                    otherlv_13=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getProgramAccess().getFromKeyword_10_2());
                    			
                    otherlv_14=(Token)match(input,13,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_10_3());
                    			
                    // InternalWodel.g:530:4: ( (lv_resources_15_0= ruleResource ) )
                    // InternalWodel.g:531:5: (lv_resources_15_0= ruleResource )
                    {
                    // InternalWodel.g:531:5: (lv_resources_15_0= ruleResource )
                    // InternalWodel.g:532:6: lv_resources_15_0= ruleResource
                    {

                    						newCompositeNode(grammarAccess.getProgramAccess().getResourcesResourceParserRuleCall_10_4_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_resources_15_0=ruleResource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProgramRule());
                    						}
                    						add(
                    							current,
                    							"resources",
                    							lv_resources_15_0,
                    							"wodel.dsls.Wodel.Resource");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,14,FOLLOW_24); 

                    				newLeafNode(otherlv_16, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_10_5());
                    			
                    // InternalWodel.g:553:4: (otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==26) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalWodel.g:554:5: otherlv_17= ',' otherlv_18= '{' ( (lv_resources_19_0= ruleResource ) ) otherlv_20= '}'
                    	    {
                    	    otherlv_17=(Token)match(input,26,FOLLOW_6); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getProgramAccess().getCommaKeyword_10_6_0());
                    	    				
                    	    otherlv_18=(Token)match(input,13,FOLLOW_7); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_10_6_1());
                    	    				
                    	    // InternalWodel.g:562:5: ( (lv_resources_19_0= ruleResource ) )
                    	    // InternalWodel.g:563:6: (lv_resources_19_0= ruleResource )
                    	    {
                    	    // InternalWodel.g:563:6: (lv_resources_19_0= ruleResource )
                    	    // InternalWodel.g:564:7: lv_resources_19_0= ruleResource
                    	    {

                    	    							newCompositeNode(grammarAccess.getProgramAccess().getResourcesResourceParserRuleCall_10_6_2_0());
                    	    						
                    	    pushFollow(FOLLOW_23);
                    	    lv_resources_19_0=ruleResource();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProgramRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"resources",
                    	    								lv_resources_19_0,
                    	    								"wodel.dsls.Wodel.Resource");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_20=(Token)match(input,14,FOLLOW_24); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_10_6_3());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalWodel.g:587:3: (otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalWodel.g:588:4: otherlv_21= 'description' ( (lv_description_22_0= ruleEString ) )
                    {
                    otherlv_21=(Token)match(input,27,FOLLOW_16); 

                    				newLeafNode(otherlv_21, grammarAccess.getProgramAccess().getDescriptionKeyword_11_0());
                    			
                    // InternalWodel.g:592:4: ( (lv_description_22_0= ruleEString ) )
                    // InternalWodel.g:593:5: (lv_description_22_0= ruleEString )
                    {
                    // InternalWodel.g:593:5: (lv_description_22_0= ruleEString )
                    // InternalWodel.g:594:6: lv_description_22_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getProgramAccess().getDescriptionEStringParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_description_22_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProgramRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_22_0,
                    							"wodel.dsls.Wodel.EString");
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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleSource"
    // InternalWodel.g:616:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // InternalWodel.g:616:47: (iv_ruleSource= ruleSource EOF )
            // InternalWodel.g:617:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:623:1: ruleSource returns [EObject current=null] : ( () ( (lv_path_1_0= ruleEString ) ) ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:629:2: ( ( () ( (lv_path_1_0= ruleEString ) ) ) )
            // InternalWodel.g:630:2: ( () ( (lv_path_1_0= ruleEString ) ) )
            {
            // InternalWodel.g:630:2: ( () ( (lv_path_1_0= ruleEString ) ) )
            // InternalWodel.g:631:3: () ( (lv_path_1_0= ruleEString ) )
            {
            // InternalWodel.g:631:3: ()
            // InternalWodel.g:632:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSourceAccess().getSourceAction_0(),
            					current);
            			

            }

            // InternalWodel.g:638:3: ( (lv_path_1_0= ruleEString ) )
            // InternalWodel.g:639:4: (lv_path_1_0= ruleEString )
            {
            // InternalWodel.g:639:4: (lv_path_1_0= ruleEString )
            // InternalWodel.g:640:5: lv_path_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSourceAccess().getPathEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSourceRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_1_0,
            						"wodel.dsls.Wodel.EString");
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


    // $ANTLR start "entryRuleResource"
    // InternalWodel.g:661:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalWodel.g:661:49: (iv_ruleResource= ruleResource EOF )
            // InternalWodel.g:662:2: iv_ruleResource= ruleResource EOF
            {
             newCompositeNode(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResource=ruleResource();

            state._fsp--;

             current =iv_ruleResource; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalWodel.g:668:1: ruleResource returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_path_3_0= ruleSource ) ) otherlv_4= 'metamodel' otherlv_5= '=' ( (lv_metamodel_6_0= ruleEString ) ) ) ;
    public final EObject ruleResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_path_3_0 = null;

        AntlrDatatypeRuleToken lv_metamodel_6_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:674:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_path_3_0= ruleSource ) ) otherlv_4= 'metamodel' otherlv_5= '=' ( (lv_metamodel_6_0= ruleEString ) ) ) )
            // InternalWodel.g:675:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_path_3_0= ruleSource ) ) otherlv_4= 'metamodel' otherlv_5= '=' ( (lv_metamodel_6_0= ruleEString ) ) )
            {
            // InternalWodel.g:675:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_path_3_0= ruleSource ) ) otherlv_4= 'metamodel' otherlv_5= '=' ( (lv_metamodel_6_0= ruleEString ) ) )
            // InternalWodel.g:676:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_path_3_0= ruleSource ) ) otherlv_4= 'metamodel' otherlv_5= '=' ( (lv_metamodel_6_0= ruleEString ) )
            {
            // InternalWodel.g:676:3: ()
            // InternalWodel.g:677:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResourceAccess().getResourceAction_0(),
            					current);
            			

            }

            // InternalWodel.g:683:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWodel.g:684:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWodel.g:684:4: (lv_name_1_0= RULE_ID )
            // InternalWodel.g:685:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_1_0, grammarAccess.getResourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getResourceAccess().getEqualsSignKeyword_2());
            		
            // InternalWodel.g:705:3: ( (lv_path_3_0= ruleSource ) )
            // InternalWodel.g:706:4: (lv_path_3_0= ruleSource )
            {
            // InternalWodel.g:706:4: (lv_path_3_0= ruleSource )
            // InternalWodel.g:707:5: lv_path_3_0= ruleSource
            {

            					newCompositeNode(grammarAccess.getResourceAccess().getPathSourceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
            lv_path_3_0=ruleSource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResourceRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_3_0,
            						"wodel.dsls.Wodel.Source");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getResourceAccess().getMetamodelKeyword_4());
            		
            otherlv_5=(Token)match(input,28,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getResourceAccess().getEqualsSignKeyword_5());
            		
            // InternalWodel.g:732:3: ( (lv_metamodel_6_0= ruleEString ) )
            // InternalWodel.g:733:4: (lv_metamodel_6_0= ruleEString )
            {
            // InternalWodel.g:733:4: (lv_metamodel_6_0= ruleEString )
            // InternalWodel.g:734:5: lv_metamodel_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getResourceAccess().getMetamodelEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_metamodel_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResourceRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_6_0,
            						"wodel.dsls.Wodel.EString");
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
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleBlock"
    // InternalWodel.g:755:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalWodel.g:755:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalWodel.g:756:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:762:1: ruleBlock returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= ruleEString ) )? (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )? otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )? ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        Enumerator lv_repeat_8_0 = null;

        EObject lv_commands_10_0 = null;

        EObject lv_commands_11_0 = null;

        AntlrDatatypeRuleToken lv_min_14_0 = null;

        AntlrDatatypeRuleToken lv_max_16_0 = null;

        AntlrDatatypeRuleToken lv_fixed_17_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:768:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= ruleEString ) )? (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )? otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )? ) )
            // InternalWodel.g:769:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= ruleEString ) )? (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )? otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )? )
            {
            // InternalWodel.g:769:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= ruleEString ) )? (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )? otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )? )
            // InternalWodel.g:770:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= ruleEString ) )? (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )? otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )?
            {
            // InternalWodel.g:770:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalWodel.g:771:4: (lv_name_0_0= RULE_ID )
            {
            // InternalWodel.g:771:4: (lv_name_0_0= RULE_ID )
            // InternalWodel.g:772:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_0_0, grammarAccess.getBlockAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWodel.g:788:3: ( (lv_description_1_0= ruleEString ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWodel.g:789:4: (lv_description_1_0= ruleEString )
                    {
                    // InternalWodel.g:789:4: (lv_description_1_0= ruleEString )
                    // InternalWodel.g:790:5: lv_description_1_0= ruleEString
                    {

                    					newCompositeNode(grammarAccess.getBlockAccess().getDescriptionEStringParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_27);
                    lv_description_1_0=ruleEString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBlockRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_1_0,
                    						"wodel.dsls.Wodel.EString");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalWodel.g:807:3: (otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalWodel.g:808:4: otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getBlockAccess().getFromKeyword_2_0());
                    			
                    // InternalWodel.g:812:4: ( (otherlv_3= RULE_ID ) )
                    // InternalWodel.g:813:5: (otherlv_3= RULE_ID )
                    {
                    // InternalWodel.g:813:5: (otherlv_3= RULE_ID )
                    // InternalWodel.g:814:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBlockRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getFromBlockCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:825:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==26) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalWodel.g:826:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_7); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getBlockAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalWodel.g:830:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalWodel.g:831:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalWodel.g:831:6: (otherlv_5= RULE_ID )
                    	    // InternalWodel.g:832:7: otherlv_5= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getBlockRule());
                    	    							}
                    	    						
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_28); 

                    	    							newLeafNode(otherlv_5, grammarAccess.getBlockAccess().getFromBlockCrossReference_2_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalWodel.g:845:3: (otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalWodel.g:846:4: otherlv_6= 'repeat' otherlv_7= '=' ( (lv_repeat_8_0= ruleRepeat ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_25); 

                    				newLeafNode(otherlv_6, grammarAccess.getBlockAccess().getRepeatKeyword_3_0());
                    			
                    otherlv_7=(Token)match(input,28,FOLLOW_29); 

                    				newLeafNode(otherlv_7, grammarAccess.getBlockAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalWodel.g:854:4: ( (lv_repeat_8_0= ruleRepeat ) )
                    // InternalWodel.g:855:5: (lv_repeat_8_0= ruleRepeat )
                    {
                    // InternalWodel.g:855:5: (lv_repeat_8_0= ruleRepeat )
                    // InternalWodel.g:856:6: lv_repeat_8_0= ruleRepeat
                    {

                    						newCompositeNode(grammarAccess.getBlockAccess().getRepeatRepeatEnumRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_repeat_8_0=ruleRepeat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBlockRule());
                    						}
                    						set(
                    							current,
                    							"repeat",
                    							lv_repeat_8_0,
                    							"wodel.dsls.Wodel.Repeat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWodel.g:878:3: ( (lv_commands_10_0= ruleMutator ) )
            // InternalWodel.g:879:4: (lv_commands_10_0= ruleMutator )
            {
            // InternalWodel.g:879:4: (lv_commands_10_0= ruleMutator )
            // InternalWodel.g:880:5: lv_commands_10_0= ruleMutator
            {

            					newCompositeNode(grammarAccess.getBlockAccess().getCommandsMutatorParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_commands_10_0=ruleMutator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlockRule());
            					}
            					add(
            						current,
            						"commands",
            						lv_commands_10_0,
            						"wodel.dsls.Wodel.Mutator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:897:3: ( (lv_commands_11_0= ruleMutator ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==30||LA16_0==59||LA16_0==63||LA16_0==66||(LA16_0>=70 && LA16_0<=72)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalWodel.g:898:4: (lv_commands_11_0= ruleMutator )
            	    {
            	    // InternalWodel.g:898:4: (lv_commands_11_0= ruleMutator )
            	    // InternalWodel.g:899:5: lv_commands_11_0= ruleMutator
            	    {

            	    					newCompositeNode(grammarAccess.getBlockAccess().getCommandsMutatorParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_commands_11_0=ruleMutator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_11_0,
            	    						"wodel.dsls.Wodel.Mutator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_12=(Token)match(input,14,FOLLOW_30); 

            			newLeafNode(otherlv_12, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_7());
            		
            // InternalWodel.g:920:3: (otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalWodel.g:921:4: otherlv_13= '[' ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) ) otherlv_18= ']'
                    {
                    otherlv_13=(Token)match(input,30,FOLLOW_31); 

                    				newLeafNode(otherlv_13, grammarAccess.getBlockAccess().getLeftSquareBracketKeyword_8_0());
                    			
                    // InternalWodel.g:925:4: ( ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_17_0= ruleEInt ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==53) ) {
                        int LA17_1 = input.LA(2);

                        if ( (LA17_1==RULE_INT) ) {
                            int LA17_2 = input.LA(3);

                            if ( (LA17_2==32) ) {
                                alt17=2;
                            }
                            else if ( (LA17_2==31) ) {
                                alt17=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA17_0==RULE_INT) ) {
                        int LA17_2 = input.LA(2);

                        if ( (LA17_2==32) ) {
                            alt17=2;
                        }
                        else if ( (LA17_2==31) ) {
                            alt17=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalWodel.g:926:5: ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) )
                            {
                            // InternalWodel.g:926:5: ( ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) ) )
                            // InternalWodel.g:927:6: ( (lv_min_14_0= ruleEInt ) ) otherlv_15= '..' ( (lv_max_16_0= ruleMaxCardinality ) )
                            {
                            // InternalWodel.g:927:6: ( (lv_min_14_0= ruleEInt ) )
                            // InternalWodel.g:928:7: (lv_min_14_0= ruleEInt )
                            {
                            // InternalWodel.g:928:7: (lv_min_14_0= ruleEInt )
                            // InternalWodel.g:929:8: lv_min_14_0= ruleEInt
                            {

                            								newCompositeNode(grammarAccess.getBlockAccess().getMinEIntParserRuleCall_8_1_0_0_0());
                            							
                            pushFollow(FOLLOW_32);
                            lv_min_14_0=ruleEInt();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getBlockRule());
                            								}
                            								set(
                            									current,
                            									"min",
                            									lv_min_14_0,
                            									"wodel.dsls.Wodel.EInt");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            otherlv_15=(Token)match(input,31,FOLLOW_33); 

                            						newLeafNode(otherlv_15, grammarAccess.getBlockAccess().getFullStopFullStopKeyword_8_1_0_1());
                            					
                            // InternalWodel.g:950:6: ( (lv_max_16_0= ruleMaxCardinality ) )
                            // InternalWodel.g:951:7: (lv_max_16_0= ruleMaxCardinality )
                            {
                            // InternalWodel.g:951:7: (lv_max_16_0= ruleMaxCardinality )
                            // InternalWodel.g:952:8: lv_max_16_0= ruleMaxCardinality
                            {

                            								newCompositeNode(grammarAccess.getBlockAccess().getMaxMaxCardinalityParserRuleCall_8_1_0_2_0());
                            							
                            pushFollow(FOLLOW_34);
                            lv_max_16_0=ruleMaxCardinality();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getBlockRule());
                            								}
                            								set(
                            									current,
                            									"max",
                            									lv_max_16_0,
                            									"wodel.dsls.Wodel.MaxCardinality");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:971:5: ( (lv_fixed_17_0= ruleEInt ) )
                            {
                            // InternalWodel.g:971:5: ( (lv_fixed_17_0= ruleEInt ) )
                            // InternalWodel.g:972:6: (lv_fixed_17_0= ruleEInt )
                            {
                            // InternalWodel.g:972:6: (lv_fixed_17_0= ruleEInt )
                            // InternalWodel.g:973:7: lv_fixed_17_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getBlockAccess().getFixedEIntParserRuleCall_8_1_1_0());
                            						
                            pushFollow(FOLLOW_34);
                            lv_fixed_17_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getBlockRule());
                            							}
                            							set(
                            								current,
                            								"fixed",
                            								lv_fixed_17_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getBlockAccess().getRightSquareBracketKeyword_8_2());
                    			

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
    // InternalWodel.g:1000:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalWodel.g:1000:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalWodel.g:1001:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:1007:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;

        EObject lv_expressions_4_0 = null;

        AntlrDatatypeRuleToken lv_rules_6_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1013:2: ( (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) ) ) )
            // InternalWodel.g:1014:2: (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) ) )
            {
            // InternalWodel.g:1014:2: (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) ) )
            // InternalWodel.g:1015:3: otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getContextKeyword_0());
            		
            // InternalWodel.g:1019:3: ( (otherlv_1= RULE_ID ) )
            // InternalWodel.g:1020:4: (otherlv_1= RULE_ID )
            {
            // InternalWodel.g:1020:4: (otherlv_1= RULE_ID )
            // InternalWodel.g:1021:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getTypeEClassCrossReference_1_0());
            				

            }


            }

            // InternalWodel.g:1032:3: ( (lv_id_2_0= ruleEString ) )
            // InternalWodel.g:1033:4: (lv_id_2_0= ruleEString )
            {
            // InternalWodel.g:1033:4: (lv_id_2_0= ruleEString )
            // InternalWodel.g:1034:5: lv_id_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getIdEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_35);
            lv_id_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"id",
            						lv_id_2_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:1051:3: ( (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ ) | (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            else if ( (LA21_0==35) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalWodel.g:1052:4: (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ )
                    {
                    // InternalWodel.g:1052:4: (otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+ )
                    // InternalWodel.g:1053:5: otherlv_3= ':' ( (lv_expressions_4_0= ruleInvariantCS ) )+
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_36); 

                    					newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getColonKeyword_3_0_0());
                    				
                    // InternalWodel.g:1057:5: ( (lv_expressions_4_0= ruleInvariantCS ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||LA19_0==47||(LA19_0>=50 && LA19_0<=51)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalWodel.g:1058:6: (lv_expressions_4_0= ruleInvariantCS )
                    	    {
                    	    // InternalWodel.g:1058:6: (lv_expressions_4_0= ruleInvariantCS )
                    	    // InternalWodel.g:1059:7: lv_expressions_4_0= ruleInvariantCS
                    	    {

                    	    							newCompositeNode(grammarAccess.getConstraintAccess().getExpressionsInvariantCSParserRuleCall_3_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_37);
                    	    lv_expressions_4_0=ruleInvariantCS();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConstraintRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"expressions",
                    	    								lv_expressions_4_0,
                    	    								"wodel.dsls.Wodel.InvariantCS");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:1078:4: (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ )
                    {
                    // InternalWodel.g:1078:4: (otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+ )
                    // InternalWodel.g:1079:5: otherlv_5= '::' ( (lv_rules_6_0= ruleEString ) )+
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_16); 

                    					newLeafNode(otherlv_5, grammarAccess.getConstraintAccess().getColonColonKeyword_3_1_0());
                    				
                    // InternalWodel.g:1083:5: ( (lv_rules_6_0= ruleEString ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||LA20_0==RULE_STRING) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalWodel.g:1084:6: (lv_rules_6_0= ruleEString )
                    	    {
                    	    // InternalWodel.g:1084:6: (lv_rules_6_0= ruleEString )
                    	    // InternalWodel.g:1085:7: lv_rules_6_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getConstraintAccess().getRulesEStringParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_38);
                    	    lv_rules_6_0=ruleEString();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConstraintRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"rules",
                    	    								lv_rules_6_0,
                    	    								"wodel.dsls.Wodel.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


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
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleInvariantCS"
    // InternalWodel.g:1108:1: entryRuleInvariantCS returns [EObject current=null] : iv_ruleInvariantCS= ruleInvariantCS EOF ;
    public final EObject entryRuleInvariantCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariantCS = null;


        try {
            // InternalWodel.g:1108:52: (iv_ruleInvariantCS= ruleInvariantCS EOF )
            // InternalWodel.g:1109:2: iv_ruleInvariantCS= ruleInvariantCS EOF
            {
             newCompositeNode(grammarAccess.getInvariantCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvariantCS=ruleInvariantCS();

            state._fsp--;

             current =iv_ruleInvariantCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleInvariantCS"


    // $ANTLR start "ruleInvariantCS"
    // InternalWodel.g:1115:1: ruleInvariantCS returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExpCS ) ) otherlv_1= ';' ) ;
    public final EObject ruleInvariantCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1121:2: ( ( ( (lv_exp_0_0= ruleExpCS ) ) otherlv_1= ';' ) )
            // InternalWodel.g:1122:2: ( ( (lv_exp_0_0= ruleExpCS ) ) otherlv_1= ';' )
            {
            // InternalWodel.g:1122:2: ( ( (lv_exp_0_0= ruleExpCS ) ) otherlv_1= ';' )
            // InternalWodel.g:1123:3: ( (lv_exp_0_0= ruleExpCS ) ) otherlv_1= ';'
            {
            // InternalWodel.g:1123:3: ( (lv_exp_0_0= ruleExpCS ) )
            // InternalWodel.g:1124:4: (lv_exp_0_0= ruleExpCS )
            {
            // InternalWodel.g:1124:4: (lv_exp_0_0= ruleExpCS )
            // InternalWodel.g:1125:5: lv_exp_0_0= ruleExpCS
            {

            					newCompositeNode(grammarAccess.getInvariantCSAccess().getExpExpCSParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_exp_0_0=ruleExpCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvariantCSRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"wodel.dsls.Wodel.ExpCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInvariantCSAccess().getSemicolonKeyword_1());
            		

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
    // $ANTLR end "ruleInvariantCS"


    // $ANTLR start "entryRuleExpCS"
    // InternalWodel.g:1150:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalWodel.g:1150:46: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalWodel.g:1151:2: iv_ruleExpCS= ruleExpCS EOF
            {
             newCompositeNode(grammarAccess.getExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;

             current =iv_ruleExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpCS"


    // $ANTLR start "ruleExpCS"
    // InternalWodel.g:1157:1: ruleExpCS returns [EObject current=null] : this_LogicExpCS_0= ruleLogicExpCS ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LogicExpCS_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1163:2: (this_LogicExpCS_0= ruleLogicExpCS )
            // InternalWodel.g:1164:2: this_LogicExpCS_0= ruleLogicExpCS
            {

            		newCompositeNode(grammarAccess.getExpCSAccess().getLogicExpCSParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_LogicExpCS_0=ruleLogicExpCS();

            state._fsp--;


            		current = this_LogicExpCS_0;
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
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRuleLogicExpCS"
    // InternalWodel.g:1175:1: entryRuleLogicExpCS returns [EObject current=null] : iv_ruleLogicExpCS= ruleLogicExpCS EOF ;
    public final EObject entryRuleLogicExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicExpCS = null;


        try {
            // InternalWodel.g:1175:51: (iv_ruleLogicExpCS= ruleLogicExpCS EOF )
            // InternalWodel.g:1176:2: iv_ruleLogicExpCS= ruleLogicExpCS EOF
            {
             newCompositeNode(grammarAccess.getLogicExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicExpCS=ruleLogicExpCS();

            state._fsp--;

             current =iv_ruleLogicExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLogicExpCS"


    // $ANTLR start "ruleLogicExpCS"
    // InternalWodel.g:1182:1: ruleLogicExpCS returns [EObject current=null] : (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) ;
    public final EObject ruleLogicExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_CallExpCS_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1188:2: ( (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) )
            // InternalWodel.g:1189:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            {
            // InternalWodel.g:1189:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            // InternalWodel.g:1190:3: this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            {

            			newCompositeNode(grammarAccess.getLogicExpCSAccess().getCallExpCSParserRuleCall_0());
            		
            pushFollow(FOLLOW_40);
            this_CallExpCS_0=ruleCallExpCS();

            state._fsp--;


            			current = this_CallExpCS_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalWodel.g:1198:3: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==28||LA23_0==37) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalWodel.g:1199:4: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) )
            	    {
            	    // InternalWodel.g:1199:4: ()
            	    // InternalWodel.g:1200:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getLogicExpCSAccess().getLogicExpCSLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalWodel.g:1206:4: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
            	    // InternalWodel.g:1207:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    {
            	    // InternalWodel.g:1207:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    // InternalWodel.g:1208:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    {
            	    // InternalWodel.g:1208:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==28) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==37) ) {
            	        alt22=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalWodel.g:1209:7: lv_op_2_1= '='
            	            {
            	            lv_op_2_1=(Token)match(input,28,FOLLOW_36); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLogicExpCSRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:1220:7: lv_op_2_2= '<>'
            	            {
            	            lv_op_2_2=(Token)match(input,37,FOLLOW_36); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getLogicExpCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLogicExpCSRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:1233:4: ( (lv_right_3_0= ruleCallExpCS ) )
            	    // InternalWodel.g:1234:5: (lv_right_3_0= ruleCallExpCS )
            	    {
            	    // InternalWodel.g:1234:5: (lv_right_3_0= ruleCallExpCS )
            	    // InternalWodel.g:1235:6: lv_right_3_0= ruleCallExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getLogicExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleCallExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLogicExpCSRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"wodel.dsls.Wodel.CallExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleLogicExpCS"


    // $ANTLR start "entryRuleCallExpCS"
    // InternalWodel.g:1257:1: entryRuleCallExpCS returns [EObject current=null] : iv_ruleCallExpCS= ruleCallExpCS EOF ;
    public final EObject entryRuleCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpCS = null;


        try {
            // InternalWodel.g:1257:50: (iv_ruleCallExpCS= ruleCallExpCS EOF )
            // InternalWodel.g:1258:2: iv_ruleCallExpCS= ruleCallExpCS EOF
            {
             newCompositeNode(grammarAccess.getCallExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCallExpCS=ruleCallExpCS();

            state._fsp--;

             current =iv_ruleCallExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCallExpCS"


    // $ANTLR start "ruleCallExpCS"
    // InternalWodel.g:1264:1: ruleCallExpCS returns [EObject current=null] : (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) ;
    public final EObject ruleCallExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrimaryExpCS_0 = null;

        EObject lv_navExp_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1270:2: ( (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) )
            // InternalWodel.g:1271:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            {
            // InternalWodel.g:1271:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            // InternalWodel.g:1272:3: this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            {

            			newCompositeNode(grammarAccess.getCallExpCSAccess().getPrimaryExpCSParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_PrimaryExpCS_0=rulePrimaryExpCS();

            state._fsp--;


            			current = this_PrimaryExpCS_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalWodel.g:1280:3: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38) ) {
                    alt25=1;
                }
                else if ( (LA25_0==39) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalWodel.g:1281:4: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    {
            	    // InternalWodel.g:1281:4: ()
            	    // InternalWodel.g:1282:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalWodel.g:1288:4: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
            	    // InternalWodel.g:1289:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
            	    {
            	    // InternalWodel.g:1289:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
            	    // InternalWodel.g:1290:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
            	    {
            	    // InternalWodel.g:1290:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==38) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==39) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalWodel.g:1291:7: lv_op_2_1= '.'
            	            {
            	            lv_op_2_1=(Token)match(input,38,FOLLOW_42); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getCallExpCSRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:1302:7: lv_op_2_2= '->'
            	            {
            	            lv_op_2_2=(Token)match(input,39,FOLLOW_42); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getCallExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getCallExpCSRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:1315:4: ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    // InternalWodel.g:1316:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    {
            	    // InternalWodel.g:1316:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    // InternalWodel.g:1317:6: lv_navExp_3_0= ruleNavigationExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_navExp_3_0=ruleNavigationExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCallExpCSRule());
            	    						}
            	    						set(
            	    							current,
            	    							"navExp",
            	    							lv_navExp_3_0,
            	    							"wodel.dsls.Wodel.NavigationExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // $ANTLR end "ruleCallExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalWodel.g:1339:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalWodel.g:1339:53: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalWodel.g:1340:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;

             current =iv_rulePrimaryExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExpCS"


    // $ANTLR start "rulePrimaryExpCS"
    // InternalWodel.g:1346:1: rulePrimaryExpCS returns [EObject current=null] : (this_NameExpCS_0= ruleNameExpCS | this_LiteralExpCS_1= ruleLiteralExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NameExpCS_0 = null;

        EObject this_LiteralExpCS_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:1352:2: ( (this_NameExpCS_0= ruleNameExpCS | this_LiteralExpCS_1= ruleLiteralExpCS ) )
            // InternalWodel.g:1353:2: (this_NameExpCS_0= ruleNameExpCS | this_LiteralExpCS_1= ruleLiteralExpCS )
            {
            // InternalWodel.g:1353:2: (this_NameExpCS_0= ruleNameExpCS | this_LiteralExpCS_1= ruleLiteralExpCS )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||LA26_0==47) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=RULE_INT && LA26_0<=RULE_STRING)||(LA26_0>=50 && LA26_0<=51)) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalWodel.g:1354:3: this_NameExpCS_0= ruleNameExpCS
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NameExpCS_0=ruleNameExpCS();

                    state._fsp--;


                    			current = this_NameExpCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:1363:3: this_LiteralExpCS_1= ruleLiteralExpCS
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralExpCS_1=ruleLiteralExpCS();

                    state._fsp--;


                    			current = this_LiteralExpCS_1;
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
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleNavigationExpCS"
    // InternalWodel.g:1375:1: entryRuleNavigationExpCS returns [EObject current=null] : iv_ruleNavigationExpCS= ruleNavigationExpCS EOF ;
    public final EObject entryRuleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationExpCS = null;


        try {
            // InternalWodel.g:1375:56: (iv_ruleNavigationExpCS= ruleNavigationExpCS EOF )
            // InternalWodel.g:1376:2: iv_ruleNavigationExpCS= ruleNavigationExpCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationExpCS=ruleNavigationExpCS();

            state._fsp--;

             current =iv_ruleNavigationExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationExpCS"


    // $ANTLR start "ruleNavigationExpCS"
    // InternalWodel.g:1382:1: ruleNavigationExpCS returns [EObject current=null] : (this_LoopExpCS_0= ruleLoopExpCS | this_NavigationNameExpCS_1= ruleNavigationNameExpCS ) ;
    public final EObject ruleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LoopExpCS_0 = null;

        EObject this_NavigationNameExpCS_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:1388:2: ( (this_LoopExpCS_0= ruleLoopExpCS | this_NavigationNameExpCS_1= ruleNavigationNameExpCS ) )
            // InternalWodel.g:1389:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NavigationNameExpCS_1= ruleNavigationNameExpCS )
            {
            // InternalWodel.g:1389:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NavigationNameExpCS_1= ruleNavigationNameExpCS )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40||LA27_0==46||(LA27_0>=48 && LA27_0<=49)) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID||LA27_0==47) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalWodel.g:1390:3: this_LoopExpCS_0= ruleLoopExpCS
                    {

                    			newCompositeNode(grammarAccess.getNavigationExpCSAccess().getLoopExpCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LoopExpCS_0=ruleLoopExpCS();

                    state._fsp--;


                    			current = this_LoopExpCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:1399:3: this_NavigationNameExpCS_1= ruleNavigationNameExpCS
                    {

                    			newCompositeNode(grammarAccess.getNavigationExpCSAccess().getNavigationNameExpCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NavigationNameExpCS_1=ruleNavigationNameExpCS();

                    state._fsp--;


                    			current = this_NavigationNameExpCS_1;
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
    // $ANTLR end "ruleNavigationExpCS"


    // $ANTLR start "entryRuleLoopExpCS"
    // InternalWodel.g:1411:1: entryRuleLoopExpCS returns [EObject current=null] : iv_ruleLoopExpCS= ruleLoopExpCS EOF ;
    public final EObject entryRuleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopExpCS = null;


        try {
            // InternalWodel.g:1411:50: (iv_ruleLoopExpCS= ruleLoopExpCS EOF )
            // InternalWodel.g:1412:2: iv_ruleLoopExpCS= ruleLoopExpCS EOF
            {
             newCompositeNode(grammarAccess.getLoopExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoopExpCS=ruleLoopExpCS();

            state._fsp--;

             current =iv_ruleLoopExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLoopExpCS"


    // $ANTLR start "ruleLoopExpCS"
    // InternalWodel.g:1418:1: ruleLoopExpCS returns [EObject current=null] : (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS | this_ExistsExpCS_2= ruleExistsExpCS | this_ForAllExpCS_3= ruleForAllExpCS ) ;
    public final EObject ruleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectExpCS_0 = null;

        EObject this_IterateExpCS_1 = null;

        EObject this_ExistsExpCS_2 = null;

        EObject this_ForAllExpCS_3 = null;



        	enterRule();

        try {
            // InternalWodel.g:1424:2: ( (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS | this_ExistsExpCS_2= ruleExistsExpCS | this_ForAllExpCS_3= ruleForAllExpCS ) )
            // InternalWodel.g:1425:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS | this_ExistsExpCS_2= ruleExistsExpCS | this_ForAllExpCS_3= ruleForAllExpCS )
            {
            // InternalWodel.g:1425:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS | this_ExistsExpCS_2= ruleExistsExpCS | this_ForAllExpCS_3= ruleForAllExpCS )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt28=1;
                }
                break;
            case 46:
                {
                alt28=2;
                }
                break;
            case 48:
                {
                alt28=3;
                }
                break;
            case 49:
                {
                alt28=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalWodel.g:1426:3: this_CollectExpCS_0= ruleCollectExpCS
                    {

                    			newCompositeNode(grammarAccess.getLoopExpCSAccess().getCollectExpCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectExpCS_0=ruleCollectExpCS();

                    state._fsp--;


                    			current = this_CollectExpCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:1435:3: this_IterateExpCS_1= ruleIterateExpCS
                    {

                    			newCompositeNode(grammarAccess.getLoopExpCSAccess().getIterateExpCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IterateExpCS_1=ruleIterateExpCS();

                    state._fsp--;


                    			current = this_IterateExpCS_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:1444:3: this_ExistsExpCS_2= ruleExistsExpCS
                    {

                    			newCompositeNode(grammarAccess.getLoopExpCSAccess().getExistsExpCSParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExistsExpCS_2=ruleExistsExpCS();

                    state._fsp--;


                    			current = this_ExistsExpCS_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:1453:3: this_ForAllExpCS_3= ruleForAllExpCS
                    {

                    			newCompositeNode(grammarAccess.getLoopExpCSAccess().getForAllExpCSParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForAllExpCS_3=ruleForAllExpCS();

                    state._fsp--;


                    			current = this_ForAllExpCS_3;
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
    // $ANTLR end "ruleLoopExpCS"


    // $ANTLR start "entryRuleCollectExpCS"
    // InternalWodel.g:1465:1: entryRuleCollectExpCS returns [EObject current=null] : iv_ruleCollectExpCS= ruleCollectExpCS EOF ;
    public final EObject entryRuleCollectExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectExpCS = null;


        try {
            // InternalWodel.g:1465:53: (iv_ruleCollectExpCS= ruleCollectExpCS EOF )
            // InternalWodel.g:1466:2: iv_ruleCollectExpCS= ruleCollectExpCS EOF
            {
             newCompositeNode(grammarAccess.getCollectExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectExpCS=ruleCollectExpCS();

            state._fsp--;

             current =iv_ruleCollectExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCollectExpCS"


    // $ANTLR start "ruleCollectExpCS"
    // InternalWodel.g:1472:1: ruleCollectExpCS returns [EObject current=null] : (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )* otherlv_7= ')' ) ;
    public final EObject ruleCollectExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_logicOp_5_1=null;
        Token lv_logicOp_5_2=null;
        Token otherlv_7=null;
        EObject lv_itVar_2_0 = null;

        EObject lv_exp_4_0 = null;

        EObject lv_exp_6_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1478:2: ( (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )* otherlv_7= ')' ) )
            // InternalWodel.g:1479:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )* otherlv_7= ')' )
            {
            // InternalWodel.g:1479:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )* otherlv_7= ')' )
            // InternalWodel.g:1480:3: otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )* otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getCollectExpCSAccess().getCollectKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:1488:3: ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==34||LA29_1==42) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalWodel.g:1489:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|'
                    {
                    // InternalWodel.g:1489:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
                    // InternalWodel.g:1490:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    {
                    // InternalWodel.g:1490:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    // InternalWodel.g:1491:6: lv_itVar_2_0= ruleIteratorVarCS
                    {

                    						newCompositeNode(grammarAccess.getCollectExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_itVar_2_0=ruleIteratorVarCS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCollectExpCSRule());
                    						}
                    						set(
                    							current,
                    							"itVar",
                    							lv_itVar_2_0,
                    							"wodel.dsls.Wodel.IteratorVarCS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,42,FOLLOW_36); 

                    				newLeafNode(otherlv_3, grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:1513:3: ( (lv_exp_4_0= ruleExpCS ) )
            // InternalWodel.g:1514:4: (lv_exp_4_0= ruleExpCS )
            {
            // InternalWodel.g:1514:4: (lv_exp_4_0= ruleExpCS )
            // InternalWodel.g:1515:5: lv_exp_4_0= ruleExpCS
            {

            					newCompositeNode(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_45);
            lv_exp_4_0=ruleExpCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectExpCSRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_4_0,
            						"wodel.dsls.Wodel.ExpCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:1532:3: ( ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=43 && LA31_0<=44)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalWodel.g:1533:4: ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) ) ( (lv_exp_6_0= ruleExpCS ) )
            	    {
            	    // InternalWodel.g:1533:4: ( ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) ) )
            	    // InternalWodel.g:1534:5: ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) )
            	    {
            	    // InternalWodel.g:1534:5: ( (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' ) )
            	    // InternalWodel.g:1535:6: (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' )
            	    {
            	    // InternalWodel.g:1535:6: (lv_logicOp_5_1= 'or' | lv_logicOp_5_2= 'and' )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==43) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==44) ) {
            	        alt30=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalWodel.g:1536:7: lv_logicOp_5_1= 'or'
            	            {
            	            lv_logicOp_5_1=(Token)match(input,43,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_5_1, grammarAccess.getCollectExpCSAccess().getLogicOpOrKeyword_4_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getCollectExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_5_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:1547:7: lv_logicOp_5_2= 'and'
            	            {
            	            lv_logicOp_5_2=(Token)match(input,44,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_5_2, grammarAccess.getCollectExpCSAccess().getLogicOpAndKeyword_4_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getCollectExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_5_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:1560:4: ( (lv_exp_6_0= ruleExpCS ) )
            	    // InternalWodel.g:1561:5: (lv_exp_6_0= ruleExpCS )
            	    {
            	    // InternalWodel.g:1561:5: (lv_exp_6_0= ruleExpCS )
            	    // InternalWodel.g:1562:6: lv_exp_6_0= ruleExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_exp_6_0=ruleExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCollectExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_6_0,
            	    							"wodel.dsls.Wodel.ExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getCollectExpCSAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleCollectExpCS"


    // $ANTLR start "entryRuleIteratorVarCS"
    // InternalWodel.g:1588:1: entryRuleIteratorVarCS returns [EObject current=null] : iv_ruleIteratorVarCS= ruleIteratorVarCS EOF ;
    public final EObject entryRuleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorVarCS = null;


        try {
            // InternalWodel.g:1588:54: (iv_ruleIteratorVarCS= ruleIteratorVarCS EOF )
            // InternalWodel.g:1589:2: iv_ruleIteratorVarCS= ruleIteratorVarCS EOF
            {
             newCompositeNode(grammarAccess.getIteratorVarCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIteratorVarCS=ruleIteratorVarCS();

            state._fsp--;

             current =iv_ruleIteratorVarCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIteratorVarCS"


    // $ANTLR start "ruleIteratorVarCS"
    // InternalWodel.g:1595:1: ruleIteratorVarCS returns [EObject current=null] : ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) ;
    public final EObject ruleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_itName_0_0=null;
        Token otherlv_1=null;
        EObject lv_itType_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1601:2: ( ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) )
            // InternalWodel.g:1602:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            {
            // InternalWodel.g:1602:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            // InternalWodel.g:1603:3: ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            {
            // InternalWodel.g:1603:3: ( (lv_itName_0_0= RULE_ID ) )
            // InternalWodel.g:1604:4: (lv_itName_0_0= RULE_ID )
            {
            // InternalWodel.g:1604:4: (lv_itName_0_0= RULE_ID )
            // InternalWodel.g:1605:5: lv_itName_0_0= RULE_ID
            {
            lv_itName_0_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(lv_itName_0_0, grammarAccess.getIteratorVarCSAccess().getItNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIteratorVarCSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"itName",
            						lv_itName_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWodel.g:1621:3: (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==34) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalWodel.g:1622:4: otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_47); 

                    				newLeafNode(otherlv_1, grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0());
                    			
                    // InternalWodel.g:1626:4: ( (lv_itType_2_0= rulePathNameCS ) )
                    // InternalWodel.g:1627:5: (lv_itType_2_0= rulePathNameCS )
                    {
                    // InternalWodel.g:1627:5: (lv_itType_2_0= rulePathNameCS )
                    // InternalWodel.g:1628:6: lv_itType_2_0= rulePathNameCS
                    {

                    						newCompositeNode(grammarAccess.getIteratorVarCSAccess().getItTypePathNameCSParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_itType_2_0=rulePathNameCS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIteratorVarCSRule());
                    						}
                    						set(
                    							current,
                    							"itType",
                    							lv_itType_2_0,
                    							"wodel.dsls.Wodel.PathNameCS");
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
    // $ANTLR end "ruleIteratorVarCS"


    // $ANTLR start "entryRuleIterateExpCS"
    // InternalWodel.g:1650:1: entryRuleIterateExpCS returns [EObject current=null] : iv_ruleIterateExpCS= ruleIterateExpCS EOF ;
    public final EObject entryRuleIterateExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterateExpCS = null;


        try {
            // InternalWodel.g:1650:53: (iv_ruleIterateExpCS= ruleIterateExpCS EOF )
            // InternalWodel.g:1651:2: iv_ruleIterateExpCS= ruleIterateExpCS EOF
            {
             newCompositeNode(grammarAccess.getIterateExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIterateExpCS=ruleIterateExpCS();

            state._fsp--;

             current =iv_ruleIterateExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIterateExpCS"


    // $ANTLR start "ruleIterateExpCS"
    // InternalWodel.g:1657:1: ruleIterateExpCS returns [EObject current=null] : (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) ;
    public final EObject ruleIterateExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_logicOp_7_1=null;
        Token lv_logicOp_7_2=null;
        Token otherlv_9=null;
        EObject lv_itVar_2_0 = null;

        EObject lv_accVar_4_0 = null;

        EObject lv_exp_6_0 = null;

        EObject lv_exp_8_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1663:2: ( (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) )
            // InternalWodel.g:1664:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            {
            // InternalWodel.g:1664:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            // InternalWodel.g:1665:3: otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getIterateExpCSAccess().getIterateKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:1673:3: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
            // InternalWodel.g:1674:4: (lv_itVar_2_0= ruleIteratorVarCS )
            {
            // InternalWodel.g:1674:4: (lv_itVar_2_0= ruleIteratorVarCS )
            // InternalWodel.g:1675:5: lv_itVar_2_0= ruleIteratorVarCS
            {

            					newCompositeNode(grammarAccess.getIterateExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_39);
            lv_itVar_2_0=ruleIteratorVarCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
            					}
            					set(
            						current,
            						"itVar",
            						lv_itVar_2_0,
            						"wodel.dsls.Wodel.IteratorVarCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_48); 

            			newLeafNode(otherlv_3, grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3());
            		
            // InternalWodel.g:1696:3: ( (lv_accVar_4_0= ruleAccVarCS ) )
            // InternalWodel.g:1697:4: (lv_accVar_4_0= ruleAccVarCS )
            {
            // InternalWodel.g:1697:4: (lv_accVar_4_0= ruleAccVarCS )
            // InternalWodel.g:1698:5: lv_accVar_4_0= ruleAccVarCS
            {

            					newCompositeNode(grammarAccess.getIterateExpCSAccess().getAccVarAccVarCSParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_44);
            lv_accVar_4_0=ruleAccVarCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
            					}
            					set(
            						current,
            						"accVar",
            						lv_accVar_4_0,
            						"wodel.dsls.Wodel.AccVarCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5());
            		
            // InternalWodel.g:1719:3: ( (lv_exp_6_0= ruleExpCS ) )
            // InternalWodel.g:1720:4: (lv_exp_6_0= ruleExpCS )
            {
            // InternalWodel.g:1720:4: (lv_exp_6_0= ruleExpCS )
            // InternalWodel.g:1721:5: lv_exp_6_0= ruleExpCS
            {

            					newCompositeNode(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_45);
            lv_exp_6_0=ruleExpCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_6_0,
            						"wodel.dsls.Wodel.ExpCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:1738:3: ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=43 && LA34_0<=44)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalWodel.g:1739:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) )
            	    {
            	    // InternalWodel.g:1739:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) )
            	    // InternalWodel.g:1740:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    {
            	    // InternalWodel.g:1740:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    // InternalWodel.g:1741:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    {
            	    // InternalWodel.g:1741:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==43) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==44) ) {
            	        alt33=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // InternalWodel.g:1742:7: lv_logicOp_7_1= 'or'
            	            {
            	            lv_logicOp_7_1=(Token)match(input,43,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_1, grammarAccess.getIterateExpCSAccess().getLogicOpOrKeyword_7_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getIterateExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:1753:7: lv_logicOp_7_2= 'and'
            	            {
            	            lv_logicOp_7_2=(Token)match(input,44,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_2, grammarAccess.getIterateExpCSAccess().getLogicOpAndKeyword_7_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getIterateExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:1766:4: ( (lv_exp_8_0= ruleExpCS ) )
            	    // InternalWodel.g:1767:5: (lv_exp_8_0= ruleExpCS )
            	    {
            	    // InternalWodel.g:1767:5: (lv_exp_8_0= ruleExpCS )
            	    // InternalWodel.g:1768:6: lv_exp_8_0= ruleExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_exp_8_0=ruleExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_8_0,
            	    							"wodel.dsls.Wodel.ExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_9=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getIterateExpCSAccess().getRightParenthesisKeyword_8());
            		

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
    // $ANTLR end "ruleIterateExpCS"


    // $ANTLR start "entryRuleAccVarCS"
    // InternalWodel.g:1794:1: entryRuleAccVarCS returns [EObject current=null] : iv_ruleAccVarCS= ruleAccVarCS EOF ;
    public final EObject entryRuleAccVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccVarCS = null;


        try {
            // InternalWodel.g:1794:49: (iv_ruleAccVarCS= ruleAccVarCS EOF )
            // InternalWodel.g:1795:2: iv_ruleAccVarCS= ruleAccVarCS EOF
            {
             newCompositeNode(grammarAccess.getAccVarCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAccVarCS=ruleAccVarCS();

            state._fsp--;

             current =iv_ruleAccVarCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAccVarCS"


    // $ANTLR start "ruleAccVarCS"
    // InternalWodel.g:1801:1: ruleAccVarCS returns [EObject current=null] : (otherlv_0= '$' ( (lv_accVarName_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )? (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleAccVarCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_accVarName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_accType_3_0 = null;

        EObject lv_accInitExp_5_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1807:2: ( (otherlv_0= '$' ( (lv_accVarName_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )? (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )? ) )
            // InternalWodel.g:1808:2: (otherlv_0= '$' ( (lv_accVarName_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )? (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )? )
            {
            // InternalWodel.g:1808:2: (otherlv_0= '$' ( (lv_accVarName_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )? (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )? )
            // InternalWodel.g:1809:3: otherlv_0= '$' ( (lv_accVarName_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )? (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )?
            {
            otherlv_0=(Token)match(input,47,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getAccVarCSAccess().getDollarSignKeyword_0());
            		
            // InternalWodel.g:1813:3: ( (lv_accVarName_1_0= RULE_ID ) )
            // InternalWodel.g:1814:4: (lv_accVarName_1_0= RULE_ID )
            {
            // InternalWodel.g:1814:4: (lv_accVarName_1_0= RULE_ID )
            // InternalWodel.g:1815:5: lv_accVarName_1_0= RULE_ID
            {
            lv_accVarName_1_0=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(lv_accVarName_1_0, grammarAccess.getAccVarCSAccess().getAccVarNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAccVarCSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"accVarName",
            						lv_accVarName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWodel.g:1831:3: (otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==34) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalWodel.g:1832:4: otherlv_2= ':' ( (lv_accType_3_0= rulePathNameCS ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getAccVarCSAccess().getColonKeyword_2_0());
                    			
                    // InternalWodel.g:1836:4: ( (lv_accType_3_0= rulePathNameCS ) )
                    // InternalWodel.g:1837:5: (lv_accType_3_0= rulePathNameCS )
                    {
                    // InternalWodel.g:1837:5: (lv_accType_3_0= rulePathNameCS )
                    // InternalWodel.g:1838:6: lv_accType_3_0= rulePathNameCS
                    {

                    						newCompositeNode(grammarAccess.getAccVarCSAccess().getAccTypePathNameCSParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_accType_3_0=rulePathNameCS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAccVarCSRule());
                    						}
                    						set(
                    							current,
                    							"accType",
                    							lv_accType_3_0,
                    							"wodel.dsls.Wodel.PathNameCS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:1856:3: (otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalWodel.g:1857:4: otherlv_4= '=' ( (lv_accInitExp_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_36); 

                    				newLeafNode(otherlv_4, grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_3_0());
                    			
                    // InternalWodel.g:1861:4: ( (lv_accInitExp_5_0= ruleExpCS ) )
                    // InternalWodel.g:1862:5: (lv_accInitExp_5_0= ruleExpCS )
                    {
                    // InternalWodel.g:1862:5: (lv_accInitExp_5_0= ruleExpCS )
                    // InternalWodel.g:1863:6: lv_accInitExp_5_0= ruleExpCS
                    {

                    						newCompositeNode(grammarAccess.getAccVarCSAccess().getAccInitExpExpCSParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_accInitExp_5_0=ruleExpCS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAccVarCSRule());
                    						}
                    						set(
                    							current,
                    							"accInitExp",
                    							lv_accInitExp_5_0,
                    							"wodel.dsls.Wodel.ExpCS");
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
    // $ANTLR end "ruleAccVarCS"


    // $ANTLR start "entryRuleExistsExpCS"
    // InternalWodel.g:1885:1: entryRuleExistsExpCS returns [EObject current=null] : iv_ruleExistsExpCS= ruleExistsExpCS EOF ;
    public final EObject entryRuleExistsExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExistsExpCS = null;


        try {
            // InternalWodel.g:1885:52: (iv_ruleExistsExpCS= ruleExistsExpCS EOF )
            // InternalWodel.g:1886:2: iv_ruleExistsExpCS= ruleExistsExpCS EOF
            {
             newCompositeNode(grammarAccess.getExistsExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExistsExpCS=ruleExistsExpCS();

            state._fsp--;

             current =iv_ruleExistsExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExistsExpCS"


    // $ANTLR start "ruleExistsExpCS"
    // InternalWodel.g:1892:1: ruleExistsExpCS returns [EObject current=null] : (otherlv_0= 'exists' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) ;
    public final EObject ruleExistsExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_logicOp_7_1=null;
        Token lv_logicOp_7_2=null;
        Token otherlv_9=null;
        EObject lv_accVars_2_0 = null;

        EObject lv_accVars_4_0 = null;

        EObject lv_exp_6_0 = null;

        EObject lv_exp_8_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:1898:2: ( (otherlv_0= 'exists' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) )
            // InternalWodel.g:1899:2: (otherlv_0= 'exists' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            {
            // InternalWodel.g:1899:2: (otherlv_0= 'exists' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            // InternalWodel.g:1900:3: otherlv_0= 'exists' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getExistsExpCSAccess().getExistsKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsExpCSAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:1908:3: ( (lv_accVars_2_0= ruleAccVarCS ) )
            // InternalWodel.g:1909:4: (lv_accVars_2_0= ruleAccVarCS )
            {
            // InternalWodel.g:1909:4: (lv_accVars_2_0= ruleAccVarCS )
            // InternalWodel.g:1910:5: lv_accVars_2_0= ruleAccVarCS
            {

            					newCompositeNode(grammarAccess.getExistsExpCSAccess().getAccVarsAccVarCSParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_51);
            lv_accVars_2_0=ruleAccVarCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsExpCSRule());
            					}
            					add(
            						current,
            						"accVars",
            						lv_accVars_2_0,
            						"wodel.dsls.Wodel.AccVarCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:1927:3: (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==26) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalWodel.g:1928:4: otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) )
            	    {
            	    otherlv_3=(Token)match(input,26,FOLLOW_48); 

            	    				newLeafNode(otherlv_3, grammarAccess.getExistsExpCSAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalWodel.g:1932:4: ( (lv_accVars_4_0= ruleAccVarCS ) )
            	    // InternalWodel.g:1933:5: (lv_accVars_4_0= ruleAccVarCS )
            	    {
            	    // InternalWodel.g:1933:5: (lv_accVars_4_0= ruleAccVarCS )
            	    // InternalWodel.g:1934:6: lv_accVars_4_0= ruleAccVarCS
            	    {

            	    						newCompositeNode(grammarAccess.getExistsExpCSAccess().getAccVarsAccVarCSParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_accVars_4_0=ruleAccVarCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExistsExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"accVars",
            	    							lv_accVars_4_0,
            	    							"wodel.dsls.Wodel.AccVarCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getExistsExpCSAccess().getVerticalLineKeyword_4());
            		
            // InternalWodel.g:1956:3: ( (lv_exp_6_0= ruleExpCS ) )
            // InternalWodel.g:1957:4: (lv_exp_6_0= ruleExpCS )
            {
            // InternalWodel.g:1957:4: (lv_exp_6_0= ruleExpCS )
            // InternalWodel.g:1958:5: lv_exp_6_0= ruleExpCS
            {

            					newCompositeNode(grammarAccess.getExistsExpCSAccess().getExpExpCSParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_45);
            lv_exp_6_0=ruleExpCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsExpCSRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_6_0,
            						"wodel.dsls.Wodel.ExpCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:1975:3: ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=43 && LA39_0<=44)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalWodel.g:1976:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) )
            	    {
            	    // InternalWodel.g:1976:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) )
            	    // InternalWodel.g:1977:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    {
            	    // InternalWodel.g:1977:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    // InternalWodel.g:1978:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    {
            	    // InternalWodel.g:1978:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==43) ) {
            	        alt38=1;
            	    }
            	    else if ( (LA38_0==44) ) {
            	        alt38=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // InternalWodel.g:1979:7: lv_logicOp_7_1= 'or'
            	            {
            	            lv_logicOp_7_1=(Token)match(input,43,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_1, grammarAccess.getExistsExpCSAccess().getLogicOpOrKeyword_6_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getExistsExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:1990:7: lv_logicOp_7_2= 'and'
            	            {
            	            lv_logicOp_7_2=(Token)match(input,44,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_2, grammarAccess.getExistsExpCSAccess().getLogicOpAndKeyword_6_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getExistsExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:2003:4: ( (lv_exp_8_0= ruleExpCS ) )
            	    // InternalWodel.g:2004:5: (lv_exp_8_0= ruleExpCS )
            	    {
            	    // InternalWodel.g:2004:5: (lv_exp_8_0= ruleExpCS )
            	    // InternalWodel.g:2005:6: lv_exp_8_0= ruleExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getExistsExpCSAccess().getExpExpCSParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_exp_8_0=ruleExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExistsExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_8_0,
            	    							"wodel.dsls.Wodel.ExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_9=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getExistsExpCSAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleExistsExpCS"


    // $ANTLR start "entryRuleForAllExpCS"
    // InternalWodel.g:2031:1: entryRuleForAllExpCS returns [EObject current=null] : iv_ruleForAllExpCS= ruleForAllExpCS EOF ;
    public final EObject entryRuleForAllExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllExpCS = null;


        try {
            // InternalWodel.g:2031:52: (iv_ruleForAllExpCS= ruleForAllExpCS EOF )
            // InternalWodel.g:2032:2: iv_ruleForAllExpCS= ruleForAllExpCS EOF
            {
             newCompositeNode(grammarAccess.getForAllExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForAllExpCS=ruleForAllExpCS();

            state._fsp--;

             current =iv_ruleForAllExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleForAllExpCS"


    // $ANTLR start "ruleForAllExpCS"
    // InternalWodel.g:2038:1: ruleForAllExpCS returns [EObject current=null] : (otherlv_0= 'forAll' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) ;
    public final EObject ruleForAllExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_logicOp_7_1=null;
        Token lv_logicOp_7_2=null;
        Token otherlv_9=null;
        EObject lv_accVars_2_0 = null;

        EObject lv_accVars_4_0 = null;

        EObject lv_exp_6_0 = null;

        EObject lv_exp_8_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2044:2: ( (otherlv_0= 'forAll' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' ) )
            // InternalWodel.g:2045:2: (otherlv_0= 'forAll' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            {
            // InternalWodel.g:2045:2: (otherlv_0= 'forAll' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')' )
            // InternalWodel.g:2046:3: otherlv_0= 'forAll' otherlv_1= '(' ( (lv_accVars_2_0= ruleAccVarCS ) ) (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )* otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )* otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getForAllExpCSAccess().getForAllKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllExpCSAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:2054:3: ( (lv_accVars_2_0= ruleAccVarCS ) )
            // InternalWodel.g:2055:4: (lv_accVars_2_0= ruleAccVarCS )
            {
            // InternalWodel.g:2055:4: (lv_accVars_2_0= ruleAccVarCS )
            // InternalWodel.g:2056:5: lv_accVars_2_0= ruleAccVarCS
            {

            					newCompositeNode(grammarAccess.getForAllExpCSAccess().getAccVarsAccVarCSParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_51);
            lv_accVars_2_0=ruleAccVarCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllExpCSRule());
            					}
            					add(
            						current,
            						"accVars",
            						lv_accVars_2_0,
            						"wodel.dsls.Wodel.AccVarCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2073:3: (otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==26) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalWodel.g:2074:4: otherlv_3= ',' ( (lv_accVars_4_0= ruleAccVarCS ) )
            	    {
            	    otherlv_3=(Token)match(input,26,FOLLOW_48); 

            	    				newLeafNode(otherlv_3, grammarAccess.getForAllExpCSAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalWodel.g:2078:4: ( (lv_accVars_4_0= ruleAccVarCS ) )
            	    // InternalWodel.g:2079:5: (lv_accVars_4_0= ruleAccVarCS )
            	    {
            	    // InternalWodel.g:2079:5: (lv_accVars_4_0= ruleAccVarCS )
            	    // InternalWodel.g:2080:6: lv_accVars_4_0= ruleAccVarCS
            	    {

            	    						newCompositeNode(grammarAccess.getForAllExpCSAccess().getAccVarsAccVarCSParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_accVars_4_0=ruleAccVarCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getForAllExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"accVars",
            	    							lv_accVars_4_0,
            	    							"wodel.dsls.Wodel.AccVarCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getForAllExpCSAccess().getVerticalLineKeyword_4());
            		
            // InternalWodel.g:2102:3: ( (lv_exp_6_0= ruleExpCS ) )
            // InternalWodel.g:2103:4: (lv_exp_6_0= ruleExpCS )
            {
            // InternalWodel.g:2103:4: (lv_exp_6_0= ruleExpCS )
            // InternalWodel.g:2104:5: lv_exp_6_0= ruleExpCS
            {

            					newCompositeNode(grammarAccess.getForAllExpCSAccess().getExpExpCSParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_45);
            lv_exp_6_0=ruleExpCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllExpCSRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_6_0,
            						"wodel.dsls.Wodel.ExpCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2121:3: ( ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=43 && LA42_0<=44)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalWodel.g:2122:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) ) ( (lv_exp_8_0= ruleExpCS ) )
            	    {
            	    // InternalWodel.g:2122:4: ( ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) ) )
            	    // InternalWodel.g:2123:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    {
            	    // InternalWodel.g:2123:5: ( (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' ) )
            	    // InternalWodel.g:2124:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    {
            	    // InternalWodel.g:2124:6: (lv_logicOp_7_1= 'or' | lv_logicOp_7_2= 'and' )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==43) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==44) ) {
            	        alt41=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // InternalWodel.g:2125:7: lv_logicOp_7_1= 'or'
            	            {
            	            lv_logicOp_7_1=(Token)match(input,43,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_1, grammarAccess.getForAllExpCSAccess().getLogicOpOrKeyword_6_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getForAllExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalWodel.g:2136:7: lv_logicOp_7_2= 'and'
            	            {
            	            lv_logicOp_7_2=(Token)match(input,44,FOLLOW_36); 

            	            							newLeafNode(lv_logicOp_7_2, grammarAccess.getForAllExpCSAccess().getLogicOpAndKeyword_6_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getForAllExpCSRule());
            	            							}
            	            							addWithLastConsumed(current, "logicOp", lv_logicOp_7_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWodel.g:2149:4: ( (lv_exp_8_0= ruleExpCS ) )
            	    // InternalWodel.g:2150:5: (lv_exp_8_0= ruleExpCS )
            	    {
            	    // InternalWodel.g:2150:5: (lv_exp_8_0= ruleExpCS )
            	    // InternalWodel.g:2151:6: lv_exp_8_0= ruleExpCS
            	    {

            	    						newCompositeNode(grammarAccess.getForAllExpCSAccess().getExpExpCSParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_exp_8_0=ruleExpCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getForAllExpCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_8_0,
            	    							"wodel.dsls.Wodel.ExpCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_9=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getForAllExpCSAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleForAllExpCS"


    // $ANTLR start "entryRuleNameExpCS"
    // InternalWodel.g:2177:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalWodel.g:2177:50: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalWodel.g:2178:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
             newCompositeNode(grammarAccess.getNameExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;

             current =iv_ruleNameExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNameExpCS"


    // $ANTLR start "ruleNameExpCS"
    // InternalWodel.g:2184:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expName_0_0 = null;

        EObject lv_roundedBrackets_1_0 = null;

        EObject lv_callExp_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2190:2: ( ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? ) )
            // InternalWodel.g:2191:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? )
            {
            // InternalWodel.g:2191:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? )
            // InternalWodel.g:2192:3: ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )?
            {
            // InternalWodel.g:2192:3: ( (lv_expName_0_0= rulePathNameCS ) )
            // InternalWodel.g:2193:4: (lv_expName_0_0= rulePathNameCS )
            {
            // InternalWodel.g:2193:4: (lv_expName_0_0= rulePathNameCS )
            // InternalWodel.g:2194:5: lv_expName_0_0= rulePathNameCS
            {

            					newCompositeNode(grammarAccess.getNameExpCSAccess().getExpNamePathNameCSParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_52);
            lv_expName_0_0=rulePathNameCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            					}
            					set(
            						current,
            						"expName",
            						lv_expName_0_0,
            						"wodel.dsls.Wodel.PathNameCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2211:3: ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==41) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalWodel.g:2212:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    {
                    // InternalWodel.g:2212:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    // InternalWodel.g:2213:5: lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS
                    {

                    					newCompositeNode(grammarAccess.getNameExpCSAccess().getRoundedBracketsRoundedBracketClauseCSParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_37);
                    lv_roundedBrackets_1_0=ruleRoundedBracketClauseCS();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                    					}
                    					set(
                    						current,
                    						"roundedBrackets",
                    						lv_roundedBrackets_1_0,
                    						"wodel.dsls.Wodel.RoundedBracketClauseCS");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalWodel.g:2230:3: ( (lv_callExp_2_0= ruleCallExpCS ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==47||(LA44_0>=50 && LA44_0<=51)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalWodel.g:2231:4: (lv_callExp_2_0= ruleCallExpCS )
                    {
                    // InternalWodel.g:2231:4: (lv_callExp_2_0= ruleCallExpCS )
                    // InternalWodel.g:2232:5: lv_callExp_2_0= ruleCallExpCS
                    {

                    					newCompositeNode(grammarAccess.getNameExpCSAccess().getCallExpCallExpCSParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_callExp_2_0=ruleCallExpCS();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                    					}
                    					set(
                    						current,
                    						"callExp",
                    						lv_callExp_2_0,
                    						"wodel.dsls.Wodel.CallExpCS");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleNavigationNameExpCS"
    // InternalWodel.g:2253:1: entryRuleNavigationNameExpCS returns [EObject current=null] : iv_ruleNavigationNameExpCS= ruleNavigationNameExpCS EOF ;
    public final EObject entryRuleNavigationNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationNameExpCS = null;


        try {
            // InternalWodel.g:2253:60: (iv_ruleNavigationNameExpCS= ruleNavigationNameExpCS EOF )
            // InternalWodel.g:2254:2: iv_ruleNavigationNameExpCS= ruleNavigationNameExpCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationNameExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationNameExpCS=ruleNavigationNameExpCS();

            state._fsp--;

             current =iv_ruleNavigationNameExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationNameExpCS"


    // $ANTLR start "ruleNavigationNameExpCS"
    // InternalWodel.g:2260:1: ruleNavigationNameExpCS returns [EObject current=null] : ( ( (lv_expName_0_0= ruleNavigationPathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? ) ;
    public final EObject ruleNavigationNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expName_0_0 = null;

        EObject lv_roundedBrackets_1_0 = null;

        EObject lv_callExp_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2266:2: ( ( ( (lv_expName_0_0= ruleNavigationPathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? ) )
            // InternalWodel.g:2267:2: ( ( (lv_expName_0_0= ruleNavigationPathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? )
            {
            // InternalWodel.g:2267:2: ( ( (lv_expName_0_0= ruleNavigationPathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )? )
            // InternalWodel.g:2268:3: ( (lv_expName_0_0= ruleNavigationPathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ( (lv_callExp_2_0= ruleCallExpCS ) )?
            {
            // InternalWodel.g:2268:3: ( (lv_expName_0_0= ruleNavigationPathNameCS ) )
            // InternalWodel.g:2269:4: (lv_expName_0_0= ruleNavigationPathNameCS )
            {
            // InternalWodel.g:2269:4: (lv_expName_0_0= ruleNavigationPathNameCS )
            // InternalWodel.g:2270:5: lv_expName_0_0= ruleNavigationPathNameCS
            {

            					newCompositeNode(grammarAccess.getNavigationNameExpCSAccess().getExpNameNavigationPathNameCSParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_52);
            lv_expName_0_0=ruleNavigationPathNameCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNavigationNameExpCSRule());
            					}
            					set(
            						current,
            						"expName",
            						lv_expName_0_0,
            						"wodel.dsls.Wodel.NavigationPathNameCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2287:3: ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalWodel.g:2288:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    {
                    // InternalWodel.g:2288:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    // InternalWodel.g:2289:5: lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS
                    {

                    					newCompositeNode(grammarAccess.getNavigationNameExpCSAccess().getRoundedBracketsRoundedBracketClauseCSParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_37);
                    lv_roundedBrackets_1_0=ruleRoundedBracketClauseCS();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNavigationNameExpCSRule());
                    					}
                    					set(
                    						current,
                    						"roundedBrackets",
                    						lv_roundedBrackets_1_0,
                    						"wodel.dsls.Wodel.RoundedBracketClauseCS");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalWodel.g:2306:3: ( (lv_callExp_2_0= ruleCallExpCS ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)||LA46_0==47||(LA46_0>=50 && LA46_0<=51)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalWodel.g:2307:4: (lv_callExp_2_0= ruleCallExpCS )
                    {
                    // InternalWodel.g:2307:4: (lv_callExp_2_0= ruleCallExpCS )
                    // InternalWodel.g:2308:5: lv_callExp_2_0= ruleCallExpCS
                    {

                    					newCompositeNode(grammarAccess.getNavigationNameExpCSAccess().getCallExpCallExpCSParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_callExp_2_0=ruleCallExpCS();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNavigationNameExpCSRule());
                    					}
                    					set(
                    						current,
                    						"callExp",
                    						lv_callExp_2_0,
                    						"wodel.dsls.Wodel.CallExpCS");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleNavigationNameExpCS"


    // $ANTLR start "entryRuleRoundedBracketClauseCS"
    // InternalWodel.g:2329:1: entryRuleRoundedBracketClauseCS returns [EObject current=null] : iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF ;
    public final EObject entryRuleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundedBracketClauseCS = null;


        try {
            // InternalWodel.g:2329:63: (iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF )
            // InternalWodel.g:2330:2: iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF
            {
             newCompositeNode(grammarAccess.getRoundedBracketClauseCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoundedBracketClauseCS=ruleRoundedBracketClauseCS();

            state._fsp--;

             current =iv_ruleRoundedBracketClauseCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRoundedBracketClauseCS"


    // $ANTLR start "ruleRoundedBracketClauseCS"
    // InternalWodel.g:2336:1: ruleRoundedBracketClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2342:2: ( ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) )
            // InternalWodel.g:2343:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            {
            // InternalWodel.g:2343:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            // InternalWodel.g:2344:3: () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')'
            {
            // InternalWodel.g:2344:3: ()
            // InternalWodel.g:2345:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:2355:3: ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_STRING)||LA48_0==47||(LA48_0>=50 && LA48_0<=51)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalWodel.g:2356:4: ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    {
                    // InternalWodel.g:2356:4: ( (lv_args_2_0= ruleExpCS ) )
                    // InternalWodel.g:2357:5: (lv_args_2_0= ruleExpCS )
                    {
                    // InternalWodel.g:2357:5: (lv_args_2_0= ruleExpCS )
                    // InternalWodel.g:2358:6: lv_args_2_0= ruleExpCS
                    {

                    						newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_54);
                    lv_args_2_0=ruleExpCS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRoundedBracketClauseCSRule());
                    						}
                    						add(
                    							current,
                    							"args",
                    							lv_args_2_0,
                    							"wodel.dsls.Wodel.ExpCS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWodel.g:2375:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==26) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalWodel.g:2376:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,26,FOLLOW_36); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalWodel.g:2380:5: ( (lv_args_4_0= ruleExpCS ) )
                    	    // InternalWodel.g:2381:6: (lv_args_4_0= ruleExpCS )
                    	    {
                    	    // InternalWodel.g:2381:6: (lv_args_4_0= ruleExpCS )
                    	    // InternalWodel.g:2382:7: lv_args_4_0= ruleExpCS
                    	    {

                    	    							newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_54);
                    	    lv_args_4_0=ruleExpCS();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRoundedBracketClauseCSRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"args",
                    	    								lv_args_4_0,
                    	    								"wodel.dsls.Wodel.ExpCS");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleRoundedBracketClauseCS"


    // $ANTLR start "entryRuleLiteralExpCS"
    // InternalWodel.g:2409:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // InternalWodel.g:2409:53: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // InternalWodel.g:2410:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getLiteralExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpCS=ruleLiteralExpCS();

            state._fsp--;

             current =iv_ruleLiteralExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteralExpCS"


    // $ANTLR start "ruleLiteralExpCS"
    // InternalWodel.g:2416:1: ruleLiteralExpCS returns [EObject current=null] : (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS ) ;
    public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteralExpCS_0 = null;

        EObject this_StringLiteralExpCS_1 = null;

        EObject this_BooleanLiteralExpCS_2 = null;



        	enterRule();

        try {
            // InternalWodel.g:2422:2: ( (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS ) )
            // InternalWodel.g:2423:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS )
            {
            // InternalWodel.g:2423:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt49=1;
                }
                break;
            case RULE_STRING:
                {
                alt49=2;
                }
                break;
            case 50:
            case 51:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalWodel.g:2424:3: this_IntLiteralExpCS_0= ruleIntLiteralExpCS
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getIntLiteralExpCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntLiteralExpCS_0=ruleIntLiteralExpCS();

                    state._fsp--;


                    			current = this_IntLiteralExpCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:2433:3: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteralExpCS_1=ruleStringLiteralExpCS();

                    state._fsp--;


                    			current = this_StringLiteralExpCS_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:2442:3: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS();

                    state._fsp--;


                    			current = this_BooleanLiteralExpCS_2;
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
    // $ANTLR end "ruleLiteralExpCS"


    // $ANTLR start "entryRuleIntLiteralExpCS"
    // InternalWodel.g:2454:1: entryRuleIntLiteralExpCS returns [EObject current=null] : iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF ;
    public final EObject entryRuleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteralExpCS = null;


        try {
            // InternalWodel.g:2454:56: (iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF )
            // InternalWodel.g:2455:2: iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteralExpCS=ruleIntLiteralExpCS();

            state._fsp--;

             current =iv_ruleIntLiteralExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIntLiteralExpCS"


    // $ANTLR start "ruleIntLiteralExpCS"
    // InternalWodel.g:2461:1: ruleIntLiteralExpCS returns [EObject current=null] : ( (lv_intSymbol_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_intSymbol_0_0=null;


        	enterRule();

        try {
            // InternalWodel.g:2467:2: ( ( (lv_intSymbol_0_0= RULE_INT ) ) )
            // InternalWodel.g:2468:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            {
            // InternalWodel.g:2468:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            // InternalWodel.g:2469:3: (lv_intSymbol_0_0= RULE_INT )
            {
            // InternalWodel.g:2469:3: (lv_intSymbol_0_0= RULE_INT )
            // InternalWodel.g:2470:4: lv_intSymbol_0_0= RULE_INT
            {
            lv_intSymbol_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_intSymbol_0_0, grammarAccess.getIntLiteralExpCSAccess().getIntSymbolINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntLiteralExpCSRule());
            				}
            				setWithLastConsumed(
            					current,
            					"intSymbol",
            					lv_intSymbol_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "ruleIntLiteralExpCS"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // InternalWodel.g:2489:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // InternalWodel.g:2489:59: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // InternalWodel.g:2490:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;

             current =iv_ruleStringLiteralExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // InternalWodel.g:2496:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_stringSymbol_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringSymbol_0_0=null;


        	enterRule();

        try {
            // InternalWodel.g:2502:2: ( ( (lv_stringSymbol_0_0= RULE_STRING ) ) )
            // InternalWodel.g:2503:2: ( (lv_stringSymbol_0_0= RULE_STRING ) )
            {
            // InternalWodel.g:2503:2: ( (lv_stringSymbol_0_0= RULE_STRING ) )
            // InternalWodel.g:2504:3: (lv_stringSymbol_0_0= RULE_STRING )
            {
            // InternalWodel.g:2504:3: (lv_stringSymbol_0_0= RULE_STRING )
            // InternalWodel.g:2505:4: lv_stringSymbol_0_0= RULE_STRING
            {
            lv_stringSymbol_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_stringSymbol_0_0, grammarAccess.getStringLiteralExpCSAccess().getStringSymbolSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringLiteralExpCSRule());
            				}
            				setWithLastConsumed(
            					current,
            					"stringSymbol",
            					lv_stringSymbol_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // InternalWodel.g:2524:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalWodel.g:2524:60: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalWodel.g:2525:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;

             current =iv_ruleBooleanLiteralExpCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // InternalWodel.g:2531:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_boolSymbol_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalWodel.g:2537:2: ( ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalWodel.g:2538:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalWodel.g:2538:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalWodel.g:2539:3: () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalWodel.g:2539:3: ()
            // InternalWodel.g:2540:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0(),
            					current);
            			

            }

            // InternalWodel.g:2546:3: ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==50) ) {
                alt50=1;
            }
            else if ( (LA50_0==51) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalWodel.g:2547:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    {
                    // InternalWodel.g:2547:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    // InternalWodel.g:2548:5: (lv_boolSymbol_1_0= 'true' )
                    {
                    // InternalWodel.g:2548:5: (lv_boolSymbol_1_0= 'true' )
                    // InternalWodel.g:2549:6: lv_boolSymbol_1_0= 'true'
                    {
                    lv_boolSymbol_1_0=(Token)match(input,50,FOLLOW_2); 

                    						newLeafNode(lv_boolSymbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                    						}
                    						setWithLastConsumed(current, "boolSymbol", true, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:2562:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1());
                    			

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
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalWodel.g:2571:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalWodel.g:2571:51: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalWodel.g:2572:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
             newCompositeNode(grammarAccess.getPathNameCSRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;

             current =iv_rulePathNameCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // InternalWodel.g:2578:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= rulePathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2584:2: ( ( ( (lv_path_0_0= rulePathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )* ) )
            // InternalWodel.g:2585:2: ( ( (lv_path_0_0= rulePathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )* )
            {
            // InternalWodel.g:2585:2: ( ( (lv_path_0_0= rulePathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )* )
            // InternalWodel.g:2586:3: ( (lv_path_0_0= rulePathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )*
            {
            // InternalWodel.g:2586:3: ( (lv_path_0_0= rulePathCS ) )
            // InternalWodel.g:2587:4: (lv_path_0_0= rulePathCS )
            {
            // InternalWodel.g:2587:4: (lv_path_0_0= rulePathCS )
            // InternalWodel.g:2588:5: lv_path_0_0= rulePathCS
            {

            					newCompositeNode(grammarAccess.getPathNameCSAccess().getPathPathCSParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_55);
            lv_path_0_0=rulePathCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            					}
            					add(
            						current,
            						"path",
            						lv_path_0_0,
            						"wodel.dsls.Wodel.PathCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2605:3: (otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==35) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalWodel.g:2606:4: otherlv_1= '::' ( (lv_path_2_0= rulePathCS ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_47); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	    			
            	    // InternalWodel.g:2610:4: ( (lv_path_2_0= rulePathCS ) )
            	    // InternalWodel.g:2611:5: (lv_path_2_0= rulePathCS )
            	    {
            	    // InternalWodel.g:2611:5: (lv_path_2_0= rulePathCS )
            	    // InternalWodel.g:2612:6: lv_path_2_0= rulePathCS
            	    {

            	    						newCompositeNode(grammarAccess.getPathNameCSAccess().getPathPathCSParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_path_2_0=rulePathCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"path",
            	    							lv_path_2_0,
            	    							"wodel.dsls.Wodel.PathCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleNavigationPathNameCS"
    // InternalWodel.g:2634:1: entryRuleNavigationPathNameCS returns [EObject current=null] : iv_ruleNavigationPathNameCS= ruleNavigationPathNameCS EOF ;
    public final EObject entryRuleNavigationPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationPathNameCS = null;


        try {
            // InternalWodel.g:2634:61: (iv_ruleNavigationPathNameCS= ruleNavigationPathNameCS EOF )
            // InternalWodel.g:2635:2: iv_ruleNavigationPathNameCS= ruleNavigationPathNameCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationPathNameCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationPathNameCS=ruleNavigationPathNameCS();

            state._fsp--;

             current =iv_ruleNavigationPathNameCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationPathNameCS"


    // $ANTLR start "ruleNavigationPathNameCS"
    // InternalWodel.g:2641:1: ruleNavigationPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleNavigationPathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )* ) ;
    public final EObject ruleNavigationPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2647:2: ( ( ( (lv_path_0_0= ruleNavigationPathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )* ) )
            // InternalWodel.g:2648:2: ( ( (lv_path_0_0= ruleNavigationPathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )* )
            {
            // InternalWodel.g:2648:2: ( ( (lv_path_0_0= ruleNavigationPathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )* )
            // InternalWodel.g:2649:3: ( (lv_path_0_0= ruleNavigationPathCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )*
            {
            // InternalWodel.g:2649:3: ( (lv_path_0_0= ruleNavigationPathCS ) )
            // InternalWodel.g:2650:4: (lv_path_0_0= ruleNavigationPathCS )
            {
            // InternalWodel.g:2650:4: (lv_path_0_0= ruleNavigationPathCS )
            // InternalWodel.g:2651:5: lv_path_0_0= ruleNavigationPathCS
            {

            					newCompositeNode(grammarAccess.getNavigationPathNameCSAccess().getPathNavigationPathCSParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_55);
            lv_path_0_0=ruleNavigationPathCS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNavigationPathNameCSRule());
            					}
            					add(
            						current,
            						"path",
            						lv_path_0_0,
            						"wodel.dsls.Wodel.NavigationPathCS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:2668:3: (otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==35) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalWodel.g:2669:4: otherlv_1= '::' ( (lv_path_2_0= ruleNavigationPathCS ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_42); 

            	    				newLeafNode(otherlv_1, grammarAccess.getNavigationPathNameCSAccess().getColonColonKeyword_1_0());
            	    			
            	    // InternalWodel.g:2673:4: ( (lv_path_2_0= ruleNavigationPathCS ) )
            	    // InternalWodel.g:2674:5: (lv_path_2_0= ruleNavigationPathCS )
            	    {
            	    // InternalWodel.g:2674:5: (lv_path_2_0= ruleNavigationPathCS )
            	    // InternalWodel.g:2675:6: lv_path_2_0= ruleNavigationPathCS
            	    {

            	    						newCompositeNode(grammarAccess.getNavigationPathNameCSAccess().getPathNavigationPathCSParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_path_2_0=ruleNavigationPathCS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNavigationPathNameCSRule());
            	    						}
            	    						add(
            	    							current,
            	    							"path",
            	    							lv_path_2_0,
            	    							"wodel.dsls.Wodel.NavigationPathCS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // $ANTLR end "ruleNavigationPathNameCS"


    // $ANTLR start "entryRulePathCS"
    // InternalWodel.g:2697:1: entryRulePathCS returns [EObject current=null] : iv_rulePathCS= rulePathCS EOF ;
    public final EObject entryRulePathCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathCS = null;


        try {
            // InternalWodel.g:2697:47: (iv_rulePathCS= rulePathCS EOF )
            // InternalWodel.g:2698:2: iv_rulePathCS= rulePathCS EOF
            {
             newCompositeNode(grammarAccess.getPathCSRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathCS=rulePathCS();

            state._fsp--;

             current =iv_rulePathCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathCS"


    // $ANTLR start "rulePathCS"
    // InternalWodel.g:2704:1: rulePathCS returns [EObject current=null] : (this_PathElementCS_0= rulePathElementCS | this_PathVariableCS_1= rulePathVariableCS ) ;
    public final EObject rulePathCS() throws RecognitionException {
        EObject current = null;

        EObject this_PathElementCS_0 = null;

        EObject this_PathVariableCS_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:2710:2: ( (this_PathElementCS_0= rulePathElementCS | this_PathVariableCS_1= rulePathVariableCS ) )
            // InternalWodel.g:2711:2: (this_PathElementCS_0= rulePathElementCS | this_PathVariableCS_1= rulePathVariableCS )
            {
            // InternalWodel.g:2711:2: (this_PathElementCS_0= rulePathElementCS | this_PathVariableCS_1= rulePathVariableCS )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                alt53=1;
            }
            else if ( (LA53_0==47) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalWodel.g:2712:3: this_PathElementCS_0= rulePathElementCS
                    {

                    			newCompositeNode(grammarAccess.getPathCSAccess().getPathElementCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PathElementCS_0=rulePathElementCS();

                    state._fsp--;


                    			current = this_PathElementCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:2721:3: this_PathVariableCS_1= rulePathVariableCS
                    {

                    			newCompositeNode(grammarAccess.getPathCSAccess().getPathVariableCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PathVariableCS_1=rulePathVariableCS();

                    state._fsp--;


                    			current = this_PathVariableCS_1;
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
    // $ANTLR end "rulePathCS"


    // $ANTLR start "entryRuleNavigationPathCS"
    // InternalWodel.g:2733:1: entryRuleNavigationPathCS returns [EObject current=null] : iv_ruleNavigationPathCS= ruleNavigationPathCS EOF ;
    public final EObject entryRuleNavigationPathCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationPathCS = null;


        try {
            // InternalWodel.g:2733:57: (iv_ruleNavigationPathCS= ruleNavigationPathCS EOF )
            // InternalWodel.g:2734:2: iv_ruleNavigationPathCS= ruleNavigationPathCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationPathCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationPathCS=ruleNavigationPathCS();

            state._fsp--;

             current =iv_ruleNavigationPathCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationPathCS"


    // $ANTLR start "ruleNavigationPathCS"
    // InternalWodel.g:2740:1: ruleNavigationPathCS returns [EObject current=null] : (this_NavigationPathElementCS_0= ruleNavigationPathElementCS | this_NavigationPathVariableCS_1= ruleNavigationPathVariableCS ) ;
    public final EObject ruleNavigationPathCS() throws RecognitionException {
        EObject current = null;

        EObject this_NavigationPathElementCS_0 = null;

        EObject this_NavigationPathVariableCS_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:2746:2: ( (this_NavigationPathElementCS_0= ruleNavigationPathElementCS | this_NavigationPathVariableCS_1= ruleNavigationPathVariableCS ) )
            // InternalWodel.g:2747:2: (this_NavigationPathElementCS_0= ruleNavigationPathElementCS | this_NavigationPathVariableCS_1= ruleNavigationPathVariableCS )
            {
            // InternalWodel.g:2747:2: (this_NavigationPathElementCS_0= ruleNavigationPathElementCS | this_NavigationPathVariableCS_1= ruleNavigationPathVariableCS )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==47) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalWodel.g:2748:3: this_NavigationPathElementCS_0= ruleNavigationPathElementCS
                    {

                    			newCompositeNode(grammarAccess.getNavigationPathCSAccess().getNavigationPathElementCSParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NavigationPathElementCS_0=ruleNavigationPathElementCS();

                    state._fsp--;


                    			current = this_NavigationPathElementCS_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:2757:3: this_NavigationPathVariableCS_1= ruleNavigationPathVariableCS
                    {

                    			newCompositeNode(grammarAccess.getNavigationPathCSAccess().getNavigationPathVariableCSParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NavigationPathVariableCS_1=ruleNavigationPathVariableCS();

                    state._fsp--;


                    			current = this_NavigationPathVariableCS_1;
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
    // $ANTLR end "ruleNavigationPathCS"


    // $ANTLR start "entryRulePathElementCS"
    // InternalWodel.g:2769:1: entryRulePathElementCS returns [EObject current=null] : iv_rulePathElementCS= rulePathElementCS EOF ;
    public final EObject entryRulePathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathElementCS = null;


        try {
            // InternalWodel.g:2769:54: (iv_rulePathElementCS= rulePathElementCS EOF )
            // InternalWodel.g:2770:2: iv_rulePathElementCS= rulePathElementCS EOF
            {
             newCompositeNode(grammarAccess.getPathElementCSRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathElementCS=rulePathElementCS();

            state._fsp--;

             current =iv_rulePathElementCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathElementCS"


    // $ANTLR start "rulePathElementCS"
    // InternalWodel.g:2776:1: rulePathElementCS returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePathElementCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalWodel.g:2782:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalWodel.g:2783:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalWodel.g:2783:2: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:2784:3: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:2784:3: (otherlv_0= RULE_ID )
            // InternalWodel.g:2785:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPathElementCSRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getPathElementCSAccess().getPathNameEStructuralFeatureCrossReference_0());
            			

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
    // $ANTLR end "rulePathElementCS"


    // $ANTLR start "entryRuleNavigationPathElementCS"
    // InternalWodel.g:2799:1: entryRuleNavigationPathElementCS returns [EObject current=null] : iv_ruleNavigationPathElementCS= ruleNavigationPathElementCS EOF ;
    public final EObject entryRuleNavigationPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationPathElementCS = null;


        try {
            // InternalWodel.g:2799:64: (iv_ruleNavigationPathElementCS= ruleNavigationPathElementCS EOF )
            // InternalWodel.g:2800:2: iv_ruleNavigationPathElementCS= ruleNavigationPathElementCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationPathElementCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationPathElementCS=ruleNavigationPathElementCS();

            state._fsp--;

             current =iv_ruleNavigationPathElementCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationPathElementCS"


    // $ANTLR start "ruleNavigationPathElementCS"
    // InternalWodel.g:2806:1: ruleNavigationPathElementCS returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleNavigationPathElementCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalWodel.g:2812:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalWodel.g:2813:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalWodel.g:2813:2: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:2814:3: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:2814:3: (otherlv_0= RULE_ID )
            // InternalWodel.g:2815:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNavigationPathElementCSRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getNavigationPathElementCSAccess().getPathNameEStructuralFeatureCrossReference_0());
            			

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
    // $ANTLR end "ruleNavigationPathElementCS"


    // $ANTLR start "entryRulePathVariableCS"
    // InternalWodel.g:2829:1: entryRulePathVariableCS returns [EObject current=null] : iv_rulePathVariableCS= rulePathVariableCS EOF ;
    public final EObject entryRulePathVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathVariableCS = null;


        try {
            // InternalWodel.g:2829:55: (iv_rulePathVariableCS= rulePathVariableCS EOF )
            // InternalWodel.g:2830:2: iv_rulePathVariableCS= rulePathVariableCS EOF
            {
             newCompositeNode(grammarAccess.getPathVariableCSRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathVariableCS=rulePathVariableCS();

            state._fsp--;

             current =iv_rulePathVariableCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathVariableCS"


    // $ANTLR start "rulePathVariableCS"
    // InternalWodel.g:2836:1: rulePathVariableCS returns [EObject current=null] : (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) ) ;
    public final EObject rulePathVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_varName_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2842:2: ( (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) ) )
            // InternalWodel.g:2843:2: (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) )
            {
            // InternalWodel.g:2843:2: (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) )
            // InternalWodel.g:2844:3: otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getPathVariableCSAccess().getDollarSignKeyword_0());
            		
            // InternalWodel.g:2848:3: ( (lv_varName_1_0= ruleEString ) )
            // InternalWodel.g:2849:4: (lv_varName_1_0= ruleEString )
            {
            // InternalWodel.g:2849:4: (lv_varName_1_0= ruleEString )
            // InternalWodel.g:2850:5: lv_varName_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPathVariableCSAccess().getVarNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_varName_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathVariableCSRule());
            					}
            					set(
            						current,
            						"varName",
            						lv_varName_1_0,
            						"wodel.dsls.Wodel.EString");
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
    // $ANTLR end "rulePathVariableCS"


    // $ANTLR start "entryRuleNavigationPathVariableCS"
    // InternalWodel.g:2871:1: entryRuleNavigationPathVariableCS returns [EObject current=null] : iv_ruleNavigationPathVariableCS= ruleNavigationPathVariableCS EOF ;
    public final EObject entryRuleNavigationPathVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationPathVariableCS = null;


        try {
            // InternalWodel.g:2871:65: (iv_ruleNavigationPathVariableCS= ruleNavigationPathVariableCS EOF )
            // InternalWodel.g:2872:2: iv_ruleNavigationPathVariableCS= ruleNavigationPathVariableCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationPathVariableCSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationPathVariableCS=ruleNavigationPathVariableCS();

            state._fsp--;

             current =iv_ruleNavigationPathVariableCS; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationPathVariableCS"


    // $ANTLR start "ruleNavigationPathVariableCS"
    // InternalWodel.g:2878:1: ruleNavigationPathVariableCS returns [EObject current=null] : (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) ) ;
    public final EObject ruleNavigationPathVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_varName_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:2884:2: ( (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) ) )
            // InternalWodel.g:2885:2: (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) )
            {
            // InternalWodel.g:2885:2: (otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) ) )
            // InternalWodel.g:2886:3: otherlv_0= '$' ( (lv_varName_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getNavigationPathVariableCSAccess().getDollarSignKeyword_0());
            		
            // InternalWodel.g:2890:3: ( (lv_varName_1_0= ruleEString ) )
            // InternalWodel.g:2891:4: (lv_varName_1_0= ruleEString )
            {
            // InternalWodel.g:2891:4: (lv_varName_1_0= ruleEString )
            // InternalWodel.g:2892:5: lv_varName_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getNavigationPathVariableCSAccess().getVarNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_varName_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNavigationPathVariableCSRule());
            					}
            					set(
            						current,
            						"varName",
            						lv_varName_1_0,
            						"wodel.dsls.Wodel.EString");
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
    // $ANTLR end "ruleNavigationPathVariableCS"


    // $ANTLR start "entryRuleMutator"
    // InternalWodel.g:2913:1: entryRuleMutator returns [EObject current=null] : iv_ruleMutator= ruleMutator EOF ;
    public final EObject entryRuleMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutator = null;


        try {
            // InternalWodel.g:2913:48: (iv_ruleMutator= ruleMutator EOF )
            // InternalWodel.g:2914:2: iv_ruleMutator= ruleMutator EOF
            {
             newCompositeNode(grammarAccess.getMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMutator=ruleMutator();

            state._fsp--;

             current =iv_ruleMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:2920:1: ruleMutator returns [EObject current=null] : (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator | this_RetypeObjectMutator_11= ruleRetypeObjectMutator ) ;
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

        EObject this_RetypeObjectMutator_11 = null;



        	enterRule();

        try {
            // InternalWodel.g:2926:2: ( (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator | this_RetypeObjectMutator_11= ruleRetypeObjectMutator ) )
            // InternalWodel.g:2927:2: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator | this_RetypeObjectMutator_11= ruleRetypeObjectMutator )
            {
            // InternalWodel.g:2927:2: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator | this_RetypeObjectMutator_11= ruleRetypeObjectMutator )
            int alt55=12;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalWodel.g:2928:3: this_CreateObjectMutator_0= ruleCreateObjectMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getCreateObjectMutatorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CreateObjectMutator_0=ruleCreateObjectMutator();

                    state._fsp--;


                    			current = this_CreateObjectMutator_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:2937:3: this_SelectObjectMutator_1= ruleSelectObjectMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getSelectObjectMutatorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelectObjectMutator_1=ruleSelectObjectMutator();

                    state._fsp--;


                    			current = this_SelectObjectMutator_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:2946:3: this_SelectSampleMutator_2= ruleSelectSampleMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getSelectSampleMutatorParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelectSampleMutator_2=ruleSelectSampleMutator();

                    state._fsp--;


                    			current = this_SelectSampleMutator_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:2955:3: this_CompositeMutator_3= ruleCompositeMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getCompositeMutatorParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompositeMutator_3=ruleCompositeMutator();

                    state._fsp--;


                    			current = this_CompositeMutator_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:2964:3: this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getModifySourceReferenceMutatorParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ModifySourceReferenceMutator_4=ruleModifySourceReferenceMutator();

                    state._fsp--;


                    			current = this_ModifySourceReferenceMutator_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWodel.g:2973:3: this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getModifyTargetReferenceMutatorParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ModifyTargetReferenceMutator_5=ruleModifyTargetReferenceMutator();

                    state._fsp--;


                    			current = this_ModifyTargetReferenceMutator_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWodel.g:2982:3: this_CreateReferenceMutator_6= ruleCreateReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getCreateReferenceMutatorParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_CreateReferenceMutator_6=ruleCreateReferenceMutator();

                    state._fsp--;


                    			current = this_CreateReferenceMutator_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalWodel.g:2991:3: this_RemoveObjectMutator_7= ruleRemoveObjectMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getRemoveObjectMutatorParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveObjectMutator_7=ruleRemoveObjectMutator();

                    state._fsp--;


                    			current = this_RemoveObjectMutator_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalWodel.g:3000:3: this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getRemoveReferenceMutatorParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveReferenceMutator_8=ruleRemoveReferenceMutator();

                    state._fsp--;


                    			current = this_RemoveReferenceMutator_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalWodel.g:3009:3: this_ModifyInformationMutator_9= ruleModifyInformationMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getModifyInformationMutatorParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_ModifyInformationMutator_9=ruleModifyInformationMutator();

                    state._fsp--;


                    			current = this_ModifyInformationMutator_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalWodel.g:3018:3: this_CloneObjectMutator_10= ruleCloneObjectMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getCloneObjectMutatorParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_CloneObjectMutator_10=ruleCloneObjectMutator();

                    state._fsp--;


                    			current = this_CloneObjectMutator_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalWodel.g:3027:3: this_RetypeObjectMutator_11= ruleRetypeObjectMutator
                    {

                    			newCompositeNode(grammarAccess.getMutatorAccess().getRetypeObjectMutatorParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_RetypeObjectMutator_11=ruleRetypeObjectMutator();

                    state._fsp--;


                    			current = this_RetypeObjectMutator_11;
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
    // InternalWodel.g:3039:1: entryRuleObSelectionStrategy returns [EObject current=null] : iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF ;
    public final EObject entryRuleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObSelectionStrategy = null;


        try {
            // InternalWodel.g:3039:60: (iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF )
            // InternalWodel.g:3040:2: iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF
            {
             newCompositeNode(grammarAccess.getObSelectionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObSelectionStrategy=ruleObSelectionStrategy();

            state._fsp--;

             current =iv_ruleObSelectionStrategy; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3046:1: ruleObSelectionStrategy returns [EObject current=null] : (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_TypedSelection_4= ruleTypedSelection ) ;
    public final EObject ruleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_RandomSelection_0 = null;

        EObject this_SpecificSelection_1 = null;

        EObject this_CompleteSelection_2 = null;

        EObject this_OtherSelection_3 = null;

        EObject this_TypedSelection_4 = null;



        	enterRule();

        try {
            // InternalWodel.g:3052:2: ( (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_TypedSelection_4= ruleTypedSelection ) )
            // InternalWodel.g:3053:2: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_TypedSelection_4= ruleTypedSelection )
            {
            // InternalWodel.g:3053:2: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_TypedSelection_4= ruleTypedSelection )
            int alt56=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt56=1;
                }
                break;
            case RULE_ID:
            case 81:
                {
                alt56=2;
                }
                break;
            case 62:
                {
                alt56=3;
                }
                break;
            case 82:
                {
                alt56=4;
                }
                break;
            case 83:
                {
                alt56=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalWodel.g:3054:3: this_RandomSelection_0= ruleRandomSelection
                    {

                    			newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getRandomSelectionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RandomSelection_0=ruleRandomSelection();

                    state._fsp--;


                    			current = this_RandomSelection_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3063:3: this_SpecificSelection_1= ruleSpecificSelection
                    {

                    			newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSpecificSelectionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificSelection_1=ruleSpecificSelection();

                    state._fsp--;


                    			current = this_SpecificSelection_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:3072:3: this_CompleteSelection_2= ruleCompleteSelection
                    {

                    			newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getCompleteSelectionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompleteSelection_2=ruleCompleteSelection();

                    state._fsp--;


                    			current = this_CompleteSelection_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:3081:3: this_OtherSelection_3= ruleOtherSelection
                    {

                    			newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getOtherSelectionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_OtherSelection_3=ruleOtherSelection();

                    state._fsp--;


                    			current = this_OtherSelection_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:3090:3: this_TypedSelection_4= ruleTypedSelection
                    {

                    			newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getTypedSelectionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_TypedSelection_4=ruleTypedSelection();

                    state._fsp--;


                    			current = this_TypedSelection_4;
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
    // InternalWodel.g:3102:1: entryRuleRandomSelection returns [EObject current=null] : iv_ruleRandomSelection= ruleRandomSelection EOF ;
    public final EObject entryRuleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomSelection = null;


        try {
            // InternalWodel.g:3102:56: (iv_ruleRandomSelection= ruleRandomSelection EOF )
            // InternalWodel.g:3103:2: iv_ruleRandomSelection= ruleRandomSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomSelection=ruleRandomSelection();

            state._fsp--;

             current =iv_ruleRandomSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3109:1: ruleRandomSelection returns [EObject current=null] : this_RandomTypeSelection_0= ruleRandomTypeSelection ;
    public final EObject ruleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject this_RandomTypeSelection_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3115:2: (this_RandomTypeSelection_0= ruleRandomTypeSelection )
            // InternalWodel.g:3116:2: this_RandomTypeSelection_0= ruleRandomTypeSelection
            {

            		newCompositeNode(grammarAccess.getRandomSelectionAccess().getRandomTypeSelectionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3127:1: entryRuleSpecificSelection returns [EObject current=null] : iv_ruleSpecificSelection= ruleSpecificSelection EOF ;
    public final EObject entryRuleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificSelection = null;


        try {
            // InternalWodel.g:3127:58: (iv_ruleSpecificSelection= ruleSpecificSelection EOF )
            // InternalWodel.g:3128:2: iv_ruleSpecificSelection= ruleSpecificSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificSelection=ruleSpecificSelection();

            state._fsp--;

             current =iv_ruleSpecificSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3134:1: ruleSpecificSelection returns [EObject current=null] : (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection ) ;
    public final EObject ruleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificObjectSelection_0 = null;

        EObject this_SpecificClosureSelection_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:3140:2: ( (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection ) )
            // InternalWodel.g:3141:2: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection )
            {
            // InternalWodel.g:3141:2: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            else if ( (LA57_0==81) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalWodel.g:3142:3: this_SpecificObjectSelection_0= ruleSpecificObjectSelection
                    {

                    			newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificObjectSelectionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificObjectSelection_0=ruleSpecificObjectSelection();

                    state._fsp--;


                    			current = this_SpecificObjectSelection_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3151:3: this_SpecificClosureSelection_1= ruleSpecificClosureSelection
                    {

                    			newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificClosureSelectionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3163:1: entryRuleCompleteSelection returns [EObject current=null] : iv_ruleCompleteSelection= ruleCompleteSelection EOF ;
    public final EObject entryRuleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteSelection = null;


        try {
            // InternalWodel.g:3163:58: (iv_ruleCompleteSelection= ruleCompleteSelection EOF )
            // InternalWodel.g:3164:2: iv_ruleCompleteSelection= ruleCompleteSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompleteSelection=ruleCompleteSelection();

            state._fsp--;

             current =iv_ruleCompleteSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3170:1: ruleCompleteSelection returns [EObject current=null] : this_CompleteTypeSelection_0= ruleCompleteTypeSelection ;
    public final EObject ruleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject this_CompleteTypeSelection_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3176:2: (this_CompleteTypeSelection_0= ruleCompleteTypeSelection )
            // InternalWodel.g:3177:2: this_CompleteTypeSelection_0= ruleCompleteTypeSelection
            {

            		newCompositeNode(grammarAccess.getCompleteSelectionAccess().getCompleteTypeSelectionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3188:1: entryRuleOtherSelection returns [EObject current=null] : iv_ruleOtherSelection= ruleOtherSelection EOF ;
    public final EObject entryRuleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherSelection = null;


        try {
            // InternalWodel.g:3188:55: (iv_ruleOtherSelection= ruleOtherSelection EOF )
            // InternalWodel.g:3189:2: iv_ruleOtherSelection= ruleOtherSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherSelection=ruleOtherSelection();

            state._fsp--;

             current =iv_ruleOtherSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3195:1: ruleOtherSelection returns [EObject current=null] : this_OtherTypeSelection_0= ruleOtherTypeSelection ;
    public final EObject ruleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject this_OtherTypeSelection_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3201:2: (this_OtherTypeSelection_0= ruleOtherTypeSelection )
            // InternalWodel.g:3202:2: this_OtherTypeSelection_0= ruleOtherTypeSelection
            {

            		newCompositeNode(grammarAccess.getOtherSelectionAccess().getOtherTypeSelectionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3213:1: entryRuleAttributeEvaluationType returns [EObject current=null] : iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF ;
    public final EObject entryRuleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluationType = null;


        try {
            // InternalWodel.g:3213:64: (iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF )
            // InternalWodel.g:3214:2: iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeEvaluationType=ruleAttributeEvaluationType();

            state._fsp--;

             current =iv_ruleAttributeEvaluationType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3220:1: ruleAttributeEvaluationType returns [EObject current=null] : (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) ;
    public final EObject ruleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeType_0 = null;

        EObject this_ObjectAttributeType_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:3226:2: ( (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) )
            // InternalWodel.g:3227:2: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            {
            // InternalWodel.g:3227:2: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalWodel.g:3228:3: this_AttributeType_0= ruleAttributeType
                    {

                    			newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getAttributeTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeType_0=ruleAttributeType();

                    state._fsp--;


                    			current = this_AttributeType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3237:3: this_ObjectAttributeType_1= ruleObjectAttributeType
                    {

                    			newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getObjectAttributeTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3249:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // InternalWodel.g:3249:54: (iv_ruleAttributeType= ruleAttributeType EOF )
            // InternalWodel.g:3250:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3256:1: ruleAttributeType returns [EObject current=null] : (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) ;
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
            // InternalWodel.g:3262:2: ( (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) )
            // InternalWodel.g:3263:2: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            {
            // InternalWodel.g:3263:2: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            int alt59=6;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // InternalWodel.g:3264:3: this_NumberType_0= ruleNumberType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getNumberTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberType_0=ruleNumberType();

                    state._fsp--;


                    			current = this_NumberType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3273:3: this_BooleanType_1= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getBooleanTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:3282:3: this_StringType_2= ruleStringType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringType_2=ruleStringType();

                    state._fsp--;


                    			current = this_StringType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:3291:3: this_ListStringType_3= ruleListStringType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getListStringTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ListStringType_3=ruleListStringType();

                    state._fsp--;


                    			current = this_ListStringType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:3300:3: this_RandomType_4= ruleRandomType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getRandomTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_RandomType_4=ruleRandomType();

                    state._fsp--;


                    			current = this_RandomType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWodel.g:3309:3: this_ListType_5= ruleListType
                    {

                    			newCompositeNode(grammarAccess.getAttributeTypeAccess().getListTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3321:1: entryRuleNumberType returns [EObject current=null] : iv_ruleNumberType= ruleNumberType EOF ;
    public final EObject entryRuleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberType = null;


        try {
            // InternalWodel.g:3321:51: (iv_ruleNumberType= ruleNumberType EOF )
            // InternalWodel.g:3322:2: iv_ruleNumberType= ruleNumberType EOF
            {
             newCompositeNode(grammarAccess.getNumberTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberType=ruleNumberType();

            state._fsp--;

             current =iv_ruleNumberType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3328:1: ruleNumberType returns [EObject current=null] : (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) ;
    public final EObject ruleNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerType_0 = null;

        EObject this_DoubleType_1 = null;

        EObject this_MinValueType_2 = null;

        EObject this_MaxValueType_3 = null;

        EObject this_RandomNumberType_4 = null;



        	enterRule();

        try {
            // InternalWodel.g:3334:2: ( (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) )
            // InternalWodel.g:3335:2: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            {
            // InternalWodel.g:3335:2: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            int alt60=5;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalWodel.g:3336:3: this_IntegerType_0= ruleIntegerType
                    {

                    			newCompositeNode(grammarAccess.getNumberTypeAccess().getIntegerTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerType_0=ruleIntegerType();

                    state._fsp--;


                    			current = this_IntegerType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3345:3: this_DoubleType_1= ruleDoubleType
                    {

                    			newCompositeNode(grammarAccess.getNumberTypeAccess().getDoubleTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DoubleType_1=ruleDoubleType();

                    state._fsp--;


                    			current = this_DoubleType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:3354:3: this_MinValueType_2= ruleMinValueType
                    {

                    			newCompositeNode(grammarAccess.getNumberTypeAccess().getMinValueTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_MinValueType_2=ruleMinValueType();

                    state._fsp--;


                    			current = this_MinValueType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:3363:3: this_MaxValueType_3= ruleMaxValueType
                    {

                    			newCompositeNode(grammarAccess.getNumberTypeAccess().getMaxValueTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MaxValueType_3=ruleMaxValueType();

                    state._fsp--;


                    			current = this_MaxValueType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:3372:3: this_RandomNumberType_4= ruleRandomNumberType
                    {

                    			newCompositeNode(grammarAccess.getNumberTypeAccess().getRandomNumberTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3384:1: entryRuleRandomNumberType returns [EObject current=null] : iv_ruleRandomNumberType= ruleRandomNumberType EOF ;
    public final EObject entryRuleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomNumberType = null;


        try {
            // InternalWodel.g:3384:57: (iv_ruleRandomNumberType= ruleRandomNumberType EOF )
            // InternalWodel.g:3385:2: iv_ruleRandomNumberType= ruleRandomNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomNumberTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomNumberType=ruleRandomNumberType();

            state._fsp--;

             current =iv_ruleRandomNumberType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3391:1: ruleRandomNumberType returns [EObject current=null] : (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) ;
    public final EObject ruleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_RandomDoubleNumberType_0 = null;

        EObject this_RandomIntegerNumberType_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:3397:2: ( (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) )
            // InternalWodel.g:3398:2: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            {
            // InternalWodel.g:3398:2: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalWodel.g:3399:3: this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType
                    {

                    			newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomDoubleNumberTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RandomDoubleNumberType_0=ruleRandomDoubleNumberType();

                    state._fsp--;


                    			current = this_RandomDoubleNumberType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3408:3: this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType
                    {

                    			newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomIntegerNumberTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3420:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // InternalWodel.g:3420:45: (iv_ruleLoad= ruleLoad EOF )
            // InternalWodel.g:3421:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3427:1: ruleLoad returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_file_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3433:2: ( ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) )
            // InternalWodel.g:3434:2: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            {
            // InternalWodel.g:3434:2: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            // InternalWodel.g:3435:3: () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) )
            {
            // InternalWodel.g:3435:3: ()
            // InternalWodel.g:3436:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoadAccess().getLoadAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,52,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getImportKeyword_1());
            		
            // InternalWodel.g:3446:3: ( (lv_file_2_0= ruleEString ) )
            // InternalWodel.g:3447:4: (lv_file_2_0= ruleEString )
            {
            // InternalWodel.g:3447:4: (lv_file_2_0= ruleEString )
            // InternalWodel.g:3448:5: lv_file_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_file_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoadRule());
            					}
            					set(
            						current,
            						"file",
            						lv_file_2_0,
            						"wodel.dsls.Wodel.EString");
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
    // InternalWodel.g:3469:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalWodel.g:3469:47: (iv_ruleEString= ruleEString EOF )
            // InternalWodel.g:3470:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3476:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalWodel.g:3482:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalWodel.g:3483:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalWodel.g:3483:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_STRING) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalWodel.g:3484:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3492:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalWodel.g:3503:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalWodel.g:3503:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalWodel.g:3504:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3510:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalWodel.g:3516:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalWodel.g:3517:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalWodel.g:3517:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalWodel.g:3518:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalWodel.g:3518:3: (kw= '-' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==53) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalWodel.g:3519:4: kw= '-'
                    {
                    kw=(Token)match(input,53,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

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
    // InternalWodel.g:3536:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalWodel.g:3536:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalWodel.g:3537:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3543:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalWodel.g:3549:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalWodel.g:3550:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalWodel.g:3550:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalWodel.g:3551:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalWodel.g:3551:3: (kw= '-' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==53) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalWodel.g:3552:4: kw= '-'
                    {
                    kw=(Token)match(input,53,FOLLOW_57); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalWodel.g:3558:3: (this_INT_1= RULE_INT )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_INT) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalWodel.g:3559:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_58); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,38,FOLLOW_56); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_59); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalWodel.g:3579:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=54 && LA68_0<=55)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalWodel.g:3580:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalWodel.g:3580:4: (kw= 'E' | kw= 'e' )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==54) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==55) ) {
                        alt66=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 66, 0, input);

                        throw nvae;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalWodel.g:3581:5: kw= 'E'
                            {
                            kw=(Token)match(input,54,FOLLOW_31); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalWodel.g:3587:5: kw= 'e'
                            {
                            kw=(Token)match(input,55,FOLLOW_31); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:3593:4: (kw= '-' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==53) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalWodel.g:3594:5: kw= '-'
                            {
                            kw=(Token)match(input,53,FOLLOW_56); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

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
    // InternalWodel.g:3612:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalWodel.g:3612:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalWodel.g:3613:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3619:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWodel.g:3625:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalWodel.g:3626:2: (kw= 'true' | kw= 'false' )
            {
            // InternalWodel.g:3626:2: (kw= 'true' | kw= 'false' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==50) ) {
                alt69=1;
            }
            else if ( (LA69_0==51) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalWodel.g:3627:3: kw= 'true'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3633:3: kw= 'false'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

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
    // InternalWodel.g:3642:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // InternalWodel.g:3642:55: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // InternalWodel.g:3643:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3649:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3655:2: ( ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) )
            // InternalWodel.g:3656:2: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            {
            // InternalWodel.g:3656:2: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            // InternalWodel.g:3657:3: () ( (lv_type_1_0= ruleLogicOperator ) )
            {
            // InternalWodel.g:3657:3: ()
            // InternalWodel.g:3658:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
            					current);
            			

            }

            // InternalWodel.g:3664:3: ( (lv_type_1_0= ruleLogicOperator ) )
            // InternalWodel.g:3665:4: (lv_type_1_0= ruleLogicOperator )
            {
            // InternalWodel.g:3665:4: (lv_type_1_0= ruleLogicOperator )
            // InternalWodel.g:3666:5: lv_type_1_0= ruleLogicOperator
            {

            					newCompositeNode(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleLogicOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"wodel.dsls.Wodel.LogicOperator");
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
    // InternalWodel.g:3687:1: entryRuleAttributeEvaluation returns [EObject current=null] : iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF ;
    public final EObject entryRuleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluation = null;


        try {
            // InternalWodel.g:3687:60: (iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF )
            // InternalWodel.g:3688:2: iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeEvaluation=ruleAttributeEvaluation();

            state._fsp--;

             current =iv_ruleAttributeEvaluation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3694:1: ruleAttributeEvaluation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3700:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // InternalWodel.g:3701:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // InternalWodel.g:3701:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // InternalWodel.g:3702:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // InternalWodel.g:3702:3: ()
            // InternalWodel.g:3703:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAttributeEvaluationAccess().getAttributeEvaluationAction_0(),
            					current);
            			

            }

            // InternalWodel.g:3709:3: ( (otherlv_1= RULE_ID ) )
            // InternalWodel.g:3710:4: (otherlv_1= RULE_ID )
            {
            // InternalWodel.g:3710:4: (otherlv_1= RULE_ID )
            // InternalWodel.g:3711:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeEvaluationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_60); 

            					newLeafNode(otherlv_1, grammarAccess.getAttributeEvaluationAccess().getNameEAttributeCrossReference_1_0());
            				

            }


            }

            // InternalWodel.g:3722:3: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // InternalWodel.g:3723:4: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // InternalWodel.g:3723:4: (lv_value_2_0= ruleAttributeEvaluationType )
            // InternalWodel.g:3724:5: lv_value_2_0= ruleAttributeEvaluationType
            {

            					newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleAttributeEvaluationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeEvaluationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Wodel.AttributeEvaluationType");
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
    // InternalWodel.g:3745:1: entryRuleReferenceEvaluation returns [EObject current=null] : iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF ;
    public final EObject entryRuleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceEvaluation = null;


        try {
            // InternalWodel.g:3745:60: (iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF )
            // InternalWodel.g:3746:2: iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF
            {
             newCompositeNode(grammarAccess.getReferenceEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceEvaluation=ruleReferenceEvaluation();

            state._fsp--;

             current =iv_ruleReferenceEvaluation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3752:1: ruleReferenceEvaluation returns [EObject current=null] : ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) ) ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) ) ) ;
    public final EObject ruleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_container_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_attValue_6_0 = null;

        Enumerator lv_operator_11_0 = null;

        EObject lv_value_12_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3758:2: ( ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) ) ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) ) ) )
            // InternalWodel.g:3759:2: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) ) ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) ) )
            {
            // InternalWodel.g:3759:2: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) ) ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) ) )
            // InternalWodel.g:3760:3: () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) ) ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) )
            {
            // InternalWodel.g:3760:3: ()
            // InternalWodel.g:3761:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getReferenceEvaluationAccess().getReferenceEvaluationAction_0(),
            					current);
            			

            }

            // InternalWodel.g:3767:3: ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' | ( (lv_container_3_0= 'container' ) ) )
            int alt70=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt70=1;
                }
                break;
            case 56:
                {
                alt70=2;
                }
                break;
            case 57:
                {
                alt70=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalWodel.g:3768:4: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalWodel.g:3768:4: ( (otherlv_1= RULE_ID ) )
                    // InternalWodel.g:3769:5: (otherlv_1= RULE_ID )
                    {
                    // InternalWodel.g:3769:5: (otherlv_1= RULE_ID )
                    // InternalWodel.g:3770:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_61); 

                    						newLeafNode(otherlv_1, grammarAccess.getReferenceEvaluationAccess().getNameEReferenceCrossReference_1_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:3782:4: otherlv_2= 'self'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferenceEvaluationAccess().getSelfKeyword_1_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalWodel.g:3787:4: ( (lv_container_3_0= 'container' ) )
                    {
                    // InternalWodel.g:3787:4: ( (lv_container_3_0= 'container' ) )
                    // InternalWodel.g:3788:5: (lv_container_3_0= 'container' )
                    {
                    // InternalWodel.g:3788:5: (lv_container_3_0= 'container' )
                    // InternalWodel.g:3789:6: lv_container_3_0= 'container'
                    {
                    lv_container_3_0=(Token)match(input,57,FOLLOW_61); 

                    						newLeafNode(lv_container_3_0, grammarAccess.getReferenceEvaluationAccess().getContainerContainerKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    						}
                    						setWithLastConsumed(current, "container", true, "container");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:3802:3: ( (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) ) | ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==38) ) {
                alt74=1;
            }
            else if ( (LA74_0==23||LA74_0==28||LA74_0==37||LA74_0==39||(LA74_0>=98 && LA74_0<=103)) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalWodel.g:3803:4: (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) )
                    {
                    // InternalWodel.g:3803:4: (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) ) )
                    // InternalWodel.g:3804:5: otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ( (lv_attValue_6_0= ruleAttributeEvaluationType ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_7); 

                    					newLeafNode(otherlv_4, grammarAccess.getReferenceEvaluationAccess().getFullStopKeyword_2_0_0());
                    				
                    // InternalWodel.g:3808:5: ( (otherlv_5= RULE_ID ) )
                    // InternalWodel.g:3809:6: (otherlv_5= RULE_ID )
                    {
                    // InternalWodel.g:3809:6: (otherlv_5= RULE_ID )
                    // InternalWodel.g:3810:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_60); 

                    							newLeafNode(otherlv_5, grammarAccess.getReferenceEvaluationAccess().getAttNameEAttributeCrossReference_2_0_1_0());
                    						

                    }


                    }

                    // InternalWodel.g:3821:5: ( (lv_attValue_6_0= ruleAttributeEvaluationType ) )
                    // InternalWodel.g:3822:6: (lv_attValue_6_0= ruleAttributeEvaluationType )
                    {
                    // InternalWodel.g:3822:6: (lv_attValue_6_0= ruleAttributeEvaluationType )
                    // InternalWodel.g:3823:7: lv_attValue_6_0= ruleAttributeEvaluationType
                    {

                    							newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getAttValueAttributeEvaluationTypeParserRuleCall_2_0_2_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_attValue_6_0=ruleAttributeEvaluationType();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                    							}
                    							set(
                    								current,
                    								"attValue",
                    								lv_attValue_6_0,
                    								"wodel.dsls.Wodel.AttributeEvaluationType");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:3842:4: ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) )
                    {
                    // InternalWodel.g:3842:4: ( (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' ) )
                    // InternalWodel.g:3843:5: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )? ( (lv_operator_11_0= ruleOperator ) ) ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' )
                    {
                    // InternalWodel.g:3843:5: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )? )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==39) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalWodel.g:3844:6: otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )?
                            {
                            otherlv_7=(Token)match(input,39,FOLLOW_7); 

                            						newLeafNode(otherlv_7, grammarAccess.getReferenceEvaluationAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0_0());
                            					
                            // InternalWodel.g:3848:6: ( (otherlv_8= RULE_ID ) )
                            // InternalWodel.g:3849:7: (otherlv_8= RULE_ID )
                            {
                            // InternalWodel.g:3849:7: (otherlv_8= RULE_ID )
                            // InternalWodel.g:3850:8: otherlv_8= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                            								}
                            							
                            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_62); 

                            								newLeafNode(otherlv_8, grammarAccess.getReferenceEvaluationAccess().getRefNameEReferenceCrossReference_2_1_0_1_0());
                            							

                            }


                            }

                            // InternalWodel.g:3861:6: (otherlv_9= '->' ( (otherlv_10= RULE_ID ) ) )?
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( (LA71_0==39) ) {
                                alt71=1;
                            }
                            switch (alt71) {
                                case 1 :
                                    // InternalWodel.g:3862:7: otherlv_9= '->' ( (otherlv_10= RULE_ID ) )
                                    {
                                    otherlv_9=(Token)match(input,39,FOLLOW_7); 

                                    							newLeafNode(otherlv_9, grammarAccess.getReferenceEvaluationAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0_2_0());
                                    						
                                    // InternalWodel.g:3866:7: ( (otherlv_10= RULE_ID ) )
                                    // InternalWodel.g:3867:8: (otherlv_10= RULE_ID )
                                    {
                                    // InternalWodel.g:3867:8: (otherlv_10= RULE_ID )
                                    // InternalWodel.g:3868:9: otherlv_10= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                                    									}
                                    								
                                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_60); 

                                    									newLeafNode(otherlv_10, grammarAccess.getReferenceEvaluationAccess().getRefRefNameEReferenceCrossReference_2_1_0_2_1_0());
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // InternalWodel.g:3881:5: ( (lv_operator_11_0= ruleOperator ) )
                    // InternalWodel.g:3882:6: (lv_operator_11_0= ruleOperator )
                    {
                    // InternalWodel.g:3882:6: (lv_operator_11_0= ruleOperator )
                    // InternalWodel.g:3883:7: lv_operator_11_0= ruleOperator
                    {

                    							newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getOperatorOperatorEnumRuleCall_2_1_1_0());
                    						
                    pushFollow(FOLLOW_63);
                    lv_operator_11_0=ruleOperator();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                    							}
                    							set(
                    								current,
                    								"operator",
                    								lv_operator_11_0,
                    								"wodel.dsls.Wodel.Operator");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalWodel.g:3900:5: ( ( (lv_value_12_0= ruleObSelectionStrategy ) ) | otherlv_13= 'null' )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==RULE_ID||LA73_0==60||LA73_0==62||(LA73_0>=81 && LA73_0<=83)) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==58) ) {
                        alt73=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 0, input);

                        throw nvae;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalWodel.g:3901:6: ( (lv_value_12_0= ruleObSelectionStrategy ) )
                            {
                            // InternalWodel.g:3901:6: ( (lv_value_12_0= ruleObSelectionStrategy ) )
                            // InternalWodel.g:3902:7: (lv_value_12_0= ruleObSelectionStrategy )
                            {
                            // InternalWodel.g:3902:7: (lv_value_12_0= ruleObSelectionStrategy )
                            // InternalWodel.g:3903:8: lv_value_12_0= ruleObSelectionStrategy
                            {

                            								newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getValueObSelectionStrategyParserRuleCall_2_1_2_0_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_value_12_0=ruleObSelectionStrategy();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"value",
                            									lv_value_12_0,
                            									"wodel.dsls.Wodel.ObSelectionStrategy");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:3921:6: otherlv_13= 'null'
                            {
                            otherlv_13=(Token)match(input,58,FOLLOW_2); 

                            						newLeafNode(otherlv_13, grammarAccess.getReferenceEvaluationAccess().getNullKeyword_2_1_2_1());
                            					

                            }
                            break;

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
    // $ANTLR end "ruleReferenceEvaluation"


    // $ANTLR start "entryRuleEvaluation"
    // InternalWodel.g:3932:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalWodel.g:3932:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalWodel.g:3933:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3939:1: ruleEvaluation returns [EObject current=null] : (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeEvaluation_0 = null;

        EObject this_ReferenceEvaluation_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:3945:2: ( (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) )
            // InternalWodel.g:3946:2: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            {
            // InternalWodel.g:3946:2: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalWodel.g:3947:3: this_AttributeEvaluation_0= ruleAttributeEvaluation
                    {

                    			newCompositeNode(grammarAccess.getEvaluationAccess().getAttributeEvaluationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeEvaluation_0=ruleAttributeEvaluation();

                    state._fsp--;


                    			current = this_AttributeEvaluation_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:3956:3: this_ReferenceEvaluation_1= ruleReferenceEvaluation
                    {

                    			newCompositeNode(grammarAccess.getEvaluationAccess().getReferenceEvaluationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:3968:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalWodel.g:3968:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalWodel.g:3969:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:3975:1: ruleExpression returns [EObject current=null] : ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_operator_2_0 = null;

        EObject lv_second_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:3981:2: ( ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) )
            // InternalWodel.g:3982:2: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            {
            // InternalWodel.g:3982:2: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            // InternalWodel.g:3983:3: () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            {
            // InternalWodel.g:3983:3: ()
            // InternalWodel.g:3984:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExpressionAccess().getExpressionAction_0(),
            					current);
            			

            }

            // InternalWodel.g:3990:3: ( (lv_first_1_0= ruleEvaluation ) )
            // InternalWodel.g:3991:4: (lv_first_1_0= ruleEvaluation )
            {
            // InternalWodel.g:3991:4: (lv_first_1_0= ruleEvaluation )
            // InternalWodel.g:3992:5: lv_first_1_0= ruleEvaluation
            {

            					newCompositeNode(grammarAccess.getExpressionAccess().getFirstEvaluationParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
            lv_first_1_0=ruleEvaluation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRule());
            					}
            					set(
            						current,
            						"first",
            						lv_first_1_0,
            						"wodel.dsls.Wodel.Evaluation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:4009:3: ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>=43 && LA76_0<=44)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalWodel.g:4010:4: ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) )
            	    {
            	    // InternalWodel.g:4010:4: ( (lv_operator_2_0= ruleBinaryOperator ) )
            	    // InternalWodel.g:4011:5: (lv_operator_2_0= ruleBinaryOperator )
            	    {
            	    // InternalWodel.g:4011:5: (lv_operator_2_0= ruleBinaryOperator )
            	    // InternalWodel.g:4012:6: lv_operator_2_0= ruleBinaryOperator
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getOperatorBinaryOperatorParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_65);
            	    lv_operator_2_0=ruleBinaryOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operator",
            	    							lv_operator_2_0,
            	    							"wodel.dsls.Wodel.BinaryOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalWodel.g:4029:4: ( (lv_second_3_0= ruleEvaluation ) )
            	    // InternalWodel.g:4030:5: (lv_second_3_0= ruleEvaluation )
            	    {
            	    // InternalWodel.g:4030:5: (lv_second_3_0= ruleEvaluation )
            	    // InternalWodel.g:4031:6: lv_second_3_0= ruleEvaluation
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getSecondEvaluationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_64);
            	    lv_second_3_0=ruleEvaluation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"second",
            	    							lv_second_3_0,
            	    							"wodel.dsls.Wodel.Evaluation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
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
    // InternalWodel.g:4053:1: entryRuleRemoveObjectMutator returns [EObject current=null] : iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF ;
    public final EObject entryRuleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveObjectMutator = null;


        try {
            // InternalWodel.g:4053:60: (iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF )
            // InternalWodel.g:4054:2: iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveObjectMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveObjectMutator=ruleRemoveObjectMutator();

            state._fsp--;

             current =iv_ruleRemoveObjectMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4060:1: ruleRemoveObjectMutator returns [EObject current=null] : ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) ;
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
            // InternalWodel.g:4066:2: ( ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) )
            // InternalWodel.g:4067:2: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            {
            // InternalWodel.g:4067:2: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            // InternalWodel.g:4068:3: () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            {
            // InternalWodel.g:4068:3: ()
            // InternalWodel.g:4069:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRemoveObjectMutatorAccess().getRemoveObjectMutatorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,59,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveObjectMutatorAccess().getRemoveKeyword_1());
            		
            // InternalWodel.g:4079:3: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:4080:4: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:4080:4: (lv_object_2_0= ruleObSelectionStrategy )
            // InternalWodel.g:4081:5: lv_object_2_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_67);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_2_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:4098:3: (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==24) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalWodel.g:4099:4: otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getRemoveObjectMutatorAccess().getFromKeyword_3_0());
                    			
                    // InternalWodel.g:4103:4: ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:4104:5: (lv_container_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:4104:5: (lv_container_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:4105:6: lv_container_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_container_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:4123:3: (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==30) ) {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==RULE_INT||LA79_1==53||LA79_1==97) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalWodel.g:4124:4: otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_5, grammarAccess.getRemoveObjectMutatorAccess().getLeftSquareBracketKeyword_4_0());
                    			
                    // InternalWodel.g:4128:4: ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==53) ) {
                        int LA78_1 = input.LA(2);

                        if ( (LA78_1==RULE_INT) ) {
                            int LA78_2 = input.LA(3);

                            if ( (LA78_2==31) ) {
                                alt78=1;
                            }
                        }
                    }
                    else if ( (LA78_0==RULE_INT) ) {
                        int LA78_2 = input.LA(2);

                        if ( (LA78_2==31) ) {
                            alt78=1;
                        }
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalWodel.g:4129:5: ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..'
                            {
                            // InternalWodel.g:4129:5: ( (lv_min_6_0= ruleEInt ) )
                            // InternalWodel.g:4130:6: (lv_min_6_0= ruleEInt )
                            {
                            // InternalWodel.g:4130:6: (lv_min_6_0= ruleEInt )
                            // InternalWodel.g:4131:7: lv_min_6_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMinEIntParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_6_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_6_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_7=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_7, grammarAccess.getRemoveObjectMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:4153:4: ( (lv_max_8_0= ruleMaxCardinality ) )
                    // InternalWodel.g:4154:5: (lv_max_8_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:4154:5: (lv_max_8_0= ruleMaxCardinality )
                    // InternalWodel.g:4155:6: lv_max_8_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_8_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_8_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:4181:1: entryRuleRemoveReferenceMutator returns [EObject current=null] : iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF ;
    public final EObject entryRuleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveReferenceMutator = null;


        try {
            // InternalWodel.g:4181:63: (iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF )
            // InternalWodel.g:4182:2: iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveReferenceMutator=ruleRemoveReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4188:1: ruleRemoveReferenceMutator returns [EObject current=null] : (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) ;
    public final EObject ruleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveRandomReferenceMutator_0 = null;

        EObject this_RemoveSpecificReferenceMutator_1 = null;

        EObject this_RemoveCompleteReferenceMutator_2 = null;



        	enterRule();

        try {
            // InternalWodel.g:4194:2: ( (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) )
            // InternalWodel.g:4195:2: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            {
            // InternalWodel.g:4195:2: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==59) ) {
                switch ( input.LA(2) ) {
                case 60:
                    {
                    alt80=1;
                    }
                    break;
                case 62:
                    {
                    alt80=3;
                    }
                    break;
                case 61:
                    {
                    alt80=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalWodel.g:4196:3: this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveRandomReferenceMutatorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveRandomReferenceMutator_0=ruleRemoveRandomReferenceMutator();

                    state._fsp--;


                    			current = this_RemoveRandomReferenceMutator_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:4205:3: this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveSpecificReferenceMutatorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveSpecificReferenceMutator_1=ruleRemoveSpecificReferenceMutator();

                    state._fsp--;


                    			current = this_RemoveSpecificReferenceMutator_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:4214:3: this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator
                    {

                    			newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveCompleteReferenceMutatorParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:4226:1: entryRuleRemoveRandomReferenceMutator returns [EObject current=null] : iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF ;
    public final EObject entryRuleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveRandomReferenceMutator = null;


        try {
            // InternalWodel.g:4226:69: (iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF )
            // InternalWodel.g:4227:2: iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveRandomReferenceMutator=ruleRemoveRandomReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveRandomReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4233:1: ruleRemoveRandomReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // InternalWodel.g:4239:2: ( ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // InternalWodel.g:4240:2: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // InternalWodel.g:4240:2: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // InternalWodel.g:4241:3: () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            // InternalWodel.g:4241:3: ()
            // InternalWodel.g:4242:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveRandomReferenceMutatorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,59,FOLLOW_68); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveKeyword_1());
            		
            otherlv_2=(Token)match(input,60,FOLLOW_69); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveRandomReferenceMutatorAccess().getOneKeyword_2());
            		
            otherlv_3=(Token)match(input,61,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getRemoveRandomReferenceMutatorAccess().getReferenceKeyword_3());
            		
            // InternalWodel.g:4260:3: ( (otherlv_4= RULE_ID ) )
            // InternalWodel.g:4261:4: (otherlv_4= RULE_ID )
            {
            // InternalWodel.g:4261:4: (otherlv_4= RULE_ID )
            // InternalWodel.g:4262:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_4, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getRemoveRandomReferenceMutatorAccess().getInKeyword_5());
            		
            // InternalWodel.g:4277:3: ( (otherlv_6= RULE_ID ) )
            // InternalWodel.g:4278:4: (otherlv_6= RULE_ID )
            {
            // InternalWodel.g:4278:4: (otherlv_6= RULE_ID )
            // InternalWodel.g:4279:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_6, grammarAccess.getRemoveRandomReferenceMutatorAccess().getTypeEClassCrossReference_6_0());
            				

            }


            }

            // InternalWodel.g:4290:3: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==30) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==RULE_INT||LA82_1==53||LA82_1==97) ) {
                    alt82=1;
                }
            }
            switch (alt82) {
                case 1 :
                    // InternalWodel.g:4291:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_7, grammarAccess.getRemoveRandomReferenceMutatorAccess().getLeftSquareBracketKeyword_7_0());
                    			
                    // InternalWodel.g:4295:4: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==53) ) {
                        int LA81_1 = input.LA(2);

                        if ( (LA81_1==RULE_INT) ) {
                            int LA81_2 = input.LA(3);

                            if ( (LA81_2==31) ) {
                                alt81=1;
                            }
                        }
                    }
                    else if ( (LA81_0==RULE_INT) ) {
                        int LA81_2 = input.LA(2);

                        if ( (LA81_2==31) ) {
                            alt81=1;
                        }
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalWodel.g:4296:5: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // InternalWodel.g:4296:5: ( (lv_min_8_0= ruleEInt ) )
                            // InternalWodel.g:4297:6: (lv_min_8_0= ruleEInt )
                            {
                            // InternalWodel.g:4297:6: (lv_min_8_0= ruleEInt )
                            // InternalWodel.g:4298:7: lv_min_8_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMinEIntParserRuleCall_7_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_8_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_9=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_9, grammarAccess.getRemoveRandomReferenceMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:4320:4: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // InternalWodel.g:4321:5: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:4321:5: (lv_max_10_0= ruleMaxCardinality )
                    // InternalWodel.g:4322:6: lv_max_10_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_10_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:4348:1: entryRuleRemoveSpecificReferenceMutator returns [EObject current=null] : iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF ;
    public final EObject entryRuleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveSpecificReferenceMutator = null;


        try {
            // InternalWodel.g:4348:71: (iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF )
            // InternalWodel.g:4349:2: iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveSpecificReferenceMutator=ruleRemoveSpecificReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveSpecificReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4355:1: ruleRemoveSpecificReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
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
            // InternalWodel.g:4361:2: ( ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // InternalWodel.g:4362:2: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // InternalWodel.g:4362:2: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // InternalWodel.g:4363:3: () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // InternalWodel.g:4363:3: ()
            // InternalWodel.g:4364:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveSpecificReferenceMutatorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,59,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveKeyword_1());
            		
            otherlv_2=(Token)match(input,61,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getReferenceKeyword_2());
            		
            // InternalWodel.g:4378:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:4379:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:4379:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:4380:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_3, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_66); 

            			newLeafNode(otherlv_4, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getInKeyword_4());
            		
            // InternalWodel.g:4395:3: ( (lv_container_5_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:4396:4: (lv_container_5_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:4396:4: (lv_container_5_0= ruleObSelectionStrategy )
            // InternalWodel.g:4397:5: lv_container_5_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getContainerObSelectionStrategyParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_30);
            lv_container_5_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            					}
            					set(
            						current,
            						"container",
            						lv_container_5_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:4414:3: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==30) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_INT||LA84_1==53||LA84_1==97) ) {
                    alt84=1;
                }
            }
            switch (alt84) {
                case 1 :
                    // InternalWodel.g:4415:4: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_6, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                    			
                    // InternalWodel.g:4419:4: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==53) ) {
                        int LA83_1 = input.LA(2);

                        if ( (LA83_1==RULE_INT) ) {
                            int LA83_2 = input.LA(3);

                            if ( (LA83_2==31) ) {
                                alt83=1;
                            }
                        }
                    }
                    else if ( (LA83_0==RULE_INT) ) {
                        int LA83_2 = input.LA(2);

                        if ( (LA83_2==31) ) {
                            alt83=1;
                        }
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalWodel.g:4420:5: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // InternalWodel.g:4420:5: ( (lv_min_7_0= ruleEInt ) )
                            // InternalWodel.g:4421:6: (lv_min_7_0= ruleEInt )
                            {
                            // InternalWodel.g:4421:6: (lv_min_7_0= ruleEInt )
                            // InternalWodel.g:4422:7: lv_min_7_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_7_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_8=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_8, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:4444:4: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // InternalWodel.g:4445:5: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:4445:5: (lv_max_9_0= ruleMaxCardinality )
                    // InternalWodel.g:4446:6: lv_max_9_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_9_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_9_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:4472:1: entryRuleRemoveCompleteReferenceMutator returns [EObject current=null] : iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF ;
    public final EObject entryRuleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveCompleteReferenceMutator = null;


        try {
            // InternalWodel.g:4472:71: (iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF )
            // InternalWodel.g:4473:2: iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveCompleteReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveCompleteReferenceMutator=ruleRemoveCompleteReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveCompleteReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4479:1: ruleRemoveCompleteReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) ;
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
            // InternalWodel.g:4485:2: ( ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalWodel.g:4486:2: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalWodel.g:4486:2: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            // InternalWodel.g:4487:3: () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) )
            {
            // InternalWodel.g:4487:3: ()
            // InternalWodel.g:4488:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveCompleteReferenceMutatorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,59,FOLLOW_70); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveKeyword_1());
            		
            otherlv_2=(Token)match(input,62,FOLLOW_69); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getAllKeyword_2());
            		
            otherlv_3=(Token)match(input,61,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getReferenceKeyword_3());
            		
            // InternalWodel.g:4506:3: ( (otherlv_4= RULE_ID ) )
            // InternalWodel.g:4507:4: (otherlv_4= RULE_ID )
            {
            // InternalWodel.g:4507:4: (otherlv_4= RULE_ID )
            // InternalWodel.g:4508:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_4, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getInKeyword_5());
            		
            // InternalWodel.g:4523:3: ( (otherlv_6= RULE_ID ) )
            // InternalWodel.g:4524:4: (otherlv_6= RULE_ID )
            {
            // InternalWodel.g:4524:4: (otherlv_6= RULE_ID )
            // InternalWodel.g:4525:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalWodel.g:4540:1: entryRuleCreateObjectMutator returns [EObject current=null] : iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF ;
    public final EObject entryRuleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateObjectMutator = null;


        try {
            // InternalWodel.g:4540:60: (iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF )
            // InternalWodel.g:4541:2: iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateObjectMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCreateObjectMutator=ruleCreateObjectMutator();

            state._fsp--;

             current =iv_ruleCreateObjectMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4547:1: ruleCreateObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) ;
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
            // InternalWodel.g:4553:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) )
            // InternalWodel.g:4554:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            {
            // InternalWodel.g:4554:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            // InternalWodel.g:4555:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            {
            // InternalWodel.g:4555:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_ID) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalWodel.g:4556:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:4556:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:4557:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:4557:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:4558:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getCreateObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_71); 

                    				newLeafNode(otherlv_1, grammarAccess.getCreateObjectMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,63,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getCreateObjectMutatorAccess().getCreateKeyword_1());
            		
            // InternalWodel.g:4583:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:4584:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:4584:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:4585:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_72); 

            					newLeafNode(otherlv_3, grammarAccess.getCreateObjectMutatorAccess().getTypeEClassCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:4596:3: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==23) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalWodel.g:4597:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_66); 

                    				newLeafNode(otherlv_4, grammarAccess.getCreateObjectMutatorAccess().getInKeyword_3_0());
                    			
                    // InternalWodel.g:4601:4: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:4602:5: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:4602:5: (lv_container_5_0= ruleObSelectionStrategy )
                    // InternalWodel.g:4603:6: lv_container_5_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_5_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:4621:3: (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==11) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalWodel.g:4622:4: otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}'
                    {
                    otherlv_6=(Token)match(input,11,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0());
                    			
                    otherlv_7=(Token)match(input,13,FOLLOW_74); 

                    				newLeafNode(otherlv_7, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalWodel.g:4630:4: ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )?
                    int alt87=3;
                    alt87 = dfa87.predict(input);
                    switch (alt87) {
                        case 1 :
                            // InternalWodel.g:4631:5: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            {
                            // InternalWodel.g:4631:5: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            // InternalWodel.g:4632:6: (lv_attributes_8_0= ruleAttributeSet )
                            {
                            // InternalWodel.g:4632:6: (lv_attributes_8_0= ruleAttributeSet )
                            // InternalWodel.g:4633:7: lv_attributes_8_0= ruleAttributeSet
                            {

                            							newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_2_0_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_attributes_8_0=ruleAttributeSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_8_0,
                            								"wodel.dsls.Wodel.AttributeSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:4651:5: ( (lv_references_9_0= ruleReferenceSet ) )
                            {
                            // InternalWodel.g:4651:5: ( (lv_references_9_0= ruleReferenceSet ) )
                            // InternalWodel.g:4652:6: (lv_references_9_0= ruleReferenceSet )
                            {
                            // InternalWodel.g:4652:6: (lv_references_9_0= ruleReferenceSet )
                            // InternalWodel.g:4653:7: lv_references_9_0= ruleReferenceSet
                            {

                            							newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_2_1_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_references_9_0=ruleReferenceSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"references",
                            								lv_references_9_0,
                            								"wodel.dsls.Wodel.ReferenceSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalWodel.g:4671:4: (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==26) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // InternalWodel.g:4672:5: otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_10=(Token)match(input,26,FOLLOW_76); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getCreateObjectMutatorAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalWodel.g:4676:5: ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    int alt88=2;
                    	    alt88 = dfa88.predict(input);
                    	    switch (alt88) {
                    	        case 1 :
                    	            // InternalWodel.g:4677:6: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            {
                    	            // InternalWodel.g:4677:6: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            // InternalWodel.g:4678:7: (lv_attributes_11_0= ruleAttributeSet )
                    	            {
                    	            // InternalWodel.g:4678:7: (lv_attributes_11_0= ruleAttributeSet )
                    	            // InternalWodel.g:4679:8: lv_attributes_11_0= ruleAttributeSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_attributes_11_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"attributes",
                    	            									lv_attributes_11_0,
                    	            									"wodel.dsls.Wodel.AttributeSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalWodel.g:4697:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            {
                    	            // InternalWodel.g:4697:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            // InternalWodel.g:4698:7: (lv_references_12_0= ruleReferenceSet )
                    	            {
                    	            // InternalWodel.g:4698:7: (lv_references_12_0= ruleReferenceSet )
                    	            // InternalWodel.g:4699:8: lv_references_12_0= ruleReferenceSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_3_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_references_12_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"references",
                    	            									lv_references_12_0,
                    	            									"wodel.dsls.Wodel.ReferenceSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,14,FOLLOW_30); 

                    				newLeafNode(otherlv_13, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalWodel.g:4723:3: (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==30) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==RULE_INT||LA92_1==53||LA92_1==97) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // InternalWodel.g:4724:4: otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']'
                    {
                    otherlv_14=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_14, grammarAccess.getCreateObjectMutatorAccess().getLeftSquareBracketKeyword_5_0());
                    			
                    // InternalWodel.g:4728:4: ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==53) ) {
                        int LA91_1 = input.LA(2);

                        if ( (LA91_1==RULE_INT) ) {
                            int LA91_2 = input.LA(3);

                            if ( (LA91_2==31) ) {
                                alt91=1;
                            }
                        }
                    }
                    else if ( (LA91_0==RULE_INT) ) {
                        int LA91_2 = input.LA(2);

                        if ( (LA91_2==31) ) {
                            alt91=1;
                        }
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalWodel.g:4729:5: ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..'
                            {
                            // InternalWodel.g:4729:5: ( (lv_min_15_0= ruleEInt ) )
                            // InternalWodel.g:4730:6: (lv_min_15_0= ruleEInt )
                            {
                            // InternalWodel.g:4730:6: (lv_min_15_0= ruleEInt )
                            // InternalWodel.g:4731:7: lv_min_15_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMinEIntParserRuleCall_5_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_15_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_15_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_16=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_16, grammarAccess.getCreateObjectMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:4753:4: ( (lv_max_17_0= ruleMaxCardinality ) )
                    // InternalWodel.g:4754:5: (lv_max_17_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:4754:5: (lv_max_17_0= ruleMaxCardinality )
                    // InternalWodel.g:4755:6: lv_max_17_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_17_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_17_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:4781:1: entryRuleSelectObjectMutator returns [EObject current=null] : iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF ;
    public final EObject entryRuleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectObjectMutator = null;


        try {
            // InternalWodel.g:4781:60: (iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF )
            // InternalWodel.g:4782:2: iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectObjectMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectObjectMutator=ruleSelectObjectMutator();

            state._fsp--;

             current =iv_ruleSelectObjectMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4788:1: ruleSelectObjectMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) ;
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
            // InternalWodel.g:4794:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) )
            // InternalWodel.g:4795:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            {
            // InternalWodel.g:4795:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            // InternalWodel.g:4796:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            {
            // InternalWodel.g:4796:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalWodel.g:4797:4: (lv_name_0_0= RULE_ID )
            {
            // InternalWodel.g:4797:4: (lv_name_0_0= RULE_ID )
            // InternalWodel.g:4798:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_0_0, grammarAccess.getSelectObjectMutatorAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSelectObjectMutatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectObjectMutatorAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,64,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getSelectObjectMutatorAccess().getSelectKeyword_2());
            		
            // InternalWodel.g:4822:3: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:4823:4: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:4823:4: (lv_object_3_0= ruleObSelectionStrategy )
            // InternalWodel.g:4824:5: lv_object_3_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_78);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_3_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:4841:3: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==23) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalWodel.g:4842:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_66); 

                    				newLeafNode(otherlv_4, grammarAccess.getSelectObjectMutatorAccess().getInKeyword_4_0());
                    			
                    // InternalWodel.g:4846:4: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:4847:5: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:4847:5: (lv_container_5_0= ruleObSelectionStrategy )
                    // InternalWodel.g:4848:6: lv_container_5_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_5_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
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
    // InternalWodel.g:4870:1: entryRuleSelectSampleMutator returns [EObject current=null] : iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF ;
    public final EObject entryRuleSelectSampleMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectSampleMutator = null;


        try {
            // InternalWodel.g:4870:60: (iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF )
            // InternalWodel.g:4871:2: iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectSampleMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectSampleMutator=ruleSelectSampleMutator();

            state._fsp--;

             current =iv_ruleSelectSampleMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:4877:1: ruleSelectSampleMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? ) ;
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
            // InternalWodel.g:4883:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? ) )
            // InternalWodel.g:4884:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? )
            {
            // InternalWodel.g:4884:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? )
            // InternalWodel.g:4885:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )?
            {
            // InternalWodel.g:4885:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalWodel.g:4886:4: (lv_name_0_0= RULE_ID )
            {
            // InternalWodel.g:4886:4: (lv_name_0_0= RULE_ID )
            // InternalWodel.g:4887:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_0_0, grammarAccess.getSelectSampleMutatorAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectSampleMutatorAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,64,FOLLOW_79); 

            			newLeafNode(otherlv_2, grammarAccess.getSelectSampleMutatorAccess().getSelectKeyword_2());
            		
            otherlv_3=(Token)match(input,65,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectSampleMutatorAccess().getSampleKeyword_3());
            		
            otherlv_4=(Token)match(input,24,FOLLOW_66); 

            			newLeafNode(otherlv_4, grammarAccess.getSelectSampleMutatorAccess().getFromKeyword_4());
            		
            // InternalWodel.g:4919:3: ( (lv_object_5_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:4920:4: (lv_object_5_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:4920:4: (lv_object_5_0= ruleObSelectionStrategy )
            // InternalWodel.g:4921:5: lv_object_5_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getSelectSampleMutatorAccess().getObjectObSelectionStrategyParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_80);
            lv_object_5_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectSampleMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_5_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:4938:3: (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==11) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalWodel.g:4939:4: otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}'
                    {
                    otherlv_6=(Token)match(input,11,FOLLOW_81); 

                    				newLeafNode(otherlv_6, grammarAccess.getSelectSampleMutatorAccess().getWithKeyword_6_0());
                    			
                    // InternalWodel.g:4943:4: ( (lv_clause_7_0= ruleSampleClause ) )
                    // InternalWodel.g:4944:5: (lv_clause_7_0= ruleSampleClause )
                    {
                    // InternalWodel.g:4944:5: (lv_clause_7_0= ruleSampleClause )
                    // InternalWodel.g:4945:6: lv_clause_7_0= ruleSampleClause
                    {

                    						newCompositeNode(grammarAccess.getSelectSampleMutatorAccess().getClauseSampleClauseEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_clause_7_0=ruleSampleClause();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSelectSampleMutatorRule());
                    						}
                    						set(
                    							current,
                    							"clause",
                    							lv_clause_7_0,
                    							"wodel.dsls.Wodel.SampleClause");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,13,FOLLOW_82); 

                    				newLeafNode(otherlv_8, grammarAccess.getSelectSampleMutatorAccess().getLeftCurlyBracketKeyword_6_2());
                    			
                    // InternalWodel.g:4966:4: ( (otherlv_9= RULE_ID ) )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==RULE_ID) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // InternalWodel.g:4967:5: (otherlv_9= RULE_ID )
                            {
                            // InternalWodel.g:4967:5: (otherlv_9= RULE_ID )
                            // InternalWodel.g:4968:6: otherlv_9= RULE_ID
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
                            						}
                            					
                            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_75); 

                            						newLeafNode(otherlv_9, grammarAccess.getSelectSampleMutatorAccess().getFeaturesEStructuralFeatureCrossReference_6_3_0());
                            					

                            }


                            }
                            break;

                    }

                    // InternalWodel.g:4979:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==26) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalWodel.g:4980:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,26,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getSelectSampleMutatorAccess().getCommaKeyword_6_4_0());
                    	    				
                    	    // InternalWodel.g:4984:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalWodel.g:4985:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalWodel.g:4985:6: (otherlv_11= RULE_ID )
                    	    // InternalWodel.g:4986:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_75); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getSelectSampleMutatorAccess().getFeaturesEStructuralFeatureCrossReference_6_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,14,FOLLOW_2); 

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
    // InternalWodel.g:5007:1: entryRuleModifyInformationMutator returns [EObject current=null] : iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF ;
    public final EObject entryRuleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyInformationMutator = null;


        try {
            // InternalWodel.g:5007:65: (iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF )
            // InternalWodel.g:5008:2: iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyInformationMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifyInformationMutator=ruleModifyInformationMutator();

            state._fsp--;

             current =iv_ruleModifyInformationMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5014:1: ruleModifyInformationMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) ;
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
            // InternalWodel.g:5020:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) )
            // InternalWodel.g:5021:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            {
            // InternalWodel.g:5021:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            // InternalWodel.g:5022:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            {
            // InternalWodel.g:5022:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_ID) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalWodel.g:5023:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:5023:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:5024:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:5024:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:5025:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getModifyInformationMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModifyInformationMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_83); 

                    				newLeafNode(otherlv_1, grammarAccess.getModifyInformationMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,66,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getModifyInformationMutatorAccess().getModifyKeyword_1());
            		
            // InternalWodel.g:5050:3: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:5051:4: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:5051:4: (lv_object_3_0= ruleObSelectionStrategy )
            // InternalWodel.g:5052:5: lv_object_3_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_73);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_3_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:5069:3: (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==11) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalWodel.g:5070:4: otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,11,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0());
                    			
                    otherlv_5=(Token)match(input,13,FOLLOW_74); 

                    				newLeafNode(otherlv_5, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalWodel.g:5078:4: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?
                    int alt98=3;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            // InternalWodel.g:5079:5: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            {
                            // InternalWodel.g:5079:5: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            // InternalWodel.g:5080:6: (lv_attributes_6_0= ruleAttributeSet )
                            {
                            // InternalWodel.g:5080:6: (lv_attributes_6_0= ruleAttributeSet )
                            // InternalWodel.g:5081:7: lv_attributes_6_0= ruleAttributeSet
                            {

                            							newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_2_0_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_attributes_6_0=ruleAttributeSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_6_0,
                            								"wodel.dsls.Wodel.AttributeSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:5099:5: ( (lv_references_7_0= ruleReferenceSet ) )
                            {
                            // InternalWodel.g:5099:5: ( (lv_references_7_0= ruleReferenceSet ) )
                            // InternalWodel.g:5100:6: (lv_references_7_0= ruleReferenceSet )
                            {
                            // InternalWodel.g:5100:6: (lv_references_7_0= ruleReferenceSet )
                            // InternalWodel.g:5101:7: lv_references_7_0= ruleReferenceSet
                            {

                            							newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_2_1_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_references_7_0=ruleReferenceSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            							}
                            							add(
                            								current,
                            								"references",
                            								lv_references_7_0,
                            								"wodel.dsls.Wodel.ReferenceSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalWodel.g:5119:4: (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==26) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalWodel.g:5120:5: otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_8=(Token)match(input,26,FOLLOW_76); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getModifyInformationMutatorAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalWodel.g:5124:5: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    int alt99=2;
                    	    alt99 = dfa99.predict(input);
                    	    switch (alt99) {
                    	        case 1 :
                    	            // InternalWodel.g:5125:6: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            {
                    	            // InternalWodel.g:5125:6: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            // InternalWodel.g:5126:7: (lv_attributes_9_0= ruleAttributeSet )
                    	            {
                    	            // InternalWodel.g:5126:7: (lv_attributes_9_0= ruleAttributeSet )
                    	            // InternalWodel.g:5127:8: lv_attributes_9_0= ruleAttributeSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_attributes_9_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"attributes",
                    	            									lv_attributes_9_0,
                    	            									"wodel.dsls.Wodel.AttributeSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalWodel.g:5145:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            {
                    	            // InternalWodel.g:5145:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            // InternalWodel.g:5146:7: (lv_references_10_0= ruleReferenceSet )
                    	            {
                    	            // InternalWodel.g:5146:7: (lv_references_10_0= ruleReferenceSet )
                    	            // InternalWodel.g:5147:8: lv_references_10_0= ruleReferenceSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_3_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_references_10_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"references",
                    	            									lv_references_10_0,
                    	            									"wodel.dsls.Wodel.ReferenceSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop100;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FOLLOW_30); 

                    				newLeafNode(otherlv_11, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalWodel.g:5171:3: (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==30) ) {
                int LA103_1 = input.LA(2);

                if ( (LA103_1==RULE_INT||LA103_1==53||LA103_1==97) ) {
                    alt103=1;
                }
            }
            switch (alt103) {
                case 1 :
                    // InternalWodel.g:5172:4: otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_12, grammarAccess.getModifyInformationMutatorAccess().getLeftSquareBracketKeyword_4_0());
                    			
                    // InternalWodel.g:5176:4: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )?
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==53) ) {
                        int LA102_1 = input.LA(2);

                        if ( (LA102_1==RULE_INT) ) {
                            int LA102_2 = input.LA(3);

                            if ( (LA102_2==31) ) {
                                alt102=1;
                            }
                        }
                    }
                    else if ( (LA102_0==RULE_INT) ) {
                        int LA102_2 = input.LA(2);

                        if ( (LA102_2==31) ) {
                            alt102=1;
                        }
                    }
                    switch (alt102) {
                        case 1 :
                            // InternalWodel.g:5177:5: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..'
                            {
                            // InternalWodel.g:5177:5: ( (lv_min_13_0= ruleEInt ) )
                            // InternalWodel.g:5178:6: (lv_min_13_0= ruleEInt )
                            {
                            // InternalWodel.g:5178:6: (lv_min_13_0= ruleEInt )
                            // InternalWodel.g:5179:7: lv_min_13_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMinEIntParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_13_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_13_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_14=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_14, grammarAccess.getModifyInformationMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:5201:4: ( (lv_max_15_0= ruleMaxCardinality ) )
                    // InternalWodel.g:5202:5: (lv_max_15_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:5202:5: (lv_max_15_0= ruleMaxCardinality )
                    // InternalWodel.g:5203:6: lv_max_15_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_15_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_15_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:5229:1: entryRuleCreateReferenceMutator returns [EObject current=null] : iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF ;
    public final EObject entryRuleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateReferenceMutator = null;


        try {
            // InternalWodel.g:5229:63: (iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF )
            // InternalWodel.g:5230:2: iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCreateReferenceMutator=ruleCreateReferenceMutator();

            state._fsp--;

             current =iv_ruleCreateReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5236:1: ruleCreateReferenceMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) ;
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
            // InternalWodel.g:5242:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) )
            // InternalWodel.g:5243:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            {
            // InternalWodel.g:5243:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            // InternalWodel.g:5244:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            {
            // InternalWodel.g:5244:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_ID) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalWodel.g:5245:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:5245:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:5246:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:5246:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:5247:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getCreateReferenceMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_71); 

                    				newLeafNode(otherlv_1, grammarAccess.getCreateReferenceMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,63,FOLLOW_69); 

            			newLeafNode(otherlv_2, grammarAccess.getCreateReferenceMutatorAccess().getCreateKeyword_1());
            		
            otherlv_3=(Token)match(input,61,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getCreateReferenceMutatorAccess().getReferenceKeyword_2());
            		
            // InternalWodel.g:5276:3: ( (otherlv_4= RULE_ID ) )
            // InternalWodel.g:5277:4: (otherlv_4= RULE_ID )
            {
            // InternalWodel.g:5277:4: (otherlv_4= RULE_ID )
            // InternalWodel.g:5278:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_84); 

            					newLeafNode(otherlv_4, grammarAccess.getCreateReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0());
            				

            }


            }

            // InternalWodel.g:5289:3: (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==67) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalWodel.g:5290:4: otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getCreateReferenceMutatorAccess().getToKeyword_4_0());
                    			
                    // InternalWodel.g:5294:4: ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5295:5: (lv_target_6_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5295:5: (lv_target_6_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5296:6: lv_target_6_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getTargetObSelectionStrategyParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_85);
                    lv_target_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"target",
                    							lv_target_6_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5314:3: (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==23) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalWodel.g:5315:4: otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_66); 

                    				newLeafNode(otherlv_7, grammarAccess.getCreateReferenceMutatorAccess().getInKeyword_5_0());
                    			
                    // InternalWodel.g:5319:4: ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5320:5: (lv_source_8_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5320:5: (lv_source_8_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5321:6: lv_source_8_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_source_8_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"source",
                    							lv_source_8_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5339:3: (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==30) ) {
                int LA108_1 = input.LA(2);

                if ( (LA108_1==RULE_INT||LA108_1==53||LA108_1==97) ) {
                    alt108=1;
                }
            }
            switch (alt108) {
                case 1 :
                    // InternalWodel.g:5340:4: otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']'
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_9, grammarAccess.getCreateReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                    			
                    // InternalWodel.g:5344:4: ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==53) ) {
                        int LA107_1 = input.LA(2);

                        if ( (LA107_1==RULE_INT) ) {
                            int LA107_2 = input.LA(3);

                            if ( (LA107_2==31) ) {
                                alt107=1;
                            }
                        }
                    }
                    else if ( (LA107_0==RULE_INT) ) {
                        int LA107_2 = input.LA(2);

                        if ( (LA107_2==31) ) {
                            alt107=1;
                        }
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalWodel.g:5345:5: ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..'
                            {
                            // InternalWodel.g:5345:5: ( (lv_min_10_0= ruleEInt ) )
                            // InternalWodel.g:5346:6: (lv_min_10_0= ruleEInt )
                            {
                            // InternalWodel.g:5346:6: (lv_min_10_0= ruleEInt )
                            // InternalWodel.g:5347:7: lv_min_10_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_10_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_10_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_11=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_11, grammarAccess.getCreateReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:5369:4: ( (lv_max_12_0= ruleMaxCardinality ) )
                    // InternalWodel.g:5370:5: (lv_max_12_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:5370:5: (lv_max_12_0= ruleMaxCardinality )
                    // InternalWodel.g:5371:6: lv_max_12_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_12_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_12_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:5397:1: entryRuleModifySourceReferenceMutator returns [EObject current=null] : iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF ;
    public final EObject entryRuleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifySourceReferenceMutator = null;


        try {
            // InternalWodel.g:5397:69: (iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF )
            // InternalWodel.g:5398:2: iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifySourceReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifySourceReferenceMutator=ruleModifySourceReferenceMutator();

            state._fsp--;

             current =iv_ruleModifySourceReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5404:1: ruleModifySourceReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // InternalWodel.g:5410:2: ( (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // InternalWodel.g:5411:2: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // InternalWodel.g:5411:2: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // InternalWodel.g:5412:3: otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,66,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getModifySourceReferenceMutatorAccess().getModifyKeyword_0());
            		
            otherlv_1=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getModifySourceReferenceMutatorAccess().getSourceKeyword_1());
            		
            // InternalWodel.g:5420:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:5421:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:5421:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:5422:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModifySourceReferenceMutatorRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_87); 

            					newLeafNode(otherlv_2, grammarAccess.getModifySourceReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:5433:3: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==24) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalWodel.g:5434:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getModifySourceReferenceMutatorAccess().getFromKeyword_3_0());
                    			
                    // InternalWodel.g:5438:4: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5439:5: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5439:5: (lv_source_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5440:6: lv_source_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_88);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"source",
                    							lv_source_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5458:3: (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==67) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalWodel.g:5459:4: otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getModifySourceReferenceMutatorAccess().getToKeyword_4_0());
                    			
                    // InternalWodel.g:5463:4: ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5464:5: (lv_newSource_6_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5464:5: (lv_newSource_6_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5465:6: lv_newSource_6_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getNewSourceObSelectionStrategyParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_newSource_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"newSource",
                    							lv_newSource_6_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5483:3: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==30) ) {
                int LA112_1 = input.LA(2);

                if ( (LA112_1==RULE_INT||LA112_1==53||LA112_1==97) ) {
                    alt112=1;
                }
            }
            switch (alt112) {
                case 1 :
                    // InternalWodel.g:5484:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_7, grammarAccess.getModifySourceReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                    			
                    // InternalWodel.g:5488:4: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==53) ) {
                        int LA111_1 = input.LA(2);

                        if ( (LA111_1==RULE_INT) ) {
                            int LA111_2 = input.LA(3);

                            if ( (LA111_2==31) ) {
                                alt111=1;
                            }
                        }
                    }
                    else if ( (LA111_0==RULE_INT) ) {
                        int LA111_2 = input.LA(2);

                        if ( (LA111_2==31) ) {
                            alt111=1;
                        }
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalWodel.g:5489:5: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // InternalWodel.g:5489:5: ( (lv_min_8_0= ruleEInt ) )
                            // InternalWodel.g:5490:6: (lv_min_8_0= ruleEInt )
                            {
                            // InternalWodel.g:5490:6: (lv_min_8_0= ruleEInt )
                            // InternalWodel.g:5491:7: lv_min_8_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_8_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_9=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_9, grammarAccess.getModifySourceReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:5513:4: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // InternalWodel.g:5514:5: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:5514:5: (lv_max_10_0= ruleMaxCardinality )
                    // InternalWodel.g:5515:6: lv_max_10_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_10_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:5541:1: entryRuleModifyTargetReferenceMutator returns [EObject current=null] : iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF ;
    public final EObject entryRuleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyTargetReferenceMutator = null;


        try {
            // InternalWodel.g:5541:69: (iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF )
            // InternalWodel.g:5542:2: iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifyTargetReferenceMutator=ruleModifyTargetReferenceMutator();

            state._fsp--;

             current =iv_ruleModifyTargetReferenceMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5548:1: ruleModifyTargetReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // InternalWodel.g:5554:2: ( (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // InternalWodel.g:5555:2: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // InternalWodel.g:5555:2: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // InternalWodel.g:5556:3: otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,66,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getModifyTargetReferenceMutatorAccess().getModifyKeyword_0());
            		
            otherlv_1=(Token)match(input,69,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getModifyTargetReferenceMutatorAccess().getTargetKeyword_1());
            		
            // InternalWodel.g:5564:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:5565:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:5565:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:5566:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModifyTargetReferenceMutatorRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_87); 

            					newLeafNode(otherlv_2, grammarAccess.getModifyTargetReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:5577:3: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==24) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalWodel.g:5578:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getModifyTargetReferenceMutatorAccess().getFromKeyword_3_0());
                    			
                    // InternalWodel.g:5582:4: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5583:5: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5583:5: (lv_source_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5584:6: lv_source_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_88);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"source",
                    							lv_source_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5602:3: (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==67) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalWodel.g:5603:4: otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getModifyTargetReferenceMutatorAccess().getToKeyword_4_0());
                    			
                    // InternalWodel.g:5607:4: ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5608:5: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5608:5: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5609:6: lv_newTarget_6_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getNewTargetObSelectionStrategyParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_newTarget_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"newTarget",
                    							lv_newTarget_6_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5627:3: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==30) ) {
                int LA116_1 = input.LA(2);

                if ( (LA116_1==RULE_INT||LA116_1==53||LA116_1==97) ) {
                    alt116=1;
                }
            }
            switch (alt116) {
                case 1 :
                    // InternalWodel.g:5628:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_7, grammarAccess.getModifyTargetReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                    			
                    // InternalWodel.g:5632:4: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==53) ) {
                        int LA115_1 = input.LA(2);

                        if ( (LA115_1==RULE_INT) ) {
                            int LA115_2 = input.LA(3);

                            if ( (LA115_2==31) ) {
                                alt115=1;
                            }
                        }
                    }
                    else if ( (LA115_0==RULE_INT) ) {
                        int LA115_2 = input.LA(2);

                        if ( (LA115_2==31) ) {
                            alt115=1;
                        }
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalWodel.g:5633:5: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // InternalWodel.g:5633:5: ( (lv_min_8_0= ruleEInt ) )
                            // InternalWodel.g:5634:6: (lv_min_8_0= ruleEInt )
                            {
                            // InternalWodel.g:5634:6: (lv_min_8_0= ruleEInt )
                            // InternalWodel.g:5635:7: lv_min_8_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_8_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_9=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_9, grammarAccess.getModifyTargetReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:5657:4: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // InternalWodel.g:5658:5: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:5658:5: (lv_max_10_0= ruleMaxCardinality )
                    // InternalWodel.g:5659:6: lv_max_10_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_10_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:5685:1: entryRuleCompositeMutator returns [EObject current=null] : iv_ruleCompositeMutator= ruleCompositeMutator EOF ;
    public final EObject entryRuleCompositeMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeMutator = null;


        try {
            // InternalWodel.g:5685:57: (iv_ruleCompositeMutator= ruleCompositeMutator EOF )
            // InternalWodel.g:5686:2: iv_ruleCompositeMutator= ruleCompositeMutator EOF
            {
             newCompositeNode(grammarAccess.getCompositeMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompositeMutator=ruleCompositeMutator();

            state._fsp--;

             current =iv_ruleCompositeMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5692:1: ruleCompositeMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) ;
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
            // InternalWodel.g:5698:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) )
            // InternalWodel.g:5699:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            {
            // InternalWodel.g:5699:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            // InternalWodel.g:5700:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            {
            // InternalWodel.g:5700:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==RULE_ID) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalWodel.g:5701:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:5701:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:5702:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:5702:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:5703:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getCompositeMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCompositeMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_90); 

                    				newLeafNode(otherlv_1, grammarAccess.getCompositeMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalWodel.g:5728:3: ( (lv_commands_3_0= ruleMutator ) )
            // InternalWodel.g:5729:4: (lv_commands_3_0= ruleMutator )
            {
            // InternalWodel.g:5729:4: (lv_commands_3_0= ruleMutator )
            // InternalWodel.g:5730:5: lv_commands_3_0= ruleMutator
            {

            					newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_91);
            lv_commands_3_0=ruleMutator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            					}
            					add(
            						current,
            						"commands",
            						lv_commands_3_0,
            						"wodel.dsls.Wodel.Mutator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:5747:3: ( (lv_commands_4_0= ruleMutator ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==RULE_ID||LA118_0==30||LA118_0==59||LA118_0==63||LA118_0==66||(LA118_0>=70 && LA118_0<=72)) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalWodel.g:5748:4: (lv_commands_4_0= ruleMutator )
            	    {
            	    // InternalWodel.g:5748:4: (lv_commands_4_0= ruleMutator )
            	    // InternalWodel.g:5749:5: lv_commands_4_0= ruleMutator
            	    {

            	    					newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_91);
            	    lv_commands_4_0=ruleMutator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_4_0,
            	    						"wodel.dsls.Wodel.Mutator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);

            otherlv_5=(Token)match(input,32,FOLLOW_30); 

            			newLeafNode(otherlv_5, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_4());
            		
            // InternalWodel.g:5770:3: (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==30) ) {
                int LA120_1 = input.LA(2);

                if ( (LA120_1==RULE_INT||LA120_1==53) ) {
                    alt120=1;
                }
            }
            switch (alt120) {
                case 1 :
                    // InternalWodel.g:5771:4: otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']'
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_31); 

                    				newLeafNode(otherlv_6, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_5_0());
                    			
                    // InternalWodel.g:5775:4: ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) )
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==53) ) {
                        int LA119_1 = input.LA(2);

                        if ( (LA119_1==RULE_INT) ) {
                            int LA119_2 = input.LA(3);

                            if ( (LA119_2==31) ) {
                                alt119=1;
                            }
                            else if ( (LA119_2==32) ) {
                                alt119=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 119, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 119, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA119_0==RULE_INT) ) {
                        int LA119_2 = input.LA(2);

                        if ( (LA119_2==31) ) {
                            alt119=1;
                        }
                        else if ( (LA119_2==32) ) {
                            alt119=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 119, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 119, 0, input);

                        throw nvae;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalWodel.g:5776:5: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            {
                            // InternalWodel.g:5776:5: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            // InternalWodel.g:5777:6: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) )
                            {
                            // InternalWodel.g:5777:6: ( (lv_min_7_0= ruleEInt ) )
                            // InternalWodel.g:5778:7: (lv_min_7_0= ruleEInt )
                            {
                            // InternalWodel.g:5778:7: (lv_min_7_0= ruleEInt )
                            // InternalWodel.g:5779:8: lv_min_7_0= ruleEInt
                            {

                            								newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMinEIntParserRuleCall_5_1_0_0_0());
                            							
                            pushFollow(FOLLOW_32);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            								}
                            								set(
                            									current,
                            									"min",
                            									lv_min_7_0,
                            									"wodel.dsls.Wodel.EInt");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            otherlv_8=(Token)match(input,31,FOLLOW_33); 

                            						newLeafNode(otherlv_8, grammarAccess.getCompositeMutatorAccess().getFullStopFullStopKeyword_5_1_0_1());
                            					
                            // InternalWodel.g:5800:6: ( (lv_max_9_0= ruleMaxCardinality ) )
                            // InternalWodel.g:5801:7: (lv_max_9_0= ruleMaxCardinality )
                            {
                            // InternalWodel.g:5801:7: (lv_max_9_0= ruleMaxCardinality )
                            // InternalWodel.g:5802:8: lv_max_9_0= ruleMaxCardinality
                            {

                            								newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_1_0_2_0());
                            							
                            pushFollow(FOLLOW_34);
                            lv_max_9_0=ruleMaxCardinality();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            								}
                            								set(
                            									current,
                            									"max",
                            									lv_max_9_0,
                            									"wodel.dsls.Wodel.MaxCardinality");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:5821:5: ( (lv_fixed_10_0= ruleEInt ) )
                            {
                            // InternalWodel.g:5821:5: ( (lv_fixed_10_0= ruleEInt ) )
                            // InternalWodel.g:5822:6: (lv_fixed_10_0= ruleEInt )
                            {
                            // InternalWodel.g:5822:6: (lv_fixed_10_0= ruleEInt )
                            // InternalWodel.g:5823:7: lv_fixed_10_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getCompositeMutatorAccess().getFixedEIntParserRuleCall_5_1_1_0());
                            						
                            pushFollow(FOLLOW_34);
                            lv_fixed_10_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            							}
                            							set(
                            								current,
                            								"fixed",
                            								lv_fixed_10_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:5850:1: entryRuleCloneObjectMutator returns [EObject current=null] : iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF ;
    public final EObject entryRuleCloneObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCloneObjectMutator = null;


        try {
            // InternalWodel.g:5850:59: (iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF )
            // InternalWodel.g:5851:2: iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCloneObjectMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCloneObjectMutator=ruleCloneObjectMutator();

            state._fsp--;

             current =iv_ruleCloneObjectMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:5857:1: ruleCloneObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_contents_2_0= 'deep' ) )? otherlv_3= 'clone' ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) ;
    public final EObject ruleCloneObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_contents_2_0=null;
        Token otherlv_3=null;
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
            // InternalWodel.g:5863:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_contents_2_0= 'deep' ) )? otherlv_3= 'clone' ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) )
            // InternalWodel.g:5864:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_contents_2_0= 'deep' ) )? otherlv_3= 'clone' ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            {
            // InternalWodel.g:5864:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_contents_2_0= 'deep' ) )? otherlv_3= 'clone' ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            // InternalWodel.g:5865:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_contents_2_0= 'deep' ) )? otherlv_3= 'clone' ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            {
            // InternalWodel.g:5865:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==RULE_ID) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalWodel.g:5866:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:5866:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:5867:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:5867:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:5868:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getCloneObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCloneObjectMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_92); 

                    				newLeafNode(otherlv_1, grammarAccess.getCloneObjectMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:5889:3: ( (lv_contents_2_0= 'deep' ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==70) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalWodel.g:5890:4: (lv_contents_2_0= 'deep' )
                    {
                    // InternalWodel.g:5890:4: (lv_contents_2_0= 'deep' )
                    // InternalWodel.g:5891:5: lv_contents_2_0= 'deep'
                    {
                    lv_contents_2_0=(Token)match(input,70,FOLLOW_93); 

                    					newLeafNode(lv_contents_2_0, grammarAccess.getCloneObjectMutatorAccess().getContentsDeepKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCloneObjectMutatorRule());
                    					}
                    					setWithLastConsumed(current, "contents", true, "deep");
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,71,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getCloneObjectMutatorAccess().getCloneKeyword_2());
            		
            // InternalWodel.g:5907:3: ( (lv_object_4_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:5908:4: (lv_object_4_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:5908:4: (lv_object_4_0= ruleObSelectionStrategy )
            // InternalWodel.g:5909:5: lv_object_4_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_72);
            lv_object_4_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_4_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:5926:3: (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==23) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalWodel.g:5927:4: otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getCloneObjectMutatorAccess().getInKeyword_4_0());
                    			
                    // InternalWodel.g:5931:4: ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:5932:5: (lv_container_6_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:5932:5: (lv_container_6_0= ruleObSelectionStrategy )
                    // InternalWodel.g:5933:6: lv_container_6_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_container_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_6_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWodel.g:5951:3: (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==11) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalWodel.g:5952:4: otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}'
                    {
                    otherlv_7=(Token)match(input,11,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getCloneObjectMutatorAccess().getWithKeyword_5_0());
                    			
                    otherlv_8=(Token)match(input,13,FOLLOW_74); 

                    				newLeafNode(otherlv_8, grammarAccess.getCloneObjectMutatorAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalWodel.g:5960:4: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )?
                    int alt124=3;
                    alt124 = dfa124.predict(input);
                    switch (alt124) {
                        case 1 :
                            // InternalWodel.g:5961:5: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            {
                            // InternalWodel.g:5961:5: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            // InternalWodel.g:5962:6: (lv_attributes_9_0= ruleAttributeSet )
                            {
                            // InternalWodel.g:5962:6: (lv_attributes_9_0= ruleAttributeSet )
                            // InternalWodel.g:5963:7: lv_attributes_9_0= ruleAttributeSet
                            {

                            							newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_2_0_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_attributes_9_0=ruleAttributeSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_9_0,
                            								"wodel.dsls.Wodel.AttributeSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:5981:5: ( (lv_references_10_0= ruleReferenceSet ) )
                            {
                            // InternalWodel.g:5981:5: ( (lv_references_10_0= ruleReferenceSet ) )
                            // InternalWodel.g:5982:6: (lv_references_10_0= ruleReferenceSet )
                            {
                            // InternalWodel.g:5982:6: (lv_references_10_0= ruleReferenceSet )
                            // InternalWodel.g:5983:7: lv_references_10_0= ruleReferenceSet
                            {

                            							newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_2_1_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_references_10_0=ruleReferenceSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"references",
                            								lv_references_10_0,
                            								"wodel.dsls.Wodel.ReferenceSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalWodel.g:6001:4: (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==26) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalWodel.g:6002:5: otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_11=(Token)match(input,26,FOLLOW_76); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getCloneObjectMutatorAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalWodel.g:6006:5: ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    int alt125=2;
                    	    alt125 = dfa125.predict(input);
                    	    switch (alt125) {
                    	        case 1 :
                    	            // InternalWodel.g:6007:6: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            {
                    	            // InternalWodel.g:6007:6: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            // InternalWodel.g:6008:7: (lv_attributes_12_0= ruleAttributeSet )
                    	            {
                    	            // InternalWodel.g:6008:7: (lv_attributes_12_0= ruleAttributeSet )
                    	            // InternalWodel.g:6009:8: lv_attributes_12_0= ruleAttributeSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_attributes_12_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"attributes",
                    	            									lv_attributes_12_0,
                    	            									"wodel.dsls.Wodel.AttributeSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalWodel.g:6027:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            {
                    	            // InternalWodel.g:6027:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            // InternalWodel.g:6028:7: (lv_references_13_0= ruleReferenceSet )
                    	            {
                    	            // InternalWodel.g:6028:7: (lv_references_13_0= ruleReferenceSet )
                    	            // InternalWodel.g:6029:8: lv_references_13_0= ruleReferenceSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_3_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_references_13_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"references",
                    	            									lv_references_13_0,
                    	            									"wodel.dsls.Wodel.ReferenceSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,14,FOLLOW_30); 

                    				newLeafNode(otherlv_14, grammarAccess.getCloneObjectMutatorAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalWodel.g:6053:3: (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==30) ) {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==RULE_INT||LA129_1==53||LA129_1==97) ) {
                    alt129=1;
                }
            }
            switch (alt129) {
                case 1 :
                    // InternalWodel.g:6054:4: otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']'
                    {
                    otherlv_15=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_15, grammarAccess.getCloneObjectMutatorAccess().getLeftSquareBracketKeyword_6_0());
                    			
                    // InternalWodel.g:6058:4: ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )?
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==53) ) {
                        int LA128_1 = input.LA(2);

                        if ( (LA128_1==RULE_INT) ) {
                            int LA128_2 = input.LA(3);

                            if ( (LA128_2==31) ) {
                                alt128=1;
                            }
                        }
                    }
                    else if ( (LA128_0==RULE_INT) ) {
                        int LA128_2 = input.LA(2);

                        if ( (LA128_2==31) ) {
                            alt128=1;
                        }
                    }
                    switch (alt128) {
                        case 1 :
                            // InternalWodel.g:6059:5: ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..'
                            {
                            // InternalWodel.g:6059:5: ( (lv_min_16_0= ruleEInt ) )
                            // InternalWodel.g:6060:6: (lv_min_16_0= ruleEInt )
                            {
                            // InternalWodel.g:6060:6: (lv_min_16_0= ruleEInt )
                            // InternalWodel.g:6061:7: lv_min_16_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMinEIntParserRuleCall_6_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_16_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_16_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_17=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_17, grammarAccess.getCloneObjectMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:6083:4: ( (lv_max_18_0= ruleMaxCardinality ) )
                    // InternalWodel.g:6084:5: (lv_max_18_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:6084:5: (lv_max_18_0= ruleMaxCardinality )
                    // InternalWodel.g:6085:6: lv_max_18_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_18_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_18_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_19=(Token)match(input,32,FOLLOW_2); 

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


    // $ANTLR start "entryRuleRetypeObjectMutator"
    // InternalWodel.g:6111:1: entryRuleRetypeObjectMutator returns [EObject current=null] : iv_ruleRetypeObjectMutator= ruleRetypeObjectMutator EOF ;
    public final EObject entryRuleRetypeObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRetypeObjectMutator = null;


        try {
            // InternalWodel.g:6111:60: (iv_ruleRetypeObjectMutator= ruleRetypeObjectMutator EOF )
            // InternalWodel.g:6112:2: iv_ruleRetypeObjectMutator= ruleRetypeObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRetypeObjectMutatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRetypeObjectMutator=ruleRetypeObjectMutator();

            state._fsp--;

             current =iv_ruleRetypeObjectMutator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRetypeObjectMutator"


    // $ANTLR start "ruleRetypeObjectMutator"
    // InternalWodel.g:6118:1: ruleRetypeObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'retype' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? otherlv_6= 'as' ( (otherlv_7= RULE_ID ) ) (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) ;
    public final EObject ruleRetypeObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
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
        EObject lv_object_3_0 = null;

        EObject lv_container_5_0 = null;

        EObject lv_attributes_10_0 = null;

        EObject lv_references_11_0 = null;

        EObject lv_attributes_13_0 = null;

        EObject lv_references_14_0 = null;

        AntlrDatatypeRuleToken lv_min_17_0 = null;

        AntlrDatatypeRuleToken lv_max_19_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:6124:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'retype' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? otherlv_6= 'as' ( (otherlv_7= RULE_ID ) ) (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) )
            // InternalWodel.g:6125:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'retype' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? otherlv_6= 'as' ( (otherlv_7= RULE_ID ) ) (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            {
            // InternalWodel.g:6125:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'retype' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? otherlv_6= 'as' ( (otherlv_7= RULE_ID ) ) (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            // InternalWodel.g:6126:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'retype' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? otherlv_6= 'as' ( (otherlv_7= RULE_ID ) ) (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            {
            // InternalWodel.g:6126:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==RULE_ID) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalWodel.g:6127:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalWodel.g:6127:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWodel.g:6128:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWodel.g:6128:5: (lv_name_0_0= RULE_ID )
                    // InternalWodel.g:6129:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getRetypeObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRetypeObjectMutatorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_94); 

                    				newLeafNode(otherlv_1, grammarAccess.getRetypeObjectMutatorAccess().getEqualsSignKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,72,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getRetypeObjectMutatorAccess().getRetypeKeyword_1());
            		
            // InternalWodel.g:6154:3: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:6155:4: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:6155:4: (lv_object_3_0= ruleObSelectionStrategy )
            // InternalWodel.g:6156:5: lv_object_3_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_95);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_3_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:6173:3: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==23) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalWodel.g:6174:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_66); 

                    				newLeafNode(otherlv_4, grammarAccess.getRetypeObjectMutatorAccess().getInKeyword_3_0());
                    			
                    // InternalWodel.g:6178:4: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:6179:5: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:6179:5: (lv_container_5_0= ruleObSelectionStrategy )
                    // InternalWodel.g:6180:6: lv_container_5_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_96);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_5_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,73,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getRetypeObjectMutatorAccess().getAsKeyword_4());
            		
            // InternalWodel.g:6202:3: ( (otherlv_7= RULE_ID ) )
            // InternalWodel.g:6203:4: (otherlv_7= RULE_ID )
            {
            // InternalWodel.g:6203:4: (otherlv_7= RULE_ID )
            // InternalWodel.g:6204:5: otherlv_7= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRetypeObjectMutatorRule());
            					}
            				
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_73); 

            					newLeafNode(otherlv_7, grammarAccess.getRetypeObjectMutatorAccess().getTypeEClassCrossReference_5_0());
            				

            }


            }

            // InternalWodel.g:6215:3: (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==11) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalWodel.g:6216:4: otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}'
                    {
                    otherlv_8=(Token)match(input,11,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getRetypeObjectMutatorAccess().getWithKeyword_6_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_74); 

                    				newLeafNode(otherlv_9, grammarAccess.getRetypeObjectMutatorAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalWodel.g:6224:4: ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )?
                    int alt132=3;
                    alt132 = dfa132.predict(input);
                    switch (alt132) {
                        case 1 :
                            // InternalWodel.g:6225:5: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            {
                            // InternalWodel.g:6225:5: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            // InternalWodel.g:6226:6: (lv_attributes_10_0= ruleAttributeSet )
                            {
                            // InternalWodel.g:6226:6: (lv_attributes_10_0= ruleAttributeSet )
                            // InternalWodel.g:6227:7: lv_attributes_10_0= ruleAttributeSet
                            {

                            							newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_6_2_0_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_attributes_10_0=ruleAttributeSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_10_0,
                            								"wodel.dsls.Wodel.AttributeSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWodel.g:6245:5: ( (lv_references_11_0= ruleReferenceSet ) )
                            {
                            // InternalWodel.g:6245:5: ( (lv_references_11_0= ruleReferenceSet ) )
                            // InternalWodel.g:6246:6: (lv_references_11_0= ruleReferenceSet )
                            {
                            // InternalWodel.g:6246:6: (lv_references_11_0= ruleReferenceSet )
                            // InternalWodel.g:6247:7: lv_references_11_0= ruleReferenceSet
                            {

                            							newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_6_2_1_0());
                            						
                            pushFollow(FOLLOW_75);
                            lv_references_11_0=ruleReferenceSet();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                            							}
                            							add(
                            								current,
                            								"references",
                            								lv_references_11_0,
                            								"wodel.dsls.Wodel.ReferenceSet");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalWodel.g:6265:4: (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==26) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // InternalWodel.g:6266:5: otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,26,FOLLOW_76); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getRetypeObjectMutatorAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalWodel.g:6270:5: ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    int alt133=2;
                    	    alt133 = dfa133.predict(input);
                    	    switch (alt133) {
                    	        case 1 :
                    	            // InternalWodel.g:6271:6: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            {
                    	            // InternalWodel.g:6271:6: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            // InternalWodel.g:6272:7: (lv_attributes_13_0= ruleAttributeSet )
                    	            {
                    	            // InternalWodel.g:6272:7: (lv_attributes_13_0= ruleAttributeSet )
                    	            // InternalWodel.g:6273:8: lv_attributes_13_0= ruleAttributeSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_6_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_attributes_13_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"attributes",
                    	            									lv_attributes_13_0,
                    	            									"wodel.dsls.Wodel.AttributeSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalWodel.g:6291:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            {
                    	            // InternalWodel.g:6291:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            // InternalWodel.g:6292:7: (lv_references_14_0= ruleReferenceSet )
                    	            {
                    	            // InternalWodel.g:6292:7: (lv_references_14_0= ruleReferenceSet )
                    	            // InternalWodel.g:6293:8: lv_references_14_0= ruleReferenceSet
                    	            {

                    	            								newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_6_3_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_75);
                    	            lv_references_14_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"references",
                    	            									lv_references_14_0,
                    	            									"wodel.dsls.Wodel.ReferenceSet");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop134;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,14,FOLLOW_30); 

                    				newLeafNode(otherlv_15, grammarAccess.getRetypeObjectMutatorAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalWodel.g:6317:3: (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==30) ) {
                int LA137_1 = input.LA(2);

                if ( (LA137_1==RULE_INT||LA137_1==53||LA137_1==97) ) {
                    alt137=1;
                }
            }
            switch (alt137) {
                case 1 :
                    // InternalWodel.g:6318:4: otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']'
                    {
                    otherlv_16=(Token)match(input,30,FOLLOW_33); 

                    				newLeafNode(otherlv_16, grammarAccess.getRetypeObjectMutatorAccess().getLeftSquareBracketKeyword_7_0());
                    			
                    // InternalWodel.g:6322:4: ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==53) ) {
                        int LA136_1 = input.LA(2);

                        if ( (LA136_1==RULE_INT) ) {
                            int LA136_2 = input.LA(3);

                            if ( (LA136_2==31) ) {
                                alt136=1;
                            }
                        }
                    }
                    else if ( (LA136_0==RULE_INT) ) {
                        int LA136_2 = input.LA(2);

                        if ( (LA136_2==31) ) {
                            alt136=1;
                        }
                    }
                    switch (alt136) {
                        case 1 :
                            // InternalWodel.g:6323:5: ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..'
                            {
                            // InternalWodel.g:6323:5: ( (lv_min_17_0= ruleEInt ) )
                            // InternalWodel.g:6324:6: (lv_min_17_0= ruleEInt )
                            {
                            // InternalWodel.g:6324:6: (lv_min_17_0= ruleEInt )
                            // InternalWodel.g:6325:7: lv_min_17_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getMinEIntParserRuleCall_7_1_0_0());
                            						
                            pushFollow(FOLLOW_32);
                            lv_min_17_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                            							}
                            							set(
                            								current,
                            								"min",
                            								lv_min_17_0,
                            								"wodel.dsls.Wodel.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_18=(Token)match(input,31,FOLLOW_33); 

                            					newLeafNode(otherlv_18, grammarAccess.getRetypeObjectMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                            				

                            }
                            break;

                    }

                    // InternalWodel.g:6347:4: ( (lv_max_19_0= ruleMaxCardinality ) )
                    // InternalWodel.g:6348:5: (lv_max_19_0= ruleMaxCardinality )
                    {
                    // InternalWodel.g:6348:5: (lv_max_19_0= ruleMaxCardinality )
                    // InternalWodel.g:6349:6: lv_max_19_0= ruleMaxCardinality
                    {

                    						newCompositeNode(grammarAccess.getRetypeObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_max_19_0=ruleMaxCardinality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRetypeObjectMutatorRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_19_0,
                    							"wodel.dsls.Wodel.MaxCardinality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getRetypeObjectMutatorAccess().getRightSquareBracketKeyword_7_3());
                    			

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
    // $ANTLR end "ruleRetypeObjectMutator"


    // $ANTLR start "entryRuleAttributeSet"
    // InternalWodel.g:6375:1: entryRuleAttributeSet returns [EObject current=null] : iv_ruleAttributeSet= ruleAttributeSet EOF ;
    public final EObject entryRuleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSet = null;


        try {
            // InternalWodel.g:6375:53: (iv_ruleAttributeSet= ruleAttributeSet EOF )
            // InternalWodel.g:6376:2: iv_ruleAttributeSet= ruleAttributeSet EOF
            {
             newCompositeNode(grammarAccess.getAttributeSetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeSet=ruleAttributeSet();

            state._fsp--;

             current =iv_ruleAttributeSet; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6382:1: ruleAttributeSet returns [EObject current=null] : (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) ;
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
            // InternalWodel.g:6388:2: ( (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) )
            // InternalWodel.g:6389:2: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            {
            // InternalWodel.g:6389:2: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            int alt138=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA138_1 = input.LA(2);

                if ( (LA138_1==23||LA138_1==28||LA138_1==37||(LA138_1>=98 && LA138_1<=103)) ) {
                    alt138=1;
                }
                else if ( (LA138_1==53||LA138_1==78||LA138_1==97||(LA138_1>=104 && LA138_1<=105)) ) {
                    alt138=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 138, 1, input);

                    throw nvae;
                }
                }
                break;
            case 74:
                {
                alt138=2;
                }
                break;
            case 75:
                {
                alt138=3;
                }
                break;
            case 76:
                {
                alt138=4;
                }
                break;
            case 77:
                {
                alt138=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }

            switch (alt138) {
                case 1 :
                    // InternalWodel.g:6390:3: this_AttributeScalar_0= ruleAttributeScalar
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeScalarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeScalar_0=ruleAttributeScalar();

                    state._fsp--;


                    			current = this_AttributeScalar_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:6399:3: this_AttributeUnset_1= ruleAttributeUnset
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeUnsetParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeUnset_1=ruleAttributeUnset();

                    state._fsp--;


                    			current = this_AttributeUnset_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:6408:3: this_AttributeSwap_2= ruleAttributeSwap
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeSwapParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeSwap_2=ruleAttributeSwap();

                    state._fsp--;


                    			current = this_AttributeSwap_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:6417:3: this_AttributeCopy_3= ruleAttributeCopy
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeCopyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeCopy_3=ruleAttributeCopy();

                    state._fsp--;


                    			current = this_AttributeCopy_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:6426:3: this_AttributeReverse_4= ruleAttributeReverse
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeReverseParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttributeReverse_4=ruleAttributeReverse();

                    state._fsp--;


                    			current = this_AttributeReverse_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWodel.g:6435:3: this_AttributeOperation_5= ruleAttributeOperation
                    {

                    			newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeOperationParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:6447:1: entryRuleAttributeScalar returns [EObject current=null] : iv_ruleAttributeScalar= ruleAttributeScalar EOF ;
    public final EObject entryRuleAttributeScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeScalar = null;


        try {
            // InternalWodel.g:6447:56: (iv_ruleAttributeScalar= ruleAttributeScalar EOF )
            // InternalWodel.g:6448:2: iv_ruleAttributeScalar= ruleAttributeScalar EOF
            {
             newCompositeNode(grammarAccess.getAttributeScalarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeScalar=ruleAttributeScalar();

            state._fsp--;

             current =iv_ruleAttributeScalar; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6454:1: ruleAttributeScalar returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:6460:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) )
            // InternalWodel.g:6461:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            {
            // InternalWodel.g:6461:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            // InternalWodel.g:6462:3: ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) )
            {
            // InternalWodel.g:6462:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:6463:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:6463:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:6464:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeScalarRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_60); 

            					newLeafNode(otherlv_0, grammarAccess.getAttributeScalarAccess().getAttributeEAttributeCrossReference_0_0());
            				

            }


            }

            // InternalWodel.g:6475:3: ( (lv_value_1_0= ruleAttributeType ) )
            // InternalWodel.g:6476:4: (lv_value_1_0= ruleAttributeType )
            {
            // InternalWodel.g:6476:4: (lv_value_1_0= ruleAttributeType )
            // InternalWodel.g:6477:5: lv_value_1_0= ruleAttributeType
            {

            					newCompositeNode(grammarAccess.getAttributeScalarAccess().getValueAttributeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleAttributeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeScalarRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"wodel.dsls.Wodel.AttributeType");
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
    // InternalWodel.g:6498:1: entryRuleAttributeUnset returns [EObject current=null] : iv_ruleAttributeUnset= ruleAttributeUnset EOF ;
    public final EObject entryRuleAttributeUnset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeUnset = null;


        try {
            // InternalWodel.g:6498:55: (iv_ruleAttributeUnset= ruleAttributeUnset EOF )
            // InternalWodel.g:6499:2: iv_ruleAttributeUnset= ruleAttributeUnset EOF
            {
             newCompositeNode(grammarAccess.getAttributeUnsetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeUnset=ruleAttributeUnset();

            state._fsp--;

             current =iv_ruleAttributeUnset; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6505:1: ruleAttributeUnset returns [EObject current=null] : (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeUnset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalWodel.g:6511:2: ( (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalWodel.g:6512:2: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalWodel.g:6512:2: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // InternalWodel.g:6513:3: otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeUnsetAccess().getUnsetKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeUnsetAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:6521:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:6522:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:6522:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:6523:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeUnsetRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_2, grammarAccess.getAttributeUnsetAccess().getAttributeEAttributeCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:6542:1: entryRuleAttributeSwap returns [EObject current=null] : iv_ruleAttributeSwap= ruleAttributeSwap EOF ;
    public final EObject entryRuleAttributeSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSwap = null;


        try {
            // InternalWodel.g:6542:54: (iv_ruleAttributeSwap= ruleAttributeSwap EOF )
            // InternalWodel.g:6543:2: iv_ruleAttributeSwap= ruleAttributeSwap EOF
            {
             newCompositeNode(grammarAccess.getAttributeSwapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeSwap=ruleAttributeSwap();

            state._fsp--;

             current =iv_ruleAttributeSwap; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6549:1: ruleAttributeSwap returns [EObject current=null] : (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // InternalWodel.g:6555:2: ( (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // InternalWodel.g:6556:2: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // InternalWodel.g:6556:2: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // InternalWodel.g:6557:3: otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeSwapAccess().getSwapKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeSwapAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:6565:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:6566:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:6566:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:6567:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeSwapRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_98); 

            					newLeafNode(otherlv_2, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getAttributeSwapAccess().getCommaKeyword_3());
            		
            // InternalWodel.g:6582:3: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==60||LA139_0==62||(LA139_0>=81 && LA139_0<=83)) ) {
                alt139=1;
            }
            else if ( (LA139_0==RULE_ID) ) {
                int LA139_2 = input.LA(2);

                if ( ((LA139_2>=38 && LA139_2<=39)||LA139_2==80) ) {
                    alt139=1;
                }
            }
            switch (alt139) {
                case 1 :
                    // InternalWodel.g:6583:4: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // InternalWodel.g:6583:4: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:6584:5: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:6584:5: (lv_object_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:6585:6: lv_object_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getAttributeSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeSwapRule());
                    						}
                    						set(
                    							current,
                    							"object",
                    							lv_object_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getAttributeSwapAccess().getFullStopKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:6607:3: ( (otherlv_6= RULE_ID ) )
            // InternalWodel.g:6608:4: (otherlv_6= RULE_ID )
            {
            // InternalWodel.g:6608:4: (otherlv_6= RULE_ID )
            // InternalWodel.g:6609:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeSwapRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_6, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_5_0());
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:6628:1: entryRuleAttributeCopy returns [EObject current=null] : iv_ruleAttributeCopy= ruleAttributeCopy EOF ;
    public final EObject entryRuleAttributeCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCopy = null;


        try {
            // InternalWodel.g:6628:54: (iv_ruleAttributeCopy= ruleAttributeCopy EOF )
            // InternalWodel.g:6629:2: iv_ruleAttributeCopy= ruleAttributeCopy EOF
            {
             newCompositeNode(grammarAccess.getAttributeCopyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeCopy=ruleAttributeCopy();

            state._fsp--;

             current =iv_ruleAttributeCopy; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6635:1: ruleAttributeCopy returns [EObject current=null] : (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // InternalWodel.g:6641:2: ( (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // InternalWodel.g:6642:2: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // InternalWodel.g:6642:2: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // InternalWodel.g:6643:3: otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeCopyAccess().getCopyKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeCopyAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:6651:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:6652:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:6652:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:6653:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeCopyRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_98); 

            					newLeafNode(otherlv_2, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getAttributeCopyAccess().getCommaKeyword_3());
            		
            // InternalWodel.g:6668:3: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==60||LA140_0==62||(LA140_0>=81 && LA140_0<=83)) ) {
                alt140=1;
            }
            else if ( (LA140_0==RULE_ID) ) {
                int LA140_2 = input.LA(2);

                if ( ((LA140_2>=38 && LA140_2<=39)||LA140_2==80) ) {
                    alt140=1;
                }
            }
            switch (alt140) {
                case 1 :
                    // InternalWodel.g:6669:4: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // InternalWodel.g:6669:4: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:6670:5: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:6670:5: (lv_object_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:6671:6: lv_object_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getAttributeCopyAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeCopyRule());
                    						}
                    						set(
                    							current,
                    							"object",
                    							lv_object_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getAttributeCopyAccess().getFullStopKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:6693:3: ( (otherlv_6= RULE_ID ) )
            // InternalWodel.g:6694:4: (otherlv_6= RULE_ID )
            {
            // InternalWodel.g:6694:4: (otherlv_6= RULE_ID )
            // InternalWodel.g:6695:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeCopyRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_6, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_5_0());
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:6714:1: entryRuleAttributeReverse returns [EObject current=null] : iv_ruleAttributeReverse= ruleAttributeReverse EOF ;
    public final EObject entryRuleAttributeReverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReverse = null;


        try {
            // InternalWodel.g:6714:57: (iv_ruleAttributeReverse= ruleAttributeReverse EOF )
            // InternalWodel.g:6715:2: iv_ruleAttributeReverse= ruleAttributeReverse EOF
            {
             newCompositeNode(grammarAccess.getAttributeReverseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeReverse=ruleAttributeReverse();

            state._fsp--;

             current =iv_ruleAttributeReverse; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6721:1: ruleAttributeReverse returns [EObject current=null] : (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeReverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalWodel.g:6727:2: ( (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalWodel.g:6728:2: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalWodel.g:6728:2: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // InternalWodel.g:6729:3: otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeReverseAccess().getReverseKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeReverseAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:6737:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:6738:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:6738:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:6739:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeReverseRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_2, grammarAccess.getAttributeReverseAccess().getAttributeEAttributeCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:6758:1: entryRuleAttributeOperation returns [EObject current=null] : iv_ruleAttributeOperation= ruleAttributeOperation EOF ;
    public final EObject entryRuleAttributeOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeOperation = null;


        try {
            // InternalWodel.g:6758:59: (iv_ruleAttributeOperation= ruleAttributeOperation EOF )
            // InternalWodel.g:6759:2: iv_ruleAttributeOperation= ruleAttributeOperation EOF
            {
             newCompositeNode(grammarAccess.getAttributeOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeOperation=ruleAttributeOperation();

            state._fsp--;

             current =iv_ruleAttributeOperation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6765:1: ruleAttributeOperation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_operator_1_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:6771:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // InternalWodel.g:6772:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // InternalWodel.g:6772:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // InternalWodel.g:6773:3: ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // InternalWodel.g:6773:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:6774:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:6774:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:6775:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeOperationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_99); 

            					newLeafNode(otherlv_0, grammarAccess.getAttributeOperationAccess().getAttributeEAttributeCrossReference_0_0());
            				

            }


            }

            // InternalWodel.g:6786:3: ( (lv_operator_1_0= ruleArithmeticOperator ) )
            // InternalWodel.g:6787:4: (lv_operator_1_0= ruleArithmeticOperator )
            {
            // InternalWodel.g:6787:4: (lv_operator_1_0= ruleArithmeticOperator )
            // InternalWodel.g:6788:5: lv_operator_1_0= ruleArithmeticOperator
            {

            					newCompositeNode(grammarAccess.getAttributeOperationAccess().getOperatorArithmeticOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_60);
            lv_operator_1_0=ruleArithmeticOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeOperationRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.ArithmeticOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:6805:3: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // InternalWodel.g:6806:4: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // InternalWodel.g:6806:4: (lv_value_2_0= ruleAttributeEvaluationType )
            // InternalWodel.g:6807:5: lv_value_2_0= ruleAttributeEvaluationType
            {

            					newCompositeNode(grammarAccess.getAttributeOperationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleAttributeEvaluationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeOperationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Wodel.AttributeEvaluationType");
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
    // InternalWodel.g:6828:1: entryRuleReferenceSet returns [EObject current=null] : iv_ruleReferenceSet= ruleReferenceSet EOF ;
    public final EObject entryRuleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSet = null;


        try {
            // InternalWodel.g:6828:53: (iv_ruleReferenceSet= ruleReferenceSet EOF )
            // InternalWodel.g:6829:2: iv_ruleReferenceSet= ruleReferenceSet EOF
            {
             newCompositeNode(grammarAccess.getReferenceSetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceSet=ruleReferenceSet();

            state._fsp--;

             current =iv_ruleReferenceSet; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6835:1: ruleReferenceSet returns [EObject current=null] : (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove ) ;
    public final EObject ruleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceInit_0 = null;

        EObject this_ReferenceSwap_1 = null;

        EObject this_ReferenceAtt_2 = null;

        EObject this_ReferenceAdd_3 = null;

        EObject this_ReferenceRemove_4 = null;



        	enterRule();

        try {
            // InternalWodel.g:6841:2: ( (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove ) )
            // InternalWodel.g:6842:2: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove )
            {
            // InternalWodel.g:6842:2: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove )
            int alt141=5;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 78:
                    {
                    alt141=4;
                    }
                    break;
                case 28:
                    {
                    alt141=1;
                    }
                    break;
                case 53:
                    {
                    alt141=5;
                    }
                    break;
                case 38:
                    {
                    alt141=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 141, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA141_0==79) ) {
                alt141=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalWodel.g:6843:3: this_ReferenceInit_0= ruleReferenceInit
                    {

                    			newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceInitParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceInit_0=ruleReferenceInit();

                    state._fsp--;


                    			current = this_ReferenceInit_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:6852:3: this_ReferenceSwap_1= ruleReferenceSwap
                    {

                    			newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceSwapParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceSwap_1=ruleReferenceSwap();

                    state._fsp--;


                    			current = this_ReferenceSwap_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:6861:3: this_ReferenceAtt_2= ruleReferenceAtt
                    {

                    			newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceAttParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceAtt_2=ruleReferenceAtt();

                    state._fsp--;


                    			current = this_ReferenceAtt_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:6870:3: this_ReferenceAdd_3= ruleReferenceAdd
                    {

                    			newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceAddParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceAdd_3=ruleReferenceAdd();

                    state._fsp--;


                    			current = this_ReferenceAdd_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:6879:3: this_ReferenceRemove_4= ruleReferenceRemove
                    {

                    			newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceRemoveParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:6891:1: entryRuleReferenceInit returns [EObject current=null] : iv_ruleReferenceInit= ruleReferenceInit EOF ;
    public final EObject entryRuleReferenceInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceInit = null;


        try {
            // InternalWodel.g:6891:54: (iv_ruleReferenceInit= ruleReferenceInit EOF )
            // InternalWodel.g:6892:2: iv_ruleReferenceInit= ruleReferenceInit EOF
            {
             newCompositeNode(grammarAccess.getReferenceInitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceInit=ruleReferenceInit();

            state._fsp--;

             current =iv_ruleReferenceInit; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6898:1: ruleReferenceInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_object_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:6904:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) )
            // InternalWodel.g:6905:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            {
            // InternalWodel.g:6905:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            // InternalWodel.g:6906:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) )
            {
            // InternalWodel.g:6906:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:6907:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:6907:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:6908:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceInitRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getReferenceInitAccess().getReferenceEReferenceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceInitAccess().getEqualsSignKeyword_1());
            		
            // InternalWodel.g:6923:3: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:6924:4: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:6924:4: (lv_object_2_0= ruleObSelectionStrategy )
            // InternalWodel.g:6925:5: lv_object_2_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getReferenceInitAccess().getObjectObSelectionStrategyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceInitRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_2_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
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
    // InternalWodel.g:6946:1: entryRuleReferenceAdd returns [EObject current=null] : iv_ruleReferenceAdd= ruleReferenceAdd EOF ;
    public final EObject entryRuleReferenceAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAdd = null;


        try {
            // InternalWodel.g:6946:53: (iv_ruleReferenceAdd= ruleReferenceAdd EOF )
            // InternalWodel.g:6947:2: iv_ruleReferenceAdd= ruleReferenceAdd EOF
            {
             newCompositeNode(grammarAccess.getReferenceAddRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceAdd=ruleReferenceAdd();

            state._fsp--;

             current =iv_ruleReferenceAdd; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:6953:1: ruleReferenceAdd returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_object_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:6959:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) )
            // InternalWodel.g:6960:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            {
            // InternalWodel.g:6960:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            // InternalWodel.g:6961:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) )
            {
            // InternalWodel.g:6961:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:6962:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:6962:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:6963:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceAddRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_100); 

            					newLeafNode(otherlv_0, grammarAccess.getReferenceAddAccess().getReferenceEReferenceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,78,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceAddAccess().getPlusSignKeyword_1());
            		
            otherlv_2=(Token)match(input,28,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getReferenceAddAccess().getEqualsSignKeyword_2());
            		
            // InternalWodel.g:6982:3: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:6983:4: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:6983:4: (lv_object_3_0= ruleObSelectionStrategy )
            // InternalWodel.g:6984:5: lv_object_3_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getReferenceAddAccess().getObjectObSelectionStrategyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceAddRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_3_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
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
    // InternalWodel.g:7005:1: entryRuleReferenceRemove returns [EObject current=null] : iv_ruleReferenceRemove= ruleReferenceRemove EOF ;
    public final EObject entryRuleReferenceRemove() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRemove = null;


        try {
            // InternalWodel.g:7005:56: (iv_ruleReferenceRemove= ruleReferenceRemove EOF )
            // InternalWodel.g:7006:2: iv_ruleReferenceRemove= ruleReferenceRemove EOF
            {
             newCompositeNode(grammarAccess.getReferenceRemoveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceRemove=ruleReferenceRemove();

            state._fsp--;

             current =iv_ruleReferenceRemove; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7012:1: ruleReferenceRemove returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceRemove() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_object_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7018:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) )
            // InternalWodel.g:7019:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            {
            // InternalWodel.g:7019:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            // InternalWodel.g:7020:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) )
            {
            // InternalWodel.g:7020:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:7021:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:7021:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:7022:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRemoveRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_101); 

            					newLeafNode(otherlv_0, grammarAccess.getReferenceRemoveAccess().getReferenceEReferenceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,53,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceRemoveAccess().getHyphenMinusKeyword_1());
            		
            otherlv_2=(Token)match(input,28,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getReferenceRemoveAccess().getEqualsSignKeyword_2());
            		
            // InternalWodel.g:7041:3: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // InternalWodel.g:7042:4: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // InternalWodel.g:7042:4: (lv_object_3_0= ruleObSelectionStrategy )
            // InternalWodel.g:7043:5: lv_object_3_0= ruleObSelectionStrategy
            {

            					newCompositeNode(grammarAccess.getReferenceRemoveAccess().getObjectObSelectionStrategyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceRemoveRule());
            					}
            					set(
            						current,
            						"object",
            						lv_object_3_0,
            						"wodel.dsls.Wodel.ObSelectionStrategy");
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
    // InternalWodel.g:7064:1: entryRuleReferenceSwap returns [EObject current=null] : iv_ruleReferenceSwap= ruleReferenceSwap EOF ;
    public final EObject entryRuleReferenceSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSwap = null;


        try {
            // InternalWodel.g:7064:54: (iv_ruleReferenceSwap= ruleReferenceSwap EOF )
            // InternalWodel.g:7065:2: iv_ruleReferenceSwap= ruleReferenceSwap EOF
            {
             newCompositeNode(grammarAccess.getReferenceSwapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceSwap=ruleReferenceSwap();

            state._fsp--;

             current =iv_ruleReferenceSwap; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7071:1: ruleReferenceSwap returns [EObject current=null] : (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // InternalWodel.g:7077:2: ( (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // InternalWodel.g:7078:2: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // InternalWodel.g:7078:2: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // InternalWodel.g:7079:3: otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getReferenceSwapAccess().getSwaprefKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceSwapAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWodel.g:7087:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7088:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7088:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7089:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceSwapRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_98); 

            					newLeafNode(otherlv_2, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getReferenceSwapAccess().getCommaKeyword_3());
            		
            // InternalWodel.g:7104:3: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==60||LA142_0==62||(LA142_0>=81 && LA142_0<=83)) ) {
                alt142=1;
            }
            else if ( (LA142_0==RULE_ID) ) {
                int LA142_2 = input.LA(2);

                if ( (LA142_2==39||LA142_2==80) ) {
                    alt142=1;
                }
            }
            switch (alt142) {
                case 1 :
                    // InternalWodel.g:7105:4: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->'
                    {
                    // InternalWodel.g:7105:4: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:7106:5: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:7106:5: (lv_object_4_0= ruleObSelectionStrategy )
                    // InternalWodel.g:7107:6: lv_object_4_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getReferenceSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_102);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferenceSwapRule());
                    						}
                    						set(
                    							current,
                    							"object",
                    							lv_object_4_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferenceSwapAccess().getHyphenMinusGreaterThanSignKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:7129:3: ( (otherlv_6= RULE_ID ) )
            // InternalWodel.g:7130:4: (otherlv_6= RULE_ID )
            {
            // InternalWodel.g:7130:4: (otherlv_6= RULE_ID )
            // InternalWodel.g:7131:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceSwapRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_6, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_5_0());
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:7150:1: entryRuleReferenceAtt returns [EObject current=null] : iv_ruleReferenceAtt= ruleReferenceAtt EOF ;
    public final EObject entryRuleReferenceAtt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAtt = null;


        try {
            // InternalWodel.g:7150:53: (iv_ruleReferenceAtt= ruleReferenceAtt EOF )
            // InternalWodel.g:7151:2: iv_ruleReferenceAtt= ruleReferenceAtt EOF
            {
             newCompositeNode(grammarAccess.getReferenceAttRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceAtt=ruleReferenceAtt();

            state._fsp--;

             current =iv_ruleReferenceAtt; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7157:1: ruleReferenceAtt returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) ;
    public final EObject ruleReferenceAtt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7163:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) )
            // InternalWodel.g:7164:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            {
            // InternalWodel.g:7164:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            // InternalWodel.g:7165:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) )
            {
            // InternalWodel.g:7165:3: ( (otherlv_0= RULE_ID ) )
            // InternalWodel.g:7166:4: (otherlv_0= RULE_ID )
            {
            // InternalWodel.g:7166:4: (otherlv_0= RULE_ID )
            // InternalWodel.g:7167:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceAttRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_58); 

            					newLeafNode(otherlv_0, grammarAccess.getReferenceAttAccess().getReferenceEReferenceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceAttAccess().getFullStopKeyword_1());
            		
            // InternalWodel.g:7182:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7183:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7183:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7184:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceAttRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_60); 

            					newLeafNode(otherlv_2, grammarAccess.getReferenceAttAccess().getAttributeEAttributeCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:7195:3: ( (lv_value_3_0= ruleAttributeType ) )
            // InternalWodel.g:7196:4: (lv_value_3_0= ruleAttributeType )
            {
            // InternalWodel.g:7196:4: (lv_value_3_0= ruleAttributeType )
            // InternalWodel.g:7197:5: lv_value_3_0= ruleAttributeType
            {

            					newCompositeNode(grammarAccess.getReferenceAttAccess().getValueAttributeTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleAttributeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceAttRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"wodel.dsls.Wodel.AttributeType");
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
    // InternalWodel.g:7218:1: entryRuleRandomTypeSelection returns [EObject current=null] : iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF ;
    public final EObject entryRuleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTypeSelection = null;


        try {
            // InternalWodel.g:7218:60: (iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF )
            // InternalWodel.g:7219:2: iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomTypeSelection=ruleRandomTypeSelection();

            state._fsp--;

             current =iv_ruleRandomTypeSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7225:1: ruleRandomTypeSelection returns [EObject current=null] : ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )? (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )? ) ;
    public final EObject ruleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_resource_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_expression_14_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7231:2: ( ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )? (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )? ) )
            // InternalWodel.g:7232:2: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )? (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )? )
            {
            // InternalWodel.g:7232:2: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )? (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )? )
            // InternalWodel.g:7233:3: () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )? (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )?
            {
            // InternalWodel.g:7233:3: ()
            // InternalWodel.g:7234:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomTypeSelectionAccess().getRandomTypeSelectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,60,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getRandomTypeSelectionAccess().getOneKeyword_1());
            		
            // InternalWodel.g:7244:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7245:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7245:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7246:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_103); 

            					newLeafNode(otherlv_2, grammarAccess.getRandomTypeSelectionAccess().getTypeEClassCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:7257:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==39) ) {
                int LA145_1 = input.LA(2);

                if ( (LA145_1==RULE_ID) ) {
                    int LA145_3 = input.LA(3);

                    if ( (LA145_3==EOF||LA145_3==RULE_ID||LA145_3==11||LA145_3==14||(LA145_3>=23 && LA145_3<=24)||LA145_3==26||LA145_3==30||LA145_3==32||(LA145_3>=38 && LA145_3<=39)||(LA145_3>=43 && LA145_3<=44)||LA145_3==59||LA145_3==63||(LA145_3>=66 && LA145_3<=67)||(LA145_3>=70 && LA145_3<=73)||LA145_3==80) ) {
                        alt145=1;
                    }
                }
            }
            switch (alt145) {
                case 1 :
                    // InternalWodel.g:7258:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getRandomTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalWodel.g:7262:4: ( (otherlv_4= RULE_ID ) )
                    // InternalWodel.g:7263:5: (otherlv_4= RULE_ID )
                    {
                    // InternalWodel.g:7263:5: (otherlv_4= RULE_ID )
                    // InternalWodel.g:7264:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_103); 

                    						newLeafNode(otherlv_4, grammarAccess.getRandomTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:7275:4: (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    int alt144=2;
                    int LA144_0 = input.LA(1);

                    if ( (LA144_0==39) ) {
                        int LA144_1 = input.LA(2);

                        if ( (LA144_1==RULE_ID) ) {
                            int LA144_3 = input.LA(3);

                            if ( (LA144_3==EOF||LA144_3==RULE_ID||LA144_3==11||LA144_3==14||(LA144_3>=23 && LA144_3<=24)||LA144_3==26||LA144_3==30||LA144_3==32||(LA144_3>=38 && LA144_3<=39)||(LA144_3>=43 && LA144_3<=44)||LA144_3==59||LA144_3==63||(LA144_3>=66 && LA144_3<=67)||(LA144_3>=70 && LA144_3<=73)||LA144_3==80) ) {
                                alt144=1;
                            }
                        }
                    }
                    switch (alt144) {
                        case 1 :
                            // InternalWodel.g:7276:5: otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            {
                            otherlv_5=(Token)match(input,39,FOLLOW_7); 

                            					newLeafNode(otherlv_5, grammarAccess.getRandomTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_0());
                            				
                            // InternalWodel.g:7280:5: ( (otherlv_6= RULE_ID ) )
                            // InternalWodel.g:7281:6: (otherlv_6= RULE_ID )
                            {
                            // InternalWodel.g:7281:6: (otherlv_6= RULE_ID )
                            // InternalWodel.g:7282:7: otherlv_6= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                            							}
                            						
                            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_103); 

                            							newLeafNode(otherlv_6, grammarAccess.getRandomTypeSelectionAccess().getRefRefTypeEReferenceCrossReference_3_2_1_0());
                            						

                            }


                            }

                            // InternalWodel.g:7293:5: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            int alt143=2;
                            int LA143_0 = input.LA(1);

                            if ( (LA143_0==39) ) {
                                int LA143_1 = input.LA(2);

                                if ( (LA143_1==RULE_ID) ) {
                                    int LA143_3 = input.LA(3);

                                    if ( (LA143_3==EOF||LA143_3==RULE_ID||LA143_3==11||LA143_3==14||(LA143_3>=23 && LA143_3<=24)||LA143_3==26||LA143_3==30||LA143_3==32||(LA143_3>=38 && LA143_3<=39)||(LA143_3>=43 && LA143_3<=44)||LA143_3==59||LA143_3==63||(LA143_3>=66 && LA143_3<=67)||(LA143_3>=70 && LA143_3<=73)||LA143_3==80) ) {
                                        alt143=1;
                                    }
                                }
                            }
                            switch (alt143) {
                                case 1 :
                                    // InternalWodel.g:7294:6: otherlv_7= '->' ( (otherlv_8= RULE_ID ) )
                                    {
                                    otherlv_7=(Token)match(input,39,FOLLOW_7); 

                                    						newLeafNode(otherlv_7, grammarAccess.getRandomTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_2_0());
                                    					
                                    // InternalWodel.g:7298:6: ( (otherlv_8= RULE_ID ) )
                                    // InternalWodel.g:7299:7: (otherlv_8= RULE_ID )
                                    {
                                    // InternalWodel.g:7299:7: (otherlv_8= RULE_ID )
                                    // InternalWodel.g:7300:8: otherlv_8= RULE_ID
                                    {

                                    								if (current==null) {
                                    									current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                                    								}
                                    							
                                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_104); 

                                    								newLeafNode(otherlv_8, grammarAccess.getRandomTypeSelectionAccess().getRefRefRefTypeEReferenceCrossReference_3_2_2_1_0());
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalWodel.g:7314:3: (otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources' )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==24) ) {
                int LA146_1 = input.LA(2);

                if ( (LA146_1==RULE_ID) ) {
                    int LA146_3 = input.LA(3);

                    if ( (LA146_3==25) ) {
                        alt146=1;
                    }
                }
            }
            switch (alt146) {
                case 1 :
                    // InternalWodel.g:7315:4: otherlv_9= 'from' ( (lv_resource_10_0= RULE_ID ) ) otherlv_11= 'resources'
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getRandomTypeSelectionAccess().getFromKeyword_4_0());
                    			
                    // InternalWodel.g:7319:4: ( (lv_resource_10_0= RULE_ID ) )
                    // InternalWodel.g:7320:5: (lv_resource_10_0= RULE_ID )
                    {
                    // InternalWodel.g:7320:5: (lv_resource_10_0= RULE_ID )
                    // InternalWodel.g:7321:6: lv_resource_10_0= RULE_ID
                    {
                    lv_resource_10_0=(Token)match(input,RULE_ID,FOLLOW_22); 

                    						newLeafNode(lv_resource_10_0, grammarAccess.getRandomTypeSelectionAccess().getResourceIDTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"resource",
                    							lv_resource_10_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,25,FOLLOW_105); 

                    				newLeafNode(otherlv_11, grammarAccess.getRandomTypeSelectionAccess().getResourcesKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalWodel.g:7342:3: (otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}' )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==80) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalWodel.g:7343:4: otherlv_12= 'where' otherlv_13= '{' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_12, grammarAccess.getRandomTypeSelectionAccess().getWhereKeyword_5_0());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_13, grammarAccess.getRandomTypeSelectionAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalWodel.g:7351:4: ( (lv_expression_14_0= ruleExpression ) )
                    // InternalWodel.g:7352:5: (lv_expression_14_0= ruleExpression )
                    {
                    // InternalWodel.g:7352:5: (lv_expression_14_0= ruleExpression )
                    // InternalWodel.g:7353:6: lv_expression_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getRandomTypeSelectionAccess().getExpressionExpressionParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomTypeSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_14_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getRandomTypeSelectionAccess().getRightCurlyBracketKeyword_5_3());
                    			

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
    // InternalWodel.g:7379:1: entryRuleSpecificObjectSelection returns [EObject current=null] : iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF ;
    public final EObject entryRuleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificObjectSelection = null;


        try {
            // InternalWodel.g:7379:64: (iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF )
            // InternalWodel.g:7380:2: iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificObjectSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificObjectSelection=ruleSpecificObjectSelection();

            state._fsp--;

             current =iv_ruleSpecificObjectSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7386:1: ruleSpecificObjectSelection returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )? (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )? ) ;
    public final EObject ruleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_expression_10_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7392:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )? (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )? ) )
            // InternalWodel.g:7393:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )? (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )? )
            {
            // InternalWodel.g:7393:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )? (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )? )
            // InternalWodel.g:7394:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )? (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )?
            {
            // InternalWodel.g:7394:3: ()
            // InternalWodel.g:7395:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificObjectSelectionAccess().getSpecificObjectSelectionAction_0(),
            					current);
            			

            }

            // InternalWodel.g:7401:3: ( (otherlv_1= RULE_ID ) )
            // InternalWodel.g:7402:4: (otherlv_1= RULE_ID )
            {
            // InternalWodel.g:7402:4: (otherlv_1= RULE_ID )
            // InternalWodel.g:7403:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_106); 

            					newLeafNode(otherlv_1, grammarAccess.getSpecificObjectSelectionAccess().getObjSelObjectEmitterCrossReference_1_0());
            				

            }


            }

            // InternalWodel.g:7414:3: (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )? )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==39) ) {
                int LA150_1 = input.LA(2);

                if ( (LA150_1==RULE_ID) ) {
                    int LA150_3 = input.LA(3);

                    if ( (LA150_3==EOF||LA150_3==RULE_ID||LA150_3==11||LA150_3==14||(LA150_3>=23 && LA150_3<=24)||LA150_3==26||LA150_3==30||LA150_3==32||(LA150_3>=38 && LA150_3<=39)||(LA150_3>=43 && LA150_3<=44)||LA150_3==59||LA150_3==63||(LA150_3>=66 && LA150_3<=67)||(LA150_3>=70 && LA150_3<=73)||LA150_3==80) ) {
                        alt150=1;
                    }
                }
            }
            switch (alt150) {
                case 1 :
                    // InternalWodel.g:7415:4: otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )?
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getSpecificObjectSelectionAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                    			
                    // InternalWodel.g:7419:4: ( (otherlv_3= RULE_ID ) )
                    // InternalWodel.g:7420:5: (otherlv_3= RULE_ID )
                    {
                    // InternalWodel.g:7420:5: (otherlv_3= RULE_ID )
                    // InternalWodel.g:7421:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_106); 

                    						newLeafNode(otherlv_3, grammarAccess.getSpecificObjectSelectionAccess().getRefTypeEReferenceCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:7432:4: (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? )?
                    int alt149=2;
                    int LA149_0 = input.LA(1);

                    if ( (LA149_0==39) ) {
                        int LA149_1 = input.LA(2);

                        if ( (LA149_1==RULE_ID) ) {
                            int LA149_3 = input.LA(3);

                            if ( (LA149_3==EOF||LA149_3==RULE_ID||LA149_3==11||LA149_3==14||(LA149_3>=23 && LA149_3<=24)||LA149_3==26||LA149_3==30||LA149_3==32||(LA149_3>=38 && LA149_3<=39)||(LA149_3>=43 && LA149_3<=44)||LA149_3==59||LA149_3==63||(LA149_3>=66 && LA149_3<=67)||(LA149_3>=70 && LA149_3<=73)||LA149_3==80) ) {
                                alt149=1;
                            }
                        }
                    }
                    switch (alt149) {
                        case 1 :
                            // InternalWodel.g:7433:5: otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
                            {
                            otherlv_4=(Token)match(input,39,FOLLOW_7); 

                            					newLeafNode(otherlv_4, grammarAccess.getSpecificObjectSelectionAccess().getHyphenMinusGreaterThanSignKeyword_2_2_0());
                            				
                            // InternalWodel.g:7437:5: ( (otherlv_5= RULE_ID ) )
                            // InternalWodel.g:7438:6: (otherlv_5= RULE_ID )
                            {
                            // InternalWodel.g:7438:6: (otherlv_5= RULE_ID )
                            // InternalWodel.g:7439:7: otherlv_5= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
                            							}
                            						
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_106); 

                            							newLeafNode(otherlv_5, grammarAccess.getSpecificObjectSelectionAccess().getRefRefTypeEReferenceCrossReference_2_2_1_0());
                            						

                            }


                            }

                            // InternalWodel.g:7450:5: (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
                            int alt148=2;
                            int LA148_0 = input.LA(1);

                            if ( (LA148_0==39) ) {
                                int LA148_1 = input.LA(2);

                                if ( (LA148_1==RULE_ID) ) {
                                    int LA148_3 = input.LA(3);

                                    if ( (LA148_3==EOF||LA148_3==RULE_ID||LA148_3==11||LA148_3==14||(LA148_3>=23 && LA148_3<=24)||LA148_3==26||LA148_3==30||LA148_3==32||(LA148_3>=38 && LA148_3<=39)||(LA148_3>=43 && LA148_3<=44)||LA148_3==59||LA148_3==63||(LA148_3>=66 && LA148_3<=67)||(LA148_3>=70 && LA148_3<=73)||LA148_3==80) ) {
                                        alt148=1;
                                    }
                                }
                            }
                            switch (alt148) {
                                case 1 :
                                    // InternalWodel.g:7451:6: otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                                    {
                                    otherlv_6=(Token)match(input,39,FOLLOW_7); 

                                    						newLeafNode(otherlv_6, grammarAccess.getSpecificObjectSelectionAccess().getHyphenMinusGreaterThanSignKeyword_2_2_2_0());
                                    					
                                    // InternalWodel.g:7455:6: ( (otherlv_7= RULE_ID ) )
                                    // InternalWodel.g:7456:7: (otherlv_7= RULE_ID )
                                    {
                                    // InternalWodel.g:7456:7: (otherlv_7= RULE_ID )
                                    // InternalWodel.g:7457:8: otherlv_7= RULE_ID
                                    {

                                    								if (current==null) {
                                    									current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
                                    								}
                                    							
                                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_105); 

                                    								newLeafNode(otherlv_7, grammarAccess.getSpecificObjectSelectionAccess().getRefRefRefTypeEReferenceCrossReference_2_2_2_1_0());
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalWodel.g:7471:3: (otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}' )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==80) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalWodel.g:7472:4: otherlv_8= 'where' otherlv_9= '{' ( (lv_expression_10_0= ruleExpression ) ) otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getSpecificObjectSelectionAccess().getWhereKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_9, grammarAccess.getSpecificObjectSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalWodel.g:7480:4: ( (lv_expression_10_0= ruleExpression ) )
                    // InternalWodel.g:7481:5: (lv_expression_10_0= ruleExpression )
                    {
                    // InternalWodel.g:7481:5: (lv_expression_10_0= ruleExpression )
                    // InternalWodel.g:7482:6: lv_expression_10_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getSpecificObjectSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_10_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSpecificObjectSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_10_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getSpecificObjectSelectionAccess().getRightCurlyBracketKeyword_3_3());
                    			

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
    // InternalWodel.g:7508:1: entryRuleSpecificClosureSelection returns [EObject current=null] : iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF ;
    public final EObject entryRuleSpecificClosureSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificClosureSelection = null;


        try {
            // InternalWodel.g:7508:65: (iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF )
            // InternalWodel.g:7509:2: iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificClosureSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificClosureSelection=ruleSpecificClosureSelection();

            state._fsp--;

             current =iv_ruleSpecificClosureSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7515:1: ruleSpecificClosureSelection returns [EObject current=null] : ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )? otherlv_10= ')' (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )? ) ;
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
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_expression_13_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7521:2: ( ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )? otherlv_10= ')' (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )? ) )
            // InternalWodel.g:7522:2: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )? otherlv_10= ')' (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )? )
            {
            // InternalWodel.g:7522:2: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )? otherlv_10= ')' (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )? )
            // InternalWodel.g:7523:3: () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )? otherlv_10= ')' (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )?
            {
            // InternalWodel.g:7523:3: ()
            // InternalWodel.g:7524:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificClosureSelectionAccess().getSpecificClosureSelectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,81,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificClosureSelectionAccess().getClosureKeyword_1());
            		
            otherlv_2=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecificClosureSelectionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWodel.g:7538:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:7539:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:7539:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:7540:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_107); 

            					newLeafNode(otherlv_3, grammarAccess.getSpecificClosureSelectionAccess().getObjSelObjectEmitterCrossReference_3_0());
            				

            }


            }

            // InternalWodel.g:7551:3: (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )? )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==39) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // InternalWodel.g:7552:4: otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )?
                    {
                    otherlv_4=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getSpecificClosureSelectionAccess().getHyphenMinusGreaterThanSignKeyword_4_0());
                    			
                    // InternalWodel.g:7556:4: ( (otherlv_5= RULE_ID ) )
                    // InternalWodel.g:7557:5: (otherlv_5= RULE_ID )
                    {
                    // InternalWodel.g:7557:5: (otherlv_5= RULE_ID )
                    // InternalWodel.g:7558:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_107); 

                    						newLeafNode(otherlv_5, grammarAccess.getSpecificClosureSelectionAccess().getRefTypeEReferenceCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:7569:4: (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )? )?
                    int alt153=2;
                    int LA153_0 = input.LA(1);

                    if ( (LA153_0==39) ) {
                        alt153=1;
                    }
                    switch (alt153) {
                        case 1 :
                            // InternalWodel.g:7570:5: otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )?
                            {
                            otherlv_6=(Token)match(input,39,FOLLOW_7); 

                            					newLeafNode(otherlv_6, grammarAccess.getSpecificClosureSelectionAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0());
                            				
                            // InternalWodel.g:7574:5: ( (otherlv_7= RULE_ID ) )
                            // InternalWodel.g:7575:6: (otherlv_7= RULE_ID )
                            {
                            // InternalWodel.g:7575:6: (otherlv_7= RULE_ID )
                            // InternalWodel.g:7576:7: otherlv_7= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
                            							}
                            						
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_107); 

                            							newLeafNode(otherlv_7, grammarAccess.getSpecificClosureSelectionAccess().getRefRefTypeEReferenceCrossReference_4_2_1_0());
                            						

                            }


                            }

                            // InternalWodel.g:7587:5: (otherlv_8= '->' ( (otherlv_9= RULE_ID ) ) )?
                            int alt152=2;
                            int LA152_0 = input.LA(1);

                            if ( (LA152_0==39) ) {
                                alt152=1;
                            }
                            switch (alt152) {
                                case 1 :
                                    // InternalWodel.g:7588:6: otherlv_8= '->' ( (otherlv_9= RULE_ID ) )
                                    {
                                    otherlv_8=(Token)match(input,39,FOLLOW_7); 

                                    						newLeafNode(otherlv_8, grammarAccess.getSpecificClosureSelectionAccess().getHyphenMinusGreaterThanSignKeyword_4_2_2_0());
                                    					
                                    // InternalWodel.g:7592:6: ( (otherlv_9= RULE_ID ) )
                                    // InternalWodel.g:7593:7: (otherlv_9= RULE_ID )
                                    {
                                    // InternalWodel.g:7593:7: (otherlv_9= RULE_ID )
                                    // InternalWodel.g:7594:8: otherlv_9= RULE_ID
                                    {

                                    								if (current==null) {
                                    									current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
                                    								}
                                    							
                                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_97); 

                                    								newLeafNode(otherlv_9, grammarAccess.getSpecificClosureSelectionAccess().getRefRefRefTypeEReferenceCrossReference_4_2_2_1_0());
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,45,FOLLOW_105); 

            			newLeafNode(otherlv_10, grammarAccess.getSpecificClosureSelectionAccess().getRightParenthesisKeyword_5());
            		
            // InternalWodel.g:7612:3: (otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}' )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==80) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // InternalWodel.g:7613:4: otherlv_11= 'where' otherlv_12= '{' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_11, grammarAccess.getSpecificClosureSelectionAccess().getWhereKeyword_6_0());
                    			
                    otherlv_12=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_12, grammarAccess.getSpecificClosureSelectionAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalWodel.g:7621:4: ( (lv_expression_13_0= ruleExpression ) )
                    // InternalWodel.g:7622:5: (lv_expression_13_0= ruleExpression )
                    {
                    // InternalWodel.g:7622:5: (lv_expression_13_0= ruleExpression )
                    // InternalWodel.g:7623:6: lv_expression_13_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getSpecificClosureSelectionAccess().getExpressionExpressionParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_13_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSpecificClosureSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_13_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getSpecificClosureSelectionAccess().getRightCurlyBracketKeyword_6_3());
                    			

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
    // InternalWodel.g:7649:1: entryRuleCompleteTypeSelection returns [EObject current=null] : iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF ;
    public final EObject entryRuleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteTypeSelection = null;


        try {
            // InternalWodel.g:7649:62: (iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF )
            // InternalWodel.g:7650:2: iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteTypeSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompleteTypeSelection=ruleCompleteTypeSelection();

            state._fsp--;

             current =iv_ruleCompleteTypeSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7656:1: ruleCompleteTypeSelection returns [EObject current=null] : ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? ) ;
    public final EObject ruleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_expression_11_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7662:2: ( ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? ) )
            // InternalWodel.g:7663:2: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? )
            {
            // InternalWodel.g:7663:2: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? )
            // InternalWodel.g:7664:3: () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )?
            {
            // InternalWodel.g:7664:3: ()
            // InternalWodel.g:7665:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompleteTypeSelectionAccess().getCompleteTypeSelectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,62,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getCompleteTypeSelectionAccess().getAllKeyword_1());
            		
            // InternalWodel.g:7675:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7676:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7676:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7677:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_106); 

            					newLeafNode(otherlv_2, grammarAccess.getCompleteTypeSelectionAccess().getTypeEClassCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:7688:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==39) ) {
                int LA158_1 = input.LA(2);

                if ( (LA158_1==RULE_ID) ) {
                    int LA158_3 = input.LA(3);

                    if ( (LA158_3==EOF||LA158_3==RULE_ID||LA158_3==11||LA158_3==14||(LA158_3>=23 && LA158_3<=24)||LA158_3==26||LA158_3==30||LA158_3==32||(LA158_3>=38 && LA158_3<=39)||(LA158_3>=43 && LA158_3<=44)||LA158_3==59||LA158_3==63||(LA158_3>=66 && LA158_3<=67)||(LA158_3>=70 && LA158_3<=73)||LA158_3==80) ) {
                        alt158=1;
                    }
                }
            }
            switch (alt158) {
                case 1 :
                    // InternalWodel.g:7689:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getCompleteTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalWodel.g:7693:4: ( (otherlv_4= RULE_ID ) )
                    // InternalWodel.g:7694:5: (otherlv_4= RULE_ID )
                    {
                    // InternalWodel.g:7694:5: (otherlv_4= RULE_ID )
                    // InternalWodel.g:7695:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_106); 

                    						newLeafNode(otherlv_4, grammarAccess.getCompleteTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:7706:4: (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    int alt157=2;
                    int LA157_0 = input.LA(1);

                    if ( (LA157_0==39) ) {
                        int LA157_1 = input.LA(2);

                        if ( (LA157_1==RULE_ID) ) {
                            int LA157_3 = input.LA(3);

                            if ( (LA157_3==EOF||LA157_3==RULE_ID||LA157_3==11||LA157_3==14||(LA157_3>=23 && LA157_3<=24)||LA157_3==26||LA157_3==30||LA157_3==32||(LA157_3>=38 && LA157_3<=39)||(LA157_3>=43 && LA157_3<=44)||LA157_3==59||LA157_3==63||(LA157_3>=66 && LA157_3<=67)||(LA157_3>=70 && LA157_3<=73)||LA157_3==80) ) {
                                alt157=1;
                            }
                        }
                    }
                    switch (alt157) {
                        case 1 :
                            // InternalWodel.g:7707:5: otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            {
                            otherlv_5=(Token)match(input,39,FOLLOW_7); 

                            					newLeafNode(otherlv_5, grammarAccess.getCompleteTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_0());
                            				
                            // InternalWodel.g:7711:5: ( (otherlv_6= RULE_ID ) )
                            // InternalWodel.g:7712:6: (otherlv_6= RULE_ID )
                            {
                            // InternalWodel.g:7712:6: (otherlv_6= RULE_ID )
                            // InternalWodel.g:7713:7: otherlv_6= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
                            							}
                            						
                            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_106); 

                            							newLeafNode(otherlv_6, grammarAccess.getCompleteTypeSelectionAccess().getRefRefTypeEReferenceCrossReference_3_2_1_0());
                            						

                            }


                            }

                            // InternalWodel.g:7724:5: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            int alt156=2;
                            int LA156_0 = input.LA(1);

                            if ( (LA156_0==39) ) {
                                int LA156_1 = input.LA(2);

                                if ( (LA156_1==RULE_ID) ) {
                                    int LA156_3 = input.LA(3);

                                    if ( (LA156_3==EOF||LA156_3==RULE_ID||LA156_3==11||LA156_3==14||(LA156_3>=23 && LA156_3<=24)||LA156_3==26||LA156_3==30||LA156_3==32||(LA156_3>=38 && LA156_3<=39)||(LA156_3>=43 && LA156_3<=44)||LA156_3==59||LA156_3==63||(LA156_3>=66 && LA156_3<=67)||(LA156_3>=70 && LA156_3<=73)||LA156_3==80) ) {
                                        alt156=1;
                                    }
                                }
                            }
                            switch (alt156) {
                                case 1 :
                                    // InternalWodel.g:7725:6: otherlv_7= '->' ( (otherlv_8= RULE_ID ) )
                                    {
                                    otherlv_7=(Token)match(input,39,FOLLOW_7); 

                                    						newLeafNode(otherlv_7, grammarAccess.getCompleteTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_2_0());
                                    					
                                    // InternalWodel.g:7729:6: ( (otherlv_8= RULE_ID ) )
                                    // InternalWodel.g:7730:7: (otherlv_8= RULE_ID )
                                    {
                                    // InternalWodel.g:7730:7: (otherlv_8= RULE_ID )
                                    // InternalWodel.g:7731:8: otherlv_8= RULE_ID
                                    {

                                    								if (current==null) {
                                    									current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
                                    								}
                                    							
                                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_105); 

                                    								newLeafNode(otherlv_8, grammarAccess.getCompleteTypeSelectionAccess().getRefRefRefTypeEReferenceCrossReference_3_2_2_1_0());
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalWodel.g:7745:3: (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==80) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalWodel.g:7746:4: otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getCompleteTypeSelectionAccess().getWhereKeyword_4_0());
                    			
                    otherlv_10=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_10, grammarAccess.getCompleteTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalWodel.g:7754:4: ( (lv_expression_11_0= ruleExpression ) )
                    // InternalWodel.g:7755:5: (lv_expression_11_0= ruleExpression )
                    {
                    // InternalWodel.g:7755:5: (lv_expression_11_0= ruleExpression )
                    // InternalWodel.g:7756:6: lv_expression_11_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getCompleteTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_11_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompleteTypeSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_11_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getCompleteTypeSelectionAccess().getRightCurlyBracketKeyword_4_3());
                    			

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
    // InternalWodel.g:7782:1: entryRuleOtherTypeSelection returns [EObject current=null] : iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF ;
    public final EObject entryRuleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTypeSelection = null;


        try {
            // InternalWodel.g:7782:59: (iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF )
            // InternalWodel.g:7783:2: iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherTypeSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherTypeSelection=ruleOtherTypeSelection();

            state._fsp--;

             current =iv_ruleOtherTypeSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7789:1: ruleOtherTypeSelection returns [EObject current=null] : ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? ) ;
    public final EObject ruleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_expression_11_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7795:2: ( ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? ) )
            // InternalWodel.g:7796:2: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? )
            {
            // InternalWodel.g:7796:2: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )? )
            // InternalWodel.g:7797:3: () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )? (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )?
            {
            // InternalWodel.g:7797:3: ()
            // InternalWodel.g:7798:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOtherTypeSelectionAccess().getOtherTypeSelectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,82,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOtherTypeSelectionAccess().getOtherKeyword_1());
            		
            // InternalWodel.g:7808:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7809:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7809:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7810:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_106); 

            					newLeafNode(otherlv_2, grammarAccess.getOtherTypeSelectionAccess().getTypeEClassCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:7821:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )? )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==39) ) {
                int LA162_1 = input.LA(2);

                if ( (LA162_1==RULE_ID) ) {
                    int LA162_3 = input.LA(3);

                    if ( (LA162_3==EOF||LA162_3==RULE_ID||LA162_3==11||LA162_3==14||(LA162_3>=23 && LA162_3<=24)||LA162_3==26||LA162_3==30||LA162_3==32||(LA162_3>=38 && LA162_3<=39)||(LA162_3>=43 && LA162_3<=44)||LA162_3==59||LA162_3==63||(LA162_3>=66 && LA162_3<=67)||(LA162_3>=70 && LA162_3<=73)||LA162_3==80) ) {
                        alt162=1;
                    }
                }
            }
            switch (alt162) {
                case 1 :
                    // InternalWodel.g:7822:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getOtherTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalWodel.g:7826:4: ( (otherlv_4= RULE_ID ) )
                    // InternalWodel.g:7827:5: (otherlv_4= RULE_ID )
                    {
                    // InternalWodel.g:7827:5: (otherlv_4= RULE_ID )
                    // InternalWodel.g:7828:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_106); 

                    						newLeafNode(otherlv_4, grammarAccess.getOtherTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalWodel.g:7839:4: (otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )? )?
                    int alt161=2;
                    int LA161_0 = input.LA(1);

                    if ( (LA161_0==39) ) {
                        int LA161_1 = input.LA(2);

                        if ( (LA161_1==RULE_ID) ) {
                            int LA161_3 = input.LA(3);

                            if ( (LA161_3==EOF||LA161_3==RULE_ID||LA161_3==11||LA161_3==14||(LA161_3>=23 && LA161_3<=24)||LA161_3==26||LA161_3==30||LA161_3==32||(LA161_3>=38 && LA161_3<=39)||(LA161_3>=43 && LA161_3<=44)||LA161_3==59||LA161_3==63||(LA161_3>=66 && LA161_3<=67)||(LA161_3>=70 && LA161_3<=73)||LA161_3==80) ) {
                                alt161=1;
                            }
                        }
                    }
                    switch (alt161) {
                        case 1 :
                            // InternalWodel.g:7840:5: otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            {
                            otherlv_5=(Token)match(input,39,FOLLOW_7); 

                            					newLeafNode(otherlv_5, grammarAccess.getOtherTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_0());
                            				
                            // InternalWodel.g:7844:5: ( (otherlv_6= RULE_ID ) )
                            // InternalWodel.g:7845:6: (otherlv_6= RULE_ID )
                            {
                            // InternalWodel.g:7845:6: (otherlv_6= RULE_ID )
                            // InternalWodel.g:7846:7: otherlv_6= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
                            							}
                            						
                            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_106); 

                            							newLeafNode(otherlv_6, grammarAccess.getOtherTypeSelectionAccess().getRefRefTypeEReferenceCrossReference_3_2_1_0());
                            						

                            }


                            }

                            // InternalWodel.g:7857:5: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) )?
                            int alt160=2;
                            int LA160_0 = input.LA(1);

                            if ( (LA160_0==39) ) {
                                int LA160_1 = input.LA(2);

                                if ( (LA160_1==RULE_ID) ) {
                                    int LA160_3 = input.LA(3);

                                    if ( (LA160_3==EOF||LA160_3==RULE_ID||LA160_3==11||LA160_3==14||(LA160_3>=23 && LA160_3<=24)||LA160_3==26||LA160_3==30||LA160_3==32||(LA160_3>=38 && LA160_3<=39)||(LA160_3>=43 && LA160_3<=44)||LA160_3==59||LA160_3==63||(LA160_3>=66 && LA160_3<=67)||(LA160_3>=70 && LA160_3<=73)||LA160_3==80) ) {
                                        alt160=1;
                                    }
                                }
                            }
                            switch (alt160) {
                                case 1 :
                                    // InternalWodel.g:7858:6: otherlv_7= '->' ( (otherlv_8= RULE_ID ) )
                                    {
                                    otherlv_7=(Token)match(input,39,FOLLOW_7); 

                                    						newLeafNode(otherlv_7, grammarAccess.getOtherTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_2_2_0());
                                    					
                                    // InternalWodel.g:7862:6: ( (otherlv_8= RULE_ID ) )
                                    // InternalWodel.g:7863:7: (otherlv_8= RULE_ID )
                                    {
                                    // InternalWodel.g:7863:7: (otherlv_8= RULE_ID )
                                    // InternalWodel.g:7864:8: otherlv_8= RULE_ID
                                    {

                                    								if (current==null) {
                                    									current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
                                    								}
                                    							
                                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_105); 

                                    								newLeafNode(otherlv_8, grammarAccess.getOtherTypeSelectionAccess().getRefRefRefTypeEReferenceCrossReference_3_2_2_1_0());
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalWodel.g:7878:3: (otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}' )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==80) ) {
                alt163=1;
            }
            switch (alt163) {
                case 1 :
                    // InternalWodel.g:7879:4: otherlv_9= 'where' otherlv_10= '{' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getOtherTypeSelectionAccess().getWhereKeyword_4_0());
                    			
                    otherlv_10=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_10, grammarAccess.getOtherTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalWodel.g:7887:4: ( (lv_expression_11_0= ruleExpression ) )
                    // InternalWodel.g:7888:5: (lv_expression_11_0= ruleExpression )
                    {
                    // InternalWodel.g:7888:5: (lv_expression_11_0= ruleExpression )
                    // InternalWodel.g:7889:6: lv_expression_11_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getOtherTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_11_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherTypeSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_11_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getOtherTypeSelectionAccess().getRightCurlyBracketKeyword_4_3());
                    			

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


    // $ANTLR start "entryRuleTypedSelection"
    // InternalWodel.g:7915:1: entryRuleTypedSelection returns [EObject current=null] : iv_ruleTypedSelection= ruleTypedSelection EOF ;
    public final EObject entryRuleTypedSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedSelection = null;


        try {
            // InternalWodel.g:7915:55: (iv_ruleTypedSelection= ruleTypedSelection EOF )
            // InternalWodel.g:7916:2: iv_ruleTypedSelection= ruleTypedSelection EOF
            {
             newCompositeNode(grammarAccess.getTypedSelectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedSelection=ruleTypedSelection();

            state._fsp--;

             current =iv_ruleTypedSelection; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypedSelection"


    // $ANTLR start "ruleTypedSelection"
    // InternalWodel.g:7922:1: ruleTypedSelection returns [EObject current=null] : ( () otherlv_1= 'typed' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleTypedSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:7928:2: ( ( () otherlv_1= 'typed' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // InternalWodel.g:7929:2: ( () otherlv_1= 'typed' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // InternalWodel.g:7929:2: ( () otherlv_1= 'typed' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // InternalWodel.g:7930:3: () otherlv_1= 'typed' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // InternalWodel.g:7930:3: ()
            // InternalWodel.g:7931:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTypedSelectionAccess().getTypedSelectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,83,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTypedSelectionAccess().getTypedKeyword_1());
            		
            // InternalWodel.g:7941:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:7942:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:7942:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:7943:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypedSelectionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_105); 

            					newLeafNode(otherlv_2, grammarAccess.getTypedSelectionAccess().getTypeEClassCrossReference_2_0());
            				

            }


            }

            // InternalWodel.g:7954:3: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==80) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // InternalWodel.g:7955:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,80,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getTypedSelectionAccess().getWhereKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,13,FOLLOW_65); 

                    				newLeafNode(otherlv_4, grammarAccess.getTypedSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalWodel.g:7963:4: ( (lv_expression_5_0= ruleExpression ) )
                    // InternalWodel.g:7964:5: (lv_expression_5_0= ruleExpression )
                    {
                    // InternalWodel.g:7964:5: (lv_expression_5_0= ruleExpression )
                    // InternalWodel.g:7965:6: lv_expression_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getTypedSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypedSelectionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_5_0,
                    							"wodel.dsls.Wodel.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getTypedSelectionAccess().getRightCurlyBracketKeyword_3_3());
                    			

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
    // $ANTLR end "ruleTypedSelection"


    // $ANTLR start "entryRuleBooleanType"
    // InternalWodel.g:7991:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalWodel.g:7991:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalWodel.g:7992:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:7998:1: ruleBooleanType returns [EObject current=null] : (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificBooleanType_0 = null;

        EObject this_RandomBooleanType_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:8004:2: ( (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) )
            // InternalWodel.g:8005:2: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            {
            // InternalWodel.g:8005:2: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            int alt165=2;
            alt165 = dfa165.predict(input);
            switch (alt165) {
                case 1 :
                    // InternalWodel.g:8006:3: this_SpecificBooleanType_0= ruleSpecificBooleanType
                    {

                    			newCompositeNode(grammarAccess.getBooleanTypeAccess().getSpecificBooleanTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificBooleanType_0=ruleSpecificBooleanType();

                    state._fsp--;


                    			current = this_SpecificBooleanType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:8015:3: this_RandomBooleanType_1= ruleRandomBooleanType
                    {

                    			newCompositeNode(grammarAccess.getBooleanTypeAccess().getRandomBooleanTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:8027:1: entryRuleRandomBooleanType returns [EObject current=null] : iv_ruleRandomBooleanType= ruleRandomBooleanType EOF ;
    public final EObject entryRuleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomBooleanType = null;


        try {
            // InternalWodel.g:8027:58: (iv_ruleRandomBooleanType= ruleRandomBooleanType EOF )
            // InternalWodel.g:8028:2: iv_ruleRandomBooleanType= ruleRandomBooleanType EOF
            {
             newCompositeNode(grammarAccess.getRandomBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomBooleanType=ruleRandomBooleanType();

            state._fsp--;

             current =iv_ruleRandomBooleanType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8034:1: ruleRandomBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) ;
    public final EObject ruleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8040:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) )
            // InternalWodel.g:8041:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            {
            // InternalWodel.g:8041:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            // InternalWodel.g:8042:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean'
            {
            // InternalWodel.g:8042:3: ()
            // InternalWodel.g:8043:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8049:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8050:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8050:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8051:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_108);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomBooleanTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,84,FOLLOW_2); 

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
    // InternalWodel.g:8076:1: entryRuleSpecificBooleanType returns [EObject current=null] : iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF ;
    public final EObject entryRuleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificBooleanType = null;


        try {
            // InternalWodel.g:8076:60: (iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF )
            // InternalWodel.g:8077:2: iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF
            {
             newCompositeNode(grammarAccess.getSpecificBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificBooleanType=ruleSpecificBooleanType();

            state._fsp--;

             current =iv_ruleSpecificBooleanType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8083:1: ruleSpecificBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) ;
    public final EObject ruleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8089:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) )
            // InternalWodel.g:8090:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            {
            // InternalWodel.g:8090:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            // InternalWodel.g:8091:3: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) )
            {
            // InternalWodel.g:8091:3: ()
            // InternalWodel.g:8092:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificBooleanTypeAccess().getSpecificBooleanTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8098:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8099:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8099:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8100:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_109);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificBooleanTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:8117:3: ( (lv_value_2_0= ruleEBoolean ) )
            // InternalWodel.g:8118:4: (lv_value_2_0= ruleEBoolean )
            {
            // InternalWodel.g:8118:4: (lv_value_2_0= ruleEBoolean )
            // InternalWodel.g:8119:5: lv_value_2_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificBooleanTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Wodel.EBoolean");
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
    // InternalWodel.g:8140:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalWodel.g:8140:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalWodel.g:8141:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8147:1: ruleStringType returns [EObject current=null] : (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType | this_RandomStringNumberType_7= ruleRandomStringNumberType ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificStringType_0 = null;

        EObject this_RandomStringType_1 = null;

        EObject this_UpperStringType_2 = null;

        EObject this_LowerStringType_3 = null;

        EObject this_CatStartStringType_4 = null;

        EObject this_CatEndStringType_5 = null;

        EObject this_ReplaceStringType_6 = null;

        EObject this_RandomStringNumberType_7 = null;



        	enterRule();

        try {
            // InternalWodel.g:8153:2: ( (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType | this_RandomStringNumberType_7= ruleRandomStringNumberType ) )
            // InternalWodel.g:8154:2: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType | this_RandomStringNumberType_7= ruleRandomStringNumberType )
            {
            // InternalWodel.g:8154:2: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType | this_RandomStringNumberType_7= ruleRandomStringNumberType )
            int alt166=8;
            alt166 = dfa166.predict(input);
            switch (alt166) {
                case 1 :
                    // InternalWodel.g:8155:3: this_SpecificStringType_0= ruleSpecificStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getSpecificStringTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificStringType_0=ruleSpecificStringType();

                    state._fsp--;


                    			current = this_SpecificStringType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:8164:3: this_RandomStringType_1= ruleRandomStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RandomStringType_1=ruleRandomStringType();

                    state._fsp--;


                    			current = this_RandomStringType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWodel.g:8173:3: this_UpperStringType_2= ruleUpperStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getUpperStringTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpperStringType_2=ruleUpperStringType();

                    state._fsp--;


                    			current = this_UpperStringType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWodel.g:8182:3: this_LowerStringType_3= ruleLowerStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getLowerStringTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LowerStringType_3=ruleLowerStringType();

                    state._fsp--;


                    			current = this_LowerStringType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWodel.g:8191:3: this_CatStartStringType_4= ruleCatStartStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getCatStartStringTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_CatStartStringType_4=ruleCatStartStringType();

                    state._fsp--;


                    			current = this_CatStartStringType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWodel.g:8200:3: this_CatEndStringType_5= ruleCatEndStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getCatEndStringTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_CatEndStringType_5=ruleCatEndStringType();

                    state._fsp--;


                    			current = this_CatEndStringType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWodel.g:8209:3: this_ReplaceStringType_6= ruleReplaceStringType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getReplaceStringTypeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReplaceStringType_6=ruleReplaceStringType();

                    state._fsp--;


                    			current = this_ReplaceStringType_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalWodel.g:8218:3: this_RandomStringNumberType_7= ruleRandomStringNumberType
                    {

                    			newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringNumberTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_RandomStringNumberType_7=ruleRandomStringNumberType();

                    state._fsp--;


                    			current = this_RandomStringNumberType_7;
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
    // InternalWodel.g:8230:1: entryRuleRandomStringType returns [EObject current=null] : iv_ruleRandomStringType= ruleRandomStringType EOF ;
    public final EObject entryRuleRandomStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringType = null;


        try {
            // InternalWodel.g:8230:57: (iv_ruleRandomStringType= ruleRandomStringType EOF )
            // InternalWodel.g:8231:2: iv_ruleRandomStringType= ruleRandomStringType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomStringType=ruleRandomStringType();

            state._fsp--;

             current =iv_ruleRandomStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8237:1: ruleRandomStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) ;
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
            // InternalWodel.g:8243:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) )
            // InternalWodel.g:8244:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            {
            // InternalWodel.g:8244:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            // InternalWodel.g:8245:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
            {
            // InternalWodel.g:8245:3: ()
            // InternalWodel.g:8246:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomStringTypeAccess().getRandomStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8252:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8253:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8253:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8254:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_110);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,85,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomStringTypeAccess().getRandomStringKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getRandomStringTypeAccess().getLeftParenthesisKeyword_3());
            		
            // InternalWodel.g:8279:3: ( (lv_min_4_0= ruleEInt ) )
            // InternalWodel.g:8280:4: (lv_min_4_0= ruleEInt )
            {
            // InternalWodel.g:8280:4: (lv_min_4_0= ruleEInt )
            // InternalWodel.g:8281:5: lv_min_4_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMinEIntParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_98);
            lv_min_4_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_4_0,
            						"wodel.dsls.Wodel.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getRandomStringTypeAccess().getCommaKeyword_5());
            		
            // InternalWodel.g:8302:3: ( (lv_max_6_0= ruleEInt ) )
            // InternalWodel.g:8303:4: (lv_max_6_0= ruleEInt )
            {
            // InternalWodel.g:8303:4: (lv_max_6_0= ruleEInt )
            // InternalWodel.g:8304:5: lv_max_6_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMaxEIntParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_97);
            lv_max_6_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            					}
            					set(
            						current,
            						"max",
            						lv_max_6_0,
            						"wodel.dsls.Wodel.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:8329:1: entryRuleSpecificStringType returns [EObject current=null] : iv_ruleSpecificStringType= ruleSpecificStringType EOF ;
    public final EObject entryRuleSpecificStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificStringType = null;


        try {
            // InternalWodel.g:8329:59: (iv_ruleSpecificStringType= ruleSpecificStringType EOF )
            // InternalWodel.g:8330:2: iv_ruleSpecificStringType= ruleSpecificStringType EOF
            {
             newCompositeNode(grammarAccess.getSpecificStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificStringType=ruleSpecificStringType();

            state._fsp--;

             current =iv_ruleSpecificStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8336:1: ruleSpecificStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSpecificStringType() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8342:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalWodel.g:8343:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalWodel.g:8343:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalWodel.g:8344:3: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalWodel.g:8344:3: ()
            // InternalWodel.g:8345:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificStringTypeAccess().getSpecificStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8351:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8352:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8352:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8353:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getSpecificStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_111);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:8370:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalWodel.g:8371:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalWodel.g:8371:4: (lv_value_2_0= RULE_STRING )
            // InternalWodel.g:8372:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getSpecificStringTypeAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificStringTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // InternalWodel.g:8392:1: entryRuleUpperStringType returns [EObject current=null] : iv_ruleUpperStringType= ruleUpperStringType EOF ;
    public final EObject entryRuleUpperStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperStringType = null;


        try {
            // InternalWodel.g:8392:56: (iv_ruleUpperStringType= ruleUpperStringType EOF )
            // InternalWodel.g:8393:2: iv_ruleUpperStringType= ruleUpperStringType EOF
            {
             newCompositeNode(grammarAccess.getUpperStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpperStringType=ruleUpperStringType();

            state._fsp--;

             current =iv_ruleUpperStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8399:1: ruleUpperStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) ;
    public final EObject ruleUpperStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8405:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) )
            // InternalWodel.g:8406:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            {
            // InternalWodel.g:8406:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            // InternalWodel.g:8407:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper'
            {
            // InternalWodel.g:8407:3: ()
            // InternalWodel.g:8408:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUpperStringTypeAccess().getUpperStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8414:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8415:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8415:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8416:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getUpperStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_112);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUpperStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,86,FOLLOW_2); 

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
    // InternalWodel.g:8441:1: entryRuleCatStartStringType returns [EObject current=null] : iv_ruleCatStartStringType= ruleCatStartStringType EOF ;
    public final EObject entryRuleCatStartStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatStartStringType = null;


        try {
            // InternalWodel.g:8441:59: (iv_ruleCatStartStringType= ruleCatStartStringType EOF )
            // InternalWodel.g:8442:2: iv_ruleCatStartStringType= ruleCatStartStringType EOF
            {
             newCompositeNode(grammarAccess.getCatStartStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatStartStringType=ruleCatStartStringType();

            state._fsp--;

             current =iv_ruleCatStartStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8448:1: ruleCatStartStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatStartStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8454:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // InternalWodel.g:8455:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // InternalWodel.g:8455:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // InternalWodel.g:8456:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // InternalWodel.g:8456:3: ()
            // InternalWodel.g:8457:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCatStartStringTypeAccess().getCatStartStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8463:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8464:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8464:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8465:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_113);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCatStartStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,87,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getCatStartStringTypeAccess().getCatstartKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getCatStartStringTypeAccess().getLeftParenthesisKeyword_3());
            		
            // InternalWodel.g:8490:3: ( (lv_value_4_0= ruleEString ) )
            // InternalWodel.g:8491:4: (lv_value_4_0= ruleEString )
            {
            // InternalWodel.g:8491:4: (lv_value_4_0= ruleEString )
            // InternalWodel.g:8492:5: lv_value_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_97);
            lv_value_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCatStartStringTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:8517:1: entryRuleCatEndStringType returns [EObject current=null] : iv_ruleCatEndStringType= ruleCatEndStringType EOF ;
    public final EObject entryRuleCatEndStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatEndStringType = null;


        try {
            // InternalWodel.g:8517:57: (iv_ruleCatEndStringType= ruleCatEndStringType EOF )
            // InternalWodel.g:8518:2: iv_ruleCatEndStringType= ruleCatEndStringType EOF
            {
             newCompositeNode(grammarAccess.getCatEndStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatEndStringType=ruleCatEndStringType();

            state._fsp--;

             current =iv_ruleCatEndStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8524:1: ruleCatEndStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatEndStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8530:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // InternalWodel.g:8531:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // InternalWodel.g:8531:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // InternalWodel.g:8532:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // InternalWodel.g:8532:3: ()
            // InternalWodel.g:8533:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCatEndStringTypeAccess().getCatEndStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8539:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8540:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8540:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8541:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_114);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCatEndStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,88,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getCatEndStringTypeAccess().getCatendKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getCatEndStringTypeAccess().getLeftParenthesisKeyword_3());
            		
            // InternalWodel.g:8566:3: ( (lv_value_4_0= ruleEString ) )
            // InternalWodel.g:8567:4: (lv_value_4_0= ruleEString )
            {
            // InternalWodel.g:8567:4: (lv_value_4_0= ruleEString )
            // InternalWodel.g:8568:5: lv_value_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_97);
            lv_value_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCatEndStringTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:8593:1: entryRuleListStringType returns [EObject current=null] : iv_ruleListStringType= ruleListStringType EOF ;
    public final EObject entryRuleListStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListStringType = null;


        try {
            // InternalWodel.g:8593:55: (iv_ruleListStringType= ruleListStringType EOF )
            // InternalWodel.g:8594:2: iv_ruleListStringType= ruleListStringType EOF
            {
             newCompositeNode(grammarAccess.getListStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListStringType=ruleListStringType();

            state._fsp--;

             current =iv_ruleListStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8600:1: ruleListStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) ;
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
            // InternalWodel.g:8606:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) )
            // InternalWodel.g:8607:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            {
            // InternalWodel.g:8607:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            // InternalWodel.g:8608:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']'
            {
            // InternalWodel.g:8608:3: ()
            // InternalWodel.g:8609:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getListStringTypeAccess().getListStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8615:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8616:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8616:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8617:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getListStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_90);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getListStringTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalWodel.g:8638:3: ( (lv_value_3_0= ruleEString ) )
            // InternalWodel.g:8639:4: (lv_value_3_0= ruleEString )
            {
            // InternalWodel.g:8639:4: (lv_value_3_0= ruleEString )
            // InternalWodel.g:8640:5: lv_value_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_115);
            lv_value_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_3_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:8657:3: (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )*
            loop167:
            do {
                int alt167=2;
                int LA167_0 = input.LA(1);

                if ( (LA167_0==26) ) {
                    alt167=1;
                }


                switch (alt167) {
            	case 1 :
            	    // InternalWodel.g:8658:4: otherlv_4= ',' ( (lv_value_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_16); 

            	    				newLeafNode(otherlv_4, grammarAccess.getListStringTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalWodel.g:8662:4: ( (lv_value_5_0= ruleEString ) )
            	    // InternalWodel.g:8663:5: (lv_value_5_0= ruleEString )
            	    {
            	    // InternalWodel.g:8663:5: (lv_value_5_0= ruleEString )
            	    // InternalWodel.g:8664:6: lv_value_5_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_115);
            	    lv_value_5_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"value",
            	    							lv_value_5_0,
            	    							"wodel.dsls.Wodel.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop167;
                }
            } while (true);

            otherlv_6=(Token)match(input,32,FOLLOW_2); 

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
    // InternalWodel.g:8690:1: entryRuleLowerStringType returns [EObject current=null] : iv_ruleLowerStringType= ruleLowerStringType EOF ;
    public final EObject entryRuleLowerStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerStringType = null;


        try {
            // InternalWodel.g:8690:56: (iv_ruleLowerStringType= ruleLowerStringType EOF )
            // InternalWodel.g:8691:2: iv_ruleLowerStringType= ruleLowerStringType EOF
            {
             newCompositeNode(grammarAccess.getLowerStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLowerStringType=ruleLowerStringType();

            state._fsp--;

             current =iv_ruleLowerStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8697:1: ruleLowerStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) ;
    public final EObject ruleLowerStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8703:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) )
            // InternalWodel.g:8704:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            {
            // InternalWodel.g:8704:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            // InternalWodel.g:8705:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower'
            {
            // InternalWodel.g:8705:3: ()
            // InternalWodel.g:8706:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLowerStringTypeAccess().getLowerStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8712:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8713:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8713:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8714:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getLowerStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_116);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLowerStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,89,FOLLOW_2); 

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
    // InternalWodel.g:8739:1: entryRuleReplaceStringType returns [EObject current=null] : iv_ruleReplaceStringType= ruleReplaceStringType EOF ;
    public final EObject entryRuleReplaceStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceStringType = null;


        try {
            // InternalWodel.g:8739:58: (iv_ruleReplaceStringType= ruleReplaceStringType EOF )
            // InternalWodel.g:8740:2: iv_ruleReplaceStringType= ruleReplaceStringType EOF
            {
             newCompositeNode(grammarAccess.getReplaceStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReplaceStringType=ruleReplaceStringType();

            state._fsp--;

             current =iv_ruleReplaceStringType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8746:1: ruleReplaceStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) ;
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
            // InternalWodel.g:8752:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) )
            // InternalWodel.g:8753:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            {
            // InternalWodel.g:8753:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            // InternalWodel.g:8754:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')'
            {
            // InternalWodel.g:8754:3: ()
            // InternalWodel.g:8755:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getReplaceStringTypeAccess().getReplaceStringTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8761:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8762:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8762:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8763:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_117);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,90,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getReplaceStringTypeAccess().getReplaceKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getReplaceStringTypeAccess().getLeftParenthesisKeyword_3());
            		
            // InternalWodel.g:8788:3: ( (lv_oldstring_4_0= ruleEString ) )
            // InternalWodel.g:8789:4: (lv_oldstring_4_0= ruleEString )
            {
            // InternalWodel.g:8789:4: (lv_oldstring_4_0= ruleEString )
            // InternalWodel.g:8790:5: lv_oldstring_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_98);
            lv_oldstring_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            					}
            					set(
            						current,
            						"oldstring",
            						lv_oldstring_4_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getReplaceStringTypeAccess().getCommaKeyword_5());
            		
            // InternalWodel.g:8811:3: ( (lv_newstring_6_0= ruleEString ) )
            // InternalWodel.g:8812:4: (lv_newstring_6_0= ruleEString )
            {
            // InternalWodel.g:8812:4: (lv_newstring_6_0= ruleEString )
            // InternalWodel.g:8813:5: lv_newstring_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_97);
            lv_newstring_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            					}
            					set(
            						current,
            						"newstring",
            						lv_newstring_6_0,
            						"wodel.dsls.Wodel.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:8838:1: entryRuleDoubleType returns [EObject current=null] : iv_ruleDoubleType= ruleDoubleType EOF ;
    public final EObject entryRuleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleType = null;


        try {
            // InternalWodel.g:8838:51: (iv_ruleDoubleType= ruleDoubleType EOF )
            // InternalWodel.g:8839:2: iv_ruleDoubleType= ruleDoubleType EOF
            {
             newCompositeNode(grammarAccess.getDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleType=ruleDoubleType();

            state._fsp--;

             current =iv_ruleDoubleType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8845:1: ruleDoubleType returns [EObject current=null] : (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) ;
    public final EObject ruleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificDoubleType_0 = null;

        EObject this_RandomDoubleType_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:8851:2: ( (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) )
            // InternalWodel.g:8852:2: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            {
            // InternalWodel.g:8852:2: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            int alt168=2;
            alt168 = dfa168.predict(input);
            switch (alt168) {
                case 1 :
                    // InternalWodel.g:8853:3: this_SpecificDoubleType_0= ruleSpecificDoubleType
                    {

                    			newCompositeNode(grammarAccess.getDoubleTypeAccess().getSpecificDoubleTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificDoubleType_0=ruleSpecificDoubleType();

                    state._fsp--;


                    			current = this_SpecificDoubleType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:8862:3: this_RandomDoubleType_1= ruleRandomDoubleType
                    {

                    			newCompositeNode(grammarAccess.getDoubleTypeAccess().getRandomDoubleTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:8874:1: entryRuleRandomDoubleType returns [EObject current=null] : iv_ruleRandomDoubleType= ruleRandomDoubleType EOF ;
    public final EObject entryRuleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleType = null;


        try {
            // InternalWodel.g:8874:57: (iv_ruleRandomDoubleType= ruleRandomDoubleType EOF )
            // InternalWodel.g:8875:2: iv_ruleRandomDoubleType= ruleRandomDoubleType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomDoubleType=ruleRandomDoubleType();

            state._fsp--;

             current =iv_ruleRandomDoubleType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8881:1: ruleRandomDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) ;
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
            // InternalWodel.g:8887:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) )
            // InternalWodel.g:8888:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            {
            // InternalWodel.g:8888:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            // InternalWodel.g:8889:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            {
            // InternalWodel.g:8889:3: ()
            // InternalWodel.g:8890:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8896:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8897:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8897:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8898:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_118);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,91,FOLLOW_119); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleKeyword_2());
            		
            // InternalWodel.g:8919:3: (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==41) ) {
                alt169=1;
            }
            switch (alt169) {
                case 1 :
                    // InternalWodel.g:8920:4: otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_120); 

                    				newLeafNode(otherlv_3, grammarAccess.getRandomDoubleTypeAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalWodel.g:8924:4: ( (lv_min_4_0= ruleEDouble ) )
                    // InternalWodel.g:8925:5: (lv_min_4_0= ruleEDouble )
                    {
                    // InternalWodel.g:8925:5: (lv_min_4_0= ruleEDouble )
                    // InternalWodel.g:8926:6: lv_min_4_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMinEDoubleParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_min_4_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    						}
                    						set(
                    							current,
                    							"min",
                    							lv_min_4_0,
                    							"wodel.dsls.Wodel.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,26,FOLLOW_120); 

                    				newLeafNode(otherlv_5, grammarAccess.getRandomDoubleTypeAccess().getCommaKeyword_3_2());
                    			
                    // InternalWodel.g:8947:4: ( (lv_max_6_0= ruleEDouble ) )
                    // InternalWodel.g:8948:5: (lv_max_6_0= ruleEDouble )
                    {
                    // InternalWodel.g:8948:5: (lv_max_6_0= ruleEDouble )
                    // InternalWodel.g:8949:6: lv_max_6_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMaxEDoubleParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_97);
                    lv_max_6_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_6_0,
                    							"wodel.dsls.Wodel.EDouble");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:8975:1: entryRuleSpecificDoubleType returns [EObject current=null] : iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF ;
    public final EObject entryRuleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDoubleType = null;


        try {
            // InternalWodel.g:8975:59: (iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF )
            // InternalWodel.g:8976:2: iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF
            {
             newCompositeNode(grammarAccess.getSpecificDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificDoubleType=ruleSpecificDoubleType();

            state._fsp--;

             current =iv_ruleSpecificDoubleType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:8982:1: ruleSpecificDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:8988:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) )
            // InternalWodel.g:8989:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            {
            // InternalWodel.g:8989:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            // InternalWodel.g:8990:3: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) )
            {
            // InternalWodel.g:8990:3: ()
            // InternalWodel.g:8991:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificDoubleTypeAccess().getSpecificDoubleTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:8997:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:8998:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:8998:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:8999:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_120);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificDoubleTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:9016:3: ( (lv_value_2_0= ruleEDouble ) )
            // InternalWodel.g:9017:4: (lv_value_2_0= ruleEDouble )
            {
            // InternalWodel.g:9017:4: (lv_value_2_0= ruleEDouble )
            // InternalWodel.g:9018:5: lv_value_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificDoubleTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Wodel.EDouble");
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
    // InternalWodel.g:9039:1: entryRuleMinValueType returns [EObject current=null] : iv_ruleMinValueType= ruleMinValueType EOF ;
    public final EObject entryRuleMinValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinValueType = null;


        try {
            // InternalWodel.g:9039:53: (iv_ruleMinValueType= ruleMinValueType EOF )
            // InternalWodel.g:9040:2: iv_ruleMinValueType= ruleMinValueType EOF
            {
             newCompositeNode(grammarAccess.getMinValueTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinValueType=ruleMinValueType();

            state._fsp--;

             current =iv_ruleMinValueType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9046:1: ruleMinValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMinValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9052:2: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalWodel.g:9053:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalWodel.g:9053:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalWodel.g:9054:3: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalWodel.g:9054:3: ( (lv_operator_0_0= ruleOperator ) )
            // InternalWodel.g:9055:4: (lv_operator_0_0= ruleOperator )
            {
            // InternalWodel.g:9055:4: (lv_operator_0_0= ruleOperator )
            // InternalWodel.g:9056:5: lv_operator_0_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getMinValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_121);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMinValueTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,92,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getMinValueTypeAccess().getMinKeyword_1());
            		
            otherlv_2=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMinValueTypeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWodel.g:9081:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:9082:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:9082:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:9083:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMinValueTypeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_3, grammarAccess.getMinValueTypeAccess().getAttributeEAttributeCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:9102:1: entryRuleMaxValueType returns [EObject current=null] : iv_ruleMaxValueType= ruleMaxValueType EOF ;
    public final EObject entryRuleMaxValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxValueType = null;


        try {
            // InternalWodel.g:9102:53: (iv_ruleMaxValueType= ruleMaxValueType EOF )
            // InternalWodel.g:9103:2: iv_ruleMaxValueType= ruleMaxValueType EOF
            {
             newCompositeNode(grammarAccess.getMaxValueTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxValueType=ruleMaxValueType();

            state._fsp--;

             current =iv_ruleMaxValueType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9109:1: ruleMaxValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMaxValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9115:2: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalWodel.g:9116:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalWodel.g:9116:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalWodel.g:9117:3: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalWodel.g:9117:3: ( (lv_operator_0_0= ruleOperator ) )
            // InternalWodel.g:9118:4: (lv_operator_0_0= ruleOperator )
            {
            // InternalWodel.g:9118:4: (lv_operator_0_0= ruleOperator )
            // InternalWodel.g:9119:5: lv_operator_0_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getMaxValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_122);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMaxValueTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,93,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxValueTypeAccess().getMaxKeyword_1());
            		
            otherlv_2=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMaxValueTypeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWodel.g:9144:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:9145:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:9145:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:9146:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMaxValueTypeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_3, grammarAccess.getMaxValueTypeAccess().getAttributeEAttributeCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:9165:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // InternalWodel.g:9165:52: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalWodel.g:9166:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9172:1: ruleIntegerType returns [EObject current=null] : (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificIntegerType_0 = null;

        EObject this_RandomIntegerType_1 = null;



        	enterRule();

        try {
            // InternalWodel.g:9178:2: ( (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) )
            // InternalWodel.g:9179:2: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            {
            // InternalWodel.g:9179:2: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            int alt170=2;
            alt170 = dfa170.predict(input);
            switch (alt170) {
                case 1 :
                    // InternalWodel.g:9180:3: this_SpecificIntegerType_0= ruleSpecificIntegerType
                    {

                    			newCompositeNode(grammarAccess.getIntegerTypeAccess().getSpecificIntegerTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificIntegerType_0=ruleSpecificIntegerType();

                    state._fsp--;


                    			current = this_SpecificIntegerType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:9189:3: this_RandomIntegerType_1= ruleRandomIntegerType
                    {

                    			newCompositeNode(grammarAccess.getIntegerTypeAccess().getRandomIntegerTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalWodel.g:9201:1: entryRuleSpecificIntegerType returns [EObject current=null] : iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF ;
    public final EObject entryRuleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificIntegerType = null;


        try {
            // InternalWodel.g:9201:60: (iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF )
            // InternalWodel.g:9202:2: iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF
            {
             newCompositeNode(grammarAccess.getSpecificIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificIntegerType=ruleSpecificIntegerType();

            state._fsp--;

             current =iv_ruleSpecificIntegerType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9208:1: ruleSpecificIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) ;
    public final EObject ruleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9214:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) )
            // InternalWodel.g:9215:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            {
            // InternalWodel.g:9215:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            // InternalWodel.g:9216:3: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) )
            {
            // InternalWodel.g:9216:3: ()
            // InternalWodel.g:9217:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecificIntegerTypeAccess().getSpecificIntegerTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9223:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9224:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9224:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9225:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificIntegerTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:9242:3: ( (lv_value_2_0= ruleEInt ) )
            // InternalWodel.g:9243:4: (lv_value_2_0= ruleEInt )
            {
            // InternalWodel.g:9243:4: (lv_value_2_0= ruleEInt )
            // InternalWodel.g:9244:5: lv_value_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecificIntegerTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Wodel.EInt");
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
    // InternalWodel.g:9265:1: entryRuleRandomIntegerType returns [EObject current=null] : iv_ruleRandomIntegerType= ruleRandomIntegerType EOF ;
    public final EObject entryRuleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerType = null;


        try {
            // InternalWodel.g:9265:58: (iv_ruleRandomIntegerType= ruleRandomIntegerType EOF )
            // InternalWodel.g:9266:2: iv_ruleRandomIntegerType= ruleRandomIntegerType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomIntegerType=ruleRandomIntegerType();

            state._fsp--;

             current =iv_ruleRandomIntegerType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9272:1: ruleRandomIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) ;
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
            // InternalWodel.g:9278:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) )
            // InternalWodel.g:9279:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            {
            // InternalWodel.g:9279:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            // InternalWodel.g:9280:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            {
            // InternalWodel.g:9280:3: ()
            // InternalWodel.g:9281:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomIntegerTypeAccess().getRandomIntegerTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9287:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9288:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9288:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9289:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_123);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,94,FOLLOW_119); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomIntegerTypeAccess().getRandomIntKeyword_2());
            		
            // InternalWodel.g:9310:3: (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==41) ) {
                alt171=1;
            }
            switch (alt171) {
                case 1 :
                    // InternalWodel.g:9311:4: otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_31); 

                    				newLeafNode(otherlv_3, grammarAccess.getRandomIntegerTypeAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalWodel.g:9315:4: ( (lv_min_4_0= ruleEInt ) )
                    // InternalWodel.g:9316:5: (lv_min_4_0= ruleEInt )
                    {
                    // InternalWodel.g:9316:5: (lv_min_4_0= ruleEInt )
                    // InternalWodel.g:9317:6: lv_min_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMinEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_min_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    						}
                    						set(
                    							current,
                    							"min",
                    							lv_min_4_0,
                    							"wodel.dsls.Wodel.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,26,FOLLOW_31); 

                    				newLeafNode(otherlv_5, grammarAccess.getRandomIntegerTypeAccess().getCommaKeyword_3_2());
                    			
                    // InternalWodel.g:9338:4: ( (lv_max_6_0= ruleEInt ) )
                    // InternalWodel.g:9339:5: (lv_max_6_0= ruleEInt )
                    {
                    // InternalWodel.g:9339:5: (lv_max_6_0= ruleEInt )
                    // InternalWodel.g:9340:6: lv_max_6_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMaxEIntParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_97);
                    lv_max_6_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_6_0,
                    							"wodel.dsls.Wodel.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,45,FOLLOW_2); 

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


    // $ANTLR start "entryRuleRandomStringNumberType"
    // InternalWodel.g:9366:1: entryRuleRandomStringNumberType returns [EObject current=null] : iv_ruleRandomStringNumberType= ruleRandomStringNumberType EOF ;
    public final EObject entryRuleRandomStringNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringNumberType = null;


        try {
            // InternalWodel.g:9366:63: (iv_ruleRandomStringNumberType= ruleRandomStringNumberType EOF )
            // InternalWodel.g:9367:2: iv_ruleRandomStringNumberType= ruleRandomStringNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringNumberTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomStringNumberType=ruleRandomStringNumberType();

            state._fsp--;

             current =iv_ruleRandomStringNumberType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRandomStringNumberType"


    // $ANTLR start "ruleRandomStringNumberType"
    // InternalWodel.g:9373:1: ruleRandomStringNumberType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int-string' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) ;
    public final EObject ruleRandomStringNumberType() throws RecognitionException {
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
            // InternalWodel.g:9379:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int-string' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) )
            // InternalWodel.g:9380:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int-string' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            {
            // InternalWodel.g:9380:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int-string' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            // InternalWodel.g:9381:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int-string' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            {
            // InternalWodel.g:9381:3: ()
            // InternalWodel.g:9382:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomStringNumberTypeAccess().getRandomStringNumberTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9388:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9389:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9389:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9390:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomStringNumberTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_124);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomStringNumberTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,95,FOLLOW_119); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomStringNumberTypeAccess().getRandomIntStringKeyword_2());
            		
            // InternalWodel.g:9411:3: (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==41) ) {
                alt172=1;
            }
            switch (alt172) {
                case 1 :
                    // InternalWodel.g:9412:4: otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_31); 

                    				newLeafNode(otherlv_3, grammarAccess.getRandomStringNumberTypeAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalWodel.g:9416:4: ( (lv_min_4_0= ruleEInt ) )
                    // InternalWodel.g:9417:5: (lv_min_4_0= ruleEInt )
                    {
                    // InternalWodel.g:9417:5: (lv_min_4_0= ruleEInt )
                    // InternalWodel.g:9418:6: lv_min_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getRandomStringNumberTypeAccess().getMinEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_min_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomStringNumberTypeRule());
                    						}
                    						set(
                    							current,
                    							"min",
                    							lv_min_4_0,
                    							"wodel.dsls.Wodel.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,26,FOLLOW_31); 

                    				newLeafNode(otherlv_5, grammarAccess.getRandomStringNumberTypeAccess().getCommaKeyword_3_2());
                    			
                    // InternalWodel.g:9439:4: ( (lv_max_6_0= ruleEInt ) )
                    // InternalWodel.g:9440:5: (lv_max_6_0= ruleEInt )
                    {
                    // InternalWodel.g:9440:5: (lv_max_6_0= ruleEInt )
                    // InternalWodel.g:9441:6: lv_max_6_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getRandomStringNumberTypeAccess().getMaxEIntParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_97);
                    lv_max_6_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomStringNumberTypeRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_6_0,
                    							"wodel.dsls.Wodel.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,45,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getRandomStringNumberTypeAccess().getRightParenthesisKeyword_3_4());
                    			

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
    // $ANTLR end "ruleRandomStringNumberType"


    // $ANTLR start "entryRuleRandomType"
    // InternalWodel.g:9467:1: entryRuleRandomType returns [EObject current=null] : iv_ruleRandomType= ruleRandomType EOF ;
    public final EObject entryRuleRandomType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomType = null;


        try {
            // InternalWodel.g:9467:51: (iv_ruleRandomType= ruleRandomType EOF )
            // InternalWodel.g:9468:2: iv_ruleRandomType= ruleRandomType EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomType=ruleRandomType();

            state._fsp--;

             current =iv_ruleRandomType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9474:1: ruleRandomType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) ;
    public final EObject ruleRandomType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9480:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) )
            // InternalWodel.g:9481:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            {
            // InternalWodel.g:9481:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            // InternalWodel.g:9482:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random'
            {
            // InternalWodel.g:9482:3: ()
            // InternalWodel.g:9483:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRandomTypeAccess().getRandomTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9489:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9490:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9490:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9491:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_125);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,96,FOLLOW_2); 

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
    // InternalWodel.g:9516:1: entryRuleRandomDoubleNumberType returns [EObject current=null] : iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF ;
    public final EObject entryRuleRandomDoubleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleNumberType = null;


        try {
            // InternalWodel.g:9516:63: (iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF )
            // InternalWodel.g:9517:2: iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleNumberTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomDoubleNumberType=ruleRandomDoubleNumberType();

            state._fsp--;

             current =iv_ruleRandomDoubleNumberType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9523:1: ruleRandomDoubleNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // InternalWodel.g:9529:2: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // InternalWodel.g:9530:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // InternalWodel.g:9530:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // InternalWodel.g:9531:3: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // InternalWodel.g:9531:3: ( (lv_operator_0_0= ruleOperator ) )
            // InternalWodel.g:9532:4: (lv_operator_0_0= ruleOperator )
            {
            // InternalWodel.g:9532:4: (lv_operator_0_0= ruleOperator )
            // InternalWodel.g:9533:5: lv_operator_0_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_125);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,96,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getRandomDoubleNumberTypeAccess().getRandomKeyword_1());
            		
            otherlv_2=(Token)match(input,41,FOLLOW_120); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomDoubleNumberTypeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWodel.g:9558:3: ( (lv_min_3_0= ruleEDouble ) )
            // InternalWodel.g:9559:4: (lv_min_3_0= ruleEDouble )
            {
            // InternalWodel.g:9559:4: (lv_min_3_0= ruleEDouble )
            // InternalWodel.g:9560:5: lv_min_3_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getMinEDoubleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_98);
            lv_min_3_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_3_0,
            						"wodel.dsls.Wodel.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_66); 

            			newLeafNode(otherlv_4, grammarAccess.getRandomDoubleNumberTypeAccess().getCommaKeyword_4());
            		
            // InternalWodel.g:9581:3: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==60||LA173_0==62||(LA173_0>=81 && LA173_0<=83)) ) {
                alt173=1;
            }
            else if ( (LA173_0==RULE_ID) ) {
                int LA173_2 = input.LA(2);

                if ( ((LA173_2>=38 && LA173_2<=39)||LA173_2==80) ) {
                    alt173=1;
                }
            }
            switch (alt173) {
                case 1 :
                    // InternalWodel.g:9582:4: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // InternalWodel.g:9582:4: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:9583:5: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:9583:5: (lv_object_5_0= ruleObSelectionStrategy )
                    // InternalWodel.g:9584:6: lv_object_5_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_object_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
                    						}
                    						set(
                    							current,
                    							"object",
                    							lv_object_5_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getRandomDoubleNumberTypeAccess().getFullStopKeyword_5_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:9606:3: ( (otherlv_7= RULE_ID ) )
            // InternalWodel.g:9607:4: (otherlv_7= RULE_ID )
            {
            // InternalWodel.g:9607:4: (otherlv_7= RULE_ID )
            // InternalWodel.g:9608:5: otherlv_7= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRandomDoubleNumberTypeRule());
            					}
            				
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_7, grammarAccess.getRandomDoubleNumberTypeAccess().getMaxEAttributeCrossReference_6_0());
            				

            }


            }

            otherlv_8=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:9627:1: entryRuleRandomIntegerNumberType returns [EObject current=null] : iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF ;
    public final EObject entryRuleRandomIntegerNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerNumberType = null;


        try {
            // InternalWodel.g:9627:64: (iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF )
            // InternalWodel.g:9628:2: iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerNumberTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRandomIntegerNumberType=ruleRandomIntegerNumberType();

            state._fsp--;

             current =iv_ruleRandomIntegerNumberType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9634:1: ruleRandomIntegerNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // InternalWodel.g:9640:2: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // InternalWodel.g:9641:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // InternalWodel.g:9641:2: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // InternalWodel.g:9642:3: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // InternalWodel.g:9642:3: ( (lv_operator_0_0= ruleOperator ) )
            // InternalWodel.g:9643:4: (lv_operator_0_0= ruleOperator )
            {
            // InternalWodel.g:9643:4: (lv_operator_0_0= ruleOperator )
            // InternalWodel.g:9644:5: lv_operator_0_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_125);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,96,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getRandomIntegerNumberTypeAccess().getRandomKeyword_1());
            		
            otherlv_2=(Token)match(input,41,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getRandomIntegerNumberTypeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWodel.g:9669:3: ( (lv_min_3_0= ruleEInt ) )
            // InternalWodel.g:9670:4: (lv_min_3_0= ruleEInt )
            {
            // InternalWodel.g:9670:4: (lv_min_3_0= ruleEInt )
            // InternalWodel.g:9671:5: lv_min_3_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getMinEIntParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_98);
            lv_min_3_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
            					}
            					set(
            						current,
            						"min",
            						lv_min_3_0,
            						"wodel.dsls.Wodel.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_66); 

            			newLeafNode(otherlv_4, grammarAccess.getRandomIntegerNumberTypeAccess().getCommaKeyword_4());
            		
            // InternalWodel.g:9692:3: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==60||LA174_0==62||(LA174_0>=81 && LA174_0<=83)) ) {
                alt174=1;
            }
            else if ( (LA174_0==RULE_ID) ) {
                int LA174_2 = input.LA(2);

                if ( ((LA174_2>=38 && LA174_2<=39)||LA174_2==80) ) {
                    alt174=1;
                }
            }
            switch (alt174) {
                case 1 :
                    // InternalWodel.g:9693:4: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // InternalWodel.g:9693:4: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // InternalWodel.g:9694:5: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // InternalWodel.g:9694:5: (lv_object_5_0= ruleObSelectionStrategy )
                    // InternalWodel.g:9695:6: lv_object_5_0= ruleObSelectionStrategy
                    {

                    						newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_object_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
                    						}
                    						set(
                    							current,
                    							"object",
                    							lv_object_5_0,
                    							"wodel.dsls.Wodel.ObSelectionStrategy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getRandomIntegerNumberTypeAccess().getFullStopKeyword_5_1());
                    			

                    }
                    break;

            }

            // InternalWodel.g:9717:3: ( (otherlv_7= RULE_ID ) )
            // InternalWodel.g:9718:4: (otherlv_7= RULE_ID )
            {
            // InternalWodel.g:9718:4: (otherlv_7= RULE_ID )
            // InternalWodel.g:9719:5: otherlv_7= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRandomIntegerNumberTypeRule());
            					}
            				
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(otherlv_7, grammarAccess.getRandomIntegerNumberTypeAccess().getMaxEAttributeCrossReference_6_0());
            				

            }


            }

            otherlv_8=(Token)match(input,45,FOLLOW_2); 

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
    // InternalWodel.g:9738:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalWodel.g:9738:49: (iv_ruleListType= ruleListType EOF )
            // InternalWodel.g:9739:2: iv_ruleListType= ruleListType EOF
            {
             newCompositeNode(grammarAccess.getListTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListType=ruleListType();

            state._fsp--;

             current =iv_ruleListType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9745:1: ruleListType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) ;
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
            // InternalWodel.g:9751:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) )
            // InternalWodel.g:9752:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // InternalWodel.g:9752:2: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            // InternalWodel.g:9753:3: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}'
            {
            // InternalWodel.g:9753:3: ()
            // InternalWodel.g:9754:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getListTypeAccess().getListTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9760:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9761:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9761:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9762:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getListTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getListTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWodel.g:9783:3: ( (otherlv_3= RULE_ID ) )
            // InternalWodel.g:9784:4: (otherlv_3= RULE_ID )
            {
            // InternalWodel.g:9784:4: (otherlv_3= RULE_ID )
            // InternalWodel.g:9785:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getListTypeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_75); 

            					newLeafNode(otherlv_3, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_3_0());
            				

            }


            }

            // InternalWodel.g:9796:3: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
            loop175:
            do {
                int alt175=2;
                int LA175_0 = input.LA(1);

                if ( (LA175_0==26) ) {
                    alt175=1;
                }


                switch (alt175) {
            	case 1 :
            	    // InternalWodel.g:9797:4: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalWodel.g:9801:4: ( (otherlv_5= RULE_ID ) )
            	    // InternalWodel.g:9802:5: (otherlv_5= RULE_ID )
            	    {
            	    // InternalWodel.g:9802:5: (otherlv_5= RULE_ID )
            	    // InternalWodel.g:9803:6: otherlv_5= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getListTypeRule());
            	    						}
            	    					
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_75); 

            	    						newLeafNode(otherlv_5, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop175;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

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
    // InternalWodel.g:9823:1: entryRuleObjectAttributeType returns [EObject current=null] : iv_ruleObjectAttributeType= ruleObjectAttributeType EOF ;
    public final EObject entryRuleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectAttributeType = null;


        try {
            // InternalWodel.g:9823:60: (iv_ruleObjectAttributeType= ruleObjectAttributeType EOF )
            // InternalWodel.g:9824:2: iv_ruleObjectAttributeType= ruleObjectAttributeType EOF
            {
             newCompositeNode(grammarAccess.getObjectAttributeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectAttributeType=ruleObjectAttributeType();

            state._fsp--;

             current =iv_ruleObjectAttributeType; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9830:1: ruleObjectAttributeType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9836:2: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalWodel.g:9837:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalWodel.g:9837:2: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            // InternalWodel.g:9838:3: () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
            {
            // InternalWodel.g:9838:3: ()
            // InternalWodel.g:9839:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getObjectAttributeTypeAccess().getObjectAttributeTypeAction_0(),
            					current);
            			

            }

            // InternalWodel.g:9845:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalWodel.g:9846:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalWodel.g:9846:4: (lv_operator_1_0= ruleOperator )
            // InternalWodel.g:9847:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getObjectAttributeTypeAccess().getOperatorOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjectAttributeTypeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"wodel.dsls.Wodel.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWodel.g:9864:3: ( (otherlv_2= RULE_ID ) )
            // InternalWodel.g:9865:4: (otherlv_2= RULE_ID )
            {
            // InternalWodel.g:9865:4: (otherlv_2= RULE_ID )
            // InternalWodel.g:9866:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_58); 

            					newLeafNode(otherlv_2, grammarAccess.getObjectAttributeTypeAccess().getObjSelObjectEmitterCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getObjectAttributeTypeAccess().getFullStopKeyword_3());
            		
            // InternalWodel.g:9881:3: ( (otherlv_4= RULE_ID ) )
            // InternalWodel.g:9882:4: (otherlv_4= RULE_ID )
            {
            // InternalWodel.g:9882:4: (otherlv_4= RULE_ID )
            // InternalWodel.g:9883:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalWodel.g:9898:1: entryRuleMaxCardinality returns [String current=null] : iv_ruleMaxCardinality= ruleMaxCardinality EOF ;
    public final String entryRuleMaxCardinality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaxCardinality = null;


        try {
            // InternalWodel.g:9898:54: (iv_ruleMaxCardinality= ruleMaxCardinality EOF )
            // InternalWodel.g:9899:2: iv_ruleMaxCardinality= ruleMaxCardinality EOF
            {
             newCompositeNode(grammarAccess.getMaxCardinalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxCardinality=ruleMaxCardinality();

            state._fsp--;

             current =iv_ruleMaxCardinality.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalWodel.g:9905:1: ruleMaxCardinality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleMaxCardinality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EInt_0 = null;



        	enterRule();

        try {
            // InternalWodel.g:9911:2: ( (this_EInt_0= ruleEInt | kw= '*' ) )
            // InternalWodel.g:9912:2: (this_EInt_0= ruleEInt | kw= '*' )
            {
            // InternalWodel.g:9912:2: (this_EInt_0= ruleEInt | kw= '*' )
            int alt176=2;
            int LA176_0 = input.LA(1);

            if ( (LA176_0==RULE_INT||LA176_0==53) ) {
                alt176=1;
            }
            else if ( (LA176_0==97) ) {
                alt176=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 176, 0, input);

                throw nvae;
            }
            switch (alt176) {
                case 1 :
                    // InternalWodel.g:9913:3: this_EInt_0= ruleEInt
                    {

                    			newCompositeNode(grammarAccess.getMaxCardinalityAccess().getEIntParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    			current.merge(this_EInt_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWodel.g:9924:3: kw= '*'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

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
    // InternalWodel.g:9933:1: ruleLogicOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) ;
    public final Enumerator ruleLogicOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWodel.g:9939:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) )
            // InternalWodel.g:9940:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            {
            // InternalWodel.g:9940:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==44) ) {
                alt177=1;
            }
            else if ( (LA177_0==43) ) {
                alt177=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;
            }
            switch (alt177) {
                case 1 :
                    // InternalWodel.g:9941:3: (enumLiteral_0= 'and' )
                    {
                    // InternalWodel.g:9941:3: (enumLiteral_0= 'and' )
                    // InternalWodel.g:9942:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:9949:3: (enumLiteral_1= 'or' )
                    {
                    // InternalWodel.g:9949:3: (enumLiteral_1= 'or' )
                    // InternalWodel.g:9950:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

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
    // InternalWodel.g:9960:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) | (enumLiteral_3= 'is' ) | (enumLiteral_4= 'not' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '<=' ) | (enumLiteral_7= '>' ) | (enumLiteral_8= '<' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;


        	enterRule();

        try {
            // InternalWodel.g:9966:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) | (enumLiteral_3= 'is' ) | (enumLiteral_4= 'not' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '<=' ) | (enumLiteral_7= '>' ) | (enumLiteral_8= '<' ) ) )
            // InternalWodel.g:9967:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) | (enumLiteral_3= 'is' ) | (enumLiteral_4= 'not' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '<=' ) | (enumLiteral_7= '>' ) | (enumLiteral_8= '<' ) )
            {
            // InternalWodel.g:9967:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) | (enumLiteral_3= 'is' ) | (enumLiteral_4= 'not' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '<=' ) | (enumLiteral_7= '>' ) | (enumLiteral_8= '<' ) )
            int alt178=9;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt178=1;
                }
                break;
            case 37:
                {
                alt178=2;
                }
                break;
            case 23:
                {
                alt178=3;
                }
                break;
            case 98:
                {
                alt178=4;
                }
                break;
            case 99:
                {
                alt178=5;
                }
                break;
            case 100:
                {
                alt178=6;
                }
                break;
            case 101:
                {
                alt178=7;
                }
                break;
            case 102:
                {
                alt178=8;
                }
                break;
            case 103:
                {
                alt178=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 178, 0, input);

                throw nvae;
            }

            switch (alt178) {
                case 1 :
                    // InternalWodel.g:9968:3: (enumLiteral_0= '=' )
                    {
                    // InternalWodel.g:9968:3: (enumLiteral_0= '=' )
                    // InternalWodel.g:9969:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:9976:3: (enumLiteral_1= '<>' )
                    {
                    // InternalWodel.g:9976:3: (enumLiteral_1= '<>' )
                    // InternalWodel.g:9977:4: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWodel.g:9984:3: (enumLiteral_2= 'in' )
                    {
                    // InternalWodel.g:9984:3: (enumLiteral_2= 'in' )
                    // InternalWodel.g:9985:4: enumLiteral_2= 'in'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWodel.g:9992:3: (enumLiteral_3= 'is' )
                    {
                    // InternalWodel.g:9992:3: (enumLiteral_3= 'is' )
                    // InternalWodel.g:9993:4: enumLiteral_3= 'is'
                    {
                    enumLiteral_3=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getIsEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOperatorAccess().getIsEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWodel.g:10000:3: (enumLiteral_4= 'not' )
                    {
                    // InternalWodel.g:10000:3: (enumLiteral_4= 'not' )
                    // InternalWodel.g:10001:4: enumLiteral_4= 'not'
                    {
                    enumLiteral_4=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getNotEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getOperatorAccess().getNotEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWodel.g:10008:3: (enumLiteral_5= '>=' )
                    {
                    // InternalWodel.g:10008:3: (enumLiteral_5= '>=' )
                    // InternalWodel.g:10009:4: enumLiteral_5= '>='
                    {
                    enumLiteral_5=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getGteEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getOperatorAccess().getGteEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalWodel.g:10016:3: (enumLiteral_6= '<=' )
                    {
                    // InternalWodel.g:10016:3: (enumLiteral_6= '<=' )
                    // InternalWodel.g:10017:4: enumLiteral_6= '<='
                    {
                    enumLiteral_6=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getLteEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getOperatorAccess().getLteEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalWodel.g:10024:3: (enumLiteral_7= '>' )
                    {
                    // InternalWodel.g:10024:3: (enumLiteral_7= '>' )
                    // InternalWodel.g:10025:4: enumLiteral_7= '>'
                    {
                    enumLiteral_7=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getGtEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getOperatorAccess().getGtEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalWodel.g:10032:3: (enumLiteral_8= '<' )
                    {
                    // InternalWodel.g:10032:3: (enumLiteral_8= '<' )
                    // InternalWodel.g:10033:4: enumLiteral_8= '<'
                    {
                    enumLiteral_8=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getLtEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getOperatorAccess().getLtEnumLiteralDeclaration_8());
                    			

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
    // InternalWodel.g:10043:1: ruleArithmeticOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) ;
    public final Enumerator ruleArithmeticOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalWodel.g:10049:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) )
            // InternalWodel.g:10050:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            {
            // InternalWodel.g:10050:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            int alt179=5;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt179=1;
                }
                break;
            case 53:
                {
                alt179=2;
                }
                break;
            case 97:
                {
                alt179=3;
                }
                break;
            case 104:
                {
                alt179=4;
                }
                break;
            case 105:
                {
                alt179=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 179, 0, input);

                throw nvae;
            }

            switch (alt179) {
                case 1 :
                    // InternalWodel.g:10051:3: (enumLiteral_0= '+' )
                    {
                    // InternalWodel.g:10051:3: (enumLiteral_0= '+' )
                    // InternalWodel.g:10052:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:10059:3: (enumLiteral_1= '-' )
                    {
                    // InternalWodel.g:10059:3: (enumLiteral_1= '-' )
                    // InternalWodel.g:10060:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWodel.g:10067:3: (enumLiteral_2= '*' )
                    {
                    // InternalWodel.g:10067:3: (enumLiteral_2= '*' )
                    // InternalWodel.g:10068:4: enumLiteral_2= '*'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWodel.g:10075:3: (enumLiteral_3= '/' )
                    {
                    // InternalWodel.g:10075:3: (enumLiteral_3= '/' )
                    // InternalWodel.g:10076:4: enumLiteral_3= '/'
                    {
                    enumLiteral_3=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWodel.g:10083:3: (enumLiteral_4= '%' )
                    {
                    // InternalWodel.g:10083:3: (enumLiteral_4= '%' )
                    // InternalWodel.g:10084:4: enumLiteral_4= '%'
                    {
                    enumLiteral_4=(Token)match(input,105,FOLLOW_2); 

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
    // InternalWodel.g:10094:1: ruleRepeat returns [Enumerator current=null] : ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) ;
    public final Enumerator ruleRepeat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWodel.g:10100:2: ( ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) )
            // InternalWodel.g:10101:2: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            {
            // InternalWodel.g:10101:2: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            int alt180=2;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==106) ) {
                alt180=1;
            }
            else if ( (LA180_0==107) ) {
                alt180=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 180, 0, input);

                throw nvae;
            }
            switch (alt180) {
                case 1 :
                    // InternalWodel.g:10102:3: (enumLiteral_0= 'yes' )
                    {
                    // InternalWodel.g:10102:3: (enumLiteral_0= 'yes' )
                    // InternalWodel.g:10103:4: enumLiteral_0= 'yes'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:10110:3: (enumLiteral_1= 'no' )
                    {
                    // InternalWodel.g:10110:3: (enumLiteral_1= 'no' )
                    // InternalWodel.g:10111:4: enumLiteral_1= 'no'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

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
    // InternalWodel.g:10121:1: ruleSampleClause returns [Enumerator current=null] : ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) ) ;
    public final Enumerator ruleSampleClause() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWodel.g:10127:2: ( ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) ) )
            // InternalWodel.g:10128:2: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) )
            {
            // InternalWodel.g:10128:2: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) )
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==108) ) {
                alt181=1;
            }
            else if ( (LA181_0==109) ) {
                alt181=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 181, 0, input);

                throw nvae;
            }
            switch (alt181) {
                case 1 :
                    // InternalWodel.g:10129:3: (enumLiteral_0= 'equals' )
                    {
                    // InternalWodel.g:10129:3: (enumLiteral_0= 'equals' )
                    // InternalWodel.g:10130:4: enumLiteral_0= 'equals'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getSampleClauseAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSampleClauseAccess().getEqualsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWodel.g:10137:3: (enumLiteral_1= 'distinct' )
                    {
                    // InternalWodel.g:10137:3: (enumLiteral_1= 'distinct' )
                    // InternalWodel.g:10138:4: enumLiteral_1= 'distinct'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

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


    protected DFA55 dfa55 = new DFA55(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA124 dfa124 = new DFA124(this);
    protected DFA125 dfa125 = new DFA125(this);
    protected DFA132 dfa132 = new DFA132(this);
    protected DFA133 dfa133 = new DFA133(this);
    protected DFA165 dfa165 = new DFA165(this);
    protected DFA166 dfa166 = new DFA166(this);
    protected DFA168 dfa168 = new DFA168(this);
    protected DFA170 dfa170 = new DFA170(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\1\4\1\34\1\4\1\uffff\2\4\2\uffff\1\36\5\uffff\2\4\2\uffff\1\4\2\uffff";
    static final String dfa_3s = "\1\110\1\34\1\75\1\uffff\2\123\2\uffff\1\110\5\uffff\2\75\2\uffff\1\123\2\uffff";
    static final String dfa_4s = "\3\uffff\1\4\2\uffff\1\13\1\14\1\uffff\1\1\1\7\1\12\1\6\1\5\2\uffff\1\10\1\11\1\uffff\1\3\1\2";
    static final String dfa_5s = "\25\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\31\uffff\1\3\34\uffff\1\5\3\uffff\1\2\2\uffff\1\4\3\uffff\2\6\1\7",
            "\1\10",
            "\1\11\70\uffff\1\12",
            "",
            "\1\13\67\uffff\1\13\1\uffff\1\13\5\uffff\1\15\1\14\13\uffff\3\13",
            "\1\20\67\uffff\1\17\1\21\1\16\22\uffff\3\20",
            "",
            "",
            "\1\3\40\uffff\1\2\1\22\1\uffff\1\13\3\uffff\2\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\20\70\uffff\1\21",
            "\1\20\70\uffff\1\21",
            "",
            "",
            "\1\24\67\uffff\1\24\1\uffff\1\24\2\uffff\1\23\17\uffff\3\24",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2927:2: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator | this_RetypeObjectMutator_11= ruleRetypeObjectMutator )";
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\27\11\4\2\uffff";
    static final String dfa_9s = "\1\147\11\140\2\uffff";
    static final String dfa_10s = "\12\uffff\1\1\1\2";
    static final String dfa_11s = "\14\uffff}>";
    static final String[] dfa_12s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "\1\13\2\12\6\uffff\1\12\20\uffff\1\12\7\uffff\1\12\13\uffff\2\12\1\uffff\1\12\36\uffff\15\12",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "3227:2: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )";
        }
    }
    static final String dfa_13s = "\21\uffff";
    static final String dfa_14s = "\17\uffff\1\20\1\uffff";
    static final String dfa_15s = "\1\27\11\5\5\uffff\1\16\1\uffff";
    static final String dfa_16s = "\1\147\11\140\5\uffff\1\54\1\uffff";
    static final String dfa_17s = "\12\uffff\1\1\1\3\1\4\1\2\1\6\1\uffff\1\5";
    static final String dfa_18s = "\21\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "\1\12\1\13\6\uffff\1\16\20\uffff\1\14\7\uffff\1\12\13\uffff\2\15\1\uffff\1\12\36\uffff\1\15\6\13\4\12\1\13\1\17",
            "",
            "",
            "",
            "",
            "",
            "\1\20\13\uffff\1\20\16\uffff\1\12\1\uffff\2\20",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "3263:2: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )";
        }
    }
    static final String dfa_20s = "\13\uffff\1\17\5\uffff";
    static final String dfa_21s = "\1\27\12\5\1\16\5\uffff";
    static final String dfa_22s = "\1\147\11\140\1\46\1\54\5\uffff";
    static final String dfa_23s = "\14\uffff\1\2\1\3\1\4\1\1\1\5";
    static final String[] dfa_24s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14\16\uffff\1\12\45\uffff\1\14\1\15\1\16\1\17\1\uffff\1\20",
            "\1\13\40\uffff\1\14",
            "\1\17\13\uffff\1\17\13\uffff\1\14\4\uffff\2\17",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_13;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_18;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "3335:2: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )";
        }
    }
    static final String dfa_25s = "\20\uffff";
    static final String dfa_26s = "\1\27\11\140\1\51\2\5\1\32\2\uffff";
    static final String dfa_27s = "\1\147\11\140\1\51\1\65\2\46\2\uffff";
    static final String dfa_28s = "\16\uffff\1\1\1\2";
    static final String dfa_29s = "\20\uffff}>";
    static final String[] dfa_30s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\15\40\uffff\1\16\16\uffff\1\14",
            "\1\15\40\uffff\1\16",
            "\1\17\13\uffff\1\16",
            "",
            ""
    };

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "3398:2: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )";
        }
    }
    static final String dfa_31s = "\16\uffff";
    static final String dfa_32s = "\14\uffff\1\2\1\uffff";
    static final String dfa_33s = "\1\4\1\27\1\uffff\11\4\1\16\1\uffff";
    static final String dfa_34s = "\1\71\1\147\1\uffff\11\140\1\120\1\uffff";
    static final String dfa_35s = "\2\uffff\1\2\12\uffff\1\1";
    static final String dfa_36s = "\16\uffff}>";
    static final String[] dfa_37s = {
            "\1\1\63\uffff\2\2",
            "\1\5\4\uffff\1\3\10\uffff\1\4\2\2\72\uffff\1\6\1\7\1\10\1\11\1\12\1\13",
            "",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\14\2\15\6\uffff\1\15\20\uffff\1\15\7\uffff\1\15\13\uffff\2\15\1\uffff\1\15\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\22\uffff\3\2\15\15",
            "\1\2\27\uffff\1\15\1\2\3\uffff\2\2\43\uffff\1\2",
            ""
    };

    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_31;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "3946:2: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )";
        }
    }
    static final String dfa_38s = "\1\4\1\27\3\uffff\2\27\3\4\2\16";
    static final String dfa_39s = "\1\117\1\151\3\uffff\2\147\3\140\2\120";
    static final String dfa_40s = "\2\uffff\1\1\1\2\1\3\7\uffff";
    static final String[] dfa_41s = {
            "\1\1\11\uffff\1\4\13\uffff\1\4\57\uffff\4\2\1\uffff\1\3",
            "\1\2\4\uffff\1\7\10\uffff\1\2\1\3\16\uffff\1\6\30\uffff\1\5\22\uffff\11\2",
            "",
            "",
            "",
            "\1\2\4\uffff\1\10\10\uffff\1\2\74\uffff\6\2",
            "\1\2\4\uffff\1\11\10\uffff\1\2\74\uffff\6\2",
            "\1\3\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\12\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\13\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3"
    };
    static final char[] dfa_38 = DFA.unpackEncodedStringToUnsignedChars(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[][] dfa_41 = unpackEncodedStringArray(dfa_41s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_38;
            this.max = dfa_39;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_41;
        }
        public String getDescription() {
            return "4630:4: ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )?";
        }
    }
    static final String dfa_42s = "\13\uffff";
    static final String dfa_43s = "\1\4\1\27\2\uffff\1\4\2\27\2\4\2\16";
    static final String dfa_44s = "\1\117\1\151\2\uffff\1\140\2\147\2\140\2\120";
    static final String dfa_45s = "\2\uffff\1\1\1\2\7\uffff";
    static final String dfa_46s = "\13\uffff}>";
    static final String[] dfa_47s = {
            "\1\1\105\uffff\4\2\1\uffff\1\3",
            "\1\2\4\uffff\1\4\10\uffff\1\2\1\3\16\uffff\1\5\30\uffff\1\6\22\uffff\11\2",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\2\4\uffff\1\7\10\uffff\1\2\74\uffff\6\2",
            "\1\2\4\uffff\1\10\10\uffff\1\2\74\uffff\6\2",
            "\1\11\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\12\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3"
    };

    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final char[] dfa_44 = DFA.unpackEncodedStringToUnsignedChars(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_43;
            this.max = dfa_44;
            this.accept = dfa_45;
            this.special = dfa_46;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "4676:5: ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )";
        }
    }
    static final String dfa_48s = "\1\4\1\27\3\uffff\1\27\1\4\1\27\2\4\2\16";
    static final String dfa_49s = "\1\117\1\151\3\uffff\1\147\1\140\1\147\2\140\2\120";
    static final String[] dfa_50s = {
            "\1\1\11\uffff\1\4\13\uffff\1\4\57\uffff\4\2\1\uffff\1\3",
            "\1\2\4\uffff\1\6\10\uffff\1\2\1\3\16\uffff\1\7\30\uffff\1\5\22\uffff\11\2",
            "",
            "",
            "",
            "\1\2\4\uffff\1\10\10\uffff\1\2\74\uffff\6\2",
            "\1\3\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\2\4\uffff\1\11\10\uffff\1\2\74\uffff\6\2",
            "\1\12\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\13\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3"
    };
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[][] dfa_50 = unpackEncodedStringArray(dfa_50s);

    class DFA98 extends DFA {

        public DFA98(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 98;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_50;
        }
        public String getDescription() {
            return "5078:4: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?";
        }
    }

    class DFA99 extends DFA {

        public DFA99(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 99;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_43;
            this.max = dfa_44;
            this.accept = dfa_45;
            this.special = dfa_46;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "5124:5: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )";
        }
    }
    static final String dfa_51s = "\1\4\1\27\3\uffff\1\4\2\27\2\4\2\16";
    static final String dfa_52s = "\1\117\1\151\3\uffff\1\140\2\147\2\140\2\120";
    static final String[] dfa_53s = {
            "\1\1\11\uffff\1\4\13\uffff\1\4\57\uffff\4\2\1\uffff\1\3",
            "\1\2\4\uffff\1\5\10\uffff\1\2\1\3\16\uffff\1\6\30\uffff\1\7\22\uffff\11\2",
            "",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\2\4\uffff\1\10\10\uffff\1\2\74\uffff\6\2",
            "\1\2\4\uffff\1\11\10\uffff\1\2\74\uffff\6\2",
            "\1\12\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\13\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3"
    };
    static final char[] dfa_51 = DFA.unpackEncodedStringToUnsignedChars(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final short[][] dfa_53 = unpackEncodedStringArray(dfa_53s);

    class DFA124 extends DFA {

        public DFA124(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 124;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_51;
            this.max = dfa_52;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_53;
        }
        public String getDescription() {
            return "5960:4: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )?";
        }
    }

    class DFA125 extends DFA {

        public DFA125(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 125;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_43;
            this.max = dfa_44;
            this.accept = dfa_45;
            this.special = dfa_46;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "6006:5: ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )";
        }
    }

    class DFA132 extends DFA {

        public DFA132(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 132;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_51;
            this.max = dfa_52;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_53;
        }
        public String getDescription() {
            return "6224:4: ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )?";
        }
    }
    static final String dfa_54s = "\1\4\1\27\2\uffff\2\27\3\4\2\16";
    static final String dfa_55s = "\1\117\1\151\2\uffff\2\147\3\140\2\120";
    static final String[] dfa_56s = {
            "\1\1\105\uffff\4\2\1\uffff\1\3",
            "\1\2\4\uffff\1\6\10\uffff\1\2\1\3\16\uffff\1\5\30\uffff\1\4\22\uffff\11\2",
            "",
            "",
            "\1\2\4\uffff\1\7\10\uffff\1\2\74\uffff\6\2",
            "\1\2\4\uffff\1\10\10\uffff\1\2\74\uffff\6\2",
            "\1\3\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\11\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\12\2\2\6\uffff\1\2\20\uffff\1\2\7\uffff\1\2\13\uffff\2\2\1\uffff\1\2\6\uffff\1\3\1\uffff\1\3\22\uffff\3\3\15\2",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3",
            "\1\3\13\uffff\1\3\13\uffff\1\2\1\3\50\uffff\1\3"
    };
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final char[] dfa_55 = DFA.unpackEncodedStringToUnsignedChars(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA133 extends DFA {

        public DFA133(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 133;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_54;
            this.max = dfa_55;
            this.accept = dfa_45;
            this.special = dfa_46;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "6270:5: ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )";
        }
    }
    static final String dfa_57s = "\1\27\11\62\2\uffff";
    static final String dfa_58s = "\1\147\11\124\2\uffff";
    static final String dfa_59s = "\12\uffff\1\2\1\1";
    static final String[] dfa_60s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "\2\13\40\uffff\1\12",
            "",
            ""
    };
    static final char[] dfa_57 = DFA.unpackEncodedStringToUnsignedChars(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final short[][] dfa_60 = unpackEncodedStringArray(dfa_60s);

    class DFA165 extends DFA {

        public DFA165(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 165;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_57;
            this.max = dfa_58;
            this.accept = dfa_59;
            this.special = dfa_11;
            this.transition = dfa_60;
        }
        public String getDescription() {
            return "8005:2: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )";
        }
    }
    static final String dfa_61s = "\22\uffff";
    static final String dfa_62s = "\1\27\11\6\10\uffff";
    static final String dfa_63s = "\1\147\11\137\10\uffff";
    static final String dfa_64s = "\12\uffff\1\6\1\2\1\3\1\1\1\4\1\7\1\5\1\10";
    static final String dfa_65s = "\22\uffff}>";
    static final String[] dfa_66s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "\1\15\116\uffff\1\13\1\14\1\20\1\12\1\16\1\17\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final char[] dfa_62 = DFA.unpackEncodedStringToUnsignedChars(dfa_62s);
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final short[] dfa_64 = DFA.unpackEncodedString(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[][] dfa_66 = unpackEncodedStringArray(dfa_66s);

    class DFA166 extends DFA {

        public DFA166(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 166;
            this.eot = dfa_61;
            this.eof = dfa_61;
            this.min = dfa_62;
            this.max = dfa_63;
            this.accept = dfa_64;
            this.special = dfa_65;
            this.transition = dfa_66;
        }
        public String getDescription() {
            return "8154:2: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType | this_RandomStringNumberType_7= ruleRandomStringNumberType )";
        }
    }
    static final String dfa_67s = "\1\27\11\5\2\uffff";
    static final String dfa_68s = "\1\147\11\133\2\uffff";
    static final String[] dfa_69s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "\1\12\40\uffff\1\12\16\uffff\1\12\45\uffff\1\13",
            "",
            ""
    };
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[][] dfa_69 = unpackEncodedStringArray(dfa_69s);

    class DFA168 extends DFA {

        public DFA168(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 168;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "8852:2: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )";
        }
    }
    static final String dfa_70s = "\1\147\11\136\2\uffff";
    static final String[] dfa_71s = {
            "\1\3\4\uffff\1\1\10\uffff\1\2\74\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "\1\13\57\uffff\1\13\50\uffff\1\12",
            "",
            ""
    };
    static final char[] dfa_70 = DFA.unpackEncodedStringToUnsignedChars(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA170 extends DFA {

        public DFA170(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 170;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_67;
            this.max = dfa_70;
            this.accept = dfa_59;
            this.special = dfa_11;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "9179:2: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0010000000120000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x8800000040000010L,0x00000000000001C4L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x8800000040004010L,0x00000000000001C4L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0020000000600020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000802L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000021002050L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000021002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000024002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0020000000000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0020000000000020L,0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000C800000000070L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000C800000000072L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0003C10000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000040004000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000C820000000072L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x000CA00000000070L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000200004000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000002010800000L,0x000000FC00000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x000000E010800000L,0x000000FC00000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x000000A010800000L,0x000000FC00000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x5400000000000010L,0x00000000000E0000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0300000000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x5000000000000010L,0x00000000000E0000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000041000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000040800802L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000040000802L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000004004010L,0x000000000000BC00L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000010L,0x000000000000BC00L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000004004010L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000040800002L,0x0000000000000008L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000040800002L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000041000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000040000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x8800000140000010L,0x00000000000001C4L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000200L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0020000000000000L,0x0000030200004000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000008001000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000001000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000008000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0020004000000020L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});

}