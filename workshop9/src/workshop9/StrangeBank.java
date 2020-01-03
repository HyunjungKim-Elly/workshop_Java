package workshop9;

public class StrangeBank {	

	public static void main(String []args) {
		
		double[] balance = {1.0, 2.0, 3.0, 3.0};
		                          
		String[] currency = {"Dollar(s)", "Euro(s)", "Euro(s)", "Pound(s)"};
		SharedAccount sharedAccount = new SharedAccount(0, "");
		Thread transaction = new Thread(new DepositThread(sharedAccount, balance, currency));
		Thread withdraw = new Thread(new WithdrawThread(sharedAccount, balance));
		
		transaction.start();
		withdraw.start();
		
		try {
			transaction.join();
			withdraw.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
}



