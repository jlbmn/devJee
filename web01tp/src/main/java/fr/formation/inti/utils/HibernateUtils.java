package fr.formation.inti.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * meme chose qu'avec jpa PERSISTENCE
 * @author johan
 *
 */
public class HibernateUtils {
	
	private static final Log log = LogFactory.getLog(HibernateUtils.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory() {
		// needs the configuration file to create sessionfactory
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build(); 
		
		return metadata.getSessionFactoryBuilder().build();
		
	}
	
	public static SessionFactory getSessionFactory() {
		log.debug("creating session factory");
		return sessionFactory;
	}
	
	public static void close() {
		log.debug("closing session factory");
		getSessionFactory().close();
	}
	
	
	
	
	
	
}
