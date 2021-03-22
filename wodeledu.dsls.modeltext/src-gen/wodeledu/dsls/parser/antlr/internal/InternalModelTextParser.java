package wodeledu.dsls.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'>'", "'.'", "'('", "','", "')'", "':'", "'not'", "'%'"
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
    public static final int RULE_ML_COMMENT=7;

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
    // InternalModelText.g:64:1: entryRuleIdentifyElements returns [EObject current=null] : iv_ruleIdentifyElements= ruleIdentifyElements EOF ;
    public final EObject entryRuleIdentifyElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifyElements = null;


        try {
            // InternalModelText.g:64:57: (iv_ruleIdentifyElements= ruleIdentifyElements EOF )
            // InternalModelText.g:65:2: iv_ruleIdentifyElements= ruleIdentifyElements EOF
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
    // InternalModelText.g:71:1: ruleIdentifyElements returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) ;
    public final EObject ruleIdentifyElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:77:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) )
            // InternalModelText.g:78:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            {
            // InternalModelText.g:78:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            // InternalModelText.g:79:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            {
            // InternalModelText.g:79:3: ()
            // InternalModelText.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1());
            		
            // InternalModelText.g:90:3: ( (lv_metamodel_2_0= ruleEString ) )
            // InternalModelText.g:91:4: (lv_metamodel_2_0= ruleEString )
            {
            // InternalModelText.g:91:4: (lv_metamodel_2_0= ruleEString )
            // InternalModelText.g:92:5: lv_metamodel_2_0= ruleEString
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

            // InternalModelText.g:109:3: ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelText.g:110:4: ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )*
                    {
                    // InternalModelText.g:110:4: ( (lv_elements_3_0= ruleElement ) )
                    // InternalModelText.g:111:5: (lv_elements_3_0= ruleElement )
                    {
                    // InternalModelText.g:111:5: (lv_elements_3_0= ruleElement )
                    // InternalModelText.g:112:6: lv_elements_3_0= ruleElement
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

                    // InternalModelText.g:129:4: ( (lv_elements_4_0= ruleElement ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalModelText.g:130:5: (lv_elements_4_0= ruleElement )
                    	    {
                    	    // InternalModelText.g:130:5: (lv_elements_4_0= ruleElement )
                    	    // InternalModelText.g:131:6: lv_elements_4_0= ruleElement
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
    // InternalModelText.g:153:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalModelText.g:153:48: (iv_ruleElement= ruleElement EOF )
            // InternalModelText.g:154:2: iv_ruleElement= ruleElement EOF
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
    // InternalModelText.g:160:1: ruleElement returns [EObject current=null] : ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_att_6_0 = null;

        EObject lv_att_8_0 = null;

        EObject lv_words_11_0 = null;

        EObject lv_words_12_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:166:2: ( ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? ) )
            // InternalModelText.g:167:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? )
            {
            // InternalModelText.g:167:2: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )? )
            // InternalModelText.g:168:3: () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )? otherlv_10= ':' ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )?
            {
            // InternalModelText.g:168:3: ()
            // InternalModelText.g:169:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getElementAccess().getElementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getElementAccess().getGreaterThanSignKeyword_1());
            		
            // InternalModelText.g:179:3: ( ( ruleEString ) )
            // InternalModelText.g:180:4: ( ruleEString )
            {
            // InternalModelText.g:180:4: ( ruleEString )
            // InternalModelText.g:181:5: ruleEString
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

            // InternalModelText.g:195:3: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelText.g:196:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3_0());
                    			
                    // InternalModelText.g:200:4: ( (otherlv_4= RULE_ID ) )
                    // InternalModelText.g:201:5: (otherlv_4= RULE_ID )
                    {
                    // InternalModelText.g:201:5: (otherlv_4= RULE_ID )
                    // InternalModelText.g:202:6: otherlv_4= RULE_ID
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

            // InternalModelText.g:214:3: (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelText.g:215:4: otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )* otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalModelText.g:219:4: ( (lv_att_6_0= ruleAttribute ) )
                    // InternalModelText.g:220:5: (lv_att_6_0= ruleAttribute )
                    {
                    // InternalModelText.g:220:5: (lv_att_6_0= ruleAttribute )
                    // InternalModelText.g:221:6: lv_att_6_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_att_6_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElementRule());
                    						}
                    						add(
                    							current,
                    							"att",
                    							lv_att_6_0,
                    							"wodeledu.dsls.ModelText.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelText.g:238:4: (otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalModelText.g:239:5: otherlv_7= ',' ( (lv_att_8_0= ruleAttribute ) )
                    	    {
                    	    otherlv_7=(Token)match(input,15,FOLLOW_8); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getElementAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalModelText.g:243:5: ( (lv_att_8_0= ruleAttribute ) )
                    	    // InternalModelText.g:244:6: (lv_att_8_0= ruleAttribute )
                    	    {
                    	    // InternalModelText.g:244:6: (lv_att_8_0= ruleAttribute )
                    	    // InternalModelText.g:245:7: lv_att_8_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_att_8_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getElementRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"att",
                    	    								lv_att_8_0,
                    	    								"wodeledu.dsls.ModelText.Attribute");
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
            		
            // InternalModelText.g:272:3: ( ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:273:4: ( (lv_words_11_0= ruleWord ) ) ( (lv_words_12_0= ruleWord ) )*
                    {
                    // InternalModelText.g:273:4: ( (lv_words_11_0= ruleWord ) )
                    // InternalModelText.g:274:5: (lv_words_11_0= ruleWord )
                    {
                    // InternalModelText.g:274:5: (lv_words_11_0= ruleWord )
                    // InternalModelText.g:275:6: lv_words_11_0= ruleWord
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

                    // InternalModelText.g:292:4: ( (lv_words_12_0= ruleWord ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==19) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalModelText.g:293:5: (lv_words_12_0= ruleWord )
                    	    {
                    	    // InternalModelText.g:293:5: (lv_words_12_0= ruleWord )
                    	    // InternalModelText.g:294:6: lv_words_12_0= ruleWord
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


    // $ANTLR start "entryRuleAttribute"
    // InternalModelText.g:316:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalModelText.g:316:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalModelText.g:317:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalModelText.g:323:1: ruleAttribute returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_negation_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalModelText.g:329:2: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalModelText.g:330:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalModelText.g:330:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            // InternalModelText.g:331:3: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) )
            {
            // InternalModelText.g:331:3: ()
            // InternalModelText.g:332:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAttributeAccess().getAttributeAction_0(),
            					current);
            			

            }

            // InternalModelText.g:338:3: ( (lv_negation_1_0= 'not' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalModelText.g:339:4: (lv_negation_1_0= 'not' )
                    {
                    // InternalModelText.g:339:4: (lv_negation_1_0= 'not' )
                    // InternalModelText.g:340:5: lv_negation_1_0= 'not'
                    {
                    lv_negation_1_0=(Token)match(input,18,FOLLOW_6); 

                    					newLeafNode(lv_negation_1_0, grammarAccess.getAttributeAccess().getNegationNotKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "negation", true, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalModelText.g:352:3: ( (otherlv_2= RULE_ID ) )
            // InternalModelText.g:353:4: (otherlv_2= RULE_ID )
            {
            // InternalModelText.g:353:4: (otherlv_2= RULE_ID )
            // InternalModelText.g:354:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleWord"
    // InternalModelText.g:369:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // InternalModelText.g:369:45: (iv_ruleWord= ruleWord EOF )
            // InternalModelText.g:370:2: iv_ruleWord= ruleWord EOF
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
    // InternalModelText.g:376:1: ruleWord returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Variable_1 = null;



        	enterRule();

        try {
            // InternalModelText.g:382:2: ( (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) )
            // InternalModelText.g:383:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            {
            // InternalModelText.g:383:2: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            else if ( (LA9_0==19) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalModelText.g:384:3: this_Constant_0= ruleConstant
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
                    // InternalModelText.g:393:3: this_Variable_1= ruleVariable
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
    // InternalModelText.g:405:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalModelText.g:405:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalModelText.g:406:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalModelText.g:412:1: ruleConstant returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEString ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalModelText.g:418:2: ( ( () ( (lv_value_1_0= ruleEString ) ) ) )
            // InternalModelText.g:419:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            {
            // InternalModelText.g:419:2: ( () ( (lv_value_1_0= ruleEString ) ) )
            // InternalModelText.g:420:3: () ( (lv_value_1_0= ruleEString ) )
            {
            // InternalModelText.g:420:3: ()
            // InternalModelText.g:421:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalModelText.g:427:3: ( (lv_value_1_0= ruleEString ) )
            // InternalModelText.g:428:4: (lv_value_1_0= ruleEString )
            {
            // InternalModelText.g:428:4: (lv_value_1_0= ruleEString )
            // InternalModelText.g:429:5: lv_value_1_0= ruleEString
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
    // InternalModelText.g:450:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalModelText.g:450:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalModelText.g:451:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalModelText.g:457:1: ruleVariable returns [EObject current=null] : ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalModelText.g:463:2: ( ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) )
            // InternalModelText.g:464:2: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalModelText.g:464:2: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            // InternalModelText.g:465:3: () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) )
            {
            // InternalModelText.g:465:3: ()
            // InternalModelText.g:466:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getPercentSignKeyword_1());
            		
            // InternalModelText.g:476:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==13) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalModelText.g:477:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.'
                    {
                    // InternalModelText.g:477:4: ( (otherlv_2= RULE_ID ) )
                    // InternalModelText.g:478:5: (otherlv_2= RULE_ID )
                    {
                    // InternalModelText.g:478:5: (otherlv_2= RULE_ID )
                    // InternalModelText.g:479:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVariableRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getFullStopKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalModelText.g:495:3: ( (otherlv_4= RULE_ID ) )
            // InternalModelText.g:496:4: (otherlv_4= RULE_ID )
            {
            // InternalModelText.g:496:4: (otherlv_4= RULE_ID )
            // InternalModelText.g:497:5: otherlv_4= RULE_ID
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


    // $ANTLR start "entryRuleEString"
    // InternalModelText.g:512:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalModelText.g:512:47: (iv_ruleEString= ruleEString EOF )
            // InternalModelText.g:513:2: iv_ruleEString= ruleEString EOF
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
    // InternalModelText.g:519:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalModelText.g:525:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalModelText.g:526:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalModelText.g:526:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:527:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalModelText.g:535:3: this_ID_1= RULE_ID
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
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080032L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000002000L});

}