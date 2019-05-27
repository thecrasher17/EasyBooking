package AppService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DAO.DAO;
import Gateway.Gateway;
import LN.Reserva;
import LN.Usuario;
import LN.Vuelo;

public class AS_Pago 
{

	private Gateway gateway;
	private int COD;

	public AS_Pago() throws RemoteException 
	{
		super();
		this.gateway = new Gateway();
	}
	
	public int pagar(String user,String dato,double precio, String sistema_pago) 
	{
		System.out.println("  * Realizando pago de '" + precio + "'€'");
		return this.gateway.pagar(user, dato, precio, sistema_pago);	
	}
	
	public void reservar(String codVuelo, String email, int cod_pago) 
	{
		Reserva reserva = new Reserva(email, cod_pago);
		DAO.GuardarObjeto(reserva);
		
		ArrayList <Vuelo> vuelos = new ArrayList <Vuelo> ();
		vuelos=DAO.LeerVuelo();
		
		for (Vuelo vuelo1 : vuelos )
		{
			if(vuelo1.getNumero().equals(codVuelo))
			{
				DAO.GuardarObjeto(vuelo1);
				//si esta ya guardado no lo guara
				
				//DAO guardar reserva en vuelo1 o como?
			}
		}
	}
}