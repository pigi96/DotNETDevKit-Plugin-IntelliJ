package com.olvins.kit.dotnetdevkit.types;

public class ClassModifier extends ValueBase {
    public static final ClassType PUBLIC = new ClassType("public");
    public static final ClassType PRIVATE = new ClassType("private");
    public static final ClassType PROTECTED = new ClassType("protected");
    public static final ClassType INTERNAL = new ClassType("internal");
    public static final ClassType PROTECTED_INTERNAL = new ClassType("protected internal");
    public static final ClassType PRIVATE_PROTECTED = new ClassType("private protected");

    ClassModifier(String value) {
        super(value, 0);
    }
}