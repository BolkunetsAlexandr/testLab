package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaAbstractDao<PKey, Entity> implements GenericDao<PKey, Entity> {

    private Class<Entity> type;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public JpaAbstractDao(Class<Entity> type) {
        this.type = type;
    }

    @Transactional
    public void create(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    @Transactional
    public Entity read(PKey id) {
        Entity entity;
        EntityManager entityManager = getEntityManager();
        entity = entityManager.find(type, id);
        entityManager.close();
        return entity;
    }

    @Transactional
    public void update(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    @Transactional
    public void delete(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        entityTransaction.commit();
        entityManager.close();
    }

    @Transactional
    public List<Entity> readAll() {
        List<Entity> entities = null;
        EntityManager entityManager = getEntityManager();
        entities = entityManager.createQuery("select entity from " + type.getSimpleName() + " entity ").getResultList();
        entityManager.close();
        return entities;
    }

    protected EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
