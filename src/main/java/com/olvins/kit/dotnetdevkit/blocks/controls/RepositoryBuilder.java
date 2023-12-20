package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.FunctionBlockBuilder;
import com.olvins.kit.IdentifierBlockBuilder;
import com.olvins.kit.MemberModifierBlockBuilder;
import com.olvins.kit.ObjectTypeBlockBuilder;
import com.olvins.kit.ParameterBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.FunctionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ParameterBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ObjectTypeBlock;
import kotlin.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Prebuilt quick built functions will be contained inside this class
 */
public class RepositoryBuilder {


    public static FunctionBlock repositoryAsyncFunction(String returnType, String identifierValue, List<Pair<String, String>> parameters, List<Block> blocks) {
        MemberModifierBlock memberModifierBlock = MemberModifierBlockBuilder.create("public virtual async");
        ObjectTypeBlock objectTypeBlock = ObjectTypeBlockBuilder.create(returnType == null ? "Task" : "Task<" + returnType + ">");
        IdentifierBlock identifierBlock = IdentifierBlockBuilder.create(identifierValue);

        List<ParameterBlock> parameterBlocks = parameters.stream()
                .map(param -> ParameterBlockBuilder.create(param.getFirst(), param.getSecond()))
                .collect(Collectors.toList());

        var block = FunctionBlockBuilder.create(memberModifierBlock, objectTypeBlock, identifierBlock, parameterBlocks, blocks);

        return block;
    }
}
