import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList04Test {
    private DoublyLinkedList04<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList04<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
    }
    
    @Test
    void testForwardTraversal() {
        assertEquals("[1, 2, 3]", list.toString());
    }
    
    @Test
    void testBothTraversals() {
        list.printForward();
        list.printBackward();
        // Just verify no exceptions thrown
        assertTrue(true);
    }
}
