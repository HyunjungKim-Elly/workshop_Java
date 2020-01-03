package sw;


public class Withdraw extends Thread {
	
	private SharedAccount sharedAcct;
	private int threadInUse = 0;
	
	//Constructor //
	
	public Withdraw(SharedAccount sharedAcct) {
		this.sharedAcct = sharedAcct;
	}
	
	public void run() {
		while(threadInUse == 0) {
			synchronized(sharedAcct) {
				while(sharedAcct.getBalance() != 0) {
					sharedAcct.withdrawBalance(1.0);
					System.out.println("1.0 " + sharedAcct.getCurrency() + " was withdrawn");
					System.out.println("Balance left in Account: " + sharedAcct.getBalance());
					sharedAcct.notify();
				}

				try {
					sharedAcct.wait();
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				}
			}
		}
	}
}