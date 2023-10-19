package com.olvins.kit.dotnetdevkit.types;

public enum CodeVariables {
    CODE("CODE"),
    ACCESS_MODIFIER("ACCESS_MODIFIER"),
    IDENTIFIER("IDENTIFIER"),
    CONDITION("CONDITION"),
    INITIALIZATION("INITIALIZATION"),
    ITERATION("ITERATION"),
    TYPE("TYPE");

    CodeVariables(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public String getValue() {
        return String.format("{%s}", name);
    }
}
