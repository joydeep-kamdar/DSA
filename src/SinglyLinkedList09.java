/**
 * Program 11: SinglyLinkedList09 - List Manipulation
 * Implements reverse(), clear(), and other utility methods
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedList09<T> {
    private Node<T> head;
    
    public SinglyLinkedList09() { this.head = null; }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    /**
     * Reverses the list in place
     * TIME: O(n)
     * SPACE: O(1)
     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;    // Save next
            current.next = prev;    // Reverse link
            prev = current;         // Move prev forward
            current = next;         // Move current forward
        }
        
        head = prev;  // New head is old tail
    }
    
    /**
     * Clears all elements
     * TIME: O(1) - just set head to null
     */
    public void clear() {
        head = null;
    }
    
    public boolean isEmpty() { return head == null; }
    
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) { count++; current = current.next; }
        return count;
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
        System.out.println("=== PROGRAM 11: LIST MANIPULATION ===\n");
        
        SinglyLinkedList09<Integer> list = new SinglyLinkedList09<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("Original: " + list);
        
        list.reverse();
        System.out.println("Reversed: " + list);
        
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty: " + list.isEmpty());
    }
}
