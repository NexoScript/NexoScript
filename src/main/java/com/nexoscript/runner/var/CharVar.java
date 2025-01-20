package com.nexoscript.runner.var;

import com.nexoscript.runner.code.Variable;

public class CharVar implements Variable<Character> {
    private String name;
    private char value;

    public CharVar(String name, char value) {
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
