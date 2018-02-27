package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.model.users.Person;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPersonDao extends JpaAbstractDao<Integer, Person> implements PersonDao {
    public JpaPersonDao() {
        super(Person.class);
    }
}
