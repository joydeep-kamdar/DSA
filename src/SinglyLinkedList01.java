/**
 * Program 3: SinglyLinkedList01 - Basic LinkedList with addFirst
 * 
 * LEARNING OBJECTIVES:
 * 1. Create a LinkedList class that manages nodes
 * 2. Implement addFirst() - adding elements at the beginning
 * 3. Understand the "head" pointer concept
 * 4. Learn why adding at the front is O(1) - constant time
 * 
 * KEY CONCEPTS:
 * - LinkedList class: Manages the chain of nodes
 * - Head pointer: Always points to the first node (or null if empty)
 * - addFirst() is very fast: Just update head, no matter how long the list is
 * - Each new element becomes the new head
 * 
 * TIME COMPLEXITY:
 * - addFirst(): O(1) - constant time, always takes same number of steps
 * 
 * CS2100 RELEVANCE:
 * - Foundation for implementing the LinkedList ADT (Abstract Data Type)
 * - Understanding O(1) operations vs O(n) operations
 * - Building blocks for stacks and other data structures
 */

/**
 * Node class - generic node for any data type
 */
class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return "Node(" + data + ")";
    }
}

/**
 * SinglyLinkedList - A proper LinkedList implementation
 * 
 * This class encapsulates all the node management logic.
 * Users of this class don't need to worry about nodes - they just add data!
 * 
 * @param <T> The type of elements stored in the list
 */
public class SinglyLinkedList01<T> {
    private Node<T> head;  // Points to the first node (null if list is empty)
    
    /**
     * Constructor - creates an empty list
     */
    public SinglyLinkedList01() {
        this.head = null;  // Start with empty list
    }
    
    /**
     * Adds a new element at the beginning of the list
     * 
     * ALGORITHM:
     * 1. Create a new node with the data
     * 2. Make new node point to current head
     * 3. Update head to point to new node
     * 
     * WHY THIS IS O(1):
     * - No matter if the list has 10 or 10,000 elements
     * - We only do these 3 steps
     * - We don't need to traverse the list
     * 
     * Example:
     *   Empty list: null
     *   addFirst(5): 5 -> null
     *   addFirst(10): 10 -> 5 -> null
     *   addFirst(15): 15 -> 10 -> 5 -> null
     * 
     * @param data The element to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);  // Step 1: Create new node
        newNode.next = head;                  // Step 2: New node points to old head
        head = newNode;                       // Step 3: Head now points to new node
        
        // That's it! Only 3 simple operations, regardless of list size
    }
    
    /**
     * Checks if the list is empty
     * 
     * @return true if list has no elements, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Returns the number of elements in the list
     * Must traverse the entire list to count
     * 
     * TIME COMPLEXITY: O(n) where n is the number of elements
     * 
     * @return The number of elements
     */
    public int size() {
        int count = 0;
        Node<T> current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    /**
     * Returns the first element without removing it
     * 
     * @return The first element, or null if list is empty
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }
    
    /**
     * Returns a string representation of the list
     * Format: [element1, element2, element3]
     * 
     * This is very useful for debugging and testing!
     * 
     * @return String representation of the list
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Prints the list in a visual format showing the chain
     * Format: element1 -> element2 -> element3 -> null
     */
    public void printList() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    /**
     * Main method - demonstrates the LinkedList
     */
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 3: SINGLY LINKED LIST - ADD FIRST ===\n");
        
        // Demo 1: Creating an empty list
        System.out.println("Demo 1: Creating an empty list");
        SinglyLinkedList01<Integer> list = new SinglyLinkedList01<>();
        System.out.println("New list: " + list);
        System.out.println("Is empty? " + list.isEmpty());
        System.out.println("Size: " + list.size());
        System.out.println();
        
        // Demo 2: Adding elements to the front
        System.out.println("Demo 2: Adding elements to the front");
        System.out.println("Adding 10...");
        list.addFirst(10);
        list.printList();
        System.out.println("List: " + list);
        System.out.println();
        
        System.out.println("Adding 20...");
        list.addFirst(20);
        list.printList();
        System.out.println("List: " + list);
        System.out.println();
        
        System.out.println("Adding 30...");
        list.addFirst(30);
        list.printList();
        System.out.println("List: " + list);
        System.out.println();
        
        // Demo 3: List properties
        System.out.println("Demo 3: List properties");
        System.out.println("Is empty? " + list.isEmpty());
        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println();
        
        // Demo 4: String list
        System.out.println("Demo 4: String LinkedList");
        SinglyLinkedList01<String> names = new SinglyLinkedList01<>();
        names.addFirst("Alice");
        names.addFirst("Bob");
        names.addFirst("Charlie");
        System.out.println("Names: " + names);
        names.printList();
        System.out.println("First name: " + names.getFirst());
        System.out.println();
        
        // Demo 5: Understanding the order
        System.out.println("Demo 5: Understanding addFirst() order");
        SinglyLinkedList01<Integer> nums = new SinglyLinkedList01<>();
        System.out.println("Adding 1, 2, 3, 4, 5 using addFirst()...");
        for (int i = 1; i <= 5; i++) {
            nums.addFirst(i);
            System.out.println("After adding " + i + ": " + nums);
        }
        System.out.println("Notice: Elements are in REVERSE order!");
        System.out.println("Last added element is FIRST in the list");
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. LinkedList class manages a chain of nodes via 'head' pointer");
        System.out.println("2. addFirst() is O(1) - very fast, always takes same time");
        System.out.println("3. Elements added with addFirst appear in reverse order");
        System.out.println("4. head always points to the first node (or null if empty)");
        System.out.println("5. size() requires traversing the list - O(n) operation");
    }
}
