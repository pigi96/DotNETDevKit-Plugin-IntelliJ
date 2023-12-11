package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

import java.util.HashMap;

public class DeclarationBlock extends Block {
    private final static String IDENTIFIER = "DECLARATION_BLOCK";
    private final static String CODE_TEMPLATE = "{DECLARATION}";

    public DeclarationBlock(String initialization) throws ConditionalException {
        super(CODE_TEMPLATE, BlockType.TYPE_BLOCK, null);
    }

    protected static HashMap<String, Object> modifyIndex(String initialization) throws ConditionalException {
        new Validators.DeclarationValidator().validate(initialization);

        HashMap<String, Object> index = new HashMap<>();
        index.replace("{INITIALIZATION}", initialization);

        return index;
    }
}
