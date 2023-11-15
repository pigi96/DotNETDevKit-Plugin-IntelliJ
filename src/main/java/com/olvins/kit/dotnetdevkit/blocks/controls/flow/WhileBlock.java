package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class WhileBlock extends Block {
    private static final String CODE_TEMPLATE = "while (" + BlockType.CONDITION_BLOCK + ") {\n" +
                                                "\t" + BlockType.BLOCK + "\n" +
                                                "}";

    public WhileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.WHILE_BLOCK, null, conditionBlock, blocks);
    }
}
