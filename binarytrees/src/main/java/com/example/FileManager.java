package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<Association<String, String>> associations = new ArrayList<>();

    public List<Association<String, String>> readDic(String fileName) {
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
    public List<String> translateText(String fileName, BinaryTree<Association<String, String>> dictionary) {
        List<String> translatedWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String translated = translateWord(word.toLowerCase(), dictionary);
                    translatedWords.add(translated);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return translatedWords;
    }

    private String translateWord(String word, BinaryTree<Association<String, String>> dictionary) {
        Association<String, String> association = dictionary.search(new Association<>(word, ""));
        if (association != null) {
            return association.getValue();
        } else {
            return "*" + word + "*";
        }
    }
}
