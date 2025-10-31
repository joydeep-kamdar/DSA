/**
 * GenericNodeTest - JUnit tests for GenericNode program
 * 
 * LEARNING OBJECTIVES:
 * 1. Test generic types with multiple data types
 * 2. Verify type safety and generic behavior
 * 3. Practice testing with custom classes
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class GenericNodeTest {
    private GenericNode genericNode;
    
    @BeforeEach
    void setUp() {
        genericNode = new GenericNode();
    }
    
    /**
     * Test 1: Creating an Integer node
     */
    @Test
    void testCreateIntegerNode() {
        // Arrange
        int testData = 42;
        
        // Act
        Node<Integer> node = genericNode.createIntegerNode(testData);
        
        // Assert
        assertNotNull(node, "Node should not be null");
        assertEquals(testData, node.data, "Node data should match input");
        assertNull(node.next, "Next reference should be null");
    }
    
    /**
     * Test 2: Creating a String node
     */
    @Test
    void testCreateStringNode() {
        // Arrange
        String testData = "Hello World";
        
        // Act
        Node<String> node = genericNode.createStringNode(testData);
        
        // Assert
        assertNotNull(node, "Node should not be null");
        assertEquals(testData, node.data, "Node data should match input");
        assertNull(node.next, "Next reference should be null");
    }
    
    /**
     * Test 3: Creating a Person node
     */
    @Test
    void testCreatePersonNode() {
        // Arrange
        Person person = new Person("Alice", 20);
        
        // Act
        Node<Person> node = genericNode.createPersonNode(person);
        
        // Assert
        assertNotNull(node, "Node should not be null");
        assertEquals(person, node.data, "Node data should match person");
        assertEquals("Alice", node.data.name, "Person name should be Alice");
        assertEquals(20, node.data.age, "Person age should be 20");
        assertNull(node.next, "Next reference should be null");
    }
    
    /**
     * Test 4: Creating an Integer chain
     */
    @Test
    void testCreateIntegerChain() {
        // Arrange & Act
        Node<Integer> head = genericNode.createIntegerChain(10, 20, 30);
        
        // Assert
        assertNotNull(head, "Head should not be null");
        assertEquals(10, head.data, "First node data should be 10");
        assertEquals(20, head.next.data, "Second node data should be 20");
        assertEquals(30, head.next.next.data, "Third node data should be 30");
        assertNull(head.next.next.next, "After third node should be null");
    }
    
    /**
     * Test 5: Creating a String chain
     */
    @Test
    void testCreateStringChain() {
        // Arrange & Act
        Node<String> head = genericNode.createStringChain("Java", "Python", "C++");
        
        // Assert
        assertNotNull(head, "Head should not be null");
        assertEquals("Java", head.data, "First node data should be 'Java'");
        assertEquals("Python", head.next.data, "Second node data should be 'Python'");
        assertEquals("C++", head.next.next.data, "Third node data should be 'C++'");
        assertNull(head.next.next.next, "After third node should be null");
    }
    
    /**
     * Test 6: Generic count method with Integers
     */
    @Test
    void testCountNodesInteger() {
        // Arrange
        Node<Integer> head = genericNode.createIntegerChain(1, 2, 3);
        
        // Act
        int count = genericNode.countNodes(head);
        
        // Assert
        assertEquals(3, count, "Should count 3 integer nodes");
    }
    
    /**
     * Test 7: Generic count method with Strings
     */
    @Test
    void testCountNodesString() {
        // Arrange
        Node<String> head = genericNode.createStringChain("A", "B", "C");
        
        // Act
        int count = genericNode.countNodes(head);
        
        // Assert
        assertEquals(3, count, "Should count 3 string nodes");
    }
    
    /**
     * Test 8: Generic count with empty chain
     */
    @Test
    void testCountNodesEmpty() {
        // Arrange
        Node<Integer> head = null;
        
        // Act
        int count = genericNode.countNodes(head);
        
        // Assert
        assertEquals(0, count, "Should count 0 for null head");
    }
    
    /**
     * Test 9: Contains method with Integer - found
     */
    @Test
    void testContainsIntegerFound() {
        // Arrange
        Node<Integer> head = genericNode.createIntegerChain(10, 20, 30);
        
        // Act & Assert
        assertTrue(genericNode.contains(head, 20), "Should find 20 in chain");
        assertTrue(genericNode.contains(head, 10), "Should find 10 in chain");
        assertTrue(genericNode.contains(head, 30), "Should find 30 in chain");
    }
    
    /**
     * Test 10: Contains method with Integer - not found
     */
    @Test
    void testContainsIntegerNotFound() {
        // Arrange
        Node<Integer> head = genericNode.createIntegerChain(10, 20, 30);
        
        // Act & Assert
        assertFalse(genericNode.contains(head, 99), "Should not find 99 in chain");
        assertFalse(genericNode.contains(head, 0), "Should not find 0 in chain");
    }
    
    /**
     * Test 11: Contains method with String - found
     */
    @Test
    void testContainsStringFound() {
        // Arrange
        Node<String> head = genericNode.createStringChain("Apple", "Banana", "Cherry");
        
        // Act & Assert
        assertTrue(genericNode.contains(head, "Banana"), "Should find 'Banana' in chain");
        assertTrue(genericNode.contains(head, "Apple"), "Should find 'Apple' in chain");
        assertTrue(genericNode.contains(head, "Cherry"), "Should find 'Cherry' in chain");
    }
    
    /**
     * Test 12: Contains method with String - not found
     */
    @Test
    void testContainsStringNotFound() {
        // Arrange
        Node<String> head = genericNode.createStringChain("Apple", "Banana", "Cherry");
        
        // Act & Assert
        assertFalse(genericNode.contains(head, "Orange"), "Should not find 'Orange' in chain");
    }
    
    /**
     * Test 13: Contains method with empty chain
     */
    @Test
    void testContainsEmptyChain() {
        // Arrange
        Node<Integer> head = null;
        
        // Act & Assert
        assertFalse(genericNode.contains(head, 10), "Should not find anything in empty chain");
    }
    
    /**
     * Test 14: Contains with Person objects
     */
    @Test
    void testContainsPerson() {
        // Arrange
        Person alice = new Person("Alice", 20);
        Person bob = new Person("Bob", 21);
        Person charlie = new Person("Charlie", 22);
        
        Node<Person> head = new Node<>(alice);
        head.next = new Node<>(bob);
        head.next.next = new Node<>(charlie);
        
        // Act & Assert
        assertTrue(genericNode.contains(head, bob), "Should find Bob in chain");
        
        // Test with equivalent Person object (same name and age)
        Person bobCopy = new Person("Bob", 21);
        assertTrue(genericNode.contains(head, bobCopy), 
                   "Should find equivalent Person (same name/age)");
        
        Person david = new Person("David", 23);
        assertFalse(genericNode.contains(head, david), "Should not find David in chain");
    }
    
    /**
     * Test 15: Node toString with different types
     */
    @Test
    void testNodeToStringGeneric() {
        // Test with Integer
        Node<Integer> intNode = new Node<>(42);
        assertEquals("Node(42)", intNode.toString(), "Integer node toString");
        
        // Test with String
        Node<String> strNode = new Node<>("Test");
        assertEquals("Node(Test)", strNode.toString(), "String node toString");
        
        // Test with Person
        Person person = new Person("Alice", 20);
        Node<Person> personNode = new Node<>(person);
        assertTrue(personNode.toString().contains("Alice"), 
                   "Person node toString should contain name");
    }
}
