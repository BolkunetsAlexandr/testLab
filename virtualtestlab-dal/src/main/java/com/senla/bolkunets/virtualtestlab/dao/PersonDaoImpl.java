package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.fake.FakePersoneDao;
import com.senla.bolkunets.virtualtestlab.domain.fake.Person;

public class PersonDaoImpl extends AbstractDao<Integer, Person> implements FakePersoneDao {
    public PersonDaoImpl() {
        super(Person.class);
    }
}
