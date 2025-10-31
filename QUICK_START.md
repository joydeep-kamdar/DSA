# Quick Start Guide

## Your LinkedList Learning Journey Starts Here! 🚀

Everything is set up and ready to go. Here's how to start learning:

## ✅ What's Already Done

- ✅ Java environment configured
- ✅ JUnit 5 testing framework installed
- ✅ 17 complete programs with extensive comments
- ✅ 17 comprehensive test suites
- ✅ Test runner script (`run-tests.sh`)
- ✅ All tests passing

## 📁 Project Structure

```
DSA/
├── src/                          # 17 source programs
│   ├── NodeBasics.java          # Start here!
│   ├── GenericNode.java
│   ├── SinglyLinkedList01.java through SinglyLinkedList09.java
│   ├── SinglyLinkedListAlgorithms.java
│   ├── DoublyLinkedList01.java through DoublyLinkedList04.java
│   └── LinkedListComparison.java
├── test/                         # 17 test files
│   └── (corresponding test files)
├── lib/
│   └── junit-platform-console-standalone.jar
├── run-tests.sh                  # Easy test runner
├── README.md                     # Project overview
├── LEARNING_GUIDE.md            # Detailed learning guide
└── QUICK_START.md               # This file!
```

## 🎯 Start Learning NOW

### Program 1: NodeBasics

This is where you start! Run these commands:

```bash
# Navigate to the project
cd /Users/joydeep.kamdar/Apps/DSA

# Run the first program (easy way!)
./run-program.sh NodeBasics

# Run its tests
./run-tests.sh NodeBasicsTest
```

**What you'll learn**: Nodes, references, and how objects link together.

### Your First Day Plan (30-60 minutes)

1. **Program 1: NodeBasics** (15 min)
   - Read the source code comments
   - Run the program and observe output
   - Run the tests
   - Modify main() to experiment

2. **Program 2: GenericNode** (15 min)
   - Understand Java generics
   - See how nodes work with any type
   - Run and test

3. **Program 3: SinglyLinkedList01** (30 min)
   - Your first LinkedList class!
   - Implement addFirst()
   - Understand O(1) operations
   - Run and test

## 🔥 Commands You'll Use

### Run a Program (Easy Way!)
```bash
./run-program.sh ProgramName
```

### Run a Program (Manual Way)
```bash
javac -d . src/ProgramName.java
java ProgramName
```

### Run Tests
```bash
./run-tests.sh ProgramNameTest
```

### Examples
```bash
# Run Program 1
./run-program.sh NodeBasics
./run-tests.sh NodeBasicsTest

# Run Program 5
./run-program.sh SinglyLinkedList03
./run-tests.sh SinglyLinkedList03Test

# Run Program 12
./run-program.sh SinglyLinkedListAlgorithms
./run-tests.sh SinglyLinkedListAlgorithmsTest

# Run Final program
./run-program.sh LinkedListComparison
./run-tests.sh LinkedListComparisonTest
```

## 📖 Learning Sequence

**Phase 1: Foundations** (Programs 1-2)
- Understand nodes and references
- Learn Java generics

**Phase 2: Basic Operations** (Programs 3-6)
- Build your first LinkedList
- Add elements anywhere
- Master insertion

**Phase 3: Deletion** (Programs 7-9)
- Remove elements
- Handle edge cases
- Complete the operations

**Phase 4: Advanced** (Programs 10-12)
- Search and access
- List manipulation
- Classic algorithms

**Phase 5: Doubly LinkedList** (Programs 13-16)
- Bidirectional pointers
- Improved performance
- Forward and backward

**Phase 6: Mastery** (Program 17)
- Compare all approaches
- Understand trade-offs
- Real-world usage

## 💡 Pro Tips

1. **Don't skip programs!** Each builds on the last
2. **Read comments carefully** - they explain WHY, not just what
3. **Run tests after changes** - immediate feedback
4. **Draw pictures** - visualize the links
5. **Experiment** - break things and fix them!

## 🆘 If Something Doesn't Work

### Test won't run?
```bash
# Make sure you're in the right directory
cd /Users/joydeep.kamdar/Apps/DSA

# Clean compiled files
rm -f *.class

# Try again
./run-tests.sh ProgramNameTest
```

### Can't compile?
```bash
# Check Java is accessible
java -version

# If not, run this first:
export PATH="/opt/homebrew/opt/openjdk@21/bin:$PATH"
```

### Need help?
- Read `LEARNING_GUIDE.md` for detailed explanations
- Check the test code to see expected behavior
- Review the comments in the source files

## 🎓 When You're Done

After completing all 17 programs, you will:

✅ Understand LinkedLists at a deep level
✅ Be able to implement them from scratch
✅ Know when to use which data structure
✅ Ace your CS2100 LinkedList assignments
✅ Solve LinkedList interview questions

## 🚦 Ready? Start Now!

```bash
cd /Users/joydeep.kamdar/Apps/DSA
./run-program.sh NodeBasics
```

See all available programs:
```bash
./run-program.sh
```

**Your LinkedList journey begins with a single node!** 

Good luck! 🎉

