package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodicsServiceImpl implements MethodicsService {

    private MethodicsDao methodicsDao;

    public MethodicsServiceImpl(MethodicsDao methodicsDao) {
        this.methodicsDao = methodicsDao;
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
}
