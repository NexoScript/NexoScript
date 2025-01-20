package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class BooleanVar implements Variable<Boolean> {
    private String name;
    private boolean value;

    public BooleanVar(String name, boolean value) {
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
