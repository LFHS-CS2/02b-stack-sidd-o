#--------This Is NOT All My Code (Some Found Online to Check Calculations)-----
# Python program to evaluate value of a postfix  
# expression with integers containing multiple digits 
  
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



import random

expression_strings = []
results = []

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
            random_int = random.randint(1, 10)
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
                random_int = random.randint(1, 10)
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

while(counter < 50):
    print(expression_creator())
    counter = counter + 1



formatted_array_literal = "{"
for x in expression_strings:
    formatted_array_literal = formatted_array_literal + "\"" + x.strip() + "\"" + ", "


formatted_results_literal = "{"
for x in results:
    formatted_results_literal = formatted_results_literal + str(x) + ", "



print(formatted_array_literal)

print(formatted_results_literal)
