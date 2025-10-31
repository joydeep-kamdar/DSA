/**
 * Program 9: SinglyLinkedList07 - Remove by Value and Position
 * Implements remove(data) and removeAt(index)
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedList07<T> {
    private Node<T> head;
    
    public SinglyLinkedList07() { this.head = null; }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    /**
     * Removes first occurrence of element
     * TIME: O(n)
     * @return true if removed, false if not found
     */
    public boolean remove(T data) {
        if (head == null) return false;
        
        // Check first node
        if ((data == null && head.data == null) || (data != null && data.equals(head.data))) {
            head = head.next;
            return true;
        }
        
        // Check remaining nodes
        Node<T> current = head;
        while (current.next != null) {
            if ((data == null && current.next.data == null) || 
                (data != null && data.equals(current.next.data))) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Removes element at specific index
     * TIME: O(n)
     */
    public T removeAt(int index) {
        if (index < 0 || head == null) return null;
        
        // Remove first
        if (index == 0) {
            T data = head.data;
            head = head.next;
            return data;
        }
        
        // Find node at index-1
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        
        if (current == null || current.next == null) return null;
        
        T data = current.next.data;
        current.next = current.next.next;
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
        System.out.println("=== PROGRAM 9: REMOVE BY VALUE AND POSITION ===\n");
        
        SinglyLinkedList07<Integer> list = new SinglyLinkedList07<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println("Initial: " + list);
        
        list.remove(20);
        System.out.println("After remove(20): " + list);
        
        list.removeAt(1);
        System.out.println("After removeAt(1): " + list);
    }
}
