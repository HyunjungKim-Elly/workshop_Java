package sw;

public class Deposit extends Thread {

	private SharedAccount sharedAccount;

	private double[] balance;
	private String[] currency;
	private int i = 0;
	private int threadInUse = 0;

	//Constructor //
	
	public Deposit(SharedAccount sharedAccount, double[] balance, String[] currency) {
		this.sharedAccount = sharedAccount;
		this.balance = balance;
		this.currency = currency;
	}
	
	public void run() {
		// infinite loop to add balance //
		while (threadInUse != -1 ) {
			synchronized (sharedAccount) {
				while (sharedAccount.getBalance() != 0) {
					try {
						sharedAccount.wait();
					} catch (InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}

				if (sharedAccount.getBalance() == 0 && i < 3) {
					sharedAccount.depositBalance(balance[i]);
					System.out.println("\n<----- Shared Account - Deposit ----->\n");
					sharedAccount.setCurrency(currency[i]);
					System.out.println("Setting new account currency:\t" + sharedAccount.getCurrency() + "\n");
					
					System.out.println("Current Account Balance:\t0.0\n" + "Current Deposit:\t\t" + sharedAccount.getBalance()+"\n");
					i++;
					System.out.println(sharedAccount.toString() + "\n");
					sharedAccount.notify();
				} else {
					Thread.currentThread().interrupt();
					threadInUse = -1;
				}
			}
		}
		Thread.currentThread().interrupt();
	}
}