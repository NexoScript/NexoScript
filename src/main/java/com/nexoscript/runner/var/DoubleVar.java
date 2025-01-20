package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class DoubleVar implements Variable<Double> {
    private String name;
    private double value;

    public DoubleVar(String name, double value) {
        this.name = name;
        this.value = value;
    }


    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "double";
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value;
    }
}
