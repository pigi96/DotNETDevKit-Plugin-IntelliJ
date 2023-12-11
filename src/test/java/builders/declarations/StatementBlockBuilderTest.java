package builders.declarations;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.StatementBlock;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatementBlockBuilderTest {
    private final static String STATEMENT_VALID = "Statement %s should be valid";
    private final static String STATEMENT_INVALID = "Statement %s should be invalid";

    @Test
    public void buildStatementBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_STRING_DECLARATION);

        StatementBlock statementBlock = StatementBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_STRING_DECLARATION)
                .build();

        assertEquals(String.format(STATEMENT_VALID, SyntaxConstants.VALID_STRING_DECLARATION), expectedResult, statementBlock.generate());
    }

    @Test
    public void buildStatementBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            StatementBlock statementBlock = StatementBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_DECLARATION_1)
                    .build();

            statementBlock.generate();
        });

        assertEquals(String.format(STATEMENT_INVALID, SyntaxConstants.INVALID_DECLARATION_1), ExpressionException.class, exception.getClass());
    }
}
