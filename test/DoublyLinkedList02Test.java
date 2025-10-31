import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList02Test {
    private DoublyLinkedList02<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList02<>();
    }
    
    @Test
    void testAddAtBeginning() {
        list.addLast(2);
        list.addAt(0, 1);
        assertEquals("[1, 2]", list.toString());
    }
    
    @Test
    void testAddAtMiddle() {
        list.addLast(1);
        list.addLast(3);
        list.addAt(1, 2);
        assertEquals("[1, 2, 3]", list.toString());
    }
    
    @Test
    void testAddAtEnd() {
        list.addLast(1);
        list.addAt(1, 2);
        assertEquals("[1, 2]", list.toString());
    }
}
