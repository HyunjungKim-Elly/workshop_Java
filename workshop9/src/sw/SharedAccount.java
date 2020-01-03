package sw;

public class SharedAccount {

	private double balance;
	private String currency;
	
	// Constructor //
	SharedAccount(double balance, String currency) {
		this.balance = balance;
		this.currency = currency;
	}
	
	// Getters //
	public double getBalance() {
		return balance;
	}
	public String getCurrency() {
		return currency;
	}
	
	// Setters //
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	// Function to deposit money 
	public void depositBalance(double balance) {
		this.balance = this.balance + balance;
	}
	
	// Function which withdraws the money
	public void withdrawBalance(double balance) {
		this.balance = this.balance - balance;
	}
	
	
	@Override
	public String toString() {
		return "<----- Shared Account - Withdraw ----->\n\n"
				+ "Current balance is " + getBalance() + "\n"
						+ "Currency: " + getCurrency();
	}
}