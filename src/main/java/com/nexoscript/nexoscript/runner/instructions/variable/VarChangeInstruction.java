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
import com.nexoscript.nexoscript.util.NexoUtil;
import com.nexoscript.nexoscript.util.StringUtil;

public class VarChangeInstruction implements Instruction {
    private String value;
    private String name;
    private boolean calculation = false;

    public VarChangeInstruction(String line) {
        String[] split = line.split(" ");
        this.name = split[0].substring(1);
        if (split.length >= 3) {
            if (split[1].equals("0xA3")) {
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
                if (split[2].startsWith("*")) {
                    if (split.length == 3) {
                        for (Variable<?> _variable : NexoRunner.get().getVariables()) {
                            if (_variable.key().equals(split[2].substring(1))) {
                                this.value = (String) _variable.getValue();
                            }
                        }
                    }
                    if(split.length > 3) {
                        StringBuilder data = new StringBuilder();
                        for (int i = 2; i < split.length; i++) {
                            if (i == split.length - 1) {data.append(split[i]); continue;}
                            data.append(split[i]).append(" ");
                        }
                        this.value = new String(data);
                        this.calculation = true;
                    }
                }
            }
        }
    }

    @Override
    public boolean execute() {
        if (!NexoRunner.get().getVariables().isEmpty()) {
            if (!calculation) {
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
                                System.out.println("No matching Var type");
                                return false;
                            }
                        }
                    }
                }
            }
            if (calculation) {
                String[] args = this.value.split(" ");
                if (args.length == 3) {
                    String result = this.name;
                    String number1 = args[0].substring(1);
                    String number2 = args[2].substring(1);
                    if (!NexoUtil.proveType(result, "integer", "long", "double", "float")) {
                        System.out.println(result + " Not matching with Allowed Types 1");
                        return false;
                    }
                    if (!NexoUtil.proveType(number1, "integer", "long", "double", "float")) {
                        System.out.println(number1 + " Not matching with Allowed Types 2");
                        return false;
                    }
                    if (!NexoUtil.proveType(number2, "integer", "long", "double", "float")) {
                        System.out.println(number2 + " Not matching with Allowed Types 3");
                        return false;
                    }
                    switch (args[1]) {
                        case "0xA4" -> {
                            NexoUtil.calculation(NexoUtil.getVarType(this.name), "<+<", this.name, number1, number2);
                            calculation = false;
                            return true;
                        }
                        case "0xA5" -> {
                            NexoUtil.calculation(NexoUtil.getVarType(this.name), "<-<", this.name, number1, number2);
                            calculation = false;
                            return true;
                        }
                        case "0xA6" -> {
                            NexoUtil.calculation(NexoUtil.getVarType(this.name), "</<", this.name, number1, number2);
                            calculation = false;
                            return true;
                        }
                        case "0xA7" -> {
                            NexoUtil.calculation(NexoUtil.getVarType(this.name), "<*<", this.name, number1, number2);
                            calculation = false;
                            return true;
                        }
                        case "0xA8" -> {
                            NexoUtil.calculation(NexoUtil.getVarType(this.name), "<%<", this.name, number1, number2);
                            calculation = false;
                            return true;
                        }
                        default -> {
                            System.out.println("No matching Operation");
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
