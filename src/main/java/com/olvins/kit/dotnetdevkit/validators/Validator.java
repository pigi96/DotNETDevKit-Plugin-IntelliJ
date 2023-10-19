package com.olvins.kit.dotnetdevkit.validators;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpLexer;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpParser;
import com.olvins.kit.dotnetdevkit.validators.misc.InitializationValidator;

import org.antlr.v4.runtime.*;

public class Validator {
    public static void validateExpression(String expression) {
        parser(expression).expression();
    }

    public static void validateIdentifier(String identifier) {
        parser(identifier).identifier();
    }


    public static void validateInitialization(String statement) {
        InitializationValidator initializationValidator = new InitializationValidator();

        initializationValidator.validateInitialization(statement);
    }

    private static CSharpParser parser(String expression) {
        CharStream charStream = CharStreams.fromString(expression);

        CSharpLexer lexer = new CSharpLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSharpParser parser = new CSharpParser(tokens);

        // Add a custom error listener to handle syntax errors.
        parser.removeErrorListeners(); // Remove the default error listener.
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e)
            {
                throw new ExpressionException(String.format("%s", msg));
            }
        });

        return parser;
    }
}
