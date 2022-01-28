package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.formation.inti.utils.HibernateUtils;

public class GenericDaoHibernate<T, I extends Serializable> implements IGenericDao<T, I>{
	
	private Class<T> type;
	private SessionFactory sessionFactory;

	public GenericDaoHibernate() {
		sessionFactory = HibernateUtils.getSessionFactory();
		this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public I save(T t) {
		return (I)getSession().save(t) ;
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(I i) {
		getSession().delete(getSession().find(type, i));
	}

	@Override
	public T findById(I i) {
		return (T)getSession().find(type, i);
	}

	@Override
	public List<T> findAll() {
		String hql = "SELECT e FROM "+type.getName()+" e";
		Query<T> query = getSession().createQuery(hql);
		List<T> datas = query.getResultList();
		return datas;
	}
	
	public void commitTransaction() {
		getSession().getTransaction().commit();
	}
	
	public void closeResources() {
		getSession().close();
		sessionFactory.close();
	}
	
	public void rollbackTransaction() {
		getSession().getTransaction().rollback();
	}
	
	public void beginTransaction() {
		if(!getSession().getTransaction().isActive()) {
			getSession().beginTransaction();
		}
	}
	
	
	
}
