package com.nexoscript.runner.var;

public class ArrayVar<Type> {
    private String name;
    private Type[] value;

    public ArrayVar(String name, Type[] value) {
        this.name = name;
        this.value = value;
    }

    public String key() {
        return this.name;
    }

    public Type[] getValue() {
        return this.value;
    }

    public void setValue(Type[] value) {
        this.value = value;
    }
}
