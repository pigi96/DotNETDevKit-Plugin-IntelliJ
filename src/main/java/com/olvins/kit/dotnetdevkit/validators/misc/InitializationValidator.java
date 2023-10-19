package com.olvins.kit.dotnetdevkit.validators.misc;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;

public class InitializationValidator {
    private static final String INITIALIZATION_PATTERN = "^\\s*\\w+\\s*=.*;$";

    public void validateInitialization(String initialization) throws ConditionalException {
        if (!initialization.matches(INITIALIZATION_PATTERN)) {
            throw new ConditionalException("Invalid initialization code: " + initialization);
        }
    }
}
