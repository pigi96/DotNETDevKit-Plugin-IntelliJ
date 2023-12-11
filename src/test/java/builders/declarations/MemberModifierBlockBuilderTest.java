package builders.declarations;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberModifierBlockBuilderTest {
    private final static String MEMBER_MODIFIER_VALID = "Member modifier %s should be valid";
    private final static String MEMBER_MODIFIER_INVALID = "Member modifier %s should be invalid";

    @Test
    public void buildMemberModifierBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_MEMBER_MODIFIER);

        MemberModifierBlock memberModifierBlock = MemberModifierBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_MEMBER_MODIFIER)
                .build();

        assertEquals(String.format(MEMBER_MODIFIER_VALID, SyntaxConstants.VALID_MEMBER_MODIFIER), expectedResult, memberModifierBlock.getGeneratedFormattedCode());
    }

    @Test
    public void buildMemberModifierBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            MemberModifierBlock memberModifierBlock = MemberModifierBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_MEMBER_MODIFIER)
                    .build();

            memberModifierBlock.getGeneratedFormattedCode();
        });

        assertEquals(String.format(MEMBER_MODIFIER_INVALID, SyntaxConstants.INVALID_MEMBER_MODIFIER), ExpressionException.class, exception.getClass());
    }
}
