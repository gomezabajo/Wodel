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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'>'", "'.'", "'('", "')'", "':'", "'yes'", "'not'", "'%'"
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
    public String getGrammarFileName() { return "../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g"; }



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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:67:1: entryRuleIdentifyElements returns [EObject current=null] : iv_ruleIdentifyElements= ruleIdentifyElements EOF ;
    public final EObject entryRuleIdentifyElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifyElements = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:68:2: (iv_ruleIdentifyElements= ruleIdentifyElements EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:69:2: iv_ruleIdentifyElements= ruleIdentifyElements EOF
            {
             newCompositeNode(grammarAccess.getIdentifyElementsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdentifyElements_in_entryRuleIdentifyElements75);
            iv_ruleIdentifyElements=ruleIdentifyElements();

            state._fsp--;

             current =iv_ruleIdentifyElements; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifyElements85); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:76:1: ruleIdentifyElements returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) ;
    public final EObject ruleIdentifyElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:79:28: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:80:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:80:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )? )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:80:2: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:80:2: ()
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleIdentifyElements131); 

                	newLeafNode(otherlv_1, grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1());
                
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:90:1: ( (lv_metamodel_2_0= ruleEString ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:91:1: (lv_metamodel_2_0= ruleEString )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:91:1: (lv_metamodel_2_0= ruleEString )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:92:3: lv_metamodel_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleIdentifyElements152);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:108:2: ( ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:108:3: ( (lv_elements_3_0= ruleElement ) ) ( (lv_elements_4_0= ruleElement ) )*
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:108:3: ( (lv_elements_3_0= ruleElement ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:109:1: (lv_elements_3_0= ruleElement )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:109:1: (lv_elements_3_0= ruleElement )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:110:3: lv_elements_3_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleIdentifyElements174);
                    lv_elements_3_0=ruleElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_3_0, 
                            		"Element");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:126:2: ( (lv_elements_4_0= ruleElement ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:127:1: (lv_elements_4_0= ruleElement )
                    	    {
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:127:1: (lv_elements_4_0= ruleElement )
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:128:3: lv_elements_4_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleIdentifyElements195);
                    	    lv_elements_4_0=ruleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_4_0, 
                    	            		"Element");
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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:152:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:153:2: (iv_ruleElement= ruleElement EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:154:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement234);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement244); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:161:1: ruleElement returns [EObject current=null] : ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )? otherlv_8= ':' ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_att_6_0 = null;

        EObject lv_words_9_0 = null;

        EObject lv_words_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:164:28: ( ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )? otherlv_8= ':' ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )? ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:165:1: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )? otherlv_8= ':' ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )? )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:165:1: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )? otherlv_8= ':' ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )? )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:165:2: () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )? otherlv_8= ':' ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )?
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:165:2: ()
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:166:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement290); 

                	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getGreaterThanSignKeyword_1());
                
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:175:1: ( ( ruleEString ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:176:1: ( ruleEString )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:176:1: ( ruleEString )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:177:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleElement313);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:190:2: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:190:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElement326); 

                        	newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3_0());
                        
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:194:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:195:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:195:1: (otherlv_4= RULE_ID )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:196:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement346); 

                    		newLeafNode(otherlv_4, grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:207:4: (otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:207:6: otherlv_5= '(' ( (lv_att_6_0= ruleAttribute ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleElement361); 

                        	newLeafNode(otherlv_5, grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0());
                        
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:211:1: ( (lv_att_6_0= ruleAttribute ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:212:1: (lv_att_6_0= ruleAttribute )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:212:1: (lv_att_6_0= ruleAttribute )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:213:3: lv_att_6_0= ruleAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleElement382);
                    lv_att_6_0=ruleAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	        }
                           		set(
                           			current, 
                           			"att",
                            		lv_att_6_0, 
                            		"Attribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleElement394); 

                        	newLeafNode(otherlv_7, grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2());
                        

                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleElement408); 

                	newLeafNode(otherlv_8, grammarAccess.getElementAccess().getColonKeyword_5());
                
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:237:1: ( ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:237:2: ( (lv_words_9_0= ruleWord ) ) ( (lv_words_10_0= ruleWord ) )*
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:237:2: ( (lv_words_9_0= ruleWord ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:238:1: (lv_words_9_0= ruleWord )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:238:1: (lv_words_9_0= ruleWord )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:239:3: lv_words_9_0= ruleWord
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWord_in_ruleElement430);
                    lv_words_9_0=ruleWord();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	        }
                           		add(
                           			current, 
                           			"words",
                            		lv_words_9_0, 
                            		"Word");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:255:2: ( (lv_words_10_0= ruleWord ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)||LA5_0==19) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:256:1: (lv_words_10_0= ruleWord )
                    	    {
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:256:1: (lv_words_10_0= ruleWord )
                    	    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:257:3: lv_words_10_0= ruleWord
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWord_in_ruleElement451);
                    	    lv_words_10_0=ruleWord();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"words",
                    	            		lv_words_10_0, 
                    	            		"Word");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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


            }


            }

             leaveRule(); 
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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:281:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:282:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:283:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute490);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute500); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:290:1: ruleAttribute returns [EObject current=null] : ( () ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )? ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_negation_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:293:28: ( ( () ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )? ( (otherlv_3= RULE_ID ) ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:294:1: ( () ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )? ( (otherlv_3= RULE_ID ) ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:294:1: ( () ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )? ( (otherlv_3= RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:294:2: () ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )? ( (otherlv_3= RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:294:2: ()
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:295:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeAccess().getAttributeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:300:2: ( ( (lv_negation_1_0= 'yes' ) ) | otherlv_2= 'not' )?
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==18) ) {
                alt7=2;
            }
            switch (alt7) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:300:3: ( (lv_negation_1_0= 'yes' ) )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:300:3: ( (lv_negation_1_0= 'yes' ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:301:1: (lv_negation_1_0= 'yes' )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:301:1: (lv_negation_1_0= 'yes' )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:302:3: lv_negation_1_0= 'yes'
                    {
                    lv_negation_1_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAttribute553); 

                            newLeafNode(lv_negation_1_0, grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "negation", true, "yes");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:316:7: otherlv_2= 'not'
                    {
                    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAttribute584); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getNotKeyword_1_1());
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:320:3: ( (otherlv_3= RULE_ID ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:321:1: (otherlv_3= RULE_ID )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:321:1: (otherlv_3= RULE_ID )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:322:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute606); 

            		newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            	

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:341:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:342:2: (iv_ruleWord= ruleWord EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:343:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_entryRuleWord642);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWord652); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:350:1: ruleWord returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Variable_1 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:353:28: ( (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:354:1: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:354:1: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:355:5: this_Constant_0= ruleConstant
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConstant_in_ruleWord699);
                    this_Constant_0=ruleConstant();

                    state._fsp--;

                     
                            current = this_Constant_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:365:5: this_Variable_1= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleWord726);
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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:381:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:382:2: (iv_ruleConstant= ruleConstant EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:383:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstant_in_entryRuleConstant761);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstant771); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:390:1: ruleConstant returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEString ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:393:28: ( ( () ( (lv_value_1_0= ruleEString ) ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:394:1: ( () ( (lv_value_1_0= ruleEString ) ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:394:1: ( () ( (lv_value_1_0= ruleEString ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:394:2: () ( (lv_value_1_0= ruleEString ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:394:2: ()
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:395:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstantAccess().getConstantAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:400:2: ( (lv_value_1_0= ruleEString ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:401:1: (lv_value_1_0= ruleEString )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:401:1: (lv_value_1_0= ruleEString )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:402:3: lv_value_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConstant826);
            lv_value_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:426:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:427:2: (iv_ruleVariable= ruleVariable EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:428:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable862);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable872); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:435:1: ruleVariable returns [EObject current=null] : ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:438:28: ( ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:439:1: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:439:1: ( () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:439:2: () otherlv_1= '%' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )? ( (otherlv_4= RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:439:2: ()
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:440:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableAccess().getVariableAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVariable918); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getPercentSignKeyword_1());
                
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:449:1: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==13) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:449:2: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.'
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:449:2: ( (otherlv_2= RULE_ID ) )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:450:1: (otherlv_2= RULE_ID )
                    {
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:450:1: (otherlv_2= RULE_ID )
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:451:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable939); 

                    		newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
                    	

                    }


                    }

                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleVariable951); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getFullStopKeyword_2_1());
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:466:3: ( (otherlv_4= RULE_ID ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:467:1: (otherlv_4= RULE_ID )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:467:1: (otherlv_4= RULE_ID )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:468:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable973); 

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:487:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:488:2: (iv_ruleEString= ruleEString EOF )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:489:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString1010);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString1021); 

            }

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
    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:496:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:499:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:500:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:500:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:500:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString1061); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelText.g:508:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString1087); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleIdentifyElements_in_entryRuleIdentifyElements75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifyElements85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleIdentifyElements131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleIdentifyElements152 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleIdentifyElements174 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleIdentifyElements195 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleElement290 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleElement313 = new BitSet(new long[]{0x0000000000016000L});
        public static final BitSet FOLLOW_13_in_ruleElement326 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement346 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_14_in_ruleElement361 = new BitSet(new long[]{0x0000000000060010L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleElement382 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleElement394 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleElement408 = new BitSet(new long[]{0x0000000000080032L});
        public static final BitSet FOLLOW_ruleWord_in_ruleElement430 = new BitSet(new long[]{0x0000000000080032L});
        public static final BitSet FOLLOW_ruleWord_in_ruleElement451 = new BitSet(new long[]{0x0000000000080032L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleAttribute553 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_18_in_ruleAttribute584 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_entryRuleWord642 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWord652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_ruleWord699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleWord726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstant771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConstant826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable862 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleVariable918 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable939 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleVariable951 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1010 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString1021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString1061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString1087 = new BitSet(new long[]{0x0000000000000002L});
    }


}