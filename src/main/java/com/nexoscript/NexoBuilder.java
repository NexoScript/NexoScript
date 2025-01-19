package com.nexoscript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class NexoBuilder {
    public NexoBuilder(String inputFile) throws FileNotFoundException {
        try {
            File file = new File(inputFile);
            if (!file.exists() || !file.getName().endsWith(".macro"))
                throw new FileNotFoundException("Macro File is not Found");
            String code = Files.readString(file.toPath());
            if (code.contains("fun")) {
                code = code.replace("fun", "0x00");
            }
            if (code.contains("cout")) {
                code = code.replace("cout", "0x01");
            }
            if (code.contains(">>")) {
                code = code.replace(">>", "0x02");
            }
            if(code.contains("{")) {
                code = code.replace("{", "0x03");
            }
            if(code.contains("}")) {
                code = code.replace("}", "0x04");
            }
            if(code.contains("    ")) {
                code = code.replace("    ", "");
            }
            if(code.contains(">!>")) {
                code = code.replace(">!>", "0x05");
            }
            if(code.contains("call")) {
                code = code.replace("call", "0x06");
            }
            String outFolder = file.getPath().replace(file.getName(), "") + "build/";
            File outDir = new File(outFolder);
            if(!outDir.exists())
                outDir.mkdirs();
            File outFile = new File(outFolder + file.getName().replace(".macro", ".nexovm"));
            Files.write(outFile.toPath(), code.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
