package workshop10;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote{
	public String carRegister(Car car) throws RemoteException;
}
