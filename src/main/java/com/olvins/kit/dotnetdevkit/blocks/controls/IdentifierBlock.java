package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.Validators;

import java.util.HashMap;

public class IdentifierBlock extends Block {
    private final static String IDENTIFIER = "IDENTIFIER_BLOCK";
    private final static String CODE_TEMPLATE = "{IDENTIFIER}";

    public IdentifierBlock(String identity) {
        super(CODE_TEMPLATE, BlockType.TYPE_BLOCK, null);
    }

    protected static HashMap<String, Object> modifyIndex(String identity) {
        new Validators.IdentifierValidator().validate(identity);

        HashMap<String, Object> index = new HashMap<>();
        index.replace("{IDENTIFIER}", identity);

        return index;
    }
}