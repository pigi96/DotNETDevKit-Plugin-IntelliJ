package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.types.BlockType;

public class InitializationBlockBuilder extends AbstractBuilder<InitializationBlock> {
    private InitializationBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static InitializationBlockBuilder start() {
        return new InitializationBlockBuilder();
    }

    public InitializationBlockBuilder withValue(String initialization) {
        setField(BlockType.INITIALIZATION_BLOCK.getValue(), initialization);
        return this;
    }

    @Override
    public InitializationBlock build() {
        validate(BlockType.INITIALIZATION_BLOCK.getValue());
        return new InitializationBlock(
                (String) fields.get(BlockType.INITIALIZATION_BLOCK.getValue())
        );
    }
}
