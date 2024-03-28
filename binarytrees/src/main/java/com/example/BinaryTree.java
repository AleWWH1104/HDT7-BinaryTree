package com.example;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

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

    public void insert(E data) {
        root = insertRec(root, data);
    }

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

    public void inOrderTraversal(Node<E> root, List<E> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.data);
            inOrderTraversal(root.right, result);
        }
    }

    public List<E> getInOrderTraversal() {
        List<E> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }
}
