package com.senla.bolkunets.virtualtestlab.controllers;

import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.UserProfileDto;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;


    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    @ResponseBody
    public UserProfileDto createUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfile userProfile = dozerBeanMapper.map(userProfileDto, UserProfile.class);
        UserProfile persistUserProfile = userProfileService.createUserProfile(userProfile);
        UserProfileDto responseUserProfile = dozerBeanMapper.map(persistUserProfile, UserProfileDto.class);
        return responseUserProfile;
    }


    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public ResponseEntity getAllUsers(@PathVariable String login){
        UserProfile userProfile = userProfileService.findUserProfileByLogin(login);
        UserProfileDto userProfileDto = dozerBeanMapper.map(userProfile, UserProfileDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(userProfileDto);
    }

}
