package com.senla.bolkunets.virtualtestlab.dao;

import com.senla.bolkunets.virtualtestlab.domain.userprofile.UserProfile;

public interface UserProfileDao extends GenericDao<Integer, UserProfile> {
    UserProfile findUserByLogin(String login);
}
