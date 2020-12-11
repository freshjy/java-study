package prob1;

import java.util.Scanner;

public class Prob1 {
	
	static boolean oddCheck(int inputNumber) {
		if (inputNumber%2==0) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		while(true) {
			int sum=0; 
			System.out.print( "숫자를 입력하세요. : " );
			int inputNumber = scanner.nextInt();
				
			if(oddCheck(inputNumber)) {
				for(int i=0; i<=inputNumber; i++) {
					if(oddCheck(i)) {
						sum+=i;
					}
				}
				System.out.println(sum);
			}else {
				for(int i=0; i<=inputNumber; i++) {
					if(!oddCheck(i)) {
						sum+=i;
					}
				}
				System.out.println(sum);
			}
		}
	}
}
