package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.validators.Validator;

import java.util.HashMap;

public class InitializationBlock extends Code {
    private final static String CODE_TEMPLATE = "{INITIALIZATION}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{INITIALIZATION}", "{INITIALIZATION}");
    }};

    public InitializationBlock(String condition) throws ConditionalException {
        super(CODE_TEMPLATE, modifyIndex(condition));
    }

    protected static HashMap<String, Object> modifyIndex(String condition) throws ConditionalException {
        isValid(condition);

        index.replace("{INITIALIZATION}", condition);

        return index;
    }

    private static void isValid(String condition) throws ConditionalException {
        Validator.validateInitialization(condition);
    }
}
