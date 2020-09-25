/**
 * ArrayStack implements the Stack interface using Arrays
 *
 * @author Sidd O.
 */
public class ArrayStack implements Stack {
	// Only Storage Used by the Class
	Object[] temp;

	/**
	 * Initializes an ArrayStack With No Objects (isEmpty)
	 */
	public ArrayStack() {
		temp = new Object[0];
	}

	/*
	 * Add the given value to the top of the stack.
	 */
	public void push(Object obj) {
		Object[] temp3 = new Object[temp.length + 1];
		for (int i = 0; i < temp.length; i++) {
			temp3[i] = temp[i];
		}
		temp3[temp3.length - 1] = obj;
		temp = temp3;
	}

	/**
	 * Remove and return the value that has been in the ArrayStack the least time.
	 * Throws a StackException if ArrayStack is Already Empty
	 */
	public Object pop() {
		try {
			if (temp.length == 0) {
				throw new StackException("Stack Is Already Empty...");
			}
			Object temp1 = new Object();
			temp1 = temp[temp.length - 1];
			Object[] temp0 = new Object[temp.length - 1];
			for (int i = 0; i < temp0.length; i++) {
				temp0[i] = temp[i];
			}
			temp = temp0;

			return temp1;

		} catch (StackException e) {
			System.out.println(e);
		}
		return null;

	}

	/**
	 * Return the value that pop would give, without modifying the ArrayStack.
	 * Throws a StackException if the ArrayStack is empty.
	 */
	public Object peekTop() {
		try {
			if (temp.length == 0) {
				throw new StackException("Stack Is Already Empty...");
			}
			return temp[temp.length - 1];

		} catch (StackException e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 *
	 * Returns Whether the ArrayStack is Empty
	 *
	 */

	public boolean isEmpty() {
		return (temp.length == 0);
	}
}



