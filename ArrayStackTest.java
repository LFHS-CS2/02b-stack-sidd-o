import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Tests ArrayStack
 *
 */
public class ArrayStackTest
{
  public static void main(String args[]) {
    ArrayStackTest test = new ArrayStackTest();
    test.test_example();
  }

    /**
     * This is an example test.  After you have written your own tests,
     * get rid of it.
     */
    @Test
    public void test_example() {
        assertTrue("it should be true", 5==5);
        assertEquals("they should be equal", 5, 5);
        // when comparing doubles, the last number is a threshold
        //   of how close the numbers should be to be considered equal
        assertEquals("they should be with .01 of each other", 5.12, 5.11, .01);
        if (false)
            fail("It should have been true");
    }

}
