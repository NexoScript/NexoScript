package com.nexoscript.builder;

public enum ByteCode {
    // Keyword for functions / methods
    FUNC("func", "0x00"),
    FUN("fun", "0x00"),
    FUNCTION("function", "0x00"),
    DEFINE("define", "0x00"),
    DEF("def", "0x00"),
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
    EQUALS("=", "0x08"),

    CALL("call", "0x06"),
    USE("use", "0x06"),

    STRING("string", "0x07"),
    STR("str", "0x07"),
    INTEGER("integer", "0x09"),
    INT("int", "0x09"),
    LONG("long", "0x0A"),
    CHAR("char", "0x0B"),
    CHARACTER("character", "0x0B"),
    BOOLEAN("boolean", "0x0C"),
    BOOL("bool", "0x0C"),
    DOUBLE("double", "0x0D"),
    FLOAT("float", "0x0E"),

    TRUE("True", "0x0F"),
    TRUE_SEC("true", "0x0F"),
    FALSE("False", "0x10"),
    FALSE_SEC("false", "0x10"),

    ARRAY("array", "0x11");


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
