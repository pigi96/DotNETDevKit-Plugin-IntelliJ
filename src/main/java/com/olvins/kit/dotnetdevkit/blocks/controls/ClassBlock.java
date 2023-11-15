package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.types.ClassModifier;
import com.olvins.kit.dotnetdevkit.types.ClassType;

import java.util.HashMap;

public class ClassBlock extends Block {
    private final static String CODE_TEMPLATE = "{CLASS_MODIFIER} {CLASS_TYPE} {IDENTIFIER} {\n" +
            "\t{CODE}\n" +
            "}";

    public ClassBlock(TypeBlock<ClassModifier> classModifierTypeBlock, TypeBlock<ClassType> classTypeTypeBlock, IdentifierBlock identifierBlock, Block block) {
        super(CODE_TEMPLATE, BlockType.IDENTIFIER_BLOCK, null);
    }

    protected static HashMap<String, Object> modifyIndex(TypeBlock<ClassModifier> classModifierTypeBlock, IdentifierBlock identifierBlock, Block block) {
        HashMap<String, Object> index = new HashMap<>();
        index.replace("{CLASS_MODIFIER}", classModifierTypeBlock);
        index.replace("{IDENTIFIER}", identifierBlock);
        index.replace("{CODE}", block);

        return index;
    }
}
