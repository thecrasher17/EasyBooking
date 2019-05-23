package Gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;

import LN.Vuelo;

public class Gateway implements IGateway
{
	private String IP;
	private int PORT;
	private String SERVER;
	private static String DELIMITER = "#";
	private Registry registry;
	
	/**public Gateway(String IP, String PORT, String SERVER)
	{
		this.IP = IP;
		this.PORT = PORT;
		this.SERVER = SERVER;
	}**/
	
	@Override
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada)
			throws RemoteException 
	{
		//Meter IP,PORT,SERVER
		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}
		try 
		{
			registry = LocateRegistry.getRegistry(Integer.valueOf(PORT));
			String name = "//" + IP + ":" + PORT + "/" + SERVER;
			IAerolinea stubServer = (IAerolinea) java.rmi.Naming.lookup(name);
			stubServer.getVuelos(aer_origen, aer_destino, fecha_salida, fecha_llegada);
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean acceder(String usuario, String contrasena, String sistema_auto) throws RemoteException 
	{
		boolean accedo=false;
		
		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}
		try 
		{	
			if (sistema_auto=="GOOGLE")
			{
				//*optimizar*MEJOR METER COMO ATRIBUTO
				//Meter IP,PORT,SERVER
				String nameGoogle = "//" + IP + ":" + PORT + "/" + SERVER;
				IAutentificacion stubGoogle = (IAutentificacion) java.rmi.Naming.lookup(nameGoogle);
				registry = LocateRegistry.getRegistry(Integer.valueOf(PORT));
				accedo = stubGoogle.acceder(usuario, contrasena);
			}
			else 
			{
				registry = LocateRegistry.getRegistry(Integer.valueOf(PORT));
				String name = "//" + IP + ":" + PORT + "/" + SERVER;
				IAutentificacion stubFacebook = (IAutentificacion) java.rmi.Naming.lookup(name);
				accedo = stubFacebook.acceder(usuario, contrasena);
			}
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
		return accedo;
	}

	@Override
	public int pagar(String user, String password, double precio, String sistema_pago) 
	{
		//Meter IP,PORT,SERVER
		String message;
		String data=null;
		int codigo=0;
		
		if (sistema_pago=="PAYPAL")
		{
			if (System.getSecurityManager() == null) 
			{
				System.setSecurityManager(new SecurityManager());
			}
			try 
			{
				registry = LocateRegistry.getRegistry(Integer.valueOf(PORT));
				String name = "//" + IP + ":" + PORT + "/" + SERVER;
				IPago stubServer = (IPago) java.rmi.Naming.lookup(name);
				codigo = stubServer.pagar(user, password, precio);
				return codigo;
			} 
			catch (Exception e) 
			{
				System.err.println("- Exception running the client: " + e.getMessage());
				e.printStackTrace();
			}
		}
		else 
		{
			message = user+DELIMITER+password+DELIMITER+precio;
			try (Socket tcpSocket = new Socket(IP, PORT);
			DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream()))
			{
				out.writeUTF(message);
				System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
				data = in.readUTF();			
				System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			} 
			catch (UnknownHostException e) 
			{
				System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
			} 
			catch (EOFException e) 
			{
				System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
			} 
			catch (IOException e) 
			{
				System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
			}
			if (!data.isEmpty()) 
			codigo = Integer.parseInt(data);
		}
		return codigo;
	}
}
