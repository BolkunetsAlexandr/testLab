package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileDao userProfileDao;

    public UserProfileServiceImpl(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    public void createUserProfile(UserProfile userProfile) {
        userProfileDao.create(userProfile);
    }

    public void deleteUserProfile(UserProfile userProfile) {
        userProfileDao.delete(userProfile);
    }

    public UserProfile findUserProfileByLogin(String login) {
        return userProfileDao.findUserByLogin(login);
    }
}
