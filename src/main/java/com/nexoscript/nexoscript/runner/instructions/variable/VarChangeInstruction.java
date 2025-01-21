package com.nexoscript.nexoscript.runner.instructions.variable;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.BooleanVariable;
import com.nexoscript.nexoscript.runner.variable.CharVariable;
import com.nexoscript.nexoscript.runner.variable.DoubleVariable;
import com.nexoscript.nexoscript.runner.variable.FloatVariable;
import com.nexoscript.nexoscript.runner.variable.IntegerVariable;
import com.nexoscript.nexoscript.runner.variable.LongVariable;
import com.nexoscript.nexoscript.runner.variable.StringVariable;
import com.nexoscript.nexoscript.util.StringUtil;

public class VarChangeInstruction implements Instruction {
    private String value;
    private String name;

    public VarChangeInstruction(String line) {
        String[] split = line.split(" ");
        if (split.length >= 3) {
            if (split[1].equals("0xA3")) {
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
                            StringVariable stringVar = (StringVariable) variable;
                            stringVar.setValue(this.value);
                            return true;
                        }
                        case "integer" -> {
                            IntegerVariable integerVar = (IntegerVariable) variable;
                            integerVar.setValue(Integer.valueOf(this.value));
                            return true;
                        }
                        case "long" -> {
                            LongVariable longVar = (LongVariable) variable;
                            longVar.setValue(Long.valueOf(this.value));
                            return true;
                        }
                        case "character" -> {
                            CharVariable charVar = (CharVariable) variable;
                            charVar.setValue(this.value.charAt(1));
                            return true;
                        }
                        case "boolean" -> {
                            BooleanVariable booleanVar = (BooleanVariable) variable;
                            if (this.value.equals("0x0F")) {
                                booleanVar.setValue(true);
                                return true;
                            }
                            if (this.value.equals("0x10")) {
                                booleanVar.setValue(false);
                                return true;
                            }
                        }
                        case "double" -> {
                            DoubleVariable doubleVar = (DoubleVariable) variable;
                            doubleVar.setValue(Double.valueOf(this.value));
                            return true;
                        }
                        case "float" -> {
                            FloatVariable floatVar = (FloatVariable) variable;
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
