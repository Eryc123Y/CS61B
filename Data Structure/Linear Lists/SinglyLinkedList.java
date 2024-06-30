public class SinglyLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // 在链表末尾添加元素
    public void add(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 在指定位置插入元素
    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // 删除指定位置的元素
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    // 获取指定位置的元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // 修改指定位置的元素
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    // 获取链表大小
    public int size() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空链表
    public void clear() {
        head = null;
        size = 0;
    }

    // 将链表转换为字符串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}