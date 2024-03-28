package com.example;

class BinaryTree<E extends Comparable<E>> {
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    private E element;

    public BinaryTree(E element) {
        this.element = element;
        left = null;
        right = null;
    }

    public boolean isEmpty() {
        return element == null;
    }

    public void insert(E element) {
        if (element.compareTo(this.element) < 0) {
            if (left == null) {
                left = new BinaryTree<E>(element);
            } else {
                left.insert(element);
            }
        } else {
            if (right == null) {
                right = new BinaryTree<E>(element);
            } else {
                right.insert(element);
            }
        }
    }

    public void inOrderTraversal(BinaryTree<E> tree) {
        if (!tree.isEmpty()) {
            inOrderTraversal(tree.left);
            System.out.println(tree.element);
            inOrderTraversal(tree.right);
        }
    }
}