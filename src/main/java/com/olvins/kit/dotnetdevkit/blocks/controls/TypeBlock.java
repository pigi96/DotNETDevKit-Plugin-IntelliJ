package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.ValueBase;

import java.util.HashMap;

public class TypeBlock<T extends ValueBase> extends Code {
    private final static String CODE_TEMPLATE = "{TYPE}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{TYPE}", "{TYPE}");
    }};

    public TypeBlock(T type) {
        super(CODE_TEMPLATE, modifyIndex(type));
    }

    protected static HashMap<String, Object> modifyIndex(ValueBase type) {
        index.replace("{TYPE}", type.getValue());

        return index;
    }
}
