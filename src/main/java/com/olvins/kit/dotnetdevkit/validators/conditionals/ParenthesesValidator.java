package com.olvins.kit.dotnetdevkit.validators.conditionals;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.validators.IValidator;

import java.util.Stack;

public class ParenthesesValidator implements IValidator {
    private final Stack<String> stack = new Stack<>();

    @Override
    public boolean validate(String token) throws ConditionalException {
        if (token.equals("(")) {
            stack.push(token);
            return true;
        } else if (token.equals(")")) {
            if (stack.isEmpty() || !stack.pop().equals("(")) {
                throw ConditionalException.PARENTHESES_MATCHING;
            }
        }
        return false;
    }

    public void validateCompletion() throws ConditionalException {
        if (!stack.isEmpty()) {
            throw ConditionalException.PARENTHESES_MATCHING;
        }
    }
}
