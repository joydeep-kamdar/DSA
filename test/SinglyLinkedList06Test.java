import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList06Test {
    private SinglyLinkedList06<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList06<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
    
    @Test
    void testRemoveLast() {
        assertEquals(30, list.removeLast());
        assertEquals("[10, 20]", list.toString());
    }
    
    @Test
    void testRemoveLastSingleElement() {
        SinglyLinkedList06<Integer> single = new SinglyLinkedList06<>();
        single.addLast(42);
        assertEquals(42, single.removeLast());
        assertTrue(single.isEmpty());
    }
    
    @Test
    void testRemoveLastOnEmpty() {
        SinglyLinkedList06<Integer> empty = new SinglyLinkedList06<>();
        assertNull(empty.removeLast());
    }
    
    @Test
    void testRemoveLastMultiple() {
        list.removeLast();
        list.removeLast();
        assertEquals("[10]", list.toString());
    }
}
