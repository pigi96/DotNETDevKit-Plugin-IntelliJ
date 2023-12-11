package builders.declarations;

import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberTypeBlock;
import com.olvins.kit.dotnetdevkit.errors.ExpressionException;
import org.junit.jupiter.api.Test;
import utils.SyntaxConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberTypeBlockBuilderTest {
    private final static String MEMBER_TYPE_VALID = "Member type %s should be valid";
    private final static String MEMBER_TYPE_INVALID = "Member type %s should be invalid";

    @Test
    public void buildMemberTypeBlock_ValidInput_ReturnsCode() {
        String expectedResult = String.format(SyntaxConstants.VALID_MEMBER_TYPE);

        MemberTypeBlock memberTypeBlock = MemberTypeBlockBuilder.start()
                .withValue(SyntaxConstants.VALID_MEMBER_TYPE)
                .build();

        assertEquals(String.format(MEMBER_TYPE_VALID, SyntaxConstants.VALID_MEMBER_TYPE), expectedResult, memberTypeBlock.getGeneratedFormattedCode());
    }

    @Test
    public void buildMemberTypeBlock_InvalidInput_ThrowsException() {
        Exception exception = assertThrows(ExpressionException.class, () -> {
            MemberTypeBlock memberModifierBlock = MemberTypeBlockBuilder.start()
                    .withValue(SyntaxConstants.INVALID_MEMBER_TYPE)
                    .build();

            memberModifierBlock.getGeneratedFormattedCode();
        });

        assertEquals(String.format(MEMBER_TYPE_INVALID, SyntaxConstants.INVALID_MEMBER_MODIFIER), ExpressionException.class, exception.getClass());
    }
}
