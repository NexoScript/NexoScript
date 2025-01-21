package com.nexoscript.nexoscript.builder;

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

    DOUBLE_RIGHT_ARROW(">>", "0xA1"),
    OPEN_CURLE_BRACKET("{", "0xB1"),
    CLOSED_CURLE_BRACKET("}", "0xB2"),
    FOUR_SPACES("    ", ""),
    THREE_SPACES("   ", ""),
    DOUBLE_INVERT_RIGHT_ARROW(">!>", "0xA2"),
    EQUALS("=", "0xA3"),

    CALL("call", "0x02"),
    USE("use", "0x02"),

    // Datatypes
    STRING("string", "0x10"),
    STR("str", "0x10"),
    INTEGER("integer", "0x11"),
    INT("int", "0x11"),
    LONG("long", "0x12"),
    CHARACTER("character", "0x13"),
    CHAR("char", "0x13"),
    BOOLEAN("boolean", "0x14"),
    BOOL("bool", "0x14"),
    DOUBLE("double", "0x15"),
    FLOAT("float", "0x16"),
    ARRAY("array", "0x17"),
    ANY("any", "0x18"),
    OBJECT("object", "0x18"),
    OBJ("obj", "0x18"),

    TRUE("True", "0x91"),
    TRUE_SEC("true", "0x91"),
    FALSE("False", "0x92"),
    FALSE_SEC("false", "0x92");

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
