/**
 * Program 1: NodeBasics
 * 
 * LEARNING OBJECTIVES:
 * 1. Understand what a Node is - the building block of LinkedLists
 * 2. Learn about object references (how objects point to each other)
 * 3. Practice creating and linking nodes manually
 * 4. Visualize how nodes connect in memory
 * 
 * KEY CONCEPTS:
 * - A Node contains DATA and a REFERENCE to the next node
 * - References are like arrows pointing from one node to another
 * - null means "pointing to nothing" (end of list)
 * 
 * CS2100 RELEVANCE:
 * - Foundation for all LinkedList operations
 * - Understanding references is critical for pointers concept
 * - Basis for understanding dynamic data structures
 */

/**
 * Node class - the building block of a LinkedList
 * 
 * Each node has two parts:
 * 1. data - stores the actual value (an integer in this case)
 * 2. next - a reference to the next node in the chain (or null if last node)
 */
class Node {
    int data;      // The value stored in this node
    Node next;     // Reference to the next node (null if this is the last node)
    
    /**
     * Constructor - creates a new node with the given data
     * The next reference is automatically set to null
     * 
     * @param data The integer value to store in this node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;  // By default, node doesn't point to anything
    }
    
    /**
     * Returns a string representation of this node
     * Useful for debugging and visualization
     */
    @Override
    public String toString() {
        return "Node(" + data + ")";
    }
}

/**
 * NodeBasics class - demonstrates basic node operations
 * This class shows how to create nodes and link them together manually
 */
public class NodeBasics {
    
    /**
     * Creates a single node
     * Demonstrates that a node can exist by itself
     */
    public Node createSingleNode(int data) {
        Node node = new Node(data);
        // At this point: node.data = data, node.next = null
        return node;
    }
    
    /**
     * Links two nodes together
     * This demonstrates how nodes form a chain
     * 
     * Example: node1 -> node2
     * 
     * @param node1 The first node (will point to node2)
     * @param node2 The second node (will be pointed to by node1)
     */
    public void linkTwoNodes(Node node1, Node node2) {
        node1.next = node2;
        // Now node1.next points to node2
        // node2.next is still null (it's the end)
    }
    
    /**
     * Creates a chain of three nodes and returns the first one
     * This is like a mini LinkedList!
     * 
     * Creates: first -> second -> third -> null
     * 
     * @param data1 Value for first node
     * @param data2 Value for second node
     * @param data3 Value for third node
     * @return Reference to the first node (the "head" of the chain)
     */
    public Node createThreeNodeChain(int data1, int data2, int data3) {
        // Create three separate nodes
        Node first = new Node(data1);
        Node second = new Node(data2);
        Node third = new Node(data3);
        
        // Link them together
        first.next = second;   // first points to second
        second.next = third;   // second points to third
        // third.next is null (end of chain)
        
        return first;  // Return the head of the chain
    }
    
    /**
     * Traverses (walks through) a node chain and prints each value
     * This demonstrates how to follow the next references
     * 
     * KEY CONCEPT: This is the fundamental pattern for LinkedList operations!
     * - Start at the head
     * - While current node is not null:
     *   - Process current node
     *   - Move to next node
     * 
     * @param head The first node in the chain
     */
    public void traverseAndPrint(Node head) {
        Node current = head;  // Start at the beginning
        
        System.out.print("Traversing: ");
        while (current != null) {  // Keep going until we reach the end
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;  // Move to the next node
        }
        System.out.println(" -> null");
    }
    
    /**
     * Counts the number of nodes in a chain
     * Another example of traversal with a different purpose
     * 
     * @param head The first node in the chain
     * @return The number of nodes in the chain
     */
    public int countNodes(Node head) {
        int count = 0;
        Node current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    /**
     * Finds the last node in a chain
     * Demonstrates traversing until the end
     * 
     * @param head The first node in the chain
     * @return The last node (the one where next == null)
     */
    public Node findLastNode(Node head) {
        if (head == null) {
            return null;  // Empty chain
        }
        
        Node current = head;
        // Keep moving forward until we find a node whose next is null
        while (current.next != null) {
            current = current.next;
        }
        
        return current;  // This is the last node
    }
    
    /**
     * Main method - demonstrates all the concepts
     * Run this to see nodes in action!
     */
    public static void main(String[] args) {
        NodeBasics demo = new NodeBasics();
        
        System.out.println("=== PROGRAM 1: NODE BASICS ===\n");
        
        // Demo 1: Single node
        System.out.println("Demo 1: Creating a single node");
        Node single = demo.createSingleNode(42);
        System.out.println("Created: " + single);
        System.out.println("Its next reference: " + single.next);
        System.out.println();
        
        // Demo 2: Two linked nodes
        System.out.println("Demo 2: Linking two nodes");
        Node first = new Node(10);
        Node second = new Node(20);
        demo.linkTwoNodes(first, second);
        System.out.println("First node: " + first + ", points to: " + first.next);
        System.out.println("Second node: " + second + ", points to: " + second.next);
        System.out.println();
        
        // Demo 3: Chain of three nodes
        System.out.println("Demo 3: Creating a chain of three nodes");
        Node head = demo.createThreeNodeChain(5, 10, 15);
        demo.traverseAndPrint(head);
        System.out.println("Number of nodes: " + demo.countNodes(head));
        Node last = demo.findLastNode(head);
        System.out.println("Last node: " + last);
        System.out.println();
        
        // Demo 4: Accessing nodes through references
        System.out.println("Demo 4: Following the chain manually");
        System.out.println("head.data = " + head.data);
        System.out.println("head.next.data = " + head.next.data);
        System.out.println("head.next.next.data = " + head.next.next.data);
        // System.out.println("head.next.next.next.data = " + head.next.next.next.data); 
        // ^ This would cause NullPointerException! (head.next.next.next is null)
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. Nodes are objects that contain data and a reference to another node");
        System.out.println("2. Linking nodes creates chains (the basis of LinkedLists)");
        System.out.println("3. Traversal: Start at head, follow next until reaching null");
        System.out.println("4. Always check for null to avoid NullPointerException!");
    }
}
