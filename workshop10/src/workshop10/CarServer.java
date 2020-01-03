package workshop10;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class CarServer {
	
	public CarServer() {
		try {
		
			CarInterface stub = new CarImpl();
			LocateRegistry.createRegistry(8880);
			Naming.rebind("rmi://localhost:8880/CarServer", stub);
	
			System.out.println("CarService bound in registry");			
			
		}catch(Throwable e) {
			System.out.println("Problem: " + e.getMessage());
			System.exit(1);
		}
		
	}

	public static void main(String[] args) {
		new CarServer();
		System.out.println("CarService is running");
	}

}
