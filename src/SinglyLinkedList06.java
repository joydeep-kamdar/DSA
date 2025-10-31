/**
 * Program 8: SinglyLinkedList06 - Remove Last
 * Implements removeLast() - deletion from end
 * TIME: O(n) - must traverse to find second-to-last node
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedList06<T> {
    private Node<T> head;
    
    public SinglyLinkedList06() { this.head = null; }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    public T removeFirst() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        return data;
    }
    
    /**
     * Removes and returns the last element
     * TIME: O(n) - must find second-to-last node
     * @return The removed element, or null if empty
     */
    public T removeLast() {
        if (head == null) return null;  // Empty list
        
        // Single element
        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }
        
        // Find second-to-last node
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = null;  // Remove last node
        return data;
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
        System.out.println("=== PROGRAM 8: REMOVE LAST ===\n");
        
        SinglyLinkedList06<Integer> list = new SinglyLinkedList06<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("Initial: " + list);
        
        System.out.println("Removed: " + list.removeLast());
        System.out.println("After removeLast(): " + list);
        
        System.out.println("\nKey: removeLast() is O(n) - must traverse to second-to-last!");
    }
}
