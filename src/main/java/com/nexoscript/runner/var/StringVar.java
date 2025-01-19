package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class StringVar implements Variable<String> {
    private String name;
    private String value;

    public StringVar(String name, String value) {
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
