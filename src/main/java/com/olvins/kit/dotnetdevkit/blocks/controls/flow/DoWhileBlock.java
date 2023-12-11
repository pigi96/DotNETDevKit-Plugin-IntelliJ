package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class DoWhileBlock extends Block {
    private static final String CODE_TEMPLATE = "do\n" +
                                                "{\n" +
                                                BlockType.BLOCK + "\n" +
                                                "} while (" + BlockType.CONDITION_BLOCK + ");";

    public DoWhileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.DO_WHILE_BLOCK, null, conditionBlock, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
