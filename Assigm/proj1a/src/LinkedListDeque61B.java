import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    Node sentinel;
    int size;

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T val, Node prev, Node next) {
            this.item = val;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        public Node(T val) {
            this.prev = null;
            this.next = null;
            this.item = val;
        }
    }


    public  LinkedListDeque61B () {
        this.sentinel = new Node();
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
        this.size = 0;

    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        this.size++;

    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = sentinel.next;
        while (curr != sentinel) {
            returnList.add(curr.item);
            curr = curr.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            Node first = sentinel.next;
            T val = first.item;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size--;
            return val;
        }
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            Node last = sentinel.prev;
            T val = last.item;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            size--;
            return val;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // Invalid index
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null; // Invalid index
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}


