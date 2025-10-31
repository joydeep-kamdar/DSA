import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList08Test {
    private SinglyLinkedList08<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList08<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
    
    @Test
    void testGet() {
        assertEquals(20, list.get(1));
    }
    
    @Test
    void testIndexOf() {
        assertEquals(1, list.indexOf(20));
        assertEquals(-1, list.indexOf(99));
    }
    
    @Test
    void testSet() {
        assertEquals(20, list.set(1, 25));
        assertEquals("[10, 25, 30]", list.toString());
    }
    
    @Test
    void testContains() {
        assertTrue(list.contains(20));
        assertFalse(list.contains(99));
    }
}
