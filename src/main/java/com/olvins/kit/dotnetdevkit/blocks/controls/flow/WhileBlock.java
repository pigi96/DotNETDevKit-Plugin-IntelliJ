package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class WhileBlock extends Block {
    private static final String CODE_TEMPLATE = "while (" + BlockType.CONDITION_BLOCK + ")\n" +
                                                "{\n" +
                                                BlockType.BLOCK + "\n" +
                                                "}";

    public WhileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.WHILE_BLOCK, null, conditionBlock, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
