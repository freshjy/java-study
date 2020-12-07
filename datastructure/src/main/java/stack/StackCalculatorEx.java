package stack;

public class StackCalculatorEx {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(1*2)*(3/4)*(5+(6/7))
		StackCalculator cal1 = new StackCalculator("1+1+1*9*9*4");
//		StackCalculator cal2 = new StackCalculator("2*4+3");
//		StackCalculator cal3 = new StackCalculator("2*1+3/2");
//		StackCalculator cal4 = new StackCalculator("2*2/3");
//		StackCalculator cal5 = new StackCalculator("(1*2+3)/4");
//		StackCalculator cal6 = new StackCalculator("(1+2*3)/4");
//		StackCalculator cal7 = new StackCalculator("(1+9)*(5/4)*(5+(6-7))");
		//StackCalculator cal7 = new StackCalculator("1+2");
		
		
		
		cal1.infixToPostfix();
		System.out.println(cal1.CalculateUsingStack());
//		cal2.infixToPostfix();
//		System.out.println(cal2.CalculateUsingStack());
//		cal3.infixToPostfix();
//		System.out.println(cal3.CalculateUsingStack());
//		cal4.infixToPostfix();
//		System.out.println(cal4.CalculateUsingStack());
//		cal5.infixToPostfix();
//		System.out.println(cal5.CalculateUsingStack());
//		cal6.infixToPostfix();
//		System.out.println(cal6.CalculateUsingStack());
//		cal7.infixToPostfix();
//		System.out.println(cal7.CalculateUsingStack());
		//System.out.println("========test========");
		//StackCalculator cal8 = new StackCalculator("(1*2*3*4)*(4+9*8)-(2+3/4)*(5-7+(6/7*1))");
		//System.out.println(cal8.infixToPostfix());	
		//cal7.infixToPostfix();
		//System.out.println(cal7.CalculateUsingStack());
		
		//aaaaaaaa cal = new aaaaaaaa("(1*2*3*4)*(4+9*8)-(2+3/4)*(5-7+(6/7*1))");
		//System.out.println(cal.infixToPostfix());
		
		//cal7.infixToPostfix();
		
		
	}
}//12*3*4*498*+*234/+57-67/1*+*-