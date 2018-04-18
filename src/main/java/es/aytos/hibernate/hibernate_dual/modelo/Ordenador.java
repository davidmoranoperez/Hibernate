package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_ORD")
public class Ordenador implements Serializable{

		@Id
		@GeneratedValue
		@Column(name = "ORD_ID")
		private int idOrdenador;

		@Column(name = "ORD_MOD", nullable = false, length = 50)
		private String modelo;

		@Column(name = "ORD_RAM", nullable = false)
		private Integer ram;

		@Column(name = "ORD_PRO", nullable = false, length = 250)
		private String procesador;
		
		@Column(name = "ORD_FAB", nullable=false)
		private Date fabricacion;

		@Column(name = "ORD_TIP", nullable = false)
		@Enumerated(EnumType.STRING)
		private TipoOrdenador tipo;
		
		@Column(name = "ORD_TAM")
		@Enumerated(EnumType.STRING)
		private TamañoOrdenador tamaño;
		
		public Ordenador() {
		}

		public int getIdOrdenador() {
			return idOrdenador;
		}

		public void setIdOrdenador(int idOrdenador) {
			this.idOrdenador = idOrdenador;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public Integer getRam() {
			return ram;
		}

		public void setRam(Integer ram) {
			this.ram = ram;
		}

		public String getProcesador() {
			return procesador;
		}

		public void setProcesador(String procesador) {
			this.procesador = procesador;
		}

		public Date getFabricacion() {
			return fabricacion;
		}

		public void setFabricacion(Date fabricacion) {
			this.fabricacion = fabricacion;
		}

		public TipoOrdenador getTipo() {
			return tipo;
		}

		public void setTipo(TipoOrdenador tipo) {
			this.tipo = tipo;
		}

		public TamañoOrdenador getTamaño() {
			return tamaño;
		}

		public void setTamaño(TamañoOrdenador tamaño) {
			this.tamaño = tamaño;
		}
		
}
