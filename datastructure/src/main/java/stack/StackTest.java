package stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		try {
			stack.push("hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("Java");
			stack.push(".");
			
			
			while(!stack.empty()) {
				String s = stack.pop();
				System.out.println(s);
			}
			
			System.out.println("=============================");
			
			stack = new Stack<String>();
			stack.push("Hello");
			
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}catch(StackException ex) {
			System.out.println(ex);
		}
		
	}

}
