package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;

public interface PassingFactService {

    void createPassingFact(PassingFact passingFact);

    void deletePassingFact(PassingFact deleteFact);

    void addScaleValueToResultPassingFact(ScaleValue scaleValue, PassingFact passingFact);

}
