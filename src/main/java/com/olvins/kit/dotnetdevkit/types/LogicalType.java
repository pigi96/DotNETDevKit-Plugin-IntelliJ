package com.olvins.kit.dotnetdevkit.types;

public class LogicalType extends ValueBase {
    public static LogicalType AND = new LogicalType("&&");
    public static LogicalType OR = new LogicalType("||");
    public static LogicalType NOT = new LogicalType("!");

    public LogicalType(String value) {
        super(value, 0);
    }
}
