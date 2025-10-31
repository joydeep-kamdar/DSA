import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListAlgorithmsTest {
    private SinglyLinkedListAlgorithms<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedListAlgorithms<>();
    }
    
    @Test
    void testFindMiddle() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertEquals(3, list.findMiddle());
    }
    
    @Test
    void testFindMiddleEvenLength() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertEquals(3, list.findMiddle());  // Returns second middle
    }
    
    @Test
    void testHasCycleNoCycle() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertFalse(list.hasCycle());
    }
    
    @Test
    void testRemoveDuplicates() {
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.removeDuplicates();
        assertEquals("[1, 2, 3]", list.toString());
    }
}
