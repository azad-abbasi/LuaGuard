#!/bin/bash
#coppy every file to the corresponding directory
cp ../src/parser/*.java ./parser/
cp ../src/unparser/*.java ./unparser/
cp ../src/main/*.java ./main/
cp ../grammars/*.g ./grammars/


java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/Lua.g
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/LuaWalker.g
mv grammars/*.java parser/
mv *.tokens parser/
javac -cp "lib/antlr-3.5.2-complete-no-st3.jar" -sourcepath "./*/*" */*.java



java -cp ".:lib/antlr-3.5.2-complete-no-st3.jar:parser/*:unparser/*:main/*" main/MainClass $1 $2 $3
rm -rf parser/*.class unparser/*.class */*.class

