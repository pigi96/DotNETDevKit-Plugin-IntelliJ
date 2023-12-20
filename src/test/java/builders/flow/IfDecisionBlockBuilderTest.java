package builders.flow;

import com.olvins.kit.ElseBlockBuilder;
import com.olvins.kit.ElseIfBlockBuilder;
import com.olvins.kit.IfBlockBuilder;
import com.olvins.kit.IfDecisionBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfDecisionBlock;
import org.junit.jupiter.api.Test;
import utils.BlockRealUtils;
import utils.BlockTestUtils;
import utils.SyntaxConstants;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IfDecisionBlockBuilderTest {
    @Test
    public void buildIfBlock_MultipleValidConditions_MultipleInnerBlocks_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = BlockTestUtils.mockBlocks(SyntaxConstants.VALID_STRING_DECLARATION);

        IfDecisionBlock ifDecisionBlock = IfDecisionBlockBuilder.start()
                .blocks(blocks)
                .build();

        assertEquals("", ifDecisionBlock.getGeneratedFormattedCode());
    }

    @Test
    public void buildIfBlock_MultipleValidConditions_MultipleInnerBlocks_IncludeElseStatement_ReturnsCode() {
        ConditionBlock conditionBlock = BlockTestUtils.mockConditionBlock(SyntaxConstants.VALID_CONDITION);
        List<Block> blocks = Arrays.asList(BlockRealUtils.validDefaultStatementBlock());

        var ifBlock = IfBlockBuilder.create(conditionBlock, blocks);
        var elseIfBlock = ElseIfBlockBuilder.create(conditionBlock, blocks);
        var elseIfBlock2 = ElseIfBlockBuilder.create(conditionBlock, blocks);
        var elseBlock = ElseBlockBuilder.create(blocks);

        IfDecisionBlock ifDecisionBlock = IfDecisionBlockBuilder.start()
                .blocks(Arrays.asList(ifBlock, elseIfBlock, elseIfBlock2, elseBlock))
                .build();

        assertEquals("", ifDecisionBlock.getGeneratedFormattedCode());
    }
}
