package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.types.ValueBase;

import java.util.HashMap;

public class TypeBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public TypeBlock(String type) {
        super(CODE_TEMPLATE, BlockType.TYPE_BLOCK, null, type);
    }
}
