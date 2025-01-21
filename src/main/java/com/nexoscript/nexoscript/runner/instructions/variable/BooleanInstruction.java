package com.nexoscript.nexoscript.runner.instructions.variable;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.BooleanVariable;

public class BooleanInstruction implements Instruction {
    private String name;
    private boolean value;

    public BooleanInstruction(String line) {
        String[] split = line.split(" ");
        if (split.length == 4) {
            this.name = split[1];
            if (split[2].equals("0xA3")) {
                if (split[3].equals("0x91")) {
                    value = true;
                }
                if (split[3].equals("0x92")) {
                    value = false;
                }
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if (!variable.key().equals(this.name)) {
                    NexoRunner.get().getVariables().add(new BooleanVariable(this.name, this.value));
                    return true;
                }
            }
        } else {
            NexoRunner.get().getVariables().add(new BooleanVariable(this.name, this.value));
            return true;
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "boolean";
    }
}
