/**
 * Program 5: SinglyLinkedList03 - Add at End
 * 
 * LEARNING OBJECTIVES:
 * 1. Implement addLast() - adding at the end of list
 * 2. Understand why addLast() is O(n) without tail pointer
 * 3. Handle edge case: adding to empty list
 * 4. Compare addFirst() O(1) vs addLast() O(n)
 * 
 * KEY CONCEPTS:
 * - addLast() requires traversing to the end - O(n)
 * - Special case: Empty list (head is null)
 * - Must find the last node (where next == null)
 * - Optimization possible with tail pointer (not in this version)
 * 
 * TIME COMPLEXITY COMPARISON:
 * - addFirst(): O(1) - instant
 * - addLast(): O(n) - must traverse entire list
 * 
 * CS2100 RELEVANCE:
 * - Understanding trade-offs in data structure operations
 * - Learning when/why to use different insertion methods
 * - Foundation for understanding doubly linked lists
 */

class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList03<T> {
    private Node<T> head;
    
    public SinglyLinkedList03() {
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
     * Adds element at the end of the list
     * 
     * ALGORITHM:
     * 1. Create new node
     * 2. If list is empty, new node becomes head
     * 3. Otherwise, traverse to last node
     * 4. Make last node point to new node
     * 
     * TIME COMPLEXITY: O(n) - must traverse to find end
     * SPACE COMPLEXITY: O(1) - only create one new node
     * 
     * WHY O(n)?
     * - Must visit every node to find the last one
     * - No direct access to tail (in this version)
     * - For list of size n, make n-1 steps
     * 
     * @param data The element to add
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        // Edge case: Empty list
        if (head == null) {
            head = newNode;
            return;
        }
        
        // Traverse to find last node
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Now current is the last node
        current.next = newNode;
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
    
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }
    
    /**
     * Gets the last element without removing it
     * O(n) - must traverse to end
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
    
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (data == null && current.data == null) {
                return true;
            }
            if (data != null && data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
        System.out.println("=== PROGRAM 5: SINGLY LINKED LIST - ADD LAST ===\n");
        
        // Demo 1: Compare addFirst vs addLast
        System.out.println("Demo 1: Comparing addFirst() vs addLast()");
        SinglyLinkedList03<Integer> list1 = new SinglyLinkedList03<>();
        System.out.println("Using addFirst(1, 2, 3):");
        list1.addFirst(1);
        list1.addFirst(2);
        list1.addFirst(3);
        System.out.println("Result: " + list1 + " (reverse order)");
        
        SinglyLinkedList03<Integer> list2 = new SinglyLinkedList03<>();
        System.out.println("\nUsing addLast(1, 2, 3):");
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        System.out.println("Result: " + list2 + " (insertion order preserved)");
        System.out.println();
        
        // Demo 2: Building a list in order
        System.out.println("Demo 2: Building a list in order with addLast()");
        SinglyLinkedList03<String> names = new SinglyLinkedList03<>();
        names.addLast("Alice");
        System.out.println("After adding Alice: " + names);
        names.addLast("Bob");
        System.out.println("After adding Bob: " + names);
        names.addLast("Charlie");
        System.out.println("After adding Charlie: " + names);
        names.addLast("Diana");
        System.out.println("After adding Diana: " + names);
        System.out.println();
        
        // Demo 3: Mixed operations
        System.out.println("Demo 3: Mixing addFirst() and addLast()");
        SinglyLinkedList03<Integer> mixed = new SinglyLinkedList03<>();
        mixed.addLast(20);   // [20]
        System.out.println("addLast(20): " + mixed);
        mixed.addFirst(10);  // [10, 20]
        System.out.println("addFirst(10): " + mixed);
        mixed.addLast(30);   // [10, 20, 30]
        System.out.println("addLast(30): " + mixed);
        mixed.addFirst(5);   // [5, 10, 20, 30]
        System.out.println("addFirst(5): " + mixed);
        mixed.addLast(40);   // [5, 10, 20, 30, 40]
        System.out.println("addLast(40): " + mixed);
        System.out.println();
        
        // Demo 4: Using getLast()
        System.out.println("Demo 4: Getting first and last elements");
        System.out.println("First: " + mixed.getFirst());
        System.out.println("Last: " + mixed.getLast());
        System.out.println();
        
        // Demo 5: Edge case - adding to empty list
        System.out.println("Demo 5: Adding to empty list");
        SinglyLinkedList03<String> empty = new SinglyLinkedList03<>();
        System.out.println("Empty list: " + empty);
        empty.addLast("First");
        System.out.println("After addLast('First'): " + empty);
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. addFirst() is O(1), addLast() is O(n) without tail pointer");
        System.out.println("2. addLast() preserves insertion order (natural sequence)");
        System.out.println("3. Must handle empty list edge case specially");
        System.out.println("4. Trade-off: convenience vs performance");
        System.out.println("5. Doubly linked lists can make addLast() O(1) with tail pointer");
    }
}
