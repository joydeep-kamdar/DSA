/**
 * Program 14: DoublyLinkedList02 - Insertion at Position
 * Implements addAt with prev/next pointer maintenance
 */

class DNode<T> {
    T data;
    DNode<T> prev;
    DNode<T> next;
    public DNode(T data) { this.data = data; }
}

public class DoublyLinkedList02<T> {
    private DNode<T> head;
    private DNode<T> tail;
    
    public DoublyLinkedList02() {}
    
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
     * Insert at index - must update BOTH prev and next
     * TIME: O(n)
     */
    public void addAt(int index, T data) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(data); return; }
        
        DNode<T> current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) throw new IndexOutOfBoundsException();
        
        DNode<T> newNode = new DNode<>(data);
        newNode.next = current.next;
        newNode.prev = current;
        
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
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
        System.out.println("=== PROGRAM 14: DOUBLY LINKED LIST INSERTION ===\n");
        
        DoublyLinkedList02<String> list = new DoublyLinkedList02<>();
        list.addLast("A");
        list.addLast("C");
        list.addAt(1, "B");
        System.out.println("List: " + list);
    }
}
