package workshop10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImpl extends UnicastRemoteObject implements CarInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CarImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String carRegister(Car car) throws RemoteException {
		// TODO Auto-generated method stub
		return " " + car.hashCode();
	}

}
