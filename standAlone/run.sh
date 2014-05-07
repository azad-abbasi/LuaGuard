#!/bin/bash
#coppy every file to the corresponding directory
cp ../src/parser/*.java ./src/parser/
cp ../src/unparser/*.java ./src/unparser/
cp ../src/main/*.java ./src/main/
cp ../grammars/*.g ./grammars/


java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/Lua.g
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/LuaWalker.g
mv grammars/*.java src/parser/
mv *.tokens src/parser/
javac -cp "lib/antlr-3.5.2-complete-no-st3.jar" -sourcepath "./src/*/*" src/*/*.java



java -cp ".:lib/antlr-3.5.2-complete-no-st3.jar" src/main/MainClass $1 $2 $3
rm -rf src/parser/*.class src/unparser/*.class src/*/*.class

