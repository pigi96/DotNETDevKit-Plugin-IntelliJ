package com.olvins.kit.dotnetdevkit.utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.ElseIfBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.List;
import java.util.stream.Collectors;

public class ConditionalListBlock extends BaseListBlock {
    public ConditionalListBlock(List<? extends Block> blocks) {
        super("\n", BlockType.IF_DECISION_BLOCK, blocks);
    }

    public ConditionalListBlock(Block... blocks) {
        super("\n", BlockType.IF_DECISION_BLOCK, blocks);
    }

    @Override
    public String getCode() {
        return blocks.stream()
                .map(Block::getGeneratedCode)
                .collect(Collectors.joining(separator));
    }
}
