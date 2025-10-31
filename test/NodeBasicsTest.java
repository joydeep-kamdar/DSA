/**
 * NodeBasicsTest - JUnit tests for NodeBasics program
 * 
 * LEARNING OBJECTIVES:
 * 1. Understand how to write unit tests
 * 2. Learn the Arrange-Act-Assert pattern
 * 3. Practice verifying node operations
 * 
 * TEST STRUCTURE:
 * - @BeforeEach: Runs before each test (setup)
 * - @Test: Marks a method as a test case
 * - Assertions: Verify expected behavior (assertEquals, assertNull, assertNotNull, etc.)
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class NodeBasicsTest {
    private NodeBasics nodeBasics;
    
    /**
     * Setup method - runs before each test
     * Creates a fresh NodeBasics instance for each test
     */
    @BeforeEach
    void setUp() {
        nodeBasics = new NodeBasics();
    }
    
    /**
     * Test 1: Creating a single node
     * Verifies that a node is created with correct data and null next
     */
    @Test
    void testCreateSingleNode() {
        // Arrange (setup) - done in setUp()
        int testData = 42;
        
        // Act (perform the operation)
        Node node = nodeBasics.createSingleNode(testData);
        
        // Assert (verify the results)
        assertNotNull(node, "Node should not be null");
        assertEquals(testData, node.data, "Node data should match input");
        assertNull(node.next, "Next reference should be null for single node");
    }
    
    /**
     * Test 2: Linking two nodes
     * Verifies that two nodes are correctly linked together
     */
    @Test
    void testLinkTwoNodes() {
        // Arrange
        Node first = new Node(10);
        Node second = new Node(20);
        
        // Act
        nodeBasics.linkTwoNodes(first, second);
        
        // Assert
        assertNotNull(first.next, "First node's next should not be null");
        assertEquals(second, first.next, "First node should point to second node");
        assertEquals(20, first.next.data, "Following next should give second node's data");
        assertNull(second.next, "Second node's next should still be null");
    }
    
    /**
     * Test 3: Creating a chain of three nodes
     * Verifies the entire chain structure
     */
    @Test
    void testCreateThreeNodeChain() {
        // Arrange
        int data1 = 5, data2 = 10, data3 = 15;
        
        // Act
        Node head = nodeBasics.createThreeNodeChain(data1, data2, data3);
        
        // Assert - check first node
        assertNotNull(head, "Head should not be null");
        assertEquals(data1, head.data, "First node data should be " + data1);
        
        // Assert - check second node
        assertNotNull(head.next, "Second node should exist");
        assertEquals(data2, head.next.data, "Second node data should be " + data2);
        
        // Assert - check third node
        assertNotNull(head.next.next, "Third node should exist");
        assertEquals(data3, head.next.next.data, "Third node data should be " + data3);
        
        // Assert - check end of chain
        assertNull(head.next.next.next, "After third node should be null");
    }
    
    /**
     * Test 4: Counting nodes in a chain
     * Tests the traversal logic
     */
    @Test
    void testCountNodes() {
        // Arrange - create chain of three nodes
        Node head = nodeBasics.createThreeNodeChain(1, 2, 3);
        
        // Act
        int count = nodeBasics.countNodes(head);
        
        // Assert
        assertEquals(3, count, "Should count 3 nodes in the chain");
    }
    
    /**
     * Test 5: Counting nodes in empty chain
     * Tests edge case of null head
     */
    @Test
    void testCountNodesEmptyChain() {
        // Arrange
        Node head = null;
        
        // Act
        int count = nodeBasics.countNodes(head);
        
        // Assert
        assertEquals(0, count, "Should count 0 nodes for null head");
    }
    
    /**
     * Test 6: Counting single node
     * Tests edge case of single node chain
     */
    @Test
    void testCountNodesSingleNode() {
        // Arrange
        Node head = new Node(100);
        
        // Act
        int count = nodeBasics.countNodes(head);
        
        // Assert
        assertEquals(1, count, "Should count 1 node");
    }
    
    /**
     * Test 7: Finding last node in chain
     * Verifies correct traversal to the end
     */
    @Test
    void testFindLastNode() {
        // Arrange
        Node head = nodeBasics.createThreeNodeChain(5, 10, 15);
        
        // Act
        Node last = nodeBasics.findLastNode(head);
        
        // Assert
        assertNotNull(last, "Last node should not be null");
        assertEquals(15, last.data, "Last node should have data 15");
        assertNull(last.next, "Last node's next should be null");
    }
    
    /**
     * Test 8: Finding last node in single node chain
     * Edge case: head is also the last node
     */
    @Test
    void testFindLastNodeSingleNode() {
        // Arrange
        Node head = new Node(42);
        
        // Act
        Node last = nodeBasics.findLastNode(head);
        
        // Assert
        assertNotNull(last, "Last node should not be null");
        assertEquals(head, last, "In single node chain, head is the last node");
        assertEquals(42, last.data, "Last node should have data 42");
    }
    
    /**
     * Test 9: Finding last node in empty chain
     * Edge case: null head
     */
    @Test
    void testFindLastNodeEmptyChain() {
        // Arrange
        Node head = null;
        
        // Act
        Node last = nodeBasics.findLastNode(head);
        
        // Assert
        assertNull(last, "Last node should be null for empty chain");
    }
    
    /**
     * Test 10: Node toString method
     * Verifies string representation
     */
    @Test
    void testNodeToString() {
        // Arrange
        Node node = new Node(99);
        
        // Act
        String result = node.toString();
        
        // Assert
        assertEquals("Node(99)", result, "toString should return 'Node(99)'");
    }
}
