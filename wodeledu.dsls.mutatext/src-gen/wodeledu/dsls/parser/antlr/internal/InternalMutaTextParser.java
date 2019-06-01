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
import wodeledu.dsls.services.MutaTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMutaTextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'>'", "'('", "')'", "':'", "'/'", "'%object'", "'%attName'", "'%oldValue'", "'%newValue'", "'%refName'", "'%fromObject'", "'%oldFromObject'", "'%srcRefName'", "'%toObject'", "'%oldToObject'", "'%firstRefName'", "'%firstObject'", "'%firstFromObject'", "'%firstToObject'", "'%secondRefName'", "'%secondObject'", "'%secondFromObject'", "'%secondToObject'", "'%firstAttName'", "'%firstValue'", "'%secondAttName'", "'%secondValue'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
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
    public static final int RULE_ID=5;
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


        public InternalMutaTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMutaTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMutaTextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMutaText.g"; }



     	private MutaTextGrammarAccess grammarAccess;

        public InternalMutaTextParser(TokenStream input, MutaTextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Configuration";
       	}

       	@Override
       	protected MutaTextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConfiguration"
    // InternalMutaText.g:65:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // InternalMutaText.g:65:54: (iv_ruleConfiguration= ruleConfiguration EOF )
            // InternalMutaText.g:66:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
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
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // InternalMutaText.g:72:1: ruleConfiguration returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_options_3_0 = null;

        EObject lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalMutaText.g:78:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? ) )
            // InternalMutaText.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? )
            {
            // InternalMutaText.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? )
            // InternalMutaText.g:80:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )?
            {
            // InternalMutaText.g:80:3: ()
            // InternalMutaText.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getMetamodelKeyword_1());
            		
            // InternalMutaText.g:91:3: ( (lv_metamodel_2_0= ruleEString ) )
            // InternalMutaText.g:92:4: (lv_metamodel_2_0= ruleEString )
            {
            // InternalMutaText.g:92:4: (lv_metamodel_2_0= ruleEString )
            // InternalMutaText.g:93:5: lv_metamodel_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_2_0,
            						"wodeledu.dsls.MutaText.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMutaText.g:110:3: ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMutaText.g:111:4: ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )*
                    {
                    // InternalMutaText.g:111:4: ( (lv_options_3_0= ruleOption ) )
                    // InternalMutaText.g:112:5: (lv_options_3_0= ruleOption )
                    {
                    // InternalMutaText.g:112:5: (lv_options_3_0= ruleOption )
                    // InternalMutaText.g:113:6: lv_options_3_0= ruleOption
                    {

                    						newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_options_3_0=ruleOption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    						}
                    						add(
                    							current,
                    							"options",
                    							lv_options_3_0,
                    							"wodeledu.dsls.MutaText.Option");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMutaText.g:130:4: ( (lv_options_4_0= ruleOption ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalMutaText.g:131:5: (lv_options_4_0= ruleOption )
                    	    {
                    	    // InternalMutaText.g:131:5: (lv_options_4_0= ruleOption )
                    	    // InternalMutaText.g:132:6: lv_options_4_0= ruleOption
                    	    {

                    	    						newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_4);
                    	    lv_options_4_0=ruleOption();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"options",
                    	    							lv_options_4_0,
                    	    							"wodeledu.dsls.MutaText.Option");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
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
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleOption"
    // InternalMutaText.g:154:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalMutaText.g:154:47: (iv_ruleOption= ruleOption EOF )
            // InternalMutaText.g:155:2: iv_ruleOption= ruleOption EOF
            {
             newCompositeNode(grammarAccess.getOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOption=ruleOption();

            state._fsp--;

             current =iv_ruleOption; 
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
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalMutaText.g:161:1: ruleOption returns [EObject current=null] : ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) ) ;
    public final EObject ruleOption() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_valid_7_0 = null;

        EObject lv_invalid_9_0 = null;



        	enterRule();

        try {
            // InternalMutaText.g:167:2: ( ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) ) )
            // InternalMutaText.g:168:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) )
            {
            // InternalMutaText.g:168:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) )
            // InternalMutaText.g:169:3: () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) )
            {
            // InternalMutaText.g:169:3: ()
            // InternalMutaText.g:170:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOptionAccess().getOptionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1());
            		
            // InternalMutaText.g:180:3: ( ( ruleEString ) )
            // InternalMutaText.g:181:4: ( ruleEString )
            {
            // InternalMutaText.g:181:4: ( ruleEString )
            // InternalMutaText.g:182:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOptionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMutaText.g:196:3: (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMutaText.g:197:4: otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalMutaText.g:201:4: ( ( ruleEString ) )
                    // InternalMutaText.g:202:5: ( ruleEString )
                    {
                    // InternalMutaText.g:202:5: ( ruleEString )
                    // InternalMutaText.g:203:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOptionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getOptionAccess().getColonKeyword_4());
            		
            // InternalMutaText.g:226:3: ( (lv_valid_7_0= ruleText ) )
            // InternalMutaText.g:227:4: (lv_valid_7_0= ruleText )
            {
            // InternalMutaText.g:227:4: (lv_valid_7_0= ruleText )
            // InternalMutaText.g:228:5: lv_valid_7_0= ruleText
            {

            					newCompositeNode(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_valid_7_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOptionRule());
            					}
            					set(
            						current,
            						"valid",
            						lv_valid_7_0,
            						"wodeledu.dsls.MutaText.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getOptionAccess().getSolidusKeyword_6());
            		
            // InternalMutaText.g:249:3: ( (lv_invalid_9_0= ruleText ) )
            // InternalMutaText.g:250:4: (lv_invalid_9_0= ruleText )
            {
            // InternalMutaText.g:250:4: (lv_invalid_9_0= ruleText )
            // InternalMutaText.g:251:5: lv_invalid_9_0= ruleText
            {

            					newCompositeNode(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_invalid_9_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOptionRule());
            					}
            					set(
            						current,
            						"invalid",
            						lv_invalid_9_0,
            						"wodeledu.dsls.MutaText.Text");
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
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRuleText"
    // InternalMutaText.g:272:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalMutaText.g:272:45: (iv_ruleText= ruleText EOF )
            // InternalMutaText.g:273:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
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
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalMutaText.g:279:1: ruleText returns [EObject current=null] : ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        EObject lv_words_1_0 = null;

        EObject lv_words_2_0 = null;



        	enterRule();

        try {
            // InternalMutaText.g:285:2: ( ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? ) )
            // InternalMutaText.g:286:2: ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? )
            {
            // InternalMutaText.g:286:2: ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? )
            // InternalMutaText.g:287:3: () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )?
            {
            // InternalMutaText.g:287:3: ()
            // InternalMutaText.g:288:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTextAccess().getTextAction_0(),
            					current);
            			

            }

            // InternalMutaText.g:294:3: ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)||(LA5_0>=17 && LA5_0<=38)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMutaText.g:295:4: ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )*
                    {
                    // InternalMutaText.g:295:4: ( (lv_words_1_0= ruleWord ) )
                    // InternalMutaText.g:296:5: (lv_words_1_0= ruleWord )
                    {
                    // InternalMutaText.g:296:5: (lv_words_1_0= ruleWord )
                    // InternalMutaText.g:297:6: lv_words_1_0= ruleWord
                    {

                    						newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_words_1_0=ruleWord();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextRule());
                    						}
                    						add(
                    							current,
                    							"words",
                    							lv_words_1_0,
                    							"wodeledu.dsls.MutaText.Word");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMutaText.g:314:4: ( (lv_words_2_0= ruleWord ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)||(LA4_0>=17 && LA4_0<=38)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMutaText.g:315:5: (lv_words_2_0= ruleWord )
                    	    {
                    	    // InternalMutaText.g:315:5: (lv_words_2_0= ruleWord )
                    	    // InternalMutaText.g:316:6: lv_words_2_0= ruleWord
                    	    {

                    	    						newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_words_2_0=ruleWord();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTextRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"words",
                    	    							lv_words_2_0,
                    	    							"wodeledu.dsls.MutaText.Word");
                    	    						afterParserOrEnumRuleCall();
                    	    					

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


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleWord"
    // InternalMutaText.g:338:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // InternalMutaText.g:338:45: (iv_ruleWord= ruleWord EOF )
            // InternalMutaText.g:339:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
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
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // InternalMutaText.g:345:1: ruleWord returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Variable_1 = null;



        	enterRule();

        try {
            // InternalMutaText.g:351:2: ( (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) )
            // InternalMutaText.g:352:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            {
            // InternalMutaText.g:352:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=17 && LA6_0<=38)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMutaText.g:353:3: this_Constant_0= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getWordAccess().getConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_0=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMutaText.g:362:3: this_Variable_1= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_1=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_1;
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
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleConstant"
    // InternalMutaText.g:374:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalMutaText.g:374:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalMutaText.g:375:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
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
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalMutaText.g:381:1: ruleConstant returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEString ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMutaText.g:387:2: ( ( () ( (lv_value_1_0= ruleEString ) ) ) )
            // InternalMutaText.g:388:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            {
            // InternalMutaText.g:388:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            // InternalMutaText.g:389:3: () ( (lv_value_1_0= ruleEString ) )
            {
            // InternalMutaText.g:389:3: ()
            // InternalMutaText.g:390:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalMutaText.g:396:3: ( (lv_value_1_0= ruleEString ) )
            // InternalMutaText.g:397:4: (lv_value_1_0= ruleEString )
            {
            // InternalMutaText.g:397:4: (lv_value_1_0= ruleEString )
            // InternalMutaText.g:398:5: lv_value_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstantRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"wodeledu.dsls.MutaText.EString");
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // InternalMutaText.g:419:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalMutaText.g:419:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalMutaText.g:420:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalMutaText.g:426:1: ruleVariable returns [EObject current=null] : ( () ( (lv_type_1_0= ruleVariableType ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalMutaText.g:432:2: ( ( () ( (lv_type_1_0= ruleVariableType ) ) ) )
            // InternalMutaText.g:433:2: ( () ( (lv_type_1_0= ruleVariableType ) ) )
            {
            // InternalMutaText.g:433:2: ( () ( (lv_type_1_0= ruleVariableType ) ) )
            // InternalMutaText.g:434:3: () ( (lv_type_1_0= ruleVariableType ) )
            {
            // InternalMutaText.g:434:3: ()
            // InternalMutaText.g:435:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            // InternalMutaText.g:441:3: ( (lv_type_1_0= ruleVariableType ) )
            // InternalMutaText.g:442:4: (lv_type_1_0= ruleVariableType )
            {
            // InternalMutaText.g:442:4: (lv_type_1_0= ruleVariableType )
            // InternalMutaText.g:443:5: lv_type_1_0= ruleVariableType
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleVariableType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"wodeledu.dsls.MutaText.VariableType");
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEString"
    // InternalMutaText.g:464:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMutaText.g:464:47: (iv_ruleEString= ruleEString EOF )
            // InternalMutaText.g:465:2: iv_ruleEString= ruleEString EOF
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
    // InternalMutaText.g:471:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMutaText.g:477:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMutaText.g:478:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMutaText.g:478:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMutaText.g:479:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMutaText.g:487:3: this_ID_1= RULE_ID
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


    // $ANTLR start "ruleVariableType"
    // InternalMutaText.g:498:1: ruleVariableType returns [Enumerator current=null] : ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) ) ;
    public final Enumerator ruleVariableType() throws RecognitionException {
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
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;


        	enterRule();

        try {
            // InternalMutaText.g:504:2: ( ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) ) )
            // InternalMutaText.g:505:2: ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) )
            {
            // InternalMutaText.g:505:2: ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) )
            int alt8=22;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 19:
                {
                alt8=3;
                }
                break;
            case 20:
                {
                alt8=4;
                }
                break;
            case 21:
                {
                alt8=5;
                }
                break;
            case 22:
                {
                alt8=6;
                }
                break;
            case 23:
                {
                alt8=7;
                }
                break;
            case 24:
                {
                alt8=8;
                }
                break;
            case 25:
                {
                alt8=9;
                }
                break;
            case 26:
                {
                alt8=10;
                }
                break;
            case 27:
                {
                alt8=11;
                }
                break;
            case 28:
                {
                alt8=12;
                }
                break;
            case 29:
                {
                alt8=13;
                }
                break;
            case 30:
                {
                alt8=14;
                }
                break;
            case 31:
                {
                alt8=15;
                }
                break;
            case 32:
                {
                alt8=16;
                }
                break;
            case 33:
                {
                alt8=17;
                }
                break;
            case 34:
                {
                alt8=18;
                }
                break;
            case 35:
                {
                alt8=19;
                }
                break;
            case 36:
                {
                alt8=20;
                }
                break;
            case 37:
                {
                alt8=21;
                }
                break;
            case 38:
                {
                alt8=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMutaText.g:506:3: (enumLiteral_0= '%object' )
                    {
                    // InternalMutaText.g:506:3: (enumLiteral_0= '%object' )
                    // InternalMutaText.g:507:4: enumLiteral_0= '%object'
                    {
                    enumLiteral_0=(Token)match(input,17,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMutaText.g:514:3: (enumLiteral_1= '%attName' )
                    {
                    // InternalMutaText.g:514:3: (enumLiteral_1= '%attName' )
                    // InternalMutaText.g:515:4: enumLiteral_1= '%attName'
                    {
                    enumLiteral_1=(Token)match(input,18,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMutaText.g:522:3: (enumLiteral_2= '%oldValue' )
                    {
                    // InternalMutaText.g:522:3: (enumLiteral_2= '%oldValue' )
                    // InternalMutaText.g:523:4: enumLiteral_2= '%oldValue'
                    {
                    enumLiteral_2=(Token)match(input,19,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMutaText.g:530:3: (enumLiteral_3= '%newValue' )
                    {
                    // InternalMutaText.g:530:3: (enumLiteral_3= '%newValue' )
                    // InternalMutaText.g:531:4: enumLiteral_3= '%newValue'
                    {
                    enumLiteral_3=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMutaText.g:538:3: (enumLiteral_4= '%refName' )
                    {
                    // InternalMutaText.g:538:3: (enumLiteral_4= '%refName' )
                    // InternalMutaText.g:539:4: enumLiteral_4= '%refName'
                    {
                    enumLiteral_4=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMutaText.g:546:3: (enumLiteral_5= '%fromObject' )
                    {
                    // InternalMutaText.g:546:3: (enumLiteral_5= '%fromObject' )
                    // InternalMutaText.g:547:4: enumLiteral_5= '%fromObject'
                    {
                    enumLiteral_5=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMutaText.g:554:3: (enumLiteral_6= '%oldFromObject' )
                    {
                    // InternalMutaText.g:554:3: (enumLiteral_6= '%oldFromObject' )
                    // InternalMutaText.g:555:4: enumLiteral_6= '%oldFromObject'
                    {
                    enumLiteral_6=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMutaText.g:562:3: (enumLiteral_7= '%srcRefName' )
                    {
                    // InternalMutaText.g:562:3: (enumLiteral_7= '%srcRefName' )
                    // InternalMutaText.g:563:4: enumLiteral_7= '%srcRefName'
                    {
                    enumLiteral_7=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMutaText.g:570:3: (enumLiteral_8= '%toObject' )
                    {
                    // InternalMutaText.g:570:3: (enumLiteral_8= '%toObject' )
                    // InternalMutaText.g:571:4: enumLiteral_8= '%toObject'
                    {
                    enumLiteral_8=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMutaText.g:578:3: (enumLiteral_9= '%oldToObject' )
                    {
                    // InternalMutaText.g:578:3: (enumLiteral_9= '%oldToObject' )
                    // InternalMutaText.g:579:4: enumLiteral_9= '%oldToObject'
                    {
                    enumLiteral_9=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalMutaText.g:586:3: (enumLiteral_10= '%firstRefName' )
                    {
                    // InternalMutaText.g:586:3: (enumLiteral_10= '%firstRefName' )
                    // InternalMutaText.g:587:4: enumLiteral_10= '%firstRefName'
                    {
                    enumLiteral_10=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalMutaText.g:594:3: (enumLiteral_11= '%firstObject' )
                    {
                    // InternalMutaText.g:594:3: (enumLiteral_11= '%firstObject' )
                    // InternalMutaText.g:595:4: enumLiteral_11= '%firstObject'
                    {
                    enumLiteral_11=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalMutaText.g:602:3: (enumLiteral_12= '%firstFromObject' )
                    {
                    // InternalMutaText.g:602:3: (enumLiteral_12= '%firstFromObject' )
                    // InternalMutaText.g:603:4: enumLiteral_12= '%firstFromObject'
                    {
                    enumLiteral_12=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalMutaText.g:610:3: (enumLiteral_13= '%firstToObject' )
                    {
                    // InternalMutaText.g:610:3: (enumLiteral_13= '%firstToObject' )
                    // InternalMutaText.g:611:4: enumLiteral_13= '%firstToObject'
                    {
                    enumLiteral_13=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalMutaText.g:618:3: (enumLiteral_14= '%secondRefName' )
                    {
                    // InternalMutaText.g:618:3: (enumLiteral_14= '%secondRefName' )
                    // InternalMutaText.g:619:4: enumLiteral_14= '%secondRefName'
                    {
                    enumLiteral_14=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalMutaText.g:626:3: (enumLiteral_15= '%secondObject' )
                    {
                    // InternalMutaText.g:626:3: (enumLiteral_15= '%secondObject' )
                    // InternalMutaText.g:627:4: enumLiteral_15= '%secondObject'
                    {
                    enumLiteral_15=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalMutaText.g:634:3: (enumLiteral_16= '%secondFromObject' )
                    {
                    // InternalMutaText.g:634:3: (enumLiteral_16= '%secondFromObject' )
                    // InternalMutaText.g:635:4: enumLiteral_16= '%secondFromObject'
                    {
                    enumLiteral_16=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalMutaText.g:642:3: (enumLiteral_17= '%secondToObject' )
                    {
                    // InternalMutaText.g:642:3: (enumLiteral_17= '%secondToObject' )
                    // InternalMutaText.g:643:4: enumLiteral_17= '%secondToObject'
                    {
                    enumLiteral_17=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalMutaText.g:650:3: (enumLiteral_18= '%firstAttName' )
                    {
                    // InternalMutaText.g:650:3: (enumLiteral_18= '%firstAttName' )
                    // InternalMutaText.g:651:4: enumLiteral_18= '%firstAttName'
                    {
                    enumLiteral_18=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalMutaText.g:658:3: (enumLiteral_19= '%firstValue' )
                    {
                    // InternalMutaText.g:658:3: (enumLiteral_19= '%firstValue' )
                    // InternalMutaText.g:659:4: enumLiteral_19= '%firstValue'
                    {
                    enumLiteral_19=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalMutaText.g:666:3: (enumLiteral_20= '%secondAttName' )
                    {
                    // InternalMutaText.g:666:3: (enumLiteral_20= '%secondAttName' )
                    // InternalMutaText.g:667:4: enumLiteral_20= '%secondAttName'
                    {
                    enumLiteral_20=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalMutaText.g:674:3: (enumLiteral_21= '%secondValue' )
                    {
                    // InternalMutaText.g:674:3: (enumLiteral_21= '%secondValue' )
                    // InternalMutaText.g:675:4: enumLiteral_21= '%secondValue'
                    {
                    enumLiteral_21=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21());
                    			

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
    // $ANTLR end "ruleVariableType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000007FFFFF0030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000007FFFFE0030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000007FFFFE0032L});

}