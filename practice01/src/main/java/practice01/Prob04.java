package practice01;

import java.util.Random;
import java.util.Scanner;

public class Prob04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		
		int min = 1;
		int max = 100;
		
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println("1-100");
		
		while(true) {			
			Scanner scanner = new Scanner(System.in);
			System.out.print("수를 입력하시오>>" );
			int number = scanner.nextInt();
			if(number == k) {
				System.out.println("맞았습니다.");
				System.out.print("종료하시겠습니까(y/n)");
				String answer = scanner.next();
				
				if( answer.equals("y") ){
				    //종료하도록 작성한다.	
					break;
				}else {
					System.out.println("수를 결정하였습니다. 맞추어 보세요");
					System.out.println("1-100");
					k = r.nextInt(100) + 1;
				}
			}else if(number < k) {
				System.out.println("더 높게");
				if(number > min) min = number;
				System.out.println(min + "-" + max);
			}else {
				System.out.println("더 낮게");
				if(number < max) max = number;
				System.out.println(min + "-" + max);
			}
		}
		

	}
}
