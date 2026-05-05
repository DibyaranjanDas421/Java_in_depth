package interview_question;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node data = map.get(key);
        remove(data);
        insertAtFront(data);

        return data.value;

    }

    public void remove(Node node) {
        Node prNode = node.prev;
        Node nxNode = node.next;

        prNode.next = nxNode;
        nxNode.prev = prNode;

    }

    public void insertAtFront(Node node) {
        Node first = head.next;
        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            remove(existing);
            insertAtFront(existing);

            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    public void printCache() {

        Node curr = head.next;

        while (curr != tail) {
            System.out.print(curr + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 10);
        lruCache.printCache();

        lruCache.put(2, 20);
        lruCache.printCache();

        lruCache.put(3, 30);
        lruCache.printCache();

        lruCache.get(1);
        lruCache.printCache();

        lruCache.put(4, 40);
        lruCache.printCache();
    }

}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }

}