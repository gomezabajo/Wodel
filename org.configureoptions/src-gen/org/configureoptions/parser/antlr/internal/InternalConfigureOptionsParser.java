package org.configureoptions.parser.antlr.internal; 

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
import org.configureoptions.services.ConfigureOptionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigureOptionsParser extends AbstractInternalAntlrParser {
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


        public InternalConfigureOptionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigureOptionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigureOptionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g"; }



     	private ConfigureOptionsGrammarAccess grammarAccess;
     	
        public InternalConfigureOptionsParser(TokenStream input, ConfigureOptionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Configuration";	
       	}
       	
       	@Override
       	protected ConfigureOptionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleConfiguration"
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:68:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:69:2: (iv_ruleConfiguration= ruleConfiguration EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:70:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration75);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration85); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:77:1: ruleConfiguration returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_options_3_0 = null;

        EObject lv_options_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:80:28: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )? )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:81:2: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )?
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:81:2: ()
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleConfiguration131); 

                	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getMetamodelKeyword_1());
                
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:91:1: ( (lv_metamodel_2_0= ruleEString ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:92:1: (lv_metamodel_2_0= ruleEString )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:92:1: (lv_metamodel_2_0= ruleEString )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:93:3: lv_metamodel_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConfiguration152);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:109:2: ( ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:109:3: ( (lv_options_3_0= ruleOption ) ) ( (lv_options_4_0= ruleOption ) )*
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:109:3: ( (lv_options_3_0= ruleOption ) )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:110:1: (lv_options_3_0= ruleOption )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:110:1: (lv_options_3_0= ruleOption )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:111:3: lv_options_3_0= ruleOption
                    {
                     
                    	        newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOption_in_ruleConfiguration174);
                    lv_options_3_0=ruleOption();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	        }
                           		add(
                           			current, 
                           			"options",
                            		lv_options_3_0, 
                            		"Option");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:127:2: ( (lv_options_4_0= ruleOption ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:128:1: (lv_options_4_0= ruleOption )
                    	    {
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:128:1: (lv_options_4_0= ruleOption )
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:129:3: lv_options_4_0= ruleOption
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOption_in_ruleConfiguration195);
                    	    lv_options_4_0=ruleOption();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"options",
                    	            		lv_options_4_0, 
                    	            		"Option");
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:153:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:154:2: (iv_ruleOption= ruleOption EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:155:2: iv_ruleOption= ruleOption EOF
            {
             newCompositeNode(grammarAccess.getOptionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOption_in_entryRuleOption234);
            iv_ruleOption=ruleOption();

            state._fsp--;

             current =iv_ruleOption; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOption244); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:162:1: ruleOption returns [EObject current=null] : ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) ) ;
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
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:165:28: ( ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:166:1: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:166:1: ( () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:166:2: () otherlv_1= '>' ( ( ruleEString ) ) (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )? otherlv_6= ':' ( (lv_valid_7_0= ruleText ) ) otherlv_8= '/' ( (lv_invalid_9_0= ruleText ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:166:2: ()
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:167:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionAccess().getOptionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleOption290); 

                	newLeafNode(otherlv_1, grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1());
                
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:176:1: ( ( ruleEString ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:177:1: ( ruleEString )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:177:1: ( ruleEString )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:178:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleOption313);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:191:2: (otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:191:4: otherlv_3= '(' ( ( ruleEString ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOption326); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:195:1: ( ( ruleEString ) )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:196:1: ( ruleEString )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:196:1: ( ruleEString )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:197:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleOption349);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOption361); 

                        	newLeafNode(otherlv_5, grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOption375); 

                	newLeafNode(otherlv_6, grammarAccess.getOptionAccess().getColonKeyword_4());
                
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:218:1: ( (lv_valid_7_0= ruleText ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:219:1: (lv_valid_7_0= ruleText )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:219:1: (lv_valid_7_0= ruleText )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:220:3: lv_valid_7_0= ruleText
            {
             
            	        newCompositeNode(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleText_in_ruleOption396);
            lv_valid_7_0=ruleText();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionRule());
            	        }
                   		set(
                   			current, 
                   			"valid",
                    		lv_valid_7_0, 
                    		"Text");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOption408); 

                	newLeafNode(otherlv_8, grammarAccess.getOptionAccess().getSolidusKeyword_6());
                
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:240:1: ( (lv_invalid_9_0= ruleText ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:241:1: (lv_invalid_9_0= ruleText )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:241:1: (lv_invalid_9_0= ruleText )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:242:3: lv_invalid_9_0= ruleText
            {
             
            	        newCompositeNode(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleText_in_ruleOption429);
            lv_invalid_9_0=ruleText();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionRule());
            	        }
                   		set(
                   			current, 
                   			"invalid",
                    		lv_invalid_9_0, 
                    		"Text");
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:266:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:267:2: (iv_ruleText= ruleText EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:268:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleText_in_entryRuleText465);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleText475); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:275:1: ruleText returns [EObject current=null] : ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        EObject lv_words_1_0 = null;

        EObject lv_words_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:278:28: ( ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:279:1: ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:279:1: ( () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )? )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:279:2: () ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )?
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:279:2: ()
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:280:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTextAccess().getTextAction_0(),
                        current);
                

            }

            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:285:2: ( ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)||(LA5_0>=17 && LA5_0<=38)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:285:3: ( (lv_words_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )*
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:285:3: ( (lv_words_1_0= ruleWord ) )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:286:1: (lv_words_1_0= ruleWord )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:286:1: (lv_words_1_0= ruleWord )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:287:3: lv_words_1_0= ruleWord
                    {
                     
                    	        newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWord_in_ruleText531);
                    lv_words_1_0=ruleWord();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTextRule());
                    	        }
                           		add(
                           			current, 
                           			"words",
                            		lv_words_1_0, 
                            		"Word");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:303:2: ( (lv_words_2_0= ruleWord ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)||(LA4_0>=17 && LA4_0<=38)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:304:1: (lv_words_2_0= ruleWord )
                    	    {
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:304:1: (lv_words_2_0= ruleWord )
                    	    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:305:3: lv_words_2_0= ruleWord
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWord_in_ruleText552);
                    	    lv_words_2_0=ruleWord();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTextRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"words",
                    	            		lv_words_2_0, 
                    	            		"Word");
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:329:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:330:2: (iv_ruleWord= ruleWord EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:331:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_entryRuleWord591);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWord601); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:338:1: ruleWord returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Variable_1 = null;


         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:341:28: ( (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:342:1: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:342:1: (this_Constant_0= ruleConstant | this_Variable_1= ruleVariable )
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
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:343:5: this_Constant_0= ruleConstant
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConstant_in_ruleWord648);
                    this_Constant_0=ruleConstant();

                    state._fsp--;

                     
                            current = this_Constant_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:353:5: this_Variable_1= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleWord675);
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:369:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:370:2: (iv_ruleConstant= ruleConstant EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:371:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstant_in_entryRuleConstant710);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstant720); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:378:1: ruleConstant returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEString ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:381:28: ( ( () ( (lv_value_1_0= ruleEString ) ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:382:1: ( () ( (lv_value_1_0= ruleEString ) ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:382:1: ( () ( (lv_value_1_0= ruleEString ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:382:2: () ( (lv_value_1_0= ruleEString ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:382:2: ()
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:383:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstantAccess().getConstantAction_0(),
                        current);
                

            }

            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:388:2: ( (lv_value_1_0= ruleEString ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:389:1: (lv_value_1_0= ruleEString )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:389:1: (lv_value_1_0= ruleEString )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:390:3: lv_value_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConstant775);
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:414:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:415:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:416:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable811);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable821); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:423:1: ruleVariable returns [EObject current=null] : ( () ( (lv_type_1_0= ruleVariableType ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:426:28: ( ( () ( (lv_type_1_0= ruleVariableType ) ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:427:1: ( () ( (lv_type_1_0= ruleVariableType ) ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:427:1: ( () ( (lv_type_1_0= ruleVariableType ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:427:2: () ( (lv_type_1_0= ruleVariableType ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:427:2: ()
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:428:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableAccess().getVariableAction_0(),
                        current);
                

            }

            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:433:2: ( (lv_type_1_0= ruleVariableType ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:434:1: (lv_type_1_0= ruleVariableType )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:434:1: (lv_type_1_0= ruleVariableType )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:435:3: lv_type_1_0= ruleVariableType
            {
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleVariableType_in_ruleVariable876);
            lv_type_1_0=ruleVariableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"VariableType");
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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:459:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:460:2: (iv_ruleEString= ruleEString EOF )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:461:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString913);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString924); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:468:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:471:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:472:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:472:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:472:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString964); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:480:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString990); 

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
    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:495:1: ruleVariableType returns [Enumerator current=null] : ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) ) ;
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
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:497:28: ( ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) ) )
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:498:1: ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) )
            {
            // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:498:1: ( (enumLiteral_0= '%object' ) | (enumLiteral_1= '%attName' ) | (enumLiteral_2= '%oldValue' ) | (enumLiteral_3= '%newValue' ) | (enumLiteral_4= '%refName' ) | (enumLiteral_5= '%fromObject' ) | (enumLiteral_6= '%oldFromObject' ) | (enumLiteral_7= '%srcRefName' ) | (enumLiteral_8= '%toObject' ) | (enumLiteral_9= '%oldToObject' ) | (enumLiteral_10= '%firstRefName' ) | (enumLiteral_11= '%firstObject' ) | (enumLiteral_12= '%firstFromObject' ) | (enumLiteral_13= '%firstToObject' ) | (enumLiteral_14= '%secondRefName' ) | (enumLiteral_15= '%secondObject' ) | (enumLiteral_16= '%secondFromObject' ) | (enumLiteral_17= '%secondToObject' ) | (enumLiteral_18= '%firstAttName' ) | (enumLiteral_19= '%firstValue' ) | (enumLiteral_20= '%secondAttName' ) | (enumLiteral_21= '%secondValue' ) )
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
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:498:2: (enumLiteral_0= '%object' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:498:2: (enumLiteral_0= '%object' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:498:4: enumLiteral_0= '%object'
                    {
                    enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleVariableType1049); 

                            current = grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:504:6: (enumLiteral_1= '%attName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:504:6: (enumLiteral_1= '%attName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:504:8: enumLiteral_1= '%attName'
                    {
                    enumLiteral_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleVariableType1066); 

                            current = grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:510:6: (enumLiteral_2= '%oldValue' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:510:6: (enumLiteral_2= '%oldValue' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:510:8: enumLiteral_2= '%oldValue'
                    {
                    enumLiteral_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVariableType1083); 

                            current = grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:516:6: (enumLiteral_3= '%newValue' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:516:6: (enumLiteral_3= '%newValue' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:516:8: enumLiteral_3= '%newValue'
                    {
                    enumLiteral_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleVariableType1100); 

                            current = grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:522:6: (enumLiteral_4= '%refName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:522:6: (enumLiteral_4= '%refName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:522:8: enumLiteral_4= '%refName'
                    {
                    enumLiteral_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleVariableType1117); 

                            current = grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:528:6: (enumLiteral_5= '%fromObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:528:6: (enumLiteral_5= '%fromObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:528:8: enumLiteral_5= '%fromObject'
                    {
                    enumLiteral_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleVariableType1134); 

                            current = grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:534:6: (enumLiteral_6= '%oldFromObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:534:6: (enumLiteral_6= '%oldFromObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:534:8: enumLiteral_6= '%oldFromObject'
                    {
                    enumLiteral_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleVariableType1151); 

                            current = grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:540:6: (enumLiteral_7= '%srcRefName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:540:6: (enumLiteral_7= '%srcRefName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:540:8: enumLiteral_7= '%srcRefName'
                    {
                    enumLiteral_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleVariableType1168); 

                            current = grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:546:6: (enumLiteral_8= '%toObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:546:6: (enumLiteral_8= '%toObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:546:8: enumLiteral_8= '%toObject'
                    {
                    enumLiteral_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleVariableType1185); 

                            current = grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:552:6: (enumLiteral_9= '%oldToObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:552:6: (enumLiteral_9= '%oldToObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:552:8: enumLiteral_9= '%oldToObject'
                    {
                    enumLiteral_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleVariableType1202); 

                            current = grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:558:6: (enumLiteral_10= '%firstRefName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:558:6: (enumLiteral_10= '%firstRefName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:558:8: enumLiteral_10= '%firstRefName'
                    {
                    enumLiteral_10=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVariableType1219); 

                            current = grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:564:6: (enumLiteral_11= '%firstObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:564:6: (enumLiteral_11= '%firstObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:564:8: enumLiteral_11= '%firstObject'
                    {
                    enumLiteral_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVariableType1236); 

                            current = grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:570:6: (enumLiteral_12= '%firstFromObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:570:6: (enumLiteral_12= '%firstFromObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:570:8: enumLiteral_12= '%firstFromObject'
                    {
                    enumLiteral_12=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleVariableType1253); 

                            current = grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:576:6: (enumLiteral_13= '%firstToObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:576:6: (enumLiteral_13= '%firstToObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:576:8: enumLiteral_13= '%firstToObject'
                    {
                    enumLiteral_13=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVariableType1270); 

                            current = grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_13, grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 
                        

                    }


                    }
                    break;
                case 15 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:582:6: (enumLiteral_14= '%secondRefName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:582:6: (enumLiteral_14= '%secondRefName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:582:8: enumLiteral_14= '%secondRefName'
                    {
                    enumLiteral_14=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVariableType1287); 

                            current = grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_14, grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:588:6: (enumLiteral_15= '%secondObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:588:6: (enumLiteral_15= '%secondObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:588:8: enumLiteral_15= '%secondObject'
                    {
                    enumLiteral_15=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVariableType1304); 

                            current = grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_15, grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:594:6: (enumLiteral_16= '%secondFromObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:594:6: (enumLiteral_16= '%secondFromObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:594:8: enumLiteral_16= '%secondFromObject'
                    {
                    enumLiteral_16=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleVariableType1321); 

                            current = grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_16, grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:600:6: (enumLiteral_17= '%secondToObject' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:600:6: (enumLiteral_17= '%secondToObject' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:600:8: enumLiteral_17= '%secondToObject'
                    {
                    enumLiteral_17=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVariableType1338); 

                            current = grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_17, grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:606:6: (enumLiteral_18= '%firstAttName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:606:6: (enumLiteral_18= '%firstAttName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:606:8: enumLiteral_18= '%firstAttName'
                    {
                    enumLiteral_18=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleVariableType1355); 

                            current = grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_18, grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:612:6: (enumLiteral_19= '%firstValue' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:612:6: (enumLiteral_19= '%firstValue' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:612:8: enumLiteral_19= '%firstValue'
                    {
                    enumLiteral_19=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleVariableType1372); 

                            current = grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_19, grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:618:6: (enumLiteral_20= '%secondAttName' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:618:6: (enumLiteral_20= '%secondAttName' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:618:8: enumLiteral_20= '%secondAttName'
                    {
                    enumLiteral_20=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVariableType1389); 

                            current = grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_20, grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 
                        

                    }


                    }
                    break;
                case 22 :
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:624:6: (enumLiteral_21= '%secondValue' )
                    {
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:624:6: (enumLiteral_21= '%secondValue' )
                    // ../org.configureoptions/src-gen/org/configureoptions/parser/antlr/internal/InternalConfigureOptions.g:624:8: enumLiteral_21= '%secondValue'
                    {
                    enumLiteral_21=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleVariableType1406); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleConfiguration131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConfiguration152 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleOption_in_ruleConfiguration174 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleOption_in_ruleConfiguration195 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleOption_in_entryRuleOption234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOption244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleOption290 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleOption313 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_13_in_ruleOption326 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleOption349 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOption361 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOption375 = new BitSet(new long[]{0x0000007FFFFF0030L});
        public static final BitSet FOLLOW_ruleText_in_ruleOption396 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOption408 = new BitSet(new long[]{0x0000007FFFFE0030L});
        public static final BitSet FOLLOW_ruleText_in_ruleOption429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleText_in_entryRuleText465 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleText475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_ruleText531 = new BitSet(new long[]{0x0000007FFFFE0032L});
        public static final BitSet FOLLOW_ruleWord_in_ruleText552 = new BitSet(new long[]{0x0000007FFFFE0032L});
        public static final BitSet FOLLOW_ruleWord_in_entryRuleWord591 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWord601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_ruleWord648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleWord675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstant720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConstant775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableType_in_ruleVariable876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleVariableType1049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleVariableType1066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleVariableType1083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleVariableType1100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleVariableType1117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleVariableType1134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleVariableType1151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleVariableType1168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleVariableType1185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleVariableType1202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleVariableType1219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVariableType1236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleVariableType1253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleVariableType1270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleVariableType1287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleVariableType1304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleVariableType1321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVariableType1338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleVariableType1355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleVariableType1372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleVariableType1389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleVariableType1406 = new BitSet(new long[]{0x0000000000000002L});
    }


}