package utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.IterationBlock;
import com.olvins.kit.dotnetdevkit.types.BlockType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlockTestUtils {
    public static ConditionBlock mockConditionBlock(String value) {
        ConditionBlock conditionBlock = mock(ConditionBlock.class);
        when(conditionBlock.value()).thenReturn(value);
        when(conditionBlock.getBlockType()).thenReturn(BlockType.CONDITION_BLOCK);
        return conditionBlock;
    }

    public static List<Block> mockBlocks(String... values) {
        List<Block> blocks = new ArrayList<>();
        for (String value: values) {
            Block block = mock();
            when(block.value()).thenReturn(value);
            when(block.getBlockType()).thenReturn(BlockType.BLOCK);
            blocks.add(block);
        }

        return blocks;
    }

    public static Block mockBlock(String value) {
        Block block = mock(Block.class);
        when(block.value()).thenReturn(value);
        when(block.getBlockType()).thenReturn(BlockType.BLOCK);
        return block;
    }

    public static InitializationBlock mockInitializationBlock(String value) {
        InitializationBlock initializationBlock = mock(InitializationBlock.class);
        when(initializationBlock.value()).thenReturn(value);
        when(initializationBlock.getBlockType()).thenReturn(BlockType.INITIALIZATION_BLOCK);
        return initializationBlock;
    }

    public static IterationBlock mockIterationBlock(String value) {
        IterationBlock iterationBlock = mock(IterationBlock.class);
        when(iterationBlock.value()).thenReturn(value);
        when(iterationBlock.getBlockType()).thenReturn(BlockType.ITERATION_BLOCK);
        return iterationBlock;
    }
}
