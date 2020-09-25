import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Tests ArrayStack
 *
 */
public class ArrayStackTest {
	public static void main(String args[]) {
		ArrayStackTest test = new ArrayStackTest();
		test.test_stack();
	}

	/**
	*
	* Test Various Cases Using the ArrayStack Class
	*
	*/
	@Test
	public void test_stack() {
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
		while (!temp.isEmpty()) {
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
		for (int i = 0; i < 100000; i++) {
			temp.push(i);
		}
		assertEquals("they should be equal", temp.peekTop(), 99999);
		while (!temp.isEmpty()) {
			temp.peekTop();
			temp.pop();
		}

		System.out.println("ArrayStack Has Passed All Tests.");

	}
}

