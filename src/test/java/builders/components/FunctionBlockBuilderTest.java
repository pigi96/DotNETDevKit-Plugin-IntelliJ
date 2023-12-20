package builders.components;

import com.olvins.kit.FunctionBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.FunctionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ParameterBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ObjectTypeBlock;
import org.junit.jupiter.api.Test;
import utils.BlockRealUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunctionBlockBuilderTest {
    @Test
    public void buildFunction_SingleInput_SingleInnerBlock_ReturnsCode() {
        ObjectTypeBlock objectTypeBlock = BlockRealUtils.validDefaultObjectTypeBlock();
        MemberModifierBlock memberModifierBlock = BlockRealUtils.validDefaultMemberModifierBlock();
        IdentifierBlock identifierBlock = BlockRealUtils.validDefaultIdentifierBlock();
        List<ParameterBlock> parameterBlocks = Arrays.asList(BlockRealUtils.validDefaultParameterBlock(), BlockRealUtils.validDefaultParameterBlock());
        List<Block> statementBlocks = Arrays.asList(BlockRealUtils.validDefaultStatementBlock(), BlockRealUtils.validDefaultStatementBlock());

        String expectedResult = "";

        FunctionBlock functionBlock = FunctionBlockBuilder.start()
                .objectTypeBlock(objectTypeBlock)
                .memberModifierBlock(memberModifierBlock)
                .identifierBlock(identifierBlock)
                .parameterBlocks(parameterBlocks)
                .blocks(statementBlocks)
                .build();

        assertEquals(expectedResult, functionBlock.getGeneratedFormattedCode());
    }
}
