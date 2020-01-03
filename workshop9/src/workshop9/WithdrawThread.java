package workshop9;

public class WithdrawThread extends Thread{
	private SharedAccount sharedAccount;
	private int count;
	
	public WithdrawThread(SharedAccount sharedAccount, double[] deposit) {
		this.sharedAccount = sharedAccount;
		this.count = deposit.length;		
	}
	public void run() {
	
		while(count > 0){
			System.out.println("Your friend is accessing to withdraw");
			synchronized(sharedAccount) {
				//while(sharedAccount.getBalance()!= 0)
					sharedAccount.withdraw(1.0);
//					count--;
									
//				try {
//					sharedAccount.wait();
//				}catch(InterruptedException e) {
//					System.out.println(e.getMessage());
//				}
			}
	
		}
		
		
	}
}