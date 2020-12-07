package Stack;

public class BTestEx {
	// 0~9 -> 48~57      A~Z -> 65~90     a~z -> 97~122 
	 
	
	static boolean checkMatch(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = expression.toCharArray();
		
		
		boolean retVal = true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
				stack.push(arr[i]);
			else {
				switch(arr[i]) {
				case '}':
					if(stack.empty() || stack.pop() != '{')
						retVal = false;
					break;
				case ')':
					if(stack.empty() || stack.pop() != '(')
						retVal = false;
					break;
				case ']':
					if(stack.empty() || stack.pop() != '[')
						retVal = false;
					break;
				}
				if(!retVal)
					return retVal;
			}
		}
		if(!stack.empty())
			retVal = false;
		return retVal;
		
		
		/*
		if(arr.length==0) return false;
		
		for(int i=0; i<arr.length;i++) {
			
			if(arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
				stack.push(arr[i]);
			}
			
			
			if(arr[i] == ']' ) {	
				
				if(!stack.empty() && stack.peak() == '[') {
					System.out.println("peak" + stack.peak());
					stack.pop();
				}else	return false;
			
			}else if( arr[i] == '}') {
				
				if(!stack.empty() && stack.peak() == '{') {
					System.out.println("peak" + stack.peak());
					stack.pop();
				}else	return false;	
				
			}else if(arr[i] == ')') {
				
				if(!stack.empty() && stack.peak() == '(') {					
					System.out.println("peak" + stack.peak());
					stack.pop();
				}else	return false;	
				
			}
		}
		if(!stack.empty()) return false;
		return true;
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		try {
			String expression = "[a{b+c-(a*3)}+4]";
			System.out.println(checkMatch(expression));
			
			
			expression = "a{b+c-(a*3)+4]";
			System.out.println(checkMatch(expression));
			
		}catch(StackException ex) {
			System.out.println(ex);
		}
		
	}

}
