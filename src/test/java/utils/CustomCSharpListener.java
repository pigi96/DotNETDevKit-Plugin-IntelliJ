package utils;

import com.olvins.kit.dotnetdevkit.lexicon.CSharpParser;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpParserBaseListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CustomCSharpListener extends CSharpParserBaseListener {

    @Override
    public void enterClass_definition(CSharpParser.Class_definitionContext ctx) {
        // Logic when entering a class definition
        System.out.println("Found class: " + ctx.identifier().getText());
    }
}
