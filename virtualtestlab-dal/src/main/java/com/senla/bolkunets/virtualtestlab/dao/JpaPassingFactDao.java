package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.methodics.result.PassingFact;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPassingFactDao extends JpaAbstractDao<Integer, PassingFact> implements PassingFactDao {
    public JpaPassingFactDao() {
        super(PassingFact.class);
    }
}
