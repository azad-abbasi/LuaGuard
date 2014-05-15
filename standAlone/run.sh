

#!/bin/bash
#coppy every file to the corresponding directory
#basically we are syncing the stand alone with the IDE project
cp -rf ../src/* ./src/
cp ../grammars/*.g ./grammars/


#compile the grammars and produce the target java files
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/Lua.g
java -cp lib/antlr-3.5.2-complete-no-st3.jar org.antlr.Tool grammars/LuaWalker.g

#moving these produced files to the target packages
mv grammars/*.java src/parser/
mv *.tokens src/parser/

#compiling the source code
javac -cp "lib/antlr-3.5.2-complete-no-st3.jar:lib/commons-cli-1.2.jar" -sourcepath "./src/*/*" src/*/*.java

#running the mainClass of the source code

java -cp "./src/:lib/antlr-3.5.2-complete-no-st3.jar:lib/commons-cli-1.2.jar" main.MainClass $1 $2 $3 $4


#clearing the directories of .class files
rm -rf src/parser/*.class src/unparser/*.class src/*/*.class

