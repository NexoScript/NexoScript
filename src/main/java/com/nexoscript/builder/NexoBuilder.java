package com.nexoscript.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class NexoBuilder {

    public NexoBuilder(String inputFile) throws FileNotFoundException {
        try {
            File file = new File(inputFile);
            if (!file.exists() || !file.getName().endsWith(".nexoscript"))
                throw new FileNotFoundException("Nexoscript file is not Found");
            String code = Files.readString(file.toPath());
            for (ByteCode value : ByteCode.values()) {
                if (code.contains(value.getKey())) {
                    code = code.replace(value.getKey(), value.getCode());
                }
            }
            String outFolder = file.getPath().replace(file.getName(), "") + "build/";
            File outDir = new File(outFolder);
            if(!outDir.exists())
                outDir.mkdirs();
            File outFile = new File(outFolder + file.getName().replace(".nexoscript", ".nexovm"));
            Files.write(outFile.toPath(), code.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
