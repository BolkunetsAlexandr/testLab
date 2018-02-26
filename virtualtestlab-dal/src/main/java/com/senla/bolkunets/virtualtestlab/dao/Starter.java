package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.fake.FakePersoneDao;
import com.senla.bolkunets.virtualtestlab.domain.fake.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("spring-dao-context.xml");

        FakePersoneDao personDao = applicationContext.getBean(FakePersoneDao.class);
        Person person = new Person();
        person.setCountChildren(1213);
        person.setAge(123123);
        personDao.create(person);

        person.setAge(1);

        System.out.println(personDao.read(1));

    }
}
