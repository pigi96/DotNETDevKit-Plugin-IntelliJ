package builders.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IterationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.ForBlock;
import org.junit.jupiter.api.Test;
import utils.BlockTestUtils;
import utils.JustUtils;
import utils.SyntaxConstants;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForBlockBuilderTest {
    @Test
    public void buildForBlock_ValidInput_SingleInnerBlock_ReturnsCode() {
        InitializationBlock initializationBlock = BlockTestUtils.mockInitializationBlock(SyntaxConstants.VALID_INT_INITIALIZATION);
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        IterationBlock iterationBlock = BlockTestUtils.mockIterationBlock(SyntaxConstants.VALID_INT_ITERATION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.FOR_BLOCK, initializationBlock.generate(), conditionBlock.generate(), iterationBlock.generate(), JustUtils.collectBlocks(blocks));

        ForBlock forBlock = ForBlockBuilder.start()
                .withInitialization(initializationBlock)
                .withCondition(conditionBlock)
                .withIteration(iterationBlock)
                .withBlocks(blocks)
                .build();

        assertEquals(expectedResult, forBlock.getGeneratedFormattedCode());
    }

    @Test
    public void buildForBlock_ValidInput_MultipleInnerBlocks_ReturnsCode() {
        InitializationBlock initializationBlock = BlockTestUtils.mockInitializationBlock(SyntaxConstants.VALID_INT_INITIALIZATION);
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        IterationBlock iterationBlock = BlockTestUtils.mockIterationBlock(SyntaxConstants.VALID_INT_ITERATION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION, SyntaxConstants.VALID_INT_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.FOR_BLOCK, initializationBlock.generate(), conditionBlock.generate(), iterationBlock.generate(), JustUtils.collectBlocks(blocks));

        ForBlock forBlock = ForBlockBuilder.start()
                .withInitialization(initializationBlock)
                .withCondition(conditionBlock)
                .withIteration(iterationBlock)
                .withBlocks(blocks)
                .build();

        assertEquals(expectedResult, forBlock.generate());
    }
}
