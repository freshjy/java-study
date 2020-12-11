package prob2;

public class Money {
	int amount;
    public Money(int amount) {
        this.amount = amount;
    }
    public Money add(Money money) {
    	return new Money(amount+money.amount);
    }
    
    public Money minus(Money money) {
        //빼기 구현
    	return new Money(amount-money.amount);
    }
    
    public Money multiply(Money money) {
        //곱하기 구현
    	return new Money(amount*money.amount);
    }
    
    public Money devide(Money money) {
        //나누기 구현
    	return new Money(amount/money.amount);
    } 
    
    public boolean equals(Object object) {
        //Object equals 메쏘드 재정의
    	if(object instanceof Money && amount == ((Money) object).amount) {
    		return true;
    	}else return false;
    }
}
