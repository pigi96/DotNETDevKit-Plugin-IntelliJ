package utils;

import com.olvins.kit.ForBlockBuilder;
import com.olvins.kit.FunctionBlockBuilder;
import com.olvins.kit.IfDecisionBlockBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class JsonBuilderInputTest {
    @Test
    public void createJsonInput_FunctionBlock_ReturnsSuccess() {
        Assert.assertEquals("", FunctionBlockBuilder.jsonInput());
    }

    @Test
    public void createJsonInput_IfDecisionBlock_ReturnsSuccess() {
        Assert.assertEquals("", IfDecisionBlockBuilder.jsonInput());
    }

    @Test
    public void createJsonInput_ForBlock_ReturnsSuccess() {
        Assert.assertEquals("", ForBlockBuilder.jsonInput());
    }
}
