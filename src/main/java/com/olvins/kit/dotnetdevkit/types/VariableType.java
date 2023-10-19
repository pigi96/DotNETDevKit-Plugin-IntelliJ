package com.olvins.kit.dotnetdevkit.types;

public class VariableType extends ValueBase {
    public static final VariableType STRING = new VariableType("string", 0);
    public static final VariableType INT = new VariableType("int", 0);
    public static final VariableType LONG = new VariableType("long", 0);
    public static final VariableType DOUBLE = new VariableType("double", 0);
    public static final VariableType FLOAT = new VariableType("float", 0);
    public static final VariableType DECIMAL = new VariableType("decimal", 0);
    public static final VariableType BYTE = new VariableType("byte", 0);
    public static final VariableType SBYTE = new VariableType("sbyte", 0);
    public static final VariableType SHORT = new VariableType("short", 0);
    public static final VariableType USHORT = new VariableType("ushort", 0);
    public static final VariableType UINT = new VariableType("uint", 0);
    public static final VariableType ULONG = new VariableType("ulong", 0);
    public static final VariableType CHAR = new VariableType("char", 0);
    public static final VariableType BOOL = new VariableType("bool", 0);
    public static final VariableType OBJECT = new VariableType("object", 0);
    public static final VariableType DATE_TIME = new VariableType("DateTime", 0);

    VariableType(String value, int order) {
        super(value, order);
    }
}
