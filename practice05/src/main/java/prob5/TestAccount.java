package prob5;

public class TestAccount {
	public static void main(String[] args) {

		Account account = new Account("078-3762-293");
		
		System.out.println( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
		account.deposit(100);	//입금
		System.out.println( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
		account.withdraw(30);	//출금
		System.out.println( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
	}

}
