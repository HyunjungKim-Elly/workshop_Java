package workshop9;

public class SharedAccount{
	private String currency;	
	private double balance;
	
	SharedAccount(double balance, String currency){
		this.balance = balance;
		this.currency = currency;
	}
	
	public synchronized void deposit(double deposit, String currency) {
		while(getBalance() != 0 && getCurrency() != currency) {			
			try {
				System.out.println("You can't deposit now, wait");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		if(getCurrency() == currency) {
			setCurrency(currency);
			setBalance(balance += deposit);
		}else {				
			setCurrency(currency);
			setBalance(deposit);
		}		
		
		System.out.println("\n<-------Deposit is available------->");
		System.out.println(deposit + " " + currency + " was added");
		System.out.println("The current balance is " + getBalance() +" "+ getCurrency()+"\n");
		notify();
			
	}
	
	public synchronized void withdraw(double widthdraw) {
		while(getBalance() < widthdraw) {
			try {
				System.out.println("You can't withdraw now. Insufficient balance\n");
				wait();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("\n<-------Withdraw is available------->");
		setBalance(getBalance() - widthdraw);
		System.out.println("1.0 " + getCurrency() + " was withdrawn");
		System.out.println("Your balance is now "+ getBalance() + " " + getCurrency()+"\n");
		notify();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public synchronized double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
}
