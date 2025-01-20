package com.nexoscript.runner.instructions.var;

import com.nexoscript.runner.NexoRunner;
import com.nexoscript.runner.code.Instruction;
import com.nexoscript.runner.var.ArrayVar;
import com.nexoscript.util.StringUtil;

public class ArrayInstruction implements Instruction {
    private String name;
    private String[] value;
    private String type;

    public ArrayInstruction(String line) {
        String[] split = line.split(" ");
        this.name = split[1];
        if(split[0].contains("[")) {
            this.type = StringUtil.getContentBetween(split[0], "[", "]");
            if(split[2].equals("0x08")) {
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
            case "0x07", "0x09", "0x0A", "0x0B", "0x0C", "0x0D", "0x0E", "0x11" -> {
                NexoRunner.get().getArrays().add(new ArrayVar<>(this.name, this.value));
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
