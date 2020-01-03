package sw;

public class Main {

	public static void main(String[] args) {
		double[] balance = { 1.0, 2.0, 3.0 };
		String[] currency = { "CAD", "EUR", "GBP" };

		SharedAccount sharedAcct = new SharedAccount(0, "");

		Thread deposit = new Thread(new Deposit(sharedAcct, balance, currency));
		Thread withdraw = new Thread(new Withdraw(sharedAcct));

		deposit.start();
		withdraw.start();

		try {
			deposit.join();
			withdraw.join();
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		System.out.println("StrangeBank is ended");
	}

}