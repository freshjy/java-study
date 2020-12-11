package practice02;

import java.util.Scanner;

class oper {
	int lValue, rValue;
	
	void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}
	int calculate() {
		return 0;
	}
}

class Add extends oper{
	int calculate() {
		return lValue+rValue;
	}	
}

class Sub extends oper{
	int calculate() {
		return lValue-rValue;
	}
}

class Mul extends oper{
	int calculate() {
		return lValue*rValue;
	}
}

class Div extends oper{	
	int calculate() {
		return lValue/rValue;
	}
	
}

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		String line = scanner.nextLine();
		String[] tokens = line.split(" ");

		int lValue = Integer.parseInt(tokens[0]);
		int rValue = Integer.parseInt(tokens[1]);
		String operator = tokens[2];
		switch (operator) {
		case "+": {
			Add add = new Add();
			add.setValue(lValue, rValue);
			int result = add.calculate();
			System.out.println(result);
			break;
		}
		case "-": {
			Sub sub = new Sub();
			sub.setValue(lValue, rValue);
			int result = sub.calculate();
			System.out.println(result);
			break;
		}
		case "*": {
			Mul mul = new Mul();
			mul.setValue(lValue, rValue);
			int result = mul.calculate();
			System.out.println(result);
			break;
		}
		case "/": {
			Div div = new Div();
			div.setValue(lValue, rValue);
			int result = div.calculate();
			System.out.println(result);
			break;
		}
		default: {
			System.out.println("지원하지 않는 계산입니다.");
		}
		
		}
		scanner.close();
	}

}
