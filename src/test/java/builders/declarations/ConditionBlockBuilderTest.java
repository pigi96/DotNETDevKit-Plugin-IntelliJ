package builders.declarations;

import com.olvins.kit.ConditionBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
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
                .condition(SyntaxConstants.VALID_CONDITION)
                .build();

        assertEquals(String.format(CONDITION_VALID, SyntaxConstants.VALID_CONDITION), expectedResult, conditionBlock.generate());
    }

    @Test
    public void buildConditionBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            ConditionBlock conditionBlock = ConditionBlockBuilder.start()
                    .condition(SyntaxConstants.INVALID_CONDITION)
                    .build();

            conditionBlock.generate();
        });

        assertEquals(String.format(CONDITION_INVALID, SyntaxConstants.INVALID_CONDITION), ExpressionException.class, exception.getClass());
    }
}
