package Gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAutentificacion extends Remote 
{	
	public boolean acceder (String usuario, String contrasena) throws RemoteException;
}