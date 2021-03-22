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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "':'", "'{'", "'}'", "'('", "','", "')'", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'not'", "'edge'", "'label'", "'->'", "'.'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'diagram'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'gray95'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'"
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
    // InternalModelDraw.g:72:1: ruleMutatorDraw returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleDrawType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' ) ;
    public final EObject ruleMutatorDraw() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        Enumerator lv_type_5_0 = null;

        EObject lv_nodes_7_0 = null;

        EObject lv_relations_8_0 = null;

        EObject lv_contents_9_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:78:2: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleDrawType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' ) )
            // InternalModelDraw.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleDrawType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' )
            {
            // InternalModelDraw.g:79:2: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleDrawType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' )
            // InternalModelDraw.g:80:3: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleDrawType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}'
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

            // InternalModelDraw.g:110:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:111:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:111:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:112:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMutatorDrawRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_3, grammarAccess.getMutatorDrawAccess().getNameEClassCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getMutatorDrawAccess().getColonKeyword_4());
            		
            // InternalModelDraw.g:127:3: ( (lv_type_5_0= ruleDrawType ) )
            // InternalModelDraw.g:128:4: (lv_type_5_0= ruleDrawType )
            {
            // InternalModelDraw.g:128:4: (lv_type_5_0= ruleDrawType )
            // InternalModelDraw.g:129:5: lv_type_5_0= ruleDrawType
            {

            					newCompositeNode(grammarAccess.getMutatorDrawAccess().getTypeDrawTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_type_5_0=ruleDrawType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"wodeledu.dsls.ModelDraw.DrawType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getMutatorDrawAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalModelDraw.g:150:3: ( (lv_nodes_7_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalModelDraw.g:151:4: (lv_nodes_7_0= ruleNode )
            	    {
            	    // InternalModelDraw.g:151:4: (lv_nodes_7_0= ruleNode )
            	    // InternalModelDraw.g:152:5: lv_nodes_7_0= ruleNode
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorDrawAccess().getNodesNodeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_nodes_7_0=ruleNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_7_0,
            	    						"wodeledu.dsls.ModelDraw.Node");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalModelDraw.g:169:3: ( (lv_relations_8_0= ruleRelation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==15||LA2_1==27) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalModelDraw.g:170:4: (lv_relations_8_0= ruleRelation )
            	    {
            	    // InternalModelDraw.g:170:4: (lv_relations_8_0= ruleRelation )
            	    // InternalModelDraw.g:171:5: lv_relations_8_0= ruleRelation
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorDrawAccess().getRelationsRelationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_relations_8_0=ruleRelation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relations",
            	    						lv_relations_8_0,
            	    						"wodeledu.dsls.ModelDraw.Relation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalModelDraw.g:188:3: ( (lv_contents_9_0= ruleContent ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalModelDraw.g:189:4: (lv_contents_9_0= ruleContent )
            	    {
            	    // InternalModelDraw.g:189:4: (lv_contents_9_0= ruleContent )
            	    // InternalModelDraw.g:190:5: lv_contents_9_0= ruleContent
            	    {

            	    					newCompositeNode(grammarAccess.getMutatorDrawAccess().getContentsContentParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_contents_9_0=ruleContent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMutatorDrawRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contents",
            	    						lv_contents_9_0,
            	    						"wodeledu.dsls.ModelDraw.Content");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_10=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getMutatorDrawAccess().getRightCurlyBracketKeyword_10());
            		

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


    // $ANTLR start "entryRuleEString"
    // InternalModelDraw.g:215:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalModelDraw.g:215:47: (iv_ruleEString= ruleEString EOF )
            // InternalModelDraw.g:216:2: iv_ruleEString= ruleEString EOF
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
    // InternalModelDraw.g:222:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:228:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalModelDraw.g:229:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalModelDraw.g:229:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalModelDraw.g:230:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:238:3: this_ID_1= RULE_ID
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
    // InternalModelDraw.g:249:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalModelDraw.g:249:45: (iv_ruleNode= ruleNode EOF )
            // InternalModelDraw.g:250:2: iv_ruleNode= ruleNode EOF
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
    // InternalModelDraw.g:256:1: ruleNode returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
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
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        EObject lv_attribute_3_0 = null;

        EObject lv_attribute_5_0 = null;

        Enumerator lv_type_8_0 = null;

        Enumerator lv_shape_19_0 = null;

        Enumerator lv_color_22_0 = null;

        Enumerator lv_style_25_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:262:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? ) )
            // InternalModelDraw.g:263:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? )
            {
            // InternalModelDraw.g:263:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? )
            // InternalModelDraw.g:264:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )?
            {
            // InternalModelDraw.g:264:3: ()
            // InternalModelDraw.g:265:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeAccess().getNodeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:271:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:272:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:272:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:273:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:284:3: (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelDraw.g:285:4: otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalModelDraw.g:289:4: ( (lv_attribute_3_0= ruleBooleanAttribute ) )
                    // InternalModelDraw.g:290:5: (lv_attribute_3_0= ruleBooleanAttribute )
                    {
                    // InternalModelDraw.g:290:5: (lv_attribute_3_0= ruleBooleanAttribute )
                    // InternalModelDraw.g:291:6: lv_attribute_3_0= ruleBooleanAttribute
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_attribute_3_0=ruleBooleanAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						add(
                    							current,
                    							"attribute",
                    							lv_attribute_3_0,
                    							"wodeledu.dsls.ModelDraw.BooleanAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalModelDraw.g:308:4: (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalModelDraw.g:309:5: otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_10); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalModelDraw.g:313:5: ( (lv_attribute_5_0= ruleBooleanAttribute ) )
                    	    // InternalModelDraw.g:314:6: (lv_attribute_5_0= ruleBooleanAttribute )
                    	    {
                    	    // InternalModelDraw.g:314:6: (lv_attribute_5_0= ruleBooleanAttribute )
                    	    // InternalModelDraw.g:315:7: lv_attribute_5_0= ruleBooleanAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_attribute_5_0=ruleBooleanAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attribute",
                    	    								lv_attribute_5_0,
                    	    								"wodeledu.dsls.ModelDraw.BooleanAttribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_5); 

                    				newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getColonKeyword_3());
            		
            // InternalModelDraw.g:342:3: ( (lv_type_8_0= ruleNodeType ) )
            // InternalModelDraw.g:343:4: (lv_type_8_0= ruleNodeType )
            {
            // InternalModelDraw.g:343:4: (lv_type_8_0= ruleNodeType )
            // InternalModelDraw.g:344:5: lv_type_8_0= ruleNodeType
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_13);
            lv_type_8_0=ruleNodeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_8_0,
            						"wodeledu.dsls.ModelDraw.NodeType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalModelDraw.g:361:3: (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelDraw.g:362:4: otherlv_9= '=' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getEqualsSignKeyword_5_0());
                    			
                    // InternalModelDraw.g:366:4: ( (otherlv_10= RULE_ID ) )
                    // InternalModelDraw.g:367:5: (otherlv_10= RULE_ID )
                    {
                    // InternalModelDraw.g:367:5: (otherlv_10= RULE_ID )
                    // InternalModelDraw.g:368:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_14); 

                    						newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_5_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:380:3: (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalModelDraw.g:381:4: otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}'
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_15); 

                    				newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getCompartmentsKeyword_6_0());
                    			
                    otherlv_12=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getNodeAccess().getEqualsSignKeyword_6_1());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_6_2());
                    			
                    // InternalModelDraw.g:393:4: ( (otherlv_14= RULE_ID ) )
                    // InternalModelDraw.g:394:5: (otherlv_14= RULE_ID )
                    {
                    // InternalModelDraw.g:394:5: (otherlv_14= RULE_ID )
                    // InternalModelDraw.g:395:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_3_0());
                    					

                    }


                    }

                    // InternalModelDraw.g:406:4: ( (otherlv_15= RULE_ID ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalModelDraw.g:407:5: (otherlv_15= RULE_ID )
                    	    {
                    	    // InternalModelDraw.g:407:5: (otherlv_15= RULE_ID )
                    	    // InternalModelDraw.g:408:6: otherlv_15= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_8); 

                    	    						newLeafNode(otherlv_15, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_4_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,14,FOLLOW_16); 

                    				newLeafNode(otherlv_16, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_6_5());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:424:3: (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelDraw.g:425:4: otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) )
                    {
                    otherlv_17=(Token)match(input,20,FOLLOW_15); 

                    				newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getShapeKeyword_7_0());
                    			
                    otherlv_18=(Token)match(input,18,FOLLOW_17); 

                    				newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:433:4: ( (lv_shape_19_0= ruleNodeShape ) )
                    // InternalModelDraw.g:434:5: (lv_shape_19_0= ruleNodeShape )
                    {
                    // InternalModelDraw.g:434:5: (lv_shape_19_0= ruleNodeShape )
                    // InternalModelDraw.g:435:6: lv_shape_19_0= ruleNodeShape
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_shape_19_0=ruleNodeShape();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"shape",
                    							lv_shape_19_0,
                    							"wodeledu.dsls.ModelDraw.NodeShape");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:453:3: (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelDraw.g:454:4: otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) )
                    {
                    otherlv_20=(Token)match(input,21,FOLLOW_15); 

                    				newLeafNode(otherlv_20, grammarAccess.getNodeAccess().getColorKeyword_8_0());
                    			
                    otherlv_21=(Token)match(input,18,FOLLOW_19); 

                    				newLeafNode(otherlv_21, grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:462:4: ( (lv_color_22_0= ruleNodeColor ) )
                    // InternalModelDraw.g:463:5: (lv_color_22_0= ruleNodeColor )
                    {
                    // InternalModelDraw.g:463:5: (lv_color_22_0= ruleNodeColor )
                    // InternalModelDraw.g:464:6: lv_color_22_0= ruleNodeColor
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_color_22_0=ruleNodeColor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"color",
                    							lv_color_22_0,
                    							"wodeledu.dsls.ModelDraw.NodeColor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:482:3: (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelDraw.g:483:4: otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) )
                    {
                    otherlv_23=(Token)match(input,22,FOLLOW_15); 

                    				newLeafNode(otherlv_23, grammarAccess.getNodeAccess().getStyleKeyword_9_0());
                    			
                    otherlv_24=(Token)match(input,18,FOLLOW_21); 

                    				newLeafNode(otherlv_24, grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:491:4: ( (lv_style_25_0= ruleNodeStyle ) )
                    // InternalModelDraw.g:492:5: (lv_style_25_0= ruleNodeStyle )
                    {
                    // InternalModelDraw.g:492:5: (lv_style_25_0= ruleNodeStyle )
                    // InternalModelDraw.g:493:6: lv_style_25_0= ruleNodeStyle
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_style_25_0=ruleNodeStyle();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"style",
                    							lv_style_25_0,
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


    // $ANTLR start "entryRuleBooleanAttribute"
    // InternalModelDraw.g:515:1: entryRuleBooleanAttribute returns [EObject current=null] : iv_ruleBooleanAttribute= ruleBooleanAttribute EOF ;
    public final EObject entryRuleBooleanAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttribute = null;


        try {
            // InternalModelDraw.g:515:57: (iv_ruleBooleanAttribute= ruleBooleanAttribute EOF )
            // InternalModelDraw.g:516:2: iv_ruleBooleanAttribute= ruleBooleanAttribute EOF
            {
             newCompositeNode(grammarAccess.getBooleanAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanAttribute=ruleBooleanAttribute();

            state._fsp--;

             current =iv_ruleBooleanAttribute; 
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
    // $ANTLR end "entryRuleBooleanAttribute"


    // $ANTLR start "ruleBooleanAttribute"
    // InternalModelDraw.g:522:1: ruleBooleanAttribute returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleBooleanAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_negation_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalModelDraw.g:528:2: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalModelDraw.g:529:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalModelDraw.g:529:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            // InternalModelDraw.g:530:3: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) )
            {
            // InternalModelDraw.g:530:3: ()
            // InternalModelDraw.g:531:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanAttributeAccess().getBooleanAttributeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:537:3: ( (lv_negation_1_0= 'not' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelDraw.g:538:4: (lv_negation_1_0= 'not' )
                    {
                    // InternalModelDraw.g:538:4: (lv_negation_1_0= 'not' )
                    // InternalModelDraw.g:539:5: lv_negation_1_0= 'not'
                    {
                    lv_negation_1_0=(Token)match(input,23,FOLLOW_4); 

                    					newLeafNode(lv_negation_1_0, grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanAttributeRule());
                    					}
                    					setWithLastConsumed(current, "negation", true, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:551:3: ( (otherlv_2= RULE_ID ) )
            // InternalModelDraw.g:552:4: (otherlv_2= RULE_ID )
            {
            // InternalModelDraw.g:552:4: (otherlv_2= RULE_ID )
            // InternalModelDraw.g:553:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBooleanAttributeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getBooleanAttributeAccess().getAttEAttributeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleBooleanAttribute"


    // $ANTLR start "entryRuleRelation"
    // InternalModelDraw.g:568:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalModelDraw.g:568:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalModelDraw.g:569:2: iv_ruleRelation= ruleRelation EOF
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
    // InternalModelDraw.g:575:1: ruleRelation returns [EObject current=null] : (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_Edge_0 = null;

        EObject this_Level_1 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:581:2: ( (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) )
            // InternalModelDraw.g:582:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            {
            // InternalModelDraw.g:582:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==15) ) {
                    alt14=1;
                }
                else if ( (LA14_1==27) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:583:3: this_Edge_0= ruleEdge
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
                    // InternalModelDraw.g:592:3: this_Level_1= ruleLevel
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
    // InternalModelDraw.g:604:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // InternalModelDraw.g:604:45: (iv_ruleEdge= ruleEdge EOF )
            // InternalModelDraw.g:605:2: iv_ruleEdge= ruleEdge EOF
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
    // InternalModelDraw.g:611:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) ) (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )? (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )? (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )? (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )? ) ;
    public final EObject ruleEdge() throws RecognitionException {
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
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_56=null;
        Enumerator lv_src_decoration_47_0 = null;

        Enumerator lv_tar_decoration_53_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:617:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) ) (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )? (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )? (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )? (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:618:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) ) (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )? (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )? (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )? (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:618:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) ) (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )? (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )? (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )? (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )? )
            // InternalModelDraw.g:619:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) ) (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )? (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )? (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )? (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:619:3: ()
            // InternalModelDraw.g:620:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEdgeAccess().getEdgeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:626:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:627:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:627:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:628:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalModelDraw.g:643:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:644:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:644:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:645:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_3, grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getCommaKeyword_4());
            		
            // InternalModelDraw.g:660:3: ( (otherlv_5= RULE_ID ) )
            // InternalModelDraw.g:661:4: (otherlv_5= RULE_ID )
            {
            // InternalModelDraw.g:661:4: (otherlv_5= RULE_ID )
            // InternalModelDraw.g:662:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_5, grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_7, grammarAccess.getEdgeAccess().getColonKeyword_7());
            		
            otherlv_8=(Token)match(input,24,FOLLOW_26); 

            			newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getEdgeKeyword_8());
            		
            // InternalModelDraw.g:685:3: (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:686:4: otherlv_9= '=' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_0());
                    			
                    // InternalModelDraw.g:690:4: ( (otherlv_10= RULE_ID ) )
                    // InternalModelDraw.g:691:5: (otherlv_10= RULE_ID )
                    {
                    // InternalModelDraw.g:691:5: (otherlv_10= RULE_ID )
                    // InternalModelDraw.g:692:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_27); 

                    						newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_9_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:704:3: (otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) ) )
            // InternalModelDraw.g:705:4: otherlv_11= 'label' otherlv_12= '=' ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) )
            {
            otherlv_11=(Token)match(input,25,FOLLOW_15); 

            				newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getLabelKeyword_10_0());
            			
            otherlv_12=(Token)match(input,18,FOLLOW_28); 

            				newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1());
            			
            // InternalModelDraw.g:713:4: ( ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) ) | (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==13) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalModelDraw.g:714:5: ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) )
                    {
                    // InternalModelDraw.g:714:5: ( ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) ) )
                    // InternalModelDraw.g:715:6: ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )? ( (otherlv_17= RULE_ID ) )
                    {
                    // InternalModelDraw.g:715:6: ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        int LA17_1 = input.LA(2);

                        if ( ((LA17_1>=26 && LA17_1<=27)) ) {
                            alt17=1;
                        }
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalModelDraw.g:716:7: ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= '.'
                            {
                            // InternalModelDraw.g:716:7: ( (otherlv_13= RULE_ID ) )
                            // InternalModelDraw.g:717:8: (otherlv_13= RULE_ID )
                            {
                            // InternalModelDraw.g:717:8: (otherlv_13= RULE_ID )
                            // InternalModelDraw.g:718:9: otherlv_13= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getEdgeRule());
                            									}
                            								
                            otherlv_13=(Token)match(input,RULE_ID,FOLLOW_29); 

                            									newLeafNode(otherlv_13, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0_0_0());
                            								

                            }


                            }

                            // InternalModelDraw.g:729:7: (otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==26) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // InternalModelDraw.g:730:8: otherlv_14= '->' ( (otherlv_15= RULE_ID ) )
                                    {
                                    otherlv_14=(Token)match(input,26,FOLLOW_4); 

                                    								newLeafNode(otherlv_14, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_0_0_1_0());
                                    							
                                    // InternalModelDraw.g:734:8: ( (otherlv_15= RULE_ID ) )
                                    // InternalModelDraw.g:735:9: (otherlv_15= RULE_ID )
                                    {
                                    // InternalModelDraw.g:735:9: (otherlv_15= RULE_ID )
                                    // InternalModelDraw.g:736:10: otherlv_15= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getEdgeRule());
                                    										}
                                    									
                                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_30); 

                                    										newLeafNode(otherlv_15, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_0_0_1_1_0());
                                    									

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_16=(Token)match(input,27,FOLLOW_4); 

                            							newLeafNode(otherlv_16, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_0_0_2());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:753:6: ( (otherlv_17= RULE_ID ) )
                    // InternalModelDraw.g:754:7: (otherlv_17= RULE_ID )
                    {
                    // InternalModelDraw.g:754:7: (otherlv_17= RULE_ID )
                    // InternalModelDraw.g:755:8: otherlv_17= RULE_ID
                    {

                    								if (current==null) {
                    									current = createModelElement(grammarAccess.getEdgeRule());
                    								}
                    							
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_31); 

                    								newLeafNode(otherlv_17, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_0_1_0());
                    							

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:768:5: (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' )
                    {
                    // InternalModelDraw.g:768:5: (otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}' )
                    // InternalModelDraw.g:769:6: otherlv_18= '{' ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )? ( (otherlv_23= RULE_ID ) ) (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )? (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )* otherlv_44= '}'
                    {
                    otherlv_18=(Token)match(input,13,FOLLOW_4); 

                    						newLeafNode(otherlv_18, grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_10_2_1_0());
                    					
                    // InternalModelDraw.g:773:6: ( ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        int LA19_1 = input.LA(2);

                        if ( ((LA19_1>=26 && LA19_1<=27)) ) {
                            alt19=1;
                        }
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalModelDraw.g:774:7: ( (otherlv_19= RULE_ID ) ) (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )? otherlv_22= '.'
                            {
                            // InternalModelDraw.g:774:7: ( (otherlv_19= RULE_ID ) )
                            // InternalModelDraw.g:775:8: (otherlv_19= RULE_ID )
                            {
                            // InternalModelDraw.g:775:8: (otherlv_19= RULE_ID )
                            // InternalModelDraw.g:776:9: otherlv_19= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getEdgeRule());
                            									}
                            								
                            otherlv_19=(Token)match(input,RULE_ID,FOLLOW_29); 

                            									newLeafNode(otherlv_19, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_1_0_0());
                            								

                            }


                            }

                            // InternalModelDraw.g:787:7: (otherlv_20= '->' ( (otherlv_21= RULE_ID ) ) )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==26) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // InternalModelDraw.g:788:8: otherlv_20= '->' ( (otherlv_21= RULE_ID ) )
                                    {
                                    otherlv_20=(Token)match(input,26,FOLLOW_4); 

                                    								newLeafNode(otherlv_20, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_1_1_0());
                                    							
                                    // InternalModelDraw.g:792:8: ( (otherlv_21= RULE_ID ) )
                                    // InternalModelDraw.g:793:9: (otherlv_21= RULE_ID )
                                    {
                                    // InternalModelDraw.g:793:9: (otherlv_21= RULE_ID )
                                    // InternalModelDraw.g:794:10: otherlv_21= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getEdgeRule());
                                    										}
                                    									
                                    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_30); 

                                    										newLeafNode(otherlv_21, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_1_1_1_0());
                                    									

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_22=(Token)match(input,27,FOLLOW_4); 

                            							newLeafNode(otherlv_22, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_1_2());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:811:6: ( (otherlv_23= RULE_ID ) )
                    // InternalModelDraw.g:812:7: (otherlv_23= RULE_ID )
                    {
                    // InternalModelDraw.g:812:7: (otherlv_23= RULE_ID )
                    // InternalModelDraw.g:813:8: otherlv_23= RULE_ID
                    {

                    								if (current==null) {
                    									current = createModelElement(grammarAccess.getEdgeRule());
                    								}
                    							
                    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_32); 

                    								newLeafNode(otherlv_23, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_2_0());
                    							

                    }


                    }

                    // InternalModelDraw.g:824:6: (otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==15) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalModelDraw.g:825:7: otherlv_24= '(' ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) otherlv_30= ')'
                            {
                            otherlv_24=(Token)match(input,15,FOLLOW_4); 

                            							newLeafNode(otherlv_24, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_3_0());
                            						
                            // InternalModelDraw.g:829:7: ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==RULE_ID) ) {
                                int LA21_1 = input.LA(2);

                                if ( ((LA21_1>=26 && LA21_1<=27)) ) {
                                    alt21=1;
                                }
                            }
                            switch (alt21) {
                                case 1 :
                                    // InternalModelDraw.g:830:8: ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.'
                                    {
                                    // InternalModelDraw.g:830:8: ( (otherlv_25= RULE_ID ) )
                                    // InternalModelDraw.g:831:9: (otherlv_25= RULE_ID )
                                    {
                                    // InternalModelDraw.g:831:9: (otherlv_25= RULE_ID )
                                    // InternalModelDraw.g:832:10: otherlv_25= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getEdgeRule());
                                    										}
                                    									
                                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_29); 

                                    										newLeafNode(otherlv_25, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_3_1_0_0());
                                    									

                                    }


                                    }

                                    // InternalModelDraw.g:843:8: (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )?
                                    int alt20=2;
                                    int LA20_0 = input.LA(1);

                                    if ( (LA20_0==26) ) {
                                        alt20=1;
                                    }
                                    switch (alt20) {
                                        case 1 :
                                            // InternalModelDraw.g:844:9: otherlv_26= '->' ( (otherlv_27= RULE_ID ) )
                                            {
                                            otherlv_26=(Token)match(input,26,FOLLOW_4); 

                                            									newLeafNode(otherlv_26, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_3_1_1_0());
                                            								
                                            // InternalModelDraw.g:848:9: ( (otherlv_27= RULE_ID ) )
                                            // InternalModelDraw.g:849:10: (otherlv_27= RULE_ID )
                                            {
                                            // InternalModelDraw.g:849:10: (otherlv_27= RULE_ID )
                                            // InternalModelDraw.g:850:11: otherlv_27= RULE_ID
                                            {

                                            											if (current==null) {
                                            												current = createModelElement(grammarAccess.getEdgeRule());
                                            											}
                                            										
                                            otherlv_27=(Token)match(input,RULE_ID,FOLLOW_30); 

                                            											newLeafNode(otherlv_27, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_3_1_1_1_0());
                                            										

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_28=(Token)match(input,27,FOLLOW_4); 

                                    								newLeafNode(otherlv_28, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_3_1_2());
                                    							

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:867:7: ( (otherlv_29= RULE_ID ) )
                            // InternalModelDraw.g:868:8: (otherlv_29= RULE_ID )
                            {
                            // InternalModelDraw.g:868:8: (otherlv_29= RULE_ID )
                            // InternalModelDraw.g:869:9: otherlv_29= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getEdgeRule());
                            									}
                            								
                            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_24); 

                            									newLeafNode(otherlv_29, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_3_2_0());
                            								

                            }


                            }

                            otherlv_30=(Token)match(input,17,FOLLOW_33); 

                            							newLeafNode(otherlv_30, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_3_3());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:885:6: (otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )? )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==16) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalModelDraw.g:886:7: otherlv_31= ',' ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )? ( (otherlv_36= RULE_ID ) ) (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )?
                    	    {
                    	    otherlv_31=(Token)match(input,16,FOLLOW_4); 

                    	    							newLeafNode(otherlv_31, grammarAccess.getEdgeAccess().getCommaKeyword_10_2_1_4_0());
                    	    						
                    	    // InternalModelDraw.g:890:7: ( ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.' )?
                    	    int alt24=2;
                    	    int LA24_0 = input.LA(1);

                    	    if ( (LA24_0==RULE_ID) ) {
                    	        int LA24_1 = input.LA(2);

                    	        if ( ((LA24_1>=26 && LA24_1<=27)) ) {
                    	            alt24=1;
                    	        }
                    	    }
                    	    switch (alt24) {
                    	        case 1 :
                    	            // InternalModelDraw.g:891:8: ( (otherlv_32= RULE_ID ) ) (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )? otherlv_35= '.'
                    	            {
                    	            // InternalModelDraw.g:891:8: ( (otherlv_32= RULE_ID ) )
                    	            // InternalModelDraw.g:892:9: (otherlv_32= RULE_ID )
                    	            {
                    	            // InternalModelDraw.g:892:9: (otherlv_32= RULE_ID )
                    	            // InternalModelDraw.g:893:10: otherlv_32= RULE_ID
                    	            {

                    	            										if (current==null) {
                    	            											current = createModelElement(grammarAccess.getEdgeRule());
                    	            										}
                    	            									
                    	            otherlv_32=(Token)match(input,RULE_ID,FOLLOW_29); 

                    	            										newLeafNode(otherlv_32, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_1_0_0());
                    	            									

                    	            }


                    	            }

                    	            // InternalModelDraw.g:904:8: (otherlv_33= '->' ( (otherlv_34= RULE_ID ) ) )?
                    	            int alt23=2;
                    	            int LA23_0 = input.LA(1);

                    	            if ( (LA23_0==26) ) {
                    	                alt23=1;
                    	            }
                    	            switch (alt23) {
                    	                case 1 :
                    	                    // InternalModelDraw.g:905:9: otherlv_33= '->' ( (otherlv_34= RULE_ID ) )
                    	                    {
                    	                    otherlv_33=(Token)match(input,26,FOLLOW_4); 

                    	                    									newLeafNode(otherlv_33, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_1_1_0());
                    	                    								
                    	                    // InternalModelDraw.g:909:9: ( (otherlv_34= RULE_ID ) )
                    	                    // InternalModelDraw.g:910:10: (otherlv_34= RULE_ID )
                    	                    {
                    	                    // InternalModelDraw.g:910:10: (otherlv_34= RULE_ID )
                    	                    // InternalModelDraw.g:911:11: otherlv_34= RULE_ID
                    	                    {

                    	                    											if (current==null) {
                    	                    												current = createModelElement(grammarAccess.getEdgeRule());
                    	                    											}
                    	                    										
                    	                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_30); 

                    	                    											newLeafNode(otherlv_34, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_1_1_1_0());
                    	                    										

                    	                    }


                    	                    }


                    	                    }
                    	                    break;

                    	            }

                    	            otherlv_35=(Token)match(input,27,FOLLOW_4); 

                    	            								newLeafNode(otherlv_35, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_1_2());
                    	            							

                    	            }
                    	            break;

                    	    }

                    	    // InternalModelDraw.g:928:7: ( (otherlv_36= RULE_ID ) )
                    	    // InternalModelDraw.g:929:8: (otherlv_36= RULE_ID )
                    	    {
                    	    // InternalModelDraw.g:929:8: (otherlv_36= RULE_ID )
                    	    // InternalModelDraw.g:930:9: otherlv_36= RULE_ID
                    	    {

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getEdgeRule());
                    	    									}
                    	    								
                    	    otherlv_36=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    									newLeafNode(otherlv_36, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_2_0());
                    	    								

                    	    }


                    	    }

                    	    // InternalModelDraw.g:941:7: (otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')' )?
                    	    int alt27=2;
                    	    int LA27_0 = input.LA(1);

                    	    if ( (LA27_0==15) ) {
                    	        alt27=1;
                    	    }
                    	    switch (alt27) {
                    	        case 1 :
                    	            // InternalModelDraw.g:942:8: otherlv_37= '(' ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )? ( (otherlv_42= RULE_ID ) ) otherlv_43= ')'
                    	            {
                    	            otherlv_37=(Token)match(input,15,FOLLOW_4); 

                    	            								newLeafNode(otherlv_37, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_4_3_0());
                    	            							
                    	            // InternalModelDraw.g:946:8: ( ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.' )?
                    	            int alt26=2;
                    	            int LA26_0 = input.LA(1);

                    	            if ( (LA26_0==RULE_ID) ) {
                    	                int LA26_1 = input.LA(2);

                    	                if ( ((LA26_1>=26 && LA26_1<=27)) ) {
                    	                    alt26=1;
                    	                }
                    	            }
                    	            switch (alt26) {
                    	                case 1 :
                    	                    // InternalModelDraw.g:947:9: ( (otherlv_38= RULE_ID ) ) (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )? otherlv_41= '.'
                    	                    {
                    	                    // InternalModelDraw.g:947:9: ( (otherlv_38= RULE_ID ) )
                    	                    // InternalModelDraw.g:948:10: (otherlv_38= RULE_ID )
                    	                    {
                    	                    // InternalModelDraw.g:948:10: (otherlv_38= RULE_ID )
                    	                    // InternalModelDraw.g:949:11: otherlv_38= RULE_ID
                    	                    {

                    	                    											if (current==null) {
                    	                    												current = createModelElement(grammarAccess.getEdgeRule());
                    	                    											}
                    	                    										
                    	                    otherlv_38=(Token)match(input,RULE_ID,FOLLOW_29); 

                    	                    											newLeafNode(otherlv_38, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_3_1_0_0());
                    	                    										

                    	                    }


                    	                    }

                    	                    // InternalModelDraw.g:960:9: (otherlv_39= '->' ( (otherlv_40= RULE_ID ) ) )?
                    	                    int alt25=2;
                    	                    int LA25_0 = input.LA(1);

                    	                    if ( (LA25_0==26) ) {
                    	                        alt25=1;
                    	                    }
                    	                    switch (alt25) {
                    	                        case 1 :
                    	                            // InternalModelDraw.g:961:10: otherlv_39= '->' ( (otherlv_40= RULE_ID ) )
                    	                            {
                    	                            otherlv_39=(Token)match(input,26,FOLLOW_4); 

                    	                            										newLeafNode(otherlv_39, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_3_1_1_0());
                    	                            									
                    	                            // InternalModelDraw.g:965:10: ( (otherlv_40= RULE_ID ) )
                    	                            // InternalModelDraw.g:966:11: (otherlv_40= RULE_ID )
                    	                            {
                    	                            // InternalModelDraw.g:966:11: (otherlv_40= RULE_ID )
                    	                            // InternalModelDraw.g:967:12: otherlv_40= RULE_ID
                    	                            {

                    	                            												if (current==null) {
                    	                            													current = createModelElement(grammarAccess.getEdgeRule());
                    	                            												}
                    	                            											
                    	                            otherlv_40=(Token)match(input,RULE_ID,FOLLOW_30); 

                    	                            												newLeafNode(otherlv_40, grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_3_1_1_1_0());
                    	                            											

                    	                            }


                    	                            }


                    	                            }
                    	                            break;

                    	                    }

                    	                    otherlv_41=(Token)match(input,27,FOLLOW_4); 

                    	                    									newLeafNode(otherlv_41, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_3_1_2());
                    	                    								

                    	                    }
                    	                    break;

                    	            }

                    	            // InternalModelDraw.g:984:8: ( (otherlv_42= RULE_ID ) )
                    	            // InternalModelDraw.g:985:9: (otherlv_42= RULE_ID )
                    	            {
                    	            // InternalModelDraw.g:985:9: (otherlv_42= RULE_ID )
                    	            // InternalModelDraw.g:986:10: otherlv_42= RULE_ID
                    	            {

                    	            										if (current==null) {
                    	            											current = createModelElement(grammarAccess.getEdgeRule());
                    	            										}
                    	            									
                    	            otherlv_42=(Token)match(input,RULE_ID,FOLLOW_24); 

                    	            										newLeafNode(otherlv_42, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_3_2_0());
                    	            									

                    	            }


                    	            }

                    	            otherlv_43=(Token)match(input,17,FOLLOW_33); 

                    	            								newLeafNode(otherlv_43, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_4_3_3());
                    	            							

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_44=(Token)match(input,14,FOLLOW_31); 

                    						newLeafNode(otherlv_44, grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_10_2_1_5());
                    					

                    }


                    }
                    break;

            }


            }

            // InternalModelDraw.g:1010:3: (otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==28) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:1011:4: otherlv_45= 'src_decoration' otherlv_46= '=' ( (lv_src_decoration_47_0= ruleDecoration ) )
                    {
                    otherlv_45=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_45, grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0());
                    			
                    otherlv_46=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_46, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1019:4: ( (lv_src_decoration_47_0= ruleDecoration ) )
                    // InternalModelDraw.g:1020:5: (lv_src_decoration_47_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1020:5: (lv_src_decoration_47_0= ruleDecoration )
                    // InternalModelDraw.g:1021:6: lv_src_decoration_47_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_src_decoration_47_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"src_decoration",
                    							lv_src_decoration_47_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1039:3: (otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalModelDraw.g:1040:4: otherlv_48= 'src_label' otherlv_49= '=' ( (otherlv_50= RULE_ID ) )
                    {
                    otherlv_48=(Token)match(input,29,FOLLOW_15); 

                    				newLeafNode(otherlv_48, grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0());
                    			
                    otherlv_49=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_49, grammarAccess.getEdgeAccess().getEqualsSignKeyword_12_1());
                    			
                    // InternalModelDraw.g:1048:4: ( (otherlv_50= RULE_ID ) )
                    // InternalModelDraw.g:1049:5: (otherlv_50= RULE_ID )
                    {
                    // InternalModelDraw.g:1049:5: (otherlv_50= RULE_ID )
                    // InternalModelDraw.g:1050:6: otherlv_50= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_50=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_50, grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1062:3: (otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==30) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:1063:4: otherlv_51= 'tar_decoration' otherlv_52= '=' ( (lv_tar_decoration_53_0= ruleDecoration ) )
                    {
                    otherlv_51=(Token)match(input,30,FOLLOW_15); 

                    				newLeafNode(otherlv_51, grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0());
                    			
                    otherlv_52=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_52, grammarAccess.getEdgeAccess().getEqualsSignKeyword_13_1());
                    			
                    // InternalModelDraw.g:1071:4: ( (lv_tar_decoration_53_0= ruleDecoration ) )
                    // InternalModelDraw.g:1072:5: (lv_tar_decoration_53_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1072:5: (lv_tar_decoration_53_0= ruleDecoration )
                    // InternalModelDraw.g:1073:6: lv_tar_decoration_53_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_tar_decoration_53_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"tar_decoration",
                    							lv_tar_decoration_53_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1091:3: (otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==31) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:1092:4: otherlv_54= 'tar_label' otherlv_55= '=' ( (otherlv_56= RULE_ID ) )
                    {
                    otherlv_54=(Token)match(input,31,FOLLOW_15); 

                    				newLeafNode(otherlv_54, grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0());
                    			
                    otherlv_55=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_55, grammarAccess.getEdgeAccess().getEqualsSignKeyword_14_1());
                    			
                    // InternalModelDraw.g:1100:4: ( (otherlv_56= RULE_ID ) )
                    // InternalModelDraw.g:1101:5: (otherlv_56= RULE_ID )
                    {
                    // InternalModelDraw.g:1101:5: (otherlv_56= RULE_ID )
                    // InternalModelDraw.g:1102:6: otherlv_56= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_56=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_56, grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_14_2_0());
                    					

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
    // InternalModelDraw.g:1118:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // InternalModelDraw.g:1118:46: (iv_ruleLevel= ruleLevel EOF )
            // InternalModelDraw.g:1119:2: iv_ruleLevel= ruleLevel EOF
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
    // InternalModelDraw.g:1125:1: ruleLevel returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) ) (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) ;
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
            // InternalModelDraw.g:1131:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) ) (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:1132:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) ) (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:1132:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) ) (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            // InternalModelDraw.g:1133:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) ) (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:1133:3: ()
            // InternalModelDraw.g:1134:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLevelAccess().getLevelAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1140:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1141:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1141:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1142:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_1, grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getLevelAccess().getFullStopKeyword_2());
            		
            // InternalModelDraw.g:1157:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:1158:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:1158:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:1159:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_3, grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getLevelAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,24,FOLLOW_26); 

            			newLeafNode(otherlv_5, grammarAccess.getLevelAccess().getEdgeKeyword_5());
            		
            // InternalModelDraw.g:1178:3: (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==18) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:1179:4: otherlv_6= '=' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:1183:4: ( (otherlv_7= RULE_ID ) )
                    // InternalModelDraw.g:1184:5: (otherlv_7= RULE_ID )
                    {
                    // InternalModelDraw.g:1184:5: (otherlv_7= RULE_ID )
                    // InternalModelDraw.g:1185:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_27); 

                    						newLeafNode(otherlv_7, grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1197:3: (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )
            // InternalModelDraw.g:1198:4: otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
            {
            otherlv_8=(Token)match(input,25,FOLLOW_15); 

            				newLeafNode(otherlv_8, grammarAccess.getLevelAccess().getLabelKeyword_7_0());
            			
            otherlv_9=(Token)match(input,18,FOLLOW_28); 

            				newLeafNode(otherlv_9, grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1());
            			
            // InternalModelDraw.g:1206:4: ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            else if ( (LA48_0==13) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalModelDraw.g:1207:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                    {
                    // InternalModelDraw.g:1207:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                    // InternalModelDraw.g:1208:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) )
                    {
                    // InternalModelDraw.g:1208:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ID) ) {
                        int LA36_1 = input.LA(2);

                        if ( ((LA36_1>=26 && LA36_1<=27)) ) {
                            alt36=1;
                        }
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalModelDraw.g:1209:7: ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.'
                            {
                            // InternalModelDraw.g:1209:7: ( (otherlv_10= RULE_ID ) )
                            // InternalModelDraw.g:1210:8: (otherlv_10= RULE_ID )
                            {
                            // InternalModelDraw.g:1210:8: (otherlv_10= RULE_ID )
                            // InternalModelDraw.g:1211:9: otherlv_10= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getLevelRule());
                            									}
                            								
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_29); 

                            									newLeafNode(otherlv_10, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0());
                            								

                            }


                            }

                            // InternalModelDraw.g:1222:7: (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )?
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==26) ) {
                                alt35=1;
                            }
                            switch (alt35) {
                                case 1 :
                                    // InternalModelDraw.g:1223:8: otherlv_11= '->' ( (otherlv_12= RULE_ID ) )
                                    {
                                    otherlv_11=(Token)match(input,26,FOLLOW_4); 

                                    								newLeafNode(otherlv_11, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0());
                                    							
                                    // InternalModelDraw.g:1227:8: ( (otherlv_12= RULE_ID ) )
                                    // InternalModelDraw.g:1228:9: (otherlv_12= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1228:9: (otherlv_12= RULE_ID )
                                    // InternalModelDraw.g:1229:10: otherlv_12= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getLevelRule());
                                    										}
                                    									
                                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_30); 

                                    										newLeafNode(otherlv_12, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0());
                                    									

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_13=(Token)match(input,27,FOLLOW_4); 

                            							newLeafNode(otherlv_13, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_0_0_2());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:1246:6: ( (otherlv_14= RULE_ID ) )
                    // InternalModelDraw.g:1247:7: (otherlv_14= RULE_ID )
                    {
                    // InternalModelDraw.g:1247:7: (otherlv_14= RULE_ID )
                    // InternalModelDraw.g:1248:8: otherlv_14= RULE_ID
                    {

                    								if (current==null) {
                    									current = createModelElement(grammarAccess.getLevelRule());
                    								}
                    							
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_31); 

                    								newLeafNode(otherlv_14, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0());
                    							

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:1261:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                    {
                    // InternalModelDraw.g:1261:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                    // InternalModelDraw.g:1262:6: otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}'
                    {
                    otherlv_15=(Token)match(input,13,FOLLOW_4); 

                    						newLeafNode(otherlv_15, grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0());
                    					
                    // InternalModelDraw.g:1266:6: ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID) ) {
                        int LA38_1 = input.LA(2);

                        if ( ((LA38_1>=26 && LA38_1<=27)) ) {
                            alt38=1;
                        }
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalModelDraw.g:1267:7: ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.'
                            {
                            // InternalModelDraw.g:1267:7: ( (otherlv_16= RULE_ID ) )
                            // InternalModelDraw.g:1268:8: (otherlv_16= RULE_ID )
                            {
                            // InternalModelDraw.g:1268:8: (otherlv_16= RULE_ID )
                            // InternalModelDraw.g:1269:9: otherlv_16= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getLevelRule());
                            									}
                            								
                            otherlv_16=(Token)match(input,RULE_ID,FOLLOW_29); 

                            									newLeafNode(otherlv_16, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0());
                            								

                            }


                            }

                            // InternalModelDraw.g:1280:7: (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )?
                            int alt37=2;
                            int LA37_0 = input.LA(1);

                            if ( (LA37_0==26) ) {
                                alt37=1;
                            }
                            switch (alt37) {
                                case 1 :
                                    // InternalModelDraw.g:1281:8: otherlv_17= '->' ( (otherlv_18= RULE_ID ) )
                                    {
                                    otherlv_17=(Token)match(input,26,FOLLOW_4); 

                                    								newLeafNode(otherlv_17, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0());
                                    							
                                    // InternalModelDraw.g:1285:8: ( (otherlv_18= RULE_ID ) )
                                    // InternalModelDraw.g:1286:9: (otherlv_18= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1286:9: (otherlv_18= RULE_ID )
                                    // InternalModelDraw.g:1287:10: otherlv_18= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getLevelRule());
                                    										}
                                    									
                                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_30); 

                                    										newLeafNode(otherlv_18, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0());
                                    									

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_19=(Token)match(input,27,FOLLOW_4); 

                            							newLeafNode(otherlv_19, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_1_2());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:1304:6: ( (otherlv_20= RULE_ID ) )
                    // InternalModelDraw.g:1305:7: (otherlv_20= RULE_ID )
                    {
                    // InternalModelDraw.g:1305:7: (otherlv_20= RULE_ID )
                    // InternalModelDraw.g:1306:8: otherlv_20= RULE_ID
                    {

                    								if (current==null) {
                    									current = createModelElement(grammarAccess.getLevelRule());
                    								}
                    							
                    otherlv_20=(Token)match(input,RULE_ID,FOLLOW_32); 

                    								newLeafNode(otherlv_20, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0());
                    							

                    }


                    }

                    // InternalModelDraw.g:1317:6: (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==15) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalModelDraw.g:1318:7: otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')'
                            {
                            otherlv_21=(Token)match(input,15,FOLLOW_4); 

                            							newLeafNode(otherlv_21, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0());
                            						
                            // InternalModelDraw.g:1322:7: ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )?
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==RULE_ID) ) {
                                int LA40_1 = input.LA(2);

                                if ( ((LA40_1>=26 && LA40_1<=27)) ) {
                                    alt40=1;
                                }
                            }
                            switch (alt40) {
                                case 1 :
                                    // InternalModelDraw.g:1323:8: ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.'
                                    {
                                    // InternalModelDraw.g:1323:8: ( (otherlv_22= RULE_ID ) )
                                    // InternalModelDraw.g:1324:9: (otherlv_22= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1324:9: (otherlv_22= RULE_ID )
                                    // InternalModelDraw.g:1325:10: otherlv_22= RULE_ID
                                    {

                                    										if (current==null) {
                                    											current = createModelElement(grammarAccess.getLevelRule());
                                    										}
                                    									
                                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_29); 

                                    										newLeafNode(otherlv_22, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0());
                                    									

                                    }


                                    }

                                    // InternalModelDraw.g:1336:8: (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )?
                                    int alt39=2;
                                    int LA39_0 = input.LA(1);

                                    if ( (LA39_0==26) ) {
                                        alt39=1;
                                    }
                                    switch (alt39) {
                                        case 1 :
                                            // InternalModelDraw.g:1337:9: otherlv_23= '->' ( (otherlv_24= RULE_ID ) )
                                            {
                                            otherlv_23=(Token)match(input,26,FOLLOW_4); 

                                            									newLeafNode(otherlv_23, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0());
                                            								
                                            // InternalModelDraw.g:1341:9: ( (otherlv_24= RULE_ID ) )
                                            // InternalModelDraw.g:1342:10: (otherlv_24= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1342:10: (otherlv_24= RULE_ID )
                                            // InternalModelDraw.g:1343:11: otherlv_24= RULE_ID
                                            {

                                            											if (current==null) {
                                            												current = createModelElement(grammarAccess.getLevelRule());
                                            											}
                                            										
                                            otherlv_24=(Token)match(input,RULE_ID,FOLLOW_30); 

                                            											newLeafNode(otherlv_24, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0());
                                            										

                                            }


                                            }


                                            }
                                            break;

                                    }

                                    otherlv_25=(Token)match(input,27,FOLLOW_4); 

                                    								newLeafNode(otherlv_25, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_3_1_2());
                                    							

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1360:7: ( (otherlv_26= RULE_ID ) )
                            // InternalModelDraw.g:1361:8: (otherlv_26= RULE_ID )
                            {
                            // InternalModelDraw.g:1361:8: (otherlv_26= RULE_ID )
                            // InternalModelDraw.g:1362:9: otherlv_26= RULE_ID
                            {

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getLevelRule());
                            									}
                            								
                            otherlv_26=(Token)match(input,RULE_ID,FOLLOW_24); 

                            									newLeafNode(otherlv_26, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0());
                            								

                            }


                            }

                            otherlv_27=(Token)match(input,17,FOLLOW_33); 

                            							newLeafNode(otherlv_27, grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3());
                            						

                            }
                            break;

                    }

                    // InternalModelDraw.g:1378:6: (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==16) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalModelDraw.g:1379:7: otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                    	    {
                    	    otherlv_28=(Token)match(input,16,FOLLOW_4); 

                    	    							newLeafNode(otherlv_28, grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0());
                    	    						
                    	    // InternalModelDraw.g:1383:7: ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )?
                    	    int alt43=2;
                    	    int LA43_0 = input.LA(1);

                    	    if ( (LA43_0==RULE_ID) ) {
                    	        int LA43_1 = input.LA(2);

                    	        if ( ((LA43_1>=26 && LA43_1<=27)) ) {
                    	            alt43=1;
                    	        }
                    	    }
                    	    switch (alt43) {
                    	        case 1 :
                    	            // InternalModelDraw.g:1384:8: ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.'
                    	            {
                    	            // InternalModelDraw.g:1384:8: ( (otherlv_29= RULE_ID ) )
                    	            // InternalModelDraw.g:1385:9: (otherlv_29= RULE_ID )
                    	            {
                    	            // InternalModelDraw.g:1385:9: (otherlv_29= RULE_ID )
                    	            // InternalModelDraw.g:1386:10: otherlv_29= RULE_ID
                    	            {

                    	            										if (current==null) {
                    	            											current = createModelElement(grammarAccess.getLevelRule());
                    	            										}
                    	            									
                    	            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_29); 

                    	            										newLeafNode(otherlv_29, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0());
                    	            									

                    	            }


                    	            }

                    	            // InternalModelDraw.g:1397:8: (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )?
                    	            int alt42=2;
                    	            int LA42_0 = input.LA(1);

                    	            if ( (LA42_0==26) ) {
                    	                alt42=1;
                    	            }
                    	            switch (alt42) {
                    	                case 1 :
                    	                    // InternalModelDraw.g:1398:9: otherlv_30= '->' ( (otherlv_31= RULE_ID ) )
                    	                    {
                    	                    otherlv_30=(Token)match(input,26,FOLLOW_4); 

                    	                    									newLeafNode(otherlv_30, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0());
                    	                    								
                    	                    // InternalModelDraw.g:1402:9: ( (otherlv_31= RULE_ID ) )
                    	                    // InternalModelDraw.g:1403:10: (otherlv_31= RULE_ID )
                    	                    {
                    	                    // InternalModelDraw.g:1403:10: (otherlv_31= RULE_ID )
                    	                    // InternalModelDraw.g:1404:11: otherlv_31= RULE_ID
                    	                    {

                    	                    											if (current==null) {
                    	                    												current = createModelElement(grammarAccess.getLevelRule());
                    	                    											}
                    	                    										
                    	                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_30); 

                    	                    											newLeafNode(otherlv_31, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0());
                    	                    										

                    	                    }


                    	                    }


                    	                    }
                    	                    break;

                    	            }

                    	            otherlv_32=(Token)match(input,27,FOLLOW_4); 

                    	            								newLeafNode(otherlv_32, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_1_2());
                    	            							

                    	            }
                    	            break;

                    	    }

                    	    // InternalModelDraw.g:1421:7: ( (otherlv_33= RULE_ID ) )
                    	    // InternalModelDraw.g:1422:8: (otherlv_33= RULE_ID )
                    	    {
                    	    // InternalModelDraw.g:1422:8: (otherlv_33= RULE_ID )
                    	    // InternalModelDraw.g:1423:9: otherlv_33= RULE_ID
                    	    {

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getLevelRule());
                    	    									}
                    	    								
                    	    otherlv_33=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    									newLeafNode(otherlv_33, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0());
                    	    								

                    	    }


                    	    }

                    	    // InternalModelDraw.g:1434:7: (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                    	    int alt46=2;
                    	    int LA46_0 = input.LA(1);

                    	    if ( (LA46_0==15) ) {
                    	        alt46=1;
                    	    }
                    	    switch (alt46) {
                    	        case 1 :
                    	            // InternalModelDraw.g:1435:8: otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')'
                    	            {
                    	            otherlv_34=(Token)match(input,15,FOLLOW_4); 

                    	            								newLeafNode(otherlv_34, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0());
                    	            							
                    	            // InternalModelDraw.g:1439:8: ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )?
                    	            int alt45=2;
                    	            int LA45_0 = input.LA(1);

                    	            if ( (LA45_0==RULE_ID) ) {
                    	                int LA45_1 = input.LA(2);

                    	                if ( ((LA45_1>=26 && LA45_1<=27)) ) {
                    	                    alt45=1;
                    	                }
                    	            }
                    	            switch (alt45) {
                    	                case 1 :
                    	                    // InternalModelDraw.g:1440:9: ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.'
                    	                    {
                    	                    // InternalModelDraw.g:1440:9: ( (otherlv_35= RULE_ID ) )
                    	                    // InternalModelDraw.g:1441:10: (otherlv_35= RULE_ID )
                    	                    {
                    	                    // InternalModelDraw.g:1441:10: (otherlv_35= RULE_ID )
                    	                    // InternalModelDraw.g:1442:11: otherlv_35= RULE_ID
                    	                    {

                    	                    											if (current==null) {
                    	                    												current = createModelElement(grammarAccess.getLevelRule());
                    	                    											}
                    	                    										
                    	                    otherlv_35=(Token)match(input,RULE_ID,FOLLOW_29); 

                    	                    											newLeafNode(otherlv_35, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0());
                    	                    										

                    	                    }


                    	                    }

                    	                    // InternalModelDraw.g:1453:9: (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )?
                    	                    int alt44=2;
                    	                    int LA44_0 = input.LA(1);

                    	                    if ( (LA44_0==26) ) {
                    	                        alt44=1;
                    	                    }
                    	                    switch (alt44) {
                    	                        case 1 :
                    	                            // InternalModelDraw.g:1454:10: otherlv_36= '->' ( (otherlv_37= RULE_ID ) )
                    	                            {
                    	                            otherlv_36=(Token)match(input,26,FOLLOW_4); 

                    	                            										newLeafNode(otherlv_36, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0());
                    	                            									
                    	                            // InternalModelDraw.g:1458:10: ( (otherlv_37= RULE_ID ) )
                    	                            // InternalModelDraw.g:1459:11: (otherlv_37= RULE_ID )
                    	                            {
                    	                            // InternalModelDraw.g:1459:11: (otherlv_37= RULE_ID )
                    	                            // InternalModelDraw.g:1460:12: otherlv_37= RULE_ID
                    	                            {

                    	                            												if (current==null) {
                    	                            													current = createModelElement(grammarAccess.getLevelRule());
                    	                            												}
                    	                            											
                    	                            otherlv_37=(Token)match(input,RULE_ID,FOLLOW_30); 

                    	                            												newLeafNode(otherlv_37, grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0());
                    	                            											

                    	                            }


                    	                            }


                    	                            }
                    	                            break;

                    	                    }

                    	                    otherlv_38=(Token)match(input,27,FOLLOW_4); 

                    	                    									newLeafNode(otherlv_38, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_3_1_2());
                    	                    								

                    	                    }
                    	                    break;

                    	            }

                    	            // InternalModelDraw.g:1477:8: ( (otherlv_39= RULE_ID ) )
                    	            // InternalModelDraw.g:1478:9: (otherlv_39= RULE_ID )
                    	            {
                    	            // InternalModelDraw.g:1478:9: (otherlv_39= RULE_ID )
                    	            // InternalModelDraw.g:1479:10: otherlv_39= RULE_ID
                    	            {

                    	            										if (current==null) {
                    	            											current = createModelElement(grammarAccess.getLevelRule());
                    	            										}
                    	            									
                    	            otherlv_39=(Token)match(input,RULE_ID,FOLLOW_24); 

                    	            										newLeafNode(otherlv_39, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0());
                    	            									

                    	            }


                    	            }

                    	            otherlv_40=(Token)match(input,17,FOLLOW_33); 

                    	            								newLeafNode(otherlv_40, grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_4_3_3());
                    	            							

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_41=(Token)match(input,14,FOLLOW_31); 

                    						newLeafNode(otherlv_41, grammarAccess.getLevelAccess().getRightCurlyBracketKeyword_7_2_1_5());
                    					

                    }


                    }
                    break;

            }


            }

            // InternalModelDraw.g:1503:3: (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==28) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalModelDraw.g:1504:4: otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) )
                    {
                    otherlv_42=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_42, grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_43=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_43, grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:1512:4: ( (lv_src_decoration_44_0= ruleDecoration ) )
                    // InternalModelDraw.g:1513:5: (lv_src_decoration_44_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1513:5: (lv_src_decoration_44_0= ruleDecoration )
                    // InternalModelDraw.g:1514:6: lv_src_decoration_44_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_35);
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

            // InternalModelDraw.g:1532:3: (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==29) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalModelDraw.g:1533:4: otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) )
                    {
                    otherlv_45=(Token)match(input,29,FOLLOW_15); 

                    				newLeafNode(otherlv_45, grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_46=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_46, grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1541:4: ( (otherlv_47= RULE_ID ) )
                    // InternalModelDraw.g:1542:5: (otherlv_47= RULE_ID )
                    {
                    // InternalModelDraw.g:1542:5: (otherlv_47= RULE_ID )
                    // InternalModelDraw.g:1543:6: otherlv_47= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_47=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_47, grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1555:3: (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==30) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalModelDraw.g:1556:4: otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    {
                    otherlv_48=(Token)match(input,30,FOLLOW_15); 

                    				newLeafNode(otherlv_48, grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_49=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_49, grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1564:4: ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    // InternalModelDraw.g:1565:5: (lv_tar_decoration_50_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1565:5: (lv_tar_decoration_50_0= ruleDecoration )
                    // InternalModelDraw.g:1566:6: lv_tar_decoration_50_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_37);
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

            // InternalModelDraw.g:1584:3: (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==31) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalModelDraw.g:1585:4: otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) )
                    {
                    otherlv_51=(Token)match(input,31,FOLLOW_15); 

                    				newLeafNode(otherlv_51, grammarAccess.getLevelAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_52=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_52, grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1593:4: ( (otherlv_53= RULE_ID ) )
                    // InternalModelDraw.g:1594:5: (otherlv_53= RULE_ID )
                    {
                    // InternalModelDraw.g:1594:5: (otherlv_53= RULE_ID )
                    // InternalModelDraw.g:1595:6: otherlv_53= RULE_ID
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
    // InternalModelDraw.g:1611:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalModelDraw.g:1611:48: (iv_ruleContent= ruleContent EOF )
            // InternalModelDraw.g:1612:2: iv_ruleContent= ruleContent EOF
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
    // InternalModelDraw.g:1618:1: ruleContent returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) ;
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
            // InternalModelDraw.g:1624:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) )
            // InternalModelDraw.g:1625:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            {
            // InternalModelDraw.g:1625:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            // InternalModelDraw.g:1626:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            {
            // InternalModelDraw.g:1626:3: ()
            // InternalModelDraw.g:1627:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContentAccess().getContentAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1633:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1634:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1634:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1635:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContentRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getContentAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getContentAccess().getColonKeyword_2());
            		
            // InternalModelDraw.g:1650:3: ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==33) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalModelDraw.g:1651:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    {
                    // InternalModelDraw.g:1651:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) )
                    // InternalModelDraw.g:1652:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    {
                    // InternalModelDraw.g:1652:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    // InternalModelDraw.g:1653:6: lv_nodenum_3_0= ruleNodeEnumerator
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_38);
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

                    // InternalModelDraw.g:1670:4: ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            int LA53_1 = input.LA(2);

                            if ( (LA53_1==33) ) {
                                alt53=1;
                            }


                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalModelDraw.g:1671:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    {
                    	    // InternalModelDraw.g:1671:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    // InternalModelDraw.g:1672:6: lv_nodenum_4_0= ruleNodeEnumerator
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
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
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:1690:3: ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==EOF||LA56_1==RULE_ID||(LA56_1>=13 && LA56_1<=14)||LA56_1==27||LA56_1==32) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // InternalModelDraw.g:1691:4: ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )*
                    {
                    // InternalModelDraw.g:1691:4: ( (lv_info_5_0= ruleInformation ) )
                    // InternalModelDraw.g:1692:5: (lv_info_5_0= ruleInformation )
                    {
                    // InternalModelDraw.g:1692:5: (lv_info_5_0= ruleInformation )
                    // InternalModelDraw.g:1693:6: lv_info_5_0= ruleInformation
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_38);
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

                    // InternalModelDraw.g:1710:4: ( (lv_info_6_0= ruleInformation ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ID) ) {
                            int LA55_2 = input.LA(2);

                            if ( (LA55_2==EOF||LA55_2==RULE_ID||(LA55_2>=13 && LA55_2<=14)||LA55_2==27||LA55_2==32) ) {
                                alt55=1;
                            }


                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalModelDraw.g:1711:5: (lv_info_6_0= ruleInformation )
                    	    {
                    	    // InternalModelDraw.g:1711:5: (lv_info_6_0= ruleInformation )
                    	    // InternalModelDraw.g:1712:6: lv_info_6_0= ruleInformation
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
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
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:1730:3: (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==13) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalModelDraw.g:1731:4: otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalModelDraw.g:1735:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:1736:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:1736:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:1737:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContentRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_39); 

                    						newLeafNode(otherlv_8, grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0());
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_40); 

                    				newLeafNode(otherlv_9, grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:1753:3: (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==32) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalModelDraw.g:1754:4: otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,32,FOLLOW_15); 

                    				newLeafNode(otherlv_10, grammarAccess.getContentAccess().getTextKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getContentAccess().getEqualsSignKeyword_6_1());
                    			
                    // InternalModelDraw.g:1762:4: ( (lv_symbol_12_0= ruleEString ) )
                    // InternalModelDraw.g:1763:5: (lv_symbol_12_0= ruleEString )
                    {
                    // InternalModelDraw.g:1763:5: (lv_symbol_12_0= ruleEString )
                    // InternalModelDraw.g:1764:6: lv_symbol_12_0= ruleEString
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
    // InternalModelDraw.g:1786:1: entryRuleNodeEnumerator returns [EObject current=null] : iv_ruleNodeEnumerator= ruleNodeEnumerator EOF ;
    public final EObject entryRuleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeEnumerator = null;


        try {
            // InternalModelDraw.g:1786:55: (iv_ruleNodeEnumerator= ruleNodeEnumerator EOF )
            // InternalModelDraw.g:1787:2: iv_ruleNodeEnumerator= ruleNodeEnumerator EOF
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
    // InternalModelDraw.g:1793:1: ruleNodeEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) ;
    public final EObject ruleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_enumerator_3_0 = null;

        EObject lv_enumerator_4_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1799:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) )
            // InternalModelDraw.g:1800:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            {
            // InternalModelDraw.g:1800:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            // InternalModelDraw.g:1801:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']'
            {
            // InternalModelDraw.g:1801:3: ()
            // InternalModelDraw.g:1802:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1808:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1809:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1809:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1810:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_1, grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalModelDraw.g:1825:3: ( (lv_enumerator_3_0= ruleEnumerator ) )
            // InternalModelDraw.g:1826:4: (lv_enumerator_3_0= ruleEnumerator )
            {
            // InternalModelDraw.g:1826:4: (lv_enumerator_3_0= ruleEnumerator )
            // InternalModelDraw.g:1827:5: lv_enumerator_3_0= ruleEnumerator
            {

            					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_42);
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

            // InternalModelDraw.g:1844:3: ( (lv_enumerator_4_0= ruleEnumerator ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalModelDraw.g:1845:4: (lv_enumerator_4_0= ruleEnumerator )
            	    {
            	    // InternalModelDraw.g:1845:4: (lv_enumerator_4_0= ruleEnumerator )
            	    // InternalModelDraw.g:1846:5: lv_enumerator_4_0= ruleEnumerator
            	    {

            	    					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_42);
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
            	    break loop59;
                }
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_2); 

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
    // InternalModelDraw.g:1871:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalModelDraw.g:1871:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalModelDraw.g:1872:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalModelDraw.g:1878:1: ruleEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1884:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) )
            // InternalModelDraw.g:1885:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            {
            // InternalModelDraw.g:1885:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            // InternalModelDraw.g:1886:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) )
            {
            // InternalModelDraw.g:1886:3: ()
            // InternalModelDraw.g:1887:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumeratorAccess().getEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1893:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1894:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1894:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1895:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_1, grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2());
            		
            // InternalModelDraw.g:1910:3: ( (lv_value_3_0= ruleEString ) )
            // InternalModelDraw.g:1911:4: (lv_value_3_0= ruleEString )
            {
            // InternalModelDraw.g:1911:4: (lv_value_3_0= ruleEString )
            // InternalModelDraw.g:1912:5: lv_value_3_0= ruleEString
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
    // InternalModelDraw.g:1933:1: entryRuleInformation returns [EObject current=null] : iv_ruleInformation= ruleInformation EOF ;
    public final EObject entryRuleInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformation = null;


        try {
            // InternalModelDraw.g:1933:52: (iv_ruleInformation= ruleInformation EOF )
            // InternalModelDraw.g:1934:2: iv_ruleInformation= ruleInformation EOF
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
    // InternalModelDraw.g:1940:1: ruleInformation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1946:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:1947:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:1947:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalModelDraw.g:1948:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:1948:3: ()
            // InternalModelDraw.g:1949:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInformationAccess().getInformationAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1955:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1956:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1956:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1957:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(otherlv_1, grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:1968:3: (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==27) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalModelDraw.g:1969:4: otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getInformationAccess().getFullStopKeyword_2_0());
                    			
                    // InternalModelDraw.g:1973:4: ( (otherlv_3= RULE_ID ) )
                    // InternalModelDraw.g:1974:5: (otherlv_3= RULE_ID )
                    {
                    // InternalModelDraw.g:1974:5: (otherlv_3= RULE_ID )
                    // InternalModelDraw.g:1975:6: otherlv_3= RULE_ID
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
    // InternalModelDraw.g:1991:1: ruleDrawType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleDrawType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1997:2: ( (enumLiteral_0= 'diagram' ) )
            // InternalModelDraw.g:1998:2: (enumLiteral_0= 'diagram' )
            {
            // InternalModelDraw.g:1998:2: (enumLiteral_0= 'diagram' )
            // InternalModelDraw.g:1999:3: enumLiteral_0= 'diagram'
            {
            enumLiteral_0=(Token)match(input,35,FOLLOW_2); 

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
    // InternalModelDraw.g:2008:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2014:2: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // InternalModelDraw.g:2015:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // InternalModelDraw.g:2015:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==36) ) {
                alt61=1;
            }
            else if ( (LA61_0==37) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalModelDraw.g:2016:3: (enumLiteral_0= 'node' )
                    {
                    // InternalModelDraw.g:2016:3: (enumLiteral_0= 'node' )
                    // InternalModelDraw.g:2017:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2024:3: (enumLiteral_1= 'markednode' )
                    {
                    // InternalModelDraw.g:2024:3: (enumLiteral_1= 'markednode' )
                    // InternalModelDraw.g:2025:4: enumLiteral_1= 'markednode'
                    {
                    enumLiteral_1=(Token)match(input,37,FOLLOW_2); 

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
    // InternalModelDraw.g:2035:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2041:2: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) )
            // InternalModelDraw.g:2042:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
            {
            // InternalModelDraw.g:2042:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt62=1;
                }
                break;
            case 39:
                {
                alt62=2;
                }
                break;
            case 40:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalModelDraw.g:2043:3: (enumLiteral_0= 'circle' )
                    {
                    // InternalModelDraw.g:2043:3: (enumLiteral_0= 'circle' )
                    // InternalModelDraw.g:2044:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2051:3: (enumLiteral_1= 'doublecircle' )
                    {
                    // InternalModelDraw.g:2051:3: (enumLiteral_1= 'doublecircle' )
                    // InternalModelDraw.g:2052:4: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2059:3: (enumLiteral_2= 'record' )
                    {
                    // InternalModelDraw.g:2059:3: (enumLiteral_2= 'record' )
                    // InternalModelDraw.g:2060:4: enumLiteral_2= 'record'
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2());
                    			

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
    // InternalModelDraw.g:2070:1: ruleNodeColor returns [Enumerator current=null] : (enumLiteral_0= 'gray95' ) ;
    public final Enumerator ruleNodeColor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2076:2: ( (enumLiteral_0= 'gray95' ) )
            // InternalModelDraw.g:2077:2: (enumLiteral_0= 'gray95' )
            {
            // InternalModelDraw.g:2077:2: (enumLiteral_0= 'gray95' )
            // InternalModelDraw.g:2078:3: enumLiteral_0= 'gray95'
            {
            enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

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
    // InternalModelDraw.g:2087:1: ruleNodeStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) ;
    public final Enumerator ruleNodeStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2093:2: ( ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) )
            // InternalModelDraw.g:2094:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            {
            // InternalModelDraw.g:2094:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==42) ) {
                alt63=1;
            }
            else if ( (LA63_0==43) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalModelDraw.g:2095:3: (enumLiteral_0= 'italic' )
                    {
                    // InternalModelDraw.g:2095:3: (enumLiteral_0= 'italic' )
                    // InternalModelDraw.g:2096:4: enumLiteral_0= 'italic'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2103:3: (enumLiteral_1= 'underline' )
                    {
                    // InternalModelDraw.g:2103:3: (enumLiteral_1= 'underline' )
                    // InternalModelDraw.g:2104:4: enumLiteral_1= 'underline'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

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
    // InternalModelDraw.g:2114:1: ruleDecoration returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) ;
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
            // InternalModelDraw.g:2120:2: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) )
            // InternalModelDraw.g:2121:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            {
            // InternalModelDraw.g:2121:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt64=1;
                }
                break;
            case 45:
                {
                alt64=2;
                }
                break;
            case 46:
                {
                alt64=3;
                }
                break;
            case 47:
                {
                alt64=4;
                }
                break;
            case 48:
                {
                alt64=5;
                }
                break;
            case 49:
                {
                alt64=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalModelDraw.g:2122:3: (enumLiteral_0= 'none' )
                    {
                    // InternalModelDraw.g:2122:3: (enumLiteral_0= 'none' )
                    // InternalModelDraw.g:2123:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2130:3: (enumLiteral_1= 'triangle' )
                    {
                    // InternalModelDraw.g:2130:3: (enumLiteral_1= 'triangle' )
                    // InternalModelDraw.g:2131:4: enumLiteral_1= 'triangle'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2138:3: (enumLiteral_2= 'diamond' )
                    {
                    // InternalModelDraw.g:2138:3: (enumLiteral_2= 'diamond' )
                    // InternalModelDraw.g:2139:4: enumLiteral_2= 'diamond'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:2146:3: (enumLiteral_3= 'odiamond' )
                    {
                    // InternalModelDraw.g:2146:3: (enumLiteral_3= 'odiamond' )
                    // InternalModelDraw.g:2147:4: enumLiteral_3= 'odiamond'
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:2154:3: (enumLiteral_4= 'open' )
                    {
                    // InternalModelDraw.g:2154:3: (enumLiteral_4= 'open' )
                    // InternalModelDraw.g:2155:4: enumLiteral_4= 'open'
                    {
                    enumLiteral_4=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:2162:3: (enumLiteral_5= 'empty' )
                    {
                    // InternalModelDraw.g:2162:3: (enumLiteral_5= 'empty' )
                    // InternalModelDraw.g:2163:4: enumLiteral_5= 'empty'
                    {
                    enumLiteral_5=(Token)match(input,49,FOLLOW_2); 

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


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\4\1\14\1\uffff\2\4\1\uffff\1\20\1\4\1\20\1\14\1\30";
    static final String dfa_3s = "\1\16\1\33\1\uffff\1\27\1\45\1\uffff\1\21\1\27\1\21\1\14\1\45";
    static final String dfa_4s = "\2\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\11\uffff\1\2",
            "\1\4\2\uffff\1\3\13\uffff\1\2",
            "",
            "\1\6\22\uffff\1\5",
            "\1\2\10\uffff\2\2\21\uffff\1\2\3\uffff\2\5",
            "",
            "\1\7\1\5",
            "\1\10\22\uffff\1\5",
            "\1\5\1\11",
            "\1\12",
            "\1\2\13\uffff\2\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 150:3: ( (lv_nodes_7_0= ruleNode ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000007C0002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000780002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0003F00000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100002012L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000008000002L});

}