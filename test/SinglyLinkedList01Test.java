/**
 * SinglyLinkedList01Test - JUnit tests for SinglyLinkedList01
 * 
 * LEARNING OBJECTIVES:
 * 1. Test LinkedList data structure operations
 * 2. Verify edge cases (empty list, single element, multiple elements)
 * 3. Understand testing ADT (Abstract Data Type) behavior
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList01Test {
    private SinglyLinkedList01<Integer> intList;
    private SinglyLinkedList01<String> stringList;
    
    @BeforeEach
    void setUp() {
        intList = new SinglyLinkedList01<>();
        stringList = new SinglyLinkedList01<>();
    }
    
    /**
     * Test 1: New list should be empty
     */
    @Test
    void testNewListIsEmpty() {
        // Assert
        assertTrue(intList.isEmpty(), "New list should be empty");
        assertEquals(0, intList.size(), "New list should have size 0");
        assertEquals("[]", intList.toString(), "Empty list should display as []");
    }
    
    /**
     * Test 2: Add single element to empty list
     */
    @Test
    void testAddFirstToEmptyList() {
        // Act
        intList.addFirst(10);
        
        // Assert
        assertFalse(intList.isEmpty(), "List should not be empty after adding");
        assertEquals(1, intList.size(), "List size should be 1");
        assertEquals(10, intList.getFirst(), "First element should be 10");
        assertEquals("[10]", intList.toString(), "List should display as [10]");
    }
    
    /**
     * Test 3: Add multiple elements
     */
    @Test
    void testAddFirstMultipleElements() {
        // Act
        intList.addFirst(10);
        intList.addFirst(20);
        intList.addFirst(30);
        
        // Assert
        assertEquals(3, intList.size(), "List should have 3 elements");
        assertEquals(30, intList.getFirst(), "First element should be 30 (last added)");
        assertEquals("[30, 20, 10]", intList.toString(), 
                     "Elements should be in reverse order of insertion");
    }
    
    /**
     * Test 4: Verify reverse order of addFirst
     */
    @Test
    void testAddFirstReverseOrder() {
        // Act - add 1, 2, 3, 4, 5
        for (int i = 1; i <= 5; i++) {
            intList.addFirst(i);
        }
        
        // Assert - should be 5, 4, 3, 2, 1
        assertEquals("[5, 4, 3, 2, 1]", intList.toString(),
                     "Elements should be in reverse order");
        assertEquals(5, intList.getFirst(), "First element should be 5");
    }
    
    /**
     * Test 5: Test with String type
     */
    @Test
    void testAddFirstWithStrings() {
        // Act
        stringList.addFirst("Alice");
        stringList.addFirst("Bob");
        stringList.addFirst("Charlie");
        
        // Assert
        assertEquals(3, stringList.size(), "List should have 3 strings");
        assertEquals("Charlie", stringList.getFirst(), "First should be Charlie");
        assertEquals("[Charlie, Bob, Alice]", stringList.toString(),
                     "Strings should be in reverse order");
    }
    
    /**
     * Test 6: isEmpty() returns false after adding elements
     */
    @Test
    void testIsEmptyAfterAdding() {
        // Arrange - empty list
        assertTrue(intList.isEmpty(), "List should start empty");
        
        // Act
        intList.addFirst(42);
        
        // Assert
        assertFalse(intList.isEmpty(), "List should not be empty after adding");
    }
    
    /**
     * Test 7: Size increases correctly
     */
    @Test
    void testSizeIncreasesCorrectly() {
        // Assert initial size
        assertEquals(0, intList.size(), "Initial size should be 0");
        
        // Add elements and check size after each addition
        intList.addFirst(10);
        assertEquals(1, intList.size(), "Size should be 1 after first add");
        
        intList.addFirst(20);
        assertEquals(2, intList.size(), "Size should be 2 after second add");
        
        intList.addFirst(30);
        assertEquals(3, intList.size(), "Size should be 3 after third add");
    }
    
    /**
     * Test 8: getFirst() on empty list returns null
     */
    @Test
    void testGetFirstOnEmptyList() {
        // Act
        Integer result = intList.getFirst();
        
        // Assert
        assertNull(result, "getFirst() on empty list should return null");
    }
    
    /**
     * Test 9: getFirst() always returns the most recently added element
     */
    @Test
    void testGetFirstAlwaysReturnsMostRecent() {
        // Act & Assert
        intList.addFirst(10);
        assertEquals(10, intList.getFirst(), "First should be 10");
        
        intList.addFirst(20);
        assertEquals(20, intList.getFirst(), "First should be 20 after adding it");
        
        intList.addFirst(30);
        assertEquals(30, intList.getFirst(), "First should be 30 after adding it");
    }
    
    /**
     * Test 10: Adding null values
     */
    @Test
    void testAddFirstWithNull() {
        // Act
        stringList.addFirst(null);
        stringList.addFirst("Hello");
        
        // Assert
        assertEquals(2, stringList.size(), "Should have 2 elements including null");
        assertEquals("Hello", stringList.getFirst(), "First should be Hello");
    }
    
    /**
     * Test 11: Large number of additions
     */
    @Test
    void testAddFirstManyElements() {
        // Act - add 100 elements
        for (int i = 0; i < 100; i++) {
            intList.addFirst(i);
        }
        
        // Assert
        assertEquals(100, intList.size(), "Should have 100 elements");
        assertEquals(99, intList.getFirst(), "First element should be 99");
        assertFalse(intList.isEmpty(), "List should not be empty");
    }
    
    /**
     * Test 12: toString() format verification
     */
    @Test
    void testToStringFormat() {
        // Empty list
        assertEquals("[]", intList.toString(), "Empty list format");
        
        // Single element
        intList.addFirst(5);
        assertEquals("[5]", intList.toString(), "Single element format");
        
        // Multiple elements
        intList.addFirst(10);
        intList.addFirst(15);
        assertEquals("[15, 10, 5]", intList.toString(), "Multiple elements format");
    }
    
    /**
     * Test 13: Test with duplicate values
     */
    @Test
    void testAddFirstWithDuplicates() {
        // Act
        intList.addFirst(5);
        intList.addFirst(10);
        intList.addFirst(5);
        intList.addFirst(10);
        
        // Assert
        assertEquals(4, intList.size(), "Should allow duplicates");
        assertEquals("[10, 5, 10, 5]", intList.toString(), 
                     "Duplicates should be preserved");
    }
}
