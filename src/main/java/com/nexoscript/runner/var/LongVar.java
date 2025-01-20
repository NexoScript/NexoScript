package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class LongVar implements Variable<Long> {
    private String name;
    private long value;

    public LongVar(String name, long value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "long";
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    @Override
    public void setValue(Long value) {
        this.value = value;
    }
}
