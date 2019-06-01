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
    public String getGrammarFileName() { return "InternalAsple.g"; }



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
    // InternalAsple.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalAsple.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalAsple.g:66:2: iv_ruleProgram= ruleProgram EOF
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
    // InternalAsple.g:72:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declarations_2_0 = null;

        EObject lv_statements_4_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:78:2: ( ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' ) )
            // InternalAsple.g:79:2: ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' )
            {
            // InternalAsple.g:79:2: ( () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end' )
            // InternalAsple.g:80:3: () otherlv_1= 'begin' ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )* ( (lv_statements_4_0= ruleStatement ) )* otherlv_5= 'end'
            {
            // InternalAsple.g:80:3: ()
            // InternalAsple.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProgramAccess().getProgramAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getBeginKeyword_1());
            		
            // InternalAsple.g:91:3: ( ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';' )*
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
            	    // InternalAsple.g:92:4: ( (lv_declarations_2_0= ruleDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalAsple.g:92:4: ( (lv_declarations_2_0= ruleDeclaration ) )
            	    // InternalAsple.g:93:5: (lv_declarations_2_0= ruleDeclaration )
            	    {
            	    // InternalAsple.g:93:5: (lv_declarations_2_0= ruleDeclaration )
            	    // InternalAsple.g:94:6: lv_declarations_2_0= ruleDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getDeclarationsDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_declarations_2_0=ruleDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"declarations",
            	    							lv_declarations_2_0,
            	    							"wodel.dsls.Asple.Declaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalAsple.g:116:3: ( (lv_statements_4_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==23||(LA2_0>=29 && LA2_0<=30)||LA2_0==32) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAsple.g:117:4: (lv_statements_4_0= ruleStatement )
            	    {
            	    // InternalAsple.g:117:4: (lv_statements_4_0= ruleStatement )
            	    // InternalAsple.g:118:5: lv_statements_4_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_statements_4_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProgramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_4_0,
            	    						"wodel.dsls.Asple.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

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
    // InternalAsple.g:143:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalAsple.g:143:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalAsple.g:144:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalAsple.g:150:1: ruleDeclaration returns [EObject current=null] : ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;
        Token otherlv_4=null;
        Enumerator lv_mode_2_0 = null;

        EObject lv_identifiers_3_0 = null;

        EObject lv_identifiers_5_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:156:2: ( ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* ) )
            // InternalAsple.g:157:2: ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* )
            {
            // InternalAsple.g:157:2: ( () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )* )
            // InternalAsple.g:158:3: () ( (lv_ref_1_0= 'ref' ) )? ( (lv_mode_2_0= ruleMode ) )? ( (lv_identifiers_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )*
            {
            // InternalAsple.g:158:3: ()
            // InternalAsple.g:159:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDeclarationAccess().getDeclarationAction_0(),
            					current);
            			

            }

            // InternalAsple.g:165:3: ( (lv_ref_1_0= 'ref' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAsple.g:166:4: (lv_ref_1_0= 'ref' )
                    {
                    // InternalAsple.g:166:4: (lv_ref_1_0= 'ref' )
                    // InternalAsple.g:167:5: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,14,FOLLOW_6); 

                    					newLeafNode(lv_ref_1_0, grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "ref", true, "ref");
                    				

                    }


                    }
                    break;

            }

            // InternalAsple.g:179:3: ( (lv_mode_2_0= ruleMode ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=42 && LA4_0<=44)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAsple.g:180:4: (lv_mode_2_0= ruleMode )
                    {
                    // InternalAsple.g:180:4: (lv_mode_2_0= ruleMode )
                    // InternalAsple.g:181:5: lv_mode_2_0= ruleMode
                    {

                    					newCompositeNode(grammarAccess.getDeclarationAccess().getModeModeEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_6);
                    lv_mode_2_0=ruleMode();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDeclarationRule());
                    					}
                    					set(
                    						current,
                    						"mode",
                    						lv_mode_2_0,
                    						"wodel.dsls.Asple.Mode");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAsple.g:198:3: ( (lv_identifiers_3_0= ruleIdentifier ) )
            // InternalAsple.g:199:4: (lv_identifiers_3_0= ruleIdentifier )
            {
            // InternalAsple.g:199:4: (lv_identifiers_3_0= ruleIdentifier )
            // InternalAsple.g:200:5: lv_identifiers_3_0= ruleIdentifier
            {

            					newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_identifiers_3_0=ruleIdentifier();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeclarationRule());
            					}
            					add(
            						current,
            						"identifiers",
            						lv_identifiers_3_0,
            						"wodel.dsls.Asple.Identifier");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAsple.g:217:3: (otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAsple.g:218:4: otherlv_4= ',' ( (lv_identifiers_5_0= ruleIdentifier ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalAsple.g:222:4: ( (lv_identifiers_5_0= ruleIdentifier ) )
            	    // InternalAsple.g:223:5: (lv_identifiers_5_0= ruleIdentifier )
            	    {
            	    // InternalAsple.g:223:5: (lv_identifiers_5_0= ruleIdentifier )
            	    // InternalAsple.g:224:6: lv_identifiers_5_0= ruleIdentifier
            	    {

            	    						newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_identifiers_5_0=ruleIdentifier();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"identifiers",
            	    							lv_identifiers_5_0,
            	    							"wodel.dsls.Asple.Identifier");
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
    // InternalAsple.g:246:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalAsple.g:246:47: (iv_ruleEString= ruleEString EOF )
            // InternalAsple.g:247:2: iv_ruleEString= ruleEString EOF
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
    // InternalAsple.g:253:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalAsple.g:259:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalAsple.g:260:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalAsple.g:260:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // InternalAsple.g:261:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:269:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleEInt"
    // InternalAsple.g:280:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalAsple.g:280:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalAsple.g:281:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalAsple.g:287:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalAsple.g:293:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalAsple.g:294:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalAsple.g:294:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalAsple.g:295:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalAsple.g:295:3: (kw= '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAsple.g:296:4: kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_8); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

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
    // InternalAsple.g:313:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalAsple.g:313:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalAsple.g:314:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalAsple.g:320:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAsple.g:326:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAsple.g:327:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAsple.g:327:2: (kw= 'true' | kw= 'false' )
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
                    // InternalAsple.g:328:3: kw= 'true'
                    {
                    kw=(Token)match(input,17,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:334:3: kw= 'false'
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

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
    // InternalAsple.g:343:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalAsple.g:343:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalAsple.g:344:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalAsple.g:350:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalAsple.g:356:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalAsple.g:357:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalAsple.g:357:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalAsple.g:358:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalAsple.g:358:3: (kw= '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAsple.g:359:4: kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_9); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalAsple.g:365:3: (this_INT_1= RULE_INT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAsple.g:366:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_10); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,19,FOLLOW_8); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_11); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalAsple.g:386:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=20 && LA13_0<=21)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAsple.g:387:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalAsple.g:387:4: (kw= 'E' | kw= 'e' )
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
                            // InternalAsple.g:388:5: kw= 'E'
                            {
                            kw=(Token)match(input,20,FOLLOW_12); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalAsple.g:394:5: kw= 'e'
                            {
                            kw=(Token)match(input,21,FOLLOW_12); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalAsple.g:400:4: (kw= '-' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==16) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalAsple.g:401:5: kw= '-'
                            {
                            kw=(Token)match(input,16,FOLLOW_8); 

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


    // $ANTLR start "entryRuleIdentifier"
    // InternalAsple.g:419:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // InternalAsple.g:419:51: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalAsple.g:420:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier; 
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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalAsple.g:426:1: ruleIdentifier returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:432:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalAsple.g:433:2: ( () ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalAsple.g:433:2: ( () ( (lv_name_1_0= ruleEString ) ) )
            // InternalAsple.g:434:3: () ( (lv_name_1_0= ruleEString ) )
            {
            // InternalAsple.g:434:3: ()
            // InternalAsple.g:435:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIdentifierAccess().getIdentifierAction_0(),
            					current);
            			

            }

            // InternalAsple.g:441:3: ( (lv_name_1_0= ruleEString ) )
            // InternalAsple.g:442:4: (lv_name_1_0= ruleEString )
            {
            // InternalAsple.g:442:4: (lv_name_1_0= ruleEString )
            // InternalAsple.g:443:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIdentifierRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"wodel.dsls.Asple.EString");
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
    // InternalAsple.g:464:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalAsple.g:464:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalAsple.g:465:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalAsple.g:471:1: ruleLiteral returns [EObject current=null] : (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_Integer_0 = null;

        EObject this_Boolean_1 = null;

        EObject this_Double_2 = null;



        	enterRule();

        try {
            // InternalAsple.g:477:2: ( (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble ) )
            // InternalAsple.g:478:2: (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble )
            {
            // InternalAsple.g:478:2: (this_Integer_0= ruleInteger | this_Boolean_1= ruleBoolean | this_Double_2= ruleDouble )
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
                    // InternalAsple.g:479:3: this_Integer_0= ruleInteger
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getIntegerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Integer_0=ruleInteger();

                    state._fsp--;


                    			current = this_Integer_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:488:3: this_Boolean_1= ruleBoolean
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getBooleanParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Boolean_1=ruleBoolean();

                    state._fsp--;


                    			current = this_Boolean_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalAsple.g:497:3: this_Double_2= ruleDouble
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getDoubleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalAsple.g:509:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalAsple.g:509:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalAsple.g:510:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger; 
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
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalAsple.g:516:1: ruleInteger returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEInt ) ) ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:522:2: ( ( () ( (lv_value_1_0= ruleEInt ) ) ) )
            // InternalAsple.g:523:2: ( () ( (lv_value_1_0= ruleEInt ) ) )
            {
            // InternalAsple.g:523:2: ( () ( (lv_value_1_0= ruleEInt ) ) )
            // InternalAsple.g:524:3: () ( (lv_value_1_0= ruleEInt ) )
            {
            // InternalAsple.g:524:3: ()
            // InternalAsple.g:525:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntegerAccess().getIntegerAction_0(),
            					current);
            			

            }

            // InternalAsple.g:531:3: ( (lv_value_1_0= ruleEInt ) )
            // InternalAsple.g:532:4: (lv_value_1_0= ruleEInt )
            {
            // InternalAsple.g:532:4: (lv_value_1_0= ruleEInt )
            // InternalAsple.g:533:5: lv_value_1_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntegerRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"wodel.dsls.Asple.EInt");
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
    // InternalAsple.g:554:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // InternalAsple.g:554:48: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalAsple.g:555:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalAsple.g:561:1: ruleBoolean returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:567:2: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // InternalAsple.g:568:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // InternalAsple.g:568:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // InternalAsple.g:569:3: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // InternalAsple.g:569:3: ()
            // InternalAsple.g:570:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanAccess().getBooleanAction_0(),
            					current);
            			

            }

            // InternalAsple.g:576:3: ( (lv_value_1_0= ruleEBoolean ) )
            // InternalAsple.g:577:4: (lv_value_1_0= ruleEBoolean )
            {
            // InternalAsple.g:577:4: (lv_value_1_0= ruleEBoolean )
            // InternalAsple.g:578:5: lv_value_1_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"wodel.dsls.Asple.EBoolean");
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
    // InternalAsple.g:599:1: entryRuleDouble returns [EObject current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final EObject entryRuleDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDouble = null;


        try {
            // InternalAsple.g:599:47: (iv_ruleDouble= ruleDouble EOF )
            // InternalAsple.g:600:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble; 
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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalAsple.g:606:1: ruleDouble returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:612:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalAsple.g:613:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalAsple.g:613:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalAsple.g:614:3: () ( (lv_value_1_0= ruleEDouble ) )
            {
            // InternalAsple.g:614:3: ()
            // InternalAsple.g:615:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDoubleAccess().getDoubleAction_0(),
            					current);
            			

            }

            // InternalAsple.g:621:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalAsple.g:622:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalAsple.g:622:4: (lv_value_1_0= ruleEDouble )
            // InternalAsple.g:623:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDoubleRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"wodel.dsls.Asple.EDouble");
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
    // InternalAsple.g:644:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalAsple.g:644:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalAsple.g:645:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalAsple.g:651:1: ruleStatement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_Conditional_1 = null;

        EObject this_Loop_2 = null;

        EObject this_Transput_3 = null;



        	enterRule();

        try {
            // InternalAsple.g:657:2: ( (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput ) )
            // InternalAsple.g:658:2: (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput )
            {
            // InternalAsple.g:658:2: (this_Assignment_0= ruleAssignment | this_Conditional_1= ruleConditional | this_Loop_2= ruleLoop | this_Transput_3= ruleTransput )
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
                    // InternalAsple.g:659:3: this_Assignment_0= ruleAssignment
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    			current = this_Assignment_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:668:3: this_Conditional_1= ruleConditional
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getConditionalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Conditional_1=ruleConditional();

                    state._fsp--;


                    			current = this_Conditional_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalAsple.g:677:3: this_Loop_2= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getLoopParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_2=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalAsple.g:686:3: this_Transput_3= ruleTransput
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getTransputParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalAsple.g:698:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalAsple.g:698:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalAsple.g:699:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalAsple.g:705:1: ruleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:711:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalAsple.g:712:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalAsple.g:712:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalAsple.g:713:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // InternalAsple.g:713:3: ( (otherlv_0= RULE_ID ) )
            // InternalAsple.g:714:4: (otherlv_0= RULE_ID )
            {
            // InternalAsple.g:714:4: (otherlv_0= RULE_ID )
            // InternalAsple.g:715:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getVarIdentifierCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalAsple.g:730:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalAsple.g:731:4: (lv_value_2_0= ruleExpression )
            {
            // InternalAsple.g:731:4: (lv_value_2_0= ruleExpression )
            // InternalAsple.g:732:5: lv_value_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"wodel.dsls.Asple.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_2); 

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
    // InternalAsple.g:757:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // InternalAsple.g:757:52: (iv_ruleConditional= ruleConditional EOF )
            // InternalAsple.g:758:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional; 
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
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalAsple.g:764:1: ruleConditional returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? ) ;
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
            // InternalAsple.g:770:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? ) )
            // InternalAsple.g:771:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? )
            {
            // InternalAsple.g:771:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )? )
            // InternalAsple.g:772:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_if_6_0= ruleStatement ) )* otherlv_7= '}' (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )?
            {
            // InternalAsple.g:772:3: ()
            // InternalAsple.g:773:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConditionalAccess().getConditionalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionalAccess().getIfKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getLeftParenthesisKeyword_2());
            		
            // InternalAsple.g:787:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalAsple.g:788:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalAsple.g:788:4: (lv_expression_3_0= ruleExpression )
            // InternalAsple.g:789:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getConditionalAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"wodel.dsls.Asple.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionalAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,26,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalAsple.g:814:3: ( (lv_if_6_0= ruleStatement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==23||(LA16_0>=29 && LA16_0<=30)||LA16_0==32) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAsple.g:815:4: (lv_if_6_0= ruleStatement )
            	    {
            	    // InternalAsple.g:815:4: (lv_if_6_0= ruleStatement )
            	    // InternalAsple.g:816:5: lv_if_6_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getConditionalAccess().getIfStatementParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_if_6_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"if",
            	    						lv_if_6_0,
            	    						"wodel.dsls.Asple.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7());
            		
            // InternalAsple.g:837:3: (otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAsple.g:838:4: otherlv_8= 'else' otherlv_9= '{' ( (lv_else_10_0= ruleStatement ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_17); 

                    				newLeafNode(otherlv_8, grammarAccess.getConditionalAccess().getElseKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalAsple.g:846:4: ( (lv_else_10_0= ruleStatement ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID||LA17_0==23||(LA17_0>=29 && LA17_0<=30)||LA17_0==32) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalAsple.g:847:5: (lv_else_10_0= ruleStatement )
                    	    {
                    	    // InternalAsple.g:847:5: (lv_else_10_0= ruleStatement )
                    	    // InternalAsple.g:848:6: lv_else_10_0= ruleStatement
                    	    {

                    	    						newCompositeNode(grammarAccess.getConditionalAccess().getElseStatementParserRuleCall_8_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_else_10_0=ruleStatement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getConditionalRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"else",
                    	    							lv_else_10_0,
                    	    							"wodel.dsls.Asple.Statement");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,27,FOLLOW_2); 

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
    // InternalAsple.g:874:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalAsple.g:874:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalAsple.g:875:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
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
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalAsple.g:881:1: ruleLoop returns [EObject current=null] : ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) ) ;
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
            // InternalAsple.g:887:2: ( ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) ) )
            // InternalAsple.g:888:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) )
            {
            // InternalAsple.g:888:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' ) | (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' ) )
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
                    // InternalAsple.g:889:3: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' )
                    {
                    // InternalAsple.g:889:3: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}' )
                    // InternalAsple.g:890:4: () otherlv_1= 'while' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_statements_6_0= ruleStatement ) )* otherlv_7= '}'
                    {
                    // InternalAsple.g:890:4: ()
                    // InternalAsple.g:891:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLoopAccess().getLoopAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getWhileKeyword_0_1());
                    			
                    otherlv_2=(Token)match(input,24,FOLLOW_14); 

                    				newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalAsple.g:905:4: ( (lv_expression_3_0= ruleExpression ) )
                    // InternalAsple.g:906:5: (lv_expression_3_0= ruleExpression )
                    {
                    // InternalAsple.g:906:5: (lv_expression_3_0= ruleExpression )
                    // InternalAsple.g:907:6: lv_expression_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_expression_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_3_0,
                    							"wodel.dsls.Asple.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_17); 

                    				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightParenthesisKeyword_0_4());
                    			
                    otherlv_5=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_0_5());
                    			
                    // InternalAsple.g:932:4: ( (lv_statements_6_0= ruleStatement ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID||LA19_0==23||(LA19_0>=29 && LA19_0<=30)||LA19_0==32) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalAsple.g:933:5: (lv_statements_6_0= ruleStatement )
                    	    {
                    	    // InternalAsple.g:933:5: (lv_statements_6_0= ruleStatement )
                    	    // InternalAsple.g:934:6: lv_statements_6_0= ruleStatement
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_0_6_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_statements_6_0=ruleStatement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"statements",
                    	    							lv_statements_6_0,
                    	    							"wodel.dsls.Asple.Statement");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_0_7());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:957:3: (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' )
                    {
                    // InternalAsple.g:957:3: (otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')' )
                    // InternalAsple.g:958:4: otherlv_8= 'repeat' otherlv_9= '{' ( (lv_statements_10_0= ruleStatement ) )* otherlv_11= '}' otherlv_12= 'until' otherlv_13= '(' ( (lv_expression_14_0= ruleExpression ) ) otherlv_15= ')'
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_17); 

                    				newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getRepeatKeyword_1_0());
                    			
                    otherlv_9=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1_1());
                    			
                    // InternalAsple.g:966:4: ( (lv_statements_10_0= ruleStatement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||LA20_0==23||(LA20_0>=29 && LA20_0<=30)||LA20_0==32) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalAsple.g:967:5: (lv_statements_10_0= ruleStatement )
                    	    {
                    	    // InternalAsple.g:967:5: (lv_statements_10_0= ruleStatement )
                    	    // InternalAsple.g:968:6: lv_statements_10_0= ruleStatement
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_statements_10_0=ruleStatement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"statements",
                    	    							lv_statements_10_0,
                    	    							"wodel.dsls.Asple.Statement");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,27,FOLLOW_20); 

                    				newLeafNode(otherlv_11, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_1_3());
                    			
                    otherlv_12=(Token)match(input,31,FOLLOW_15); 

                    				newLeafNode(otherlv_12, grammarAccess.getLoopAccess().getUntilKeyword_1_4());
                    			
                    otherlv_13=(Token)match(input,24,FOLLOW_14); 

                    				newLeafNode(otherlv_13, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1_5());
                    			
                    // InternalAsple.g:997:4: ( (lv_expression_14_0= ruleExpression ) )
                    // InternalAsple.g:998:5: (lv_expression_14_0= ruleExpression )
                    {
                    // InternalAsple.g:998:5: (lv_expression_14_0= ruleExpression )
                    // InternalAsple.g:999:6: lv_expression_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_1_6_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_expression_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_14_0,
                    							"wodel.dsls.Asple.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,25,FOLLOW_2); 

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
    // InternalAsple.g:1025:1: entryRuleTransput returns [EObject current=null] : iv_ruleTransput= ruleTransput EOF ;
    public final EObject entryRuleTransput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransput = null;


        try {
            // InternalAsple.g:1025:49: (iv_ruleTransput= ruleTransput EOF )
            // InternalAsple.g:1026:2: iv_ruleTransput= ruleTransput EOF
            {
             newCompositeNode(grammarAccess.getTransputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransput=ruleTransput();

            state._fsp--;

             current =iv_ruleTransput; 
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
    // $ANTLR end "entryRuleTransput"


    // $ANTLR start "ruleTransput"
    // InternalAsple.g:1032:1: ruleTransput returns [EObject current=null] : ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleTransput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalAsple.g:1038:2: ( ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) ) )
            // InternalAsple.g:1039:2: ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) )
            {
            // InternalAsple.g:1039:2: ( () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) ) )
            // InternalAsple.g:1040:3: () otherlv_1= 'input' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'output' ( (lv_expression_4_0= ruleExpression ) )
            {
            // InternalAsple.g:1040:3: ()
            // InternalAsple.g:1041:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTransputAccess().getTransputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getTransputAccess().getInputKeyword_1());
            		
            // InternalAsple.g:1051:3: ( (otherlv_2= RULE_ID ) )
            // InternalAsple.g:1052:4: (otherlv_2= RULE_ID )
            {
            // InternalAsple.g:1052:4: (otherlv_2= RULE_ID )
            // InternalAsple.g:1053:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransputRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(otherlv_2, grammarAccess.getTransputAccess().getVarIdentifierCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getTransputAccess().getOutputKeyword_3());
            		
            // InternalAsple.g:1068:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalAsple.g:1069:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalAsple.g:1069:4: (lv_expression_4_0= ruleExpression )
            // InternalAsple.g:1070:5: lv_expression_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransputRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_4_0,
            						"wodel.dsls.Asple.Expression");
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
    // InternalAsple.g:1091:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAsple.g:1091:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAsple.g:1092:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalAsple.g:1098:1: ruleExpression returns [EObject current=null] : (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Primary_0 = null;

        EObject this_BinaryOperator_1 = null;



        	enterRule();

        try {
            // InternalAsple.g:1104:2: ( (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator ) )
            // InternalAsple.g:1105:2: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )
            {
            // InternalAsple.g:1105:2: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalAsple.g:1106:3: this_Primary_0= rulePrimary
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Primary_0=rulePrimary();

                    state._fsp--;


                    			current = this_Primary_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:1115:3: this_BinaryOperator_1= ruleBinaryOperator
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getBinaryOperatorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalAsple.g:1127:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAsple.g:1127:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAsple.g:1128:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalAsple.g:1134:1: rulePrimary returns [EObject current=null] : (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        EObject this_Identifier_0 = null;

        EObject this_Literal_1 = null;



        	enterRule();

        try {
            // InternalAsple.g:1140:2: ( (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral ) )
            // InternalAsple.g:1141:2: (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral )
            {
            // InternalAsple.g:1141:2: (this_Identifier_0= ruleIdentifier | this_Literal_1= ruleLiteral )
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
                    // InternalAsple.g:1142:3: this_Identifier_0= ruleIdentifier
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getIdentifierParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;


                    			current = this_Identifier_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAsple.g:1151:3: this_Literal_1= ruleLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalAsple.g:1163:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // InternalAsple.g:1163:55: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // InternalAsple.g:1164:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalAsple.g:1170:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) ) ;
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
            // InternalAsple.g:1176:2: ( ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) ) )
            // InternalAsple.g:1177:2: ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) )
            {
            // InternalAsple.g:1177:2: ( () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) ) )
            // InternalAsple.g:1178:3: () ( (lv_left_1_0= rulePrimary ) ) ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) ) ( (lv_right_3_0= ruleExpression ) )
            {
            // InternalAsple.g:1178:3: ()
            // InternalAsple.g:1179:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
            					current);
            			

            }

            // InternalAsple.g:1185:3: ( (lv_left_1_0= rulePrimary ) )
            // InternalAsple.g:1186:4: (lv_left_1_0= rulePrimary )
            {
            // InternalAsple.g:1186:4: (lv_left_1_0= rulePrimary )
            // InternalAsple.g:1187:5: lv_left_1_0= rulePrimary
            {

            					newCompositeNode(grammarAccess.getBinaryOperatorAccess().getLeftPrimaryParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
            lv_left_1_0=rulePrimary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"wodel.dsls.Asple.Primary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAsple.g:1204:3: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) ) )
            // InternalAsple.g:1205:4: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) )
            {
            // InternalAsple.g:1205:4: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' ) )
            // InternalAsple.g:1206:5: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' )
            {
            // InternalAsple.g:1206:5: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '*' | lv_operator_2_4= '/' | lv_operator_2_5= '%' | lv_operator_2_6= '==' | lv_operator_2_7= '!=' | lv_operator_2_8= '>' | lv_operator_2_9= '<' )
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
                    // InternalAsple.g:1207:6: lv_operator_2_1= '+'
                    {
                    lv_operator_2_1=(Token)match(input,34,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_1, grammarAccess.getBinaryOperatorAccess().getOperatorPlusSignKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalAsple.g:1218:6: lv_operator_2_2= '-'
                    {
                    lv_operator_2_2=(Token)match(input,16,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_2, grammarAccess.getBinaryOperatorAccess().getOperatorHyphenMinusKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalAsple.g:1229:6: lv_operator_2_3= '*'
                    {
                    lv_operator_2_3=(Token)match(input,35,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_3, grammarAccess.getBinaryOperatorAccess().getOperatorAsteriskKeyword_2_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalAsple.g:1240:6: lv_operator_2_4= '/'
                    {
                    lv_operator_2_4=(Token)match(input,36,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_4, grammarAccess.getBinaryOperatorAccess().getOperatorSolidusKeyword_2_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalAsple.g:1251:6: lv_operator_2_5= '%'
                    {
                    lv_operator_2_5=(Token)match(input,37,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_5, grammarAccess.getBinaryOperatorAccess().getOperatorPercentSignKeyword_2_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalAsple.g:1262:6: lv_operator_2_6= '=='
                    {
                    lv_operator_2_6=(Token)match(input,38,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_6, grammarAccess.getBinaryOperatorAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_6, null);
                    					

                    }
                    break;
                case 7 :
                    // InternalAsple.g:1273:6: lv_operator_2_7= '!='
                    {
                    lv_operator_2_7=(Token)match(input,39,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_7, grammarAccess.getBinaryOperatorAccess().getOperatorExclamationMarkEqualsSignKeyword_2_0_6());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_7, null);
                    					

                    }
                    break;
                case 8 :
                    // InternalAsple.g:1284:6: lv_operator_2_8= '>'
                    {
                    lv_operator_2_8=(Token)match(input,40,FOLLOW_14); 

                    						newLeafNode(lv_operator_2_8, grammarAccess.getBinaryOperatorAccess().getOperatorGreaterThanSignKeyword_2_0_7());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryOperatorRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_2_8, null);
                    					

                    }
                    break;
                case 9 :
                    // InternalAsple.g:1295:6: lv_operator_2_9= '<'
                    {
                    lv_operator_2_9=(Token)match(input,41,FOLLOW_14); 

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

            // InternalAsple.g:1308:3: ( (lv_right_3_0= ruleExpression ) )
            // InternalAsple.g:1309:4: (lv_right_3_0= ruleExpression )
            {
            // InternalAsple.g:1309:4: (lv_right_3_0= ruleExpression )
            // InternalAsple.g:1310:5: lv_right_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBinaryOperatorAccess().getRightExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"wodel.dsls.Asple.Expression");
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
    // InternalAsple.g:1331:1: ruleMode returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) ) ;
    public final Enumerator ruleMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalAsple.g:1337:2: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) ) )
            // InternalAsple.g:1338:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) )
            {
            // InternalAsple.g:1338:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'bool' ) | (enumLiteral_2= 'double' ) )
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
                    // InternalAsple.g:1339:3: (enumLiteral_0= 'int' )
                    {
                    // InternalAsple.g:1339:3: (enumLiteral_0= 'int' )
                    // InternalAsple.g:1340:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:1347:3: (enumLiteral_1= 'bool' )
                    {
                    // InternalAsple.g:1347:3: (enumLiteral_1= 'bool' )
                    // InternalAsple.g:1348:4: enumLiteral_1= 'bool'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalAsple.g:1355:3: (enumLiteral_2= 'double' )
                    {
                    // InternalAsple.g:1355:3: (enumLiteral_2= 'double' )
                    // InternalAsple.g:1356:4: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); 

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
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\uffff\2\11\1\uffff\3\11\3\uffff\1\11\3\uffff\1\11";
    static final String dfa_3s = "\1\4\2\5\1\6\3\5\1\6\2\uffff\1\5\3\6\1\5";
    static final String dfa_4s = "\1\23\2\51\1\23\3\51\1\6\2\uffff\1\51\2\20\1\6\1\51";
    static final String dfa_5s = "\10\uffff\1\2\1\1\5\uffff";
    static final String dfa_6s = "\17\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\1\4\11\uffff\1\3\1\5\1\6\1\7",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\4\14\uffff\1\7",
            "\1\11\6\uffff\2\11\2\uffff\1\10\2\uffff\1\7\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\12",
            "",
            "",
            "\1\11\6\uffff\2\11\2\uffff\1\10\3\uffff\1\13\1\14\1\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10",
            "\1\16\11\uffff\1\15",
            "\1\16\11\uffff\1\15",
            "\1\16",
            "\1\11\6\uffff\2\11\2\uffff\1\10\6\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\10\10"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1105:2: (this_Primary_0= rulePrimary | this_BinaryOperator_1= ruleBinaryOperator )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00001C0160806030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000160802020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00001C0000004030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00001C00000F4070L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000168800020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000003FC00010000L});

}