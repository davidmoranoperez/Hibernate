package es.aytos.hibernate.hibernate_dual.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	
	private static SessionFactory miFactoria = construirSessionFactory();

	private static SessionFactory construirSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			System.out.println("Seha producido un error obteniendo l factoria de sesiones: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static SessionFactory getMiFactoria() {
		return miFactoria;
	}
}
