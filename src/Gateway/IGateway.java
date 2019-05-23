package Gateway;

import java.rmi.RemoteException;
import java.util.LinkedList;

import LN.Vuelo;

public interface IGateway 
{
	public int pagar(String user,String password,double precio, String sistema_pago);
	
	public LinkedList<Vuelo> getVuelos (String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException;
	
	public boolean acceder (String usuario, String contrasena, String sistema_auto) throws RemoteException;
}