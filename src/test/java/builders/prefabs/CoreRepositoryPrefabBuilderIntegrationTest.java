package builders.prefabs;

import com.olvins.kit.dotnetdevkit.blocks.controls.dot_net.prefabs.CoreRepositoryPrefabBuilder;
import org.junit.jupiter.api.Test;
import utils.BlockRealUtils;

import static org.junit.Assert.assertEquals;

public class CoreRepositoryPrefabBuilderIntegrationTest {
    @Test
    public void buildCoreRepositoryBlock_ValidSingleInput_MultipleFunctions_ReturnsCode() {
        String generatedCode = CoreRepositoryPrefabBuilder.start(BlockRealUtils.validDefaultMemberModifierBlock(), BlockRealUtils.validDefaultMemberTypeBlock(), BlockRealUtils.validDefaultIdentifierBlock())
                .withGetById()
                .generateFormattedCode();

        assertEquals("", generatedCode);
    }
}