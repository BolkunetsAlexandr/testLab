package com.senla.bolkunets.virtualtestlab.controllers;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.MethodicsDescriptionDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.MethodicsWithQuestionsDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MethodicsController {

    @Autowired
    private MethodicsService methodicsService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/methodics/all", method = RequestMethod.GET)
    @ResponseBody
    public List<MethodicsDescriptionDto> getAllDescriptionsMethodics(){
        final List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<MethodicsDescriptionDto>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getAllMethodicsDescriptions();
        for(Methodics methodics : allMethodicsDescriptions){
            MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
            methodicsDescriptionDtoList.add(methodicsDescriptionDto);
        }
        return methodicsDescriptionDtoList;
    }

    @RequestMapping(value = "/methodics/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MethodicsWithQuestionsDto getMethodicsById(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.findById(id);
        return dozerBeanMapper.map(methodics, MethodicsWithQuestionsDto.class);
    }


}
