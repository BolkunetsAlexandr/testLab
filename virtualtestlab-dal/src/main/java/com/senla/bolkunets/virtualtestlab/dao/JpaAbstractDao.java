package com.senla.bolkunets.virtualtestlab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaAbstractDao<PKey, Entity> implements GenericDao<PKey, Entity> {

    private Class<Entity> type;

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    public JpaAbstractDao(Class<Entity> type) {
        this.type = type;
    }

    public void create(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    public Entity read(PKey id) {
        Entity entity;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entity = entityManager.find(type, id);
        entityManager.close();
        return entity;
    }

    public void update(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    public void delete(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        entityTransaction.commit();
        entityManager.close();
    }

    public List<Entity> readAll() {
        List<Entity> entities = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entities = entityManager.createQuery("select entity from " + type.getSimpleName() + " entity ").getResultList();
        entityManager.close();
        return entities;
    }

}
