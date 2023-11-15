package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class DoWhileBlock extends Block {
    private static final String CODE_TEMPLATE = "do {\n" +
                                                "\t" + BlockType.BLOCK + "\n" +
                                                "} while (" + BlockType.CONDITION_BLOCK + ")";

    public DoWhileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.DO_WHILE_BLOCK, null, conditionBlock, blocks);
    }
}
