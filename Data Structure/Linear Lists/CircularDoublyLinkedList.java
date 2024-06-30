public class CircularDoublyLinkedList<T> {
    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    // 在链表末尾添加元素
    public void add(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }

    // 在指定位置插入元素
    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == size) {
            add(data);
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                head.next = head;
                head.prev = head;
            } else {
                Node last = head.prev;
                newNode.next = head;
                newNode.prev = last;
                head.prev = newNode;
                last.next = newNode;
                head = newNode;
            }
        } else {
            Node current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    // 删除指定位置的元素
    public T remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = getNode(index);
        if (size == 1) {
            head = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            if (current == head) {
                head = head.next;
            }
        }
        size--;
        return current.data;
    }

    // 获取指定位置的元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return getNode(index).data;
    }

    // 修改指定位置的元素
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        getNode(index).data = data;
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

    // 获取指定位置的节点
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // 将链表转换为字符串
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}