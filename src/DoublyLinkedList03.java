/**
 * Program 15: DoublyLinkedList03 - Deletion Operations
 * Removing nodes while maintaining bidirectional links
 */

class DNode<T> {
    T data;
    DNode<T> prev;
    DNode<T> next;
    public DNode(T data) { this.data = data; }
}

public class DoublyLinkedList03<T> {
    private DNode<T> head;
    private DNode<T> tail;
    
    public DoublyLinkedList03() {}
    
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
    
    /**
     * Remove first - O(1) with tail pointer
     */
    public T removeFirst() {
        if (head == null) return null;
        T data = head.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }
    
    /**
     * Remove last - O(1) because we have tail.prev!
     * This is O(n) in Singly LinkedList
     */
    public T removeLast() {
        if (tail == null) return null;
        T data = tail.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return data;
    }
    
    /**
     * Remove at index - O(n)
     */
    public T removeAt(int index) {
        if (index < 0 || head == null) return null;
        
        DNode<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) return null;
        
        T data = current.data;
        
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        
        return data;
    }
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        DNode<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== PROGRAM 15: DOUBLY LINKED LIST DELETION ===\n");
        
        DoublyLinkedList03<Integer> list = new DoublyLinkedList03<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("Initial: " + list);
        
        list.removeFirst();
        System.out.println("After removeFirst(): " + list);
        
        list.removeLast();
        System.out.println("After removeLast(): " + list);
        
        System.out.println("\nKey: removeLast() is O(1) with doubly linked list!");
    }
}
