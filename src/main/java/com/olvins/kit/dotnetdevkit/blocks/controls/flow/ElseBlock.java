package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class ElseBlock extends Block {
    private final static String CODE_TEMPLATE = "else\n" +
            "{\n" +
            BlockType.BLOCK + "\n" +
            "}";

    public ElseBlock(List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.ELSE_BLOCK, null, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
