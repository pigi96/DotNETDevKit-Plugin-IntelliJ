package com.olvins.kit.dotnetdevkit.blocks.controls.declarations;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.types.ValueBase;

@BlockBuilder
public class ObjectTypeBlock extends Block implements ISimpleBlock {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public ObjectTypeBlock(String objectType) {
        super(CODE_TEMPLATE, BlockType.OBJECT_TYPE_BLOCK, null, objectType);
    }
}
