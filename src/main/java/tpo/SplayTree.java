package tpo;

import java.util.*;

public class SplayTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    private static class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            return;
        }
        root = splay(root, key);
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            root.value = value;
            return;
        }
        Node<K, V> n = new Node<>(key, value);
        if (cmp < 0) {
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
            n.right = root.right;
            n.left = root;
            root.right = null;
        }
        root = n;
    }

    public V get(K key) {
        root = splay(root, key);
        if (root == null || key.compareTo(root.key) != 0) {
            return null;
        }
        return root.value;
    }

    public void remove(K key) {
        if (root == null) return;

        root = splay(root, key);
        if (key.compareTo(root.key) != 0) return;

        Node<K, V> x = root;
        if (x.left == null) root = x.right;
        else if (x.right == null) root = x.left;
        else {
            Node<K, V> temp = x.left;
            root = splay(x.right, key);
            root.left = temp;
        }
    }

    private Node<K, V> splay(Node<K, V> x, K key) {
        if (x == null) return null;

        int cmp1 = key.compareTo(x.key);
        if (cmp1 < 0) {
            if (x.left == null) {
                return x;
            }
            int cmp2 = key.compareTo(x.left.key);
            if (cmp2 < 0) {
                x.left.left = splay(x.left.left, key);
                x = rotateRight(x);
            } else if (cmp2 > 0) {
                x.left.right = splay(x.left.right, key);
                if (x.left.right != null)
                    x.left = rotateLeft(x.left);
            }
            if (x.left == null) return x;
            else return rotateRight(x);
        } else if (cmp1 > 0) {
            if (x.right == null) {
                return x;
            }
            int cmp2 = key.compareTo(x.right.key);
            if (cmp2 < 0) {
                x.right.left = splay(x.right.left, key);
                if (x.right.left != null)
                    x.right = rotateRight(x.right);
            } else if (cmp2 > 0) {
                x.right.right = splay(x.right.right, key);
                x = rotateLeft(x);
            }
            if (x.right == null) return x;
            else return rotateLeft(x);
        } else return x;
    }

    private Node<K, V> rotateRight(Node<K, V> h) {
        Node<K, V> x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private Node<K, V> rotateLeft(Node<K, V> h) {
        Node<K, V> x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<K, V> x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public List<K> keys() {
        List<K> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node<K, V> x, List<K> list) {
        if (x == null) return;
        inorder(x.left, list);
        list.add(x.key);
        inorder(x.right, list);
    }
}
