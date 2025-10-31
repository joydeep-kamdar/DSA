/**
 * Program 4: SinglyLinkedList02 - Traversal Operations
 * 
 * LEARNING OBJECTIVES:
 * 1. Master list traversal pattern
 * 2. Implement operations that walk through the list
 * 3. Understand why traversal operations are O(n)
 * 4. Build on previous program by adding more methods
 * 
 * KEY CONCEPTS:
 * - Traversal: Walking through the list from head to end
 * - Pattern: current = head; while (current != null) { ... current = current.next; }
 * - All traversal operations are O(n) - time grows with list size
 * 
 * NEW METHODS IN THIS PROGRAM:
 * - contains(data): Check if element exists
 * - get(index): Access element at specific position
 * - indexOf(data): Find position of element
 * 
 * CS2100 RELEVANCE:
 * - Understanding linear search in linked structures
 * - Comparing LinkedList vs ArrayList access patterns
 * - Building complete ADT implementations
 */

class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * SinglyLinkedList02 - LinkedList with traversal operations
 * Builds on SinglyLinkedList01 by adding search and access methods
 */
public class SinglyLinkedList02<T> {
    private Node<T> head;
    
    public SinglyLinkedList02() {
        this.head = null;
    }
    
    /**
     * Adds element at the beginning - O(1)
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    /**
     * Checks if list is empty - O(1)
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Returns size by counting nodes - O(n)
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
     * Gets first element - O(1)
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }
    
    /**
     * Checks if the list contains a specific element
     * Uses .equals() for comparison
     * 
     * ALGORITHM:
     * 1. Start at head
     * 2. Check each node's data
     * 3. If match found, return true
     * 4. If reach end without finding, return false
     * 
     * TIME COMPLEXITY: O(n) - worst case check all nodes
     * SPACE COMPLEXITY: O(1) - only use one current pointer
     * 
     * @param data The element to search for
     * @return true if found, false otherwise
     */
    public boolean contains(T data) {
        Node<T> current = head;
        
        while (current != null) {
            // Handle null data
            if (data == null && current.data == null) {
                return true;
            }
            if (data != null && data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        
        return false;  // Not found
    }
    
    /**
     * Gets element at specific index (0-based)
     * 
     * IMPORTANT: This is O(n) for LinkedLists!
     * Compare to ArrayList where get(index) is O(1)
     * 
     * ALGORITHM:
     * 1. Start at head (index 0)
     * 2. Move forward 'index' times
     * 3. Return data at that position
     * 
     * @param index The position (0-based)
     * @return The element at that position, or null if invalid index
     */
    public T get(int index) {
        if (index < 0) {
            return null;  // Invalid index
        }
        
        Node<T> current = head;
        int currentIndex = 0;
        
        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        
        return null;  // Index out of bounds
    }
    
    /**
     * Finds the index of the first occurrence of an element
     * Returns -1 if not found (following Java convention)
     * 
     * ALGORITHM:
     * 1. Traverse list while tracking current index
     * 2. When data matches, return current index
     * 3. If complete traversal without match, return -1
     * 
     * TIME COMPLEXITY: O(n)
     * 
     * @param data The element to find
     * @return Index of first occurrence, or -1 if not found
     */
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            // Handle null data
            if (data == null && current.data == null) {
                return index;
            }
            if (data != null && data.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;  // Not found
    }
    
    /**
     * Prints all elements in the list
     * Useful for debugging
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
    
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 4: SINGLY LINKED LIST - TRAVERSAL ===\n");
        
        // Setup
        SinglyLinkedList02<String> list = new SinglyLinkedList02<>();
        list.addFirst("Apple");
        list.addFirst("Banana");
        list.addFirst("Cherry");
        list.addFirst("Date");
        list.addFirst("Elderberry");
        
        System.out.println("List: " + list);
        list.printList();
        System.out.println("Size: " + list.size());
        System.out.println();
        
        // Demo 1: contains() method
        System.out.println("Demo 1: Searching with contains()");
        System.out.println("Contains 'Banana'? " + list.contains("Banana"));
        System.out.println("Contains 'Cherry'? " + list.contains("Cherry"));
        System.out.println("Contains 'Grape'? " + list.contains("Grape"));
        System.out.println("Contains 'Elderberry'? " + list.contains("Elderberry"));
        System.out.println();
        
        // Demo 2: get() method
        System.out.println("Demo 2: Accessing by index with get()");
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Element at index 3: " + list.get(3));
        System.out.println("Element at index 4: " + list.get(4));
        System.out.println("Element at index 10: " + list.get(10) + " (out of bounds)");
        System.out.println();
        
        // Demo 3: indexOf() method
        System.out.println("Demo 3: Finding position with indexOf()");
        System.out.println("Index of 'Banana': " + list.indexOf("Banana"));
        System.out.println("Index of 'Elderberry': " + list.indexOf("Elderberry"));
        System.out.println("Index of 'Apple': " + list.indexOf("Apple"));
        System.out.println("Index of 'Grape': " + list.indexOf("Grape") + " (not found)");
        System.out.println();
        
        // Demo 4: Working with numbers
        System.out.println("Demo 4: Integer list traversal");
        SinglyLinkedList02<Integer> nums = new SinglyLinkedList02<>();
        for (int i = 10; i <= 50; i += 10) {
            nums.addFirst(i);
        }
        System.out.println("Numbers: " + nums);
        System.out.println("Contains 30? " + nums.contains(30));
        System.out.println("Index of 20: " + nums.indexOf(20));
        System.out.println("Element at index 2: " + nums.get(2));
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. Traversal pattern: start at head, follow next until null");
        System.out.println("2. contains(), get(), indexOf() all require traversal - O(n)");
        System.out.println("3. LinkedList random access is slow compared to ArrayList");
        System.out.println("4. Use .equals() for proper object comparison");
        System.out.println("5. Always check for null to avoid NullPointerException");
    }
}
