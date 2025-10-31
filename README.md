# LinkedList Learning Journey - CS2100

## Project Structure
```
DSA/
├── src/          # Source code files
├── test/         # JUnit test files
├── lib/          # JUnit JAR file
└── run-tests.sh  # Test runner script
```

## How to Run Programs and Tests

### Run a Program (Easy!):
```bash
./run-program.sh <ProgramName>
```

Example:
```bash
./run-program.sh NodeBasics
```

See all available programs:
```bash
./run-program.sh
```

### Run Tests:
```bash
./run-tests.sh <TestClassName>
```

Example:
```bash
./run-tests.sh NodeBasicsTest
```

### Manual Compilation (if needed):
```bash
# Compile and run program
javac -d . src/YourProgram.java
java YourProgram

# Compile and run test
javac -cp .:lib/junit-platform-console-standalone.jar -d . test/YourProgramTest.java
java -jar lib/junit-platform-console-standalone.jar --class-path . --select-class YourProgramTest
```

## Learning Path

### Phase 1: Java Foundations
- [x] Setup JUnit 5
- [x] Program 1: NodeBasics.java
- [x] Program 2: GenericNode.java

### Phase 2: Singly LinkedList - Basic Operations
- [x] Program 3: SinglyLinkedList01.java - addFirst()
- [x] Program 4: SinglyLinkedList02.java - Traversal
- [x] Program 5: SinglyLinkedList03.java - addLast()
- [x] Program 6: SinglyLinkedList04.java - addAt()

### Phase 3: Singly LinkedList - Deletion Operations
- [x] Program 7: SinglyLinkedList05.java - removeFirst()
- [x] Program 8: SinglyLinkedList06.java - removeLast()
- [x] Program 9: SinglyLinkedList07.java - remove by value/position

### Phase 4: Singly LinkedList - Advanced Operations
- [x] Program 10: SinglyLinkedList08.java - Search and access
- [x] Program 11: SinglyLinkedList09.java - reverse(), clear()
- [x] Program 12: SinglyLinkedListAlgorithms.java - Classic algorithms

### Phase 5: Doubly LinkedList
- [x] Program 13: DoublyLinkedList01.java - Basic operations
- [x] Program 14: DoublyLinkedList02.java - Insertion
- [x] Program 15: DoublyLinkedList03.java - Deletion
- [x] Program 16: DoublyLinkedList04.java - Bidirectional traversal

### Phase 6: Final Project
- [x] Program 17: LinkedListComparison.java - Implementation comparison

## ALL PROGRAMS COMPLETE! 🎉

## Learning Notes

### Key Concepts to Master:
1. **References**: Understanding how objects point to each other
2. **Null handling**: Checking for empty lists and null references
3. **Edge cases**: Single node, empty list, operations at boundaries
4. **Time complexity**: O(1) vs O(n) operations
5. **Memory management**: Creating and breaking links

### Common Pitfalls:
- Forgetting to update head/tail pointers
- Losing references to nodes (memory leaks in other languages)
- Off-by-one errors in index-based operations
- Not handling null checks before accessing node.next

Add your own notes here as you learn!
