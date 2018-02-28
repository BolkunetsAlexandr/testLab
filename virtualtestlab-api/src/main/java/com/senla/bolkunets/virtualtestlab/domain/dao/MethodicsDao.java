package com.senla.bolkunets.virtualtestlab.domain.dao;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;

import java.util.List;

public interface MethodicsDao extends GenericDao<Integer, Methodics> {

    Methodics getMethodicsByName(String name);

}
