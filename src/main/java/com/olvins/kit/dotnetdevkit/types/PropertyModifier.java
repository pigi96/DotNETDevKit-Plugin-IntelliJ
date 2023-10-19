package com.olvins.kit.dotnetdevkit.types;

public class PropertyModifier extends ValueBase {
    public static final PropertyModifier PUBLIC = new PropertyModifier("public", 0);
    public static final PropertyModifier PRIVATE = new PropertyModifier("private", 0);
    public static final PropertyModifier PROTECTED = new PropertyModifier("protected", 0);
    public static final PropertyModifier INTERNAL = new PropertyModifier("internal", 0);
    public static final PropertyModifier PROTECTED_INTERNAL = new PropertyModifier("protected internal", 0);
    public static final PropertyModifier PRIVATE_PROTECTED = new PropertyModifier("private protected", 0);
    public static final PropertyModifier STATIC = new PropertyModifier("static", 1);
    public static final PropertyModifier VIRTUAL = new PropertyModifier("virtual", 1);
    public static final PropertyModifier OVERRIDE = new PropertyModifier("override", 2);
    public static final PropertyModifier ABSTRACT = new PropertyModifier("abstract", 2);
    public static final PropertyModifier READONLY = new PropertyModifier("readonly", 3);
    public static final PropertyModifier EXTERN = new PropertyModifier("extern", 4);

    PropertyModifier(String value, int order) {
        super(value, order);
    }
}