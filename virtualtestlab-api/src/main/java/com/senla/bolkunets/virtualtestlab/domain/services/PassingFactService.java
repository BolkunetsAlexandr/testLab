package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;

import java.util.List;

public interface PassingFactService {

    void createPassingFact(PassingFact passingFact);

    void deletePassingFact(PassingFact deleteFact);

    void addScaleValueToResultPassingFact(ScaleValue scaleValue, PassingFact passingFact);

    List<PassingFact> findPassingFactByMethodicsId(Integer methodicsId);

}
