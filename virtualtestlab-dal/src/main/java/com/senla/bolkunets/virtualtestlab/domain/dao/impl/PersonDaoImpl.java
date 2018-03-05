package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.PersonDao;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
    public PersonDaoImpl() {
        super(Person.class);
    }
}
