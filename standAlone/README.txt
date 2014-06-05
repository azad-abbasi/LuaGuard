LUA AST GENERATOR DOCUMENTATION

CONTENTS:


-Antlr library,
	antlr is being used to tokenize, do the lexical analysis and parse a lua code and generate the AST tree. the antlr-3.5.2-complete-no-st3.jar is the target library as the external library to this code. 


-Lua.g
	this file is the complete grammar for tokenizing and lexical analysis along with parser rules written with regard to antlr library to generate a parser that is creating an AST along with parsing the lua code. 

-Run.sh & Run.bat
	these two scripts are the scripts that will generate the proper Lexer code and Parser code for the target grammar. you will only have to run them (Run.sh for Linux-Unix machines and Run.bat for windows machines) and they will produce the proper Lexer.java and Parser.java with respect to the input grammar (Lua.g)

- src/LuaParser.java src/LuaLexer.java/Lua.tokens
	the first two java files are the automatic output of the antlr library. one for doing lexical analysis and the other is the parser which uses the output of the lexical analysis to parse the lua code. the Lua.tokens is being used to do the lexical analysis

-src/InputReader.java
	this class is designed to work with outer text files. 

-src/MainClass.java
	this is the main class that is designing and drawing the AST output. 
	in the main method there are the ususal steps toward parsing the input code and then calling proper functions to create and draw the AST to the output
	this program takes 2 arguments to work
		1:the source to the lua file that you wish to generate an AST tree for. 
		2:the path to the output you wish to save the AST to. 

-src/Demo.java
	this class is designed to play around with the capabilities of antlr and helpful way of testing different capabilities. there is no special functionality considered for this file.

==========================
warning: the program is designed for testing , and it's not a final release. the output is designed to generate new files with new names everytime the program runs to generate differnet AST trees from different inputs. 

