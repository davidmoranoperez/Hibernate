package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

//@MappedSuperclass
@Entity
@Table(name="A_USU")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USU_ID")
	private int idUsuario;
	
	@Column(name="USU_LOG", nullable=false, unique=true)
	private String login;
	
	@Column(name="USU_PASS", nullable=false)
	private String password;
	
	@Column(name="USU_FEC", nullable=false)
	private Date alta;
	
	public Usuario() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}
	
	
}
