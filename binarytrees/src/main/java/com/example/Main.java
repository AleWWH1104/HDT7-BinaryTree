package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto FileManager para leer los archivos
        FileManager filemanager = new FileManager();
        String file1 = "/Users/alejandraayala/Documents/Trabajos_UVG/Semestre 3/EstructuraDatos/HDT7-BinaryTree/binarytrees/src/main/java/com/example/diccionario.txt";
        String file2 = "/Users/alejandraayala/Documents/Trabajos_UVG/Semestre 3/EstructuraDatos/HDT7-BinaryTree/binarytrees/src/main/java/com/example/texto.txt";
        List<Association<String, String>> associations = filemanager.readFile(file1);
        
        // Crear un objeto BinaryTree para almacenar las asociaciones del diccionario
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();
        // Insertar las asociaciones en el árbol binario
        for (Association<String, String> association : associations) {
            dictionary.insert(association);
        }

        // Obtener las palabras ordenadas por inglés del árbol binario
        List<Association<String, String>> orderedWords = dictionary.getInOrderTraversal();

        // Imprimir las palabras ordenadas
        for (Association<String, String> association : orderedWords) {
            System.out.println(association);
        }

    }
}
