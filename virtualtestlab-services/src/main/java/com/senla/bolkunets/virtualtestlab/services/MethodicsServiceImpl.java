package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.PassingFactDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodicsServiceImpl implements MethodicsService {

    private MethodicsDao methodicsDao;

    private UserProfileDao userProfileDao;

    public MethodicsServiceImpl(MethodicsDao methodicsDao, UserProfileDao userProfileDao) {
        this.methodicsDao = methodicsDao;
        this.userProfileDao = userProfileDao;
    }

    public void createMethodics(Methodics methodics) {
        methodicsDao.create(methodics);
    }

    public void deleteMethodics(Methodics methodics) {

    }

    public List<Methodics> getAllMethodicsDescriptions() {
        return methodicsDao.readAll();
    }

    public Methodics findById(Integer id) {
        return methodicsDao.read(id);
    }

    public List<Methodics> getMethodicsByUserProfile(Integer userProfileId) {
        UserProfile userProfile = userProfileDao.read(userProfileId);
        if(userProfile!=null){
            return userProfile.getOpenMethodicsForUser();
        }
        return null;
    }
}
