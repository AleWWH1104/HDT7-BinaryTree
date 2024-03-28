package com.example;
import java.util.List;

/**
 * Clase principal que contiene el método main para ejecutar el programa.
 */
public class Main {
    public static void main(String[] args) {
        // Crear un objeto FileManager para leer los archivos
        FileManager filemanager = new FileManager();
        String file1 = "/Users/alejandraayala/Documents/Trabajos_UVG/Semestre 3/EstructuraDatos/HDT7-BinaryTree/binarytrees/src/main/java/com/example/diccionario.txt";
        String file2 = "/Users/alejandraayala/Documents/Trabajos_UVG/Semestre 3/EstructuraDatos/HDT7-BinaryTree/binarytrees/src/main/java/com/example/texto.txt";
        List<Association<String, String>> listAssociations = filemanager.readDic(file1);
        
        // Crear un objeto BinaryTree para almacenar las asociaciones del diccionario
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();
        // Insertar las asociaciones en el árbol binario
        for (Association<String, String> association : listAssociations) {
            dictionary.insert(association);
        }

        // Obtener las palabras ordenadas por inglés del árbol binario
        List<Association<String, String>> orderedWords = dictionary.getInOrderTraversal();

        // Imprimir las palabras ordenadas
        for (Association<String, String> association : orderedWords) {
            System.out.println(association);
        }
        
        // Leer el texto y traducir las palabras
        List<String> translatedWords = filemanager.translateText(file2, dictionary);

        // Imprimir las palabras traducidas
        System.out.println("Oracion Traducida");
        for (String word : translatedWords) {
            System.out.print(word + " ");
        }
    }
}
