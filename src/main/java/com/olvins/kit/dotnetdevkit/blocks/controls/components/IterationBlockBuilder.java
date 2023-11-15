package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.types.BlockType;

public class IterationBlockBuilder extends AbstractBuilder<IterationBlock> {
    private IterationBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static IterationBlockBuilder start() {
        return new IterationBlockBuilder();
    }

    public IterationBlockBuilder withValue(String iteration) {
        setField(BlockType.ITERATION_BLOCK.getValue(), iteration);
        return this;
    }

    @Override
    public IterationBlock build() {
        validate(BlockType.ITERATION_BLOCK.getValue());
        return new IterationBlock(
                (String) fields.get(BlockType.ITERATION_BLOCK.getValue())
        );
    }
}
