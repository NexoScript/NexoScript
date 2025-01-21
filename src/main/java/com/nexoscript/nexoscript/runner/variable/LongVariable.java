package com.nexoscript.nexoscript.runner.variable;

import com.nexoscript.nexoscript.runner.code.Variable;

public class LongVariable implements Variable<Long> {
    private final String name;
    private long value;

    public LongVariable(String name, long value) {
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
