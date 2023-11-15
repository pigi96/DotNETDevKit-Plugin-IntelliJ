package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.types.BlockType;

public class ConditionBlockBuilder extends AbstractBuilder<ConditionBlock> {
    private ConditionBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static ConditionBlockBuilder start() {
        return new ConditionBlockBuilder();
    }

    public ConditionBlockBuilder withValue(String condition) {
        setField(BlockType.CONDITION_BLOCK.getValue(), condition);
        return this;
    }

    @Override
    public ConditionBlock build() {
        validate(BlockType.CONDITION_BLOCK.getValue());
        return new ConditionBlock(
                (String) fields.get(BlockType.CONDITION_BLOCK.getValue())
        );
    }
}
