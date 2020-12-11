package practice02;

public class Goods {
	private String name;
	int price;
	int stockCount;

	Goods(String name, int price, int stockCount) {
		this.name = name;
		this.price = price;
		this.stockCount = stockCount;
	}

	String getName() {
		return name;
	}

	int getPrice() {
		return price;
	}

	int getstockCount() {
		return stockCount;
	}

}