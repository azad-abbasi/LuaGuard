COPY .\src\parser\*.java .\parser\
COPY .\src\unparser\*.java .\unparser\
COPY ..\grammars\*.g .\grammars\
java -cp .\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool .\grammars\Lua.g
java -cp .\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool .\grammars\LuaWalker.g

COPY .\grammars\*.java .\parser\
COPY .\*.tokens .\parser\
DEL .\grammars\*.java
DEL .\*.tokens

javac -cp .\antlr-3.5.2-complete-no-st3.jar -sourcepath ".\parser" parser\*.java
java -cp ".;.\antlr-3.5.2-complete-no-st3.jar" parser\MainClass %1 %2

DEL .\parser\*.class


