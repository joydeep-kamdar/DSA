import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList04Test {
    private SinglyLinkedList04<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList04<>();
    }
    
    @Test
    void testAddAtBeginning() {
        list.addLast(10);
        list.addLast(20);
        list.addAt(0, 5);
        assertEquals("[5, 10, 20]", list.toString());
    }
    
    @Test
    void testAddAtMiddle() {
        list.addLast(10);
        list.addLast(30);
        list.addAt(1, 20);
        assertEquals("[10, 20, 30]", list.toString());
    }
    
    @Test
    void testAddAtEnd() {
        list.addLast(10);
        list.addLast(20);
        list.addAt(2, 30);
        assertEquals("[10, 20, 30]", list.toString());
    }
    
    @Test
    void testAddAtEmptyList() {
        list.addAt(0, 10);
        assertEquals("[10]", list.toString());
    }
    
    @Test
    void testAddAtNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(-1, 10));
    }
    
    @Test
    void testAddAtOutOfBounds() {
        list.addLast(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(10, 20));
    }
    
    @Test
    void testAddAtMultiplePositions() {
        list.addAt(0, 1);
        list.addAt(1, 3);
        list.addAt(1, 2);
        assertEquals("[1, 2, 3]", list.toString());
    }
}
