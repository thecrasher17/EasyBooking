package Facade;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import DAO.DAO;
import LN.Aerolinea;
import LN.Aeropuerto;
import LN.Reserva;
import LN.Usuario;
import LN.Vuelo;

public class Main {

	
	public static void main(String[] args)
	{				
		
		//Reservas
		
	    Reserva reserva1= new Reserva(1, "72518965B");
	    Reserva reserva2= new Reserva(2, "72518965B");
	    ArrayList <Reserva> reservasIBE123 = new ArrayList <Reserva> ();
	    reservasIBE123.add(reserva1);
	    ArrayList <Reserva> reservasIBE321 = new ArrayList <Reserva> ();
	    reservasIBE321.add(reserva2);
	    
	    
	    //Usuario
	    ArrayList <Reserva> reservas72518965 = new ArrayList <Reserva> ();
	    reservas72518965.add(reserva1);
	    reservas72518965.add(reserva2);
	    Usuario usuario1= new Usuario ("72518965B", "real123", "BCN", "MIKEL", "MIGUELIZ", "GOÑI",  "txurfero@gmail.com", "GOOGLE", "VISA", reservas72518965 );
	    
	    //Vuelo
	    Vuelo vuelo1= new Vuelo ("IBE-123", "MADRID", "BARCELONA", reservasIBE123);
	    Vuelo vuelo2=new Vuelo ("IBE-321", "BARCELONA", "MADRID", reservasIBE321);
	    
	    
	    ArrayList <Vuelo> vuelosllegadaIBEBCN = new ArrayList <Vuelo> ();
	    vuelosllegadaIBEBCN.add(vuelo1);
	    ArrayList <Vuelo> vuelossalidaIBEBCN = new ArrayList <Vuelo>();
	    vuelossalidaIBEBCN.add(vuelo2);
	    
	    //Aerolinea
	    
	    Aerolinea aerolinea = new Aerolinea ("IBE", "IBERIA", vuelosllegadaIBEBCN, vuelossalidaIBEBCN);
	    ArrayList <Aerolinea> AerolineasBCN = new ArrayList <Aerolinea> ();
	    AerolineasBCN.add(aerolinea);
		    
	    //Aeropuerto
	    
	    Aeropuerto aeropuerto = new Aeropuerto ("BCN","EL_PRAT","BARCELONA", AerolineasBCN );
	    
	    DAO.GuardarObjeto(reserva1);
	    DAO.GuardarObjeto(reserva2);
	    DAO.GuardarObjeto(usuario1);
	    DAO.GuardarObjeto(vuelo1);
	    DAO.GuardarObjeto(vuelo2);
	    DAO.GuardarObjeto(aerolinea);
	    DAO.GuardarObjeto(aeropuerto);
	    DAO.cerrarBD();
	    

	}

}
