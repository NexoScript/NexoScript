package com.nexoscript.nexoscript.runner.variable;

import com.nexoscript.nexoscript.runner.code.Variable;

public class FloatVariable implements Variable<Float> {
    private final String name;
    private float value;

    public FloatVariable(String name, float value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "float";
    }

    @Override
    public Float getValue() {
        return this.value;
    }

    @Override
    public void setValue(Float value) {
        this.value = value;
    }
}
