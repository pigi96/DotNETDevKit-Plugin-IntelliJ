package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberTypeBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class ClassBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.MEMBER_MODIFIER_BLOCK.getValue() + " " + BlockType.MEMBER_TYPE_BLOCK.getValue() + " " + BlockType.IDENTIFIER_BLOCK + "\n" +
            "{\n" +
            BlockType.BLOCK + "\n" +
            "}";

    public ClassBlock(MemberModifierBlock memberModifierBlock, MemberTypeBlock memberTypeBlock, IdentifierBlock identifierBlock, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.CLASS_BLOCK, null, memberModifierBlock, memberTypeBlock, identifierBlock, new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
