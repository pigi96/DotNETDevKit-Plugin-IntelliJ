package com.olvins.kit.dotnetdevkit.blocks.controls.dot_net.prefabs;

import com.olvins.kit.ClassBlockBuilder;
import com.olvins.kit.StatementBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.Prebuilt;
import com.olvins.kit.dotnetdevkit.blocks.controls.Prefab;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.FunctionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberTypeBlock;
import kotlin.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreRepositoryPrefabBuilder extends Prefab<List<Block>> {
    private CoreRepositoryPrefabBuilder() {
        // Creation only allowed through the start method
    }

    public static CoreRepositoryPrefabBuilder start(MemberModifierBlock memberModifierBlock, MemberTypeBlock memberTypeBlock, IdentifierBlock identifierBlock) {
        List<Block> blocks = new ArrayList<>();
        CoreRepositoryPrefabBuilder coreRepositoryPrefabBuilder = new CoreRepositoryPrefabBuilder();
        coreRepositoryPrefabBuilder.parentBlock = ClassBlockBuilder.start()
                .memberModifierBlock(memberModifierBlock)
                .memberTypeBlock(memberTypeBlock)
                .identifierBlock(identifierBlock)
                .blocks(blocks);

        coreRepositoryPrefabBuilder.memory = blocks;

        return coreRepositoryPrefabBuilder;
    }

    public CoreRepositoryPrefabBuilder withGetById() {
        List<Block> logic = new ArrayList<>();
        logic.add(StatementBlockBuilder.create("return await query.FirstOrDefaultAsync();"));

        Block block = Prebuilt.repositoryAsyncFunction(
                null,
                "GetById",
                Arrays.asList(new Pair<>("Expression<Func<TEntity, bool>>[]", "predicates")),
                logic
        );

        memory.add(block);
        return this;
    }

    @Override
    public String generateFormattedCode() {
        var block = parentBlock.build();
        return block.getGeneratedFormattedCode();
    }
}