package validators;

import com.olvins.kit.dotnetdevkit.blocks.controls.ConditionBlock;
import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpressionValidatorTest {
    private final static String EXPRESSION_CORRECT = "Expression %s should be valid";
    private final static String EXPRESSION_INCORRECT = "Expression %s should be invalid";

    @Test
    void validateExpression_CorrectExpression_ReturnsCode() {
        String expression = "i == 3";
        ConditionBlock conditionBlock = new ConditionBlock(expression);
        String code = conditionBlock.value();
        assertEquals(String.format(EXPRESSION_CORRECT, expression), code,  expression);
    }

    @Test
    void validateExpression_MismatchedParentheses_ThrowsException() {
        String expression = "((i == 3)";
        Exception exception = assertThrows(ConditionalException.class, () -> {
            ConditionBlock conditionBlock = new ConditionBlock(expression);
        });

        assertEquals(String.format(EXPRESSION_INCORRECT, expression), ConditionalException.class, exception.getClass());
    }

    @Test
    void validateExpression_InvalidOperators_ThrowsException() {
        String expression = "i %% 3";
        Exception exception = assertThrows(ConditionalException.class, () -> {
            ConditionBlock conditionBlock = new ConditionBlock(expression);
        });

        assertEquals(String.format(EXPRESSION_INCORRECT, expression), ConditionalException.class, exception.getClass());
    }

    @Test
    void validateExpression_InvalidNestedConditions_ThrowsException() {
        String expression = "(i == 3) && (i";
        Exception exception = assertThrows(ConditionalException.class, () -> {
            ConditionBlock conditionBlock = new ConditionBlock(expression);
        });

        assertEquals(String.format(EXPRESSION_INCORRECT, expression), ConditionalException.class, exception.getClass());
    }
}
