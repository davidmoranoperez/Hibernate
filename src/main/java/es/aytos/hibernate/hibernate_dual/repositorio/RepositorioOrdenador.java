package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Ordenador;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioOrdenador {

	public static Integer crearOrdenador(final Ordenador ordenador) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			final Integer idPersona = (Integer) sesion.save(ordenador);
			
			sesion.getTransaction().commit();
			
			return idPersona;
			
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando el ordenador: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void modificarNombreOrdenador(Integer idOrdenador, final String modelo) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Ordenador set ord_mod =:modelo where ord_id = :identificador")
					.setParameter("modelo", modelo).setParameter("identificador", idOrdenador).executeUpdate();

//			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :identificador")
//					.setParameter("identificador", idPersona).uniqueResult();
//
//			personaBBDD.setNombre(nombre);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el nombre: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	
	public static void eliminarOrdenadorCodigo(Integer idOrdenador) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Ordenador where ord_id = :identificador")
			.setParameter("identificador", idOrdenador).executeUpdate();
			
//			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :identificador")
//					.setParameter("identificador", idPersona).uniqueResult();
//
//			personaBBDD.setNombre(nombre);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando el ordenador: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
