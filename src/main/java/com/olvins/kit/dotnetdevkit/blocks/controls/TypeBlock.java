package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.types.ValueBase;

import java.util.HashMap;

public class TypeBlock<T extends ValueBase> extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public TypeBlock(T type) {
        super(CODE_TEMPLATE, BlockType.TYPE_BLOCK, null, type.getValue());
    }
}
