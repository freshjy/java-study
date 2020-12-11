package practice02;

import java.util.Scanner;

public class Prob02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int GOODS_COUNT = 3;
		Goods[] goods = new Goods[GOODS_COUNT];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < GOODS_COUNT; i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			String name = infos[0];
			
			int price = Integer.parseInt(infos[1]);
			int stockCount = Integer.parseInt(infos[2]);
			
			goods[i] = new Goods(name, price, stockCount);
		}
		scanner.close();

		for (int i = 0; i < GOODS_COUNT; i++) {
			System.out.println(
					goods[i].getName() + "(가격:" + goods[i].getPrice() + "원)이 " + goods[i].getstockCount() + "개 입고 되었습니다.");
		}

	}
}
