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
import wodeledu.dsls.services.ModelTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelTextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'>'", "'.'", "'('", "','", "')'", "':'", "'not'", "'->'", "'=='", "'null'", "'%'", "'type'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalModelTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelTextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalModelText.g"; }



     	private ModelTextGrammarAccess grammarAccess;

        public InternalModelTextParser(TokenStream input, ModelTextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "IdentifyElements";
       	}

       	@Override
       	protected ModelTextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleIdentifyElements"
    // InternalModelText.g:65:1: entryRuleIdentifyElements returns [EObject current=null] : iv_ruleIdentifyElements= ruleIdentifyElements EOF ;
    public final EObject entryRuleIdentifyElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifyElements = null;


        try {
            // InternalModelText.g:65:57: (iv_ruleIdentifyElements= ruleIdentifyElements EOF )
            // InternalModelText.g:66:2: iv_ruleIdentifyElements= ruleIdentifyElements EOF
            {
             newCompositeNode(grammarAccess.getIdentifyElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdentifyElements=ruleIdentifyElements();

            state._fsp--;

             current =iv_ruleIdentifyElements; 
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
    // $ANTLR end "entryRuleIdentifyElements"


    // $ANTLR start "ruleIdentifyElements"
    // InternalModelText.g:72:1: ruleIdentifyElements returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) ;
    public final EObject ruleIdentifyElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:78:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) )
            // InternalModelText.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            {
            // InternalModelText.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            // InternalModelText.g:80:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            {
            // InternalModelText.g:80:3: ()
            // InternalModelText.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1());
            		
            // InternalModelText.g:91:3: ( (lv_metamodel_2_0= ruleEString ) )
            // InternalModelText.g:92:4: (lv_metamodel_2_0= ruleEString )
            {
            // InternalModelText.g:92:4: (lv_metamodel_2_0= ruleEString )
            // InternalModelText.g:93:5: lv_metamodel_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_2_0,
            						"wodeledu.dsls.ModelText.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelText.g:110:3: ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelText.g:111:4: ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )*
                    {
                    // InternalModelText.g:111:4: ( (lv_elements_3_0= ruleElement ) )
                    // InternalModelText.g:112:5: (lv_elements_3_0= ruleElement )
                    {
                    // InternalModelText.g:112:5: (lv_elements_3_0= ruleElement )
                    // InternalModelText.g:113:6: lv_elements_3_0= ruleElement
                    {

                    						newCompositeNode(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_elements_3_0=ruleElement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
                    						}
                    						add(
                    							current,
                    							"elements",
                    							lv_elements_3_0,
                    							"wodeledu.dsls.ModelText.Element");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelText.g:130:4: ( (lv_elements_4_0= ruleElement ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalModelText.g:131:5: (lv_elements_4_0= ruleElement )
                    	    {
                    	    // InternalModelText.g:131:5: (lv_elements_4_0= ruleElement )
                    	    // InternalModelText.g:132:6: lv_elements_4_0= ruleElement
                    	    {

                    	    						newCompositeNode(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_4);
                    	    lv_elements_4_0=ruleElement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_4_0,
                    	    							"wodeledu.dsls.ModelText.Element");
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
    // $ANTLR end "ruleIdentifyElements"


    // $ANTLR start "entryRuleElement"
    // InternalModelText.g:154:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalModelText.g:154:48: (iv_ruleElement= ruleElement EOF )
            // InternalModelText.g:155:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalModelText.g:161:1: ruleElement returns [EObject current=null] : ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_feature_6_0 = null;

        EObject lv_feature_8_0 = null;

        EObject lv_words_11_0 = null;

        EObject lv_words_12_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:167:2: ( ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? ) )
            // InternalModelText.g:168:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? )
            {
            // InternalModelText.g:168:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? )
            // InternalModelText.g:169:3: () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )?
            {
            // InternalModelText.g:169:3: ()
            // InternalModelText.g:170:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getElementAccess().getElementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getElementAccess().getGreaterThanSignKeyword_1());
            		
            // InternalModelText.g:180:3: ( ( ruleEString ) )
            // InternalModelText.g:181:4: ( ruleEString )
            {
            // InternalModelText.g:181:4: ( ruleEString )
            // InternalModelText.g:182:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getElementRule());
            					}
            				

            					newCompositeNode(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelText.g:196:3: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelText.g:197:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3_0());
                    			
                    // InternalModelText.g:201:4: ( (otherlv_4= RULE_ID ) )
                    // InternalModelText.g:202:5: (otherlv_4= RULE_ID )
                    {
                    // InternalModelText.g:202:5: (otherlv_4= RULE_ID )
                    // InternalModelText.g:203:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getElementRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(otherlv_4, grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelText.g:215:3: (otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelText.g:216:4: otherlv_5= '(' ( (lv_feature_6_0= ruleValuedFeature ) ) (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )* otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalModelText.g:220:4: ( (lv_feature_6_0= ruleValuedFeature ) )
                    // InternalModelText.g:221:5: (lv_feature_6_0= ruleValuedFeature )
                    {
                    // InternalModelText.g:221:5: (lv_feature_6_0= ruleValuedFeature )
                    // InternalModelText.g:222:6: lv_feature_6_0= ruleValuedFeature
                    {

                    						newCompositeNode(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_feature_6_0=ruleValuedFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElementRule());
                    						}
                    						add(
                    							current,
                    							"feature",
                    							lv_feature_6_0,
                    							"wodeledu.dsls.ModelText.ValuedFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelText.g:239:4: (otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalModelText.g:240:5: otherlv_7= ',' ( (lv_feature_8_0= ruleValuedFeature ) )
                    	    {
                    	    otherlv_7=(Token)match(input,15,FOLLOW_8); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getElementAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalModelText.g:244:5: ( (lv_feature_8_0= ruleValuedFeature ) )
                    	    // InternalModelText.g:245:6: (lv_feature_8_0= ruleValuedFeature )
                    	    {
                    	    // InternalModelText.g:245:6: (lv_feature_8_0= ruleValuedFeature )
                    	    // InternalModelText.g:246:7: lv_feature_8_0= ruleValuedFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_feature_8_0=ruleValuedFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getElementRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"feature",
                    	    								lv_feature_8_0,
                    	    								"wodeledu.dsls.ModelText.ValuedFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_9, grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_10, grammarAccess.getElementAccess().getColonKeyword_5());
            		
            // InternalModelText.g:273:3: ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:274:4: ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )*
                    {
                    // InternalModelText.g:274:4: ( (lv_words_11_0= ruleWord ) )
                    // InternalModelText.g:275:5: (lv_words_11_0= ruleWord )
                    {
                    // InternalModelText.g:275:5: (lv_words_11_0= ruleWord )
                    // InternalModelText.g:276:6: lv_words_11_0= ruleWord
                    {

                    						newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_words_11_0=ruleWord();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElementRule());
                    						}
                    						add(
                    							current,
                    							"words",
                    							lv_words_11_0,
                    							"wodeledu.dsls.ModelText.Word");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelText.g:293:4: ( (lv_words_12_0= ruleWord ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==22) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalModelText.g:294:5: (lv_words_12_0= ruleWord )
                    	    {
                    	    // InternalModelText.g:294:5: (lv_words_12_0= ruleWord )
                    	    // InternalModelText.g:295:6: lv_words_12_0= ruleWord
                    	    {

                    	    						newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_words_12_0=ruleWord();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getElementRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"words",
                    	    							lv_words_12_0,
                    	    							"wodeledu.dsls.ModelText.Word");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleValuedFeature"
    // InternalModelText.g:317:1: entryRuleValuedFeature returns [EObject current=null] : iv_ruleValuedFeature= ruleValuedFeature EOF ;
    public final EObject entryRuleValuedFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedFeature = null;


        try {
            // InternalModelText.g:317:54: (iv_ruleValuedFeature= ruleValuedFeature EOF )
            // InternalModelText.g:318:2: iv_ruleValuedFeature= ruleValuedFeature EOF
            {
             newCompositeNode(grammarAccess.getValuedFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValuedFeature=ruleValuedFeature();

            state._fsp--;

             current =iv_ruleValuedFeature; 
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
    // $ANTLR end "entryRuleValuedFeature"


    // $ANTLR start "ruleValuedFeature"
    // InternalModelText.g:324:1: ruleValuedFeature returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) ;
    public final EObject ruleValuedFeature() throws RecognitionException {
        EObject current = null;

        Token lv_negation_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_value_6_0=null;


        	enterRule();

        try {
            // InternalModelText.g:330:2: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) )
            // InternalModelText.g:331:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            {
            // InternalModelText.g:331:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            // InternalModelText.g:332:3: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            {
            // InternalModelText.g:332:3: ()
            // InternalModelText.g:333:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0(),
            					current);
            			

            }

            // InternalModelText.g:339:3: ( (lv_negation_1_0= 'not' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalModelText.g:340:4: (lv_negation_1_0= 'not' )
                    {
                    // InternalModelText.g:340:4: (lv_negation_1_0= 'not' )
                    // InternalModelText.g:341:5: lv_negation_1_0= 'not'
                    {
                    lv_negation_1_0=(Token)match(input,18,FOLLOW_6); 

                    					newLeafNode(lv_negation_1_0, grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getValuedFeatureRule());
                    					}
                    					setWithLastConsumed(current, "negation", true, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalModelText.g:353:3: ( (otherlv_2= RULE_ID ) )
            // InternalModelText.g:354:4: (otherlv_2= RULE_ID )
            {
            // InternalModelText.g:354:4: (otherlv_2= RULE_ID )
            // InternalModelText.g:355:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValuedFeatureRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_2, grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalModelText.g:366:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalModelText.g:367:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalModelText.g:371:4: ( (otherlv_4= RULE_ID ) )
                    // InternalModelText.g:372:5: (otherlv_4= RULE_ID )
                    {
                    // InternalModelText.g:372:5: (otherlv_4= RULE_ID )
                    // InternalModelText.g:373:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValuedFeatureRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelText.g:385:3: (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelText.g:386:4: otherlv_5= '==' ( (lv_value_6_0= 'null' ) )
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0());
                    			
                    // InternalModelText.g:390:4: ( (lv_value_6_0= 'null' ) )
                    // InternalModelText.g:391:5: (lv_value_6_0= 'null' )
                    {
                    // InternalModelText.g:391:5: (lv_value_6_0= 'null' )
                    // InternalModelText.g:392:6: lv_value_6_0= 'null'
                    {
                    lv_value_6_0=(Token)match(input,21,FOLLOW_2); 

                    						newLeafNode(lv_value_6_0, grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValuedFeatureRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_6_0, "null");
                    					

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
    // $ANTLR end "ruleValuedFeature"


    // $ANTLR start "entryRuleWord"
    // InternalModelText.g:409:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // InternalModelText.g:409:45: (iv_ruleWord= ruleWord EOF )
            // InternalModelText.g:410:2: iv_ruleWord= ruleWord EOF
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
    // InternalModelText.g:416:1: ruleWord returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable | this_Macro_2= ruleMacro ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Variable_1 = null;

        EObject this_Macro_2 = null;



        	enterRule();

        try {
            // InternalModelText.g:422:2: ( (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable | this_Macro_2= ruleMacro ) )
            // InternalModelText.g:423:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable | this_Macro_2= ruleMacro )
            {
            // InternalModelText.g:423:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable | this_Macro_2= ruleMacro )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
                alt11=1;
            }
            else if ( (LA11_0==22) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==RULE_ID) ) {
                    alt11=2;
                }
                else if ( (LA11_2==23) ) {
                    alt11=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:424:3: this_Constant_0= ruleConstant
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
                    // InternalModelText.g:433:3: this_Variable_1= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_1=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalModelText.g:442:3: this_Macro_2= ruleMacro
                    {

                    			newCompositeNode(grammarAccess.getWordAccess().getMacroParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Macro_2=ruleMacro();

                    state._fsp--;


                    			current = this_Macro_2;
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
    // InternalModelText.g:454:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalModelText.g:454:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalModelText.g:455:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalModelText.g:461:1: ruleConstant returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEString ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:467:2: ( ( () ( (lv_value_1_0= ruleEString ) ) ) )
            // InternalModelText.g:468:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            {
            // InternalModelText.g:468:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            // InternalModelText.g:469:3: () ( (lv_value_1_0= ruleEString ) )
            {
            // InternalModelText.g:469:3: ()
            // InternalModelText.g:470:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalModelText.g:476:3: ( (lv_value_1_0= ruleEString ) )
            // InternalModelText.g:477:4: (lv_value_1_0= ruleEString )
            {
            // InternalModelText.g:477:4: (lv_value_1_0= ruleEString )
            // InternalModelText.g:478:5: lv_value_1_0= ruleEString
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
            						"wodeledu.dsls.ModelText.EString");
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
    // InternalModelText.g:499:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalModelText.g:499:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalModelText.g:500:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalModelText.g:506:1: ruleVariable returns [EObject current=null] : ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalModelText.g:512:2: ( ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) )
            // InternalModelText.g:513:2: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalModelText.g:513:2: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            // InternalModelText.g:514:3: () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) )
            {
            // InternalModelText.g:514:3: ()
            // InternalModelText.g:515:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getPercentSignKeyword_1());
            		
            // InternalModelText.g:525:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==13) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // InternalModelText.g:526:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.'
                    {
                    // InternalModelText.g:526:4: ( (otherlv_2= RULE_ID ) )
                    // InternalModelText.g:527:5: (otherlv_2= RULE_ID )
                    {
                    // InternalModelText.g:527:5: (otherlv_2= RULE_ID )
                    // InternalModelText.g:528:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVariableRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getFullStopKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalModelText.g:544:3: ( (otherlv_4= RULE_ID ) )
            // InternalModelText.g:545:4: (otherlv_4= RULE_ID )
            {
            // InternalModelText.g:545:4: (otherlv_4= RULE_ID )
            // InternalModelText.g:546:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0());
            				

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


    // $ANTLR start "entryRuleMacro"
    // InternalModelText.g:561:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalModelText.g:561:46: (iv_ruleMacro= ruleMacro EOF )
            // InternalModelText.g:562:2: iv_ruleMacro= ruleMacro EOF
            {
             newCompositeNode(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMacro=ruleMacro();

            state._fsp--;

             current =iv_ruleMacro; 
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
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // InternalModelText.g:568:1: ruleMacro returns [EObject current=null] : ( () otherlv_1= '%' ( (lv_item_2_0= ruleMacroItem ) ) ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_item_2_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:574:2: ( ( () otherlv_1= '%' ( (lv_item_2_0= ruleMacroItem ) ) ) )
            // InternalModelText.g:575:2: ( () otherlv_1= '%' ( (lv_item_2_0= ruleMacroItem ) ) )
            {
            // InternalModelText.g:575:2: ( () otherlv_1= '%' ( (lv_item_2_0= ruleMacroItem ) ) )
            // InternalModelText.g:576:3: () otherlv_1= '%' ( (lv_item_2_0= ruleMacroItem ) )
            {
            // InternalModelText.g:576:3: ()
            // InternalModelText.g:577:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMacroAccess().getMacroAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getMacroAccess().getPercentSignKeyword_1());
            		
            // InternalModelText.g:587:3: ( (lv_item_2_0= ruleMacroItem ) )
            // InternalModelText.g:588:4: (lv_item_2_0= ruleMacroItem )
            {
            // InternalModelText.g:588:4: (lv_item_2_0= ruleMacroItem )
            // InternalModelText.g:589:5: lv_item_2_0= ruleMacroItem
            {

            					newCompositeNode(grammarAccess.getMacroAccess().getItemMacroItemEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_item_2_0=ruleMacroItem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMacroRule());
            					}
            					set(
            						current,
            						"item",
            						lv_item_2_0,
            						"wodeledu.dsls.ModelText.MacroItem");
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
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleEString"
    // InternalModelText.g:610:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalModelText.g:610:47: (iv_ruleEString= ruleEString EOF )
            // InternalModelText.g:611:2: iv_ruleEString= ruleEString EOF
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
    // InternalModelText.g:617:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalModelText.g:623:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalModelText.g:624:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalModelText.g:624:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // InternalModelText.g:625:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalModelText.g:633:3: this_ID_1= RULE_ID
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


    // $ANTLR start "ruleMacroItem"
    // InternalModelText.g:644:1: ruleMacroItem returns [Enumerator current=null] : (enumLiteral_0= 'type' ) ;
    public final Enumerator ruleMacroItem() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelText.g:650:2: ( (enumLiteral_0= 'type' ) )
            // InternalModelText.g:651:2: (enumLiteral_0= 'type' )
            {
            // InternalModelText.g:651:2: (enumLiteral_0= 'type' )
            // InternalModelText.g:652:3: enumLiteral_0= 'type'
            {
            enumLiteral_0=(Token)match(input,23,FOLLOW_2); 

            			current = grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacroItem"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000026000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400032L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});

}