import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList05Test {
    private SinglyLinkedList05<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList05<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
    
    @Test
    void testRemoveFirst() {
        assertEquals(10, list.removeFirst());
        assertEquals("[20, 30]", list.toString());
        assertEquals(2, list.size());
    }
    
    @Test
    void testRemoveFirstMultiple() {
        list.removeFirst();
        list.removeFirst();
        assertEquals("[30]", list.toString());
    }
    
    @Test
    void testRemoveFirstUntilEmpty() {
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertTrue(list.isEmpty());
    }
    
    @Test
    void testRemoveFirstOnEmpty() {
        SinglyLinkedList05<Integer> empty = new SinglyLinkedList05<>();
        assertNull(empty.removeFirst());
    }
}
