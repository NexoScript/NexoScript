package com.nexoscript.nexoscript.runner.variable;

import com.nexoscript.nexoscript.runner.code.Variable;

public class StringVariable implements Variable<String> {
    private final String name;
    private String value;

    public StringVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "string";
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
