package com.olvins.kit.dotnetdevkit.types;

public class ConstructorModifier extends ValueBase {
    public static final ConstructorModifier PUBLIC = new ConstructorModifier("public", 0);
    public static final ConstructorModifier PRIVATE = new ConstructorModifier("private", 0);
    public static final ConstructorModifier PROTECTED = new ConstructorModifier("protected", 0);
    public static final ConstructorModifier INTERNAL = new ConstructorModifier("internal", 0);
    public static final ConstructorModifier PROTECTED_INTERNAL = new ConstructorModifier("protected internal", 0);
    public static final ConstructorModifier PRIVATE_INTERNAL = new ConstructorModifier("private protected", 0);
    public static final ConstructorModifier STATIC = new ConstructorModifier("static", 1);
    public static final ConstructorModifier EXTERN = new ConstructorModifier("extern", 2);

    ConstructorModifier(String value, int order) {
        super(value, order);
    }
}
