package com.olvins.kit.dotnetdevkit.types;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ValueBase {
    private String value;
    private int order;
    private static final Map<String, ValueBase> VALUES = new ConcurrentHashMap<>();

    public ValueBase() {}

    public ValueBase(String value, int order) {
        this.value = value;
        this.order = order;

        VALUES.put(value, this);
    }

    public String getValue() {
        return this.value;
    }

    public int getOrder() {
        return this.order;
    }

    public static Optional<ValueBase> getByValue(String value) {
        return Optional.ofNullable(VALUES.get(value));
    }

    public static boolean validate(String value) {
        return VALUES.get(value) != null;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
