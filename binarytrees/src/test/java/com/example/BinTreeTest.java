package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinTreeTest {

    @Test
    public void testInsert() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);

        // Verificar que los elementos se han insertado correctamente
        assertNotNull(tree.search(5));
        assertNotNull(tree.search(3));
        assertNotNull(tree.search(7));
        assertNotNull(tree.search(2));
        assertNotNull(tree.search(4));
        assertNotNull(tree.search(6));

        // Verificar que un elemento que no está en el árbol no se encuentre
        assertNull(tree.search(8));
    }

    @Test
    public void testSearch() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("cherry");

        // Verificar que los elementos se pueden buscar correctamente
        assertEquals("apple", tree.search("apple"));
        assertEquals("banana", tree.search("banana"));
        assertEquals("cherry", tree.search("cherry"));

        // Verificar que un elemento que no está en el árbol devuelve null
        assertNull(tree.search("orange"));
    }
}
