package com.nexoscript.nexoscript;

import java.io.File;
import java.io.FileNotFoundException;

import com.nexoscript.nexoscript.builder.NexoBuilder;
import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.util.ConsoleUtil;

public class Nexoscript {

    public static void main(String[] args) {
        if (args.length == 2) {
            switch (args[0]) {
                case "build" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start builder with file: " + args[1]);
                    NexoBuilder builder = new NexoBuilder(args[1]);
                    builder.build();
                }
                case "run" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start runner with file: " + args[1]);
                    NexoBuilder builder = new NexoBuilder(args[1]);
                    builder.build();
                }
                case "build-run" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start builder with file: " + args[1]);
                    NexoBuilder builder = new NexoBuilder(args[1]);
                    builder.build();
                    System.out.println("[NexoVM] -> Start runner with file: " + args[1]);
                    try {
                        File file = new File(args[1]);
                        String outFolder = file.getPath().replace(file.getName(), "") + "build/";
                        File outFile = new File(outFolder + file.getName().replace(".nexoscript", ".nexovm"));
                        NexoRunner runner = new NexoRunner(outFile.getPath());
                        runner.run();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Use nexovm.exe <build/run> <input file>");
                }
            }
        }
    }
}
