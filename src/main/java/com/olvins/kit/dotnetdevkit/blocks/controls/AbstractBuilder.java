package com.olvins.kit.dotnetdevkit.blocks.controls;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBuilder<T extends Block> {
    protected final Map<String, Object> fields = new HashMap<>();

    protected AbstractBuilder() {}

    protected void setField(String field, Object value) {
        fields.put(field, value);
    }

    protected void validate(String... requiredFields) {
        for (String requiredField : requiredFields) {
            if (!fields.containsKey(requiredField)) {
                throw new IllegalStateException("Missing field: " + requiredField);
            }
        }
    }

    public abstract T build();
}
