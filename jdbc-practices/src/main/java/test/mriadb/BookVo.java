package test.mriadb;

public class BookVo {
	private Long no;
	private String title;
	private String author;
	private int price;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVo [getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
	
	
		
	
}
