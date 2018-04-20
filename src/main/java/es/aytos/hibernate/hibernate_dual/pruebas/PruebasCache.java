package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.Idioma;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioIdioma;

public class PruebasCache {

	public static void main(String[] args) {
		consultarIdioma();
		consultarIdioma();
	}
	
	public static void consultarIdioma() {
		final List<Idioma> idiomas = RepositorioIdioma.consultarIdiomas();
		idiomas.stream().map(Idioma::getIdioma).forEach(System.out::println);
	}
}
