package com.olvins.kit.dotnetdevkit.blocks.controls;

/**
 * Used for complexities that are built from @Block objects
 */
public abstract class Prefab<T> {
    protected AbstractBuilder parentBlock;
    protected T memory;

    protected Prefab() {
    }

    public abstract String generateFormattedCode();
}
