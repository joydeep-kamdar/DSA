/**
 * Program 13: DoublyLinkedList01 - Bidirectional LinkedList
 * Each node has both prev and next pointers
 * KEY: Both head AND tail pointers for O(1) addFirst/addLast
 */

class DNode<T> {
    T data;
    DNode<T> prev;
    DNode<T> next;
    
    public DNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList01<T> {
    private DNode<T> head;
    private DNode<T> tail;
    
    public DoublyLinkedList01() {
        this.head = null;
        this.tail = null;
    }
    
    /**
     * Adds at beginning - O(1)
     * Must update both next AND prev pointers
     */
    public void addFirst(T data) {
        DNode<T> newNode = new DNode<>(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    /**
     * Adds at end - O(1) with tail pointer!
     * Compare to SinglyLinkedList where addLast is O(n)
     */
    public void addLast(T data) {
        DNode<T> newNode = new DNode<>(data);
        
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        int count = 0;
        DNode<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        DNode<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
    
    public String toStringReverse() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        DNode<T> current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) sb.append(", ");
            current = current.prev;
        }
        return sb.append("]").toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 13: DOUBLY LINKED LIST ===\n");
        
        DoublyLinkedList01<Integer> list = new DoublyLinkedList01<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        System.out.println("Forward: " + list);
        System.out.println("Backward: " + list.toStringReverse());
        
        list.addFirst(0);
        System.out.println("After addFirst(0): " + list);
        
        System.out.println("\nKey: Both addFirst() and addLast() are O(1)!");
    }
}
