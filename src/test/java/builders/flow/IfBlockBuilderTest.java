package builders.flow;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfBlock;
import org.junit.jupiter.api.Test;
import utils.BlockTestUtils;
import utils.JustUtils;
import utils.SyntaxConstants;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IfBlockBuilderTest {
    @Test
    public void buildIfBlock_ValidInput_SingleInnerBlock_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.IF_BLOCK, conditionBlock.generate(), JustUtils.collectBlocks(blocks));

        IfBlock ifBlock = IfBlockBuilder.start()
                .withCondition(conditionBlock)
                .withBlocks(blocks)
                .build();

        assertEquals(expectedResult, ifBlock.generate());
    }

    @Test
    public void buildIfBlock_ValidInput_MultipleInnerBlocks_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION, SyntaxConstants.VALID_INT_DECLARATION);

        String expectedResult = String.format(SyntaxConstants.IF_BLOCK, conditionBlock.generate(), JustUtils.collectBlocks(blocks));

        IfBlock ifBlock = IfBlockBuilder.start()
                .withCondition(conditionBlock)
                .withBlocks(blocks)
                .build();

        assertEquals(expectedResult, ifBlock.generate());
    }
}
