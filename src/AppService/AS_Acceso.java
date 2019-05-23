package AppService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Gateway.Gateway;
import LN.Usuario;
import DAO.DAO;

public class AS_Acceso
{
	private Gateway	gateway;

	public AS_Acceso() throws RemoteException 
	{
		super();
		this.gateway = new Gateway();
	}
	
	public boolean registrar (Usuario usuario) throws RemoteException
	{
		ArrayList <Usuario> usuarios = new ArrayList <Usuario> ();
		usuarios=DAO.LeerUsuario();
		
		for (Usuario usuario1 : usuarios )
		{
			if(usuario1.getDni().equals(usuario.getDni()))
			{
				System.out.println("El usuario está ya registrado");
				return false;
			}else
			{
				DAO.GuardarObjeto(usuario);
			}
		}
		DAO.GuardarObjeto(usuario);
		return true;
	}
	
	public Usuario acceder (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		System.out.println("  * Accediendo a tu cuenta '" + usuario + "'");
		return gateway.acceder(usuario, contrasena, sistema_auto);
	}
}
