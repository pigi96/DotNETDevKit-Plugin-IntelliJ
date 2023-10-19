package com.olvins.kit.dotnetdevkit.validators.conditionals;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.validators.IValidator;

import java.util.regex.Pattern;

public class OperandValidator implements IValidator {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");

    @Override
    public boolean validate(String token) throws ConditionalException {
        if (!OPERAND_PATTERN.matcher(token).matches()) {
            throw ConditionalException.OPERAND_VALIDATION;
        }
        return true;
    }
}
