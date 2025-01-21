package com.nexoscript.nexoscript.runner.instructions.variable;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.DoubleVariable;

public class DoubleInstruction implements Instruction {
    private String name;
    private double value;

    public DoubleInstruction(String line) {
        String[] split = line.split(" ");
        if (split.length == 4) {
            this.name = split[1];
            if (split[2].equals("0xA3")) {
                this.value = Double.parseDouble(split[3]);
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if (!variable.key().equals(this.name)) {
                    NexoRunner.get().getVariables().add(new DoubleVariable(this.name, this.value));
                    return true;
                }
            }
        } else {
            NexoRunner.get().getVariables().add(new DoubleVariable(this.name, this.value));
            return true;
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "double";
    }
}
