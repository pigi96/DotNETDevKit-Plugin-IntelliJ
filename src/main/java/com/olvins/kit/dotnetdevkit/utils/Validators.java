package com.olvins.kit.dotnetdevkit.utils;

import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpLexer;
import com.olvins.kit.dotnetdevkit.lexicon.CSharpParser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class Validators {
    public static class ExpressionValidator implements IValidator {
        @Override
        public void validate(String expression) {
            //parser(expression).expression();
        }
    }

    public static class IdentifierValidator implements IValidator {
        @Override
        public void validate(String identifier) {
            parser(identifier).identifier();
        }
    }

    public static class DeclarationValidator implements IValidator {
        @Override
        public void validate(String declaration) {
            parser(declaration).declarationStatement();
        }
    }

    public static class InitializationValidator implements IValidator {
        @Override
        public void validate(String initialization) {
            parser(initialization).for_initializer();
        }
    }

    public static class IterationValidator implements IValidator {
        @Override
        public void validate(String iteration) {
            parser(iteration).for_iterator();
        }
    }

    public static class StatementValidator implements IValidator {
        @Override
        public void validate(String statement) {
            parser(statement).statement();
        }
    }

    public static class MemberModifierValidator implements IValidator {
        @Override
        public void validate(String memberModifier) {
            //parser(memberModifier).common_member_declaration();
        }
    }

    public static class MemberTypeValidator implements IValidator {
        @Override
        public void validate(String memberType) {
            //parser(memberType).type_declaration();
        }
    }

    public static class IfDecisionBlockValidator implements IValidator {
        @Override
        public void validate(String ifDecision) {
            parser(ifDecision).if_body();
        }
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
