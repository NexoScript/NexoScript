package com.nexoscript.runner.instructions;

import com.nexoscript.runner.NexoRunner;
import com.nexoscript.runner.code.Instruction;
import com.nexoscript.runner.code.Variable;
import com.nexoscript.utils.StringUtils;

import java.util.List;
import java.util.Objects;

public class CoutInstruction implements Instruction {
    private String[] args;

    public CoutInstruction(String line) {
        args = line.split(" ");
    }

    @Override
    public boolean execute() {
        if(Objects.equals(args[1], "0x02")) {
            if(!args[2].startsWith("*")) {
                if(args[2].startsWith("\"")) {
                    StringBuilder consoleData = new StringBuilder();
                    for (int i = 2; i < args.length; i++) {
                        consoleData.append(args[i]).append(" ");
                    }
                    String contentBetween = StringUtils.
                            getContentBetween(new String(consoleData), "\"", "\"");
                    System.out.print(contentBetween);
                    return true;
                }
                StringBuilder consoleData = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    consoleData.append(args[i]).append(" ");
                }
                System.out.print(consoleData);
                return true;
            } else {
                for (Variable<?> variable : NexoRunner.get().getVariables()) {
                    if(variable.key().equals(args[2].substring(1))) {
                        System.out.print(variable.getValue());
                        return true;
                    }
                }
            }
        }
        if(Objects.equals(args[1], "0x05")) {
            if(!args[2].startsWith("*")) {
                if(args[2].startsWith("\"")) {
                    StringBuilder consoleData = new StringBuilder();
                    for (int i = 2; i < args.length; i++) {
                        consoleData.append(args[i]).append(" ");
                    }
                    String contentBetween = StringUtils.
                            getContentBetween(new String(consoleData), "\"", "\"");
                    System.out.println(contentBetween);
                    return true;
                }
                StringBuilder consoleData = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    consoleData.append(args[i]).append(" ");
                }
                System.out.println(consoleData);
                return true;
            }
            for (Variable<?> variable : NexoRunner.get().getVariables()) {
                if(variable.key().equals(args[2].substring(1))) {
                    System.out.println(variable.getValue());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "0x01";
    }
}