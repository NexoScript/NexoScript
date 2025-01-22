package com.nexoscript.nexoscript.runner.instructions.variable;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.variable.ArrayVariable;
import com.nexoscript.nexoscript.util.StringUtil;

import java.util.Arrays;

public class ArrayInstruction implements Instruction {
    private final String name;
    private String[] value;
    private String type;

    public ArrayInstruction(String line) {
        String[] split = line.split(" ");
        this.name = split[1];
        if (split[0].contains("[")) {
            this.type = StringUtil.getContentBetween(split[0], "[", "]");
            if (split[2].equals("0xA3")) {
                if (split[3].startsWith("[")) {
                    StringBuilder stringData = new StringBuilder();
                    for (int i = 3; i < split.length; i++) {
                        stringData.append(split[i]).append(" ");
                    }
                    String temp = StringUtil.getContentBetween(new String(stringData), "[", "]").replace(", ", ",");
                    this.value = temp.split(",");
                }
            }
        }
    }

    @Override
    public boolean execute() {
        switch (type) {
            case "0x10", "0x11", "0x12", "0x13", "0x14", "0x15", "0x16" -> {
                NexoRunner.get().getArrays().add(new ArrayVariable<>(this.name, this.value));
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public String getKeyWord() {
        return "array";
    }
}
