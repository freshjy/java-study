package prob3;

public class Book {
	private int no;
	private String title;
	private String author;
	int stateCode; //1:재고있음, 0:대여중
	
	Book(){}
	Book(int bookNum, String title, String genre){
		no = bookNum;
		this.title = title;
		this.author = genre;
		stateCode=1;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
















