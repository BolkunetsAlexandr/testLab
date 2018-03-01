package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

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
