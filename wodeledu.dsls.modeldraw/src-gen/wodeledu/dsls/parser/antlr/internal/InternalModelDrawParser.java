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
import wodeledu.dsls.services.ModelDrawGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelDrawParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "':'", "'{'", "'}'", "'('", "','", "')'", "'->'", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'not'", "'=='", "'null'", "'edge'", "'label'", "'.'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'diagram'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'load'", "'logic'", "'gray95'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'"
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
    public static final int T__53=53;
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


        public InternalModelDrawParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelDrawParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelDrawParser.tokenNames; }
    public String getGrammarFileName() { return "InternalModelDraw.g"; }



     	private ModelDrawGrammarAccess grammarAccess;

        public InternalModelDrawParser(TokenStream input, ModelDrawGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MutatorDraw";
       	}

       	@Override
       	protected ModelDrawGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMutatorDraw"
    // InternalModelDraw.g:65:1: entryRuleMutatorDraw returns [EObject current=null] : iv_ruleMutatorDraw= ruleMutatorDraw EOF ;
    public final EObject entryRuleMutatorDraw() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorDraw = null;


        try {
            // InternalModelDraw.g:65:52: (iv_ruleMutatorDraw= ruleMutatorDraw EOF )
            // InternalModelDraw.g:66:2: iv_ruleMutatorDraw= ruleMutatorDraw EOF
            {
             newCompositeNode(grammarAccess.getMutatorDrawRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMutatorDraw=ruleMutatorDraw();

            state._fsp--;

             current =iv_ruleMutatorDraw; 
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
    // $ANTLR end "entryRuleMutatorDraw"


    // $ANTLR start "ruleMutatorDraw"
    // InternalModelDraw.g:72:1: ruleMutatorDraw returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_instances_3_0= ruleMutatorInstance ) )+ ) ;
    public final EObject ruleMutatorDraw() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        EObject lv_instances_3_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:78:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_instances_3_0= ruleMutatorInstance ) )+ ) )
            // InternalModelDraw.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_instances_3_0= ruleMutatorInstance ) )+ )
            {
            // InternalModelDraw.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_instances_3_0= ruleMutatorInstance ) )+ )
            // InternalModelDraw.g:80:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (lv_instances_3_0= ruleMutatorInstance ) )+
            {
            // InternalModelDraw.g:80:3: ()
            // InternalModelDraw.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMutatorDrawAccess().getMetamodelKeyword_1());
            		
            // InternalModelDraw.g:91:3: ( (lv_metamodel_2_0= ruleEString ) )
            // InternalModelDraw.g:92:4: (lv_metamodel_2_0= ruleEString )
            {
            // InternalModelDraw.g:92:4: (lv_metamodel_2_0= ruleEString )
            // InternalModelDraw.g:93:5: lv_metamodel_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMutatorDrawAccess().getMetamodelEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_2_0,
            						"wodeledu.dsls.ModelDraw.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelDraw.g:110:3: ( (lv_instances_3_0= ruleMutatorInstance ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalModelDraw.g:111:4: (lv_instances_3_0= ruleMutatorInstance )
            	    {
            	    // InternalModelDraw.g:111:4: (lv_instances_3_0= ruleMutatorInstance )
            	    // InternalModelDraw.g:112:5: lv_instances_3_0= ruleMutatorInstance
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorDrawAccess().getInstancesMutatorInstanceParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_instances_3_0=ruleMutatorInstance();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instances",
            	    						lv_instances_3_0,
            	    						"wodeledu.dsls.ModelDraw.MutatorInstance");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
    // $ANTLR end "ruleMutatorDraw"


    // $ANTLR start "entryRuleMutatorInstance"
    // InternalModelDraw.g:133:1: entryRuleMutatorInstance returns [EObject current=null] : iv_ruleMutatorInstance= ruleMutatorInstance EOF ;
    public final EObject entryRuleMutatorInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorInstance = null;


        try {
            // InternalModelDraw.g:133:56: (iv_ruleMutatorInstance= ruleMutatorInstance EOF )
            // InternalModelDraw.g:134:2: iv_ruleMutatorInstance= ruleMutatorInstance EOF
            {
             newCompositeNode(grammarAccess.getMutatorInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMutatorInstance=ruleMutatorInstance();

            state._fsp--;

             current =iv_ruleMutatorInstance; 
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
    // $ANTLR end "entryRuleMutatorInstance"


    // $ANTLR start "ruleMutatorInstance"
    // InternalModelDraw.g:140:1: ruleMutatorInstance returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDrawType ) ) otherlv_4= '{' ( (lv_nodes_5_0= ruleNode ) )* ( (lv_relations_6_0= ruleRelation ) )* ( (lv_contents_7_0= ruleContent ) )* otherlv_8= '}' ) ;
    public final EObject ruleMutatorInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_nodes_5_0 = null;

        EObject lv_relations_6_0 = null;

        EObject lv_contents_7_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:146:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDrawType ) ) otherlv_4= '{' ( (lv_nodes_5_0= ruleNode ) )* ( (lv_relations_6_0= ruleRelation ) )* ( (lv_contents_7_0= ruleContent ) )* otherlv_8= '}' ) )
            // InternalModelDraw.g:147:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDrawType ) ) otherlv_4= '{' ( (lv_nodes_5_0= ruleNode ) )* ( (lv_relations_6_0= ruleRelation ) )* ( (lv_contents_7_0= ruleContent ) )* otherlv_8= '}' )
            {
            // InternalModelDraw.g:147:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDrawType ) ) otherlv_4= '{' ( (lv_nodes_5_0= ruleNode ) )* ( (lv_relations_6_0= ruleRelation ) )* ( (lv_contents_7_0= ruleContent ) )* otherlv_8= '}' )
            // InternalModelDraw.g:148:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDrawType ) ) otherlv_4= '{' ( (lv_nodes_5_0= ruleNode ) )* ( (lv_relations_6_0= ruleRelation ) )* ( (lv_contents_7_0= ruleContent ) )* otherlv_8= '}'
            {
            // InternalModelDraw.g:148:3: ()
            // InternalModelDraw.g:149:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:155:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:156:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:156:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:157:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMutatorInstanceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_1, grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMutatorInstanceAccess().getColonKeyword_2());
            		
            // InternalModelDraw.g:172:3: ( (lv_type_3_0= ruleDrawType ) )
            // InternalModelDraw.g:173:4: (lv_type_3_0= ruleDrawType )
            {
            // InternalModelDraw.g:173:4: (lv_type_3_0= ruleDrawType )
            // InternalModelDraw.g:174:5: lv_type_3_0= ruleDrawType
            {

            					newCompositeNode(grammarAccess.getMutatorInstanceAccess().getTypeDrawTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_3_0=ruleDrawType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"wodeledu.dsls.ModelDraw.DrawType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalModelDraw.g:195:3: ( (lv_nodes_5_0= ruleNode ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalModelDraw.g:196:4: (lv_nodes_5_0= ruleNode )
            	    {
            	    // InternalModelDraw.g:196:4: (lv_nodes_5_0= ruleNode )
            	    // InternalModelDraw.g:197:5: lv_nodes_5_0= ruleNode
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorInstanceAccess().getNodesNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_nodes_5_0=ruleNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"wodeledu.dsls.ModelDraw.Node");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalModelDraw.g:214:3: ( (lv_relations_6_0= ruleRelation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==15||LA3_1==18||LA3_1==29) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // InternalModelDraw.g:215:4: (lv_relations_6_0= ruleRelation )
            	    {
            	    // InternalModelDraw.g:215:4: (lv_relations_6_0= ruleRelation )
            	    // InternalModelDraw.g:216:5: lv_relations_6_0= ruleRelation
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorInstanceAccess().getRelationsRelationParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_relations_6_0=ruleRelation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relations",
            	    						lv_relations_6_0,
            	    						"wodeledu.dsls.ModelDraw.Relation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalModelDraw.g:233:3: ( (lv_contents_7_0= ruleContent ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalModelDraw.g:234:4: (lv_contents_7_0= ruleContent )
            	    {
            	    // InternalModelDraw.g:234:4: (lv_contents_7_0= ruleContent )
            	    // InternalModelDraw.g:235:5: lv_contents_7_0= ruleContent
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorInstanceAccess().getContentsContentParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_contents_7_0=ruleContent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contents",
            	    						lv_contents_7_0,
            	    						"wodeledu.dsls.ModelDraw.Content");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_8());
            		

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
    // $ANTLR end "ruleMutatorInstance"


    // $ANTLR start "entryRuleEString"
    // InternalModelDraw.g:260:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalModelDraw.g:260:47: (iv_ruleEString= ruleEString EOF )
            // InternalModelDraw.g:261:2: iv_ruleEString= ruleEString EOF
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
    // InternalModelDraw.g:267:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:273:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalModelDraw.g:274:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalModelDraw.g:274:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelDraw.g:275:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:283:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleNode"
    // InternalModelDraw.g:294:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalModelDraw.g:294:45: (iv_ruleNode= ruleNode EOF )
            // InternalModelDraw.g:295:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalModelDraw.g:301:1: ruleNode returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        EObject lv_feature_3_0 = null;

        EObject lv_feature_5_0 = null;

        EObject lv_targetFeature_10_0 = null;

        EObject lv_targetFeature_12_0 = null;

        Enumerator lv_type_15_0 = null;

        Enumerator lv_shape_26_0 = null;

        AntlrDatatypeRuleToken lv_pathShape_28_0 = null;

        Enumerator lv_color_32_0 = null;

        Enumerator lv_style_35_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:307:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? ) )
            // InternalModelDraw.g:308:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? )
            {
            // InternalModelDraw.g:308:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? )
            // InternalModelDraw.g:309:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )?
            {
            // InternalModelDraw.g:309:3: ()
            // InternalModelDraw.g:310:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeAccess().getNodeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:316:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:317:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:317:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:318:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:329:3: (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelDraw.g:330:4: otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalModelDraw.g:334:4: ( (lv_feature_3_0= ruleValuedFeature ) )
                    // InternalModelDraw.g:335:5: (lv_feature_3_0= ruleValuedFeature )
                    {
                    // InternalModelDraw.g:335:5: (lv_feature_3_0= ruleValuedFeature )
                    // InternalModelDraw.g:336:6: lv_feature_3_0= ruleValuedFeature
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_feature_3_0=ruleValuedFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						add(
                    							current,
                    							"feature",
                    							lv_feature_3_0,
                    							"wodeledu.dsls.ModelDraw.ValuedFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:353:4: (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalModelDraw.g:354:5: otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_11); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalModelDraw.g:358:5: ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    // InternalModelDraw.g:359:6: (lv_feature_5_0= ruleValuedFeature )
                    	    {
                    	    // InternalModelDraw.g:359:6: (lv_feature_5_0= ruleValuedFeature )
                    	    // InternalModelDraw.g:360:7: lv_feature_5_0= ruleValuedFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_feature_5_0=ruleValuedFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"feature",
                    	    								lv_feature_5_0,
                    	    								"wodeledu.dsls.ModelDraw.ValuedFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_13); 

                    				newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:383:3: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelDraw.g:384:4: otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )?
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalModelDraw.g:388:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:389:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:389:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:390:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_14); 

                    						newLeafNode(otherlv_8, grammarAccess.getNodeAccess().getTargetNodeEClassCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalModelDraw.g:401:4: (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalModelDraw.g:402:5: otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')'
                            {
                            otherlv_9=(Token)match(input,15,FOLLOW_11); 

                            					newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_3_2_0());
                            				
                            // InternalModelDraw.g:406:5: ( (lv_targetFeature_10_0= ruleValuedFeature ) )
                            // InternalModelDraw.g:407:6: (lv_targetFeature_10_0= ruleValuedFeature )
                            {
                            // InternalModelDraw.g:407:6: (lv_targetFeature_10_0= ruleValuedFeature )
                            // InternalModelDraw.g:408:7: lv_targetFeature_10_0= ruleValuedFeature
                            {

                            							newCompositeNode(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_1_0());
                            						
                            pushFollow(FOLLOW_12);
                            lv_targetFeature_10_0=ruleValuedFeature();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getNodeRule());
                            							}
                            							add(
                            								current,
                            								"targetFeature",
                            								lv_targetFeature_10_0,
                            								"wodeledu.dsls.ModelDraw.ValuedFeature");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalModelDraw.g:425:5: (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==16) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalModelDraw.g:426:6: otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) )
                            	    {
                            	    otherlv_11=(Token)match(input,16,FOLLOW_11); 

                            	    						newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getCommaKeyword_3_2_2_0());
                            	    					
                            	    // InternalModelDraw.g:430:6: ( (lv_targetFeature_12_0= ruleValuedFeature ) )
                            	    // InternalModelDraw.g:431:7: (lv_targetFeature_12_0= ruleValuedFeature )
                            	    {
                            	    // InternalModelDraw.g:431:7: (lv_targetFeature_12_0= ruleValuedFeature )
                            	    // InternalModelDraw.g:432:8: lv_targetFeature_12_0= ruleValuedFeature
                            	    {

                            	    								newCompositeNode(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_2_1_0());
                            	    							
                            	    pushFollow(FOLLOW_12);
                            	    lv_targetFeature_12_0=ruleValuedFeature();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getNodeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"targetFeature",
                            	    									lv_targetFeature_12_0,
                            	    									"wodeledu.dsls.ModelDraw.ValuedFeature");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);

                            otherlv_13=(Token)match(input,17,FOLLOW_6); 

                            					newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getRightParenthesisKeyword_3_2_3());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getColonKeyword_4());
            		
            // InternalModelDraw.g:460:3: ( (lv_type_15_0= ruleNodeType ) )
            // InternalModelDraw.g:461:4: (lv_type_15_0= ruleNodeType )
            {
            // InternalModelDraw.g:461:4: (lv_type_15_0= ruleNodeType )
            // InternalModelDraw.g:462:5: lv_type_15_0= ruleNodeType
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_15_0=ruleNodeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_15_0,
            						"wodeledu.dsls.ModelDraw.NodeType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelDraw.g:479:3: (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelDraw.g:480:4: otherlv_16= '=' ( (otherlv_17= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_16, grammarAccess.getNodeAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:484:4: ( (otherlv_17= RULE_ID ) )
                    // InternalModelDraw.g:485:5: (otherlv_17= RULE_ID )
                    {
                    // InternalModelDraw.g:485:5: (otherlv_17= RULE_ID )
                    // InternalModelDraw.g:486:6: otherlv_17= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_17); 

                    						newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:498:3: (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelDraw.g:499:4: otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}'
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getCompartmentsKeyword_7_0());
                    			
                    otherlv_19=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_19, grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1());
                    			
                    otherlv_20=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_20, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_7_2());
                    			
                    // InternalModelDraw.g:511:4: ( (otherlv_21= RULE_ID ) )
                    // InternalModelDraw.g:512:5: (otherlv_21= RULE_ID )
                    {
                    // InternalModelDraw.g:512:5: (otherlv_21= RULE_ID )
                    // InternalModelDraw.g:513:6: otherlv_21= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(otherlv_21, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_3_0());
                    					

                    }


                    }

                    // InternalModelDraw.g:524:4: ( (otherlv_22= RULE_ID ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalModelDraw.g:525:5: (otherlv_22= RULE_ID )
                    	    {
                    	    // InternalModelDraw.g:525:5: (otherlv_22= RULE_ID )
                    	    // InternalModelDraw.g:526:6: otherlv_22= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_9); 

                    	    						newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_4_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_23, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_7_5());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:542:3: (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==21) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:543:4: otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )?
                    {
                    otherlv_24=(Token)match(input,21,FOLLOW_18); 

                    				newLeafNode(otherlv_24, grammarAccess.getNodeAccess().getShapeKeyword_8_0());
                    			
                    otherlv_25=(Token)match(input,19,FOLLOW_20); 

                    				newLeafNode(otherlv_25, grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:551:4: ( (lv_shape_26_0= ruleNodeShape ) )
                    // InternalModelDraw.g:552:5: (lv_shape_26_0= ruleNodeShape )
                    {
                    // InternalModelDraw.g:552:5: (lv_shape_26_0= ruleNodeShape )
                    // InternalModelDraw.g:553:6: lv_shape_26_0= ruleNodeShape
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_shape_26_0=ruleNodeShape();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"shape",
                    							lv_shape_26_0,
                    							"wodeledu.dsls.ModelDraw.NodeShape");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:570:4: (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==15) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalModelDraw.g:571:5: otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')'
                            {
                            otherlv_27=(Token)match(input,15,FOLLOW_3); 

                            					newLeafNode(otherlv_27, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_8_3_0());
                            				
                            // InternalModelDraw.g:575:5: ( (lv_pathShape_28_0= ruleEString ) )
                            // InternalModelDraw.g:576:6: (lv_pathShape_28_0= ruleEString )
                            {
                            // InternalModelDraw.g:576:6: (lv_pathShape_28_0= ruleEString )
                            // InternalModelDraw.g:577:7: lv_pathShape_28_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getNodeAccess().getPathShapeEStringParserRuleCall_8_3_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_pathShape_28_0=ruleEString();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getNodeRule());
                            							}
                            							set(
                            								current,
                            								"pathShape",
                            								lv_pathShape_28_0,
                            								"wodeledu.dsls.ModelDraw.EString");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_29=(Token)match(input,17,FOLLOW_23); 

                            					newLeafNode(otherlv_29, grammarAccess.getNodeAccess().getRightParenthesisKeyword_8_3_2());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:600:3: (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalModelDraw.g:601:4: otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) )
                    {
                    otherlv_30=(Token)match(input,22,FOLLOW_18); 

                    				newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getColorKeyword_9_0());
                    			
                    otherlv_31=(Token)match(input,19,FOLLOW_24); 

                    				newLeafNode(otherlv_31, grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:609:4: ( (lv_color_32_0= ruleNodeColor ) )
                    // InternalModelDraw.g:610:5: (lv_color_32_0= ruleNodeColor )
                    {
                    // InternalModelDraw.g:610:5: (lv_color_32_0= ruleNodeColor )
                    // InternalModelDraw.g:611:6: lv_color_32_0= ruleNodeColor
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_color_32_0=ruleNodeColor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"color",
                    							lv_color_32_0,
                    							"wodeledu.dsls.ModelDraw.NodeColor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:629:3: (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:630:4: otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) )
                    {
                    otherlv_33=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_33, grammarAccess.getNodeAccess().getStyleKeyword_10_0());
                    			
                    otherlv_34=(Token)match(input,19,FOLLOW_26); 

                    				newLeafNode(otherlv_34, grammarAccess.getNodeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:638:4: ( (lv_style_35_0= ruleNodeStyle ) )
                    // InternalModelDraw.g:639:5: (lv_style_35_0= ruleNodeStyle )
                    {
                    // InternalModelDraw.g:639:5: (lv_style_35_0= ruleNodeStyle )
                    // InternalModelDraw.g:640:6: lv_style_35_0= ruleNodeStyle
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_style_35_0=ruleNodeStyle();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"style",
                    							lv_style_35_0,
                    							"wodeledu.dsls.ModelDraw.NodeStyle");
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
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleValuedFeature"
    // InternalModelDraw.g:662:1: entryRuleValuedFeature returns [EObject current=null] : iv_ruleValuedFeature= ruleValuedFeature EOF ;
    public final EObject entryRuleValuedFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedFeature = null;


        try {
            // InternalModelDraw.g:662:54: (iv_ruleValuedFeature= ruleValuedFeature EOF )
            // InternalModelDraw.g:663:2: iv_ruleValuedFeature= ruleValuedFeature EOF
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
    // InternalModelDraw.g:669:1: ruleValuedFeature returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) ;
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
            // InternalModelDraw.g:675:2: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) )
            // InternalModelDraw.g:676:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            {
            // InternalModelDraw.g:676:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            // InternalModelDraw.g:677:3: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            {
            // InternalModelDraw.g:677:3: ()
            // InternalModelDraw.g:678:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:684:3: ( (lv_negation_1_0= 'not' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:685:4: (lv_negation_1_0= 'not' )
                    {
                    // InternalModelDraw.g:685:4: (lv_negation_1_0= 'not' )
                    // InternalModelDraw.g:686:5: lv_negation_1_0= 'not'
                    {
                    lv_negation_1_0=(Token)match(input,24,FOLLOW_4); 

                    					newLeafNode(lv_negation_1_0, grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getValuedFeatureRule());
                    					}
                    					setWithLastConsumed(current, "negation", lv_negation_1_0 != null, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:698:3: ( (otherlv_2= RULE_ID ) )
            // InternalModelDraw.g:699:4: (otherlv_2= RULE_ID )
            {
            // InternalModelDraw.g:699:4: (otherlv_2= RULE_ID )
            // InternalModelDraw.g:700:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValuedFeatureRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(otherlv_2, grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalModelDraw.g:711:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:712:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalModelDraw.g:716:4: ( (otherlv_4= RULE_ID ) )
                    // InternalModelDraw.g:717:5: (otherlv_4= RULE_ID )
                    {
                    // InternalModelDraw.g:717:5: (otherlv_4= RULE_ID )
                    // InternalModelDraw.g:718:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValuedFeatureRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(otherlv_4, grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:730:3: (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:731:4: otherlv_5= '==' ( (lv_value_6_0= 'null' ) )
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_29); 

                    				newLeafNode(otherlv_5, grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0());
                    			
                    // InternalModelDraw.g:735:4: ( (lv_value_6_0= 'null' ) )
                    // InternalModelDraw.g:736:5: (lv_value_6_0= 'null' )
                    {
                    // InternalModelDraw.g:736:5: (lv_value_6_0= 'null' )
                    // InternalModelDraw.g:737:6: lv_value_6_0= 'null'
                    {
                    lv_value_6_0=(Token)match(input,26,FOLLOW_2); 

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


    // $ANTLR start "entryRuleRelation"
    // InternalModelDraw.g:754:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalModelDraw.g:754:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalModelDraw.g:755:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalModelDraw.g:761:1: ruleRelation returns [EObject current=null] : (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_Edge_0 = null;

        EObject this_Level_1 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:767:2: ( (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) )
            // InternalModelDraw.g:768:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            {
            // InternalModelDraw.g:768:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==15||LA21_1==18) ) {
                    alt21=1;
                }
                else if ( (LA21_1==29) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalModelDraw.g:769:3: this_Edge_0= ruleEdge
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getEdgeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Edge_0=ruleEdge();

                    state._fsp--;


                    			current = this_Edge_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:778:3: this_Level_1= ruleLevel
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getLevelParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Level_1=ruleLevel();

                    state._fsp--;


                    			current = this_Level_1;
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
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleEdge"
    // InternalModelDraw.g:790:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // InternalModelDraw.g:790:45: (iv_ruleEdge= ruleEdge EOF )
            // InternalModelDraw.g:791:2: iv_ruleEdge= ruleEdge EOF
            {
             newCompositeNode(grammarAccess.getEdgeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEdge=ruleEdge();

            state._fsp--;

             current =iv_ruleEdge; 
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
    // $ANTLR end "entryRuleEdge"


    // $ANTLR start "ruleEdge"
    // InternalModelDraw.g:797:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? ) ;
    public final EObject ruleEdge() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
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
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_56=null;
        Token otherlv_57=null;
        Token otherlv_58=null;
        Token otherlv_60=null;
        Token otherlv_61=null;
        Token otherlv_62=null;
        Token otherlv_63=null;
        Token otherlv_64=null;
        Token otherlv_66=null;
        Token otherlv_67=null;
        Token otherlv_68=null;
        EObject lv_feature_3_0 = null;

        EObject lv_feature_5_0 = null;

        EObject lv_targetFeature_15_0 = null;

        EObject lv_targetFeature_17_0 = null;

        Enumerator lv_src_decoration_59_0 = null;

        Enumerator lv_tar_decoration_65_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:803:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:804:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:804:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? )
            // InternalModelDraw.g:805:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:805:3: ()
            // InternalModelDraw.g:806:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEdgeAccess().getEdgeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:812:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:813:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:813:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:814:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:825:3: (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==24) ) {
                    alt23=1;
                }
                else if ( (LA23_1==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                        case 18:
                        case 25:
                            {
                            alt23=1;
                            }
                            break;
                        case 16:
                            {
                            int LA23_5 = input.LA(4);

                            if ( (LA23_5==24) ) {
                                alt23=1;
                            }
                            else if ( (LA23_5==RULE_ID) ) {
                                int LA23_7 = input.LA(5);

                                if ( (LA23_7==16||LA23_7==18||LA23_7==25) ) {
                                    alt23=1;
                                }
                                else if ( (LA23_7==17) ) {
                                    int LA23_6 = input.LA(6);

                                    if ( (LA23_6==15||LA23_6==18) ) {
                                        alt23=1;
                                    }
                                }
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA23_6 = input.LA(4);

                            if ( (LA23_6==15||LA23_6==18) ) {
                                alt23=1;
                            }
                            }
                            break;
                    }

                }
            }
            switch (alt23) {
                case 1 :
                    // InternalModelDraw.g:826:4: otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalModelDraw.g:830:4: ( (lv_feature_3_0= ruleValuedFeature ) )
                    // InternalModelDraw.g:831:5: (lv_feature_3_0= ruleValuedFeature )
                    {
                    // InternalModelDraw.g:831:5: (lv_feature_3_0= ruleValuedFeature )
                    // InternalModelDraw.g:832:6: lv_feature_3_0= ruleValuedFeature
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_feature_3_0=ruleValuedFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						add(
                    							current,
                    							"feature",
                    							lv_feature_3_0,
                    							"wodeledu.dsls.ModelDraw.ValuedFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:849:4: (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==16) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalModelDraw.g:850:5: otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_11); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalModelDraw.g:854:5: ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    // InternalModelDraw.g:855:6: (lv_feature_5_0= ruleValuedFeature )
                    	    {
                    	    // InternalModelDraw.g:855:6: (lv_feature_5_0= ruleValuedFeature )
                    	    // InternalModelDraw.g:856:7: lv_feature_5_0= ruleValuedFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_feature_5_0=ruleValuedFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEdgeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"feature",
                    	    								lv_feature_5_0,
                    	    								"wodeledu.dsls.ModelDraw.ValuedFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_30); 

                    				newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:879:3: ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==15) ) {
                alt27=1;
            }
            else if ( (LA27_0==18) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:880:4: (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' )
                    {
                    // InternalModelDraw.g:880:4: (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')' )
                    // InternalModelDraw.g:881:5: otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_4); 

                    					newLeafNode(otherlv_7, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_0_0());
                    				
                    // InternalModelDraw.g:885:5: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:886:6: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:886:6: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:887:7: otherlv_8= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEdgeRule());
                    							}
                    						
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_12); 

                    							newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0_1_0());
                    						

                    }


                    }

                    // InternalModelDraw.g:898:5: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==16) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalModelDraw.g:899:6: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            {
                            otherlv_9=(Token)match(input,16,FOLLOW_4); 

                            						newLeafNode(otherlv_9, grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2_0());
                            					
                            // InternalModelDraw.g:903:6: ( (otherlv_10= RULE_ID ) )
                            // InternalModelDraw.g:904:7: (otherlv_10= RULE_ID )
                            {
                            // InternalModelDraw.g:904:7: (otherlv_10= RULE_ID )
                            // InternalModelDraw.g:905:8: otherlv_10= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getEdgeRule());
                            								}
                            							
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_22); 

                            								newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_2_1_0());
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_6); 

                    					newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:923:4: (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? )
                    {
                    // InternalModelDraw.g:923:4: (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? )
                    // InternalModelDraw.g:924:5: otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )?
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_4); 

                    					newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    				
                    // InternalModelDraw.g:928:5: ( (otherlv_13= RULE_ID ) )
                    // InternalModelDraw.g:929:6: (otherlv_13= RULE_ID )
                    {
                    // InternalModelDraw.g:929:6: (otherlv_13= RULE_ID )
                    // InternalModelDraw.g:930:7: otherlv_13= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEdgeRule());
                    							}
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_14); 

                    							newLeafNode(otherlv_13, grammarAccess.getEdgeAccess().getTargetNodeEClassCrossReference_3_1_1_0());
                    						

                    }


                    }

                    // InternalModelDraw.g:941:5: (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==15) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalModelDraw.g:942:6: otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')'
                            {
                            otherlv_14=(Token)match(input,15,FOLLOW_11); 

                            						newLeafNode(otherlv_14, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_1_2_0());
                            					
                            // InternalModelDraw.g:946:6: ( (lv_targetFeature_15_0= ruleValuedFeature ) )
                            // InternalModelDraw.g:947:7: (lv_targetFeature_15_0= ruleValuedFeature )
                            {
                            // InternalModelDraw.g:947:7: (lv_targetFeature_15_0= ruleValuedFeature )
                            // InternalModelDraw.g:948:8: lv_targetFeature_15_0= ruleValuedFeature
                            {

                            								newCompositeNode(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_1_0());
                            							
                            pushFollow(FOLLOW_12);
                            lv_targetFeature_15_0=ruleValuedFeature();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEdgeRule());
                            								}
                            								add(
                            									current,
                            									"targetFeature",
                            									lv_targetFeature_15_0,
                            									"wodeledu.dsls.ModelDraw.ValuedFeature");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalModelDraw.g:965:6: (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==16) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // InternalModelDraw.g:966:7: otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) )
                            	    {
                            	    otherlv_16=(Token)match(input,16,FOLLOW_11); 

                            	    							newLeafNode(otherlv_16, grammarAccess.getEdgeAccess().getCommaKeyword_3_1_2_2_0());
                            	    						
                            	    // InternalModelDraw.g:970:7: ( (lv_targetFeature_17_0= ruleValuedFeature ) )
                            	    // InternalModelDraw.g:971:8: (lv_targetFeature_17_0= ruleValuedFeature )
                            	    {
                            	    // InternalModelDraw.g:971:8: (lv_targetFeature_17_0= ruleValuedFeature )
                            	    // InternalModelDraw.g:972:9: lv_targetFeature_17_0= ruleValuedFeature
                            	    {

                            	    									newCompositeNode(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_12);
                            	    lv_targetFeature_17_0=ruleValuedFeature();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getEdgeRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"targetFeature",
                            	    										lv_targetFeature_17_0,
                            	    										"wodeledu.dsls.ModelDraw.ValuedFeature");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);

                            otherlv_18=(Token)match(input,17,FOLLOW_6); 

                            						newLeafNode(otherlv_18, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_1_2_3());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_19, grammarAccess.getEdgeAccess().getColonKeyword_4());
            		
            otherlv_20=(Token)match(input,27,FOLLOW_32); 

            			newLeafNode(otherlv_20, grammarAccess.getEdgeAccess().getEdgeKeyword_5());
            		
            // InternalModelDraw.g:1005:3: (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==19) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:1006:4: otherlv_21= '=' ( (otherlv_22= RULE_ID ) )
                    {
                    otherlv_21=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_21, grammarAccess.getEdgeAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:1010:4: ( (otherlv_22= RULE_ID ) )
                    // InternalModelDraw.g:1011:5: (otherlv_22= RULE_ID )
                    {
                    // InternalModelDraw.g:1011:5: (otherlv_22= RULE_ID )
                    // InternalModelDraw.g:1012:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_33); 

                    						newLeafNode(otherlv_22, grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1024:3: (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==28) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalModelDraw.g:1025:4: otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) )
                    {
                    otherlv_23=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_23, grammarAccess.getEdgeAccess().getLabelKeyword_7_0());
                    			
                    otherlv_24=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_24, grammarAccess.getEdgeAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:1033:4: ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ID) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==13) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalModelDraw.g:1034:5: ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) )
                            {
                            // InternalModelDraw.g:1034:5: ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) )
                            // InternalModelDraw.g:1035:6: ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) )
                            {
                            // InternalModelDraw.g:1035:6: ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )?
                            int alt30=2;
                            int LA30_0 = input.LA(1);

                            if ( (LA30_0==RULE_ID) ) {
                                int LA30_1 = input.LA(2);

                                if ( (LA30_1==18||LA30_1==29) ) {
                                    alt30=1;
                                }
                            }
                            switch (alt30) {
                                case 1 :
                                    // InternalModelDraw.g:1036:7: ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.'
                                    {
                                    // InternalModelDraw.g:1036:7: ( (otherlv_25= RULE_ID ) )
                                    // InternalModelDraw.g:1037:8: (otherlv_25= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1037:8: (otherlv_25= RULE_ID )
                                    // InternalModelDraw.g:1038:9: otherlv_25= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_25, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1049:7: (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )?
                                    int alt29=2;
                                    int LA29_0 = input.LA(1);

                                    if ( (LA29_0==18) ) {
                                        alt29=1;
                                    }
                                    switch (alt29) {
                                        case 1 :
                                            // InternalModelDraw.g:1050:8: otherlv_26= '->' ( (otherlv_27= RULE_ID ) )
                                            {
                                            otherlv_26=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_26, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0());
                                            							
                                            // InternalModelDraw.g:1054:8: ( (otherlv_27= RULE_ID ) )
                                            // InternalModelDraw.g:1055:9: (otherlv_27= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1055:9: (otherlv_27= RULE_ID )
                                            // InternalModelDraw.g:1056:10: otherlv_27= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getEdgeRule());
                                            										}
                                            									
                                            otherlv_27=(Token)match(input,RULE_ID,FOLLOW_36); 

                                            										newLeafNode(otherlv_27, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0());
                                            									

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_28=(Token)match(input,29,FOLLOW_4); 

                                    							newLeafNode(otherlv_28, grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_0_0_2());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1073:6: ( (otherlv_29= RULE_ID ) )
                            // InternalModelDraw.g:1074:7: (otherlv_29= RULE_ID )
                            {
                            // InternalModelDraw.g:1074:7: (otherlv_29= RULE_ID )
                            // InternalModelDraw.g:1075:8: otherlv_29= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getEdgeRule());
                            								}
                            							
                            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_37); 

                            								newLeafNode(otherlv_29, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_0_1_0());
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalModelDraw.g:1088:5: (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' )
                            {
                            // InternalModelDraw.g:1088:5: (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' )
                            // InternalModelDraw.g:1089:6: otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}'
                            {
                            otherlv_30=(Token)match(input,13,FOLLOW_4); 

                            						newLeafNode(otherlv_30, grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_7_2_1_0());
                            					
                            // InternalModelDraw.g:1093:6: ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )?
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==RULE_ID) ) {
                                int LA32_1 = input.LA(2);

                                if ( (LA32_1==18||LA32_1==29) ) {
                                    alt32=1;
                                }
                            }
                            switch (alt32) {
                                case 1 :
                                    // InternalModelDraw.g:1094:7: ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.'
                                    {
                                    // InternalModelDraw.g:1094:7: ( (otherlv_31= RULE_ID ) )
                                    // InternalModelDraw.g:1095:8: (otherlv_31= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1095:8: (otherlv_31= RULE_ID )
                                    // InternalModelDraw.g:1096:9: otherlv_31= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_31, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1107:7: (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )?
                                    int alt31=2;
                                    int LA31_0 = input.LA(1);

                                    if ( (LA31_0==18) ) {
                                        alt31=1;
                                    }
                                    switch (alt31) {
                                        case 1 :
                                            // InternalModelDraw.g:1108:8: otherlv_32= '->' ( (otherlv_33= RULE_ID ) )
                                            {
                                            otherlv_32=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_32, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0());
                                            							
                                            // InternalModelDraw.g:1112:8: ( (otherlv_33= RULE_ID ) )
                                            // InternalModelDraw.g:1113:9: (otherlv_33= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1113:9: (otherlv_33= RULE_ID )
                                            // InternalModelDraw.g:1114:10: otherlv_33= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getEdgeRule());
                                            										}
                                            									
                                            otherlv_33=(Token)match(input,RULE_ID,FOLLOW_36); 

                                            										newLeafNode(otherlv_33, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0());
                                            									

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_34=(Token)match(input,29,FOLLOW_4); 

                                    							newLeafNode(otherlv_34, grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_1_2());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1131:6: ( (otherlv_35= RULE_ID ) )
                            // InternalModelDraw.g:1132:7: (otherlv_35= RULE_ID )
                            {
                            // InternalModelDraw.g:1132:7: (otherlv_35= RULE_ID )
                            // InternalModelDraw.g:1133:8: otherlv_35= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getEdgeRule());
                            								}
                            							
                            otherlv_35=(Token)match(input,RULE_ID,FOLLOW_38); 

                            								newLeafNode(otherlv_35, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_2_0());
                            							

                            }


                            }

                            // InternalModelDraw.g:1144:6: (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )?
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==15) ) {
                                alt35=1;
                            }
                            switch (alt35) {
                                case 1 :
                                    // InternalModelDraw.g:1145:7: otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')'
                                    {
                                    otherlv_36=(Token)match(input,15,FOLLOW_4); 

                                    							newLeafNode(otherlv_36, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_3_0());
                                    						
                                    // InternalModelDraw.g:1149:7: ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )?
                                    int alt34=2;
                                    int LA34_0 = input.LA(1);

                                    if ( (LA34_0==RULE_ID) ) {
                                        int LA34_1 = input.LA(2);

                                        if ( (LA34_1==18||LA34_1==29) ) {
                                            alt34=1;
                                        }
                                    }
                                    switch (alt34) {
                                        case 1 :
                                            // InternalModelDraw.g:1150:8: ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.'
                                            {
                                            // InternalModelDraw.g:1150:8: ( (otherlv_37= RULE_ID ) )
                                            // InternalModelDraw.g:1151:9: (otherlv_37= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1151:9: (otherlv_37= RULE_ID )
                                            // InternalModelDraw.g:1152:10: otherlv_37= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getEdgeRule());
                                            										}
                                            									
                                            otherlv_37=(Token)match(input,RULE_ID,FOLLOW_35); 

                                            										newLeafNode(otherlv_37, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0());
                                            									

                                            }


                                            }

                                            // InternalModelDraw.g:1163:8: (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )?
                                            int alt33=2;
                                            int LA33_0 = input.LA(1);

                                            if ( (LA33_0==18) ) {
                                                alt33=1;
                                            }
                                            switch (alt33) {
                                                case 1 :
                                                    // InternalModelDraw.g:1164:9: otherlv_38= '->' ( (otherlv_39= RULE_ID ) )
                                                    {
                                                    otherlv_38=(Token)match(input,18,FOLLOW_4); 

                                                    									newLeafNode(otherlv_38, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0());
                                                    								
                                                    // InternalModelDraw.g:1168:9: ( (otherlv_39= RULE_ID ) )
                                                    // InternalModelDraw.g:1169:10: (otherlv_39= RULE_ID )
                                                    {
                                                    // InternalModelDraw.g:1169:10: (otherlv_39= RULE_ID )
                                                    // InternalModelDraw.g:1170:11: otherlv_39= RULE_ID
                                                    {

                                                    											if (current==null) {
                                                    												current = createModelElement(grammarAccess.getEdgeRule());
                                                    											}
                                                    										
                                                    otherlv_39=(Token)match(input,RULE_ID,FOLLOW_36); 

                                                    											newLeafNode(otherlv_39, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0());
                                                    										

                                                    }


                                                    }


                                                    }
                                                    break;

                                            }

                                            otherlv_40=(Token)match(input,29,FOLLOW_4); 

                                            								newLeafNode(otherlv_40, grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_3_1_2());
                                            							

                                            }
                                            break;

                                    }

                                    // InternalModelDraw.g:1187:7: ( (otherlv_41= RULE_ID ) )
                                    // InternalModelDraw.g:1188:8: (otherlv_41= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1188:8: (otherlv_41= RULE_ID )
                                    // InternalModelDraw.g:1189:9: otherlv_41= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_41=(Token)match(input,RULE_ID,FOLLOW_22); 

                                    									newLeafNode(otherlv_41, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0());
                                    								

                                    }


                                    }

                                    otherlv_42=(Token)match(input,17,FOLLOW_39); 

                                    							newLeafNode(otherlv_42, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_3_3());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1205:6: (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==16) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalModelDraw.g:1206:7: otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )?
                            	    {
                            	    otherlv_43=(Token)match(input,16,FOLLOW_4); 

                            	    							newLeafNode(otherlv_43, grammarAccess.getEdgeAccess().getCommaKeyword_7_2_1_4_0());
                            	    						
                            	    // InternalModelDraw.g:1210:7: ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )?
                            	    int alt37=2;
                            	    int LA37_0 = input.LA(1);

                            	    if ( (LA37_0==RULE_ID) ) {
                            	        int LA37_1 = input.LA(2);

                            	        if ( (LA37_1==18||LA37_1==29) ) {
                            	            alt37=1;
                            	        }
                            	    }
                            	    switch (alt37) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1211:8: ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.'
                            	            {
                            	            // InternalModelDraw.g:1211:8: ( (otherlv_44= RULE_ID ) )
                            	            // InternalModelDraw.g:1212:9: (otherlv_44= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1212:9: (otherlv_44= RULE_ID )
                            	            // InternalModelDraw.g:1213:10: otherlv_44= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getEdgeRule());
                            	            										}
                            	            									
                            	            otherlv_44=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	            										newLeafNode(otherlv_44, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0());
                            	            									

                            	            }


                            	            }

                            	            // InternalModelDraw.g:1224:8: (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )?
                            	            int alt36=2;
                            	            int LA36_0 = input.LA(1);

                            	            if ( (LA36_0==18) ) {
                            	                alt36=1;
                            	            }
                            	            switch (alt36) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1225:9: otherlv_45= '->' ( (otherlv_46= RULE_ID ) )
                            	                    {
                            	                    otherlv_45=(Token)match(input,18,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_45, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0());
                            	                    								
                            	                    // InternalModelDraw.g:1229:9: ( (otherlv_46= RULE_ID ) )
                            	                    // InternalModelDraw.g:1230:10: (otherlv_46= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1230:10: (otherlv_46= RULE_ID )
                            	                    // InternalModelDraw.g:1231:11: otherlv_46= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getEdgeRule());
                            	                    											}
                            	                    										
                            	                    otherlv_46=(Token)match(input,RULE_ID,FOLLOW_36); 

                            	                    											newLeafNode(otherlv_46, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0());
                            	                    										

                            	                    }


                            	                    }


                            	                    }
                            	                    break;

                            	            }

                            	            otherlv_47=(Token)match(input,29,FOLLOW_4); 

                            	            								newLeafNode(otherlv_47, grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_1_2());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalModelDraw.g:1248:7: ( (otherlv_48= RULE_ID ) )
                            	    // InternalModelDraw.g:1249:8: (otherlv_48= RULE_ID )
                            	    {
                            	    // InternalModelDraw.g:1249:8: (otherlv_48= RULE_ID )
                            	    // InternalModelDraw.g:1250:9: otherlv_48= RULE_ID
                            	    {

                            	    									if (current==null) {
                            	    										current = createModelElement(grammarAccess.getEdgeRule());
                            	    									}
                            	    								
                            	    otherlv_48=(Token)match(input,RULE_ID,FOLLOW_38); 

                            	    									newLeafNode(otherlv_48, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0());
                            	    								

                            	    }


                            	    }

                            	    // InternalModelDraw.g:1261:7: (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )?
                            	    int alt40=2;
                            	    int LA40_0 = input.LA(1);

                            	    if ( (LA40_0==15) ) {
                            	        alt40=1;
                            	    }
                            	    switch (alt40) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1262:8: otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')'
                            	            {
                            	            otherlv_49=(Token)match(input,15,FOLLOW_4); 

                            	            								newLeafNode(otherlv_49, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_4_3_0());
                            	            							
                            	            // InternalModelDraw.g:1266:8: ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )?
                            	            int alt39=2;
                            	            int LA39_0 = input.LA(1);

                            	            if ( (LA39_0==RULE_ID) ) {
                            	                int LA39_1 = input.LA(2);

                            	                if ( (LA39_1==18||LA39_1==29) ) {
                            	                    alt39=1;
                            	                }
                            	            }
                            	            switch (alt39) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1267:9: ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.'
                            	                    {
                            	                    // InternalModelDraw.g:1267:9: ( (otherlv_50= RULE_ID ) )
                            	                    // InternalModelDraw.g:1268:10: (otherlv_50= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1268:10: (otherlv_50= RULE_ID )
                            	                    // InternalModelDraw.g:1269:11: otherlv_50= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getEdgeRule());
                            	                    											}
                            	                    										
                            	                    otherlv_50=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	                    											newLeafNode(otherlv_50, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0());
                            	                    										

                            	                    }


                            	                    }

                            	                    // InternalModelDraw.g:1280:9: (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )?
                            	                    int alt38=2;
                            	                    int LA38_0 = input.LA(1);

                            	                    if ( (LA38_0==18) ) {
                            	                        alt38=1;
                            	                    }
                            	                    switch (alt38) {
                            	                        case 1 :
                            	                            // InternalModelDraw.g:1281:10: otherlv_51= '->' ( (otherlv_52= RULE_ID ) )
                            	                            {
                            	                            otherlv_51=(Token)match(input,18,FOLLOW_4); 

                            	                            										newLeafNode(otherlv_51, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0());
                            	                            									
                            	                            // InternalModelDraw.g:1285:10: ( (otherlv_52= RULE_ID ) )
                            	                            // InternalModelDraw.g:1286:11: (otherlv_52= RULE_ID )
                            	                            {
                            	                            // InternalModelDraw.g:1286:11: (otherlv_52= RULE_ID )
                            	                            // InternalModelDraw.g:1287:12: otherlv_52= RULE_ID
                            	                            {

                            	                            												if (current==null) {
                            	                            													current = createModelElement(grammarAccess.getEdgeRule());
                            	                            												}
                            	                            											
                            	                            otherlv_52=(Token)match(input,RULE_ID,FOLLOW_36); 

                            	                            												newLeafNode(otherlv_52, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0());
                            	                            											

                            	                            }


                            	                            }


                            	                            }
                            	                            break;

                            	                    }

                            	                    otherlv_53=(Token)match(input,29,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_53, grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_3_1_2());
                            	                    								

                            	                    }
                            	                    break;

                            	            }

                            	            // InternalModelDraw.g:1304:8: ( (otherlv_54= RULE_ID ) )
                            	            // InternalModelDraw.g:1305:9: (otherlv_54= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1305:9: (otherlv_54= RULE_ID )
                            	            // InternalModelDraw.g:1306:10: otherlv_54= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getEdgeRule());
                            	            										}
                            	            									
                            	            otherlv_54=(Token)match(input,RULE_ID,FOLLOW_22); 

                            	            										newLeafNode(otherlv_54, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0());
                            	            									

                            	            }


                            	            }

                            	            otherlv_55=(Token)match(input,17,FOLLOW_39); 

                            	            								newLeafNode(otherlv_55, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_4_3_3());
                            	            							

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop41;
                                }
                            } while (true);

                            otherlv_56=(Token)match(input,14,FOLLOW_37); 

                            						newLeafNode(otherlv_56, grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_7_2_1_5());
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1330:3: (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==30) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalModelDraw.g:1331:4: otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) )
                    {
                    otherlv_57=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_57, grammarAccess.getEdgeAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_58=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_58, grammarAccess.getEdgeAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:1339:4: ( (lv_src_decoration_59_0= ruleDecoration ) )
                    // InternalModelDraw.g:1340:5: (lv_src_decoration_59_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1340:5: (lv_src_decoration_59_0= ruleDecoration )
                    // InternalModelDraw.g:1341:6: lv_src_decoration_59_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_src_decoration_59_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"src_decoration",
                    							lv_src_decoration_59_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1359:3: (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==31) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalModelDraw.g:1360:4: otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) )
                    {
                    otherlv_60=(Token)match(input,31,FOLLOW_18); 

                    				newLeafNode(otherlv_60, grammarAccess.getEdgeAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_61=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_61, grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1368:4: ( (otherlv_62= RULE_ID ) )
                    // InternalModelDraw.g:1369:5: (otherlv_62= RULE_ID )
                    {
                    // InternalModelDraw.g:1369:5: (otherlv_62= RULE_ID )
                    // InternalModelDraw.g:1370:6: otherlv_62= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_62=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_62, grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_9_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1382:3: (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==32) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalModelDraw.g:1383:4: otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) )
                    {
                    otherlv_63=(Token)match(input,32,FOLLOW_18); 

                    				newLeafNode(otherlv_63, grammarAccess.getEdgeAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_64=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_64, grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1391:4: ( (lv_tar_decoration_65_0= ruleDecoration ) )
                    // InternalModelDraw.g:1392:5: (lv_tar_decoration_65_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1392:5: (lv_tar_decoration_65_0= ruleDecoration )
                    // InternalModelDraw.g:1393:6: lv_tar_decoration_65_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_tar_decoration_65_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"tar_decoration",
                    							lv_tar_decoration_65_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1411:3: (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalModelDraw.g:1412:4: otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) )
                    {
                    otherlv_66=(Token)match(input,33,FOLLOW_18); 

                    				newLeafNode(otherlv_66, grammarAccess.getEdgeAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_67=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_67, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1420:4: ( (otherlv_68= RULE_ID ) )
                    // InternalModelDraw.g:1421:5: (otherlv_68= RULE_ID )
                    {
                    // InternalModelDraw.g:1421:5: (otherlv_68= RULE_ID )
                    // InternalModelDraw.g:1422:6: otherlv_68= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_68=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_68, grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_11_2_0());
                    					

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
    // $ANTLR end "ruleEdge"


    // $ANTLR start "entryRuleLevel"
    // InternalModelDraw.g:1438:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // InternalModelDraw.g:1438:46: (iv_ruleLevel= ruleLevel EOF )
            // InternalModelDraw.g:1439:2: iv_ruleLevel= ruleLevel EOF
            {
             newCompositeNode(grammarAccess.getLevelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLevel=ruleLevel();

            state._fsp--;

             current =iv_ruleLevel; 
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
    // $ANTLR end "entryRuleLevel"


    // $ANTLR start "ruleLevel"
    // InternalModelDraw.g:1445:1: ruleLevel returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) ;
    public final EObject ruleLevel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
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
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_53=null;
        Enumerator lv_src_decoration_44_0 = null;

        Enumerator lv_tar_decoration_50_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1451:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:1452:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:1452:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            // InternalModelDraw.g:1453:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:1453:3: ()
            // InternalModelDraw.g:1454:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLevelAccess().getLevelAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1460:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1461:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1461:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1462:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_1, grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getLevelAccess().getFullStopKeyword_2());
            		
            // InternalModelDraw.g:1477:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:1478:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:1478:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:1479:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_3, grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getLevelAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,27,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getLevelAccess().getEdgeKeyword_5());
            		
            // InternalModelDraw.g:1498:3: (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==19) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalModelDraw.g:1499:4: otherlv_6= '=' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:1503:4: ( (otherlv_7= RULE_ID ) )
                    // InternalModelDraw.g:1504:5: (otherlv_7= RULE_ID )
                    {
                    // InternalModelDraw.g:1504:5: (otherlv_7= RULE_ID )
                    // InternalModelDraw.g:1505:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_33); 

                    						newLeafNode(otherlv_7, grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1517:3: (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==28) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalModelDraw.g:1518:4: otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getLevelAccess().getLabelKeyword_7_0());
                    			
                    otherlv_9=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:1526:4: ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==13) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalModelDraw.g:1527:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                            {
                            // InternalModelDraw.g:1527:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                            // InternalModelDraw.g:1528:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) )
                            {
                            // InternalModelDraw.g:1528:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )?
                            int alt50=2;
                            int LA50_0 = input.LA(1);

                            if ( (LA50_0==RULE_ID) ) {
                                int LA50_1 = input.LA(2);

                                if ( (LA50_1==18||LA50_1==29) ) {
                                    alt50=1;
                                }
                            }
                            switch (alt50) {
                                case 1 :
                                    // InternalModelDraw.g:1529:7: ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.'
                                    {
                                    // InternalModelDraw.g:1529:7: ( (otherlv_10= RULE_ID ) )
                                    // InternalModelDraw.g:1530:8: (otherlv_10= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1530:8: (otherlv_10= RULE_ID )
                                    // InternalModelDraw.g:1531:9: otherlv_10= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_10, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1542:7: (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )?
                                    int alt49=2;
                                    int LA49_0 = input.LA(1);

                                    if ( (LA49_0==18) ) {
                                        alt49=1;
                                    }
                                    switch (alt49) {
                                        case 1 :
                                            // InternalModelDraw.g:1543:8: otherlv_11= '->' ( (otherlv_12= RULE_ID ) )
                                            {
                                            otherlv_11=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_11, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0());
                                            							
                                            // InternalModelDraw.g:1547:8: ( (otherlv_12= RULE_ID ) )
                                            // InternalModelDraw.g:1548:9: (otherlv_12= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1548:9: (otherlv_12= RULE_ID )
                                            // InternalModelDraw.g:1549:10: otherlv_12= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getLevelRule());
                                            										}
                                            									
                                            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_36); 

                                            										newLeafNode(otherlv_12, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0());
                                            									

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_13=(Token)match(input,29,FOLLOW_4); 

                                    							newLeafNode(otherlv_13, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_0_0_2());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1566:6: ( (otherlv_14= RULE_ID ) )
                            // InternalModelDraw.g:1567:7: (otherlv_14= RULE_ID )
                            {
                            // InternalModelDraw.g:1567:7: (otherlv_14= RULE_ID )
                            // InternalModelDraw.g:1568:8: otherlv_14= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getLevelRule());
                            								}
                            							
                            otherlv_14=(Token)match(input,RULE_ID,FOLLOW_37); 

                            								newLeafNode(otherlv_14, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0());
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalModelDraw.g:1581:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                            {
                            // InternalModelDraw.g:1581:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                            // InternalModelDraw.g:1582:6: otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}'
                            {
                            otherlv_15=(Token)match(input,13,FOLLOW_4); 

                            						newLeafNode(otherlv_15, grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0());
                            					
                            // InternalModelDraw.g:1586:6: ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )?
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==RULE_ID) ) {
                                int LA52_1 = input.LA(2);

                                if ( (LA52_1==18||LA52_1==29) ) {
                                    alt52=1;
                                }
                            }
                            switch (alt52) {
                                case 1 :
                                    // InternalModelDraw.g:1587:7: ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.'
                                    {
                                    // InternalModelDraw.g:1587:7: ( (otherlv_16= RULE_ID ) )
                                    // InternalModelDraw.g:1588:8: (otherlv_16= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1588:8: (otherlv_16= RULE_ID )
                                    // InternalModelDraw.g:1589:9: otherlv_16= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_16, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1600:7: (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )?
                                    int alt51=2;
                                    int LA51_0 = input.LA(1);

                                    if ( (LA51_0==18) ) {
                                        alt51=1;
                                    }
                                    switch (alt51) {
                                        case 1 :
                                            // InternalModelDraw.g:1601:8: otherlv_17= '->' ( (otherlv_18= RULE_ID ) )
                                            {
                                            otherlv_17=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_17, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0());
                                            							
                                            // InternalModelDraw.g:1605:8: ( (otherlv_18= RULE_ID ) )
                                            // InternalModelDraw.g:1606:9: (otherlv_18= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1606:9: (otherlv_18= RULE_ID )
                                            // InternalModelDraw.g:1607:10: otherlv_18= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getLevelRule());
                                            										}
                                            									
                                            otherlv_18=(Token)match(input,RULE_ID,FOLLOW_36); 

                                            										newLeafNode(otherlv_18, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0());
                                            									

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_19=(Token)match(input,29,FOLLOW_4); 

                                    							newLeafNode(otherlv_19, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_1_2());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1624:6: ( (otherlv_20= RULE_ID ) )
                            // InternalModelDraw.g:1625:7: (otherlv_20= RULE_ID )
                            {
                            // InternalModelDraw.g:1625:7: (otherlv_20= RULE_ID )
                            // InternalModelDraw.g:1626:8: otherlv_20= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getLevelRule());
                            								}
                            							
                            otherlv_20=(Token)match(input,RULE_ID,FOLLOW_38); 

                            								newLeafNode(otherlv_20, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0());
                            							

                            }


                            }

                            // InternalModelDraw.g:1637:6: (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )?
                            int alt55=2;
                            int LA55_0 = input.LA(1);

                            if ( (LA55_0==15) ) {
                                alt55=1;
                            }
                            switch (alt55) {
                                case 1 :
                                    // InternalModelDraw.g:1638:7: otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')'
                                    {
                                    otherlv_21=(Token)match(input,15,FOLLOW_4); 

                                    							newLeafNode(otherlv_21, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0());
                                    						
                                    // InternalModelDraw.g:1642:7: ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )?
                                    int alt54=2;
                                    int LA54_0 = input.LA(1);

                                    if ( (LA54_0==RULE_ID) ) {
                                        int LA54_1 = input.LA(2);

                                        if ( (LA54_1==18||LA54_1==29) ) {
                                            alt54=1;
                                        }
                                    }
                                    switch (alt54) {
                                        case 1 :
                                            // InternalModelDraw.g:1643:8: ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.'
                                            {
                                            // InternalModelDraw.g:1643:8: ( (otherlv_22= RULE_ID ) )
                                            // InternalModelDraw.g:1644:9: (otherlv_22= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1644:9: (otherlv_22= RULE_ID )
                                            // InternalModelDraw.g:1645:10: otherlv_22= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getLevelRule());
                                            										}
                                            									
                                            otherlv_22=(Token)match(input,RULE_ID,FOLLOW_35); 

                                            										newLeafNode(otherlv_22, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0());
                                            									

                                            }


                                            }

                                            // InternalModelDraw.g:1656:8: (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )?
                                            int alt53=2;
                                            int LA53_0 = input.LA(1);

                                            if ( (LA53_0==18) ) {
                                                alt53=1;
                                            }
                                            switch (alt53) {
                                                case 1 :
                                                    // InternalModelDraw.g:1657:9: otherlv_23= '->' ( (otherlv_24= RULE_ID ) )
                                                    {
                                                    otherlv_23=(Token)match(input,18,FOLLOW_4); 

                                                    									newLeafNode(otherlv_23, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0());
                                                    								
                                                    // InternalModelDraw.g:1661:9: ( (otherlv_24= RULE_ID ) )
                                                    // InternalModelDraw.g:1662:10: (otherlv_24= RULE_ID )
                                                    {
                                                    // InternalModelDraw.g:1662:10: (otherlv_24= RULE_ID )
                                                    // InternalModelDraw.g:1663:11: otherlv_24= RULE_ID
                                                    {

                                                    											if (current==null) {
                                                    												current = createModelElement(grammarAccess.getLevelRule());
                                                    											}
                                                    										
                                                    otherlv_24=(Token)match(input,RULE_ID,FOLLOW_36); 

                                                    											newLeafNode(otherlv_24, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0());
                                                    										

                                                    }


                                                    }


                                                    }
                                                    break;

                                            }

                                            otherlv_25=(Token)match(input,29,FOLLOW_4); 

                                            								newLeafNode(otherlv_25, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_3_1_2());
                                            							

                                            }
                                            break;

                                    }

                                    // InternalModelDraw.g:1680:7: ( (otherlv_26= RULE_ID ) )
                                    // InternalModelDraw.g:1681:8: (otherlv_26= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1681:8: (otherlv_26= RULE_ID )
                                    // InternalModelDraw.g:1682:9: otherlv_26= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_26=(Token)match(input,RULE_ID,FOLLOW_22); 

                                    									newLeafNode(otherlv_26, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0());
                                    								

                                    }


                                    }

                                    otherlv_27=(Token)match(input,17,FOLLOW_39); 

                                    							newLeafNode(otherlv_27, grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1698:6: (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )*
                            loop61:
                            do {
                                int alt61=2;
                                int LA61_0 = input.LA(1);

                                if ( (LA61_0==16) ) {
                                    alt61=1;
                                }


                                switch (alt61) {
                            	case 1 :
                            	    // InternalModelDraw.g:1699:7: otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                            	    {
                            	    otherlv_28=(Token)match(input,16,FOLLOW_4); 

                            	    							newLeafNode(otherlv_28, grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0());
                            	    						
                            	    // InternalModelDraw.g:1703:7: ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )?
                            	    int alt57=2;
                            	    int LA57_0 = input.LA(1);

                            	    if ( (LA57_0==RULE_ID) ) {
                            	        int LA57_1 = input.LA(2);

                            	        if ( (LA57_1==18||LA57_1==29) ) {
                            	            alt57=1;
                            	        }
                            	    }
                            	    switch (alt57) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1704:8: ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.'
                            	            {
                            	            // InternalModelDraw.g:1704:8: ( (otherlv_29= RULE_ID ) )
                            	            // InternalModelDraw.g:1705:9: (otherlv_29= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1705:9: (otherlv_29= RULE_ID )
                            	            // InternalModelDraw.g:1706:10: otherlv_29= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getLevelRule());
                            	            										}
                            	            									
                            	            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	            										newLeafNode(otherlv_29, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0());
                            	            									

                            	            }


                            	            }

                            	            // InternalModelDraw.g:1717:8: (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )?
                            	            int alt56=2;
                            	            int LA56_0 = input.LA(1);

                            	            if ( (LA56_0==18) ) {
                            	                alt56=1;
                            	            }
                            	            switch (alt56) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1718:9: otherlv_30= '->' ( (otherlv_31= RULE_ID ) )
                            	                    {
                            	                    otherlv_30=(Token)match(input,18,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_30, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0());
                            	                    								
                            	                    // InternalModelDraw.g:1722:9: ( (otherlv_31= RULE_ID ) )
                            	                    // InternalModelDraw.g:1723:10: (otherlv_31= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1723:10: (otherlv_31= RULE_ID )
                            	                    // InternalModelDraw.g:1724:11: otherlv_31= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getLevelRule());
                            	                    											}
                            	                    										
                            	                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_36); 

                            	                    											newLeafNode(otherlv_31, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0());
                            	                    										

                            	                    }


                            	                    }


                            	                    }
                            	                    break;

                            	            }

                            	            otherlv_32=(Token)match(input,29,FOLLOW_4); 

                            	            								newLeafNode(otherlv_32, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_1_2());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalModelDraw.g:1741:7: ( (otherlv_33= RULE_ID ) )
                            	    // InternalModelDraw.g:1742:8: (otherlv_33= RULE_ID )
                            	    {
                            	    // InternalModelDraw.g:1742:8: (otherlv_33= RULE_ID )
                            	    // InternalModelDraw.g:1743:9: otherlv_33= RULE_ID
                            	    {

                            	    									if (current==null) {
                            	    										current = createModelElement(grammarAccess.getLevelRule());
                            	    									}
                            	    								
                            	    otherlv_33=(Token)match(input,RULE_ID,FOLLOW_38); 

                            	    									newLeafNode(otherlv_33, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0());
                            	    								

                            	    }


                            	    }

                            	    // InternalModelDraw.g:1754:7: (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                            	    int alt60=2;
                            	    int LA60_0 = input.LA(1);

                            	    if ( (LA60_0==15) ) {
                            	        alt60=1;
                            	    }
                            	    switch (alt60) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1755:8: otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')'
                            	            {
                            	            otherlv_34=(Token)match(input,15,FOLLOW_4); 

                            	            								newLeafNode(otherlv_34, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0());
                            	            							
                            	            // InternalModelDraw.g:1759:8: ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )?
                            	            int alt59=2;
                            	            int LA59_0 = input.LA(1);

                            	            if ( (LA59_0==RULE_ID) ) {
                            	                int LA59_1 = input.LA(2);

                            	                if ( (LA59_1==18||LA59_1==29) ) {
                            	                    alt59=1;
                            	                }
                            	            }
                            	            switch (alt59) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1760:9: ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.'
                            	                    {
                            	                    // InternalModelDraw.g:1760:9: ( (otherlv_35= RULE_ID ) )
                            	                    // InternalModelDraw.g:1761:10: (otherlv_35= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1761:10: (otherlv_35= RULE_ID )
                            	                    // InternalModelDraw.g:1762:11: otherlv_35= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getLevelRule());
                            	                    											}
                            	                    										
                            	                    otherlv_35=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	                    											newLeafNode(otherlv_35, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0());
                            	                    										

                            	                    }


                            	                    }

                            	                    // InternalModelDraw.g:1773:9: (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )?
                            	                    int alt58=2;
                            	                    int LA58_0 = input.LA(1);

                            	                    if ( (LA58_0==18) ) {
                            	                        alt58=1;
                            	                    }
                            	                    switch (alt58) {
                            	                        case 1 :
                            	                            // InternalModelDraw.g:1774:10: otherlv_36= '->' ( (otherlv_37= RULE_ID ) )
                            	                            {
                            	                            otherlv_36=(Token)match(input,18,FOLLOW_4); 

                            	                            										newLeafNode(otherlv_36, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0());
                            	                            									
                            	                            // InternalModelDraw.g:1778:10: ( (otherlv_37= RULE_ID ) )
                            	                            // InternalModelDraw.g:1779:11: (otherlv_37= RULE_ID )
                            	                            {
                            	                            // InternalModelDraw.g:1779:11: (otherlv_37= RULE_ID )
                            	                            // InternalModelDraw.g:1780:12: otherlv_37= RULE_ID
                            	                            {

                            	                            												if (current==null) {
                            	                            													current = createModelElement(grammarAccess.getLevelRule());
                            	                            												}
                            	                            											
                            	                            otherlv_37=(Token)match(input,RULE_ID,FOLLOW_36); 

                            	                            												newLeafNode(otherlv_37, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0());
                            	                            											

                            	                            }


                            	                            }


                            	                            }
                            	                            break;

                            	                    }

                            	                    otherlv_38=(Token)match(input,29,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_38, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_3_1_2());
                            	                    								

                            	                    }
                            	                    break;

                            	            }

                            	            // InternalModelDraw.g:1797:8: ( (otherlv_39= RULE_ID ) )
                            	            // InternalModelDraw.g:1798:9: (otherlv_39= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1798:9: (otherlv_39= RULE_ID )
                            	            // InternalModelDraw.g:1799:10: otherlv_39= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getLevelRule());
                            	            										}
                            	            									
                            	            otherlv_39=(Token)match(input,RULE_ID,FOLLOW_22); 

                            	            										newLeafNode(otherlv_39, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0());
                            	            									

                            	            }


                            	            }

                            	            otherlv_40=(Token)match(input,17,FOLLOW_39); 

                            	            								newLeafNode(otherlv_40, grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_4_3_3());
                            	            							

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop61;
                                }
                            } while (true);

                            otherlv_41=(Token)match(input,14,FOLLOW_37); 

                            						newLeafNode(otherlv_41, grammarAccess.getLevelAccess().getRightCurlyBracketKeyword_7_2_1_5());
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1823:3: (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==30) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalModelDraw.g:1824:4: otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) )
                    {
                    otherlv_42=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_42, grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_43=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_43, grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:1832:4: ( (lv_src_decoration_44_0= ruleDecoration ) )
                    // InternalModelDraw.g:1833:5: (lv_src_decoration_44_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1833:5: (lv_src_decoration_44_0= ruleDecoration )
                    // InternalModelDraw.g:1834:6: lv_src_decoration_44_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_src_decoration_44_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLevelRule());
                    						}
                    						set(
                    							current,
                    							"src_decoration",
                    							lv_src_decoration_44_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1852:3: (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==31) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalModelDraw.g:1853:4: otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) )
                    {
                    otherlv_45=(Token)match(input,31,FOLLOW_18); 

                    				newLeafNode(otherlv_45, grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_46=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_46, grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1861:4: ( (otherlv_47= RULE_ID ) )
                    // InternalModelDraw.g:1862:5: (otherlv_47= RULE_ID )
                    {
                    // InternalModelDraw.g:1862:5: (otherlv_47= RULE_ID )
                    // InternalModelDraw.g:1863:6: otherlv_47= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_47=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_47, grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1875:3: (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==32) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalModelDraw.g:1876:4: otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    {
                    otherlv_48=(Token)match(input,32,FOLLOW_18); 

                    				newLeafNode(otherlv_48, grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_49=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_49, grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1884:4: ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    // InternalModelDraw.g:1885:5: (lv_tar_decoration_50_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1885:5: (lv_tar_decoration_50_0= ruleDecoration )
                    // InternalModelDraw.g:1886:6: lv_tar_decoration_50_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_tar_decoration_50_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLevelRule());
                    						}
                    						set(
                    							current,
                    							"tar_decoration",
                    							lv_tar_decoration_50_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1904:3: (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==33) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalModelDraw.g:1905:4: otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) )
                    {
                    otherlv_51=(Token)match(input,33,FOLLOW_18); 

                    				newLeafNode(otherlv_51, grammarAccess.getLevelAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_52=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_52, grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1913:4: ( (otherlv_53= RULE_ID ) )
                    // InternalModelDraw.g:1914:5: (otherlv_53= RULE_ID )
                    {
                    // InternalModelDraw.g:1914:5: (otherlv_53= RULE_ID )
                    // InternalModelDraw.g:1915:6: otherlv_53= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_53=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_53, grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0());
                    					

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
    // $ANTLR end "ruleLevel"


    // $ANTLR start "entryRuleContent"
    // InternalModelDraw.g:1931:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalModelDraw.g:1931:48: (iv_ruleContent= ruleContent EOF )
            // InternalModelDraw.g:1932:2: iv_ruleContent= ruleContent EOF
            {
             newCompositeNode(grammarAccess.getContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // InternalModelDraw.g:1938:1: ruleContent returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_nodenum_3_0 = null;

        EObject lv_nodenum_4_0 = null;

        EObject lv_info_5_0 = null;

        EObject lv_info_6_0 = null;

        AntlrDatatypeRuleToken lv_symbol_12_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1944:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) )
            // InternalModelDraw.g:1945:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            {
            // InternalModelDraw.g:1945:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            // InternalModelDraw.g:1946:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            {
            // InternalModelDraw.g:1946:3: ()
            // InternalModelDraw.g:1947:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContentAccess().getContentAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1953:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1954:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1954:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1955:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContentRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_1, grammarAccess.getContentAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getContentAccess().getColonKeyword_2());
            		
            // InternalModelDraw.g:1970:3: ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==35) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalModelDraw.g:1971:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    {
                    // InternalModelDraw.g:1971:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) )
                    // InternalModelDraw.g:1972:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    {
                    // InternalModelDraw.g:1972:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    // InternalModelDraw.g:1973:6: lv_nodenum_3_0= ruleNodeEnumerator
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_nodenum_3_0=ruleNodeEnumerator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContentRule());
                    						}
                    						add(
                    							current,
                    							"nodenum",
                    							lv_nodenum_3_0,
                    							"wodeledu.dsls.ModelDraw.NodeEnumerator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:1990:4: ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID) ) {
                            int LA68_1 = input.LA(2);

                            if ( (LA68_1==35) ) {
                                alt68=1;
                            }


                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalModelDraw.g:1991:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    {
                    	    // InternalModelDraw.g:1991:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    // InternalModelDraw.g:1992:6: lv_nodenum_4_0= ruleNodeEnumerator
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_44);
                    	    lv_nodenum_4_0=ruleNodeEnumerator();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"nodenum",
                    	    							lv_nodenum_4_0,
                    	    							"wodeledu.dsls.ModelDraw.NodeEnumerator");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:2010:3: ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==EOF||LA71_1==RULE_ID||(LA71_1>=13 && LA71_1<=14)||LA71_1==29||LA71_1==34) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalModelDraw.g:2011:4: ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )*
                    {
                    // InternalModelDraw.g:2011:4: ( (lv_info_5_0= ruleInformation ) )
                    // InternalModelDraw.g:2012:5: (lv_info_5_0= ruleInformation )
                    {
                    // InternalModelDraw.g:2012:5: (lv_info_5_0= ruleInformation )
                    // InternalModelDraw.g:2013:6: lv_info_5_0= ruleInformation
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_info_5_0=ruleInformation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContentRule());
                    						}
                    						add(
                    							current,
                    							"info",
                    							lv_info_5_0,
                    							"wodeledu.dsls.ModelDraw.Information");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:2030:4: ( (lv_info_6_0= ruleInformation ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            int LA70_2 = input.LA(2);

                            if ( (LA70_2==EOF||LA70_2==RULE_ID||(LA70_2>=13 && LA70_2<=14)||LA70_2==29||LA70_2==34) ) {
                                alt70=1;
                            }


                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalModelDraw.g:2031:5: (lv_info_6_0= ruleInformation )
                    	    {
                    	    // InternalModelDraw.g:2031:5: (lv_info_6_0= ruleInformation )
                    	    // InternalModelDraw.g:2032:6: lv_info_6_0= ruleInformation
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_44);
                    	    lv_info_6_0=ruleInformation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"info",
                    	    							lv_info_6_0,
                    	    							"wodeledu.dsls.ModelDraw.Information");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:2050:3: (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==13) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalModelDraw.g:2051:4: otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalModelDraw.g:2055:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:2056:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:2056:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:2057:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContentRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_8, grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0());
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_46); 

                    				newLeafNode(otherlv_9, grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:2073:3: (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==34) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalModelDraw.g:2074:4: otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getContentAccess().getTextKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getContentAccess().getEqualsSignKeyword_6_1());
                    			
                    // InternalModelDraw.g:2082:4: ( (lv_symbol_12_0= ruleEString ) )
                    // InternalModelDraw.g:2083:5: (lv_symbol_12_0= ruleEString )
                    {
                    // InternalModelDraw.g:2083:5: (lv_symbol_12_0= ruleEString )
                    // InternalModelDraw.g:2084:6: lv_symbol_12_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getSymbolEStringParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_symbol_12_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContentRule());
                    						}
                    						set(
                    							current,
                    							"symbol",
                    							lv_symbol_12_0,
                    							"wodeledu.dsls.ModelDraw.EString");
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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleNodeEnumerator"
    // InternalModelDraw.g:2106:1: entryRuleNodeEnumerator returns [EObject current=null] : iv_ruleNodeEnumerator= ruleNodeEnumerator EOF ;
    public final EObject entryRuleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeEnumerator = null;


        try {
            // InternalModelDraw.g:2106:55: (iv_ruleNodeEnumerator= ruleNodeEnumerator EOF )
            // InternalModelDraw.g:2107:2: iv_ruleNodeEnumerator= ruleNodeEnumerator EOF
            {
             newCompositeNode(grammarAccess.getNodeEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNodeEnumerator=ruleNodeEnumerator();

            state._fsp--;

             current =iv_ruleNodeEnumerator; 
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
    // $ANTLR end "entryRuleNodeEnumerator"


    // $ANTLR start "ruleNodeEnumerator"
    // InternalModelDraw.g:2113:1: ruleNodeEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) ;
    public final EObject ruleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_enumerator_3_0 = null;

        EObject lv_enumerator_4_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:2119:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) )
            // InternalModelDraw.g:2120:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            {
            // InternalModelDraw.g:2120:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            // InternalModelDraw.g:2121:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']'
            {
            // InternalModelDraw.g:2121:3: ()
            // InternalModelDraw.g:2122:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2128:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2129:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2129:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2130:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(otherlv_1, grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalModelDraw.g:2145:3: ( (lv_enumerator_3_0= ruleEnumerator ) )
            // InternalModelDraw.g:2146:4: (lv_enumerator_3_0= ruleEnumerator )
            {
            // InternalModelDraw.g:2146:4: (lv_enumerator_3_0= ruleEnumerator )
            // InternalModelDraw.g:2147:5: lv_enumerator_3_0= ruleEnumerator
            {

            					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_48);
            lv_enumerator_3_0=ruleEnumerator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeEnumeratorRule());
            					}
            					add(
            						current,
            						"enumerator",
            						lv_enumerator_3_0,
            						"wodeledu.dsls.ModelDraw.Enumerator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelDraw.g:2164:3: ( (lv_enumerator_4_0= ruleEnumerator ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ID) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalModelDraw.g:2165:4: (lv_enumerator_4_0= ruleEnumerator )
            	    {
            	    // InternalModelDraw.g:2165:4: (lv_enumerator_4_0= ruleEnumerator )
            	    // InternalModelDraw.g:2166:5: lv_enumerator_4_0= ruleEnumerator
            	    {

            	    					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_enumerator_4_0=ruleEnumerator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNodeEnumeratorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"enumerator",
            	    						lv_enumerator_4_0,
            	    						"wodeledu.dsls.ModelDraw.Enumerator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getNodeEnumeratorAccess().getRightSquareBracketKeyword_5());
            		

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
    // $ANTLR end "ruleNodeEnumerator"


    // $ANTLR start "entryRuleEnumerator"
    // InternalModelDraw.g:2191:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalModelDraw.g:2191:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalModelDraw.g:2192:2: iv_ruleEnumerator= ruleEnumerator EOF
            {
             newCompositeNode(grammarAccess.getEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerator=ruleEnumerator();

            state._fsp--;

             current =iv_ruleEnumerator; 
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
    // $ANTLR end "entryRuleEnumerator"


    // $ANTLR start "ruleEnumerator"
    // InternalModelDraw.g:2198:1: ruleEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:2204:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) )
            // InternalModelDraw.g:2205:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            {
            // InternalModelDraw.g:2205:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            // InternalModelDraw.g:2206:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) )
            {
            // InternalModelDraw.g:2206:3: ()
            // InternalModelDraw.g:2207:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumeratorAccess().getEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2213:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2214:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2214:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2215:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(otherlv_1, grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2());
            		
            // InternalModelDraw.g:2230:3: ( (lv_value_3_0= ruleEString ) )
            // InternalModelDraw.g:2231:4: (lv_value_3_0= ruleEString )
            {
            // InternalModelDraw.g:2231:4: (lv_value_3_0= ruleEString )
            // InternalModelDraw.g:2232:5: lv_value_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEnumeratorAccess().getValueEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumeratorRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"wodeledu.dsls.ModelDraw.EString");
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
    // $ANTLR end "ruleEnumerator"


    // $ANTLR start "entryRuleInformation"
    // InternalModelDraw.g:2253:1: entryRuleInformation returns [EObject current=null] : iv_ruleInformation= ruleInformation EOF ;
    public final EObject entryRuleInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformation = null;


        try {
            // InternalModelDraw.g:2253:52: (iv_ruleInformation= ruleInformation EOF )
            // InternalModelDraw.g:2254:2: iv_ruleInformation= ruleInformation EOF
            {
             newCompositeNode(grammarAccess.getInformationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInformation=ruleInformation();

            state._fsp--;

             current =iv_ruleInformation; 
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
    // $ANTLR end "entryRuleInformation"


    // $ANTLR start "ruleInformation"
    // InternalModelDraw.g:2260:1: ruleInformation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2266:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:2267:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:2267:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalModelDraw.g:2268:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:2268:3: ()
            // InternalModelDraw.g:2269:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInformationAccess().getInformationAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2275:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2276:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2276:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2277:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_1, grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:2288:3: (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==29) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalModelDraw.g:2289:4: otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getInformationAccess().getFullStopKeyword_2_0());
                    			
                    // InternalModelDraw.g:2293:4: ( (otherlv_3= RULE_ID ) )
                    // InternalModelDraw.g:2294:5: (otherlv_3= RULE_ID )
                    {
                    // InternalModelDraw.g:2294:5: (otherlv_3= RULE_ID )
                    // InternalModelDraw.g:2295:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInformationRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0());
                    					

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
    // $ANTLR end "ruleInformation"


    // $ANTLR start "ruleDrawType"
    // InternalModelDraw.g:2311:1: ruleDrawType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleDrawType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2317:2: ( (enumLiteral_0= 'diagram' ) )
            // InternalModelDraw.g:2318:2: (enumLiteral_0= 'diagram' )
            {
            // InternalModelDraw.g:2318:2: (enumLiteral_0= 'diagram' )
            // InternalModelDraw.g:2319:3: enumLiteral_0= 'diagram'
            {
            enumLiteral_0=(Token)match(input,37,FOLLOW_2); 

            			current = grammarAccess.getDrawTypeAccess().getDiagramEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getDrawTypeAccess().getDiagramEnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleDrawType"


    // $ANTLR start "ruleNodeType"
    // InternalModelDraw.g:2328:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2334:2: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // InternalModelDraw.g:2335:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // InternalModelDraw.g:2335:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==38) ) {
                alt76=1;
            }
            else if ( (LA76_0==39) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalModelDraw.g:2336:3: (enumLiteral_0= 'node' )
                    {
                    // InternalModelDraw.g:2336:3: (enumLiteral_0= 'node' )
                    // InternalModelDraw.g:2337:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2344:3: (enumLiteral_1= 'markednode' )
                    {
                    // InternalModelDraw.g:2344:3: (enumLiteral_1= 'markednode' )
                    // InternalModelDraw.g:2345:4: enumLiteral_1= 'markednode'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleNodeType"


    // $ANTLR start "ruleNodeShape"
    // InternalModelDraw.g:2355:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2361:2: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) ) )
            // InternalModelDraw.g:2362:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) )
            {
            // InternalModelDraw.g:2362:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) )
            int alt77=5;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt77=1;
                }
                break;
            case 41:
                {
                alt77=2;
                }
                break;
            case 42:
                {
                alt77=3;
                }
                break;
            case 43:
                {
                alt77=4;
                }
                break;
            case 44:
                {
                alt77=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalModelDraw.g:2363:3: (enumLiteral_0= 'circle' )
                    {
                    // InternalModelDraw.g:2363:3: (enumLiteral_0= 'circle' )
                    // InternalModelDraw.g:2364:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2371:3: (enumLiteral_1= 'doublecircle' )
                    {
                    // InternalModelDraw.g:2371:3: (enumLiteral_1= 'doublecircle' )
                    // InternalModelDraw.g:2372:4: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2379:3: (enumLiteral_2= 'record' )
                    {
                    // InternalModelDraw.g:2379:3: (enumLiteral_2= 'record' )
                    // InternalModelDraw.g:2380:4: enumLiteral_2= 'record'
                    {
                    enumLiteral_2=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:2387:3: (enumLiteral_3= 'load' )
                    {
                    // InternalModelDraw.g:2387:3: (enumLiteral_3= 'load' )
                    // InternalModelDraw.g:2388:4: enumLiteral_3= 'load'
                    {
                    enumLiteral_3=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:2395:3: (enumLiteral_4= 'logic' )
                    {
                    // InternalModelDraw.g:2395:3: (enumLiteral_4= 'logic' )
                    // InternalModelDraw.g:2396:4: enumLiteral_4= 'logic'
                    {
                    enumLiteral_4=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getLogicEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getNodeShapeAccess().getLogicEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleNodeShape"


    // $ANTLR start "ruleNodeColor"
    // InternalModelDraw.g:2406:1: ruleNodeColor returns [Enumerator current=null] : (enumLiteral_0= 'gray95' ) ;
    public final Enumerator ruleNodeColor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2412:2: ( (enumLiteral_0= 'gray95' ) )
            // InternalModelDraw.g:2413:2: (enumLiteral_0= 'gray95' )
            {
            // InternalModelDraw.g:2413:2: (enumLiteral_0= 'gray95' )
            // InternalModelDraw.g:2414:3: enumLiteral_0= 'gray95'
            {
            enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

            			current = grammarAccess.getNodeColorAccess().getGray95EnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getNodeColorAccess().getGray95EnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleNodeColor"


    // $ANTLR start "ruleNodeStyle"
    // InternalModelDraw.g:2423:1: ruleNodeStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) ;
    public final Enumerator ruleNodeStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2429:2: ( ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) )
            // InternalModelDraw.g:2430:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            {
            // InternalModelDraw.g:2430:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==46) ) {
                alt78=1;
            }
            else if ( (LA78_0==47) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalModelDraw.g:2431:3: (enumLiteral_0= 'italic' )
                    {
                    // InternalModelDraw.g:2431:3: (enumLiteral_0= 'italic' )
                    // InternalModelDraw.g:2432:4: enumLiteral_0= 'italic'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2439:3: (enumLiteral_1= 'underline' )
                    {
                    // InternalModelDraw.g:2439:3: (enumLiteral_1= 'underline' )
                    // InternalModelDraw.g:2440:4: enumLiteral_1= 'underline'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleNodeStyle"


    // $ANTLR start "ruleDecoration"
    // InternalModelDraw.g:2450:1: ruleDecoration returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) ;
    public final Enumerator ruleDecoration() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2456:2: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) )
            // InternalModelDraw.g:2457:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            {
            // InternalModelDraw.g:2457:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            int alt79=6;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt79=1;
                }
                break;
            case 49:
                {
                alt79=2;
                }
                break;
            case 50:
                {
                alt79=3;
                }
                break;
            case 51:
                {
                alt79=4;
                }
                break;
            case 52:
                {
                alt79=5;
                }
                break;
            case 53:
                {
                alt79=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalModelDraw.g:2458:3: (enumLiteral_0= 'none' )
                    {
                    // InternalModelDraw.g:2458:3: (enumLiteral_0= 'none' )
                    // InternalModelDraw.g:2459:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2466:3: (enumLiteral_1= 'triangle' )
                    {
                    // InternalModelDraw.g:2466:3: (enumLiteral_1= 'triangle' )
                    // InternalModelDraw.g:2467:4: enumLiteral_1= 'triangle'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2474:3: (enumLiteral_2= 'diamond' )
                    {
                    // InternalModelDraw.g:2474:3: (enumLiteral_2= 'diamond' )
                    // InternalModelDraw.g:2475:4: enumLiteral_2= 'diamond'
                    {
                    enumLiteral_2=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:2482:3: (enumLiteral_3= 'odiamond' )
                    {
                    // InternalModelDraw.g:2482:3: (enumLiteral_3= 'odiamond' )
                    // InternalModelDraw.g:2483:4: enumLiteral_3= 'odiamond'
                    {
                    enumLiteral_3=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:2490:3: (enumLiteral_4= 'open' )
                    {
                    // InternalModelDraw.g:2490:3: (enumLiteral_4= 'open' )
                    // InternalModelDraw.g:2491:4: enumLiteral_4= 'open'
                    {
                    enumLiteral_4=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:2498:3: (enumLiteral_5= 'empty' )
                    {
                    // InternalModelDraw.g:2498:3: (enumLiteral_5= 'empty' )
                    // InternalModelDraw.g:2499:4: enumLiteral_5= 'empty'
                    {
                    enumLiteral_5=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleDecoration"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\52\uffff";
    static final String dfa_2s = "\1\4\1\14\1\uffff\3\4\1\uffff\1\4\1\20\1\14\1\20\1\4\1\32\1\4\1\14\1\4\1\33\1\4\1\14\3\20\2\4\2\20\1\4\1\32\1\4\1\32\1\4\1\14\4\20\1\4\1\20\1\4\1\32\2\20";
    static final String dfa_3s = "\1\16\1\35\1\uffff\1\47\1\30\1\4\1\uffff\1\4\1\31\1\17\1\31\1\4\1\32\1\30\1\22\1\30\1\47\1\30\1\22\1\31\1\21\1\31\2\4\2\31\1\4\1\32\1\4\1\32\1\30\1\14\1\31\1\21\1\31\1\21\1\4\1\31\1\4\1\32\1\31\1\21";
    static final String dfa_4s = "\2\uffff\1\2\3\uffff\1\1\43\uffff";
    static final String dfa_5s = "\52\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\11\uffff\1\2",
            "\1\3\2\uffff\1\4\2\uffff\1\5\12\uffff\1\2",
            "",
            "\1\2\10\uffff\2\2\23\uffff\1\2\3\uffff\2\6",
            "\1\10\23\uffff\1\7",
            "\1\11",
            "",
            "\1\12",
            "\1\15\1\16\1\13\6\uffff\1\14",
            "\1\20\2\uffff\1\17",
            "\1\21\1\22\1\13\6\uffff\1\14",
            "\1\23",
            "\1\24",
            "\1\25\23\uffff\1\26",
            "\1\20\2\uffff\1\2\2\uffff\1\5",
            "\1\30\23\uffff\1\27",
            "\1\2\12\uffff\2\6",
            "\1\31\23\uffff\1\26",
            "\1\6\2\uffff\1\2\2\uffff\1\5",
            "\1\21\1\22\7\uffff\1\14",
            "\1\21\1\22",
            "\1\21\1\16\1\32\6\uffff\1\33",
            "\1\31",
            "\1\30",
            "\1\36\1\37\1\34\6\uffff\1\35",
            "\1\21\1\22\1\32\6\uffff\1\33",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\23\uffff\1\44",
            "\1\20",
            "\1\21\1\22\7\uffff\1\33",
            "\1\21\1\22",
            "\1\36\1\37\7\uffff\1\35",
            "\1\36\1\37",
            "\1\45",
            "\1\36\1\37\1\46\6\uffff\1\47",
            "\1\50",
            "\1\51",
            "\1\36\1\37\7\uffff\1\47",
            "\1\36\1\37"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 195:3: ( (lv_nodes_5_0= ruleNode ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000049000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000F80002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000F00002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00001F0000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000C08002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002040002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000003D0080002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000003D0000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000003C0000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x003F000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000400002012L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000020000002L});

}