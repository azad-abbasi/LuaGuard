// $ANTLR 3.5.2 grammars/Lua.g 2014-05-14 22:58:50

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
		"In", "LABEL", "LOCAL_ASSIGNMENT", "LOCAL_DEC", "LT", "LTEq", "Length", 
		"Letter", "LineBreak", "Local", "LongBracket", "Minus", "Mod", "Mult", 
		"NAME_LIST", "NEq", "Name", "Nil", "Not", "Number", "OBrace", "OBrack", 
		"OPar", "Or", "PARAM_LIST", "Pow", "REQUIRE", "Repeat", "Require", "Return", 
		"SCol", "Space", "String", "TABLE", "Then", "True", "UNARY_MINUS", "Until", 
		"VAR", "VAR_LIST", "While"
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
	public static final int LOCAL_DEC=54;
	public static final int LT=55;
	public static final int LTEq=56;
	public static final int Length=57;
	public static final int Letter=58;
	public static final int LineBreak=59;
	public static final int Local=60;
	public static final int LongBracket=61;
	public static final int Minus=62;
	public static final int Mod=63;
	public static final int Mult=64;
	public static final int NAME_LIST=65;
	public static final int NEq=66;
	public static final int Name=67;
	public static final int Nil=68;
	public static final int Not=69;
	public static final int Number=70;
	public static final int OBrace=71;
	public static final int OBrack=72;
	public static final int OPar=73;
	public static final int Or=74;
	public static final int PARAM_LIST=75;
	public static final int Pow=76;
	public static final int REQUIRE=77;
	public static final int Repeat=78;
	public static final int Require=79;
	public static final int Return=80;
	public static final int SCol=81;
	public static final int Space=82;
	public static final int String=83;
	public static final int TABLE=84;
	public static final int Then=85;
	public static final int True=86;
	public static final int UNARY_MINUS=87;
	public static final int Until=88;
	public static final int VAR=89;
	public static final int VAR_LIST=90;
	public static final int While=91;

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
	// grammars/Lua.g:197:1: parse : chunk EOF -> chunk ;
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
			// grammars/Lua.g:198:2: ( chunk EOF -> chunk )
			// grammars/Lua.g:198:4: chunk EOF
			{
			pushFollow(FOLLOW_chunk_in_parse878);
			chunk1=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk1.getTree());
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse880); if (state.failed) return retval; 
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
			// 198:14: -> chunk
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
	// grammars/Lua.g:201:1: chunk : ( stat )* ( ret_stat )? -> ^( CHUNK ( stat )* ( ret_stat )? ) ;
	public final LuaParser.chunk_return chunk() throws RecognitionException {
		LuaParser.chunk_return retval = new LuaParser.chunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat3 =null;
		ParserRuleReturnScope ret_stat4 =null;

		RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
		RewriteRuleSubtreeStream stream_ret_stat=new RewriteRuleSubtreeStream(adaptor,"rule ret_stat");

		try {
			// grammars/Lua.g:202:2: ( ( stat )* ( ret_stat )? -> ^( CHUNK ( stat )* ( ret_stat )? ) )
			// grammars/Lua.g:202:4: ( stat )* ( ret_stat )?
			{
			// grammars/Lua.g:202:4: ( stat )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Break||LA1_0==ColCol||LA1_0==Do||(LA1_0 >= For && LA1_0 <= Function)||LA1_0==Goto||LA1_0==If||LA1_0==Local||LA1_0==Name||LA1_0==OPar||(LA1_0 >= Repeat && LA1_0 <= Require)||LA1_0==SCol||LA1_0==While) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// grammars/Lua.g:202:4: stat
					{
					pushFollow(FOLLOW_stat_in_chunk895);
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

			// grammars/Lua.g:202:10: ( ret_stat )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Return) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// grammars/Lua.g:202:10: ret_stat
					{
					pushFollow(FOLLOW_ret_stat_in_chunk898);
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
			// 202:20: -> ^( CHUNK ( stat )* ( ret_stat )? )
			{
				// grammars/Lua.g:202:23: ^( CHUNK ( stat )* ( ret_stat )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHUNK, "CHUNK"), root_1);
				// grammars/Lua.g:202:31: ( stat )*
				while ( stream_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_stat.nextTree());
				}
				stream_stat.reset();

				// grammars/Lua.g:202:37: ( ret_stat )?
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
	// grammars/Lua.g:205:1: stat : ( ( assignment )=> assignment | var[false] | do_block | while_stat | repeat_stat | local | require_stat | goto_stat | if_stat | for_stat | function | label | Break | ';' ->);
	public final LuaParser.stat_return stat() throws RecognitionException {
		LuaParser.stat_return retval = new LuaParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Break17=null;
		Token char_literal18=null;
		ParserRuleReturnScope assignment5 =null;
		ParserRuleReturnScope var6 =null;
		ParserRuleReturnScope do_block7 =null;
		ParserRuleReturnScope while_stat8 =null;
		ParserRuleReturnScope repeat_stat9 =null;
		ParserRuleReturnScope local10 =null;
		ParserRuleReturnScope require_stat11 =null;
		ParserRuleReturnScope goto_stat12 =null;
		ParserRuleReturnScope if_stat13 =null;
		ParserRuleReturnScope for_stat14 =null;
		ParserRuleReturnScope function15 =null;
		ParserRuleReturnScope label16 =null;

		CommonTree Break17_tree=null;
		CommonTree char_literal18_tree=null;
		RewriteRuleTokenStream stream_SCol=new RewriteRuleTokenStream(adaptor,"token SCol");

		try {
			// grammars/Lua.g:206:2: ( ( assignment )=> assignment | var[false] | do_block | while_stat | repeat_stat | local | require_stat | goto_stat | if_stat | for_stat | function | label | Break | ';' ->)
			int alt3=14;
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
			case Require:
				{
				alt3=7;
				}
				break;
			case Goto:
				{
				alt3=8;
				}
				break;
			case If:
				{
				alt3=9;
				}
				break;
			case For:
				{
				alt3=10;
				}
				break;
			case Function:
				{
				alt3=11;
				}
				break;
			case ColCol:
				{
				alt3=12;
				}
				break;
			case Break:
				{
				alt3=13;
				}
				break;
			case SCol:
				{
				alt3=14;
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
					// grammars/Lua.g:206:4: ( assignment )=> assignment
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_stat927);
					assignment5=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment5.getTree());

					}
					break;
				case 2 :
					// grammars/Lua.g:207:4: var[false]
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_in_stat932);
					var6=var(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var6.getTree());

					}
					break;
				case 3 :
					// grammars/Lua.g:208:4: do_block
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_do_block_in_stat963);
					do_block7=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, do_block7.getTree());

					}
					break;
				case 4 :
					// grammars/Lua.g:209:4: while_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_while_stat_in_stat969);
					while_stat8=while_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stat8.getTree());

					}
					break;
				case 5 :
					// grammars/Lua.g:210:4: repeat_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_repeat_stat_in_stat974);
					repeat_stat9=repeat_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_stat9.getTree());

					}
					break;
				case 6 :
					// grammars/Lua.g:211:4: local
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_local_in_stat979);
					local10=local();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local10.getTree());

					}
					break;
				case 7 :
					// grammars/Lua.g:212:4: require_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_require_stat_in_stat984);
					require_stat11=require_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, require_stat11.getTree());

					}
					break;
				case 8 :
					// grammars/Lua.g:213:4: goto_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_goto_stat_in_stat989);
					goto_stat12=goto_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goto_stat12.getTree());

					}
					break;
				case 9 :
					// grammars/Lua.g:214:4: if_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stat_in_stat994);
					if_stat13=if_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stat13.getTree());

					}
					break;
				case 10 :
					// grammars/Lua.g:215:4: for_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_for_stat_in_stat999);
					for_stat14=for_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stat14.getTree());

					}
					break;
				case 11 :
					// grammars/Lua.g:216:4: function
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_in_stat1004);
					function15=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function15.getTree());

					}
					break;
				case 12 :
					// grammars/Lua.g:217:4: label
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_label_in_stat1009);
					label16=label();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, label16.getTree());

					}
					break;
				case 13 :
					// grammars/Lua.g:218:4: Break
					{
					root_0 = (CommonTree)adaptor.nil();


					Break17=(Token)match(input,Break,FOLLOW_Break_in_stat1014); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Break17_tree = (CommonTree)adaptor.create(Break17);
					adaptor.addChild(root_0, Break17_tree);
					}

					}
					break;
				case 14 :
					// grammars/Lua.g:219:4: ';'
					{
					char_literal18=(Token)match(input,SCol,FOLLOW_SCol_in_stat1019); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCol.add(char_literal18);

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
					// 219:8: ->
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
	// grammars/Lua.g:222:1: do_block : Do chunk End -> ^( Do chunk ) ;
	public final LuaParser.do_block_return do_block() throws RecognitionException {
		LuaParser.do_block_return retval = new LuaParser.do_block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Do19=null;
		Token End21=null;
		ParserRuleReturnScope chunk20 =null;

		CommonTree Do19_tree=null;
		CommonTree End21_tree=null;
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");

		try {
			// grammars/Lua.g:223:2: ( Do chunk End -> ^( Do chunk ) )
			// grammars/Lua.g:223:4: Do chunk End
			{
			Do19=(Token)match(input,Do,FOLLOW_Do_in_do_block1034); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Do.add(Do19);

			pushFollow(FOLLOW_chunk_in_do_block1036);
			chunk20=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk20.getTree());
			End21=(Token)match(input,End,FOLLOW_End_in_do_block1038); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End21);

			// AST REWRITE
			// elements: Do, chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 223:17: -> ^( Do chunk )
			{
				// grammars/Lua.g:223:20: ^( Do chunk )
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
	// grammars/Lua.g:226:1: while_stat : While expr do_block -> ^( While expr do_block ) ;
	public final LuaParser.while_stat_return while_stat() throws RecognitionException {
		LuaParser.while_stat_return retval = new LuaParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token While22=null;
		ParserRuleReturnScope expr23 =null;
		ParserRuleReturnScope do_block24 =null;

		CommonTree While22_tree=null;
		RewriteRuleTokenStream stream_While=new RewriteRuleTokenStream(adaptor,"token While");
		RewriteRuleSubtreeStream stream_do_block=new RewriteRuleSubtreeStream(adaptor,"rule do_block");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:227:2: ( While expr do_block -> ^( While expr do_block ) )
			// grammars/Lua.g:227:4: While expr do_block
			{
			While22=(Token)match(input,While,FOLLOW_While_in_while_stat1057); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_While.add(While22);

			pushFollow(FOLLOW_expr_in_while_stat1059);
			expr23=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr23.getTree());
			pushFollow(FOLLOW_do_block_in_while_stat1061);
			do_block24=do_block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_do_block.add(do_block24.getTree());
			// AST REWRITE
			// elements: expr, do_block, While
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 227:24: -> ^( While expr do_block )
			{
				// grammars/Lua.g:227:27: ^( While expr do_block )
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
	// grammars/Lua.g:230:1: repeat_stat : Repeat chunk Until expr -> ^( Repeat chunk expr ) ;
	public final LuaParser.repeat_stat_return repeat_stat() throws RecognitionException {
		LuaParser.repeat_stat_return retval = new LuaParser.repeat_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Repeat25=null;
		Token Until27=null;
		ParserRuleReturnScope chunk26 =null;
		ParserRuleReturnScope expr28 =null;

		CommonTree Repeat25_tree=null;
		CommonTree Until27_tree=null;
		RewriteRuleTokenStream stream_Repeat=new RewriteRuleTokenStream(adaptor,"token Repeat");
		RewriteRuleTokenStream stream_Until=new RewriteRuleTokenStream(adaptor,"token Until");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:231:2: ( Repeat chunk Until expr -> ^( Repeat chunk expr ) )
			// grammars/Lua.g:231:4: Repeat chunk Until expr
			{
			Repeat25=(Token)match(input,Repeat,FOLLOW_Repeat_in_repeat_stat1082); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Repeat.add(Repeat25);

			pushFollow(FOLLOW_chunk_in_repeat_stat1084);
			chunk26=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk26.getTree());
			Until27=(Token)match(input,Until,FOLLOW_Until_in_repeat_stat1086); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Until.add(Until27);

			pushFollow(FOLLOW_expr_in_repeat_stat1088);
			expr28=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr28.getTree());
			// AST REWRITE
			// elements: expr, Repeat, chunk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 231:28: -> ^( Repeat chunk expr )
			{
				// grammars/Lua.g:231:31: ^( Repeat chunk expr )
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
	// grammars/Lua.g:234:1: assignment : var_list '=' expr_list -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) ) ;
	public final LuaParser.assignment_return assignment() throws RecognitionException {
		LuaParser.assignment_return retval = new LuaParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal30=null;
		ParserRuleReturnScope var_list29 =null;
		ParserRuleReturnScope expr_list31 =null;

		CommonTree char_literal30_tree=null;
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_var_list=new RewriteRuleSubtreeStream(adaptor,"rule var_list");

		try {
			// grammars/Lua.g:235:2: ( var_list '=' expr_list -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) ) )
			// grammars/Lua.g:235:4: var_list '=' expr_list
			{
			pushFollow(FOLLOW_var_list_in_assignment1110);
			var_list29=var_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var_list.add(var_list29.getTree());
			char_literal30=(Token)match(input,Assign,FOLLOW_Assign_in_assignment1112); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assign.add(char_literal30);

			pushFollow(FOLLOW_expr_list_in_assignment1114);
			expr_list31=expr_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr_list.add(expr_list31.getTree());
			// AST REWRITE
			// elements: expr_list, var_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 236:4: -> ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) )
			{
				// grammars/Lua.g:236:7: ^( ASSIGNMENT ^( VAR_LIST var_list ) ^( EXPR_LIST expr_list ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// grammars/Lua.g:236:20: ^( VAR_LIST var_list )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
				adaptor.addChild(root_2, stream_var_list.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// grammars/Lua.g:236:41: ^( EXPR_LIST expr_list )
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
	// grammars/Lua.g:239:1: local : Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) | name_list -> ^( LOCAL_DEC ^( NAME_LIST name_list ) ) ) ;
	public final LuaParser.local_return local() throws RecognitionException {
		LuaParser.local_return retval = new LuaParser.local_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Local32=null;
		Token char_literal34=null;
		Token Function36=null;
		Token Name37=null;
		ParserRuleReturnScope name_list33 =null;
		ParserRuleReturnScope expr_list35 =null;
		ParserRuleReturnScope func_body38 =null;
		ParserRuleReturnScope name_list39 =null;

		CommonTree Local32_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree Function36_tree=null;
		CommonTree Name37_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleTokenStream stream_Local=new RewriteRuleTokenStream(adaptor,"token Local");
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_name_list=new RewriteRuleSubtreeStream(adaptor,"rule name_list");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:240:2: ( Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) | name_list -> ^( LOCAL_DEC ^( NAME_LIST name_list ) ) ) )
			// grammars/Lua.g:240:4: Local ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) | name_list -> ^( LOCAL_DEC ^( NAME_LIST name_list ) ) )
			{
			Local32=(Token)match(input,Local,FOLLOW_Local_in_local1147); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Local.add(Local32);

			// grammars/Lua.g:240:10: ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) | name_list -> ^( LOCAL_DEC ^( NAME_LIST name_list ) ) )
			int alt4=3;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// grammars/Lua.g:240:12: name_list '=' expr_list
					{
					pushFollow(FOLLOW_name_list_in_local1151);
					name_list33=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list33.getTree());
					char_literal34=(Token)match(input,Assign,FOLLOW_Assign_in_local1153); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal34);

					pushFollow(FOLLOW_expr_list_in_local1155);
					expr_list35=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list35.getTree());
					// AST REWRITE
					// elements: name_list, expr_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 240:36: -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) )
					{
						// grammars/Lua.g:240:39: ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_ASSIGNMENT, "LOCAL_ASSIGNMENT"), root_1);
						// grammars/Lua.g:240:58: ^( NAME_LIST name_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_name_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:240:81: ^( EXPR_LIST expr_list )
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
					// grammars/Lua.g:241:12: Function Name func_body
					{
					Function36=(Token)match(input,Function,FOLLOW_Function_in_local1186); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Function.add(Function36);

					Name37=(Token)match(input,Name,FOLLOW_Name_in_local1188); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name37);

					pushFollow(FOLLOW_func_body_in_local1190);
					func_body38=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body38.getTree());
					// AST REWRITE
					// elements: func_body, Name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 241:36: -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:241:39: ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_ASSIGNMENT, "LOCAL_ASSIGNMENT"), root_1);
						// grammars/Lua.g:241:58: ^( NAME_LIST Name )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_Name.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:241:76: ^( EXPR_LIST func_body )
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
				case 3 :
					// grammars/Lua.g:242:12: name_list
					{
					pushFollow(FOLLOW_name_list_in_local1221);
					name_list39=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list39.getTree());
					// AST REWRITE
					// elements: name_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 242:22: -> ^( LOCAL_DEC ^( NAME_LIST name_list ) )
					{
						// grammars/Lua.g:242:25: ^( LOCAL_DEC ^( NAME_LIST name_list ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_DEC, "LOCAL_DEC"), root_1);
						// grammars/Lua.g:242:37: ^( NAME_LIST name_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_name_list.nextTree());
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


	public static class require_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "require_stat"
	// grammars/Lua.g:246:2: require_stat : Require expr_list -> ^( REQUIRE ^( EXPR_LIST expr_list ) ) ;
	public final LuaParser.require_stat_return require_stat() throws RecognitionException {
		LuaParser.require_stat_return retval = new LuaParser.require_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Require40=null;
		ParserRuleReturnScope expr_list41 =null;

		CommonTree Require40_tree=null;
		RewriteRuleTokenStream stream_Require=new RewriteRuleTokenStream(adaptor,"token Require");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// grammars/Lua.g:247:2: ( Require expr_list -> ^( REQUIRE ^( EXPR_LIST expr_list ) ) )
			// grammars/Lua.g:247:4: Require expr_list
			{
			Require40=(Token)match(input,Require,FOLLOW_Require_in_require_stat1256); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Require.add(Require40);

			pushFollow(FOLLOW_expr_list_in_require_stat1258);
			expr_list41=expr_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr_list.add(expr_list41.getTree());
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
			// 247:22: -> ^( REQUIRE ^( EXPR_LIST expr_list ) )
			{
				// grammars/Lua.g:247:25: ^( REQUIRE ^( EXPR_LIST expr_list ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REQUIRE, "REQUIRE"), root_1);
				// grammars/Lua.g:247:35: ^( EXPR_LIST expr_list )
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
	// $ANTLR end "require_stat"


	public static class goto_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goto_stat"
	// grammars/Lua.g:250:1: goto_stat : Goto Name -> ^( Goto Name ) ;
	public final LuaParser.goto_stat_return goto_stat() throws RecognitionException {
		LuaParser.goto_stat_return retval = new LuaParser.goto_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Goto42=null;
		Token Name43=null;

		CommonTree Goto42_tree=null;
		CommonTree Name43_tree=null;
		RewriteRuleTokenStream stream_Goto=new RewriteRuleTokenStream(adaptor,"token Goto");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:251:2: ( Goto Name -> ^( Goto Name ) )
			// grammars/Lua.g:251:4: Goto Name
			{
			Goto42=(Token)match(input,Goto,FOLLOW_Goto_in_goto_stat1281); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Goto.add(Goto42);

			Name43=(Token)match(input,Name,FOLLOW_Name_in_goto_stat1283); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name43);

			// AST REWRITE
			// elements: Goto, Name
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 251:14: -> ^( Goto Name )
			{
				// grammars/Lua.g:251:17: ^( Goto Name )
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
	// grammars/Lua.g:254:1: if_stat : If expr Then chunk ( elseif_stat )* ( else_stat )? End -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? ) ;
	public final LuaParser.if_stat_return if_stat() throws RecognitionException {
		LuaParser.if_stat_return retval = new LuaParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token If44=null;
		Token Then46=null;
		Token End50=null;
		ParserRuleReturnScope expr45 =null;
		ParserRuleReturnScope chunk47 =null;
		ParserRuleReturnScope elseif_stat48 =null;
		ParserRuleReturnScope else_stat49 =null;

		CommonTree If44_tree=null;
		CommonTree Then46_tree=null;
		CommonTree End50_tree=null;
		RewriteRuleTokenStream stream_Then=new RewriteRuleTokenStream(adaptor,"token Then");
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_elseif_stat=new RewriteRuleSubtreeStream(adaptor,"rule elseif_stat");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_else_stat=new RewriteRuleSubtreeStream(adaptor,"rule else_stat");

		try {
			// grammars/Lua.g:255:2: ( If expr Then chunk ( elseif_stat )* ( else_stat )? End -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? ) )
			// grammars/Lua.g:255:4: If expr Then chunk ( elseif_stat )* ( else_stat )? End
			{
			If44=(Token)match(input,If,FOLLOW_If_in_if_stat1302); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If44);

			pushFollow(FOLLOW_expr_in_if_stat1304);
			expr45=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());
			Then46=(Token)match(input,Then,FOLLOW_Then_in_if_stat1306); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Then.add(Then46);

			pushFollow(FOLLOW_chunk_in_if_stat1308);
			chunk47=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk47.getTree());
			// grammars/Lua.g:255:23: ( elseif_stat )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==Elseif) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// grammars/Lua.g:255:23: elseif_stat
					{
					pushFollow(FOLLOW_elseif_stat_in_if_stat1310);
					elseif_stat48=elseif_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseif_stat.add(elseif_stat48.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// grammars/Lua.g:255:36: ( else_stat )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Else) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// grammars/Lua.g:255:36: else_stat
					{
					pushFollow(FOLLOW_else_stat_in_if_stat1313);
					else_stat49=else_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_else_stat.add(else_stat49.getTree());
					}
					break;

			}

			End50=(Token)match(input,End,FOLLOW_End_in_if_stat1316); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End50);

			// AST REWRITE
			// elements: elseif_stat, If, chunk, expr, else_stat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 255:51: -> ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? )
			{
				// grammars/Lua.g:255:54: ^( If ^( CONDITION expr chunk ) ( elseif_stat )* ( else_stat )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_If.nextNode(), root_1);
				// grammars/Lua.g:255:59: ^( CONDITION expr chunk )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_2);
				adaptor.addChild(root_2, stream_expr.nextTree());
				adaptor.addChild(root_2, stream_chunk.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// grammars/Lua.g:255:83: ( elseif_stat )*
				while ( stream_elseif_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_elseif_stat.nextTree());
				}
				stream_elseif_stat.reset();

				// grammars/Lua.g:255:96: ( else_stat )?
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
	// grammars/Lua.g:258:1: elseif_stat : Elseif expr Then chunk -> ^( CONDITION expr chunk ) ;
	public final LuaParser.elseif_stat_return elseif_stat() throws RecognitionException {
		LuaParser.elseif_stat_return retval = new LuaParser.elseif_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Elseif51=null;
		Token Then53=null;
		ParserRuleReturnScope expr52 =null;
		ParserRuleReturnScope chunk54 =null;

		CommonTree Elseif51_tree=null;
		CommonTree Then53_tree=null;
		RewriteRuleTokenStream stream_Elseif=new RewriteRuleTokenStream(adaptor,"token Elseif");
		RewriteRuleTokenStream stream_Then=new RewriteRuleTokenStream(adaptor,"token Then");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:259:2: ( Elseif expr Then chunk -> ^( CONDITION expr chunk ) )
			// grammars/Lua.g:259:4: Elseif expr Then chunk
			{
			Elseif51=(Token)match(input,Elseif,FOLLOW_Elseif_in_elseif_stat1347); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Elseif.add(Elseif51);

			pushFollow(FOLLOW_expr_in_elseif_stat1349);
			expr52=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr52.getTree());
			Then53=(Token)match(input,Then,FOLLOW_Then_in_elseif_stat1351); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Then.add(Then53);

			pushFollow(FOLLOW_chunk_in_elseif_stat1353);
			chunk54=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk54.getTree());
			// AST REWRITE
			// elements: chunk, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 259:27: -> ^( CONDITION expr chunk )
			{
				// grammars/Lua.g:259:30: ^( CONDITION expr chunk )
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
	// grammars/Lua.g:262:1: else_stat : Else chunk -> ^( CONDITION True chunk ) ;
	public final LuaParser.else_stat_return else_stat() throws RecognitionException {
		LuaParser.else_stat_return retval = new LuaParser.else_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Else55=null;
		ParserRuleReturnScope chunk56 =null;

		CommonTree Else55_tree=null;
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");

		try {
			// grammars/Lua.g:263:2: ( Else chunk -> ^( CONDITION True chunk ) )
			// grammars/Lua.g:263:4: Else chunk
			{
			Else55=(Token)match(input,Else,FOLLOW_Else_in_else_stat1374); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else55);

			pushFollow(FOLLOW_chunk_in_else_stat1376);
			chunk56=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk56.getTree());
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
			// 263:15: -> ^( CONDITION True chunk )
			{
				// grammars/Lua.g:263:18: ^( CONDITION True chunk )
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
	// grammars/Lua.g:266:1: for_stat : For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) ) ;
	public final LuaParser.for_stat_return for_stat() throws RecognitionException {
		LuaParser.for_stat_return retval = new LuaParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token For57=null;
		Token Name58=null;
		Token char_literal59=null;
		Token char_literal60=null;
		Token char_literal61=null;
		Token In64=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope do_block62 =null;
		ParserRuleReturnScope name_list63 =null;
		ParserRuleReturnScope expr_list65 =null;
		ParserRuleReturnScope do_block66 =null;

		CommonTree For57_tree=null;
		CommonTree Name58_tree=null;
		CommonTree char_literal59_tree=null;
		CommonTree char_literal60_tree=null;
		CommonTree char_literal61_tree=null;
		CommonTree In64_tree=null;
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
			// grammars/Lua.g:267:2: ( For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) ) )
			// grammars/Lua.g:267:4: For ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) )
			{
			For57=(Token)match(input,For,FOLLOW_For_in_for_stat1397); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_For.add(For57);

			// grammars/Lua.g:267:8: ( Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block -> ^( For Name $a $b ( $c)? do_block ) | name_list In expr_list do_block -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) )
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
					// grammars/Lua.g:267:10: Name '=' a= expr ',' b= expr ( ',' c= expr )? do_block
					{
					Name58=(Token)match(input,Name,FOLLOW_Name_in_for_stat1401); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name58);

					char_literal59=(Token)match(input,Assign,FOLLOW_Assign_in_for_stat1403); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal59);

					pushFollow(FOLLOW_expr_in_for_stat1407);
					a=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(a.getTree());
					char_literal60=(Token)match(input,Comma,FOLLOW_Comma_in_for_stat1409); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal60);

					pushFollow(FOLLOW_expr_in_for_stat1413);
					b=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(b.getTree());
					// grammars/Lua.g:267:37: ( ',' c= expr )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==Comma) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// grammars/Lua.g:267:38: ',' c= expr
							{
							char_literal61=(Token)match(input,Comma,FOLLOW_Comma_in_for_stat1416); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Comma.add(char_literal61);

							pushFollow(FOLLOW_expr_in_for_stat1420);
							c=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(c.getTree());
							}
							break;

					}

					pushFollow(FOLLOW_do_block_in_for_stat1424);
					do_block62=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_do_block.add(do_block62.getTree());
					// AST REWRITE
					// elements: a, Name, do_block, b, For, c
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
					// 267:60: -> ^( For Name $a $b ( $c)? do_block )
					{
						// grammars/Lua.g:267:63: ^( For Name $a $b ( $c)? do_block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_For.nextNode(), root_1);
						adaptor.addChild(root_1, stream_Name.nextNode());
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						// grammars/Lua.g:267:81: ( $c)?
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
					// grammars/Lua.g:268:10: name_list In expr_list do_block
					{
					pushFollow(FOLLOW_name_list_in_for_stat1455);
					name_list63=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list63.getTree());
					In64=(Token)match(input,In,FOLLOW_In_in_for_stat1457); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_In.add(In64);

					pushFollow(FOLLOW_expr_list_in_for_stat1459);
					expr_list65=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list65.getTree());
					pushFollow(FOLLOW_do_block_in_for_stat1461);
					do_block66=do_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_do_block.add(do_block66.getTree());
					// AST REWRITE
					// elements: name_list, do_block, expr_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 268:60: -> ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block )
					{
						// grammars/Lua.g:268:63: ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_IN, "FOR_IN"), root_1);
						// grammars/Lua.g:268:72: ^( NAME_LIST name_list )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME_LIST, "NAME_LIST"), root_2);
						adaptor.addChild(root_2, stream_name_list.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:268:95: ^( EXPR_LIST expr_list )
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
	// grammars/Lua.g:272:1: function : Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) ) ;
	public final LuaParser.function_return function() throws RecognitionException {
		LuaParser.function_return retval = new LuaParser.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Function67=null;
		Token Col69=null;
		Token Name70=null;
		ParserRuleReturnScope names68 =null;
		ParserRuleReturnScope func_body71 =null;
		ParserRuleReturnScope func_body72 =null;

		CommonTree Function67_tree=null;
		CommonTree Col69_tree=null;
		CommonTree Name70_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleTokenStream stream_Col=new RewriteRuleTokenStream(adaptor,"token Col");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_names=new RewriteRuleSubtreeStream(adaptor,"rule names");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:273:2: ( Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) ) )
			// grammars/Lua.g:273:4: Function names ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) )
			{
			Function67=(Token)match(input,Function,FOLLOW_Function_in_function1519); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Function.add(Function67);

			pushFollow(FOLLOW_names_in_function1521);
			names68=names();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_names.add(names68.getTree());
			// grammars/Lua.g:273:19: ( Col Name func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) | func_body -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) ) )
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
					// grammars/Lua.g:273:21: Col Name func_body
					{
					Col69=(Token)match(input,Col,FOLLOW_Col_in_function1525); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(Col69);

					Name70=(Token)match(input,Name,FOLLOW_Name_in_function1527); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name70);

					if ( state.backtracking==0 ) {addSelf=true;}
					pushFollow(FOLLOW_func_body_in_function1531);
					func_body71=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body71.getTree());
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
					// 274:21: -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:274:24: ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_ASSIGNMENT, "FUNCTION_ASSIGNMENT"), root_1);
						// grammars/Lua.g:274:46: ^( VAR_LIST )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
						adaptor.addChild(root_2, namesToVar((names68!=null?((LuaParser.names_return)names68).list:null), (Name70!=null?Name70.getText():null)));
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:274:96: ^( EXPR_LIST func_body )
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
					// grammars/Lua.g:275:21: func_body
					{
					pushFollow(FOLLOW_func_body_in_function1594);
					func_body72=func_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_body.add(func_body72.getTree());
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
					// 276:21: -> ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
					{
						// grammars/Lua.g:276:24: ^( FUNCTION_ASSIGNMENT ^( VAR_LIST ) ^( EXPR_LIST func_body ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_ASSIGNMENT, "FUNCTION_ASSIGNMENT"), root_1);
						// grammars/Lua.g:276:46: ^( VAR_LIST )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_LIST, "VAR_LIST"), root_2);
						adaptor.addChild(root_2, namesToVar((names68!=null?((LuaParser.names_return)names68).list:null)));
						adaptor.addChild(root_1, root_2);
						}

						// grammars/Lua.g:276:84: ^( EXPR_LIST func_body )
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
	// grammars/Lua.g:280:1: names returns [List<String> list] : a= Name ( '.' b= Name )* ;
	public final LuaParser.names_return names() throws RecognitionException {
		LuaParser.names_return retval = new LuaParser.names_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token a=null;
		Token b=null;
		Token char_literal73=null;

		CommonTree a_tree=null;
		CommonTree b_tree=null;
		CommonTree char_literal73_tree=null;

		retval.list = new ArrayList<String>();
		try {
			// grammars/Lua.g:282:2: (a= Name ( '.' b= Name )* )
			// grammars/Lua.g:282:4: a= Name ( '.' b= Name )*
			{
			root_0 = (CommonTree)adaptor.nil();


			a=(Token)match(input,Name,FOLLOW_Name_in_names1673); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			a_tree = (CommonTree)adaptor.create(a);
			adaptor.addChild(root_0, a_tree);
			}

			if ( state.backtracking==0 ) {retval.list.add((a!=null?a.getText():null));}
			// grammars/Lua.g:282:33: ( '.' b= Name )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Dot) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// grammars/Lua.g:282:34: '.' b= Name
					{
					char_literal73=(Token)match(input,Dot,FOLLOW_Dot_in_names1678); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal73_tree = (CommonTree)adaptor.create(char_literal73);
					adaptor.addChild(root_0, char_literal73_tree);
					}

					b=(Token)match(input,Name,FOLLOW_Name_in_names1682); if (state.failed) return retval;
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
	// grammars/Lua.g:285:1: function_literal : Function func_body -> func_body ;
	public final LuaParser.function_literal_return function_literal() throws RecognitionException {
		LuaParser.function_literal_return retval = new LuaParser.function_literal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Function74=null;
		ParserRuleReturnScope func_body75 =null;

		CommonTree Function74_tree=null;
		RewriteRuleTokenStream stream_Function=new RewriteRuleTokenStream(adaptor,"token Function");
		RewriteRuleSubtreeStream stream_func_body=new RewriteRuleSubtreeStream(adaptor,"rule func_body");

		try {
			// grammars/Lua.g:286:2: ( Function func_body -> func_body )
			// grammars/Lua.g:286:4: Function func_body
			{
			Function74=(Token)match(input,Function,FOLLOW_Function_in_function_literal1697); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Function.add(Function74);

			pushFollow(FOLLOW_func_body_in_function_literal1699);
			func_body75=func_body();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_body.add(func_body75.getTree());
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
			// 286:23: -> func_body
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
	// grammars/Lua.g:289:1: func_body : '(' param_list ')' chunk End -> ^( FUNCTION param_list chunk ) ;
	public final LuaParser.func_body_return func_body() throws RecognitionException {
		LuaParser.func_body_return retval = new LuaParser.func_body_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal76=null;
		Token char_literal78=null;
		Token End80=null;
		ParserRuleReturnScope param_list77 =null;
		ParserRuleReturnScope chunk79 =null;

		CommonTree char_literal76_tree=null;
		CommonTree char_literal78_tree=null;
		CommonTree End80_tree=null;
		RewriteRuleTokenStream stream_CPar=new RewriteRuleTokenStream(adaptor,"token CPar");
		RewriteRuleTokenStream stream_OPar=new RewriteRuleTokenStream(adaptor,"token OPar");
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleSubtreeStream stream_chunk=new RewriteRuleSubtreeStream(adaptor,"rule chunk");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// grammars/Lua.g:290:2: ( '(' param_list ')' chunk End -> ^( FUNCTION param_list chunk ) )
			// grammars/Lua.g:290:4: '(' param_list ')' chunk End
			{
			char_literal76=(Token)match(input,OPar,FOLLOW_OPar_in_func_body1714); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OPar.add(char_literal76);

			pushFollow(FOLLOW_param_list_in_func_body1716);
			param_list77=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list77.getTree());
			char_literal78=(Token)match(input,CPar,FOLLOW_CPar_in_func_body1718); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CPar.add(char_literal78);

			pushFollow(FOLLOW_chunk_in_func_body1720);
			chunk79=chunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_chunk.add(chunk79.getTree());
			End80=(Token)match(input,End,FOLLOW_End_in_func_body1722); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_End.add(End80);

			// AST REWRITE
			// elements: chunk, param_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 290:33: -> ^( FUNCTION param_list chunk )
			{
				// grammars/Lua.g:290:36: ^( FUNCTION param_list chunk )
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
	// grammars/Lua.g:293:1: param_list : ( name_list ( ',' DotDotDot )? -> ^( PARAM_LIST name_list ( DotDotDot )? ) | ( DotDotDot )? -> ^( PARAM_LIST ( DotDotDot )? ) );
	public final LuaParser.param_list_return param_list() throws RecognitionException {
		LuaParser.param_list_return retval = new LuaParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal82=null;
		Token DotDotDot83=null;
		Token DotDotDot84=null;
		ParserRuleReturnScope name_list81 =null;

		CommonTree char_literal82_tree=null;
		CommonTree DotDotDot83_tree=null;
		CommonTree DotDotDot84_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_DotDotDot=new RewriteRuleTokenStream(adaptor,"token DotDotDot");
		RewriteRuleSubtreeStream stream_name_list=new RewriteRuleSubtreeStream(adaptor,"rule name_list");

		try {
			// grammars/Lua.g:294:2: ( name_list ( ',' DotDotDot )? -> ^( PARAM_LIST name_list ( DotDotDot )? ) | ( DotDotDot )? -> ^( PARAM_LIST ( DotDotDot )? ) )
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
					// grammars/Lua.g:294:4: name_list ( ',' DotDotDot )?
					{
					pushFollow(FOLLOW_name_list_in_param_list1743);
					name_list81=name_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name_list.add(name_list81.getTree());
					// grammars/Lua.g:294:14: ( ',' DotDotDot )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==Comma) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// grammars/Lua.g:294:15: ',' DotDotDot
							{
							char_literal82=(Token)match(input,Comma,FOLLOW_Comma_in_param_list1746); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Comma.add(char_literal82);

							DotDotDot83=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_param_list1748); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DotDotDot.add(DotDotDot83);

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
					// 294:31: -> ^( PARAM_LIST name_list ( DotDotDot )? )
					{
						// grammars/Lua.g:294:34: ^( PARAM_LIST name_list ( DotDotDot )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_LIST, "PARAM_LIST"), root_1);
						adaptor.addChild(root_1, stream_name_list.nextTree());
						// grammars/Lua.g:294:57: ( DotDotDot )?
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
					// grammars/Lua.g:295:4: ( DotDotDot )?
					{
					// grammars/Lua.g:295:4: ( DotDotDot )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==DotDotDot) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// grammars/Lua.g:295:4: DotDotDot
							{
							DotDotDot84=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_param_list1766); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DotDotDot.add(DotDotDot84);

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
					// 295:31: -> ^( PARAM_LIST ( DotDotDot )? )
					{
						// grammars/Lua.g:295:34: ^( PARAM_LIST ( DotDotDot )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_LIST, "PARAM_LIST"), root_1);
						// grammars/Lua.g:295:47: ( DotDotDot )?
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
	// grammars/Lua.g:298:1: ret_stat : Return ( expr_list )? ( ';' )? -> ^( Return ( expr_list )? ) ;
	public final LuaParser.ret_stat_return ret_stat() throws RecognitionException {
		LuaParser.ret_stat_return retval = new LuaParser.ret_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Return85=null;
		Token char_literal87=null;
		ParserRuleReturnScope expr_list86 =null;

		CommonTree Return85_tree=null;
		CommonTree char_literal87_tree=null;
		RewriteRuleTokenStream stream_Return=new RewriteRuleTokenStream(adaptor,"token Return");
		RewriteRuleTokenStream stream_SCol=new RewriteRuleTokenStream(adaptor,"token SCol");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// grammars/Lua.g:299:2: ( Return ( expr_list )? ( ';' )? -> ^( Return ( expr_list )? ) )
			// grammars/Lua.g:299:4: Return ( expr_list )? ( ';' )?
			{
			Return85=(Token)match(input,Return,FOLLOW_Return_in_ret_stat1803); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Return.add(Return85);

			// grammars/Lua.g:299:11: ( expr_list )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==DotDotDot||LA14_0==False||LA14_0==Function||LA14_0==Length||LA14_0==Minus||(LA14_0 >= Name && LA14_0 <= OBrace)||LA14_0==OPar||LA14_0==String||LA14_0==True) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// grammars/Lua.g:299:11: expr_list
					{
					pushFollow(FOLLOW_expr_list_in_ret_stat1805);
					expr_list86=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list86.getTree());
					}
					break;

			}

			// grammars/Lua.g:299:22: ( ';' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==SCol) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// grammars/Lua.g:299:22: ';'
					{
					char_literal87=(Token)match(input,SCol,FOLLOW_SCol_in_ret_stat1808); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCol.add(char_literal87);

					}
					break;

			}

			// AST REWRITE
			// elements: Return, expr_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 299:27: -> ^( Return ( expr_list )? )
			{
				// grammars/Lua.g:299:30: ^( Return ( expr_list )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_Return.nextNode(), root_1);
				// grammars/Lua.g:299:39: ( expr_list )?
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
	// grammars/Lua.g:302:1: expr : or_expr ;
	public final LuaParser.expr_return expr() throws RecognitionException {
		LuaParser.expr_return retval = new LuaParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope or_expr88 =null;


		try {
			// grammars/Lua.g:303:2: ( or_expr )
			// grammars/Lua.g:303:4: or_expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_or_expr_in_expr1829);
			or_expr88=or_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, or_expr88.getTree());

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
	// grammars/Lua.g:306:1: or_expr : and_expr ( Or ^ and_expr )* ;
	public final LuaParser.or_expr_return or_expr() throws RecognitionException {
		LuaParser.or_expr_return retval = new LuaParser.or_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Or90=null;
		ParserRuleReturnScope and_expr89 =null;
		ParserRuleReturnScope and_expr91 =null;

		CommonTree Or90_tree=null;

		try {
			// grammars/Lua.g:307:2: ( and_expr ( Or ^ and_expr )* )
			// grammars/Lua.g:307:4: and_expr ( Or ^ and_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_and_expr_in_or_expr1840);
			and_expr89=and_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr89.getTree());

			// grammars/Lua.g:307:13: ( Or ^ and_expr )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==Or) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// grammars/Lua.g:307:14: Or ^ and_expr
					{
					Or90=(Token)match(input,Or,FOLLOW_Or_in_or_expr1843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Or90_tree = (CommonTree)adaptor.create(Or90);
					root_0 = (CommonTree)adaptor.becomeRoot(Or90_tree, root_0);
					}

					pushFollow(FOLLOW_and_expr_in_or_expr1846);
					and_expr91=and_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr91.getTree());

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
	// grammars/Lua.g:310:1: and_expr : rel_expr ( And ^ rel_expr )* ;
	public final LuaParser.and_expr_return and_expr() throws RecognitionException {
		LuaParser.and_expr_return retval = new LuaParser.and_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token And93=null;
		ParserRuleReturnScope rel_expr92 =null;
		ParserRuleReturnScope rel_expr94 =null;

		CommonTree And93_tree=null;

		try {
			// grammars/Lua.g:311:2: ( rel_expr ( And ^ rel_expr )* )
			// grammars/Lua.g:311:4: rel_expr ( And ^ rel_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_rel_expr_in_and_expr1859);
			rel_expr92=rel_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_expr92.getTree());

			// grammars/Lua.g:311:13: ( And ^ rel_expr )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==And) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// grammars/Lua.g:311:14: And ^ rel_expr
					{
					And93=(Token)match(input,And,FOLLOW_And_in_and_expr1862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					And93_tree = (CommonTree)adaptor.create(And93);
					root_0 = (CommonTree)adaptor.becomeRoot(And93_tree, root_0);
					}

					pushFollow(FOLLOW_rel_expr_in_and_expr1865);
					rel_expr94=rel_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_expr94.getTree());

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
	// grammars/Lua.g:314:1: rel_expr : concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )? ;
	public final LuaParser.rel_expr_return rel_expr() throws RecognitionException {
		LuaParser.rel_expr_return retval = new LuaParser.rel_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set96=null;
		ParserRuleReturnScope concat_expr95 =null;
		ParserRuleReturnScope concat_expr97 =null;

		CommonTree set96_tree=null;

		try {
			// grammars/Lua.g:315:2: ( concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )? )
			// grammars/Lua.g:315:4: concat_expr ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_concat_expr_in_rel_expr1878);
			concat_expr95=concat_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, concat_expr95.getTree());

			// grammars/Lua.g:315:16: ( ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==Eq||(LA18_0 >= GT && LA18_0 <= GTEq)||(LA18_0 >= LT && LA18_0 <= LTEq)||LA18_0==NEq) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// grammars/Lua.g:315:17: ( LT | GT | LTEq | GTEq | NEq | Eq ) ^ concat_expr
					{
					set96=input.LT(1);
					set96=input.LT(1);
					if ( input.LA(1)==Eq||(input.LA(1) >= GT && input.LA(1) <= GTEq)||(input.LA(1) >= LT && input.LA(1) <= LTEq)||input.LA(1)==NEq ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set96), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_concat_expr_in_rel_expr1906);
					concat_expr97=concat_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, concat_expr97.getTree());

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
	// grammars/Lua.g:318:1: concat_expr : add_expr ( DotDot ^ add_expr )* ;
	public final LuaParser.concat_expr_return concat_expr() throws RecognitionException {
		LuaParser.concat_expr_return retval = new LuaParser.concat_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DotDot99=null;
		ParserRuleReturnScope add_expr98 =null;
		ParserRuleReturnScope add_expr100 =null;

		CommonTree DotDot99_tree=null;

		try {
			// grammars/Lua.g:319:2: ( add_expr ( DotDot ^ add_expr )* )
			// grammars/Lua.g:319:4: add_expr ( DotDot ^ add_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_add_expr_in_concat_expr1919);
			add_expr98=add_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr98.getTree());

			// grammars/Lua.g:319:13: ( DotDot ^ add_expr )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==DotDot) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// grammars/Lua.g:319:14: DotDot ^ add_expr
					{
					DotDot99=(Token)match(input,DotDot,FOLLOW_DotDot_in_concat_expr1922); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DotDot99_tree = (CommonTree)adaptor.create(DotDot99);
					root_0 = (CommonTree)adaptor.becomeRoot(DotDot99_tree, root_0);
					}

					pushFollow(FOLLOW_add_expr_in_concat_expr1925);
					add_expr100=add_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr100.getTree());

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
	// grammars/Lua.g:322:1: add_expr : mult_expr ( ( Add | Minus ) ^ mult_expr )* ;
	public final LuaParser.add_expr_return add_expr() throws RecognitionException {
		LuaParser.add_expr_return retval = new LuaParser.add_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set102=null;
		ParserRuleReturnScope mult_expr101 =null;
		ParserRuleReturnScope mult_expr103 =null;

		CommonTree set102_tree=null;

		try {
			// grammars/Lua.g:323:2: ( mult_expr ( ( Add | Minus ) ^ mult_expr )* )
			// grammars/Lua.g:323:4: mult_expr ( ( Add | Minus ) ^ mult_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_mult_expr_in_add_expr1938);
			mult_expr101=mult_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr101.getTree());

			// grammars/Lua.g:323:14: ( ( Add | Minus ) ^ mult_expr )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==Add||LA20_0==Minus) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// grammars/Lua.g:323:15: ( Add | Minus ) ^ mult_expr
					{
					set102=input.LT(1);
					set102=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Minus ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set102), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mult_expr_in_add_expr1950);
					mult_expr103=mult_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr103.getTree());

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
	// grammars/Lua.g:326:1: mult_expr : unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )* ;
	public final LuaParser.mult_expr_return mult_expr() throws RecognitionException {
		LuaParser.mult_expr_return retval = new LuaParser.mult_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set105=null;
		ParserRuleReturnScope unary_expr104 =null;
		ParserRuleReturnScope unary_expr106 =null;

		CommonTree set105_tree=null;

		try {
			// grammars/Lua.g:327:2: ( unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )* )
			// grammars/Lua.g:327:4: unary_expr ( ( Mult | Div | Mod ) ^ unary_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unary_expr_in_mult_expr1963);
			unary_expr104=unary_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr104.getTree());

			// grammars/Lua.g:327:15: ( ( Mult | Div | Mod ) ^ unary_expr )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==Div||(LA21_0 >= Mod && LA21_0 <= Mult)) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// grammars/Lua.g:327:16: ( Mult | Div | Mod ) ^ unary_expr
					{
					set105=input.LT(1);
					set105=input.LT(1);
					if ( input.LA(1)==Div||(input.LA(1) >= Mod && input.LA(1) <= Mult) ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set105), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unary_expr_in_mult_expr1979);
					unary_expr106=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr106.getTree());

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
	// grammars/Lua.g:330:1: unary_expr : ( Minus unary_expr -> ^( UNARY_MINUS unary_expr ) | Length pow_expr -> ^( Length pow_expr ) | Not unary_expr -> ^( Not unary_expr ) | pow_expr );
	public final LuaParser.unary_expr_return unary_expr() throws RecognitionException {
		LuaParser.unary_expr_return retval = new LuaParser.unary_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Minus107=null;
		Token Length109=null;
		Token Not111=null;
		ParserRuleReturnScope unary_expr108 =null;
		ParserRuleReturnScope pow_expr110 =null;
		ParserRuleReturnScope unary_expr112 =null;
		ParserRuleReturnScope pow_expr113 =null;

		CommonTree Minus107_tree=null;
		CommonTree Length109_tree=null;
		CommonTree Not111_tree=null;
		RewriteRuleTokenStream stream_Not=new RewriteRuleTokenStream(adaptor,"token Not");
		RewriteRuleTokenStream stream_Length=new RewriteRuleTokenStream(adaptor,"token Length");
		RewriteRuleTokenStream stream_Minus=new RewriteRuleTokenStream(adaptor,"token Minus");
		RewriteRuleSubtreeStream stream_unary_expr=new RewriteRuleSubtreeStream(adaptor,"rule unary_expr");
		RewriteRuleSubtreeStream stream_pow_expr=new RewriteRuleSubtreeStream(adaptor,"rule pow_expr");

		try {
			// grammars/Lua.g:331:2: ( Minus unary_expr -> ^( UNARY_MINUS unary_expr ) | Length pow_expr -> ^( Length pow_expr ) | Not unary_expr -> ^( Not unary_expr ) | pow_expr )
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
					// grammars/Lua.g:331:4: Minus unary_expr
					{
					Minus107=(Token)match(input,Minus,FOLLOW_Minus_in_unary_expr1992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Minus.add(Minus107);

					pushFollow(FOLLOW_unary_expr_in_unary_expr1994);
					unary_expr108=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_unary_expr.add(unary_expr108.getTree());
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
					// 331:21: -> ^( UNARY_MINUS unary_expr )
					{
						// grammars/Lua.g:331:24: ^( UNARY_MINUS unary_expr )
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
					// grammars/Lua.g:332:4: Length pow_expr
					{
					Length109=(Token)match(input,Length,FOLLOW_Length_in_unary_expr2007); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Length.add(Length109);

					pushFollow(FOLLOW_pow_expr_in_unary_expr2009);
					pow_expr110=pow_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_pow_expr.add(pow_expr110.getTree());
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
					// 332:21: -> ^( Length pow_expr )
					{
						// grammars/Lua.g:332:24: ^( Length pow_expr )
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
					// grammars/Lua.g:333:4: Not unary_expr
					{
					Not111=(Token)match(input,Not,FOLLOW_Not_in_unary_expr2023); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Not.add(Not111);

					pushFollow(FOLLOW_unary_expr_in_unary_expr2025);
					unary_expr112=unary_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_unary_expr.add(unary_expr112.getTree());
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
					// 333:21: -> ^( Not unary_expr )
					{
						// grammars/Lua.g:333:24: ^( Not unary_expr )
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
					// grammars/Lua.g:334:4: pow_expr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_pow_expr_in_unary_expr2040);
					pow_expr113=pow_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr113.getTree());

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
	// grammars/Lua.g:338:1: pow_expr : (a+= atom -> $a) ( ( Pow a+= atom )+ ->)? ;
	public final LuaParser.pow_expr_return pow_expr() throws RecognitionException {
		LuaParser.pow_expr_return retval = new LuaParser.pow_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Pow114=null;
		List<Object> list_a=null;
		RuleReturnScope a = null;
		CommonTree Pow114_tree=null;
		RewriteRuleTokenStream stream_Pow=new RewriteRuleTokenStream(adaptor,"token Pow");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			// grammars/Lua.g:340:2: ( (a+= atom -> $a) ( ( Pow a+= atom )+ ->)? )
			// grammars/Lua.g:340:4: (a+= atom -> $a) ( ( Pow a+= atom )+ ->)?
			{
			// grammars/Lua.g:340:4: (a+= atom -> $a)
			// grammars/Lua.g:340:5: a+= atom
			{
			pushFollow(FOLLOW_atom_in_pow_expr2056);
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
			// 340:13: -> $a
			{
				adaptor.addChild(root_0, stream_a.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// grammars/Lua.g:340:20: ( ( Pow a+= atom )+ ->)?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==Pow) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// grammars/Lua.g:340:21: ( Pow a+= atom )+
					{
					// grammars/Lua.g:340:21: ( Pow a+= atom )+
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
							// grammars/Lua.g:340:22: Pow a+= atom
							{
							Pow114=(Token)match(input,Pow,FOLLOW_Pow_in_pow_expr2066); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pow.add(Pow114);

							pushFollow(FOLLOW_atom_in_pow_expr2070);
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
					// 340:36: ->
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
	// grammars/Lua.g:343:1: atom : ( var[false] | function_literal | table_constructor | DotDotDot | Number | String | Nil | True | False );
	public final LuaParser.atom_return atom() throws RecognitionException {
		LuaParser.atom_return retval = new LuaParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DotDotDot118=null;
		Token Number119=null;
		Token String120=null;
		Token Nil121=null;
		Token True122=null;
		Token False123=null;
		ParserRuleReturnScope var115 =null;
		ParserRuleReturnScope function_literal116 =null;
		ParserRuleReturnScope table_constructor117 =null;

		CommonTree DotDotDot118_tree=null;
		CommonTree Number119_tree=null;
		CommonTree String120_tree=null;
		CommonTree Nil121_tree=null;
		CommonTree True122_tree=null;
		CommonTree False123_tree=null;

		try {
			// grammars/Lua.g:344:2: ( var[false] | function_literal | table_constructor | DotDotDot | Number | String | Nil | True | False )
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
					// grammars/Lua.g:344:4: var[false]
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_in_atom2089);
					var115=var(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var115.getTree());

					}
					break;
				case 2 :
					// grammars/Lua.g:345:4: function_literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_literal_in_atom2095);
					function_literal116=function_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_literal116.getTree());

					}
					break;
				case 3 :
					// grammars/Lua.g:346:4: table_constructor
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_constructor_in_atom2100);
					table_constructor117=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, table_constructor117.getTree());

					}
					break;
				case 4 :
					// grammars/Lua.g:347:4: DotDotDot
					{
					root_0 = (CommonTree)adaptor.nil();


					DotDotDot118=(Token)match(input,DotDotDot,FOLLOW_DotDotDot_in_atom2105); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DotDotDot118_tree = (CommonTree)adaptor.create(DotDotDot118);
					adaptor.addChild(root_0, DotDotDot118_tree);
					}

					}
					break;
				case 5 :
					// grammars/Lua.g:348:4: Number
					{
					root_0 = (CommonTree)adaptor.nil();


					Number119=(Token)match(input,Number,FOLLOW_Number_in_atom2111); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Number119_tree = (CommonTree)adaptor.create(Number119);
					adaptor.addChild(root_0, Number119_tree);
					}

					}
					break;
				case 6 :
					// grammars/Lua.g:349:4: String
					{
					root_0 = (CommonTree)adaptor.nil();


					String120=(Token)match(input,String,FOLLOW_String_in_atom2116); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					String120_tree = (CommonTree)adaptor.create(String120);
					adaptor.addChild(root_0, String120_tree);
					}

					}
					break;
				case 7 :
					// grammars/Lua.g:350:4: Nil
					{
					root_0 = (CommonTree)adaptor.nil();


					Nil121=(Token)match(input,Nil,FOLLOW_Nil_in_atom2121); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Nil121_tree = (CommonTree)adaptor.create(Nil121);
					adaptor.addChild(root_0, Nil121_tree);
					}

					}
					break;
				case 8 :
					// grammars/Lua.g:351:4: True
					{
					root_0 = (CommonTree)adaptor.nil();


					True122=(Token)match(input,True,FOLLOW_True_in_atom2126); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					True122_tree = (CommonTree)adaptor.create(True122);
					adaptor.addChild(root_0, True122_tree);
					}

					}
					break;
				case 9 :
					// grammars/Lua.g:352:4: False
					{
					root_0 = (CommonTree)adaptor.nil();


					False123=(Token)match(input,False,FOLLOW_False_in_atom2131); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					False123_tree = (CommonTree)adaptor.create(False123);
					adaptor.addChild(root_0, False123_tree);
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
	// grammars/Lua.g:355:1: var[boolean assign] : ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )? ;
	public final LuaParser.var_return var(boolean assign) throws RecognitionException {
		LuaParser.var_return retval = new LuaParser.var_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope t =null;
		ParserRuleReturnScope callee124 =null;

		RewriteRuleSubtreeStream stream_tail=new RewriteRuleSubtreeStream(adaptor,"rule tail");
		RewriteRuleSubtreeStream stream_callee=new RewriteRuleSubtreeStream(adaptor,"rule callee");

		try {
			// grammars/Lua.g:356:2: ( ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )? )
			// grammars/Lua.g:356:4: ( callee[assign] -> callee ) ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )?
			{
			// grammars/Lua.g:356:4: ( callee[assign] -> callee )
			// grammars/Lua.g:356:5: callee[assign]
			{
			pushFollow(FOLLOW_callee_in_var2144);
			callee124=callee(assign);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_callee.add(callee124.getTree());
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
			// 356:20: -> callee
			{
				adaptor.addChild(root_0, stream_callee.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// grammars/Lua.g:356:31: ( ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) ) )?
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
					// grammars/Lua.g:356:33: ( tail )=> ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) )
					{
					// grammars/Lua.g:356:42: ( ( ( tail )=>t= tail )+ -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ ) -> ^( VAR callee ( tail )+ ) )
					// grammars/Lua.g:356:43: ( ( tail )=>t= tail )+
					{
					// grammars/Lua.g:356:43: ( ( tail )=>t= tail )+
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
							// grammars/Lua.g:356:44: ( tail )=>t= tail
							{
							pushFollow(FOLLOW_tail_in_var2168);
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
					// elements: tail, callee, tail, callee
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 356:62: -> {assign}? ^( ASSIGNMENT_VAR callee ( tail )+ )
					if (assign) {
						// grammars/Lua.g:356:75: ^( ASSIGNMENT_VAR callee ( tail )+ )
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

					else // 357:62: -> ^( VAR callee ( tail )+ )
					{
						// grammars/Lua.g:357:75: ^( VAR callee ( tail )+ )
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
	// grammars/Lua.g:361:1: callee[boolean assign] : ( '(' expr ')' -> expr | Name );
	public final LuaParser.callee_return callee(boolean assign) throws RecognitionException {
		LuaParser.callee_return retval = new LuaParser.callee_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal125=null;
		Token char_literal127=null;
		Token Name128=null;
		ParserRuleReturnScope expr126 =null;

		CommonTree char_literal125_tree=null;
		CommonTree char_literal127_tree=null;
		CommonTree Name128_tree=null;
		RewriteRuleTokenStream stream_CPar=new RewriteRuleTokenStream(adaptor,"token CPar");
		RewriteRuleTokenStream stream_OPar=new RewriteRuleTokenStream(adaptor,"token OPar");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:362:2: ( '(' expr ')' -> expr | Name )
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
					// grammars/Lua.g:362:4: '(' expr ')'
					{
					char_literal125=(Token)match(input,OPar,FOLLOW_OPar_in_callee2311); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal125);

					pushFollow(FOLLOW_expr_in_callee2313);
					expr126=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr126.getTree());
					char_literal127=(Token)match(input,CPar,FOLLOW_CPar_in_callee2315); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal127);

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
					// 362:17: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:363:4: Name
					{
					root_0 = (CommonTree)adaptor.nil();


					Name128=(Token)match(input,Name,FOLLOW_Name_in_callee2324); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Name128_tree = (CommonTree)adaptor.create(Name128);
					adaptor.addChild(root_0, Name128_tree);
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
	// grammars/Lua.g:366:1: tail : ( '.' Name -> ^( INDEX String[$Name.text] ) | '[' expr ']' -> ^( INDEX expr ) | ':' Name '(' ( expr_list )? ')' -> ^( INDEX ) ^( COL_CALL ( expr_list )? ) | ':' Name table_constructor -> ^( INDEX ) ^( COL_CALL table_constructor ) | ':' Name String -> ^( INDEX ) ^( COL_CALL String ) | '(' ( expr_list )? ')' -> ^( CALL ( expr_list )? ) | table_constructor -> ^( CALL table_constructor ) | String -> ^( CALL String ) );
	public final LuaParser.tail_return tail() throws RecognitionException {
		LuaParser.tail_return retval = new LuaParser.tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal129=null;
		Token Name130=null;
		Token char_literal131=null;
		Token char_literal133=null;
		Token char_literal134=null;
		Token Name135=null;
		Token char_literal136=null;
		Token char_literal138=null;
		Token char_literal139=null;
		Token Name140=null;
		Token char_literal142=null;
		Token Name143=null;
		Token String144=null;
		Token char_literal145=null;
		Token char_literal147=null;
		Token String149=null;
		ParserRuleReturnScope expr132 =null;
		ParserRuleReturnScope expr_list137 =null;
		ParserRuleReturnScope table_constructor141 =null;
		ParserRuleReturnScope expr_list146 =null;
		ParserRuleReturnScope table_constructor148 =null;

		CommonTree char_literal129_tree=null;
		CommonTree Name130_tree=null;
		CommonTree char_literal131_tree=null;
		CommonTree char_literal133_tree=null;
		CommonTree char_literal134_tree=null;
		CommonTree Name135_tree=null;
		CommonTree char_literal136_tree=null;
		CommonTree char_literal138_tree=null;
		CommonTree char_literal139_tree=null;
		CommonTree Name140_tree=null;
		CommonTree char_literal142_tree=null;
		CommonTree Name143_tree=null;
		CommonTree String144_tree=null;
		CommonTree char_literal145_tree=null;
		CommonTree char_literal147_tree=null;
		CommonTree String149_tree=null;
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
			// grammars/Lua.g:367:2: ( '.' Name -> ^( INDEX String[$Name.text] ) | '[' expr ']' -> ^( INDEX expr ) | ':' Name '(' ( expr_list )? ')' -> ^( INDEX ) ^( COL_CALL ( expr_list )? ) | ':' Name table_constructor -> ^( INDEX ) ^( COL_CALL table_constructor ) | ':' Name String -> ^( INDEX ) ^( COL_CALL String ) | '(' ( expr_list )? ')' -> ^( CALL ( expr_list )? ) | table_constructor -> ^( CALL table_constructor ) | String -> ^( CALL String ) )
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
					// grammars/Lua.g:367:4: '.' Name
					{
					char_literal129=(Token)match(input,Dot,FOLLOW_Dot_in_tail2335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Dot.add(char_literal129);

					Name130=(Token)match(input,Name,FOLLOW_Name_in_tail2337); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name130);

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
					// 367:32: -> ^( INDEX String[$Name.text] )
					{
						// grammars/Lua.g:367:35: ^( INDEX String[$Name.text] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(String, (Name130!=null?Name130.getText():null)));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// grammars/Lua.g:368:4: '[' expr ']'
					{
					char_literal131=(Token)match(input,OBrack,FOLLOW_OBrack_in_tail2370); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OBrack.add(char_literal131);

					pushFollow(FOLLOW_expr_in_tail2372);
					expr132=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr132.getTree());
					char_literal133=(Token)match(input,CBrack,FOLLOW_CBrack_in_tail2374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CBrack.add(char_literal133);

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
					// 368:32: -> ^( INDEX expr )
					{
						// grammars/Lua.g:368:35: ^( INDEX expr )
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
					// grammars/Lua.g:369:4: ':' Name '(' ( expr_list )? ')'
					{
					char_literal134=(Token)match(input,Col,FOLLOW_Col_in_tail2402); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal134);

					Name135=(Token)match(input,Name,FOLLOW_Name_in_tail2404); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name135);

					char_literal136=(Token)match(input,OPar,FOLLOW_OPar_in_tail2406); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal136);

					// grammars/Lua.g:369:17: ( expr_list )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==DotDotDot||LA29_0==False||LA29_0==Function||LA29_0==Length||LA29_0==Minus||(LA29_0 >= Name && LA29_0 <= OBrace)||LA29_0==OPar||LA29_0==String||LA29_0==True) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// grammars/Lua.g:369:17: expr_list
							{
							pushFollow(FOLLOW_expr_list_in_tail2408);
							expr_list137=expr_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr_list.add(expr_list137.getTree());
							}
							break;

					}

					char_literal138=(Token)match(input,CPar,FOLLOW_CPar_in_tail2411); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal138);

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
					// 369:32: -> ^( INDEX ) ^( COL_CALL ( expr_list )? )
					{
						// grammars/Lua.g:369:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name135!=null?Name135.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:369:98: ^( COL_CALL ( expr_list )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COL_CALL, "COL_CALL"), root_1);
						// grammars/Lua.g:369:109: ( expr_list )?
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
					// grammars/Lua.g:370:4: ':' Name table_constructor
					{
					char_literal139=(Token)match(input,Col,FOLLOW_Col_in_tail2431); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal139);

					Name140=(Token)match(input,Name,FOLLOW_Name_in_tail2433); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name140);

					pushFollow(FOLLOW_table_constructor_in_tail2435);
					table_constructor141=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_constructor.add(table_constructor141.getTree());
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
					// 370:32: -> ^( INDEX ) ^( COL_CALL table_constructor )
					{
						// grammars/Lua.g:370:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name140!=null?Name140.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:370:98: ^( COL_CALL table_constructor )
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
					// grammars/Lua.g:371:4: ':' Name String
					{
					char_literal142=(Token)match(input,Col,FOLLOW_Col_in_tail2455); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Col.add(char_literal142);

					Name143=(Token)match(input,Name,FOLLOW_Name_in_tail2457); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name143);

					String144=(Token)match(input,String,FOLLOW_String_in_tail2459); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_String.add(String144);

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
					// 371:32: -> ^( INDEX ) ^( COL_CALL String )
					{
						// grammars/Lua.g:371:35: ^( INDEX )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name143!=null?Name143.getText():null))));
						adaptor.addChild(root_0, root_1);
						}

						// grammars/Lua.g:371:98: ^( COL_CALL String )
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
					// grammars/Lua.g:372:4: '(' ( expr_list )? ')'
					{
					char_literal145=(Token)match(input,OPar,FOLLOW_OPar_in_tail2490); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OPar.add(char_literal145);

					// grammars/Lua.g:372:8: ( expr_list )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==DotDotDot||LA30_0==False||LA30_0==Function||LA30_0==Length||LA30_0==Minus||(LA30_0 >= Name && LA30_0 <= OBrace)||LA30_0==OPar||LA30_0==String||LA30_0==True) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// grammars/Lua.g:372:8: expr_list
							{
							pushFollow(FOLLOW_expr_list_in_tail2492);
							expr_list146=expr_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr_list.add(expr_list146.getTree());
							}
							break;

					}

					char_literal147=(Token)match(input,CPar,FOLLOW_CPar_in_tail2495); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CPar.add(char_literal147);

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
					// 372:32: -> ^( CALL ( expr_list )? )
					{
						// grammars/Lua.g:372:35: ^( CALL ( expr_list )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);
						// grammars/Lua.g:372:42: ( expr_list )?
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
					// grammars/Lua.g:373:4: table_constructor
					{
					pushFollow(FOLLOW_table_constructor_in_tail2518);
					table_constructor148=table_constructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_constructor.add(table_constructor148.getTree());
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
					// 373:32: -> ^( CALL table_constructor )
					{
						// grammars/Lua.g:373:35: ^( CALL table_constructor )
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
					// grammars/Lua.g:374:4: String
					{
					String149=(Token)match(input,String,FOLLOW_String_in_tail2541); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_String.add(String149);

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
					// 374:32: -> ^( CALL String )
					{
						// grammars/Lua.g:374:35: ^( CALL String )
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
	// grammars/Lua.g:377:1: table_constructor : '{' ( field_list )? '}' -> ^( TABLE ( field_list )? ) ;
	public final LuaParser.table_constructor_return table_constructor() throws RecognitionException {
		LuaParser.table_constructor_return retval = new LuaParser.table_constructor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal150=null;
		Token char_literal152=null;
		ParserRuleReturnScope field_list151 =null;

		CommonTree char_literal150_tree=null;
		CommonTree char_literal152_tree=null;
		RewriteRuleTokenStream stream_OBrace=new RewriteRuleTokenStream(adaptor,"token OBrace");
		RewriteRuleTokenStream stream_CBrace=new RewriteRuleTokenStream(adaptor,"token CBrace");
		RewriteRuleSubtreeStream stream_field_list=new RewriteRuleSubtreeStream(adaptor,"rule field_list");

		try {
			// grammars/Lua.g:378:2: ( '{' ( field_list )? '}' -> ^( TABLE ( field_list )? ) )
			// grammars/Lua.g:378:4: '{' ( field_list )? '}'
			{
			char_literal150=(Token)match(input,OBrace,FOLLOW_OBrace_in_table_constructor2581); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OBrace.add(char_literal150);

			// grammars/Lua.g:378:8: ( field_list )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==DotDotDot||LA32_0==False||LA32_0==Function||LA32_0==Length||LA32_0==Minus||(LA32_0 >= Name && LA32_0 <= OPar)||LA32_0==String||LA32_0==True) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// grammars/Lua.g:378:8: field_list
					{
					pushFollow(FOLLOW_field_list_in_table_constructor2583);
					field_list151=field_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_list.add(field_list151.getTree());
					}
					break;

			}

			char_literal152=(Token)match(input,CBrace,FOLLOW_CBrace_in_table_constructor2586); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CBrace.add(char_literal152);

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
			// 378:24: -> ^( TABLE ( field_list )? )
			{
				// grammars/Lua.g:378:27: ^( TABLE ( field_list )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TABLE, "TABLE"), root_1);
				// grammars/Lua.g:378:35: ( field_list )?
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
	// grammars/Lua.g:381:1: field_list : field ( field_sep field )* ( field_sep )? -> ( field )+ ;
	public final LuaParser.field_list_return field_list() throws RecognitionException {
		LuaParser.field_list_return retval = new LuaParser.field_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope field153 =null;
		ParserRuleReturnScope field_sep154 =null;
		ParserRuleReturnScope field155 =null;
		ParserRuleReturnScope field_sep156 =null;

		RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
		RewriteRuleSubtreeStream stream_field_sep=new RewriteRuleSubtreeStream(adaptor,"rule field_sep");

		try {
			// grammars/Lua.g:382:2: ( field ( field_sep field )* ( field_sep )? -> ( field )+ )
			// grammars/Lua.g:382:4: field ( field_sep field )* ( field_sep )?
			{
			pushFollow(FOLLOW_field_in_field_list2606);
			field153=field();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_field.add(field153.getTree());
			// grammars/Lua.g:382:10: ( field_sep field )*
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
					// grammars/Lua.g:382:11: field_sep field
					{
					pushFollow(FOLLOW_field_sep_in_field_list2609);
					field_sep154=field_sep();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_sep.add(field_sep154.getTree());
					pushFollow(FOLLOW_field_in_field_list2611);
					field155=field();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field.add(field155.getTree());
					}
					break;

				default :
					break loop33;
				}
			}

			// grammars/Lua.g:382:29: ( field_sep )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==Comma||LA34_0==SCol) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// grammars/Lua.g:382:29: field_sep
					{
					pushFollow(FOLLOW_field_sep_in_field_list2615);
					field_sep156=field_sep();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_sep.add(field_sep156.getTree());
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
			// 382:40: -> ( field )+
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
	// grammars/Lua.g:385:1: field : ( '[' expr ']' '=' expr -> ^( FIELD expr expr ) | Name '=' expr -> ^( FIELD expr ) | expr -> ^( FIELD expr ) );
	public final LuaParser.field_return field() throws RecognitionException {
		LuaParser.field_return retval = new LuaParser.field_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal157=null;
		Token char_literal159=null;
		Token char_literal160=null;
		Token Name162=null;
		Token char_literal163=null;
		ParserRuleReturnScope expr158 =null;
		ParserRuleReturnScope expr161 =null;
		ParserRuleReturnScope expr164 =null;
		ParserRuleReturnScope expr165 =null;

		CommonTree char_literal157_tree=null;
		CommonTree char_literal159_tree=null;
		CommonTree char_literal160_tree=null;
		CommonTree Name162_tree=null;
		CommonTree char_literal163_tree=null;
		RewriteRuleTokenStream stream_CBrack=new RewriteRuleTokenStream(adaptor,"token CBrack");
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_OBrack=new RewriteRuleTokenStream(adaptor,"token OBrack");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:386:2: ( '[' expr ']' '=' expr -> ^( FIELD expr expr ) | Name '=' expr -> ^( FIELD expr ) | expr -> ^( FIELD expr ) )
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
					// grammars/Lua.g:386:4: '[' expr ']' '=' expr
					{
					char_literal157=(Token)match(input,OBrack,FOLLOW_OBrack_in_field2632); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OBrack.add(char_literal157);

					pushFollow(FOLLOW_expr_in_field2634);
					expr158=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr158.getTree());
					char_literal159=(Token)match(input,CBrack,FOLLOW_CBrack_in_field2636); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CBrack.add(char_literal159);

					char_literal160=(Token)match(input,Assign,FOLLOW_Assign_in_field2638); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal160);

					pushFollow(FOLLOW_expr_in_field2640);
					expr161=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr161.getTree());
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
					// 386:26: -> ^( FIELD expr expr )
					{
						// grammars/Lua.g:386:29: ^( FIELD expr expr )
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
					// grammars/Lua.g:387:4: Name '=' expr
					{
					Name162=(Token)match(input,Name,FOLLOW_Name_in_field2655); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name162);

					char_literal163=(Token)match(input,Assign,FOLLOW_Assign_in_field2657); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Assign.add(char_literal163);

					pushFollow(FOLLOW_expr_in_field2659);
					expr164=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr164.getTree());
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
					// 387:26: -> ^( FIELD expr )
					{
						// grammars/Lua.g:387:29: ^( FIELD expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELD, "FIELD"), root_1);
						adaptor.addChild(root_1, new CommonTree(new CommonToken(String, (Name162!=null?Name162.getText():null))));
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// grammars/Lua.g:388:4: expr
					{
					pushFollow(FOLLOW_expr_in_field2682);
					expr165=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr165.getTree());
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
					// 388:26: -> ^( FIELD expr )
					{
						// grammars/Lua.g:388:29: ^( FIELD expr )
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
	// grammars/Lua.g:391:1: field_sep : ( ',' | ';' );
	public final LuaParser.field_sep_return field_sep() throws RecognitionException {
		LuaParser.field_sep_return retval = new LuaParser.field_sep_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set166=null;

		CommonTree set166_tree=null;

		try {
			// grammars/Lua.g:392:2: ( ',' | ';' )
			// grammars/Lua.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set166=input.LT(1);
			if ( input.LA(1)==Comma||input.LA(1)==SCol ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set166));
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
	// grammars/Lua.g:396:1: label : '::' Name '::' -> ^( LABEL Name ) ;
	public final LuaParser.label_return label() throws RecognitionException {
		LuaParser.label_return retval = new LuaParser.label_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal167=null;
		Token Name168=null;
		Token string_literal169=null;

		CommonTree string_literal167_tree=null;
		CommonTree Name168_tree=null;
		CommonTree string_literal169_tree=null;
		RewriteRuleTokenStream stream_ColCol=new RewriteRuleTokenStream(adaptor,"token ColCol");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:397:2: ( '::' Name '::' -> ^( LABEL Name ) )
			// grammars/Lua.g:397:4: '::' Name '::'
			{
			string_literal167=(Token)match(input,ColCol,FOLLOW_ColCol_in_label2735); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ColCol.add(string_literal167);

			Name168=(Token)match(input,Name,FOLLOW_Name_in_label2737); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name168);

			string_literal169=(Token)match(input,ColCol,FOLLOW_ColCol_in_label2739); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ColCol.add(string_literal169);

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
			// 397:19: -> ^( LABEL Name )
			{
				// grammars/Lua.g:397:22: ^( LABEL Name )
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
	// grammars/Lua.g:400:1: var_list : var[true] ( ',' var[true] )* -> ( var )+ ;
	public final LuaParser.var_list_return var_list() throws RecognitionException {
		LuaParser.var_list_return retval = new LuaParser.var_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal171=null;
		ParserRuleReturnScope var170 =null;
		ParserRuleReturnScope var172 =null;

		CommonTree char_literal171_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleSubtreeStream stream_var=new RewriteRuleSubtreeStream(adaptor,"rule var");

		try {
			// grammars/Lua.g:401:2: ( var[true] ( ',' var[true] )* -> ( var )+ )
			// grammars/Lua.g:401:4: var[true] ( ',' var[true] )*
			{
			pushFollow(FOLLOW_var_in_var_list2758);
			var170=var(true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_var.add(var170.getTree());
			// grammars/Lua.g:401:14: ( ',' var[true] )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==Comma) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// grammars/Lua.g:401:15: ',' var[true]
					{
					char_literal171=(Token)match(input,Comma,FOLLOW_Comma_in_var_list2762); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal171);

					pushFollow(FOLLOW_var_in_var_list2764);
					var172=var(true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_var.add(var172.getTree());
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
			// 401:31: -> ( var )+
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
	// grammars/Lua.g:404:1: expr_list : expr ( ',' expr )* -> ( expr )+ ;
	public final LuaParser.expr_list_return expr_list() throws RecognitionException {
		LuaParser.expr_list_return retval = new LuaParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal174=null;
		ParserRuleReturnScope expr173 =null;
		ParserRuleReturnScope expr175 =null;

		CommonTree char_literal174_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// grammars/Lua.g:405:2: ( expr ( ',' expr )* -> ( expr )+ )
			// grammars/Lua.g:405:4: expr ( ',' expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list2783);
			expr173=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr173.getTree());
			// grammars/Lua.g:405:9: ( ',' expr )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==Comma) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// grammars/Lua.g:405:10: ',' expr
					{
					char_literal174=(Token)match(input,Comma,FOLLOW_Comma_in_expr_list2786); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal174);

					pushFollow(FOLLOW_expr_in_expr_list2788);
					expr175=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr175.getTree());
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
			// 405:21: -> ( expr )+
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
	// grammars/Lua.g:408:1: name_list : Name ( ',' Name )* -> {addSelf}? ( Name )+ -> ( Name )+ ;
	public final LuaParser.name_list_return name_list() throws RecognitionException {
		LuaParser.name_list_return retval = new LuaParser.name_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Name176=null;
		Token char_literal177=null;
		Token Name178=null;

		CommonTree Name176_tree=null;
		CommonTree char_literal177_tree=null;
		CommonTree Name178_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

		try {
			// grammars/Lua.g:409:2: ( Name ( ',' Name )* -> {addSelf}? ( Name )+ -> ( Name )+ )
			// grammars/Lua.g:409:4: Name ( ',' Name )*
			{
			Name176=(Token)match(input,Name,FOLLOW_Name_in_name_list2806); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Name.add(Name176);

			// grammars/Lua.g:409:9: ( ',' Name )*
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
					// grammars/Lua.g:409:10: ',' Name
					{
					char_literal177=(Token)match(input,Comma,FOLLOW_Comma_in_name_list2809); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal177);

					Name178=(Token)match(input,Name,FOLLOW_Name_in_name_list2811); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Name.add(Name178);

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
			// 409:21: -> {addSelf}? ( Name )+
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

			else // 410:21: -> ( Name )+
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
		// grammars/Lua.g:206:4: ( assignment )
		// grammars/Lua.g:206:5: assignment
		{
		pushFollow(FOLLOW_assignment_in_synpred1_Lua923);
		assignment();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Lua

	// $ANTLR start synpred2_Lua
	public final void synpred2_Lua_fragment() throws RecognitionException {
		// grammars/Lua.g:356:33: ( tail )
		// grammars/Lua.g:356:34: tail
		{
		pushFollow(FOLLOW_tail_in_synpred2_Lua2155);
		tail();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_Lua

	// $ANTLR start synpred3_Lua
	public final void synpred3_Lua_fragment() throws RecognitionException {
		// grammars/Lua.g:356:44: ( tail )
		// grammars/Lua.g:356:45: tail
		{
		pushFollow(FOLLOW_tail_in_synpred3_Lua2162);
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


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\7\uffff";
	static final String DFA4_eofS =
		"\1\uffff\1\5\4\uffff\1\5";
	static final String DFA4_minS =
		"\1\53\1\11\1\uffff\1\103\2\uffff\1\11";
	static final String DFA4_maxS =
		"\1\103\1\133\1\uffff\1\103\2\uffff\1\133";
	static final String DFA4_acceptS =
		"\2\uffff\1\2\1\uffff\1\1\1\3\1\uffff";
	static final String DFA4_specialS =
		"\7\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\2\27\uffff\1\1",
			"\1\4\1\uffff\1\5\10\uffff\1\5\1\3\3\uffff\1\5\4\uffff\3\5\11\uffff\2"+
			"\5\2\uffff\1\5\3\uffff\1\5\11\uffff\1\5\6\uffff\1\5\5\uffff\1\5\4\uffff"+
			"\4\5\6\uffff\1\5\2\uffff\1\5",
			"",
			"\1\6",
			"",
			"",
			"\1\4\1\uffff\1\5\10\uffff\1\5\1\3\3\uffff\1\5\4\uffff\3\5\11\uffff\2"+
			"\5\2\uffff\1\5\3\uffff\1\5\11\uffff\1\5\6\uffff\1\5\5\uffff\1\5\4\uffff"+
			"\4\5\6\uffff\1\5\2\uffff\1\5"
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "240:10: ( name_list '=' expr_list -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) ) | Function Name func_body -> ^( LOCAL_ASSIGNMENT ^( NAME_LIST Name ) ^( EXPR_LIST func_body ) ) | name_list -> ^( LOCAL_DEC ^( NAME_LIST name_list ) ) )";
		}
	}

	public static final BitSet FOLLOW_chunk_in_parse878 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_chunk895 = new BitSet(new long[]{0x10044C0002100802L,0x000000000803C208L});
	public static final BitSet FOLLOW_ret_stat_in_chunk898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_stat927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_stat932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_do_block_in_stat963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_repeat_stat_in_stat974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_local_in_stat979 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_stat_in_stat984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goto_stat_in_stat989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stat_in_stat994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_stat1004 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_label_in_stat1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Break_in_stat1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCol_in_stat1019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Do_in_do_block1034 = new BitSet(new long[]{0x10044C0102100800L,0x000000000803C208L});
	public static final BitSet FOLLOW_chunk_in_do_block1036 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_do_block1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_While_in_while_stat1057 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_while_stat1059 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_while_stat1061 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Repeat_in_repeat_stat1082 = new BitSet(new long[]{0x10044C0002100800L,0x000000000903C208L});
	public static final BitSet FOLLOW_chunk_in_repeat_stat1084 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_Until_in_repeat_stat1086 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_repeat_stat1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_list_in_assignment1110 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_assignment1112 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_assignment1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Local_in_local1147 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_name_list_in_local1151 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_local1153 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_local1155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Function_in_local1186 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_local1188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_func_body_in_local1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_list_in_local1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Require_in_require_stat1256 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_require_stat1258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Goto_in_goto_stat1281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_goto_stat1283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_if_stat1302 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_if_stat1304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_Then_in_if_stat1306 = new BitSet(new long[]{0x10044C01C2100800L,0x000000000803C208L});
	public static final BitSet FOLLOW_chunk_in_if_stat1308 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_elseif_stat_in_if_stat1310 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_else_stat_in_if_stat1313 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_if_stat1316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Elseif_in_elseif_stat1347 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_elseif_stat1349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_Then_in_elseif_stat1351 = new BitSet(new long[]{0x10044C0002100800L,0x000000000803C208L});
	public static final BitSet FOLLOW_chunk_in_elseif_stat1353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_else_stat1374 = new BitSet(new long[]{0x10044C0002100800L,0x000000000803C208L});
	public static final BitSet FOLLOW_chunk_in_else_stat1376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_For_in_for_stat1397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_for_stat1401 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_for_stat1403 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_for_stat1407 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Comma_in_for_stat1409 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_for_stat1413 = new BitSet(new long[]{0x0000000002200000L});
	public static final BitSet FOLLOW_Comma_in_for_stat1416 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_for_stat1420 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_for_stat1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_list_in_for_stat1455 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_In_in_for_stat1457 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_for_stat1459 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_for_stat1461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Function_in_function1519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_names_in_function1521 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
	public static final BitSet FOLLOW_Col_in_function1525 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_function1527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_func_body_in_function1531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_body_in_function1594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_names1673 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_Dot_in_names1678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_names1682 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_Function_in_function_literal1697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_func_body_in_function_literal1699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPar_in_func_body1714 = new BitSet(new long[]{0x0000000010040000L,0x0000000000000008L});
	public static final BitSet FOLLOW_param_list_in_func_body1716 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_func_body1718 = new BitSet(new long[]{0x10044C0102100800L,0x000000000803C208L});
	public static final BitSet FOLLOW_chunk_in_func_body1720 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_End_in_func_body1722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_list_in_param_list1743 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_param_list1746 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_DotDotDot_in_param_list1748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DotDotDot_in_param_list1766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Return_in_ret_stat1803 = new BitSet(new long[]{0x42000A0010000002L,0x00000000004A02F8L});
	public static final BitSet FOLLOW_expr_list_in_ret_stat1805 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_SCol_in_ret_stat1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expr_in_expr1829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expr_in_or_expr1840 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_Or_in_or_expr1843 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_and_expr_in_or_expr1846 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_rel_expr_in_and_expr1859 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_And_in_and_expr1862 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_rel_expr_in_and_expr1865 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_concat_expr_in_rel_expr1878 = new BitSet(new long[]{0x0180300200000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_rel_expr1881 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_concat_expr_in_rel_expr1906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_expr_in_concat_expr1919 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_DotDot_in_concat_expr1922 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_add_expr_in_concat_expr1925 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_mult_expr_in_add_expr1938 = new BitSet(new long[]{0x4000000000000042L});
	public static final BitSet FOLLOW_set_in_add_expr1941 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_mult_expr_in_add_expr1950 = new BitSet(new long[]{0x4000000000000042L});
	public static final BitSet FOLLOW_unary_expr_in_mult_expr1963 = new BitSet(new long[]{0x8000000001000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_set_in_mult_expr1966 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_unary_expr_in_mult_expr1979 = new BitSet(new long[]{0x8000000001000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_Minus_in_unary_expr1992 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_unary_expr_in_unary_expr1994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Length_in_unary_expr2007 = new BitSet(new long[]{0x00000A0010000000L,0x00000000004802D8L});
	public static final BitSet FOLLOW_pow_expr_in_unary_expr2009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unary_expr2023 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_unary_expr_in_unary_expr2025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_expr_in_unary_expr2040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_pow_expr2056 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
	public static final BitSet FOLLOW_Pow_in_pow_expr2066 = new BitSet(new long[]{0x00000A0010000000L,0x00000000004802D8L});
	public static final BitSet FOLLOW_atom_in_pow_expr2070 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
	public static final BitSet FOLLOW_var_in_atom2089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_literal_in_atom2095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_constructor_in_atom2100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DotDotDot_in_atom2105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Number_in_atom2111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_atom2116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Nil_in_atom2121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_True_in_atom2126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_False_in_atom2131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_callee_in_var2144 = new BitSet(new long[]{0x0000000004080002L,0x0000000000080380L});
	public static final BitSet FOLLOW_tail_in_var2168 = new BitSet(new long[]{0x0000000004080002L,0x0000000000080380L});
	public static final BitSet FOLLOW_OPar_in_callee2311 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_callee2313 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_callee2315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_callee2324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Dot_in_tail2335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_tail2337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrack_in_tail2370 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_tail2372 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CBrack_in_tail2374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_tail2404 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_OPar_in_tail2406 = new BitSet(new long[]{0x42000A0010040000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_tail2408 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_tail2411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_tail2433 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_table_constructor_in_tail2435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Col_in_tail2455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_tail2457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_String_in_tail2459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPar_in_tail2490 = new BitSet(new long[]{0x42000A0010040000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_list_in_tail2492 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CPar_in_tail2495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_constructor_in_tail2518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_tail2541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrace_in_table_constructor2581 = new BitSet(new long[]{0x42000A0010002000L,0x00000000004803F8L});
	public static final BitSet FOLLOW_field_list_in_table_constructor2583 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CBrace_in_table_constructor2586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_field_in_field_list2606 = new BitSet(new long[]{0x0000000000200002L,0x0000000000020000L});
	public static final BitSet FOLLOW_field_sep_in_field_list2609 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004803F8L});
	public static final BitSet FOLLOW_field_in_field_list2611 = new BitSet(new long[]{0x0000000000200002L,0x0000000000020000L});
	public static final BitSet FOLLOW_field_sep_in_field_list2615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBrack_in_field2632 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_field2634 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CBrack_in_field2636 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_field2638 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_field2640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Name_in_field2655 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assign_in_field2657 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_field2659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_field2682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ColCol_in_label2735 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_label2737 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ColCol_in_label2739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_var_list2758 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_var_list2762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000208L});
	public static final BitSet FOLLOW_var_in_var_list2764 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_expr_in_expr_list2783 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_expr_list2786 = new BitSet(new long[]{0x42000A0010000000L,0x00000000004802F8L});
	public static final BitSet FOLLOW_expr_in_expr_list2788 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Name_in_name_list2806 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_Comma_in_name_list2809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_name_list2811 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_assignment_in_synpred1_Lua923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tail_in_synpred2_Lua2155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tail_in_synpred3_Lua2162 = new BitSet(new long[]{0x0000000000000002L});
}
