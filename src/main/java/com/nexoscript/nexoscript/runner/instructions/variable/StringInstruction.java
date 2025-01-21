package com.nexoscript.nexoscript.runner.instructions.variable;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.StringVariable;
import com.nexoscript.nexoscript.util.StringUtil;

public class StringInstruction implements Instruction {
    private String name;
    private String value;

    public StringInstruction(String value) {
        String[] split = value.split(" ");
        if (split.length >= 3) {
            this.name = split[1];
            if (split[2].equals("0xA3")) {
                if (split[3].startsWith("\"")) {
                    StringBuilder stringData = new StringBuilder();
                    for (int i = 3; i < split.length; i++) {
                        stringData.append(split[i]).append(" ");
                    }
                    this.value = StringUtil.getContentBetween(new String(stringData), "\"", "\"");
                }
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if (!variable.key().equals(this.name)) {
                    NexoRunner.get().getVariables().add(new StringVariable(this.name, this.value));
                    return true;
                }
            }
        } else {
            NexoRunner.get().getVariables().add(new StringVariable(this.name, this.value));
            return true;
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "string";
    }
}
