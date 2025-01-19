package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class IntegerVar implements Variable<Integer> {
    private String name;
    private int value;

    public IntegerVar(String name, int value) {
        this.name = name;
        this.value = value;
    }


    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "integer";
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Integer value) {
        this.value  = value;
    }
}
