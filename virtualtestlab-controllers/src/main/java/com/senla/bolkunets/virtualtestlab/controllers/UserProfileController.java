package com.senla.bolkunets.virtualtestlab.controllers;

import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.UserProfileDto;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProfileController {

    private UserProfileService userProfileService;

    private DozerBeanMapper dozerBeanMapper;

    public UserProfileController(UserProfileService userProfileService, DozerBeanMapper dozerBeanMapper) {
        this.userProfileService = userProfileService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    @ResponseBody
    public UserProfileDto createUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfile userProfile = dozerBeanMapper.map(userProfileDto, UserProfile.class);
        UserProfile persistUserProfile = userProfileService.createUserProfile(userProfile);
        UserProfileDto responseUserProfile = dozerBeanMapper.map(persistUserProfile, UserProfileDto.class);
        return responseUserProfile;
    }


    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public ResponseEntity getUsersByLogin(@PathVariable String login){
        UserProfile userProfile = userProfileService.findUserProfileByLogin(login);
        UserProfileDto userProfileDto = dozerBeanMapper.map(userProfile, UserProfileDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(userProfileDto);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getAllUsers(){
        List<UserProfileDto> response = new ArrayList<>();
        List<UserProfile> userProfile = userProfileService.getUsers();
        userProfile.forEach(x-> response.add(dozerBeanMapper.map(x, UserProfileDto.class)));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
