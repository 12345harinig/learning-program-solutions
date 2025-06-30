package com.example;

public class FileService {
    private FileReader reader;
    private FileWriter writer;

    public FileService(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {
        String content = reader.read();  // mock read
        writer.write("Processed " + content);  // mock write
        return "Processed " + content;
    }
}
