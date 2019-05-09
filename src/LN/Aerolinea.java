package es.deusto.ingenieria.jdo.easybooking;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Aerolinea{
	
	@PrimaryKey
	private String codigo=null;
	private String nombre = null;
	@Element(column="FK_VUELOSLLEG")
	ArrayList <Vuelo> vueloslleg= new ArrayList<Vuelo>();
	@Element(column="FK_VUELOSSALI")
	ArrayList <Vuelo> vuelossal= new ArrayList<Vuelo>();
	
	 public Aerolinea (String codigo,String nombre, ArrayList <Vuelo> vueloslleg, ArrayList <Vuelo> vuelossal)
	    {
	        
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.vueloslleg=vueloslleg;
	        this.vuelossal=vuelossal;
	    }


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
