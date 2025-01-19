package com.nexoscript;

import com.nexoscript.utils.ConsoleUtil;

import java.io.FileNotFoundException;

public class NexoVM {
    public static void main(String[] args){
        if(args.length == 2) {
            switch (args[0]) {
                case "build" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start NexoBuilder with File: " + args[1]);
                    try {
                        new NexoBuilder(args[1]);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "run" -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> Start NexoRunner with File: " + args[1]);
                    try {
                        new NexoRunner(args[1]);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    ConsoleUtil.printHeader();
                    System.out.println("[NexoVM] -> use NexoVM.exe <build/run> <input file>");
                }
            }
        }
    }
}
