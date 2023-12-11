package validators;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO: fix
public class IdentifierValidatorTest {
    private final static String IDENTIFIER_VALID = "Identifier %s should be valid";
    private final static String IDENTIFIER_INVALID = "Identifier %s should be invalid";

    @Test
    void validateIdentifier_CorrectExpression_ReturnsCode() {
        String expression = "idt";
        IdentifierBlock conditionBlock = new IdentifierBlock(expression);
        String code = conditionBlock.generate();
        assertEquals(String.format(IDENTIFIER_VALID, expression), code,  expression);
    }

    @Test
    void validateIdentifier_Space_ThrowsException() {
        String expression = "idt d";
        Exception exception = assertThrows(ExpressionException.class, () -> {
            IdentifierBlock conditionBlock = new IdentifierBlock(expression);
        });

        assertEquals(String.format(IDENTIFIER_INVALID, expression), ExpressionException.class, exception.getClass());
    }

    @Test
    void validateIdentifier_FrontNumber_ThrowsException() {
        String expression = "3idt";
        Exception exception = assertThrows(ExpressionException.class, () -> {
            IdentifierBlock conditionBlock = new IdentifierBlock(expression);
        });

        assertEquals(String.format(IDENTIFIER_INVALID, expression), ExpressionException.class, exception.getClass());
    }
}
