package com.nexoscript.runner.instructions.var;

import com.nexoscript.runner.NexoRunner;
import com.nexoscript.runner.code.Instruction;
import com.nexoscript.runner.code.Variable;
import com.nexoscript.runner.var.DoubleVar;
import com.nexoscript.runner.var.IntegerVar;

public class DoubleInstruction implements Instruction {
    private String name;
    private double value;

    public DoubleInstruction(String line) {
        String[] split = line.split(" ");
        if (split.length == 4) {
            this.name = split[1];
            if (split[2].equals("0x08")) {
                this.value = Double.valueOf(split[3]);
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if (!variable.key().equals(this.name)) {
                    NexoRunner.get().getVariables().add(new DoubleVar(this.name, this.value));
                    return true;
                }
            }
        } else {
            NexoRunner.get().getVariables().add(new DoubleVar(this.name, this.value));
            return true;
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "double";
    }
}
