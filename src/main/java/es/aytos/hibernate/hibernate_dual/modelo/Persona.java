package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import es.aytos.hibernate.hibernate_dual.conversor.ConversorGenero;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Direccion> direcciones = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Idioma> idiomas = new ArrayList<>();

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("numero")
	private List<Telefono> telefonos = new ArrayList<>();

	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private DetallePersona detalles;

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_GEN", nullable = false, length = 1)
	@Convert( converter = ConversorGenero.class )
	private Genero genero;

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;


	public Persona() {
	}

	// public int getIdPersona() {
	// return idPersona;
	// }
	//
	// public void setIdPersona(int idPersona) {
	// this.idPersona = idPersona;
	// }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Direccion> getDireccion() {
		return direcciones;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direcciones = direccion;
	}

	public void añadirDireccion(Direccion direccion) {
		direcciones.add(direccion);
		direccion.getPersonas().add(this);
	}

	public void removeAddress(Direccion direccion) {
		direcciones.remove(direccion);
		direccion.getPersonas().add(this);
	}

	public void añadirTelefono(Telefono telefono) {
		telefonos.add(telefono);
		telefono.setPersona(this);
	}

	public void removePhone(Telefono telefono) {
		telefonos.remove(telefono);
		telefono.setPersona(this);
	}

	public DetallePersona getDetalles() {
		return detalles;
	}

	public void setDetalles(DetallePersona detalles) {
		this.detalles = detalles;
	}

	public void añadirDetalles(DetallePersona detalle) {
		detalle.setPersona(this);
	}

	public void removeDetails() {
		if (detalles != null) {
			detalles.setPersona(null);
			this.detalles = null;
		}
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}
