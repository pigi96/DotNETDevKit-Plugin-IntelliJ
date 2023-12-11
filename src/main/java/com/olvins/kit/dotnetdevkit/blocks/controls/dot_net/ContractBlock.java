package com.olvins.kit.dotnetdevkit.blocks.controls.dot_net;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

public class ContractBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public ContractBlock(String condition) {
        super(CODE_TEMPLATE, BlockType.CONDITION_BLOCK, new Validators.ExpressionValidator(), condition);
    }
}
