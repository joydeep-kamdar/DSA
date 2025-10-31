import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic test for LinkedListComparison
 * Mainly verifies the program runs without errors
 */
class LinkedListComparisonTest {
    
    @Test
    void testDemonstrateComplexity() {
        // Just verify it runs without exceptions
        LinkedListComparison.demonstrateComplexity();
        assertTrue(true);
    }
    
    @Test
    void testShowUseCases() {
        LinkedListComparison.showUseCases();
        assertTrue(true);
    }
    
    @Test
    void testCompareMemory() {
        LinkedListComparison.compareMemory();
        assertTrue(true);
    }
    
    @Test
    void testPrintConclusions() {
        LinkedListComparison.printConclusions();
        assertTrue(true);
    }
    
    @Test
    void testMain() {
        // Verify complete program runs
        LinkedListComparison.main(new String[]{});
        assertTrue(true);
    }
}

