package es.aytos.hibernate.hibernate_dual.modelo;

public enum Genero {

	MASCULINO("M"), FEMENINO("F");

	private final String valor;

	Genero(String valor) {
		this.valor=valor;
	}

	public static Genero porCodigo(String valor) {
		if (valor == "M" || valor == "m") {
			return MASCULINO;
		}
		if (valor == "F" || valor == "f") {
			return FEMENINO;
		}
		throw new UnsupportedOperationException("El codigo " + valor + " no está soportado");
	}

	public String getValor() {
		return valor;
	}
}
