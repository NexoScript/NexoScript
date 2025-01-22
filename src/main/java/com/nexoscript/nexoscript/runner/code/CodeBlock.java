package com.nexoscript.nexoscript.runner.code;

import java.util.List;
import java.util.Scanner;

public interface CodeBlock {
    void start(String name, Scanner scanner);
    String getName();
    List<Instruction> getInstructions();
}
