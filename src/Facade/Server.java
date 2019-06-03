package Facade;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


import AppService.AS_Acceso;
import AppService.AS_Pago;
import AppService.AS_Vuelos;
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
	
	
	
	public static void main(String[] args) {
//		if (args.length != 3) {
//			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
//			System.exit(0);
//		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		
		//String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		String name = "//" + "127.0.0.1" + ":" + "1099" + "/" + "EasyBooking";

		try {		
			IServer objServer = new Server();
			Registry registry= LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			//Naming.rebind(name, objServer);
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}


	
	public boolean registrar (Usuario usuario, String contrasena) throws RemoteException
	{
		AS_Acceso appAcceso = new AS_Acceso();
		appAcceso.registrar(usuario, contrasena);
		return false;
	}
	
	public Usuario inicioSesion (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		AS_Acceso appAcceso = new AS_Acceso ();
		Usuario user= appAcceso.InicioSesion(usuario, contrasena, sistema_auto);
		return user;
	}
	
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException
	{
		LinkedList<Vuelo> vuelos=null;
		AS_Vuelos appVuelo = new AS_Vuelos();
		vuelos = appVuelo.getVuelos(aer_origen, aer_destino, fecha_salida, fecha_llegada);
		return vuelos;
	}

	@Override
	public int pagar(String user, String dato, double precio,String sistema_pago) throws RemoteException 
	{
		AS_Pago appPago = new AS_Pago();
		return appPago.pagar(user, dato, precio, sistema_pago);
	}

	@Override
	public void reservar(String codVuelo, String email, int cod_pago) throws RemoteException 
	{
		AS_Pago appPago = new AS_Pago();
		appPago.reservar(codVuelo, email, cod_pago);
		
	}
}