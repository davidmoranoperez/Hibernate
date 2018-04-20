package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioUsuario {

	public static void eliminarUsuarioCodigo(Integer idUsuario) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Usuario where usu_id = :identificador").setParameter("identificador", idUsuario)
					.executeUpdate();

			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :identificador")
			// .setParameter("identificador", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);
			
			sesion.delete(idUsuario);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
