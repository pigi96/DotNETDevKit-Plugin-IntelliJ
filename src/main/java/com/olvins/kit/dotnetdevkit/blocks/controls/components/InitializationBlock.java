package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.Validators;

public class InitializationBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public InitializationBlock(String initialization) {
        super(CODE_TEMPLATE, BlockType.INITIALIZATION_BLOCK, new Validators.InitializationValidator(), initialization);
    }
}
