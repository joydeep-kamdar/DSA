/**
 * Program 2: GenericNode
 * 
 * LEARNING OBJECTIVES:
 * 1. Understand Java Generics (making code work with any data type)
 * 2. Learn the <T> syntax (Type Parameter)
 * 3. Create flexible, reusable data structures
 * 4. Work with different data types (Integer, String, custom objects)
 * 
 * KEY CONCEPTS:
 * - Generic types allow writing code once for all types
 * - <T> is a placeholder for any type (Integer, String, Person, etc.)
 * - Generic classes are fundamental to Java Collections Framework
 * 
 * WHY GENERICS MATTER:
 * - Type safety: Compiler catches type mismatches
 * - No casting needed: Cleaner, easier to read code
 * - Reusability: One implementation works for all types
 * 
 * CS2100 RELEVANCE:
 * - Real LinkedLists use generics to store any type
 * - Understanding generics is essential for data structures
 * - Java's ArrayList<T>, LinkedList<T> all use generics
 */

/**
 * Generic Node class - can hold any type of data
 * 
 * The <T> syntax means "This class works with any type T"
 * When you create a node, you specify what T is:
 * - Node<Integer> means T is Integer
 * - Node<String> means T is String
 * - Node<Person> means T is Person
 */
class Node<T> {
    T data;           // Data can be any type T
    Node<T> next;     // Next node also holds type T
    
    /**
     * Constructor - creates a node with generic type data
     * 
     * @param data The value to store (can be any type)
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * Returns string representation of the node
     */
    @Override
    public String toString() {
        return "Node(" + data + ")";
    }
}

/**
 * Person class - a custom class to demonstrate generics with user-defined types
 * This shows that nodes can hold ANY type, not just built-in types
 */
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
    
    // Override equals to compare Person objects properly
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
}

/**
 * GenericNode class - demonstrates generic node operations
 * This class shows how to work with nodes of different types
 */
public class GenericNode {
    
    /**
     * Creates a node with Integer data
     * Demonstrates generic type inference
     */
    public Node<Integer> createIntegerNode(int data) {
        return new Node<>(data);  // Java can infer <Integer> from context
    }
    
    /**
     * Creates a node with String data
     */
    public Node<String> createStringNode(String data) {
        return new Node<>(data);  // Java can infer <String> from context
    }
    
    /**
     * Creates a node with Person data
     * Shows that generics work with custom classes too
     */
    public Node<Person> createPersonNode(Person person) {
        return new Node<>(person);
    }
    
    /**
     * Creates a chain of Integer nodes
     * Generic version of createThreeNodeChain from Program 1
     * 
     * @param data1 First integer
     * @param data2 Second integer
     * @param data3 Third integer
     * @return Head of the chain
     */
    public Node<Integer> createIntegerChain(int data1, int data2, int data3) {
        Node<Integer> first = new Node<>(data1);
        Node<Integer> second = new Node<>(data2);
        Node<Integer> third = new Node<>(data3);
        
        first.next = second;
        second.next = third;
        
        return first;
    }
    
    /**
     * Creates a chain of String nodes
     * Shows the same structure works for different types
     * 
     * @param data1 First string
     * @param data2 Second string
     * @param data3 Third string
     * @return Head of the chain
     */
    public Node<String> createStringChain(String data1, String data2, String data3) {
        Node<String> first = new Node<>(data1);
        Node<String> second = new Node<>(data2);
        Node<String> third = new Node<>(data3);
        
        first.next = second;
        second.next = third;
        
        return first;
    }
    
    /**
     * Generic traversal method - works with ANY type!
     * This is the power of generics: write once, use for all types
     * 
     * Type parameter <T> means "this method works with any type T"
     * 
     * @param head Head of the chain (can be any type)
     * @param <T> The type parameter (inferred from head parameter)
     */
    public <T> void traverseAndPrint(Node<T> head) {
        Node<T> current = head;
        
        System.out.print("Traversing: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    /**
     * Generic count method - counts nodes of any type
     * 
     * @param head Head of the chain
     * @param <T> The type parameter
     * @return Number of nodes
     */
    public <T> int countNodes(Node<T> head) {
        int count = 0;
        Node<T> current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    /**
     * Generic search method - finds if a value exists in the chain
     * Uses .equals() method for comparison (works with any type)
     * 
     * @param head Head of the chain
     * @param target Value to search for
     * @param <T> The type parameter
     * @return true if found, false otherwise
     */
    public <T> boolean contains(Node<T> head, T target) {
        Node<T> current = head;
        
        while (current != null) {
            // Use equals() for proper comparison
            if (current.data.equals(target)) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Main method - demonstrates generics with different types
     */
    public static void main(String[] args) {
        GenericNode demo = new GenericNode();
        
        System.out.println("=== PROGRAM 2: GENERIC NODES ===\n");
        
        // Demo 1: Integer nodes
        System.out.println("Demo 1: Integer Nodes");
        Node<Integer> intNode = demo.createIntegerNode(42);
        System.out.println("Created: " + intNode);
        Node<Integer> intChain = demo.createIntegerChain(10, 20, 30);
        demo.traverseAndPrint(intChain);
        System.out.println("Contains 20? " + demo.contains(intChain, 20));
        System.out.println("Contains 99? " + demo.contains(intChain, 99));
        System.out.println();
        
        // Demo 2: String nodes
        System.out.println("Demo 2: String Nodes");
        Node<String> stringNode = demo.createStringNode("Hello");
        System.out.println("Created: " + stringNode);
        Node<String> stringChain = demo.createStringChain("Java", "Python", "C++");
        demo.traverseAndPrint(stringChain);
        System.out.println("Contains 'Python'? " + demo.contains(stringChain, "Python"));
        System.out.println("Contains 'Ruby'? " + demo.contains(stringChain, "Ruby"));
        System.out.println();
        
        // Demo 3: Person nodes (custom class)
        System.out.println("Demo 3: Person Nodes (Custom Class)");
        Person alice = new Person("Alice", 20);
        Person bob = new Person("Bob", 21);
        Person charlie = new Person("Charlie", 22);
        
        Node<Person> personNode = demo.createPersonNode(alice);
        System.out.println("Created: " + personNode);
        
        // Build a chain manually
        Node<Person> p1 = new Node<>(alice);
        Node<Person> p2 = new Node<>(bob);
        Node<Person> p3 = new Node<>(charlie);
        p1.next = p2;
        p2.next = p3;
        
        demo.traverseAndPrint(p1);
        System.out.println("Contains Bob? " + demo.contains(p1, bob));
        System.out.println("Count: " + demo.countNodes(p1));
        System.out.println();
        
        // Demo 4: Type Safety (this would not compile)
        System.out.println("Demo 4: Type Safety");
        System.out.println("The following would NOT compile:");
        System.out.println("  Node<Integer> intNode = new Node<>(\"Hello\");  // ERROR!");
        System.out.println("  intChain.next = stringNode;  // ERROR! Different types");
        System.out.println("This is the power of generics - compiler catches type errors!");
        System.out.println();
        
        System.out.println("=== KEY TAKEAWAYS ===");
        System.out.println("1. Generics make data structures flexible and reusable");
        System.out.println("2. <T> is a type parameter - a placeholder for any type");
        System.out.println("3. Same code works for Integer, String, or custom classes");
        System.out.println("4. Type safety: Compiler prevents mixing incompatible types");
        System.out.println("5. This is how Java's real LinkedList<T> works!");
    }
}
