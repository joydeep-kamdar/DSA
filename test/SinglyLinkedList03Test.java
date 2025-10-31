import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList03Test {
    private SinglyLinkedList03<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList03<>();
    }
    
    @Test
    void testAddLastToEmptyList() {
        list.addLast(10);
        assertEquals("[10]", list.toString());
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(10, list.getLast());
    }
    
    @Test
    void testAddLastMultiple() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        
        assertEquals("[10, 20, 30]", list.toString());
        assertEquals(3, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(30, list.getLast());
    }
    
    @Test
    void testAddLastPreservesOrder() {
        for (int i = 1; i <= 5; i++) {
            list.addLast(i);
        }
        assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }
    
    @Test
    void testMixedAddFirstAndAddLast() {
        list.addLast(20);
        list.addFirst(10);
        list.addLast(30);
        list.addFirst(5);
        
        assertEquals("[5, 10, 20, 30]", list.toString());
    }
    
    @Test
    void testGetLastEmptyList() {
        assertNull(list.getLast());
    }
    
    @Test
    void testGetLastSingleElement() {
        list.addLast(42);
        assertEquals(42, list.getLast());
    }
    
    @Test
    void testGetLastMultipleElements() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(30, list.getLast());
    }
    
    @Test
    void testAddLastVsAddFirstOrder() {
        SinglyLinkedList03<Integer> lastList = new SinglyLinkedList03<>();
        SinglyLinkedList03<Integer> firstList = new SinglyLinkedList03<>();
        
        lastList.addLast(1);
        lastList.addLast(2);
        lastList.addLast(3);
        
        firstList.addFirst(1);
        firstList.addFirst(2);
        firstList.addFirst(3);
        
        assertEquals("[1, 2, 3]", lastList.toString());
        assertEquals("[3, 2, 1]", firstList.toString());
    }
}
