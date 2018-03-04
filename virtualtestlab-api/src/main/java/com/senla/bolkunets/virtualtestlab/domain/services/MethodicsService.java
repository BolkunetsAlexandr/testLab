package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;

import java.util.List;

public interface MethodicsService {

    Methodics createMethodics(Methodics methodics);

    void deleteMethodics(Methodics methodics);

    List<Methodics> getAllMethodics();

    Methodics findById(Integer id);

    List<Methodics> getMethodicsByUserProfile(Integer userProfileId);

    Methodics deleteMethodicsById(Integer id);
}
