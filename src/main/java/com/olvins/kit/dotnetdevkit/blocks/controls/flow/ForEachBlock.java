package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IterationBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class ForEachBlock extends Block {
    private static final String CODE_TEMPLATE = "foreach (" + BlockType.TYPE_BLOCK + " " + BlockType.IDENTIFIER_BLOCK + " in " + BlockType.IDENTIFIER_BLOCK + ")\n" +
                                                "{\n" +
                                                BlockType.BLOCK + "\n" +
                                                "}";

    public ForEachBlock(InitializationBlock initializationBlock, ConditionBlock conditionBlock, IterationBlock iterationBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.FOR_EACH_BLOCK, null, initializationBlock, conditionBlock, iterationBlock, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
