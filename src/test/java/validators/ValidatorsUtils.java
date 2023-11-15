package validators;

import com.olvins.kit.dotnetdevkit.validators.IValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorsUtils {
    public static void validateValueSuccess(String value, String message, IValidator validator) {
        try {
            validator.validate(value);
        } catch (Exception e) {
            fail(String.format(message, value));
        }
    }

    public static <T> void validateValueFailure(String value, String message, IValidator validator) {
        Exception exception = assertThrows(Exception.class, () -> validator.validate(value), String.format(message, value));
    }
}
