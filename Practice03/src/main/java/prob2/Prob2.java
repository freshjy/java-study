package prob2;

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		/*코드추가*/
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		int[] count = {0,0,0,0,0,0,0,0,0};
		
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();//67879;입력받는 코드 쳐야함
		System.out.println("금액:"+money);

		for (int i = 0; i < unit.length; i++) {
			if (money >= unit[i]) {
				if(money<10) {
					count[unit.length-1] = money;
					break;
				}else {
					while (money >= unit[i]) {
						count[i] = money /unit[i];
						money = money % unit[i];
					}
				}
			}
		}
		for(int i=0; i<count.length; i++) {
				switch(i) {
				case 0:
					System.out.println("오만 원권:"+count[i]+"매");
					break;
				case 1:
					System.out.println("만 원권:"+count[i]+"매");
					break;
				case 2:
					System.out.println("오천 원권:"+count[i]+"매");
					break;
				case 3:
					System.out.println("천 원권:"+count[i]+"매");
					break;
				default:
					System.out.println(unit[i]+"원 동전:"+count[i]+"개");
				}
			
		}
	}
}

