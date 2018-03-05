package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.PassingFactDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import org.springframework.stereotype.Repository;

@Repository
public class PassingFactDaoImpl extends AbstractDao<Integer, PassingFact> implements PassingFactDao {
    public PassingFactDaoImpl() {
        super(PassingFact.class);
    }
}
