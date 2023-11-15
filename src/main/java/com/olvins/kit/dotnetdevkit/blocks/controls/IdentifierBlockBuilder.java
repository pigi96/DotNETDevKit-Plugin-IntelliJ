package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.Validators;

import java.util.HashMap;

public class IdentifierBlockBuilder extends AbstractBuilder<IdentifierBlock> {
    private IdentifierBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static IdentifierBlockBuilder start() {
        return new IdentifierBlockBuilder();
    }

    public IdentifierBlockBuilder withIdentifier(String identifier) {
        setField(BlockType.IDENTIFIER_BLOCK.getValue(), identifier);
        return this;
    }

    @Override
    public IdentifierBlock build() {
        validate(BlockType.IDENTIFIER_BLOCK.getValue());
        return new IdentifierBlock(
                (String) fields.get(BlockType.IDENTIFIER_BLOCK.getValue())
        );
    }
}
