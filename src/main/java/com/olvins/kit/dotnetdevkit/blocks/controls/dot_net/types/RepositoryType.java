package com.olvins.kit.dotnetdevkit.blocks.controls.dot_net.types;

import com.olvins.kit.dotnetdevkit.types.BlockType;

public class RepositoryType extends DotNetType {
    public static final RepositoryType GET_BY_PREDICATE = new RepositoryType("{GET_BY_PREDICATE}");
    public static final RepositoryType GET_BY_ID = new RepositoryType("{GET_BY_ID}");
    public static final RepositoryType GET_ALL_BY_PREDICATE = new RepositoryType("{GET_ALL_BY_PREDICATE}");
    public static final RepositoryType GET_ALL_BY_ID = new RepositoryType("{GET_ALL_BY_ID}");
    public static final RepositoryType ADD_ENTITY = new RepositoryType("{ADD_ENTITY}");
    public static final RepositoryType UPDATE_ENTITY = new RepositoryType("{UPDATE_ENTITY}");
    public static final RepositoryType DELETE_BY_ENTITY = new RepositoryType("{DELETE_BY_ENTITY}");
    public static final RepositoryType DELETE_BY_PREDICATE = new RepositoryType("{DELETE_BY_PREDICATE}");
    public static final RepositoryType DELETE_BY_ID = new RepositoryType("{DELETE_BY_ID}");

    RepositoryType(String value) {
        super(value);
    }
}
