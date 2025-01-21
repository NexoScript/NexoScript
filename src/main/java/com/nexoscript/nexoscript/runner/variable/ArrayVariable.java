package com.nexoscript.nexoscript.runner.variable;

public class ArrayVariable<Type> {
    private final String name;
    private Type[] value;

    public ArrayVariable(String name, Type[] value) {
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
