package Stack;

public class StackCalculator {
	
private String infixExpression;	
	
	private Stack<Character> stack = new Stack<Character>();
	private Stack<String> stack1 = new Stack<String>();
	private String success = "";
	private char[] postfixArr;
	int calcul = 0;
	
	public StackCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}	

	public void calculator(char oper,Stack<String> stack1) {
		if(oper == '+') {
			int a,b;
			b= Integer.parseInt(stack1.pop());
			a = Integer.parseInt(stack1.pop());
			calcul = a+b;
			stack1.push(Integer.toString(calcul));
		}else if(oper == '-') {
			int a,b;
			b= Integer.parseInt(stack1.pop());
			a = Integer.parseInt(stack1.pop());
			calcul = a-b;
			stack1.push(Integer.toString(calcul));
		}else if(oper == '*') {
			int a,b;
			b= Integer.parseInt(stack1.pop());
			a = Integer.parseInt(stack1.pop());
			calcul = a*b;
			stack1.push(Integer.toString(calcul));
		}else {
			int a,b;
			b= Integer.parseInt(stack1.pop());
			a = Integer.parseInt(stack1.pop());
			calcul = a/b;
			stack1.push(Integer.toString(calcul));
		}
	}
	
	public int CalculateUsingStack() {
		
		for(int i=0; i<postfixArr.length; i++) {
			if(postfixArr[i] >= '0' && postfixArr[i] <= '9') {
				stack1.push(String.valueOf(postfixArr[i]));
			}else {
				switch(postfixArr[i]) {
				case '+':
					calculator('+',stack1);
					break;
				case '-':
					calculator('-',stack1);
					break;
				case '*':
					calculator('*',stack1);
					break;
				case '/':
					calculator('/',stack1);
					break;
				}
				
			}
		}
		
		return calcul;
	}		
	
	
	public Stack<Character> bracketInStack(char arr, Stack<Character> stack) {
		while(!stack.empty()) {
			if(stack.peak()=='(')	break;
			success += stack.pop();
		}
		stack.push(arr);
		return stack ;
	}
	
	public boolean multipleDivedeOperCheck(Stack<Character> stack) {
		boolean check = false;
		if(stack.peak() =='*' || stack.peak() == '/')	check  = true;
		return check;
	}
	
	public boolean plusMinusOperCheck(Stack<Character> stack) {
		boolean check = false;
		if(stack.peak() == '+' || stack.peak() == '-') check = true;
		return check;
	}
	
	public String infixToPostfix() {
		
		char[] arr = infixExpression.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				success += arr[i];
			} else {
				switch (arr[i]) {
				case '(':
					stack.push(arr[i]);
					break;
				case ')':
					while (stack.peak() != '(') success += stack.pop();
					stack.pop();
					break;
				default:
					if (arr[i] == '+' || arr[i] == '-' 
					&& !(stack.empty() && multipleDivedeOperCheck(stack) && plusMinusOperCheck(stack))) {
						bracketInStack(arr[i],stack);
					}else if(!stack.empty() && multipleDivedeOperCheck(stack) ) {
						bracketInStack(arr[i],stack);
					}else  stack.push(arr[i]);
				}
			}
		}
		
		while(!stack.empty()) {
			success += stack.pop();
		}
		
		postfixArr = success.toCharArray();
		
		return success;
	}
}












