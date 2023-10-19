package com.olvins.kit.dotnetdevkit.errors;

public class ConditionalException extends ValidationException {
    public static final ConditionalException PARENTHESES_MATCHING = new ConditionalException("Parentheses are not matched correctly");
    public static final ConditionalException VALID_COMPARISON_OPERATOR = new ConditionalException("Comparison operators are not matched correctly");
    public static final ConditionalException VALID_LOGICAL_OPERATOR = new ConditionalException("Logical operators are not matched correctly");
    public static final ConditionalException OPERAND_VALIDATION = new ConditionalException("Operands are not matched correctly");

    public ConditionalException(String message) {
        super(message);
    }
}
