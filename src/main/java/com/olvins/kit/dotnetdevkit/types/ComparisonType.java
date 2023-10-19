package com.olvins.kit.dotnetdevkit.types;

public class ComparisonType extends ValueBase {
    public static ComparisonType EQUAL = new ComparisonType("==");
    public static ComparisonType NOT_EQUAL = new ComparisonType("!=");
    public static ComparisonType GREATER_THAN = new ComparisonType(">");
    public static ComparisonType LESS_THAN = new ComparisonType("<");
    public static ComparisonType GREATER_THAN_OR_EQUAL = new ComparisonType(">=");
    public static ComparisonType LESS_THAN_OR_EQUAL = new ComparisonType("<=");

    public ComparisonType(String value) {
        super(value, 0);
    }
}
