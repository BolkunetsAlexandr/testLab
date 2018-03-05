package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.MethodicsKey;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static  org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-test-dao.xml")
public class JpaMethodicsDaoTest {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String NEW_NAME = "new name";
    @Autowired
    private MethodicsDao methodicsDao;

    @After
    public void clear(){
        List<Methodics> methodicsList = methodicsDao.readAll();
        methodicsList.forEach(x -> methodicsDao.delete(x));
    }

    @Test
    public void updateMethodics(){
        Methodics methodics = new Methodics();
        methodics.setName(NAME);
        methodics.setDescription(DESCRIPTION);
        methodics.setLeftValueBorder(0);
        methodics.setRightValueBorder(5);
        Methodics resultMethodics = methodicsDao.create(methodics);

        methodics.setName(NEW_NAME);
        methodicsDao.update(methodics);

        Methodics read = methodicsDao.read(resultMethodics.getId());
        assertEquals(NEW_NAME, read.getName());

    }

    @Test
    public void createEmptyMethodics(){
        Methodics methodics = new Methodics();
        methodics.setName(NAME);
        methodics.setDescription(DESCRIPTION);
        methodics.setLeftValueBorder(0);
        methodics.setRightValueBorder(5);

        Methodics resultMethodics = methodicsDao.create(methodics);

        assertNotNull(resultMethodics.getId());
    }

    @Test(expected = Exception.class)
    public void createMethodicsWithoutName(){
        Methodics methodics = new Methodics();
        methodics.setDescription(DESCRIPTION);
        methodics.setLeftValueBorder(0);
        methodics.setRightValueBorder(5);

        methodicsDao.create(methodics);
    }

    @Test
    public void readMethodics(){

        Methodics methodics = new Methodics();
        methodics.setName(NAME);
        methodics.setDescription(DESCRIPTION);
        methodics.setLeftValueBorder(0);
        methodics.setRightValueBorder(5);

        methodicsDao.create(methodics);

        List<Methodics> methodicsList = methodicsDao.readAll();
        assertTrue(methodicsList.size() == 1);
    }

    @Test
    public void getMethodicsByName(){

        Methodics methodics = new Methodics();
        methodics.setName(NAME);
        methodics.setDescription(DESCRIPTION);
        methodics.setLeftValueBorder(0);
        methodics.setRightValueBorder(5);

        Methodics resultMethodics = methodicsDao.create(methodics);

        Methodics methodicFound = methodicsDao.getMethodicsByName(NAME);
        assertEquals(resultMethodics, methodicFound);
    }



}