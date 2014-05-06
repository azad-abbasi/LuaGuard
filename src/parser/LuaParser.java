// $ANTLR 3.5.2 grammars/Lua.g 2014-05-06 12:40:25

package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class LuaParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_VAR", 
		"Add", "And", "Any", "Assign", "BinaryExponent", "Break", "CALL", "CBrace", 
		"CBrack", "CHUNK", "COL_CALL", "CONDITION", "CPar", "Col", "ColCol", "Comma", 
		"Comment", "Digit", "Div", "Do", "Dot", "DotDot", "DotDotDot", "EXPR_LIST", 
		"Else", "Elseif", "End", "Eq", "EscapeSequence", "Exponent", "FIELD", 
		"FIELD_LIST", "FOR_IN", "FUNCTION", "FUNCTION_ASSIGNMENT", "False", "For", 
		"Function", "GT", "GTEq", "Goto", "HexDigit", "HexDigits", "INDEX", "If", 
		"In", "LABEL", "LOCAL_ASSIGNMENT", "LT", "LTEq", "Length", "Letter", "LineBreak", 
		"Local", "LongBracket", "Minus", "Mod", "Mult", "NAME_LIST", "NEq", "Name", 
		"Nil", "Not", "Number", "OBrace", "OBrack", "OPar", "Or", "PARAM_LIST", 
		"Pow", "Repeat", "Return", "SCol", "Space", "String", "TABLE", "Then", 
		"True", "UNARY_MINUS", "Until", "VAR", "VAR_LIST", "While"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_VAR=5;
	public static final int Add=6;
	public static final int And=7;
	public static final int Any=8;
	public static final int Assign=9;
	public static final int BinaryExponent=10;
	public static final int Break=11;
	public static final int CALL=12;
	public static final int CBrace=13;
	public static final int CBrack=14;
	public static final int CHUNK=15;
	public static final int COL_CALL=16;
	public static final int CONDITION=17;
	public static final int CPar=18;
	public static final int Col=19;
	public static final int ColCol=20;
	public static final int Comma=21;
	public static final int Comment=22;
	public static final int Digit=23;
	public static final int Div=24;
	public static final int Do=25;
	public static final int Dot=26;
	public static final int DotDot=27;
	public static final int DotDotDot=28;
	public static final int EXPR_LIST=29;
	public static final int Else=30;
	public static final int Elseif=31;
	public static final int End=32;
	public static final int Eq=33;
	public static final int EscapeSequence=34;
	public static final int Exponent=35;
	public static final int FIELD=36;
	public static final int FIELD_LIST=37;
	public static final int FOR_IN=38;
	public static final int FUNCTION=39;
	public static final int FUNCTION_ASSIGNMENT=40;
	public static final int False=41;
	public static final int For=42;
	public static final int Function=43;
	public static final int GT=44;
	public static final int GTEq=45;
	public static final int Goto=46;
	public static final int HexDigit=47;
	public static final int HexDigits=48;
	public static final int INDEX=49;
	public static final int If=50;
	public static final int In=51;
	public static final int LABEL=52;
	public static final int LOCAL_ASSIGNMENT=53;
	public static final int LT=54;
	public static final int LTEq=55;
	public static final int Length=56;
	public static final int Letter=57;
	public static final int LineBreak=58;
	public static final int Local=59;
	public static final int LongBracket=60;
	public static final int Minus=61;
	public static final int Mod=62;
	public static final int Mult=63;
	public static final int NAME_LIST=64;
	public static final int NEq=65;
	public static final int Name=66;
	public static final int Nil=67;
	public static final int Not=68;
	public static final int Number=69;
	public static final int OBrace=70;
	public static final int OBrack=71;
	public static final int OPar=72;
	public static final int Or=73;
	public static final int PARAM_LIST=74;
	public static final int Pow=75;
	public static final int Repeat=76;
	public static final int Return=77;
	public static final int SCol=78;
	public static final int Space=79;
	public static final int String=80;
	public static final int TABLE=81;
	public static final int Then=82;
	public static final int True=83;
	public static final int UNARY_MINUS=84;
	public static final int Until=85;
	public static final int VAR=86;
	public static final int VAR_LIST=87;
	public static final int While=88;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public LuaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public LuaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return LuaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "grammars/Lua.g"; }



	  private boolean addSelf = false;

	  private CommonTree createPowAST(List tokens) {
	    int n = tokens.size();

	    CommonTree ast = new CommonTree(new CommonToken(Pow, "^"));
	    ast.addChild((CommonTree)tokens.get(n - 2));
	    ast.addChild((CommonTree)tokens.get(n - 1));

	    for(int i = n - 3; i >= 0; i--) {
	      CommonTree temp = new CommonTree(new CommonToken(Pow, "^"));
	      temp.addChild((CommonTree)tokens.get(i));
	      temp.addChild(ast);
	      ast = temp;
	    }

	    return ast;
	  }

	  private CommonTree namesToVar(List<String> names, String name) {
	    names.add(name);
	    return namesToVar(names);
	  }

	  private CommonTree namesToVar(List<String> names) {

	    if(names.size() == 1) {
	      return new CommonTree(new CommonToken(Name, names.get(0)));
	    }

	    CommonTree ast = new CommonTree(new CommonToken(VAR, "VAR"));

	    ast.addChild(new CommonTree(new CommonToken(Name, names.get(0))));

	    for(int i = 1; i < names.size(); i++) {
	      CommonTree indexNode = new CommonTree(new CommonToken(INDEX, "INDEX"));
	      indexNode.addChild(new CommonTree(new CommonToken(Name, names.get(i))));
	      ast.addChild(indexNode);
	    }

	    return ast;
	  }

	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e); 
	  }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// grammars/Lua.g:194:1: parse : chunk EOF -> chunk ;
	public final LuaParser.parse_return parse() throws RecognitionException {
		LuaParser.parse_return retval = new LuaParser.parse_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope chunk1 =null;

		CommonTree EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");

		try {
			// grammars/Lua.g:195:2: ( chunk EOF -> chunk )
			// grammars/Lua.g:195:4: chunk EOF
			{
			pushFollow(FOLLOW_chunk_in_parse857);
			chunk1=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk1.getTree());
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse859); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 195:14: -> chunk
			{
				adaptor.addChild(root_0, stream_chunk.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parse"


	public static class chunk_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "chunk"
	// grammars/Lua.g:198:1: chunk : ( stat )* ( ret_stat )? -> ^( CHUNK ( stat )* ( ret_stat )? ) ;
	public final LuaParser.chunk_return chunk() throws RecognitionException {
		LuaParser.chunk_return retval = new LuaParser.chunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat3 =null;
		ParserRuleReturnScope ret_stat4 =null;

		RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
		RewriteRuleSubtreeStream stream_ret_stat=new RewriteRuleSubtreeStream(adaptor,"rule ret_stat");

		try {
			// grammars/Lua.g:199:2: ( ( stat )* ( ret_stat )? -> ^( CHUNK ( stat )* ( ret_stat )? ) )
			// grammars/Lua.g:199:4: ( stat )* ( ret_stat )?
			{
			// grammars/Lua.g:199:4: ( stat )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Break||LA1_0==ColCol||LA1_0==Do||(LA1_0 >= For && LA1_0 <= Function)||LA1_0==Goto||LA1_0==If||LA1_0==Local||LA1_0==Name||LA1_0==OPar||LA1_0==Repeat||LA1_0==SCol||LA1_0==While) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// grammars/Lua.g:199:4: stat
					{
					pushFollow(FOLLOW_stat_in_chunk874);
					stat3=stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat.add(stat3.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// grammars/Lua.g:199:10: ( ret_stat )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Return) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// grammars/Lua.g:199:10: ret_stat
					{
					pushFollow(FOLLOW_ret_stat_in_chunk877);
					ret_stat4=ret_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_ret_stat.add(ret_stat4.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: stat, ret_stat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 199:20: -> ^( CHUNK ( stat )* ( ret_stat )? )
			{
				// grammars/Lua.g:199:23: ^( CHUNK ( stat )* ( ret_stat )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHUNK, "CHUNK"), root_1);
				// grammars/Lua.g:199:31: ( stat )*
				while ( stream_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_stat.nextTree());
				}
				stream_stat.reset();

				// grammars/Lua.g:199:37: ( ret_stat )?
				if ( stream_ret_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_ret_stat.nextTree());
				}
				stream_ret_stat.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "chunk"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// grammars/Lua.g:202:1: stat : ( ( assignment )=> assignment | var[false] | do_block | while_stat | repeat_stat | local | goto_stat | if_stat | for_stat | function | label | Break | ';' ->);
	public final LuaParser.stat_return stat() throws RecognitionException {
		LuaParser.stat_return retval = new LuaParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Break16=null;
		Token char_literal17=null;
		ParserRuleReturnScope assignment5 =null;
		ParserRuleReturnScope var6 =null;
		ParserRuleReturnScope do_block7 =null;
		ParserRuleReturnScope while_stat8 =null;
		ParserRuleReturnScope repeat_stat9 =null;
		ParserRuleReturnScope local10 =null;
		ParserRuleReturnScope goto_stat11 =null;
		ParserRuleReturnScope if_stat12 =null;
		ParserRuleReturnScope for_stat13 =null;
		ParserRuleReturnScope function14 =null;
		ParserRuleReturnScope label15 =null;

		CommonTree Break16_tree=null;
		CommonTree char_literal17_tree=null;
		RewriteRuleTokenStream stream_SCol=new RewriteRuleTokenStream(adaptor,"token SCol");

		try {
			// grammars/Lua.g:203:2: ( ( assignment )=> assignment | var[false] | do_block | while_stat | repeat_stat | local | goto_stat | if_stat | for_stat | function | label | Break | ';' ->)
			int alt3=13;
			switch ( input.LA(1) ) {
			case OPar:
				{
				int LA3_1 = input.LA(2);
				if ( (synpred1_Lua()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

				}
				break;
			case Name:
				{
				int LA3_2 = input.LA(2);
				if ( (synpred1_Lua()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

				}
				break;
			case Do:
				{
				alt3=3;
				}
				break;
			case While:
				{
				alt3=4;
				}
				break;
			case Repeat:
				{
				alt3=5;
				}
				break;
			case Local:
				{
				alt3=6;
				}
				break;
			case Goto:
				{
				alt3=7;
				}
				break;
			case If:
				{
				alt3=8;
				}
				break;
			case For:
				{
				alt3=9;
				}
				break;
			case Function:
				{
				alt3=10;
				}
				break;
			case ColCol:
				{
				alt3=11;
				}
				break;
			case Break:
				{
				alt3=12;
				}
				break;
			case SCol:
				{
				alt3=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// grammars/Lua.g:203:4: ( assignment )=> assignment
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_stat906);
					assignment5=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment5.getTree());

					}
					break;
				case 2 :
					// grammars/Lua.g:204:4: var[false]
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_in_stat911);
					var6=var(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var6.getTree());

					}
					break;
				case 3 :
					// grammars/Lua.g:205:4: do_block
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_do_block_in_stat942);
					do_block7=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, do_block7.getTree());

					}
					break;
				case 4 :
					// grammars/Lua.g:206:4: while_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_while_stat_in_stat948);
					while_stat8=while_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stat8.getTree());

					}
					break;
				case 5 :
					// grammars/Lua.g:207:4: repeat_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_repeat_stat_in_stat953);
					repeat_stat9=repeat_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_stat9.getTree());

					}
					break;
				case 6 :
					// grammars/Lua.g:208:4: local
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_local_in_stat958);
					local10=local();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local10.getTree());

					}
					break;
				case 7 :
					// grammars/Lua.g:209:4: goto_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_goto_stat_in_stat963);
					goto_stat11=goto_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goto_stat11.getTree());

					}
					break;
				case 8 :
					// grammars/Lua.g:210:4: if_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stat_in_stat968);
					if_stat12=if_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stat12.getTree());

					}
					break;
				case 9 :
					// grammars/Lua.g:211:4: for_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_for_stat_in_stat973);
					for_stat13=for_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stat13.getTree());

					}
					break;
				case 10 :
					// grammars/Lua.g:212:4: function
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_in_stat978);
					function14=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function14.getTree());

					}
					break;
				case 11 :
					// grammars/Lua.g:213:4: label
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_label_in_stat983);
					label15=label();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, label15.getTree());

					}
					break;
				case 12 :
					// grammars/Lua.g:214:4: Break
					{
					root_0 = (CommonTree)adaptor.nil();


					Break16=(Token)match(input,Break,FOLLOW_Break_in_stat988); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Break16_tree = (CommonTree)adaptor.create(Break16);
					adaptor.addChild(root_0, Break16_tree);
					}

					}
					break;
				case 13 :
					// grammars/Lua.g:215:4: ';'
					{
					char_literal17=(Token)match(input,SCol,FOLLOW_SCol_in_stat993); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCol.add(char_literal17);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 215:8: ->
					{
						root_0 = null;
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class do_block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "do_block"
	// grammars/Lua.g:218:1: do_block : Do chunk End -> ^( Do chunk ) ;
	public final LuaParser.do_block_return do_block() throws RecognitionException {
		LuaParser.do_block_return retval = new LuaParser.do_block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Do18=null;
		Token End20=null;
		ParserRuleReturnScope chunk19 =null;

		CommonTree Do18_tree=null;
		CommonTree End20_tree=null;
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");

		try {
			// grammars/Lua.g:219:2: ( Do chunk End -> ^( Do chunk ) )
			// grammars/Lua.g:219:4: Do chunk End
			{
			Do18=(Token)match(input,Do,FOLLOW_Do_in_do_block1008); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Do.add(Do18);

			pushFollow(FOLLOW_chunk_in_do_block1010);
			chunk19=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk19.getTree());
			End20=(Token)match(input,End,FOLLOW_End_in_do_block1012); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End20);

			// AST REWRITE
			// elements: chunk, Do
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 219:17: -> ^( Do chunk )
			{
				// grammars/Lua.g:219:20: ^( Do chunk )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_Do.nextNode(), root_1);
				adaptor.addChild(root_1, stream_chunk.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "do_block"


	public static class while_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "while_stat"
	// grammars/Lua.g:222:1: while_stat : While expr do_block -> ^( While expr do_block ) ;
	public final LuaParser.while_stat_return while_stat() throws RecognitionException {
		LuaParser.while_stat_return retval = new LuaParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token While21=null;
		ParserRuleReturnScope expr22 =null;
		ParserRuleReturnScope do_block23 =null;

		CommonTree While21_tree=null;
		RewriteRuleTokenStream stream_While=new RewriteRuleTokenStream(adaptor,"token While");
		RewriteRuleSubtreeStream stream_do_block=new RewriteRuleSubtreeStream(adaptor,"rule do_block");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:223:2: ( While expr do_block -> ^( While expr do_block ) )
			// grammars/Lua.g:223:4: While expr do_block
			{
			While21=(Token)match(input,While,FOLLOW_While_in_while_stat1031); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_While.add(While21);

			pushFollow(FOLLOW_expr_in_while_stat1033);
			expr22=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr22.getTree());
			pushFollow(FOLLOW_do_block_in_while_stat1035);
			do_block23=do_block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_do_block.add(do_block23.getTree());
			// AST REWRITE
			// elements: While, do_block, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 223:24: -> ^( While expr do_block )
			{
				// grammars/Lua.g:223:27: ^( While expr do_block )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_While.nextNode(), root_1);
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_1, stream_do_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "while_stat"


	public static class repeat_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "repeat_stat"
	// grammars/Lua.g:226:1: repeat_stat : Repeat chunk Until expr -> ^( Repeat chunk expr ) ;
	public final LuaParser.repeat_stat_return repeat_stat() throws RecognitionException {
		LuaParser.repeat_stat_return retval = new LuaParser.repeat_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Repeat24=null;
		Token Until26=null;
		ParserRuleReturnScope chunk25 =null;
		ParserRuleReturnScope expr27 =null;

		CommonTree Repeat24_tree=null;
		CommonTree Until26_tree=null;
		RewriteRuleTokenStream stream_Repeat=new RewriteRuleTokenStream(adaptor,"token Repeat");
		RewriteRuleTokenStream stream_Until=new RewriteRuleTokenStream(adaptor,"token Until");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:227:2: ( Repeat chunk Until expr -> ^( Repeat chunk expr ) )
			// grammars/Lua.g:227:4: Repeat chunk Until expr
			{
			Repeat24=(Token)match(input,Repeat,FOLLOW_Repeat_in_repeat_stat1056); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Repeat.add(Repeat24);

			pushFollow(FOLLOW_chunk_in_repeat_stat1058);
			chunk25=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk25.getTree());
			Until26=(Token)match(input,Until,FOLLOW_Until_in_repeat_stat1060); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Until.add(Until26);

			pushFollow(FOLLOW_expr_in_repeat_stat1062);
			expr27=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr27.getTree());
			// AST REWRITE
			// elements: chunk, expr, Repeat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 227:28: -> ^( Repeat chunk expr )
			{
				// grammars/Lua.g:227:31: ^( Repeat chunk expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_Repeat.nextNode(), root_1);
				adaptor.addChild(root_1, stream_chunk.nextTree());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "repeat_stat"


	public static class assignment_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// grammars/Lua.g:230:1: assignment : var_list '=' expr_list -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) ) ;
	public final LuaParser.assignment_return assignment() throws RecognitionException {
		LuaParser.assignment_return retval = new LuaParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal29=null;
		ParserRuleReturnScope var_list28 =null;
		ParserRuleReturnScope expr_list30 =null;

		CommonTree char_literal29_tree=null;
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_var_list=new RewriteRuleSubtreeStream(adaptor,"rule var_list");

		try {
			// grammars/Lua.g:231:2: ( var_list '=' expr_list -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) ) )
			// grammars/Lua.g:231:4: var_list '=' expr_list
			{
			pushFollow(FOLLOW_var_list_in_assignment1084);
			var_list28=var_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_list.add(var_list28.getTree());
			char_literal29=(Token)match(input,Assign,FOLLOW_Assign_in_assignment1086); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assign.add(char_literal29);

			pushFollow(FOLLOW_expr_list_in_assignment1088);
			expr_list30=expr_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr_list.add(expr_list30.getTree());
			// AST REWRITE
			// elements: var_list, expr_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 232:4: -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) )
			{
				// grammars/Lua.g:232:7: ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// grammars/Lua.g:232:20: ^( VAR_LIST var_list )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
				adaptor.addChild(root_2, stream_var_list.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// grammars/Lua.g:232:41: ^( EXPR_LIST expr_list )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
				adaptor.addChild(root_2, stream_expr_list.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class local_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "local"
	// grammars/Lua.g:235:1: local : Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) ) ;
	public final LuaParser.local_return local() throws RecognitionException {
		LuaParser.local_return retval = new LuaParser.local_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Local31=null;
		Token char_literal33=null;
		Token Function35=null;
		Token Name36=null;
		ParserRuleReturnScope name_list32 =null;
		ParserRuleReturnScope expr_list34 =null;
		ParserRuleReturnScope func_body37 =null;

		CommonTree Local31_tree=null;
		CommonTree char_literal33_tree=null;
		CommonTree Function35_tree=null;
		CommonTree Name36_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleTokenStream stream_Local=new RewriteRuleTokenStream(adaptor,"token Local");
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_name_list=new RewriteRuleSubtreeStream(adaptor,"rule name_list");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:236:2: ( Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) ) )
			// grammars/Lua.g:236:4: Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) )
			{
			Local31=(Token)match(input,Local,FOLLOW_Local_in_local1121); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Local.add(Local31);

			// grammars/Lua.g:236:10: ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Name) ) {
				alt4=1;
			}
			else if ( (LA4_0==Function) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// grammars/Lua.g:236:12: name_list '=' expr_list
					{
					pushFollow(FOLLOW_name_list_in_local1125);
					name_list32=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list32.getTree());
					char_literal33=(Token)match(input,Assign,FOLLOW_Assign_in_local1127); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal33);

					pushFollow(FOLLOW_expr_list_in_local1129);
					expr_list34=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list34.getTree());
					// AST REWRITE
					// elements: expr_list, name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 236:36: -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) )
					{
						// grammars/Lua.g:236:39: ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_ASSIGNMENT, "LOCAL_ASSIGNMENT"), root_1);
						// grammars/Lua.g:236:58: ^( NAME_LIST name_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_name_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:236:81: ^( EXPR_LIST expr_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
						adaptor.addChild(root_2, stream_expr_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:237:12: Function Name func_body
					{
					Function35=(Token)match(input,Function,FOLLOW_Function_in_local1160); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Function.add(Function35);

					Name36=(Token)match(input,Name,FOLLOW_Name_in_local1162); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name36);

					pushFollow(FOLLOW_func_body_in_local1164);
					func_body37=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body37.getTree());
					// AST REWRITE
					// elements: Name, func_body
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 237:36: -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:237:39: ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_ASSIGNMENT, "LOCAL_ASSIGNMENT"), root_1);
						// grammars/Lua.g:237:58: ^( NAME_LIST Name )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_Name.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:237:76: ^( EXPR_LIST func_body )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
						adaptor.addChild(root_2, stream_func_body.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "local"


	public static class goto_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goto_stat"
	// grammars/Lua.g:241:1: goto_stat : Goto Name -> ^( Goto Name ) ;
	public final LuaParser.goto_stat_return goto_stat() throws RecognitionException {
		LuaParser.goto_stat_return retval = new LuaParser.goto_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Goto38=null;
		Token Name39=null;

		CommonTree Goto38_tree=null;
		CommonTree Name39_tree=null;
		RewriteRuleTokenStream stream_Goto=new RewriteRuleTokenStream(adaptor,"token Goto");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:242:2: ( Goto Name -> ^( Goto Name ) )
			// grammars/Lua.g:242:4: Goto Name
			{
			Goto38=(Token)match(input,Goto,FOLLOW_Goto_in_goto_stat1204); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Goto.add(Goto38);

			Name39=(Token)match(input,Name,FOLLOW_Name_in_goto_stat1206); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name39);

			// AST REWRITE
			// elements: Name, Goto
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 242:14: -> ^( Goto Name )
			{
				// grammars/Lua.g:242:17: ^( Goto Name )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_Goto.nextNode(), root_1);
				adaptor.addChild(root_1, stream_Name.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "goto_stat"


	public static class if_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_stat"
	// grammars/Lua.g:245:1: if_stat : If expr Then chunk ( elseif_stat )* ( else_stat )? End -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? ) ;
	public final LuaParser.if_stat_return if_stat() throws RecognitionException {
		LuaParser.if_stat_return retval = new LuaParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token If40=null;
		Token Then42=null;
		Token End46=null;
		ParserRuleReturnScope expr41 =null;
		ParserRuleReturnScope chunk43 =null;
		ParserRuleReturnScope elseif_stat44 =null;
		ParserRuleReturnScope else_stat45 =null;

		CommonTree If40_tree=null;
		CommonTree Then42_tree=null;
		CommonTree End46_tree=null;
		RewriteRuleTokenStream stream_Then=new RewriteRuleTokenStream(adaptor,"token Then");
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_elseif_stat=new RewriteRuleSubtreeStream(adaptor,"rule elseif_stat");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_else_stat=new RewriteRuleSubtreeStream(adaptor,"rule else_stat");

		try {
			// grammars/Lua.g:246:2: ( If expr Then chunk ( elseif_stat )* ( else_stat )? End -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? ) )
			// grammars/Lua.g:246:4: If expr Then chunk ( elseif_stat )* ( else_stat )? End
			{
			If40=(Token)match(input,If,FOLLOW_If_in_if_stat1225); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If40);

			pushFollow(FOLLOW_expr_in_if_stat1227);
			expr41=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr41.getTree());
			Then42=(Token)match(input,Then,FOLLOW_Then_in_if_stat1229); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Then.add(Then42);

			pushFollow(FOLLOW_chunk_in_if_stat1231);
			chunk43=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk43.getTree());
			// grammars/Lua.g:246:23: ( elseif_stat )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==Elseif) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// grammars/Lua.g:246:23: elseif_stat
					{
					pushFollow(FOLLOW_elseif_stat_in_if_stat1233);
					elseif_stat44=elseif_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseif_stat.add(elseif_stat44.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// grammars/Lua.g:246:36: ( else_stat )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Else) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// grammars/Lua.g:246:36: else_stat
					{
					pushFollow(FOLLOW_else_stat_in_if_stat1236);
					else_stat45=else_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_else_stat.add(else_stat45.getTree());
					}
					break;

			}

			End46=(Token)match(input,End,FOLLOW_End_in_if_stat1239); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End46);

			// AST REWRITE
			// elements: If, chunk, expr, elseif_stat, else_stat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 246:51: -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? )
			{
				// grammars/Lua.g:246:54: ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_If.nextNode(), root_1);
				// grammars/Lua.g:246:59: ^( CONDITION expr chunk )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_2);
				adaptor.addChild(root_2, stream_expr.nextTree());
				adaptor.addChild(root_2, stream_chunk.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// grammars/Lua.g:246:83: ( elseif_stat )*
				while ( stream_elseif_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_elseif_stat.nextTree());
				}
				stream_elseif_stat.reset();

				// grammars/Lua.g:246:96: ( else_stat )?
				if ( stream_else_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_else_stat.nextTree());
				}
				stream_else_stat.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_stat"


	public static class elseif_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elseif_stat"
	// grammars/Lua.g:249:1: elseif_stat : Elseif expr Then chunk -> ^( CONDITION expr chunk ) ;
	public final LuaParser.elseif_stat_return elseif_stat() throws RecognitionException {
		LuaParser.elseif_stat_return retval = new LuaParser.elseif_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Elseif47=null;
		Token Then49=null;
		ParserRuleReturnScope expr48 =null;
		ParserRuleReturnScope chunk50 =null;

		CommonTree Elseif47_tree=null;
		CommonTree Then49_tree=null;
		RewriteRuleTokenStream stream_Elseif=new RewriteRuleTokenStream(adaptor,"token Elseif");
		RewriteRuleTokenStream stream_Then=new RewriteRuleTokenStream(adaptor,"token Then");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:250:2: ( Elseif expr Then chunk -> ^( CONDITION expr chunk ) )
			// grammars/Lua.g:250:4: Elseif expr Then chunk
			{
			Elseif47=(Token)match(input,Elseif,FOLLOW_Elseif_in_elseif_stat1270); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Elseif.add(Elseif47);

			pushFollow(FOLLOW_expr_in_elseif_stat1272);
			expr48=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr48.getTree());
			Then49=(Token)match(input,Then,FOLLOW_Then_in_elseif_stat1274); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Then.add(Then49);

			pushFollow(FOLLOW_chunk_in_elseif_stat1276);
			chunk50=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk50.getTree());
			// AST REWRITE
			// elements: expr, chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 250:27: -> ^( CONDITION expr chunk )
			{
				// grammars/Lua.g:250:30: ^( CONDITION expr chunk )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_1, stream_chunk.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elseif_stat"


	public static class else_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "else_stat"
	// grammars/Lua.g:253:1: else_stat : Else chunk -> ^( CONDITION True chunk ) ;
	public final LuaParser.else_stat_return else_stat() throws RecognitionException {
		LuaParser.else_stat_return retval = new LuaParser.else_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Else51=null;
		ParserRuleReturnScope chunk52 =null;

		CommonTree Else51_tree=null;
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");

		try {
			// grammars/Lua.g:254:2: ( Else chunk -> ^( CONDITION True chunk ) )
			// grammars/Lua.g:254:4: Else chunk
			{
			Else51=(Token)match(input,Else,FOLLOW_Else_in_else_stat1297); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else51);

			pushFollow(FOLLOW_chunk_in_else_stat1299);
			chunk52=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk52.getTree());
			// AST REWRITE
			// elements: chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 254:15: -> ^( CONDITION True chunk )
			{
				// grammars/Lua.g:254:18: ^( CONDITION True chunk )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(True, "True"));
				adaptor.addChild(root_1, stream_chunk.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "else_stat"


	public static class for_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "for_stat"
	// grammars/Lua.g:257:1: for_stat : For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) ) ;
	public final LuaParser.for_stat_return for_stat() throws RecognitionException {
		LuaParser.for_stat_return retval = new LuaParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token For53=null;
		Token Name54=null;
		Token char_literal55=null;
		Token char_literal56=null;
		Token char_literal57=null;
		Token In60=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope do_block58 =null;
		ParserRuleReturnScope name_list59 =null;
		ParserRuleReturnScope expr_list61 =null;
		ParserRuleReturnScope do_block62 =null;

		CommonTree For53_tree=null;
		CommonTree Name54_tree=null;
		CommonTree char_literal55_tree=null;
		CommonTree char_literal56_tree=null;
		CommonTree char_literal57_tree=null;
		CommonTree In60_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
		RewriteRuleTokenStream stream_For=new RewriteRuleTokenStream(adaptor,"token For");
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_do_block=new RewriteRuleSubtreeStream(adaptor,"rule do_block");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_name_list=new RewriteRuleSubtreeStream(adaptor,"rule name_list");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:258:2: ( For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) ) )
			// grammars/Lua.g:258:4: For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) )
			{
			For53=(Token)match(input,For,FOLLOW_For_in_for_stat1320); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_For.add(For53);

			// grammars/Lua.g:258:8: ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Name) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==Assign) ) {
					alt8=1;
				}
				else if ( (LA8_1==Comma||LA8_1==In) ) {
					alt8=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// grammars/Lua.g:258:10: Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block
					{
					Name54=(Token)match(input,Name,FOLLOW_Name_in_for_stat1324); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name54);

					char_literal55=(Token)match(input,Assign,FOLLOW_Assign_in_for_stat1326); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal55);

					pushFollow(FOLLOW_expr_in_for_stat1330);
					a=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(a.getTree());
					char_literal56=(Token)match(input,Comma,FOLLOW_Comma_in_for_stat1332); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal56);

					pushFollow(FOLLOW_expr_in_for_stat1336);
					b=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(b.getTree());
					// grammars/Lua.g:258:37: ( ',' c= expr )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==Comma) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// grammars/Lua.g:258:38: ',' c= expr
							{
							char_literal57=(Token)match(input,Comma,FOLLOW_Comma_in_for_stat1339); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Comma.add(char_literal57);

							pushFollow(FOLLOW_expr_in_for_stat1343);
							c=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(c.getTree());
							}
							break;

					}

					pushFollow(FOLLOW_do_block_in_for_stat1347);
					do_block58=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_do_block.add(do_block58.getTree());
					// AST REWRITE
					// elements: c, do_block, For, Name, b, a
					// token labels: 
					// rule labels: a, b, c, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 258:60: -> ^( For Name $a $b ( $c)? do_block )
					{
						// grammars/Lua.g:258:63: ^( For Name $a $b ( $c)? do_block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_For.nextNode(), root_1);
						adaptor.addChild(root_1, stream_Name.nextNode());
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						// grammars/Lua.g:258:81: ( $c)?
						if ( stream_c.hasNext() ) {
							adaptor.addChild(root_1, stream_c.nextTree());
						}
						stream_c.reset();

						adaptor.addChild(root_1, stream_do_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:259:10: name_list In expr_list do_block
					{
					pushFollow(FOLLOW_name_list_in_for_stat1378);
					name_list59=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list59.getTree());
					In60=(Token)match(input,In,FOLLOW_In_in_for_stat1380); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_In.add(In60);

					pushFollow(FOLLOW_expr_list_in_for_stat1382);
					expr_list61=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list61.getTree());
					pushFollow(FOLLOW_do_block_in_for_stat1384);
					do_block62=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_do_block.add(do_block62.getTree());
					// AST REWRITE
					// elements: expr_list, do_block, name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 259:60: -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block )
					{
						// grammars/Lua.g:259:63: ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_IN, "FOR_IN"), root_1);
						// grammars/Lua.g:259:72: ^( NAME_LIST name_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_name_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:259:95: ^( EXPR_LIST expr_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
						adaptor.addChild(root_2, stream_expr_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_do_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_stat"


	public static class function_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function"
	// grammars/Lua.g:263:1: function : Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) ) ;
	public final LuaParser.function_return function() throws RecognitionException {
		LuaParser.function_return retval = new LuaParser.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Function63=null;
		Token Col65=null;
		Token Name66=null;
		ParserRuleReturnScope names64 =null;
		ParserRuleReturnScope func_body67 =null;
		ParserRuleReturnScope func_body68 =null;

		CommonTree Function63_tree=null;
		CommonTree Col65_tree=null;
		CommonTree Name66_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleTokenStream stream_Col=new RewriteRuleTokenStream(adaptor,"token Col");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_names=new RewriteRuleSubtreeStream(adaptor,"rule names");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:264:2: ( Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) ) )
			// grammars/Lua.g:264:4: Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) )
			{
			Function63=(Token)match(input,Function,FOLLOW_Function_in_function1442); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Function.add(Function63);

			pushFollow(FOLLOW_names_in_function1444);
			names64=names();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_names.add(names64.getTree());
			// grammars/Lua.g:264:19: ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==Col) ) {
				alt9=1;
			}
			else if ( (LA9_0==OPar) ) {
				alt9=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// grammars/Lua.g:264:21: Col Name func_body
					{
					Col65=(Token)match(input,Col,FOLLOW_Col_in_function1448); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(Col65);

					Name66=(Token)match(input,Name,FOLLOW_Name_in_function1450); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name66);

					if ( state.backtracking==0 ) {addSelf=true;}
					pushFollow(FOLLOW_func_body_in_function1454);
					func_body67=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body67.getTree());
					if ( state.backtracking==0 ) {addSelf=false;}
					// AST REWRITE
					// elements: func_body
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 265:21: -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:265:24: ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_ASSIGNMENT, "FUNCTION_ASSIGNMENT"), root_1);
						// grammars/Lua.g:265:46: ^( VAR_LIST )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
						adaptor.addChild(root_2, namesToVar((names64!=null?((LuaParser.names_return)names64).list:null), (Name66!=null?Name66.getText():null)));
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:265:96: ^( EXPR_LIST func_body )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
						adaptor.addChild(root_2, stream_func_body.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:266:21: func_body
					{
					pushFollow(FOLLOW_func_body_in_function1517);
					func_body68=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body68.getTree());
					// AST REWRITE
					// elements: func_body
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 267:21: -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:267:24: ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_ASSIGNMENT, "FUNCTION_ASSIGNMENT"), root_1);
						// grammars/Lua.g:267:46: ^( VAR_LIST )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
						adaptor.addChild(root_2, namesToVar((names64!=null?((LuaParser.names_return)names64).list:null)));
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:267:84: ^( EXPR_LIST func_body )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_2);
						adaptor.addChild(root_2, stream_func_body.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class names_return extends ParserRuleReturnScope {
		public List<String> list;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "names"
	// grammars/Lua.g:271:1: names returns [List<String> list] : a= Name ( '.' b= Name )* ;
	public final LuaParser.names_return names() throws RecognitionException {
		LuaParser.names_return retval = new LuaParser.names_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token a=null;
		Token b=null;
		Token char_literal69=null;

		CommonTree a_tree=null;
		CommonTree b_tree=null;
		CommonTree char_literal69_tree=null;

		retval.list = new ArrayList<String>();
		try {
			// grammars/Lua.g:273:2: (a= Name ( '.' b= Name )* )
			// grammars/Lua.g:273:4: a= Name ( '.' b= Name )*
			{
			root_0 = (CommonTree)adaptor.nil();


			a=(Token)match(input,Name,FOLLOW_Name_in_names1596); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			a_tree = (CommonTree)adaptor.create(a);
			adaptor.addChild(root_0, a_tree);
			}

			if ( state.backtracking==0 ) {retval.list.add((a!=null?a.getText():null));}
			// grammars/Lua.g:273:33: ( '.' b= Name )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Dot) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// grammars/Lua.g:273:34: '.' b= Name
					{
					char_literal69=(Token)match(input,Dot,FOLLOW_Dot_in_names1601); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal69_tree = (CommonTree)adaptor.create(char_literal69);
					adaptor.addChild(root_0, char_literal69_tree);
					}

					b=(Token)match(input,Name,FOLLOW_Name_in_names1605); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					b_tree = (CommonTree)adaptor.create(b);
					adaptor.addChild(root_0, b_tree);
					}

					if ( state.backtracking==0 ) {retval.list.add((b!=null?b.getText():null));}
					}
					break;

				default :
					break loop10;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "names"


	public static class function_literal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function_literal"
	// grammars/Lua.g:276:1: function_literal : Function func_body -> func_body ;
	public final LuaParser.function_literal_return function_literal() throws RecognitionException {
		LuaParser.function_literal_return retval = new LuaParser.function_literal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Function70=null;
		ParserRuleReturnScope func_body71 =null;

		CommonTree Function70_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:277:2: ( Function func_body -> func_body )
			// grammars/Lua.g:277:4: Function func_body
			{
			Function70=(Token)match(input,Function,FOLLOW_Function_in_function_literal1620); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Function.add(Function70);

			pushFollow(FOLLOW_func_body_in_function_literal1622);
			func_body71=func_body();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_body.add(func_body71.getTree());
			// AST REWRITE
			// elements: func_body
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 277:23: -> func_body
			{
				adaptor.addChild(root_0, stream_func_body.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_literal"


	public static class func_body_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_body"
	// grammars/Lua.g:280:1: func_body : '(' param_list ')' chunk End -> ^( FUNCTION param_list chunk ) ;
	public final LuaParser.func_body_return func_body() throws RecognitionException {
		LuaParser.func_body_return retval = new LuaParser.func_body_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal72=null;
		Token char_literal74=null;
		Token End76=null;
		ParserRuleReturnScope param_list73 =null;
		ParserRuleReturnScope chunk75 =null;

		CommonTree char_literal72_tree=null;
		CommonTree char_literal74_tree=null;
		CommonTree End76_tree=null;
		RewriteRuleTokenStream stream_CPar=new RewriteRuleTokenStream(adaptor,"token CPar");
		RewriteRuleTokenStream stream_OPar=new RewriteRuleTokenStream(adaptor,"token OPar");
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// grammars/Lua.g:281:2: ( '(' param_list ')' chunk End -> ^( FUNCTION param_list chunk ) )
			// grammars/Lua.g:281:4: '(' param_list ')' chunk End
			{
			char_literal72=(Token)match(input,OPar,FOLLOW_OPar_in_func_body1637); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OPar.add(char_literal72);

			pushFollow(FOLLOW_param_list_in_func_body1639);
			param_list73=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list73.getTree());
			char_literal74=(Token)match(input,CPar,FOLLOW_CPar_in_func_body1641); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CPar.add(char_literal74);

			pushFollow(FOLLOW_chunk_in_func_body1643);
			chunk75=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk75.getTree());
			End76=(Token)match(input,End,FOLLOW_End_in_func_body1645); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End76);

			// AST REWRITE
			// elements: param_list, chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 281:33: -> ^( FUNCTION param_list chunk )
			{
				// grammars/Lua.g:281:36: ^( FUNCTION param_list chunk )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				adaptor.addChild(root_1, stream_param_list.nextTree());
				adaptor.addChild(root_1, stream_chunk.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_body"


	public static class param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// grammars/Lua.g:284:1: param_list : ( name_list ( ',' DotDotDot )? -> ^( PARAM_LIST name_list ( DotDotDot )? ) | ( DotDotDot )? -> ^( PARAM_LIST ( DotDotDot )? ) );
	public final LuaParser.param_list_return param_list() throws RecognitionException {
		LuaParser.param_list_return retval = new LuaParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal78=null;
		Token DotDotDot79=null;
		Token DotDotDot80=null;
		ParserRuleReturnScope name_list77 =null;

		CommonTree char_literal78_tree=null;
		CommonTree DotDotDot79_tree=null;
		CommonTree DotDotDot80_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_DotDotDot=new RewriteRuleTokenStream(adaptor,"token DotDotDot");
		RewriteRuleSubtreeStream stream_name_list=new RewriteRuleSubtreeStream(adaptor,"rule name_list");

		try {
			// grammars/Lua.g:285:2: ( name_list ( ',' DotDotDot )? -> ^( PARAM_LIST name_list ( DotDotDot )? ) | ( DotDotDot )? -> ^( PARAM_LIST ( DotDotDot )? ) )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==Name) ) {
				alt13=1;
			}
			else if ( (LA13_0==CPar||LA13_0==DotDotDot) ) {
				alt13=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// grammars/Lua.g:285:4: name_list ( ',' DotDotDot )?
					{
					pushFollow(FOLLOW_name_list_in_param_list1666);
					name_list77=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list77.getTree());
					// grammars/Lua.g:285:14: ( ',' DotDotDot )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==Comma) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// grammars/Lua.g:285:15: ',' DotDotDot
							{
							char_literal78=(Token)match(input,Comma,FOLLOW_Comma_in_param_list1669); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Comma.add(char_literal78);

							DotDotDot79=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_param_list1671); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DotDotDot.add(DotDotDot79);

							}
							break;

					}

					// AST REWRITE
					// elements: DotDotDot, name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 285:31: -> ^( PARAM_LIST name_list ( DotDotDot )? )
					{
						// grammars/Lua.g:285:34: ^( PARAM_LIST name_list ( DotDotDot )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_LIST, "PARAM_LIST"), root_1);
						adaptor.addChild(root_1, stream_name_list.nextTree());
						// grammars/Lua.g:285:57: ( DotDotDot )?
						if ( stream_DotDotDot.hasNext() ) {
							adaptor.addChild(root_1, stream_DotDotDot.nextNode());
						}
						stream_DotDotDot.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:286:4: ( DotDotDot )?
					{
					// grammars/Lua.g:286:4: ( DotDotDot )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==DotDotDot) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// grammars/Lua.g:286:4: DotDotDot
							{
							DotDotDot80=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_param_list1689); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DotDotDot.add(DotDotDot80);

							}
							break;

					}

					// AST REWRITE
					// elements: DotDotDot
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 286:31: -> ^( PARAM_LIST ( DotDotDot )? )
					{
						// grammars/Lua.g:286:34: ^( PARAM_LIST ( DotDotDot )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_LIST, "PARAM_LIST"), root_1);
						// grammars/Lua.g:286:47: ( DotDotDot )?
						if ( stream_DotDotDot.hasNext() ) {
							adaptor.addChild(root_1, stream_DotDotDot.nextNode());
						}
						stream_DotDotDot.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "param_list"


	public static class ret_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret_stat"
	// grammars/Lua.g:289:1: ret_stat : Return ( expr_list )? ( ';' )? -> ^( Return ( expr_list )? ) ;
	public final LuaParser.ret_stat_return ret_stat() throws RecognitionException {
		LuaParser.ret_stat_return retval = new LuaParser.ret_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Return81=null;
		Token char_literal83=null;
		ParserRuleReturnScope expr_list82 =null;

		CommonTree Return81_tree=null;
		CommonTree char_literal83_tree=null;
		RewriteRuleTokenStream stream_Return=new RewriteRuleTokenStream(adaptor,"token Return");
		RewriteRuleTokenStream stream_SCol=new RewriteRuleTokenStream(adaptor,"token SCol");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// grammars/Lua.g:290:2: ( Return ( expr_list )? ( ';' )? -> ^( Return ( expr_list )? ) )
			// grammars/Lua.g:290:4: Return ( expr_list )? ( ';' )?
			{
			Return81=(Token)match(input,Return,FOLLOW_Return_in_ret_stat1726); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Return.add(Return81);

			// grammars/Lua.g:290:11: ( expr_list )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==DotDotDot||LA14_0==False||LA14_0==Function||LA14_0==Length||LA14_0==Minus||(LA14_0 >= Name && LA14_0 <= OBrace)||LA14_0==OPar||LA14_0==String||LA14_0==True) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// grammars/Lua.g:290:11: expr_list
					{
					pushFollow(FOLLOW_expr_list_in_ret_stat1728);
					expr_list82=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list82.getTree());
					}
					break;

			}

			// grammars/Lua.g:290:22: ( ';' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==SCol) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// grammars/Lua.g:290:22: ';'
					{
					char_literal83=(Token)match(input,SCol,FOLLOW_SCol_in_ret_stat1731); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCol.add(char_literal83);

					}
					break;

			}

			// AST REWRITE
			// elements: expr_list, Return
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 290:27: -> ^( Return ( expr_list )? )
			{
				// grammars/Lua.g:290:30: ^( Return ( expr_list )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_Return.nextNode(), root_1);
				// grammars/Lua.g:290:39: ( expr_list )?
				if ( stream_expr_list.hasNext() ) {
					adaptor.addChild(root_1, stream_expr_list.nextTree());
				}
				stream_expr_list.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ret_stat"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// grammars/Lua.g:293:1: expr : or_expr ;
	public final LuaParser.expr_return expr() throws RecognitionException {
		LuaParser.expr_return retval = new LuaParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope or_expr84 =null;


		try {
			// grammars/Lua.g:294:2: ( or_expr )
			// grammars/Lua.g:294:4: or_expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_or_expr_in_expr1752);
			or_expr84=or_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, or_expr84.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class or_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "or_expr"
	// grammars/Lua.g:297:1: or_expr : and_expr ( Or ^ and_expr )* ;
	public final LuaParser.or_expr_return or_expr() throws RecognitionException {
		LuaParser.or_expr_return retval = new LuaParser.or_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Or86=null;
		ParserRuleReturnScope and_expr85 =null;
		ParserRuleReturnScope and_expr87 =null;

		CommonTree Or86_tree=null;

		try {
			// grammars/Lua.g:298:2: ( and_expr ( Or ^ and_expr )* )
			// grammars/Lua.g:298:4: and_expr ( Or ^ and_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_and_expr_in_or_expr1763);
			and_expr85=and_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr85.getTree());

			// grammars/Lua.g:298:13: ( Or ^ and_expr )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==Or) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// grammars/Lua.g:298:14: Or ^ and_expr
					{
					Or86=(Token)match(input,Or,FOLLOW_Or_in_or_expr1766); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Or86_tree = (CommonTree)adaptor.create(Or86);
					root_0 = (CommonTree)adaptor.becomeRoot(Or86_tree, root_0);
					}

					pushFollow(FOLLOW_and_expr_in_or_expr1769);
					and_expr87=and_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr87.getTree());

					}
					break;

				default :
					break loop16;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "or_expr"


	public static class and_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "and_expr"
	// grammars/Lua.g:301:1: and_expr : rel_expr ( And ^ rel_expr )* ;
	public final LuaParser.and_expr_return and_expr() throws RecognitionException {
		LuaParser.and_expr_return retval = new LuaParser.and_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token And89=null;
		ParserRuleReturnScope rel_expr88 =null;
		ParserRuleReturnScope rel_expr90 =null;

		CommonTree And89_tree=null;

		try {
			// grammars/Lua.g:302:2: ( rel_expr ( And ^ rel_expr )* )
			// grammars/Lua.g:302:4: rel_expr ( And ^ rel_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_rel_expr_in_and_expr1782);
			rel_expr88=rel_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_expr88.getTree());

			// grammars/Lua.g:302:13: ( And ^ rel_expr )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==And) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// grammars/Lua.g:302:14: And ^ rel_expr
					{
					And89=(Token)match(input,And,FOLLOW_And_in_and_expr1785); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					And89_tree = (CommonTree)adaptor.create(And89);
					root_0 = (CommonTree)adaptor.becomeRoot(And89_tree, root_0);
					}

					pushFollow(FOLLOW_rel_expr_in_and_expr1788);
					rel_expr90=rel_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_expr90.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "and_expr"


	public static class rel_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_expr"
	// grammars/Lua.g:305:1: rel_expr : concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )? ;
	public final LuaParser.rel_expr_return rel_expr() throws RecognitionException {
		LuaParser.rel_expr_return retval = new LuaParser.rel_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set92=null;
		ParserRuleReturnScope concat_expr91 =null;
		ParserRuleReturnScope concat_expr93 =null;

		CommonTree set92_tree=null;

		try {
			// grammars/Lua.g:306:2: ( concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )? )
			// grammars/Lua.g:306:4: concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_concat_expr_in_rel_expr1801);
			concat_expr91=concat_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, concat_expr91.getTree());

			// grammars/Lua.g:306:16: ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==Eq||(LA18_0 >= GT && LA18_0 <= GTEq)||(LA18_0 >= LT && LA18_0 <= LTEq)||LA18_0==NEq) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// grammars/Lua.g:306:17: ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr
					{
					set92=input.LT(1);
					set92=input.LT(1);
					if ( input.LA(1)==Eq||(input.LA(1) >= GT && input.LA(1) <= GTEq)||(input.LA(1) >= LT && input.LA(1) <= LTEq)||input.LA(1)==NEq ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set92), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_concat_expr_in_rel_expr1829);
					concat_expr93=concat_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, concat_expr93.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rel_expr"


	public static class concat_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "concat_expr"
	// grammars/Lua.g:309:1: concat_expr : add_expr ( DotDot ^ add_expr )* ;
	public final LuaParser.concat_expr_return concat_expr() throws RecognitionException {
		LuaParser.concat_expr_return retval = new LuaParser.concat_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DotDot95=null;
		ParserRuleReturnScope add_expr94 =null;
		ParserRuleReturnScope add_expr96 =null;

		CommonTree DotDot95_tree=null;

		try {
			// grammars/Lua.g:310:2: ( add_expr ( DotDot ^ add_expr )* )
			// grammars/Lua.g:310:4: add_expr ( DotDot ^ add_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_add_expr_in_concat_expr1842);
			add_expr94=add_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr94.getTree());

			// grammars/Lua.g:310:13: ( DotDot ^ add_expr )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==DotDot) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// grammars/Lua.g:310:14: DotDot ^ add_expr
					{
					DotDot95=(Token)match(input,DotDot,FOLLOW_DotDot_in_concat_expr1845); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DotDot95_tree = (CommonTree)adaptor.create(DotDot95);
					root_0 = (CommonTree)adaptor.becomeRoot(DotDot95_tree, root_0);
					}

					pushFollow(FOLLOW_add_expr_in_concat_expr1848);
					add_expr96=add_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr96.getTree());

					}
					break;

				default :
					break loop19;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "concat_expr"


	public static class add_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "add_expr"
	// grammars/Lua.g:313:1: add_expr : mult_expr ( ( Add | Minus ) ^ mult_expr )* ;
	public final LuaParser.add_expr_return add_expr() throws RecognitionException {
		LuaParser.add_expr_return retval = new LuaParser.add_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set98=null;
		ParserRuleReturnScope mult_expr97 =null;
		ParserRuleReturnScope mult_expr99 =null;

		CommonTree set98_tree=null;

		try {
			// grammars/Lua.g:314:2: ( mult_expr ( ( Add | Minus ) ^ mult_expr )* )
			// grammars/Lua.g:314:4: mult_expr ( ( Add | Minus ) ^ mult_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_mult_expr_in_add_expr1861);
			mult_expr97=mult_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr97.getTree());

			// grammars/Lua.g:314:14: ( ( Add | Minus ) ^ mult_expr )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==Add||LA20_0==Minus) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// grammars/Lua.g:314:15: ( Add | Minus ) ^ mult_expr
					{
					set98=input.LT(1);
					set98=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Minus ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set98), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mult_expr_in_add_expr1873);
					mult_expr99=mult_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr99.getTree());

					}
					break;

				default :
					break loop20;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "add_expr"


	public static class mult_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mult_expr"
	// grammars/Lua.g:317:1: mult_expr : unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )* ;
	public final LuaParser.mult_expr_return mult_expr() throws RecognitionException {
		LuaParser.mult_expr_return retval = new LuaParser.mult_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set101=null;
		ParserRuleReturnScope unary_expr100 =null;
		ParserRuleReturnScope unary_expr102 =null;

		CommonTree set101_tree=null;

		try {
			// grammars/Lua.g:318:2: ( unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )* )
			// grammars/Lua.g:318:4: unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unary_expr_in_mult_expr1886);
			unary_expr100=unary_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr100.getTree());

			// grammars/Lua.g:318:15: ( ( Mult | Div | Mod ) ^ unary_expr )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==Div||(LA21_0 >= Mod && LA21_0 <= Mult)) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// grammars/Lua.g:318:16: ( Mult | Div | Mod ) ^ unary_expr
					{
					set101=input.LT(1);
					set101=input.LT(1);
					if ( input.LA(1)==Div||(input.LA(1) >= Mod && input.LA(1) <= Mult) ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set101), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unary_expr_in_mult_expr1902);
					unary_expr102=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr102.getTree());

					}
					break;

				default :
					break loop21;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mult_expr"


	public static class unary_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary_expr"
	// grammars/Lua.g:321:1: unary_expr : ( Minus unary_expr -> ^( UNARY_MINUS unary_expr ) | Length pow_expr -> ^( Length pow_expr ) | Not unary_expr -> ^( Not unary_expr ) | pow_expr );
	public final LuaParser.unary_expr_return unary_expr() throws RecognitionException {
		LuaParser.unary_expr_return retval = new LuaParser.unary_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Minus103=null;
		Token Length105=null;
		Token Not107=null;
		ParserRuleReturnScope unary_expr104 =null;
		ParserRuleReturnScope pow_expr106 =null;
		ParserRuleReturnScope unary_expr108 =null;
		ParserRuleReturnScope pow_expr109 =null;

		CommonTree Minus103_tree=null;
		CommonTree Length105_tree=null;
		CommonTree Not107_tree=null;
		RewriteRuleTokenStream stream_Not=new RewriteRuleTokenStream(adaptor,"token Not");
		RewriteRuleTokenStream stream_Length=new RewriteRuleTokenStream(adaptor,"token Length");
		RewriteRuleTokenStream stream_Minus=new RewriteRuleTokenStream(adaptor,"token Minus");
		RewriteRuleSubtreeStream stream_unary_expr=new RewriteRuleSubtreeStream(adaptor,"rule unary_expr");
		RewriteRuleSubtreeStream stream_pow_expr=new RewriteRuleSubtreeStream(adaptor,"rule pow_expr");

		try {
			// grammars/Lua.g:322:2: ( Minus unary_expr -> ^( UNARY_MINUS unary_expr ) | Length pow_expr -> ^( Length pow_expr ) | Not unary_expr -> ^( Not unary_expr ) | pow_expr )
			int alt22=4;
			switch ( input.LA(1) ) {
			case Minus:
				{
				alt22=1;
				}
				break;
			case Length:
				{
				alt22=2;
				}
				break;
			case Not:
				{
				alt22=3;
				}
				break;
			case DotDotDot:
			case False:
			case Function:
			case Name:
			case Nil:
			case Number:
			case OBrace:
			case OPar:
			case String:
			case True:
				{
				alt22=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// grammars/Lua.g:322:4: Minus unary_expr
					{
					Minus103=(Token)match(input,Minus,FOLLOW_Minus_in_unary_expr1915); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Minus.add(Minus103);

					pushFollow(FOLLOW_unary_expr_in_unary_expr1917);
					unary_expr104=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_unary_expr.add(unary_expr104.getTree());
					// AST REWRITE
					// elements: unary_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 322:21: -> ^( UNARY_MINUS unary_expr )
					{
						// grammars/Lua.g:322:24: ^( UNARY_MINUS unary_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						adaptor.addChild(root_1, stream_unary_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:323:4: Length pow_expr
					{
					Length105=(Token)match(input,Length,FOLLOW_Length_in_unary_expr1930); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Length.add(Length105);

					pushFollow(FOLLOW_pow_expr_in_unary_expr1932);
					pow_expr106=pow_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_pow_expr.add(pow_expr106.getTree());
					// AST REWRITE
					// elements: Length, pow_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 323:21: -> ^( Length pow_expr )
					{
						// grammars/Lua.g:323:24: ^( Length pow_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_Length.nextNode(), root_1);
						adaptor.addChild(root_1, stream_pow_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// grammars/Lua.g:324:4: Not unary_expr
					{
					Not107=(Token)match(input,Not,FOLLOW_Not_in_unary_expr1946); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Not.add(Not107);

					pushFollow(FOLLOW_unary_expr_in_unary_expr1948);
					unary_expr108=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_unary_expr.add(unary_expr108.getTree());
					// AST REWRITE
					// elements: Not, unary_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 324:21: -> ^( Not unary_expr )
					{
						// grammars/Lua.g:324:24: ^( Not unary_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_Not.nextNode(), root_1);
						adaptor.addChild(root_1, stream_unary_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// grammars/Lua.g:325:4: pow_expr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_pow_expr_in_unary_expr1963);
					pow_expr109=pow_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr109.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unary_expr"


	public static class pow_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pow_expr"
	// grammars/Lua.g:329:1: pow_expr : (a+= atom -> $a) ( ( Pow a+= atom )+ ->)? ;
	public final LuaParser.pow_expr_return pow_expr() throws RecognitionException {
		LuaParser.pow_expr_return retval = new LuaParser.pow_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Pow110=null;
		List<Object> list_a=null;
		RuleReturnScope a = null;
		CommonTree Pow110_tree=null;
		RewriteRuleTokenStream stream_Pow=new RewriteRuleTokenStream(adaptor,"token Pow");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			// grammars/Lua.g:331:2: ( (a+= atom -> $a) ( ( Pow a+= atom )+ ->)? )
			// grammars/Lua.g:331:4: (a+= atom -> $a) ( ( Pow a+= atom )+ ->)?
			{
			// grammars/Lua.g:331:4: (a+= atom -> $a)
			// grammars/Lua.g:331:5: a+= atom
			{
			pushFollow(FOLLOW_atom_in_pow_expr1979);
			a=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(a.getTree());
			if (list_a==null) list_a=new ArrayList<Object>();
			list_a.add(a.getTree());
			// AST REWRITE
			// elements: a
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: a
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",list_a);
			root_0 = (CommonTree)adaptor.nil();
			// 331:13: -> $a
			{
				adaptor.addChild(root_0, stream_a.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// grammars/Lua.g:331:20: ( ( Pow a+= atom )+ ->)?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==Pow) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// grammars/Lua.g:331:21: ( Pow a+= atom )+
					{
					// grammars/Lua.g:331:21: ( Pow a+= atom )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==Pow) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// grammars/Lua.g:331:22: Pow a+= atom
							{
							Pow110=(Token)match(input,Pow,FOLLOW_Pow_in_pow_expr1989); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pow.add(Pow110);

							pushFollow(FOLLOW_atom_in_pow_expr1993);
							a=atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_atom.add(a.getTree());
							if (list_a==null) list_a=new ArrayList<Object>();
							list_a.add(a.getTree());
							}
							break;

						default :
							if ( cnt23 >= 1 ) break loop23;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(23, input);
							throw eee;
						}
						cnt23++;
					}

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 331:36: ->
					{
						adaptor.addChild(root_0, createPowAST(list_a));
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pow_expr"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// grammars/Lua.g:334:1: atom : ( var[false] | function_literal | table_constructor | DotDotDot | Number | String | Nil | True | False );
	public final LuaParser.atom_return atom() throws RecognitionException {
		LuaParser.atom_return retval = new LuaParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DotDotDot114=null;
		Token Number115=null;
		Token String116=null;
		Token Nil117=null;
		Token True118=null;
		Token False119=null;
		ParserRuleReturnScope var111 =null;
		ParserRuleReturnScope function_literal112 =null;
		ParserRuleReturnScope table_constructor113 =null;

		CommonTree DotDotDot114_tree=null;
		CommonTree Number115_tree=null;
		CommonTree String116_tree=null;
		CommonTree Nil117_tree=null;
		CommonTree True118_tree=null;
		CommonTree False119_tree=null;

		try {
			// grammars/Lua.g:335:2: ( var[false] | function_literal | table_constructor | DotDotDot | Number | String | Nil | True | False )
			int alt25=9;
			switch ( input.LA(1) ) {
			case Name:
			case OPar:
				{
				alt25=1;
				}
				break;
			case Function:
				{
				alt25=2;
				}
				break;
			case OBrace:
				{
				alt25=3;
				}
				break;
			case DotDotDot:
				{
				alt25=4;
				}
				break;
			case Number:
				{
				alt25=5;
				}
				break;
			case String:
				{
				alt25=6;
				}
				break;
			case Nil:
				{
				alt25=7;
				}
				break;
			case True:
				{
				alt25=8;
				}
				break;
			case False:
				{
				alt25=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// grammars/Lua.g:335:4: var[false]
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_in_atom2012);
					var111=var(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var111.getTree());

					}
					break;
				case 2 :
					// grammars/Lua.g:336:4: function_literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_literal_in_atom2018);
					function_literal112=function_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_literal112.getTree());

					}
					break;
				case 3 :
					// grammars/Lua.g:337:4: table_constructor
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_constructor_in_atom2023);
					table_constructor113=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, table_constructor113.getTree());

					}
					break;
				case 4 :
					// grammars/Lua.g:338:4: DotDotDot
					{
					root_0 = (CommonTree)adaptor.nil();


					DotDotDot114=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_atom2028); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DotDotDot114_tree = (CommonTree)adaptor.create(DotDotDot114);
					adaptor.addChild(root_0, DotDotDot114_tree);
					}

					}
					break;
				case 5 :
					// grammars/Lua.g:339:4: Number
					{
					root_0 = (CommonTree)adaptor.nil();


					Number115=(Token)match(input,Number,FOLLOW_Number_in_atom2034); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Number115_tree = (CommonTree)adaptor.create(Number115);
					adaptor.addChild(root_0, Number115_tree);
					}

					}
					break;
				case 6 :
					// grammars/Lua.g:340:4: String
					{
					root_0 = (CommonTree)adaptor.nil();


					String116=(Token)match(input,String,FOLLOW_String_in_atom2039); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					String116_tree = (CommonTree)adaptor.create(String116);
					adaptor.addChild(root_0, String116_tree);
					}

					}
					break;
				case 7 :
					// grammars/Lua.g:341:4: Nil
					{
					root_0 = (CommonTree)adaptor.nil();


					Nil117=(Token)match(input,Nil,FOLLOW_Nil_in_atom2044); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Nil117_tree = (CommonTree)adaptor.create(Nil117);
					adaptor.addChild(root_0, Nil117_tree);
					}

					}
					break;
				case 8 :
					// grammars/Lua.g:342:4: True
					{
					root_0 = (CommonTree)adaptor.nil();


					True118=(Token)match(input,True,FOLLOW_True_in_atom2049); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					True118_tree = (CommonTree)adaptor.create(True118);
					adaptor.addChild(root_0, True118_tree);
					}

					}
					break;
				case 9 :
					// grammars/Lua.g:343:4: False
					{
					root_0 = (CommonTree)adaptor.nil();


					False119=(Token)match(input,False,FOLLOW_False_in_atom2054); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					False119_tree = (CommonTree)adaptor.create(False119);
					adaptor.addChild(root_0, False119_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class var_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var"
	// grammars/Lua.g:346:1: var[boolean assign] : ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )? ;
	public final LuaParser.var_return var(boolean assign) throws RecognitionException {
		LuaParser.var_return retval = new LuaParser.var_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope t =null;
		ParserRuleReturnScope callee120 =null;

		RewriteRuleSubtreeStream stream_tail=new RewriteRuleSubtreeStream(adaptor,"rule tail");
		RewriteRuleSubtreeStream stream_callee=new RewriteRuleSubtreeStream(adaptor,"rule callee");

		try {
			// grammars/Lua.g:347:2: ( ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )? )
			// grammars/Lua.g:347:4: ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )?
			{
			// grammars/Lua.g:347:4: ( callee[assign] -> callee )
			// grammars/Lua.g:347:5: callee[assign]
			{
			pushFollow(FOLLOW_callee_in_var2067);
			callee120=callee(assign);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_callee.add(callee120.getTree());
			// AST REWRITE
			// elements: callee
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 347:20: -> callee
			{
				adaptor.addChild(root_0, stream_callee.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// grammars/Lua.g:347:31: ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==Dot) && (synpred2_Lua())) {
				alt27=1;
			}
			else if ( (LA27_0==OBrack) && (synpred2_Lua())) {
				alt27=1;
			}
			else if ( (LA27_0==Col) && (synpred2_Lua())) {
				alt27=1;
			}
			else if ( (LA27_0==OPar) ) {
				int LA27_4 = input.LA(2);
				if ( (synpred2_Lua()) ) {
					alt27=1;
				}
			}
			else if ( (LA27_0==OBrace) && (synpred2_Lua())) {
				alt27=1;
			}
			else if ( (LA27_0==String) && (synpred2_Lua())) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// grammars/Lua.g:347:33: ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) )
					{
					// grammars/Lua.g:347:42: ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) )
					// grammars/Lua.g:347:43: ( ( tail )=>t= tail )+
					{
					// grammars/Lua.g:347:43: ( ( tail )=>t= tail )+
					int cnt26=0;
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==OPar) ) {
							int LA26_7 = input.LA(2);
							if ( (synpred3_Lua()) ) {
								alt26=1;
							}

						}
						else if ( (LA26_0==Dot) && (synpred3_Lua())) {
							alt26=1;
						}
						else if ( (LA26_0==OBrack) && (synpred3_Lua())) {
							alt26=1;
						}
						else if ( (LA26_0==Col) && (synpred3_Lua())) {
							alt26=1;
						}
						else if ( (LA26_0==OBrace) && (synpred3_Lua())) {
							alt26=1;
						}
						else if ( (LA26_0==String) && (synpred3_Lua())) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// grammars/Lua.g:347:44: ( tail )=>t= tail
							{
							pushFollow(FOLLOW_tail_in_var2091);
							t=tail();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_tail.add(t.getTree());
							}
							break;

						default :
							if ( cnt26 >= 1 ) break loop26;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(26, input);
							throw eee;
						}
						cnt26++;
					}

					// AST REWRITE
					// elements: callee, tail, callee, tail
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 347:62: -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ )
					if (assign) {
						// grammars/Lua.g:347:75: ^( ASSIGNMENT_VAR callee ( tail )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNMENT_VAR, "ASSIGNMENT_VAR"), root_1);
						adaptor.addChild(root_1, stream_callee.nextTree());
						if ( !(stream_tail.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_tail.hasNext() ) {
							adaptor.addChild(root_1, stream_tail.nextTree());
						}
						stream_tail.reset();

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 348:62: -> ^( VAR callee ( tail )+ )
					{
						// grammars/Lua.g:348:75: ^( VAR callee ( tail )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);
						adaptor.addChild(root_1, stream_callee.nextTree());
						if ( !(stream_tail.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_tail.hasNext() ) {
							adaptor.addChild(root_1, stream_tail.nextTree());
						}
						stream_tail.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var"


	public static class callee_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "callee"
	// grammars/Lua.g:352:1: callee[boolean assign] : ( '(' expr ')' -> expr | Name );
	public final LuaParser.callee_return callee(boolean assign) throws RecognitionException {
		LuaParser.callee_return retval = new LuaParser.callee_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal121=null;
		Token char_literal123=null;
		Token Name124=null;
		ParserRuleReturnScope expr122 =null;

		CommonTree char_literal121_tree=null;
		CommonTree char_literal123_tree=null;
		CommonTree Name124_tree=null;
		RewriteRuleTokenStream stream_CPar=new RewriteRuleTokenStream(adaptor,"token CPar");
		RewriteRuleTokenStream stream_OPar=new RewriteRuleTokenStream(adaptor,"token OPar");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:353:2: ( '(' expr ')' -> expr | Name )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==OPar) ) {
				alt28=1;
			}
			else if ( (LA28_0==Name) ) {
				alt28=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// grammars/Lua.g:353:4: '(' expr ')'
					{
					char_literal121=(Token)match(input,OPar,FOLLOW_OPar_in_callee2234); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal121);

					pushFollow(FOLLOW_expr_in_callee2236);
					expr122=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr122.getTree());
					char_literal123=(Token)match(input,CPar,FOLLOW_CPar_in_callee2238); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal123);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 353:17: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:354:4: Name
					{
					root_0 = (CommonTree)adaptor.nil();


					Name124=(Token)match(input,Name,FOLLOW_Name_in_callee2247); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Name124_tree = (CommonTree)adaptor.create(Name124);
					adaptor.addChild(root_0, Name124_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "callee"


	public static class tail_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tail"
	// grammars/Lua.g:357:1: tail : ( '.' Name -> ^( INDEX String[$Name.text] ) | '[' expr ']' -> ^( INDEX expr ) | ':' Name '(' ( expr_list )? ')' -> ^( INDEX ) ^( COL_CALL ( expr_list )? ) | ':' Name table_constructor -> ^( INDEX ) ^( COL_CALL table_constructor ) | ':' Name String -> ^( INDEX ) ^( COL_CALL String ) | '(' ( expr_list )? ')' -> ^( CALL ( expr_list )? ) | table_constructor -> ^( CALL table_constructor ) | String -> ^( CALL String ) );
	public final LuaParser.tail_return tail() throws RecognitionException {
		LuaParser.tail_return retval = new LuaParser.tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal125=null;
		Token Name126=null;
		Token char_literal127=null;
		Token char_literal129=null;
		Token char_literal130=null;
		Token Name131=null;
		Token char_literal132=null;
		Token char_literal134=null;
		Token char_literal135=null;
		Token Name136=null;
		Token char_literal138=null;
		Token Name139=null;
		Token String140=null;
		Token char_literal141=null;
		Token char_literal143=null;
		Token String145=null;
		ParserRuleReturnScope expr128 =null;
		ParserRuleReturnScope expr_list133 =null;
		ParserRuleReturnScope table_constructor137 =null;
		ParserRuleReturnScope expr_list142 =null;
		ParserRuleReturnScope table_constructor144 =null;

		CommonTree char_literal125_tree=null;
		CommonTree Name126_tree=null;
		CommonTree char_literal127_tree=null;
		CommonTree char_literal129_tree=null;
		CommonTree char_literal130_tree=null;
		CommonTree Name131_tree=null;
		CommonTree char_literal132_tree=null;
		CommonTree char_literal134_tree=null;
		CommonTree char_literal135_tree=null;
		CommonTree Name136_tree=null;
		CommonTree char_literal138_tree=null;
		CommonTree Name139_tree=null;
		CommonTree String140_tree=null;
		CommonTree char_literal141_tree=null;
		CommonTree char_literal143_tree=null;
		CommonTree String145_tree=null;
		RewriteRuleTokenStream stream_Col=new RewriteRuleTokenStream(adaptor,"token Col");
		RewriteRuleTokenStream stream_CPar=new RewriteRuleTokenStream(adaptor,"token CPar");
		RewriteRuleTokenStream stream_OPar=new RewriteRuleTokenStream(adaptor,"token OPar");
		RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
		RewriteRuleTokenStream stream_CBrack=new RewriteRuleTokenStream(adaptor,"token CBrack");
		RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
		RewriteRuleTokenStream stream_OBrack=new RewriteRuleTokenStream(adaptor,"token OBrack");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_table_constructor=new RewriteRuleSubtreeStream(adaptor,"rule table_constructor");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:358:2: ( '.' Name -> ^( INDEX String[$Name.text] ) | '[' expr ']' -> ^( INDEX expr ) | ':' Name '(' ( expr_list )? ')' -> ^( INDEX ) ^( COL_CALL ( expr_list )? ) | ':' Name table_constructor -> ^( INDEX ) ^( COL_CALL table_constructor ) | ':' Name String -> ^( INDEX ) ^( COL_CALL String ) | '(' ( expr_list )? ')' -> ^( CALL ( expr_list )? ) | table_constructor -> ^( CALL table_constructor ) | String -> ^( CALL String ) )
			int alt31=8;
			switch ( input.LA(1) ) {
			case Dot:
				{
				alt31=1;
				}
				break;
			case OBrack:
				{
				alt31=2;
				}
				break;
			case Col:
				{
				int LA31_3 = input.LA(2);
				if ( (LA31_3==Name) ) {
					switch ( input.LA(3) ) {
					case OPar:
						{
						alt31=3;
						}
						break;
					case String:
						{
						alt31=5;
						}
						break;
					case OBrace:
						{
						alt31=4;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 31, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case OPar:
				{
				alt31=6;
				}
				break;
			case OBrace:
				{
				alt31=7;
				}
				break;
			case String:
				{
				alt31=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// grammars/Lua.g:358:4: '.' Name
					{
					char_literal125=(Token)match(input,Dot,FOLLOW_Dot_in_tail2258); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Dot.add(char_literal125);

					Name126=(Token)match(input,Name,FOLLOW_Name_in_tail2260); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name126);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 358:32: -> ^( INDEX String[$Name.text] )
					{
						// grammars/Lua.g:358:35: ^( INDEX String[$Name.text] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(String, (Name126!=null?Name126.getText():null)));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:359:4: '[' expr ']'
					{
					char_literal127=(Token)match(input,OBrack,FOLLOW_OBrack_in_tail2293); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OBrack.add(char_literal127);

					pushFollow(FOLLOW_expr_in_tail2295);
					expr128=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr128.getTree());
					char_literal129=(Token)match(input,CBrack,FOLLOW_CBrack_in_tail2297); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CBrack.add(char_literal129);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 359:32: -> ^( INDEX expr )
					{
						// grammars/Lua.g:359:35: ^( INDEX expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// grammars/Lua.g:360:4: ':' Name '(' ( expr_list )? ')'
					{
					char_literal130=(Token)match(input,Col,FOLLOW_Col_in_tail2325); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal130);

					Name131=(Token)match(input,Name,FOLLOW_Name_in_tail2327); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name131);

					char_literal132=(Token)match(input,OPar,FOLLOW_OPar_in_tail2329); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal132);

					// grammars/Lua.g:360:17: ( expr_list )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==DotDotDot||LA29_0==False||LA29_0==Function||LA29_0==Length||LA29_0==Minus||(LA29_0 >= Name && LA29_0 <= OBrace)||LA29_0==OPar||LA29_0==String||LA29_0==True) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// grammars/Lua.g:360:17: expr_list
							{
							pushFollow(FOLLOW_expr_list_in_tail2331);
							expr_list133=expr_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr_list.add(expr_list133.getTree());
							}
							break;

					}

					char_literal134=(Token)match(input,CPar,FOLLOW_CPar_in_tail2334); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal134);

					// AST REWRITE
					// elements: expr_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 360:32: -> ^( INDEX ) ^( COL_CALL ( expr_list )? )
					{
						// grammars/Lua.g:360:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name131!=null?Name131.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:360:98: ^( COL_CALL ( expr_list )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COL_CALL, "COL_CALL"), root_1);
						// grammars/Lua.g:360:109: ( expr_list )?
						if ( stream_expr_list.hasNext() ) {
							adaptor.addChild(root_1, stream_expr_list.nextTree());
						}
						stream_expr_list.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// grammars/Lua.g:361:4: ':' Name table_constructor
					{
					char_literal135=(Token)match(input,Col,FOLLOW_Col_in_tail2354); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal135);

					Name136=(Token)match(input,Name,FOLLOW_Name_in_tail2356); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name136);

					pushFollow(FOLLOW_table_constructor_in_tail2358);
					table_constructor137=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_constructor.add(table_constructor137.getTree());
					// AST REWRITE
					// elements: table_constructor
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 361:32: -> ^( INDEX ) ^( COL_CALL table_constructor )
					{
						// grammars/Lua.g:361:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name136!=null?Name136.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:361:98: ^( COL_CALL table_constructor )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COL_CALL, "COL_CALL"), root_1);
						adaptor.addChild(root_1, stream_table_constructor.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// grammars/Lua.g:362:4: ':' Name String
					{
					char_literal138=(Token)match(input,Col,FOLLOW_Col_in_tail2378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal138);

					Name139=(Token)match(input,Name,FOLLOW_Name_in_tail2380); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name139);

					String140=(Token)match(input,String,FOLLOW_String_in_tail2382); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_String.add(String140);

					// AST REWRITE
					// elements: String
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 362:32: -> ^( INDEX ) ^( COL_CALL String )
					{
						// grammars/Lua.g:362:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name139!=null?Name139.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:362:98: ^( COL_CALL String )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COL_CALL, "COL_CALL"), root_1);
						adaptor.addChild(root_1, stream_String.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// grammars/Lua.g:363:4: '(' ( expr_list )? ')'
					{
					char_literal141=(Token)match(input,OPar,FOLLOW_OPar_in_tail2413); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal141);

					// grammars/Lua.g:363:8: ( expr_list )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==DotDotDot||LA30_0==False||LA30_0==Function||LA30_0==Length||LA30_0==Minus||(LA30_0 >= Name && LA30_0 <= OBrace)||LA30_0==OPar||LA30_0==String||LA30_0==True) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// grammars/Lua.g:363:8: expr_list
							{
							pushFollow(FOLLOW_expr_list_in_tail2415);
							expr_list142=expr_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr_list.add(expr_list142.getTree());
							}
							break;

					}

					char_literal143=(Token)match(input,CPar,FOLLOW_CPar_in_tail2418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal143);

					// AST REWRITE
					// elements: expr_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 363:32: -> ^( CALL ( expr_list )? )
					{
						// grammars/Lua.g:363:35: ^( CALL ( expr_list )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);
						// grammars/Lua.g:363:42: ( expr_list )?
						if ( stream_expr_list.hasNext() ) {
							adaptor.addChild(root_1, stream_expr_list.nextTree());
						}
						stream_expr_list.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// grammars/Lua.g:364:4: table_constructor
					{
					pushFollow(FOLLOW_table_constructor_in_tail2441);
					table_constructor144=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_constructor.add(table_constructor144.getTree());
					// AST REWRITE
					// elements: table_constructor
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 364:32: -> ^( CALL table_constructor )
					{
						// grammars/Lua.g:364:35: ^( CALL table_constructor )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);
						adaptor.addChild(root_1, stream_table_constructor.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// grammars/Lua.g:365:4: String
					{
					String145=(Token)match(input,String,FOLLOW_String_in_tail2464); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_String.add(String145);

					// AST REWRITE
					// elements: String
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 365:32: -> ^( CALL String )
					{
						// grammars/Lua.g:365:35: ^( CALL String )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);
						adaptor.addChild(root_1, stream_String.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tail"


	public static class table_constructor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "table_constructor"
	// grammars/Lua.g:368:1: table_constructor : '{' ( field_list )? '}' -> ^( TABLE ( field_list )? ) ;
	public final LuaParser.table_constructor_return table_constructor() throws RecognitionException {
		LuaParser.table_constructor_return retval = new LuaParser.table_constructor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal146=null;
		Token char_literal148=null;
		ParserRuleReturnScope field_list147 =null;

		CommonTree char_literal146_tree=null;
		CommonTree char_literal148_tree=null;
		RewriteRuleTokenStream stream_OBrace=new RewriteRuleTokenStream(adaptor,"token OBrace");
		RewriteRuleTokenStream stream_CBrace=new RewriteRuleTokenStream(adaptor,"token CBrace");
		RewriteRuleSubtreeStream stream_field_list=new RewriteRuleSubtreeStream(adaptor,"rule field_list");

		try {
			// grammars/Lua.g:369:2: ( '{' ( field_list )? '}' -> ^( TABLE ( field_list )? ) )
			// grammars/Lua.g:369:4: '{' ( field_list )? '}'
			{
			char_literal146=(Token)match(input,OBrace,FOLLOW_OBrace_in_table_constructor2504); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OBrace.add(char_literal146);

			// grammars/Lua.g:369:8: ( field_list )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==DotDotDot||LA32_0==False||LA32_0==Function||LA32_0==Length||LA32_0==Minus||(LA32_0 >= Name && LA32_0 <= OPar)||LA32_0==String||LA32_0==True) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// grammars/Lua.g:369:8: field_list
					{
					pushFollow(FOLLOW_field_list_in_table_constructor2506);
					field_list147=field_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_list.add(field_list147.getTree());
					}
					break;

			}

			char_literal148=(Token)match(input,CBrace,FOLLOW_CBrace_in_table_constructor2509); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CBrace.add(char_literal148);

			// AST REWRITE
			// elements: field_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 369:24: -> ^( TABLE ( field_list )? )
			{
				// grammars/Lua.g:369:27: ^( TABLE ( field_list )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TABLE, "TABLE"), root_1);
				// grammars/Lua.g:369:35: ( field_list )?
				if ( stream_field_list.hasNext() ) {
					adaptor.addChild(root_1, stream_field_list.nextTree());
				}
				stream_field_list.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "table_constructor"


	public static class field_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "field_list"
	// grammars/Lua.g:372:1: field_list : field ( field_sep field )* ( field_sep )? -> ( field )+ ;
	public final LuaParser.field_list_return field_list() throws RecognitionException {
		LuaParser.field_list_return retval = new LuaParser.field_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope field149 =null;
		ParserRuleReturnScope field_sep150 =null;
		ParserRuleReturnScope field151 =null;
		ParserRuleReturnScope field_sep152 =null;

		RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
		RewriteRuleSubtreeStream stream_field_sep=new RewriteRuleSubtreeStream(adaptor,"rule field_sep");

		try {
			// grammars/Lua.g:373:2: ( field ( field_sep field )* ( field_sep )? -> ( field )+ )
			// grammars/Lua.g:373:4: field ( field_sep field )* ( field_sep )?
			{
			pushFollow(FOLLOW_field_in_field_list2529);
			field149=field();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_field.add(field149.getTree());
			// grammars/Lua.g:373:10: ( field_sep field )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==Comma||LA33_0==SCol) ) {
					int LA33_1 = input.LA(2);
					if ( (LA33_1==DotDotDot||LA33_1==False||LA33_1==Function||LA33_1==Length||LA33_1==Minus||(LA33_1 >= Name && LA33_1 <= OPar)||LA33_1==String||LA33_1==True) ) {
						alt33=1;
					}

				}

				switch (alt33) {
				case 1 :
					// grammars/Lua.g:373:11: field_sep field
					{
					pushFollow(FOLLOW_field_sep_in_field_list2532);
					field_sep150=field_sep();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_sep.add(field_sep150.getTree());
					pushFollow(FOLLOW_field_in_field_list2534);
					field151=field();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field.add(field151.getTree());
					}
					break;

				default :
					break loop33;
				}
			}

			// grammars/Lua.g:373:29: ( field_sep )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==Comma||LA34_0==SCol) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// grammars/Lua.g:373:29: field_sep
					{
					pushFollow(FOLLOW_field_sep_in_field_list2538);
					field_sep152=field_sep();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_sep.add(field_sep152.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: field
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 373:40: -> ( field )+
			{
				if ( !(stream_field.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_field.hasNext() ) {
					adaptor.addChild(root_0, stream_field.nextTree());
				}
				stream_field.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_list"


	public static class field_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "field"
	// grammars/Lua.g:376:1: field : ( '[' expr ']' '=' expr -> ^( FIELD expr expr ) | Name '=' expr -> ^( FIELD expr ) | expr -> ^( FIELD expr ) );
	public final LuaParser.field_return field() throws RecognitionException {
		LuaParser.field_return retval = new LuaParser.field_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal153=null;
		Token char_literal155=null;
		Token char_literal156=null;
		Token Name158=null;
		Token char_literal159=null;
		ParserRuleReturnScope expr154 =null;
		ParserRuleReturnScope expr157 =null;
		ParserRuleReturnScope expr160 =null;
		ParserRuleReturnScope expr161 =null;

		CommonTree char_literal153_tree=null;
		CommonTree char_literal155_tree=null;
		CommonTree char_literal156_tree=null;
		CommonTree Name158_tree=null;
		CommonTree char_literal159_tree=null;
		RewriteRuleTokenStream stream_CBrack=new RewriteRuleTokenStream(adaptor,"token CBrack");
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_OBrack=new RewriteRuleTokenStream(adaptor,"token OBrack");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:377:2: ( '[' expr ']' '=' expr -> ^( FIELD expr expr ) | Name '=' expr -> ^( FIELD expr ) | expr -> ^( FIELD expr ) )
			int alt35=3;
			switch ( input.LA(1) ) {
			case OBrack:
				{
				alt35=1;
				}
				break;
			case Name:
				{
				int LA35_2 = input.LA(2);
				if ( (LA35_2==Assign) ) {
					alt35=2;
				}
				else if ( ((LA35_2 >= Add && LA35_2 <= And)||LA35_2==CBrace||LA35_2==Col||LA35_2==Comma||LA35_2==Div||(LA35_2 >= Dot && LA35_2 <= DotDot)||LA35_2==Eq||(LA35_2 >= GT && LA35_2 <= GTEq)||(LA35_2 >= LT && LA35_2 <= LTEq)||(LA35_2 >= Minus && LA35_2 <= Mult)||LA35_2==NEq||(LA35_2 >= OBrace && LA35_2 <= Or)||LA35_2==Pow||LA35_2==SCol||LA35_2==String) ) {
					alt35=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DotDotDot:
			case False:
			case Function:
			case Length:
			case Minus:
			case Nil:
			case Not:
			case Number:
			case OBrace:
			case OPar:
			case String:
			case True:
				{
				alt35=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// grammars/Lua.g:377:4: '[' expr ']' '=' expr
					{
					char_literal153=(Token)match(input,OBrack,FOLLOW_OBrack_in_field2555); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OBrack.add(char_literal153);

					pushFollow(FOLLOW_expr_in_field2557);
					expr154=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr154.getTree());
					char_literal155=(Token)match(input,CBrack,FOLLOW_CBrack_in_field2559); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CBrack.add(char_literal155);

					char_literal156=(Token)match(input,Assign,FOLLOW_Assign_in_field2561); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal156);

					pushFollow(FOLLOW_expr_in_field2563);
					expr157=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr157.getTree());
					// AST REWRITE
					// elements: expr, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 377:26: -> ^( FIELD expr expr )
					{
						// grammars/Lua.g:377:29: ^( FIELD expr expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELD, "FIELD"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:378:4: Name '=' expr
					{
					Name158=(Token)match(input,Name,FOLLOW_Name_in_field2578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name158);

					char_literal159=(Token)match(input,Assign,FOLLOW_Assign_in_field2580); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal159);

					pushFollow(FOLLOW_expr_in_field2582);
					expr160=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr160.getTree());
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 378:26: -> ^( FIELD expr )
					{
						// grammars/Lua.g:378:29: ^( FIELD expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELD, "FIELD"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name158!=null?Name158.getText():null))));
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// grammars/Lua.g:379:4: expr
					{
					pushFollow(FOLLOW_expr_in_field2605);
					expr161=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr161.getTree());
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 379:26: -> ^( FIELD expr )
					{
						// grammars/Lua.g:379:29: ^( FIELD expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELD, "FIELD"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field"


	public static class field_sep_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "field_sep"
	// grammars/Lua.g:382:1: field_sep : ( ',' | ';' );
	public final LuaParser.field_sep_return field_sep() throws RecognitionException {
		LuaParser.field_sep_return retval = new LuaParser.field_sep_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set162=null;

		CommonTree set162_tree=null;

		try {
			// grammars/Lua.g:383:2: ( ',' | ';' )
			// grammars/Lua.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set162=input.LT(1);
			if ( input.LA(1)==Comma||input.LA(1)==SCol ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set162));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_sep"


	public static class label_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "label"
	// grammars/Lua.g:387:1: label : '::' Name '::' -> ^( LABEL Name ) ;
	public final LuaParser.label_return label() throws RecognitionException {
		LuaParser.label_return retval = new LuaParser.label_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal163=null;
		Token Name164=null;
		Token string_literal165=null;

		CommonTree string_literal163_tree=null;
		CommonTree Name164_tree=null;
		CommonTree string_literal165_tree=null;
		RewriteRuleTokenStream stream_ColCol=new RewriteRuleTokenStream(adaptor,"token ColCol");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:388:2: ( '::' Name '::' -> ^( LABEL Name ) )
			// grammars/Lua.g:388:4: '::' Name '::'
			{
			string_literal163=(Token)match(input,ColCol,FOLLOW_ColCol_in_label2658); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ColCol.add(string_literal163);

			Name164=(Token)match(input,Name,FOLLOW_Name_in_label2660); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name164);

			string_literal165=(Token)match(input,ColCol,FOLLOW_ColCol_in_label2662); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ColCol.add(string_literal165);

			// AST REWRITE
			// elements: Name
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 388:19: -> ^( LABEL Name )
			{
				// grammars/Lua.g:388:22: ^( LABEL Name )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LABEL, "LABEL"), root_1);
				adaptor.addChild(root_1, stream_Name.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "label"


	public static class var_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_list"
	// grammars/Lua.g:391:1: var_list : var[true] ( ',' var[true] )* -> ( var )+ ;
	public final LuaParser.var_list_return var_list() throws RecognitionException {
		LuaParser.var_list_return retval = new LuaParser.var_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal167=null;
		ParserRuleReturnScope var166 =null;
		ParserRuleReturnScope var168 =null;

		CommonTree char_literal167_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleSubtreeStream stream_var=new RewriteRuleSubtreeStream(adaptor,"rule var");

		try {
			// grammars/Lua.g:392:2: ( var[true] ( ',' var[true] )* -> ( var )+ )
			// grammars/Lua.g:392:4: var[true] ( ',' var[true] )*
			{
			pushFollow(FOLLOW_var_in_var_list2681);
			var166=var(true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var.add(var166.getTree());
			// grammars/Lua.g:392:14: ( ',' var[true] )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==Comma) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// grammars/Lua.g:392:15: ',' var[true]
					{
					char_literal167=(Token)match(input,Comma,FOLLOW_Comma_in_var_list2685); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal167);

					pushFollow(FOLLOW_var_in_var_list2687);
					var168=var(true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var.add(var168.getTree());
					}
					break;

				default :
					break loop36;
				}
			}

			// AST REWRITE
			// elements: var
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 392:31: -> ( var )+
			{
				if ( !(stream_var.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_var.hasNext() ) {
					adaptor.addChild(root_0, stream_var.nextTree());
				}
				stream_var.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_list"


	public static class expr_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// grammars/Lua.g:395:1: expr_list : expr ( ',' expr )* -> ( expr )+ ;
	public final LuaParser.expr_list_return expr_list() throws RecognitionException {
		LuaParser.expr_list_return retval = new LuaParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal170=null;
		ParserRuleReturnScope expr169 =null;
		ParserRuleReturnScope expr171 =null;

		CommonTree char_literal170_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:396:2: ( expr ( ',' expr )* -> ( expr )+ )
			// grammars/Lua.g:396:4: expr ( ',' expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list2706);
			expr169=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr169.getTree());
			// grammars/Lua.g:396:9: ( ',' expr )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==Comma) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// grammars/Lua.g:396:10: ',' expr
					{
					char_literal170=(Token)match(input,Comma,FOLLOW_Comma_in_expr_list2709); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal170);

					pushFollow(FOLLOW_expr_in_expr_list2711);
					expr171=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr171.getTree());
					}
					break;

				default :
					break loop37;
				}
			}

			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 396:21: -> ( expr )+
			{
				if ( !(stream_expr.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expr.hasNext() ) {
					adaptor.addChild(root_0, stream_expr.nextTree());
				}
				stream_expr.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_list"


	public static class name_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "name_list"
	// grammars/Lua.g:399:1: name_list : Name ( ',' Name )* -> {addSelf}? ( Name )+ -> ( Name )+ ;
	public final LuaParser.name_list_return name_list() throws RecognitionException {
		LuaParser.name_list_return retval = new LuaParser.name_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Name172=null;
		Token char_literal173=null;
		Token Name174=null;

		CommonTree Name172_tree=null;
		CommonTree char_literal173_tree=null;
		CommonTree Name174_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:400:2: ( Name ( ',' Name )* -> {addSelf}? ( Name )+ -> ( Name )+ )
			// grammars/Lua.g:400:4: Name ( ',' Name )*
			{
			Name172=(Token)match(input,Name,FOLLOW_Name_in_name_list2729); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name172);

			// grammars/Lua.g:400:9: ( ',' Name )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==Comma) ) {
					int LA38_2 = input.LA(2);
					if ( (LA38_2==Name) ) {
						alt38=1;
					}

				}

				switch (alt38) {
				case 1 :
					// grammars/Lua.g:400:10: ',' Name
					{
					char_literal173=(Token)match(input,Comma,FOLLOW_Comma_in_name_list2732); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal173);

					Name174=(Token)match(input,Name,FOLLOW_Name_in_name_list2734); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name174);

					}
					break;

				default :
					break loop38;
				}
			}

			// AST REWRITE
			// elements: Name, Name
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 400:21: -> {addSelf}? ( Name )+
			if (addSelf) {
				adaptor.addChild(root_0, new CommonTree(new CommonToken(Name, "self")));
				if ( !(stream_Name.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Name.hasNext() ) {
					adaptor.addChild(root_0, stream_Name.nextNode());
				}
				stream_Name.reset();

			}

			else // 401:21: -> ( Name )+
			{
				if ( !(stream_Name.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Name.hasNext() ) {
					adaptor.addChild(root_0, stream_Name.nextNode());
				}
				stream_Name.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "name_list"

	// $ANTLR start synpred1_Lua
	public final void synpred1_Lua_fragment() throws RecognitionException {
		// grammars/Lua.g:203:4: ( assignment )
		// grammars/Lua.g:203:5: assignment
		{
		pushFollow(FOLLOW_assignment_in_synpred1_Lua902);
		assignment();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Lua

	// $ANTLR start synpred2_Lua
	public final void synpred2_Lua_fragment() throws RecognitionException {
		// grammars/Lua.g:347:33: ( tail )
		// grammars/Lua.g:347:34: tail
		{
		pushFollow(FOLLOW_tail_in_synpred2_Lua2078);
		tail();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_Lua

	// $ANTLR start synpred3_Lua
	public final void synpred3_Lua_fragment() throws RecognitionException {
		// grammars/Lua.g:347:44: ( tail )
		// grammars/Lua.g:347:45: tail
		{
		pushFollow(FOLLOW_tail_in_synpred3_Lua2085);
		tail();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_Lua

	// Delegated rules

	public final boolean synpred1_Lua() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Lua_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_Lua() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Lua_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_Lua() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_Lua_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_chunk_in_parse857 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_chunk874 = new BitSet(new long[]{0x08044C0002100802L,0x0000000001007104L});
	public static final BitSet FOLLOW_ret_stat_in_chunk877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_stat906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_stat911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_do_block_in_stat942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_repeat_stat_in_stat953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_local_in_stat958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goto_stat_in_stat963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stat_in_stat968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_stat978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_label_in_stat983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Break_in_stat988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCol_in_stat993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Do_in_do_block1008 = new BitSet(new long[]{0x08044C0102100800L,0x0000000001007104L});
	public static final BitSet FOLLOW_chunk_in_do_block1010 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_do_block1012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_While_in_while_stat1031 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_while_stat1033 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_while_stat1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Repeat_in_repeat_stat1056 = new BitSet(new long[]{0x08044C0002100800L,0x0000000001207104L});
	public static final BitSet FOLLOW_chunk_in_repeat_stat1058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_Until_in_repeat_stat1060 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_repeat_stat1062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_list_in_assignment1084 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_assignment1086 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_list_in_assignment1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Local_in_local1121 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_name_list_in_local1125 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_local1127 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_list_in_local1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Function_in_local1160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_local1162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_func_body_in_local1164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Goto_in_goto_stat1204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_goto_stat1206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_if_stat1225 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_if_stat1227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_Then_in_if_stat1229 = new BitSet(new long[]{0x08044C01C2100800L,0x0000000001007104L});
	public static final BitSet FOLLOW_chunk_in_if_stat1231 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_elseif_stat_in_if_stat1233 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_else_stat_in_if_stat1236 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_if_stat1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Elseif_in_elseif_stat1270 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_elseif_stat1272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_Then_in_elseif_stat1274 = new BitSet(new long[]{0x08044C0002100800L,0x0000000001007104L});
	public static final BitSet FOLLOW_chunk_in_elseif_stat1276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_else_stat1297 = new BitSet(new long[]{0x08044C0002100800L,0x0000000001007104L});
	public static final BitSet FOLLOW_chunk_in_else_stat1299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_For_in_for_stat1320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_for_stat1324 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_for_stat1326 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_for_stat1330 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Comma_in_for_stat1332 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_for_stat1336 = new BitSet(new long[]{0x0000000002200000L});
	public static final BitSet FOLLOW_Comma_in_for_stat1339 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_for_stat1343 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_for_stat1347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_list_in_for_stat1378 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_In_in_for_stat1380 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_list_in_for_stat1382 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_for_stat1384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Function_in_function1442 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_names_in_function1444 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000100L});
	public static final BitSet FOLLOW_Col_in_function1448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_function1450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_func_body_in_function1454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_body_in_function1517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_names1596 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_Dot_in_names1601 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_names1605 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_Function_in_function_literal1620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_func_body_in_function_literal1622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPar_in_func_body1637 = new BitSet(new long[]{0x0000000010040000L,0x0000000000000004L});
	public static final BitSet FOLLOW_param_list_in_func_body1639 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_func_body1641 = new BitSet(new long[]{0x08044C0102100800L,0x0000000001007104L});
	public static final BitSet FOLLOW_chunk_in_func_body1643 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_func_body1645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_list_in_param_list1666 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_param_list1669 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_DotDotDot_in_param_list1671 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DotDotDot_in_param_list1689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Return_in_ret_stat1726 = new BitSet(new long[]{0x21000A0010000002L,0x000000000009417CL});
	public static final BitSet FOLLOW_expr_list_in_ret_stat1728 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
	public static final BitSet FOLLOW_SCol_in_ret_stat1731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expr_in_expr1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expr_in_or_expr1763 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_Or_in_or_expr1766 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_and_expr_in_or_expr1769 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_rel_expr_in_and_expr1782 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_And_in_and_expr1785 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_rel_expr_in_and_expr1788 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_concat_expr_in_rel_expr1801 = new BitSet(new long[]{0x00C0300200000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_rel_expr1804 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_concat_expr_in_rel_expr1829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_expr_in_concat_expr1842 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_DotDot_in_concat_expr1845 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_add_expr_in_concat_expr1848 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_mult_expr_in_add_expr1861 = new BitSet(new long[]{0x2000000000000042L});
	public static final BitSet FOLLOW_set_in_add_expr1864 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_mult_expr_in_add_expr1873 = new BitSet(new long[]{0x2000000000000042L});
	public static final BitSet FOLLOW_unary_expr_in_mult_expr1886 = new BitSet(new long[]{0xC000000001000002L});
	public static final BitSet FOLLOW_set_in_mult_expr1889 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_unary_expr_in_mult_expr1902 = new BitSet(new long[]{0xC000000001000002L});
	public static final BitSet FOLLOW_Minus_in_unary_expr1915 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_unary_expr_in_unary_expr1917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Length_in_unary_expr1930 = new BitSet(new long[]{0x00000A0010000000L,0x000000000009016CL});
	public static final BitSet FOLLOW_pow_expr_in_unary_expr1932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unary_expr1946 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_unary_expr_in_unary_expr1948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_expr_in_unary_expr1963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_pow_expr1979 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_Pow_in_pow_expr1989 = new BitSet(new long[]{0x00000A0010000000L,0x000000000009016CL});
	public static final BitSet FOLLOW_atom_in_pow_expr1993 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_var_in_atom2012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_literal_in_atom2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_constructor_in_atom2023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DotDotDot_in_atom2028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Number_in_atom2034 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_atom2039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Nil_in_atom2044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_True_in_atom2049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_False_in_atom2054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_callee_in_var2067 = new BitSet(new long[]{0x0000000004080002L,0x00000000000101C0L});
	public static final BitSet FOLLOW_tail_in_var2091 = new BitSet(new long[]{0x0000000004080002L,0x00000000000101C0L});
	public static final BitSet FOLLOW_OPar_in_callee2234 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_callee2236 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_callee2238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_callee2247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Dot_in_tail2258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_tail2260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrack_in_tail2293 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_tail2295 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CBrack_in_tail2297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_tail2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_OPar_in_tail2329 = new BitSet(new long[]{0x21000A0010040000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_list_in_tail2331 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_tail2334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_tail2356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_table_constructor_in_tail2358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_tail2380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_String_in_tail2382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPar_in_tail2413 = new BitSet(new long[]{0x21000A0010040000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_list_in_tail2415 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_tail2418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_constructor_in_tail2441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_tail2464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrace_in_table_constructor2504 = new BitSet(new long[]{0x21000A0010002000L,0x00000000000901FCL});
	public static final BitSet FOLLOW_field_list_in_table_constructor2506 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CBrace_in_table_constructor2509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_field_in_field_list2529 = new BitSet(new long[]{0x0000000000200002L,0x0000000000004000L});
	public static final BitSet FOLLOW_field_sep_in_field_list2532 = new BitSet(new long[]{0x21000A0010000000L,0x00000000000901FCL});
	public static final BitSet FOLLOW_field_in_field_list2534 = new BitSet(new long[]{0x0000000000200002L,0x0000000000004000L});
	public static final BitSet FOLLOW_field_sep_in_field_list2538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrack_in_field2555 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_field2557 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CBrack_in_field2559 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_field2561 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_field2563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_field2578 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_field2580 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_field2582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_field2605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ColCol_in_label2658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_label2660 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ColCol_in_label2662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_var_list2681 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_var_list2685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000104L});
	public static final BitSet FOLLOW_var_in_var_list2687 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_expr_in_expr_list2706 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_expr_list2709 = new BitSet(new long[]{0x21000A0010000000L,0x000000000009017CL});
	public static final BitSet FOLLOW_expr_in_expr_list2711 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Name_in_name_list2729 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_name_list2732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_name_list2734 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_assignment_in_synpred1_Lua902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tail_in_synpred2_Lua2078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tail_in_synpred3_Lua2085 = new BitSet(new long[]{0x0000000000000002L});
}
