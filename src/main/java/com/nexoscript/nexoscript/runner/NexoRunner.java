package com.nexoscript.nexoscript.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nexoscript.nexoscript.runner.code.CodeBlock;
import com.nexoscript.nexoscript.runner.instructions.codeblock.MethodCodeBlock;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.ArrayVariable;

public class NexoRunner {
    private static NexoRunner instance;
    private final String vmFile;
    private final List<CodeBlock> codeBlocks;
    private final List<Variable<?>> variables;
    private final List<ArrayVariable<?>> arrays;

    public NexoRunner(String vmFile) {
        instance = this;
        this.vmFile = vmFile;
        this.codeBlocks = new ArrayList<>();
        this.variables = new ArrayList<>();
        this.arrays = new ArrayList<>();
    }

    public void run() throws FileNotFoundException {
        File file = new File(vmFile);
        if (!file.exists() || !file.getName().endsWith(".nexovm"))
            throw new FileNotFoundException("NexoVM file is not Found");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("0x00") && line.endsWith("0xB1")) {
                    String[] args = line.split(" ");
                    MethodCodeBlock codeBlock = new MethodCodeBlock();
                    codeBlock.start(args[1], scanner);
                    codeBlocks.add(codeBlock);
                }
            }
        }
        if (!codeBlocks.isEmpty()) {
            codeBlocks.forEach(codeBlock -> {
                if (codeBlock.getName().equals("main")) {
                    codeBlock.getInstructions().forEach(instruction -> {
                        if (!instruction.execute()) {
                            throw new RuntimeException(
                                    "[NexoVM] -> Instruction " + instruction.getKeyWord() + " has an issue!");
                        }
                    });
                }
            });
        }
    }

    public List<CodeBlock> getCodeBlocks() {
        return codeBlocks;
    }

    public List<Variable<?>> getVariables() {
        return variables;
    }

    public List<ArrayVariable<?>> getArrays() {
        return arrays;
    }

    public static NexoRunner get() {
        return instance;
    }
}
