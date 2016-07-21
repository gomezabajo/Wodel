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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AlternativeResponse'", "'{'", "'}'", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'navigation'", "'='", "'retry'", "'yes'", "'no'", "','", "'weighted'", "'penalty'", "'order'", "'mode'", "'description'", "'for'", "'-'", "'.'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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

    // delegates
    // delegators


        public InternalEduTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEduTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEduTestParser.tokenNames; }
    public String getGrammarFileName() { return "../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g"; }



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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:68:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:69:2: (iv_ruleProgram= ruleProgram EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:70:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram75);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram85); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:77:1: ruleProgram returns [EObject current=null] : ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_config_1_0 = null;

        EObject lv_exercises_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:80:28: ( ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:81:1: ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:81:1: ( () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+ )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:81:2: () ( (lv_config_1_0= ruleProgramConfiguration ) )? ( (lv_exercises_2_0= ruleMutatorTests ) )+
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:81:2: ()
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgramAccess().getProgramAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:87:2: ( (lv_config_1_0= ruleProgramConfiguration ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:88:1: (lv_config_1_0= ruleProgramConfiguration )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:88:1: (lv_config_1_0= ruleProgramConfiguration )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:89:3: lv_config_1_0= ruleProgramConfiguration
                    {
                     
                    	        newCompositeNode(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleProgramConfiguration_in_ruleProgram140);
                    lv_config_1_0=ruleProgramConfiguration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProgramRule());
                    	        }
                           		set(
                           			current, 
                           			"config",
                            		lv_config_1_0, 
                            		"ProgramConfiguration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:105:3: ( (lv_exercises_2_0= ruleMutatorTests ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||(LA2_0>=14 && LA2_0<=15)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:106:1: (lv_exercises_2_0= ruleMutatorTests )
            	    {
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:106:1: (lv_exercises_2_0= ruleMutatorTests )
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:107:3: lv_exercises_2_0= ruleMutatorTests
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutatorTests_in_ruleProgram162);
            	    lv_exercises_2_0=ruleMutatorTests();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exercises",
            	            		lv_exercises_2_0, 
            	            		"MutatorTests");
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:131:1: entryRuleMutatorTests returns [EObject current=null] : iv_ruleMutatorTests= ruleMutatorTests EOF ;
    public final EObject entryRuleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorTests = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:132:2: (iv_ruleMutatorTests= ruleMutatorTests EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:133:2: iv_ruleMutatorTests= ruleMutatorTests EOF
            {
             newCompositeNode(grammarAccess.getMutatorTestsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests199);
            iv_ruleMutatorTests=ruleMutatorTests();

            state._fsp--;

             current =iv_ruleMutatorTests; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorTests209); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:140:1: ruleMutatorTests returns [EObject current=null] : (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation ) ;
    public final EObject ruleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject this_AlternativeResponse_0 = null;

        EObject this_MultiChoiceDiagram_1 = null;

        EObject this_MultiChoiceEmendation_2 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:143:28: ( (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:144:1: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:144:1: (this_AlternativeResponse_0= ruleAlternativeResponse | this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram | this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:145:5: this_AlternativeResponse_0= ruleAlternativeResponse
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeResponse_in_ruleMutatorTests256);
                    this_AlternativeResponse_0=ruleAlternativeResponse();

                    state._fsp--;

                     
                            current = this_AlternativeResponse_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:155:5: this_MultiChoiceDiagram_1= ruleMultiChoiceDiagram
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceDiagram_in_ruleMutatorTests283);
                    this_MultiChoiceDiagram_1=ruleMultiChoiceDiagram();

                    state._fsp--;

                     
                            current = this_MultiChoiceDiagram_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:165:5: this_MultiChoiceEmendation_2= ruleMultiChoiceEmendation
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmendation_in_ruleMutatorTests310);
                    this_MultiChoiceEmendation_2=ruleMultiChoiceEmendation();

                    state._fsp--;

                     
                            current = this_MultiChoiceEmendation_2; 
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:181:1: entryRuleAlternativeResponse returns [EObject current=null] : iv_ruleAlternativeResponse= ruleAlternativeResponse EOF ;
    public final EObject entryRuleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeResponse = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:182:2: (iv_ruleAlternativeResponse= ruleAlternativeResponse EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:183:2: iv_ruleAlternativeResponse= ruleAlternativeResponse EOF
            {
             newCompositeNode(grammarAccess.getAlternativeResponseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeResponse_in_entryRuleAlternativeResponse345);
            iv_ruleAlternativeResponse=ruleAlternativeResponse();

            state._fsp--;

             current =iv_ruleAlternativeResponse; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeResponse355); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:190:1: ruleAlternativeResponse returns [EObject current=null] : (otherlv_0= 'AlternativeResponse' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) ;
    public final EObject ruleAlternativeResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_config_3_0 = null;

        EObject lv_tests_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:193:28: ( (otherlv_0= 'AlternativeResponse' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:194:1: (otherlv_0= 'AlternativeResponse' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:194:1: (otherlv_0= 'AlternativeResponse' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:194:3: otherlv_0= 'AlternativeResponse' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAlternativeResponse392); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:198:1: ( (otherlv_1= RULE_ID ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:199:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:199:1: (otherlv_1= RULE_ID )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:200:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeResponseRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeResponse412); 

                    		newLeafNode(otherlv_1, grammarAccess.getAlternativeResponseAccess().getBlockEObjectCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAlternativeResponse425); 

                	newLeafNode(otherlv_2, grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:215:1: ( (lv_config_3_0= ruleTestConfiguration ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:216:1: (lv_config_3_0= ruleTestConfiguration )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:216:1: (lv_config_3_0= ruleTestConfiguration )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:217:3: lv_config_3_0= ruleTestConfiguration
            {
             
            	        newCompositeNode(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_ruleAlternativeResponse446);
            lv_config_3_0=ruleTestConfiguration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
            	        }
                   		set(
                   			current, 
                   			"config",
                    		lv_config_3_0, 
                    		"TestConfiguration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:233:2: ( (lv_tests_4_0= ruleTest ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:234:1: (lv_tests_4_0= ruleTest )
            	    {
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:234:1: (lv_tests_4_0= ruleTest )
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:235:3: lv_tests_4_0= ruleTest
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleAlternativeResponse467);
            	    lv_tests_4_0=ruleTest();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAlternativeResponseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tests",
            	            		lv_tests_4_0, 
            	            		"Test");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeResponse480); 

                	newLeafNode(otherlv_5, grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:263:1: entryRuleMultiChoiceDiagram returns [EObject current=null] : iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF ;
    public final EObject entryRuleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceDiagram = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:264:2: (iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:265:2: iv_ruleMultiChoiceDiagram= ruleMultiChoiceDiagram EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceDiagramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceDiagram_in_entryRuleMultiChoiceDiagram516);
            iv_ruleMultiChoiceDiagram=ruleMultiChoiceDiagram();

            state._fsp--;

             current =iv_ruleMultiChoiceDiagram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceDiagram526); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:272:1: ruleMultiChoiceDiagram returns [EObject current=null] : (otherlv_0= 'MultiChoiceDiagram' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) ;
    public final EObject ruleMultiChoiceDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_config_3_0 = null;

        EObject lv_tests_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:275:28: ( (otherlv_0= 'MultiChoiceDiagram' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:276:1: (otherlv_0= 'MultiChoiceDiagram' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:276:1: (otherlv_0= 'MultiChoiceDiagram' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:276:3: otherlv_0= 'MultiChoiceDiagram' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleTestConfiguration ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMultiChoiceDiagram563); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:280:1: ( (otherlv_1= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:281:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:281:1: (otherlv_1= RULE_ID )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:282:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiChoiceDiagramRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiChoiceDiagram583); 

                    		newLeafNode(otherlv_1, grammarAccess.getMultiChoiceDiagramAccess().getBlockEObjectCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMultiChoiceDiagram596); 

                	newLeafNode(otherlv_2, grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:297:1: ( (lv_config_3_0= ruleTestConfiguration ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:298:1: (lv_config_3_0= ruleTestConfiguration )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:298:1: (lv_config_3_0= ruleTestConfiguration )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:299:3: lv_config_3_0= ruleTestConfiguration
            {
             
            	        newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_ruleMultiChoiceDiagram617);
            lv_config_3_0=ruleTestConfiguration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
            	        }
                   		set(
                   			current, 
                   			"config",
                    		lv_config_3_0, 
                    		"TestConfiguration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:315:2: ( (lv_tests_4_0= ruleTest ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:316:1: (lv_tests_4_0= ruleTest )
            	    {
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:316:1: (lv_tests_4_0= ruleTest )
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:317:3: lv_tests_4_0= ruleTest
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleMultiChoiceDiagram638);
            	    lv_tests_4_0=ruleTest();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiChoiceDiagramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tests",
            	            		lv_tests_4_0, 
            	            		"Test");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMultiChoiceDiagram651); 

                	newLeafNode(otherlv_5, grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:345:1: entryRuleMultiChoiceEmendation returns [EObject current=null] : iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF ;
    public final EObject entryRuleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmendation = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:346:2: (iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:347:2: iv_ruleMultiChoiceEmendation= ruleMultiChoiceEmendation EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceEmendationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmendation_in_entryRuleMultiChoiceEmendation687);
            iv_ruleMultiChoiceEmendation=ruleMultiChoiceEmendation();

            state._fsp--;

             current =iv_ruleMultiChoiceEmendation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceEmendation697); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:354:1: ruleMultiChoiceEmendation returns [EObject current=null] : (otherlv_0= 'MultiChoiceEmendation' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) ;
    public final EObject ruleMultiChoiceEmendation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_config_3_0 = null;

        EObject lv_tests_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:357:28: ( (otherlv_0= 'MultiChoiceEmendation' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:358:1: (otherlv_0= 'MultiChoiceEmendation' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:358:1: (otherlv_0= 'MultiChoiceEmendation' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}' )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:358:3: otherlv_0= 'MultiChoiceEmendation' ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_config_3_0= ruleMultiChoiceEmConfig ) ) ( (lv_tests_4_0= ruleTest ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMultiChoiceEmendation734); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:362:1: ( (otherlv_1= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:363:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:363:1: (otherlv_1= RULE_ID )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:364:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiChoiceEmendationRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiChoiceEmendation754); 

                    		newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmendationAccess().getBlockEObjectCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMultiChoiceEmendation767); 

                	newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:379:1: ( (lv_config_3_0= ruleMultiChoiceEmConfig ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:380:1: (lv_config_3_0= ruleMultiChoiceEmConfig )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:380:1: (lv_config_3_0= ruleMultiChoiceEmConfig )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:381:3: lv_config_3_0= ruleMultiChoiceEmConfig
            {
             
            	        newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmConfig_in_ruleMultiChoiceEmendation788);
            lv_config_3_0=ruleMultiChoiceEmConfig();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
            	        }
                   		set(
                   			current, 
                   			"config",
                    		lv_config_3_0, 
                    		"MultiChoiceEmConfig");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:397:2: ( (lv_tests_4_0= ruleTest ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:398:1: (lv_tests_4_0= ruleTest )
            	    {
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:398:1: (lv_tests_4_0= ruleTest )
            	    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:399:3: lv_tests_4_0= ruleTest
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleMultiChoiceEmendation809);
            	    lv_tests_4_0=ruleTest();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiChoiceEmendationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tests",
            	            		lv_tests_4_0, 
            	            		"Test");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMultiChoiceEmendation822); 

                	newLeafNode(otherlv_5, grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleProgramConfiguration"
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:427:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:428:2: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:429:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
            {
             newCompositeNode(grammarAccess.getProgramConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgramConfiguration_in_entryRuleProgramConfiguration858);
            iv_ruleProgramConfiguration=ruleProgramConfiguration();

            state._fsp--;

             current =iv_ruleProgramConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgramConfiguration868); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:436:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) ;
    public final EObject ruleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_navigation_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:439:28: ( (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:440:1: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:440:1: (otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:440:3: otherlv_0= 'navigation' otherlv_1= '=' ( (lv_navigation_2_0= ruleNavigation ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleProgramConfiguration905); 

                	newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0());
                
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleProgramConfiguration917); 

                	newLeafNode(otherlv_1, grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:448:1: ( (lv_navigation_2_0= ruleNavigation ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:449:1: (lv_navigation_2_0= ruleNavigation )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:449:1: (lv_navigation_2_0= ruleNavigation )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:450:3: lv_navigation_2_0= ruleNavigation
            {
             
            	        newCompositeNode(grammarAccess.getProgramConfigurationAccess().getNavigationNavigationEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNavigation_in_ruleProgramConfiguration938);
            lv_navigation_2_0=ruleNavigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramConfigurationRule());
            	        }
                   		set(
                   			current, 
                   			"navigation",
                    		lv_navigation_2_0, 
                    		"Navigation");
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:474:1: entryRuleTestConfiguration returns [EObject current=null] : iv_ruleTestConfiguration= ruleTestConfiguration EOF ;
    public final EObject entryRuleTestConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestConfiguration = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:475:2: (iv_ruleTestConfiguration= ruleTestConfiguration EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:476:2: iv_ruleTestConfiguration= ruleTestConfiguration EOF
            {
             newCompositeNode(grammarAccess.getTestConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_entryRuleTestConfiguration974);
            iv_ruleTestConfiguration=ruleTestConfiguration();

            state._fsp--;

             current =iv_ruleTestConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestConfiguration984); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:483:1: ruleTestConfiguration returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) ;
    public final EObject ruleTestConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_retry_3_1=null;
        Token lv_retry_3_2=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:486:28: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:487:1: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:487:1: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:487:2: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:487:2: ()
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:488:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTestConfiguration1030); 

                	newLeafNode(otherlv_1, grammarAccess.getTestConfigurationAccess().getRetryKeyword_1());
                
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTestConfiguration1042); 

                	newLeafNode(otherlv_2, grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:501:1: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:502:1: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:502:1: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:503:1: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:503:1: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:504:3: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTestConfiguration1062); 

                            newLeafNode(lv_retry_3_1, grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestConfigurationRule());
                    	        }
                           		setWithLastConsumed(current, "retry", true, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:516:8: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTestConfiguration1091); 

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:539:1: entryRuleMultiChoiceEmConfig returns [EObject current=null] : iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF ;
    public final EObject entryRuleMultiChoiceEmConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiChoiceEmConfig = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:540:2: (iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:541:2: iv_ruleMultiChoiceEmConfig= ruleMultiChoiceEmConfig EOF
            {
             newCompositeNode(grammarAccess.getMultiChoiceEmConfigRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmConfig_in_entryRuleMultiChoiceEmConfig1143);
            iv_ruleMultiChoiceEmConfig=ruleMultiChoiceEmConfig();

            state._fsp--;

             current =iv_ruleMultiChoiceEmConfig; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceEmConfig1153); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:548:1: ruleMultiChoiceEmConfig returns [EObject current=null] : ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) ;
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
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:551:28: ( ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:552:1: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:552:1: ( () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:552:2: () otherlv_1= 'retry' otherlv_2= '=' ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) ) otherlv_4= ',' otherlv_5= 'weighted' otherlv_6= '=' ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) ) otherlv_8= ',' otherlv_9= 'penalty' otherlv_10= '=' ( (lv_penalty_11_0= ruleEDouble ) ) otherlv_12= ',' otherlv_13= 'order' otherlv_14= '=' ( (lv_order_15_0= ruleOrder ) ) otherlv_16= ',' otherlv_17= 'mode' otherlv_18= '=' ( (lv_mode_19_0= ruleMode ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:552:2: ()
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:553:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiChoiceEmConfig1199); 

                	newLeafNode(otherlv_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1());
                
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiChoiceEmConfig1211); 

                	newLeafNode(otherlv_2, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:566:1: ( ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:567:1: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:567:1: ( (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:568:1: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:568:1: (lv_retry_3_1= 'yes' | lv_retry_3_2= 'no' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:569:3: lv_retry_3_1= 'yes'
                    {
                    lv_retry_3_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiChoiceEmConfig1231); 

                            newLeafNode(lv_retry_3_1, grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    	        }
                           		setWithLastConsumed(current, "retry", true, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:581:8: lv_retry_3_2= 'no'
                    {
                    lv_retry_3_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiChoiceEmConfig1260); 

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

            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMultiChoiceEmConfig1288); 

                	newLeafNode(otherlv_4, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4());
                
            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiChoiceEmConfig1300); 

                	newLeafNode(otherlv_5, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5());
                
            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiChoiceEmConfig1312); 

                	newLeafNode(otherlv_6, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:608:1: ( ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:609:1: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:609:1: ( (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:610:1: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:610:1: (lv_weighted_7_1= 'yes' | lv_weighted_7_2= 'no' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            else if ( (LA12_0==20) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:611:3: lv_weighted_7_1= 'yes'
                    {
                    lv_weighted_7_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiChoiceEmConfig1332); 

                            newLeafNode(lv_weighted_7_1, grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiChoiceEmConfigRule());
                    	        }
                           		setWithLastConsumed(current, "weighted", true, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:623:8: lv_weighted_7_2= 'no'
                    {
                    lv_weighted_7_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiChoiceEmConfig1361); 

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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMultiChoiceEmConfig1389); 

                	newLeafNode(otherlv_8, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8());
                
            otherlv_9=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiChoiceEmConfig1401); 

                	newLeafNode(otherlv_9, grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9());
                
            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiChoiceEmConfig1413); 

                	newLeafNode(otherlv_10, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:650:1: ( (lv_penalty_11_0= ruleEDouble ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:651:1: (lv_penalty_11_0= ruleEDouble )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:651:1: (lv_penalty_11_0= ruleEDouble )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:652:3: lv_penalty_11_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleMultiChoiceEmConfig1434);
            lv_penalty_11_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            	        }
                   		set(
                   			current, 
                   			"penalty",
                    		lv_penalty_11_0, 
                    		"EDouble");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMultiChoiceEmConfig1446); 

                	newLeafNode(otherlv_12, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12());
                
            otherlv_13=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiChoiceEmConfig1458); 

                	newLeafNode(otherlv_13, grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13());
                
            otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiChoiceEmConfig1470); 

                	newLeafNode(otherlv_14, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:680:1: ( (lv_order_15_0= ruleOrder ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:681:1: (lv_order_15_0= ruleOrder )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:681:1: (lv_order_15_0= ruleOrder )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:682:3: lv_order_15_0= ruleOrder
            {
             
            	        newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOrder_in_ruleMultiChoiceEmConfig1491);
            lv_order_15_0=ruleOrder();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            	        }
                   		set(
                   			current, 
                   			"order",
                    		lv_order_15_0, 
                    		"Order");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMultiChoiceEmConfig1503); 

                	newLeafNode(otherlv_16, grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16());
                
            otherlv_17=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMultiChoiceEmConfig1515); 

                	newLeafNode(otherlv_17, grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17());
                
            otherlv_18=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiChoiceEmConfig1527); 

                	newLeafNode(otherlv_18, grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:710:1: ( (lv_mode_19_0= ruleMode ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:711:1: (lv_mode_19_0= ruleMode )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:711:1: (lv_mode_19_0= ruleMode )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:712:3: lv_mode_19_0= ruleMode
            {
             
            	        newCompositeNode(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMode_in_ruleMultiChoiceEmConfig1548);
            lv_mode_19_0=ruleMode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiChoiceEmConfigRule());
            	        }
                   		set(
                   			current, 
                   			"mode",
                    		lv_mode_19_0, 
                    		"Mode");
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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:736:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:737:2: (iv_ruleTest= ruleTest EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:738:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest1584);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest1594); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:745:1: ruleTest returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_source_2_0 = null;

        AntlrDatatypeRuleToken lv_question_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:748:28: ( (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:749:1: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:749:1: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:749:3: otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTest1631); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getDescriptionKeyword_0());
                
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTest1643); 

                	newLeafNode(otherlv_1, grammarAccess.getTestAccess().getForKeyword_1());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:757:1: ( (lv_source_2_0= ruleEString ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:758:1: (lv_source_2_0= ruleEString )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:758:1: (lv_source_2_0= ruleEString )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:759:3: lv_source_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTest1664);
            lv_source_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTest1676); 

                	newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3());
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:779:1: ( (lv_question_4_0= ruleEString ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:780:1: (lv_question_4_0= ruleEString )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:780:1: (lv_question_4_0= ruleEString )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:781:3: lv_question_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTest1697);
            lv_question_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestRule());
            	        }
                   		set(
                   			current, 
                   			"question",
                    		lv_question_4_0, 
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
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleEString"
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:805:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:806:2: (iv_ruleEString= ruleEString EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:807:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString1734);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString1745); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:814:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:817:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:818:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:818:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:818:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString1785); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:826:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString1811); 

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:841:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:842:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:843:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble1857);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble1868); 

            }

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:850:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:853:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:854:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:854:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:854:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:854:2: (kw= '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:855:2: kw= '-'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEDouble1907); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:860:3: (this_INT_1= RULE_INT )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_INT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:860:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble1925); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEDouble1945); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble1960); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:880:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=30 && LA18_0<=31)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:880:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:880:2: (kw= 'E' | kw= 'e' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==30) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==31) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:881:2: kw= 'E'
                            {
                            kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEDouble1980); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:888:2: kw= 'e'
                            {
                            kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEDouble1999); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:893:2: (kw= '-' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==28) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:894:2: kw= '-'
                            {
                            kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEDouble2014); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2031); 

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:914:1: ruleOrder returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) ;
    public final Enumerator ruleOrder() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:916:28: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:917:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:917:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'random' ) | (enumLiteral_2= 'options-ascending' ) | (enumLiteral_3= 'options-descending' ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt19=1;
                }
                break;
            case 33:
                {
                alt19=2;
                }
                break;
            case 34:
                {
                alt19=3;
                }
                break;
            case 35:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:917:2: (enumLiteral_0= 'fixed' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:917:2: (enumLiteral_0= 'fixed' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:917:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleOrder2092); 

                            current = grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:923:6: (enumLiteral_1= 'random' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:923:6: (enumLiteral_1= 'random' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:923:8: enumLiteral_1= 'random'
                    {
                    enumLiteral_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleOrder2109); 

                            current = grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:929:6: (enumLiteral_2= 'options-ascending' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:929:6: (enumLiteral_2= 'options-ascending' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:929:8: enumLiteral_2= 'options-ascending'
                    {
                    enumLiteral_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleOrder2126); 

                            current = grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:935:6: (enumLiteral_3= 'options-descending' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:935:6: (enumLiteral_3= 'options-descending' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:935:8: enumLiteral_3= 'options-descending'
                    {
                    enumLiteral_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleOrder2143); 

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:945:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:947:28: ( ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:948:1: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:948:1: ( (enumLiteral_0= 'radiobutton' ) | (enumLiteral_1= 'checkbox' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            else if ( (LA20_0==37) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:948:2: (enumLiteral_0= 'radiobutton' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:948:2: (enumLiteral_0= 'radiobutton' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:948:4: enumLiteral_0= 'radiobutton'
                    {
                    enumLiteral_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMode2188); 

                            current = grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:954:6: (enumLiteral_1= 'checkbox' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:954:6: (enumLiteral_1= 'checkbox' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:954:8: enumLiteral_1= 'checkbox'
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMode2205); 

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
    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:964:1: ruleNavigation returns [Enumerator current=null] : ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) ;
    public final Enumerator ruleNavigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:966:28: ( ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) ) )
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:967:1: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            {
            // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:967:1: ( (enumLiteral_0= 'free' ) | (enumLiteral_1= 'locked' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            else if ( (LA21_0==39) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:967:2: (enumLiteral_0= 'free' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:967:2: (enumLiteral_0= 'free' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:967:4: enumLiteral_0= 'free'
                    {
                    enumLiteral_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNavigation2250); 

                            current = grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:973:6: (enumLiteral_1= 'locked' )
                    {
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:973:6: (enumLiteral_1= 'locked' )
                    // ../wodeledu.dsls.edutest/src-gen/wodeledu/dsls/parser/antlr/internal/InternalEduTest.g:973:8: enumLiteral_1= 'locked'
                    {
                    enumLiteral_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNavigation2267); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramConfiguration_in_ruleProgram140 = new BitSet(new long[]{0x000000000000C800L});
        public static final BitSet FOLLOW_ruleMutatorTests_in_ruleProgram162 = new BitSet(new long[]{0x000000000000C802L});
        public static final BitSet FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorTests209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeResponse_in_ruleMutatorTests256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceDiagram_in_ruleMutatorTests283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmendation_in_ruleMutatorTests310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeResponse_in_entryRuleAlternativeResponse345 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeResponse355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAlternativeResponse392 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeResponse412 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAlternativeResponse425 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_ruleAlternativeResponse446 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleAlternativeResponse467 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeResponse480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceDiagram_in_entryRuleMultiChoiceDiagram516 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceDiagram526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleMultiChoiceDiagram563 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiChoiceDiagram583 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMultiChoiceDiagram596 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_ruleMultiChoiceDiagram617 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleMultiChoiceDiagram638 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_13_in_ruleMultiChoiceDiagram651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmendation_in_entryRuleMultiChoiceEmendation687 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceEmendation697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleMultiChoiceEmendation734 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiChoiceEmendation754 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMultiChoiceEmendation767 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmConfig_in_ruleMultiChoiceEmendation788 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleMultiChoiceEmendation809 = new BitSet(new long[]{0x0000000004002000L});
        public static final BitSet FOLLOW_13_in_ruleMultiChoiceEmendation822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramConfiguration_in_entryRuleProgramConfiguration858 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgramConfiguration868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleProgramConfiguration905 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleProgramConfiguration917 = new BitSet(new long[]{0x000000C000000000L});
        public static final BitSet FOLLOW_ruleNavigation_in_ruleProgramConfiguration938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_entryRuleTestConfiguration974 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestConfiguration984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleTestConfiguration1030 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleTestConfiguration1042 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleTestConfiguration1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleTestConfiguration1091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmConfig_in_entryRuleMultiChoiceEmConfig1143 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceEmConfig1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiChoiceEmConfig1199 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMultiChoiceEmConfig1211 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleMultiChoiceEmConfig1231 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_20_in_ruleMultiChoiceEmConfig1260 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMultiChoiceEmConfig1288 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleMultiChoiceEmConfig1300 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMultiChoiceEmConfig1312 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleMultiChoiceEmConfig1332 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_20_in_ruleMultiChoiceEmConfig1361 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMultiChoiceEmConfig1389 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMultiChoiceEmConfig1401 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMultiChoiceEmConfig1413 = new BitSet(new long[]{0x0000000030000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleMultiChoiceEmConfig1434 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMultiChoiceEmConfig1446 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMultiChoiceEmConfig1458 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMultiChoiceEmConfig1470 = new BitSet(new long[]{0x0000000F00000000L});
        public static final BitSet FOLLOW_ruleOrder_in_ruleMultiChoiceEmConfig1491 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMultiChoiceEmConfig1503 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleMultiChoiceEmConfig1515 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMultiChoiceEmConfig1527 = new BitSet(new long[]{0x0000003000000000L});
        public static final BitSet FOLLOW_ruleMode_in_ruleMultiChoiceEmConfig1548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest1584 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest1594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleTest1631 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTest1643 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTest1664 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleTest1676 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTest1697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString1745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString1785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString1811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble1857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble1868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEDouble1907 = new BitSet(new long[]{0x0000000020000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble1925 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleEDouble1945 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble1960 = new BitSet(new long[]{0x00000000C0000002L});
        public static final BitSet FOLLOW_30_in_ruleEDouble1980 = new BitSet(new long[]{0x0000000010000040L});
        public static final BitSet FOLLOW_31_in_ruleEDouble1999 = new BitSet(new long[]{0x0000000010000040L});
        public static final BitSet FOLLOW_28_in_ruleEDouble2014 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleOrder2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleOrder2109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleOrder2126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleOrder2143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMode2188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleMode2205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNavigation2250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleNavigation2267 = new BitSet(new long[]{0x0000000000000002L});
    }


}