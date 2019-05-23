package DAO;

import java.util.ArrayList;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import LN.Aerolinea;
import LN.Aeropuerto;
import LN.Reserva;
import LN.Usuario;
import LN.Vuelo;

public class DAO {
	
	
	private static PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private static PersistenceManager persistentManager =  persistentManagerFactory.getPersistenceManager();

	
	public static void GuardarObjeto (Object object)
	{
		
		
		Transaction transaction = null;
		try {

			//persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			//persistentManager = persistentManagerFactory.getPersistenceManager();		
			transaction = DAO.persistentManager.currentTransaction();				

			transaction.begin();

			persistentManager.makePersistent(object);

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive() && transaction != null) 
			{
				transaction.rollback();
			}   
			//persistentManager.close();
		}	
	}
	
	public static ArrayList<Aeropuerto> LeerAeropuerto ()
	{
	
		PersistenceManagerFactory persistentManagerFactory =  JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = null;
		Transaction transaction = null;
		
		ArrayList<Aeropuerto> aeropuertos= new ArrayList<Aeropuerto> ();
		
		try {

				
			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				

			transaction.begin();

			Extent<Aeropuerto> extent = (Extent) persistentManager.getExtent(Aeropuerto.class, true);
			
			for (Aeropuerto aeropuerto : extent)
			{
				aeropuertos.add (aeropuerto);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		
		
		return aeropuertos;
	}

	
	
	public static ArrayList<Aerolinea> LeerAerolinea ()
	{
	
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = null;
		Transaction transaction = null;
		
		ArrayList<Aerolinea> aerolineas= new ArrayList<Aerolinea> ();
		
		try {

			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				

			transaction.begin();

			Extent<Aerolinea> extent = (Extent) persistentManager.getExtent(Aerolinea.class, true);
			
			for (Aerolinea aerolinea : extent)
			{
				aerolineas.add (aerolinea);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		
		
		return aerolineas;
	}

	public static ArrayList<Reserva> LeerReserva ()
	{
	
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = null;
		Transaction transaction = null;
		
		ArrayList<Reserva> reservas= new ArrayList<Reserva> ();
		
		try {

			
			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				

			transaction.begin();

			Extent<Reserva> extent = (Extent) persistentManager.getExtent(Reserva.class, true);
			
			for (Reserva reserva : extent)
			{
				reservas.add (reserva);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		
		
		return reservas;
	}
	
	public static ArrayList<Usuario> LeerUsuario ()
	{
	
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = null;
		Transaction transaction = null;
		
		ArrayList<Usuario> usuarios= new ArrayList<Usuario> ();
		
		try {

			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				

			transaction.begin();

			Extent<Usuario> extent = (Extent) persistentManager.getExtent(Usuario.class, true);
			
			for (Usuario usuario : extent)
			{
				usuarios.add (usuario);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		
		
		return usuarios;
	}

	public static ArrayList<Vuelo> LeerVuelo ()
	{
	
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = null;
		Transaction transaction = null;
		
		ArrayList<Vuelo> vuelos= new ArrayList<Vuelo> ();
		
		try {

			
			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				

			transaction.begin();

			Extent<Vuelo> extent = (Extent) persistentManager.getExtent(Vuelo.class, true);
			
			for (Vuelo vuelo : extent)
			{
				vuelos.add (vuelo);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		
		
		return vuelos;
	}
	
	public static void cerrarBD()
	{
		if (persistentManager != null && !persistentManager.isClosed()) 
		{
			persistentManager.close();
		}
	}

}

