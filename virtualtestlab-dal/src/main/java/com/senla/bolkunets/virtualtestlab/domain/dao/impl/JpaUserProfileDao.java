package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaUserProfileDao extends JpaAbstractDao<Integer, UserProfile> implements UserProfileDao {
    public JpaUserProfileDao() {
        super(UserProfile.class);
    }

    public UserProfile findUserByLogin(String login) {
        UserProfile userProfile = null;
        EntityManager entityManager = super.getEntityManager();
        userProfile = (UserProfile) entityManager
                .createQuery("select user from UserProfile user where user.login = :login ")
                .setParameter("login", login).getSingleResult();
        return userProfile;
    }
}
