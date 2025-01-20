package com.nexoscript.runner.instructions.var;

import com.nexoscript.runner.NexoRunner;
import com.nexoscript.runner.code.Instruction;
import com.nexoscript.runner.code.Variable;
import com.nexoscript.runner.var.*;
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
                        this.value = StringUtil.getContentBetween(new String(consoleData), "\"", "\"");
                    }
                    if (split[2].startsWith("'")) {
                        StringBuilder consoleData = new StringBuilder();
                        for (int i = 2; i < split.length; i++) {
                            consoleData.append(split[i]).append(" ");
                        }
                        String contentBetween = StringUtil.getContentBetween(new String(consoleData), "'", "'");
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
                        case "long" -> {
                            LongVar longVar = (LongVar) variable;
                            longVar.setValue(Long.valueOf(this.value));
                            return true;
                        }
                        case "character" -> {
                            CharVar charVar = (CharVar) variable;
                            charVar.setValue(this.value.charAt(1));
                            return true;
                        }
                        case "boolean" -> {
                            BooleanVar booleanVar = (BooleanVar) variable;
                            if(this.value.equals("0x0F")) {
                                booleanVar.setValue(true);
                                return true;
                            }
                            if(this.value.equals("0x10")) {
                                booleanVar.setValue(false);
                                return true;
                            }
                        }
                        case "double" -> {
                            DoubleVar doubleVar = (DoubleVar) variable;
                            doubleVar.setValue(Double.valueOf(this.value));
                            return true;
                        }
                        case "float" -> {
                            FloatVar floatVar = (FloatVar) variable;
                            floatVar.setValue(Float.valueOf(this.value));
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
