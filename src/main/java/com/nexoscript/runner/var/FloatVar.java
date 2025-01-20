package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class FloatVar implements Variable<Float> {
    private String name;
    private float value;

    public FloatVar(String name, float value) {
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
