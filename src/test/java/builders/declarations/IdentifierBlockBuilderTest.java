package builders.declarations;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IdentifierBlockBuilderTest {
    private final static String IDENTIFIER_VALID = "Identifier %s should be valid";
    private final static String IDENTIFIER_INVALID = "Identifier %s should be invalid";

    @Test
    public void buildIdentifierBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_IDENTIFIER);

        IdentifierBlock identifierBlock = IdentifierBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_IDENTIFIER)
                .build();

        assertEquals(String.format(IDENTIFIER_VALID, SyntaxConstants.VALID_IDENTIFIER), expectedResult, identifierBlock.getGeneratedFormattedCode());
    }

    @Test
    public void buildIdentifierBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            IdentifierBlock identifierBlock = IdentifierBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_IDENTIFIER)
                    .build();

            identifierBlock.getGeneratedFormattedCode();
        });

        assertEquals(String.format(IDENTIFIER_INVALID, SyntaxConstants.INVALID_IDENTIFIER), ExpressionException.class, exception.getClass());
    }
}
