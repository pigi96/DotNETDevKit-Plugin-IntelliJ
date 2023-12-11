package com.olvins.kit.dotnetdevkit.blocks.controls.declarations;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

import java.util.HashMap;

@BlockBuilder
public class IdentifierBlock extends Block implements ISimpleBlock {
    private final static String CODE_TEMPLATE = BlockType.STRING_BLOCK.getValue();

    public IdentifierBlock(String identifier) {
        super(CODE_TEMPLATE, BlockType.IDENTIFIER_BLOCK, new Validators.IdentifierValidator(), identifier);
    }
}