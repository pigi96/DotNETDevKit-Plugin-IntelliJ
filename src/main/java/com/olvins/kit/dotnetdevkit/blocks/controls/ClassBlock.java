package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.ClassModifier;

import java.util.HashMap;

public class ClassBlock extends Code {
    private final static String CODE_TEMPLATE = "{CLASS_MODIFIER} class {IDENTIFIER} {" +
            "   {CODE}" +
            "}";

    private final static HashMap<String, Object> index = new HashMap<>() {{
        put("{CLASS_MODIFIER}", new TypeBlock<ClassModifier>(null));
        put("{IDENTIFIER}", new IdentifierBlock(null));
        put("{CODE}", new Code(null, null));
    }};

    public ClassBlock(TypeBlock<ClassModifier> classModifierTypeBlock, IdentifierBlock identifierBlock, Code code) {
        super(CODE_TEMPLATE, modifyIndex(classModifierTypeBlock, identifierBlock, code));
    }

    protected static HashMap<String, Object> modifyIndex(TypeBlock<ClassModifier> classModifierTypeBlock, IdentifierBlock identifierBlock, Code code) {
        index.replace("{CLASS_MODIFIER}", classModifierTypeBlock);
        index.replace("{IDENTIFIER}", identifierBlock);
        index.replace("{CODE}", code);

        return index;
    }
}
