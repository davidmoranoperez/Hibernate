package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Date;
import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Ordenador;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.TamañoOrdenador;
import es.aytos.hibernate.hibernate_dual.modelo.TipoOrdenador;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioOrdenador;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		//crearPersona();
		//crearOrdenador();
		//modificarPersona(); 
		//eliminarPersonaCodigo(1);
		//eliminarOrdenadoCodigo(1);
		//modificarNombreOrdenador(1, "Gigabyte");
		consultar("%avi%", "%orano Pére%", "15456786G",EstadoCivil.SOLTERO);
	}
	
	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("David");
		persona.setApellidos("Morano Pérez");
		persona.setDni("15456786G");
		persona.setEdad(26);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		
		return RepositorioPersona.crearPersona(persona);
	}
	
	private static Integer crearOrdenador() {
		final Ordenador ordenador = new Ordenador();
		ordenador.setFabricacion(new Date());
		ordenador.setModelo("Intel");
		ordenador.setProcesador("QuadCore2,5Ghz");
		ordenador.setRam(2048);
		ordenador.setTamaño(TamañoOrdenador.ATX);
		ordenador.setTipo(TipoOrdenador.SOBREMESA);
		
		return RepositorioOrdenador.crearOrdenador(ordenador);
	}
	
//	private static void modificarPersona() {
//		final Persona persona = new Persona();
//		persona.setNombre("Jesus");
//		persona.setApellidos("Delgado Pérez");
//		persona.setDni("0000786G");
//		persona.setEdad(16);
//		persona.setEstadoCivil(EstadoCivil.CASADO);
//		
//		RepositorioPersona.modificarPersona(persona);
//	}
	
	private static void modificarNombrePersona(Integer idPersona, String nombre) {
		RepositorioPersona.modificarNombrePersona(idPersona, nombre);
	}
	
//	private static void eliminarPersona() {
//		final Persona persona = new Persona();
//		persona.setIdPersona(1);
//		
//		RepositorioPersona.eliminarPersona(persona);
//	}
	
	private static void eliminarPersonaCodigo(Integer idPersona) {
		RepositorioPersona.eliminarPersonaCodigo(idPersona);
	}
	
	private static void modificarNombreOrdenador(Integer idOrdenador, String modelo) {
		RepositorioOrdenador.modificarNombreOrdenador(idOrdenador, modelo);
	}
	
	private static void eliminarOrdenadorCodigo(Integer idOrdenador) {
		RepositorioOrdenador.eliminarOrdenadorCodigo(idOrdenador);
	}
	
	public static void consultarPersona(final Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarPersona(idPersona);
		System.out.println(persona.getNombre());
	}
	
	public static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		System.out.println(personas.size());
	}
}
