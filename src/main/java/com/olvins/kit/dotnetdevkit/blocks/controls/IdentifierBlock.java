package com.olvins.kit.dotnetdevkit.blocks.controls;

import java.util.HashMap;

public class IdentifierBlock extends Code {
    private final static String CODE_TEMPLATE = "{IDENTIFIER}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{IDENTIFIER}", "{IDENTIFIER}");
    }};

    public IdentifierBlock(String identity) {
        super(CODE_TEMPLATE, modifyIndex(identity));
    }

    protected static HashMap<String, Object> modifyIndex(String identity) {
        index.replace("{IDENTIFIER}", identity);

        return index;
    }
}