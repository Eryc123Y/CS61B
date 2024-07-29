import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ArrayDeque61BTest {

    private ArrayDeque61B<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new ArrayDeque61B<>();
    }

    @Test
    void testAddFirstAndRemoveFirst() {
        for (int i = 0; i < 1000; i++) {
            deque.addFirst(i);
        }
        assertEquals(1000, deque.size());
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, deque.removeFirst());
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    void testAddLastAndRemoveLast() {
        for (int i = 0; i < 1000; i++) {
            deque.addLast(i);
        }
        assertEquals(1000, deque.size());
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, deque.removeLast());
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    void testMixedOperations() {
        for (int i = 0; i < 500; i++) {
            deque.addFirst(i);
            deque.addLast(1000 + i);
        }
        assertEquals(1000, deque.size());
        for (int i = 499; i >= 0; i--) {
            assertEquals(i, deque.removeFirst());
            assertEquals(1000 + i, deque.removeLast());
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    void testToList() {
        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }
        List<Integer> list = deque.toList();
        assertEquals(100, list.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testGet() {
        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(i, deque.get(i));
        }
        assertNull(deque.get(100));
    }

    @Test
    void testResize() {
        for (int i = 0; i < 1000; i++) {
            deque.addLast(i);
        }
        assertEquals(1000, deque.size());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, deque.get(i));
        }
    }

    @Test
    void testEmptyDeque() {
        assertTrue(deque.isEmpty());
        assertNull(deque.removeFirst());
        assertNull(deque.removeLast());
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testSingleElement() {
        deque.addFirst(1);
        assertEquals(1, deque.size());
        assertEquals(1, deque.get(0));
        assertEquals(1, deque.removeFirst());
        assertTrue(deque.isEmpty());

        deque.addLast(1);
        assertEquals(1, deque.size());
        assertEquals(1, deque.get(0));
        assertEquals(1, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testRemoveFromEmptyDeque() {
        assertNull(deque.removeFirst());
        assertNull(deque.removeLast());
        deque.addFirst(1);
        deque.removeFirst();
        assertNull(deque.removeFirst());
        assertNull(deque.removeLast());
    }

    @Test
    void testAddRemoveInterleaved() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        assertEquals(1000, deque.size());
        int count = 0;
        while (!deque.isEmpty()) {
            if (count % 2 == 0) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
            count++;
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    void testWrapAround() {
        for (int i = 0; i < 8; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 4; i++) {
            deque.removeFirst();
        }
        for (int i = 8; i < 12; i++) {
            deque.addLast(i);
        }
        assertEquals(8, deque.size());
        assertEquals(4, deque.get(0));
        assertEquals(11, deque.get(7));
    }
}
