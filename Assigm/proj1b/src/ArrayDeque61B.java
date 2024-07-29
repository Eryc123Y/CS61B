import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private static final int INITIAL_SIZE = 8;
    private int size;
    private int firstPos;
    private int lastPos;
    private T[] items;

    @SuppressWarnings("unchecked")
    public ArrayDeque61B() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        firstPos = 0;
        lastPos = 0;
    }

    private int mapIndex(int pos) {
        return Math.floorMod(pos, items.length);
    }

    @SuppressWarnings("unchecked")
    private void resize(int newLength) {
        T[] newItems = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[mapIndex(firstPos + i)];
        }
        items = newItems;
        firstPos = 0;
        lastPos = size;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        firstPos = (firstPos - 1 + items.length) % items.length;
        items[firstPos] = x;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[lastPos] = x;
        lastPos = (lastPos + 1) % items.length;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            returnList.add(items[mapIndex(firstPos + i)]);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[firstPos];
        items[firstPos] = null;
        firstPos = (firstPos + 1) % items.length;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        lastPos = (lastPos - 1 + items.length) % items.length;
        T item = items[lastPos];
        items[lastPos] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[mapIndex(firstPos + index)];
    }

    @Override
    public T getRecursive(int index) {
        return get(index);  // Simplified for the purpose of this example
    }
}