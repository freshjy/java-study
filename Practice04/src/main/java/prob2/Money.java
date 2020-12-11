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
        //���� ����
    	return new Money(amount-money.amount);
    }
    
    public Money multiply(Money money) {
        //���ϱ� ����
    	return new Money(amount*money.amount);
    }
    
    public Money devide(Money money) {
        //������ ����
    	return new Money(amount/money.amount);
    } 
    
    public boolean equals(Object object) {
        //Object equals �޽�� ������
    	if(object instanceof Money && amount == ((Money) object).amount) {
    		return true;
    	}else return false;
    }
}
