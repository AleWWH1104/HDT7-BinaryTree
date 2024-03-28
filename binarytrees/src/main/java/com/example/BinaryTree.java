package com.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un árbol binario de búsqueda genérico.
 *
 * @param <E> Tipo de datos que se almacenarán en el árbol y que deben ser comparables.
 */
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Clase interna que representa un nodo en el árbol binario.
     *
     * @param <E> Tipo de datos que se almacenan en el nodo.
     */
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    //Inserta un nuevo dato en el árbol.
    public void insert(E data) {
        root = insertRec(root, data);
    }

    //Método para insertar un dato en el árbol de forma recursiva.
    private Node<E> insertRec(Node<E> root, E data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    //Método para realizar el recorrido en orden del árbol de forma recursiva.
    public void inOrderTraversal(Node<E> root, List<E> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.data);
            inOrderTraversal(root.right, result);
        }
    }

    // Realiza un recorrido en orden del árbol y devuelve una lista con los elementos ordenados.
    public List<E> getInOrderTraversal() {
        List<E> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    //Busca un elemento en el árbol
    public E search(E key) {
        return searchRec(root, key);
    }

    //Método para buscar un elemento en el árbol de forma recursiva.
    private E searchRec(Node<E> root, E key) {
        if (root == null || root.data.compareTo(key) == 0) {
            return root != null ? root.data : null;
        }
        if (key.compareTo(root.data) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }
}
