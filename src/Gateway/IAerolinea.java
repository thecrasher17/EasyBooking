package Gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

import LN.Vuelo;
public interface IAerolinea extends Remote 
{	
	public LinkedList<Vuelo> getVuelos (String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException;
}