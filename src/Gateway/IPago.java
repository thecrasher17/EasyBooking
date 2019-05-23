package Gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPago extends Remote 
{	
	public int pagar (String usuario, String contrasena, double precio) throws RemoteException;
}