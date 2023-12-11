package utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IterationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.DoWhileBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.ForBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.WhileBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlockTestUtils {
    public static ConditionBlock mockConditionBlock(String value) {
        ConditionBlock conditionBlock = mock(ConditionBlock.class);
        when(conditionBlock.generate()).thenReturn(value);
        when(conditionBlock.getBlockType()).thenReturn(BlockType.CONDITION_BLOCK);
        return conditionBlock;
    }

    public static List<Block> mockBlocks(String... values) {
        List<Block> blocks = new ArrayList<>();
        for (String value: values) {
            Block block = mock();
            when(block.generate()).thenReturn(value);
            when(block.getBlockType()).thenReturn(BlockType.BLOCK);
            blocks.add(block);
        }

        return blocks;
    }

    public static Block mockBlock(String value) {
        Block block = mock(Block.class);
        when(block.generate()).thenReturn(value);
        when(block.getBlockType()).thenReturn(BlockType.BLOCK);
        return block;
    }

    public static InitializationBlock mockInitializationBlock(String value) {
        InitializationBlock initializationBlock = mock(InitializationBlock.class);
        when(initializationBlock.generate()).thenReturn(value);
        when(initializationBlock.getBlockType()).thenReturn(BlockType.INITIALIZATION_BLOCK);
        return initializationBlock;
    }

    public static IterationBlock mockIterationBlock(String value) {
        IterationBlock iterationBlock = mock(IterationBlock.class);
        when(iterationBlock.generate()).thenReturn(value);
        when(iterationBlock.getBlockType()).thenReturn(BlockType.ITERATION_BLOCK);
        return iterationBlock;
    }

    public static IfBlock mockIfBlock(String value) {
        IfBlock ifBlock = mock(IfBlock.class);
        when(ifBlock.generate()).thenReturn(value);
        when(ifBlock.getBlockType()).thenReturn(BlockType.IF_BLOCK);
        return ifBlock;
    }

    public static ForBlock mockForBlock(String value) {
        ForBlock forBlock = mock(ForBlock.class);
        when(forBlock.generate()).thenReturn(value);
        when(forBlock.getBlockType()).thenReturn(BlockType.FOR_BLOCK);
        return forBlock;
    }

    public static WhileBlock mockWhileBlock(String value) {
        WhileBlock whileBlock = mock(WhileBlock.class);
        when(whileBlock.generate()).thenReturn(value);
        when(whileBlock.getBlockType()).thenReturn(BlockType.WHILE_BLOCK);
        return whileBlock;
    }

    public static DoWhileBlock mockDoWhileBlock(String value) {
        DoWhileBlock doWhileBlock = mock(DoWhileBlock.class);
        when(doWhileBlock.generate()).thenReturn(value);
        when(doWhileBlock.getBlockType()).thenReturn(BlockType.DO_WHILE_BLOCK);
        return doWhileBlock;
    }
}
