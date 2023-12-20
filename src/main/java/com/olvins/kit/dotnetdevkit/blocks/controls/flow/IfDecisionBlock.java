package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ConditionalListBlock;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;
import com.olvins.kit.dotnetdevkit.utils.Validators;

import java.util.List;

@BlockBuilder
public class IfDecisionBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.IF_DECISION_BLOCK.toString();

    public IfDecisionBlock(List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.IF_DECISION_BLOCK, new Validators.IfDecisionBlockValidator(), new ConditionalListBlock(blocks));
    }
}