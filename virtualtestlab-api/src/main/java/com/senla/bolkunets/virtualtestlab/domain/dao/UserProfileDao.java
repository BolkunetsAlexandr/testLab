package com.senla.bolkunets.virtualtestlab.domain.dao;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;

public interface UserProfileDao extends GenericDao<Integer, UserProfile> {
    UserProfile findUserByLogin(String login);
}
