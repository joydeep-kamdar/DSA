/**
 * Program 10: SinglyLinkedList08 - Search and Access
 * Complete implementation with all accessor methods
 */

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; this.next = null; }
}

public class SinglyLinkedList08<T> {
    private Node<T> head;
    
    public SinglyLinkedList08() { this.head = null; }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }
    
    /**
     * Gets element at index
     * TIME: O(n)
     */
    public T get(int index) {
        if (index < 0) return null;
        Node<T> current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        return (current == null) ? null : current.data;
    }
    
    /**
     * Finds index of first occurrence
     * TIME: O(n)
     * @return index or -1 if not found
     */
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((data == null && current.data == null) || 
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    /**
     * Sets element at index
     * TIME: O(n)
     */
    public T set(int index, T data) {
        if (index < 0) return null;
        Node<T> current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current == null) return null;
        T oldData = current.data;
        current.data = data;
        return oldData;
    }
    
    public boolean contains(T data) {
        return indexOf(data) != -1;
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
        System.out.println("=== PROGRAM 10: SEARCH AND ACCESS ===\n");
        
        SinglyLinkedList08<String> list = new SinglyLinkedList08<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        System.out.println("List: " + list);
        
        System.out.println("get(1): " + list.get(1));
        System.out.println("indexOf('B'): " + list.indexOf("B"));
        System.out.println("set(1, 'X'): " + list.set(1, "X"));
        System.out.println("After set: " + list);
    }
}
