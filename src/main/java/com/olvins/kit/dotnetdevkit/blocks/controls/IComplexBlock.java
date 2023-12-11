package com.olvins.kit.dotnetdevkit.blocks.controls;

public interface IComplexBlock<T extends Block> {
    T create(Object... params);
}
