package prob1;

public class MainApp {
	
	public static void main(String[] args) {
		
		int[] data = {1,3,5,8,9,11,15,19,18,20,30,33,31};
		
		/*코드추가*/
		int threeMulNum = 0;
		int threeMulSum = 0;
		
		for(int value : data) {
			if(value%3==0) {
				threeMulNum++;
				threeMulSum+=value;
			}
		}
		System.out.println("주어진 배열에서 3의 배수의 개수=>"+threeMulNum);
		System.out.println("주어진 배열에서 3의 배수의 합=>"+threeMulSum);
	}
}