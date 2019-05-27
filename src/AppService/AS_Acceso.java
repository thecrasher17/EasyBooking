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
	
	public boolean registrar (Usuario usuario, String contrasena)
	{
		ArrayList <Usuario> usuarios = new ArrayList <Usuario> ();
		usuarios=DAO.LeerUsuario();
		try 
		{
			if (gateway.acceder(usuario.getEmail(), contrasena, usuario.getPago()))
			{
				for (Usuario usuario1 : usuarios )
				{
					if(usuario1.getEmail().equals(usuario.getEmail()))
					{
						System.out.println("El usuario está ya registrado");
						return false;
					}
				}
				DAO.GuardarObjeto(usuario);
				return true;
			}
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Usuario InicioSesion (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		System.out.println("  * Accediendo a tu cuenta '" + usuario + "'");
		gateway.acceder(usuario, contrasena, sistema_auto);
		
		ArrayList <Usuario> usuarios = new ArrayList <Usuario> ();
		usuarios=DAO.LeerUsuario();
		Usuario user=null;
		
		if (gateway.acceder(usuario, contrasena, sistema_auto))
		{
			for (Usuario usuario1 : usuarios )
			{
				if(usuario1.getEmail().equals(usuario))
				{
					user=usuario1;
				}
			}
		}
		return user;
		
	}
}
