#!/bin/bash
java -cp antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/Lua.g
java -cp antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/LuaWalker.g 
mv grammars/*.java src/parser/
mv *.tokens src/parser/


