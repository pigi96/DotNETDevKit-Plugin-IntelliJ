package com.olvins.kit.dotnetdevkit.blocks.controls.declarations;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

@BlockBuilder
public class StatementBlock extends Block implements ISimpleBlock {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public StatementBlock(String condition) {
        super(CODE_TEMPLATE, BlockType.STATEMENT_BLOCK, new Validators.StatementValidator(), condition);
    }
}
