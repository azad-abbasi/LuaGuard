// $ANTLR 3.5.2 grammars/Lua.g 2014-05-07 15:02:25

package parser;
import java.math.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LuaLexer extends Lexer {
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


	  private boolean ahead(CharSequence chars) {
	    for(int i = 0; i < chars.length(); i++) {
	      if(input.LA(i + 1) != chars.charAt(i)) {        
	        return false;
	      }
	    }
	    return true;
	  }

	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e); 
	  }

	  private String unescape(String text) {
	    StringBuilder b = new StringBuilder();
	    String regex = "\\\\([\\\\abfnrtv\"']|\r?\n|\r|\\d{1,3}|x[0-9a-fA-F]{2}|z\\s*)|(?s).";
	    java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(text);
	    while(m.find()) {
	      if(m.group(1) != null) {
	        // an escaped char
	        String matched = m.group(1);
	        if(matched.equals("\\")) b.append("\\");
	        else if(matched.equals("a")) b.append("\u0007");
	        else if(matched.equals("b")) b.append("\u0008");
	        else if(matched.equals("f")) b.append("\u000C");
	        else if(matched.equals("n")) b.append("\n");
	        else if(matched.equals("r")) b.append("\r");
	        else if(matched.equals("t")) b.append("\t");
	        else if(matched.equals("v")) b.append("\u000B");
	        else if(matched.equals("\"")) b.append("\"");
	        else if(matched.equals("'")) b.append("'");
	        else if(matched.matches("\r?\n|\r")) b.append(matched);
	        else if(matched.matches("\\d{1,3}")) b.append((char)Integer.parseInt(matched));
	        else if(matched.matches("x[0-9a-fA-F]{2}")) b.append((char)Integer.parseInt(matched.substring(1), 16));
	        else if(matched.equals("z\\s*")) { /* do nothing, remove from string */ }
	      }
	      else {
	        // a normal char, append "as is"
	        b.append(m.group());
	      }
	    }
	    return b.toString();
	  }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public LuaLexer() {} 
	public LuaLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public LuaLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "grammars/Lua.g"; }

	// $ANTLR start "Add"
	public final void mAdd() throws RecognitionException {
		try {
			int _type = Add;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:54:5: ( '+' )
			// grammars/Lua.g:54:7: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Add"

	// $ANTLR start "And"
	public final void mAnd() throws RecognitionException {
		try {
			int _type = And;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:55:5: ( 'and' )
			// grammars/Lua.g:55:7: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "And"

	// $ANTLR start "Assign"
	public final void mAssign() throws RecognitionException {
		try {
			int _type = Assign;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:56:8: ( '=' )
			// grammars/Lua.g:56:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Assign"

	// $ANTLR start "Break"
	public final void mBreak() throws RecognitionException {
		try {
			int _type = Break;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:57:7: ( 'break' )
			// grammars/Lua.g:57:9: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Break"

	// $ANTLR start "CBrace"
	public final void mCBrace() throws RecognitionException {
		try {
			int _type = CBrace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:58:8: ( '}' )
			// grammars/Lua.g:58:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CBrace"

	// $ANTLR start "CBrack"
	public final void mCBrack() throws RecognitionException {
		try {
			int _type = CBrack;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:59:8: ( ']' )
			// grammars/Lua.g:59:10: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CBrack"

	// $ANTLR start "CPar"
	public final void mCPar() throws RecognitionException {
		try {
			int _type = CPar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:60:6: ( ')' )
			// grammars/Lua.g:60:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CPar"

	// $ANTLR start "Col"
	public final void mCol() throws RecognitionException {
		try {
			int _type = Col;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:61:5: ( ':' )
			// grammars/Lua.g:61:7: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Col"

	// $ANTLR start "ColCol"
	public final void mColCol() throws RecognitionException {
		try {
			int _type = ColCol;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:62:8: ( '::' )
			// grammars/Lua.g:62:10: '::'
			{
			match("::"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ColCol"

	// $ANTLR start "Comma"
	public final void mComma() throws RecognitionException {
		try {
			int _type = Comma;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:63:7: ( ',' )
			// grammars/Lua.g:63:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Comma"

	// $ANTLR start "Div"
	public final void mDiv() throws RecognitionException {
		try {
			int _type = Div;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:64:5: ( '/' )
			// grammars/Lua.g:64:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Div"

	// $ANTLR start "Do"
	public final void mDo() throws RecognitionException {
		try {
			int _type = Do;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:65:4: ( 'do' )
			// grammars/Lua.g:65:6: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Do"

	// $ANTLR start "Dot"
	public final void mDot() throws RecognitionException {
		try {
			int _type = Dot;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:66:5: ( '.' )
			// grammars/Lua.g:66:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Dot"

	// $ANTLR start "DotDot"
	public final void mDotDot() throws RecognitionException {
		try {
			int _type = DotDot;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:67:8: ( '..' )
			// grammars/Lua.g:67:10: '..'
			{
			match(".."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DotDot"

	// $ANTLR start "DotDotDot"
	public final void mDotDotDot() throws RecognitionException {
		try {
			int _type = DotDotDot;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:68:11: ( '...' )
			// grammars/Lua.g:68:13: '...'
			{
			match("..."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DotDotDot"

	// $ANTLR start "Else"
	public final void mElse() throws RecognitionException {
		try {
			int _type = Else;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:69:6: ( 'else' )
			// grammars/Lua.g:69:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Else"

	// $ANTLR start "Elseif"
	public final void mElseif() throws RecognitionException {
		try {
			int _type = Elseif;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:70:8: ( 'elseif' )
			// grammars/Lua.g:70:10: 'elseif'
			{
			match("elseif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Elseif"

	// $ANTLR start "End"
	public final void mEnd() throws RecognitionException {
		try {
			int _type = End;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:71:5: ( 'end' )
			// grammars/Lua.g:71:7: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "End"

	// $ANTLR start "Eq"
	public final void mEq() throws RecognitionException {
		try {
			int _type = Eq;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:72:4: ( '==' )
			// grammars/Lua.g:72:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Eq"

	// $ANTLR start "False"
	public final void mFalse() throws RecognitionException {
		try {
			int _type = False;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:73:7: ( 'false' )
			// grammars/Lua.g:73:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "False"

	// $ANTLR start "For"
	public final void mFor() throws RecognitionException {
		try {
			int _type = For;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:74:5: ( 'for' )
			// grammars/Lua.g:74:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "For"

	// $ANTLR start "Function"
	public final void mFunction() throws RecognitionException {
		try {
			int _type = Function;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:75:10: ( 'function' )
			// grammars/Lua.g:75:12: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Function"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:76:4: ( '>' )
			// grammars/Lua.g:76:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTEq"
	public final void mGTEq() throws RecognitionException {
		try {
			int _type = GTEq;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:77:6: ( '>=' )
			// grammars/Lua.g:77:8: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTEq"

	// $ANTLR start "Goto"
	public final void mGoto() throws RecognitionException {
		try {
			int _type = Goto;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:78:6: ( 'goto' )
			// grammars/Lua.g:78:8: 'goto'
			{
			match("goto"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Goto"

	// $ANTLR start "If"
	public final void mIf() throws RecognitionException {
		try {
			int _type = If;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:79:4: ( 'if' )
			// grammars/Lua.g:79:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "If"

	// $ANTLR start "In"
	public final void mIn() throws RecognitionException {
		try {
			int _type = In;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:80:4: ( 'in' )
			// grammars/Lua.g:80:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "In"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:81:4: ( '<' )
			// grammars/Lua.g:81:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTEq"
	public final void mLTEq() throws RecognitionException {
		try {
			int _type = LTEq;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:82:6: ( '<=' )
			// grammars/Lua.g:82:8: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTEq"

	// $ANTLR start "Length"
	public final void mLength() throws RecognitionException {
		try {
			int _type = Length;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:83:8: ( '#' )
			// grammars/Lua.g:83:10: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Length"

	// $ANTLR start "Local"
	public final void mLocal() throws RecognitionException {
		try {
			int _type = Local;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:84:7: ( 'local' )
			// grammars/Lua.g:84:9: 'local'
			{
			match("local"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Local"

	// $ANTLR start "Minus"
	public final void mMinus() throws RecognitionException {
		try {
			int _type = Minus;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:85:7: ( '-' )
			// grammars/Lua.g:85:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Minus"

	// $ANTLR start "Mod"
	public final void mMod() throws RecognitionException {
		try {
			int _type = Mod;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:86:5: ( '%' )
			// grammars/Lua.g:86:7: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Mod"

	// $ANTLR start "Mult"
	public final void mMult() throws RecognitionException {
		try {
			int _type = Mult;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:87:6: ( '*' )
			// grammars/Lua.g:87:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Mult"

	// $ANTLR start "NEq"
	public final void mNEq() throws RecognitionException {
		try {
			int _type = NEq;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:88:5: ( '~=' )
			// grammars/Lua.g:88:7: '~='
			{
			match("~="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEq"

	// $ANTLR start "Nil"
	public final void mNil() throws RecognitionException {
		try {
			int _type = Nil;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:89:5: ( 'nil' )
			// grammars/Lua.g:89:7: 'nil'
			{
			match("nil"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Nil"

	// $ANTLR start "Not"
	public final void mNot() throws RecognitionException {
		try {
			int _type = Not;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:90:5: ( 'not' )
			// grammars/Lua.g:90:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Not"

	// $ANTLR start "OBrace"
	public final void mOBrace() throws RecognitionException {
		try {
			int _type = OBrace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:91:8: ( '{' )
			// grammars/Lua.g:91:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OBrace"

	// $ANTLR start "OBrack"
	public final void mOBrack() throws RecognitionException {
		try {
			int _type = OBrack;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:92:8: ( '[' )
			// grammars/Lua.g:92:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OBrack"

	// $ANTLR start "OPar"
	public final void mOPar() throws RecognitionException {
		try {
			int _type = OPar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:93:6: ( '(' )
			// grammars/Lua.g:93:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPar"

	// $ANTLR start "Or"
	public final void mOr() throws RecognitionException {
		try {
			int _type = Or;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:94:4: ( 'or' )
			// grammars/Lua.g:94:6: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Or"

	// $ANTLR start "Pow"
	public final void mPow() throws RecognitionException {
		try {
			int _type = Pow;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:95:5: ( '^' )
			// grammars/Lua.g:95:7: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Pow"

	// $ANTLR start "Repeat"
	public final void mRepeat() throws RecognitionException {
		try {
			int _type = Repeat;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:96:8: ( 'repeat' )
			// grammars/Lua.g:96:10: 'repeat'
			{
			match("repeat"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Repeat"

	// $ANTLR start "Return"
	public final void mReturn() throws RecognitionException {
		try {
			int _type = Return;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:97:8: ( 'return' )
			// grammars/Lua.g:97:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Return"

	// $ANTLR start "SCol"
	public final void mSCol() throws RecognitionException {
		try {
			int _type = SCol;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:98:6: ( ';' )
			// grammars/Lua.g:98:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCol"

	// $ANTLR start "Then"
	public final void mThen() throws RecognitionException {
		try {
			int _type = Then;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:99:6: ( 'then' )
			// grammars/Lua.g:99:8: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Then"

	// $ANTLR start "True"
	public final void mTrue() throws RecognitionException {
		try {
			int _type = True;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:100:6: ( 'true' )
			// grammars/Lua.g:100:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "True"

	// $ANTLR start "Until"
	public final void mUntil() throws RecognitionException {
		try {
			int _type = Until;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:101:7: ( 'until' )
			// grammars/Lua.g:101:9: 'until'
			{
			match("until"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Until"

	// $ANTLR start "While"
	public final void mWhile() throws RecognitionException {
		try {
			int _type = While;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:102:7: ( 'while' )
			// grammars/Lua.g:102:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "While"

	// $ANTLR start "Name"
	public final void mName() throws RecognitionException {
		try {
			int _type = Name;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:406:2: ( ( Letter | '_' ) ( Letter | '_' | Digit )* )
			// grammars/Lua.g:406:4: ( Letter | '_' ) ( Letter | '_' | Digit )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// grammars/Lua.g:406:19: ( Letter | '_' | Digit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Name"

	// $ANTLR start "Number"
	public final void mNumber() throws RecognitionException {
		try {
			int _type = Number;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken a=null;
			CommonToken b=null;
			CommonToken c=null;

			// grammars/Lua.g:410:2: ( ( ( Digit )+ ( '.' ( Digit )* )? ( Exponent )? | '.' ( Digit )+ ( Exponent )? ) | '0' ( 'x' | 'X' ) a= HexDigits ( '.' (b= HexDigits )? )? (c= BinaryExponent )? )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='0') ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1=='X'||LA12_1=='x') ) {
					alt12=2;
				}

				else {
					alt12=1;
				}

			}
			else if ( (LA12_0=='.'||(LA12_0 >= '1' && LA12_0 <= '9')) ) {
				alt12=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// grammars/Lua.g:410:4: ( ( Digit )+ ( '.' ( Digit )* )? ( Exponent )? | '.' ( Digit )+ ( Exponent )? )
					{
					// grammars/Lua.g:410:4: ( ( Digit )+ ( '.' ( Digit )* )? ( Exponent )? | '.' ( Digit )+ ( Exponent )? )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
						alt8=1;
					}
					else if ( (LA8_0=='.') ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// grammars/Lua.g:410:5: ( Digit )+ ( '.' ( Digit )* )? ( Exponent )?
							{
							// grammars/Lua.g:410:5: ( Digit )+
							int cnt2=0;
							loop2:
							while (true) {
								int alt2=2;
								int LA2_0 = input.LA(1);
								if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
									alt2=1;
								}

								switch (alt2) {
								case 1 :
									// grammars/Lua.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									if ( cnt2 >= 1 ) break loop2;
									EarlyExitException eee = new EarlyExitException(2, input);
									throw eee;
								}
								cnt2++;
							}

							// grammars/Lua.g:410:12: ( '.' ( Digit )* )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0=='.') ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// grammars/Lua.g:410:13: '.' ( Digit )*
									{
									match('.'); 
									// grammars/Lua.g:410:17: ( Digit )*
									loop3:
									while (true) {
										int alt3=2;
										int LA3_0 = input.LA(1);
										if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
											alt3=1;
										}

										switch (alt3) {
										case 1 :
											// grammars/Lua.g:
											{
											if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
												input.consume();
											}
											else {
												MismatchedSetException mse = new MismatchedSetException(null,input);
												recover(mse);
												throw mse;
											}
											}
											break;

										default :
											break loop3;
										}
									}

									}
									break;

							}

							// grammars/Lua.g:410:26: ( Exponent )?
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0=='E'||LA5_0=='e') ) {
								alt5=1;
							}
							switch (alt5) {
								case 1 :
									// grammars/Lua.g:410:26: Exponent
									{
									mExponent(); 

									}
									break;

							}

							}
							break;
						case 2 :
							// grammars/Lua.g:410:38: '.' ( Digit )+ ( Exponent )?
							{
							match('.'); 
							// grammars/Lua.g:410:42: ( Digit )+
							int cnt6=0;
							loop6:
							while (true) {
								int alt6=2;
								int LA6_0 = input.LA(1);
								if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
									alt6=1;
								}

								switch (alt6) {
								case 1 :
									// grammars/Lua.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									if ( cnt6 >= 1 ) break loop6;
									EarlyExitException eee = new EarlyExitException(6, input);
									throw eee;
								}
								cnt6++;
							}

							// grammars/Lua.g:410:49: ( Exponent )?
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0=='E'||LA7_0=='e') ) {
								alt7=1;
							}
							switch (alt7) {
								case 1 :
									// grammars/Lua.g:410:49: Exponent
									{
									mExponent(); 

									}
									break;

							}

							}
							break;

					}

					setText(new java.math.BigDecimal(getText()).toPlainString().replaceAll("\\.0*$", ""));
					}
					break;
				case 2 :
					// grammars/Lua.g:411:4: '0' ( 'x' | 'X' ) a= HexDigits ( '.' (b= HexDigits )? )? (c= BinaryExponent )?
					{
					match('0'); 
					if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					int aStart492 = getCharIndex();
					int aStartLine492 = getLine();
					int aStartCharPos492 = getCharPositionInLine();
					mHexDigits(); 
					a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart492, getCharIndex()-1);
					a.setLine(aStartLine492);
					a.setCharPositionInLine(aStartCharPos492);

					// grammars/Lua.g:411:32: ( '.' (b= HexDigits )? )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='.') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// grammars/Lua.g:411:33: '.' (b= HexDigits )?
							{
							match('.'); 
							// grammars/Lua.g:411:38: (b= HexDigits )?
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'F')||(LA9_0 >= 'a' && LA9_0 <= 'f')) ) {
								alt9=1;
							}
							switch (alt9) {
								case 1 :
									// grammars/Lua.g:411:38: b= HexDigits
									{
									int bStart499 = getCharIndex();
									int bStartLine499 = getLine();
									int bStartCharPos499 = getCharPositionInLine();
									mHexDigits(); 
									b = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, bStart499, getCharIndex()-1);
									b.setLine(bStartLine499);
									b.setCharPositionInLine(bStartCharPos499);

									}
									break;

							}

							}
							break;

					}

					// grammars/Lua.g:411:53: (c= BinaryExponent )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0=='P'||LA11_0=='p') ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// grammars/Lua.g:411:53: c= BinaryExponent
							{
							int cStart506 = getCharIndex();
							int cStartLine506 = getLine();
							int cStartCharPos506 = getCharPositionInLine();
							mBinaryExponent(); 
							c = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, cStart506, getCharIndex()-1);
							c.setLine(cStartLine506);
							c.setCharPositionInLine(cStartCharPos506);

							}
							break;

					}


					     double num = Long.parseLong((a!=null?a.getText():null), 16);

					     if(b != null) {
					       double fraction = Long.parseLong((b!=null?b.getText():null), 16) / Math.pow(16, (b!=null?b.getText():null).length());
					       num += fraction;
					     }

					     if(c != null) {
					       int binExp = Integer.valueOf((c!=null?c.getText():null).contains("+") ? (c!=null?c.getText():null).substring(2) : (c!=null?c.getText():null).substring(1));
					       for(int i = 0; i < Math.abs(binExp); i++) {
					         num = binExp < 0 ? num/2 : num*2;
					       }
					     }

					     setText(new BigDecimal(Double.toString(num)).toPlainString().replaceAll("\\.0*$", ""));
					   
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Number"

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:432:2: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"' | '\\'' ( EscapeSequence |~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\'' | LongBracket )
			int alt15=3;
			switch ( input.LA(1) ) {
			case '\"':
				{
				alt15=1;
				}
				break;
			case '\'':
				{
				alt15=2;
				}
				break;
			case '[':
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
					// grammars/Lua.g:432:4: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"'
					{
					match('\"'); 
					// grammars/Lua.g:432:9: ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )*
					loop13:
					while (true) {
						int alt13=3;
						int LA13_0 = input.LA(1);
						if ( (LA13_0=='\\') ) {
							alt13=1;
						}
						else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
							alt13=2;
						}

						switch (alt13) {
						case 1 :
							// grammars/Lua.g:432:10: EscapeSequence
							{
							mEscapeSequence(); 

							}
							break;
						case 2 :
							// grammars/Lua.g:432:27: ~ ( '\\\\' | '\"' | '\\r' | '\\n' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop13;
						}
					}

					match('\"'); 
					setText(unescape(getText().substring(1, getText().length()-1)));
					}
					break;
				case 2 :
					// grammars/Lua.g:433:4: '\\'' ( EscapeSequence |~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\''
					{
					match('\''); 
					// grammars/Lua.g:433:9: ( EscapeSequence |~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )*
					loop14:
					while (true) {
						int alt14=3;
						int LA14_0 = input.LA(1);
						if ( (LA14_0=='\\') ) {
							alt14=1;
						}
						else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\t')||(LA14_0 >= '\u000B' && LA14_0 <= '\f')||(LA14_0 >= '\u000E' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
							alt14=2;
						}

						switch (alt14) {
						case 1 :
							// grammars/Lua.g:433:10: EscapeSequence
							{
							mEscapeSequence(); 

							}
							break;
						case 2 :
							// grammars/Lua.g:433:27: ~ ( '\\\\' | '\\'' | '\\r' | '\\n' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop14;
						}
					}

					match('\''); 
					setText(unescape(getText().substring(1, getText().length()-1)));
					}
					break;
				case 3 :
					// grammars/Lua.g:434:4: LongBracket
					{
					mLongBracket(); 

					setText(getText().replaceAll("^\\[=*\\[|]=*]$", ""));
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "String"

	// $ANTLR start "Comment"
	public final void mComment() throws RecognitionException {
		try {
			int _type = Comment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:439:2: ( '--' ( LongBracket | '[' ( '=' )* ~ ( '=' | '[' ) (~ ( '\\r' | '\\n' ) )* | (~ '[' (~ ( '\\r' | '\\n' ) )* )? ) )
			// grammars/Lua.g:439:4: '--' ( LongBracket | '[' ( '=' )* ~ ( '=' | '[' ) (~ ( '\\r' | '\\n' ) )* | (~ '[' (~ ( '\\r' | '\\n' ) )* )? )
			{
			match("--"); 

			// grammars/Lua.g:439:9: ( LongBracket | '[' ( '=' )* ~ ( '=' | '[' ) (~ ( '\\r' | '\\n' ) )* | (~ '[' (~ ( '\\r' | '\\n' ) )* )? )
			int alt20=3;
			alt20 = dfa20.predict(input);
			switch (alt20) {
				case 1 :
					// grammars/Lua.g:439:11: LongBracket
					{
					mLongBracket(); 

					}
					break;
				case 2 :
					// grammars/Lua.g:440:11: '[' ( '=' )* ~ ( '=' | '[' ) (~ ( '\\r' | '\\n' ) )*
					{
					match('['); 
					// grammars/Lua.g:440:15: ( '=' )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0=='=') ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// grammars/Lua.g:440:15: '='
							{
							match('='); 
							}
							break;

						default :
							break loop16;
						}
					}

					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '<')||(input.LA(1) >= '>' && input.LA(1) <= 'Z')||(input.LA(1) >= '\\' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// grammars/Lua.g:440:33: (~ ( '\\r' | '\\n' ) )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= '\uFFFF')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// grammars/Lua.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop17;
						}
					}

					}
					break;
				case 3 :
					// grammars/Lua.g:441:11: (~ '[' (~ ( '\\r' | '\\n' ) )* )?
					{
					// grammars/Lua.g:441:11: (~ '[' (~ ( '\\r' | '\\n' ) )* )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( ((LA19_0 >= '\u0000' && LA19_0 <= 'Z')||(LA19_0 >= '\\' && LA19_0 <= '\uFFFF')) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// grammars/Lua.g:441:12: ~ '[' (~ ( '\\r' | '\\n' ) )*
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= 'Z')||(input.LA(1) >= '\\' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							// grammars/Lua.g:441:17: (~ ( '\\r' | '\\n' ) )*
							loop18:
							while (true) {
								int alt18=2;
								int LA18_0 = input.LA(1);
								if ( ((LA18_0 >= '\u0000' && LA18_0 <= '\t')||(LA18_0 >= '\u000B' && LA18_0 <= '\f')||(LA18_0 >= '\u000E' && LA18_0 <= '\uFFFF')) ) {
									alt18=1;
								}

								switch (alt18) {
								case 1 :
									// grammars/Lua.g:
									{
									if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop18;
								}
							}

							}
							break;

					}

					}
					break;

			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Comment"

	// $ANTLR start "Space"
	public final void mSpace() throws RecognitionException {
		try {
			int _type = Space;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:447:2: ( ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+ )
			// grammars/Lua.g:447:4: ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+
			{
			// grammars/Lua.g:447:4: ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( ((LA21_0 >= '\t' && LA21_0 <= '\n')||(LA21_0 >= '\f' && LA21_0 <= '\r')||LA21_0==' ') ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Space"

	// $ANTLR start "Letter"
	public final void mLetter() throws RecognitionException {
		try {
			// grammars/Lua.g:452:2: ( 'a' .. 'z' | 'A' .. 'Z' )
			// grammars/Lua.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Letter"

	// $ANTLR start "Digit"
	public final void mDigit() throws RecognitionException {
		try {
			// grammars/Lua.g:457:2: ( '0' .. '9' )
			// grammars/Lua.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Digit"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// grammars/Lua.g:461:2: ( Digit | 'a' .. 'f' | 'A' .. 'F' )
			// grammars/Lua.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexDigit"

	// $ANTLR start "HexDigits"
	public final void mHexDigits() throws RecognitionException {
		try {
			// grammars/Lua.g:467:2: ( ( HexDigit )+ )
			// grammars/Lua.g:467:4: ( HexDigit )+
			{
			// grammars/Lua.g:467:4: ( HexDigit )+
			int cnt22=0;
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( ((LA22_0 >= '0' && LA22_0 <= '9')||(LA22_0 >= 'A' && LA22_0 <= 'F')||(LA22_0 >= 'a' && LA22_0 <= 'f')) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt22 >= 1 ) break loop22;
					EarlyExitException eee = new EarlyExitException(22, input);
					throw eee;
				}
				cnt22++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexDigits"

	// $ANTLR start "Exponent"
	public final void mExponent() throws RecognitionException {
		try {
			// grammars/Lua.g:471:2: ( ( 'e' | 'E' ) ( '-' | '+' )? ( Digit )+ )
			// grammars/Lua.g:471:4: ( 'e' | 'E' ) ( '-' | '+' )? ( Digit )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// grammars/Lua.g:471:16: ( '-' | '+' )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0=='+'||LA23_0=='-') ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// grammars/Lua.g:471:29: ( Digit )+
			int cnt24=0;
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( ((LA24_0 >= '0' && LA24_0 <= '9')) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt24 >= 1 ) break loop24;
					EarlyExitException eee = new EarlyExitException(24, input);
					throw eee;
				}
				cnt24++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exponent"

	// $ANTLR start "BinaryExponent"
	public final void mBinaryExponent() throws RecognitionException {
		try {
			// grammars/Lua.g:475:2: ( ( 'p' | 'P' ) ( '-' | '+' )? ( Digit )+ )
			// grammars/Lua.g:475:4: ( 'p' | 'P' ) ( '-' | '+' )? ( Digit )+
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// grammars/Lua.g:475:16: ( '-' | '+' )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0=='+'||LA25_0=='-') ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// grammars/Lua.g:475:29: ( Digit )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// grammars/Lua.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BinaryExponent"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// grammars/Lua.g:479:2: ( '\\\\' ( ( 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | '\\\\' | '\"' | '\\'' | 'z' | LineBreak ) | Digit ( Digit ( Digit )? )? | 'x' HexDigit HexDigit ) )
			// grammars/Lua.g:479:4: '\\\\' ( ( 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | '\\\\' | '\"' | '\\'' | 'z' | LineBreak ) | Digit ( Digit ( Digit )? )? | 'x' HexDigit HexDigit )
			{
			match('\\'); 
			// grammars/Lua.g:479:9: ( ( 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | '\\\\' | '\"' | '\\'' | 'z' | LineBreak ) | Digit ( Digit ( Digit )? )? | 'x' HexDigit HexDigit )
			int alt30=3;
			switch ( input.LA(1) ) {
			case '\n':
			case '\r':
			case '\"':
			case '\'':
			case '\\':
			case 'a':
			case 'b':
			case 'f':
			case 'n':
			case 'r':
			case 't':
			case 'v':
			case 'z':
				{
				alt30=1;
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				{
				alt30=2;
				}
				break;
			case 'x':
				{
				alt30=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// grammars/Lua.g:479:11: ( 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | '\\\\' | '\"' | '\\'' | 'z' | LineBreak )
					{
					// grammars/Lua.g:479:11: ( 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | '\\\\' | '\"' | '\\'' | 'z' | LineBreak )
					int alt27=12;
					switch ( input.LA(1) ) {
					case 'a':
						{
						alt27=1;
						}
						break;
					case 'b':
						{
						alt27=2;
						}
						break;
					case 'f':
						{
						alt27=3;
						}
						break;
					case 'n':
						{
						alt27=4;
						}
						break;
					case 'r':
						{
						alt27=5;
						}
						break;
					case 't':
						{
						alt27=6;
						}
						break;
					case 'v':
						{
						alt27=7;
						}
						break;
					case '\\':
						{
						alt27=8;
						}
						break;
					case '\"':
						{
						alt27=9;
						}
						break;
					case '\'':
						{
						alt27=10;
						}
						break;
					case 'z':
						{
						alt27=11;
						}
						break;
					case '\n':
					case '\r':
						{
						alt27=12;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 27, 0, input);
						throw nvae;
					}
					switch (alt27) {
						case 1 :
							// grammars/Lua.g:479:12: 'a'
							{
							match('a'); 
							}
							break;
						case 2 :
							// grammars/Lua.g:479:18: 'b'
							{
							match('b'); 
							}
							break;
						case 3 :
							// grammars/Lua.g:479:24: 'f'
							{
							match('f'); 
							}
							break;
						case 4 :
							// grammars/Lua.g:479:30: 'n'
							{
							match('n'); 
							}
							break;
						case 5 :
							// grammars/Lua.g:479:36: 'r'
							{
							match('r'); 
							}
							break;
						case 6 :
							// grammars/Lua.g:479:42: 't'
							{
							match('t'); 
							}
							break;
						case 7 :
							// grammars/Lua.g:479:48: 'v'
							{
							match('v'); 
							}
							break;
						case 8 :
							// grammars/Lua.g:479:54: '\\\\'
							{
							match('\\'); 
							}
							break;
						case 9 :
							// grammars/Lua.g:479:61: '\"'
							{
							match('\"'); 
							}
							break;
						case 10 :
							// grammars/Lua.g:479:67: '\\''
							{
							match('\''); 
							}
							break;
						case 11 :
							// grammars/Lua.g:479:74: 'z'
							{
							match('z'); 
							}
							break;
						case 12 :
							// grammars/Lua.g:479:80: LineBreak
							{
							mLineBreak(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// grammars/Lua.g:480:11: Digit ( Digit ( Digit )? )?
					{
					mDigit(); 

					// grammars/Lua.g:480:17: ( Digit ( Digit )? )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( ((LA29_0 >= '0' && LA29_0 <= '9')) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// grammars/Lua.g:480:18: Digit ( Digit )?
							{
							mDigit(); 

							// grammars/Lua.g:480:24: ( Digit )?
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( ((LA28_0 >= '0' && LA28_0 <= '9')) ) {
								alt28=1;
							}
							switch (alt28) {
								case 1 :
									// grammars/Lua.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 3 :
					// grammars/Lua.g:481:11: 'x' HexDigit HexDigit
					{
					match('x'); 
					mHexDigit(); 

					mHexDigit(); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EscapeSequence"

	// $ANTLR start "LineBreak"
	public final void mLineBreak() throws RecognitionException {
		try {
			// grammars/Lua.g:486:2: ( ( '\\r' )? '\\n' | '\\r' )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='\r') ) {
				int LA32_1 = input.LA(2);
				if ( (LA32_1=='\n') ) {
					alt32=1;
				}

				else {
					alt32=2;
				}

			}
			else if ( (LA32_0=='\n') ) {
				alt32=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// grammars/Lua.g:486:4: ( '\\r' )? '\\n'
					{
					// grammars/Lua.g:486:4: ( '\\r' )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0=='\r') ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// grammars/Lua.g:486:4: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;
				case 2 :
					// grammars/Lua.g:487:4: '\\r'
					{
					match('\r'); 
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LineBreak"

	// $ANTLR start "LongBracket"
	public final void mLongBracket() throws RecognitionException {
		try {
			StringBuilder b = new StringBuilder("]");
			// grammars/Lua.g:492:2: ( '[' ( '=' )* '[' ({...}? => (~ '\\\\' | EscapeSequence ) )* )
			// grammars/Lua.g:494:4: '[' ( '=' )* '[' ({...}? => (~ '\\\\' | EscapeSequence ) )*
			{
			match('['); 
			// grammars/Lua.g:494:8: ( '=' )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0=='=') ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// grammars/Lua.g:494:9: '='
					{
					match('='); 
					b.append("=");
					}
					break;

				default :
					break loop33;
				}
			}

			match('['); 
			b.append("]");
			// grammars/Lua.g:497:4: ({...}? => (~ '\\\\' | EscapeSequence ) )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( ((LA35_0 >= '\u0000' && LA35_0 <= '\uFFFF')) && ((!ahead(b)))) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// grammars/Lua.g:497:5: {...}? => (~ '\\\\' | EscapeSequence )
					{
					if ( !((!ahead(b))) ) {
						throw new FailedPredicateException(input, "LongBracket", "!ahead(b)");
					}
					// grammars/Lua.g:497:20: (~ '\\\\' | EscapeSequence )
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( ((LA34_0 >= '\u0000' && LA34_0 <= '[')||(LA34_0 >= ']' && LA34_0 <= '\uFFFF')) ) {
						alt34=1;
					}
					else if ( (LA34_0=='\\') ) {
						alt34=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 34, 0, input);
						throw nvae;
					}

					switch (alt34) {
						case 1 :
							// grammars/Lua.g:497:21: ~ '\\\\'
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;
						case 2 :
							// grammars/Lua.g:497:29: EscapeSequence
							{
							mEscapeSequence(); 

							}
							break;

					}

					}
					break;

				default :
					break loop35;
				}
			}


			     if(input.LA(1) == EOF) {
			       throw new RuntimeException("unfinished long comment or string near '<eof>'");
			     }

			     // let the lexer match the closing bracket
			     match(b.toString());
			   
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LongBracket"

	// $ANTLR start "Any"
	public final void mAny() throws RecognitionException {
		try {
			int _type = Any;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// grammars/Lua.g:513:2: ( . )
			// grammars/Lua.g:513:4: .
			{
			matchAny(); 
			}

			state.type = _type;
			state.channel = _channel;
			throw new RuntimeException("unexpected symbol near: '" + getText() + "'");
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Any"

	@Override
	public void mTokens() throws RecognitionException {
		// grammars/Lua.g:1:8: ( Add | And | Assign | Break | CBrace | CBrack | CPar | Col | ColCol | Comma | Div | Do | Dot | DotDot | DotDotDot | Else | Elseif | End | Eq | False | For | Function | GT | GTEq | Goto | If | In | LT | LTEq | Length | Local | Minus | Mod | Mult | NEq | Nil | Not | OBrace | OBrack | OPar | Or | Pow | Repeat | Return | SCol | Then | True | Until | While | Name | Number | String | Comment | Space | Any )
		int alt36=55;
		alt36 = dfa36.predict(input);
		switch (alt36) {
			case 1 :
				// grammars/Lua.g:1:10: Add
				{
				mAdd(); 

				}
				break;
			case 2 :
				// grammars/Lua.g:1:14: And
				{
				mAnd(); 

				}
				break;
			case 3 :
				// grammars/Lua.g:1:18: Assign
				{
				mAssign(); 

				}
				break;
			case 4 :
				// grammars/Lua.g:1:25: Break
				{
				mBreak(); 

				}
				break;
			case 5 :
				// grammars/Lua.g:1:31: CBrace
				{
				mCBrace(); 

				}
				break;
			case 6 :
				// grammars/Lua.g:1:38: CBrack
				{
				mCBrack(); 

				}
				break;
			case 7 :
				// grammars/Lua.g:1:45: CPar
				{
				mCPar(); 

				}
				break;
			case 8 :
				// grammars/Lua.g:1:50: Col
				{
				mCol(); 

				}
				break;
			case 9 :
				// grammars/Lua.g:1:54: ColCol
				{
				mColCol(); 

				}
				break;
			case 10 :
				// grammars/Lua.g:1:61: Comma
				{
				mComma(); 

				}
				break;
			case 11 :
				// grammars/Lua.g:1:67: Div
				{
				mDiv(); 

				}
				break;
			case 12 :
				// grammars/Lua.g:1:71: Do
				{
				mDo(); 

				}
				break;
			case 13 :
				// grammars/Lua.g:1:74: Dot
				{
				mDot(); 

				}
				break;
			case 14 :
				// grammars/Lua.g:1:78: DotDot
				{
				mDotDot(); 

				}
				break;
			case 15 :
				// grammars/Lua.g:1:85: DotDotDot
				{
				mDotDotDot(); 

				}
				break;
			case 16 :
				// grammars/Lua.g:1:95: Else
				{
				mElse(); 

				}
				break;
			case 17 :
				// grammars/Lua.g:1:100: Elseif
				{
				mElseif(); 

				}
				break;
			case 18 :
				// grammars/Lua.g:1:107: End
				{
				mEnd(); 

				}
				break;
			case 19 :
				// grammars/Lua.g:1:111: Eq
				{
				mEq(); 

				}
				break;
			case 20 :
				// grammars/Lua.g:1:114: False
				{
				mFalse(); 

				}
				break;
			case 21 :
				// grammars/Lua.g:1:120: For
				{
				mFor(); 

				}
				break;
			case 22 :
				// grammars/Lua.g:1:124: Function
				{
				mFunction(); 

				}
				break;
			case 23 :
				// grammars/Lua.g:1:133: GT
				{
				mGT(); 

				}
				break;
			case 24 :
				// grammars/Lua.g:1:136: GTEq
				{
				mGTEq(); 

				}
				break;
			case 25 :
				// grammars/Lua.g:1:141: Goto
				{
				mGoto(); 

				}
				break;
			case 26 :
				// grammars/Lua.g:1:146: If
				{
				mIf(); 

				}
				break;
			case 27 :
				// grammars/Lua.g:1:149: In
				{
				mIn(); 

				}
				break;
			case 28 :
				// grammars/Lua.g:1:152: LT
				{
				mLT(); 

				}
				break;
			case 29 :
				// grammars/Lua.g:1:155: LTEq
				{
				mLTEq(); 

				}
				break;
			case 30 :
				// grammars/Lua.g:1:160: Length
				{
				mLength(); 

				}
				break;
			case 31 :
				// grammars/Lua.g:1:167: Local
				{
				mLocal(); 

				}
				break;
			case 32 :
				// grammars/Lua.g:1:173: Minus
				{
				mMinus(); 

				}
				break;
			case 33 :
				// grammars/Lua.g:1:179: Mod
				{
				mMod(); 

				}
				break;
			case 34 :
				// grammars/Lua.g:1:183: Mult
				{
				mMult(); 

				}
				break;
			case 35 :
				// grammars/Lua.g:1:188: NEq
				{
				mNEq(); 

				}
				break;
			case 36 :
				// grammars/Lua.g:1:192: Nil
				{
				mNil(); 

				}
				break;
			case 37 :
				// grammars/Lua.g:1:196: Not
				{
				mNot(); 

				}
				break;
			case 38 :
				// grammars/Lua.g:1:200: OBrace
				{
				mOBrace(); 

				}
				break;
			case 39 :
				// grammars/Lua.g:1:207: OBrack
				{
				mOBrack(); 

				}
				break;
			case 40 :
				// grammars/Lua.g:1:214: OPar
				{
				mOPar(); 

				}
				break;
			case 41 :
				// grammars/Lua.g:1:219: Or
				{
				mOr(); 

				}
				break;
			case 42 :
				// grammars/Lua.g:1:222: Pow
				{
				mPow(); 

				}
				break;
			case 43 :
				// grammars/Lua.g:1:226: Repeat
				{
				mRepeat(); 

				}
				break;
			case 44 :
				// grammars/Lua.g:1:233: Return
				{
				mReturn(); 

				}
				break;
			case 45 :
				// grammars/Lua.g:1:240: SCol
				{
				mSCol(); 

				}
				break;
			case 46 :
				// grammars/Lua.g:1:245: Then
				{
				mThen(); 

				}
				break;
			case 47 :
				// grammars/Lua.g:1:250: True
				{
				mTrue(); 

				}
				break;
			case 48 :
				// grammars/Lua.g:1:255: Until
				{
				mUntil(); 

				}
				break;
			case 49 :
				// grammars/Lua.g:1:261: While
				{
				mWhile(); 

				}
				break;
			case 50 :
				// grammars/Lua.g:1:267: Name
				{
				mName(); 

				}
				break;
			case 51 :
				// grammars/Lua.g:1:272: Number
				{
				mNumber(); 

				}
				break;
			case 52 :
				// grammars/Lua.g:1:279: String
				{
				mString(); 

				}
				break;
			case 53 :
				// grammars/Lua.g:1:286: Comment
				{
				mComment(); 

				}
				break;
			case 54 :
				// grammars/Lua.g:1:294: Space
				{
				mSpace(); 

				}
				break;
			case 55 :
				// grammars/Lua.g:1:300: Any
				{
				mAny(); 

				}
				break;

		}
	}


	protected DFA20 dfa20 = new DFA20(this);
	protected DFA36 dfa36 = new DFA36(this);
	static final String DFA20_eotS =
		"\1\2\5\uffff";
	static final String DFA20_eofS =
		"\6\uffff";
	static final String DFA20_minS =
		"\1\133\1\0\1\uffff\1\0\2\uffff";
	static final String DFA20_maxS =
		"\1\133\1\uffff\1\uffff\1\uffff\2\uffff";
	static final String DFA20_acceptS =
		"\2\uffff\1\3\1\uffff\1\1\1\2";
	static final String DFA20_specialS =
		"\1\uffff\1\0\1\uffff\1\1\2\uffff}>";
	static final String[] DFA20_transitionS = {
			"\1\1",
			"\75\5\1\3\35\5\1\4\uffa4\5",
			"",
			"\75\5\1\3\35\5\1\4\uffa4\5",
			"",
			""
	};

	static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
	static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
	static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
	static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
	static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
	static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
	static final short[][] DFA20_transition;

	static {
		int numStates = DFA20_transitionS.length;
		DFA20_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
		}
	}

	protected class DFA20 extends DFA {

		public DFA20(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 20;
			this.eot = DFA20_eot;
			this.eof = DFA20_eof;
			this.min = DFA20_min;
			this.max = DFA20_max;
			this.accept = DFA20_accept;
			this.special = DFA20_special;
			this.transition = DFA20_transition;
		}
		@Override
		public String getDescription() {
			return "439:9: ( LongBracket | '[' ( '=' )* ~ ( '=' | '[' ) (~ ( '\\r' | '\\n' ) )* | (~ '[' (~ ( '\\r' | '\\n' ) )* )? )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA20_1 = input.LA(1);
						s = -1;
						if ( (LA20_1=='=') ) {s = 3;}
						else if ( (LA20_1=='[') ) {s = 4;}
						else if ( ((LA20_1 >= '\u0000' && LA20_1 <= '<')||(LA20_1 >= '>' && LA20_1 <= 'Z')||(LA20_1 >= '\\' && LA20_1 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA20_3 = input.LA(1);
						s = -1;
						if ( (LA20_3=='[') ) {s = 4;}
						else if ( (LA20_3=='=') ) {s = 3;}
						else if ( ((LA20_3 >= '\u0000' && LA20_3 <= '<')||(LA20_3 >= '>' && LA20_3 <= 'Z')||(LA20_3 >= '\\' && LA20_3 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 20, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA36_eotS =
		"\2\uffff\1\55\1\57\1\55\3\uffff\1\65\2\uffff\1\55\1\72\2\55\1\102\2\55"+
		"\1\107\1\uffff\1\55\1\113\2\uffff\1\52\1\55\1\uffff\1\122\1\uffff\1\55"+
		"\1\uffff\1\55\1\uffff\3\55\3\uffff\2\52\3\uffff\1\55\3\uffff\1\55\7\uffff"+
		"\1\140\1\142\2\uffff\5\55\2\uffff\1\55\1\151\1\152\3\uffff\1\55\5\uffff"+
		"\2\55\4\uffff\1\156\1\uffff\1\55\1\uffff\4\55\1\uffff\1\165\1\55\3\uffff"+
		"\1\55\1\170\1\55\1\172\2\55\2\uffff\1\55\1\176\1\177\1\uffff\6\55\1\uffff"+
		"\1\55\1\u0088\1\uffff\1\55\1\uffff\1\55\1\u008b\1\55\2\uffff\2\55\1\u008f"+
		"\1\u0090\2\55\1\u0093\1\55\1\uffff\1\u0095\1\55\1\uffff\1\u0097\2\55\2"+
		"\uffff\1\u009a\1\u009b\1\uffff\1\u009c\1\uffff\1\55\1\uffff\1\u009e\1"+
		"\u009f\3\uffff\1\55\2\uffff\1\u00a1\1\uffff";
	static final String DFA36_eofS =
		"\u00a2\uffff";
	static final String DFA36_minS =
		"\1\0\1\uffff\1\156\1\75\1\162\3\uffff\1\72\2\uffff\1\157\1\56\1\154\1"+
		"\141\1\75\1\157\1\146\1\75\1\uffff\1\157\1\55\2\uffff\1\75\1\151\1\uffff"+
		"\1\75\1\uffff\1\162\1\uffff\1\145\1\uffff\1\150\1\156\1\150\3\uffff\2"+
		"\0\3\uffff\1\144\3\uffff\1\145\7\uffff\1\60\1\56\2\uffff\1\163\1\144\1"+
		"\154\1\162\1\156\2\uffff\1\164\2\60\3\uffff\1\143\5\uffff\1\154\1\164"+
		"\4\uffff\1\60\1\uffff\1\160\1\uffff\1\145\1\165\1\164\1\151\1\uffff\1"+
		"\60\1\141\3\uffff\1\145\1\60\1\163\1\60\1\143\1\157\2\uffff\1\141\2\60"+
		"\1\uffff\1\145\1\165\1\156\1\145\1\151\1\154\1\uffff\1\153\1\60\1\uffff"+
		"\1\145\1\uffff\1\164\1\60\1\154\2\uffff\1\141\1\162\2\60\1\154\1\145\1"+
		"\60\1\146\1\uffff\1\60\1\151\1\uffff\1\60\1\164\1\156\2\uffff\2\60\1\uffff"+
		"\1\60\1\uffff\1\157\1\uffff\2\60\3\uffff\1\156\2\uffff\1\60\1\uffff";
	static final String DFA36_maxS =
		"\1\uffff\1\uffff\1\156\1\75\1\162\3\uffff\1\72\2\uffff\1\157\1\71\1\156"+
		"\1\165\1\75\1\157\1\156\1\75\1\uffff\1\157\1\55\2\uffff\1\75\1\157\1\uffff"+
		"\1\133\1\uffff\1\162\1\uffff\1\145\1\uffff\1\162\1\156\1\150\3\uffff\2"+
		"\uffff\3\uffff\1\144\3\uffff\1\145\7\uffff\1\172\1\56\2\uffff\1\163\1"+
		"\144\1\154\1\162\1\156\2\uffff\1\164\2\172\3\uffff\1\143\5\uffff\1\154"+
		"\1\164\4\uffff\1\172\1\uffff\1\164\1\uffff\1\145\1\165\1\164\1\151\1\uffff"+
		"\1\172\1\141\3\uffff\1\145\1\172\1\163\1\172\1\143\1\157\2\uffff\1\141"+
		"\2\172\1\uffff\1\145\1\165\1\156\1\145\1\151\1\154\1\uffff\1\153\1\172"+
		"\1\uffff\1\145\1\uffff\1\164\1\172\1\154\2\uffff\1\141\1\162\2\172\1\154"+
		"\1\145\1\172\1\146\1\uffff\1\172\1\151\1\uffff\1\172\1\164\1\156\2\uffff"+
		"\2\172\1\uffff\1\172\1\uffff\1\157\1\uffff\2\172\3\uffff\1\156\2\uffff"+
		"\1\172\1\uffff";
	static final String DFA36_acceptS =
		"\1\uffff\1\1\3\uffff\1\5\1\6\1\7\1\uffff\1\12\1\13\10\uffff\1\36\2\uffff"+
		"\1\41\1\42\2\uffff\1\46\1\uffff\1\50\1\uffff\1\52\1\uffff\1\55\3\uffff"+
		"\1\62\2\63\2\uffff\1\66\1\67\1\1\1\uffff\1\62\1\23\1\3\1\uffff\1\5\1\6"+
		"\1\7\1\11\1\10\1\12\1\13\2\uffff\1\15\1\63\5\uffff\1\30\1\27\3\uffff\1"+
		"\35\1\34\1\36\1\uffff\1\65\1\40\1\41\1\42\1\43\2\uffff\1\46\1\47\1\64"+
		"\1\50\1\uffff\1\52\1\uffff\1\55\4\uffff\1\66\2\uffff\1\14\1\17\1\16\6"+
		"\uffff\1\32\1\33\3\uffff\1\51\6\uffff\1\2\2\uffff\1\22\1\uffff\1\25\3"+
		"\uffff\1\44\1\45\10\uffff\1\20\2\uffff\1\31\3\uffff\1\56\1\57\2\uffff"+
		"\1\4\1\uffff\1\24\1\uffff\1\37\2\uffff\1\60\1\61\1\21\1\uffff\1\53\1\54"+
		"\1\uffff\1\26";
	static final String DFA36_specialS =
		"\1\2\46\uffff\1\1\1\0\171\uffff}>";
	static final String[] DFA36_transitionS = {
			"\11\52\2\51\1\52\2\51\22\52\1\51\1\52\1\47\1\23\1\52\1\26\1\52\1\50\1"+
			"\34\1\7\1\27\1\1\1\11\1\25\1\14\1\12\1\45\11\46\1\10\1\40\1\22\1\3\1"+
			"\17\2\52\32\44\1\33\1\52\1\6\1\36\1\44\1\52\1\2\1\4\1\44\1\13\1\15\1"+
			"\16\1\20\1\44\1\21\2\44\1\24\1\44\1\31\1\35\2\44\1\37\1\44\1\41\1\42"+
			"\1\44\1\43\3\44\1\32\1\52\1\5\1\30\uff81\52",
			"",
			"\1\54",
			"\1\56",
			"\1\60",
			"",
			"",
			"",
			"\1\64",
			"",
			"",
			"\1\70",
			"\1\71\1\uffff\12\73",
			"\1\74\1\uffff\1\75",
			"\1\76\15\uffff\1\77\5\uffff\1\100",
			"\1\101",
			"\1\103",
			"\1\104\7\uffff\1\105",
			"\1\106",
			"",
			"\1\111",
			"\1\112",
			"",
			"",
			"\1\116",
			"\1\117\5\uffff\1\120",
			"",
			"\1\123\35\uffff\1\123",
			"",
			"\1\125",
			"",
			"\1\127",
			"",
			"\1\131\11\uffff\1\132",
			"\1\133",
			"\1\134",
			"",
			"",
			"",
			"\12\123\1\uffff\2\123\1\uffff\ufff2\123",
			"\12\123\1\uffff\2\123\1\uffff\ufff2\123",
			"",
			"",
			"",
			"\1\136",
			"",
			"",
			"",
			"\1\137",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\141",
			"",
			"",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"",
			"",
			"\1\150",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"",
			"",
			"\1\153",
			"",
			"",
			"",
			"",
			"",
			"\1\154",
			"\1\155",
			"",
			"",
			"",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"\1\157\3\uffff\1\160",
			"",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\166",
			"",
			"",
			"",
			"\1\167",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\171",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\173",
			"\1\174",
			"",
			"",
			"\1\175",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"",
			"\1\u0086",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\10\55\1\u0087\21\55",
			"",
			"\1\u0089",
			"",
			"\1\u008a",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\u008c",
			"",
			"",
			"\1\u008d",
			"\1\u008e",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\u0091",
			"\1\u0092",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\u0094",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\u0096",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\1\u0098",
			"\1\u0099",
			"",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"\1\u009d",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			"",
			"",
			"",
			"\1\u00a0",
			"",
			"",
			"\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
			""
	};

	static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
	static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
	static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
	static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
	static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
	static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
	static final short[][] DFA36_transition;

	static {
		int numStates = DFA36_transitionS.length;
		DFA36_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
		}
	}

	protected class DFA36 extends DFA {

		public DFA36(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 36;
			this.eot = DFA36_eot;
			this.eof = DFA36_eof;
			this.min = DFA36_min;
			this.max = DFA36_max;
			this.accept = DFA36_accept;
			this.special = DFA36_special;
			this.transition = DFA36_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( Add | And | Assign | Break | CBrace | CBrack | CPar | Col | ColCol | Comma | Div | Do | Dot | DotDot | DotDotDot | Else | Elseif | End | Eq | False | For | Function | GT | GTEq | Goto | If | In | LT | LTEq | Length | Local | Minus | Mod | Mult | NEq | Nil | Not | OBrace | OBrack | OPar | Or | Pow | Repeat | Return | SCol | Then | True | Until | While | Name | Number | String | Comment | Space | Any );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA36_40 = input.LA(1);
						s = -1;
						if ( ((LA36_40 >= '\u0000' && LA36_40 <= '\t')||(LA36_40 >= '\u000B' && LA36_40 <= '\f')||(LA36_40 >= '\u000E' && LA36_40 <= '\uFFFF')) ) {s = 83;}
						else s = 42;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA36_39 = input.LA(1);
						s = -1;
						if ( ((LA36_39 >= '\u0000' && LA36_39 <= '\t')||(LA36_39 >= '\u000B' && LA36_39 <= '\f')||(LA36_39 >= '\u000E' && LA36_39 <= '\uFFFF')) ) {s = 83;}
						else s = 42;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA36_0 = input.LA(1);
						s = -1;
						if ( (LA36_0=='+') ) {s = 1;}
						else if ( (LA36_0=='a') ) {s = 2;}
						else if ( (LA36_0=='=') ) {s = 3;}
						else if ( (LA36_0=='b') ) {s = 4;}
						else if ( (LA36_0=='}') ) {s = 5;}
						else if ( (LA36_0==']') ) {s = 6;}
						else if ( (LA36_0==')') ) {s = 7;}
						else if ( (LA36_0==':') ) {s = 8;}
						else if ( (LA36_0==',') ) {s = 9;}
						else if ( (LA36_0=='/') ) {s = 10;}
						else if ( (LA36_0=='d') ) {s = 11;}
						else if ( (LA36_0=='.') ) {s = 12;}
						else if ( (LA36_0=='e') ) {s = 13;}
						else if ( (LA36_0=='f') ) {s = 14;}
						else if ( (LA36_0=='>') ) {s = 15;}
						else if ( (LA36_0=='g') ) {s = 16;}
						else if ( (LA36_0=='i') ) {s = 17;}
						else if ( (LA36_0=='<') ) {s = 18;}
						else if ( (LA36_0=='#') ) {s = 19;}
						else if ( (LA36_0=='l') ) {s = 20;}
						else if ( (LA36_0=='-') ) {s = 21;}
						else if ( (LA36_0=='%') ) {s = 22;}
						else if ( (LA36_0=='*') ) {s = 23;}
						else if ( (LA36_0=='~') ) {s = 24;}
						else if ( (LA36_0=='n') ) {s = 25;}
						else if ( (LA36_0=='{') ) {s = 26;}
						else if ( (LA36_0=='[') ) {s = 27;}
						else if ( (LA36_0=='(') ) {s = 28;}
						else if ( (LA36_0=='o') ) {s = 29;}
						else if ( (LA36_0=='^') ) {s = 30;}
						else if ( (LA36_0=='r') ) {s = 31;}
						else if ( (LA36_0==';') ) {s = 32;}
						else if ( (LA36_0=='t') ) {s = 33;}
						else if ( (LA36_0=='u') ) {s = 34;}
						else if ( (LA36_0=='w') ) {s = 35;}
						else if ( ((LA36_0 >= 'A' && LA36_0 <= 'Z')||LA36_0=='_'||LA36_0=='c'||LA36_0=='h'||(LA36_0 >= 'j' && LA36_0 <= 'k')||LA36_0=='m'||(LA36_0 >= 'p' && LA36_0 <= 'q')||LA36_0=='s'||LA36_0=='v'||(LA36_0 >= 'x' && LA36_0 <= 'z')) ) {s = 36;}
						else if ( (LA36_0=='0') ) {s = 37;}
						else if ( ((LA36_0 >= '1' && LA36_0 <= '9')) ) {s = 38;}
						else if ( (LA36_0=='\"') ) {s = 39;}
						else if ( (LA36_0=='\'') ) {s = 40;}
						else if ( ((LA36_0 >= '\t' && LA36_0 <= '\n')||(LA36_0 >= '\f' && LA36_0 <= '\r')||LA36_0==' ') ) {s = 41;}
						else if ( ((LA36_0 >= '\u0000' && LA36_0 <= '\b')||LA36_0=='\u000B'||(LA36_0 >= '\u000E' && LA36_0 <= '\u001F')||LA36_0=='!'||LA36_0=='$'||LA36_0=='&'||(LA36_0 >= '?' && LA36_0 <= '@')||LA36_0=='\\'||LA36_0=='`'||LA36_0=='|'||(LA36_0 >= '\u007F' && LA36_0 <= '\uFFFF')) ) {s = 42;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 36, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
