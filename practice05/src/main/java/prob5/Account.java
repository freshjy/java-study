package prob5;

public class Account {
	String accountNo;
	int balance = 0;
	
	Account(String accountNo){
		this.accountNo = accountNo;
		System.out.println(accountNo+"계좌가 개설되었습니다.");
	}
	
	public String getAccNo() {
		return accountNo;
	}
	public void setAccNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void deposit(int balance) {
		this.balance += balance;
		System.out.println(accountNo + "계좌에 " + balance + "만원이 입금되었습니다.");
	}
	public void withdraw(int balance) {
		this.balance -= balance;
		System.out.println(accountNo + "계좌에 " + balance + "만원이 출금되었습니다.");
	}
	
}
