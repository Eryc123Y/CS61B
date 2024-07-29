public class AList<T> {
    private T[] items;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    /** Creates an empty list. */
    @SuppressWarnings("unchecked")
    public AList() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        if (size == 0) {
            return null;
        }
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T lastItem = items[size - 1];
        items[size - 1] = null;  // Avoid loitering
        size--;

        // Shrink the array if it's less than 25% full
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return lastItem;
    }

    /** Resizes the underlying array to the target capacity. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
}