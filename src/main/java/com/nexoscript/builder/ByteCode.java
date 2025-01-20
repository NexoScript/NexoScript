package com.nexoscript.builder;

public enum ByteCode {
    // Keyword for functions / methods
    FUN("fun", "0x00"),
    FUNC("func", "0x00"),
    FUNCTION("function", "0x00"),
    DEF("def", "0x00"),
    DEFINE("define", "0x00"),
    METHOD("method", "0x00"),
    METH("meth", "0x00"),
    MET("met", "0x00"),

    // Keyword for console printing
    COUT("cout", "0x01"),
    PRINT("print", "0x01"),
    SOUT("sout", "0x01"),
    SYSOUT("sysout", "0x01"),
    LOG("log", "0x01"),

    DOUBLE_RIGHT_ARROW(">>", "0x02"),
    OPEN_CURLE_BRACKET("{", "0x03"),
    CLOSED_CURLE_BRACKET("}", "0x04"),
    FOUR_SPACES("    ", ""),
    THREE_SPACES("   ", ""),
    DOUBLE_INVERT_RIGHT_ARROW(">!>", "0x05"),
    CALL("call", "0x06"),
    USE("use", "0x06"),
    STRING("string", "0x07"),
    STR("str", "0x07"),
    EQUALS("=", "0x08"),
    INTEGER("integer", "0x09"),
    INT("int", "0x09");


    private final String key;
    private final String code;

    ByteCode(String key, String code) {
        this.key = key;
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public String getCode() {
        return code;
    }
}
