package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.FullMethodicsDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;

public interface MethodicsDtoToModelConverter {

    Methodics convertNewMethodics(FullMethodicsDto methodicsDto);

}
