package builders.complex;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IterationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.StatementBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfDecisionBlock;
import org.junit.jupiter.api.Test;
import utils.BlockRealUtils;
import utils.SyntaxConstants;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComplexCombinationsIntegrationTest {
    @Test
    public void buildComplexStatement_IncludesWhileDoForIf_ReturnsCode() {
        ConditionBlock conditionBlock = BlockRealUtils.validDefaultConditionBlock();
        InitializationBlock initializationBlock = BlockRealUtils.validDefaultInitializationBlock();
        IterationBlock iterationBlock = BlockRealUtils.validDefaultIterationBlock();
        StatementBlock statementBlock = BlockRealUtils.validDefaultStatementBlock();

        String expectedResult =
                String.format(SyntaxConstants.IF_BLOCK, conditionBlock.getCode(),
                        String.format(SyntaxConstants.FOR_BLOCK, initializationBlock.getCode(), conditionBlock.getCode(), iterationBlock.getCode(),
                                String.format(SyntaxConstants.DO_WHILE_BLOCK, String.format(SyntaxConstants.WHILE_BLOCK, conditionBlock.getCode(), SyntaxConstants.VALID_STRING_DECLARATION), conditionBlock.getCode())));

        IfDecisionBlock ifDecisionBlock = BlockRealUtils.ifBlock(conditionBlock,
                Arrays.asList(BlockRealUtils.forBlock(initializationBlock, conditionBlock, iterationBlock,
                        Arrays.asList(BlockRealUtils.doWhileBlock(conditionBlock,
                                Arrays.asList(BlockRealUtils.whileBlock(conditionBlock, Arrays.asList(statementBlock))))))));

        assertEquals(expectedResult, ifDecisionBlock.getGeneratedFormattedCode());
    }
}
