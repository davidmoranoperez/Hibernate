package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "A_TEL")
public class Telefono {

	@ManyToOne
	private Persona persona;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
	@SequenceGenerator(name = "sequence-generator", sequenceName = "Numeros_de_teléfono", initialValue = 1, allocationSize = 2)
	private Integer id;

	@Column(name = "numero")
	private String numero;

	public Telefono() {
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String number) {
		this.numero = number;
	}

}
