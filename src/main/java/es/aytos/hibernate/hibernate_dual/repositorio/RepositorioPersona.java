package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioPersona {

	public static void crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.save(persona);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);

			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error modificar la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarNombrePersona(Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			// sesion.createQuery("Update Persona set per_nom =:nombre where usu_id =
			// :identificador")
			// .setParameter("nombre", nombre).setParameter("identificador",
			// idPersona).executeUpdate();

			final Persona personaBBDD = (Persona) sesion
					.createQuery("from Usuario usuario where usuario.idUsuario = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();

			personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error al modificar el nombre de la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);

			sesion.delete(persona);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersonaCodigo(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Usuario where usu_id = :identificador").setParameter("identificador", idPersona)
					.executeUpdate();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static String consultarNombrePersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			Persona persona = (Persona) sesion.createQuery("select nombre from Persona where per_id = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);
			//persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getNumero()));
			
			return persona.getNombre();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static Persona consultarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			return (Persona) sesion.createQuery("from Persona where PER_ID = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();

//			 final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_DNI = :identificador")
//			 .setParameter("identificador", idPersona).uniqueResult();
//			 
//			 return personaBBDD;
			
			// personaBBDD.setNombre(nombre);
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and PER_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and PER_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and PER_DNI = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and PER_ECV = :estadoCivil");
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
			System.out.println("Se ha producido un error consutando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

}
