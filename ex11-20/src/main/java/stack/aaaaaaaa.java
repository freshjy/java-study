package stack;

public class aaaaaaaa {
	
	private String infixExpression;	
	
	public aaaaaaaa(String infixExpression) {
		this.infixExpression = infixExpression;
	}
	
	
	private Stack<Character> stack = new Stack<Character>();
	private String success = ""; // infix�� postfix�� ������ ��
	
	public Stack<Character> bracketInStack(char arr) {//�켱���� Ȯ�� �� push (���ÿ� '('�� ���� ��� pop�� ����)
		while(!stack.empty()) {
			if(stack.peak()=='(')	break;
			success += stack.pop();
		}
		stack.push(arr);
		return stack ;
	}
	
	public boolean MultipleDivedeOperCheck() {
		boolean check = false;
		if(stack.peak() =='*' || stack.peak() == '/')	check  = true;
		return check;
	}
	
	public boolean plusMinusOperCheck() {
		boolean check = false;
		if(stack.peak() == '+' || stack.peak() == '-') check = true;
		return check;
	}
	
	public String infixToPostfix() {
		
		char[] arr = infixExpression.toCharArray(); // infix���� char�� �ɰ��� ���� �迭
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {//���ڸ� string�� ����
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
					if (arr[i] == '+' || arr[i] == '-' &&(!stack.empty() && (MultipleDivedeOperCheck() || plusMinusOperCheck()))) {//���� �� ���� + - �� ���
						bracketInStack(arr[i]);//���ÿ� �ִ� �� pop ���� ���ÿ�'('�� �ִ� ��� pop����
					}else if(!stack.empty() && MultipleDivedeOperCheck() ) {//�켱���� Ȯ�� (������ ������� �ʰ� ���ÿ� �� ���� �켱������ ���� �� )
						bracketInStack(arr[i]);//���ÿ� �ִ� �� pop ���� ���ÿ�'('�� �ִ� ��� pop����
					}else  stack.push(arr[i]);//���ÿ� �ƹ��͵� ���ų� ���� �� ���� �켱������ �� ���� ��� 
					
					
				}
			}
		}
		
		while(!stack.empty()) {//���ÿ� �����ִ� �����ڸ� ���ϰ��� ����
			success += stack.pop();
		}
		
		return success;
	}
}












