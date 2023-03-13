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

                    if ( (LA2_1==15||LA2_1==18||LA2_1==29) ) {
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
    // InternalModelDraw.g:256:1: ruleNode returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? ) ;
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
            // InternalModelDraw.g:262:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? ) )
            // InternalModelDraw.g:263:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? )
            {
            // InternalModelDraw.g:263:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )? )
            // InternalModelDraw.g:264:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )? otherlv_14= ':' ( (lv_type_15_0= ruleNodeType ) ) (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )? (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )? (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )? (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )? (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )?
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

            // InternalModelDraw.g:284:3: (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelDraw.g:285:4: otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalModelDraw.g:289:4: ( (lv_feature_3_0= ruleValuedFeature ) )
                    // InternalModelDraw.g:290:5: (lv_feature_3_0= ruleValuedFeature )
                    {
                    // InternalModelDraw.g:290:5: (lv_feature_3_0= ruleValuedFeature )
                    // InternalModelDraw.g:291:6: lv_feature_3_0= ruleValuedFeature
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalModelDraw.g:308:4: (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalModelDraw.g:309:5: otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_10); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalModelDraw.g:313:5: ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    // InternalModelDraw.g:314:6: (lv_feature_5_0= ruleValuedFeature )
                    	    {
                    	    // InternalModelDraw.g:314:6: (lv_feature_5_0= ruleValuedFeature )
                    	    // InternalModelDraw.g:315:7: lv_feature_5_0= ruleValuedFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:338:3: (otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalModelDraw.g:339:4: otherlv_7= '->' ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )?
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalModelDraw.g:343:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:344:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:344:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:345:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_8, grammarAccess.getNodeAccess().getTargetNodeEClassCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalModelDraw.g:356:4: (otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==15) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalModelDraw.g:357:5: otherlv_9= '(' ( (lv_targetFeature_10_0= ruleValuedFeature ) ) (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )* otherlv_13= ')'
                            {
                            otherlv_9=(Token)match(input,15,FOLLOW_10); 

                            					newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_3_2_0());
                            				
                            // InternalModelDraw.g:361:5: ( (lv_targetFeature_10_0= ruleValuedFeature ) )
                            // InternalModelDraw.g:362:6: (lv_targetFeature_10_0= ruleValuedFeature )
                            {
                            // InternalModelDraw.g:362:6: (lv_targetFeature_10_0= ruleValuedFeature )
                            // InternalModelDraw.g:363:7: lv_targetFeature_10_0= ruleValuedFeature
                            {

                            							newCompositeNode(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_1_0());
                            						
                            pushFollow(FOLLOW_11);
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

                            // InternalModelDraw.g:380:5: (otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) ) )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0==16) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // InternalModelDraw.g:381:6: otherlv_11= ',' ( (lv_targetFeature_12_0= ruleValuedFeature ) )
                            	    {
                            	    otherlv_11=(Token)match(input,16,FOLLOW_10); 

                            	    						newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getCommaKeyword_3_2_2_0());
                            	    					
                            	    // InternalModelDraw.g:385:6: ( (lv_targetFeature_12_0= ruleValuedFeature ) )
                            	    // InternalModelDraw.g:386:7: (lv_targetFeature_12_0= ruleValuedFeature )
                            	    {
                            	    // InternalModelDraw.g:386:7: (lv_targetFeature_12_0= ruleValuedFeature )
                            	    // InternalModelDraw.g:387:8: lv_targetFeature_12_0= ruleValuedFeature
                            	    {

                            	    								newCompositeNode(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_2_1_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
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
                            	    break loop7;
                                }
                            } while (true);

                            otherlv_13=(Token)match(input,17,FOLLOW_5); 

                            					newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getRightParenthesisKeyword_3_2_3());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getColonKeyword_4());
            		
            // InternalModelDraw.g:415:3: ( (lv_type_15_0= ruleNodeType ) )
            // InternalModelDraw.g:416:4: (lv_type_15_0= ruleNodeType )
            {
            // InternalModelDraw.g:416:4: (lv_type_15_0= ruleNodeType )
            // InternalModelDraw.g:417:5: lv_type_15_0= ruleNodeType
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_15);
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

            // InternalModelDraw.g:434:3: (otherlv_16= '=' ( (otherlv_17= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelDraw.g:435:4: otherlv_16= '=' ( (otherlv_17= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_16, grammarAccess.getNodeAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:439:4: ( (otherlv_17= RULE_ID ) )
                    // InternalModelDraw.g:440:5: (otherlv_17= RULE_ID )
                    {
                    // InternalModelDraw.g:440:5: (otherlv_17= RULE_ID )
                    // InternalModelDraw.g:441:6: otherlv_17= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:453:3: (otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelDraw.g:454:4: otherlv_18= 'compartments' otherlv_19= '=' otherlv_20= '{' ( (otherlv_21= RULE_ID ) ) ( (otherlv_22= RULE_ID ) )* otherlv_23= '}'
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_17); 

                    				newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getCompartmentsKeyword_7_0());
                    			
                    otherlv_19=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1());
                    			
                    otherlv_20=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_20, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_7_2());
                    			
                    // InternalModelDraw.g:466:4: ( (otherlv_21= RULE_ID ) )
                    // InternalModelDraw.g:467:5: (otherlv_21= RULE_ID )
                    {
                    // InternalModelDraw.g:467:5: (otherlv_21= RULE_ID )
                    // InternalModelDraw.g:468:6: otherlv_21= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(otherlv_21, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_3_0());
                    					

                    }


                    }

                    // InternalModelDraw.g:479:4: ( (otherlv_22= RULE_ID ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalModelDraw.g:480:5: (otherlv_22= RULE_ID )
                    	    {
                    	    // InternalModelDraw.g:480:5: (otherlv_22= RULE_ID )
                    	    // InternalModelDraw.g:481:6: otherlv_22= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_8); 

                    	    						newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_4_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,14,FOLLOW_18); 

                    				newLeafNode(otherlv_23, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_7_5());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:497:3: (otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:498:4: otherlv_24= 'shape' otherlv_25= '=' ( (lv_shape_26_0= ruleNodeShape ) ) (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )?
                    {
                    otherlv_24=(Token)match(input,21,FOLLOW_17); 

                    				newLeafNode(otherlv_24, grammarAccess.getNodeAccess().getShapeKeyword_8_0());
                    			
                    otherlv_25=(Token)match(input,19,FOLLOW_19); 

                    				newLeafNode(otherlv_25, grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:506:4: ( (lv_shape_26_0= ruleNodeShape ) )
                    // InternalModelDraw.g:507:5: (lv_shape_26_0= ruleNodeShape )
                    {
                    // InternalModelDraw.g:507:5: (lv_shape_26_0= ruleNodeShape )
                    // InternalModelDraw.g:508:6: lv_shape_26_0= ruleNodeShape
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_20);
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

                    // InternalModelDraw.g:525:4: (otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==15) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalModelDraw.g:526:5: otherlv_27= '(' ( (lv_pathShape_28_0= ruleEString ) ) otherlv_29= ')'
                            {
                            otherlv_27=(Token)match(input,15,FOLLOW_3); 

                            					newLeafNode(otherlv_27, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_8_3_0());
                            				
                            // InternalModelDraw.g:530:5: ( (lv_pathShape_28_0= ruleEString ) )
                            // InternalModelDraw.g:531:6: (lv_pathShape_28_0= ruleEString )
                            {
                            // InternalModelDraw.g:531:6: (lv_pathShape_28_0= ruleEString )
                            // InternalModelDraw.g:532:7: lv_pathShape_28_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getNodeAccess().getPathShapeEStringParserRuleCall_8_3_1_0());
                            						
                            pushFollow(FOLLOW_21);
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

                            otherlv_29=(Token)match(input,17,FOLLOW_22); 

                            					newLeafNode(otherlv_29, grammarAccess.getNodeAccess().getRightParenthesisKeyword_8_3_2());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalModelDraw.g:555:3: (otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:556:4: otherlv_30= 'color' otherlv_31= '=' ( (lv_color_32_0= ruleNodeColor ) )
                    {
                    otherlv_30=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getColorKeyword_9_0());
                    			
                    otherlv_31=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_31, grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:564:4: ( (lv_color_32_0= ruleNodeColor ) )
                    // InternalModelDraw.g:565:5: (lv_color_32_0= ruleNodeColor )
                    {
                    // InternalModelDraw.g:565:5: (lv_color_32_0= ruleNodeColor )
                    // InternalModelDraw.g:566:6: lv_color_32_0= ruleNodeColor
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_24);
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

            // InternalModelDraw.g:584:3: (otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalModelDraw.g:585:4: otherlv_33= 'style' otherlv_34= '=' ( (lv_style_35_0= ruleNodeStyle ) )
                    {
                    otherlv_33=(Token)match(input,23,FOLLOW_17); 

                    				newLeafNode(otherlv_33, grammarAccess.getNodeAccess().getStyleKeyword_10_0());
                    			
                    otherlv_34=(Token)match(input,19,FOLLOW_25); 

                    				newLeafNode(otherlv_34, grammarAccess.getNodeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:593:4: ( (lv_style_35_0= ruleNodeStyle ) )
                    // InternalModelDraw.g:594:5: (lv_style_35_0= ruleNodeStyle )
                    {
                    // InternalModelDraw.g:594:5: (lv_style_35_0= ruleNodeStyle )
                    // InternalModelDraw.g:595:6: lv_style_35_0= ruleNodeStyle
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
    // InternalModelDraw.g:617:1: entryRuleValuedFeature returns [EObject current=null] : iv_ruleValuedFeature= ruleValuedFeature EOF ;
    public final EObject entryRuleValuedFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedFeature = null;


        try {
            // InternalModelDraw.g:617:54: (iv_ruleValuedFeature= ruleValuedFeature EOF )
            // InternalModelDraw.g:618:2: iv_ruleValuedFeature= ruleValuedFeature EOF
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
    // InternalModelDraw.g:624:1: ruleValuedFeature returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) ;
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
            // InternalModelDraw.g:630:2: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? ) )
            // InternalModelDraw.g:631:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            {
            // InternalModelDraw.g:631:2: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )? )
            // InternalModelDraw.g:632:3: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            {
            // InternalModelDraw.g:632:3: ()
            // InternalModelDraw.g:633:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:639:3: ( (lv_negation_1_0= 'not' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:640:4: (lv_negation_1_0= 'not' )
                    {
                    // InternalModelDraw.g:640:4: (lv_negation_1_0= 'not' )
                    // InternalModelDraw.g:641:5: lv_negation_1_0= 'not'
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

            // InternalModelDraw.g:653:3: ( (otherlv_2= RULE_ID ) )
            // InternalModelDraw.g:654:4: (otherlv_2= RULE_ID )
            {
            // InternalModelDraw.g:654:4: (otherlv_2= RULE_ID )
            // InternalModelDraw.g:655:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValuedFeatureRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(otherlv_2, grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalModelDraw.g:666:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:667:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalModelDraw.g:671:4: ( (otherlv_4= RULE_ID ) )
                    // InternalModelDraw.g:672:5: (otherlv_4= RULE_ID )
                    {
                    // InternalModelDraw.g:672:5: (otherlv_4= RULE_ID )
                    // InternalModelDraw.g:673:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValuedFeatureRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_27); 

                    						newLeafNode(otherlv_4, grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalModelDraw.g:685:3: (otherlv_5= '==' ( (lv_value_6_0= 'null' ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:686:4: otherlv_5= '==' ( (lv_value_6_0= 'null' ) )
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0());
                    			
                    // InternalModelDraw.g:690:4: ( (lv_value_6_0= 'null' ) )
                    // InternalModelDraw.g:691:5: (lv_value_6_0= 'null' )
                    {
                    // InternalModelDraw.g:691:5: (lv_value_6_0= 'null' )
                    // InternalModelDraw.g:692:6: lv_value_6_0= 'null'
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
    // InternalModelDraw.g:709:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalModelDraw.g:709:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalModelDraw.g:710:2: iv_ruleRelation= ruleRelation EOF
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
    // InternalModelDraw.g:716:1: ruleRelation returns [EObject current=null] : (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_Edge_0 = null;

        EObject this_Level_1 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:722:2: ( (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) )
            // InternalModelDraw.g:723:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            {
            // InternalModelDraw.g:723:2: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==15||LA20_1==18) ) {
                    alt20=1;
                }
                else if ( (LA20_1==29) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:724:3: this_Edge_0= ruleEdge
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
                    // InternalModelDraw.g:733:3: this_Level_1= ruleLevel
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
    // InternalModelDraw.g:745:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // InternalModelDraw.g:745:45: (iv_ruleEdge= ruleEdge EOF )
            // InternalModelDraw.g:746:2: iv_ruleEdge= ruleEdge EOF
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
    // InternalModelDraw.g:752:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? ) ;
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
            // InternalModelDraw.g:758:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:759:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:759:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )? )
            // InternalModelDraw.g:760:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )? ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) ) otherlv_19= ':' otherlv_20= 'edge' (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )? (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )? (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )? (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )? (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )? (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:760:3: ()
            // InternalModelDraw.g:761:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEdgeAccess().getEdgeAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:767:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:768:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:768:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:769:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:780:3: (otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==24) ) {
                    alt22=1;
                }
                else if ( (LA22_1==RULE_ID) ) {
                    int LA22_4 = input.LA(3);

                    if ( (LA22_4==16) ) {
                        int LA22_5 = input.LA(4);

                        if ( (LA22_5==24) ) {
                            alt22=1;
                        }
                        else if ( (LA22_5==RULE_ID) ) {
                            int LA22_6 = input.LA(5);

                            if ( (LA22_6==16||LA22_6==18||LA22_6==25) ) {
                                alt22=1;
                            }
                            else if ( (LA22_6==17) ) {
                                int LA22_7 = input.LA(6);

                                if ( (LA22_7==15||LA22_7==18) ) {
                                    alt22=1;
                                }
                            }
                        }
                    }
                    else if ( ((LA22_4>=17 && LA22_4<=18)||LA22_4==25) ) {
                        alt22=1;
                    }
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalModelDraw.g:781:4: otherlv_2= '(' ( (lv_feature_3_0= ruleValuedFeature ) ) (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalModelDraw.g:785:4: ( (lv_feature_3_0= ruleValuedFeature ) )
                    // InternalModelDraw.g:786:5: (lv_feature_3_0= ruleValuedFeature )
                    {
                    // InternalModelDraw.g:786:5: (lv_feature_3_0= ruleValuedFeature )
                    // InternalModelDraw.g:787:6: lv_feature_3_0= ruleValuedFeature
                    {

                    						newCompositeNode(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalModelDraw.g:804:4: (otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==16) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalModelDraw.g:805:5: otherlv_4= ',' ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_10); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalModelDraw.g:809:5: ( (lv_feature_5_0= ruleValuedFeature ) )
                    	    // InternalModelDraw.g:810:6: (lv_feature_5_0= ruleValuedFeature )
                    	    {
                    	    // InternalModelDraw.g:810:6: (lv_feature_5_0= ruleValuedFeature )
                    	    // InternalModelDraw.g:811:7: lv_feature_5_0= ruleValuedFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalModelDraw.g:834:3: ( (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==15) ) {
                alt25=1;
            }
            else if ( (LA25_0==18) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:835:4: (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    {
                    // InternalModelDraw.g:835:4: (otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    // InternalModelDraw.g:836:5: otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_4); 

                    					newLeafNode(otherlv_7, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_0_0());
                    				
                    // InternalModelDraw.g:840:5: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:841:6: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:841:6: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:842:7: otherlv_8= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEdgeRule());
                    							}
                    						
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_30); 

                    							newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0_1_0());
                    						

                    }


                    }

                    otherlv_9=(Token)match(input,16,FOLLOW_4); 

                    					newLeafNode(otherlv_9, grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2());
                    				
                    // InternalModelDraw.g:857:5: ( (otherlv_10= RULE_ID ) )
                    // InternalModelDraw.g:858:6: (otherlv_10= RULE_ID )
                    {
                    // InternalModelDraw.g:858:6: (otherlv_10= RULE_ID )
                    // InternalModelDraw.g:859:7: otherlv_10= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEdgeRule());
                    							}
                    						
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_21); 

                    							newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_3_0());
                    						

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_5); 

                    					newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:876:4: (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? )
                    {
                    // InternalModelDraw.g:876:4: (otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )? )
                    // InternalModelDraw.g:877:5: otherlv_12= '->' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )?
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_4); 

                    					newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    				
                    // InternalModelDraw.g:881:5: ( (otherlv_13= RULE_ID ) )
                    // InternalModelDraw.g:882:6: (otherlv_13= RULE_ID )
                    {
                    // InternalModelDraw.g:882:6: (otherlv_13= RULE_ID )
                    // InternalModelDraw.g:883:7: otherlv_13= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEdgeRule());
                    							}
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_13, grammarAccess.getEdgeAccess().getTargetNodeEClassCrossReference_3_1_1_0());
                    						

                    }


                    }

                    // InternalModelDraw.g:894:5: (otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==15) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalModelDraw.g:895:6: otherlv_14= '(' ( (lv_targetFeature_15_0= ruleValuedFeature ) ) (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )* otherlv_18= ')'
                            {
                            otherlv_14=(Token)match(input,15,FOLLOW_10); 

                            						newLeafNode(otherlv_14, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_1_2_0());
                            					
                            // InternalModelDraw.g:899:6: ( (lv_targetFeature_15_0= ruleValuedFeature ) )
                            // InternalModelDraw.g:900:7: (lv_targetFeature_15_0= ruleValuedFeature )
                            {
                            // InternalModelDraw.g:900:7: (lv_targetFeature_15_0= ruleValuedFeature )
                            // InternalModelDraw.g:901:8: lv_targetFeature_15_0= ruleValuedFeature
                            {

                            								newCompositeNode(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_1_0());
                            							
                            pushFollow(FOLLOW_11);
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

                            // InternalModelDraw.g:918:6: (otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) ) )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==16) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // InternalModelDraw.g:919:7: otherlv_16= ',' ( (lv_targetFeature_17_0= ruleValuedFeature ) )
                            	    {
                            	    otherlv_16=(Token)match(input,16,FOLLOW_10); 

                            	    							newLeafNode(otherlv_16, grammarAccess.getEdgeAccess().getCommaKeyword_3_1_2_2_0());
                            	    						
                            	    // InternalModelDraw.g:923:7: ( (lv_targetFeature_17_0= ruleValuedFeature ) )
                            	    // InternalModelDraw.g:924:8: (lv_targetFeature_17_0= ruleValuedFeature )
                            	    {
                            	    // InternalModelDraw.g:924:8: (lv_targetFeature_17_0= ruleValuedFeature )
                            	    // InternalModelDraw.g:925:9: lv_targetFeature_17_0= ruleValuedFeature
                            	    {

                            	    									newCompositeNode(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_11);
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
                            	    break loop23;
                                }
                            } while (true);

                            otherlv_18=(Token)match(input,17,FOLLOW_5); 

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
            		
            // InternalModelDraw.g:958:3: (otherlv_21= '=' ( (otherlv_22= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:959:4: otherlv_21= '=' ( (otherlv_22= RULE_ID ) )
                    {
                    otherlv_21=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_21, grammarAccess.getEdgeAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:963:4: ( (otherlv_22= RULE_ID ) )
                    // InternalModelDraw.g:964:5: (otherlv_22= RULE_ID )
                    {
                    // InternalModelDraw.g:964:5: (otherlv_22= RULE_ID )
                    // InternalModelDraw.g:965:6: otherlv_22= RULE_ID
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

            // InternalModelDraw.g:977:3: (otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==28) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalModelDraw.g:978:4: otherlv_23= 'label' otherlv_24= '=' ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) )
                    {
                    otherlv_23=(Token)match(input,28,FOLLOW_17); 

                    				newLeafNode(otherlv_23, grammarAccess.getEdgeAccess().getLabelKeyword_7_0());
                    			
                    otherlv_24=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_24, grammarAccess.getEdgeAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:986:4: ( ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) ) | (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' ) )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==RULE_ID) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==13) ) {
                        alt40=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalModelDraw.g:987:5: ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) )
                            {
                            // InternalModelDraw.g:987:5: ( ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) ) )
                            // InternalModelDraw.g:988:6: ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )? ( (otherlv_29= RULE_ID ) )
                            {
                            // InternalModelDraw.g:988:6: ( ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==RULE_ID) ) {
                                int LA28_1 = input.LA(2);

                                if ( (LA28_1==18||LA28_1==29) ) {
                                    alt28=1;
                                }
                            }
                            switch (alt28) {
                                case 1 :
                                    // InternalModelDraw.g:989:7: ( (otherlv_25= RULE_ID ) ) (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )? otherlv_28= '.'
                                    {
                                    // InternalModelDraw.g:989:7: ( (otherlv_25= RULE_ID ) )
                                    // InternalModelDraw.g:990:8: (otherlv_25= RULE_ID )
                                    {
                                    // InternalModelDraw.g:990:8: (otherlv_25= RULE_ID )
                                    // InternalModelDraw.g:991:9: otherlv_25= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_25, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1002:7: (otherlv_26= '->' ( (otherlv_27= RULE_ID ) ) )?
                                    int alt27=2;
                                    int LA27_0 = input.LA(1);

                                    if ( (LA27_0==18) ) {
                                        alt27=1;
                                    }
                                    switch (alt27) {
                                        case 1 :
                                            // InternalModelDraw.g:1003:8: otherlv_26= '->' ( (otherlv_27= RULE_ID ) )
                                            {
                                            otherlv_26=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_26, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0());
                                            							
                                            // InternalModelDraw.g:1007:8: ( (otherlv_27= RULE_ID ) )
                                            // InternalModelDraw.g:1008:9: (otherlv_27= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1008:9: (otherlv_27= RULE_ID )
                                            // InternalModelDraw.g:1009:10: otherlv_27= RULE_ID
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

                            // InternalModelDraw.g:1026:6: ( (otherlv_29= RULE_ID ) )
                            // InternalModelDraw.g:1027:7: (otherlv_29= RULE_ID )
                            {
                            // InternalModelDraw.g:1027:7: (otherlv_29= RULE_ID )
                            // InternalModelDraw.g:1028:8: otherlv_29= RULE_ID
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
                            // InternalModelDraw.g:1041:5: (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' )
                            {
                            // InternalModelDraw.g:1041:5: (otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}' )
                            // InternalModelDraw.g:1042:6: otherlv_30= '{' ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )? ( (otherlv_35= RULE_ID ) ) (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )? (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )* otherlv_56= '}'
                            {
                            otherlv_30=(Token)match(input,13,FOLLOW_4); 

                            						newLeafNode(otherlv_30, grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_7_2_1_0());
                            					
                            // InternalModelDraw.g:1046:6: ( ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.' )?
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
                                    // InternalModelDraw.g:1047:7: ( (otherlv_31= RULE_ID ) ) (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )? otherlv_34= '.'
                                    {
                                    // InternalModelDraw.g:1047:7: ( (otherlv_31= RULE_ID ) )
                                    // InternalModelDraw.g:1048:8: (otherlv_31= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1048:8: (otherlv_31= RULE_ID )
                                    // InternalModelDraw.g:1049:9: otherlv_31= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_31, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1060:7: (otherlv_32= '->' ( (otherlv_33= RULE_ID ) ) )?
                                    int alt29=2;
                                    int LA29_0 = input.LA(1);

                                    if ( (LA29_0==18) ) {
                                        alt29=1;
                                    }
                                    switch (alt29) {
                                        case 1 :
                                            // InternalModelDraw.g:1061:8: otherlv_32= '->' ( (otherlv_33= RULE_ID ) )
                                            {
                                            otherlv_32=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_32, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0());
                                            							
                                            // InternalModelDraw.g:1065:8: ( (otherlv_33= RULE_ID ) )
                                            // InternalModelDraw.g:1066:9: (otherlv_33= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1066:9: (otherlv_33= RULE_ID )
                                            // InternalModelDraw.g:1067:10: otherlv_33= RULE_ID
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

                            // InternalModelDraw.g:1084:6: ( (otherlv_35= RULE_ID ) )
                            // InternalModelDraw.g:1085:7: (otherlv_35= RULE_ID )
                            {
                            // InternalModelDraw.g:1085:7: (otherlv_35= RULE_ID )
                            // InternalModelDraw.g:1086:8: otherlv_35= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getEdgeRule());
                            								}
                            							
                            otherlv_35=(Token)match(input,RULE_ID,FOLLOW_38); 

                            								newLeafNode(otherlv_35, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_2_0());
                            							

                            }


                            }

                            // InternalModelDraw.g:1097:6: (otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')' )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==15) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // InternalModelDraw.g:1098:7: otherlv_36= '(' ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )? ( (otherlv_41= RULE_ID ) ) otherlv_42= ')'
                                    {
                                    otherlv_36=(Token)match(input,15,FOLLOW_4); 

                                    							newLeafNode(otherlv_36, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_3_0());
                                    						
                                    // InternalModelDraw.g:1102:7: ( ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.' )?
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
                                            // InternalModelDraw.g:1103:8: ( (otherlv_37= RULE_ID ) ) (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )? otherlv_40= '.'
                                            {
                                            // InternalModelDraw.g:1103:8: ( (otherlv_37= RULE_ID ) )
                                            // InternalModelDraw.g:1104:9: (otherlv_37= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1104:9: (otherlv_37= RULE_ID )
                                            // InternalModelDraw.g:1105:10: otherlv_37= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getEdgeRule());
                                            										}
                                            									
                                            otherlv_37=(Token)match(input,RULE_ID,FOLLOW_35); 

                                            										newLeafNode(otherlv_37, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0());
                                            									

                                            }


                                            }

                                            // InternalModelDraw.g:1116:8: (otherlv_38= '->' ( (otherlv_39= RULE_ID ) ) )?
                                            int alt31=2;
                                            int LA31_0 = input.LA(1);

                                            if ( (LA31_0==18) ) {
                                                alt31=1;
                                            }
                                            switch (alt31) {
                                                case 1 :
                                                    // InternalModelDraw.g:1117:9: otherlv_38= '->' ( (otherlv_39= RULE_ID ) )
                                                    {
                                                    otherlv_38=(Token)match(input,18,FOLLOW_4); 

                                                    									newLeafNode(otherlv_38, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0());
                                                    								
                                                    // InternalModelDraw.g:1121:9: ( (otherlv_39= RULE_ID ) )
                                                    // InternalModelDraw.g:1122:10: (otherlv_39= RULE_ID )
                                                    {
                                                    // InternalModelDraw.g:1122:10: (otherlv_39= RULE_ID )
                                                    // InternalModelDraw.g:1123:11: otherlv_39= RULE_ID
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

                                    // InternalModelDraw.g:1140:7: ( (otherlv_41= RULE_ID ) )
                                    // InternalModelDraw.g:1141:8: (otherlv_41= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1141:8: (otherlv_41= RULE_ID )
                                    // InternalModelDraw.g:1142:9: otherlv_41= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getEdgeRule());
                                    									}
                                    								
                                    otherlv_41=(Token)match(input,RULE_ID,FOLLOW_21); 

                                    									newLeafNode(otherlv_41, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0());
                                    								

                                    }


                                    }

                                    otherlv_42=(Token)match(input,17,FOLLOW_39); 

                                    							newLeafNode(otherlv_42, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_3_3());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1158:6: (otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )? )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==16) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // InternalModelDraw.g:1159:7: otherlv_43= ',' ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )? ( (otherlv_48= RULE_ID ) ) (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )?
                            	    {
                            	    otherlv_43=(Token)match(input,16,FOLLOW_4); 

                            	    							newLeafNode(otherlv_43, grammarAccess.getEdgeAccess().getCommaKeyword_7_2_1_4_0());
                            	    						
                            	    // InternalModelDraw.g:1163:7: ( ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.' )?
                            	    int alt35=2;
                            	    int LA35_0 = input.LA(1);

                            	    if ( (LA35_0==RULE_ID) ) {
                            	        int LA35_1 = input.LA(2);

                            	        if ( (LA35_1==18||LA35_1==29) ) {
                            	            alt35=1;
                            	        }
                            	    }
                            	    switch (alt35) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1164:8: ( (otherlv_44= RULE_ID ) ) (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )? otherlv_47= '.'
                            	            {
                            	            // InternalModelDraw.g:1164:8: ( (otherlv_44= RULE_ID ) )
                            	            // InternalModelDraw.g:1165:9: (otherlv_44= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1165:9: (otherlv_44= RULE_ID )
                            	            // InternalModelDraw.g:1166:10: otherlv_44= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getEdgeRule());
                            	            										}
                            	            									
                            	            otherlv_44=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	            										newLeafNode(otherlv_44, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0());
                            	            									

                            	            }


                            	            }

                            	            // InternalModelDraw.g:1177:8: (otherlv_45= '->' ( (otherlv_46= RULE_ID ) ) )?
                            	            int alt34=2;
                            	            int LA34_0 = input.LA(1);

                            	            if ( (LA34_0==18) ) {
                            	                alt34=1;
                            	            }
                            	            switch (alt34) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1178:9: otherlv_45= '->' ( (otherlv_46= RULE_ID ) )
                            	                    {
                            	                    otherlv_45=(Token)match(input,18,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_45, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0());
                            	                    								
                            	                    // InternalModelDraw.g:1182:9: ( (otherlv_46= RULE_ID ) )
                            	                    // InternalModelDraw.g:1183:10: (otherlv_46= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1183:10: (otherlv_46= RULE_ID )
                            	                    // InternalModelDraw.g:1184:11: otherlv_46= RULE_ID
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

                            	    // InternalModelDraw.g:1201:7: ( (otherlv_48= RULE_ID ) )
                            	    // InternalModelDraw.g:1202:8: (otherlv_48= RULE_ID )
                            	    {
                            	    // InternalModelDraw.g:1202:8: (otherlv_48= RULE_ID )
                            	    // InternalModelDraw.g:1203:9: otherlv_48= RULE_ID
                            	    {

                            	    									if (current==null) {
                            	    										current = createModelElement(grammarAccess.getEdgeRule());
                            	    									}
                            	    								
                            	    otherlv_48=(Token)match(input,RULE_ID,FOLLOW_38); 

                            	    									newLeafNode(otherlv_48, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0());
                            	    								

                            	    }


                            	    }

                            	    // InternalModelDraw.g:1214:7: (otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')' )?
                            	    int alt38=2;
                            	    int LA38_0 = input.LA(1);

                            	    if ( (LA38_0==15) ) {
                            	        alt38=1;
                            	    }
                            	    switch (alt38) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1215:8: otherlv_49= '(' ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )? ( (otherlv_54= RULE_ID ) ) otherlv_55= ')'
                            	            {
                            	            otherlv_49=(Token)match(input,15,FOLLOW_4); 

                            	            								newLeafNode(otherlv_49, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_4_3_0());
                            	            							
                            	            // InternalModelDraw.g:1219:8: ( ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.' )?
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
                            	                    // InternalModelDraw.g:1220:9: ( (otherlv_50= RULE_ID ) ) (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )? otherlv_53= '.'
                            	                    {
                            	                    // InternalModelDraw.g:1220:9: ( (otherlv_50= RULE_ID ) )
                            	                    // InternalModelDraw.g:1221:10: (otherlv_50= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1221:10: (otherlv_50= RULE_ID )
                            	                    // InternalModelDraw.g:1222:11: otherlv_50= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getEdgeRule());
                            	                    											}
                            	                    										
                            	                    otherlv_50=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	                    											newLeafNode(otherlv_50, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0());
                            	                    										

                            	                    }


                            	                    }

                            	                    // InternalModelDraw.g:1233:9: (otherlv_51= '->' ( (otherlv_52= RULE_ID ) ) )?
                            	                    int alt36=2;
                            	                    int LA36_0 = input.LA(1);

                            	                    if ( (LA36_0==18) ) {
                            	                        alt36=1;
                            	                    }
                            	                    switch (alt36) {
                            	                        case 1 :
                            	                            // InternalModelDraw.g:1234:10: otherlv_51= '->' ( (otherlv_52= RULE_ID ) )
                            	                            {
                            	                            otherlv_51=(Token)match(input,18,FOLLOW_4); 

                            	                            										newLeafNode(otherlv_51, grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0());
                            	                            									
                            	                            // InternalModelDraw.g:1238:10: ( (otherlv_52= RULE_ID ) )
                            	                            // InternalModelDraw.g:1239:11: (otherlv_52= RULE_ID )
                            	                            {
                            	                            // InternalModelDraw.g:1239:11: (otherlv_52= RULE_ID )
                            	                            // InternalModelDraw.g:1240:12: otherlv_52= RULE_ID
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

                            	            // InternalModelDraw.g:1257:8: ( (otherlv_54= RULE_ID ) )
                            	            // InternalModelDraw.g:1258:9: (otherlv_54= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1258:9: (otherlv_54= RULE_ID )
                            	            // InternalModelDraw.g:1259:10: otherlv_54= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getEdgeRule());
                            	            										}
                            	            									
                            	            otherlv_54=(Token)match(input,RULE_ID,FOLLOW_21); 

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
                            	    break loop39;
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

            // InternalModelDraw.g:1283:3: (otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==30) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalModelDraw.g:1284:4: otherlv_57= 'src_decoration' otherlv_58= '=' ( (lv_src_decoration_59_0= ruleDecoration ) )
                    {
                    otherlv_57=(Token)match(input,30,FOLLOW_17); 

                    				newLeafNode(otherlv_57, grammarAccess.getEdgeAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_58=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_58, grammarAccess.getEdgeAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:1292:4: ( (lv_src_decoration_59_0= ruleDecoration ) )
                    // InternalModelDraw.g:1293:5: (lv_src_decoration_59_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1293:5: (lv_src_decoration_59_0= ruleDecoration )
                    // InternalModelDraw.g:1294:6: lv_src_decoration_59_0= ruleDecoration
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

            // InternalModelDraw.g:1312:3: (otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==31) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalModelDraw.g:1313:4: otherlv_60= 'src_label' otherlv_61= '=' ( (otherlv_62= RULE_ID ) )
                    {
                    otherlv_60=(Token)match(input,31,FOLLOW_17); 

                    				newLeafNode(otherlv_60, grammarAccess.getEdgeAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_61=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_61, grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1321:4: ( (otherlv_62= RULE_ID ) )
                    // InternalModelDraw.g:1322:5: (otherlv_62= RULE_ID )
                    {
                    // InternalModelDraw.g:1322:5: (otherlv_62= RULE_ID )
                    // InternalModelDraw.g:1323:6: otherlv_62= RULE_ID
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

            // InternalModelDraw.g:1335:3: (otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==32) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalModelDraw.g:1336:4: otherlv_63= 'tar_decoration' otherlv_64= '=' ( (lv_tar_decoration_65_0= ruleDecoration ) )
                    {
                    otherlv_63=(Token)match(input,32,FOLLOW_17); 

                    				newLeafNode(otherlv_63, grammarAccess.getEdgeAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_64=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_64, grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1344:4: ( (lv_tar_decoration_65_0= ruleDecoration ) )
                    // InternalModelDraw.g:1345:5: (lv_tar_decoration_65_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1345:5: (lv_tar_decoration_65_0= ruleDecoration )
                    // InternalModelDraw.g:1346:6: lv_tar_decoration_65_0= ruleDecoration
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

            // InternalModelDraw.g:1364:3: (otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalModelDraw.g:1365:4: otherlv_66= 'tar_label' otherlv_67= '=' ( (otherlv_68= RULE_ID ) )
                    {
                    otherlv_66=(Token)match(input,33,FOLLOW_17); 

                    				newLeafNode(otherlv_66, grammarAccess.getEdgeAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_67=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_67, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1373:4: ( (otherlv_68= RULE_ID ) )
                    // InternalModelDraw.g:1374:5: (otherlv_68= RULE_ID )
                    {
                    // InternalModelDraw.g:1374:5: (otherlv_68= RULE_ID )
                    // InternalModelDraw.g:1375:6: otherlv_68= RULE_ID
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
    // InternalModelDraw.g:1391:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // InternalModelDraw.g:1391:46: (iv_ruleLevel= ruleLevel EOF )
            // InternalModelDraw.g:1392:2: iv_ruleLevel= ruleLevel EOF
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
    // InternalModelDraw.g:1398:1: ruleLevel returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) ;
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
            // InternalModelDraw.g:1404:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:1405:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:1405:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )? )
            // InternalModelDraw.g:1406:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )? (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )? (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )? (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )? (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:1406:3: ()
            // InternalModelDraw.g:1407:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLevelAccess().getLevelAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1413:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1414:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1414:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1415:5: otherlv_1= RULE_ID
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
            		
            // InternalModelDraw.g:1430:3: ( (otherlv_3= RULE_ID ) )
            // InternalModelDraw.g:1431:4: (otherlv_3= RULE_ID )
            {
            // InternalModelDraw.g:1431:4: (otherlv_3= RULE_ID )
            // InternalModelDraw.g:1432:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_3, grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getLevelAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,27,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getLevelAccess().getEdgeKeyword_5());
            		
            // InternalModelDraw.g:1451:3: (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==19) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalModelDraw.g:1452:4: otherlv_6= '=' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0());
                    			
                    // InternalModelDraw.g:1456:4: ( (otherlv_7= RULE_ID ) )
                    // InternalModelDraw.g:1457:5: (otherlv_7= RULE_ID )
                    {
                    // InternalModelDraw.g:1457:5: (otherlv_7= RULE_ID )
                    // InternalModelDraw.g:1458:6: otherlv_7= RULE_ID
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

            // InternalModelDraw.g:1470:3: (otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==28) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalModelDraw.g:1471:4: otherlv_8= 'label' otherlv_9= '=' ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_17); 

                    				newLeafNode(otherlv_8, grammarAccess.getLevelAccess().getLabelKeyword_7_0());
                    			
                    otherlv_9=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalModelDraw.g:1479:4: ( ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) ) | (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' ) )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==RULE_ID) ) {
                        alt60=1;
                    }
                    else if ( (LA60_0==13) ) {
                        alt60=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalModelDraw.g:1480:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                            {
                            // InternalModelDraw.g:1480:5: ( ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) ) )
                            // InternalModelDraw.g:1481:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )? ( (otherlv_14= RULE_ID ) )
                            {
                            // InternalModelDraw.g:1481:6: ( ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.' )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==RULE_ID) ) {
                                int LA48_1 = input.LA(2);

                                if ( (LA48_1==18||LA48_1==29) ) {
                                    alt48=1;
                                }
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalModelDraw.g:1482:7: ( (otherlv_10= RULE_ID ) ) (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )? otherlv_13= '.'
                                    {
                                    // InternalModelDraw.g:1482:7: ( (otherlv_10= RULE_ID ) )
                                    // InternalModelDraw.g:1483:8: (otherlv_10= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1483:8: (otherlv_10= RULE_ID )
                                    // InternalModelDraw.g:1484:9: otherlv_10= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_10, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1495:7: (otherlv_11= '->' ( (otherlv_12= RULE_ID ) ) )?
                                    int alt47=2;
                                    int LA47_0 = input.LA(1);

                                    if ( (LA47_0==18) ) {
                                        alt47=1;
                                    }
                                    switch (alt47) {
                                        case 1 :
                                            // InternalModelDraw.g:1496:8: otherlv_11= '->' ( (otherlv_12= RULE_ID ) )
                                            {
                                            otherlv_11=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_11, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0());
                                            							
                                            // InternalModelDraw.g:1500:8: ( (otherlv_12= RULE_ID ) )
                                            // InternalModelDraw.g:1501:9: (otherlv_12= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1501:9: (otherlv_12= RULE_ID )
                                            // InternalModelDraw.g:1502:10: otherlv_12= RULE_ID
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

                            // InternalModelDraw.g:1519:6: ( (otherlv_14= RULE_ID ) )
                            // InternalModelDraw.g:1520:7: (otherlv_14= RULE_ID )
                            {
                            // InternalModelDraw.g:1520:7: (otherlv_14= RULE_ID )
                            // InternalModelDraw.g:1521:8: otherlv_14= RULE_ID
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
                            // InternalModelDraw.g:1534:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                            {
                            // InternalModelDraw.g:1534:5: (otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}' )
                            // InternalModelDraw.g:1535:6: otherlv_15= '{' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )? ( (otherlv_20= RULE_ID ) ) (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )? (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )* otherlv_41= '}'
                            {
                            otherlv_15=(Token)match(input,13,FOLLOW_4); 

                            						newLeafNode(otherlv_15, grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0());
                            					
                            // InternalModelDraw.g:1539:6: ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.' )?
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
                                    // InternalModelDraw.g:1540:7: ( (otherlv_16= RULE_ID ) ) (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )? otherlv_19= '.'
                                    {
                                    // InternalModelDraw.g:1540:7: ( (otherlv_16= RULE_ID ) )
                                    // InternalModelDraw.g:1541:8: (otherlv_16= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1541:8: (otherlv_16= RULE_ID )
                                    // InternalModelDraw.g:1542:9: otherlv_16= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_35); 

                                    									newLeafNode(otherlv_16, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0());
                                    								

                                    }


                                    }

                                    // InternalModelDraw.g:1553:7: (otherlv_17= '->' ( (otherlv_18= RULE_ID ) ) )?
                                    int alt49=2;
                                    int LA49_0 = input.LA(1);

                                    if ( (LA49_0==18) ) {
                                        alt49=1;
                                    }
                                    switch (alt49) {
                                        case 1 :
                                            // InternalModelDraw.g:1554:8: otherlv_17= '->' ( (otherlv_18= RULE_ID ) )
                                            {
                                            otherlv_17=(Token)match(input,18,FOLLOW_4); 

                                            								newLeafNode(otherlv_17, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0());
                                            							
                                            // InternalModelDraw.g:1558:8: ( (otherlv_18= RULE_ID ) )
                                            // InternalModelDraw.g:1559:9: (otherlv_18= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1559:9: (otherlv_18= RULE_ID )
                                            // InternalModelDraw.g:1560:10: otherlv_18= RULE_ID
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

                            // InternalModelDraw.g:1577:6: ( (otherlv_20= RULE_ID ) )
                            // InternalModelDraw.g:1578:7: (otherlv_20= RULE_ID )
                            {
                            // InternalModelDraw.g:1578:7: (otherlv_20= RULE_ID )
                            // InternalModelDraw.g:1579:8: otherlv_20= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getLevelRule());
                            								}
                            							
                            otherlv_20=(Token)match(input,RULE_ID,FOLLOW_38); 

                            								newLeafNode(otherlv_20, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0());
                            							

                            }


                            }

                            // InternalModelDraw.g:1590:6: (otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')' )?
                            int alt53=2;
                            int LA53_0 = input.LA(1);

                            if ( (LA53_0==15) ) {
                                alt53=1;
                            }
                            switch (alt53) {
                                case 1 :
                                    // InternalModelDraw.g:1591:7: otherlv_21= '(' ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )? ( (otherlv_26= RULE_ID ) ) otherlv_27= ')'
                                    {
                                    otherlv_21=(Token)match(input,15,FOLLOW_4); 

                                    							newLeafNode(otherlv_21, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0());
                                    						
                                    // InternalModelDraw.g:1595:7: ( ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.' )?
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
                                            // InternalModelDraw.g:1596:8: ( (otherlv_22= RULE_ID ) ) (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )? otherlv_25= '.'
                                            {
                                            // InternalModelDraw.g:1596:8: ( (otherlv_22= RULE_ID ) )
                                            // InternalModelDraw.g:1597:9: (otherlv_22= RULE_ID )
                                            {
                                            // InternalModelDraw.g:1597:9: (otherlv_22= RULE_ID )
                                            // InternalModelDraw.g:1598:10: otherlv_22= RULE_ID
                                            {

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getLevelRule());
                                            										}
                                            									
                                            otherlv_22=(Token)match(input,RULE_ID,FOLLOW_35); 

                                            										newLeafNode(otherlv_22, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0());
                                            									

                                            }


                                            }

                                            // InternalModelDraw.g:1609:8: (otherlv_23= '->' ( (otherlv_24= RULE_ID ) ) )?
                                            int alt51=2;
                                            int LA51_0 = input.LA(1);

                                            if ( (LA51_0==18) ) {
                                                alt51=1;
                                            }
                                            switch (alt51) {
                                                case 1 :
                                                    // InternalModelDraw.g:1610:9: otherlv_23= '->' ( (otherlv_24= RULE_ID ) )
                                                    {
                                                    otherlv_23=(Token)match(input,18,FOLLOW_4); 

                                                    									newLeafNode(otherlv_23, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0());
                                                    								
                                                    // InternalModelDraw.g:1614:9: ( (otherlv_24= RULE_ID ) )
                                                    // InternalModelDraw.g:1615:10: (otherlv_24= RULE_ID )
                                                    {
                                                    // InternalModelDraw.g:1615:10: (otherlv_24= RULE_ID )
                                                    // InternalModelDraw.g:1616:11: otherlv_24= RULE_ID
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

                                    // InternalModelDraw.g:1633:7: ( (otherlv_26= RULE_ID ) )
                                    // InternalModelDraw.g:1634:8: (otherlv_26= RULE_ID )
                                    {
                                    // InternalModelDraw.g:1634:8: (otherlv_26= RULE_ID )
                                    // InternalModelDraw.g:1635:9: otherlv_26= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLevelRule());
                                    									}
                                    								
                                    otherlv_26=(Token)match(input,RULE_ID,FOLLOW_21); 

                                    									newLeafNode(otherlv_26, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0());
                                    								

                                    }


                                    }

                                    otherlv_27=(Token)match(input,17,FOLLOW_39); 

                                    							newLeafNode(otherlv_27, grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3());
                                    						

                                    }
                                    break;

                            }

                            // InternalModelDraw.g:1651:6: (otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )? )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==16) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // InternalModelDraw.g:1652:7: otherlv_28= ',' ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )? ( (otherlv_33= RULE_ID ) ) (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                            	    {
                            	    otherlv_28=(Token)match(input,16,FOLLOW_4); 

                            	    							newLeafNode(otherlv_28, grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0());
                            	    						
                            	    // InternalModelDraw.g:1656:7: ( ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.' )?
                            	    int alt55=2;
                            	    int LA55_0 = input.LA(1);

                            	    if ( (LA55_0==RULE_ID) ) {
                            	        int LA55_1 = input.LA(2);

                            	        if ( (LA55_1==18||LA55_1==29) ) {
                            	            alt55=1;
                            	        }
                            	    }
                            	    switch (alt55) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1657:8: ( (otherlv_29= RULE_ID ) ) (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )? otherlv_32= '.'
                            	            {
                            	            // InternalModelDraw.g:1657:8: ( (otherlv_29= RULE_ID ) )
                            	            // InternalModelDraw.g:1658:9: (otherlv_29= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1658:9: (otherlv_29= RULE_ID )
                            	            // InternalModelDraw.g:1659:10: otherlv_29= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getLevelRule());
                            	            										}
                            	            									
                            	            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	            										newLeafNode(otherlv_29, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0());
                            	            									

                            	            }


                            	            }

                            	            // InternalModelDraw.g:1670:8: (otherlv_30= '->' ( (otherlv_31= RULE_ID ) ) )?
                            	            int alt54=2;
                            	            int LA54_0 = input.LA(1);

                            	            if ( (LA54_0==18) ) {
                            	                alt54=1;
                            	            }
                            	            switch (alt54) {
                            	                case 1 :
                            	                    // InternalModelDraw.g:1671:9: otherlv_30= '->' ( (otherlv_31= RULE_ID ) )
                            	                    {
                            	                    otherlv_30=(Token)match(input,18,FOLLOW_4); 

                            	                    									newLeafNode(otherlv_30, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0());
                            	                    								
                            	                    // InternalModelDraw.g:1675:9: ( (otherlv_31= RULE_ID ) )
                            	                    // InternalModelDraw.g:1676:10: (otherlv_31= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1676:10: (otherlv_31= RULE_ID )
                            	                    // InternalModelDraw.g:1677:11: otherlv_31= RULE_ID
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

                            	    // InternalModelDraw.g:1694:7: ( (otherlv_33= RULE_ID ) )
                            	    // InternalModelDraw.g:1695:8: (otherlv_33= RULE_ID )
                            	    {
                            	    // InternalModelDraw.g:1695:8: (otherlv_33= RULE_ID )
                            	    // InternalModelDraw.g:1696:9: otherlv_33= RULE_ID
                            	    {

                            	    									if (current==null) {
                            	    										current = createModelElement(grammarAccess.getLevelRule());
                            	    									}
                            	    								
                            	    otherlv_33=(Token)match(input,RULE_ID,FOLLOW_38); 

                            	    									newLeafNode(otherlv_33, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0());
                            	    								

                            	    }


                            	    }

                            	    // InternalModelDraw.g:1707:7: (otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')' )?
                            	    int alt58=2;
                            	    int LA58_0 = input.LA(1);

                            	    if ( (LA58_0==15) ) {
                            	        alt58=1;
                            	    }
                            	    switch (alt58) {
                            	        case 1 :
                            	            // InternalModelDraw.g:1708:8: otherlv_34= '(' ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )? ( (otherlv_39= RULE_ID ) ) otherlv_40= ')'
                            	            {
                            	            otherlv_34=(Token)match(input,15,FOLLOW_4); 

                            	            								newLeafNode(otherlv_34, grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0());
                            	            							
                            	            // InternalModelDraw.g:1712:8: ( ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.' )?
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
                            	                    // InternalModelDraw.g:1713:9: ( (otherlv_35= RULE_ID ) ) (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )? otherlv_38= '.'
                            	                    {
                            	                    // InternalModelDraw.g:1713:9: ( (otherlv_35= RULE_ID ) )
                            	                    // InternalModelDraw.g:1714:10: (otherlv_35= RULE_ID )
                            	                    {
                            	                    // InternalModelDraw.g:1714:10: (otherlv_35= RULE_ID )
                            	                    // InternalModelDraw.g:1715:11: otherlv_35= RULE_ID
                            	                    {

                            	                    											if (current==null) {
                            	                    												current = createModelElement(grammarAccess.getLevelRule());
                            	                    											}
                            	                    										
                            	                    otherlv_35=(Token)match(input,RULE_ID,FOLLOW_35); 

                            	                    											newLeafNode(otherlv_35, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0());
                            	                    										

                            	                    }


                            	                    }

                            	                    // InternalModelDraw.g:1726:9: (otherlv_36= '->' ( (otherlv_37= RULE_ID ) ) )?
                            	                    int alt56=2;
                            	                    int LA56_0 = input.LA(1);

                            	                    if ( (LA56_0==18) ) {
                            	                        alt56=1;
                            	                    }
                            	                    switch (alt56) {
                            	                        case 1 :
                            	                            // InternalModelDraw.g:1727:10: otherlv_36= '->' ( (otherlv_37= RULE_ID ) )
                            	                            {
                            	                            otherlv_36=(Token)match(input,18,FOLLOW_4); 

                            	                            										newLeafNode(otherlv_36, grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0());
                            	                            									
                            	                            // InternalModelDraw.g:1731:10: ( (otherlv_37= RULE_ID ) )
                            	                            // InternalModelDraw.g:1732:11: (otherlv_37= RULE_ID )
                            	                            {
                            	                            // InternalModelDraw.g:1732:11: (otherlv_37= RULE_ID )
                            	                            // InternalModelDraw.g:1733:12: otherlv_37= RULE_ID
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

                            	            // InternalModelDraw.g:1750:8: ( (otherlv_39= RULE_ID ) )
                            	            // InternalModelDraw.g:1751:9: (otherlv_39= RULE_ID )
                            	            {
                            	            // InternalModelDraw.g:1751:9: (otherlv_39= RULE_ID )
                            	            // InternalModelDraw.g:1752:10: otherlv_39= RULE_ID
                            	            {

                            	            										if (current==null) {
                            	            											current = createModelElement(grammarAccess.getLevelRule());
                            	            										}
                            	            									
                            	            otherlv_39=(Token)match(input,RULE_ID,FOLLOW_21); 

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
                            	    break loop59;
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

            // InternalModelDraw.g:1776:3: (otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==30) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalModelDraw.g:1777:4: otherlv_42= 'src_decoration' otherlv_43= '=' ( (lv_src_decoration_44_0= ruleDecoration ) )
                    {
                    otherlv_42=(Token)match(input,30,FOLLOW_17); 

                    				newLeafNode(otherlv_42, grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0());
                    			
                    otherlv_43=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_43, grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalModelDraw.g:1785:4: ( (lv_src_decoration_44_0= ruleDecoration ) )
                    // InternalModelDraw.g:1786:5: (lv_src_decoration_44_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1786:5: (lv_src_decoration_44_0= ruleDecoration )
                    // InternalModelDraw.g:1787:6: lv_src_decoration_44_0= ruleDecoration
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

            // InternalModelDraw.g:1805:3: (otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==31) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalModelDraw.g:1806:4: otherlv_45= 'src_label' otherlv_46= '=' ( (otherlv_47= RULE_ID ) )
                    {
                    otherlv_45=(Token)match(input,31,FOLLOW_17); 

                    				newLeafNode(otherlv_45, grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0());
                    			
                    otherlv_46=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_46, grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalModelDraw.g:1814:4: ( (otherlv_47= RULE_ID ) )
                    // InternalModelDraw.g:1815:5: (otherlv_47= RULE_ID )
                    {
                    // InternalModelDraw.g:1815:5: (otherlv_47= RULE_ID )
                    // InternalModelDraw.g:1816:6: otherlv_47= RULE_ID
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

            // InternalModelDraw.g:1828:3: (otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==32) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalModelDraw.g:1829:4: otherlv_48= 'tar_decoration' otherlv_49= '=' ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    {
                    otherlv_48=(Token)match(input,32,FOLLOW_17); 

                    				newLeafNode(otherlv_48, grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0());
                    			
                    otherlv_49=(Token)match(input,19,FOLLOW_40); 

                    				newLeafNode(otherlv_49, grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalModelDraw.g:1837:4: ( (lv_tar_decoration_50_0= ruleDecoration ) )
                    // InternalModelDraw.g:1838:5: (lv_tar_decoration_50_0= ruleDecoration )
                    {
                    // InternalModelDraw.g:1838:5: (lv_tar_decoration_50_0= ruleDecoration )
                    // InternalModelDraw.g:1839:6: lv_tar_decoration_50_0= ruleDecoration
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

            // InternalModelDraw.g:1857:3: (otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==33) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalModelDraw.g:1858:4: otherlv_51= 'tar_label' otherlv_52= '=' ( (otherlv_53= RULE_ID ) )
                    {
                    otherlv_51=(Token)match(input,33,FOLLOW_17); 

                    				newLeafNode(otherlv_51, grammarAccess.getLevelAccess().getTar_labelKeyword_11_0());
                    			
                    otherlv_52=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_52, grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1());
                    			
                    // InternalModelDraw.g:1866:4: ( (otherlv_53= RULE_ID ) )
                    // InternalModelDraw.g:1867:5: (otherlv_53= RULE_ID )
                    {
                    // InternalModelDraw.g:1867:5: (otherlv_53= RULE_ID )
                    // InternalModelDraw.g:1868:6: otherlv_53= RULE_ID
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
    // InternalModelDraw.g:1884:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalModelDraw.g:1884:48: (iv_ruleContent= ruleContent EOF )
            // InternalModelDraw.g:1885:2: iv_ruleContent= ruleContent EOF
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
    // InternalModelDraw.g:1891:1: ruleContent returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) ;
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
            // InternalModelDraw.g:1897:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) )
            // InternalModelDraw.g:1898:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            {
            // InternalModelDraw.g:1898:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            // InternalModelDraw.g:1899:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            {
            // InternalModelDraw.g:1899:3: ()
            // InternalModelDraw.g:1900:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContentAccess().getContentAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:1906:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:1907:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:1907:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:1908:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContentRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getContentAccess().getNameEClassCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getContentAccess().getColonKeyword_2());
            		
            // InternalModelDraw.g:1923:3: ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==35) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // InternalModelDraw.g:1924:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    {
                    // InternalModelDraw.g:1924:4: ( (lv_nodenum_3_0= ruleNodeEnumerator ) )
                    // InternalModelDraw.g:1925:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    {
                    // InternalModelDraw.g:1925:5: (lv_nodenum_3_0= ruleNodeEnumerator )
                    // InternalModelDraw.g:1926:6: lv_nodenum_3_0= ruleNodeEnumerator
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

                    // InternalModelDraw.g:1943:4: ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID) ) {
                            int LA66_1 = input.LA(2);

                            if ( (LA66_1==35) ) {
                                alt66=1;
                            }


                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalModelDraw.g:1944:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    {
                    	    // InternalModelDraw.g:1944:5: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    // InternalModelDraw.g:1945:6: lv_nodenum_4_0= ruleNodeEnumerator
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
                    	    break loop66;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:1963:3: ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==EOF||LA69_1==RULE_ID||(LA69_1>=13 && LA69_1<=14)||LA69_1==29||LA69_1==34) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalModelDraw.g:1964:4: ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )*
                    {
                    // InternalModelDraw.g:1964:4: ( (lv_info_5_0= ruleInformation ) )
                    // InternalModelDraw.g:1965:5: (lv_info_5_0= ruleInformation )
                    {
                    // InternalModelDraw.g:1965:5: (lv_info_5_0= ruleInformation )
                    // InternalModelDraw.g:1966:6: lv_info_5_0= ruleInformation
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

                    // InternalModelDraw.g:1983:4: ( (lv_info_6_0= ruleInformation ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID) ) {
                            int LA68_2 = input.LA(2);

                            if ( (LA68_2==EOF||LA68_2==RULE_ID||(LA68_2>=13 && LA68_2<=14)||LA68_2==29||LA68_2==34) ) {
                                alt68=1;
                            }


                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalModelDraw.g:1984:5: (lv_info_6_0= ruleInformation )
                    	    {
                    	    // InternalModelDraw.g:1984:5: (lv_info_6_0= ruleInformation )
                    	    // InternalModelDraw.g:1985:6: lv_info_6_0= ruleInformation
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
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalModelDraw.g:2003:3: (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==13) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalModelDraw.g:2004:4: otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalModelDraw.g:2008:4: ( (otherlv_8= RULE_ID ) )
                    // InternalModelDraw.g:2009:5: (otherlv_8= RULE_ID )
                    {
                    // InternalModelDraw.g:2009:5: (otherlv_8= RULE_ID )
                    // InternalModelDraw.g:2010:6: otherlv_8= RULE_ID
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

            // InternalModelDraw.g:2026:3: (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==34) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalModelDraw.g:2027:4: otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_17); 

                    				newLeafNode(otherlv_10, grammarAccess.getContentAccess().getTextKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getContentAccess().getEqualsSignKeyword_6_1());
                    			
                    // InternalModelDraw.g:2035:4: ( (lv_symbol_12_0= ruleEString ) )
                    // InternalModelDraw.g:2036:5: (lv_symbol_12_0= ruleEString )
                    {
                    // InternalModelDraw.g:2036:5: (lv_symbol_12_0= ruleEString )
                    // InternalModelDraw.g:2037:6: lv_symbol_12_0= ruleEString
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
    // InternalModelDraw.g:2059:1: entryRuleNodeEnumerator returns [EObject current=null] : iv_ruleNodeEnumerator= ruleNodeEnumerator EOF ;
    public final EObject entryRuleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeEnumerator = null;


        try {
            // InternalModelDraw.g:2059:55: (iv_ruleNodeEnumerator= ruleNodeEnumerator EOF )
            // InternalModelDraw.g:2060:2: iv_ruleNodeEnumerator= ruleNodeEnumerator EOF
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
    // InternalModelDraw.g:2066:1: ruleNodeEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) ;
    public final EObject ruleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_enumerator_3_0 = null;

        EObject lv_enumerator_4_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:2072:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) )
            // InternalModelDraw.g:2073:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            {
            // InternalModelDraw.g:2073:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            // InternalModelDraw.g:2074:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']'
            {
            // InternalModelDraw.g:2074:3: ()
            // InternalModelDraw.g:2075:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2081:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2082:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2082:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2083:5: otherlv_1= RULE_ID
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
            		
            // InternalModelDraw.g:2098:3: ( (lv_enumerator_3_0= ruleEnumerator ) )
            // InternalModelDraw.g:2099:4: (lv_enumerator_3_0= ruleEnumerator )
            {
            // InternalModelDraw.g:2099:4: (lv_enumerator_3_0= ruleEnumerator )
            // InternalModelDraw.g:2100:5: lv_enumerator_3_0= ruleEnumerator
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

            // InternalModelDraw.g:2117:3: ( (lv_enumerator_4_0= ruleEnumerator ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_ID) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalModelDraw.g:2118:4: (lv_enumerator_4_0= ruleEnumerator )
            	    {
            	    // InternalModelDraw.g:2118:4: (lv_enumerator_4_0= ruleEnumerator )
            	    // InternalModelDraw.g:2119:5: lv_enumerator_4_0= ruleEnumerator
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
            	    break loop72;
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
    // InternalModelDraw.g:2144:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalModelDraw.g:2144:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalModelDraw.g:2145:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalModelDraw.g:2151:1: ruleEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalModelDraw.g:2157:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) )
            // InternalModelDraw.g:2158:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            {
            // InternalModelDraw.g:2158:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            // InternalModelDraw.g:2159:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) )
            {
            // InternalModelDraw.g:2159:3: ()
            // InternalModelDraw.g:2160:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumeratorAccess().getEnumeratorAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2166:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2167:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2167:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2168:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumeratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(otherlv_1, grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2());
            		
            // InternalModelDraw.g:2183:3: ( (lv_value_3_0= ruleEString ) )
            // InternalModelDraw.g:2184:4: (lv_value_3_0= ruleEString )
            {
            // InternalModelDraw.g:2184:4: (lv_value_3_0= ruleEString )
            // InternalModelDraw.g:2185:5: lv_value_3_0= ruleEString
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
    // InternalModelDraw.g:2206:1: entryRuleInformation returns [EObject current=null] : iv_ruleInformation= ruleInformation EOF ;
    public final EObject entryRuleInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformation = null;


        try {
            // InternalModelDraw.g:2206:52: (iv_ruleInformation= ruleInformation EOF )
            // InternalModelDraw.g:2207:2: iv_ruleInformation= ruleInformation EOF
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
    // InternalModelDraw.g:2213:1: ruleInformation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2219:2: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalModelDraw.g:2220:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalModelDraw.g:2220:2: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalModelDraw.g:2221:3: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalModelDraw.g:2221:3: ()
            // InternalModelDraw.g:2222:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInformationAccess().getInformationAction_0(),
            					current);
            			

            }

            // InternalModelDraw.g:2228:3: ( (otherlv_1= RULE_ID ) )
            // InternalModelDraw.g:2229:4: (otherlv_1= RULE_ID )
            {
            // InternalModelDraw.g:2229:4: (otherlv_1= RULE_ID )
            // InternalModelDraw.g:2230:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_1, grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0());
            				

            }


            }

            // InternalModelDraw.g:2241:3: (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==29) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalModelDraw.g:2242:4: otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getInformationAccess().getFullStopKeyword_2_0());
                    			
                    // InternalModelDraw.g:2246:4: ( (otherlv_3= RULE_ID ) )
                    // InternalModelDraw.g:2247:5: (otherlv_3= RULE_ID )
                    {
                    // InternalModelDraw.g:2247:5: (otherlv_3= RULE_ID )
                    // InternalModelDraw.g:2248:6: otherlv_3= RULE_ID
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
    // InternalModelDraw.g:2264:1: ruleDrawType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleDrawType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2270:2: ( (enumLiteral_0= 'diagram' ) )
            // InternalModelDraw.g:2271:2: (enumLiteral_0= 'diagram' )
            {
            // InternalModelDraw.g:2271:2: (enumLiteral_0= 'diagram' )
            // InternalModelDraw.g:2272:3: enumLiteral_0= 'diagram'
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
    // InternalModelDraw.g:2281:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2287:2: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // InternalModelDraw.g:2288:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // InternalModelDraw.g:2288:2: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==38) ) {
                alt74=1;
            }
            else if ( (LA74_0==39) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalModelDraw.g:2289:3: (enumLiteral_0= 'node' )
                    {
                    // InternalModelDraw.g:2289:3: (enumLiteral_0= 'node' )
                    // InternalModelDraw.g:2290:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2297:3: (enumLiteral_1= 'markednode' )
                    {
                    // InternalModelDraw.g:2297:3: (enumLiteral_1= 'markednode' )
                    // InternalModelDraw.g:2298:4: enumLiteral_1= 'markednode'
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
    // InternalModelDraw.g:2308:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2314:2: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) ) )
            // InternalModelDraw.g:2315:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) )
            {
            // InternalModelDraw.g:2315:2: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) | (enumLiteral_3= 'load' ) | (enumLiteral_4= 'logic' ) )
            int alt75=5;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt75=1;
                }
                break;
            case 41:
                {
                alt75=2;
                }
                break;
            case 42:
                {
                alt75=3;
                }
                break;
            case 43:
                {
                alt75=4;
                }
                break;
            case 44:
                {
                alt75=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // InternalModelDraw.g:2316:3: (enumLiteral_0= 'circle' )
                    {
                    // InternalModelDraw.g:2316:3: (enumLiteral_0= 'circle' )
                    // InternalModelDraw.g:2317:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2324:3: (enumLiteral_1= 'doublecircle' )
                    {
                    // InternalModelDraw.g:2324:3: (enumLiteral_1= 'doublecircle' )
                    // InternalModelDraw.g:2325:4: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2332:3: (enumLiteral_2= 'record' )
                    {
                    // InternalModelDraw.g:2332:3: (enumLiteral_2= 'record' )
                    // InternalModelDraw.g:2333:4: enumLiteral_2= 'record'
                    {
                    enumLiteral_2=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:2340:3: (enumLiteral_3= 'load' )
                    {
                    // InternalModelDraw.g:2340:3: (enumLiteral_3= 'load' )
                    // InternalModelDraw.g:2341:4: enumLiteral_3= 'load'
                    {
                    enumLiteral_3=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:2348:3: (enumLiteral_4= 'logic' )
                    {
                    // InternalModelDraw.g:2348:3: (enumLiteral_4= 'logic' )
                    // InternalModelDraw.g:2349:4: enumLiteral_4= 'logic'
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
    // InternalModelDraw.g:2359:1: ruleNodeColor returns [Enumerator current=null] : (enumLiteral_0= 'gray95' ) ;
    public final Enumerator ruleNodeColor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2365:2: ( (enumLiteral_0= 'gray95' ) )
            // InternalModelDraw.g:2366:2: (enumLiteral_0= 'gray95' )
            {
            // InternalModelDraw.g:2366:2: (enumLiteral_0= 'gray95' )
            // InternalModelDraw.g:2367:3: enumLiteral_0= 'gray95'
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
    // InternalModelDraw.g:2376:1: ruleNodeStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) ;
    public final Enumerator ruleNodeStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalModelDraw.g:2382:2: ( ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) )
            // InternalModelDraw.g:2383:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            {
            // InternalModelDraw.g:2383:2: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==46) ) {
                alt76=1;
            }
            else if ( (LA76_0==47) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalModelDraw.g:2384:3: (enumLiteral_0= 'italic' )
                    {
                    // InternalModelDraw.g:2384:3: (enumLiteral_0= 'italic' )
                    // InternalModelDraw.g:2385:4: enumLiteral_0= 'italic'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2392:3: (enumLiteral_1= 'underline' )
                    {
                    // InternalModelDraw.g:2392:3: (enumLiteral_1= 'underline' )
                    // InternalModelDraw.g:2393:4: enumLiteral_1= 'underline'
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
    // InternalModelDraw.g:2403:1: ruleDecoration returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) ;
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
            // InternalModelDraw.g:2409:2: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) )
            // InternalModelDraw.g:2410:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            {
            // InternalModelDraw.g:2410:2: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            int alt77=6;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt77=1;
                }
                break;
            case 49:
                {
                alt77=2;
                }
                break;
            case 50:
                {
                alt77=3;
                }
                break;
            case 51:
                {
                alt77=4;
                }
                break;
            case 52:
                {
                alt77=5;
                }
                break;
            case 53:
                {
                alt77=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalModelDraw.g:2411:3: (enumLiteral_0= 'none' )
                    {
                    // InternalModelDraw.g:2411:3: (enumLiteral_0= 'none' )
                    // InternalModelDraw.g:2412:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:2419:3: (enumLiteral_1= 'triangle' )
                    {
                    // InternalModelDraw.g:2419:3: (enumLiteral_1= 'triangle' )
                    // InternalModelDraw.g:2420:4: enumLiteral_1= 'triangle'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:2427:3: (enumLiteral_2= 'diamond' )
                    {
                    // InternalModelDraw.g:2427:3: (enumLiteral_2= 'diamond' )
                    // InternalModelDraw.g:2428:4: enumLiteral_2= 'diamond'
                    {
                    enumLiteral_2=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:2435:3: (enumLiteral_3= 'odiamond' )
                    {
                    // InternalModelDraw.g:2435:3: (enumLiteral_3= 'odiamond' )
                    // InternalModelDraw.g:2436:4: enumLiteral_3= 'odiamond'
                    {
                    enumLiteral_3=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:2443:3: (enumLiteral_4= 'open' )
                    {
                    // InternalModelDraw.g:2443:3: (enumLiteral_4= 'open' )
                    // InternalModelDraw.g:2444:4: enumLiteral_4= 'open'
                    {
                    enumLiteral_4=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:2451:3: (enumLiteral_5= 'empty' )
                    {
                    // InternalModelDraw.g:2451:3: (enumLiteral_5= 'empty' )
                    // InternalModelDraw.g:2452:4: enumLiteral_5= 'empty'
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


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\52\uffff";
    static final String dfa_2s = "\1\4\1\14\1\uffff\3\4\1\20\1\4\1\14\1\uffff\2\4\1\32\1\14\1\20\1\4\1\33\1\4\3\20\2\4\2\20\1\14\1\4\1\32\1\4\1\32\1\4\1\14\4\20\1\4\1\20\1\4\1\32\2\20";
    static final String dfa_3s = "\1\16\1\35\1\uffff\1\30\1\4\1\47\1\31\1\4\1\17\1\uffff\1\30\1\4\1\32\1\22\1\31\1\30\1\47\1\4\2\31\1\21\1\30\1\4\2\31\1\22\1\4\1\32\1\4\1\32\1\30\1\14\1\31\1\21\1\31\1\21\1\4\1\31\1\4\1\32\1\31\1\21";
    static final String dfa_4s = "\2\uffff\1\2\6\uffff\1\1\40\uffff";
    static final String dfa_5s = "\52\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\11\uffff\1\2",
            "\1\5\2\uffff\1\3\2\uffff\1\4\12\uffff\1\2",
            "",
            "\1\6\23\uffff\1\7",
            "\1\10",
            "\1\2\10\uffff\2\2\23\uffff\1\2\3\uffff\2\11",
            "\1\12\1\15\1\13\6\uffff\1\14",
            "\1\16",
            "\1\20\2\uffff\1\17",
            "",
            "\1\22\23\uffff\1\21",
            "\1\23",
            "\1\24",
            "\1\11\2\uffff\1\2\2\uffff\1\4",
            "\1\25\1\15\1\13\6\uffff\1\14",
            "\1\27\23\uffff\1\26",
            "\1\2\12\uffff\2\11",
            "\1\30",
            "\1\25\1\31\1\32\6\uffff\1\33",
            "\1\25\1\15\7\uffff\1\14",
            "\1\25\1\15",
            "\1\30\23\uffff\1\21",
            "\1\27",
            "\1\36\1\37\1\34\6\uffff\1\35",
            "\1\25\1\15\1\32\6\uffff\1\33",
            "\1\20\2\uffff\1\2\2\uffff\1\4",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\23\uffff\1\44",
            "\1\20",
            "\1\25\1\15\7\uffff\1\33",
            "\1\25\1\15",
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
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000049000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000F80002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000F00002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00001F0000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C08002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002040002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000010000L});
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