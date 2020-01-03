package workshop10;

import java.rmi.Naming;

public class CarClient {
	
	public static void main(String[] args) throws java.rmi.RemoteException{
		
		Car[] cars = new Car[3];
		cars[0] = new Car("Toyata Corolla", "White", 1000);
		cars[1] = new Car("Honda Civic", "Black", 2000);
		cars[2] = new Car("Volvo S70", "Blue", 3000);
		
		for(int i = 0; i < 3; i++) {
			System.out.println("\n---Car Register Request---\n\t" + cars[i].toString());
			
			try {
				
				CarInterface stub = (CarInterface) Naming.lookup("rmi://localhost:8880/CarServer");
				cars[i].setRegistration(stub.carRegister(cars[i]));
		
				System.out.println("\n---Register Response---\n\t" + cars[i].toString() + "\n");
				
			}catch(Throwable e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("\n\n###Register Request Clear###");
	}

}
