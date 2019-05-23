package LN;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Vuelo 
{
	
	@PrimaryKey
	private String numero = null;
	private String Aero_orig = null;
	private String Aero_dest = null;
	@Element (column="FK_VUELO")
	ArrayList <Reserva> reservas= new ArrayList<Reserva>();
	//@NotPersistent 
	//private String fechasalida = null;
	
	public Vuelo (String numero, String Aero_orig, String Aero_dest, ArrayList <Reserva> reservas)//, String fechasalida)
	{
		this.numero = numero;
		this.Aero_orig = Aero_orig;
		this.Aero_dest = Aero_dest;
		this.reservas = reservas;
		//this.fechasalida = fechasalida;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAero_orig() {
		return Aero_orig;
	}

	public void setAero_orig(String aero_orig) {
		Aero_orig = aero_orig;
	}

	public String getAero_dest() {
		return Aero_dest;
	}

	public void setAero_dest(String aero_dest) {
		Aero_dest = aero_dest;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
