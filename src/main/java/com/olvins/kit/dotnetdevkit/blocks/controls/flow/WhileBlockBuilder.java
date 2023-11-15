package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class WhileBlockBuilder extends AbstractBuilder<WhileBlock> {
    private WhileBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static WhileBlockBuilder start() {
        return new WhileBlockBuilder();
    }

    public WhileBlockBuilder withCondition(ConditionBlock conditionBlock) {
        setField(BlockType.CONDITION_BLOCK.getValue(), conditionBlock);
        return this;
    }

    public WhileBlockBuilder withBlocks(List<Block> blocks) {
        setField(BlockType.BLOCK.getValue(), blocks);
        return this;
    }

    @Override
    public WhileBlock build() {
        validate(BlockType.CONDITION_BLOCK.getValue(), BlockType.BLOCK.getValue());
        return new WhileBlock(
                (ConditionBlock) fields.get(BlockType.CONDITION_BLOCK.getValue()),
                (List<Block>) fields.get(BlockType.BLOCK.getValue())
        );
    }
}
