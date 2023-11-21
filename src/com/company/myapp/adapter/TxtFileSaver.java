package com.company.myapp.adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class TxtFileSaver implements ITxtFileSaver {
    @Override
    public void saveToTxtFile(String fileName, String data) {
        try {
            Path filePath = Paths.get(fileName);
            Files.write(filePath, data.getBytes());
            System.out.println("Saved to TXT file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to TXT file: " + e.getMessage());
        }
    }

    @Override
    public String loadFromTxtFile(String fileName) {
        try {
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new String(data);
        } catch (IOException e) {
            System.err.println("Error loading data from TXT file: " + e.getMessage());
            return null;
        }
    }
}
