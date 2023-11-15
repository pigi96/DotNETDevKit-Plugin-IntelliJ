package com.olvins.kit.dotnetdevkit.blocks.controls.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;

public class IfBlockBuilder extends AbstractBuilder<IfBlock> {
    private IfBlockBuilder() {
        // Creation only allowed through the start method
    }

    public static IfBlockBuilder start() {
        return new IfBlockBuilder();
    }

    public IfBlockBuilder withCondition(ConditionBlock conditionBlock) {
        setField(BlockType.CONDITION_BLOCK.getValue(), conditionBlock);
        return this;
    }

    public IfBlockBuilder withBlocks(List<Block> blocks) {
        setField(BlockType.BLOCK.getValue(), blocks);
        return this;
    }

    @Override
    public IfBlock build() {
        validate(BlockType.CONDITION_BLOCK.getValue(), BlockType.BLOCK.getValue());
        return new IfBlock(
                (ConditionBlock) fields.get(BlockType.CONDITION_BLOCK.getValue()),
                (List<Block>) fields.get(BlockType.BLOCK.getValue())
        );
    }
}
