package AppService;

import java.rmi.RemoteException;

import Gateway.Gateway;

public class AS_Pago 
{

	private Gateway gateway;

	public AS_Pago() throws RemoteException 
	{
		super();
		this.gateway = new Gateway();
	}
	
	public int pagar(String user,String password,double precio, String sistema_pago) 
	{
		System.out.println("  * Realizando pago de '" + precio + "'€'");
		return this.gateway.pagar(user, password, precio, sistema_pago);
	}
	
	
}
