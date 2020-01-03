package workshop9;

public class DepositThread extends Thread{
	private SharedAccount sharedAccount;
	private double[] balance;
	private String[] currency;
	private int inUse = 0;
	
	public DepositThread(SharedAccount sharedAccount, double[] balance, String[] currency) {
		this.sharedAccount = sharedAccount;
		this.balance = balance;
		this.currency = currency;
	}
	
	public void run() {
		int i = 0;
		System.out.println("I am accessing to deposit");
		while(i>= 0 && i<balance.length)
			synchronized(sharedAccount) {				
					//if I use for loop, it always alternate
						sharedAccount.deposit(balance[i], currency[i]);	
						
						try {
							if(i < balance.length && i >=0 )i++;
							Thread.sleep((int)(Math.random()*1000));
							
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}			

	
			}
		
	}
}