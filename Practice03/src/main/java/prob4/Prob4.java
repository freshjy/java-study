package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        int intArray[] = new int[5];
        double sum = 0;

        /* 키보드에서 배열 크기만큼 입력 받아 배열에 정장하는 코드 */
        System.out.println("5개의 숫자를 입력하세요.");
        int num = 0;
        while(num != intArray.length) {
        	int value = in.nextInt();
			intArray[num] = value;
        	
        	num++;
        }
        /* 배열에 저장된 정수 값 더하기 */
        for(int i=0; i<intArray.length; i++) {
        	sum+=intArray[i];
        }
        /*출력*/
        System.out.println("평균은 " + sum/num + " 입니다.");
	}

}
