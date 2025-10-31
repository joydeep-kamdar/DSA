/**
 * Program 12: SinglyLinkedListAlgorithms - Classic Algorithms
 * Implements common interview problems
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedListAlgorithms<T> {
    private Node<T> head;
    
    public SinglyLinkedListAlgorithms() { this.head = null; }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    /**
     * Finds middle element using fast/slow pointer technique
     * Fast moves 2 steps, slow moves 1 step
     * When fast reaches end, slow is at middle
     * TIME: O(n), SPACE: O(1)
     */
    public T findMiddle() {
        if (head == null) return null;
        Node<T> slow = head;
        Node<T> fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    /**
     * Detects if list has a cycle using Floyd's algorithm
     * TIME: O(n), SPACE: O(1)
     */
    public boolean hasCycle() {
        if (head == null) return false;
        Node<T> slow = head;
        Node<T> fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        
        return false;
    }
    
    /**
     * Removes duplicates from sorted list
     * TIME: O(n), SPACE: O(1)
     */
    public void removeDuplicates() {
        if (head == null) return;
        Node<T> current = head;
        
        while (current != null && current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 12: LINKEDLIST ALGORITHMS ===\n");
        
        SinglyLinkedListAlgorithms<Integer> list = new SinglyLinkedListAlgorithms<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("List: " + list);
        System.out.println("Middle: " + list.findMiddle());
        System.out.println("Has cycle: " + list.hasCycle());
        
        SinglyLinkedListAlgorithms<Integer> dups = new SinglyLinkedListAlgorithms<>();
        dups.addLast(1);
        dups.addLast(1);
        dups.addLast(2);
        dups.addLast(3);
        dups.addLast(3);
        System.out.println("\nWith duplicates: " + dups);
        dups.removeDuplicates();
        System.out.println("After removing: " + dups);
    }
}
