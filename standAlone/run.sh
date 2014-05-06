#!/bin/bash
cp ../src/parser/*.java ./parser/
cp ../src/unparser/*.java ./unparser/
cp ../grammars/*.g ./grammars/
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/Lua.g
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/LuaWalker.g
mv grammars/*.java parser/
mv *.tokens parser/ 
javac -cp "lib/antlr-3.5.2-complete-no-st3.jar" -sourcepath "./parser" parser/*.java
java -cp ".:lib/antlr-3.5.2-complete-no-st3.jar" parser/MainClass $1 $2
rm -rf parser/*.class

