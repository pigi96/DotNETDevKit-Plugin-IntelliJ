package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;

import java.util.HashMap;

public class ForBlock extends Code {
    private final static String CODE_TEMPLATE = "FOR ({INITIALIZATION}; {CONDITION}; {ITERATION}) {" +
                                                "   {CODE}" +
                                                "}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{CONDITION}", new ConditionBlock("null"));
        put("{CODE}", new Code(null, null));
    }};

    public ForBlock(ConditionBlock conditionBlock, Code code) {
        super(CODE_TEMPLATE, modifyIndex(conditionBlock, code));
    }

    protected static HashMap<String, Object> modifyIndex(ConditionBlock conditionBlock, Code code) throws ConditionalException {
        index.replace("{CONDITION}", conditionBlock);
        index.replace("{CODE}", code);

        return index;
    }
}
