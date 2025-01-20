package com.nexoscript;

import java.io.File;
import java.io.FileNotFoundException;

import com.nexoscript.builder.NexoBuilder;
import com.nexoscript.runner.NexoRunner;
import com.nexoscript.util.ConsoleUtil;

public class NexoVM {

    public static void main(String[] args) {
        if (args.length == 2) {
            switch (args[0]) {
                case "build" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start builder with file: " + args[1]);
                    try {
                        new NexoBuilder(args[1]);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "run" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start runner with file: " + args[1]);
                    try {
                        new NexoRunner(args[1]);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "build-run" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start builder with file: " + args[1]);
                    try {
                        new NexoBuilder(args[1]);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("[NexoVM] -> Start runner with file: " + args[1]);
                    try {
                        File file = new File(args[1]);
                        String outFolder = file.getPath().replace(file.getName(), "") + "build/";
                        File outFile = new File(outFolder + file.getName().replace(".nexoscript", ".nexovm"));
                        new NexoRunner(outFile.getPath());
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
