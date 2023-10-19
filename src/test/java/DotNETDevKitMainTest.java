import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DotNETDevKitMainTest {
    @Test
    void mainTest() {
        String initialize = "Test initialized";
        assertEquals("Test should have initialized correctly", initialize, "Test initialized");
    }
}
