package com.senla.bolkunets.virtualtestlab.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;


public class AbstractDao<PKey, Entity> implements GenericDao<PKey, Entity> {

    private Class<Entity> type;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public AbstractDao(Class<Entity> type) {
        this.type = type;
    }


    public void create(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public Entity read(PKey id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(type, id);
    }

    public void update(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void delete(Entity entity) {

    }

    public List<Entity> readAll() {
        return null;
    }

}
