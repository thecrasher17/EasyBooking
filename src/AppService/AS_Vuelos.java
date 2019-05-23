package AppService;

import java.rmi.RemoteException;
import java.util.LinkedList;

import Gateway.Gateway;
import LN.Vuelo;

public class AS_Vuelos 
{
	private Gateway gateway;

	public AS_Vuelos() throws RemoteException 
	{
		super();
		this.gateway = new Gateway();
	}
	
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException
	{
		System.out.println("  * Getting vuelos from '" + aer_origen + "' to '" + aer_destino + "'");
		return this.gateway.getVuelos(aer_origen, aer_destino, fecha_salida, fecha_llegada);
	}
	
}
