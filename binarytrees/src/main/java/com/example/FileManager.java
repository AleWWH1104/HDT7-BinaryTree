package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<Association<String, String>> readFile(String fileName) {
        List<Association<String, String>> associations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.replace("(", "").replace(")", "").split(",");
                associations.add(new Association<>(parts[0].trim(), parts[1].trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return associations;
    }
}
