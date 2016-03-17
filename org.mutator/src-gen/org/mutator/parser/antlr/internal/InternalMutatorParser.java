package org.mutator.parser.antlr.internal; 

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
import org.mutator.services.MutatorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMutatorParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'with'", "'commands'", "'{'", "'}'", "'library'", "'for'", "'metamodel'", "'generate'", "'mutants'", "'in'", "'from'", "'all'", "'import'", "'-'", "'.'", "'E'", "'e'", "'true'", "'false'", "'self'", "'null'", "'remove'", "'['", "'..'", "']'", "'one'", "'reference'", "'='", "'create'", "','", "'select'", "'modify'", "'to'", "'source'", "'target'", "'unset'", "'('", "')'", "'swap'", "'copy'", "'reverse'", "'swapref'", "'where'", "'other'", "'random-boolean'", "'random-string'", "'upper'", "'catstart'", "'catend'", "'inside'", "'lower'", "'replace'", "'random-double'", "'random-int'", "'*'", "'and'", "'or'", "'<>'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
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


        public InternalMutatorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMutatorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMutatorParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g"; }



     	private MutatorGrammarAccess grammarAccess;
     	
        public InternalMutatorParser(TokenStream input, MutatorGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MutatorEnvironment";	
       	}
       	
       	@Override
       	protected MutatorGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMutatorEnvironment"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:68:1: entryRuleMutatorEnvironment returns [EObject current=null] : iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF ;
    public final EObject entryRuleMutatorEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorEnvironment = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:69:2: (iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:70:2: iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF
            {
             newCompositeNode(grammarAccess.getMutatorEnvironmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorEnvironment_in_entryRuleMutatorEnvironment75);
            iv_ruleMutatorEnvironment=ruleMutatorEnvironment();

            state._fsp--;

             current =iv_ruleMutatorEnvironment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorEnvironment85); 

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
    // $ANTLR end "entryRuleMutatorEnvironment"


    // $ANTLR start "ruleMutatorEnvironment"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:77:1: ruleMutatorEnvironment returns [EObject current=null] : ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleMutator ) ) ( (lv_commands_6_0= ruleMutator ) )* otherlv_7= '}' ) ;
    public final EObject ruleMutatorEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_load_0_0 = null;

        EObject lv_definition_1_0 = null;

        EObject lv_commands_5_0 = null;

        EObject lv_commands_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:80:28: ( ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleMutator ) ) ( (lv_commands_6_0= ruleMutator ) )* otherlv_7= '}' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:81:1: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleMutator ) ) ( (lv_commands_6_0= ruleMutator ) )* otherlv_7= '}' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:81:1: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleMutator ) ) ( (lv_commands_6_0= ruleMutator ) )* otherlv_7= '}' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:81:2: ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' otherlv_3= 'commands' otherlv_4= '{' ( (lv_commands_5_0= ruleMutator ) ) ( (lv_commands_6_0= ruleMutator ) )* otherlv_7= '}'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:81:2: ( (lv_load_0_0= ruleLoad ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:82:1: (lv_load_0_0= ruleLoad )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:82:1: (lv_load_0_0= ruleLoad )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:83:3: lv_load_0_0= ruleLoad
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getLoadLoadParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleLoad_in_ruleMutatorEnvironment131);
            	    lv_load_0_0=ruleLoad();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"load",
            	            		lv_load_0_0, 
            	            		"Load");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:99:3: ( (lv_definition_1_0= ruleDefinition ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:100:1: (lv_definition_1_0= ruleDefinition )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:100:1: (lv_definition_1_0= ruleDefinition )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:101:3: lv_definition_1_0= ruleDefinition
            {
             
            	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getDefinitionDefinitionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_ruleMutatorEnvironment153);
            lv_definition_1_0=ruleDefinition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_1_0, 
                    		"Definition");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleMutatorEnvironment165); 

                	newLeafNode(otherlv_2, grammarAccess.getMutatorEnvironmentAccess().getWithKeyword_2());
                
            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMutatorEnvironment177); 

                	newLeafNode(otherlv_3, grammarAccess.getMutatorEnvironmentAccess().getCommandsKeyword_3());
                
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMutatorEnvironment189); 

                	newLeafNode(otherlv_4, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:129:1: ( (lv_commands_5_0= ruleMutator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:130:1: (lv_commands_5_0= ruleMutator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:130:1: (lv_commands_5_0= ruleMutator )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:131:3: lv_commands_5_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleMutatorEnvironment210);
            lv_commands_5_0=ruleMutator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	        }
                   		add(
                   			current, 
                   			"commands",
                    		lv_commands_5_0, 
                    		"Mutator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:147:2: ( (lv_commands_6_0= ruleMutator ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=32 && LA2_0<=33)||LA2_0==39||LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:148:1: (lv_commands_6_0= ruleMutator )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:148:1: (lv_commands_6_0= ruleMutator )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:149:3: lv_commands_6_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleMutatorEnvironment231);
            	    lv_commands_6_0=ruleMutator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_6_0, 
            	            		"Mutator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorEnvironment244); 

                	newLeafNode(otherlv_7, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_7());
                

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
    // $ANTLR end "ruleMutatorEnvironment"


    // $ANTLR start "entryRuleDefinition"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:177:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:178:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:179:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_entryRuleDefinition280);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefinition290); 

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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:186:1: ruleDefinition returns [EObject current=null] : (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_Library_0 = null;

        EObject this_Program_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:189:28: ( (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:190:1: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:190:1: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:191:5: this_Library_0= ruleLibrary
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getLibraryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_ruleDefinition337);
                    this_Library_0=ruleLibrary();

                    state._fsp--;

                     
                            current = this_Library_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:201:5: this_Program_1= ruleProgram
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getProgramParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleProgram_in_ruleDefinition364);
                    this_Program_1=ruleProgram();

                    state._fsp--;

                     
                            current = this_Program_1; 
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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleLibrary"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:217:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:218:2: (iv_ruleLibrary= ruleLibrary EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:219:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_entryRuleLibrary399);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibrary409); 

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
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:226:1: ruleLibrary returns [EObject current=null] : ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_metamodel_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:229:28: ( ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:230:1: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:230:1: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:230:2: () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:230:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:231:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLibraryAccess().getLibraryAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLibrary455); 

                	newLeafNode(otherlv_1, grammarAccess.getLibraryAccess().getLibraryKeyword_1());
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLibrary467); 

                	newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getForKeyword_2());
                
            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLibrary479); 

                	newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getMetamodelKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:248:1: ( (lv_metamodel_4_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:249:1: (lv_metamodel_4_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:249:1: (lv_metamodel_4_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:250:3: lv_metamodel_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLibraryAccess().getMetamodelEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLibrary500);
            lv_metamodel_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLibraryRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_4_0, 
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
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleProgram"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:274:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:275:2: (iv_ruleProgram= ruleProgram EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:276:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram536);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram546); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:283:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) ) otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_num_2_0 = null;

        AntlrDatatypeRuleToken lv_output_5_0 = null;

        EObject lv_source_7_0 = null;

        AntlrDatatypeRuleToken lv_metamodel_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:286:28: ( ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) ) otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:287:1: ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) ) otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:287:1: ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) ) otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:287:2: () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) ) otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:287:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:288:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgramAccess().getProgramAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProgram592); 

                	newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getGenerateKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:297:1: ( (lv_num_2_0= ruleEInt ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:298:1: (lv_num_2_0= ruleEInt )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:298:1: (lv_num_2_0= ruleEInt )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:299:3: lv_num_2_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getNumEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleProgram613);
            lv_num_2_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"num",
                    		lv_num_2_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleProgram625); 

                	newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getMutantsKeyword_3());
                
            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleProgram637); 

                	newLeafNode(otherlv_4, grammarAccess.getProgramAccess().getInKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:323:1: ( (lv_output_5_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:324:1: (lv_output_5_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:324:1: (lv_output_5_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:325:3: lv_output_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getOutputEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleProgram658);
            lv_output_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"output",
                    		lv_output_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleProgram670); 

                	newLeafNode(otherlv_6, grammarAccess.getProgramAccess().getFromKeyword_6());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:345:1: ( (lv_source_7_0= ruleSource ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:346:1: (lv_source_7_0= ruleSource )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:346:1: (lv_source_7_0= ruleSource )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:347:3: lv_source_7_0= ruleSource
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getSourceSourceParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSource_in_ruleProgram691);
            lv_source_7_0=ruleSource();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_7_0, 
                    		"Source");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleProgram703); 

                	newLeafNode(otherlv_8, grammarAccess.getProgramAccess().getMetamodelKeyword_8());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:367:1: ( (lv_metamodel_9_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:368:1: (lv_metamodel_9_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:368:1: (lv_metamodel_9_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:369:3: lv_metamodel_9_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_9_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleProgram724);
            lv_metamodel_9_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_9_0, 
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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleSource"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:393:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:394:2: (iv_ruleSource= ruleSource EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:395:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSource_in_entryRuleSource760);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSource770); 

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
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:402:1: ruleSource returns [EObject current=null] : ( () ( (lv_path_1_0= ruleEString ) ) ( (lv_multiple_2_0= 'all' ) )? ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        Token lv_multiple_2_0=null;
        AntlrDatatypeRuleToken lv_path_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:405:28: ( ( () ( (lv_path_1_0= ruleEString ) ) ( (lv_multiple_2_0= 'all' ) )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:406:1: ( () ( (lv_path_1_0= ruleEString ) ) ( (lv_multiple_2_0= 'all' ) )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:406:1: ( () ( (lv_path_1_0= ruleEString ) ) ( (lv_multiple_2_0= 'all' ) )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:406:2: () ( (lv_path_1_0= ruleEString ) ) ( (lv_multiple_2_0= 'all' ) )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:406:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:407:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSourceAccess().getSourceAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:412:2: ( (lv_path_1_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:413:1: (lv_path_1_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:413:1: (lv_path_1_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:414:3: lv_path_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSourceAccess().getPathEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSource825);
            lv_path_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSourceRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:430:2: ( (lv_multiple_2_0= 'all' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:431:1: (lv_multiple_2_0= 'all' )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:431:1: (lv_multiple_2_0= 'all' )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:432:3: lv_multiple_2_0= 'all'
                    {
                    lv_multiple_2_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSource843); 

                            newLeafNode(lv_multiple_2_0, grammarAccess.getSourceAccess().getMultipleAllKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSourceRule());
                    	        }
                           		setWithLastConsumed(current, "multiple", true, "all");
                    	    

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
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:453:1: entryRuleMutator returns [EObject current=null] : iv_ruleMutator= ruleMutator EOF ;
    public final EObject entryRuleMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:454:2: (iv_ruleMutator= ruleMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:455:2: iv_ruleMutator= ruleMutator EOF
            {
             newCompositeNode(grammarAccess.getMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_entryRuleMutator893);
            iv_ruleMutator=ruleMutator();

            state._fsp--;

             current =iv_ruleMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutator903); 

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
    // $ANTLR end "entryRuleMutator"


    // $ANTLR start "ruleMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:462:1: ruleMutator returns [EObject current=null] : (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator ) ;
    public final EObject ruleMutator() throws RecognitionException {
        EObject current = null;

        EObject this_CreateObjectMutator_0 = null;

        EObject this_SelectObjectMutator_1 = null;

        EObject this_CompositeMutator_2 = null;

        EObject this_ModifySourceReferenceMutator_3 = null;

        EObject this_ModifyTargetReferenceMutator_4 = null;

        EObject this_CreateReferenceMutator_5 = null;

        EObject this_RemoveObjectMutator_6 = null;

        EObject this_RemoveReferenceMutator_7 = null;

        EObject this_ModifyInformationMutator_8 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:465:28: ( (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:466:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:466:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )
            int alt5=9;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:467:5: this_CreateObjectMutator_0= ruleCreateObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCreateObjectMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_ruleMutator950);
                    this_CreateObjectMutator_0=ruleCreateObjectMutator();

                    state._fsp--;

                     
                            current = this_CreateObjectMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:477:5: this_SelectObjectMutator_1= ruleSelectObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getSelectObjectMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_ruleMutator977);
                    this_SelectObjectMutator_1=ruleSelectObjectMutator();

                    state._fsp--;

                     
                            current = this_SelectObjectMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:487:5: this_CompositeMutator_2= ruleCompositeMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCompositeMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_ruleMutator1004);
                    this_CompositeMutator_2=ruleCompositeMutator();

                    state._fsp--;

                     
                            current = this_CompositeMutator_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:497:5: this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifySourceReferenceMutatorParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1031);
                    this_ModifySourceReferenceMutator_3=ruleModifySourceReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifySourceReferenceMutator_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:507:5: this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyTargetReferenceMutatorParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1058);
                    this_ModifyTargetReferenceMutator_4=ruleModifyTargetReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifyTargetReferenceMutator_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:517:5: this_CreateReferenceMutator_5= ruleCreateReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCreateReferenceMutatorParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1085);
                    this_CreateReferenceMutator_5=ruleCreateReferenceMutator();

                    state._fsp--;

                     
                            current = this_CreateReferenceMutator_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:527:5: this_RemoveObjectMutator_6= ruleRemoveObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveObjectMutatorParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1112);
                    this_RemoveObjectMutator_6=ruleRemoveObjectMutator();

                    state._fsp--;

                     
                            current = this_RemoveObjectMutator_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:537:5: this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveReferenceMutatorParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1139);
                    this_RemoveReferenceMutator_7=ruleRemoveReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveReferenceMutator_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:547:5: this_ModifyInformationMutator_8= ruleModifyInformationMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyInformationMutatorParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_ruleMutator1166);
                    this_ModifyInformationMutator_8=ruleModifyInformationMutator();

                    state._fsp--;

                     
                            current = this_ModifyInformationMutator_8; 
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
    // $ANTLR end "ruleMutator"


    // $ANTLR start "entryRuleObSelectionStrategy"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:563:1: entryRuleObSelectionStrategy returns [EObject current=null] : iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF ;
    public final EObject entryRuleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObSelectionStrategy = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:564:2: (iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:565:2: iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF
            {
             newCompositeNode(grammarAccess.getObSelectionStrategyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1201);
            iv_ruleObSelectionStrategy=ruleObSelectionStrategy();

            state._fsp--;

             current =iv_ruleObSelectionStrategy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObSelectionStrategy1211); 

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
    // $ANTLR end "entryRuleObSelectionStrategy"


    // $ANTLR start "ruleObSelectionStrategy"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:572:1: ruleObSelectionStrategy returns [EObject current=null] : (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) ;
    public final EObject ruleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_RandomSelection_0 = null;

        EObject this_SpecificSelection_1 = null;

        EObject this_CompleteSelection_2 = null;

        EObject this_OtherSelection_3 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:575:28: ( (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:576:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:576:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            case 54:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:577:5: this_RandomSelection_0= ruleRandomSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getRandomSelectionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1258);
                    this_RandomSelection_0=ruleRandomSelection();

                    state._fsp--;

                     
                            current = this_RandomSelection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:587:5: this_SpecificSelection_1= ruleSpecificSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSpecificSelectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy1285);
                    this_SpecificSelection_1=ruleSpecificSelection();

                    state._fsp--;

                     
                            current = this_SpecificSelection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:597:5: this_CompleteSelection_2= ruleCompleteSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getCompleteSelectionParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy1312);
                    this_CompleteSelection_2=ruleCompleteSelection();

                    state._fsp--;

                     
                            current = this_CompleteSelection_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:607:5: this_OtherSelection_3= ruleOtherSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getOtherSelectionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy1339);
                    this_OtherSelection_3=ruleOtherSelection();

                    state._fsp--;

                     
                            current = this_OtherSelection_3; 
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
    // $ANTLR end "ruleObSelectionStrategy"


    // $ANTLR start "entryRuleRandomSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:623:1: entryRuleRandomSelection returns [EObject current=null] : iv_ruleRandomSelection= ruleRandomSelection EOF ;
    public final EObject entryRuleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:624:2: (iv_ruleRandomSelection= ruleRandomSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:625:2: iv_ruleRandomSelection= ruleRandomSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection1374);
            iv_ruleRandomSelection=ruleRandomSelection();

            state._fsp--;

             current =iv_ruleRandomSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomSelection1384); 

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
    // $ANTLR end "entryRuleRandomSelection"


    // $ANTLR start "ruleRandomSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:632:1: ruleRandomSelection returns [EObject current=null] : this_RandomTypeSelection_0= ruleRandomTypeSelection ;
    public final EObject ruleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject this_RandomTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:635:28: (this_RandomTypeSelection_0= ruleRandomTypeSelection )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:637:5: this_RandomTypeSelection_0= ruleRandomTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getRandomSelectionAccess().getRandomTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection1430);
            this_RandomTypeSelection_0=ruleRandomTypeSelection();

            state._fsp--;

             
                    current = this_RandomTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleRandomSelection"


    // $ANTLR start "entryRuleSpecificSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:653:1: entryRuleSpecificSelection returns [EObject current=null] : iv_ruleSpecificSelection= ruleSpecificSelection EOF ;
    public final EObject entryRuleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:654:2: (iv_ruleSpecificSelection= ruleSpecificSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:655:2: iv_ruleSpecificSelection= ruleSpecificSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection1464);
            iv_ruleSpecificSelection=ruleSpecificSelection();

            state._fsp--;

             current =iv_ruleSpecificSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificSelection1474); 

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
    // $ANTLR end "entryRuleSpecificSelection"


    // $ANTLR start "ruleSpecificSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:662:1: ruleSpecificSelection returns [EObject current=null] : this_SpecificObjectSelection_0= ruleSpecificObjectSelection ;
    public final EObject ruleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificObjectSelection_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:665:28: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:667:5: this_SpecificObjectSelection_0= ruleSpecificObjectSelection
            {
             
                    newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificObjectSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection1520);
            this_SpecificObjectSelection_0=ruleSpecificObjectSelection();

            state._fsp--;

             
                    current = this_SpecificObjectSelection_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleSpecificSelection"


    // $ANTLR start "entryRuleCompleteSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:683:1: entryRuleCompleteSelection returns [EObject current=null] : iv_ruleCompleteSelection= ruleCompleteSelection EOF ;
    public final EObject entryRuleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:684:2: (iv_ruleCompleteSelection= ruleCompleteSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:685:2: iv_ruleCompleteSelection= ruleCompleteSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection1554);
            iv_ruleCompleteSelection=ruleCompleteSelection();

            state._fsp--;

             current =iv_ruleCompleteSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteSelection1564); 

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
    // $ANTLR end "entryRuleCompleteSelection"


    // $ANTLR start "ruleCompleteSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:692:1: ruleCompleteSelection returns [EObject current=null] : this_CompleteTypeSelection_0= ruleCompleteTypeSelection ;
    public final EObject ruleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject this_CompleteTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:695:28: (this_CompleteTypeSelection_0= ruleCompleteTypeSelection )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:697:5: this_CompleteTypeSelection_0= ruleCompleteTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getCompleteSelectionAccess().getCompleteTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection1610);
            this_CompleteTypeSelection_0=ruleCompleteTypeSelection();

            state._fsp--;

             
                    current = this_CompleteTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleCompleteSelection"


    // $ANTLR start "entryRuleOtherSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:713:1: entryRuleOtherSelection returns [EObject current=null] : iv_ruleOtherSelection= ruleOtherSelection EOF ;
    public final EObject entryRuleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:714:2: (iv_ruleOtherSelection= ruleOtherSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:715:2: iv_ruleOtherSelection= ruleOtherSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection1644);
            iv_ruleOtherSelection=ruleOtherSelection();

            state._fsp--;

             current =iv_ruleOtherSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherSelection1654); 

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
    // $ANTLR end "entryRuleOtherSelection"


    // $ANTLR start "ruleOtherSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:722:1: ruleOtherSelection returns [EObject current=null] : this_OtherTypeSelection_0= ruleOtherTypeSelection ;
    public final EObject ruleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject this_OtherTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:725:28: (this_OtherTypeSelection_0= ruleOtherTypeSelection )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:727:5: this_OtherTypeSelection_0= ruleOtherTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getOtherSelectionAccess().getOtherTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection1700);
            this_OtherTypeSelection_0=ruleOtherTypeSelection();

            state._fsp--;

             
                    current = this_OtherTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleOtherSelection"


    // $ANTLR start "entryRuleAttributeType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:743:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:744:2: (iv_ruleAttributeType= ruleAttributeType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:745:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_entryRuleAttributeType1734);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeType1744); 

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
    // $ANTLR end "entryRuleAttributeType"


    // $ANTLR start "ruleAttributeType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:752:1: ruleAttributeType returns [EObject current=null] : (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType ) ;
    public final EObject ruleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerType_0 = null;

        EObject this_BooleanType_1 = null;

        EObject this_StringType_2 = null;

        EObject this_DoubleType_3 = null;

        EObject this_ListStringType_4 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:755:28: ( (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:756:1: (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:756:1: (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==EOF||LA7_2==14||LA7_2==40||(LA7_2>=66 && LA7_2<=67)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_2==25) ) {
                        alt7=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==25) ) {
                    alt7=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EOF||LA7_2==14||LA7_2==40||(LA7_2>=66 && LA7_2<=67)) ) {
                    alt7=1;
                }
                else if ( (LA7_2==25) ) {
                    alt7=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case 64:
                {
                alt7=1;
                }
                break;
            case 28:
            case 29:
            case 55:
                {
                alt7=2;
                }
                break;
            case RULE_STRING:
            case 56:
            case 57:
            case 58:
            case 59:
            case 61:
            case 62:
                {
                alt7=3;
                }
                break;
            case 25:
            case 63:
                {
                alt7=4;
                }
                break;
            case 60:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:757:5: this_IntegerType_0= ruleIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_ruleAttributeType1791);
                    this_IntegerType_0=ruleIntegerType();

                    state._fsp--;

                     
                            current = this_IntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:767:5: this_BooleanType_1= ruleBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_ruleAttributeType1818);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;

                     
                            current = this_BooleanType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:777:5: this_StringType_2= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringType_in_ruleAttributeType1845);
                    this_StringType_2=ruleStringType();

                    state._fsp--;

                     
                            current = this_StringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:787:5: this_DoubleType_3= ruleDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getDoubleTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_ruleAttributeType1872);
                    this_DoubleType_3=ruleDoubleType();

                    state._fsp--;

                     
                            current = this_DoubleType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:797:5: this_ListStringType_4= ruleListStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_ruleAttributeType1899);
                    this_ListStringType_4=ruleListStringType();

                    state._fsp--;

                     
                            current = this_ListStringType_4; 
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
    // $ANTLR end "ruleAttributeType"


    // $ANTLR start "entryRuleLoad"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:813:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:814:2: (iv_ruleLoad= ruleLoad EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:815:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoad_in_entryRuleLoad1934);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoad1944); 

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
    // $ANTLR end "entryRuleLoad"


    // $ANTLR start "ruleLoad"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:822:1: ruleLoad returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_file_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:825:28: ( ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:826:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:826:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:826:2: () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:826:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:827:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLoadAccess().getLoadAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLoad1990); 

                	newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getImportKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:836:1: ( (lv_file_2_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:837:1: (lv_file_2_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:837:1: (lv_file_2_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:838:3: lv_file_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLoad2011);
            lv_file_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLoadRule());
            	        }
                   		set(
                   			current, 
                   			"file",
                    		lv_file_2_0, 
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
    // $ANTLR end "ruleLoad"


    // $ANTLR start "entryRuleEString"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:862:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:863:2: (iv_ruleEString= ruleEString EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:864:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString2048);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString2059); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:871:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:874:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:875:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:875:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:875:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString2099); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:883:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString2125); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:898:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:899:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:900:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt2171);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt2182); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:907:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:910:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:911:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:911:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:911:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:911:2: (kw= '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:912:2: kw= '-'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEInt2221); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt2238); 

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


    // $ANTLR start "entryRuleEDouble"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:932:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:933:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:934:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble2284);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble2295); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:941:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:944:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:945:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:945:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:945:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:945:2: (kw= '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:946:2: kw= '-'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEDouble2334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:951:3: (this_INT_1= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_INT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:951:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2352); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEDouble2372); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2387); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:971:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=26 && LA14_0<=27)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:971:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:971:2: (kw= 'E' | kw= 'e' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==26) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==27) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:972:2: kw= 'E'
                            {
                            kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEDouble2407); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:979:2: kw= 'e'
                            {
                            kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEDouble2426); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:984:2: (kw= '-' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==24) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:985:2: kw= '-'
                            {
                            kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEDouble2441); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2458); 

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


    // $ANTLR start "entryRuleEBoolean"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1005:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1006:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1007:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean2506);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean2517); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1014:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1017:28: ( (kw= 'true' | kw= 'false' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1018:1: (kw= 'true' | kw= 'false' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1018:1: (kw= 'true' | kw= 'false' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            else if ( (LA15_0==29) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1019:2: kw= 'true'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEBoolean2555); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1026:2: kw= 'false'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEBoolean2574); 

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


    // $ANTLR start "entryRuleBinaryOperator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1039:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1040:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1041:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator2614);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperator2624); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1048:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1051:28: ( ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1052:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1052:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1052:2: () ( (lv_type_1_0= ruleLogicOperator ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1052:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1053:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1058:2: ( (lv_type_1_0= ruleLogicOperator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1059:1: (lv_type_1_0= ruleLogicOperator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1059:1: (lv_type_1_0= ruleLogicOperator )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1060:3: lv_type_1_0= ruleLogicOperator
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLogicOperator_in_ruleBinaryOperator2679);
            lv_type_1_0=ruleLogicOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"LogicOperator");
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


    // $ANTLR start "entryRuleAttributeEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1084:1: entryRuleAttributeEvaluation returns [EObject current=null] : iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF ;
    public final EObject entryRuleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluation = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1085:2: (iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1086:2: iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation2715);
            iv_ruleAttributeEvaluation=ruleAttributeEvaluation();

            state._fsp--;

             current =iv_ruleAttributeEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluation2725); 

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
    // $ANTLR end "entryRuleAttributeEvaluation"


    // $ANTLR start "ruleAttributeEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1093:1: ruleAttributeEvaluation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_operator_2_0= ruleOperator ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_operator_2_0 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1096:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_operator_2_0= ruleOperator ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1097:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_operator_2_0= ruleOperator ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1097:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_operator_2_0= ruleOperator ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1097:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_operator_2_0= ruleOperator ) ) ( (lv_value_3_0= ruleAttributeType ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1097:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1098:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeEvaluationAccess().getAttributeEvaluationAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1103:2: ( (otherlv_1= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1104:1: (otherlv_1= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1104:1: (otherlv_1= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1105:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeEvaluationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeEvaluation2779); 

            		newLeafNode(otherlv_1, grammarAccess.getAttributeEvaluationAccess().getNameEAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1116:2: ( (lv_operator_2_0= ruleOperator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1117:1: (lv_operator_2_0= ruleOperator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1117:1: (lv_operator_2_0= ruleOperator )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1118:3: lv_operator_2_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getOperatorOperatorEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleAttributeEvaluation2800);
            lv_operator_2_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_2_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1134:2: ( (lv_value_3_0= ruleAttributeType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1135:1: (lv_value_3_0= ruleAttributeType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1135:1: (lv_value_3_0= ruleAttributeType )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1136:3: lv_value_3_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getValueAttributeTypeParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeEvaluation2821);
            lv_value_3_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"AttributeType");
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
    // $ANTLR end "ruleAttributeEvaluation"


    // $ANTLR start "entryRuleReferenceEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1160:1: entryRuleReferenceEvaluation returns [EObject current=null] : iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF ;
    public final EObject entryRuleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceEvaluation = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1161:2: (iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1162:2: iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF
            {
             newCompositeNode(grammarAccess.getReferenceEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation2857);
            iv_ruleReferenceEvaluation=ruleReferenceEvaluation();

            state._fsp--;

             current =iv_ruleReferenceEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceEvaluation2867); 

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
    // $ANTLR end "entryRuleReferenceEvaluation"


    // $ANTLR start "ruleReferenceEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1169:1: ruleReferenceEvaluation returns [EObject current=null] : ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) ) ;
    public final EObject ruleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_operator_3_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1172:28: ( ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1173:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1173:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1173:2: () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1173:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1174:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceEvaluationAccess().getReferenceEvaluationAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1179:2: ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            else if ( (LA16_0==30) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1179:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1179:3: ( (otherlv_1= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1180:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1180:1: (otherlv_1= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1181:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation2922); 

                    		newLeafNode(otherlv_1, grammarAccess.getReferenceEvaluationAccess().getNameEReferenceCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1193:7: otherlv_2= 'self'
                    {
                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleReferenceEvaluation2940); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferenceEvaluationAccess().getSelfKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1197:2: ( (lv_operator_3_0= ruleOperator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1198:1: (lv_operator_3_0= ruleOperator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1198:1: (lv_operator_3_0= ruleOperator )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1199:3: lv_operator_3_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getOperatorOperatorEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReferenceEvaluation2962);
            lv_operator_3_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1215:2: ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||LA18_0==22||LA18_0==36||LA18_0==54) ) {
                alt18=1;
            }
            else if ( (LA18_0==31) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1215:3: ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1215:3: ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1215:4: ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1215:4: ( (lv_value_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1216:1: (lv_value_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1216:1: (lv_value_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1217:3: lv_value_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getValueObSelectionStrategyParserRuleCall_3_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation2985);
                    lv_value_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1233:2: (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==25) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1233:4: otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
                            {
                            otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleReferenceEvaluation2998); 

                                	newLeafNode(otherlv_5, grammarAccess.getReferenceEvaluationAccess().getFullStopKeyword_3_0_1_0());
                                
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1237:1: ( (otherlv_6= RULE_ID ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1238:1: (otherlv_6= RULE_ID )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1238:1: (otherlv_6= RULE_ID )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1239:3: otherlv_6= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                            	        }
                                    
                            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation3018); 

                            		newLeafNode(otherlv_6, grammarAccess.getReferenceEvaluationAccess().getRefTypeEReferenceCrossReference_3_0_1_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1251:7: otherlv_7= 'null'
                    {
                    otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleReferenceEvaluation3039); 

                        	newLeafNode(otherlv_7, grammarAccess.getReferenceEvaluationAccess().getNullKeyword_3_1());
                        

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
    // $ANTLR end "ruleReferenceEvaluation"


    // $ANTLR start "entryRuleEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1263:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1264:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1265:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_entryRuleEvaluation3076);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvaluation3086); 

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
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1272:1: ruleEvaluation returns [EObject current=null] : (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeEvaluation_0 = null;

        EObject this_ReferenceEvaluation_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1275:28: ( (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1276:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1276:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==38) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==RULE_STRING||LA19_3==RULE_INT||(LA19_3>=24 && LA19_3<=25)||(LA19_3>=28 && LA19_3<=29)||(LA19_3>=55 && LA19_3<=64)) ) {
                        alt19=1;
                    }
                    else if ( (LA19_3==RULE_ID||LA19_3==22||LA19_3==31||LA19_3==36||LA19_3==54) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA19_1==68) ) {
                    int LA19_4 = input.LA(3);

                    if ( (LA19_4==RULE_ID||LA19_4==22||LA19_4==31||LA19_4==36||LA19_4==54) ) {
                        alt19=2;
                    }
                    else if ( (LA19_4==RULE_STRING||LA19_4==RULE_INT||(LA19_4>=24 && LA19_4<=25)||(LA19_4>=28 && LA19_4<=29)||(LA19_4>=55 && LA19_4<=64)) ) {
                        alt19=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1277:5: this_AttributeEvaluation_0= ruleAttributeEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getAttributeEvaluationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation3133);
                    this_AttributeEvaluation_0=ruleAttributeEvaluation();

                    state._fsp--;

                     
                            current = this_AttributeEvaluation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1287:5: this_ReferenceEvaluation_1= ruleReferenceEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getReferenceEvaluationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation3160);
                    this_ReferenceEvaluation_1=ruleReferenceEvaluation();

                    state._fsp--;

                     
                            current = this_ReferenceEvaluation_1; 
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
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1303:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1304:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1305:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression3195);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression3205); 

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
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1312:1: ruleExpression returns [EObject current=null] : ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_operator_2_0 = null;

        EObject lv_second_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1315:28: ( ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1316:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1316:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1316:2: () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1316:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1317:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getExpressionAccess().getExpressionAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1322:2: ( (lv_first_1_0= ruleEvaluation ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1323:1: (lv_first_1_0= ruleEvaluation )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1323:1: (lv_first_1_0= ruleEvaluation )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1324:3: lv_first_1_0= ruleEvaluation
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getFirstEvaluationParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression3260);
            lv_first_1_0=ruleEvaluation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_1_0, 
                    		"Evaluation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1340:2: ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=66 && LA20_0<=67)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1340:3: ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1340:3: ( (lv_operator_2_0= ruleBinaryOperator ) )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1341:1: (lv_operator_2_0= ruleBinaryOperator )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1341:1: (lv_operator_2_0= ruleBinaryOperator )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1342:3: lv_operator_2_0= ruleBinaryOperator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getOperatorBinaryOperatorParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_ruleExpression3282);
            	    lv_operator_2_0=ruleBinaryOperator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operator",
            	            		lv_operator_2_0, 
            	            		"BinaryOperator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1358:2: ( (lv_second_3_0= ruleEvaluation ) )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1359:1: (lv_second_3_0= ruleEvaluation )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1359:1: (lv_second_3_0= ruleEvaluation )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1360:3: lv_second_3_0= ruleEvaluation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getSecondEvaluationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression3303);
            	    lv_second_3_0=ruleEvaluation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"second",
            	            		lv_second_3_0, 
            	            		"Evaluation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleRemoveObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1384:1: entryRuleRemoveObjectMutator returns [EObject current=null] : iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF ;
    public final EObject entryRuleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveObjectMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1385:2: (iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1386:2: iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator3341);
            iv_ruleRemoveObjectMutator=ruleRemoveObjectMutator();

            state._fsp--;

             current =iv_ruleRemoveObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveObjectMutator3351); 

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
    // $ANTLR end "entryRuleRemoveObjectMutator"


    // $ANTLR start "ruleRemoveObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1393:1: ruleRemoveObjectMutator returns [EObject current=null] : ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? ) ;
    public final EObject ruleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_object_2_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1396:28: ( ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1397:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1397:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1397:2: () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1397:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1398:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveObjectMutatorAccess().getRemoveObjectMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRemoveObjectMutator3397); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveObjectMutatorAccess().getRemoveKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1407:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1408:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1408:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1409:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator3418);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_2_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1425:2: (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_INT||LA22_1==24||LA22_1==65) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1425:4: otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleRemoveObjectMutator3431); 

                        	newLeafNode(otherlv_3, grammarAccess.getRemoveObjectMutatorAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1429:1: ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==24) ) {
                        int LA21_1 = input.LA(2);

                        if ( (LA21_1==RULE_INT) ) {
                            int LA21_2 = input.LA(3);

                            if ( (LA21_2==34) ) {
                                alt21=1;
                            }
                        }
                    }
                    else if ( (LA21_0==RULE_INT) ) {
                        int LA21_2 = input.LA(2);

                        if ( (LA21_2==34) ) {
                            alt21=1;
                        }
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1429:2: ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1429:2: ( (lv_min_4_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1430:1: (lv_min_4_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1430:1: (lv_min_4_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1431:3: lv_min_4_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMinEIntParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveObjectMutator3453);
                            lv_min_4_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_4_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRemoveObjectMutator3465); 

                                	newLeafNode(otherlv_5, grammarAccess.getRemoveObjectMutatorAccess().getFullStopFullStopKeyword_3_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1451:3: ( (lv_max_6_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1452:1: (lv_max_6_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1452:1: (lv_max_6_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1453:3: lv_max_6_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator3488);
                    lv_max_6_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_6_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRemoveObjectMutator3500); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveObjectMutatorAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleRemoveObjectMutator"


    // $ANTLR start "entryRuleRemoveReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1481:1: entryRuleRemoveReferenceMutator returns [EObject current=null] : iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF ;
    public final EObject entryRuleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1482:2: (iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1483:2: iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator3538);
            iv_ruleRemoveReferenceMutator=ruleRemoveReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveReferenceMutator3548); 

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
    // $ANTLR end "entryRuleRemoveReferenceMutator"


    // $ANTLR start "ruleRemoveReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1490:1: ruleRemoveReferenceMutator returns [EObject current=null] : (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) ;
    public final EObject ruleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveRandomReferenceMutator_0 = null;

        EObject this_RemoveSpecificReferenceMutator_1 = null;

        EObject this_RemoveCompleteReferenceMutator_2 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1493:28: ( (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1494:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1494:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                switch ( input.LA(2) ) {
                case 36:
                    {
                    alt23=1;
                    }
                    break;
                case 22:
                    {
                    alt23=3;
                    }
                    break;
                case 37:
                    {
                    alt23=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1495:5: this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveRandomReferenceMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator3595);
                    this_RemoveRandomReferenceMutator_0=ruleRemoveRandomReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveRandomReferenceMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1505:5: this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveSpecificReferenceMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator3622);
                    this_RemoveSpecificReferenceMutator_1=ruleRemoveSpecificReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveSpecificReferenceMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1515:5: this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveCompleteReferenceMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator3649);
                    this_RemoveCompleteReferenceMutator_2=ruleRemoveCompleteReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveCompleteReferenceMutator_2; 
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
    // $ANTLR end "ruleRemoveReferenceMutator"


    // $ANTLR start "entryRuleRemoveRandomReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1531:1: entryRuleRemoveRandomReferenceMutator returns [EObject current=null] : iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF ;
    public final EObject entryRuleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveRandomReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1532:2: (iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1533:2: iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator3684);
            iv_ruleRemoveRandomReferenceMutator=ruleRemoveRandomReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveRandomReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator3694); 

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
    // $ANTLR end "entryRuleRemoveRandomReferenceMutator"


    // $ANTLR start "ruleRemoveRandomReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1540:1: ruleRemoveRandomReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1543:28: ( ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1544:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1544:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1544:2: () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1544:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1545:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveRandomReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRemoveRandomReferenceMutator3740); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleRemoveRandomReferenceMutator3752); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveRandomReferenceMutatorAccess().getOneKeyword_2());
                
            otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleRemoveRandomReferenceMutator3764); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveRandomReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1562:1: ( (otherlv_4= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1563:1: (otherlv_4= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1563:1: (otherlv_4= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1564:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator3784); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRemoveRandomReferenceMutator3796); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveRandomReferenceMutatorAccess().getInKeyword_5());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1579:1: ( (otherlv_6= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1580:1: (otherlv_6= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1580:1: (otherlv_6= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1581:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator3816); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveRandomReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1592:2: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_INT||LA25_1==24||LA25_1==65) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1592:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleRemoveRandomReferenceMutator3829); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveRandomReferenceMutatorAccess().getLeftSquareBracketKeyword_7_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1596:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==24) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==RULE_INT) ) {
                            int LA24_2 = input.LA(3);

                            if ( (LA24_2==34) ) {
                                alt24=1;
                            }
                        }
                    }
                    else if ( (LA24_0==RULE_INT) ) {
                        int LA24_2 = input.LA(2);

                        if ( (LA24_2==34) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1596:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1596:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1597:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1597:1: (lv_min_8_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1598:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMinEIntParserRuleCall_7_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator3851);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRemoveRandomReferenceMutator3863); 

                                	newLeafNode(otherlv_9, grammarAccess.getRemoveRandomReferenceMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1618:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1619:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1619:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1620:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator3886);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRemoveRandomReferenceMutator3898); 

                        	newLeafNode(otherlv_11, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRightSquareBracketKeyword_7_3());
                        

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
    // $ANTLR end "ruleRemoveRandomReferenceMutator"


    // $ANTLR start "entryRuleRemoveSpecificReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1648:1: entryRuleRemoveSpecificReferenceMutator returns [EObject current=null] : iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF ;
    public final EObject entryRuleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveSpecificReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1649:2: (iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1650:2: iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator3936);
            iv_ruleRemoveSpecificReferenceMutator=ruleRemoveSpecificReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveSpecificReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator3946); 

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
    // $ANTLR end "entryRuleRemoveSpecificReferenceMutator"


    // $ANTLR start "ruleRemoveSpecificReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1657:1: ruleRemoveSpecificReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
    public final EObject ruleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_container_5_0 = null;

        AntlrDatatypeRuleToken lv_min_7_0 = null;

        AntlrDatatypeRuleToken lv_max_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1660:28: ( ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1661:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1661:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1661:2: () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1661:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1662:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveSpecificReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRemoveSpecificReferenceMutator3992); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleRemoveSpecificReferenceMutator4004); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1675:1: ( (otherlv_3= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1676:1: (otherlv_3= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1676:1: (otherlv_3= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1677:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator4024); 

            		newLeafNode(otherlv_3, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRemoveSpecificReferenceMutator4036); 

                	newLeafNode(otherlv_4, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getInKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1692:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1693:1: (lv_container_5_0= ruleObSelectionStrategy )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1693:1: (lv_container_5_0= ruleObSelectionStrategy )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1694:3: lv_container_5_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getContainerObSelectionStrategyParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator4057);
            lv_container_5_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"container",
                    		lv_container_5_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1710:2: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==RULE_INT||LA27_1==24||LA27_1==65) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1710:4: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleRemoveSpecificReferenceMutator4070); 

                        	newLeafNode(otherlv_6, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1714:1: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==24) ) {
                        int LA26_1 = input.LA(2);

                        if ( (LA26_1==RULE_INT) ) {
                            int LA26_2 = input.LA(3);

                            if ( (LA26_2==34) ) {
                                alt26=1;
                            }
                        }
                    }
                    else if ( (LA26_0==RULE_INT) ) {
                        int LA26_2 = input.LA(2);

                        if ( (LA26_2==34) ) {
                            alt26=1;
                        }
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1714:2: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1714:2: ( (lv_min_7_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1715:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1715:1: (lv_min_7_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1716:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator4092);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRemoveSpecificReferenceMutator4104); 

                                	newLeafNode(otherlv_8, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1736:3: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1737:1: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1737:1: (lv_max_9_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1738:3: lv_max_9_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator4127);
                    lv_max_9_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_9_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRemoveSpecificReferenceMutator4139); 

                        	newLeafNode(otherlv_10, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRightSquareBracketKeyword_6_3());
                        

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
    // $ANTLR end "ruleRemoveSpecificReferenceMutator"


    // $ANTLR start "entryRuleRemoveCompleteReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1766:1: entryRuleRemoveCompleteReferenceMutator returns [EObject current=null] : iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF ;
    public final EObject entryRuleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveCompleteReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1767:2: (iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1768:2: iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveCompleteReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator4177);
            iv_ruleRemoveCompleteReferenceMutator=ruleRemoveCompleteReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveCompleteReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator4187); 

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
    // $ANTLR end "entryRuleRemoveCompleteReferenceMutator"


    // $ANTLR start "ruleRemoveCompleteReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1775:1: ruleRemoveCompleteReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1778:28: ( ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1779:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1779:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1779:2: () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1779:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1780:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveCompleteReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRemoveCompleteReferenceMutator4233); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveCompleteReferenceMutator4245); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getAllKeyword_2());
                
            otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleRemoveCompleteReferenceMutator4257); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1797:1: ( (otherlv_4= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1798:1: (otherlv_4= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1798:1: (otherlv_4= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1799:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4277); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRemoveCompleteReferenceMutator4289); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getInKeyword_5());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1814:1: ( (otherlv_6= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1815:1: (otherlv_6= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1815:1: (otherlv_6= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1816:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4309); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

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
    // $ANTLR end "ruleRemoveCompleteReferenceMutator"


    // $ANTLR start "entryRuleCreateObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1835:1: entryRuleCreateObjectMutator returns [EObject current=null] : iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF ;
    public final EObject entryRuleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateObjectMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1836:2: (iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1837:2: iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator4345);
            iv_ruleCreateObjectMutator=ruleCreateObjectMutator();

            state._fsp--;

             current =iv_ruleCreateObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateObjectMutator4355); 

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
    // $ANTLR end "entryRuleCreateObjectMutator"


    // $ANTLR start "ruleCreateObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1844:1: ruleCreateObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) ;
    public final EObject ruleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_container_5_0 = null;

        EObject lv_attributes_10_0 = null;

        EObject lv_references_11_0 = null;

        EObject lv_attributes_13_0 = null;

        EObject lv_references_14_0 = null;

        AntlrDatatypeRuleToken lv_min_17_0 = null;

        AntlrDatatypeRuleToken lv_max_19_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1847:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1848:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1849:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1849:1: (lv_name_0_0= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1850:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator4398); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCreateObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCreateObjectMutator4415); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleCreateObjectMutator4429); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateObjectMutatorAccess().getCreateKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1874:1: ( (otherlv_3= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1875:1: (otherlv_3= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1875:1: (otherlv_3= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1876:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator4449); 

            		newLeafNode(otherlv_3, grammarAccess.getCreateObjectMutatorAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1887:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==20) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1887:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCreateObjectMutator4462); 

                        	newLeafNode(otherlv_4, grammarAccess.getCreateObjectMutatorAccess().getInKeyword_3_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1891:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1892:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1892:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1893:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator4483);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1909:2: (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==25) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1909:4: otherlv_6= '.' ( (otherlv_7= RULE_ID ) )
                            {
                            otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCreateObjectMutator4496); 

                                	newLeafNode(otherlv_6, grammarAccess.getCreateObjectMutatorAccess().getFullStopKeyword_3_2_0());
                                
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1913:1: ( (otherlv_7= RULE_ID ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1914:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1914:1: (otherlv_7= RULE_ID )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1915:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator4516); 

                            		newLeafNode(otherlv_7, grammarAccess.getCreateObjectMutatorAccess().getRefTypeEReferenceCrossReference_3_2_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1926:6: (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==11) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1926:8: otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}'
                    {
                    otherlv_8=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCreateObjectMutator4533); 

                        	newLeafNode(otherlv_8, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0());
                        
                    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreateObjectMutator4545); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1934:1: ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )?
                    int alt31=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA31_1 = input.LA(2);

                            if ( (LA31_1==38) ) {
                                int LA31_5 = input.LA(3);

                                if ( (LA31_5==RULE_ID||LA31_5==22||LA31_5==36||LA31_5==54) ) {
                                    alt31=2;
                                }
                                else if ( (LA31_5==RULE_STRING||LA31_5==RULE_INT||(LA31_5>=24 && LA31_5<=25)||(LA31_5>=28 && LA31_5<=29)||(LA31_5>=55 && LA31_5<=64)) ) {
                                    alt31=1;
                                }
                            }
                            }
                            break;
                        case 46:
                        case 49:
                        case 50:
                        case 51:
                            {
                            alt31=1;
                            }
                            break;
                        case 52:
                            {
                            alt31=2;
                            }
                            break;
                    }

                    switch (alt31) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1934:2: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1934:2: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1935:1: (lv_attributes_10_0= ruleAttributeSet )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1935:1: (lv_attributes_10_0= ruleAttributeSet )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1936:3: lv_attributes_10_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator4567);
                            lv_attributes_10_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_10_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1953:6: ( (lv_references_11_0= ruleReferenceSet ) )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1953:6: ( (lv_references_11_0= ruleReferenceSet ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1954:1: (lv_references_11_0= ruleReferenceSet )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1954:1: (lv_references_11_0= ruleReferenceSet )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1955:3: lv_references_11_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator4594);
                            lv_references_11_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_11_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1971:4: (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==40) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1971:6: otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleCreateObjectMutator4609); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getCreateObjectMutatorAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1975:1: ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    int alt32=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        int LA32_1 = input.LA(2);

                    	        if ( (LA32_1==38) ) {
                    	            int LA32_4 = input.LA(3);

                    	            if ( (LA32_4==RULE_STRING||LA32_4==RULE_INT||(LA32_4>=24 && LA32_4<=25)||(LA32_4>=28 && LA32_4<=29)||(LA32_4>=55 && LA32_4<=64)) ) {
                    	                alt32=1;
                    	            }
                    	            else if ( (LA32_4==RULE_ID||LA32_4==22||LA32_4==36||LA32_4==54) ) {
                    	                alt32=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 32, 4, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 32, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case 46:
                    	    case 49:
                    	    case 50:
                    	    case 51:
                    	        {
                    	        alt32=1;
                    	        }
                    	        break;
                    	    case 52:
                    	        {
                    	        alt32=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 32, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt32) {
                    	        case 1 :
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1975:2: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1975:2: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1976:1: (lv_attributes_13_0= ruleAttributeSet )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1976:1: (lv_attributes_13_0= ruleAttributeSet )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1977:3: lv_attributes_13_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator4631);
                    	            lv_attributes_13_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_13_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1994:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1994:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1995:1: (lv_references_14_0= ruleReferenceSet )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1995:1: (lv_references_14_0= ruleReferenceSet )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:1996:3: lv_references_14_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator4658);
                    	            lv_references_14_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_14_0, 
                    	                    		"ReferenceSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreateObjectMutator4673); 

                        	newLeafNode(otherlv_15, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2016:3: (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==33) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==RULE_INT||LA36_1==24||LA36_1==65) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2016:5: otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']'
                    {
                    otherlv_16=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCreateObjectMutator4688); 

                        	newLeafNode(otherlv_16, grammarAccess.getCreateObjectMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2020:1: ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==24) ) {
                        int LA35_1 = input.LA(2);

                        if ( (LA35_1==RULE_INT) ) {
                            int LA35_2 = input.LA(3);

                            if ( (LA35_2==34) ) {
                                alt35=1;
                            }
                        }
                    }
                    else if ( (LA35_0==RULE_INT) ) {
                        int LA35_2 = input.LA(2);

                        if ( (LA35_2==34) ) {
                            alt35=1;
                        }
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2020:2: ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2020:2: ( (lv_min_17_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2021:1: (lv_min_17_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2021:1: (lv_min_17_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2022:3: lv_min_17_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateObjectMutator4710);
                            lv_min_17_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_17_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_18=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCreateObjectMutator4722); 

                                	newLeafNode(otherlv_18, grammarAccess.getCreateObjectMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2042:3: ( (lv_max_19_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2043:1: (lv_max_19_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2043:1: (lv_max_19_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2044:3: lv_max_19_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator4745);
                    lv_max_19_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_19_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_20=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCreateObjectMutator4757); 

                        	newLeafNode(otherlv_20, grammarAccess.getCreateObjectMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleCreateObjectMutator"


    // $ANTLR start "entryRuleSelectObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2072:1: entryRuleSelectObjectMutator returns [EObject current=null] : iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF ;
    public final EObject entryRuleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectObjectMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2073:2: (iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2074:2: iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator4795);
            iv_ruleSelectObjectMutator=ruleSelectObjectMutator();

            state._fsp--;

             current =iv_ruleSelectObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectObjectMutator4805); 

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
    // $ANTLR end "entryRuleSelectObjectMutator"


    // $ANTLR start "ruleSelectObjectMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2081:1: ruleSelectObjectMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? ) ;
    public final EObject ruleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_3_0 = null;

        EObject lv_container_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2084:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2085:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2085:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2085:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2085:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2086:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2086:1: (lv_name_0_0= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2087:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator4847); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSelectObjectMutatorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectObjectMutatorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSelectObjectMutator4864); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectObjectMutatorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleSelectObjectMutator4876); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectObjectMutatorAccess().getSelectKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2111:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2112:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2112:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2113:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator4897);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2129:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==20) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2129:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSelectObjectMutator4910); 

                        	newLeafNode(otherlv_4, grammarAccess.getSelectObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2133:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2134:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2134:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2135:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator4931);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2151:2: (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==25) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2151:4: otherlv_6= '.' ( (otherlv_7= RULE_ID ) )
                            {
                            otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSelectObjectMutator4944); 

                                	newLeafNode(otherlv_6, grammarAccess.getSelectObjectMutatorAccess().getFullStopKeyword_4_2_0());
                                
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2155:1: ( (otherlv_7= RULE_ID ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2156:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2156:1: (otherlv_7= RULE_ID )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2157:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getSelectObjectMutatorRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator4964); 

                            		newLeafNode(otherlv_7, grammarAccess.getSelectObjectMutatorAccess().getRefTypeEReferenceCrossReference_4_2_1_0()); 
                            	

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleSelectObjectMutator"


    // $ANTLR start "entryRuleModifyInformationMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2176:1: entryRuleModifyInformationMutator returns [EObject current=null] : iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF ;
    public final EObject entryRuleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyInformationMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2177:2: (iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2178:2: iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyInformationMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator5004);
            iv_ruleModifyInformationMutator=ruleModifyInformationMutator();

            state._fsp--;

             current =iv_ruleModifyInformationMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyInformationMutator5014); 

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
    // $ANTLR end "entryRuleModifyInformationMutator"


    // $ANTLR start "ruleModifyInformationMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2185:1: ruleModifyInformationMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) ;
    public final EObject ruleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_object_3_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_references_7_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_references_10_0 = null;

        AntlrDatatypeRuleToken lv_min_13_0 = null;

        AntlrDatatypeRuleToken lv_max_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2188:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2189:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2190:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2190:1: (lv_name_0_0= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2191:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyInformationMutator5057); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getModifyInformationMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModifyInformationMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleModifyInformationMutator5074); 

                        	newLeafNode(otherlv_1, grammarAccess.getModifyInformationMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleModifyInformationMutator5088); 

                	newLeafNode(otherlv_2, grammarAccess.getModifyInformationMutatorAccess().getModifyKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2215:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2216:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2216:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2217:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator5109);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2233:2: (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==11) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2233:4: otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModifyInformationMutator5122); 

                        	newLeafNode(otherlv_4, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModifyInformationMutator5134); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2241:1: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?
                    int alt40=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA40_1 = input.LA(2);

                            if ( (LA40_1==38) ) {
                                int LA40_5 = input.LA(3);

                                if ( (LA40_5==RULE_ID||LA40_5==22||LA40_5==36||LA40_5==54) ) {
                                    alt40=2;
                                }
                                else if ( (LA40_5==RULE_STRING||LA40_5==RULE_INT||(LA40_5>=24 && LA40_5<=25)||(LA40_5>=28 && LA40_5<=29)||(LA40_5>=55 && LA40_5<=64)) ) {
                                    alt40=1;
                                }
                            }
                            }
                            break;
                        case 46:
                        case 49:
                        case 50:
                        case 51:
                            {
                            alt40=1;
                            }
                            break;
                        case 52:
                            {
                            alt40=2;
                            }
                            break;
                    }

                    switch (alt40) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2241:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2241:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2242:1: (lv_attributes_6_0= ruleAttributeSet )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2242:1: (lv_attributes_6_0= ruleAttributeSet )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2243:3: lv_attributes_6_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5156);
                            lv_attributes_6_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_6_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2260:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2260:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2261:1: (lv_references_7_0= ruleReferenceSet )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2261:1: (lv_references_7_0= ruleReferenceSet )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2262:3: lv_references_7_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5183);
                            lv_references_7_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_7_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2278:4: (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==40) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2278:6: otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_8=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleModifyInformationMutator5198); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getModifyInformationMutatorAccess().getCommaKeyword_3_3_0());
                    	        
                    	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2282:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    int alt41=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        int LA41_1 = input.LA(2);

                    	        if ( (LA41_1==38) ) {
                    	            int LA41_4 = input.LA(3);

                    	            if ( (LA41_4==RULE_STRING||LA41_4==RULE_INT||(LA41_4>=24 && LA41_4<=25)||(LA41_4>=28 && LA41_4<=29)||(LA41_4>=55 && LA41_4<=64)) ) {
                    	                alt41=1;
                    	            }
                    	            else if ( (LA41_4==RULE_ID||LA41_4==22||LA41_4==36||LA41_4==54) ) {
                    	                alt41=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 41, 4, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 41, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case 46:
                    	    case 49:
                    	    case 50:
                    	    case 51:
                    	        {
                    	        alt41=1;
                    	        }
                    	        break;
                    	    case 52:
                    	        {
                    	        alt41=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 41, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt41) {
                    	        case 1 :
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2282:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2282:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2283:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2283:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2284:3: lv_attributes_9_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5220);
                    	            lv_attributes_9_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_9_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2301:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2301:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2302:1: (lv_references_10_0= ruleReferenceSet )
                    	            {
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2302:1: (lv_references_10_0= ruleReferenceSet )
                    	            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2303:3: lv_references_10_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5247);
                    	            lv_references_10_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_10_0, 
                    	                    		"ReferenceSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModifyInformationMutator5262); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2323:3: (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==RULE_INT||LA45_1==24||LA45_1==65) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2323:5: otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleModifyInformationMutator5277); 

                        	newLeafNode(otherlv_12, grammarAccess.getModifyInformationMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2327:1: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==24) ) {
                        int LA44_1 = input.LA(2);

                        if ( (LA44_1==RULE_INT) ) {
                            int LA44_2 = input.LA(3);

                            if ( (LA44_2==34) ) {
                                alt44=1;
                            }
                        }
                    }
                    else if ( (LA44_0==RULE_INT) ) {
                        int LA44_2 = input.LA(2);

                        if ( (LA44_2==34) ) {
                            alt44=1;
                        }
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2327:2: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2327:2: ( (lv_min_13_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2328:1: (lv_min_13_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2328:1: (lv_min_13_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2329:3: lv_min_13_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyInformationMutator5299);
                            lv_min_13_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_13_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_14=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleModifyInformationMutator5311); 

                                	newLeafNode(otherlv_14, grammarAccess.getModifyInformationMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2349:3: ( (lv_max_15_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2350:1: (lv_max_15_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2350:1: (lv_max_15_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2351:3: lv_max_15_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator5334);
                    lv_max_15_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_15_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleModifyInformationMutator5346); 

                        	newLeafNode(otherlv_16, grammarAccess.getModifyInformationMutatorAccess().getRightSquareBracketKeyword_4_3());
                        

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
    // $ANTLR end "ruleModifyInformationMutator"


    // $ANTLR start "entryRuleCreateReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2379:1: entryRuleCreateReferenceMutator returns [EObject current=null] : iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF ;
    public final EObject entryRuleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2380:2: (iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2381:2: iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator5384);
            iv_ruleCreateReferenceMutator=ruleCreateReferenceMutator();

            state._fsp--;

             current =iv_ruleCreateReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateReferenceMutator5394); 

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
    // $ANTLR end "entryRuleCreateReferenceMutator"


    // $ANTLR start "ruleCreateReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2388:1: ruleCreateReferenceMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) ;
    public final EObject ruleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_target_6_0 = null;

        EObject lv_source_8_0 = null;

        AntlrDatatypeRuleToken lv_min_10_0 = null;

        AntlrDatatypeRuleToken lv_max_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2391:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2392:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2393:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2393:1: (lv_name_0_0= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2394:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator5437); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCreateReferenceMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCreateReferenceMutator5454); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateReferenceMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleCreateReferenceMutator5468); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateReferenceMutatorAccess().getCreateKeyword_1());
                
            otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCreateReferenceMutator5480); 

                	newLeafNode(otherlv_3, grammarAccess.getCreateReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2422:1: ( (otherlv_4= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2423:1: (otherlv_4= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2423:1: (otherlv_4= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2424:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator5500); 

            		newLeafNode(otherlv_4, grammarAccess.getCreateReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2435:2: (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==43) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2435:4: otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleCreateReferenceMutator5513); 

                        	newLeafNode(otherlv_5, grammarAccess.getCreateReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2439:1: ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2440:1: (lv_target_6_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2440:1: (lv_target_6_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2441:3: lv_target_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator5534);
                    lv_target_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2457:4: (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==20) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2457:6: otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCreateReferenceMutator5549); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateReferenceMutatorAccess().getInKeyword_5_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2461:1: ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2462:1: (lv_source_8_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2462:1: (lv_source_8_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2463:3: lv_source_8_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator5570);
                    lv_source_8_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_8_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2479:4: (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_INT||LA50_1==24||LA50_1==65) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2479:6: otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']'
                    {
                    otherlv_9=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCreateReferenceMutator5585); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2483:1: ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==24) ) {
                        int LA49_1 = input.LA(2);

                        if ( (LA49_1==RULE_INT) ) {
                            int LA49_2 = input.LA(3);

                            if ( (LA49_2==34) ) {
                                alt49=1;
                            }
                        }
                    }
                    else if ( (LA49_0==RULE_INT) ) {
                        int LA49_2 = input.LA(2);

                        if ( (LA49_2==34) ) {
                            alt49=1;
                        }
                    }
                    switch (alt49) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2483:2: ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2483:2: ( (lv_min_10_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2484:1: (lv_min_10_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2484:1: (lv_min_10_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2485:3: lv_min_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateReferenceMutator5607);
                            lv_min_10_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_10_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_11=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCreateReferenceMutator5619); 

                                	newLeafNode(otherlv_11, grammarAccess.getCreateReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2505:3: ( (lv_max_12_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2506:1: (lv_max_12_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2506:1: (lv_max_12_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2507:3: lv_max_12_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator5642);
                    lv_max_12_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_12_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCreateReferenceMutator5654); 

                        	newLeafNode(otherlv_13, grammarAccess.getCreateReferenceMutatorAccess().getRightSquareBracketKeyword_6_3());
                        

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
    // $ANTLR end "ruleCreateReferenceMutator"


    // $ANTLR start "entryRuleModifySourceReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2535:1: entryRuleModifySourceReferenceMutator returns [EObject current=null] : iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF ;
    public final EObject entryRuleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifySourceReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2536:2: (iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2537:2: iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifySourceReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator5692);
            iv_ruleModifySourceReferenceMutator=ruleModifySourceReferenceMutator();

            state._fsp--;

             current =iv_ruleModifySourceReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator5702); 

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
    // $ANTLR end "entryRuleModifySourceReferenceMutator"


    // $ANTLR start "ruleModifySourceReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2544:1: ruleModifySourceReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_source_4_0 = null;

        EObject lv_newSource_6_0 = null;

        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2547:28: ( (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2548:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2548:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2548:3: otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleModifySourceReferenceMutator5739); 

                	newLeafNode(otherlv_0, grammarAccess.getModifySourceReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleModifySourceReferenceMutator5751); 

                	newLeafNode(otherlv_1, grammarAccess.getModifySourceReferenceMutatorAccess().getSourceKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2556:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2557:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2557:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2558:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifySourceReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator5771); 

            		newLeafNode(otherlv_2, grammarAccess.getModifySourceReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2569:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==21) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2569:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModifySourceReferenceMutator5784); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifySourceReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2573:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2574:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2574:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2575:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator5805);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2591:4: (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==43) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2591:6: otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleModifySourceReferenceMutator5820); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifySourceReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2595:1: ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2596:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2596:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2597:3: lv_newSource_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getNewSourceObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator5841);
                    lv_newSource_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"newSource",
                            		lv_newSource_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2613:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==33) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_INT||LA54_1==24||LA54_1==65) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2613:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleModifySourceReferenceMutator5856); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifySourceReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2617:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==24) ) {
                        int LA53_1 = input.LA(2);

                        if ( (LA53_1==RULE_INT) ) {
                            int LA53_2 = input.LA(3);

                            if ( (LA53_2==34) ) {
                                alt53=1;
                            }
                        }
                    }
                    else if ( (LA53_0==RULE_INT) ) {
                        int LA53_2 = input.LA(2);

                        if ( (LA53_2==34) ) {
                            alt53=1;
                        }
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2617:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2617:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2618:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2618:1: (lv_min_8_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2619:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator5878);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleModifySourceReferenceMutator5890); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifySourceReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2639:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2640:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2640:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2641:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator5913);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleModifySourceReferenceMutator5925); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifySourceReferenceMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleModifySourceReferenceMutator"


    // $ANTLR start "entryRuleModifyTargetReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2669:1: entryRuleModifyTargetReferenceMutator returns [EObject current=null] : iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF ;
    public final EObject entryRuleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyTargetReferenceMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2670:2: (iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2671:2: iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator5963);
            iv_ruleModifyTargetReferenceMutator=ruleModifyTargetReferenceMutator();

            state._fsp--;

             current =iv_ruleModifyTargetReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator5973); 

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
    // $ANTLR end "entryRuleModifyTargetReferenceMutator"


    // $ANTLR start "ruleModifyTargetReferenceMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2678:1: ruleModifyTargetReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_source_4_0 = null;

        EObject lv_newTarget_6_0 = null;

        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2681:28: ( (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2682:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2682:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2682:3: otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleModifyTargetReferenceMutator6010); 

                	newLeafNode(otherlv_0, grammarAccess.getModifyTargetReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleModifyTargetReferenceMutator6022); 

                	newLeafNode(otherlv_1, grammarAccess.getModifyTargetReferenceMutatorAccess().getTargetKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2690:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2691:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2691:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2692:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifyTargetReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator6042); 

            		newLeafNode(otherlv_2, grammarAccess.getModifyTargetReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2703:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==21) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2703:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModifyTargetReferenceMutator6055); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifyTargetReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2707:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2708:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2708:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2709:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6076);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2725:4: (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==43) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2725:6: otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleModifyTargetReferenceMutator6091); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyTargetReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2729:1: ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2730:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2730:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2731:3: lv_newTarget_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getNewTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6112);
                    lv_newTarget_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"newTarget",
                            		lv_newTarget_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2747:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==33) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==RULE_INT||LA58_1==24||LA58_1==65) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2747:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleModifyTargetReferenceMutator6127); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifyTargetReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2751:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==24) ) {
                        int LA57_1 = input.LA(2);

                        if ( (LA57_1==RULE_INT) ) {
                            int LA57_2 = input.LA(3);

                            if ( (LA57_2==34) ) {
                                alt57=1;
                            }
                        }
                    }
                    else if ( (LA57_0==RULE_INT) ) {
                        int LA57_2 = input.LA(2);

                        if ( (LA57_2==34) ) {
                            alt57=1;
                        }
                    }
                    switch (alt57) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2751:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2751:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2752:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2752:1: (lv_min_8_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2753:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator6149);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleModifyTargetReferenceMutator6161); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifyTargetReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2773:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2774:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2774:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2775:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator6184);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleModifyTargetReferenceMutator6196); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyTargetReferenceMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleModifyTargetReferenceMutator"


    // $ANTLR start "entryRuleCompositeMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2803:1: entryRuleCompositeMutator returns [EObject current=null] : iv_ruleCompositeMutator= ruleCompositeMutator EOF ;
    public final EObject entryRuleCompositeMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeMutator = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2804:2: (iv_ruleCompositeMutator= ruleCompositeMutator EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2805:2: iv_ruleCompositeMutator= ruleCompositeMutator EOF
            {
             newCompositeNode(grammarAccess.getCompositeMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator6234);
            iv_ruleCompositeMutator=ruleCompositeMutator();

            state._fsp--;

             current =iv_ruleCompositeMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeMutator6244); 

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
    // $ANTLR end "entryRuleCompositeMutator"


    // $ANTLR start "ruleCompositeMutator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2812:1: ruleCompositeMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
    public final EObject ruleCompositeMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_commands_3_0 = null;

        EObject lv_commands_4_0 = null;

        AntlrDatatypeRuleToken lv_min_7_0 = null;

        AntlrDatatypeRuleToken lv_max_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2815:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2816:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2817:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2817:1: (lv_name_0_0= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2818:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompositeMutator6287); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCompositeMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompositeMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCompositeMutator6304); 

                        	newLeafNode(otherlv_1, grammarAccess.getCompositeMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCompositeMutator6318); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2842:1: ( (lv_commands_3_0= ruleMutator ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2843:1: (lv_commands_3_0= ruleMutator )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2843:1: (lv_commands_3_0= ruleMutator )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2844:3: lv_commands_3_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator6339);
            lv_commands_3_0=ruleMutator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            	        }
                   		add(
                   			current, 
                   			"commands",
                    		lv_commands_3_0, 
                    		"Mutator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2860:2: ( (lv_commands_4_0= ruleMutator ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID||(LA60_0>=32 && LA60_0<=33)||LA60_0==39||LA60_0==42) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2861:1: (lv_commands_4_0= ruleMutator )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2861:1: (lv_commands_4_0= ruleMutator )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2862:3: lv_commands_4_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator6360);
            	    lv_commands_4_0=ruleMutator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_4_0, 
            	            		"Mutator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCompositeMutator6373); 

                	newLeafNode(otherlv_5, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2882:1: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==33) ) {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==RULE_INT||LA62_1==24||LA62_1==65) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2882:3: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCompositeMutator6386); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2886:1: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==24) ) {
                        int LA61_1 = input.LA(2);

                        if ( (LA61_1==RULE_INT) ) {
                            int LA61_2 = input.LA(3);

                            if ( (LA61_2==34) ) {
                                alt61=1;
                            }
                        }
                    }
                    else if ( (LA61_0==RULE_INT) ) {
                        int LA61_2 = input.LA(2);

                        if ( (LA61_2==34) ) {
                            alt61=1;
                        }
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2886:2: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2886:2: ( (lv_min_7_0= ruleEInt ) )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2887:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2887:1: (lv_min_7_0= ruleEInt )
                            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2888:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator6408);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCompositeMutator6420); 

                                	newLeafNode(otherlv_8, grammarAccess.getCompositeMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2908:3: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2909:1: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2909:1: (lv_max_9_0= ruleMaxCardinality )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2910:3: lv_max_9_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator6443);
                    lv_max_9_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_9_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCompositeMutator6455); 

                        	newLeafNode(otherlv_10, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleCompositeMutator"


    // $ANTLR start "entryRuleAttributeSet"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2938:1: entryRuleAttributeSet returns [EObject current=null] : iv_ruleAttributeSet= ruleAttributeSet EOF ;
    public final EObject entryRuleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSet = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2939:2: (iv_ruleAttributeSet= ruleAttributeSet EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2940:2: iv_ruleAttributeSet= ruleAttributeSet EOF
            {
             newCompositeNode(grammarAccess.getAttributeSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet6493);
            iv_ruleAttributeSet=ruleAttributeSet();

            state._fsp--;

             current =iv_ruleAttributeSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSet6503); 

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
    // $ANTLR end "entryRuleAttributeSet"


    // $ANTLR start "ruleAttributeSet"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2947:1: ruleAttributeSet returns [EObject current=null] : (this_AttributeInit_0= ruleAttributeInit | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse ) ;
    public final EObject ruleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeInit_0 = null;

        EObject this_AttributeUnset_1 = null;

        EObject this_AttributeSwap_2 = null;

        EObject this_AttributeCopy_3 = null;

        EObject this_AttributeReverse_4 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2950:28: ( (this_AttributeInit_0= ruleAttributeInit | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2951:1: (this_AttributeInit_0= ruleAttributeInit | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2951:1: (this_AttributeInit_0= ruleAttributeInit | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse )
            int alt63=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt63=1;
                }
                break;
            case 46:
                {
                alt63=2;
                }
                break;
            case 49:
                {
                alt63=3;
                }
                break;
            case 50:
                {
                alt63=4;
                }
                break;
            case 51:
                {
                alt63=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2952:5: this_AttributeInit_0= ruleAttributeInit
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeInitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeInit_in_ruleAttributeSet6550);
                    this_AttributeInit_0=ruleAttributeInit();

                    state._fsp--;

                     
                            current = this_AttributeInit_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2962:5: this_AttributeUnset_1= ruleAttributeUnset
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeUnsetParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_ruleAttributeSet6577);
                    this_AttributeUnset_1=ruleAttributeUnset();

                    state._fsp--;

                     
                            current = this_AttributeUnset_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2972:5: this_AttributeSwap_2= ruleAttributeSwap
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeSwapParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_ruleAttributeSet6604);
                    this_AttributeSwap_2=ruleAttributeSwap();

                    state._fsp--;

                     
                            current = this_AttributeSwap_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2982:5: this_AttributeCopy_3= ruleAttributeCopy
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeCopyParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_ruleAttributeSet6631);
                    this_AttributeCopy_3=ruleAttributeCopy();

                    state._fsp--;

                     
                            current = this_AttributeCopy_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:2992:5: this_AttributeReverse_4= ruleAttributeReverse
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeReverseParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_ruleAttributeSet6658);
                    this_AttributeReverse_4=ruleAttributeReverse();

                    state._fsp--;

                     
                            current = this_AttributeReverse_4; 
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
    // $ANTLR end "ruleAttributeSet"


    // $ANTLR start "entryRuleAttributeInit"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3008:1: entryRuleAttributeInit returns [EObject current=null] : iv_ruleAttributeInit= ruleAttributeInit EOF ;
    public final EObject entryRuleAttributeInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeInit = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3009:2: (iv_ruleAttributeInit= ruleAttributeInit EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3010:2: iv_ruleAttributeInit= ruleAttributeInit EOF
            {
             newCompositeNode(grammarAccess.getAttributeInitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeInit_in_entryRuleAttributeInit6693);
            iv_ruleAttributeInit=ruleAttributeInit();

            state._fsp--;

             current =iv_ruleAttributeInit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeInit6703); 

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
    // $ANTLR end "entryRuleAttributeInit"


    // $ANTLR start "ruleAttributeInit"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3017:1: ruleAttributeInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3020:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleAttributeType ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3021:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleAttributeType ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3021:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleAttributeType ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3021:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleAttributeType ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3021:2: ( (otherlv_0= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3022:1: (otherlv_0= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3022:1: (otherlv_0= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3023:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeInitRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeInit6748); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeInitAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleAttributeInit6760); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeInitAccess().getEqualsSignKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3038:1: ( (lv_value_2_0= ruleAttributeType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3039:1: (lv_value_2_0= ruleAttributeType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3039:1: (lv_value_2_0= ruleAttributeType )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3040:3: lv_value_2_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeInitAccess().getValueAttributeTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeInit6781);
            lv_value_2_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeInitRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"AttributeType");
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
    // $ANTLR end "ruleAttributeInit"


    // $ANTLR start "entryRuleAttributeUnset"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3064:1: entryRuleAttributeUnset returns [EObject current=null] : iv_ruleAttributeUnset= ruleAttributeUnset EOF ;
    public final EObject entryRuleAttributeUnset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeUnset = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3065:2: (iv_ruleAttributeUnset= ruleAttributeUnset EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3066:2: iv_ruleAttributeUnset= ruleAttributeUnset EOF
            {
             newCompositeNode(grammarAccess.getAttributeUnsetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset6817);
            iv_ruleAttributeUnset=ruleAttributeUnset();

            state._fsp--;

             current =iv_ruleAttributeUnset; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeUnset6827); 

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
    // $ANTLR end "entryRuleAttributeUnset"


    // $ANTLR start "ruleAttributeUnset"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3073:1: ruleAttributeUnset returns [EObject current=null] : (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeUnset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3076:28: ( (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3077:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3077:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3077:3: otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleAttributeUnset6864); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeUnsetAccess().getUnsetKeyword_0());
                
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleAttributeUnset6876); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeUnsetAccess().getLeftParenthesisKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3085:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3086:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3086:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3087:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeUnsetRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeUnset6896); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeUnsetAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAttributeUnset6908); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeUnsetAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleAttributeUnset"


    // $ANTLR start "entryRuleAttributeSwap"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3110:1: entryRuleAttributeSwap returns [EObject current=null] : iv_ruleAttributeSwap= ruleAttributeSwap EOF ;
    public final EObject entryRuleAttributeSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSwap = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3111:2: (iv_ruleAttributeSwap= ruleAttributeSwap EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3112:2: iv_ruleAttributeSwap= ruleAttributeSwap EOF
            {
             newCompositeNode(grammarAccess.getAttributeSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap6944);
            iv_ruleAttributeSwap=ruleAttributeSwap();

            state._fsp--;

             current =iv_ruleAttributeSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSwap6954); 

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
    // $ANTLR end "entryRuleAttributeSwap"


    // $ANTLR start "ruleAttributeSwap"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3119:1: ruleAttributeSwap returns [EObject current=null] : (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleAttributeSwap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3122:28: ( (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3123:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3123:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3123:3: otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleAttributeSwap6991); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeSwapAccess().getSwapKeyword_0());
                
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleAttributeSwap7003); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3131:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3132:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3132:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3133:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap7023); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAttributeSwap7035); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeSwapAccess().getCommaKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3148:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==22||LA64_0==36||LA64_0==54) ) {
                alt64=1;
            }
            else if ( (LA64_0==RULE_ID) ) {
                int LA64_2 = input.LA(2);

                if ( (LA64_2==25||LA64_2==53) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3148:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3148:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3149:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3149:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3150:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap7057);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeSwapRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAttributeSwap7069); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3170:3: ( (otherlv_6= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3171:1: (otherlv_6= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3171:1: (otherlv_6= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3172:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap7091); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAttributeSwap7103); 

                	newLeafNode(otherlv_7, grammarAccess.getAttributeSwapAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleAttributeSwap"


    // $ANTLR start "entryRuleAttributeCopy"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3195:1: entryRuleAttributeCopy returns [EObject current=null] : iv_ruleAttributeCopy= ruleAttributeCopy EOF ;
    public final EObject entryRuleAttributeCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCopy = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3196:2: (iv_ruleAttributeCopy= ruleAttributeCopy EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3197:2: iv_ruleAttributeCopy= ruleAttributeCopy EOF
            {
             newCompositeNode(grammarAccess.getAttributeCopyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy7139);
            iv_ruleAttributeCopy=ruleAttributeCopy();

            state._fsp--;

             current =iv_ruleAttributeCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeCopy7149); 

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
    // $ANTLR end "entryRuleAttributeCopy"


    // $ANTLR start "ruleAttributeCopy"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3204:1: ruleAttributeCopy returns [EObject current=null] : (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleAttributeCopy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3207:28: ( (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3208:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3208:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3208:3: otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleAttributeCopy7186); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeCopyAccess().getCopyKeyword_0());
                
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleAttributeCopy7198); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeCopyAccess().getLeftParenthesisKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3216:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3217:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3217:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3218:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy7218); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAttributeCopy7230); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeCopyAccess().getCommaKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3233:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==22||LA65_0==36||LA65_0==54) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_ID) ) {
                int LA65_2 = input.LA(2);

                if ( (LA65_2==25||LA65_2==53) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3233:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3233:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3234:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3234:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3235:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeCopyAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy7252);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeCopyRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAttributeCopy7264); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeCopyAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3255:3: ( (otherlv_6= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3256:1: (otherlv_6= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3256:1: (otherlv_6= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3257:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy7286); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAttributeCopy7298); 

                	newLeafNode(otherlv_7, grammarAccess.getAttributeCopyAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleAttributeCopy"


    // $ANTLR start "entryRuleAttributeReverse"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3280:1: entryRuleAttributeReverse returns [EObject current=null] : iv_ruleAttributeReverse= ruleAttributeReverse EOF ;
    public final EObject entryRuleAttributeReverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReverse = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3281:2: (iv_ruleAttributeReverse= ruleAttributeReverse EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3282:2: iv_ruleAttributeReverse= ruleAttributeReverse EOF
            {
             newCompositeNode(grammarAccess.getAttributeReverseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse7334);
            iv_ruleAttributeReverse=ruleAttributeReverse();

            state._fsp--;

             current =iv_ruleAttributeReverse; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeReverse7344); 

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
    // $ANTLR end "entryRuleAttributeReverse"


    // $ANTLR start "ruleAttributeReverse"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3289:1: ruleAttributeReverse returns [EObject current=null] : (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeReverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3292:28: ( (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3293:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3293:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3293:3: otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleAttributeReverse7381); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReverseAccess().getReverseKeyword_0());
                
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleAttributeReverse7393); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeReverseAccess().getLeftParenthesisKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3301:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3302:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3302:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3303:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeReverseRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeReverse7413); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeReverseAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAttributeReverse7425); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeReverseAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleAttributeReverse"


    // $ANTLR start "entryRuleReferenceSet"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3326:1: entryRuleReferenceSet returns [EObject current=null] : iv_ruleReferenceSet= ruleReferenceSet EOF ;
    public final EObject entryRuleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSet = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3327:2: (iv_ruleReferenceSet= ruleReferenceSet EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3328:2: iv_ruleReferenceSet= ruleReferenceSet EOF
            {
             newCompositeNode(grammarAccess.getReferenceSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet7461);
            iv_ruleReferenceSet=ruleReferenceSet();

            state._fsp--;

             current =iv_ruleReferenceSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSet7471); 

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
    // $ANTLR end "entryRuleReferenceSet"


    // $ANTLR start "ruleReferenceSet"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3335:1: ruleReferenceSet returns [EObject current=null] : (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap ) ;
    public final EObject ruleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceInit_0 = null;

        EObject this_ReferenceSwap_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3338:28: ( (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3339:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3339:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                alt66=1;
            }
            else if ( (LA66_0==52) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3340:5: this_ReferenceInit_0= ruleReferenceInit
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceInitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_ruleReferenceSet7518);
                    this_ReferenceInit_0=ruleReferenceInit();

                    state._fsp--;

                     
                            current = this_ReferenceInit_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3350:5: this_ReferenceSwap_1= ruleReferenceSwap
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceSwapParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_ruleReferenceSet7545);
                    this_ReferenceSwap_1=ruleReferenceSwap();

                    state._fsp--;

                     
                            current = this_ReferenceSwap_1; 
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
    // $ANTLR end "ruleReferenceSet"


    // $ANTLR start "entryRuleReferenceInit"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3366:1: entryRuleReferenceInit returns [EObject current=null] : iv_ruleReferenceInit= ruleReferenceInit EOF ;
    public final EObject entryRuleReferenceInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceInit = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3367:2: (iv_ruleReferenceInit= ruleReferenceInit EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3368:2: iv_ruleReferenceInit= ruleReferenceInit EOF
            {
             newCompositeNode(grammarAccess.getReferenceInitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit7580);
            iv_ruleReferenceInit=ruleReferenceInit();

            state._fsp--;

             current =iv_ruleReferenceInit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceInit7590); 

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
    // $ANTLR end "entryRuleReferenceInit"


    // $ANTLR start "ruleReferenceInit"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3375:1: ruleReferenceInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleReferenceInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_object_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3378:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3379:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3379:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3379:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3379:2: ( (otherlv_0= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3380:1: (otherlv_0= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3380:1: (otherlv_0= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3381:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceInitRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit7635); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceInitAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleReferenceInit7647); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceInitAccess().getEqualsSignKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3396:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3397:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3397:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3398:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceInitAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit7668);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceInitRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_2_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3414:2: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==25) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3414:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleReferenceInit7681); 

                        	newLeafNode(otherlv_3, grammarAccess.getReferenceInitAccess().getFullStopKeyword_3_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3418:1: ( (otherlv_4= RULE_ID ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3419:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3419:1: (otherlv_4= RULE_ID )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3420:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceInitRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit7701); 

                    		newLeafNode(otherlv_4, grammarAccess.getReferenceInitAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

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
    // $ANTLR end "ruleReferenceInit"


    // $ANTLR start "entryRuleReferenceSwap"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3439:1: entryRuleReferenceSwap returns [EObject current=null] : iv_ruleReferenceSwap= ruleReferenceSwap EOF ;
    public final EObject entryRuleReferenceSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSwap = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3440:2: (iv_ruleReferenceSwap= ruleReferenceSwap EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3441:2: iv_ruleReferenceSwap= ruleReferenceSwap EOF
            {
             newCompositeNode(grammarAccess.getReferenceSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap7739);
            iv_ruleReferenceSwap=ruleReferenceSwap();

            state._fsp--;

             current =iv_ruleReferenceSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSwap7749); 

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
    // $ANTLR end "entryRuleReferenceSwap"


    // $ANTLR start "ruleReferenceSwap"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3448:1: ruleReferenceSwap returns [EObject current=null] : (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleReferenceSwap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3451:28: ( (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3452:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3452:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3452:3: otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleReferenceSwap7786); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceSwapAccess().getSwaprefKeyword_0());
                
            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleReferenceSwap7798); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3460:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3461:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3461:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3462:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap7818); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceSwap7830); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceSwapAccess().getCommaKeyword_3());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3477:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==22||LA68_0==36||LA68_0==54) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_ID) ) {
                int LA68_2 = input.LA(2);

                if ( (LA68_2==25||LA68_2==53) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3477:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3477:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3478:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3478:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3479:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap7852);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceSwapRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleReferenceSwap7864); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3499:3: ( (otherlv_6= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3500:1: (otherlv_6= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3500:1: (otherlv_6= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3501:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap7886); 

            		newLeafNode(otherlv_6, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleReferenceSwap7898); 

                	newLeafNode(otherlv_7, grammarAccess.getReferenceSwapAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleReferenceSwap"


    // $ANTLR start "entryRuleRandomTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3524:1: entryRuleRandomTypeSelection returns [EObject current=null] : iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF ;
    public final EObject entryRuleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTypeSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3525:2: (iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3526:2: iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection7934);
            iv_ruleRandomTypeSelection=ruleRandomTypeSelection();

            state._fsp--;

             current =iv_ruleRandomTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomTypeSelection7944); 

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
    // $ANTLR end "entryRuleRandomTypeSelection"


    // $ANTLR start "ruleRandomTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3533:1: ruleRandomTypeSelection returns [EObject current=null] : ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3536:28: ( ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3537:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3537:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3537:2: () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3537:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3538:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeSelectionAccess().getRandomTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleRandomTypeSelection7990); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomTypeSelectionAccess().getOneKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3547:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3548:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3548:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3549:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection8010); 

            		newLeafNode(otherlv_2, grammarAccess.getRandomTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3560:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==53) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3560:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleRandomTypeSelection8023); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRandomTypeSelection8035); 

                        	newLeafNode(otherlv_4, grammarAccess.getRandomTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3568:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3569:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3569:1: (lv_expression_5_0= ruleExpression )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3570:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRandomTypeSelection8056);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRandomTypeSelection8068); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleRandomTypeSelection"


    // $ANTLR start "entryRuleSpecificObjectSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3598:1: entryRuleSpecificObjectSelection returns [EObject current=null] : iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF ;
    public final EObject entryRuleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificObjectSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3599:2: (iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3600:2: iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificObjectSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection8106);
            iv_ruleSpecificObjectSelection=ruleSpecificObjectSelection();

            state._fsp--;

             current =iv_ruleSpecificObjectSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificObjectSelection8116); 

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
    // $ANTLR end "entryRuleSpecificObjectSelection"


    // $ANTLR start "ruleSpecificObjectSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3607:1: ruleSpecificObjectSelection returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? ) ;
    public final EObject ruleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3610:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3611:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3611:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3611:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3611:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3612:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificObjectSelectionAccess().getSpecificObjectSelectionAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3617:2: ( (otherlv_1= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3618:1: (otherlv_1= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3618:1: (otherlv_1= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3619:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection8170); 

            		newLeafNode(otherlv_1, grammarAccess.getSpecificObjectSelectionAccess().getObjSelObjectEmitterCrossReference_1_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3630:2: (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==53) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3630:4: otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}'
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSpecificObjectSelection8183); 

                        	newLeafNode(otherlv_2, grammarAccess.getSpecificObjectSelectionAccess().getWhereKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificObjectSelection8195); 

                        	newLeafNode(otherlv_3, grammarAccess.getSpecificObjectSelectionAccess().getLeftCurlyBracketKeyword_2_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3638:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3639:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3639:1: (lv_expression_4_0= ruleExpression )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3640:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificObjectSelectionAccess().getExpressionExpressionParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificObjectSelection8216);
                    lv_expression_4_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificObjectSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_4_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificObjectSelection8228); 

                        	newLeafNode(otherlv_5, grammarAccess.getSpecificObjectSelectionAccess().getRightCurlyBracketKeyword_2_3());
                        

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
    // $ANTLR end "ruleSpecificObjectSelection"


    // $ANTLR start "entryRuleCompleteTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3668:1: entryRuleCompleteTypeSelection returns [EObject current=null] : iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF ;
    public final EObject entryRuleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteTypeSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3669:2: (iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3670:2: iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection8266);
            iv_ruleCompleteTypeSelection=ruleCompleteTypeSelection();

            state._fsp--;

             current =iv_ruleCompleteTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteTypeSelection8276); 

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
    // $ANTLR end "entryRuleCompleteTypeSelection"


    // $ANTLR start "ruleCompleteTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3677:1: ruleCompleteTypeSelection returns [EObject current=null] : ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3680:28: ( ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3681:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3681:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3681:2: () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3681:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3682:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompleteTypeSelectionAccess().getCompleteTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCompleteTypeSelection8322); 

                	newLeafNode(otherlv_1, grammarAccess.getCompleteTypeSelectionAccess().getAllKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3691:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3692:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3692:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3693:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection8342); 

            		newLeafNode(otherlv_2, grammarAccess.getCompleteTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3704:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==53) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3704:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCompleteTypeSelection8355); 

                        	newLeafNode(otherlv_3, grammarAccess.getCompleteTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCompleteTypeSelection8367); 

                        	newLeafNode(otherlv_4, grammarAccess.getCompleteTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3712:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3713:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3713:1: (lv_expression_5_0= ruleExpression )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3714:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompleteTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleCompleteTypeSelection8388);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompleteTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCompleteTypeSelection8400); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompleteTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleCompleteTypeSelection"


    // $ANTLR start "entryRuleOtherTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3742:1: entryRuleOtherTypeSelection returns [EObject current=null] : iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF ;
    public final EObject entryRuleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTypeSelection = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3743:2: (iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3744:2: iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection8438);
            iv_ruleOtherTypeSelection=ruleOtherTypeSelection();

            state._fsp--;

             current =iv_ruleOtherTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherTypeSelection8448); 

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
    // $ANTLR end "entryRuleOtherTypeSelection"


    // $ANTLR start "ruleOtherTypeSelection"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3751:1: ruleOtherTypeSelection returns [EObject current=null] : ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3754:28: ( ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3755:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3755:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3755:2: () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3755:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3756:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOtherTypeSelectionAccess().getOtherTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleOtherTypeSelection8494); 

                	newLeafNode(otherlv_1, grammarAccess.getOtherTypeSelectionAccess().getOtherKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3765:1: ( (otherlv_2= RULE_ID ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3766:1: (otherlv_2= RULE_ID )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3766:1: (otherlv_2= RULE_ID )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3767:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection8514); 

            		newLeafNode(otherlv_2, grammarAccess.getOtherTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3778:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==53) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3778:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleOtherTypeSelection8527); 

                        	newLeafNode(otherlv_3, grammarAccess.getOtherTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOtherTypeSelection8539); 

                        	newLeafNode(otherlv_4, grammarAccess.getOtherTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3786:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3787:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3787:1: (lv_expression_5_0= ruleExpression )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3788:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOtherTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleOtherTypeSelection8560);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOtherTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOtherTypeSelection8572); 

                        	newLeafNode(otherlv_6, grammarAccess.getOtherTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleOtherTypeSelection"


    // $ANTLR start "entryRuleBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3816:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3817:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3818:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_entryRuleBooleanType8610);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanType8620); 

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
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3825:1: ruleBooleanType returns [EObject current=null] : (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificBooleanType_0 = null;

        EObject this_RandomBooleanType_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3828:28: ( (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3829:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3829:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=28 && LA73_0<=29)) ) {
                alt73=1;
            }
            else if ( (LA73_0==55) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3830:5: this_SpecificBooleanType_0= ruleSpecificBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getSpecificBooleanTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType8667);
                    this_SpecificBooleanType_0=ruleSpecificBooleanType();

                    state._fsp--;

                     
                            current = this_SpecificBooleanType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3840:5: this_RandomBooleanType_1= ruleRandomBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getRandomBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_ruleBooleanType8694);
                    this_RandomBooleanType_1=ruleRandomBooleanType();

                    state._fsp--;

                     
                            current = this_RandomBooleanType_1; 
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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleRandomBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3856:1: entryRuleRandomBooleanType returns [EObject current=null] : iv_ruleRandomBooleanType= ruleRandomBooleanType EOF ;
    public final EObject entryRuleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomBooleanType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3857:2: (iv_ruleRandomBooleanType= ruleRandomBooleanType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3858:2: iv_ruleRandomBooleanType= ruleRandomBooleanType EOF
            {
             newCompositeNode(grammarAccess.getRandomBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType8729);
            iv_ruleRandomBooleanType=ruleRandomBooleanType();

            state._fsp--;

             current =iv_ruleRandomBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomBooleanType8739); 

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
    // $ANTLR end "entryRuleRandomBooleanType"


    // $ANTLR start "ruleRandomBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3865:1: ruleRandomBooleanType returns [EObject current=null] : ( () otherlv_1= 'random-boolean' ) ;
    public final EObject ruleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3868:28: ( ( () otherlv_1= 'random-boolean' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3869:1: ( () otherlv_1= 'random-boolean' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3869:1: ( () otherlv_1= 'random-boolean' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3869:2: () otherlv_1= 'random-boolean'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3869:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3870:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomBooleanType8785); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanKeyword_1());
                

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
    // $ANTLR end "ruleRandomBooleanType"


    // $ANTLR start "entryRuleSpecificBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3887:1: entryRuleSpecificBooleanType returns [EObject current=null] : iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF ;
    public final EObject entryRuleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificBooleanType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3888:2: (iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3889:2: iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF
            {
             newCompositeNode(grammarAccess.getSpecificBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType8821);
            iv_ruleSpecificBooleanType=ruleSpecificBooleanType();

            state._fsp--;

             current =iv_ruleSpecificBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificBooleanType8831); 

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
    // $ANTLR end "entryRuleSpecificBooleanType"


    // $ANTLR start "ruleSpecificBooleanType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3896:1: ruleSpecificBooleanType returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3899:28: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3900:1: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3900:1: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3900:2: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3900:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3901:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificBooleanTypeAccess().getSpecificBooleanTypeAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3906:2: ( (lv_value_1_0= ruleEBoolean ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3907:1: (lv_value_1_0= ruleEBoolean )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3907:1: (lv_value_1_0= ruleEBoolean )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3908:3: lv_value_1_0= ruleEBoolean
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType8886);
            lv_value_1_0=ruleEBoolean();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificBooleanTypeRule());
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
    // $ANTLR end "ruleSpecificBooleanType"


    // $ANTLR start "entryRuleStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3932:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3933:2: (iv_ruleStringType= ruleStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3934:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringType_in_entryRuleStringType8922);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringType8932); 

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
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3941:1: ruleStringType returns [EObject current=null] : (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificStringType_0 = null;

        EObject this_RandomStringType_1 = null;

        EObject this_UpperStringType_2 = null;

        EObject this_LowerStringType_3 = null;

        EObject this_CatStartStringType_4 = null;

        EObject this_CatEndStringType_5 = null;

        EObject this_ReplaceStringType_6 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3944:28: ( (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3945:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3945:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            int alt74=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt74=1;
                }
                break;
            case 56:
                {
                alt74=2;
                }
                break;
            case 57:
                {
                alt74=3;
                }
                break;
            case 61:
                {
                alt74=4;
                }
                break;
            case 58:
                {
                alt74=5;
                }
                break;
            case 59:
                {
                alt74=6;
                }
                break;
            case 62:
                {
                alt74=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3946:5: this_SpecificStringType_0= ruleSpecificStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getSpecificStringTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_ruleStringType8979);
                    this_SpecificStringType_0=ruleSpecificStringType();

                    state._fsp--;

                     
                            current = this_SpecificStringType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3956:5: this_RandomStringType_1= ruleRandomStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_ruleStringType9006);
                    this_RandomStringType_1=ruleRandomStringType();

                    state._fsp--;

                     
                            current = this_RandomStringType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3966:5: this_UpperStringType_2= ruleUpperStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getUpperStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_ruleStringType9033);
                    this_UpperStringType_2=ruleUpperStringType();

                    state._fsp--;

                     
                            current = this_UpperStringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3976:5: this_LowerStringType_3= ruleLowerStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getLowerStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_ruleStringType9060);
                    this_LowerStringType_3=ruleLowerStringType();

                    state._fsp--;

                     
                            current = this_LowerStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3986:5: this_CatStartStringType_4= ruleCatStartStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatStartStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_ruleStringType9087);
                    this_CatStartStringType_4=ruleCatStartStringType();

                    state._fsp--;

                     
                            current = this_CatStartStringType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:3996:5: this_CatEndStringType_5= ruleCatEndStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatEndStringTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_ruleStringType9114);
                    this_CatEndStringType_5=ruleCatEndStringType();

                    state._fsp--;

                     
                            current = this_CatEndStringType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4006:5: this_ReplaceStringType_6= ruleReplaceStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getReplaceStringTypeParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_ruleStringType9141);
                    this_ReplaceStringType_6=ruleReplaceStringType();

                    state._fsp--;

                     
                            current = this_ReplaceStringType_6; 
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
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleRandomStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4022:1: entryRuleRandomStringType returns [EObject current=null] : iv_ruleRandomStringType= ruleRandomStringType EOF ;
    public final EObject entryRuleRandomStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4023:2: (iv_ruleRandomStringType= ruleRandomStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4024:2: iv_ruleRandomStringType= ruleRandomStringType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType9176);
            iv_ruleRandomStringType=ruleRandomStringType();

            state._fsp--;

             current =iv_ruleRandomStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomStringType9186); 

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
    // $ANTLR end "entryRuleRandomStringType"


    // $ANTLR start "ruleRandomStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4031:1: ruleRandomStringType returns [EObject current=null] : ( () otherlv_1= 'random-string' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' ) ;
    public final EObject ruleRandomStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_min_3_0 = null;

        AntlrDatatypeRuleToken lv_max_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4034:28: ( ( () otherlv_1= 'random-string' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4035:1: ( () otherlv_1= 'random-string' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4035:1: ( () otherlv_1= 'random-string' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4035:2: () otherlv_1= 'random-string' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4035:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4036:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomStringTypeAccess().getRandomStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomStringType9232); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomStringTypeAccess().getRandomStringKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleRandomStringType9244); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomStringTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4049:1: ( (lv_min_3_0= ruleEInt ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4050:1: (lv_min_3_0= ruleEInt )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4050:1: (lv_min_3_0= ruleEInt )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4051:3: lv_min_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMinEIntParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType9265);
            lv_min_3_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"min",
                    		lv_min_3_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRandomStringType9277); 

                	newLeafNode(otherlv_4, grammarAccess.getRandomStringTypeAccess().getCommaKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4071:1: ( (lv_max_5_0= ruleEInt ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4072:1: (lv_max_5_0= ruleEInt )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4072:1: (lv_max_5_0= ruleEInt )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4073:3: lv_max_5_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMaxEIntParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType9298);
            lv_max_5_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"max",
                    		lv_max_5_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleRandomStringType9310); 

                	newLeafNode(otherlv_6, grammarAccess.getRandomStringTypeAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleRandomStringType"


    // $ANTLR start "entryRuleSpecificStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4101:1: entryRuleSpecificStringType returns [EObject current=null] : iv_ruleSpecificStringType= ruleSpecificStringType EOF ;
    public final EObject entryRuleSpecificStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4102:2: (iv_ruleSpecificStringType= ruleSpecificStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4103:2: iv_ruleSpecificStringType= ruleSpecificStringType EOF
            {
             newCompositeNode(grammarAccess.getSpecificStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType9346);
            iv_ruleSpecificStringType=ruleSpecificStringType();

            state._fsp--;

             current =iv_ruleSpecificStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificStringType9356); 

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
    // $ANTLR end "entryRuleSpecificStringType"


    // $ANTLR start "ruleSpecificStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4110:1: ruleSpecificStringType returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSpecificStringType() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4113:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4114:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4114:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4114:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4114:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4115:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificStringTypeAccess().getSpecificStringTypeAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4120:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4121:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4121:1: (lv_value_1_0= RULE_STRING )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4122:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpecificStringType9407); 

            			newLeafNode(lv_value_1_0, grammarAccess.getSpecificStringTypeAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificStringTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleSpecificStringType"


    // $ANTLR start "entryRuleUpperStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4146:1: entryRuleUpperStringType returns [EObject current=null] : iv_ruleUpperStringType= ruleUpperStringType EOF ;
    public final EObject entryRuleUpperStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4147:2: (iv_ruleUpperStringType= ruleUpperStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4148:2: iv_ruleUpperStringType= ruleUpperStringType EOF
            {
             newCompositeNode(grammarAccess.getUpperStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType9448);
            iv_ruleUpperStringType=ruleUpperStringType();

            state._fsp--;

             current =iv_ruleUpperStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUpperStringType9458); 

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
    // $ANTLR end "entryRuleUpperStringType"


    // $ANTLR start "ruleUpperStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4155:1: ruleUpperStringType returns [EObject current=null] : ( () otherlv_1= 'upper' ) ;
    public final EObject ruleUpperStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4158:28: ( ( () otherlv_1= 'upper' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4159:1: ( () otherlv_1= 'upper' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4159:1: ( () otherlv_1= 'upper' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4159:2: () otherlv_1= 'upper'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4159:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4160:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUpperStringTypeAccess().getUpperStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleUpperStringType9504); 

                	newLeafNode(otherlv_1, grammarAccess.getUpperStringTypeAccess().getUpperKeyword_1());
                

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
    // $ANTLR end "ruleUpperStringType"


    // $ANTLR start "entryRuleCatStartStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4177:1: entryRuleCatStartStringType returns [EObject current=null] : iv_ruleCatStartStringType= ruleCatStartStringType EOF ;
    public final EObject entryRuleCatStartStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatStartStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4178:2: (iv_ruleCatStartStringType= ruleCatStartStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4179:2: iv_ruleCatStartStringType= ruleCatStartStringType EOF
            {
             newCompositeNode(grammarAccess.getCatStartStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType9540);
            iv_ruleCatStartStringType=ruleCatStartStringType();

            state._fsp--;

             current =iv_ruleCatStartStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatStartStringType9550); 

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
    // $ANTLR end "entryRuleCatStartStringType"


    // $ANTLR start "ruleCatStartStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4186:1: ruleCatStartStringType returns [EObject current=null] : ( () otherlv_1= 'catstart' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' ) ;
    public final EObject ruleCatStartStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4189:28: ( ( () otherlv_1= 'catstart' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4190:1: ( () otherlv_1= 'catstart' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4190:1: ( () otherlv_1= 'catstart' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4190:2: () otherlv_1= 'catstart' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4190:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4191:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatStartStringTypeAccess().getCatStartStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleCatStartStringType9596); 

                	newLeafNode(otherlv_1, grammarAccess.getCatStartStringTypeAccess().getCatstartKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCatStartStringType9608); 

                	newLeafNode(otherlv_2, grammarAccess.getCatStartStringTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4204:1: ( (lv_value_3_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4205:1: (lv_value_3_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4205:1: (lv_value_3_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4206:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatStartStringType9629);
            lv_value_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatStartStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCatStartStringType9641); 

                	newLeafNode(otherlv_4, grammarAccess.getCatStartStringTypeAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleCatStartStringType"


    // $ANTLR start "entryRuleCatEndStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4234:1: entryRuleCatEndStringType returns [EObject current=null] : iv_ruleCatEndStringType= ruleCatEndStringType EOF ;
    public final EObject entryRuleCatEndStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatEndStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4235:2: (iv_ruleCatEndStringType= ruleCatEndStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4236:2: iv_ruleCatEndStringType= ruleCatEndStringType EOF
            {
             newCompositeNode(grammarAccess.getCatEndStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType9677);
            iv_ruleCatEndStringType=ruleCatEndStringType();

            state._fsp--;

             current =iv_ruleCatEndStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatEndStringType9687); 

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
    // $ANTLR end "entryRuleCatEndStringType"


    // $ANTLR start "ruleCatEndStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4243:1: ruleCatEndStringType returns [EObject current=null] : ( () otherlv_1= 'catend' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' ) ;
    public final EObject ruleCatEndStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4246:28: ( ( () otherlv_1= 'catend' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4247:1: ( () otherlv_1= 'catend' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4247:1: ( () otherlv_1= 'catend' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4247:2: () otherlv_1= 'catend' otherlv_2= '(' ( (lv_value_3_0= ruleEString ) ) otherlv_4= ')'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4247:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4248:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatEndStringTypeAccess().getCatEndStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleCatEndStringType9733); 

                	newLeafNode(otherlv_1, grammarAccess.getCatEndStringTypeAccess().getCatendKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCatEndStringType9745); 

                	newLeafNode(otherlv_2, grammarAccess.getCatEndStringTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4261:1: ( (lv_value_3_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4262:1: (lv_value_3_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4262:1: (lv_value_3_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4263:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatEndStringType9766);
            lv_value_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatEndStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCatEndStringType9778); 

                	newLeafNode(otherlv_4, grammarAccess.getCatEndStringTypeAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleCatEndStringType"


    // $ANTLR start "entryRuleListStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4291:1: entryRuleListStringType returns [EObject current=null] : iv_ruleListStringType= ruleListStringType EOF ;
    public final EObject entryRuleListStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4292:2: (iv_ruleListStringType= ruleListStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4293:2: iv_ruleListStringType= ruleListStringType EOF
            {
             newCompositeNode(grammarAccess.getListStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_entryRuleListStringType9814);
            iv_ruleListStringType=ruleListStringType();

            state._fsp--;

             current =iv_ruleListStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListStringType9824); 

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
    // $ANTLR end "entryRuleListStringType"


    // $ANTLR start "ruleListStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4300:1: ruleListStringType returns [EObject current=null] : ( () otherlv_1= 'inside' otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) ;
    public final EObject ruleListStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4303:28: ( ( () otherlv_1= 'inside' otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4304:1: ( () otherlv_1= 'inside' otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4304:1: ( () otherlv_1= 'inside' otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4304:2: () otherlv_1= 'inside' otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4304:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4305:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListStringTypeAccess().getListStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleListStringType9870); 

                	newLeafNode(otherlv_1, grammarAccess.getListStringTypeAccess().getInsideKeyword_1());
                
            otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleListStringType9882); 

                	newLeafNode(otherlv_2, grammarAccess.getListStringTypeAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4318:1: ( (lv_value_3_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4319:1: (lv_value_3_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4319:1: (lv_value_3_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4320:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType9903);
            lv_value_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	        }
                   		add(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4336:2: (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==40) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4336:4: otherlv_4= ',' ( (lv_value_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleListStringType9916); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListStringTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4340:1: ( (lv_value_5_0= ruleEString ) )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4341:1: (lv_value_5_0= ruleEString )
            	    {
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4341:1: (lv_value_5_0= ruleEString )
            	    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4342:3: lv_value_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType9937);
            	    lv_value_5_0=ruleEString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"value",
            	            		lv_value_5_0, 
            	            		"EString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            otherlv_6=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleListStringType9951); 

                	newLeafNode(otherlv_6, grammarAccess.getListStringTypeAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleListStringType"


    // $ANTLR start "entryRuleLowerStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4370:1: entryRuleLowerStringType returns [EObject current=null] : iv_ruleLowerStringType= ruleLowerStringType EOF ;
    public final EObject entryRuleLowerStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4371:2: (iv_ruleLowerStringType= ruleLowerStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4372:2: iv_ruleLowerStringType= ruleLowerStringType EOF
            {
             newCompositeNode(grammarAccess.getLowerStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType9987);
            iv_ruleLowerStringType=ruleLowerStringType();

            state._fsp--;

             current =iv_ruleLowerStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerStringType9997); 

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
    // $ANTLR end "entryRuleLowerStringType"


    // $ANTLR start "ruleLowerStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4379:1: ruleLowerStringType returns [EObject current=null] : ( () otherlv_1= 'lower' ) ;
    public final EObject ruleLowerStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4382:28: ( ( () otherlv_1= 'lower' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4383:1: ( () otherlv_1= 'lower' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4383:1: ( () otherlv_1= 'lower' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4383:2: () otherlv_1= 'lower'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4383:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4384:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLowerStringTypeAccess().getLowerStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleLowerStringType10043); 

                	newLeafNode(otherlv_1, grammarAccess.getLowerStringTypeAccess().getLowerKeyword_1());
                

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
    // $ANTLR end "ruleLowerStringType"


    // $ANTLR start "entryRuleReplaceStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4401:1: entryRuleReplaceStringType returns [EObject current=null] : iv_ruleReplaceStringType= ruleReplaceStringType EOF ;
    public final EObject entryRuleReplaceStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceStringType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4402:2: (iv_ruleReplaceStringType= ruleReplaceStringType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4403:2: iv_ruleReplaceStringType= ruleReplaceStringType EOF
            {
             newCompositeNode(grammarAccess.getReplaceStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType10079);
            iv_ruleReplaceStringType=ruleReplaceStringType();

            state._fsp--;

             current =iv_ruleReplaceStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReplaceStringType10089); 

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
    // $ANTLR end "entryRuleReplaceStringType"


    // $ANTLR start "ruleReplaceStringType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4410:1: ruleReplaceStringType returns [EObject current=null] : ( () otherlv_1= 'replace' otherlv_2= '(' ( (lv_oldstring_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_newstring_5_0= ruleEString ) ) otherlv_6= ')' ) ;
    public final EObject ruleReplaceStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_oldstring_3_0 = null;

        AntlrDatatypeRuleToken lv_newstring_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4413:28: ( ( () otherlv_1= 'replace' otherlv_2= '(' ( (lv_oldstring_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_newstring_5_0= ruleEString ) ) otherlv_6= ')' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4414:1: ( () otherlv_1= 'replace' otherlv_2= '(' ( (lv_oldstring_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_newstring_5_0= ruleEString ) ) otherlv_6= ')' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4414:1: ( () otherlv_1= 'replace' otherlv_2= '(' ( (lv_oldstring_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_newstring_5_0= ruleEString ) ) otherlv_6= ')' )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4414:2: () otherlv_1= 'replace' otherlv_2= '(' ( (lv_oldstring_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_newstring_5_0= ruleEString ) ) otherlv_6= ')'
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4414:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4415:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReplaceStringTypeAccess().getReplaceStringTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleReplaceStringType10135); 

                	newLeafNode(otherlv_1, grammarAccess.getReplaceStringTypeAccess().getReplaceKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleReplaceStringType10147); 

                	newLeafNode(otherlv_2, grammarAccess.getReplaceStringTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4428:1: ( (lv_oldstring_3_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4429:1: (lv_oldstring_3_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4429:1: (lv_oldstring_3_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4430:3: lv_oldstring_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType10168);
            lv_oldstring_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"oldstring",
                    		lv_oldstring_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReplaceStringType10180); 

                	newLeafNode(otherlv_4, grammarAccess.getReplaceStringTypeAccess().getCommaKeyword_4());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4450:1: ( (lv_newstring_5_0= ruleEString ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4451:1: (lv_newstring_5_0= ruleEString )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4451:1: (lv_newstring_5_0= ruleEString )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4452:3: lv_newstring_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType10201);
            lv_newstring_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"newstring",
                    		lv_newstring_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleReplaceStringType10213); 

                	newLeafNode(otherlv_6, grammarAccess.getReplaceStringTypeAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleReplaceStringType"


    // $ANTLR start "entryRuleDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4480:1: entryRuleDoubleType returns [EObject current=null] : iv_ruleDoubleType= ruleDoubleType EOF ;
    public final EObject entryRuleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4481:2: (iv_ruleDoubleType= ruleDoubleType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4482:2: iv_ruleDoubleType= ruleDoubleType EOF
            {
             newCompositeNode(grammarAccess.getDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_entryRuleDoubleType10249);
            iv_ruleDoubleType=ruleDoubleType();

            state._fsp--;

             current =iv_ruleDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleType10259); 

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
    // $ANTLR end "entryRuleDoubleType"


    // $ANTLR start "ruleDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4489:1: ruleDoubleType returns [EObject current=null] : (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) ;
    public final EObject ruleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificDoubleType_0 = null;

        EObject this_RandomDoubleType_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4492:28: ( (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4493:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4493:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_INT||(LA76_0>=24 && LA76_0<=25)) ) {
                alt76=1;
            }
            else if ( (LA76_0==63) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4494:5: this_SpecificDoubleType_0= ruleSpecificDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getSpecificDoubleTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType10306);
                    this_SpecificDoubleType_0=ruleSpecificDoubleType();

                    state._fsp--;

                     
                            current = this_SpecificDoubleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4504:5: this_RandomDoubleType_1= ruleRandomDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getRandomDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_ruleDoubleType10333);
                    this_RandomDoubleType_1=ruleRandomDoubleType();

                    state._fsp--;

                     
                            current = this_RandomDoubleType_1; 
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
    // $ANTLR end "ruleDoubleType"


    // $ANTLR start "entryRuleRandomDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4520:1: entryRuleRandomDoubleType returns [EObject current=null] : iv_ruleRandomDoubleType= ruleRandomDoubleType EOF ;
    public final EObject entryRuleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4521:2: (iv_ruleRandomDoubleType= ruleRandomDoubleType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4522:2: iv_ruleRandomDoubleType= ruleRandomDoubleType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType10368);
            iv_ruleRandomDoubleType=ruleRandomDoubleType();

            state._fsp--;

             current =iv_ruleRandomDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleType10378); 

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
    // $ANTLR end "entryRuleRandomDoubleType"


    // $ANTLR start "ruleRandomDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4529:1: ruleRandomDoubleType returns [EObject current=null] : ( () otherlv_1= 'random-double' (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )? ) ;
    public final EObject ruleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_min_3_0 = null;

        AntlrDatatypeRuleToken lv_max_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4532:28: ( ( () otherlv_1= 'random-double' (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4533:1: ( () otherlv_1= 'random-double' (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4533:1: ( () otherlv_1= 'random-double' (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4533:2: () otherlv_1= 'random-double' (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4533:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4534:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleRandomDoubleType10424); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4543:1: (otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==47) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4543:3: otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEDouble ) ) otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleRandomDoubleType10437); 

                        	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleTypeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4547:1: ( (lv_min_3_0= ruleEDouble ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4548:1: (lv_min_3_0= ruleEDouble )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4548:1: (lv_min_3_0= ruleEDouble )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4549:3: lv_min_3_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMinEDoubleParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType10458);
                    lv_min_3_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"min",
                            		lv_min_3_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRandomDoubleType10470); 

                        	newLeafNode(otherlv_4, grammarAccess.getRandomDoubleTypeAccess().getCommaKeyword_2_2());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4569:1: ( (lv_max_5_0= ruleEDouble ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4570:1: (lv_max_5_0= ruleEDouble )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4570:1: (lv_max_5_0= ruleEDouble )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4571:3: lv_max_5_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMaxEDoubleParserRuleCall_2_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType10491);
                    lv_max_5_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_5_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleRandomDoubleType10503); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomDoubleTypeAccess().getRightParenthesisKeyword_2_4());
                        

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
    // $ANTLR end "ruleRandomDoubleType"


    // $ANTLR start "entryRuleSpecificDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4599:1: entryRuleSpecificDoubleType returns [EObject current=null] : iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF ;
    public final EObject entryRuleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDoubleType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4600:2: (iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4601:2: iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF
            {
             newCompositeNode(grammarAccess.getSpecificDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType10541);
            iv_ruleSpecificDoubleType=ruleSpecificDoubleType();

            state._fsp--;

             current =iv_ruleSpecificDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificDoubleType10551); 

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
    // $ANTLR end "entryRuleSpecificDoubleType"


    // $ANTLR start "ruleSpecificDoubleType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4608:1: ruleSpecificDoubleType returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4611:28: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4612:1: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4612:1: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4612:2: () ( (lv_value_1_0= ruleEDouble ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4612:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4613:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificDoubleTypeAccess().getSpecificDoubleTypeAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4618:2: ( (lv_value_1_0= ruleEDouble ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4619:1: (lv_value_1_0= ruleEDouble )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4619:1: (lv_value_1_0= ruleEDouble )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4620:3: lv_value_1_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleSpecificDoubleType10606);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificDoubleTypeRule());
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
    // $ANTLR end "ruleSpecificDoubleType"


    // $ANTLR start "entryRuleIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4644:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4645:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4646:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_entryRuleIntegerType10642);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerType10652); 

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
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4653:1: ruleIntegerType returns [EObject current=null] : (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificIntegerType_0 = null;

        EObject this_RandomIntegerType_1 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4656:28: ( (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4657:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4657:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_INT||LA78_0==24) ) {
                alt78=1;
            }
            else if ( (LA78_0==64) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4658:5: this_SpecificIntegerType_0= ruleSpecificIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getSpecificIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType10699);
                    this_SpecificIntegerType_0=ruleSpecificIntegerType();

                    state._fsp--;

                     
                            current = this_SpecificIntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4668:5: this_RandomIntegerType_1= ruleRandomIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getRandomIntegerTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_ruleIntegerType10726);
                    this_RandomIntegerType_1=ruleRandomIntegerType();

                    state._fsp--;

                     
                            current = this_RandomIntegerType_1; 
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
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleSpecificIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4684:1: entryRuleSpecificIntegerType returns [EObject current=null] : iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF ;
    public final EObject entryRuleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificIntegerType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4685:2: (iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4686:2: iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF
            {
             newCompositeNode(grammarAccess.getSpecificIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType10761);
            iv_ruleSpecificIntegerType=ruleSpecificIntegerType();

            state._fsp--;

             current =iv_ruleSpecificIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificIntegerType10771); 

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
    // $ANTLR end "entryRuleSpecificIntegerType"


    // $ANTLR start "ruleSpecificIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4693:1: ruleSpecificIntegerType returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEInt ) ) ) ;
    public final EObject ruleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4696:28: ( ( () ( (lv_value_1_0= ruleEInt ) ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4697:1: ( () ( (lv_value_1_0= ruleEInt ) ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4697:1: ( () ( (lv_value_1_0= ruleEInt ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4697:2: () ( (lv_value_1_0= ruleEInt ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4697:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4698:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificIntegerTypeAccess().getSpecificIntegerTypeAction_0(),
                        current);
                

            }

            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4703:2: ( (lv_value_1_0= ruleEInt ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4704:1: (lv_value_1_0= ruleEInt )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4704:1: (lv_value_1_0= ruleEInt )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4705:3: lv_value_1_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleSpecificIntegerType10826);
            lv_value_1_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificIntegerTypeRule());
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
    // $ANTLR end "ruleSpecificIntegerType"


    // $ANTLR start "entryRuleRandomIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4729:1: entryRuleRandomIntegerType returns [EObject current=null] : iv_ruleRandomIntegerType= ruleRandomIntegerType EOF ;
    public final EObject entryRuleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerType = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4730:2: (iv_ruleRandomIntegerType= ruleRandomIntegerType EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4731:2: iv_ruleRandomIntegerType= ruleRandomIntegerType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType10862);
            iv_ruleRandomIntegerType=ruleRandomIntegerType();

            state._fsp--;

             current =iv_ruleRandomIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerType10872); 

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
    // $ANTLR end "entryRuleRandomIntegerType"


    // $ANTLR start "ruleRandomIntegerType"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4738:1: ruleRandomIntegerType returns [EObject current=null] : ( () otherlv_1= 'random-int' (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )? ) ;
    public final EObject ruleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_min_3_0 = null;

        AntlrDatatypeRuleToken lv_max_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4741:28: ( ( () otherlv_1= 'random-int' (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )? ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4742:1: ( () otherlv_1= 'random-int' (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )? )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4742:1: ( () otherlv_1= 'random-int' (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )? )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4742:2: () otherlv_1= 'random-int' (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )?
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4742:2: ()
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4743:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomIntegerTypeAccess().getRandomIntegerTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleRandomIntegerType10918); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomIntegerTypeAccess().getRandomIntKeyword_1());
                
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4752:1: (otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==47) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4752:3: otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_max_5_0= ruleEInt ) ) otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleRandomIntegerType10931); 

                        	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerTypeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4756:1: ( (lv_min_3_0= ruleEInt ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4757:1: (lv_min_3_0= ruleEInt )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4757:1: (lv_min_3_0= ruleEInt )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4758:3: lv_min_3_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMinEIntParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType10952);
                    lv_min_3_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"min",
                            		lv_min_3_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRandomIntegerType10964); 

                        	newLeafNode(otherlv_4, grammarAccess.getRandomIntegerTypeAccess().getCommaKeyword_2_2());
                        
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4778:1: ( (lv_max_5_0= ruleEInt ) )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4779:1: (lv_max_5_0= ruleEInt )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4779:1: (lv_max_5_0= ruleEInt )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4780:3: lv_max_5_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMaxEIntParserRuleCall_2_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType10985);
                    lv_max_5_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_5_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleRandomIntegerType10997); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomIntegerTypeAccess().getRightParenthesisKeyword_2_4());
                        

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
    // $ANTLR end "ruleRandomIntegerType"


    // $ANTLR start "entryRuleMaxCardinality"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4808:1: entryRuleMaxCardinality returns [String current=null] : iv_ruleMaxCardinality= ruleMaxCardinality EOF ;
    public final String entryRuleMaxCardinality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaxCardinality = null;


        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4809:2: (iv_ruleMaxCardinality= ruleMaxCardinality EOF )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4810:2: iv_ruleMaxCardinality= ruleMaxCardinality EOF
            {
             newCompositeNode(grammarAccess.getMaxCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality11036);
            iv_ruleMaxCardinality=ruleMaxCardinality();

            state._fsp--;

             current =iv_ruleMaxCardinality.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxCardinality11047); 

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
    // $ANTLR end "entryRuleMaxCardinality"


    // $ANTLR start "ruleMaxCardinality"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4817:1: ruleMaxCardinality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleMaxCardinality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EInt_0 = null;


         enterRule(); 
            
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4820:28: ( (this_EInt_0= ruleEInt | kw= '*' ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4821:1: (this_EInt_0= ruleEInt | kw= '*' )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4821:1: (this_EInt_0= ruleEInt | kw= '*' )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_INT||LA80_0==24) ) {
                alt80=1;
            }
            else if ( (LA80_0==65) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4822:5: this_EInt_0= ruleEInt
                    {
                     
                            newCompositeNode(grammarAccess.getMaxCardinalityAccess().getEIntParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleMaxCardinality11094);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    		current.merge(this_EInt_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4834:2: kw= '*'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleMaxCardinality11118); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMaxCardinalityAccess().getAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleMaxCardinality"


    // $ANTLR start "ruleLogicOperator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4847:1: ruleLogicOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) ;
    public final Enumerator ruleLogicOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4849:28: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4850:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4850:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==66) ) {
                alt81=1;
            }
            else if ( (LA81_0==67) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4850:2: (enumLiteral_0= 'and' )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4850:2: (enumLiteral_0= 'and' )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4850:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleLogicOperator11172); 

                            current = grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4856:6: (enumLiteral_1= 'or' )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4856:6: (enumLiteral_1= 'or' )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4856:8: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleLogicOperator11189); 

                            current = grammarAccess.getLogicOperatorAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLogicOperatorAccess().getOrEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleLogicOperator"


    // $ANTLR start "ruleOperator"
    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4866:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4868:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4869:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4869:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==38) ) {
                alt82=1;
            }
            else if ( (LA82_0==68) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4869:2: (enumLiteral_0= '=' )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4869:2: (enumLiteral_0= '=' )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4869:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleOperator11234); 

                            current = grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4875:6: (enumLiteral_1= '<>' )
                    {
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4875:6: (enumLiteral_1= '<>' )
                    // ../org.mutator/src-gen/org/mutator/parser/antlr/internal/InternalMutator.g:4875:8: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleOperator11251); 

                            current = grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleOperator"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\21\uffff";
    static final String DFA5_eofS =
        "\21\uffff";
    static final String DFA5_minS =
        "\1\5\1\46\1\5\1\uffff\2\5\1\41\5\uffff\2\5\3\uffff";
    static final String DFA5_maxS =
        "\1\52\1\46\1\45\1\uffff\2\66\1\52\5\uffff\2\45\3\uffff";
    static final String DFA5_acceptS =
        "\3\uffff\1\3\3\uffff\1\6\1\1\1\4\1\11\1\5\2\uffff\1\10\1\7\1\2";
    static final String DFA5_specialS =
        "\21\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\32\uffff\1\5\1\3\5\uffff\1\2\2\uffff\1\4",
            "\1\6",
            "\1\10\37\uffff\1\7",
            "",
            "\1\12\20\uffff\1\12\15\uffff\1\12\7\uffff\1\11\1\13\10\uffff"+
            "\1\12",
            "\1\17\20\uffff\1\14\15\uffff\1\15\1\16\20\uffff\1\17",
            "\1\3\5\uffff\1\2\1\uffff\1\20\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\17\37\uffff\1\16",
            "\1\17\37\uffff\1\16",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "466:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorEnvironment_in_entryRuleMutatorEnvironment75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorEnvironment85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_ruleMutatorEnvironment131 = new BitSet(new long[]{0x0000000000848000L});
        public static final BitSet FOLLOW_ruleDefinition_in_ruleMutatorEnvironment153 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleMutatorEnvironment165 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMutatorEnvironment177 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment189 = new BitSet(new long[]{0x0000048300000020L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment210 = new BitSet(new long[]{0x0000048300004020L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment231 = new BitSet(new long[]{0x0000048300004020L});
        public static final BitSet FOLLOW_14_in_ruleMutatorEnvironment244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition280 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefinition290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibrary_in_ruleDefinition337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgram_in_ruleDefinition364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary399 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibrary409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLibrary455 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLibrary467 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleLibrary479 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLibrary500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleProgram592 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleProgram613 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleProgram625 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleProgram637 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleProgram658 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleProgram670 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSource_in_ruleProgram691 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleProgram703 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleProgram724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSource_in_entryRuleSource760 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSource770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSource825 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleSource843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMutator_in_entryRuleMutator893 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutator903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_ruleMutator950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_ruleMutator977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_ruleMutator1004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_ruleMutator1166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObSelectionStrategy1211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy1285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy1312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy1339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection1374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomSelection1384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection1430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificSelection1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection1520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection1554 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteSelection1564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection1610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection1644 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherSelection1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_entryRuleAttributeType1734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeType1744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_ruleAttributeType1791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_ruleAttributeType1818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_ruleAttributeType1845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_ruleAttributeType1872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_ruleAttributeType1899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_entryRuleLoad1934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoad1944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleLoad1990 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLoad2011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2048 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString2059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString2125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt2182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleEInt2221 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble2284 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble2295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleEDouble2334 = new BitSet(new long[]{0x0000000002000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2352 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleEDouble2372 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2387 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_26_in_ruleEDouble2407 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_27_in_ruleEDouble2426 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_24_in_ruleEDouble2441 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean2506 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEBoolean2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEBoolean2574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator2614 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator2624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogicOperator_in_ruleBinaryOperator2679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation2715 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluation2725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeEvaluation2779 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleAttributeEvaluation2800 = new BitSet(new long[]{0xFF80000033000050L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeEvaluation2821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation2857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceEvaluation2867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation2922 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_30_in_ruleReferenceEvaluation2940 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReferenceEvaluation2962 = new BitSet(new long[]{0x0040001080400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation2985 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleReferenceEvaluation2998 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleReferenceEvaluation3039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation3076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation3086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation3133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation3160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression3195 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression3205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression3260 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleExpression3282 = new BitSet(new long[]{0x0000000040000020L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression3303 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator3341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveObjectMutator3351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleRemoveObjectMutator3397 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator3418 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleRemoveObjectMutator3431 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveObjectMutator3453 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRemoveObjectMutator3465 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator3488 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRemoveObjectMutator3500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator3538 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveReferenceMutator3548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator3595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator3622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator3649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator3684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator3694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleRemoveRandomReferenceMutator3740 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleRemoveRandomReferenceMutator3752 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleRemoveRandomReferenceMutator3764 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator3784 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleRemoveRandomReferenceMutator3796 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator3816 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleRemoveRandomReferenceMutator3829 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator3851 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRemoveRandomReferenceMutator3863 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator3886 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRemoveRandomReferenceMutator3898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator3936 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator3946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleRemoveSpecificReferenceMutator3992 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleRemoveSpecificReferenceMutator4004 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator4024 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleRemoveSpecificReferenceMutator4036 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator4057 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleRemoveSpecificReferenceMutator4070 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator4092 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRemoveSpecificReferenceMutator4104 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator4127 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRemoveSpecificReferenceMutator4139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator4177 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator4187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleRemoveCompleteReferenceMutator4233 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveCompleteReferenceMutator4245 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleRemoveCompleteReferenceMutator4257 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4277 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleRemoveCompleteReferenceMutator4289 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator4345 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateObjectMutator4355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator4398 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleCreateObjectMutator4415 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleCreateObjectMutator4429 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator4449 = new BitSet(new long[]{0x0000000200100802L});
        public static final BitSet FOLLOW_20_in_ruleCreateObjectMutator4462 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator4483 = new BitSet(new long[]{0x0000000202000802L});
        public static final BitSet FOLLOW_25_in_ruleCreateObjectMutator4496 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator4516 = new BitSet(new long[]{0x0000000200000802L});
        public static final BitSet FOLLOW_11_in_ruleCreateObjectMutator4533 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCreateObjectMutator4545 = new BitSet(new long[]{0x001E410000004020L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator4567 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator4594 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_40_in_ruleCreateObjectMutator4609 = new BitSet(new long[]{0x001E400000000020L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator4631 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator4658 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_14_in_ruleCreateObjectMutator4673 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleCreateObjectMutator4688 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateObjectMutator4710 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleCreateObjectMutator4722 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator4745 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleCreateObjectMutator4757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator4795 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectObjectMutator4805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator4847 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleSelectObjectMutator4864 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleSelectObjectMutator4876 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator4897 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleSelectObjectMutator4910 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator4931 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleSelectObjectMutator4944 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator4964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator5004 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyInformationMutator5014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyInformationMutator5057 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleModifyInformationMutator5074 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleModifyInformationMutator5088 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator5109 = new BitSet(new long[]{0x0000000200000802L});
        public static final BitSet FOLLOW_11_in_ruleModifyInformationMutator5122 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModifyInformationMutator5134 = new BitSet(new long[]{0x001E410000004020L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5156 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5183 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_40_in_ruleModifyInformationMutator5198 = new BitSet(new long[]{0x001E400000000020L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5220 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5247 = new BitSet(new long[]{0x0000010000004000L});
        public static final BitSet FOLLOW_14_in_ruleModifyInformationMutator5262 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleModifyInformationMutator5277 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyInformationMutator5299 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleModifyInformationMutator5311 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator5334 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleModifyInformationMutator5346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator5384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateReferenceMutator5394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator5437 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleCreateReferenceMutator5454 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleCreateReferenceMutator5468 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleCreateReferenceMutator5480 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator5500 = new BitSet(new long[]{0x0000080200100002L});
        public static final BitSet FOLLOW_43_in_ruleCreateReferenceMutator5513 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator5534 = new BitSet(new long[]{0x0000000200100002L});
        public static final BitSet FOLLOW_20_in_ruleCreateReferenceMutator5549 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator5570 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleCreateReferenceMutator5585 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateReferenceMutator5607 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleCreateReferenceMutator5619 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator5642 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleCreateReferenceMutator5654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator5692 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator5702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleModifySourceReferenceMutator5739 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleModifySourceReferenceMutator5751 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator5771 = new BitSet(new long[]{0x0000080200200002L});
        public static final BitSet FOLLOW_21_in_ruleModifySourceReferenceMutator5784 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator5805 = new BitSet(new long[]{0x0000080200000002L});
        public static final BitSet FOLLOW_43_in_ruleModifySourceReferenceMutator5820 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator5841 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleModifySourceReferenceMutator5856 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator5878 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleModifySourceReferenceMutator5890 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator5913 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleModifySourceReferenceMutator5925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator5963 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator5973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleModifyTargetReferenceMutator6010 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleModifyTargetReferenceMutator6022 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator6042 = new BitSet(new long[]{0x0000080200200002L});
        public static final BitSet FOLLOW_21_in_ruleModifyTargetReferenceMutator6055 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6076 = new BitSet(new long[]{0x0000080200000002L});
        public static final BitSet FOLLOW_43_in_ruleModifyTargetReferenceMutator6091 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6112 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleModifyTargetReferenceMutator6127 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator6149 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleModifyTargetReferenceMutator6161 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator6184 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleModifyTargetReferenceMutator6196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator6234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeMutator6244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeMutator6287 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleCompositeMutator6304 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleCompositeMutator6318 = new BitSet(new long[]{0x0000048300000020L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator6339 = new BitSet(new long[]{0x0000048B00000020L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator6360 = new BitSet(new long[]{0x0000048B00000020L});
        public static final BitSet FOLLOW_35_in_ruleCompositeMutator6373 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleCompositeMutator6386 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator6408 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleCompositeMutator6420 = new BitSet(new long[]{0x0000000001000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator6443 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleCompositeMutator6455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet6493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSet6503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeInit_in_ruleAttributeSet6550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_ruleAttributeSet6577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_ruleAttributeSet6604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_ruleAttributeSet6631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_ruleAttributeSet6658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeInit_in_entryRuleAttributeInit6693 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeInit6703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeInit6748 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleAttributeInit6760 = new BitSet(new long[]{0xFF80000033000050L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeInit6781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset6817 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeUnset6827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleAttributeUnset6864 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleAttributeUnset6876 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeUnset6896 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleAttributeUnset6908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap6944 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSwap6954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleAttributeSwap6991 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleAttributeSwap7003 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap7023 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleAttributeSwap7035 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap7057 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAttributeSwap7069 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap7091 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleAttributeSwap7103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy7139 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeCopy7149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleAttributeCopy7186 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleAttributeCopy7198 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy7218 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleAttributeCopy7230 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy7252 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAttributeCopy7264 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy7286 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleAttributeCopy7298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse7334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeReverse7344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleAttributeReverse7381 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleAttributeReverse7393 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeReverse7413 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleAttributeReverse7425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet7461 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSet7471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_ruleReferenceSet7518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_ruleReferenceSet7545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit7580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceInit7590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit7635 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleReferenceInit7647 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit7668 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleReferenceInit7681 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit7701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap7739 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSwap7749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleReferenceSwap7786 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleReferenceSwap7798 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap7818 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleReferenceSwap7830 = new BitSet(new long[]{0x0040001000400020L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap7852 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleReferenceSwap7864 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap7886 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleReferenceSwap7898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection7934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomTypeSelection7944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleRandomTypeSelection7990 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection8010 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleRandomTypeSelection8023 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleRandomTypeSelection8035 = new BitSet(new long[]{0x0000000040000020L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRandomTypeSelection8056 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleRandomTypeSelection8068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection8106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificObjectSelection8116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection8170 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleSpecificObjectSelection8183 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificObjectSelection8195 = new BitSet(new long[]{0x0000000040000020L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificObjectSelection8216 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificObjectSelection8228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection8266 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteTypeSelection8276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleCompleteTypeSelection8322 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection8342 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleCompleteTypeSelection8355 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCompleteTypeSelection8367 = new BitSet(new long[]{0x0000000040000020L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleCompleteTypeSelection8388 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCompleteTypeSelection8400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection8438 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherTypeSelection8448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleOtherTypeSelection8494 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection8514 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleOtherTypeSelection8527 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOtherTypeSelection8539 = new BitSet(new long[]{0x0000000040000020L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleOtherTypeSelection8560 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOtherTypeSelection8572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType8610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType8620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType8667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_ruleBooleanType8694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType8729 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomBooleanType8739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleRandomBooleanType8785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType8821 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificBooleanType8831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType8886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType8922 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringType8932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_ruleStringType8979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_ruleStringType9006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_ruleStringType9033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_ruleStringType9060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_ruleStringType9087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_ruleStringType9114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_ruleStringType9141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType9176 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomStringType9186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleRandomStringType9232 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleRandomStringType9244 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType9265 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleRandomStringType9277 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType9298 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleRandomStringType9310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType9346 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificStringType9356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpecificStringType9407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType9448 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUpperStringType9458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleUpperStringType9504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType9540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatStartStringType9550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleCatStartStringType9596 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleCatStartStringType9608 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatStartStringType9629 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleCatStartStringType9641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType9677 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatEndStringType9687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleCatEndStringType9733 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleCatEndStringType9745 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatEndStringType9766 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleCatEndStringType9778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_entryRuleListStringType9814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListStringType9824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleListStringType9870 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleListStringType9882 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType9903 = new BitSet(new long[]{0x0000010800000000L});
        public static final BitSet FOLLOW_40_in_ruleListStringType9916 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType9937 = new BitSet(new long[]{0x0000010800000000L});
        public static final BitSet FOLLOW_35_in_ruleListStringType9951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType9987 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerStringType9997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleLowerStringType10043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType10079 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReplaceStringType10089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleReplaceStringType10135 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleReplaceStringType10147 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType10168 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleReplaceStringType10180 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType10201 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleReplaceStringType10213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_entryRuleDoubleType10249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleType10259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType10306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_ruleDoubleType10333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType10368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleType10378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleRandomDoubleType10424 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleRandomDoubleType10437 = new BitSet(new long[]{0x0000000003000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType10458 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleRandomDoubleType10470 = new BitSet(new long[]{0x0000000003000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType10491 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleRandomDoubleType10503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType10541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificDoubleType10551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleSpecificDoubleType10606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType10642 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType10652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType10699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_ruleIntegerType10726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType10761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificIntegerType10771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleSpecificIntegerType10826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType10862 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerType10872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleRandomIntegerType10918 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleRandomIntegerType10931 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType10952 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleRandomIntegerType10964 = new BitSet(new long[]{0x0000000001000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType10985 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleRandomIntegerType10997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality11036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxCardinality11047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleMaxCardinality11094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleMaxCardinality11118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleLogicOperator11172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleLogicOperator11189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleOperator11234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleOperator11251 = new BitSet(new long[]{0x0000000000000002L});
    }


}