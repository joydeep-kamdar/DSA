import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList07Test {
    private SinglyLinkedList07<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList07<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
    
    @Test
    void testRemoveByValue() {
        assertTrue(list.remove(20));
        assertEquals("[10, 30]", list.toString());
    }
    
    @Test
    void testRemoveValueNotFound() {
        assertFalse(list.remove(99));
        assertEquals(3, list.size());
    }
    
    @Test
    void testRemoveAt() {
        assertEquals(20, list.removeAt(1));
        assertEquals("[10, 30]", list.toString());
    }
    
    @Test
    void testRemoveAtInvalidIndex() {
        assertNull(list.removeAt(-1));
        assertNull(list.removeAt(10));
    }
}
