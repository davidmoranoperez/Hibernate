package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Date;
import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Genero;
import es.aytos.hibernate.hibernate_dual.modelo.Ordenador;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.Direccion;
import es.aytos.hibernate.hibernate_dual.modelo.TamañoOrdenador;
import es.aytos.hibernate.hibernate_dual.modelo.Telefono;
import es.aytos.hibernate.hibernate_dual.modelo.TipoOrdenador;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioCliente;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioOrdenador;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioUsuario;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("12345678d", "usuario7");
//		crearCliente("02345675G", "usuario1");
//		crearPersona("52345675G", "user");
//		crearCliente("82345675G", "user1");
		// crearOrdenador();
		// modificarPersona();
		//modificarNombrePersona(3,"Jesus");
		//eliminarUsuarioCodigo(8);
		// eliminarOrdenadoCodigo(1);
		// modificarNombreOrdenador(1, "Gigabyte");
		//consultar("David", "Morano Pérez", "12345678d",EstadoCivil.SOLTERO);
		//devolverTelefonos();
		//consultarPersona(1);
	}

	private static void crearPersona(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("David");
		persona.setApellidos("Morano Pérez");
		persona.setDni(dni);
		persona.setEdad(26);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("usuario");
		persona.setGenero(Genero.MASCULINO);
		
		Direccion address1 = crearDireccion();
		persona.añadirDireccion( address1 );
		
		Telefono telefono = crearTelefono("955901033");
		persona.añadirTelefono(telefono);
		
		Telefono telefono2 = crearTelefono("617094453");
		persona.añadirTelefono(telefono2);
		
		Telefono telefono3 = crearTelefono("666664453");
		persona.añadirTelefono(telefono3);
		
		persona.getTelefonos().stream().forEach(t->System.out.println(telefono.getNumero()));
		
		RepositorioPersona.crearPersona(persona);
		
		
	}
	
	private static Persona crearPersona2(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("David");
		persona.setApellidos("Morano Pérez");
		persona.setDni(dni);
		persona.setEdad(26);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("usuario");

		return persona;
	}
	
	private static void devolverTelefonos() {
		Persona persona = new Persona();
		System.out.println(persona.getTelefonos());
	}
	
	private static Telefono crearTelefono(String numero) {
		final Telefono telefono = new Telefono();
		telefono.setNumero(numero);
		
		return telefono;
	}
	
	private static Direccion crearDireccion() {
		final Direccion direccion = new Direccion();
		direccion.setProvincia("Sevilla");
		direccion.setBloque(2);
		direccion.setCiudad("Ecija");
		direccion.setCalle("Cordoba");
		direccion.setNumero(3);
		direccion.setPlanta(4);
		direccion.setPuerta(3);
		
		return direccion;
	}
	
	private static Direccion crearDireccion2() {
		final Direccion direccion = new Direccion();
		direccion.setProvincia("Málaga");
		direccion.setBloque(2);
		direccion.setCalle("Cordoba");
		direccion.setNumero(5);
		direccion.setPlanta(8);
		direccion.setPuerta(1);
		
		return direccion;
	}

	private static Integer crearCliente(String dni, String login) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Jesus");
		cliente.setApellidos("Delgado Marin");
		cliente.setDni(dni);
		cliente.setEdad(27);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("usuario");

		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Jesus");
		persona.setApellidos("Delgado Pérez"); 
		persona.setDni("0000786G");
		persona.setEdad(16);
		persona.setEstadoCivil(EstadoCivil.CASADO);

		RepositorioPersona.modificarPersona(persona);
	}

	private static void modificarNombrePersona(Integer idPersona, String nombre) {
		RepositorioPersona.modificarNombrePersona(idPersona, nombre);
	}

	private static void eliminarOrdenadorCodigo(Integer idOrdenador) {
		RepositorioOrdenador.eliminarOrdenadorCodigo(idOrdenador);
	}
	
	private static void eliminarPersona() {
		final Persona persona = new Persona();
		persona.setIdUsuario(1);

		RepositorioPersona.eliminarPersona(persona);
	}

	private static void eliminarUsuarioCodigo(Integer idPersona) {
		RepositorioUsuario.eliminarUsuarioCodigo(idPersona);
	}

	public static void consultarPersona(final Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarPersona(idPersona);
		System.out.println(persona.getNombre());
	}

	public static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		System.out.println(personas.size());
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
	
	private static void modificarNombreOrdenador(Integer idOrdenador, String modelo) {
		RepositorioOrdenador.modificarNombreOrdenador(idOrdenador, modelo);
	}
}

