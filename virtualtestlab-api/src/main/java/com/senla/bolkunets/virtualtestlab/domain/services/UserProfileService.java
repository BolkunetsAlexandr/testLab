package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;

public interface UserProfileService {

    void createUserProfile(UserProfile userProfile);
    void deleteUserProfile(UserProfile userProfile);
    UserProfile findUserProfileByLogin(String login);

}
