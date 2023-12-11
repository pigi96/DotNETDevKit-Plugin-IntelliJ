package com.olvins.kit.dotnetdevkit.blocks.controls.declarations;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

@BlockBuilder
public class MemberTypeBlock extends Block implements ISimpleBlock {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public MemberTypeBlock(String classType) {
        super(CODE_TEMPLATE, BlockType.MEMBER_TYPE_BLOCK, new Validators.MemberTypeValidator(), classType);
    }
}
