package com.example;

public class FileManager {
    private DangerousAction action;

    public FileManager(DangerousAction action) {
        this.action = action;
    }

    public void deleteFileSafely(String fileName) {
        try {
            action.deleteImportantFile(fileName);
            System.out.println("File deleted: " + fileName);
        } catch (RuntimeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
