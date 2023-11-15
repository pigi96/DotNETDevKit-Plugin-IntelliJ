package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class IfBlock extends Block {
    private final static String CODE_TEMPLATE = "if (" + BlockType.CONDITION_BLOCK + ") {\n" +
                                                "\t" + BlockType.BLOCK + "\n" +
                                                "}";

    IfBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.IF_BLOCK, null, conditionBlock, blocks);
    }
}
