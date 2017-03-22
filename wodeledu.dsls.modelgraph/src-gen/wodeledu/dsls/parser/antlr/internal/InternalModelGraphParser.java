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
import wodeledu.dsls.services.ModelGraphGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelGraphParser extends AbstractInternalAntlrParser {
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


        public InternalModelGraphParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelGraphParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelGraphParser.tokenNames; }
    public String getGrammarFileName() { return "../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g"; }



     	private ModelGraphGrammarAccess grammarAccess;
     	
        public InternalModelGraphParser(TokenStream input, ModelGraphGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MutatorGraph";	
       	}
       	
       	@Override
       	protected ModelGraphGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMutatorGraph"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:68:1: entryRuleMutatorGraph returns [EObject current=null] : iv_ruleMutatorGraph= ruleMutatorGraph EOF ;
    public final EObject entryRuleMutatorGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorGraph = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:69:2: (iv_ruleMutatorGraph= ruleMutatorGraph EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:70:2: iv_ruleMutatorGraph= ruleMutatorGraph EOF
            {
             newCompositeNode(grammarAccess.getMutatorGraphRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorGraph_in_entryRuleMutatorGraph75);
            iv_ruleMutatorGraph=ruleMutatorGraph();

            state._fsp--;

             current =iv_ruleMutatorGraph; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorGraph85); 

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
    // $ANTLR end "entryRuleMutatorGraph"


    // $ANTLR start "ruleMutatorGraph"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:77:1: ruleMutatorGraph returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' ) ;
    public final EObject ruleMutatorGraph() throws RecognitionException {
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:80:28: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:2: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_relations_8_0= ruleRelation ) )* ( (lv_contents_9_0= ruleContent ) )* otherlv_10= '}'
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMutatorGraphAccess().getMutatorGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleMutatorGraph131); 

                	newLeafNode(otherlv_1, grammarAccess.getMutatorGraphAccess().getMetamodelKeyword_1());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:91:1: ( (lv_metamodel_2_0= ruleEString ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:92:1: (lv_metamodel_2_0= ruleEString )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:92:1: (lv_metamodel_2_0= ruleEString )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:93:3: lv_metamodel_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getMetamodelEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMutatorGraph152);
            lv_metamodel_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:109:2: ( (otherlv_3= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:110:1: (otherlv_3= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:110:1: (otherlv_3= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:111:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMutatorGraphRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMutatorGraph172); 

            		newLeafNode(otherlv_3, grammarAccess.getMutatorGraphAccess().getNameEClassCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMutatorGraph184); 

                	newLeafNode(otherlv_4, grammarAccess.getMutatorGraphAccess().getColonKeyword_4());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:126:1: ( (lv_type_5_0= ruleGraphType ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:127:1: (lv_type_5_0= ruleGraphType )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:127:1: (lv_type_5_0= ruleGraphType )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:128:3: lv_type_5_0= ruleGraphType
            {
             
            	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getTypeGraphTypeEnumRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleGraphType_in_ruleMutatorGraph205);
            lv_type_5_0=ruleGraphType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_5_0, 
                    		"GraphType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMutatorGraph217); 

                	newLeafNode(otherlv_6, grammarAccess.getMutatorGraphAccess().getLeftCurlyBracketKeyword_6());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:148:1: ( (lv_nodes_7_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:149:1: (lv_nodes_7_0= ruleNode )
            	    {
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:149:1: (lv_nodes_7_0= ruleNode )
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:150:3: lv_nodes_7_0= ruleNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getNodesNodeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNode_in_ruleMutatorGraph238);
            	    lv_nodes_7_0=ruleNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodes",
            	            		lv_nodes_7_0, 
            	            		"Node");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:166:3: ( (lv_relations_8_0= ruleRelation ) )*
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
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:167:1: (lv_relations_8_0= ruleRelation )
            	    {
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:167:1: (lv_relations_8_0= ruleRelation )
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:168:3: lv_relations_8_0= ruleRelation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getRelationsRelationParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRelation_in_ruleMutatorGraph260);
            	    lv_relations_8_0=ruleRelation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relations",
            	            		lv_relations_8_0, 
            	            		"Relation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:184:3: ( (lv_contents_9_0= ruleContent ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:185:1: (lv_contents_9_0= ruleContent )
            	    {
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:185:1: (lv_contents_9_0= ruleContent )
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:186:3: lv_contents_9_0= ruleContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getContentsContentParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleMutatorGraph282);
            	    lv_contents_9_0=ruleContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"contents",
            	            		lv_contents_9_0, 
            	            		"Content");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorGraph295); 

                	newLeafNode(otherlv_10, grammarAccess.getMutatorGraphAccess().getRightCurlyBracketKeyword_10());
                

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
    // $ANTLR end "ruleMutatorGraph"


    // $ANTLR start "entryRuleEString"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:214:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:215:2: (iv_ruleEString= ruleEString EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:216:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString332);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString343); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:223:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:226:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:227:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:227:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:227:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString383); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:235:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString409); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:250:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:251:2: (iv_ruleNode= ruleNode EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:252:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_entryRuleNode454);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNode464); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:259:1: ruleNode returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? ) ;
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:262:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:263:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:263:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:263:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )? (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )? (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )? (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:263:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:264:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeAccess().getNodeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:269:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:270:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:270:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:271:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode518); 

            		newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:282:2: (otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:282:4: otherlv_2= '(' ( (lv_attribute_3_0= ruleBooleanAttribute ) ) (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNode531); 

                        	newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:286:1: ( (lv_attribute_3_0= ruleBooleanAttribute ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:287:1: (lv_attribute_3_0= ruleBooleanAttribute )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:287:1: (lv_attribute_3_0= ruleBooleanAttribute )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:288:3: lv_attribute_3_0= ruleBooleanAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAttribute_in_ruleNode552);
                    lv_attribute_3_0=ruleBooleanAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		add(
                           			current, 
                           			"attribute",
                            		lv_attribute_3_0, 
                            		"BooleanAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:304:2: (otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:304:4: otherlv_4= ',' ( (lv_attribute_5_0= ruleBooleanAttribute ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNode565); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:308:1: ( (lv_attribute_5_0= ruleBooleanAttribute ) )
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:309:1: (lv_attribute_5_0= ruleBooleanAttribute )
                    	    {
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:309:1: (lv_attribute_5_0= ruleBooleanAttribute )
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:310:3: lv_attribute_5_0= ruleBooleanAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBooleanAttribute_in_ruleNode586);
                    	    lv_attribute_5_0=ruleBooleanAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_5_0, 
                    	            		"BooleanAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNode600); 

                        	newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNode614); 

                	newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getColonKeyword_3());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:334:1: ( (lv_type_8_0= ruleNodeType ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:335:1: (lv_type_8_0= ruleNodeType )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:335:1: (lv_type_8_0= ruleNodeType )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:336:3: lv_type_8_0= ruleNodeType
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNodeType_in_ruleNode635);
            lv_type_8_0=ruleNodeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_8_0, 
                    		"NodeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:352:2: (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:352:4: otherlv_9= '=' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode648); 

                        	newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getEqualsSignKeyword_5_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:356:1: ( (otherlv_10= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:357:1: (otherlv_10= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:357:1: (otherlv_10= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:358:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNodeRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode668); 

                    		newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_5_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:369:4: (otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:369:6: otherlv_11= 'compartments' otherlv_12= '=' otherlv_13= '{' ( (otherlv_14= RULE_ID ) ) ( (otherlv_15= RULE_ID ) )* otherlv_16= '}'
                    {
                    otherlv_11=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNode683); 

                        	newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getCompartmentsKeyword_6_0());
                        
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode695); 

                        	newLeafNode(otherlv_12, grammarAccess.getNodeAccess().getEqualsSignKeyword_6_1());
                        
                    otherlv_13=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNode707); 

                        	newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_6_2());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:381:1: ( (otherlv_14= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:382:1: (otherlv_14= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:382:1: (otherlv_14= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:383:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNodeRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode727); 

                    		newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_3_0()); 
                    	

                    }


                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:394:2: ( (otherlv_15= RULE_ID ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:395:1: (otherlv_15= RULE_ID )
                    	    {
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:395:1: (otherlv_15= RULE_ID )
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:396:3: otherlv_15= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNodeRule());
                    	    	        }
                    	            
                    	    otherlv_15=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode747); 

                    	    		newLeafNode(otherlv_15, grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_4_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNode760); 

                        	newLeafNode(otherlv_16, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_6_5());
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:411:3: (otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:411:5: otherlv_17= 'shape' otherlv_18= '=' ( (lv_shape_19_0= ruleNodeShape ) )
                    {
                    otherlv_17=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNode775); 

                        	newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getShapeKeyword_7_0());
                        
                    otherlv_18=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode787); 

                        	newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:419:1: ( (lv_shape_19_0= ruleNodeShape ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:420:1: (lv_shape_19_0= ruleNodeShape )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:420:1: (lv_shape_19_0= ruleNodeShape )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:421:3: lv_shape_19_0= ruleNodeShape
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNodeShape_in_ruleNode808);
                    lv_shape_19_0=ruleNodeShape();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"shape",
                            		lv_shape_19_0, 
                            		"NodeShape");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:437:4: (otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:437:6: otherlv_20= 'color' otherlv_21= '=' ( (lv_color_22_0= ruleNodeColor ) )
                    {
                    otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNode823); 

                        	newLeafNode(otherlv_20, grammarAccess.getNodeAccess().getColorKeyword_8_0());
                        
                    otherlv_21=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode835); 

                        	newLeafNode(otherlv_21, grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:445:1: ( (lv_color_22_0= ruleNodeColor ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:446:1: (lv_color_22_0= ruleNodeColor )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:446:1: (lv_color_22_0= ruleNodeColor )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:447:3: lv_color_22_0= ruleNodeColor
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNodeColor_in_ruleNode856);
                    lv_color_22_0=ruleNodeColor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"color",
                            		lv_color_22_0, 
                            		"NodeColor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:463:4: (otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:463:6: otherlv_23= 'style' otherlv_24= '=' ( (lv_style_25_0= ruleNodeStyle ) )
                    {
                    otherlv_23=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNode871); 

                        	newLeafNode(otherlv_23, grammarAccess.getNodeAccess().getStyleKeyword_9_0());
                        
                    otherlv_24=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode883); 

                        	newLeafNode(otherlv_24, grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:471:1: ( (lv_style_25_0= ruleNodeStyle ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:472:1: (lv_style_25_0= ruleNodeStyle )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:472:1: (lv_style_25_0= ruleNodeStyle )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:473:3: lv_style_25_0= ruleNodeStyle
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNodeStyle_in_ruleNode904);
                    lv_style_25_0=ruleNodeStyle();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"style",
                            		lv_style_25_0, 
                            		"NodeStyle");
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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:497:1: entryRuleBooleanAttribute returns [EObject current=null] : iv_ruleBooleanAttribute= ruleBooleanAttribute EOF ;
    public final EObject entryRuleBooleanAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttribute = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:498:2: (iv_ruleBooleanAttribute= ruleBooleanAttribute EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:499:2: iv_ruleBooleanAttribute= ruleBooleanAttribute EOF
            {
             newCompositeNode(grammarAccess.getBooleanAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAttribute_in_entryRuleBooleanAttribute942);
            iv_ruleBooleanAttribute=ruleBooleanAttribute();

            state._fsp--;

             current =iv_ruleBooleanAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAttribute952); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:506:1: ruleBooleanAttribute returns [EObject current=null] : ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleBooleanAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_negation_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:509:28: ( ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:510:1: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:510:1: ( () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:510:2: () ( (lv_negation_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:510:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanAttributeAccess().getBooleanAttributeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:516:2: ( (lv_negation_1_0= 'not' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:517:1: (lv_negation_1_0= 'not' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:517:1: (lv_negation_1_0= 'not' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:518:3: lv_negation_1_0= 'not'
                    {
                    lv_negation_1_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleBooleanAttribute1004); 

                            newLeafNode(lv_negation_1_0, grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "negation", true, "not");
                    	    

                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:531:3: ( (otherlv_2= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:532:1: (otherlv_2= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:532:1: (otherlv_2= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:533:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanAttributeRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanAttribute1038); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:552:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:553:2: (iv_ruleRelation= ruleRelation EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:554:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRelation_in_entryRuleRelation1074);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRelation1084); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:561:1: ruleRelation returns [EObject current=null] : (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_Edge_0 = null;

        EObject this_Level_1 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:564:28: ( (this_Edge_0= ruleEdge | this_Level_1= ruleLevel ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:565:1: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:565:1: (this_Edge_0= ruleEdge | this_Level_1= ruleLevel )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:566:5: this_Edge_0= ruleEdge
                    {
                     
                            newCompositeNode(grammarAccess.getRelationAccess().getEdgeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEdge_in_ruleRelation1131);
                    this_Edge_0=ruleEdge();

                    state._fsp--;

                     
                            current = this_Edge_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:576:5: this_Level_1= ruleLevel
                    {
                     
                            newCompositeNode(grammarAccess.getRelationAccess().getLevelParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLevel_in_ruleRelation1158);
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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:592:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:593:2: (iv_ruleEdge= ruleEdge EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:594:2: iv_ruleEdge= ruleEdge EOF
            {
             newCompositeNode(grammarAccess.getEdgeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEdge_in_entryRuleEdge1193);
            iv_ruleEdge=ruleEdge();

            state._fsp--;

             current =iv_ruleEdge; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEdge1203); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:601:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? ) ;
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:604:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:605:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:605:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:605:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )? (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )? (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )? (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )? (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )? (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:605:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:606:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEdgeAccess().getEdgeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:611:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:612:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:612:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:613:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1257); 

            		newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEdge1269); 

                	newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:628:1: ( (otherlv_3= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:629:1: (otherlv_3= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:629:1: (otherlv_3= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:630:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1289); 

            		newLeafNode(otherlv_3, grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEdge1301); 

                	newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getCommaKeyword_4());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:645:1: ( (otherlv_5= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:646:1: (otherlv_5= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:646:1: (otherlv_5= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:647:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1321); 

            		newLeafNode(otherlv_5, grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEdge1333); 

                	newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6());
                
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEdge1345); 

                	newLeafNode(otherlv_7, grammarAccess.getEdgeAccess().getColonKeyword_7());
                
            otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEdge1357); 

                	newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getEdgeKeyword_8());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:670:1: (otherlv_9= '=' ( (otherlv_10= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:670:3: otherlv_9= '=' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1370); 

                        	newLeafNode(otherlv_9, grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:674:1: ( (otherlv_10= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:675:1: (otherlv_10= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:675:1: (otherlv_10= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:676:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEdgeRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1390); 

                    		newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_9_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:687:4: (otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:687:6: otherlv_11= 'label' otherlv_12= '=' ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )? ( (otherlv_15= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEdge1405); 

                        	newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getLabelKeyword_10_0());
                        
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1417); 

                        	newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:695:1: ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '.' )?
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
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:695:2: ( (otherlv_13= RULE_ID ) ) otherlv_14= '.'
                            {
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:695:2: ( (otherlv_13= RULE_ID ) )
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:696:1: (otherlv_13= RULE_ID )
                            {
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:696:1: (otherlv_13= RULE_ID )
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:697:3: otherlv_13= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getEdgeRule());
                            	        }
                                    
                            otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1438); 

                            		newLeafNode(otherlv_13, grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0()); 
                            	

                            }


                            }

                            otherlv_14=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEdge1450); 

                                	newLeafNode(otherlv_14, grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1());
                                

                            }
                            break;

                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:712:3: ( (otherlv_15= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:713:1: (otherlv_15= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:713:1: (otherlv_15= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:714:3: otherlv_15= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEdgeRule());
                    	        }
                            
                    otherlv_15=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1472); 

                    		newLeafNode(otherlv_15, grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:725:4: (otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:725:6: otherlv_16= 'src_decoration' otherlv_17= '=' ( (lv_src_decoration_18_0= ruleDecoration ) )
                    {
                    otherlv_16=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEdge1487); 

                        	newLeafNode(otherlv_16, grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0());
                        
                    otherlv_17=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1499); 

                        	newLeafNode(otherlv_17, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:733:1: ( (lv_src_decoration_18_0= ruleDecoration ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:734:1: (lv_src_decoration_18_0= ruleDecoration )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:734:1: (lv_src_decoration_18_0= ruleDecoration )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:735:3: lv_src_decoration_18_0= ruleDecoration
                    {
                     
                    	        newCompositeNode(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_11_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDecoration_in_ruleEdge1520);
                    lv_src_decoration_18_0=ruleDecoration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEdgeRule());
                    	        }
                           		set(
                           			current, 
                           			"src_decoration",
                            		lv_src_decoration_18_0, 
                            		"Decoration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:751:4: (otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:751:6: otherlv_19= 'src_label' otherlv_20= '=' ( (otherlv_21= RULE_ID ) )
                    {
                    otherlv_19=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEdge1535); 

                        	newLeafNode(otherlv_19, grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0());
                        
                    otherlv_20=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1547); 

                        	newLeafNode(otherlv_20, grammarAccess.getEdgeAccess().getEqualsSignKeyword_12_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:759:1: ( (otherlv_21= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:760:1: (otherlv_21= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:760:1: (otherlv_21= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:761:3: otherlv_21= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEdgeRule());
                    	        }
                            
                    otherlv_21=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1567); 

                    		newLeafNode(otherlv_21, grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:772:4: (otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:772:6: otherlv_22= 'tar_decoration' otherlv_23= '=' ( (lv_tar_decoration_24_0= ruleDecoration ) )
                    {
                    otherlv_22=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEdge1582); 

                        	newLeafNode(otherlv_22, grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0());
                        
                    otherlv_23=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1594); 

                        	newLeafNode(otherlv_23, grammarAccess.getEdgeAccess().getEqualsSignKeyword_13_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:780:1: ( (lv_tar_decoration_24_0= ruleDecoration ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:781:1: (lv_tar_decoration_24_0= ruleDecoration )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:781:1: (lv_tar_decoration_24_0= ruleDecoration )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:782:3: lv_tar_decoration_24_0= ruleDecoration
                    {
                     
                    	        newCompositeNode(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_13_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDecoration_in_ruleEdge1615);
                    lv_tar_decoration_24_0=ruleDecoration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEdgeRule());
                    	        }
                           		set(
                           			current, 
                           			"tar_decoration",
                            		lv_tar_decoration_24_0, 
                            		"Decoration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:798:4: (otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:798:6: otherlv_25= 'tar_label' otherlv_26= '=' ( (otherlv_27= RULE_ID ) )
                    {
                    otherlv_25=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEdge1630); 

                        	newLeafNode(otherlv_25, grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0());
                        
                    otherlv_26=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge1642); 

                        	newLeafNode(otherlv_26, grammarAccess.getEdgeAccess().getEqualsSignKeyword_14_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:806:1: ( (otherlv_27= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:807:1: (otherlv_27= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:807:1: (otherlv_27= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:808:3: otherlv_27= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEdgeRule());
                    	        }
                            
                    otherlv_27=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge1662); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:827:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:828:2: (iv_ruleLevel= ruleLevel EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:829:2: iv_ruleLevel= ruleLevel EOF
            {
             newCompositeNode(grammarAccess.getLevelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLevel_in_entryRuleLevel1700);
            iv_ruleLevel=ruleLevel();

            state._fsp--;

             current =iv_ruleLevel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLevel1710); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:836:1: ruleLevel returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? ) ;
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:839:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:840:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:840:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:840:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' otherlv_5= 'edge' (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )? (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )? (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )? (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:840:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:841:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLevelAccess().getLevelAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:846:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:847:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:847:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:848:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLevelRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel1764); 

            		newLeafNode(otherlv_1, grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLevel1776); 

                	newLeafNode(otherlv_2, grammarAccess.getLevelAccess().getFullStopKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:863:1: ( (otherlv_3= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:864:1: (otherlv_3= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:864:1: (otherlv_3= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:865:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLevelRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel1796); 

            		newLeafNode(otherlv_3, grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLevel1808); 

                	newLeafNode(otherlv_4, grammarAccess.getLevelAccess().getColonKeyword_4());
                
            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLevel1820); 

                	newLeafNode(otherlv_5, grammarAccess.getLevelAccess().getEdgeKeyword_5());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:884:1: (otherlv_6= '=' ( (otherlv_7= RULE_ID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==18) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:884:3: otherlv_6= '=' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel1833); 

                        	newLeafNode(otherlv_6, grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:888:1: ( (otherlv_7= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:889:1: (otherlv_7= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:889:1: (otherlv_7= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:890:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getLevelRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel1853); 

                    		newLeafNode(otherlv_7, grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:901:4: (otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==25) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:901:6: otherlv_8= 'label' otherlv_9= '=' ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )? ( (otherlv_12= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLevel1868); 

                        	newLeafNode(otherlv_8, grammarAccess.getLevelAccess().getLabelKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel1880); 

                        	newLeafNode(otherlv_9, grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:909:1: ( ( (otherlv_10= RULE_ID ) ) otherlv_11= '.' )?
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
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:909:2: ( (otherlv_10= RULE_ID ) ) otherlv_11= '.'
                            {
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:909:2: ( (otherlv_10= RULE_ID ) )
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:910:1: (otherlv_10= RULE_ID )
                            {
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:910:1: (otherlv_10= RULE_ID )
                            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:911:3: otherlv_10= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getLevelRule());
                            	        }
                                    
                            otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel1901); 

                            		newLeafNode(otherlv_10, grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0()); 
                            	

                            }


                            }

                            otherlv_11=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLevel1913); 

                                	newLeafNode(otherlv_11, grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1());
                                

                            }
                            break;

                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:926:3: ( (otherlv_12= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:927:1: (otherlv_12= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:927:1: (otherlv_12= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:928:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getLevelRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel1935); 

                    		newLeafNode(otherlv_12, grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:939:4: (otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:939:6: otherlv_13= 'src_decoration' otherlv_14= '=' ( (lv_src_decoration_15_0= ruleDecoration ) )
                    {
                    otherlv_13=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleLevel1950); 

                        	newLeafNode(otherlv_13, grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0());
                        
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel1962); 

                        	newLeafNode(otherlv_14, grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:947:1: ( (lv_src_decoration_15_0= ruleDecoration ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:948:1: (lv_src_decoration_15_0= ruleDecoration )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:948:1: (lv_src_decoration_15_0= ruleDecoration )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:949:3: lv_src_decoration_15_0= ruleDecoration
                    {
                     
                    	        newCompositeNode(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDecoration_in_ruleLevel1983);
                    lv_src_decoration_15_0=ruleDecoration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLevelRule());
                    	        }
                           		set(
                           			current, 
                           			"src_decoration",
                            		lv_src_decoration_15_0, 
                            		"Decoration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:965:4: (otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==28) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:965:6: otherlv_16= 'src_label' otherlv_17= '=' ( (otherlv_18= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleLevel1998); 

                        	newLeafNode(otherlv_16, grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0());
                        
                    otherlv_17=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel2010); 

                        	newLeafNode(otherlv_17, grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:973:1: ( (otherlv_18= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:974:1: (otherlv_18= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:974:1: (otherlv_18= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:975:3: otherlv_18= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getLevelRule());
                    	        }
                            
                    otherlv_18=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel2030); 

                    		newLeafNode(otherlv_18, grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:986:4: (otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==29) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:986:6: otherlv_19= 'tar_decoration' otherlv_20= '=' ( (lv_tar_decoration_21_0= ruleDecoration ) )
                    {
                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleLevel2045); 

                        	newLeafNode(otherlv_19, grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0());
                        
                    otherlv_20=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel2057); 

                        	newLeafNode(otherlv_20, grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:994:1: ( (lv_tar_decoration_21_0= ruleDecoration ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:995:1: (lv_tar_decoration_21_0= ruleDecoration )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:995:1: (lv_tar_decoration_21_0= ruleDecoration )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:996:3: lv_tar_decoration_21_0= ruleDecoration
                    {
                     
                    	        newCompositeNode(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDecoration_in_ruleLevel2078);
                    lv_tar_decoration_21_0=ruleDecoration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLevelRule());
                    	        }
                           		set(
                           			current, 
                           			"tar_decoration",
                            		lv_tar_decoration_21_0, 
                            		"Decoration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1012:4: (otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1012:6: otherlv_22= 'tar_label' otherlv_23= '=' ( (otherlv_24= RULE_ID ) )
                    {
                    otherlv_22=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleLevel2093); 

                        	newLeafNode(otherlv_22, grammarAccess.getLevelAccess().getTar_labelKeyword_11_0());
                        
                    otherlv_23=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLevel2105); 

                        	newLeafNode(otherlv_23, grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1020:1: ( (otherlv_24= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1021:1: (otherlv_24= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1021:1: (otherlv_24= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1022:3: otherlv_24= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getLevelRule());
                    	        }
                            
                    otherlv_24=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLevel2125); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1041:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1042:2: (iv_ruleContent= ruleContent EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1043:2: iv_ruleContent= ruleContent EOF
            {
             newCompositeNode(grammarAccess.getContentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent2163);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent2173); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1050:1: ruleContent returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) ;
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1053:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1054:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1054:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1054:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )? ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )? (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )? (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1054:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1055:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getContentAccess().getContentAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1060:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1061:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1061:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1062:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContentRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContent2227); 

            		newLeafNode(otherlv_1, grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleContent2239); 

                	newLeafNode(otherlv_2, grammarAccess.getContentAccess().getColonKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1077:1: ( ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )* )?
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1077:2: ( (lv_nodenum_3_0= ruleNodeEnumerator ) ) ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1077:2: ( (lv_nodenum_3_0= ruleNodeEnumerator ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1078:1: (lv_nodenum_3_0= ruleNodeEnumerator )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1078:1: (lv_nodenum_3_0= ruleNodeEnumerator )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1079:3: lv_nodenum_3_0= ruleNodeEnumerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNodeEnumerator_in_ruleContent2261);
                    lv_nodenum_3_0=ruleNodeEnumerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContentRule());
                    	        }
                           		add(
                           			current, 
                           			"nodenum",
                            		lv_nodenum_3_0, 
                            		"NodeEnumerator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1095:2: ( (lv_nodenum_4_0= ruleNodeEnumerator ) )*
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
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1096:1: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    {
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1096:1: (lv_nodenum_4_0= ruleNodeEnumerator )
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1097:3: lv_nodenum_4_0= ruleNodeEnumerator
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleNodeEnumerator_in_ruleContent2282);
                    	    lv_nodenum_4_0=ruleNodeEnumerator();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"nodenum",
                    	            		lv_nodenum_4_0, 
                    	            		"NodeEnumerator");
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

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1113:5: ( ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )* )?
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1113:6: ( (lv_info_5_0= ruleInformation ) ) ( (lv_info_6_0= ruleInformation ) )*
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1113:6: ( (lv_info_5_0= ruleInformation ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1114:1: (lv_info_5_0= ruleInformation )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1114:1: (lv_info_5_0= ruleInformation )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1115:3: lv_info_5_0= ruleInformation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInformation_in_ruleContent2307);
                    lv_info_5_0=ruleInformation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContentRule());
                    	        }
                           		add(
                           			current, 
                           			"info",
                            		lv_info_5_0, 
                            		"Information");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1131:2: ( (lv_info_6_0= ruleInformation ) )*
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
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1132:1: (lv_info_6_0= ruleInformation )
                    	    {
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1132:1: (lv_info_6_0= ruleInformation )
                    	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1133:3: lv_info_6_0= ruleInformation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleInformation_in_ruleContent2328);
                    	    lv_info_6_0=ruleInformation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"info",
                    	            		lv_info_6_0, 
                    	            		"Information");
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

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1149:5: (otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==13) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1149:7: otherlv_7= '{' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
                    {
                    otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleContent2344); 

                        	newLeafNode(otherlv_7, grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1153:1: ( (otherlv_8= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1154:1: (otherlv_8= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1154:1: (otherlv_8= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1155:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContentRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContent2364); 

                    		newLeafNode(otherlv_8, grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 
                    	

                    }


                    }

                    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleContent2376); 

                        	newLeafNode(otherlv_9, grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2());
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1170:3: (otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1170:5: otherlv_10= 'text' otherlv_11= '=' ( (lv_symbol_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleContent2391); 

                        	newLeafNode(otherlv_10, grammarAccess.getContentAccess().getTextKeyword_6_0());
                        
                    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleContent2403); 

                        	newLeafNode(otherlv_11, grammarAccess.getContentAccess().getEqualsSignKeyword_6_1());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1178:1: ( (lv_symbol_12_0= ruleEString ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1179:1: (lv_symbol_12_0= ruleEString )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1179:1: (lv_symbol_12_0= ruleEString )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1180:3: lv_symbol_12_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getContentAccess().getSymbolEStringParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleContent2424);
                    lv_symbol_12_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContentRule());
                    	        }
                           		set(
                           			current, 
                           			"symbol",
                            		lv_symbol_12_0, 
                            		"EString");
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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1204:1: entryRuleNodeEnumerator returns [EObject current=null] : iv_ruleNodeEnumerator= ruleNodeEnumerator EOF ;
    public final EObject entryRuleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeEnumerator = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1205:2: (iv_ruleNodeEnumerator= ruleNodeEnumerator EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1206:2: iv_ruleNodeEnumerator= ruleNodeEnumerator EOF
            {
             newCompositeNode(grammarAccess.getNodeEnumeratorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeEnumerator_in_entryRuleNodeEnumerator2462);
            iv_ruleNodeEnumerator=ruleNodeEnumerator();

            state._fsp--;

             current =iv_ruleNodeEnumerator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeEnumerator2472); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1213:1: ruleNodeEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) ;
    public final EObject ruleNodeEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_enumerator_3_0 = null;

        EObject lv_enumerator_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1216:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1217:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1217:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1217:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_enumerator_3_0= ruleEnumerator ) ) ( (lv_enumerator_4_0= ruleEnumerator ) )* otherlv_5= ']'
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1217:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1218:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1223:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1224:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1224:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1225:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeEnumeratorRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNodeEnumerator2526); 

            		newLeafNode(otherlv_1, grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNodeEnumerator2538); 

                	newLeafNode(otherlv_2, grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1240:1: ( (lv_enumerator_3_0= ruleEnumerator ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1241:1: (lv_enumerator_3_0= ruleEnumerator )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1241:1: (lv_enumerator_3_0= ruleEnumerator )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1242:3: lv_enumerator_3_0= ruleEnumerator
            {
             
            	        newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumerator_in_ruleNodeEnumerator2559);
            lv_enumerator_3_0=ruleEnumerator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeEnumeratorRule());
            	        }
                   		add(
                   			current, 
                   			"enumerator",
                    		lv_enumerator_3_0, 
                    		"Enumerator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1258:2: ( (lv_enumerator_4_0= ruleEnumerator ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1259:1: (lv_enumerator_4_0= ruleEnumerator )
            	    {
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1259:1: (lv_enumerator_4_0= ruleEnumerator )
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1260:3: lv_enumerator_4_0= ruleEnumerator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumerator_in_ruleNodeEnumerator2580);
            	    lv_enumerator_4_0=ruleEnumerator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeEnumeratorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"enumerator",
            	            		lv_enumerator_4_0, 
            	            		"Enumerator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleNodeEnumerator2593); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1288:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1289:2: (iv_ruleEnumerator= ruleEnumerator EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1290:2: iv_ruleEnumerator= ruleEnumerator EOF
            {
             newCompositeNode(grammarAccess.getEnumeratorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumerator_in_entryRuleEnumerator2629);
            iv_ruleEnumerator=ruleEnumerator();

            state._fsp--;

             current =iv_ruleEnumerator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumerator2639); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1297:1: ruleEnumerator returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1300:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1301:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1301:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1301:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEString ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1301:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1302:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnumeratorAccess().getEnumeratorAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1307:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1308:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1308:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1309:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumeratorRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumerator2693); 

            		newLeafNode(otherlv_1, grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEnumerator2705); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1324:1: ( (lv_value_3_0= ruleEString ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1325:1: (lv_value_3_0= ruleEString )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1325:1: (lv_value_3_0= ruleEString )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1326:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEnumeratorAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumerator2726);
            lv_value_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumeratorRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
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
    // $ANTLR end "ruleEnumerator"


    // $ANTLR start "entryRuleInformation"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1350:1: entryRuleInformation returns [EObject current=null] : iv_ruleInformation= ruleInformation EOF ;
    public final EObject entryRuleInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformation = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1351:2: (iv_ruleInformation= ruleInformation EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1352:2: iv_ruleInformation= ruleInformation EOF
            {
             newCompositeNode(grammarAccess.getInformationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInformation_in_entryRuleInformation2762);
            iv_ruleInformation=ruleInformation();

            state._fsp--;

             current =iv_ruleInformation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInformation2772); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1359:1: ruleInformation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1362:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1363:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1363:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1363:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1363:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1364:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInformationAccess().getInformationAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1369:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1370:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1370:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1371:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInformationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInformation2826); 

            		newLeafNode(otherlv_1, grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 
            	

            }


            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1382:2: (otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==26) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1382:4: otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleInformation2839); 

                        	newLeafNode(otherlv_2, grammarAccess.getInformationAccess().getFullStopKeyword_2_0());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1386:1: ( (otherlv_3= RULE_ID ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1387:1: (otherlv_3= RULE_ID )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1387:1: (otherlv_3= RULE_ID )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1388:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInformationRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInformation2859); 

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


    // $ANTLR start "ruleGraphType"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1407:1: ruleGraphType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleGraphType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1409:28: ( (enumLiteral_0= 'diagram' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1410:1: (enumLiteral_0= 'diagram' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1410:1: (enumLiteral_0= 'diagram' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1410:3: enumLiteral_0= 'diagram'
            {
            enumLiteral_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleGraphType2910); 

                    current = grammarAccess.getGraphTypeAccess().getDiagramEnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getGraphTypeAccess().getDiagramEnumLiteralDeclaration()); 
                

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
    // $ANTLR end "ruleGraphType"


    // $ANTLR start "ruleNodeType"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1420:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1422:28: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1423:1: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1423:1: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1423:2: (enumLiteral_0= 'node' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1423:2: (enumLiteral_0= 'node' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1423:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleNodeType2954); 

                            current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1429:6: (enumLiteral_1= 'markednode' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1429:6: (enumLiteral_1= 'markednode' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1429:8: enumLiteral_1= 'markednode'
                    {
                    enumLiteral_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNodeType2971); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1439:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1441:28: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1442:1: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1442:1: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) | (enumLiteral_2= 'record' ) )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1442:2: (enumLiteral_0= 'circle' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1442:2: (enumLiteral_0= 'circle' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1442:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNodeShape3016); 

                            current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1448:6: (enumLiteral_1= 'doublecircle' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1448:6: (enumLiteral_1= 'doublecircle' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1448:8: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNodeShape3033); 

                            current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1454:6: (enumLiteral_2= 'record' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1454:6: (enumLiteral_2= 'record' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1454:8: enumLiteral_2= 'record'
                    {
                    enumLiteral_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNodeShape3050); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1464:1: ruleNodeColor returns [Enumerator current=null] : (enumLiteral_0= 'gray95' ) ;
    public final Enumerator ruleNodeColor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1466:28: ( (enumLiteral_0= 'gray95' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1467:1: (enumLiteral_0= 'gray95' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1467:1: (enumLiteral_0= 'gray95' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1467:3: enumLiteral_0= 'gray95'
            {
            enumLiteral_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleNodeColor3094); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1477:1: ruleNodeStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) ;
    public final Enumerator ruleNodeStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1479:28: ( ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1480:1: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1480:1: ( (enumLiteral_0= 'italic' ) | (enumLiteral_1= 'underline' ) )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1480:2: (enumLiteral_0= 'italic' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1480:2: (enumLiteral_0= 'italic' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1480:4: enumLiteral_0= 'italic'
                    {
                    enumLiteral_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleNodeStyle3138); 

                            current = grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1486:6: (enumLiteral_1= 'underline' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1486:6: (enumLiteral_1= 'underline' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1486:8: enumLiteral_1= 'underline'
                    {
                    enumLiteral_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleNodeStyle3155); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1496:1: ruleDecoration returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) ;
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
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1498:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1499:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1499:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'triangle' ) | (enumLiteral_2= 'diamond' ) | (enumLiteral_3= 'odiamond' ) | (enumLiteral_4= 'open' ) | (enumLiteral_5= 'empty' ) )
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
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1499:2: (enumLiteral_0= 'none' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1499:2: (enumLiteral_0= 'none' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1499:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleDecoration3200); 

                            current = grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1505:6: (enumLiteral_1= 'triangle' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1505:6: (enumLiteral_1= 'triangle' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1505:8: enumLiteral_1= 'triangle'
                    {
                    enumLiteral_1=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleDecoration3217); 

                            current = grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1511:6: (enumLiteral_2= 'diamond' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1511:6: (enumLiteral_2= 'diamond' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1511:8: enumLiteral_2= 'diamond'
                    {
                    enumLiteral_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleDecoration3234); 

                            current = grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1517:6: (enumLiteral_3= 'odiamond' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1517:6: (enumLiteral_3= 'odiamond' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1517:8: enumLiteral_3= 'odiamond'
                    {
                    enumLiteral_3=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleDecoration3251); 

                            current = grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1523:6: (enumLiteral_4= 'open' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1523:6: (enumLiteral_4= 'open' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1523:8: enumLiteral_4= 'open'
                    {
                    enumLiteral_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleDecoration3268); 

                            current = grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1529:6: (enumLiteral_5= 'empty' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1529:6: (enumLiteral_5= 'empty' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:1529:8: enumLiteral_5= 'empty'
                    {
                    enumLiteral_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleDecoration3285); 

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
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\1\4\1\14\1\uffff\2\4\1\uffff\1\20\1\4\1\20\1\14\1\30";
    static final String DFA1_maxS =
        "\1\16\1\32\1\uffff\1\27\1\44\1\uffff\1\21\1\27\1\21\1\14\1\44";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
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

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 148:1: ( (lv_nodes_7_0= ruleNode ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorGraph_in_entryRuleMutatorGraph75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorGraph85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleMutatorGraph131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMutatorGraph152 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMutatorGraph172 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMutatorGraph184 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_ruleGraphType_in_ruleMutatorGraph205 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorGraph217 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleNode_in_ruleMutatorGraph238 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleRelation_in_ruleMutatorGraph260 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleContent_in_ruleMutatorGraph282 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleMutatorGraph295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString332 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_entryRuleNode454 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNode464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode518 = new BitSet(new long[]{0x0000000000009000L});
        public static final BitSet FOLLOW_15_in_ruleNode531 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_ruleBooleanAttribute_in_ruleNode552 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleNode565 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_ruleBooleanAttribute_in_ruleNode586 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleNode600 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNode614 = new BitSet(new long[]{0x0000001800000000L});
        public static final BitSet FOLLOW_ruleNodeType_in_ruleNode635 = new BitSet(new long[]{0x00000000007C0002L});
        public static final BitSet FOLLOW_18_in_ruleNode648 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode668 = new BitSet(new long[]{0x0000000000780002L});
        public static final BitSet FOLLOW_19_in_ruleNode683 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleNode695 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleNode707 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode727 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode747 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleNode760 = new BitSet(new long[]{0x0000000000700002L});
        public static final BitSet FOLLOW_20_in_ruleNode775 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleNode787 = new BitSet(new long[]{0x000000E000000000L});
        public static final BitSet FOLLOW_ruleNodeShape_in_ruleNode808 = new BitSet(new long[]{0x0000000000600002L});
        public static final BitSet FOLLOW_21_in_ruleNode823 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleNode835 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_ruleNodeColor_in_ruleNode856 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleNode871 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleNode883 = new BitSet(new long[]{0x0000060000000000L});
        public static final BitSet FOLLOW_ruleNodeStyle_in_ruleNode904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttribute_in_entryRuleBooleanAttribute942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttribute952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleBooleanAttribute1004 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttribute1038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelation_in_entryRuleRelation1074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRelation1084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEdge_in_ruleRelation1131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLevel_in_ruleRelation1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEdge_in_entryRuleEdge1193 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEdge1203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1257 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEdge1269 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1289 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEdge1301 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1321 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEdge1333 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEdge1345 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleEdge1357 = new BitSet(new long[]{0x000000007A040002L});
        public static final BitSet FOLLOW_18_in_ruleEdge1370 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1390 = new BitSet(new long[]{0x000000007A000002L});
        public static final BitSet FOLLOW_25_in_ruleEdge1405 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge1417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1438 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleEdge1450 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1472 = new BitSet(new long[]{0x0000000078000002L});
        public static final BitSet FOLLOW_27_in_ruleEdge1487 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge1499 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleDecoration_in_ruleEdge1520 = new BitSet(new long[]{0x0000000070000002L});
        public static final BitSet FOLLOW_28_in_ruleEdge1535 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge1547 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1567 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_29_in_ruleEdge1582 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge1594 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleDecoration_in_ruleEdge1615 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleEdge1630 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge1642 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge1662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLevel_in_entryRuleLevel1700 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLevel1710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel1764 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLevel1776 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel1796 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLevel1808 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLevel1820 = new BitSet(new long[]{0x000000007A040002L});
        public static final BitSet FOLLOW_18_in_ruleLevel1833 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel1853 = new BitSet(new long[]{0x000000007A000002L});
        public static final BitSet FOLLOW_25_in_ruleLevel1868 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLevel1880 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel1901 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLevel1913 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel1935 = new BitSet(new long[]{0x0000000078000002L});
        public static final BitSet FOLLOW_27_in_ruleLevel1950 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLevel1962 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleDecoration_in_ruleLevel1983 = new BitSet(new long[]{0x0000000070000002L});
        public static final BitSet FOLLOW_28_in_ruleLevel1998 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLevel2010 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel2030 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_29_in_ruleLevel2045 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLevel2057 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleDecoration_in_ruleLevel2078 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleLevel2093 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLevel2105 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLevel2125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent2163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent2173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContent2227 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleContent2239 = new BitSet(new long[]{0x0000000080002012L});
        public static final BitSet FOLLOW_ruleNodeEnumerator_in_ruleContent2261 = new BitSet(new long[]{0x0000000080002012L});
        public static final BitSet FOLLOW_ruleNodeEnumerator_in_ruleContent2282 = new BitSet(new long[]{0x0000000080002012L});
        public static final BitSet FOLLOW_ruleInformation_in_ruleContent2307 = new BitSet(new long[]{0x0000000080002012L});
        public static final BitSet FOLLOW_ruleInformation_in_ruleContent2328 = new BitSet(new long[]{0x0000000080002012L});
        public static final BitSet FOLLOW_13_in_ruleContent2344 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContent2364 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleContent2376 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_ruleContent2391 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleContent2403 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleContent2424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeEnumerator_in_entryRuleNodeEnumerator2462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeEnumerator2472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNodeEnumerator2526 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleNodeEnumerator2538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumerator_in_ruleNodeEnumerator2559 = new BitSet(new long[]{0x0000000200000010L});
        public static final BitSet FOLLOW_ruleEnumerator_in_ruleNodeEnumerator2580 = new BitSet(new long[]{0x0000000200000010L});
        public static final BitSet FOLLOW_33_in_ruleNodeEnumerator2593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumerator_in_entryRuleEnumerator2629 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumerator2639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerator2693 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEnumerator2705 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumerator2726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInformation_in_entryRuleInformation2762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInformation2772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInformation2826 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleInformation2839 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInformation2859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleGraphType2910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleNodeType2954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNodeType2971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleNodeShape3016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNodeShape3033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleNodeShape3050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleNodeColor3094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleNodeStyle3138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleNodeStyle3155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleDecoration3200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleDecoration3217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleDecoration3234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleDecoration3251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleDecoration3268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleDecoration3285 = new BitSet(new long[]{0x0000000000000002L});
    }


}