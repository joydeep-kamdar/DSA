import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList03Test {
    private DoublyLinkedList03<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList03<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
    
    @Test
    void testRemoveFirst() {
        assertEquals(10, list.removeFirst());
        assertEquals("[20, 30]", list.toString());
    }
    
    @Test
    void testRemoveLast() {
        assertEquals(30, list.removeLast());
        assertEquals("[10, 20]", list.toString());
    }
    
    @Test
    void testRemoveAt() {
        assertEquals(20, list.removeAt(1));
        assertEquals("[10, 30]", list.toString());
    }
}
