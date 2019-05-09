package es.deusto.ingenieria.jdo.easybooking;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Aeropuerto {
	@PrimaryKey
	private String identificador = null;
	private String nombre = null;
	private String ciudad = null;
	@Element(column="FK_AEROLINEAS")
	ArrayList <Aerolinea> Aerolineas= new ArrayList<Aerolinea>();
	
	public Aeropuerto (String identificador, String nombre, String ciudad, ArrayList<Aerolinea> Aerolineas)

	{
		this.identificador = identificador;
		this.nombre=nombre;
		this.ciudad=ciudad;
		this.Aerolineas=Aerolineas;
		
		
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public ArrayList<Aerolinea> getAerolineas() {
		return Aerolineas;
	}

	public void setAerolineas(ArrayList<Aerolinea> aerolineas) {
		Aerolineas = aerolineas;
	}
}
