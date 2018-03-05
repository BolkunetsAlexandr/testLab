package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MethodicsDaoImpl extends AbstractDao<Integer, Methodics> implements MethodicsDao {
    public MethodicsDaoImpl() {
        super(Methodics.class);
    }

    public Methodics getMethodicsByName(String name) {
        Methodics methodics = null;
        EntityManager entityManager = super.getEntityManager();
        methodics = (Methodics) entityManager
                .createQuery("select methodics from Methodics methodics where methodics.name = :name ")
                .setParameter("name", name).getSingleResult();
        return methodics;
    }
}
