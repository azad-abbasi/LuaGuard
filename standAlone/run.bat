XCOPY /Y .\src\* .\src\
XCOPY /Y ..\grammars\*.g .\grammars\

java -cp .\lib\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool .\grammars\Lua.g
java -cp .\lib\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool .\grammars\LuaWalker.g

COPY .\grammars\*.java .\src\parser\
COPY .\*.tokens .\src\parser\
DEL .\grammars\*.java
DEL .\*.tokens

javac -cp .\lib\antlr-3.5.2-complete-no-st3.jar -sourcepath ".\src\*\*" src\*\*.java
java -cp ".\src\;.\lib\antlr-3.5.2-complete-no-st3.jar" main.MainClass %1 %2

DEL .\src\*\*.class


