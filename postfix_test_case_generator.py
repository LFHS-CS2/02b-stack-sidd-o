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
    expression_strings.append(expression_str)
    answer = calculate(expression)
    results.append(answer)
    return answer


counter = 0

while(counter < 100):
    print(expression_creator())
    counter = counter + 1

print(expression_strings)

print(results)
