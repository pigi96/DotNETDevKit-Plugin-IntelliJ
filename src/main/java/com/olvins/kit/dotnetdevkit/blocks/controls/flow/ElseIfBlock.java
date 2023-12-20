package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ConditionalListBlock;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class ElseIfBlock extends Block {
    private final static String CODE_TEMPLATE = "else if (" + BlockType.CONDITION_BLOCK + ")\n" +
            "{\n" +
            BlockType.BLOCK + "\n" +
            "}";

    public ElseIfBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.ELSE_IF_BLOCK, null, conditionBlock, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
