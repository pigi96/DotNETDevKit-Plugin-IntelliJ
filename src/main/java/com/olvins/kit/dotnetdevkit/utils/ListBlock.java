package com.olvins.kit.dotnetdevkit.utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.Arrays;
import java.util.List;

public class ListBlock {
    private List<? extends Block> blocks;
    private String separator;
    private BlockType blockType;

    public ListBlock(String separator, BlockType blockType, List<? extends Block> blocks) {
        this.blocks = blocks;
        this.separator = separator;
        this.blockType = blockType;
    }

    public ListBlock(String separator, BlockType blockType, Block... blocks) {
        this.blocks = Arrays.asList(blocks);
        this.separator = separator;
        this.blockType = blockType;
    }

    public List<? extends Block> getList() {
        return blocks;
    }

    public String getSeparator() {
        return separator;
    }

    public BlockType getBlockType() {
        return blockType;
    }
}
