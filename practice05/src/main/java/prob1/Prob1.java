package prob1;
import java.util.Scanner;


public class Prob1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in );
		System.out.print("문자열을 입력하세요:");
		
		String s = scanner.nextLine();
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<i+1; j++) {
				s=s.toUpperCase();
				System.out.print(s.charAt(j));		
			}
			System.out.println();
		}
	}
}
