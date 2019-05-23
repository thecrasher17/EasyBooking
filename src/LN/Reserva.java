package LN;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	
	@PrimaryKey 
	private int Reservacodigo = 0;
	private String pasajeroemail = null;
	private int codigopago;
	
	
	public Reserva (int Reservacodigo,String pasajerodni, int codigopago ) 
	{
		this.Reservacodigo=Reservacodigo;
		this.pasajeroemail=pasajerodni;
		this.codigopago=codigopago;
		
		
		
		
	}


	public int getReservacodigo() {
		return Reservacodigo;
	}


	public void setReservacodigo(int reservacodigo) {
		Reservacodigo = reservacodigo;
	}


	public String getPasajeroemail() {
		return pasajeroemail;
	}


	public void setPasajeroemail(String pasajeroemail) {
		this.pasajeroemail = pasajeroemail;
	}


	public int getCodigopago() {
		return codigopago;
	}


	public void setCodigopago(int codigopago) {
		this.codigopago = codigopago;
	}

}
