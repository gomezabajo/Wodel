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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'='", "'solution'", "'AlternativeResponse'", "','", "'{'", "'}'", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'MultiChoiceText'", "'AlternativeTextResponse'", "'DragAndDropText'", "'navigation'", "'retry'", "'yes'", "'no'", "'mode'", "'statement'", "'answers'", "'weighted'", "'penalty'", "'order'", "'text'", "'description'", "'for'", "'%text'", "'('", "')'", "'-'", "'.'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'"
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
    // InternalEduTest.g:72:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_config_3_0= ruleProgramConfiguration ) )? ( (lv_exercises_4_0= ruleMutatorTests ) )+ ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_config_3_0 = null;

        EObject lv_exercises_4_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:78:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_config_3_0= ruleProgramConfiguration ) )? ( (lv_exercises_4_0= ruleMutatorTests ) )+ ) )
            // InternalEduTest.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_config_3_0= ruleProgramConfiguration ) )? ( (lv_exercises_4_0= ruleMutatorTests ) )+ )
            {
            // InternalEduTest.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_config_3_0= ruleProgramConfiguration ) )? ( (lv_exercises_4_0= ruleMutatorTests ) )+ )
            // InternalEduTest.g:80:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_config_3_0= ruleProgramConfiguration ) )? ( (lv_exercises_4_0= ruleMutatorTests ) )+
            {
            // InternalEduTest.g:80:3: ()
            // InternalEduTest.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProgramAccess().getProgramAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getMetamodelKeyword_1());
            		
            // InternalEduTest.g:91:3: ( (lv_metamodel_2_0= ruleEString ) )
            // InternalEduTest.g:92:4: (lv_metamodel_2_0= ruleEString )
            {
            // InternalEduTest.g:92:4: (lv_metamodel_2_0= ruleEString )
            // InternalEduTest.g:93:5: lv_metamodel_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_2_0,
            						"wodeledu.dsls.EduTest.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:110:3: ( (lv_config_3_0= ruleProgramConfiguration ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==25) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalEduTest.g:111:4: (lv_config_3_0= ruleProgramConfiguration )
                    {
                    // InternalEduTest.g:111:4: (lv_config_3_0= ruleProgramConfiguration )
                    // InternalEduTest.g:112:5: lv_config_3_0= ruleProgramConfiguration
                    {

                    					newCompositeNode(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_config_3_0=ruleProgramConfiguration();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getProgramRule());
                    					}
                    					set(
                    						current,
                    						"config",
                    						lv_config_3_0,
                    						"wodeledu.dsls.EduTest.ProgramConfiguration");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalEduTest.g:129:3: ( (lv_exercises_4_0= ruleMutatorTests ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14||(LA2_0>=18 && LA2_0<=24)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalEduTest.g:130:4: (lv_exercises_4_0= ruleMutatorTests )
            	    {
            	    // InternalEduTest.g:130:4: (lv_exercises_4_0= ruleMutatorTests )
            	    // InternalEduTest.g:131:5: lv_exercises_4_0= ruleMutatorTests
            	    {

            	    					newCompositeNode(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_exercises_4_0=ruleMutatorTests();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProgramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"exercises",
            	    						lv_exercises_4_0,
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
    // InternalEduTest.g:152:1: entryRuleMutatorTests returns [EObject current=null] : iv_ruleMutatorTests= ruleMutatorTests EOF ;
    public final EObject entryRuleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorTests = null;


        try {
            // InternalEduTest.g:152:53: (iv_ruleMutatorTests= ruleMutatorTests EOF )
            // InternalEduTest.g:153:2: iv_ruleMutatorTests= ruleMutatorTests EOF
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
    // InternalEduTest.g:159:1: ruleMutatorTests returns [EObject current=null] : (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText | this_AlternativeText_6= ruleAlternativeText | this_DragAndDropText_7= ruleDragAndDropText ) ;
    public final EObject ruleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject this_AlternativeResponse_0 = null;

        EObject this_MultiChoiceDiagram_1 = null;

        EObject this_MultiChoiceEmendation_2 = null;

        EObject this_MatchPairs_3 = null;

        EObject this_MissingWords_4 = null;

        EObject this_MultiChoiceText_5 = null;

        EObject this_AlternativeText_6 = null;

        EObject this_DragAndDropText_7 = null;



        	enterRule();

        try {
            // InternalEduTest.g:165:2: ( (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText | this_AlternativeText_6= ruleAlternativeText | this_DragAndDropText_7= ruleDragAndDropText ) )
            // InternalEduTest.g:166:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText | this_AlternativeText_6= ruleAlternativeText | this_DragAndDropText_7= ruleDragAndDropText )
            {
            // InternalEduTest.g:166:2: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation | this_MatchPairs_3= ruleMatchPairs | this_MissingWords_4= ruleMissingWords | this_MultiChoiceText_5= ruleMultiChoiceText | this_AlternativeText_6= ruleAlternativeText | this_DragAndDropText_7= ruleDragAndDropText )
            int alt3=8;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            case 21:
                {
                alt3=5;
                }
                break;
            case 22:
                {
                alt3=6;
                }
                break;
            case 23:
                {
                alt3=7;
                }
                break;
            case 24:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalEduTest.g:167:3: this_AlternativeResponse_0= ruleAlternativeResponse
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
                    // InternalEduTest.g:176:3: this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram
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
                    // InternalEduTest.g:185:3: this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation
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
                    // InternalEduTest.g:194:3: this_MatchPairs_3= ruleMatchPairs
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
                    // InternalEduTest.g:203:3: this_MissingWords_4= ruleMissingWords
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
                    // InternalEduTest.g:212:3: this_MultiChoiceText_5= ruleMultiChoiceText
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceTextParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_MultiChoiceText_5=ruleMultiChoiceText();

                    state._fsp--;


                    			current = this_MultiChoiceText_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalEduTest.g:221:3: this_AlternativeText_6= ruleAlternativeText
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getAlternativeTextParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlternativeText_6=ruleAlternativeText();

                    state._fsp--;


                    			current = this_AlternativeText_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalEduTest.g:230:3: this_DragAndDropText_7= ruleDragAndDropText
                    {

                    			newCompositeNode(grammarAccess.getMutatorTestsAccess().getDragAndDropTextParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_DragAndDropText_7=ruleDragAndDropText();

                    state._fsp--;


                    			current = this_DragAndDropText_7;
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


    // $ANTLR start "entryRuleMarkedBlock"
    // InternalEduTest.g:242:1: entryRuleMarkedBlock returns [EObject current=null] : iv_ruleMarkedBlock= ruleMarkedBlock EOF ;
    public final EObject entryRuleMarkedBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMarkedBlock = null;


        try {
            // InternalEduTest.g:242:52: (iv_ruleMarkedBlock= ruleMarkedBlock EOF )
            // InternalEduTest.g:243:2: iv_ruleMarkedBlock= ruleMarkedBlock EOF
            {
             newCompositeNode(grammarAccess.getMarkedBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMarkedBlock=ruleMarkedBlock();

            state._fsp--;

             current =iv_ruleMarkedBlock; 
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
    // $ANTLR end "entryRuleMarkedBlock"


    // $ANTLR start "ruleMarkedBlock"
    // InternalEduTest.g:249:1: ruleMarkedBlock returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )? ) ;
    public final EObject ruleMarkedBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_solution_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalEduTest.g:255:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )? ) )
            // InternalEduTest.g:256:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )? )
            {
            // InternalEduTest.g:256:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )? )
            // InternalEduTest.g:257:3: () ( (otherlv_1= RULE_ID ) ) ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )?
            {
            // InternalEduTest.g:257:3: ()
            // InternalEduTest.g:258:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMarkedBlockAccess().getMarkedBlockAction_0(),
            					current);
            			

            }

            // InternalEduTest.g:264:3: ( (otherlv_1= RULE_ID ) )
            // InternalEduTest.g:265:4: (otherlv_1= RULE_ID )
            {
            // InternalEduTest.g:265:4: (otherlv_1= RULE_ID )
            // InternalEduTest.g:266:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMarkedBlockRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_1, grammarAccess.getMarkedBlockAccess().getBlockBlockCrossReference_1_0());
            				

            }


            }

            // InternalEduTest.g:277:3: ( ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEduTest.g:278:4: ( (lv_solution_2_0= '=' ) ) otherlv_3= 'solution'
                    {
                    // InternalEduTest.g:278:4: ( (lv_solution_2_0= '=' ) )
                    // InternalEduTest.g:279:5: (lv_solution_2_0= '=' )
                    {
                    // InternalEduTest.g:279:5: (lv_solution_2_0= '=' )
                    // InternalEduTest.g:280:6: lv_solution_2_0= '='
                    {
                    lv_solution_2_0=(Token)match(input,12,FOLLOW_7); 

                    						newLeafNode(lv_solution_2_0, grammarAccess.getMarkedBlockAccess().getSolutionEqualsSignKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMarkedBlockRule());
                    						}
                    						setWithLastConsumed(current, "solution", lv_solution_2_0 != null, "=");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getMarkedBlockAccess().getSolutionKeyword_2_1());
                    			

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
    // $ANTLR end "ruleMarkedBlock"


    // $ANTLR start "entryRuleAlternativeResponse"
    // InternalEduTest.g:301:1: entryRuleAlternativeResponse returns [EObject current=null] : iv_ruleAlternativeResponse= ruleAlternativeResponse EOF ;
    public final EObject entryRuleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeResponse = null;


        try {
            // InternalEduTest.g:301:60: (iv_ruleAlternativeResponse= ruleAlternativeResponse EOF )
            // InternalEduTest.g:302:2: iv_ruleAlternativeResponse= ruleAlternativeResponse EOF
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
    // InternalEduTest.g:308:1: ruleAlternativeResponse returns [EObject current=null] : (otherlv_0= 'AlternativeResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:314:2: ( (otherlv_0= 'AlternativeResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:315:2: (otherlv_0= 'AlternativeResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:315:2: (otherlv_0= 'AlternativeResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:316:3: otherlv_0= 'AlternativeResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0());
            		
            // InternalEduTest.g:320:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalEduTest.g:321:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:321:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:322:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:322:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:323:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:340:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalEduTest.g:341:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:345:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:346:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:346:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:347:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:370:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:371:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:371:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:372:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalEduTest.g:389:3: ( (lv_tests_6_0= ruleTest ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==36) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalEduTest.g:390:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:390:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:391:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop7;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalEduTest.g:416:1: entryRuleMultiChoiceDiagram returns [EObject current=null] : iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF ;
    public final EObject entryRuleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceDiagram = null;


        try {
            // InternalEduTest.g:416:59: (iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF )
            // InternalEduTest.g:417:2: iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF
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
    // InternalEduTest.g:423:1: ruleMultiChoiceDiagram returns [EObject current=null] : (otherlv_0= 'MultiChoiceDiagram' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:429:2: ( (otherlv_0= 'MultiChoiceDiagram' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:430:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:430:2: (otherlv_0= 'MultiChoiceDiagram' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:431:3: otherlv_0= 'MultiChoiceDiagram' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0());
            		
            // InternalEduTest.g:435:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalEduTest.g:436:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:436:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:437:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:437:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:438:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:455:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==15) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalEduTest.g:456:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:460:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:461:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:461:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:462:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:485:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:486:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:486:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:487:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalEduTest.g:504:3: ( (lv_tests_6_0= ruleTest ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==36) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalEduTest.g:505:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:505:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:506:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop10;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalEduTest.g:531:1: entryRuleMultiChoiceEmendation returns [EObject current=null] : iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF ;
    public final EObject entryRuleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmendation = null;


        try {
            // InternalEduTest.g:531:62: (iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF )
            // InternalEduTest.g:532:2: iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF
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
    // InternalEduTest.g:538:1: ruleMultiChoiceEmendation returns [EObject current=null] : (otherlv_0= 'MultiChoiceEmendation' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:544:2: ( (otherlv_0= 'MultiChoiceEmendation' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:545:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:545:2: (otherlv_0= 'MultiChoiceEmendation' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:546:3: otherlv_0= 'MultiChoiceEmendation' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0());
            		
            // InternalEduTest.g:550:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalEduTest.g:551:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:551:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:552:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:552:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:553:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:570:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalEduTest.g:571:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:575:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:576:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:576:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:577:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:600:3: ( (lv_config_5_0= ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:601:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:601:4: (lv_config_5_0= ruleMultiChoiceEmConfig )
            // InternalEduTest.g:602:5: lv_config_5_0= ruleMultiChoiceEmConfig
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalEduTest.g:619:3: ( (lv_tests_6_0= ruleTest ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalEduTest.g:620:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:620:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:621:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop13;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalEduTest.g:646:1: entryRuleMatchPairs returns [EObject current=null] : iv_ruleMatchPairs= ruleMatchPairs EOF ;
    public final EObject entryRuleMatchPairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchPairs = null;


        try {
            // InternalEduTest.g:646:51: (iv_ruleMatchPairs= ruleMatchPairs EOF )
            // InternalEduTest.g:647:2: iv_ruleMatchPairs= ruleMatchPairs EOF
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
    // InternalEduTest.g:653:1: ruleMatchPairs returns [EObject current=null] : (otherlv_0= 'MatchPairs' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMatchPairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:659:2: ( (otherlv_0= 'MatchPairs' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:660:2: (otherlv_0= 'MatchPairs' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:660:2: (otherlv_0= 'MatchPairs' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:661:3: otherlv_0= 'MatchPairs' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0());
            		
            // InternalEduTest.g:665:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalEduTest.g:666:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:666:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:667:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:667:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:668:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMatchPairsRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:685:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==15) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalEduTest.g:686:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:690:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:691:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:691:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:692:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMatchPairsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getMatchPairsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:715:3: ( (lv_config_5_0= ruleTextConfiguration ) )
            // InternalEduTest.g:716:4: (lv_config_5_0= ruleTextConfiguration )
            {
            // InternalEduTest.g:716:4: (lv_config_5_0= ruleTextConfiguration )
            // InternalEduTest.g:717:5: lv_config_5_0= ruleTextConfiguration
            {

            					newCompositeNode(grammarAccess.getMatchPairsAccess().getConfigTextConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_config_5_0=ruleTextConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMatchPairsRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TextConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:734:3: ( (lv_tests_6_0= ruleTest ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalEduTest.g:735:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:735:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:736:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMatchPairsAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalEduTest.g:761:1: entryRuleMissingWords returns [EObject current=null] : iv_ruleMissingWords= ruleMissingWords EOF ;
    public final EObject entryRuleMissingWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissingWords = null;


        try {
            // InternalEduTest.g:761:53: (iv_ruleMissingWords= ruleMissingWords EOF )
            // InternalEduTest.g:762:2: iv_ruleMissingWords= ruleMissingWords EOF
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
    // InternalEduTest.g:768:1: ruleMissingWords returns [EObject current=null] : (otherlv_0= 'MissingWords' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMissingWords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:774:2: ( (otherlv_0= 'MissingWords' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:775:2: (otherlv_0= 'MissingWords' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:775:2: (otherlv_0= 'MissingWords' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:776:3: otherlv_0= 'MissingWords' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0());
            		
            // InternalEduTest.g:780:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalEduTest.g:781:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:781:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:782:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:782:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:783:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMissingWordsRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:800:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==15) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalEduTest.g:801:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:805:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:806:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:806:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:807:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMissingWordsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getMissingWordsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:830:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:831:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:831:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:832:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getMissingWordsAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalEduTest.g:849:3: ( (lv_tests_6_0= ruleTest ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==36) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalEduTest.g:850:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:850:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:851:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMissingWordsAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop19;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalEduTest.g:876:1: entryRuleMultiChoiceText returns [EObject current=null] : iv_ruleMultiChoiceText= ruleMultiChoiceText EOF ;
    public final EObject entryRuleMultiChoiceText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceText = null;


        try {
            // InternalEduTest.g:876:56: (iv_ruleMultiChoiceText= ruleMultiChoiceText EOF )
            // InternalEduTest.g:877:2: iv_ruleMultiChoiceText= ruleMultiChoiceText EOF
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
    // InternalEduTest.g:883:1: ruleMultiChoiceText returns [EObject current=null] : (otherlv_0= 'MultiChoiceText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleMultiChoiceText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:889:2: ( (otherlv_0= 'MultiChoiceText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:890:2: (otherlv_0= 'MultiChoiceText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:890:2: (otherlv_0= 'MultiChoiceText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:891:3: otherlv_0= 'MultiChoiceText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiChoiceTextAccess().getMultiChoiceTextKeyword_0());
            		
            // InternalEduTest.g:895:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalEduTest.g:896:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:896:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:897:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:897:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:898:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMultiChoiceTextRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:915:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==15) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalEduTest.g:916:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getMultiChoiceTextAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:920:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:921:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:921:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:922:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMultiChoiceTextRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceTextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:945:3: ( (lv_config_5_0= ruleTextConfiguration ) )
            // InternalEduTest.g:946:4: (lv_config_5_0= ruleTextConfiguration )
            {
            // InternalEduTest.g:946:4: (lv_config_5_0= ruleTextConfiguration )
            // InternalEduTest.g:947:5: lv_config_5_0= ruleTextConfiguration
            {

            					newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getConfigTextConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_config_5_0=ruleTextConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiChoiceTextRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TextConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:964:3: ( (lv_tests_6_0= ruleTest ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==36) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalEduTest.g:965:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:965:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:966:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getMultiChoiceTextAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAlternativeText"
    // InternalEduTest.g:991:1: entryRuleAlternativeText returns [EObject current=null] : iv_ruleAlternativeText= ruleAlternativeText EOF ;
    public final EObject entryRuleAlternativeText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeText = null;


        try {
            // InternalEduTest.g:991:56: (iv_ruleAlternativeText= ruleAlternativeText EOF )
            // InternalEduTest.g:992:2: iv_ruleAlternativeText= ruleAlternativeText EOF
            {
             newCompositeNode(grammarAccess.getAlternativeTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlternativeText=ruleAlternativeText();

            state._fsp--;

             current =iv_ruleAlternativeText; 
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
    // $ANTLR end "entryRuleAlternativeText"


    // $ANTLR start "ruleAlternativeText"
    // InternalEduTest.g:998:1: ruleAlternativeText returns [EObject current=null] : (otherlv_0= 'AlternativeTextResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleAlternativeText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1004:2: ( (otherlv_0= 'AlternativeTextResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:1005:2: (otherlv_0= 'AlternativeTextResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:1005:2: (otherlv_0= 'AlternativeTextResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:1006:3: otherlv_0= 'AlternativeTextResponse' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTextConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeTextAccess().getAlternativeTextResponseKeyword_0());
            		
            // InternalEduTest.g:1010:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalEduTest.g:1011:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:1011:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:1012:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:1012:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:1013:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAlternativeTextRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:1030:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==15) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalEduTest.g:1031:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativeTextAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:1035:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:1036:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:1036:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:1037:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlternativeTextRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
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
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getAlternativeTextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:1060:3: ( (lv_config_5_0= ruleTextConfiguration ) )
            // InternalEduTest.g:1061:4: (lv_config_5_0= ruleTextConfiguration )
            {
            // InternalEduTest.g:1061:4: (lv_config_5_0= ruleTextConfiguration )
            // InternalEduTest.g:1062:5: lv_config_5_0= ruleTextConfiguration
            {

            					newCompositeNode(grammarAccess.getAlternativeTextAccess().getConfigTextConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_config_5_0=ruleTextConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAlternativeTextRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TextConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:1079:3: ( (lv_tests_6_0= ruleTest ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==36) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalEduTest.g:1080:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:1080:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:1081:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getAlternativeTextAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlternativeTextRule());
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
            	    break loop25;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAlternativeTextAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeText"


    // $ANTLR start "entryRuleDragAndDropText"
    // InternalEduTest.g:1106:1: entryRuleDragAndDropText returns [EObject current=null] : iv_ruleDragAndDropText= ruleDragAndDropText EOF ;
    public final EObject entryRuleDragAndDropText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDragAndDropText = null;


        try {
            // InternalEduTest.g:1106:56: (iv_ruleDragAndDropText= ruleDragAndDropText EOF )
            // InternalEduTest.g:1107:2: iv_ruleDragAndDropText= ruleDragAndDropText EOF
            {
             newCompositeNode(grammarAccess.getDragAndDropTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDragAndDropText=ruleDragAndDropText();

            state._fsp--;

             current =iv_ruleDragAndDropText; 
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
    // $ANTLR end "entryRuleDragAndDropText"


    // $ANTLR start "ruleDragAndDropText"
    // InternalEduTest.g:1113:1: ruleDragAndDropText returns [EObject current=null] : (otherlv_0= 'DragAndDropText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) ;
    public final EObject ruleDragAndDropText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_markedBlocks_1_0 = null;

        EObject lv_markedBlocks_3_0 = null;

        EObject lv_config_5_0 = null;

        EObject lv_tests_6_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1119:2: ( (otherlv_0= 'DragAndDropText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' ) )
            // InternalEduTest.g:1120:2: (otherlv_0= 'DragAndDropText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            {
            // InternalEduTest.g:1120:2: (otherlv_0= 'DragAndDropText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}' )
            // InternalEduTest.g:1121:3: otherlv_0= 'DragAndDropText' ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )? otherlv_4= '{' ( (lv_config_5_0= ruleTestConfiguration ) ) ( (lv_tests_6_0= ruleTest ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDragAndDropTextAccess().getDragAndDropTextKeyword_0());
            		
            // InternalEduTest.g:1125:3: ( ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalEduTest.g:1126:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) ) (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    {
                    // InternalEduTest.g:1126:4: ( (lv_markedBlocks_1_0= ruleMarkedBlock ) )
                    // InternalEduTest.g:1127:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    {
                    // InternalEduTest.g:1127:5: (lv_markedBlocks_1_0= ruleMarkedBlock )
                    // InternalEduTest.g:1128:6: lv_markedBlocks_1_0= ruleMarkedBlock
                    {

                    						newCompositeNode(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_markedBlocks_1_0=ruleMarkedBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDragAndDropTextRule());
                    						}
                    						add(
                    							current,
                    							"markedBlocks",
                    							lv_markedBlocks_1_0,
                    							"wodeledu.dsls.EduTest.MarkedBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEduTest.g:1145:4: (otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==15) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalEduTest.g:1146:5: otherlv_2= ',' ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    {
                    	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getDragAndDropTextAccess().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalEduTest.g:1150:5: ( (lv_markedBlocks_3_0= ruleMarkedBlock ) )
                    	    // InternalEduTest.g:1151:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    {
                    	    // InternalEduTest.g:1151:6: (lv_markedBlocks_3_0= ruleMarkedBlock )
                    	    // InternalEduTest.g:1152:7: lv_markedBlocks_3_0= ruleMarkedBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_markedBlocks_3_0=ruleMarkedBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDragAndDropTextRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"markedBlocks",
                    	    								lv_markedBlocks_3_0,
                    	    								"wodeledu.dsls.EduTest.MarkedBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getDragAndDropTextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalEduTest.g:1175:3: ( (lv_config_5_0= ruleTestConfiguration ) )
            // InternalEduTest.g:1176:4: (lv_config_5_0= ruleTestConfiguration )
            {
            // InternalEduTest.g:1176:4: (lv_config_5_0= ruleTestConfiguration )
            // InternalEduTest.g:1177:5: lv_config_5_0= ruleTestConfiguration
            {

            					newCompositeNode(grammarAccess.getDragAndDropTextAccess().getConfigTestConfigurationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_config_5_0=ruleTestConfiguration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDragAndDropTextRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_5_0,
            						"wodeledu.dsls.EduTest.TestConfiguration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEduTest.g:1194:3: ( (lv_tests_6_0= ruleTest ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==36) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalEduTest.g:1195:4: (lv_tests_6_0= ruleTest )
            	    {
            	    // InternalEduTest.g:1195:4: (lv_tests_6_0= ruleTest )
            	    // InternalEduTest.g:1196:5: lv_tests_6_0= ruleTest
            	    {

            	    					newCompositeNode(grammarAccess.getDragAndDropTextAccess().getTestsTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_tests_6_0=ruleTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDragAndDropTextRule());
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
            	    break loop28;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDragAndDropTextAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDragAndDropText"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalEduTest.g:1221:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalEduTest.g:1221:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalEduTest.g:1222:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
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
    // InternalEduTest.g:1228:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) ;
    public final EObject ruleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_navigation_2_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1234:2: ( (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) )
            // InternalEduTest.g:1235:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            {
            // InternalEduTest.g:1235:2: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            // InternalEduTest.g:1236:3: otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1());
            		
            // InternalEduTest.g:1244:3: ( (lv_navigation_2_0= ruleNavigation ) )
            // InternalEduTest.g:1245:4: (lv_navigation_2_0= ruleNavigation )
            {
            // InternalEduTest.g:1245:4: (lv_navigation_2_0= ruleNavigation )
            // InternalEduTest.g:1246:5: lv_navigation_2_0= ruleNavigation
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
    // InternalEduTest.g:1267:1: entryRuleTestConfiguration returns [EObject current=null] : iv_ruleTestConfiguration= ruleTestConfiguration EOF ;
    public final EObject entryRuleTestConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestConfiguration = null;


        try {
            // InternalEduTest.g:1267:58: (iv_ruleTestConfiguration= ruleTestConfiguration EOF )
            // InternalEduTest.g:1268:2: iv_ruleTestConfiguration= ruleTestConfiguration EOF
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
    // InternalEduTest.g:1274:1: ruleTestConfiguration returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ) ;
    public final EObject ruleTestConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Enumerator lv_mode_7_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1280:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ) )
            // InternalEduTest.g:1281:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? )
            {
            // InternalEduTest.g:1281:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? )
            // InternalEduTest.g:1282:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )?
            {
            // InternalEduTest.g:1282:3: ()
            // InternalEduTest.g:1283:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTestConfigurationAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:1297:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:1298:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:1298:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:1299:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:1299:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            else if ( (LA29_0==28) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalEduTest.g:1300:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,27,FOLLOW_16); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_1 != null, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1311:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,28,FOLLOW_16); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getTestConfigurationAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_2 != null, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalEduTest.g:1324:3: (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==15) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==29) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // InternalEduTest.g:1325:4: otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) )
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_17); 

                    				newLeafNode(otherlv_4, grammarAccess.getTestConfigurationAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,29,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getTestConfigurationAccess().getModeKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,12,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalEduTest.g:1337:4: ( (lv_mode_7_0= ruleMode ) )
                    // InternalEduTest.g:1338:5: (lv_mode_7_0= ruleMode )
                    {
                    // InternalEduTest.g:1338:5: (lv_mode_7_0= ruleMode )
                    // InternalEduTest.g:1339:6: lv_mode_7_0= ruleMode
                    {

                    						newCompositeNode(grammarAccess.getTestConfigurationAccess().getModeModeEnumRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_mode_7_0=ruleMode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTestConfigurationRule());
                    						}
                    						set(
                    							current,
                    							"mode",
                    							lv_mode_7_0,
                    							"wodeledu.dsls.EduTest.Mode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalEduTest.g:1357:3: (otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==15) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==30) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalEduTest.g:1358:4: otherlv_8= ',' otherlv_9= 'statement' otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_19); 

                    				newLeafNode(otherlv_8, grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,30,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getTestConfigurationAccess().getStatementKeyword_5_1());
                    			
                    otherlv_10=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_5_2());
                    			
                    // InternalEduTest.g:1370:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEduTest.g:1371:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEduTest.g:1371:5: (otherlv_11= RULE_ID )
                    // InternalEduTest.g:1372:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_11, grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_3_0());
                    					

                    }


                    }

                    // InternalEduTest.g:1383:4: (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==15) ) {
                            int LA31_1 = input.LA(2);

                            if ( (LA31_1==RULE_ID) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalEduTest.g:1384:5: otherlv_12= ',' ( (otherlv_13= RULE_ID ) )
                    	    {
                    	    otherlv_12=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_4_0());
                    	    				
                    	    // InternalEduTest.g:1388:5: ( (otherlv_13= RULE_ID ) )
                    	    // InternalEduTest.g:1389:6: (otherlv_13= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:1389:6: (otherlv_13= RULE_ID )
                    	    // InternalEduTest.g:1390:7: otherlv_13= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getTestConfigurationRule());
                    	    							}
                    	    						
                    	    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    							newLeafNode(otherlv_13, grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalEduTest.g:1403:3: (otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalEduTest.g:1404:4: otherlv_14= ',' otherlv_15= 'answers' otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )*
                    {
                    otherlv_14=(Token)match(input,15,FOLLOW_20); 

                    				newLeafNode(otherlv_14, grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_0());
                    			
                    otherlv_15=(Token)match(input,31,FOLLOW_13); 

                    				newLeafNode(otherlv_15, grammarAccess.getTestConfigurationAccess().getAnswersKeyword_6_1());
                    			
                    otherlv_16=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_16, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_6_2());
                    			
                    // InternalEduTest.g:1416:4: ( (otherlv_17= RULE_ID ) )
                    // InternalEduTest.g:1417:5: (otherlv_17= RULE_ID )
                    {
                    // InternalEduTest.g:1417:5: (otherlv_17= RULE_ID )
                    // InternalEduTest.g:1418:6: otherlv_17= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestConfigurationRule());
                    						}
                    					
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_17, grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_3_0());
                    					

                    }


                    }

                    // InternalEduTest.g:1429:4: (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==15) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalEduTest.g:1430:5: otherlv_18= ',' ( (otherlv_19= RULE_ID ) )
                    	    {
                    	    otherlv_18=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_4_0());
                    	    				
                    	    // InternalEduTest.g:1434:5: ( (otherlv_19= RULE_ID ) )
                    	    // InternalEduTest.g:1435:6: (otherlv_19= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:1435:6: (otherlv_19= RULE_ID )
                    	    // InternalEduTest.g:1436:7: otherlv_19= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getTestConfigurationRule());
                    	    							}
                    	    						
                    	    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    							newLeafNode(otherlv_19, grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


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
    // $ANTLR end "ruleTestConfiguration"


    // $ANTLR start "entryRuleMultiChoiceEmConfig"
    // InternalEduTest.g:1453:1: entryRuleMultiChoiceEmConfig returns [EObject current=null] : iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF ;
    public final EObject entryRuleMultiChoiceEmConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmConfig = null;


        try {
            // InternalEduTest.g:1453:60: (iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:1454:2: iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF
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
    // InternalEduTest.g:1460:1: ruleMultiChoiceEmConfig returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )? (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )? ) ;
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
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        AntlrDatatypeRuleToken lv_penalty_11_0 = null;

        Enumerator lv_order_15_0 = null;

        Enumerator lv_mode_19_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1466:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )? (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )? ) )
            // InternalEduTest.g:1467:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )? (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )? )
            {
            // InternalEduTest.g:1467:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )? (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )? )
            // InternalEduTest.g:1468:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )? (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )?
            {
            // InternalEduTest.g:1468:3: ()
            // InternalEduTest.g:1469:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:1483:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:1484:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:1484:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:1485:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:1485:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                alt35=1;
            }
            else if ( (LA35_0==28) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalEduTest.g:1486:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,27,FOLLOW_21); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_1 != null, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1497:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,28,FOLLOW_21); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getMultiChoiceEmConfigAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_2 != null, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_22); 

            			newLeafNode(otherlv_4, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4());
            		
            otherlv_5=(Token)match(input,32,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6());
            		
            // InternalEduTest.g:1522:3: ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) )
            // InternalEduTest.g:1523:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            {
            // InternalEduTest.g:1523:4: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            // InternalEduTest.g:1524:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            {
            // InternalEduTest.g:1524:5: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==27) ) {
                alt36=1;
            }
            else if ( (LA36_0==28) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalEduTest.g:1525:6: lv_weighted_7_1= 'yes'
                    {
                    lv_weighted_7_1=(Token)match(input,27,FOLLOW_21); 

                    						newLeafNode(lv_weighted_7_1, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "weighted", lv_weighted_7_1 != null, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1536:6: lv_weighted_7_2= 'no'
                    {
                    lv_weighted_7_2=(Token)match(input,28,FOLLOW_21); 

                    						newLeafNode(lv_weighted_7_2, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedNoKeyword_7_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    						setWithLastConsumed(current, "weighted", lv_weighted_7_2 != null, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_23); 

            			newLeafNode(otherlv_8, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8());
            		
            otherlv_9=(Token)match(input,33,FOLLOW_13); 

            			newLeafNode(otherlv_9, grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9());
            		
            otherlv_10=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_10, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10());
            		
            // InternalEduTest.g:1561:3: ( (lv_penalty_11_0= ruleEDouble ) )
            // InternalEduTest.g:1562:4: (lv_penalty_11_0= ruleEDouble )
            {
            // InternalEduTest.g:1562:4: (lv_penalty_11_0= ruleEDouble )
            // InternalEduTest.g:1563:5: lv_penalty_11_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_12=(Token)match(input,15,FOLLOW_25); 

            			newLeafNode(otherlv_12, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12());
            		
            otherlv_13=(Token)match(input,34,FOLLOW_13); 

            			newLeafNode(otherlv_13, grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13());
            		
            otherlv_14=(Token)match(input,12,FOLLOW_26); 

            			newLeafNode(otherlv_14, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14());
            		
            // InternalEduTest.g:1592:3: ( (lv_order_15_0= ruleOrder ) )
            // InternalEduTest.g:1593:4: (lv_order_15_0= ruleOrder )
            {
            // InternalEduTest.g:1593:4: (lv_order_15_0= ruleOrder )
            // InternalEduTest.g:1594:5: lv_order_15_0= ruleOrder
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_16=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_16, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16());
            		
            otherlv_17=(Token)match(input,29,FOLLOW_13); 

            			newLeafNode(otherlv_17, grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17());
            		
            otherlv_18=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_18, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18());
            		
            // InternalEduTest.g:1623:3: ( (lv_mode_19_0= ruleMode ) )
            // InternalEduTest.g:1624:4: (lv_mode_19_0= ruleMode )
            {
            // InternalEduTest.g:1624:4: (lv_mode_19_0= ruleMode )
            // InternalEduTest.g:1625:5: lv_mode_19_0= ruleMode
            {

            					newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0());
            				
            pushFollow(FOLLOW_16);
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

            // InternalEduTest.g:1642:3: (otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==15) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==30) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalEduTest.g:1643:4: otherlv_20= ',' otherlv_21= 'statement' otherlv_22= '=' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )*
                    {
                    otherlv_20=(Token)match(input,15,FOLLOW_19); 

                    				newLeafNode(otherlv_20, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_0());
                    			
                    otherlv_21=(Token)match(input,30,FOLLOW_13); 

                    				newLeafNode(otherlv_21, grammarAccess.getMultiChoiceEmConfigAccess().getStatementKeyword_20_1());
                    			
                    otherlv_22=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_22, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_20_2());
                    			
                    // InternalEduTest.g:1655:4: ( (otherlv_23= RULE_ID ) )
                    // InternalEduTest.g:1656:5: (otherlv_23= RULE_ID )
                    {
                    // InternalEduTest.g:1656:5: (otherlv_23= RULE_ID )
                    // InternalEduTest.g:1657:6: otherlv_23= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    					
                    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_23, grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_3_0());
                    					

                    }


                    }

                    // InternalEduTest.g:1668:4: (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==15) ) {
                            int LA37_1 = input.LA(2);

                            if ( (LA37_1==RULE_ID) ) {
                                alt37=1;
                            }


                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalEduTest.g:1669:5: otherlv_24= ',' ( (otherlv_25= RULE_ID ) )
                    	    {
                    	    otherlv_24=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_4_0());
                    	    				
                    	    // InternalEduTest.g:1673:5: ( (otherlv_25= RULE_ID ) )
                    	    // InternalEduTest.g:1674:6: (otherlv_25= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:1674:6: (otherlv_25= RULE_ID )
                    	    // InternalEduTest.g:1675:7: otherlv_25= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    	    							}
                    	    						
                    	    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    							newLeafNode(otherlv_25, grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalEduTest.g:1688:3: (otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==15) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalEduTest.g:1689:4: otherlv_26= ',' otherlv_27= 'answers' otherlv_28= '=' ( (otherlv_29= RULE_ID ) ) (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )*
                    {
                    otherlv_26=(Token)match(input,15,FOLLOW_20); 

                    				newLeafNode(otherlv_26, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_0());
                    			
                    otherlv_27=(Token)match(input,31,FOLLOW_13); 

                    				newLeafNode(otherlv_27, grammarAccess.getMultiChoiceEmConfigAccess().getAnswersKeyword_21_1());
                    			
                    otherlv_28=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_28, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_21_2());
                    			
                    // InternalEduTest.g:1701:4: ( (otherlv_29= RULE_ID ) )
                    // InternalEduTest.g:1702:5: (otherlv_29= RULE_ID )
                    {
                    // InternalEduTest.g:1702:5: (otherlv_29= RULE_ID )
                    // InternalEduTest.g:1703:6: otherlv_29= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    						}
                    					
                    otherlv_29=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_29, grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_3_0());
                    					

                    }


                    }

                    // InternalEduTest.g:1714:4: (otherlv_30= ',' ( (otherlv_31= RULE_ID ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==15) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalEduTest.g:1715:5: otherlv_30= ',' ( (otherlv_31= RULE_ID ) )
                    	    {
                    	    otherlv_30=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_30, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_4_0());
                    	    				
                    	    // InternalEduTest.g:1719:5: ( (otherlv_31= RULE_ID ) )
                    	    // InternalEduTest.g:1720:6: (otherlv_31= RULE_ID )
                    	    {
                    	    // InternalEduTest.g:1720:6: (otherlv_31= RULE_ID )
                    	    // InternalEduTest.g:1721:7: otherlv_31= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    	    							}
                    	    						
                    	    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    							newLeafNode(otherlv_31, grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


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
    // $ANTLR end "ruleMultiChoiceEmConfig"


    // $ANTLR start "entryRuleTextConfiguration"
    // InternalEduTest.g:1738:1: entryRuleTextConfiguration returns [EObject current=null] : iv_ruleTextConfiguration= ruleTextConfiguration EOF ;
    public final EObject entryRuleTextConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextConfiguration = null;


        try {
            // InternalEduTest.g:1738:58: (iv_ruleTextConfiguration= ruleTextConfiguration EOF )
            // InternalEduTest.g:1739:2: iv_ruleTextConfiguration= ruleTextConfiguration EOF
            {
             newCompositeNode(grammarAccess.getTextConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextConfiguration=ruleTextConfiguration();

            state._fsp--;

             current =iv_ruleTextConfiguration; 
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
    // $ANTLR end "entryRuleTextConfiguration"


    // $ANTLR start "ruleTextConfiguration"
    // InternalEduTest.g:1745:1: ruleTextConfiguration returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )? ) ;
    public final EObject ruleTextConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_mode_7_0 = null;

        AntlrDatatypeRuleToken lv_identifier_11_0 = null;



        	enterRule();

        try {
            // InternalEduTest.g:1751:2: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )? ) )
            // InternalEduTest.g:1752:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )? )
            {
            // InternalEduTest.g:1752:2: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )? )
            // InternalEduTest.g:1753:3: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )? (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )?
            {
            // InternalEduTest.g:1753:3: ()
            // InternalEduTest.g:1754:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTextConfigurationAccess().getTextConfigurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTextConfigurationAccess().getRetryKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_2());
            		
            // InternalEduTest.g:1768:3: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // InternalEduTest.g:1769:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // InternalEduTest.g:1769:4: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // InternalEduTest.g:1770:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // InternalEduTest.g:1770:5: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==27) ) {
                alt41=1;
            }
            else if ( (LA41_0==28) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalEduTest.g:1771:6: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,27,FOLLOW_16); 

                    						newLeafNode(lv_retry_3_1, grammarAccess.getTextConfigurationAccess().getRetryYesKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTextConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_1 != null, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1782:6: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,28,FOLLOW_16); 

                    						newLeafNode(lv_retry_3_2, grammarAccess.getTextConfigurationAccess().getRetryNoKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTextConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "retry", lv_retry_3_2 != null, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalEduTest.g:1795:3: (otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==15) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==29) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalEduTest.g:1796:4: otherlv_4= ',' otherlv_5= 'mode' otherlv_6= '=' ( (lv_mode_7_0= ruleMode ) )
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_17); 

                    				newLeafNode(otherlv_4, grammarAccess.getTextConfigurationAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,29,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getTextConfigurationAccess().getModeKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,12,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalEduTest.g:1808:4: ( (lv_mode_7_0= ruleMode ) )
                    // InternalEduTest.g:1809:5: (lv_mode_7_0= ruleMode )
                    {
                    // InternalEduTest.g:1809:5: (lv_mode_7_0= ruleMode )
                    // InternalEduTest.g:1810:6: lv_mode_7_0= ruleMode
                    {

                    						newCompositeNode(grammarAccess.getTextConfigurationAccess().getModeModeEnumRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_mode_7_0=ruleMode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextConfigurationRule());
                    						}
                    						set(
                    							current,
                    							"mode",
                    							lv_mode_7_0,
                    							"wodeledu.dsls.EduTest.Mode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalEduTest.g:1828:3: (otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==15) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalEduTest.g:1829:4: otherlv_8= ',' otherlv_9= 'text' otherlv_10= '=' ( (lv_identifier_11_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_27); 

                    				newLeafNode(otherlv_8, grammarAccess.getTextConfigurationAccess().getCommaKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,35,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getTextConfigurationAccess().getTextKeyword_5_1());
                    			
                    otherlv_10=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_5_2());
                    			
                    // InternalEduTest.g:1841:4: ( (lv_identifier_11_0= ruleEString ) )
                    // InternalEduTest.g:1842:5: (lv_identifier_11_0= ruleEString )
                    {
                    // InternalEduTest.g:1842:5: (lv_identifier_11_0= ruleEString )
                    // InternalEduTest.g:1843:6: lv_identifier_11_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTextConfigurationAccess().getIdentifierEStringParserRuleCall_5_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_identifier_11_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextConfigurationRule());
                    						}
                    						set(
                    							current,
                    							"identifier",
                    							lv_identifier_11_0,
                    							"wodeledu.dsls.EduTest.EString");
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
    // $ANTLR end "ruleTextConfiguration"


    // $ANTLR start "entryRuleTest"
    // InternalEduTest.g:1865:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalEduTest.g:1865:45: (iv_ruleTest= ruleTest EOF )
            // InternalEduTest.g:1866:2: iv_ruleTest= ruleTest EOF
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
    // InternalEduTest.g:1872:1: ruleTest returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) ;
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
            // InternalEduTest.g:1878:2: ( (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? ) )
            // InternalEduTest.g:1879:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            {
            // InternalEduTest.g:1879:2: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )? )
            // InternalEduTest.g:1880:3: otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getTestAccess().getDescriptionKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTestAccess().getForKeyword_1());
            		
            // InternalEduTest.g:1888:3: ( (lv_source_2_0= ruleEString ) )
            // InternalEduTest.g:1889:4: (lv_source_2_0= ruleEString )
            {
            // InternalEduTest.g:1889:4: (lv_source_2_0= ruleEString )
            // InternalEduTest.g:1890:5: lv_source_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
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

            otherlv_3=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3());
            		
            // InternalEduTest.g:1911:3: ( (lv_question_4_0= ruleEString ) )
            // InternalEduTest.g:1912:4: (lv_question_4_0= ruleEString )
            {
            // InternalEduTest.g:1912:4: (lv_question_4_0= ruleEString )
            // InternalEduTest.g:1913:5: lv_question_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalEduTest.g:1930:3: ( ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )? )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalEduTest.g:1931:4: ( (lv_expression_5_0= '%text' ) ) (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    {
                    // InternalEduTest.g:1931:4: ( (lv_expression_5_0= '%text' ) )
                    // InternalEduTest.g:1932:5: (lv_expression_5_0= '%text' )
                    {
                    // InternalEduTest.g:1932:5: (lv_expression_5_0= '%text' )
                    // InternalEduTest.g:1933:6: lv_expression_5_0= '%text'
                    {
                    lv_expression_5_0=(Token)match(input,38,FOLLOW_30); 

                    						newLeafNode(lv_expression_5_0, grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestRule());
                    						}
                    						setWithLastConsumed(current, "expression", lv_expression_5_0 != null, "%text");
                    					

                    }


                    }

                    // InternalEduTest.g:1945:4: (otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==39) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalEduTest.g:1946:5: otherlv_6= '(' ( (lv_identifier_7_0= ruleEString ) ) otherlv_8= ')'
                            {
                            otherlv_6=(Token)match(input,39,FOLLOW_3); 

                            					newLeafNode(otherlv_6, grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0());
                            				
                            // InternalEduTest.g:1950:5: ( (lv_identifier_7_0= ruleEString ) )
                            // InternalEduTest.g:1951:6: (lv_identifier_7_0= ruleEString )
                            {
                            // InternalEduTest.g:1951:6: (lv_identifier_7_0= ruleEString )
                            // InternalEduTest.g:1952:7: lv_identifier_7_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getTestAccess().getIdentifierEStringParserRuleCall_5_1_1_0());
                            						
                            pushFollow(FOLLOW_31);
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

                            otherlv_8=(Token)match(input,40,FOLLOW_2); 

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
    // InternalEduTest.g:1979:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalEduTest.g:1979:47: (iv_ruleEString= ruleEString EOF )
            // InternalEduTest.g:1980:2: iv_ruleEString= ruleEString EOF
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
    // InternalEduTest.g:1986:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:1992:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalEduTest.g:1993:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalEduTest.g:1993:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_STRING) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_ID) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalEduTest.g:1994:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:2002:3: this_ID_1= RULE_ID
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
    // InternalEduTest.g:2013:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalEduTest.g:2013:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalEduTest.g:2014:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalEduTest.g:2020:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalEduTest.g:2026:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalEduTest.g:2027:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalEduTest.g:2027:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalEduTest.g:2028:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalEduTest.g:2028:3: (kw= '-' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalEduTest.g:2029:4: kw= '-'
                    {
                    kw=(Token)match(input,41,FOLLOW_32); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalEduTest.g:2035:3: (this_INT_1= RULE_INT )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_INT) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalEduTest.g:2036:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_33); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,42,FOLLOW_34); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_35); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalEduTest.g:2056:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=43 && LA51_0<=44)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalEduTest.g:2057:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalEduTest.g:2057:4: (kw= 'E' | kw= 'e' )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==43) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==44) ) {
                        alt49=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalEduTest.g:2058:5: kw= 'E'
                            {
                            kw=(Token)match(input,43,FOLLOW_36); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalEduTest.g:2064:5: kw= 'e'
                            {
                            kw=(Token)match(input,44,FOLLOW_36); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalEduTest.g:2070:4: (kw= '-' )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==41) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalEduTest.g:2071:5: kw= '-'
                            {
                            kw=(Token)match(input,41,FOLLOW_34); 

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
    // InternalEduTest.g:2089:1: ruleOrder returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) ;
    public final Enumerator ruleOrder() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalEduTest.g:2095:2: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) )
            // InternalEduTest.g:2096:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            {
            // InternalEduTest.g:2096:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt52=1;
                }
                break;
            case 46:
                {
                alt52=2;
                }
                break;
            case 47:
                {
                alt52=3;
                }
                break;
            case 48:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalEduTest.g:2097:3: (enumLiteral_0= 'fixed' )
                    {
                    // InternalEduTest.g:2097:3: (enumLiteral_0= 'fixed' )
                    // InternalEduTest.g:2098:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:2105:3: (enumLiteral_1= 'random' )
                    {
                    // InternalEduTest.g:2105:3: (enumLiteral_1= 'random' )
                    // InternalEduTest.g:2106:4: enumLiteral_1= 'random'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:2113:3: (enumLiteral_2= 'options-ascending' )
                    {
                    // InternalEduTest.g:2113:3: (enumLiteral_2= 'options-ascending' )
                    // InternalEduTest.g:2114:4: enumLiteral_2= 'options-ascending'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:2121:3: (enumLiteral_3= 'options-descending' )
                    {
                    // InternalEduTest.g:2121:3: (enumLiteral_3= 'options-descending' )
                    // InternalEduTest.g:2122:4: enumLiteral_3= 'options-descending'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

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
    // InternalEduTest.g:2132:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:2138:2: ( ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) )
            // InternalEduTest.g:2139:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            {
            // InternalEduTest.g:2139:2: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==49) ) {
                alt53=1;
            }
            else if ( (LA53_0==50) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalEduTest.g:2140:3: (enumLiteral_0= 'radiobutton' )
                    {
                    // InternalEduTest.g:2140:3: (enumLiteral_0= 'radiobutton' )
                    // InternalEduTest.g:2141:4: enumLiteral_0= 'radiobutton'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:2148:3: (enumLiteral_1= 'checkbox' )
                    {
                    // InternalEduTest.g:2148:3: (enumLiteral_1= 'checkbox' )
                    // InternalEduTest.g:2149:4: enumLiteral_1= 'checkbox'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

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
    // InternalEduTest.g:2159:1: ruleNavigation returns [Enumerator current=null] : ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) ;
    public final Enumerator ruleNavigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEduTest.g:2165:2: ( ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) )
            // InternalEduTest.g:2166:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            {
            // InternalEduTest.g:2166:2: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==51) ) {
                alt54=1;
            }
            else if ( (LA54_0==52) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalEduTest.g:2167:3: (enumLiteral_0= 'free' )
                    {
                    // InternalEduTest.g:2167:3: (enumLiteral_0= 'free' )
                    // InternalEduTest.g:2168:4: enumLiteral_0= 'free'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:2175:3: (enumLiteral_1= 'locked' )
                    {
                    // InternalEduTest.g:2175:3: (enumLiteral_1= 'locked' )
                    // InternalEduTest.g:2176:4: enumLiteral_1= 'locked'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000003FC4000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003FC4002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000060000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0001E00000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000040000000040L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000000040L});

}