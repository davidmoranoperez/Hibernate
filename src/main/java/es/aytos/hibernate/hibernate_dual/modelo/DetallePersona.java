package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="A_DET")
public class DetallePersona {

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalles")
    private Persona persona;
	
	@Id
    @GeneratedValue
    private Integer id;
	
	@Column(name = "hijos")
	private boolean hijos;
	
	@Column(name = "mascotas")
	private boolean mascotas;
	
	@Column(name = "deportista")
	private boolean deportista;
	
	public DetallePersona(Boolean hijos, Boolean mascotas, Boolean deportista) {
        this.hijos = hijos;
        this.mascotas = mascotas;
        this.deportista = deportista;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isHijos() {
		return hijos;
	}

	public void setHijos(boolean hijos) {
		this.hijos = hijos;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}

	public boolean isDeportista() {
		return deportista;
	}

	public void setDeportista(boolean deportista) {
		this.deportista = deportista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
