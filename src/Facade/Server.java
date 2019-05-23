package Facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import AppService.AS_Acceso;
import AppService.AS_Pago;
import Facade.IServer;
import LN.Vuelo;
import LN.Usuario;

public class Server extends UnicastRemoteObject implements IServer 
{
	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	
	public boolean registrar (Usuario usuario) throws RemoteException
	{
		
		return false;
	}
	
	public boolean acceder (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		AS_Acceso appAcceso = new AS_Acceso ();
		appAcceso.acceder(usuario, contrasena, sistema_auto);
		return false;
	}
	
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException
	{
		LinkedList<Vuelo> vuelos=null;
		//AS_Vuelos
		return vuelos;
	}
	
	public int pagar(String user,String password,double precio, String sistema_pago)
	{
		int codigo=0;
		//AS_Pago appPago = new AS_Pago ();
		//appPago.pagar(user, password, precio, sistema_pago);
		return codigo;
		
		
	}
}