/**
*
* PostfixCalculator Class Allows For Calculations Using Postfix Notation
* @author Sidd O.
* Please Note: Items in Expressions Must Either Be Seperated By Space or Not As a Mix Will Throw a PostfixError
*
*/
import java.io.*;

class PostfixCalculator {
	private String expression = "";
	private int last_ans = 0;
	private final char[] SUPPORTED_OPERATIONS = {'+', '-', '*', '/', '^'};

	public PostfixCalculator() {

	}

	/**
	 *
	 * Returns the Result of a Valid Postfix Expression Contained in the Given
	 * String and Stores the Expression and Result in a Local Variable. Throws a
	 * PostfixError When the Given String is a Not Valid Postfix Expression
	 * 
	 * @params String str
	 * @return int Evaluated Expression
	 *
	 */

	public int evaluate(String str) throws PostfixError {
		expression = str;
		int answer = 0;
		ArrayStack main_stack = new ArrayStack();
		if (!isValidExpression(str)) {
			throw new PostfixError(str);
		}
		ArrayStack temp_stack = getExpressionStackForm(str);
		while (!temp_stack.isEmpty()) {
			String item = (String) temp_stack.pop();
			if (item == null) {
				//Safety First
				throw new PostfixError(str);
			}
			// Check If It Is An Int
			if (item.length() > 0 && isInt(item)) {
				main_stack.push(Integer.parseInt(item));
			} else if (getArrayStackLength(main_stack) < 2) {
				// Throw a PostfixError as all operations require >= 2 integers to complete
				throw new PostfixError(str);
			} else if (item.length() == 1 && item.charAt(0) == '+') {
				// Add the Top Two Integers in the Main ArrayStack
				int num2 = (Integer) main_stack.pop();
				int num1 = (Integer) main_stack.pop();
				main_stack.push(num1 + num2);
			} else if (item.length() == 1 && item.charAt(0) == '-') {
				// Subtract the Top Two Integers in the Main ArrayStack
				int num2 = (Integer) main_stack.pop();
				int num1 = (Integer) main_stack.pop();
				main_stack.push(num1 - num2);
			} else if (item.length() == 1 && item.charAt(0) == '*') {
				// Multiply the Top Two Integers in the Main ArrayStack
				int num2 = (Integer) main_stack.pop();
				int num1 = (Integer) main_stack.pop();
				main_stack.push(num1 * num2);
			} else if (item.length() == 1 && item.charAt(0) == '/') {
				// Divide the Top Two Integers in the Main ArrayStack
				int num2 = (Integer) main_stack.pop();
				int num1 = (Integer) main_stack.pop();
				main_stack.push(num1 / num2);
			} else if (item.length() == 1 && item.charAt(0) == '^') {
				// Raise the 2nd Integer From the Top to the Power of the Top Integer in the
				// Main ArrayStack
				int num2 = (Integer) main_stack.pop();
				int num1 = (Integer) main_stack.pop();
				main_stack.push((int) Math.pow(num1, num2));
			} else {
				throw new PostfixError(str);
			}

			// Add Support for Additional Operations Here With Additional else if statments

		}
		// If Calculations Were Successfull (No Extra Integers at the End in an Invalid
		// Expression), Then Return the Result (The Only Integer Remaining on the
		// ArrayStack)
		if (getArrayStackLength(main_stack) == 1) {
			answer = (Integer) main_stack.pop();
			last_ans = answer;
			return answer;
		} else {
			// Throw a PostfixError As There Are Incorrectly Located Integers Without
			// Operations
			throw new PostfixError(str);
		}

	}

	/**
	 *
	 * Returns Whether the Given String Is an Integer Value Using Error Handling to
	 * Catch a NumberFormatException Which Occurs When the Given String is Not an
	 * Integer
	 * 
	 * @params String str
	 * @return boolean answer
	 *
	 */
	private boolean isInt(String str) {
		if (str == null) {
			return false;
		}
		try {
			int temp = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * Returns an ArrayStack Containing Strings With Each Element of the Postfix
	 * Input
	 * 
	 * @params String str
	 * @return ArrayStack Parsed Expression
	 *
	 */

	private ArrayStack getExpressionStackForm(String str) {
		ArrayStack temp = new ArrayStack();
		// Check Whether It Appears to Use Whitespace to Seperate Input
		if (usesSpaceNotation(str.trim())) {
			String[] components = str.split("\\s+");
			for (int i = 0; i < components.length; i++) {
				temp.push(components[i]);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				temp.push(Character.toString(str.charAt(i)));
			}
		}

		// Reverse the Order of the Stack
		ArrayStack temp1 = new ArrayStack();
		while (!temp.isEmpty()) {
			temp1.push(temp.pop());
		}

		return temp1;

	}

	/**
	 *
	 * Returns the Length of the Given ArrayStack, Making Sure to Return the Given
	 * ArrayStack to its Original Order
	 * 
	 * @params ArrayStack stk
	 * @return int Length of Given ArrayStack
	 *
	 */

	private int getArrayStackLength(ArrayStack stk) {
		ArrayStack stk1 = new ArrayStack();
		int count = 0;
		while (!stk.isEmpty()) {
			stk1.push(stk.pop());
			count++;
		}
		while (!stk1.isEmpty()) {
			stk.push(stk1.pop());
		}
		return count;
	}

	/**
	 *
	 * Returns a String Containing the Most Recently Evaluating Expression Followed
	 * by " = " and the Answer of the Most Recently Evaluated Expression
	 * 
	 * @return String To String Expression
	 *
	 */
	public String toString() {
		return (expression + " = " + last_ans);
	}

	/**
	 *
	 * Returns Whether There a Whitespace Characters in the Given String, Indicating
	 * That the Given String Uses Whitespace to Seperate Items In the Expression
	 * 
	 * @params String str
	 * @return boolean answer
	 *
	 */

	private boolean usesSpaceNotation(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * Returns Whether the Given String Contains An "Illegal Characters", Such as
	 * Non-Digits, Non-Whitespace, or Characters Other Than the Supported
	 * Operations. Serves as a First Round of Expression Checking
	 * 
	 * @params String str
	 * @return boolean answer
	 *
	 */

	private boolean isValidExpression(String str) {
		for (int i = 0; i < str.length(); i++) {
			char temp_char = str.charAt(i);
			boolean temp_char_ans = false;
			if (Character.isDigit(temp_char) || Character.isWhitespace(temp_char)){
				temp_char_ans = true;
			}
			for(int j = 0; j < SUPPORTED_OPERATIONS.length; i++){
				if(SUPPORTED_OPERATIONS[j] == temp_char){
				temp_char_ans = true;
				}
				
			}
			
			if(!temp_char_ans){
				return false;
			}
		}
		return true;
	}
}


