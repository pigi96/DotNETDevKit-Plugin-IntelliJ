package validators;

import com.olvins.kit.dotnetdevkit.validators.Validators;
import org.junit.jupiter.api.Test;

public class ExpressionValidatorTest {
    private final static String EXPRESSION_VALID_MESSAGE = "Expression %s should be valid";
    private final static String EXPRESSION_INVALID_MESSAGE = "Expression %s should be invalid";

    private final static String EXPRESSION_BASIC_VALID = "exp == 1";
    private final static String EXPRESSION_SINGLE_BRACKETS_VALID = "(exp == 1)";
    private final static String EXPRESSION_MULTIPLE_COMPLEX_VALID = "((exp == 1) && (exp == 2))";
    private final static String EXPRESSION_MULTIPLE_BRACKETS_VALID = "((exp == 1))";
    private final static String EXPRESSION_BASIC_INVALID = "exp == ";
    private final static String EXPRESSION_BRACKETS_INVALID = "(exp == 1";
    private final static String EXPRESSION_OPERATORS_INVALID = "exp %%% 1";
    private final static String EXPRESSION_NESTED_BRACKETS_INVALID = "(exp == 1) && (exp";

    @Test
    void validateExpression_BasicValid_ReturnsSuccess() {
        ValidatorsUtils.validateValueSuccess(EXPRESSION_BASIC_VALID, EXPRESSION_VALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_SingleBracketsValid_ReturnsSuccess() {
        ValidatorsUtils.validateValueSuccess(EXPRESSION_SINGLE_BRACKETS_VALID, EXPRESSION_VALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_MultipleComplexValid_ReturnsSuccess() {
        ValidatorsUtils.validateValueSuccess(EXPRESSION_MULTIPLE_COMPLEX_VALID, EXPRESSION_VALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_MultipleBracketsValid_ReturnsSuccess() {
        ValidatorsUtils.validateValueSuccess(EXPRESSION_MULTIPLE_BRACKETS_VALID, EXPRESSION_VALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_BasicInvalid_ThrowsException() {
        ValidatorsUtils.validateValueFailure(EXPRESSION_BASIC_INVALID, EXPRESSION_INVALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_BracketsInvalid_ThrowsException() {
        ValidatorsUtils.validateValueFailure(EXPRESSION_BRACKETS_INVALID, EXPRESSION_INVALID_MESSAGE, new Validators.ExpressionValidator());
    }
    @Test
    void validateExpression_OperationsInvalid_ThrowsException() {
        ValidatorsUtils.validateValueFailure(EXPRESSION_OPERATORS_INVALID, EXPRESSION_INVALID_MESSAGE, new Validators.ExpressionValidator());
    }

    @Test
    void validateExpression_NestedBracketsInvalid_ThrowsException() {
        ValidatorsUtils.validateValueFailure(EXPRESSION_NESTED_BRACKETS_INVALID, EXPRESSION_INVALID_MESSAGE, new Validators.ExpressionValidator());
    }
}
