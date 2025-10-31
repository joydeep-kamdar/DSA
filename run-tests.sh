#!/bin/bash
# Script to compile and run JUnit tests

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Check if a test file is provided
if [ -z "$1" ]; then
    echo "Usage: ./run-tests.sh <TestClassName>"
    echo "Example: ./run-tests.sh NodeBasicsTest"
    exit 1
fi

TEST_CLASS=$1

# Determine which source file to compile based on test name
SOURCE_FILE=""
if [[ "$TEST_CLASS" == "NodeBasicsTest" ]]; then
    SOURCE_FILE="src/NodeBasics.java"
elif [[ "$TEST_CLASS" == "GenericNodeTest" ]]; then
    SOURCE_FILE="src/GenericNode.java"
else
    # For SinglyLinkedList and DoublyLinkedList tests
    # Extract the base name from test (e.g., SinglyLinkedList01Test -> SinglyLinkedList01)
    BASE_NAME=${TEST_CLASS%Test}
    SOURCE_FILE="src/${BASE_NAME}.java"
fi

echo "Compiling source file: $SOURCE_FILE"
javac -d . "$SOURCE_FILE" 2>&1
if [ $? -ne 0 ]; then
    echo -e "${RED}Source compilation failed${NC}"
    exit 1
fi

echo "Compiling test file: test/${TEST_CLASS}.java"
javac -cp .:lib/junit-platform-console-standalone.jar -d . "test/${TEST_CLASS}.java" 2>&1
if [ $? -ne 0 ]; then
    echo -e "${RED}Test compilation failed${NC}"
    exit 1
fi

echo "Running tests for ${TEST_CLASS}..."
java -jar lib/junit-platform-console-standalone.jar --class-path . --select-class ${TEST_CLASS}

echo -e "\n${GREEN}Test execution complete!${NC}"
