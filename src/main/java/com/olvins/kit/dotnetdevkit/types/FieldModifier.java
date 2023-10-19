package com.olvins.kit.dotnetdevkit.types;

public class FieldModifier extends ValueBase {
    public static final FieldModifier PUBLIC = new FieldModifier("public", 0);
    public static final FieldModifier PRIVATE = new FieldModifier("private", 0);
    public static final FieldModifier PROTECTED = new FieldModifier("protected", 0);
    public static final FieldModifier INTERNAL = new FieldModifier("internal", 0);
    public static final FieldModifier PROTECTED_INTERNAL = new FieldModifier("protected internal", 0);
    public static final FieldModifier PRIVATE_PROTECTED = new FieldModifier("private protected", 0);
    public static final FieldModifier STATIC = new FieldModifier("static", 1);
    public static final FieldModifier READONLY = new FieldModifier("readonly", 1);
    public static final FieldModifier CONST = new FieldModifier("const", 1);
    public static final FieldModifier VOLATILE = new FieldModifier("volatile", 2);
    public static final FieldModifier FIXED = new FieldModifier("fixed", 3);

    FieldModifier(String value, int order) {
        super(value, order);
    }
}
