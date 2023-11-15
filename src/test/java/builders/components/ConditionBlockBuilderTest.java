package builders.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlockBuilder;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConditionBlockBuilderTest {
    private final static String CONDITION_VALID = "Condition %s should be valid";
    private final static String CONDITION_INVALID = "Condition %s should be invalid";

    @Test
    public void buildConditionBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_CONDITION);

        ConditionBlock conditionBlock = ConditionBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_CONDITION)
                .build();

        assertEquals(String.format(CONDITION_VALID, SyntaxConstants.VALID_CONDITION), expectedResult, conditionBlock.value());
    }

    @Test
    public void buildConditionBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            ConditionBlock conditionBlock = ConditionBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_CONDITION)
                    .build();

            conditionBlock.value();
        });

        assertEquals(String.format(CONDITION_INVALID, SyntaxConstants.INVALID_CONDITION), ExpressionException.class, exception.getClass());
    }
}
