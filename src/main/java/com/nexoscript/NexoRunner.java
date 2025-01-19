package com.nexoscript;

import com.nexoscript.code.CodeBlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NexoRunner {
    private List<CodeBlock> codeBlocks = new ArrayList<>();

    public NexoRunner(String vmFile) throws FileNotFoundException {
        File file = new File(vmFile);
        if (!file.exists() || !file.getName().endsWith(".nexovm"))
            throw new FileNotFoundException("Macro File is not Found");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.startsWith("0x00")) {
                String[] args = line.split(" ");
                CodeBlock codeBlock = new CodeBlock();
                codeBlock.start(args[1], scanner);
                codeBlocks.add(codeBlock);
            }
        }
        if(!codeBlocks.isEmpty()) {
            codeBlocks.forEach(codeBlock -> {
                codeBlock.getInstructions().forEach(instruction -> {
                    if(!instruction.execute()) {
                        throw new RuntimeException("[NexoVM] -> Instruction " + instruction.getKeyWord() + " has an Issue!");
                    }
                });
            });
        }
    }
}
