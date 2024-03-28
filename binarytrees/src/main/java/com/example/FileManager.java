package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase FileManager que maneja la lectura de archivos y la traducción de palabras.
 */
public class FileManager {
    private List<Association<String, String>> associations = new ArrayList<>();

    /**
     * Lee un archivo que contiene asociaciones de palabras y las guarda en una lista.
     *
     * @param fileName El nombre del archivo a leer.
     * @return Una lista de asociaciones de palabras.
     */
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

    /**
     * Lee un archivo de texto y traduce las palabras utilizando un diccionario.
     *
     * @param fileName   El nombre del archivo de texto a traducir.
     * @param dictionary El diccionario que contiene las asociaciones de palabras.
     * @return Una lista de palabras traducidas.
     */
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

    /**
     * Traduce una palabra utilizando un diccionario.
     *
     * @param word       La palabra a traducir.
     * @param dictionary El diccionario que contiene las asociaciones de palabras.
     * @return La palabra traducida o la palabra original encerrada entre asteriscos si no se encuentra en el diccionario.
     */
    private String translateWord(String word, BinaryTree<Association<String, String>> dictionary) {
        Association<String, String> association = dictionary.search(new Association<>(word, ""));
        if (association != null) {
            return association.getValue();
        } else {
            return "*" + word + "*";
        }
    }
}
