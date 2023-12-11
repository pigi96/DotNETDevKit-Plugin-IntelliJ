package com.olvins.kit.dotnetdevkit.blocks.controls.components;

import annotations.BlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberTypeBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ObjectTypeBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.List;

@BlockBuilder
public class FunctionBlock extends Block {
    private final static String CODE_TEMPLATE = BlockType.MEMBER_MODIFIER_BLOCK.getValue() + " " + BlockType.OBJECT_TYPE_BLOCK.getValue() + " " + BlockType.IDENTIFIER_BLOCK + "(" + BlockType.PARAMETER_BLOCK + ")\n" +
            "{\n" +
            BlockType.BLOCK + "\n" +
            "}";

    public FunctionBlock(MemberModifierBlock memberModifierBlock, ObjectTypeBlock objectTypeBlock, IdentifierBlock identifierBlock, List<ParameterBlock> parameterBlocks, List<Block> blocks) {
        super(CODE_TEMPLATE, BlockType.FUNCTION_BLOCK, null, memberModifierBlock, objectTypeBlock, identifierBlock, new ListBlock(", ", BlockType.PARAMETER_BLOCK, parameterBlocks), new ListBlock("\n", BlockType.BLOCK, blocks));
    }
}
