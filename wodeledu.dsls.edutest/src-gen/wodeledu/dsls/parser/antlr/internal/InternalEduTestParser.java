package wodeledu.dsls.parser.antlr.internal;

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
import wodeledu.dsls.services.EduTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEduTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AlternativeResponse'", "','", "'{'", "'}'", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'navigation'", "'='", "'retry'", "'yes'", "'no'", "'weighted'", "'penalty'", "'order'", "'mode'", "'description'", "'for'", "'%text'", "'('", "')'", "'-'", "'.'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'"
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
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
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
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalEduTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEduTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEduTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEduTest.g"; }



     	private EduTestGrammarAccess grammarAccess;

        public InternalEduTestParser(TokenStream input, EduTestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected EduTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalEduTest.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalEduTest.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalEduTest.g:66:2: iv_ruleProgram= ruleProgram EOF
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
    // InternalEduTest.g:72:1: ruleProgram returns [EObject current=null] : ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_config_1_0 = null;

        EObject lv_exercises_2_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:78:2: ( ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ ) )
            // InternalEduTest.g:79:2: ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ )
            {
            // InternalEduTest.g:79:2: ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ )
            // InternalEduTest.g:80:3: () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+
            {
            // InternalEduTest.g:80:3: ()
            // InternalEduTest.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProgramAccess().getProgramAction_0(),
            					current);
            			

            }

            // InternalEduTest.g:87:3: ( (lv_config_1_0= ruleProgramConfiguration ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalEduTest.g:88:4: (lv_config_1_0= ruleProgramConfiguration )
                    {
                    // InternalEduTest.g:88:4: (lv_config_1_0= ruleProgramConfiguration )
                    // InternalEduTest.g:89:5: lv_config_1_0= ruleProgramConfiguration
                    {

                    					newCompositeNode(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_config_1_0=ruleProgramConfiguration();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getProgramRule());
                    					}
                    					set(
                    						current,
                    						"config",
                    						lv_config_1_0,
                    						"wodeledu.dsls.EduTest.ProgramConfiguration");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalEduTest.g:106:3: ( (lv_exercises_2_0= ruleMutatorTests ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||(LA2_0>=15 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalEduTest.g:107:4: (lv_exercises_2_0= ruleMutatorTests )
            	    {
            	    // InternalEduTest.g:107:4: (lv_exercises_2_0= ruleMutatorTests )
            	    // InternalEduTest.g:108:5: lv_exercises_2_0= ruleMutatorTests
            	    {

            	    					newCompositeNode(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_exercises_2_0=ruleMutatorTests();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProgramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"exercises",
            	    						lv_exercises_2_0,
            	    						"wodeledu.dsls.EduTest.MutatorTests");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleMutatorTests"
    // InternalEduTest.g:129:1: entryRuleMutatorTests returns [EObject current=null] : iv_ruleMutatorTests= ruleMutatorTests EOF ;
    public final EObject entryRuleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorTests = null;


        try {
            // InternalEduTest.g:129:53: (iv_ruleMutatorTests= ruleMutatorTests EOF )
            // InternalEduTest.g:130:2: iv_ruleMutatorTests= ruleMutatorTests EOF
            {
             newCompositeNode(grammarAccess.getMutatorTestsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMutatorTests=ruleMutatorTests();

            state._fsp--;

             current =iv_ruleMutatorTests; 
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
    // $ANTLR end "entryRuleMutatorTests"


    // $ANTLR start "ruleMutatorTests"
    // InternalEduTest.g:136:1: ruleMutatorTests returns [EObject current=null] : (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords ) ;
    public final EObject ruleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject this_AlternativeResponse_0 = null;

        EObject this_MultiChoiceDiagram_1 = null;

        EObject this_MultiChoiceEmendation_2 = null;

        EObject this_MatchPairs_3 = null;

        EObject this_MissingWords_4 = null;



        	enterRule();

        try {
            // InternalEduTest.g:142:2: ( (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords ) )
            // InternalEduTest.g:143:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords )
            {
            // InternalEduTest.g:143:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            case 17:
                {
                alt3=4;
                }
                break;
            case 18:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalEduTest.g:144:3: this_AlternativeResponse_0= ruleAlternativeResponse
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlternativeResponse_0=ruleAlternativeResponse();

                    state._fsp--;


                    			current = this_AlternativeResponse_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:153:3: this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MultiChoiceDiagram_1=ruleMultiChoiceDiagram();

                    state._fsp--;


                    			current = this_MultiChoiceDiagram_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalEduTest.g:162:3: this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_MultiChoiceEmendation_2=ruleMultiChoiceEmendation();

                    state._fsp--;


                    			current = this_MultiChoiceEmendation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalEduTest.g:171:3: this_MatchPairs_3= ruleMatchPairs
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMatchPairsParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MatchPairs_3=ruleMatchPairs();

                    state._fsp--;


                    			current = this_MatchPairs_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalEduTest.g:180:3: this_MissingWords_4= ruleMissingWords
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMissingWordsParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_MissingWords_4=ruleMissingWords();

                    state._fsp--;


                    			current = this_MissingWords_4;
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
    // $ANTLR end "ruleMutatorTests"


    // $ANTLR start "entryRuleAlternativeResponse"
    // InternalEduTest.g:192:1: entryRuleAlternativeResponse returns [EObject current=null] : iv_ruleAlternativeResponse= ruleAlternativeResponse EOF ;
    public final EObject entryRuleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeResponse = null;


        try {
            // InternalEduTest.g:192:60: (iv_ruleAlternativeResponse= ruleAlternativeResponse EOF )
            // InternalEduTest.g:193:2: iv_ruleAlternativeResponse= ruleAlternativeResponse EOF
            {
             newCompositeNode(grammarAccess.getAlternativeResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlternativeResponse=ruleAlternativeResponse();

            state._fsp--;

             current =iv_ruleAlternativeResponse; 
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
    // $ANTLR end "entryRuleAlternativeResponse"


    // $ANTLR start "ruleAlternativeResponse"
    // InternalEduTest.g:199:1: ruleAlternativeResponse returns [EObject current=null] : (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:205:2: ( (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:206:2: (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:206:2: (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:207:3: otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0());
            		
            // InternalEduTest.g:211:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEduTest.g:212:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:212:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:213:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:213:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:214:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternativeResponseRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:225:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==12) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalEduTest.g:226:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:230:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:231:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:231:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:232:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getAlternativeResponseRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:249:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:250:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:250:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:251:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleTestConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TestConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:268:3: ( (lv_tests_6_0= ruleTest ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalEduTest.g:269:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:269:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:270:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_6_0,
            	    						"wodeledu.dsls.EduTest.Test");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeResponse"


    // $ANTLR start "entryRuleMultiChoiceDiagram"
    // InternalEduTest.g:295:1: entryRuleMultiChoiceDiagram returns [EObject current=null] : iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF ;
    public final EObject entryRuleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceDiagram = null;


        try {
            // InternalEduTest.g:295:59: (iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF )
            // InternalEduTest.g:296:2: iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceDiagramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiChoiceDiagram=ruleMultiChoiceDiagram();

            state._fsp--;

             current =iv_ruleMultiChoiceDiagram; 
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
    // $ANTLR end "entryRuleMultiChoiceDiagram"


    // $ANTLR start "ruleMultiChoiceDiagram"
    // InternalEduTest.g:302:1: ruleMultiChoiceDiagram returns [EObject current=null] : (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:308:2: ( (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:309:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:309:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:310:3: otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0());
            		
            // InternalEduTest.g:314:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalEduTest.g:315:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:315:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:316:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:316:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:317:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceDiagramRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:328:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==12) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalEduTest.g:329:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:333:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:334:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:334:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:335:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMultiChoiceDiagramRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:352:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:353:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:353:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:354:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleTestConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TestConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:371:3: ( (lv_tests_6_0= ruleTest ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==28) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalEduTest.g:372:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:372:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:373:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_6_0,
            	    						"wodeledu.dsls.EduTest.Test");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiChoiceDiagram"


    // $ANTLR start "entryRuleMultiChoiceEmendation"
    // InternalEduTest.g:398:1: entryRuleMultiChoiceEmendation returns [EObject current=null] : iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF ;
    public final EObject entryRuleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmendation = null;


        try {
            // InternalEduTest.g:398:62: (iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF )
            // InternalEduTest.g:399:2: iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceEmendationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiChoiceEmendation=ruleMultiChoiceEmendation();

            state._fsp--;

             current =iv_ruleMultiChoiceEmendation; 
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
    // $ANTLR end "entryRuleMultiChoiceEmendation"


    // $ANTLR start "ruleMultiChoiceEmendation"
    // InternalEduTest.g:405:1: ruleMultiChoiceEmendation returns [EObject current=null] : (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:411:2: ( (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:412:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:412:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:413:3: otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0());
            		
            // InternalEduTest.g:417:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEduTest.g:418:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:418:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:419:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:419:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:420:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmendationRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:431:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==12) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalEduTest.g:432:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:436:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:437:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:437:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:438:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMultiChoiceEmendationRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:455:3: ( (lv_config_5_0= ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:456:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:456:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            // InternalEduTest.g:457:5: lv_config_5_0= ruleMultiChoiceEmConfig
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleMultiChoiceEmConfig();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.MultiChoiceEmConfig");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:474:3: ( (lv_tests_6_0= ruleTest ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalEduTest.g:475:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:475:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:476:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_6_0,
            	    						"wodeledu.dsls.EduTest.Test");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiChoiceEmendation"


    // $ANTLR start "entryRuleMatchPairs"
    // InternalEduTest.g:501:1: entryRuleMatchPairs returns [EObject current=null] : iv_ruleMatchPairs= ruleMatchPairs EOF ;
    public final EObject entryRuleMatchPairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchPairs = null;


        try {
            // InternalEduTest.g:501:51: (iv_ruleMatchPairs= ruleMatchPairs EOF )
            // InternalEduTest.g:502:2: iv_ruleMatchPairs= ruleMatchPairs EOF
            {
             newCompositeNode(grammarAccess.getMatchPairsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMatchPairs=ruleMatchPairs();

            state._fsp--;

             current =iv_ruleMatchPairs; 
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
    // $ANTLR end "entryRuleMatchPairs"


    // $ANTLR start "ruleMatchPairs"
    // InternalEduTest.g:508:1: ruleMatchPairs returns [EObject current=null] : (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMatchPairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:514:2: ( (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:515:2: (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:515:2: (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:516:3: otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0());
            		
            // InternalEduTest.g:520:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalEduTest.g:521:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:521:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:522:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:522:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:523:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMatchPairsRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:534:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==12) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalEduTest.g:535:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:539:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:540:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:540:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:541:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMatchPairsRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

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

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMatchPairsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:558:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:559:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:559:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:560:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getMatchPairsAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleTestConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMatchPairsRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TestConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:577:3: ( (lv_tests_6_0= ruleTest ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==28) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalEduTest.g:578:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:578:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:579:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMatchPairsAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMatchPairsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_6_0,
            	    						"wodeledu.dsls.EduTest.Test");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMatchPairsAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMatchPairs"


    // $ANTLR start "entryRuleMissingWords"
    // InternalEduTest.g:604:1: entryRuleMissingWords returns [EObject current=null] : iv_ruleMissingWords= ruleMissingWords EOF ;
    public final EObject entryRuleMissingWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissingWords = null;


        try {
            // InternalEduTest.g:604:53: (iv_ruleMissingWords= ruleMissingWords EOF )
            // InternalEduTest.g:605:2: iv_ruleMissingWords= ruleMissingWords EOF
            {
             newCompositeNode(grammarAccess.getMissingWordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMissingWords=ruleMissingWords();

            state._fsp--;

             current =iv_ruleMissingWords; 
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
    // $ANTLR end "entryRuleMissingWords"


    // $ANTLR start "ruleMissingWords"
    // InternalEduTest.g:611:1: ruleMissingWords returns [EObject current=null] : (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMissingWords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:617:2: ( (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:618:2: (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:618:2: (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:619:3: otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0());
            		
            // InternalEduTest.g:623:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalEduTest.g:624:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:624:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:625:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:625:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:626:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMissingWordsRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:637:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==12) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalEduTest.g:638:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:642:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:643:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:643:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:644:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMissingWordsRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMissingWordsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:661:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:662:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:662:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:663:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getMissingWordsAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleTestConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissingWordsRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TestConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:680:3: ( (lv_tests_6_0= ruleTest ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalEduTest.g:681:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:681:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:682:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMissingWordsAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMissingWordsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_6_0,
            	    						"wodeledu.dsls.EduTest.Test");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMissingWordsAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMissingWords"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalEduTest.g:707:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalEduTest.g:707:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalEduTest.g:708:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
            {
             newCompositeNode(grammarAccess.getProgramConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramConfiguration=ruleProgramConfiguration();

            state._fsp--;

             current =iv_ruleProgramConfiguration; 
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
    // $ANTLR end "entryRuleProgramConfiguration"


    // $ANTLR start "ruleProgramConfiguration"
    // InternalEduTest.g:714:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) ;
    public final EObject ruleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_navigation_2_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:720:2: ( (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) )
            // InternalEduTest.g:721:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            {
            // InternalEduTest.g:721:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            // InternalEduTest.g:722:3: otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1());
            		
            // InternalEduTest.g:730:3: ( (lv_navigation_2_0= ruleNavigation ) )
            // InternalEduTest.g:731:4: (lv_navigation_2_0= ruleNavigation )
            {
            // InternalEduTest.g:731:4: (lv_navigation_2_0= ruleNavigation )
            // InternalEduTest.g:732:5: lv_navigation_2_0= ruleNavigation
            {

            					newCompositeNode(grammarAccess.getProgramConfigurationAccess().getNavigationNavigationEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_navigation_2_0=ruleNavigation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramConfigurationRule());
            					}
            					set(
            						current,
            						"navigation",
            						lv_navigation_2_0,
            						"wodeledu.dsls.EduTest.Navigation");
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
    // $ANTLR end "ruleProgramConfiguration"


    // $ANTLR start "entryRuleTestConfiguration"
    // InternalEduTest.g:753:1: entryRuleTestConfiguration returns [EObject current=null] : iv_ruleTestConfiguration= ruleTestConfiguration EOF ;
    public final EObject entryRuleTestConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestConfiguration = null;


        try {
            // InternalEduTest.g:753:58: (iv_ruleTestConfiguration= ruleTestConfiguration EOF )
            // InternalEduTest.g:754:2: iv_ruleTestConfiguration= ruleTestConfiguration EOF
            {
             newCompositeNode(grammarAccess.getTestConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestConfiguration=ruleTestConfiguration();

            state._fsp--;

             current =iv_ruleTestConfiguration; 
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
    // $ANTLR end "entryRuleTestConfiguration"


    // $ANTLR start "ruleTestConfiguration"
    // InternalEduTest.g:760:1: ruleTestConfiguration returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) ;
    public final EObject ruleTestConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;


        	enterRule();

        try {
            // InternalEduTest.g:766:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) )
            // InternalEduTest.g:767:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            {
            // InternalEduTest.g:767:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            // InternalEduTest.g:768:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            {
            // InternalEduTest.g:768:3: ()
            // InternalEduTest.g:769:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getTestConfigurationAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:783:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:784:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:784:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:785:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:785:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            else if ( (LA19_0==23) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalEduTest.g:786:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:797:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getTestConfigurationAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;

            }


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
    // $ANTLR end "ruleTestConfiguration"


    // $ANTLR start "entryRuleMultiChoiceEmConfig"
    // InternalEduTest.g:814:1: entryRuleMultiChoiceEmConfig returns [EObject current=null] : iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF ;
    public final EObject entryRuleMultiChoiceEmConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmConfig = null;


        try {
            // InternalEduTest.g:814:60: (iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:815:2: iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceEmConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiChoiceEmConfig=ruleMultiChoiceEmConfig();

            state._fsp--;

             current =iv_ruleMultiChoiceEmConfig; 
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
    // $ANTLR end "entryRuleMultiChoiceEmConfig"


    // $ANTLR start "ruleMultiChoiceEmConfig"
    // InternalEduTest.g:821:1: ruleMultiChoiceEmConfig returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) ;
    public final EObject ruleMultiChoiceEmConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_weighted_7_1=null;
        Token lv_weighted_7_2=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_penalty_11_0 = null;

        Enumerator lv_order_15_0 = null;

        Enumerator lv_mode_19_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:827:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) )
            // InternalEduTest.g:828:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            {
            // InternalEduTest.g:828:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            // InternalEduTest.g:829:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) )
            {
            // InternalEduTest.g:829:3: ()
            // InternalEduTest.g:830:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:844:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:845:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:845:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:846:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:846:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            else if ( (LA20_0==23) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalEduTest.g:847:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,22,FOLLOW_13); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:858:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,23,FOLLOW_13); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getMultiChoiceEmConfigAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4());
            		
            otherlv_5=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5());
            		
            otherlv_6=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6());
            		
            // InternalEduTest.g:883:3: ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) )
            // InternalEduTest.g:884:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            {
            // InternalEduTest.g:884:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            // InternalEduTest.g:885:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            {
            // InternalEduTest.g:885:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            else if ( (LA21_0==23) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalEduTest.g:886:6: lv_weighted_7_1= 'yes'
                    {
                    lv_weighted_7_1=(Token)match(input,22,FOLLOW_13); 

                    						newLeafNode(lv_weighted_7_1, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "weighted", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:897:6: lv_weighted_7_2= 'no'
                    {
                    lv_weighted_7_2=(Token)match(input,23,FOLLOW_13); 

                    						newLeafNode(lv_weighted_7_2, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedNoKeyword_7_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "weighted", true, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_8=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8());
            		
            otherlv_9=(Token)match(input,25,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9());
            		
            otherlv_10=(Token)match(input,20,FOLLOW_16); 

            			newLeafNode(otherlv_10, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10());
            		
            // InternalEduTest.g:922:3: ( (lv_penalty_11_0= ruleEDouble ) )
            // InternalEduTest.g:923:4: (lv_penalty_11_0= ruleEDouble )
            {
            // InternalEduTest.g:923:4: (lv_penalty_11_0= ruleEDouble )
            // InternalEduTest.g:924:5: lv_penalty_11_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_13);
            lv_penalty_11_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            					}
            					set(
            						current,
            						"penalty",
            						lv_penalty_11_0,
            						"wodeledu.dsls.EduTest.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_12, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12());
            		
            otherlv_13=(Token)match(input,26,FOLLOW_10); 

            			newLeafNode(otherlv_13, grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13());
            		
            otherlv_14=(Token)match(input,20,FOLLOW_18); 

            			newLeafNode(otherlv_14, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14());
            		
            // InternalEduTest.g:953:3: ( (lv_order_15_0= ruleOrder ) )
            // InternalEduTest.g:954:4: (lv_order_15_0= ruleOrder )
            {
            // InternalEduTest.g:954:4: (lv_order_15_0= ruleOrder )
            // InternalEduTest.g:955:5: lv_order_15_0= ruleOrder
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0());
            				
            pushFollow(FOLLOW_13);
            lv_order_15_0=ruleOrder();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            					}
            					set(
            						current,
            						"order",
            						lv_order_15_0,
            						"wodeledu.dsls.EduTest.Order");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_16, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16());
            		
            otherlv_17=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_17, grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17());
            		
            otherlv_18=(Token)match(input,20,FOLLOW_20); 

            			newLeafNode(otherlv_18, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18());
            		
            // InternalEduTest.g:984:3: ( (lv_mode_19_0= ruleMode ) )
            // InternalEduTest.g:985:4: (lv_mode_19_0= ruleMode )
            {
            // InternalEduTest.g:985:4: (lv_mode_19_0= ruleMode )
            // InternalEduTest.g:986:5: lv_mode_19_0= ruleMode
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0());
            				
            pushFollow(FOLLOW_2);
            lv_mode_19_0=ruleMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            					}
            					set(
            						current,
            						"mode",
            						lv_mode_19_0,
            						"wodeledu.dsls.EduTest.Mode");
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
    // $ANTLR end "ruleMultiChoiceEmConfig"


    // $ANTLR start "entryRuleTest"
    // InternalEduTest.g:1007:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalEduTest.g:1007:45: (iv_ruleTest= ruleTest EOF )
            // InternalEduTest.g:1008:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
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
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // InternalEduTest.g:1014:1: ruleTest returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_expression_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_source_2_0 = null;

        AntlrDatatypeRuleToken lv_question_4_0 = null;

        AntlrDatatypeRuleToken lv_identifier_7_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1020:2: ( (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) )
            // InternalEduTest.g:1021:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            {
            // InternalEduTest.g:1021:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            // InternalEduTest.g:1022:3: otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getTestAccess().getDescriptionKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getTestAccess().getForKeyword_1());
            		
            // InternalEduTest.g:1030:3: ( (lv_source_2_0= ruleEString ) )
            // InternalEduTest.g:1031:4: (lv_source_2_0= ruleEString )
            {
            // InternalEduTest.g:1031:4: (lv_source_2_0= ruleEString )
            // InternalEduTest.g:1032:5: lv_source_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
            lv_source_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_2_0,
            						"wodeledu.dsls.EduTest.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3());
            		
            // InternalEduTest.g:1053:3: ( (lv_question_4_0= ruleEString ) )
            // InternalEduTest.g:1054:4: (lv_question_4_0= ruleEString )
            {
            // InternalEduTest.g:1054:4: (lv_question_4_0= ruleEString )
            // InternalEduTest.g:1055:5: lv_question_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_question_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestRule());
            					}
            					set(
            						current,
            						"question",
            						lv_question_4_0,
            						"wodeledu.dsls.EduTest.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:1072:3: ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalEduTest.g:1073:4: ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    {
                    // InternalEduTest.g:1073:4: ( (lv_expression_5_0= '%text' ) )
                    // InternalEduTest.g:1074:5: (lv_expression_5_0= '%text' )
                    {
                    // InternalEduTest.g:1074:5: (lv_expression_5_0= '%text' )
                    // InternalEduTest.g:1075:6: lv_expression_5_0= '%text'
                    {
                    lv_expression_5_0=(Token)match(input,30,FOLLOW_24); 

                    						newLeafNode(lv_expression_5_0, grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestRule());
                    						}
                    						setWithLastConsumed(current, "expression", true, "%text");
                    					

                    }


                    }

                    // InternalEduTest.g:1087:4: (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==31) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalEduTest.g:1088:5: otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')'
                            {
                            otherlv_6=(Token)match(input,31,FOLLOW_22); 

                            					newLeafNode(otherlv_6, grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0());
                            				
                            // InternalEduTest.g:1092:5: ( (lv_identifier_7_0= ruleEString ) )
                            // InternalEduTest.g:1093:6: (lv_identifier_7_0= ruleEString )
                            {
                            // InternalEduTest.g:1093:6: (lv_identifier_7_0= ruleEString )
                            // InternalEduTest.g:1094:7: lv_identifier_7_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getTestAccess().getIdentifierEStringParserRuleCall_5_1_1_0());
                            						
                            pushFollow(FOLLOW_25);
                            lv_identifier_7_0=ruleEString();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTestRule());
                            							}
                            							set(
                            								current,
                            								"identifier",
                            								lv_identifier_7_0,
                            								"wodeledu.dsls.EduTest.EString");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_8=(Token)match(input,32,FOLLOW_2); 

                            					newLeafNode(otherlv_8, grammarAccess.getTestAccess().getRightParenthesisKeyword_5_1_2());
                            				

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
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleEString"
    // InternalEduTest.g:1121:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalEduTest.g:1121:47: (iv_ruleEString= ruleEString EOF )
            // InternalEduTest.g:1122:2: iv_ruleEString= ruleEString EOF
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
    // InternalEduTest.g:1128:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1134:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalEduTest.g:1135:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalEduTest.g:1135:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_STRING) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_ID) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalEduTest.g:1136:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1144:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleEDouble"
    // InternalEduTest.g:1155:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalEduTest.g:1155:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalEduTest.g:1156:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalEduTest.g:1162:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalEduTest.g:1168:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalEduTest.g:1169:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalEduTest.g:1169:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalEduTest.g:1170:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalEduTest.g:1170:3: (kw= '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalEduTest.g:1171:4: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_26); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalEduTest.g:1177:3: (this_INT_1= RULE_INT )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_INT) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalEduTest.g:1178:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_27); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,34,FOLLOW_28); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_29); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalEduTest.g:1198:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=35 && LA29_0<=36)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalEduTest.g:1199:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalEduTest.g:1199:4: (kw= 'E' | kw= 'e' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==35) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==36) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalEduTest.g:1200:5: kw= 'E'
                            {
                            kw=(Token)match(input,35,FOLLOW_30); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalEduTest.g:1206:5: kw= 'e'
                            {
                            kw=(Token)match(input,36,FOLLOW_30); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalEduTest.g:1212:4: (kw= '-' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==33) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalEduTest.g:1213:5: kw= '-'
                            {
                            kw=(Token)match(input,33,FOLLOW_28); 

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


    // $ANTLR start "ruleOrder"
    // InternalEduTest.g:1231:1: ruleOrder returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) ;
    public final Enumerator ruleOrder() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalEduTest.g:1237:2: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) )
            // InternalEduTest.g:1238:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            {
            // InternalEduTest.g:1238:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt30=1;
                }
                break;
            case 38:
                {
                alt30=2;
                }
                break;
            case 39:
                {
                alt30=3;
                }
                break;
            case 40:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalEduTest.g:1239:3: (enumLiteral_0= 'fixed' )
                    {
                    // InternalEduTest.g:1239:3: (enumLiteral_0= 'fixed' )
                    // InternalEduTest.g:1240:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1247:3: (enumLiteral_1= 'random' )
                    {
                    // InternalEduTest.g:1247:3: (enumLiteral_1= 'random' )
                    // InternalEduTest.g:1248:4: enumLiteral_1= 'random'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:1255:3: (enumLiteral_2= 'options-ascending' )
                    {
                    // InternalEduTest.g:1255:3: (enumLiteral_2= 'options-ascending' )
                    // InternalEduTest.g:1256:4: enumLiteral_2= 'options-ascending'
                    {
                    enumLiteral_2=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:1263:3: (enumLiteral_3= 'options-descending' )
                    {
                    // InternalEduTest.g:1263:3: (enumLiteral_3= 'options-descending' )
                    // InternalEduTest.g:1264:4: enumLiteral_3= 'options-descending'
                    {
                    enumLiteral_3=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleOrder"


    // $ANTLR start "ruleMode"
    // InternalEduTest.g:1274:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1280:2: ( ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) )
            // InternalEduTest.g:1281:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            {
            // InternalEduTest.g:1281:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==41) ) {
                alt31=1;
            }
            else if ( (LA31_0==42) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalEduTest.g:1282:3: (enumLiteral_0= 'radiobutton' )
                    {
                    // InternalEduTest.g:1282:3: (enumLiteral_0= 'radiobutton' )
                    // InternalEduTest.g:1283:4: enumLiteral_0= 'radiobutton'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1290:3: (enumLiteral_1= 'checkbox' )
                    {
                    // InternalEduTest.g:1290:3: (enumLiteral_1= 'checkbox' )
                    // InternalEduTest.g:1291:4: enumLiteral_1= 'checkbox'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleMode"


    // $ANTLR start "ruleNavigation"
    // InternalEduTest.g:1301:1: ruleNavigation returns [Enumerator current=null] : ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) ;
    public final Enumerator ruleNavigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1307:2: ( ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) )
            // InternalEduTest.g:1308:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            {
            // InternalEduTest.g:1308:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            else if ( (LA32_0==44) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalEduTest.g:1309:3: (enumLiteral_0= 'free' )
                    {
                    // InternalEduTest.g:1309:3: (enumLiteral_0= 'free' )
                    // InternalEduTest.g:1310:4: enumLiteral_0= 'free'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1317:3: (enumLiteral_1= 'locked' )
                    {
                    // InternalEduTest.g:1317:3: (enumLiteral_1= 'locked' )
                    // InternalEduTest.g:1318:4: enumLiteral_1= 'locked'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleNavigation"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000078800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000078802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000600000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000001E000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000040L});

}