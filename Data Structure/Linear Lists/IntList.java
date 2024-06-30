public class IntList {
    public int first;
    public IntList rest;
    
    /**
     * Constructors
     */
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public IntList(int f) {
        first = f;
        rest = null;
    }

    /**return size of list (recurssion) */
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**return size of list (Iterattion) */
    public int iterateSize() {
        IntList cur = this;
        int s = 0;
        while (cur != null) {
            s++;
            cur = cur.rest;
        }
        return s;
    }

    /**Get the ith value, starting from 0.
     * If excedded, return the last value.
     */
    public int get(int idx) {
        int counter = 0;
        IntList cur = this;
        while (counter < idx && cur.rest != null){
            cur = cur.rest;
            counter ++;
        }
        return cur.first;
    }

    public static void main(String[] args) {
        // Create a new list 1 -> 2 -> 3
        IntList list = new IntList(1, new IntList(2, new IntList(3)));

        // Test size method
        System.out.println("Size (recursion): " + list.size()); // Output: 3
        System.out.println("Size (iteration): " + list.iterateSize()); // Output: 3

        // Test get method
        System.out.println("Element at index 0: " + list.get(0)); // Output: 1
        System.out.println("Element at index 1: " + list.get(1)); // Output: 2
        System.out.println("Element at index 2: " + list.get(2)); // Output: 3
    }
}


