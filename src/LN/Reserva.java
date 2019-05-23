package LN;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	
	@PrimaryKey 
	private int Reservacodigo = 0;
	private String pasajerodni = null;
	
	
	public Reserva (int Reservacodigo,String pasajerodni ) 
	{
		this.Reservacodigo=Reservacodigo;
		this.pasajerodni=pasajerodni;
		
		
		
		
	}


	public int getReservacodigo() {
		return Reservacodigo;
	}


	public void setReservacodigo(int reservacodigo) {
		Reservacodigo = reservacodigo;
	}


	public String getPasajerodni() {
		return pasajerodni;
	}


	public void setPasajerodni(String pasajerodni) {
		this.pasajerodni = pasajerodni;
	}

}
