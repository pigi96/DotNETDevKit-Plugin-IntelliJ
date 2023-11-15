package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.HashMap;
import java.util.List;

public class ForBlockBuilder extends AbstractBuilder<ForBlock> {
    private ForBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static ForBlockBuilder start() {
        return new ForBlockBuilder();
    }

    public ForBlockBuilder withInitialization(InitializationBlock initializationBlock) {
        setField(BlockType.INITIALIZATION_BLOCK.getValue(), initializationBlock);
        return this;
    }

    public ForBlockBuilder withCondition(ConditionBlock conditionBlock) {
        setField(BlockType.CONDITION_BLOCK.getValue(), conditionBlock);
        return this;
    }

    public ForBlockBuilder withIteration(IterationBlock iterationBlock) {
        setField(BlockType.ITERATION_BLOCK.getValue(), iterationBlock);
        return this;
    }

    public ForBlockBuilder withBlocks(List<Block> blocks) {
        setField(BlockType.BLOCK.getValue(), blocks);
        return this;
    }

    @Override
    public ForBlock build() {
        validate(BlockType.INITIALIZATION_BLOCK.getValue(), BlockType.CONDITION_BLOCK.getValue(), BlockType.ITERATION_BLOCK.getValue(), BlockType.BLOCK.getValue());
        return new ForBlock(
                (InitializationBlock) fields.get(BlockType.INITIALIZATION_BLOCK.getValue()),
                (ConditionBlock) fields.get(BlockType.CONDITION_BLOCK.getValue()),
                (IterationBlock) fields.get(BlockType.ITERATION_BLOCK.getValue()),
                (List<Block>) fields.get(BlockType.BLOCK.getValue())
        );
    }
}
