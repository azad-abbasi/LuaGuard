// $ANTLR 3.5.2 grammars/LuaWalker.g 2014-05-07 14:47:53

package parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LuaWalker extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public LuaWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public LuaWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LuaWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "grammars/LuaWalker.g"; }



	// $ANTLR start "walk"
	// grammars/LuaWalker.g:41:1: walk : chunk ;
	public final void walk() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:42:2: ( chunk )
			// grammars/LuaWalker.g:42:4: chunk
			{
			pushFollow(FOLLOW_chunk_in_walk38);
			chunk();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "walk"



	// $ANTLR start "chunk"
	// grammars/LuaWalker.g:45:1: chunk : ^( CHUNK ( stat )* ( ret_stat )? ) ;
	public final void chunk() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:46:2: ( ^( CHUNK ( stat )* ( ret_stat )? ) )
			// grammars/LuaWalker.g:46:4: ^( CHUNK ( stat )* ( ret_stat )? )
			{
			match(input,CHUNK,FOLLOW_CHUNK_in_chunk50); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// grammars/LuaWalker.g:46:12: ( stat )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==Break||LA1_0==Do||LA1_0==FOR_IN||LA1_0==For||LA1_0==Goto||LA1_0==If||(LA1_0 >= LABEL && LA1_0 <= LOCAL_ASSIGNMENT)||LA1_0==Repeat||LA1_0==VAR||LA1_0==While) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// grammars/LuaWalker.g:46:12: stat
						{
						pushFollow(FOLLOW_stat_in_chunk52);
						stat();
						state._fsp--;

						}
						break;

					default :
						break loop1;
					}
				}

				// grammars/LuaWalker.g:46:18: ( ret_stat )?
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==Return) ) {
					alt2=1;
				}
				switch (alt2) {
					case 1 :
						// grammars/LuaWalker.g:46:18: ret_stat
						{
						pushFollow(FOLLOW_ret_stat_in_chunk55);
						ret_stat();
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "chunk"



	// $ANTLR start "stat"
	// grammars/LuaWalker.g:49:1: stat : ( assignment | var[true] | do_block | while_stat | repeat_stat | local | if_stat | for_stat | label | goto_stat | Break );
	public final void stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:50:2: ( assignment | var[true] | do_block | while_stat | repeat_stat | local | if_stat | for_stat | label | goto_stat | Break )
			int alt3=11;
			switch ( input.LA(1) ) {
			case ASSIGNMENT:
				{
				alt3=1;
				}
				break;
			case VAR:
				{
				alt3=2;
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
			case LOCAL_ASSIGNMENT:
				{
				alt3=6;
				}
				break;
			case If:
				{
				alt3=7;
				}
				break;
			case FOR_IN:
			case For:
				{
				alt3=8;
				}
				break;
			case LABEL:
				{
				alt3=9;
				}
				break;
			case Goto:
				{
				alt3=10;
				}
				break;
			case Break:
				{
				alt3=11;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// grammars/LuaWalker.g:50:4: assignment
					{
					pushFollow(FOLLOW_assignment_in_stat68);
					assignment();
					state._fsp--;

					}
					break;
				case 2 :
					// grammars/LuaWalker.g:51:4: var[true]
					{
					pushFollow(FOLLOW_var_in_stat73);
					var(true);
					state._fsp--;

					}
					break;
				case 3 :
					// grammars/LuaWalker.g:52:4: do_block
					{
					pushFollow(FOLLOW_do_block_in_stat79);
					do_block();
					state._fsp--;

					}
					break;
				case 4 :
					// grammars/LuaWalker.g:53:4: while_stat
					{
					pushFollow(FOLLOW_while_stat_in_stat84);
					while_stat();
					state._fsp--;

					}
					break;
				case 5 :
					// grammars/LuaWalker.g:54:4: repeat_stat
					{
					pushFollow(FOLLOW_repeat_stat_in_stat89);
					repeat_stat();
					state._fsp--;

					}
					break;
				case 6 :
					// grammars/LuaWalker.g:55:4: local
					{
					pushFollow(FOLLOW_local_in_stat94);
					local();
					state._fsp--;

					}
					break;
				case 7 :
					// grammars/LuaWalker.g:56:4: if_stat
					{
					pushFollow(FOLLOW_if_stat_in_stat99);
					if_stat();
					state._fsp--;

					}
					break;
				case 8 :
					// grammars/LuaWalker.g:57:4: for_stat
					{
					pushFollow(FOLLOW_for_stat_in_stat104);
					for_stat();
					state._fsp--;

					}
					break;
				case 9 :
					// grammars/LuaWalker.g:58:4: label
					{
					pushFollow(FOLLOW_label_in_stat109);
					label();
					state._fsp--;

					}
					break;
				case 10 :
					// grammars/LuaWalker.g:59:4: goto_stat
					{
					pushFollow(FOLLOW_goto_stat_in_stat114);
					goto_stat();
					state._fsp--;

					}
					break;
				case 11 :
					// grammars/LuaWalker.g:60:4: Break
					{
					match(input,Break,FOLLOW_Break_in_stat119); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "do_block"
	// grammars/LuaWalker.g:63:1: do_block : ^( Do chunk ) ;
	public final void do_block() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:64:2: ( ^( Do chunk ) )
			// grammars/LuaWalker.g:64:4: ^( Do chunk )
			{
			match(input,Do,FOLLOW_Do_in_do_block131); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_chunk_in_do_block133);
			chunk();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "do_block"



	// $ANTLR start "while_stat"
	// grammars/LuaWalker.g:67:1: while_stat : ^( While expr do_block ) ;
	public final void while_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:68:2: ( ^( While expr do_block ) )
			// grammars/LuaWalker.g:68:4: ^( While expr do_block )
			{
			match(input,While,FOLLOW_While_in_while_stat146); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_in_while_stat148);
			expr();
			state._fsp--;

			pushFollow(FOLLOW_do_block_in_while_stat150);
			do_block();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_stat"



	// $ANTLR start "repeat_stat"
	// grammars/LuaWalker.g:71:1: repeat_stat : ^( Repeat chunk expr ) ;
	public final void repeat_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:72:2: ( ^( Repeat chunk expr ) )
			// grammars/LuaWalker.g:72:4: ^( Repeat chunk expr )
			{
			match(input,Repeat,FOLLOW_Repeat_in_repeat_stat163); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_chunk_in_repeat_stat165);
			chunk();
			state._fsp--;

			pushFollow(FOLLOW_expr_in_repeat_stat167);
			expr();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "repeat_stat"



	// $ANTLR start "assignment"
	// grammars/LuaWalker.g:75:1: assignment : ^( ASSIGNMENT ^( VAR_LIST e1= expr_list ) ^( EXPR_LIST e2= expr_list ) ) ;
	public final void assignment() throws RecognitionException {
		TreeRuleReturnScope e1 =null;
		TreeRuleReturnScope e2 =null;

		try {
			// grammars/LuaWalker.g:76:2: ( ^( ASSIGNMENT ^( VAR_LIST e1= expr_list ) ^( EXPR_LIST e2= expr_list ) ) )
			// grammars/LuaWalker.g:76:4: ^( ASSIGNMENT ^( VAR_LIST e1= expr_list ) ^( EXPR_LIST e2= expr_list ) )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignment180); 
			match(input, Token.DOWN, null); 
			match(input,VAR_LIST,FOLLOW_VAR_LIST_in_assignment183); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_list_in_assignment187);
			e1=expr_list();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,EXPR_LIST,FOLLOW_EXPR_LIST_in_assignment191); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_list_in_assignment195);
			e2=expr_list();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 


			     System.out.println("> from Lua52Walker.assignment");
			     System.out.println(">   VAR_LIST=" + (e1!=null?((CommonTree)e1.start):null).getText());
			     System.out.println(">   EXPR_LIST=" + (e2!=null?((CommonTree)e2.start):null).getText());
			   
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment"



	// $ANTLR start "local"
	// grammars/LuaWalker.g:84:1: local : ^( LOCAL_ASSIGNMENT ^( NAME_LIST a= name_list ) ^( EXPR_LIST b= expr_list ) ) ;
	public final void local() throws RecognitionException {
		TreeRuleReturnScope b =null;

		try {
			// grammars/LuaWalker.g:85:2: ( ^( LOCAL_ASSIGNMENT ^( NAME_LIST a= name_list ) ^( EXPR_LIST b= expr_list ) ) )
			// grammars/LuaWalker.g:85:4: ^( LOCAL_ASSIGNMENT ^( NAME_LIST a= name_list ) ^( EXPR_LIST b= expr_list ) )
			{
			match(input,LOCAL_ASSIGNMENT,FOLLOW_LOCAL_ASSIGNMENT_in_local214); 
			match(input, Token.DOWN, null); 
			match(input,NAME_LIST,FOLLOW_NAME_LIST_in_local217); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_name_list_in_local221);
			name_list();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,EXPR_LIST,FOLLOW_EXPR_LIST_in_local225); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_list_in_local229);
			b=expr_list();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "local"



	// $ANTLR start "goto_stat"
	// grammars/LuaWalker.g:88:1: goto_stat : ^( Goto Name ) ;
	public final void goto_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:89:2: ( ^( Goto Name ) )
			// grammars/LuaWalker.g:89:4: ^( Goto Name )
			{
			match(input,Goto,FOLLOW_Goto_in_goto_stat243); 
			match(input, Token.DOWN, null); 
			match(input,Name,FOLLOW_Name_in_goto_stat245); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "goto_stat"



	// $ANTLR start "if_stat"
	// grammars/LuaWalker.g:92:1: if_stat : ^( If ( ^( CONDITION expr chunk ) )+ ) ;
	public final void if_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:93:2: ( ^( If ( ^( CONDITION expr chunk ) )+ ) )
			// grammars/LuaWalker.g:93:4: ^( If ( ^( CONDITION expr chunk ) )+ )
			{
			match(input,If,FOLLOW_If_in_if_stat258); 
			match(input, Token.DOWN, null); 
			// grammars/LuaWalker.g:93:9: ( ^( CONDITION expr chunk ) )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==CONDITION) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// grammars/LuaWalker.g:93:10: ^( CONDITION expr chunk )
					{
					match(input,CONDITION,FOLLOW_CONDITION_in_if_stat262); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_if_stat264);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_chunk_in_if_stat266);
					chunk();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_stat"



	// $ANTLR start "for_stat"
	// grammars/LuaWalker.g:96:1: for_stat : ( ^( For Name expr expr ( expr )? do_block ) | ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) );
	public final void for_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:97:2: ( ^( For Name expr expr ( expr )? do_block ) | ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==For) ) {
				alt6=1;
			}
			else if ( (LA6_0==FOR_IN) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// grammars/LuaWalker.g:97:4: ^( For Name expr expr ( expr )? do_block )
					{
					match(input,For,FOLLOW_For_in_for_stat282); 
					match(input, Token.DOWN, null); 
					match(input,Name,FOLLOW_Name_in_for_stat284); 
					pushFollow(FOLLOW_expr_in_for_stat286);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_for_stat288);
					expr();
					state._fsp--;

					// grammars/LuaWalker.g:97:25: ( expr )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( ((LA5_0 >= ASSIGNMENT_VAR && LA5_0 <= And)||LA5_0==Div||(LA5_0 >= DotDot && LA5_0 <= DotDotDot)||LA5_0==Eq||LA5_0==FUNCTION||LA5_0==False||(LA5_0 >= GT && LA5_0 <= GTEq)||(LA5_0 >= LT && LA5_0 <= Length)||(LA5_0 >= Minus && LA5_0 <= Mult)||(LA5_0 >= NEq && LA5_0 <= Number)||LA5_0==Or||LA5_0==Pow||(LA5_0 >= String && LA5_0 <= TABLE)||(LA5_0 >= True && LA5_0 <= UNARY_MINUS)||LA5_0==VAR) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// grammars/LuaWalker.g:97:25: expr
							{
							pushFollow(FOLLOW_expr_in_for_stat290);
							expr();
							state._fsp--;

							}
							break;

					}

					pushFollow(FOLLOW_do_block_in_for_stat293);
					do_block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// grammars/LuaWalker.g:98:4: ^( FOR_IN ^( NAME_LIST name_list ) ^( EXPR_LIST expr_list ) do_block )
					{
					match(input,FOR_IN,FOLLOW_FOR_IN_in_for_stat300); 
					match(input, Token.DOWN, null); 
					match(input,NAME_LIST,FOLLOW_NAME_LIST_in_for_stat303); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_name_list_in_for_stat305);
					name_list();
					state._fsp--;

					match(input, Token.UP, null); 

					match(input,EXPR_LIST,FOLLOW_EXPR_LIST_in_for_stat309); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_list_in_for_stat311);
					expr_list();
					state._fsp--;

					match(input, Token.UP, null); 

					pushFollow(FOLLOW_do_block_in_for_stat314);
					do_block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_stat"



	// $ANTLR start "function_literal"
	// grammars/LuaWalker.g:101:1: function_literal : ^( FUNCTION ^( PARAM_LIST ( name_list )? ( DotDotDot )? ) chunk ) ;
	public final void function_literal() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:102:2: ( ^( FUNCTION ^( PARAM_LIST ( name_list )? ( DotDotDot )? ) chunk ) )
			// grammars/LuaWalker.g:102:4: ^( FUNCTION ^( PARAM_LIST ( name_list )? ( DotDotDot )? ) chunk )
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_function_literal327); 
			match(input, Token.DOWN, null); 
			match(input,PARAM_LIST,FOLLOW_PARAM_LIST_in_function_literal330); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// grammars/LuaWalker.g:102:28: ( name_list )?
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==Name) ) {
					alt7=1;
				}
				switch (alt7) {
					case 1 :
						// grammars/LuaWalker.g:102:28: name_list
						{
						pushFollow(FOLLOW_name_list_in_function_literal332);
						name_list();
						state._fsp--;

						}
						break;

				}

				// grammars/LuaWalker.g:102:39: ( DotDotDot )?
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DotDotDot) ) {
					alt8=1;
				}
				switch (alt8) {
					case 1 :
						// grammars/LuaWalker.g:102:39: DotDotDot
						{
						match(input,DotDotDot,FOLLOW_DotDotDot_in_function_literal335); 
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			pushFollow(FOLLOW_chunk_in_function_literal339);
			chunk();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_literal"



	// $ANTLR start "ret_stat"
	// grammars/LuaWalker.g:105:1: ret_stat : ^( Return ( expr_list )? ) ;
	public final void ret_stat() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:106:2: ( ^( Return ( expr_list )? ) )
			// grammars/LuaWalker.g:106:4: ^( Return ( expr_list )? )
			{
			match(input,Return,FOLLOW_Return_in_ret_stat352); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// grammars/LuaWalker.g:106:13: ( expr_list )?
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= ASSIGNMENT_VAR && LA9_0 <= And)||LA9_0==Div||(LA9_0 >= DotDot && LA9_0 <= DotDotDot)||LA9_0==Eq||LA9_0==FUNCTION||LA9_0==False||(LA9_0 >= GT && LA9_0 <= GTEq)||(LA9_0 >= LT && LA9_0 <= Length)||(LA9_0 >= Minus && LA9_0 <= Mult)||(LA9_0 >= NEq && LA9_0 <= Number)||LA9_0==Or||LA9_0==Pow||(LA9_0 >= String && LA9_0 <= TABLE)||(LA9_0 >= True && LA9_0 <= UNARY_MINUS)||LA9_0==VAR) ) {
					alt9=1;
				}
				switch (alt9) {
					case 1 :
						// grammars/LuaWalker.g:106:13: expr_list
						{
						pushFollow(FOLLOW_expr_list_in_ret_stat354);
						expr_list();
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ret_stat"



	// $ANTLR start "expr"
	// grammars/LuaWalker.g:109:1: expr : ( ^( Or a= expr b= expr ) | ^( And a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( LTEq a= expr b= expr ) | ^( GTEq a= expr b= expr ) | ^( NEq a= expr b= expr ) | ^( Eq a= expr b= expr ) | ^( DotDot a= expr b= expr ) | ^( Add a= expr b= expr ) | ^( Minus a= expr b= expr ) | ^( Mult a= expr b= expr ) | ^( Div a= expr b= expr ) | ^( Mod a= expr b= expr ) | ^( Pow a= expr b= expr ) | ^( UNARY_MINUS a= expr ) | ^( Length a= expr ) | ^( Not a= expr ) | Name | DotDotDot | Number | String | Nil | True | False | var[false] | assignment_var | function_literal | table_constructor );
	public final void expr() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:110:2: ( ^( Or a= expr b= expr ) | ^( And a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( LTEq a= expr b= expr ) | ^( GTEq a= expr b= expr ) | ^( NEq a= expr b= expr ) | ^( Eq a= expr b= expr ) | ^( DotDot a= expr b= expr ) | ^( Add a= expr b= expr ) | ^( Minus a= expr b= expr ) | ^( Mult a= expr b= expr ) | ^( Div a= expr b= expr ) | ^( Mod a= expr b= expr ) | ^( Pow a= expr b= expr ) | ^( UNARY_MINUS a= expr ) | ^( Length a= expr ) | ^( Not a= expr ) | Name | DotDotDot | Number | String | Nil | True | False | var[false] | assignment_var | function_literal | table_constructor )
			int alt10=29;
			switch ( input.LA(1) ) {
			case Or:
				{
				alt10=1;
				}
				break;
			case And:
				{
				alt10=2;
				}
				break;
			case LT:
				{
				alt10=3;
				}
				break;
			case GT:
				{
				alt10=4;
				}
				break;
			case LTEq:
				{
				alt10=5;
				}
				break;
			case GTEq:
				{
				alt10=6;
				}
				break;
			case NEq:
				{
				alt10=7;
				}
				break;
			case Eq:
				{
				alt10=8;
				}
				break;
			case DotDot:
				{
				alt10=9;
				}
				break;
			case Add:
				{
				alt10=10;
				}
				break;
			case Minus:
				{
				alt10=11;
				}
				break;
			case Mult:
				{
				alt10=12;
				}
				break;
			case Div:
				{
				alt10=13;
				}
				break;
			case Mod:
				{
				alt10=14;
				}
				break;
			case Pow:
				{
				alt10=15;
				}
				break;
			case UNARY_MINUS:
				{
				alt10=16;
				}
				break;
			case Length:
				{
				alt10=17;
				}
				break;
			case Not:
				{
				alt10=18;
				}
				break;
			case Name:
				{
				alt10=19;
				}
				break;
			case DotDotDot:
				{
				alt10=20;
				}
				break;
			case Number:
				{
				alt10=21;
				}
				break;
			case String:
				{
				alt10=22;
				}
				break;
			case Nil:
				{
				alt10=23;
				}
				break;
			case True:
				{
				alt10=24;
				}
				break;
			case False:
				{
				alt10=25;
				}
				break;
			case VAR:
				{
				alt10=26;
				}
				break;
			case ASSIGNMENT_VAR:
				{
				alt10=27;
				}
				break;
			case FUNCTION:
				{
				alt10=28;
				}
				break;
			case TABLE:
				{
				alt10=29;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// grammars/LuaWalker.g:110:4: ^( Or a= expr b= expr )
					{
					match(input,Or,FOLLOW_Or_in_expr368); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr372);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr376);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// grammars/LuaWalker.g:111:4: ^( And a= expr b= expr )
					{
					match(input,And,FOLLOW_And_in_expr383); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr387);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr391);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// grammars/LuaWalker.g:112:4: ^( LT a= expr b= expr )
					{
					match(input,LT,FOLLOW_LT_in_expr398); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr402);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr406);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// grammars/LuaWalker.g:113:4: ^( GT a= expr b= expr )
					{
					match(input,GT,FOLLOW_GT_in_expr413); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr417);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr421);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// grammars/LuaWalker.g:114:4: ^( LTEq a= expr b= expr )
					{
					match(input,LTEq,FOLLOW_LTEq_in_expr428); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr432);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr436);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// grammars/LuaWalker.g:115:4: ^( GTEq a= expr b= expr )
					{
					match(input,GTEq,FOLLOW_GTEq_in_expr443); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr447);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr451);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// grammars/LuaWalker.g:116:4: ^( NEq a= expr b= expr )
					{
					match(input,NEq,FOLLOW_NEq_in_expr458); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr462);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr466);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// grammars/LuaWalker.g:117:4: ^( Eq a= expr b= expr )
					{
					match(input,Eq,FOLLOW_Eq_in_expr473); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr477);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr481);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// grammars/LuaWalker.g:118:4: ^( DotDot a= expr b= expr )
					{
					match(input,DotDot,FOLLOW_DotDot_in_expr488); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr492);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr496);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// grammars/LuaWalker.g:119:4: ^( Add a= expr b= expr )
					{
					match(input,Add,FOLLOW_Add_in_expr503); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr507);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr511);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// grammars/LuaWalker.g:120:4: ^( Minus a= expr b= expr )
					{
					match(input,Minus,FOLLOW_Minus_in_expr518); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr522);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr526);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// grammars/LuaWalker.g:121:4: ^( Mult a= expr b= expr )
					{
					match(input,Mult,FOLLOW_Mult_in_expr533); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr537);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr541);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// grammars/LuaWalker.g:122:4: ^( Div a= expr b= expr )
					{
					match(input,Div,FOLLOW_Div_in_expr548); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr552);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr556);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// grammars/LuaWalker.g:123:4: ^( Mod a= expr b= expr )
					{
					match(input,Mod,FOLLOW_Mod_in_expr563); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr567);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr571);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// grammars/LuaWalker.g:124:4: ^( Pow a= expr b= expr )
					{
					match(input,Pow,FOLLOW_Pow_in_expr578); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr582);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr586);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 16 :
					// grammars/LuaWalker.g:125:4: ^( UNARY_MINUS a= expr )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expr593); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr597);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 17 :
					// grammars/LuaWalker.g:126:4: ^( Length a= expr )
					{
					match(input,Length,FOLLOW_Length_in_expr604); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr608);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 18 :
					// grammars/LuaWalker.g:127:4: ^( Not a= expr )
					{
					match(input,Not,FOLLOW_Not_in_expr615); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr619);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 19 :
					// grammars/LuaWalker.g:128:4: Name
					{
					match(input,Name,FOLLOW_Name_in_expr625); 
					}
					break;
				case 20 :
					// grammars/LuaWalker.g:129:4: DotDotDot
					{
					match(input,DotDotDot,FOLLOW_DotDotDot_in_expr630); 
					}
					break;
				case 21 :
					// grammars/LuaWalker.g:130:4: Number
					{
					match(input,Number,FOLLOW_Number_in_expr635); 
					}
					break;
				case 22 :
					// grammars/LuaWalker.g:131:4: String
					{
					match(input,String,FOLLOW_String_in_expr640); 
					}
					break;
				case 23 :
					// grammars/LuaWalker.g:132:4: Nil
					{
					match(input,Nil,FOLLOW_Nil_in_expr645); 
					}
					break;
				case 24 :
					// grammars/LuaWalker.g:133:4: True
					{
					match(input,True,FOLLOW_True_in_expr650); 
					}
					break;
				case 25 :
					// grammars/LuaWalker.g:134:4: False
					{
					match(input,False,FOLLOW_False_in_expr655); 
					}
					break;
				case 26 :
					// grammars/LuaWalker.g:135:4: var[false]
					{
					pushFollow(FOLLOW_var_in_expr660);
					var(false);
					state._fsp--;

					}
					break;
				case 27 :
					// grammars/LuaWalker.g:136:4: assignment_var
					{
					pushFollow(FOLLOW_assignment_var_in_expr666);
					assignment_var();
					state._fsp--;

					}
					break;
				case 28 :
					// grammars/LuaWalker.g:137:4: function_literal
					{
					pushFollow(FOLLOW_function_literal_in_expr671);
					function_literal();
					state._fsp--;

					}
					break;
				case 29 :
					// grammars/LuaWalker.g:138:4: table_constructor
					{
					pushFollow(FOLLOW_table_constructor_in_expr676);
					table_constructor();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "var"
	// grammars/LuaWalker.g:141:1: var[boolean noReturn] : ^( VAR expr ( tail )+ ) ;
	public final void var(boolean noReturn) throws RecognitionException {
		try {
			// grammars/LuaWalker.g:142:2: ( ^( VAR expr ( tail )+ ) )
			// grammars/LuaWalker.g:142:4: ^( VAR expr ( tail )+ )
			{
			match(input,VAR,FOLLOW_VAR_in_var689); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_in_var691);
			expr();
			state._fsp--;

			// grammars/LuaWalker.g:142:15: ( tail )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==CALL||LA11_0==COL_CALL||LA11_0==INDEX) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// grammars/LuaWalker.g:142:15: tail
					{
					pushFollow(FOLLOW_tail_in_var693);
					tail();
					state._fsp--;

					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "var"



	// $ANTLR start "assignment_var"
	// grammars/LuaWalker.g:145:1: assignment_var : ^( ASSIGNMENT_VAR expr ( tail )+ ) ;
	public final void assignment_var() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:146:2: ( ^( ASSIGNMENT_VAR expr ( tail )+ ) )
			// grammars/LuaWalker.g:146:4: ^( ASSIGNMENT_VAR expr ( tail )+ )
			{
			match(input,ASSIGNMENT_VAR,FOLLOW_ASSIGNMENT_VAR_in_assignment_var707); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_in_assignment_var709);
			expr();
			state._fsp--;

			// grammars/LuaWalker.g:146:26: ( tail )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==CALL||LA12_0==COL_CALL||LA12_0==INDEX) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// grammars/LuaWalker.g:146:26: tail
					{
					pushFollow(FOLLOW_tail_in_assignment_var711);
					tail();
					state._fsp--;

					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment_var"



	// $ANTLR start "tail"
	// grammars/LuaWalker.g:149:1: tail : ( ^( INDEX expr ) | ^( CALL ( expr_list )? ) | ^( COL_CALL ( expr_list )? ) );
	public final void tail() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:150:2: ( ^( INDEX expr ) | ^( CALL ( expr_list )? ) | ^( COL_CALL ( expr_list )? ) )
			int alt15=3;
			switch ( input.LA(1) ) {
			case INDEX:
				{
				alt15=1;
				}
				break;
			case CALL:
				{
				alt15=2;
				}
				break;
			case COL_CALL:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// grammars/LuaWalker.g:150:4: ^( INDEX expr )
					{
					match(input,INDEX,FOLLOW_INDEX_in_tail725); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_tail727);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// grammars/LuaWalker.g:151:4: ^( CALL ( expr_list )? )
					{
					match(input,CALL,FOLLOW_CALL_in_tail734); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// grammars/LuaWalker.g:151:11: ( expr_list )?
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( ((LA13_0 >= ASSIGNMENT_VAR && LA13_0 <= And)||LA13_0==Div||(LA13_0 >= DotDot && LA13_0 <= DotDotDot)||LA13_0==Eq||LA13_0==FUNCTION||LA13_0==False||(LA13_0 >= GT && LA13_0 <= GTEq)||(LA13_0 >= LT && LA13_0 <= Length)||(LA13_0 >= Minus && LA13_0 <= Mult)||(LA13_0 >= NEq && LA13_0 <= Number)||LA13_0==Or||LA13_0==Pow||(LA13_0 >= String && LA13_0 <= TABLE)||(LA13_0 >= True && LA13_0 <= UNARY_MINUS)||LA13_0==VAR) ) {
							alt13=1;
						}
						switch (alt13) {
							case 1 :
								// grammars/LuaWalker.g:151:11: expr_list
								{
								pushFollow(FOLLOW_expr_list_in_tail736);
								expr_list();
								state._fsp--;

								}
								break;

						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 3 :
					// grammars/LuaWalker.g:152:4: ^( COL_CALL ( expr_list )? )
					{
					match(input,COL_CALL,FOLLOW_COL_CALL_in_tail744); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// grammars/LuaWalker.g:152:15: ( expr_list )?
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= ASSIGNMENT_VAR && LA14_0 <= And)||LA14_0==Div||(LA14_0 >= DotDot && LA14_0 <= DotDotDot)||LA14_0==Eq||LA14_0==FUNCTION||LA14_0==False||(LA14_0 >= GT && LA14_0 <= GTEq)||(LA14_0 >= LT && LA14_0 <= Length)||(LA14_0 >= Minus && LA14_0 <= Mult)||(LA14_0 >= NEq && LA14_0 <= Number)||LA14_0==Or||LA14_0==Pow||(LA14_0 >= String && LA14_0 <= TABLE)||(LA14_0 >= True && LA14_0 <= UNARY_MINUS)||LA14_0==VAR) ) {
							alt14=1;
						}
						switch (alt14) {
							case 1 :
								// grammars/LuaWalker.g:152:15: expr_list
								{
								pushFollow(FOLLOW_expr_list_in_tail746);
								expr_list();
								state._fsp--;

								}
								break;

						}

						match(input, Token.UP, null); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tail"



	// $ANTLR start "table_constructor"
	// grammars/LuaWalker.g:155:1: table_constructor : ^( TABLE ( field )* ) ;
	public final void table_constructor() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:156:2: ( ^( TABLE ( field )* ) )
			// grammars/LuaWalker.g:156:4: ^( TABLE ( field )* )
			{
			match(input,TABLE,FOLLOW_TABLE_in_table_constructor760); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// grammars/LuaWalker.g:156:12: ( field )*
				loop16:
				while (true) {
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==FIELD) ) {
						alt16=1;
					}

					switch (alt16) {
					case 1 :
						// grammars/LuaWalker.g:156:12: field
						{
						pushFollow(FOLLOW_field_in_table_constructor762);
						field();
						state._fsp--;

						}
						break;

					default :
						break loop16;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "table_constructor"



	// $ANTLR start "field"
	// grammars/LuaWalker.g:159:1: field : ^( FIELD a= expr (b= expr )? ) ;
	public final void field() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:160:2: ( ^( FIELD a= expr (b= expr )? ) )
			// grammars/LuaWalker.g:160:4: ^( FIELD a= expr (b= expr )? )
			{
			match(input,FIELD,FOLLOW_FIELD_in_field776); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_in_field780);
			expr();
			state._fsp--;

			// grammars/LuaWalker.g:160:20: (b= expr )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( ((LA17_0 >= ASSIGNMENT_VAR && LA17_0 <= And)||LA17_0==Div||(LA17_0 >= DotDot && LA17_0 <= DotDotDot)||LA17_0==Eq||LA17_0==FUNCTION||LA17_0==False||(LA17_0 >= GT && LA17_0 <= GTEq)||(LA17_0 >= LT && LA17_0 <= Length)||(LA17_0 >= Minus && LA17_0 <= Mult)||(LA17_0 >= NEq && LA17_0 <= Number)||LA17_0==Or||LA17_0==Pow||(LA17_0 >= String && LA17_0 <= TABLE)||(LA17_0 >= True && LA17_0 <= UNARY_MINUS)||LA17_0==VAR) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// grammars/LuaWalker.g:160:20: b= expr
					{
					pushFollow(FOLLOW_expr_in_field784);
					expr();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "field"



	// $ANTLR start "label"
	// grammars/LuaWalker.g:163:1: label : ^( LABEL Name ) ;
	public final void label() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:164:2: ( ^( LABEL Name ) )
			// grammars/LuaWalker.g:164:4: ^( LABEL Name )
			{
			match(input,LABEL,FOLLOW_LABEL_in_label798); 
			match(input, Token.DOWN, null); 
			match(input,Name,FOLLOW_Name_in_label800); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "label"


	public static class expr_list_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "expr_list"
	// grammars/LuaWalker.g:167:1: expr_list : ( expr )+ ;
	public final LuaWalker.expr_list_return expr_list() throws RecognitionException {
		LuaWalker.expr_list_return retval = new LuaWalker.expr_list_return();
		retval.start = input.LT(1);

		try {
			// grammars/LuaWalker.g:168:2: ( ( expr )+ )
			// grammars/LuaWalker.g:168:4: ( expr )+
			{
			// grammars/LuaWalker.g:168:4: ( expr )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( ((LA18_0 >= ASSIGNMENT_VAR && LA18_0 <= And)||LA18_0==Div||(LA18_0 >= DotDot && LA18_0 <= DotDotDot)||LA18_0==Eq||LA18_0==FUNCTION||LA18_0==False||(LA18_0 >= GT && LA18_0 <= GTEq)||(LA18_0 >= LT && LA18_0 <= Length)||(LA18_0 >= Minus && LA18_0 <= Mult)||(LA18_0 >= NEq && LA18_0 <= Number)||LA18_0==Or||LA18_0==Pow||(LA18_0 >= String && LA18_0 <= TABLE)||(LA18_0 >= True && LA18_0 <= UNARY_MINUS)||LA18_0==VAR) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// grammars/LuaWalker.g:168:4: expr
					{
					pushFollow(FOLLOW_expr_in_expr_list812);
					expr();
					state._fsp--;

					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_list"



	// $ANTLR start "name_list"
	// grammars/LuaWalker.g:171:1: name_list : ( Name )+ ;
	public final void name_list() throws RecognitionException {
		try {
			// grammars/LuaWalker.g:172:2: ( ( Name )+ )
			// grammars/LuaWalker.g:172:4: ( Name )+
			{
			// grammars/LuaWalker.g:172:4: ( Name )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==Name) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// grammars/LuaWalker.g:172:4: Name
					{
					match(input,Name,FOLLOW_Name_in_name_list824); 
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "name_list"

	// Delegated rules



	public static final BitSet FOLLOW_chunk_in_walk38 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHUNK_in_chunk50 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_in_chunk52 = new BitSet(new long[]{0x0034444002000818L,0x0000000001403000L});
	public static final BitSet FOLLOW_ret_stat_in_chunk55 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignment_in_stat68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_stat73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_do_block_in_stat79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_repeat_stat_in_stat89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_local_in_stat94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stat_in_stat99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_label_in_stat109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goto_stat_in_stat114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Break_in_stat119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Do_in_do_block131 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_chunk_in_do_block133 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_While_in_while_stat146 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_while_stat148 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_while_stat150 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Repeat_in_repeat_stat163 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_chunk_in_repeat_stat165 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_repeat_stat167 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_assignment180 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_VAR_LIST_in_assignment183 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_assignment187 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPR_LIST_in_assignment191 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_assignment195 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCAL_ASSIGNMENT_in_local214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NAME_LIST_in_local217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_name_list_in_local221 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPR_LIST_in_local225 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_local229 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Goto_in_goto_stat243 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_goto_stat245 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_If_in_if_stat258 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CONDITION_in_if_stat262 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_if_stat264 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_chunk_in_if_stat266 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_For_in_for_stat282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_for_stat284 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_for_stat286 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_for_stat288 = new BitSet(new long[]{0xE1C032821B0000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_for_stat290 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_do_block_in_for_stat293 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOR_IN_in_for_stat300 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NAME_LIST_in_for_stat303 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_name_list_in_for_stat305 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPR_LIST_in_for_stat309 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_for_stat311 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_do_block_in_for_stat314 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_in_function_literal327 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_PARAM_LIST_in_function_literal330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_name_list_in_function_literal332 = new BitSet(new long[]{0x0000000010000008L});
	public static final BitSet FOLLOW_DotDotDot_in_function_literal335 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_chunk_in_function_literal339 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Return_in_ret_stat352 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_ret_stat354 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Or_in_expr368 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr372 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expr383 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr387 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr391 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expr398 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr402 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr406 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expr413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr417 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr421 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEq_in_expr428 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr432 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr436 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEq_in_expr443 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr447 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr451 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEq_in_expr458 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr462 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Eq_in_expr473 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr477 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr481 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DotDot_in_expr488 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr492 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr496 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expr503 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr507 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr511 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Minus_in_expr518 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr522 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr526 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mult_in_expr533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr537 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr541 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expr548 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr552 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr556 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mod_in_expr563 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr567 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr571 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Pow_in_expr578 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr582 = new BitSet(new long[]{0xE1C03282190000E0L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_expr586 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expr593 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr597 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Length_in_expr604 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr608 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Not_in_expr615 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr619 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Name_in_expr625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DotDotDot_in_expr630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Number_in_expr635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_expr640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Nil_in_expr645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_True_in_expr650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_False_in_expr655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_expr660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_var_in_expr666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_literal_in_expr671 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_constructor_in_expr676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var689 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_var691 = new BitSet(new long[]{0x0002000000011000L});
	public static final BitSet FOLLOW_tail_in_var693 = new BitSet(new long[]{0x0002000000011008L});
	public static final BitSet FOLLOW_ASSIGNMENT_VAR_in_assignment_var707 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_assignment_var709 = new BitSet(new long[]{0x0002000000011000L});
	public static final BitSet FOLLOW_tail_in_assignment_var711 = new BitSet(new long[]{0x0002000000011008L});
	public static final BitSet FOLLOW_INDEX_in_tail725 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_tail727 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_tail734 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_tail736 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COL_CALL_in_tail744 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_list_in_tail746 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TABLE_in_table_constructor760 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_field_in_table_constructor762 = new BitSet(new long[]{0x0000001000000008L});
	public static final BitSet FOLLOW_FIELD_in_field776 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_field780 = new BitSet(new long[]{0xE1C03282190000E8L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_expr_in_field784 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LABEL_in_label798 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Name_in_label800 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr_in_expr_list812 = new BitSet(new long[]{0xE1C03282190000E2L,0x00000000005B0A3EL});
	public static final BitSet FOLLOW_Name_in_name_list824 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
}
