package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class DoWhileBlockBuilder extends AbstractBuilder<DoWhileBlock> {
    private DoWhileBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static DoWhileBlockBuilder start() {
        return new DoWhileBlockBuilder();
    }

    public DoWhileBlockBuilder withCondition(ConditionBlock conditionBlock) {
        setField(BlockType.CONDITION_BLOCK.getValue(), conditionBlock);
        return this;
    }

    public DoWhileBlockBuilder withBlocks(List<Block> blocks) {
        setField(BlockType.BLOCK.getValue(), blocks);
        return this;
    }

    @Override
    public DoWhileBlock build() {
        validate(BlockType.CONDITION_BLOCK.getValue(), BlockType.BLOCK.getValue());
        return new DoWhileBlock(
                (ConditionBlock) fields.get(BlockType.CONDITION_BLOCK.getValue()),
                (List<Block>) fields.get(BlockType.BLOCK.getValue())
        );
    }
}
