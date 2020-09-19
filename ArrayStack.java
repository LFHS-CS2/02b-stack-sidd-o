/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author (your name)
 */
public class ArrayStack implements Stack
{
	Object[] temp;
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
		try{
		if(temp.length == 0){
			throw new StackException("Stack Is Already Empty...");
		}
		Object temp1 = new Object();
		temp1 = temp[temp.length - 1];
		Object[] temp0 = new Object[temp.length - 1];
		for(int i = 0; i < temp0.length; i++){
			temp0[i] = temp[i];
		}
		temp = temp0;

		return temp1;

		} catch(StackException e){
			System.out.println(e);
		}
		return null;
		
	}

	public Object peekTop(){
		try{
		if(temp.length == 0){
			throw new StackException("Stack Is Already Empty...");
		}
		return temp[temp.length - 1];

		}catch(StackException e){
			System.out.println(e);
		}
		return null;
	}

	public boolean isEmpty(){
		return(temp.length == 0);
	}
}
