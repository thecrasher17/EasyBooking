package es.deusto.ingenieria.jdo.easybooking;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Usuario {
	
	@PrimaryKey
	private String dni = null;
	private String Aeropuerto_ident = null;
	private String nombre = null;
	private String apellido = null;
	private String email = null;
	private String sistema_auto = null;
	
	@Element(column="FK_USUARIO")
	ArrayList <Reserva> reservas= new ArrayList<Reserva>();
	
	
	public Usuario (String Aeropuerto_ident, String dni, String nombre,String apellido, String email, String sistema_auto, ArrayList <Reserva> reservas  )
	{
		this.Aeropuerto_ident=Aeropuerto_ident;
		this.dni =dni;
		this.nombre=nombre;
		this.apellido = apellido;
		this.email=email;
		this.sistema_auto=sistema_auto;
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
	
	
}
