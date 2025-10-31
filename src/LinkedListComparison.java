/**
 * Program 17: LinkedListComparison - Final Project
 * 
 * Compares time complexity and performance of:
 * - ArrayList (from Java standard library)
 * - SinglyLinkedList (our implementation)
 * - DoublyLinkedList (our implementation)
 * 
 * LEARNING OBJECTIVES:
 * 1. Understand time complexity trade-offs
 * 2. Know when to use each data structure
 * 3. Practical performance analysis
 * 
 * KEY COMPARISONS:
 * 
 * Operation          | ArrayList | SinglyLinkedList | DoublyLinkedList
 * -------------------|-----------|------------------|------------------
 * addFirst()         | O(n)      | O(1)             | O(1)
 * addLast()          | O(1)*     | O(n)             | O(1)
 * add(index)         | O(n)      | O(n)             | O(n)
 * removeFirst()      | O(n)      | O(1)             | O(1)
 * removeLast()       | O(1)      | O(n)             | O(1)
 * get(index)         | O(1)      | O(n)             | O(n)
 * contains(element)  | O(n)      | O(n)             | O(n)
 * size()             | O(1)      | O(n)**           | O(n)**
 * 
 * * Amortized O(1) - occasionally O(n) when array needs to resize
 * ** Can be O(1) if we maintain a size variable
 * 
 * WHEN TO USE EACH:
 * 
 * ArrayList:
 * - Need fast random access by index
 * - Mostly adding/removing at end
 * - Know approximate size in advance
 * 
 * SinglyLinkedList:
 * - Frequent additions/removals at beginning
 * - Memory-constrained (less overhead per element)
 * - Implementing stack
 * 
 * DoublyLinkedList:
 * - Need bidirectional traversal
 * - Frequent add/remove at both ends
 * - Implementing deque or LRU cache
 * - Java's LinkedList uses this
 */

import java.util.ArrayList;

public class LinkedListComparison {
    
    /**
     * Demonstrates time complexity differences
     */
    public static void demonstrateComplexity() {
        int n = 1000;
        
        System.out.println("=== TIME COMPLEXITY DEMONSTRATION ===\n");
        
        // ArrayList - fast random access
        System.out.println("1. Random Access (get by index):");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int val = arrayList.get(i * 10);  // O(1) for each access
        }
        long end = System.nanoTime();
        System.out.println("ArrayList random access: " + (end - start) + " ns");
        System.out.println("Complexity: O(1) per access\n");
        
        // LinkedList simulation - slow random access
        System.out.println("2. Sequential Access:");
        System.out.println("SinglyLinkedList: Must traverse from head - O(n)");
        System.out.println("DoublyLinkedList: Can traverse from nearest end - O(n/2)");
        System.out.println("ArrayList: Direct index access - O(1)\n");
        
        // Adding at beginning
        System.out.println("3. Add at Beginning:");
        System.out.println("ArrayList: Shift all elements - O(n)");
        System.out.println("SinglyLinkedList: Just update head - O(1)");
        System.out.println("DoublyLinkedList: Just update head - O(1)\n");
        
        // Adding at end
        System.out.println("4. Add at End:");
        System.out.println("ArrayList: Usually O(1), O(n) when resizing");
        System.out.println("SinglyLinkedList: Traverse to end - O(n)");
        System.out.println("DoublyLinkedList: Use tail pointer - O(1)\n");
    }
    
    /**
     * Shows when to use each data structure
     */
    public static void showUseCases() {
        System.out.println("=== USE CASE RECOMMENDATIONS ===\n");
        
        System.out.println("Use ArrayList when:");
        System.out.println("  • Need fast random access (like array subscript)");
        System.out.println("  • Mostly adding/removing at the end");
        System.out.println("  • Iterating through all elements");
        System.out.println("  • Example: Dynamic array of game scores\n");
        
        System.out.println("Use SinglyLinkedList when:");
        System.out.println("  • Frequent insertions/deletions at beginning");
        System.out.println("  • Implementing stack (LIFO)");
        System.out.println("  • Memory overhead is a concern");
        System.out.println("  • Example: Undo history, function call stack\n");
        
        System.out.println("Use DoublyLinkedList when:");
        System.out.println("  • Need to traverse in both directions");
        System.out.println("  • Frequent operations at both ends");
        System.out.println("  • Implementing deque (double-ended queue)");
        System.out.println("  • Example: Browser history, LRU cache\n");
    }
    
    /**
     * Memory comparison
     */
    public static void compareMemory() {
        System.out.println("=== MEMORY OVERHEAD ===\n");
        
        System.out.println("Per element storage:");
        System.out.println("ArrayList:");
        System.out.println("  • Data: 1 reference");
        System.out.println("  • Overhead: Excess capacity (amortized)");
        System.out.println("  • Total: ~1-1.5x data size\n");
        
        System.out.println("SinglyLinkedList:");
        System.out.println("  • Data: 1 reference");
        System.out.println("  • Next pointer: 1 reference");
        System.out.println("  • Node object: 1 object header");
        System.out.println("  • Total: ~2-3x data size\n");
        
        System.out.println("DoublyLinkedList:");
        System.out.println("  • Data: 1 reference");
        System.out.println("  • Next pointer: 1 reference");
        System.out.println("  • Prev pointer: 1 reference");
        System.out.println("  • Node object: 1 object header");
        System.out.println("  • Total: ~3-4x data size\n");
    }
    
    /**
     * Key takeaways
     */
    public static void printConclusions() {
        System.out.println("=== KEY TAKEAWAYS FOR CS2100 ===\n");
        
        System.out.println("1. TIME-SPACE TRADEOFF:");
        System.out.println("   ArrayList: Fast access, wastes some space");
        System.out.println("   LinkedLists: Flexible insertion, more overhead\n");
        
        System.out.println("2. NO PERFECT DATA STRUCTURE:");
        System.out.println("   Choose based on your specific use case\n");
        
        System.out.println("3. BIG-O IS A GUIDE:");
        System.out.println("   For small datasets, constant factors matter");
        System.out.println("   ArrayList often wins even with O(n) operations\n");
        
        System.out.println("4. CACHE LOCALITY:");
        System.out.println("   ArrayList: Elements stored contiguously (cache-friendly)");
        System.out.println("   LinkedList: Nodes scattered in memory (cache-unfriendly)\n");
        
        System.out.println("5. REAL WORLD:");
        System.out.println("   Java's ArrayList is most common (90% of use cases)");
        System.out.println("   LinkedList for specialized needs (queues, deques)");
        System.out.println("   Roll your own only for learning or special requirements\n");
    }
    
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 17: LINKEDLIST COMPARISON ===\n");
        System.out.println("Comprehensive analysis of list implementations\n");
        System.out.println("=" .repeat(60) + "\n");
        
        demonstrateComplexity();
        System.out.println("=" .repeat(60) + "\n");
        
        showUseCases();
        System.out.println("=" .repeat(60) + "\n");
        
        compareMemory();
        System.out.println("=" .repeat(60) + "\n");
        
        printConclusions();
        
        System.out.println("CONGRATULATIONS!");
        System.out.println("You've completed the LinkedList learning journey!");
        System.out.println("You now understand:");
        System.out.println("  ✓ Node-based data structures");
        System.out.println("  ✓ Singly and doubly linked lists");
        System.out.println("  ✓ Time/space complexity trade-offs");
        System.out.println("  ✓ When to use each data structure");
        System.out.println("\nYou're ready for CS2100 LinkedList topics!");
    }
}
