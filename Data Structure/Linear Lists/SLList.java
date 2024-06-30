public class SLList {
    public IntNode first;
    private IntNode sentinal;
    private int size;

    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * normal constructor
     * @param x value of node
     */
    public SLList(int x) {
        sentinal = new IntNode(0, null);
        first = new IntNode(x, null);
        size = 1;
    }

    /**
     * empty param constructor
     */
    public SLList() {
        sentinal = new IntNode(0, null);
        size = 0;
    }


    public void addFirst(int x) {
        sentinal.next = new IntNode(x, sentinal.next);
        size += 1;
    }

    public int getFirst() {
        return sentinal.next.item;
    }

    public void addLast(int x) {
        var cur = sentinal;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new IntNode(x, null);
        size += 1;
    }

    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }

    public int size() {
        return size(first);
    }




}
