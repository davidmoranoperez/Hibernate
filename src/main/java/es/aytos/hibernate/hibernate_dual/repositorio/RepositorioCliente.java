package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioCliente {

	
	// TODO: Borrar
	public static Integer crearCliente(final Cliente persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);

			sesion.saveOrUpdate(cliente);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	

	
	public static void eliminarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);

			sesion.delete(cliente);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static List<Persona> consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();
			

			final StringBuilder sb = new StringBuilder("from Cliente Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and CLI_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and CLI_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and CLI_DNI = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and CLI_ECV = :estadoCivil");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.toString());
			}
			
			

			return consulta.list();
			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);
		} catch (Exception e) {
			System.out.println("Se ha producido un error consutando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
