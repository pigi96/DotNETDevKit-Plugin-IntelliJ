package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import org.ini4j.Ini;

import java.util.HashMap;
import java.util.List;

public class ForBlock extends Block {
    private static final String CODE_TEMPLATE = "for (" + BlockType.INITIALIZATION_BLOCK + "; " + BlockType.CONDITION_BLOCK + "; " + BlockType.ITERATION_BLOCK + ") {\n" +
                                                "\t" + BlockType.BLOCK + "\n" +
                                                "}";

    public ForBlock(InitializationBlock initializationBlock, ConditionBlock conditionBlock, IterationBlock iterationBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.FOR_BLOCK, null, initializationBlock, conditionBlock, iterationBlock, blocks);
    }
}
