package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;

import java.util.HashMap;

public class IfBlock extends Code {
    private final static String CODE_TEMPLATE = "IF ({CONDITION}) {" +
                                                "   {CODE}" +
                                                "}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{CONDITION}", new ConditionBlock("null"));
        put("{CODE}", new Code(null, null));
    }};

    public IfBlock(ConditionBlock conditionBlock, Code code) {
        super(CODE_TEMPLATE, index);
    }

    protected static HashMap<String, Object> modifyIndex(ConditionBlock conditionBlock, Code code) throws ConditionalException {
        index.replace("{CONDITION}", conditionBlock);
        index.replace("{CODE}", code);

        return index;
    }
}
