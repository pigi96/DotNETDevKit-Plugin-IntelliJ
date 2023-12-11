package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ObjectTypeBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.Validators;

@BlockBuilder
public class ParameterBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.OBJECT_TYPE_BLOCK.getValue() + " " + BlockType.IDENTIFIER_BLOCK.getValue();

    public ParameterBlock(ObjectTypeBlock objectTypeBlock, IdentifierBlock identifierBlock) {
        super(CODE_TEMPLATE, BlockType.PARAMETER_BLOCK, new Validators.ExpressionValidator(), objectTypeBlock, identifierBlock);
    }
}
