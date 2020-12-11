package prob3;

import java.util.Scanner;

public class BookShop {
	public static void main(String[] args) {
		Book[] books = new Book[10];
		books[0] = new Book(1,"트와일라잇","스테파니메이어");
		books[1] = new Book(2,"뉴문","스테파니메이어");
		books[2] = new Book(3,"이클립스","스테파니메이어");
		books[3] = new Book(4,"브레이킹던","스테파니메이어");
		books[4] = new Book(5,"아리랑","조정래");
		books[5] = new Book(6,"젊은그들","김동인");
		books[6] = new Book(7,"아프니까 청춘이다","김난도");
		books[7] = new Book(8,"귀천","천상병");
		books[8] = new Book(9,"태백산맥","조정래");
		books[9] = new Book(10,"풀하우스","원수연");
		Scanner key = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요.:");
		int num = key.nextInt();
		
		rent(num, books);
		
		System.out.println("*****도서 정보 출력하기*****");
		displayBookInfo(books);
	}

	public static void rent(int num, Book[] books) {
		books[num-1].stateCode = 0;
		System.out.println(books[num-1].getTitle()+"이(가) 대여 됐습니다.");
	}

	public static void displayBookInfo(Book[] books) {
		for(Book book : books) {
			System.out.print("책 제목:"+book.getTitle()+", 장르:"+book.getAuthor() + ", 대여 유무:");
			if(book.stateCode==1) {
				System.out.println("재고있음");
			}else {
				System.out.println("재고없음");
			}
		}
	}
}
