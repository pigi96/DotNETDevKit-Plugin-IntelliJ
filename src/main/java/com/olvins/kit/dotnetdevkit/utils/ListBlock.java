package com.olvins.kit.dotnetdevkit.utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListBlock extends BaseListBlock {
    public ListBlock(String separator, BlockType blockType, List<? extends Block> blocks) {
        super(separator, blockType, blocks);
    }

    public ListBlock(String separator, BlockType blockType, Block... blocks) {
        super(separator, blockType, blocks);
    }

    @Override
    public String getCode() {
        return blocks.stream()
                .map(Block::getGeneratedCode)
                .collect(Collectors.joining(separator));
    }
}
