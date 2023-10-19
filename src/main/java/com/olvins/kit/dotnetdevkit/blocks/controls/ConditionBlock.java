package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.validators.Validator;

import java.util.HashMap;

public class ConditionBlock extends Code {
    private final static String CODE_TEMPLATE = "{CONDITION}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{CONDITION}", "{CONDITION}");
    }};

    public ConditionBlock(String condition) throws ConditionalException {
        super(CODE_TEMPLATE, modifyIndex(condition));
    }

    protected static HashMap<String, Object> modifyIndex(String condition) throws ConditionalException {
        Validator.validateExpression(condition);

        index.replace("{CONDITION}", condition);

        return index;
    }
}
