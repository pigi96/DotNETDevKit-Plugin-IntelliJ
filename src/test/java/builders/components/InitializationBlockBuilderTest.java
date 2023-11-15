package builders.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlockBuilder;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InitializationBlockBuilderTest {
    private final static String INITIALIZATION_VALID = "Initialization %s should be valid";
    private final static String INITIALIZATION_INVALID = "Initialization %s should be invalid";

    @Test
    public void buildInitializationBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_INT_INITIALIZATION);

        InitializationBlock initializationBlock = InitializationBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_INT_INITIALIZATION)
                .build();

        assertEquals(String.format(INITIALIZATION_VALID, SyntaxConstants.VALID_INT_INITIALIZATION), expectedResult, initializationBlock.value());
    }

    @Test
    public void buildInitializationBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            InitializationBlock initializationBlock = InitializationBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_INT_INITIALIZATION)
                    .build();

            initializationBlock.value();
        });

        assertEquals(String.format(INITIALIZATION_INVALID, SyntaxConstants.INVALID_INT_INITIALIZATION), ExpressionException.class, exception.getClass());
    }
}
