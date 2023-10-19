package com.olvins.kit.dotnetdevkit.validators.conditionals;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.types.ComparisonType;
import com.olvins.kit.dotnetdevkit.validators.IValidator;

public class ComparisonValidator implements IValidator {
    @Override
    public boolean validate(String token) throws ConditionalException {
        if (!ComparisonType.validate(token)) {
            throw ConditionalException.VALID_COMPARISON_OPERATOR;
        }
        return true;
    }
}
