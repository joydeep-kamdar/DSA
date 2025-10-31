#!/bin/bash
# Script to easily run any Java program from src/ directory

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if a program name is provided
if [ -z "$1" ]; then
    echo -e "${RED}Usage: ./run-program.sh <ProgramName>${NC}"
    echo ""
    echo "Examples:"
    echo "  ./run-program.sh NodeBasics"
    echo "  ./run-program.sh SinglyLinkedList03"
    echo "  ./run-program.sh DoublyLinkedList01"
    echo ""
    echo -e "${BLUE}Available programs:${NC}"
    ls -1 src/*.java | xargs -n 1 basename | sed 's/.java$//' | sed 's/^/  - /'
    exit 1
fi

PROGRAM_NAME=$1
SOURCE_FILE="src/${PROGRAM_NAME}.java"

# Check if the source file exists
if [ ! -f "$SOURCE_FILE" ]; then
    echo -e "${RED}Error: Program '$PROGRAM_NAME' not found!${NC}"
    echo ""
    echo "File '$SOURCE_FILE' does not exist."
    echo ""
    echo -e "${BLUE}Available programs:${NC}"
    ls -1 src/*.java | xargs -n 1 basename | sed 's/.java$//' | sed 's/^/  - /'
    exit 1
fi

echo -e "${BLUE}=== Running $PROGRAM_NAME ===${NC}"
echo ""

# Clean up old class files
echo "Cleaning old class files..."
rm -f *.class 2>/dev/null

# Compile the program
echo "Compiling $SOURCE_FILE..."
javac -d . "$SOURCE_FILE" 2>&1

if [ $? -ne 0 ]; then
    echo -e "${RED}Compilation failed!${NC}"
    exit 1
fi

echo -e "${GREEN}Compilation successful!${NC}"
echo ""
echo -e "${BLUE}=== Program Output ===${NC}"
echo ""

# Run the program
java "$PROGRAM_NAME"

if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}Program completed successfully!${NC}"
else
    echo ""
    echo -e "${RED}Program execution failed!${NC}"
    exit 1
fi

