package Facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

import LN.Vuelo;
import LN.Usuario;

public interface IServer extends Remote
{
	public boolean registrar (Usuario usuario, String contrasena) throws RemoteException;
	public Usuario inicioSesion (String usuario, String contrasena, String sistema_auto) throws RemoteException;
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException;
	public int pagar(String user,String dato,double precio, String sistema_pago) throws RemoteException;
	public void reservar (String codVuelo, String email, int cod_pago)throws RemoteException;
}