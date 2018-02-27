package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.methodics.description.Methodics;
import org.springframework.stereotype.Repository;

@Repository
public class JpaMethodicsDao extends JpaAbstractDao<Integer, Methodics> implements MethodicsDao {
    public JpaMethodicsDao() {
        super(Methodics.class);
    }
}
