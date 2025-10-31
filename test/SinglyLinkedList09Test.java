import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList09Test {
    private SinglyLinkedList09<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList09<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
    }
    
    @Test
    void testReverse() {
        list.reverse();
        assertEquals("[3, 2, 1]", list.toString());
    }
    
    @Test
    void testReverseEmpty() {
        SinglyLinkedList09<Integer> empty = new SinglyLinkedList09<>();
        empty.reverse();
        assertTrue(empty.isEmpty());
    }
    
    @Test
    void testClear() {
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }
}
