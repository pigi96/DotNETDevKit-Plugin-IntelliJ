package com.olvins.kit.dotnetdevkit.types;

public class ClassType extends ValueBase {
    public static final ClassType CLASS = new ClassType("class");
    public static final ClassType STRUCT = new ClassType("struct");
    public static final ClassType INTERFACE = new ClassType("interface");
    public static final ClassType ENUM = new ClassType("enum");
    public static final ClassType DELEGATE = new ClassType("delegate");

    ClassType(String value) {
        super(value, 0);
    }
}