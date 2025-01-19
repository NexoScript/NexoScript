package com.nexoscript.instructions;

import com.nexoscript.NexoRunner;
import com.nexoscript.code.CodeBlock;
import com.nexoscript.code.Instruction;

public class CallInstruction implements Instruction {
    private String methodName;

    public CallInstruction(String methodName) {
        this.methodName = methodName.split(" ")[1];
    }

    @Override
    public boolean execute() {
        NexoRunner.get().getCodeBlocks().forEach(codeBlock -> {
            if(codeBlock.getName().equals(this.methodName)) {
                codeBlock.getInstructions().forEach(instruction -> {
                    if (!instruction.execute()) {
                        throw new RuntimeException("[NexoVM] -> Instruction " + instruction.getKeyWord() + " has an Issue!");
                    }
                });
            }
        });
        return true;
    }

    @Override
    public String getKeyWord() {
        return "call";
    }
}
