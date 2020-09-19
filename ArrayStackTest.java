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
			String[] postfix_test_expressions = {"123*+", "4 5 + 7 2 - *", "4 2 3 5 1 - + * +", "3", "", "6 2 + 6 - 10 - 4 * 5 + 5 + 4 * 1 - 10 / 2 + 9 / 1 * 2 * 4 / 2 / 5 + 3 / ", "3 9 / 6 + 10 + ", "7 3 + 9 - 7 / 7 * 1 * 4 - 8 + 3 * 1 - 5 * 7 + 1 * ", "1 1 + 10 - 6 / 7 - 7 / 2 * 1 + 1 / 8 + 3 * 2 - 5 - 9 + 5 + 10 / 3 - 1 / 3 - 7 - 6 + 4 * 5 * ", "3 3 / 4 * ", "8 7 / 7 * 4 * 4 * 10 - ", "7 10 - 8 - 9 * 5 * 5 + 8 + 7 * 8 + 5 - 6 * 9 * 4 * 5 / 3 + 1 * 7 / 1 + 9 - 2 - 4 - 1 - 3 / ", "9 5 / 8 + 3 - 6 / ", "1 7 + 1 / 3 + 3 + 10 * 1 - 9 + 6 + 8 - 1 - 4 + 2 * 5 - ", "8 4 * ", "3 6 / 8 - 2 / ", "8 8 * 10 / 5 / 7 - 10 + 4 * 3 / 9 - 6 - 9 - 6 + 9 / 7 - 1 / 10 * ", "2 2 / 4 + 1 * 9 - 4 - 2 - 5 * 6 + 5 + 3 + 7 * 1 / 10 / 3 - 6 * 7 / ", "9 5 * 8 / 6 / 7 / 1 - 9 - 7 / 9 + ", "10 3 + 9 - ", "2 3 * 10 - 1 + 4 - 8 + 6 / 9 / 2 + 1 * 5 - ", "8 3 + 9 - 7 * 2 - 2 / 2 * 6 - 9 / 6 * 3 * 7 - 6 * ", "7 10 / 5 * 2 + 4 + 3 + 5 / 2 - 9 / 2 - 5 - ", "4 10 - 5 - 9 - 3 / 8 - 2 - 10 - 3 - 4 / 2 + 1 - 5 * 1 + 10 / 5 / ", "5 3 / 7 - 6 + 1 - 6 / 9 * ", "3 2 + 6 * ", "2 3 / 8 / 1 + 9 * 7 + 10 + ", "2 1 * 3 / 9 * 4 * 7 * 6 + 6 - 9 / 9 / 7 + 10 - 2 - ", "1 6 - 7 + 4 - 8 + 1 * 8 * 5 * 5 - 2 / 7 / 3 / 6 / 8 + 2 - 8 * 2 + 1 / 4 * 6 + 6 + 9 - 10 * ", "9 4 + 10 * 8 * 2 + 5 / ", "6 7 - 5 + 7 * 6 + 5 / 4 * 10 * 8 - 10 + 2 * 7 - 8 / ", "10 1 / 8 - 9 - 4 - 3 + 6 / 6 / 5 + 3 * 6 - 7 - 4 * 8 + 3 / 4 * 2 - ", "3 4 * 5 / 4 - 9 * 1 / 9 + 1 - 10 * 7 / 7 * 2 + 1 + 4 - 8 * ", "1 2 / 3 + 8 - 4 - 2 * 7 - 2 * 2 / 5 * 8 + 1 / 4 / 5 + 4 * 8 + 3 / ", "2 7 / 4 + 1 / 4 / ", "5 5 * 3 + 7 / 1 + 9 - 3 / 4 - 10 - 7 - 5 + 7 * 2 / 4 * ", "2 8 / 4 - 9 + 6 / 3 * 1 + 6 / 7 + ", "4 6 / 5 / 6 - 7 / 3 - 4 / 6 - 2 - 10 / 8 + ", "7 5 - 2 + ", "4 6 * 1 + 9 * 8 / 3 + ", "7 7 - 9 / 7 / 3 - 3 + 3 * 3 * 5 * 3 - 1 - 1 / 2 - 7 - 2 * 7 + 5 * 3 + 1 * 4 / 10 + 6 / 6 * ", "10 1 - 9 - 7 / 1 * 10 + 5 * ", "6 4 + 1 * 8 - 9 * 7 * 6 - 8 * 2 / 1 * 8 + 7 * 2 / 8 - 1 * 6 + ", "8 2 / 10 * 5 * 7 - 10 + 8 + 10 / 1 + 8 - 8 / ", "1 10 - ", "2 5 + 4 + 3 / 4 - 6 + 5 + 4 - ", "3 7 - 6 * 10 - 5 / ", "8 3 / 7 - 1 - 3 - 4 * 7 * 3 / ", "4 7 - 8 / 8 / 9 * 8 + 2 / 10 * ", "7 10 + 7 * 4 / 1 - 8 - 4 + ", "5 5 * 3 - 9 * 4 - 6 / 2 + 8 / 7 / 10 / 6 + 4 - 5 - ", "6 10 + 3 + 9 * 1 * 8 * 7 / 9 / ", "5 7 - 2 * 7 - 9 * 10 - 5 / 1 - 5 - 1 + 4 * 7 / 5 + 1 + ", "3 3 - 6 * 6 - 7 / 6 * 8 / 4 - 2 - 4 * 7 + 9 - 8 + 6 - 2 - 6 * ", "5 8 / 2 + 3 + 4 + 3 + 10 * 3 * 3 - ", "10 5 / 6 + 7 + 5 + 8 * 10 / 8 * 4 / 5 + 1 * ", "1 2 + 2 / 4 + 2 * 1 - 10 / 9 - ", "2 3 + 10 * 1 * 6 / 8 / 5 * 10 - 10 - ", "8 8 / ", "10 7 + 5 + 6 / ", "1 5 + 4 / 9 - 3 / 8 + 8 * 7 - 2 * 8 / 6 - ", "9 2 * 5 * 9 / 7 - 10 * 5 * 1 - 6 + 8 - 2 - 2 + 9 / 10 + 1 / 10 + 4 * 7 + 5 * ", "8 1 * 10 - 9 - 10 / 7 / 9 + 2 + 4 / 8 - 1 - 2 - 9 / 7 - 5 - 8 - 4 - 9 * 1 - 1 + 6 - 1 / 9 - ", "2 1 / 10 / 7 * 7 + 10 * 8 + 9 / 2 - 4 + 5 + 8 * 9 / 7 * 3 + ", "9 2 + 2 - ", "5 10 / 10 * 10 + 2 - 3 - 10 * 1 - 3 + 9 + 4 * ", "4 2 * 5 - 6 - 7 * 8 - 5 * ", "6 4 + 5 + 1 / 1 / ", "9 3 / 7 * 2 / 9 + 9 + 10 / 8 - 7 - 4 * 8 - 4 / 1 + 1 - 8 / 4 - 7 * 2 / 8 * ", "5 9 + 9 / 8 / 6 / 9 / 9 - 3 / 2 - 5 * 7 + ", "1 5 * 10 - 4 + 4 + 2 + 9 * 1 - 9 - 6 + 1 - 4 / 8 * 8 * 9 - 3 * 7 * 9 / 5 / ", "2 7 - ", "9 7 - 10 - 8 * 5 * 9 - 4 - 2 - 10 + 5 + 5 - ", "10 7 + 2 * 5 + 10 / 2 + 4 - 9 + 6 + 8 / 6 * 5 + 8 * ", "1 4 / 6 * 10 - 6 * 9 * 5 * 1 + 2 - 3 + ", "7 9 + 4 / ", "3 10 - 8 + 3 / 10 - ", "7 4 / 1 + 2 * ", "5 7 - 9 - 8 - 1 + ", "8 8 + 2 + 9 / 6 * 9 + 10 * 8 + 7 - 8 - 3 + 5 * 2 * 5 / ", "4 5 * 10 - 3 - 7 - 4 * 1 / 5 + 7 / 9 / 10 * 1 / 7 + 4 + ", "6 3 / 2 / 1 + 5 + 8 / 2 - ", "5 2 * 4 * 8 / 5 - 2 - 8 / 8 / ", "10 7 + 6 * 9 - 5 / 8 - 6 / 4 / ", "10 10 - 5 / 8 * 2 * 2 * 5 / 5 / 10 / 1 + 10 + 4 + 2 + 8 * 4 * 2 / 10 + ", "1 2 - 5 / 3 * 6 * 5 - 3 + 4 / 4 - 8 / 5 + ", "10 7 + 2 + 5 / 6 + 9 * 3 / 10 + 9 * 2 * 7 / 7 + 6 + ", "10 2 / 10 - 8 * 3 - 8 - 3 * 3 - 2 - 3 - 1 * ", "7 10 / 5 / 6 * 2 * 3 + 10 - 7 + 4 + 7 / ", "3 7 + 2 * 9 + 8 * 10 / 3 - 7 / ", "6 4 / 3 / 4 / 5 * 5 - 8 * 8 - 4 / ", "1 7 - 9 + 9 * 9 + ", "3 3 * 2 * 3 + 1 / 4 + 1 / ", "6 6 * 2 * 8 - 9 + 10 * 6 * 4 - 10 * 9 + 10 + 6 * 1 - ", "1 8 - 8 - 10 + 1 * 1 - 2 + 6 / 10 / 1 * 7 / 9 * 9 * 10 + 6 * ", "3 7 + 3 * 4 / 6 + 9 / 7 + 4 / 2 + 9 * 5 + ", "3 5 * 9 * ", "5 6 * 9 * 10 / 10 / 5 / 7 / 9 + 1 / 3 - 3 * 2 - 10 * ", "1 2 + 8 - 7 - 3 * 7 + ", "9 10 - 6 + 10 - 3 * 8 + 3 - 7 + 5 * 8 / 1 - 7 * 3 + ", "3 6 * 9 - 6 - 8 / 3 + 5 * 4 - 5 * 9 * 6 * 10 - 1 / 7 / 5 - 2 - 6 - 9 - 6 / 6 * 5 * 6 * 9 + ", "1 3 * 3 + 1 - 10 + 1 + 1 / 9 - 1 - 5 - 1 / ", "8 4 - 8 * 1 + ", "1 7 / 2 / ", "5 5 * 4 - 4 - 1 * 3 / 6 / 3 / 5 / 5 + 3 / "};
			int[] postfix_test_expressions_answers = {7, 45, 18, 3, 0, 1, 16, 62, -100, 4, 102, -6940, 1, 293, 32, -4, -90, -25, 7, 4, -3, -42, -8, -1, -9, 30, 26, -5, 2030, 208, 59, 2, -848, -31, 1, -252, 7, 7, 4, 31, -18, 50, 1706, 1, -9, 6, -7, -84, -10, 24, -3, 21, -10, -180, 357, 37, -9, -15, 1, 3, 2, 755, -240, 94, 9, 244, -145, 15, -168, -18, 294, -5, -325, 136, -2698, 4, -10, 4, -18, 412, 11, -2, -1, 0, 282, 3, 108, -161, 0, 2, -12, 36, 25, 262673, -426, 41, 135, 160, -29, -18, 11889, 1, 33, 0, 1};
			for(int i = 0; i < postfix_test_expressions.length; i++){
			assertEquals("they should be equal", temp.evaluate(postfix_test_expressions[i]), postfix_test_expressions_answers[i]);
			}

			System.out.println("Calculator Test Program Passed!");
		}

}
