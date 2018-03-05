package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaAbstractDao<PKey, Entity> implements GenericDao<PKey, Entity> {

    private Logger log = Logger.getLogger(JpaAbstractDao.class);

    private Class<Entity> type;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    public JpaAbstractDao(Class<Entity> type) {
        this.type = type;
    }

    protected EntityManager getEntityManager(){
        if(entityManager==null || !entityManager.isOpen() ){
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public Entity create(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        }catch (Exception e){
            log.error(e.getMessage());
            transaction.rollback();
            throw e;
        }
        return entity;
    }

    public Entity read(PKey id) {
        Entity entity;
        EntityManager entityManager = getEntityManager();
        entity = entityManager.find(type, id);
        return entity;
    }

    public void update(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        }catch (Exception e){
            log.error(e.getMessage());
            transaction.rollback();
            throw e;
        }
    }

    public void delete(Entity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            entityTransaction.commit();
        }catch (Exception e){
            log.error(e.getMessage());
            entityTransaction.rollback();
            throw e;
        }
    }

    public List<Entity> readAll() {
        List<Entity> entities = null;
        EntityManager entityManager = getEntityManager();
        entities = entityManager.createQuery("select entity from " + type.getSimpleName() + " entity ").getResultList();
        return entities;
    }



}
