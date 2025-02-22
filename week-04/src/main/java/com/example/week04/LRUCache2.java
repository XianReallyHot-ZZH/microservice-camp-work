package com.example.week04;

/**
 * 基于链表数据结构实现的LRU缓存
 * <p>
 * 越靠近链表头的元素为最新访问的，越远离链表头的元素为最旧访问的
 *
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache2<K, V> {
    private final int capacity;
    private final Node<K, V> head;
    private final Node<K, V> tail;
    private int size;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.head = new Node<>();
        this.tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // get时维护元素访问顺序
    public V get(K key) {
        Node<K, V> node = getNodeByKey(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    // put时维护元素访问顺序+LRU实现
    public void put(K key, V value) {
        Node<K, V> node = getNodeByKey(key);
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            addToHead(newNode);
            // LRU实现核心逻辑
            if (size() > capacity) {
                Node<K, V> tail = removeTail();
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int size() {
        return size;
    }

    private Node<K, V> getNodeByKey(K key) {
        Node<K, V> current = head.next;
        while (current != tail) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private Node<K, V> removeTail() {
        Node<K, V> res = tail.prev;
        removeNode(res);
        return res;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
