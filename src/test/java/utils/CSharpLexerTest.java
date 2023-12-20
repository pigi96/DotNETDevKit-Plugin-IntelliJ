package utils;

import com.olvins.kit.dotnetdevkit.lexicon.CSharpLexer;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * TODO - future stuff, can be created to parse code and convert it into Blocks
 */
public class CSharpLexerTest {
    @Test
    public void CSharpLexer_validInput_returnSuccess() {
        String cSharpCode = "public class MyClass {" +
                "   String statement = 3;" +
                "   if (test == 3) {" +
                "       String boom = \"zoom\"" +
                "   }" +
                "};";

        CSharpLexer lexer = new CSharpLexer(CharStreams.fromString(cSharpCode));

        // Minimal parsing with tokenization
        for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
            System.out.println("Token: " + token.getText() + " Type: " + token.getType());
        }

        // Converting to trees may be easier to use
        /*CSharpParser parser = new CSharpParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.compilation_unit();
        ParseTreeWalker walker = new ParseTreeWalker();
        CustomCSharpListener listener = new CustomCSharpListener();

        walker.walk(listener, tree);*/

        Assert.assertEquals("", "");
    }
}
