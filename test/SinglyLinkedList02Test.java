/**
 * SinglyLinkedList02Test - Tests for traversal operations
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList02Test {
    private SinglyLinkedList02<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList02<>();
        // Create list: [50, 40, 30, 20, 10]
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
    }
    
    @Test
    void testContainsFound() {
        assertTrue(list.contains(30), "Should find 30");
        assertTrue(list.contains(10), "Should find 10");
        assertTrue(list.contains(50), "Should find 50");
    }
    
    @Test
    void testContainsNotFound() {
        assertFalse(list.contains(100), "Should not find 100");
        assertFalse(list.contains(0), "Should not find 0");
    }
    
    @Test
    void testContainsEmptyList() {
        SinglyLinkedList02<Integer> empty = new SinglyLinkedList02<>();
        assertFalse(empty.contains(10), "Empty list should not contain anything");
    }
    
    @Test
    void testContainsNull() {
        SinglyLinkedList02<String> strList = new SinglyLinkedList02<>();
        strList.addFirst("Hello");
        strList.addFirst(null);
        strList.addFirst("World");
        
        assertTrue(strList.contains(null), "Should find null value");
        assertTrue(strList.contains("Hello"), "Should find Hello");
    }
    
    @Test
    void testGetValidIndices() {
        assertEquals(50, list.get(0), "Index 0 should be 50");
        assertEquals(40, list.get(1), "Index 1 should be 40");
        assertEquals(30, list.get(2), "Index 2 should be 30");
        assertEquals(20, list.get(3), "Index 3 should be 20");
        assertEquals(10, list.get(4), "Index 4 should be 10");
    }
    
    @Test
    void testGetInvalidIndices() {
        assertNull(list.get(-1), "Negative index should return null");
        assertNull(list.get(10), "Out of bounds should return null");
        assertNull(list.get(100), "Large out of bounds should return null");
    }
    
    @Test
    void testGetEmptyList() {
        SinglyLinkedList02<Integer> empty = new SinglyLinkedList02<>();
        assertNull(empty.get(0), "Get on empty list should return null");
    }
    
    @Test
    void testIndexOfFound() {
        assertEquals(0, list.indexOf(50), "50 should be at index 0");
        assertEquals(2, list.indexOf(30), "30 should be at index 2");
        assertEquals(4, list.indexOf(10), "10 should be at index 4");
    }
    
    @Test
    void testIndexOfNotFound() {
        assertEquals(-1, list.indexOf(100), "100 not in list, should return -1");
        assertEquals(-1, list.indexOf(0), "0 not in list, should return -1");
    }
    
    @Test
    void testIndexOfEmptyList() {
        SinglyLinkedList02<Integer> empty = new SinglyLinkedList02<>();
        assertEquals(-1, empty.indexOf(10), "Empty list should return -1");
    }
    
    @Test
    void testIndexOfNull() {
        SinglyLinkedList02<String> strList = new SinglyLinkedList02<>();
        strList.addFirst("A");
        strList.addFirst(null);
        strList.addFirst("B");
        
        assertEquals(1, strList.indexOf(null), "null should be at index 1");
    }
    
    @Test
    void testIndexOfDuplicates() {
        list.addFirst(30);  // Now list has 30 twice
        // List is now: [30, 50, 40, 30, 20, 10]
        assertEquals(0, list.indexOf(30), "Should return first occurrence");
    }
    
    @Test
    void testToString() {
        assertEquals("[50, 40, 30, 20, 10]", list.toString());
    }
}
