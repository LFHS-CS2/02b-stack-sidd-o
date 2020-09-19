class PostfixCalculator{
	private int last_ans = 0;

	public PostfixCalculator(){

	}

	public int evaluate(String str){
		int answer = 0;
		ArrayStack main_stack = new ArrayStack();
		if(!isValidExpression(str)){
			last_ans = answer;
			return answer;
		}
	ArrayStack temp_stack = getExpressionStackForm(str);
	while(!temp_stack.isEmpty()){
		String item = (String) temp_stack.pop();
		//Check If It Is An Int
		//Single Digit Case
		if(isInt(item)){
			main_stack.push(Integer.parseInt(item));
		} else if(item.equals("+")){
			int num2 = (Integer) main_stack.pop();
			int num1 = (Integer) main_stack.pop();
			main_stack.push(num1 + num2);
		} else if(item.equals("-")){
			int num2 = (Integer) main_stack.pop();
			int num1 = (Integer) main_stack.pop();
			main_stack.push(num1 - num2);
		} else if(item.equals("*")){
			int num2 = (Integer) main_stack.pop();
			int num1 = (Integer) main_stack.pop();
			main_stack.push(num1 * num2);
		} else if(item.equals("/")){
			int num2 = (Integer) main_stack.pop();
			int num1 = (Integer) main_stack.pop();
			main_stack.push(num1 / num2);
		} else if(item.equals("^")){
			int num2 = (Integer) main_stack.pop();
			int num1 = (Integer) main_stack.pop();
			main_stack.push(Math.pow(num1, num2));
		}
		
	}

	if(!main_stack.isEmpty()){
		answer = (Integer) main_stack.pop();
	}

	if(!main_stack.isEmpty()){
		System.out.println("Oops! That's not a good expression...");
	}
	return answer;

	}

	private boolean isInt(String str){
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

	private ArrayStack getExpressionStackForm(String str){
		ArrayStack temp = new ArrayStack();
		if(usesSpaceNotation(str)){
			String[] components = str.split("\\s+");
			for(int i = 0; i < components.length; i++){
				temp.push(components[i]);
			}
		}else{
			for(int i = 0; i < str.length(); i++){
				temp.push(Character.toString(str.charAt(i)));
		}
	}

	//Reverse the Order of the Stack

	ArrayStack temp1 = new ArrayStack();

	while(!temp.isEmpty()){
		temp1.push(temp.pop());
	}

	return temp1;
	
	}

	public String toString(){
		return "";
	}

	private boolean usesSpaceNotation(String str){
		for(int i = 0; i < str.length(); i++){
			if(Character.isWhitespace(str.charAt(i))){
				return true;
			}
	}
	return false;
	}


	private boolean isValidExpression(String str){
		for(int i = 0; i < str.length(); i++){
			if(!(Character.isDigit(str.charAt(i)) || Character.isWhitespace(str.charAt(i)) || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'|| str.charAt(i) == '^')){
				return false;
			}
		}
		return true;
	}
}
