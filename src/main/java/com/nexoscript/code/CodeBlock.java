package com.nexoscript.code;

import com.nexoscript.instructions.CallInstruction;
import com.nexoscript.instructions.CoutInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeBlock {
    private String name;
    private List<Instruction> instructions = new ArrayList<>();
    public void start(String name, Scanner scanner) {
        this.name = name;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if(nextLine.startsWith("0x04")) break;
            if(nextLine.startsWith("0x01")) instructions.add(new CoutInstruction(nextLine));
            if(nextLine.startsWith("0x06")) instructions.add(new CallInstruction(nextLine));
        }
    }

    public String getName() {
        return name;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
