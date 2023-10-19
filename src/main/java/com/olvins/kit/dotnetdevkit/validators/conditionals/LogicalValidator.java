package com.olvins.kit.dotnetdevkit.validators.conditionals;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.types.LogicalType;
import com.olvins.kit.dotnetdevkit.validators.IValidator;

public class LogicalValidator implements IValidator {
    @Override
    public boolean validate(String token) throws ConditionalException {
        if (!LogicalType.validate(token)) {
            throw ConditionalException.VALID_LOGICAL_OPERATOR;
        }
        return true;
    }
}
