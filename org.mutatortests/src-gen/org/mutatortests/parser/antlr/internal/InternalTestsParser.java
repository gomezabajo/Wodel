package org.mutatortests.parser.antlr.internal; 

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
import org.mutatortests.services.TestsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'retry'", "'='", "','", "'showall'", "'description'", "'for'", "'no'", "'yes'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalTestsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g"; }



     	private TestsGrammarAccess grammarAccess;
     	
        public InternalTestsParser(TokenStream input, TestsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MutatorTests";	
       	}
       	
       	@Override
       	protected TestsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMutatorTests"
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:68:1: entryRuleMutatorTests returns [EObject current=null] : iv_ruleMutatorTests= ruleMutatorTests EOF ;
    public final EObject entryRuleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorTests = null;


        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:69:2: (iv_ruleMutatorTests= ruleMutatorTests EOF )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:70:2: iv_ruleMutatorTests= ruleMutatorTests EOF
            {
             newCompositeNode(grammarAccess.getMutatorTestsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests75);
            iv_ruleMutatorTests=ruleMutatorTests();

            state._fsp--;

             current =iv_ruleMutatorTests; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorTests85); 

            }

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
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:77:1: ruleMutatorTests returns [EObject current=null] : ( ( (lv_config_0_0= ruleConfiguration ) ) ( (lv_tests_1_0= ruleTest ) )* ) ;
    public final EObject ruleMutatorTests() throws RecognitionException {
        EObject current = null;

        EObject lv_config_0_0 = null;

        EObject lv_tests_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:80:28: ( ( ( (lv_config_0_0= ruleConfiguration ) ) ( (lv_tests_1_0= ruleTest ) )* ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:81:1: ( ( (lv_config_0_0= ruleConfiguration ) ) ( (lv_tests_1_0= ruleTest ) )* )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:81:1: ( ( (lv_config_0_0= ruleConfiguration ) ) ( (lv_tests_1_0= ruleTest ) )* )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:81:2: ( (lv_config_0_0= ruleConfiguration ) ) ( (lv_tests_1_0= ruleTest ) )*
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:81:2: ( (lv_config_0_0= ruleConfiguration ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:82:1: (lv_config_0_0= ruleConfiguration )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:82:1: (lv_config_0_0= ruleConfiguration )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:83:3: lv_config_0_0= ruleConfiguration
            {
             
            	        newCompositeNode(grammarAccess.getMutatorTestsAccess().getConfigConfigurationParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_ruleMutatorTests131);
            lv_config_0_0=ruleConfiguration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorTestsRule());
            	        }
                   		set(
                   			current, 
                   			"config",
                    		lv_config_0_0, 
                    		"Configuration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:99:2: ( (lv_tests_1_0= ruleTest ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:100:1: (lv_tests_1_0= ruleTest )
            	    {
            	    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:100:1: (lv_tests_1_0= ruleTest )
            	    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:101:3: lv_tests_1_0= ruleTest
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorTestsAccess().getTestsTestParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleMutatorTests152);
            	    lv_tests_1_0=ruleTest();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorTestsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tests",
            	            		lv_tests_1_0, 
            	            		"Test");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleMutatorTests"


    // $ANTLR start "entryRuleConfiguration"
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:125:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:126:2: (iv_ruleConfiguration= ruleConfiguration EOF )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:127:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration189);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:134:1: ruleConfiguration returns [EObject current=null] : (otherlv_0= 'retry' otherlv_1= '=' ( (lv_retry_2_0= ruleParameter ) ) otherlv_3= ',' otherlv_4= 'showall' otherlv_5= '=' ( (lv_showall_6_0= ruleParameter ) ) ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Enumerator lv_retry_2_0 = null;

        Enumerator lv_showall_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:137:28: ( (otherlv_0= 'retry' otherlv_1= '=' ( (lv_retry_2_0= ruleParameter ) ) otherlv_3= ',' otherlv_4= 'showall' otherlv_5= '=' ( (lv_showall_6_0= ruleParameter ) ) ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:138:1: (otherlv_0= 'retry' otherlv_1= '=' ( (lv_retry_2_0= ruleParameter ) ) otherlv_3= ',' otherlv_4= 'showall' otherlv_5= '=' ( (lv_showall_6_0= ruleParameter ) ) )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:138:1: (otherlv_0= 'retry' otherlv_1= '=' ( (lv_retry_2_0= ruleParameter ) ) otherlv_3= ',' otherlv_4= 'showall' otherlv_5= '=' ( (lv_showall_6_0= ruleParameter ) ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:138:3: otherlv_0= 'retry' otherlv_1= '=' ( (lv_retry_2_0= ruleParameter ) ) otherlv_3= ',' otherlv_4= 'showall' otherlv_5= '=' ( (lv_showall_6_0= ruleParameter ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleConfiguration236); 

                	newLeafNode(otherlv_0, grammarAccess.getConfigurationAccess().getRetryKeyword_0());
                
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConfiguration248); 

                	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getEqualsSignKeyword_1());
                
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:146:1: ( (lv_retry_2_0= ruleParameter ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:147:1: (lv_retry_2_0= ruleParameter )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:147:1: (lv_retry_2_0= ruleParameter )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:148:3: lv_retry_2_0= ruleParameter
            {
             
            	        newCompositeNode(grammarAccess.getConfigurationAccess().getRetryParameterEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleConfiguration269);
            lv_retry_2_0=ruleParameter();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	        }
                   		set(
                   			current, 
                   			"retry",
                    		lv_retry_2_0, 
                    		"Parameter");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConfiguration281); 

                	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getCommaKeyword_3());
                
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConfiguration293); 

                	newLeafNode(otherlv_4, grammarAccess.getConfigurationAccess().getShowallKeyword_4());
                
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConfiguration305); 

                	newLeafNode(otherlv_5, grammarAccess.getConfigurationAccess().getEqualsSignKeyword_5());
                
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:176:1: ( (lv_showall_6_0= ruleParameter ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:177:1: (lv_showall_6_0= ruleParameter )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:177:1: (lv_showall_6_0= ruleParameter )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:178:3: lv_showall_6_0= ruleParameter
            {
             
            	        newCompositeNode(grammarAccess.getConfigurationAccess().getShowallParameterEnumRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleConfiguration326);
            lv_showall_6_0=ruleParameter();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	        }
                   		set(
                   			current, 
                   			"showall",
                    		lv_showall_6_0, 
                    		"Parameter");
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
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleTest"
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:202:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:203:2: (iv_ruleTest= ruleTest EOF )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:204:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest362);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest372); 

            }

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
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:211:1: ruleTest returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_source_2_0 = null;

        AntlrDatatypeRuleToken lv_question_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:214:28: ( (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:215:1: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:215:1: (otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:215:3: otherlv_0= 'description' otherlv_1= 'for' ( (lv_source_2_0= ruleEString ) ) otherlv_3= '=' ( (lv_question_4_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTest409); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getDescriptionKeyword_0());
                
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTest421); 

                	newLeafNode(otherlv_1, grammarAccess.getTestAccess().getForKeyword_1());
                
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:223:1: ( (lv_source_2_0= ruleEString ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:224:1: (lv_source_2_0= ruleEString )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:224:1: (lv_source_2_0= ruleEString )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:225:3: lv_source_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTest442);
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTest454); 

                	newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3());
                
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:245:1: ( (lv_question_4_0= ruleEString ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:246:1: (lv_question_4_0= ruleEString )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:246:1: (lv_question_4_0= ruleEString )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:247:3: lv_question_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTest475);
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
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:271:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:272:2: (iv_ruleEString= ruleEString EOF )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:273:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString512);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString523); 

            }

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
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:280:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:283:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:284:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:284:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:284:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString563); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:292:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString589); 

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


    // $ANTLR start "ruleParameter"
    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:307:1: ruleParameter returns [Enumerator current=null] : ( (enumLiteral_0= 'no' ) | (enumLiteral_1= 'yes' ) ) ;
    public final Enumerator ruleParameter() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:309:28: ( ( (enumLiteral_0= 'no' ) | (enumLiteral_1= 'yes' ) ) )
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:310:1: ( (enumLiteral_0= 'no' ) | (enumLiteral_1= 'yes' ) )
            {
            // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:310:1: ( (enumLiteral_0= 'no' ) | (enumLiteral_1= 'yes' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:310:2: (enumLiteral_0= 'no' )
                    {
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:310:2: (enumLiteral_0= 'no' )
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:310:4: enumLiteral_0= 'no'
                    {
                    enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParameter648); 

                            current = grammarAccess.getParameterAccess().getNoEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getParameterAccess().getNoEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:316:6: (enumLiteral_1= 'yes' )
                    {
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:316:6: (enumLiteral_1= 'yes' )
                    // ../org.mutatortests/src-gen/org/mutatortests/parser/antlr/internal/InternalTests.g:316:8: enumLiteral_1= 'yes'
                    {
                    enumLiteral_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParameter665); 

                            current = grammarAccess.getParameterAccess().getYesEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getParameterAccess().getYesEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleParameter"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorTests85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConfiguration_in_ruleMutatorTests131 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleTest_in_ruleMutatorTests152 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleConfiguration236 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleConfiguration248 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleConfiguration269 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConfiguration281 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConfiguration293 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleConfiguration305 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleConfiguration326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTest409 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTest421 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTest442 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTest454 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTest475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString512 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParameter648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParameter665 = new BitSet(new long[]{0x0000000000000002L});
    }


}