package com.nexoscript.runner.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nexoscript.runner.instructions.CallInstruction;
import com.nexoscript.runner.instructions.CoutInstruction;
import com.nexoscript.runner.instructions.var.IntegerInstruction;
import com.nexoscript.runner.instructions.var.StringInstruction;
import com.nexoscript.runner.instructions.var.VarChangeInstruction;

public class CodeBlock {
    private final List<Instruction> instructions = new ArrayList<>();
    private String name;

    public void start(String name, Scanner scanner) {
        this.name = name;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("0x04"))
                break;
            if (nextLine.startsWith("0x01"))
                instructions.add(new CoutInstruction(nextLine));
            if (nextLine.startsWith("0x06"))
                instructions.add(new CallInstruction(nextLine));
            if (nextLine.startsWith("0x07"))
                instructions.add(new StringInstruction(nextLine));
            if (nextLine.startsWith("0x09"))
                instructions.add(new IntegerInstruction(nextLine));
            if (nextLine.startsWith("*"))
                instructions.add(new VarChangeInstruction(nextLine));
        }
    }

    public String getName() {
        return name;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
