

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

one="../"$1
two="../"$2
three="../"$3
cd src/
java -cp ".:../lib/antlr-3.5.2-complete-no-st3.jar:*/*" main/MainClass $one $two $three
cd ../
rm -rf src/parser/*.class src/unparser/*.class src/*/*.class

