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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "':'", "'{'", "'}'", "'('", "','", "')'", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'not'", "'edge'", "'label'", "'.'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'diagram'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'gray95'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'"
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

                    if ( (LA2_1==15||LA2_1==26) ) {
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
                else if ( (LA14_1==26) ) {
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
    // InternalModelDraw.g:611:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? ) ;
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
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Enumerator lv_src_decoration_18_0 = null;

        Enumerator lv_tar_decoration_24_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:617:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:618:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:618:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? )
            // InternalModelDraw.g:619:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )?
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

            // InternalModelDraw.g:704:3: (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:705:4: otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,25,FOLLOW_15); 

                    				newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getLabelKeyword_10_0());
                    			
                    otherlv_12=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:713:4: ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID) ) {
                        int LA16_1 = input.LA(2);

                        if ( (LA16_1==26) ) {
                            alt16=1;
                        }
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalModelDraw.g:714:5: ( (otherlv_13= RULE_ID ) ) otherlv_14= '.'
                            {
                            // InternalModelDraw.g:714:5: ( (otherlv_13= RULE_ID ) )
                            // InternalModelDraw.g:715:6: (otherlv_13= RULE_ID )
                            {
                            // InternalModelDraw.g:715:6: (otherlv_13= RULE_ID )
                            // InternalModelDraw.g:716:7: otherlv_13= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getEdgeRule());
                            							}
                            						
                            otherlv_13=(Token)match(input,RULE_ID,FOLLOW_28); 

                            							newLeafNode(otherlv_13, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0());
                            						

                            }


                            }

                            otherlv_14=(Token)match(input,26,FOLLOW_4); 

                            					newLeafNode(otherlv_14, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1());
                            				

                            }
                            break;

                    }

                    // InternalModelDraw.g:732:4: ( (otherlv_15= RULE_ID ) )
                    // InternalModelDraw.g:733:5: (otherlv_15= RULE_ID )
                    {
                    // InternalModelDraw.g:733:5: (otherlv_15= RULE_ID )
                    // InternalModelDraw.g:734:6: otherlv_15= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_29); 

                    						newLeafNode(otherlv_15, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:746:3: (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:747:4: otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) )
                    {
                    otherlv_16=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_16, grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0());
                    			
                    otherlv_17=(Token)match(input,18,FOLLOW_30); 

                    				newLeafNode(otherlv_17, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:755:4: ( (lv_src_decoration_18_0= ruleDecoration ) )
                    // InternalModelDraw.g:756:5: (lv_src_decoration_18_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:756:5: (lv_src_decoration_18_0= ruleDecoration )
                    // InternalModelDraw.g:757:6: lv_src_decoration_18_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_src_decoration_18_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"src_decoration",
                    							lv_src_decoration_18_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:775:3: (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:776:4: otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) )
                    {
                    otherlv_19=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_19, grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0());
                    			
                    otherlv_20=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_20, grammarAccess.getEdgeAccess().getEqualsSignKeyword_12_1());
                    			
                    // InternalModelDraw.g:784:4: ( (otherlv_21= RULE_ID ) )
                    // InternalModelDraw.g:785:5: (otherlv_21= RULE_ID )
                    {
                    // InternalModelDraw.g:785:5: (otherlv_21= RULE_ID )
                    // InternalModelDraw.g:786:6: otherlv_21= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_21, grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:798:3: (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:799:4: otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) )
                    {
                    otherlv_22=(Token)match(input,29,FOLLOW_15); 

                    				newLeafNode(otherlv_22, grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0());
                    			
                    otherlv_23=(Token)match(input,18,FOLLOW_30); 

                    				newLeafNode(otherlv_23, grammarAccess.getEdgeAccess().getEqualsSignKeyword_13_1());
                    			
                    // InternalModelDraw.g:807:4: ( (lv_tar_decoration_24_0= ruleDecoration ) )
                    // InternalModelDraw.g:808:5: (lv_tar_decoration_24_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:808:5: (lv_tar_decoration_24_0= ruleDecoration )
                    // InternalModelDraw.g:809:6: lv_tar_decoration_24_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_tar_decoration_24_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEdgeRule());
                    						}
                    						set(
                    							current,
                    							"tar_decoration",
                    							lv_tar_decoration_24_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:827:3: (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalModelDraw.g:828:4: otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) )
                    {
                    otherlv_25=(Token)match(input,30,FOLLOW_15); 

                    				newLeafNode(otherlv_25, grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0());
                    			
                    otherlv_26=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_26, grammarAccess.getEdgeAccess().getEqualsSignKeyword_14_1());
                    			
                    // InternalModelDraw.g:836:4: ( (otherlv_27= RULE_ID ) )
                    // InternalModelDraw.g:837:5: (otherlv_27= RULE_ID )
                    {
                    // InternalModelDraw.g:837:5: (otherlv_27= RULE_ID )
                    // InternalModelDraw.g:838:6: otherlv_27= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEdgeRule());
                    						}
                    					
                    otherlv_27=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_27, grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_14_2_0());
                    					

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
    // InternalModelDraw.g:854:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // InternalModelDraw.g:854:46: (iv_ruleLevel= ruleLevel EOF )
            // InternalModelDraw.g:855:2: iv_ruleLevel= ruleLevel EOF
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
    // InternalModelDraw.g:861:1: ruleLevel returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? ) ;
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
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Enumerator lv_src_decoration_15_0 = null;

        Enumerator lv_tar_decoration_21_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:867:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:868:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:868:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? )
            // InternalModelDraw.g:869:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:869:3: ()
            // InternalModelDraw.g:870:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLevelAccess().getLevelAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:876:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:877:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:877:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:878:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(otherlv_1, grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getLevelAccess().getFullStopKeyword_2());
            		
            // InternalModelDraw.g:893:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:894:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:894:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:895:5: otherlv_3= RULE_ID
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
            		
            // InternalModelDraw.g:914:3: (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==18) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalModelDraw.g:915:4: otherlv_6= '=' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:919:4: ( (otherlv_7= RULE_ID ) )
                    // InternalModelDraw.g:920:5: (otherlv_7= RULE_ID )
                    {
                    // InternalModelDraw.g:920:5: (otherlv_7= RULE_ID )
                    // InternalModelDraw.g:921:6: otherlv_7= RULE_ID
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

            // InternalModelDraw.g:933:3: (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==25) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalModelDraw.g:934:4: otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_15); 

                    				newLeafNode(otherlv_8, grammarAccess.getLevelAccess().getLabelKeyword_7_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:942:4: ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_ID) ) {
                        int LA23_1 = input.LA(2);

                        if ( (LA23_1==26) ) {
                            alt23=1;
                        }
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalModelDraw.g:943:5: ( (otherlv_10= RULE_ID ) ) otherlv_11= '.'
                            {
                            // InternalModelDraw.g:943:5: ( (otherlv_10= RULE_ID ) )
                            // InternalModelDraw.g:944:6: (otherlv_10= RULE_ID )
                            {
                            // InternalModelDraw.g:944:6: (otherlv_10= RULE_ID )
                            // InternalModelDraw.g:945:7: otherlv_10= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLevelRule());
                            							}
                            						
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_28); 

                            							newLeafNode(otherlv_10, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0());
                            						

                            }


                            }

                            otherlv_11=(Token)match(input,26,FOLLOW_4); 

                            					newLeafNode(otherlv_11, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1());
                            				

                            }
                            break;

                    }

                    // InternalModelDraw.g:961:4: ( (otherlv_12= RULE_ID ) )
                    // InternalModelDraw.g:962:5: (otherlv_12= RULE_ID )
                    {
                    // InternalModelDraw.g:962:5: (otherlv_12= RULE_ID )
                    // InternalModelDraw.g:963:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_29); 

                    						newLeafNode(otherlv_12, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:975:3: (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:976:4: otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) )
                    {
                    otherlv_13=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_13, grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_14=(Token)match(input,18,FOLLOW_30); 

                    				newLeafNode(otherlv_14, grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:984:4: ( (lv_src_decoration_15_0= ruleDecoration ) )
                    // InternalModelDraw.g:985:5: (lv_src_decoration_15_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:985:5: (lv_src_decoration_15_0= ruleDecoration )
                    // InternalModelDraw.g:986:6: lv_src_decoration_15_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_src_decoration_15_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLevelRule());
                    						}
                    						set(
                    							current,
                    							"src_decoration",
                    							lv_src_decoration_15_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1004:3: (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==28) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:1005:4: otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_16, grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_17=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_17, grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1013:4: ( (otherlv_18= RULE_ID ) )
                    // InternalModelDraw.g:1014:5: (otherlv_18= RULE_ID )
                    {
                    // InternalModelDraw.g:1014:5: (otherlv_18= RULE_ID )
                    // InternalModelDraw.g:1015:6: otherlv_18= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_18, grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1027:3: (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==29) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:1028:4: otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) )
                    {
                    otherlv_19=(Token)match(input,29,FOLLOW_15); 

                    				newLeafNode(otherlv_19, grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_20=(Token)match(input,18,FOLLOW_30); 

                    				newLeafNode(otherlv_20, grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1036:4: ( (lv_tar_decoration_21_0= ruleDecoration ) )
                    // InternalModelDraw.g:1037:5: (lv_tar_decoration_21_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1037:5: (lv_tar_decoration_21_0= ruleDecoration )
                    // InternalModelDraw.g:1038:6: lv_tar_decoration_21_0= ruleDecoration
                    {

                    						newCompositeNode(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_tar_decoration_21_0=ruleDecoration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLevelRule());
                    						}
                    						set(
                    							current,
                    							"tar_decoration",
                    							lv_tar_decoration_21_0,
                    							"wodeledu.dsls.ModelDraw.Decoration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:1056:3: (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:1057:4: otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) )
                    {
                    otherlv_22=(Token)match(input,30,FOLLOW_15); 

                    				newLeafNode(otherlv_22, grammarAccess.getLevelAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_23=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1065:4: ( (otherlv_24= RULE_ID ) )
                    // InternalModelDraw.g:1066:5: (otherlv_24= RULE_ID )
                    {
                    // InternalModelDraw.g:1066:5: (otherlv_24= RULE_ID )
                    // InternalModelDraw.g:1067:6: otherlv_24= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLevelRule());
                    						}
                    					
                    otherlv_24=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_24, grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0());
                    					

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
    // InternalModelDraw.g:1083:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalModelDraw.g:1083:48: (iv_ruleContent= ruleContent EOF )
            // InternalModelDraw.g:1084:2: iv_ruleContent= ruleContent EOF
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
    // InternalModelDraw.g:1090:1: ruleContent returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) ;
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
            // InternalModelDraw.g:1096:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) )
            // InternalModelDraw.g:1097:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            {
            // InternalModelDraw.g:1097:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            // InternalModelDraw.g:1098:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            {
            // InternalModelDraw.g:1098:3: ()
            // InternalModelDraw.g:1099:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContentAccess().getContentAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1105:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1106:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1106:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1107:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContentRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getContentAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getContentAccess().getColonKeyword_2());
            		
            // InternalModelDraw.g:1122:3: ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==32) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:1123:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    {
                    // InternalModelDraw.g:1123:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) )
                    // InternalModelDraw.g:1124:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    {
                    // InternalModelDraw.g:1124:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    // InternalModelDraw.g:1125:6: lv_nodenum_3_0= ruleNodeEnumerator
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalModelDraw.g:1142:4: ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID) ) {
                            int LA29_1 = input.LA(2);

                            if ( (LA29_1==32) ) {
                                alt29=1;
                            }


                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalModelDraw.g:1143:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    {
                    	    // InternalModelDraw.g:1143:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    // InternalModelDraw.g:1144:6: lv_nodenum_4_0= ruleNodeEnumerator
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:1162:3: ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==EOF||LA32_1==RULE_ID||(LA32_1>=13 && LA32_1<=14)||LA32_1==26||LA32_1==31) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:1163:4: ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )*
                    {
                    // InternalModelDraw.g:1163:4: ( (lv_info_5_0= ruleInformation ) )
                    // InternalModelDraw.g:1164:5: (lv_info_5_0= ruleInformation )
                    {
                    // InternalModelDraw.g:1164:5: (lv_info_5_0= ruleInformation )
                    // InternalModelDraw.g:1165:6: lv_info_5_0= ruleInformation
                    {

                    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalModelDraw.g:1182:4: ( (lv_info_6_0= ruleInformation ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_ID) ) {
                            int LA31_2 = input.LA(2);

                            if ( (LA31_2==EOF||LA31_2==RULE_ID||(LA31_2>=13 && LA31_2<=14)||LA31_2==26||LA31_2==31) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalModelDraw.g:1183:5: (lv_info_6_0= ruleInformation )
                    	    {
                    	    // InternalModelDraw.g:1183:5: (lv_info_6_0= ruleInformation )
                    	    // InternalModelDraw.g:1184:6: lv_info_6_0= ruleInformation
                    	    {

                    	    						newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:1202:3: (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==13) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:1203:4: otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalModelDraw.g:1207:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:1208:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:1208:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:1209:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContentRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_35); 

                    						newLeafNode(otherlv_8, grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0());
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_9, grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:1225:3: (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:1226:4: otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,31,FOLLOW_15); 

                    				newLeafNode(otherlv_10, grammarAccess.getContentAccess().getTextKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getContentAccess().getEqualsSignKeyword_6_1());
                    			
                    // InternalModelDraw.g:1234:4: ( (lv_symbol_12_0= ruleEString ) )
                    // InternalModelDraw.g:1235:5: (lv_symbol_12_0= ruleEString )
                    {
                    // InternalModelDraw.g:1235:5: (lv_symbol_12_0= ruleEString )
                    // InternalModelDraw.g:1236:6: lv_symbol_12_0= ruleEString
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
    // InternalModelDraw.g:1258:1: entryRuleNodeEnumerator returns [EObject current=null] : iv_ruleNodeEnumerator= ruleNodeEnumerator EOF ;
    public final EObject entryRuleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeEnumerator = null;


        try {
            // InternalModelDraw.g:1258:55: (iv_ruleNodeEnumerator= ruleNodeEnumerator EOF )
            // InternalModelDraw.g:1259:2: iv_ruleNodeEnumerator= ruleNodeEnumerator EOF
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
    // InternalModelDraw.g:1265:1: ruleNodeEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) ;
    public final EObject ruleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_enumerator_3_0 = null;

        EObject lv_enumerator_4_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1271:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) )
            // InternalModelDraw.g:1272:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            {
            // InternalModelDraw.g:1272:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            // InternalModelDraw.g:1273:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']'
            {
            // InternalModelDraw.g:1273:3: ()
            // InternalModelDraw.g:1274:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1280:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1281:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1281:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1282:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_1, grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalModelDraw.g:1297:3: ( (lv_enumerator_3_0= ruleEnumerator ) )
            // InternalModelDraw.g:1298:4: (lv_enumerator_3_0= ruleEnumerator )
            {
            // InternalModelDraw.g:1298:4: (lv_enumerator_3_0= ruleEnumerator )
            // InternalModelDraw.g:1299:5: lv_enumerator_3_0= ruleEnumerator
            {

            					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalModelDraw.g:1316:3: ( (lv_enumerator_4_0= ruleEnumerator ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalModelDraw.g:1317:4: (lv_enumerator_4_0= ruleEnumerator )
            	    {
            	    // InternalModelDraw.g:1317:4: (lv_enumerator_4_0= ruleEnumerator )
            	    // InternalModelDraw.g:1318:5: lv_enumerator_4_0= ruleEnumerator
            	    {

            	    					newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_38);
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
            	    break loop35;
                }
            } while (true);

            otherlv_5=(Token)match(input,33,FOLLOW_2); 

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
    // InternalModelDraw.g:1343:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalModelDraw.g:1343:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalModelDraw.g:1344:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalModelDraw.g:1350:1: ruleEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:1356:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) )
            // InternalModelDraw.g:1357:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            {
            // InternalModelDraw.g:1357:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            // InternalModelDraw.g:1358:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) )
            {
            // InternalModelDraw.g:1358:3: ()
            // InternalModelDraw.g:1359:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumeratorAccess().getEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1365:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1366:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1366:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1367:5: otherlv_1= RULE_ID
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
            		
            // InternalModelDraw.g:1382:3: ( (lv_value_3_0= ruleEString ) )
            // InternalModelDraw.g:1383:4: (lv_value_3_0= ruleEString )
            {
            // InternalModelDraw.g:1383:4: (lv_value_3_0= ruleEString )
            // InternalModelDraw.g:1384:5: lv_value_3_0= ruleEString
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
    // InternalModelDraw.g:1405:1: entryRuleInformation returns [EObject current=null] : iv_ruleInformation= ruleInformation EOF ;
    public final EObject entryRuleInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformation = null;


        try {
            // InternalModelDraw.g:1405:52: (iv_ruleInformation= ruleInformation EOF )
            // InternalModelDraw.g:1406:2: iv_ruleInformation= ruleInformation EOF
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
    // InternalModelDraw.g:1412:1: ruleInformation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1418:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:1419:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:1419:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalModelDraw.g:1420:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:1420:3: ()
            // InternalModelDraw.g:1421:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInformationAccess().getInformationAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1427:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1428:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1428:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1429:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_1, grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:1440:3: (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==26) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalModelDraw.g:1441:4: otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getInformationAccess().getFullStopKeyword_2_0());
                    			
                    // InternalModelDraw.g:1445:4: ( (otherlv_3= RULE_ID ) )
                    // InternalModelDraw.g:1446:5: (otherlv_3= RULE_ID )
                    {
                    // InternalModelDraw.g:1446:5: (otherlv_3= RULE_ID )
                    // InternalModelDraw.g:1447:6: otherlv_3= RULE_ID
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
    // InternalModelDraw.g:1463:1: ruleDrawType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleDrawType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1469:2: ( (enumLiteral_0= 'diagram' ) )
            // InternalModelDraw.g:1470:2: (enumLiteral_0= 'diagram' )
            {
            // InternalModelDraw.g:1470:2: (enumLiteral_0= 'diagram' )
            // InternalModelDraw.g:1471:3: enumLiteral_0= 'diagram'
            {
            enumLiteral_0=(Token)match(input,34,FOLLOW_2); 

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
    // InternalModelDraw.g:1480:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1486:2: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // InternalModelDraw.g:1487:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // InternalModelDraw.g:1487:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==35) ) {
                alt37=1;
            }
            else if ( (LA37_0==36) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalModelDraw.g:1488:3: (enumLiteral_0= 'node' )
                    {
                    // InternalModelDraw.g:1488:3: (enumLiteral_0= 'node' )
                    // InternalModelDraw.g:1489:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:1496:3: (enumLiteral_1= 'markednode' )
                    {
                    // InternalModelDraw.g:1496:3: (enumLiteral_1= 'markednode' )
                    // InternalModelDraw.g:1497:4: enumLiteral_1= 'markednode'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_2); 

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
    // InternalModelDraw.g:1507:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1513:2: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) )
            // InternalModelDraw.g:1514:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
            {
            // InternalModelDraw.g:1514:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt38=1;
                }
                break;
            case 38:
                {
                alt38=2;
                }
                break;
            case 39:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalModelDraw.g:1515:3: (enumLiteral_0= 'circle' )
                    {
                    // InternalModelDraw.g:1515:3: (enumLiteral_0= 'circle' )
                    // InternalModelDraw.g:1516:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:1523:3: (enumLiteral_1= 'doublecircle' )
                    {
                    // InternalModelDraw.g:1523:3: (enumLiteral_1= 'doublecircle' )
                    // InternalModelDraw.g:1524:4: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:1531:3: (enumLiteral_2= 'record' )
                    {
                    // InternalModelDraw.g:1531:3: (enumLiteral_2= 'record' )
                    // InternalModelDraw.g:1532:4: enumLiteral_2= 'record'
                    {
                    enumLiteral_2=(Token)match(input,39,FOLLOW_2); 

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
    // InternalModelDraw.g:1542:1: ruleNodeColor returns [Enumerator current=null] : (enumLiteral_0= 'gray95' ) ;
    public final Enumerator ruleNodeColor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1548:2: ( (enumLiteral_0= 'gray95' ) )
            // InternalModelDraw.g:1549:2: (enumLiteral_0= 'gray95' )
            {
            // InternalModelDraw.g:1549:2: (enumLiteral_0= 'gray95' )
            // InternalModelDraw.g:1550:3: enumLiteral_0= 'gray95'
            {
            enumLiteral_0=(Token)match(input,40,FOLLOW_2); 

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
    // InternalModelDraw.g:1559:1: ruleNodeStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) ;
    public final Enumerator ruleNodeStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:1565:2: ( ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) )
            // InternalModelDraw.g:1566:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            {
            // InternalModelDraw.g:1566:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==41) ) {
                alt39=1;
            }
            else if ( (LA39_0==42) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalModelDraw.g:1567:3: (enumLiteral_0= 'italic' )
                    {
                    // InternalModelDraw.g:1567:3: (enumLiteral_0= 'italic' )
                    // InternalModelDraw.g:1568:4: enumLiteral_0= 'italic'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:1575:3: (enumLiteral_1= 'underline' )
                    {
                    // InternalModelDraw.g:1575:3: (enumLiteral_1= 'underline' )
                    // InternalModelDraw.g:1576:4: enumLiteral_1= 'underline'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

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
    // InternalModelDraw.g:1586:1: ruleDecoration returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) ;
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
            // InternalModelDraw.g:1592:2: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) )
            // InternalModelDraw.g:1593:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            {
            // InternalModelDraw.g:1593:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt40=1;
                }
                break;
            case 44:
                {
                alt40=2;
                }
                break;
            case 45:
                {
                alt40=3;
                }
                break;
            case 46:
                {
                alt40=4;
                }
                break;
            case 47:
                {
                alt40=5;
                }
                break;
            case 48:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalModelDraw.g:1594:3: (enumLiteral_0= 'none' )
                    {
                    // InternalModelDraw.g:1594:3: (enumLiteral_0= 'none' )
                    // InternalModelDraw.g:1595:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:1602:3: (enumLiteral_1= 'triangle' )
                    {
                    // InternalModelDraw.g:1602:3: (enumLiteral_1= 'triangle' )
                    // InternalModelDraw.g:1603:4: enumLiteral_1= 'triangle'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:1610:3: (enumLiteral_2= 'diamond' )
                    {
                    // InternalModelDraw.g:1610:3: (enumLiteral_2= 'diamond' )
                    // InternalModelDraw.g:1611:4: enumLiteral_2= 'diamond'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:1618:3: (enumLiteral_3= 'odiamond' )
                    {
                    // InternalModelDraw.g:1618:3: (enumLiteral_3= 'odiamond' )
                    // InternalModelDraw.g:1619:4: enumLiteral_3= 'odiamond'
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:1626:3: (enumLiteral_4= 'open' )
                    {
                    // InternalModelDraw.g:1626:3: (enumLiteral_4= 'open' )
                    // InternalModelDraw.g:1627:4: enumLiteral_4= 'open'
                    {
                    enumLiteral_4=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:1634:3: (enumLiteral_5= 'empty' )
                    {
                    // InternalModelDraw.g:1634:3: (enumLiteral_5= 'empty' )
                    // InternalModelDraw.g:1635:4: enumLiteral_5= 'empty'
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_2); 

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
    static final String dfa_3s = "\1\16\1\32\1\uffff\1\27\1\44\1\uffff\1\21\1\27\1\21\1\14\1\44";
    static final String dfa_4s = "\2\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\11\uffff\1\2",
            "\1\4\2\uffff\1\3\12\uffff\1\2",
            "",
            "\1\6\22\uffff\1\5",
            "\1\2\10\uffff\2\2\20\uffff\1\2\3\uffff\2\5",
            "",
            "\1\7\1\5",
            "\1\10\22\uffff\1\5",
            "\1\5\1\11",
            "\1\12",
            "\1\2\12\uffff\2\5"
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
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000007C0002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000780002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000007A040002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000007A000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001F80000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080002012L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000004000002L});

}