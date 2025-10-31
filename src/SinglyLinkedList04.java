/**
 * Program 6: SinglyLinkedList04 - Add at Position
 * 
 * LEARNING OBJECTIVES:
 * 1. Implement addAt(index, data) - insert at specific position
 * 2. Handle multiple edge cases (index 0, middle, end, out of bounds)
 * 3. Understand pointer manipulation for insertion
 * 4. Learn importance of tracking previous node
 * 
 * KEY CONCEPTS:
 * - Insertion at index requires finding position (index-1)
 * - Must track both current and previous nodes
 * - Edge cases: index 0 (use addFirst), index >= size (use addLast or error)
 * - TIME: O(n) for finding position + O(1) for insertion = O(n) total
 *
 * CS2100 RELEVANCE:
 * - Complete insertion functionality
 * - Understanding indexed operations on linked structures
 * - Comparing with ArrayList insertion (also O(n) but different reasons)
 */

class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList04<T> {
    private Node<T> head;
    
    public SinglyLinkedList04() {
        this.head = null;
    }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    /**
     * Inserts element at specific index (0-based)
     * 
     * ALGORITHM:
     * 1. Handle special case: index 0 (same as addFirst)
     * 2. Traverse to node at (index-1)
     * 3. Create new node
     * 4. newNode.next = current.next
     * 5. current.next = newNode
     * 
     * EDGE CASES:
     * - index < 0: invalid, throw exception
     * - index == 0: use addFirst logic
     * - index >= size: add at end (or throw exception - design choice)
     * 
     * TIME COMPLEXITY: O(n) where n is the index
     * 
     * @param index Position to insert at (0-based)
     * @param data Element to insert
     * @throws IndexOutOfBoundsException if index < 0
     */
    public void addAt(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
        }
        
        // Special case: insert at beginning
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        // Traverse to position (index-1)
        Node<T> current = head;
        int currentIndex = 0;
        
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        
        // If current is null, index is out of bounds
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        
        // Insert new node after current
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;  // New node points to next node
        current.next = newNode;        // Previous node points to new node
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public T get(int index) {
        if (index < 0) {
            return null;
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
        return null;
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
        System.out.println("=== PROGRAM 6: SINGLY LINKED LIST - ADD AT POSITION ===\n");
        
        SinglyLinkedList04<String> list = new SinglyLinkedList04<>();
        
        // Demo 1: Build list with addAt
        System.out.println("Demo 1: Building list with addAt()");
        list.addAt(0, "A");     // [A]
        System.out.println("addAt(0, 'A'): " + list);
        list.addAt(1, "C");     // [A, C]
        System.out.println("addAt(1, 'C'): " + list);
        list.addAt(1, "B");     // [A, B, C]
        System.out.println("addAt(1, 'B'): " + list);
        list.addAt(3, "E");     // [A, B, C, E]
        System.out.println("addAt(3, 'E'): " + list);
        list.addAt(3, "D");     // [A, B, C, D, E]
        System.out.println("addAt(3, 'D'): " + list);
        System.out.println();
        
        // Demo 2: Insert at beginning, middle, end
        System.out.println("Demo 2: Positional insertions");
        SinglyLinkedList04<Integer> nums = new SinglyLinkedList04<>();
        nums.addLast(10);
        nums.addLast(20);
        nums.addLast(30);
        System.out.println("Initial: " + nums);
        
        nums.addAt(0, 5);   // Insert at beginning
        System.out.println("After addAt(0, 5): " + nums);
        
        nums.addAt(2, 15);  // Insert in middle
        System.out.println("After addAt(2, 15): " + nums);
        
        nums.addAt(5, 40);  // Insert at end
        System.out.println("After addAt(5, 40): " + nums);
        System.out.println();
        
        // Demo 3: Error handling
        System.out.println("Demo 3: Error handling");
        try {
            nums.addAt(-1, 999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception for negative index: " + e.getMessage());
        }
        
        try {
            nums.addAt(100, 999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception for large index: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. addAt() allows insertion at any valid position");
        System.out.println("2. Must track previous node to insert correctly");
        System.out.println("3. Edge cases: index 0 (beginning), end, out of bounds");
        System.out.println("4. Time complexity: O(n) to find position");
        System.out.println("5. Always validate index to avoid errors");
    }
}
