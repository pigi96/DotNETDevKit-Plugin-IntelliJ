package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.Validators;

public class ConditionBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public ConditionBlock(String condition) {
        super(CODE_TEMPLATE, BlockType.CONDITION_BLOCK, new Validators.ExpressionValidator(), condition);
    }
}
