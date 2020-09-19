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
		test.test_postfix_calculator();
    test.test_example();
		test.test_stack();
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

		@Test
		public void test_stack(){
			ArrayStack temp = new ArrayStack();
			temp.push(1);
			temp.push(45);
			temp.push(62);
			temp.push(2345);
			temp.push(23);
			temp.push(83);
			temp.push(23435);
			temp.push(3523);
			temp.push(32534);
			assertEquals("they should be equal", temp.peekTop(), temp.pop());
			ArrayList<Integer> temp1 = new ArrayList<Integer>();
			while(!temp.isEmpty()){
				temp1.add((Integer) temp.pop());
			}
				ArrayList<Integer> temp2 = new ArrayList<Integer>();
				temp2.add(3523);
				temp2.add(23435);
				temp2.add(83);
				temp2.add(23);
				temp2.add(2345);
				temp2.add(62);
				temp2.add(45);
				temp2.add(1);
			assertEquals("they should be equal", temp1, temp2);
			for(int i = 0; i < 100000; i++){
				temp.push(i);
			}
			assertEquals("they should be equal", temp.peekTop(), 99999);
			while(!temp.isEmpty()){
				temp.peekTop();
				temp.pop();
			}

			System.out.println("ArrayStack Has Passed All Tests.");

		}

		@Test

		public void test_postfix_calculator(){
			PostfixCalculator temp = new PostfixCalculator();
			String[] postfix_test_expressions = {"123*+", "4 5 + 7 2 - *", "4 2 3 5 1 - + * +", "3", "", "7 3 +", "6 6 / 1 - 2 * 7 + 5 - 6 * 1 + 6 * 8 * 9 - 2 + 5 * 6 -", "7 6 - 5 + 7 * 7 - 7 + 8 / 10 / 5 / 3 * 1 *", "3 5 * 8 + 8 + 4 - 5 / 10 / 7 / 5 + 5 * 8 +", "7 2 - 1 - 5 * 9 / 4 / 10 / 4 - 6 + 3 + 8 - 7 + 9 * 7 * 2 + 5 / 4 - 5 - 1 +", "8 1 + 4 +", "2 8 * 7 - 1 / 4 /", "9 2 + 7 - 4 * 10 * 6 - 8 * 6 + 10 - 7 - 8 * 8 * 10 / 3 - 9 +", "4 7 - 2 * 4 - 9 - 2 * 1 - 1 * 6 + 8 -", "6 2 + 4 / 3 + 6 + 3 + 4 * 6 - 4 - 10 * 1 * 6 / 6 * 1 * 4 * 5 / 10 - 2 * 8 +", "1 6 / 7 + 4 - 10 / 10 * 10 +", "6 2 + 1 * 5 / 1 + 3 + 2 / 10 - 7 - 3 - 3 * 7 - 4 - 10 * 4 + 1 / 3 - 2 -", "2 10 * 6 + 7 * 5 * 3 * 9 / 5 / 7 - 4 + 9 + 8 + 9 - 5 - 5 + 7 + 8 + 5 - 3 -", "3 2 + 7 + 8 / 6 + 2 - 6 * 8 - 10 / 5 + 8 +", "9 5 * 10 + 10 + 1 - 3 - 8 + 4 / 6 - 4 - 6 -", "4 1 - 4 *", "9 4 * 6 * 6 + 10 / 7 + 4 / 4 / 5 * 9 / 4 * 5 - 8 /", "7 4 + 10 / 6 * 1 * 5 - 8 /", "2 7 + 4 + 2 + 3 + 2 * 7 / 7 +", "6 4 + 2 + 5 / 1 / 5 * 10 * 8 * 7 + 6 /", "9 8 / 10 + 3 + 6 - 9 + 8 - 2 /", "1 9 - 2 + 4 - 1 + 4 + 1 + 8 / 9 + 4 * 2 * 3 / 6 - 4 * 3 / 1 +", "2 7 + 1 / 4 / 2 +", "4 6 / 10 -", "9 10 / 9 - 1 * 1 - 10 - 2 - 6 - 9 * 2 - 8 + 8 - 5 + 5 * 9 + 4 * 1 *", "9 5 / 9 - 1 +", "8 6 / 6 - 2 / 1 / 7 / 6 / 9 -", "4 6 / 10 - 5 * 6 / 9 + 6 - 3 / 8 - 4 + 2 * 1 * 1 -", "5 2 - 10 / 6 - 6 / 9 + 9 / 10 *", "2 5 - 8 * 2 * 4 + 7 * 3 + 7 + 1 * 9 + 10 / 3 + 10 * 4 +", "6 6 /", "10 4 * 1 + 10 / 10 * 7 - 7 - 7 *", "9 6 - 5 + 6 + 7 * 10 + 5 / 3 * 1 - 8 * 8 - 2 * 5 - 1 - 3 - 5 +", "8 1 + 9 - 3 / 10 * 5 / 6 * 6 *", "6 5 * 3 * 9 / 9 -", "4 9 - 7 / 9 * 3 - 3 - 2 + 10 + 1 / 3 * 7 * 8 + 2 * 10 / 5 - 7 - 4 - 2 /", "10 5 + 9 /", "4 8 - 5 / 6 +", "2 3 / 3 - 4 + 2 / 7 * 9 * 2 + 10 * 2 / 5 *", "9 4 + 5 * 5 - 5 +", "8 1 / 5 * 4 / 1 + 2 + 5 * 6 * 2 / 8 + 4 -", "4 3 / 1 + 5 * 10 - 3 * 8 + 5 - 10 - 10 * 10 + 9 * 2 + 5 + 8 + 10 - 1 - 5 - 3 - 6 * 8 / 3 / 10 *", "4 8 * 9 - 8 / 1 * 9 *", "8 8 / 1 / 2 * 6 / 10 + 2 -", "1 1 - 7 * 3 + 8 +", "8 1 / 6 + 2 * 8 / 6 *", "10 7 - 5 * 2 - 7 + 5 / 2 + 5 * 6 + 3 - 3 - 1 + 10 /", "2 9 - 4 * 7 / 7 + 8 / 3 / 1 -", "4 10 - 8 * 8 * 7 - 4 / 10 / 9 / 5 / 10 / 10 / 9 * 9 -", "9 6 * 6 / 4 * 5 * 10 * 7 * 4 / 2 / 6 / 5 / 3 - 8 / 6 + 8 + 9 / 1 / 7 * 4 + 2 * 6 + 7 / 2 *"};
			int[] postfix_test_expressions_answers = {7, 45, 18, 3, 0, 10, 3079, 0, 33, 42, 13, 2, 7820, -41, 716, 10, -651, 72, 15, 1, 12, 0, 0, 12, 134, 4, 25, 4, -10, -4944, -7, -9, -11, 0, -246, 1, 182, 972, 0, 1, 5, 1, 6, 50, 65, 199, -1360, 18, 8, 11, 18, 3, -1, -9, 12};
			for(int i = 0; i < postfix_test_expressions.length; i++){
			assertEquals(("the expression " + postfix_test_expressions[i] +"should yield " + postfix_test_expressions_answers[i]), temp.evaluate(postfix_test_expressions[i]), postfix_test_expressions_answers[i]);
			}

			System.out.println("Calculator Test Program Passed!");
		}

}
