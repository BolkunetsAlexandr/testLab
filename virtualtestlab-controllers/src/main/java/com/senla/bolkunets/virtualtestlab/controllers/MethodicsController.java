package com.senla.bolkunets.virtualtestlab.controllers;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.*;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MethodicsController {

    @Autowired
    private MethodicsService methodicsService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "methodics/description/all", method = RequestMethod.GET)
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

    @RequestMapping(value = "/methodics/open/{idProfile}", method = RequestMethod.GET)
    @ResponseBody
    public List<MethodicsDescriptionDto> getOpenMethodicsForUser(@PathVariable(name = "idProfile") Integer idProfile){
        final List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<MethodicsDescriptionDto>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getMethodicsByUserProfile(idProfile);
        if(allMethodicsDescriptions!=null) {
            for (Methodics methodics : allMethodicsDescriptions) {
                MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
                methodicsDescriptionDtoList.add(methodicsDescriptionDto);
            }
        }
        return methodicsDescriptionDtoList;
    }

    @RequestMapping(value = "/methodics/description/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MethodicsDescriptionDto getDescriptionsMethodics(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.findById(id);
        return dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
    }

    @RequestMapping(value = "/methodics/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MethodicsWithQuestionsDto getMethodicsById(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.findById(id);
        return dozerBeanMapper.map(methodics, MethodicsWithQuestionsDto.class);
    }

    @RequestMapping(value = "/methodics/create", method = RequestMethod.POST)
    @ResponseBody
    public MethodicsDescriptionDto createMethodics(@RequestBody FullMethodicsDto methodicsDto){

        //TODO
        List<MethodicsKeyDto> methodicsKeyDtoList = methodicsDto.getMethodicsKeyDtoList();
        List<QuestionsWithKeyIdDto> questionsWithKeyList = methodicsDto.getQuestionsWithKeyList();


        return null;

    }
}
