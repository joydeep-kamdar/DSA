/**
 * Program 16: DoublyLinkedList04 - Complete Implementation
 * Full doubly linked list with forward and backward traversal
 */

class DNode<T> {
    T data;
    DNode<T> prev;
    DNode<T> next;
    public DNode(T data) { this.data = data; }
}

public class DoublyLinkedList04<T> {
    private DNode<T> head;
    private DNode<T> tail;
    
    public DoublyLinkedList04() {}
    
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
     * Print forward (head to tail)
     */
    public void printForward() {
        System.out.print("Forward: ");
        DNode<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Print backward (tail to head)
     * This is the power of doubly linked lists!
     */
    public void printBackward() {
        System.out.print("Backward: ");
        DNode<T> current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println();
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
        System.out.println("=== PROGRAM 16: DOUBLY LINKED LIST TRAVERSAL ===\n");
        
        DoublyLinkedList04<String> list = new DoublyLinkedList04<>();
        list.addLast("First");
        list.addLast("Second");
        list.addLast("Third");
        list.addLast("Fourth");
        
        list.printForward();
        list.printBackward();
        
        System.out.println("\nKey: Can traverse in BOTH directions efficiently!");
    }
}
