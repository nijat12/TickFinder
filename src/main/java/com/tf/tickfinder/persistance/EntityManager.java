package com.tf.tickfinder.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tf.tickfinder.web.Response;

public class EntityManager<T> {
	private Class<T> entityClass;
	private SessionFactory factory;

	public EntityManager(Class<T> entityClass) {
		factory = Database.getInstance().getSessionFactory();
		this.entityClass = entityClass;
	}

	public T create(T t) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(t);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	public T getUnique(String query) {
		Session session = factory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T object = (T) session.createQuery(query).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return object;
	}

	public List<T> getAll() {
		Session session = factory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> objectList = session.createCriteria(entityClass).list();
		session.getTransaction().commit();
		session.close();
		return objectList;
	}

	public T get(long id) {
		Session session = factory.openSession();
		session.beginTransaction();
		T t = (T) session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	public Response update(T t) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();
		return new Response("OK");
	}

	public Response delete(long id) {
		Session session = factory.openSession();
		session.beginTransaction();
		T t = session.load(entityClass, id);
		session.delete(t);
		session.getTransaction().commit();
		session.close();
		return new Response("OK");
	}

}
