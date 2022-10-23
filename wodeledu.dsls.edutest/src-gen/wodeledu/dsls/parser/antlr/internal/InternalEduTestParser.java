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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AlternativeResponse'", "','", "'{'", "'}'", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'MultiChoiceText'", "'navigation'", "'='", "'retry'", "'yes'", "'no'", "'weighted'", "'penalty'", "'order'", "'mode'", "'text'", "'description'", "'for'", "'%text'", "'('", "')'", "'-'", "'.'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'"
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
    public static final int T__45=45;
    public static final int T__46=46;
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

            if ( (LA1_0==20) ) {
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

                if ( (LA2_0==11||(LA2_0>=15 && LA2_0<=19)) ) {
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
    // InternalEduTest.g:136:1: ruleMutatorTests returns [EObject current=null] : (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText ) ;
    public final EObject ruleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject this_AlternativeResponse_0 = null;

        EObject this_MultiChoiceDiagram_1 = null;

        EObject this_MultiChoiceEmendation_2 = null;

        EObject this_MatchPairs_3 = null;

        EObject this_MissingWords_4 = null;

        EObject this_MultiChoiceText_5 = null;



        	enterRule();

        try {
            // InternalEduTest.g:142:2: ( (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText ) )
            // InternalEduTest.g:143:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText )
            {
            // InternalEduTest.g:143:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText )
            int alt3=6;
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
            case 19:
                {
                alt3=6;
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
                case 6 :
                    // InternalEduTest.g:189:3: this_MultiChoiceText_5= ruleMultiChoiceText
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceTextParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_MultiChoiceText_5=ruleMultiChoiceText();

                    state._fsp--;


                    			current = this_MultiChoiceText_5;
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
    // InternalEduTest.g:201:1: entryRuleAlternativeResponse returns [EObject current=null] : iv_ruleAlternativeResponse= ruleAlternativeResponse EOF ;
    public final EObject entryRuleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeResponse = null;


        try {
            // InternalEduTest.g:201:60: (iv_ruleAlternativeResponse= ruleAlternativeResponse EOF )
            // InternalEduTest.g:202:2: iv_ruleAlternativeResponse= ruleAlternativeResponse EOF
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
    // InternalEduTest.g:208:1: ruleAlternativeResponse returns [EObject current=null] : (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
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
            // InternalEduTest.g:214:2: ( (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:215:2: (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:215:2: (otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:216:3: otherlv_0= 'AlternativeResponse' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0());
            		
            // InternalEduTest.g:220:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEduTest.g:221:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:221:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:222:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:222:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:223:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternativeResponseRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:234:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==12) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalEduTest.g:235:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:239:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:240:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:240:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:241:7: otherlv_3= RULE_ID
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
            		
            // InternalEduTest.g:258:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:259:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:259:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:260:5: lv_config_5_0= ruleTestConfiguration
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

            // InternalEduTest.g:277:3: ( (lv_tests_6_0= ruleTest ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==30) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalEduTest.g:278:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:278:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:279:5: lv_tests_6_0= ruleTest
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
    // InternalEduTest.g:304:1: entryRuleMultiChoiceDiagram returns [EObject current=null] : iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF ;
    public final EObject entryRuleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceDiagram = null;


        try {
            // InternalEduTest.g:304:59: (iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF )
            // InternalEduTest.g:305:2: iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF
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
    // InternalEduTest.g:311:1: ruleMultiChoiceDiagram returns [EObject current=null] : (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
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
            // InternalEduTest.g:317:2: ( (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:318:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:318:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:319:3: otherlv_0= 'MultiChoiceDiagram' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0());
            		
            // InternalEduTest.g:323:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalEduTest.g:324:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:324:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:325:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:325:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:326:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceDiagramRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:337:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==12) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalEduTest.g:338:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:342:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:343:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:343:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:344:7: otherlv_3= RULE_ID
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
            		
            // InternalEduTest.g:361:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:362:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:362:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:363:5: lv_config_5_0= ruleTestConfiguration
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

            // InternalEduTest.g:380:3: ( (lv_tests_6_0= ruleTest ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalEduTest.g:381:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:381:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:382:5: lv_tests_6_0= ruleTest
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
    // InternalEduTest.g:407:1: entryRuleMultiChoiceEmendation returns [EObject current=null] : iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF ;
    public final EObject entryRuleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmendation = null;


        try {
            // InternalEduTest.g:407:62: (iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF )
            // InternalEduTest.g:408:2: iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF
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
    // InternalEduTest.g:414:1: ruleMultiChoiceEmendation returns [EObject current=null] : (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
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
            // InternalEduTest.g:420:2: ( (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:421:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:421:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:422:3: otherlv_0= 'MultiChoiceEmendation' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0());
            		
            // InternalEduTest.g:426:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEduTest.g:427:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:427:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:428:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:428:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:429:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmendationRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:440:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==12) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalEduTest.g:441:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:445:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:446:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:446:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:447:7: otherlv_3= RULE_ID
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
            		
            // InternalEduTest.g:464:3: ( (lv_config_5_0= ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:465:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:465:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            // InternalEduTest.g:466:5: lv_config_5_0= ruleMultiChoiceEmConfig
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

            // InternalEduTest.g:483:3: ( (lv_tests_6_0= ruleTest ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalEduTest.g:484:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:484:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:485:5: lv_tests_6_0= ruleTest
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
    // InternalEduTest.g:510:1: entryRuleMatchPairs returns [EObject current=null] : iv_ruleMatchPairs= ruleMatchPairs EOF ;
    public final EObject entryRuleMatchPairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchPairs = null;


        try {
            // InternalEduTest.g:510:51: (iv_ruleMatchPairs= ruleMatchPairs EOF )
            // InternalEduTest.g:511:2: iv_ruleMatchPairs= ruleMatchPairs EOF
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
    // InternalEduTest.g:517:1: ruleMatchPairs returns [EObject current=null] : (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
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
            // InternalEduTest.g:523:2: ( (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:524:2: (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:524:2: (otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:525:3: otherlv_0= 'MatchPairs' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0());
            		
            // InternalEduTest.g:529:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalEduTest.g:530:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:530:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:531:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:531:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:532:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMatchPairsRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:543:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==12) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalEduTest.g:544:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:548:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:549:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:549:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:550:7: otherlv_3= RULE_ID
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
            		
            // InternalEduTest.g:567:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:568:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:568:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:569:5: lv_config_5_0= ruleTestConfiguration
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

            // InternalEduTest.g:586:3: ( (lv_tests_6_0= ruleTest ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalEduTest.g:587:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:587:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:588:5: lv_tests_6_0= ruleTest
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
    // InternalEduTest.g:613:1: entryRuleMissingWords returns [EObject current=null] : iv_ruleMissingWords= ruleMissingWords EOF ;
    public final EObject entryRuleMissingWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissingWords = null;


        try {
            // InternalEduTest.g:613:53: (iv_ruleMissingWords= ruleMissingWords EOF )
            // InternalEduTest.g:614:2: iv_ruleMissingWords= ruleMissingWords EOF
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
    // InternalEduTest.g:620:1: ruleMissingWords returns [EObject current=null] : (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
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
            // InternalEduTest.g:626:2: ( (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:627:2: (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:627:2: (otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:628:3: otherlv_0= 'MissingWords' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0());
            		
            // InternalEduTest.g:632:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalEduTest.g:633:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:633:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:634:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:634:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:635:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMissingWordsRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:646:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==12) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalEduTest.g:647:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:651:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:652:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:652:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:653:7: otherlv_3= RULE_ID
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
            		
            // InternalEduTest.g:670:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:671:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:671:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:672:5: lv_config_5_0= ruleTestConfiguration
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

            // InternalEduTest.g:689:3: ( (lv_tests_6_0= ruleTest ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalEduTest.g:690:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:690:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:691:5: lv_tests_6_0= ruleTest
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


    // $ANTLR start "entryRuleMultiChoiceText"
    // InternalEduTest.g:716:1: entryRuleMultiChoiceText returns [EObject current=null] : iv_ruleMultiChoiceText= ruleMultiChoiceText EOF ;
    public final EObject entryRuleMultiChoiceText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceText = null;


        try {
            // InternalEduTest.g:716:56: (iv_ruleMultiChoiceText= ruleMultiChoiceText EOF )
            // InternalEduTest.g:717:2: iv_ruleMultiChoiceText= ruleMultiChoiceText EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiChoiceText=ruleMultiChoiceText();

            state._fsp--;

             current =iv_ruleMultiChoiceText; 
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
    // $ANTLR end "entryRuleMultiChoiceText"


    // $ANTLR start "ruleMultiChoiceText"
    // InternalEduTest.g:723:1: ruleMultiChoiceText returns [EObject current=null] : (otherlv_0= 'MultiChoiceText' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceTextConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceText() throws RecognitionException {
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
            // InternalEduTest.g:729:2: ( (otherlv_0= 'MultiChoiceText' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceTextConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:730:2: (otherlv_0= 'MultiChoiceText' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceTextConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:730:2: (otherlv_0= 'MultiChoiceText' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceTextConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:731:3: otherlv_0= 'MultiChoiceText' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceTextConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceTextAccess().getMultiChoiceTextKeyword_0());
            		
            // InternalEduTest.g:735:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalEduTest.g:736:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalEduTest.g:736:4: ( (otherlv_1= RULE_ID ) )
                    // InternalEduTest.g:737:5: (otherlv_1= RULE_ID )
                    {
                    // InternalEduTest.g:737:5: (otherlv_1= RULE_ID )
                    // InternalEduTest.g:738:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceTextRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_1, grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalEduTest.g:749:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==12) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalEduTest.g:750:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,12,FOLLOW_7); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceTextAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:754:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalEduTest.g:755:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:755:6: (otherlv_3= RULE_ID )
                    	    // InternalEduTest.g:756:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMultiChoiceTextRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceTextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:773:3: ( (lv_config_5_0= ruleMultiChoiceTextConfig ) )
            // InternalEduTest.g:774:4: (lv_config_5_0= ruleMultiChoiceTextConfig )
            {
            // InternalEduTest.g:774:4: (lv_config_5_0= ruleMultiChoiceTextConfig )
            // InternalEduTest.g:775:5: lv_config_5_0= ruleMultiChoiceTextConfig
            {

            					newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getConfigMultiChoiceTextConfigParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_config_5_0=ruleMultiChoiceTextConfig();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceTextRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.MultiChoiceTextConfig");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:792:3: ( (lv_tests_6_0= ruleTest ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalEduTest.g:793:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:793:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:794:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMultiChoiceTextRule());
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
            	    break loop21;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMultiChoiceTextAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiChoiceText"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalEduTest.g:819:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalEduTest.g:819:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalEduTest.g:820:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
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
    // InternalEduTest.g:826:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) ;
    public final EObject ruleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_navigation_2_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:832:2: ( (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) )
            // InternalEduTest.g:833:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            {
            // InternalEduTest.g:833:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            // InternalEduTest.g:834:3: otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1());
            		
            // InternalEduTest.g:842:3: ( (lv_navigation_2_0= ruleNavigation ) )
            // InternalEduTest.g:843:4: (lv_navigation_2_0= ruleNavigation )
            {
            // InternalEduTest.g:843:4: (lv_navigation_2_0= ruleNavigation )
            // InternalEduTest.g:844:5: lv_navigation_2_0= ruleNavigation
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
    // InternalEduTest.g:865:1: entryRuleTestConfiguration returns [EObject current=null] : iv_ruleTestConfiguration= ruleTestConfiguration EOF ;
    public final EObject entryRuleTestConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestConfiguration = null;


        try {
            // InternalEduTest.g:865:58: (iv_ruleTestConfiguration= ruleTestConfiguration EOF )
            // InternalEduTest.g:866:2: iv_ruleTestConfiguration= ruleTestConfiguration EOF
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
    // InternalEduTest.g:872:1: ruleTestConfiguration returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) ;
    public final EObject ruleTestConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;


        	enterRule();

        try {
            // InternalEduTest.g:878:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) )
            // InternalEduTest.g:879:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            {
            // InternalEduTest.g:879:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            // InternalEduTest.g:880:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            {
            // InternalEduTest.g:880:3: ()
            // InternalEduTest.g:881:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getTestConfigurationAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:895:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:896:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:896:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:897:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:897:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23) ) {
                alt22=1;
            }
            else if ( (LA22_0==24) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalEduTest.g:898:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:909:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,24,FOLLOW_2); 

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
    // InternalEduTest.g:926:1: entryRuleMultiChoiceEmConfig returns [EObject current=null] : iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF ;
    public final EObject entryRuleMultiChoiceEmConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmConfig = null;


        try {
            // InternalEduTest.g:926:60: (iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:927:2: iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF
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
    // InternalEduTest.g:933:1: ruleMultiChoiceEmConfig returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) ;
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
            // InternalEduTest.g:939:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) )
            // InternalEduTest.g:940:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            {
            // InternalEduTest.g:940:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            // InternalEduTest.g:941:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) )
            {
            // InternalEduTest.g:941:3: ()
            // InternalEduTest.g:942:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:956:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:957:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:957:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:958:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:958:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            else if ( (LA23_0==24) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalEduTest.g:959:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,23,FOLLOW_13); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:970:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,24,FOLLOW_13); 

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
            		
            otherlv_5=(Token)match(input,25,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5());
            		
            otherlv_6=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6());
            		
            // InternalEduTest.g:995:3: ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) )
            // InternalEduTest.g:996:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            {
            // InternalEduTest.g:996:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            // InternalEduTest.g:997:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            {
            // InternalEduTest.g:997:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==23) ) {
                alt24=1;
            }
            else if ( (LA24_0==24) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalEduTest.g:998:6: lv_weighted_7_1= 'yes'
                    {
                    lv_weighted_7_1=(Token)match(input,23,FOLLOW_13); 

                    						newLeafNode(lv_weighted_7_1, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "weighted", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1009:6: lv_weighted_7_2= 'no'
                    {
                    lv_weighted_7_2=(Token)match(input,24,FOLLOW_13); 

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
            		
            otherlv_9=(Token)match(input,26,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9());
            		
            otherlv_10=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_10, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10());
            		
            // InternalEduTest.g:1034:3: ( (lv_penalty_11_0= ruleEDouble ) )
            // InternalEduTest.g:1035:4: (lv_penalty_11_0= ruleEDouble )
            {
            // InternalEduTest.g:1035:4: (lv_penalty_11_0= ruleEDouble )
            // InternalEduTest.g:1036:5: lv_penalty_11_0= ruleEDouble
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
            		
            otherlv_13=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_13, grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13());
            		
            otherlv_14=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_14, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14());
            		
            // InternalEduTest.g:1065:3: ( (lv_order_15_0= ruleOrder ) )
            // InternalEduTest.g:1066:4: (lv_order_15_0= ruleOrder )
            {
            // InternalEduTest.g:1066:4: (lv_order_15_0= ruleOrder )
            // InternalEduTest.g:1067:5: lv_order_15_0= ruleOrder
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
            		
            otherlv_17=(Token)match(input,28,FOLLOW_10); 

            			newLeafNode(otherlv_17, grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17());
            		
            otherlv_18=(Token)match(input,21,FOLLOW_20); 

            			newLeafNode(otherlv_18, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18());
            		
            // InternalEduTest.g:1096:3: ( (lv_mode_19_0= ruleMode ) )
            // InternalEduTest.g:1097:4: (lv_mode_19_0= ruleMode )
            {
            // InternalEduTest.g:1097:4: (lv_mode_19_0= ruleMode )
            // InternalEduTest.g:1098:5: lv_mode_19_0= ruleMode
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


    // $ANTLR start "entryRuleMultiChoiceTextConfig"
    // InternalEduTest.g:1119:1: entryRuleMultiChoiceTextConfig returns [EObject current=null] : iv_ruleMultiChoiceTextConfig= ruleMultiChoiceTextConfig EOF ;
    public final EObject entryRuleMultiChoiceTextConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceTextConfig = null;


        try {
            // InternalEduTest.g:1119:62: (iv_ruleMultiChoiceTextConfig= ruleMultiChoiceTextConfig EOF )
            // InternalEduTest.g:1120:2: iv_ruleMultiChoiceTextConfig= ruleMultiChoiceTextConfig EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceTextConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiChoiceTextConfig=ruleMultiChoiceTextConfig();

            state._fsp--;

             current =iv_ruleMultiChoiceTextConfig; 
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
    // $ANTLR end "entryRuleMultiChoiceTextConfig"


    // $ANTLR start "ruleMultiChoiceTextConfig"
    // InternalEduTest.g:1126:1: ruleMultiChoiceTextConfig returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'text' otherlv_6= '=' ( (lv_identifier_7_0= ruleEString ) ) ) ;
    public final EObject ruleMultiChoiceTextConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_identifier_7_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1132:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'text' otherlv_6= '=' ( (lv_identifier_7_0= ruleEString ) ) ) )
            // InternalEduTest.g:1133:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'text' otherlv_6= '=' ( (lv_identifier_7_0= ruleEString ) ) )
            {
            // InternalEduTest.g:1133:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'text' otherlv_6= '=' ( (lv_identifier_7_0= ruleEString ) ) )
            // InternalEduTest.g:1134:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'text' otherlv_6= '=' ( (lv_identifier_7_0= ruleEString ) )
            {
            // InternalEduTest.g:1134:3: ()
            // InternalEduTest.g:1135:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMultiChoiceTextConfigAccess().getMultiChoiceTextConfigAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getMultiChoiceTextConfigAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getMultiChoiceTextConfigAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:1149:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:1150:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:1150:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:1151:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:1151:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23) ) {
                alt25=1;
            }
            else if ( (LA25_0==24) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalEduTest.g:1152:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,23,FOLLOW_13); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getMultiChoiceTextConfigAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceTextConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1163:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,24,FOLLOW_13); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getMultiChoiceTextConfigAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceTextConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", true, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceTextConfigAccess().getCommaKeyword_4());
            		
            otherlv_5=(Token)match(input,29,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getMultiChoiceTextConfigAccess().getTextKeyword_5());
            		
            otherlv_6=(Token)match(input,21,FOLLOW_22); 

            			newLeafNode(otherlv_6, grammarAccess.getMultiChoiceTextConfigAccess().getEqualsSignKeyword_6());
            		
            // InternalEduTest.g:1188:3: ( (lv_identifier_7_0= ruleEString ) )
            // InternalEduTest.g:1189:4: (lv_identifier_7_0= ruleEString )
            {
            // InternalEduTest.g:1189:4: (lv_identifier_7_0= ruleEString )
            // InternalEduTest.g:1190:5: lv_identifier_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMultiChoiceTextConfigAccess().getIdentifierEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_identifier_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceTextConfigRule());
            					}
            					set(
            						current,
            						"identifier",
            						lv_identifier_7_0,
            						"wodeledu.dsls.EduTest.EString");
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
    // $ANTLR end "ruleMultiChoiceTextConfig"


    // $ANTLR start "entryRuleTest"
    // InternalEduTest.g:1211:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalEduTest.g:1211:45: (iv_ruleTest= ruleTest EOF )
            // InternalEduTest.g:1212:2: iv_ruleTest= ruleTest EOF
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
    // InternalEduTest.g:1218:1: ruleTest returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) ;
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
            // InternalEduTest.g:1224:2: ( (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) )
            // InternalEduTest.g:1225:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            {
            // InternalEduTest.g:1225:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            // InternalEduTest.g:1226:3: otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTestAccess().getDescriptionKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getTestAccess().getForKeyword_1());
            		
            // InternalEduTest.g:1234:3: ( (lv_source_2_0= ruleEString ) )
            // InternalEduTest.g:1235:4: (lv_source_2_0= ruleEString )
            {
            // InternalEduTest.g:1235:4: (lv_source_2_0= ruleEString )
            // InternalEduTest.g:1236:5: lv_source_2_0= ruleEString
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

            otherlv_3=(Token)match(input,21,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3());
            		
            // InternalEduTest.g:1257:3: ( (lv_question_4_0= ruleEString ) )
            // InternalEduTest.g:1258:4: (lv_question_4_0= ruleEString )
            {
            // InternalEduTest.g:1258:4: (lv_question_4_0= ruleEString )
            // InternalEduTest.g:1259:5: lv_question_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_24);
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

            // InternalEduTest.g:1276:3: ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalEduTest.g:1277:4: ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    {
                    // InternalEduTest.g:1277:4: ( (lv_expression_5_0= '%text' ) )
                    // InternalEduTest.g:1278:5: (lv_expression_5_0= '%text' )
                    {
                    // InternalEduTest.g:1278:5: (lv_expression_5_0= '%text' )
                    // InternalEduTest.g:1279:6: lv_expression_5_0= '%text'
                    {
                    lv_expression_5_0=(Token)match(input,32,FOLLOW_25); 

                    						newLeafNode(lv_expression_5_0, grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestRule());
                    						}
                    						setWithLastConsumed(current, "expression", true, "%text");
                    					

                    }


                    }

                    // InternalEduTest.g:1291:4: (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==33) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalEduTest.g:1292:5: otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')'
                            {
                            otherlv_6=(Token)match(input,33,FOLLOW_22); 

                            					newLeafNode(otherlv_6, grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0());
                            				
                            // InternalEduTest.g:1296:5: ( (lv_identifier_7_0= ruleEString ) )
                            // InternalEduTest.g:1297:6: (lv_identifier_7_0= ruleEString )
                            {
                            // InternalEduTest.g:1297:6: (lv_identifier_7_0= ruleEString )
                            // InternalEduTest.g:1298:7: lv_identifier_7_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getTestAccess().getIdentifierEStringParserRuleCall_5_1_1_0());
                            						
                            pushFollow(FOLLOW_26);
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

                            otherlv_8=(Token)match(input,34,FOLLOW_2); 

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
    // InternalEduTest.g:1325:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalEduTest.g:1325:47: (iv_ruleEString= ruleEString EOF )
            // InternalEduTest.g:1326:2: iv_ruleEString= ruleEString EOF
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
    // InternalEduTest.g:1332:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1338:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalEduTest.g:1339:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalEduTest.g:1339:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_STRING) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalEduTest.g:1340:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1348:3: this_ID_1= RULE_ID
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
    // InternalEduTest.g:1359:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalEduTest.g:1359:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalEduTest.g:1360:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalEduTest.g:1366:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalEduTest.g:1372:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalEduTest.g:1373:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalEduTest.g:1373:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalEduTest.g:1374:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalEduTest.g:1374:3: (kw= '-' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==35) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalEduTest.g:1375:4: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_27); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalEduTest.g:1381:3: (this_INT_1= RULE_INT )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalEduTest.g:1382:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_28); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,36,FOLLOW_29); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_30); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalEduTest.g:1402:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=37 && LA33_0<=38)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalEduTest.g:1403:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalEduTest.g:1403:4: (kw= 'E' | kw= 'e' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==37) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==38) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalEduTest.g:1404:5: kw= 'E'
                            {
                            kw=(Token)match(input,37,FOLLOW_31); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalEduTest.g:1410:5: kw= 'e'
                            {
                            kw=(Token)match(input,38,FOLLOW_31); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalEduTest.g:1416:4: (kw= '-' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==35) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalEduTest.g:1417:5: kw= '-'
                            {
                            kw=(Token)match(input,35,FOLLOW_29); 

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
    // InternalEduTest.g:1435:1: ruleOrder returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) ;
    public final Enumerator ruleOrder() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalEduTest.g:1441:2: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) )
            // InternalEduTest.g:1442:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            {
            // InternalEduTest.g:1442:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt34=1;
                }
                break;
            case 40:
                {
                alt34=2;
                }
                break;
            case 41:
                {
                alt34=3;
                }
                break;
            case 42:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalEduTest.g:1443:3: (enumLiteral_0= 'fixed' )
                    {
                    // InternalEduTest.g:1443:3: (enumLiteral_0= 'fixed' )
                    // InternalEduTest.g:1444:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1451:3: (enumLiteral_1= 'random' )
                    {
                    // InternalEduTest.g:1451:3: (enumLiteral_1= 'random' )
                    // InternalEduTest.g:1452:4: enumLiteral_1= 'random'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:1459:3: (enumLiteral_2= 'options-ascending' )
                    {
                    // InternalEduTest.g:1459:3: (enumLiteral_2= 'options-ascending' )
                    // InternalEduTest.g:1460:4: enumLiteral_2= 'options-ascending'
                    {
                    enumLiteral_2=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:1467:3: (enumLiteral_3= 'options-descending' )
                    {
                    // InternalEduTest.g:1467:3: (enumLiteral_3= 'options-descending' )
                    // InternalEduTest.g:1468:4: enumLiteral_3= 'options-descending'
                    {
                    enumLiteral_3=(Token)match(input,42,FOLLOW_2); 

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
    // InternalEduTest.g:1478:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1484:2: ( ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) )
            // InternalEduTest.g:1485:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            {
            // InternalEduTest.g:1485:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==43) ) {
                alt35=1;
            }
            else if ( (LA35_0==44) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalEduTest.g:1486:3: (enumLiteral_0= 'radiobutton' )
                    {
                    // InternalEduTest.g:1486:3: (enumLiteral_0= 'radiobutton' )
                    // InternalEduTest.g:1487:4: enumLiteral_0= 'radiobutton'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1494:3: (enumLiteral_1= 'checkbox' )
                    {
                    // InternalEduTest.g:1494:3: (enumLiteral_1= 'checkbox' )
                    // InternalEduTest.g:1495:4: enumLiteral_1= 'checkbox'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); 

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
    // InternalEduTest.g:1505:1: ruleNavigation returns [Enumerator current=null] : ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) ;
    public final Enumerator ruleNavigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1511:2: ( ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) )
            // InternalEduTest.g:1512:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            {
            // InternalEduTest.g:1512:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            else if ( (LA36_0==46) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalEduTest.g:1513:3: (enumLiteral_0= 'free' )
                    {
                    // InternalEduTest.g:1513:3: (enumLiteral_0= 'free' )
                    // InternalEduTest.g:1514:4: enumLiteral_0= 'free'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1521:3: (enumLiteral_1= 'locked' )
                    {
                    // InternalEduTest.g:1521:3: (enumLiteral_1= 'locked' )
                    // InternalEduTest.g:1522:4: enumLiteral_1= 'locked'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000F8800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000F8802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000001800000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000078000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000040L});

}