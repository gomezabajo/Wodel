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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "':'", "'{'", "'}'", "'('", "'not'", "'yes'", "')'", "','", "'shape'", "'='", "'edge'", "'label'", "'diagram'", "'node'", "'markednode'", "'circle'", "'doublecircle'"
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
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:77:1: ruleMutatorGraph returns [EObject current=null] : ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_edges_8_0= ruleEdge ) )* otherlv_9= '}' ) ;
    public final EObject ruleMutatorGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_metamodel_2_0 = null;

        Enumerator lv_type_5_0 = null;

        EObject lv_nodes_7_0 = null;

        EObject lv_edges_8_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:80:28: ( ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_edges_8_0= ruleEdge ) )* otherlv_9= '}' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_edges_8_0= ruleEdge ) )* otherlv_9= '}' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:1: ( () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_edges_8_0= ruleEdge ) )* otherlv_9= '}' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:81:2: () otherlv_1= 'metamodel' ( (lv_metamodel_2_0= ruleEString ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleGraphType ) ) otherlv_6= '{' ( (lv_nodes_7_0= ruleNode ) )* ( (lv_edges_8_0= ruleEdge ) )* otherlv_9= '}'
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
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==15) ) {
                        int LA1_3 = input.LA(3);

                        if ( (LA1_3==RULE_ID) ) {
                            int LA1_4 = input.LA(4);

                            if ( (LA1_4==18) ) {
                                alt1=1;
                            }


                        }
                        else if ( ((LA1_3>=16 && LA1_3<=17)) ) {
                            alt1=1;
                        }


                    }


                }


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

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:166:3: ( (lv_edges_8_0= ruleEdge ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:167:1: (lv_edges_8_0= ruleEdge )
            	    {
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:167:1: (lv_edges_8_0= ruleEdge )
            	    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:168:3: lv_edges_8_0= ruleEdge
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorGraphAccess().getEdgesEdgeParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEdge_in_ruleMutatorGraph260);
            	    lv_edges_8_0=ruleEdge();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"edges",
            	            		lv_edges_8_0, 
            	            		"Edge");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorGraph273); 

                	newLeafNode(otherlv_9, grammarAccess.getMutatorGraphAccess().getRightCurlyBracketKeyword_9());
                

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:196:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:197:2: (iv_ruleEString= ruleEString EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:198:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString310);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString321); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:205:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:208:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:209:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:209:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:209:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString361); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:217:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString387); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:232:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:233:2: (iv_ruleNode= ruleNode EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:234:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_entryRuleNode432);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNode442); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:241:1: ruleNode returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )? ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_negation_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_type_8_0 = null;

        Enumerator lv_shape_12_0 = null;


         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:244:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )? ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )? ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:245:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )? ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )? )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:245:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )? ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )? )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:245:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )? ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleNodeType ) ) (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )?
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:245:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:246:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeAccess().getNodeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:251:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:252:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:252:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:253:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode496); 

            		newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNode508); 

                	newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:268:1: ( ( (lv_negation_3_0= 'not' ) ) | otherlv_4= 'yes' )?
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            switch (alt4) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:268:2: ( (lv_negation_3_0= 'not' ) )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:268:2: ( (lv_negation_3_0= 'not' ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:269:1: (lv_negation_3_0= 'not' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:269:1: (lv_negation_3_0= 'not' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:270:3: lv_negation_3_0= 'not'
                    {
                    lv_negation_3_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNode527); 

                            newLeafNode(lv_negation_3_0, grammarAccess.getNodeAccess().getNegationNotKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNodeRule());
                    	        }
                           		setWithLastConsumed(current, "negation", true, "not");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:284:7: otherlv_4= 'yes'
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNode558); 

                        	newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getYesKeyword_3_1());
                        

                    }
                    break;

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:288:3: ( (otherlv_5= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:289:1: (otherlv_5= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:289:1: (otherlv_5= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:290:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode580); 

            		newLeafNode(otherlv_5, grammarAccess.getNodeAccess().getAttributeEAttributeCrossReference_4_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNode592); 

                	newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightParenthesisKeyword_5());
                
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNode604); 

                	newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getColonKeyword_6());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:309:1: ( (lv_type_8_0= ruleNodeType ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:310:1: (lv_type_8_0= ruleNodeType )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:310:1: (lv_type_8_0= ruleNodeType )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:311:3: lv_type_8_0= ruleNodeType
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNodeType_in_ruleNode625);
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

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:327:2: (otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:327:4: otherlv_9= ',' otherlv_10= 'shape' otherlv_11= '=' ( (lv_shape_12_0= ruleNodeShape ) )
                    {
                    otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNode638); 

                        	newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getCommaKeyword_8_0());
                        
                    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNode650); 

                        	newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getShapeKeyword_8_1());
                        
                    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNode662); 

                        	newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getEqualsSignKeyword_8_2());
                        
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:339:1: ( (lv_shape_12_0= ruleNodeShape ) )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:340:1: (lv_shape_12_0= ruleNodeShape )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:340:1: (lv_shape_12_0= ruleNodeShape )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:341:3: lv_shape_12_0= ruleNodeShape
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNodeShape_in_ruleNode683);
                    lv_shape_12_0=ruleNodeShape();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"shape",
                            		lv_shape_12_0, 
                            		"NodeShape");
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


    // $ANTLR start "entryRuleEdge"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:365:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:366:2: (iv_ruleEdge= ruleEdge EOF )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:367:2: iv_ruleEdge= ruleEdge EOF
            {
             newCompositeNode(grammarAccess.getEdgeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEdge_in_entryRuleEdge721);
            iv_ruleEdge=ruleEdge();

            state._fsp--;

             current =iv_ruleEdge; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEdge731); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:374:1: ruleEdge returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' otherlv_9= ',' otherlv_10= 'label' otherlv_11= '=' ( (otherlv_12= RULE_ID ) ) ) ;
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

         enterRule(); 
            
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:377:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' otherlv_9= ',' otherlv_10= 'label' otherlv_11= '=' ( (otherlv_12= RULE_ID ) ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:378:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' otherlv_9= ',' otherlv_10= 'label' otherlv_11= '=' ( (otherlv_12= RULE_ID ) ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:378:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' otherlv_9= ',' otherlv_10= 'label' otherlv_11= '=' ( (otherlv_12= RULE_ID ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:378:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= ':' otherlv_8= 'edge' otherlv_9= ',' otherlv_10= 'label' otherlv_11= '=' ( (otherlv_12= RULE_ID ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:378:2: ()
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:379:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEdgeAccess().getEdgeAction_0(),
                        current);
                

            }

            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:384:2: ( (otherlv_1= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:385:1: (otherlv_1= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:385:1: (otherlv_1= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:386:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge785); 

            		newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEdge797); 

                	newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:401:1: ( (otherlv_3= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:402:1: (otherlv_3= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:402:1: (otherlv_3= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:403:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge817); 

            		newLeafNode(otherlv_3, grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEdge829); 

                	newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getCommaKeyword_4());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:418:1: ( (otherlv_5= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:419:1: (otherlv_5= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:419:1: (otherlv_5= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:420:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge849); 

            		newLeafNode(otherlv_5, grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEdge861); 

                	newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6());
                
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEdge873); 

                	newLeafNode(otherlv_7, grammarAccess.getEdgeAccess().getColonKeyword_7());
                
            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEdge885); 

                	newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getEdgeKeyword_8());
                
            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEdge897); 

                	newLeafNode(otherlv_9, grammarAccess.getEdgeAccess().getCommaKeyword_9());
                
            otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEdge909); 

                	newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getLabelKeyword_10());
                
            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEdge921); 

                	newLeafNode(otherlv_11, grammarAccess.getEdgeAccess().getEqualsSignKeyword_11());
                
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:455:1: ( (otherlv_12= RULE_ID ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:456:1: (otherlv_12= RULE_ID )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:456:1: (otherlv_12= RULE_ID )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:457:3: otherlv_12= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEdgeRule());
            	        }
                    
            otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEdge941); 

            		newLeafNode(otherlv_12, grammarAccess.getEdgeAccess().getLabelEReferenceCrossReference_12_0()); 
            	

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
    // $ANTLR end "ruleEdge"


    // $ANTLR start "ruleGraphType"
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:476:1: ruleGraphType returns [Enumerator current=null] : (enumLiteral_0= 'diagram' ) ;
    public final Enumerator ruleGraphType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:478:28: ( (enumLiteral_0= 'diagram' ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:479:1: (enumLiteral_0= 'diagram' )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:479:1: (enumLiteral_0= 'diagram' )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:479:3: enumLiteral_0= 'diagram'
            {
            enumLiteral_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleGraphType990); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:489:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:491:28: ( ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:492:1: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:492:1: ( (enumLiteral_0= 'node' ) | (enumLiteral_1= 'markednode' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:492:2: (enumLiteral_0= 'node' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:492:2: (enumLiteral_0= 'node' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:492:4: enumLiteral_0= 'node'
                    {
                    enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNodeType1034); 

                            current = grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:498:6: (enumLiteral_1= 'markednode' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:498:6: (enumLiteral_1= 'markednode' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:498:8: enumLiteral_1= 'markednode'
                    {
                    enumLiteral_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNodeType1051); 

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
    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:508:1: ruleNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) ) ;
    public final Enumerator ruleNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:510:28: ( ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) ) )
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:1: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) )
            {
            // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:1: ( (enumLiteral_0= 'circle' ) | (enumLiteral_1= 'doublecircle' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            else if ( (LA7_0==28) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:2: (enumLiteral_0= 'circle' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:2: (enumLiteral_0= 'circle' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:511:4: enumLiteral_0= 'circle'
                    {
                    enumLiteral_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNodeShape1096); 

                            current = grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:517:6: (enumLiteral_1= 'doublecircle' )
                    {
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:517:6: (enumLiteral_1= 'doublecircle' )
                    // ../wodeledu.dsls.modelgraph/src-gen/wodeledu/dsls/parser/antlr/internal/InternalModelGraph.g:517:8: enumLiteral_1= 'doublecircle'
                    {
                    enumLiteral_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNodeShape1113); 

                            current = grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                        

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorGraph_in_entryRuleMutatorGraph75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorGraph85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleMutatorGraph131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMutatorGraph152 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMutatorGraph172 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMutatorGraph184 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleGraphType_in_ruleMutatorGraph205 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorGraph217 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleNode_in_ruleMutatorGraph238 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleEdge_in_ruleMutatorGraph260 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleMutatorGraph273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_entryRuleNode432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNode442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode496 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleNode508 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_16_in_ruleNode527 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_17_in_ruleNode558 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode580 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleNode592 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNode604 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_ruleNodeType_in_ruleNode625 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleNode638 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleNode650 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleNode662 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_ruleNodeShape_in_ruleNode683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEdge_in_entryRuleEdge721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEdge731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge785 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEdge797 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge817 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleEdge829 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge849 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEdge861 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEdge873 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEdge885 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleEdge897 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEdge909 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEdge921 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEdge941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleGraphType990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleNodeType1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleNodeType1051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleNodeShape1096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleNodeShape1113 = new BitSet(new long[]{0x0000000000000002L});
    }


}