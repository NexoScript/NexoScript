package com.nexoscript.nexoscript.runner.variable;

import com.nexoscript.nexoscript.runner.code.Variable;

public class BooleanVariable implements Variable<Boolean> {
    private final String name;
    private boolean value;

    public BooleanVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "boolean";
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }
}
