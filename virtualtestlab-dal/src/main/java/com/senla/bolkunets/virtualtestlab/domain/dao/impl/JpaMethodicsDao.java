package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import org.springframework.stereotype.Repository;

@Repository
public class JpaMethodicsDao extends JpaAbstractDao<Integer, Methodics> implements MethodicsDao {
    public JpaMethodicsDao() {
        super(Methodics.class);
    }

    public Methodics getMethodicsByName(String name) {
        return null;
    }
}
