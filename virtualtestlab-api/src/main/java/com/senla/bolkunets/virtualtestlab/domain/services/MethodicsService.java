package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;

import java.util.List;

public interface MethodicsService {

    List<Methodics> getAllMethodicsDescriptions();

    Methodics findById(Integer id);

}
