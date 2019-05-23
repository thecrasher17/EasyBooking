package LN;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Usuario {
	
	@PrimaryKey
	private String dni = null;
	private String contrasena = null;
	private String Aeropuerto_ident = null;
	private String nombre = null;
	private String apellido = null;
	private String apellido2 = null;
	private String email = null;
	private String sistema_auto = null;
	private String pago = null;
	
	@Element(column="FK_USUARIO")
	ArrayList <Reserva> reservas= new ArrayList<Reserva>();
	
	
	public Usuario ( String dni, String contrasena, String Aeropuerto_ident, String nombre,String apellido, String apellido2, String email, String sistema_auto, String pago, ArrayList <Reserva> reservas  )
	{
		
		this.dni =dni;
		this.contrasena = contrasena;
		this.Aeropuerto_ident=Aeropuerto_ident;
		this.nombre=nombre;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.email=email;
		this.sistema_auto=sistema_auto;
		this.pago=pago;
		this.reservas=reservas;
	}


	public String getAeropuerto_ident() {
		return Aeropuerto_ident;
	}


	public void setAeropuerto_ident(String aeropuerto_ident) {
		Aeropuerto_ident = aeropuerto_ident;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSistema_auto() {
		return sistema_auto;
	}


	public void setSistema_auto(String sistema_auto) {
		this.sistema_auto = sistema_auto;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getPago() {
		return pago;
	}


	public void setPago(String pago) {
		this.pago = pago;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
