import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList01Test {
    private DoublyLinkedList01<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList01<>();
    }
    
    @Test
    void testAddFirst() {
        list.addFirst(10);
        assertEquals("[10]", list.toString());
    }
    
    @Test
    void testAddLast() {
        list.addLast(10);
        assertEquals("[10]", list.toString());
    }
    
    @Test
    void testBidirectionalTraversal() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals("[1, 2, 3]", list.toString());
        assertEquals("[3, 2, 1]", list.toStringReverse());
    }
    
    @Test
    void testMixedOperations() {
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        assertEquals("[1, 2, 3]", list.toString());
    }
}
