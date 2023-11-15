package builders.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlockBuilder;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IterationBlockBuilderTest {
    private final static String ITERATION_VALID = "Iteration %s should be valid";
    private final static String ITERATION_INVALID = "Iteration %s should be invalid";

    @Test
    public void buildIterationBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_INT_ITERATION);

        IterationBlock iterationBlock = IterationBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_INT_ITERATION)
                .build();

        assertEquals(String.format(ITERATION_VALID, SyntaxConstants.VALID_INT_ITERATION), expectedResult, iterationBlock.value());
    }

    @Test
    public void buildInitializationBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            InitializationBlock initializationBlock = InitializationBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_INT_ITERATION)
                    .build();

            initializationBlock.value();
        });

        assertEquals(String.format(ITERATION_INVALID, SyntaxConstants.INVALID_INT_ITERATION), ExpressionException.class, exception.getClass());
    }
}
