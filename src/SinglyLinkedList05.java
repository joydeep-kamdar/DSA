/**
 * Program 7: SinglyLinkedList05 - Remove First
 * Implements removeFirst() - deletion from the beginning
 * TIME: O(1) - just update head pointer
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedList05<T> {
    private Node<T> head;
    
    public SinglyLinkedList05() { this.head = null; }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    /**
     * Removes and returns the first element
     * TIME: O(1) - just update head pointer
     * @return The removed element, or null if empty
     */
    public T removeFirst() {
        if (head == null) return null;  // Empty list
        
        T data = head.data;
        head = head.next;  // Move head to next node
        return data;
    }
    
    public boolean isEmpty() { return head == null; }
    
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) { count++; current = current.next; }
        return count;
    }
    
    public T getFirst() {
        return (head == null) ? null : head.data;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
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
        System.out.println("=== PROGRAM 7: REMOVE FIRST ===\n");
        
        SinglyLinkedList05<Integer> list = new SinglyLinkedList05<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("Initial: " + list);
        
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("After removeFirst(): " + list);
        
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("After removeFirst(): " + list);
        
        System.out.println("\nKey: removeFirst() is O(1) - very fast!");
    }
}
