package wodel.dsls.parser.antlr.internal; 

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
import wodel.dsls.services.AspleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAspleParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'begin'", "';'", "'end'", "'ref'", "','", "'-'", "'true'", "'false'", "'.'", "'E'", "'e'", "'='", "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'while'", "'repeat'", "'until'", "'input'", "'output'", "'+'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'<'", "'int'", "'bool'", "'double'"
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
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
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


        public InternalAspleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAspleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAspleParser.tokenNames; }
    public String getGrammarFileName() { return "../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g"; }



     	private AspleGrammarAccess grammarAccess;
     	
        public InternalAspleParser(TokenStream input, AspleGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected AspleGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:68:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:69:2: (iv_ruleProgram= ruleProgram EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:70:2: iv_ruleProgram= ruleProgram EOF
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
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:77:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declarations_2_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:80:28: ( ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:81:1: ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:81:1: ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:81:2: () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end'
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:81:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgramAccess().getProgramAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleProgram131); 

                	newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getBeginKeyword_1());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:91:1: ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==12||LA1_1==15) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0==RULE_STRING||LA1_0==14||(LA1_0>=42 && LA1_0<=44)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:91:2: ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';'
            	    {
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:91:2: ( (lv_declarations_2_0= ruleDeclaration ) )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:92:1: (lv_declarations_2_0= ruleDeclaration )
            	    {
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:92:1: (lv_declarations_2_0= ruleDeclaration )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:93:3: lv_declarations_2_0= ruleDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProgramAccess().getDeclarationsDeclarationParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleDeclaration_in_ruleProgram153);
            	    lv_declarations_2_0=ruleDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_2_0, 
            	            		"Declaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleProgram165); 

            	        	newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getSemicolonKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:113:3: ( (lv_statements_4_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==23||(LA2_0>=29 && LA2_0<=30)||LA2_0==32) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:114:1: (lv_statements_4_0= ruleStatement )
            	    {
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:114:1: (lv_statements_4_0= ruleStatement )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:115:3: lv_statements_4_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleProgram188);
            	    lv_statements_4_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_4_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProgram201); 

                	newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getEndKeyword_4());
                

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


    // $ANTLR start "entryRuleDeclaration"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:143:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:144:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:145:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDeclaration_in_entryRuleDeclaration237);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDeclaration247); 

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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:152:1: ruleDeclaration returns [EObject current=null] : ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;
        Token otherlv_4=null;
        Enumerator lv_mode_2_0 = null;

        EObject lv_identifiers_3_0 = null;

        EObject lv_identifiers_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:155:28: ( ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:156:1: ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:156:1: ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:156:2: () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )*
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:156:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:157:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDeclarationAccess().getDeclarationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:162:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:163:1: (lv_ref_1_0= 'ref' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:163:1: (lv_ref_1_0= 'ref' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:164:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDeclaration299); 

                            newLeafNode(lv_ref_1_0, grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDeclarationRule());
                    	        }
                           		setWithLastConsumed(current, "ref", true, "ref");
                    	    

                    }


                    }
                    break;

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:177:3: ( (lv_mode_2_0= ruleMode ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=42 && LA4_0<=44)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:178:1: (lv_mode_2_0= ruleMode )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:178:1: (lv_mode_2_0= ruleMode )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:179:3: lv_mode_2_0= ruleMode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclarationAccess().getModeModeEnumRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMode_in_ruleDeclaration334);
                    lv_mode_2_0=ruleMode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"mode",
                            		lv_mode_2_0, 
                            		"Mode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:195:3: ( (lv_identifiers_3_0= ruleIdentifier ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:196:1: (lv_identifiers_3_0= ruleIdentifier )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:196:1: (lv_identifiers_3_0= ruleIdentifier )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:197:3: lv_identifiers_3_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleDeclaration356);
            lv_identifiers_3_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	        }
                   		add(
                   			current, 
                   			"identifiers",
                    		lv_identifiers_3_0, 
                    		"Identifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:213:2: (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:213:4: otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDeclaration369); 

            	        	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:217:1: ( (lv_identifiers_5_0= ruleIdentifier ) )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:218:1: (lv_identifiers_5_0= ruleIdentifier )
            	    {
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:218:1: (lv_identifiers_5_0= ruleIdentifier )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:219:3: lv_identifiers_5_0= ruleIdentifier
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleDeclaration390);
            	    lv_identifiers_5_0=ruleIdentifier();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"identifiers",
            	            		lv_identifiers_5_0, 
            	            		"Identifier");
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleEString"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:243:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:244:2: (iv_ruleEString= ruleEString EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:245:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString429);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString440); 

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
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:252:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:255:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:256:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:256:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:256:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString480); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:264:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString506); 

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


    // $ANTLR start "entryRuleEInt"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:279:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:280:2: (iv_ruleEInt= ruleEInt EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:281:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt552);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt563); 

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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:288:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:291:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:292:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:292:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:292:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:292:2: (kw= '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:293:2: kw= '-'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEInt602); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt619); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEBoolean"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:313:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:314:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:315:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean665);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean676); 

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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:322:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:325:28: ( (kw= 'true' | kw= 'false' ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:326:1: (kw= 'true' | kw= 'false' )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:326:1: (kw= 'true' | kw= 'false' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:327:2: kw= 'true'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEBoolean714); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:334:2: kw= 'false'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEBoolean733); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                        

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEDouble"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:347:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:348:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:349:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble774);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble785); 

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
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:356:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:359:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:360:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:360:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:360:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:360:2: (kw= '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:361:2: kw= '-'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEDouble824); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:366:3: (this_INT_1= RULE_INT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:366:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble842); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEDouble862); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble877); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:386:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=20 && LA13_0<=21)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:386:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:386:2: (kw= 'E' | kw= 'e' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==20) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==21) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:387:2: kw= 'E'
                            {
                            kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEDouble897); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:394:2: kw= 'e'
                            {
                            kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEDouble916); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:399:2: (kw= '-' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==16) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:400:2: kw= '-'
                            {
                            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEDouble931); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble948); 

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


    // $ANTLR start "entryRuleIdentifier"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:420:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:421:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:422:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier995);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier1005); 

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:429:1: ruleIdentifier returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:432:28: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:433:1: ( () ( (lv_name_1_0= ruleEString ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:433:1: ( () ( (lv_name_1_0= ruleEString ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:433:2: () ( (lv_name_1_0= ruleEString ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:433:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:434:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIdentifierAccess().getIdentifierAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:439:2: ( (lv_name_1_0= ruleEString ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:440:1: (lv_name_1_0= ruleEString )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:440:1: (lv_name_1_0= ruleEString )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:441:3: lv_name_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleIdentifier1060);
            lv_name_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIdentifierRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLiteral"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:465:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:466:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:467:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_entryRuleLiteral1096);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteral1106); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:474:1: ruleLiteral returns [EObject current=null] : (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_Integer_0 = null;

        EObject this_Boolean_1 = null;

        EObject this_Double_2 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:477:28: ( (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:478:1: (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:478:1: (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_INT) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==EOF||LA14_2==RULE_ID||(LA14_2>=12 && LA14_2<=13)||LA14_2==16||LA14_2==23||LA14_2==25||LA14_2==27||(LA14_2>=29 && LA14_2<=30)||LA14_2==32||(LA14_2>=34 && LA14_2<=41)) ) {
                        alt14=1;
                    }
                    else if ( (LA14_2==19) ) {
                        alt14=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA14_1==19) ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==EOF||LA14_2==RULE_ID||(LA14_2>=12 && LA14_2<=13)||LA14_2==16||LA14_2==23||LA14_2==25||LA14_2==27||(LA14_2>=29 && LA14_2<=30)||LA14_2==32||(LA14_2>=34 && LA14_2<=41)) ) {
                    alt14=1;
                }
                else if ( (LA14_2==19) ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case 17:
            case 18:
                {
                alt14=2;
                }
                break;
            case 19:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:479:5: this_Integer_0= ruleInteger
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getIntegerParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInteger_in_ruleLiteral1153);
                    this_Integer_0=ruleInteger();

                    state._fsp--;

                     
                            current = this_Integer_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:489:5: this_Boolean_1= ruleBoolean
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleLiteral1180);
                    this_Boolean_1=ruleBoolean();

                    state._fsp--;

                     
                            current = this_Boolean_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:499:5: this_Double_2= ruleDouble
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDoubleParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDouble_in_ruleLiteral1207);
                    this_Double_2=ruleDouble();

                    state._fsp--;

                     
                            current = this_Double_2; 
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleInteger"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:515:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:516:2: (iv_ruleInteger= ruleInteger EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:517:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInteger_in_entryRuleInteger1242);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInteger1252); 

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
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:524:1: ruleInteger returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEInt ) ) ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:527:28: ( ( () ( (lv_value_1_0= ruleEInt ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:528:1: ( () ( (lv_value_1_0= ruleEInt ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:528:1: ( () ( (lv_value_1_0= ruleEInt ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:528:2: () ( (lv_value_1_0= ruleEInt ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:528:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:529:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntegerAccess().getIntegerAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:534:2: ( (lv_value_1_0= ruleEInt ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:535:1: (lv_value_1_0= ruleEInt )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:535:1: (lv_value_1_0= ruleEInt )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:536:3: lv_value_1_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleInteger1307);
            lv_value_1_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntegerRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"EInt");
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
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleBoolean"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:560:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:561:2: (iv_ruleBoolean= ruleBoolean EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:562:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1343);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1353); 

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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:569:1: ruleBoolean returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:572:28: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:573:1: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:573:1: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:573:2: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:573:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:574:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanAccess().getBooleanAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:579:2: ( (lv_value_1_0= ruleEBoolean ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:580:1: (lv_value_1_0= ruleEBoolean )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:580:1: (lv_value_1_0= ruleEBoolean )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:581:3: lv_value_1_0= ruleEBoolean
            {
             
            	        newCompositeNode(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleBoolean1408);
            lv_value_1_0=ruleEBoolean();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBooleanRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"EBoolean");
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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleDouble"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:605:1: entryRuleDouble returns [EObject current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final EObject entryRuleDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDouble = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:606:2: (iv_ruleDouble= ruleDouble EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:607:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDouble_in_entryRuleDouble1444);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDouble1454); 

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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:614:1: ruleDouble returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:617:28: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:618:1: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:618:1: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:618:2: () ( (lv_value_1_0= ruleEDouble ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:618:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:619:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDoubleAccess().getDoubleAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:624:2: ( (lv_value_1_0= ruleEDouble ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:625:1: (lv_value_1_0= ruleEDouble )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:625:1: (lv_value_1_0= ruleEDouble )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:626:3: lv_value_1_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleDouble1509);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDoubleRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"EDouble");
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
    // $ANTLR end "ruleDouble"


    // $ANTLR start "entryRuleStatement"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:650:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:651:2: (iv_ruleStatement= ruleStatement EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:652:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_entryRuleStatement1545);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatement1555); 

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:659:1: ruleStatement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_Conditional_1 = null;

        EObject this_Loop_2 = null;

        EObject this_Transput_3 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:662:28: ( (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:663:1: (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:663:1: (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput )
            int alt15=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt15=1;
                }
                break;
            case 23:
                {
                alt15=2;
                }
                break;
            case 29:
            case 30:
                {
                alt15=3;
                }
                break;
            case 32:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:664:5: this_Assignment_0= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleStatement1602);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:674:5: this_Conditional_1= ruleConditional
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getConditionalParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConditional_in_ruleStatement1629);
                    this_Conditional_1=ruleConditional();

                    state._fsp--;

                     
                            current = this_Conditional_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:684:5: this_Loop_2= ruleLoop
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getLoopParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleStatement1656);
                    this_Loop_2=ruleLoop();

                    state._fsp--;

                     
                            current = this_Loop_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:694:5: this_Transput_3= ruleTransput
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getTransputParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTransput_in_ruleStatement1683);
                    this_Transput_3=ruleTransput();

                    state._fsp--;

                     
                            current = this_Transput_3; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAssignment"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:710:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:711:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:712:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1718);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment1728); 

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:719:1: ruleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:722:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:723:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:723:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:723:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:723:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:724:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:724:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:725:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment1773); 

            		newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getVarIdentifierCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignment1785); 

                	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:740:1: ( (lv_value_2_0= ruleExpression ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:741:1: (lv_value_2_0= ruleExpression )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:741:1: (lv_value_2_0= ruleExpression )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:742:3: lv_value_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAssignment1806);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAssignment1818); 

                	newLeafNode(otherlv_3, grammarAccess.getAssignmentAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleConditional"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:770:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:771:2: (iv_ruleConditional= ruleConditional EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:772:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConditional_in_entryRuleConditional1854);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConditional1864); 

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
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:779:1: ruleConditional returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? ) ;
    public final EObject ruleConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_expression_3_0 = null;

        EObject lv_if_6_0 = null;

        EObject lv_else_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:782:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:783:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:783:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:783:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )?
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:783:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:784:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConditionalAccess().getConditionalAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleConditional1910); 

                	newLeafNode(otherlv_1, grammarAccess.getConditionalAccess().getIfKeyword_1());
                
            otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleConditional1922); 

                	newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:797:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:798:1: (lv_expression_3_0= ruleExpression )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:798:1: (lv_expression_3_0= ruleExpression )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:799:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleConditional1943);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_3_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleConditional1955); 

                	newLeafNode(otherlv_4, grammarAccess.getConditionalAccess().getRightParenthesisKeyword_4());
                
            otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConditional1967); 

                	newLeafNode(otherlv_5, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_5());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:823:1: ( (lv_if_6_0= ruleStatement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==23||(LA16_0>=29 && LA16_0<=30)||LA16_0==32) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:824:1: (lv_if_6_0= ruleStatement )
            	    {
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:824:1: (lv_if_6_0= ruleStatement )
            	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:825:3: lv_if_6_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalAccess().getIfStatementParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleConditional1988);
            	    lv_if_6_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"if",
            	            		lv_if_6_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleConditional2001); 

                	newLeafNode(otherlv_7, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:845:1: (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:845:3: otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleConditional2014); 

                        	newLeafNode(otherlv_8, grammarAccess.getConditionalAccess().getElseKeyword_8_0());
                        
                    otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConditional2026); 

                        	newLeafNode(otherlv_9, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:853:1: ( (lv_else_10_0= ruleStatement ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID||LA17_0==23||(LA17_0>=29 && LA17_0<=30)||LA17_0==32) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:854:1: (lv_else_10_0= ruleStatement )
                    	    {
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:854:1: (lv_else_10_0= ruleStatement )
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:855:3: lv_else_10_0= ruleStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConditionalAccess().getElseStatementParserRuleCall_8_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleConditional2047);
                    	    lv_else_10_0=ruleStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConditionalRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"else",
                    	            		lv_else_10_0, 
                    	            		"Statement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleConditional2060); 

                        	newLeafNode(otherlv_11, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_8_3());
                        

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
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleLoop"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:883:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:884:2: (iv_ruleLoop= ruleLoop EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:885:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop2098);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop2108); 

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
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:892:1: ruleLoop returns [EObject current=null] : ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_expression_3_0 = null;

        EObject lv_statements_6_0 = null;

        EObject lv_statements_10_0 = null;

        EObject lv_expression_14_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:895:28: ( ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:1: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:1: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            else if ( (LA21_0==30) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}'
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:896:3: ()
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:897:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLoopAccess().getLoopAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleLoop2155); 

                        	newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getWhileKeyword_0_1());
                        
                    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLoop2167); 

                        	newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_0_2());
                        
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:910:1: ( (lv_expression_3_0= ruleExpression ) )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:911:1: (lv_expression_3_0= ruleExpression )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:911:1: (lv_expression_3_0= ruleExpression )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:912:3: lv_expression_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_0_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleLoop2188);
                    lv_expression_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoopRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop2200); 

                        	newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightParenthesisKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop2212); 

                        	newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_0_5());
                        
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:936:1: ( (lv_statements_6_0= ruleStatement ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID||LA19_0==23||(LA19_0>=29 && LA19_0<=30)||LA19_0==32) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:937:1: (lv_statements_6_0= ruleStatement )
                    	    {
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:937:1: (lv_statements_6_0= ruleStatement )
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:938:3: lv_statements_6_0= ruleStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_0_6_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleLoop2233);
                    	    lv_statements_6_0=ruleStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLoopRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"statements",
                    	            		lv_statements_6_0, 
                    	            		"Statement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleLoop2246); 

                        	newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_0_7());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:959:6: (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:959:6: (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:959:8: otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')'
                    {
                    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleLoop2266); 

                        	newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getRepeatKeyword_1_0());
                        
                    otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop2278); 

                        	newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1_1());
                        
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:967:1: ( (lv_statements_10_0= ruleStatement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||LA20_0==23||(LA20_0>=29 && LA20_0<=30)||LA20_0==32) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:968:1: (lv_statements_10_0= ruleStatement )
                    	    {
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:968:1: (lv_statements_10_0= ruleStatement )
                    	    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:969:3: lv_statements_10_0= ruleStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_1_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleLoop2299);
                    	    lv_statements_10_0=ruleStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLoopRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"statements",
                    	            		lv_statements_10_0, 
                    	            		"Statement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleLoop2312); 

                        	newLeafNode(otherlv_11, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_1_3());
                        
                    otherlv_12=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLoop2324); 

                        	newLeafNode(otherlv_12, grammarAccess.getLoopAccess().getUntilKeyword_1_4());
                        
                    otherlv_13=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLoop2336); 

                        	newLeafNode(otherlv_13, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1_5());
                        
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:997:1: ( (lv_expression_14_0= ruleExpression ) )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:998:1: (lv_expression_14_0= ruleExpression )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:998:1: (lv_expression_14_0= ruleExpression )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:999:3: lv_expression_14_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleLoop2357);
                    lv_expression_14_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoopRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_14_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop2369); 

                        	newLeafNode(otherlv_15, grammarAccess.getLoopAccess().getRightParenthesisKeyword_1_7());
                        

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
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleTransput"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1027:1: entryRuleTransput returns [EObject current=null] : iv_ruleTransput= ruleTransput EOF ;
    public final EObject entryRuleTransput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransput = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1028:2: (iv_ruleTransput= ruleTransput EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1029:2: iv_ruleTransput= ruleTransput EOF
            {
             newCompositeNode(grammarAccess.getTransputRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransput_in_entryRuleTransput2406);
            iv_ruleTransput=ruleTransput();

            state._fsp--;

             current =iv_ruleTransput; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransput2416); 

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
    // $ANTLR end "entryRuleTransput"


    // $ANTLR start "ruleTransput"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1036:1: ruleTransput returns [EObject current=null] : ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleTransput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1039:28: ( ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1040:1: ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1040:1: ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1040:2: () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1040:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1041:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTransputAccess().getTransputAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTransput2462); 

                	newLeafNode(otherlv_1, grammarAccess.getTransputAccess().getInputKeyword_1());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1050:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1051:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1051:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1052:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransputRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransput2482); 

            		newLeafNode(otherlv_2, grammarAccess.getTransputAccess().getVarIdentifierCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleTransput2494); 

                	newLeafNode(otherlv_3, grammarAccess.getTransputAccess().getOutputKeyword_3());
                
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1067:1: ( (lv_expression_4_0= ruleExpression ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1068:1: (lv_expression_4_0= ruleExpression )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1068:1: (lv_expression_4_0= ruleExpression )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1069:3: lv_expression_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleTransput2515);
            lv_expression_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransputRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_4_0, 
                    		"Expression");
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
    // $ANTLR end "ruleTransput"


    // $ANTLR start "entryRuleExpression"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1093:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1094:2: (iv_ruleExpression= ruleExpression EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1095:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression2551);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression2561); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1102:1: ruleExpression returns [EObject current=null] : (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Primary_0 = null;

        EObject this_BinaryOperator_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1105:28: ( (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1106:1: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1106:1: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1107:5: this_Primary_0= rulePrimary
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression2608);
                    this_Primary_0=rulePrimary();

                    state._fsp--;

                     
                            current = this_Primary_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1117:5: this_BinaryOperator_1= ruleBinaryOperator
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getBinaryOperatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_ruleExpression2635);
                    this_BinaryOperator_1=ruleBinaryOperator();

                    state._fsp--;

                     
                            current = this_BinaryOperator_1; 
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimary"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1133:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1134:2: (iv_rulePrimary= rulePrimary EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1135:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_entryRulePrimary2670);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimary2680); 

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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1142:1: rulePrimary returns [EObject current=null] : (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        EObject this_Identifier_0 = null;

        EObject this_Literal_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1145:28: ( (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1146:1: (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1146:1: (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_INT||(LA23_0>=16 && LA23_0<=19)) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1147:5: this_Identifier_0= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getIdentifierParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rulePrimary2727);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;

                     
                            current = this_Identifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1157:5: this_Literal_1= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_rulePrimary2754);
                    this_Literal_1=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_1; 
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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleBinaryOperator"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1173:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1174:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1175:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator2789);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperator2799); 

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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1182:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        Token lv_operator_2_7=null;
        Token lv_operator_2_8=null;
        Token lv_operator_2_9=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1185:28: ( ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1186:1: ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1186:1: ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1186:2: () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1186:2: ()
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1187:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
                        current);
                

            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1192:2: ( (lv_left_1_0= rulePrimary ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1193:1: (lv_left_1_0= rulePrimary )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1193:1: (lv_left_1_0= rulePrimary )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1194:3: lv_left_1_0= rulePrimary
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getLeftPrimaryParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleBinaryOperator2854);
            lv_left_1_0=rulePrimary();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"left",
                    		lv_left_1_0, 
                    		"Primary");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1210:2: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1211:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1211:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1212:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1212:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' )
            int alt24=9;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt24=1;
                }
                break;
            case 16:
                {
                alt24=2;
                }
                break;
            case 35:
                {
                alt24=3;
                }
                break;
            case 36:
                {
                alt24=4;
                }
                break;
            case 37:
                {
                alt24=5;
                }
                break;
            case 38:
                {
                alt24=6;
                }
                break;
            case 39:
                {
                alt24=7;
                }
                break;
            case 40:
                {
                alt24=8;
                }
                break;
            case 41:
                {
                alt24=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1213:3: lv_operator_2_1= '+'
                    {
                    lv_operator_2_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleBinaryOperator2874); 

                            newLeafNode(lv_operator_2_1, grammarAccess.getBinaryOperatorAccess().getOperatorPlusSignKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1225:8: lv_operator_2_2= '-'
                    {
                    lv_operator_2_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBinaryOperator2903); 

                            newLeafNode(lv_operator_2_2, grammarAccess.getBinaryOperatorAccess().getOperatorHyphenMinusKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1237:8: lv_operator_2_3= '*'
                    {
                    lv_operator_2_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleBinaryOperator2932); 

                            newLeafNode(lv_operator_2_3, grammarAccess.getBinaryOperatorAccess().getOperatorAsteriskKeyword_2_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1249:8: lv_operator_2_4= '/'
                    {
                    lv_operator_2_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleBinaryOperator2961); 

                            newLeafNode(lv_operator_2_4, grammarAccess.getBinaryOperatorAccess().getOperatorSolidusKeyword_2_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1261:8: lv_operator_2_5= '%'
                    {
                    lv_operator_2_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleBinaryOperator2990); 

                            newLeafNode(lv_operator_2_5, grammarAccess.getBinaryOperatorAccess().getOperatorPercentSignKeyword_2_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1273:8: lv_operator_2_6= '=='
                    {
                    lv_operator_2_6=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleBinaryOperator3019); 

                            newLeafNode(lv_operator_2_6, grammarAccess.getBinaryOperatorAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1285:8: lv_operator_2_7= '!='
                    {
                    lv_operator_2_7=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleBinaryOperator3048); 

                            newLeafNode(lv_operator_2_7, grammarAccess.getBinaryOperatorAccess().getOperatorExclamationMarkEqualsSignKeyword_2_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1297:8: lv_operator_2_8= '>'
                    {
                    lv_operator_2_8=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleBinaryOperator3077); 

                            newLeafNode(lv_operator_2_8, grammarAccess.getBinaryOperatorAccess().getOperatorGreaterThanSignKeyword_2_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1309:8: lv_operator_2_9= '<'
                    {
                    lv_operator_2_9=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleBinaryOperator3106); 

                            newLeafNode(lv_operator_2_9, grammarAccess.getBinaryOperatorAccess().getOperatorLessThanSignKeyword_2_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_2_9, null);
                    	    

                    }
                    break;

            }


            }


            }

            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1324:2: ( (lv_right_3_0= ruleExpression ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1325:1: (lv_right_3_0= ruleExpression )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1325:1: (lv_right_3_0= ruleExpression )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1326:3: lv_right_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getRightExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleBinaryOperator3143);
            lv_right_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"right",
                    		lv_right_3_0, 
                    		"Expression");
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
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "ruleMode"
    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1350:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1352:28: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) ) )
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1353:1: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) )
            {
            // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1353:1: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt25=1;
                }
                break;
            case 43:
                {
                alt25=2;
                }
                break;
            case 44:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1353:2: (enumLiteral_0= 'int' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1353:2: (enumLiteral_0= 'int' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1353:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleMode3193); 

                            current = grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1359:6: (enumLiteral_1= 'bool' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1359:6: (enumLiteral_1= 'bool' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1359:8: enumLiteral_1= 'bool'
                    {
                    enumLiteral_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleMode3210); 

                            current = grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1365:6: (enumLiteral_2= 'double' )
                    {
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1365:6: (enumLiteral_2= 'double' )
                    // ../wodel.dsls.asple/src-gen/wodel/dsls/parser/antlr/internal/InternalAsple.g:1365:8: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMode3227); 

                            current = grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2()); 
                        

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

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\17\uffff";
    static final String DFA22_eofS =
        "\1\uffff\2\11\1\uffff\3\11\3\uffff\1\11\3\uffff\1\11";
    static final String DFA22_minS =
        "\1\4\2\5\1\6\3\5\1\6\2\uffff\1\5\3\6\1\5";
    static final String DFA22_maxS =
        "\1\23\2\51\1\23\3\51\1\6\2\uffff\1\51\2\20\1\6\1\51";
    static final String DFA22_acceptS =
        "\10\uffff\1\2\1\1\5\uffff";
    static final String DFA22_specialS =
        "\17\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\2\1\4\11\uffff\1\3\1\5\1\6\1\7",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11"+
            "\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11"+
            "\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\4\14\uffff\1\7",
            "\1\11\6\uffff\2\11\2\uffff\1\10\2\uffff\1\7\3\uffff\1\11\1"+
            "\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10"+
            "\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11"+
            "\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11"+
            "\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\12",
            "",
            "",
            "\1\11\6\uffff\2\11\2\uffff\1\10\3\uffff\1\13\1\14\1\uffff"+
            "\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1"+
            "\uffff\10\10",
            "\1\16\11\uffff\1\15",
            "\1\16\11\uffff\1\15",
            "\1\16",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11"+
            "\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1106:1: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleProgram131 = new BitSet(new long[]{0x00001C0160806030L});
        public static final BitSet FOLLOW_ruleDeclaration_in_ruleProgram153 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleProgram165 = new BitSet(new long[]{0x00001C0160806030L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleProgram188 = new BitSet(new long[]{0x0000000160802020L});
        public static final BitSet FOLLOW_13_in_ruleProgram201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleDeclaration299 = new BitSet(new long[]{0x00001C0000004030L});
        public static final BitSet FOLLOW_ruleMode_in_ruleDeclaration334 = new BitSet(new long[]{0x00001C0000004030L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration356 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleDeclaration369 = new BitSet(new long[]{0x00001C0000004030L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration390 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEInt602 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean665 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleEBoolean714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleEBoolean733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEDouble824 = new BitSet(new long[]{0x0000000000080040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble842 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleEDouble862 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble877 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_20_in_ruleEDouble897 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_21_in_ruleEDouble916 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_16_in_ruleEDouble931 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleIdentifier1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1096 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInteger_in_ruleLiteral1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleLiteral1180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDouble_in_ruleLiteral1207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger1242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInteger1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleInteger1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1343 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleBoolean1408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble1444 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDouble1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleDouble1509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatement1555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement1602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConditional_in_ruleStatement1629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_ruleStatement1656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransput_in_ruleStatement1683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment1773 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleAssignment1785 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment1806 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAssignment1818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConditional_in_entryRuleConditional1854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConditional1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleConditional1910 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleConditional1922 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleConditional1943 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleConditional1955 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleConditional1967 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleConditional1988 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_27_in_ruleConditional2001 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleConditional2014 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleConditional2026 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleConditional2047 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_27_in_ruleConditional2060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop2098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleLoop2155 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLoop2167 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleLoop2188 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoop2200 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoop2212 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleLoop2233 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_27_in_ruleLoop2246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleLoop2266 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoop2278 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleLoop2299 = new BitSet(new long[]{0x0000000168800020L});
        public static final BitSet FOLLOW_27_in_ruleLoop2312 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLoop2324 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLoop2336 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleLoop2357 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoop2369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransput_in_entryRuleTransput2406 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransput2416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleTransput2462 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransput2482 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleTransput2494 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleTransput2515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression2561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression2608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleExpression2635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary2670 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimary2680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rulePrimary2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_rulePrimary2754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator2789 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator2799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleBinaryOperator2854 = new BitSet(new long[]{0x000003FC00010000L});
        public static final BitSet FOLLOW_34_in_ruleBinaryOperator2874 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_16_in_ruleBinaryOperator2903 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_35_in_ruleBinaryOperator2932 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_36_in_ruleBinaryOperator2961 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_37_in_ruleBinaryOperator2990 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_38_in_ruleBinaryOperator3019 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_39_in_ruleBinaryOperator3048 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_40_in_ruleBinaryOperator3077 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_41_in_ruleBinaryOperator3106 = new BitSet(new long[]{0x00001C00000F4070L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleBinaryOperator3143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleMode3193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleMode3210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMode3227 = new BitSet(new long[]{0x0000000000000002L});
    }


}