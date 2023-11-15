package utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SyntaxConstants {
    // Blocks expected codes
    public static final String IF_BLOCK = "if (%s) {\n\t%s\n}";
    public static final String FOR_BLOCK = "for (%s; %s; %s) {\n\t%s\n}";
    public static final String WHILE_BLOCK = "while (%s) {\n\t%s\n}";
    public static final String DO_WHILE_BLOCK = "do {\n\t%s\n} while (%s)";

    // Conditions
    public static final String VALID_CONDITION = "x > 0";
    public static final String ANOTHER_VALID_CONDITION = "y == 5";
    public static final String INVALID_CONDITION = "x >";
    public static final String NULL_CONDITION = null;

    // Declarations
    public static final String VALID_INT_DECLARATION = "int x = 10;";
    public static final String VALID_STRING_DECLARATION = "String name = \"John Doe\";";
    public static final String INVALID_DECLARATION = "int = 10;"; // Missing variable name
    public static final String NULL_DECLARATION = null;

    // Initialization
    public static final String VALID_INT_INITIALIZATION = "int x = 10";
    public static final String INVALID_INT_INITIALIZATION = "int x =";

    // Iteration
    public static final String VALID_INT_ITERATION = "x++";
    public static final String INVALID_INT_ITERATION = "x +=";
}
