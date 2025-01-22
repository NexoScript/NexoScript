package com.nexoscript.nexoscript.runner.instructions.codeblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nexoscript.nexoscript.runner.code.CodeBlock;
import com.nexoscript.nexoscript.runner.code.Instruction;
import com.nexoscript.nexoscript.runner.instructions.CallInstruction;
import com.nexoscript.nexoscript.runner.instructions.CoutInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.ArrayInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.BooleanInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.CharacterInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.DoubleInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.FloatInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.IntegerInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.LongInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.StringInstruction;
import com.nexoscript.nexoscript.runner.instructions.variable.VarChangeInstruction;

public class MethodCodeBlock implements CodeBlock {
    private final List<Instruction> instructions = new ArrayList<>();
    private String name;

    public void start(String name, Scanner scanner) {
        this.name = name;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("0xB2"))
                break;
            if (nextLine.startsWith("0x01"))
                instructions.add(new CoutInstruction(nextLine));
            if (nextLine.startsWith("0x02"))
                instructions.add(new CallInstruction(nextLine));
            if (nextLine.startsWith("0x10"))
                instructions.add(new StringInstruction(nextLine));
            if (nextLine.startsWith("0x11"))
                instructions.add(new IntegerInstruction(nextLine));
            if (nextLine.startsWith("0x12"))
                instructions.add(new LongInstruction(nextLine));
            if (nextLine.startsWith("0x13"))
                instructions.add(new CharacterInstruction(nextLine));
            if (nextLine.startsWith("0x14"))
                instructions.add(new BooleanInstruction(nextLine));
            if (nextLine.startsWith("0x15"))
                instructions.add(new DoubleInstruction(nextLine));
            if (nextLine.startsWith("0x16"))
                instructions.add(new FloatInstruction(nextLine));
            if (nextLine.startsWith("0x17"))
                instructions.add(new ArrayInstruction(nextLine));
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
