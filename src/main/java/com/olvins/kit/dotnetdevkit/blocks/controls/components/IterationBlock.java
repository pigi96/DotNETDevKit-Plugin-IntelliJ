package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.Validators;

public class IterationBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public IterationBlock(String initialization) {
        super(CODE_TEMPLATE, BlockType.ITERATION_BLOCK, new Validators.IterationValidator(), initialization);
    }
}
