package com.olvins.kit.dotnetdevkit.types;

public class BlockType extends ValueBase {
    public static final BlockType BLOCK = new BlockType("{BLOCK}");
    public static final BlockType CLASS_BLOCK = new BlockType("{CLASS_BLOCK}");
    public static final BlockType CONDITION_BLOCK = new BlockType("{CONDITION_BLOCK}");
    public static final BlockType SWITCH_BLOCK = new BlockType("{SWITCH_BLOCK}");
    public static final BlockType DECLARATION_BLOCK = new BlockType("{DECLARATION_BLOCK}");
    public static final BlockType IDENTIFIER_BLOCK = new BlockType("{IDENTIFIER_BLOCK}");
    public static final BlockType IF_BLOCK = new BlockType("{IF_BLOCK}");
    public static final BlockType FOR_BLOCK = new BlockType("{FOR_BLOCK}");
    public static final BlockType WHILE_BLOCK = new BlockType("{WHILE_BLOCK}");
    public static final BlockType DO_WHILE_BLOCK = new BlockType("{DO_WHILE_BLOCK}");
    public static final BlockType TYPE_BLOCK = new BlockType("{TYPE_BLOCK}");
    public static final BlockType STRING_BLOCK = new BlockType("{STRING_BLOCK}");
    public static final BlockType TYPE_CLASS_MODIFIER_BLOCK = new BlockType("{CLASS_MODIFIER_BLOCK}");
    public static final BlockType TYPE_CLASS_TYPE_BLOCK = new BlockType("{CLASS_TYPE_BLOCK}");
    public static final BlockType INITIALIZATION_BLOCK = new BlockType("{INITIALIZATION_BLOCK}");
    public static final BlockType ITERATION_BLOCK = new BlockType("{ITERATION_BLOCK}");

    BlockType(String value) {
        super(value, 0);
    }
}
