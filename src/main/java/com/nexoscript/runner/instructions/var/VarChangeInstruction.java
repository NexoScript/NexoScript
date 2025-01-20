package com.nexoscript.runner.instructions.var;

import com.nexoscript.runner.NexoRunner;
import com.nexoscript.runner.code.Instruction;
import com.nexoscript.runner.code.Variable;
import com.nexoscript.runner.var.IntegerVar;
import com.nexoscript.runner.var.StringVar;
import com.nexoscript.util.StringUtil;

public class VarChangeInstruction implements Instruction {
    private String value;
    private String name;

    public VarChangeInstruction(String line) {
        String[] split = line.split(" ");
        if (split.length >= 3) {
            if (split[1].equals("0x08")) {
                this.name = split[0].substring(1);
                if (!split[2].startsWith("*")) {
                    if (split[2].startsWith("\"")) {
                        StringBuilder consoleData = new StringBuilder();
                        for (int i = 2; i < split.length; i++) {
                            consoleData.append(split[i]).append(" ");
                        }
                        String contentBetween = StringUtil.getContentBetween(new String(consoleData), "\"", "\"");
                        this.value = contentBetween;
                    }
                    if (split.length == 3) {
                        this.value = split[2];
                    }
                }
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if (variable.key().equals(this.name)) {
                    switch (variable.type()) {
                        case "string" -> {
                            StringVar stringVar = (StringVar) variable;
                            stringVar.setValue(this.value);
                            return true;
                        }
                        case "integer" -> {
                            IntegerVar integerVar = (IntegerVar) variable;
                            integerVar.setValue(Integer.valueOf(this.value));
                            return true;
                        }
                        default -> {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "var-change";
    }
}
