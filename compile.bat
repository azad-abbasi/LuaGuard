java -cp .\lib\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool Lua.g
java -cp .\lib\antlr-3.5.2-complete-no-st3.jar org.antlr.Tool LuaWalker.g
COPY .\LuaLexer.java src\
COPY .\LuaParser.java src\
COPY .\Lua.tokens scr\
COPY .\LuaWalker src\
DEL .\LuaLexer.java
DEL .\LuaParser.java
DEL .\Lua.tokens
DEL .\LuaWalker.java