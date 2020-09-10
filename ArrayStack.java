/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author (your name)
 */
public class ArrayStack implements Stack
{
	Object[] temp;
	Object oldest = new Object();
	public ArrayStack(){
		temp = new Object[0];
	}

	public void push(Object obj){
		Object[] temp3 = new Object[temp.length + 1];
		for(int i = 0; i < temp.length; i++){
			temp3[i] = temp[i];
		}
		temp3[temp3.length - 1] = obj;
		temp = temp3;
	}

	public Object pop(){
		if(temp.length == 0){
			//throw a StackException
		}
		Object temp1 = new Object();
		temp1 = temp[temp.length - 1];
		Object[] temp0 = new Object[temp.length - 1];
		for(int i = 0; i < temp0.length; i++){
			temp0[i] = temp[i];
		}
		temp = temp0;

		return temp1;
		
	}

	public Object peekTop(){
		if(temp.length == 0){
			//throw a StackException
		}
		return temp[temp.length - 1];
	}

	public boolean isEmpty(){
		return(temp.length == 0);
	}
}
