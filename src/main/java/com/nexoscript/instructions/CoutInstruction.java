package com.nexoscript.instructions;

import com.nexoscript.code.Instruction;

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
                StringBuilder consoleData = new StringBuilder();
                for(int i = 2; i < args.length; i++) {
                    consoleData.append(args[i]).append(" ");
                }
                System.out.print(new String(consoleData));
                return true;
            }
        }
        if(Objects.equals(args[1], "0x05")) {
            if(!args[2].startsWith("*")) {
                StringBuilder consoleData = new StringBuilder();
                for(int i = 2; i < args.length; i++) {
                    consoleData.append(args[i]).append(" ");
                }
                System.out.println(new String(consoleData));
                return true;
            }
        }
        return false;
    }

    @Override
    public String getKeyWord() {
        return "0x01";
    }
}