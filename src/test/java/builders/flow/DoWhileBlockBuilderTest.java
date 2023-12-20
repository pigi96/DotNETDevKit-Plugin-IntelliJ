package builders.flow;

import com.olvins.kit.DoWhileBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.DoWhileBlock;
import org.junit.jupiter.api.Test;
import utils.BlockTestUtils;
import utils.JustUtils;
import utils.SyntaxConstants;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DoWhileBlockBuilderTest {
    @Test
    public void buildDoWhileBlock_ValidInput_SingleInnerBlock_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.DO_WHILE_BLOCK, JustUtils.collectBlocks(blocks), conditionBlock.generate());

        DoWhileBlock doWhileBlock = DoWhileBlockBuilder.start()
                .conditionBlock(conditionBlock)
                .blocks(blocks)
                .build();

        assertEquals(expectedResult, doWhileBlock.generate());
    }

    @Test
    public void buildDoWhileBlock_ValidInput_MultipleInnerBlocks_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION, SyntaxConstants.VALID_INT_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.DO_WHILE_BLOCK, JustUtils.collectBlocks(blocks), conditionBlock.generate());

        DoWhileBlock doWhileBlock = DoWhileBlockBuilder.start()
                .conditionBlock(conditionBlock)
                .blocks(blocks)
                .build();

        assertEquals(expectedResult, doWhileBlock.generate());
    }
}
