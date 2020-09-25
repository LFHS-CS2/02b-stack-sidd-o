import random



#Python Script Used to Generate a Test Data Set. Since, Some of the Methods in the Class Were Not My Work, There Are Comments About Which Parts Are and Which Are to Be Transparent. Script Can Be Run By Typing "python postfix_test_case_generator.py" Into the Terminal

#NOTE ABOUT TEST DATASET: Even though both of the methods used to evaluated the generated postfix expressions were sourced from two seperate internet source, use integer match, and are cross-checked with each other, there would occasionally be a case that would fail the test program, requiring a manual calculation to verify the correct result, which would always require changing the expected answer in the data set. Nonetheless, this script was extremely useful is generating usable expressions and correctly evaluating most of them.

#Lists Used for Local Storage
expression_strings = []
results = []

#Number of Desired Test Cases
test_case_count = 50;

#Highest Randomly Generated Int Desired
random_int_max = 100;


# Python program to evaluate value of a postfix  
# expression with integers containing multiple digits
#THIS METHOD WAS NOT WRITTEN BY MYSELF BUT WAS FOUND ONLINE AS A MEASURE TO ENSURE THAT A PROGRAMMATIC ERROR WAS NOT OCCURING IN BOTH JAVA AND PYTHON. 
  
class evalpostfix: 
    def __init__(self): 
        self.stack =[] 
        self.top =-1
    def pop(self): 
        if self.top ==-1: 
            return
        else: 
            self.top-= 1
            return self.stack.pop() 
    def push(self, i): 
        self.top+= 1
        self.stack.append(i) 
  
    def centralfunc(self, ab): 
        for i in ab: 
  
            # if the component of the list is an integer 
            try: 
                self.push(int(i)) 
            # if the component of the list is not an integer,  
            # it must be an operator. Using ValueError, we can  
            # evaluate components of the list other than type int 
            except ValueError: 
                val1 = self.pop() 
                val2 = self.pop() 
  
                # switch statement to perform operation 
                switcher ={'+':val2 + val1, '-':val2-val1, '*':val2 * val1, '/':val2 / val1, '^':val2**val1} 
                self.push(switcher.get(i)) 
        return int(self.pop())


# Returns the Result of the Given Postfix Expression in a List. THIS METHOD WAS NOT WRITTEN BY MYSELF BUT WAS FOUND ONLINE AS A MEASURE TO ENSURE THAT A PROGRAMMATIC ERROR WAS NOT OCCURING IN BOTH JAVA AND PYTHON.
def calculate(inputs):
    stack = []
    for a in inputs:
        if type(a) is int:
            stack.append(a)
            continue

        op1, op2 = stack.pop(), stack.pop()

        if a == '+':
            stack.append(op2 + op1)
        elif a == '-':
            stack.append(op2 - op1)
        elif a == '*':
            stack.append(op2 * op1)
        elif a == '/':
            stack.append(op2 / op1)
        elif a == '^':
            stack.append(pow(op2, op1))

    return stack.pop()

#EVERYTHING WRITTEN FROM HERE DOWN WAS WRITTEN BY ME


#Creates a Valid Expression Using Random Integers and Operations, Except for Expononetials Due to Issues With Arthmatic Overflow Issues, Calls Both Evaluate Methods, Confirms that the Results Match, and Then Appends the Expression and the Result to Local Variables.
def expression_creator():
    expression = []
    length = random.randint(3, 5)*random.randint(1, 9)
    index = 0
    expression_str = ""
    max_operations = length - 1
    int_balance = 0
    operation_counter = 0
    operations = ['+', '-', '*', '/']

    while(index < length):
        if(index < 2):
            random_int = random.randint(1, random_int_max)
            expression.append(random_int)
            expression_str = expression_str + str(random_int) + " "
            int_balance = int_balance + 1
        else:
            if(False):
                print(0)
            if(int_balance >= 2 and operation_counter < max_operations):
                random_operation = random.choice(operations)
                expression.append(random_operation)
                expression_str = expression_str + str(random_operation) + " "
                operation_counter = operation_counter + 1
                int_balance = int_balance - 1
            else:
                random_int = random.randint(1, random_int_max)
                expression.append(random_int)
                expression_str = expression_str + str(random_int) + " "
                int_balance = int_balance + 1
        index = index + 1
    if(isinstance(expression[length - 1], int)):
        random_operation = random.choice(operations)
        expression.append(random_operation)
        expression_str = expression_str + str(random_operation) + " "
    strconv = expression_str.strip().split(' ')
    obj = evalpostfix()
    answer = obj.centralfunc(strconv)
    answer1 = calculate(expression)
    if(answer == answer1):
        expression_strings.append(expression_str)
        results.append(answer)
    else:
        print("Oops!")
    return answer

counter = 0

# Generate the Specified Number of Test Cases and Prints the Evaluated Result to the Terminal
while(counter < test_case_count):
    print(expression_creator())
    counter = counter + 1




#Format the List Data Into a String Following Java Syntax

formatted_array_literal = "String[] postfix_test_expressions = {"
for x in expression_strings:
    formatted_array_literal = formatted_array_literal + "\"" + x.strip() + "\"" + ", "
formatted_array_literal =formatted_array_literal.strip()[:-1] + "};"


formatted_results_literal = "int[] postfix_test_expressions_answers = {"
for x in results:
    formatted_results_literal = formatted_results_literal + str(x) + ", "
formatted_results_literal =formatted_results_literal.strip()[:-1] + " };"

#Print Results to Terminal
print("\nCopy and Paste The Following String[] into PostfixCalculatorTest.java\n")
print(formatted_array_literal)

print("\nCopy and Paste The Following int[] into PostfixCalculatorTest.java\n")
print(formatted_results_literal)
