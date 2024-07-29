import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

import java.util.List;

public class SelfTests {

    private LinkedListDeque61B<Integer> deque;

    @BeforeEach
    public void setUp() {
        deque = new LinkedListDeque61B<>();
    }

    // Add Tests
    @Test
    public void testAddFirstFromEmpty() {
        deque.addFirst(1);
        assertThat(deque.toList()).containsExactly(1).inOrder();
    }

    @Test
    public void testAddLastFromEmpty() {
        deque.addLast(1);
        assertThat(deque.toList()).containsExactly(1).inOrder();
    }

    @Test
    public void testAddFirstNonEmpty() {
        deque.addLast(2);
        deque.addFirst(1);
        assertThat(deque.toList()).containsExactly(1, 2).inOrder();
    }

    @Test
    public void testAddLastNonEmpty() {
        deque.addFirst(1);
        deque.addLast(2);
        assertThat(deque.toList()).containsExactly(1, 2).inOrder();
    }

    // Add After Remove Tests
    @Test
    public void testAddFirstAfterRemoveToEmpty() {
        deque.addFirst(1);
        deque.removeFirst();
        deque.addFirst(2);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void testAddLastAfterRemoveToEmpty() {
        deque.addLast(1);
        deque.removeLast();
        deque.addLast(2);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    // Remove Tests
    @Test
    public void testRemoveFirst() {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.removeFirst()).isEqualTo(1);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void testRemoveLast() {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.removeLast()).isEqualTo(1);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void testRemoveFirstToEmpty() {
        deque.addLast(1);
        assertThat(deque.removeFirst()).isEqualTo(1);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testRemoveLastToEmpty() {
        deque.addFirst(1);
        assertThat(deque.removeLast()).isEqualTo(1);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testRemoveFirstToOne() {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.removeFirst()).isEqualTo(1);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    @Test
    public void testRemoveLastToOne() {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.removeLast()).isEqualTo(1);
        assertThat(deque.toList()).containsExactly(2).inOrder();
    }

    // Get Tests
    @Test
    public void testGetValid() {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.get(1)).isEqualTo(2);
    }

    @Test
    public void testGetOOBLarge() {
        deque.addLast(1);
        assertThat(deque.get(100)).isNull();
    }

    @Test
    public void testGetOOBNeg() {
        deque.addLast(1);
        assertThat(deque.get(-1)).isNull();
    }

    @Test
    public void testGetRecursiveValid() {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.getRecursive(1)).isEqualTo(2);
    }

    @Test
    public void testGetRecursiveOOBLarge() {
        deque.addLast(1);
        assertThat(deque.getRecursive(100)).isNull();
    }

    @Test
    public void testGetRecursiveOOBNeg() {
        deque.addLast(1);
        assertThat(deque.getRecursive(-1)).isNull();
    }

    // Size Tests
    @Test
    public void testSize() {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.size()).isEqualTo(2);
    }

    @Test
    public void testSizeAfterRemoveToEmpty() {
        deque.addLast(1);
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(0);
    }

    @Test
    public void testSizeAfterRemoveFromEmpty() {
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(0);
    }

    // IsEmpty Tests
    @Test
    public void testIsEmptyTrue() {
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyFalse() {
        deque.addFirst(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    // ToList Tests
    @Test
    public void testToListEmpty() {
        assertThat(deque.toList()).isEmpty();
    }

    @Test
    public void testToListNonEmpty() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertThat(deque.toList()).containsExactly(1, 2, 3).inOrder();
    }
}