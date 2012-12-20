
public class Money implements Expression {

	protected int amount;
	protected String currency;
	    
	public Money times(int multiplier) {
		return (new Money(amount * multiplier, currency));
	}
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
		
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && currency().equals(money.currency());
	}
		
	public String currency() {
		return currency;
	}
		
	public String toString() {
		return amount + " " + currency;
	}
		
	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}
		
	public Money reduce(String to) {
		return this;
	}
		
	// Factory Method
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
		
	// Factory Method
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
}
