package es.aytos.hibernate.hibernate_dual.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_CLI")
public class Cliente extends Usuario{

	@Column(name = "CLI_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "CLI_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "CLI_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "CLI_EDA", nullable = false)
	private Integer edad;
	
	@Column(name = "CLI_ECV", nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	public Cliente() {
	}

//	public int getIdPersona() {
//		return idPersona;
//	}
//
//	public void setIdPersona(int idPersona) {
//		this.idPersona = idPersona;
//	}

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
	
	
}