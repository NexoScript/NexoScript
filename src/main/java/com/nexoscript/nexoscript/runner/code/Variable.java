package com.nexoscript.nexoscript.runner.code;

public interface Variable<Value> {
    String key();

    String type();

    Value getValue();

    void setValue(Value value);
}
