package com.olvins.kit.dotnetdevkit.conventions;

public class NamingConvention {
    public static final NamingConvention PASCAL_CASE = new NamingConvention("^[A-Z][a-zA-Z0-9]*$");
    public static final NamingConvention CAMEL_CASE = new NamingConvention("^[a-z][a-zA-Z0-9]*$");
    public static final NamingConvention UPPERCASE = new NamingConvention("^[A-Z_]+$");
    public static final NamingConvention MEMBER_VARIABLES = new NamingConvention("^(_|m_)[a-z][a-zA-Z0-9]*$");
    public static final NamingConvention VERB_NOUN = new NamingConvention("[a-z][a-zA-Z0-9]*[A-Z][a-zA-Z0-9]*$");
    public static final NamingConvention INTERFACE = new NamingConvention("^I[A-Z][a-zA-Z0-9]*$");

    public NamingConvention(String pattern) {
        this.pattern = pattern;
    }

    private String pattern;


}
