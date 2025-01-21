package com.nexoscript.nexoscript.runner.variable;

import com.nexoscript.nexoscript.runner.code.Variable;

public class CharVariable implements Variable<Character> {
    private final String name;
    private char value;

    public CharVariable(String name, char value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String key() {
        return this.name;
    }

    @Override
    public String type() {
        return "character";
    }

    @Override
    public Character getValue() {
        return this.value;
    }

    @Override
    public void setValue(Character value) {
        this.value = value;
    }
}
