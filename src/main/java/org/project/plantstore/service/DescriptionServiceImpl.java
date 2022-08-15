package org.project.plantstore.service;

import org.project.plantstore.dao.DescriptionDAO;
import org.project.plantstore.entity.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DescriptionServiceImpl implements DescriptionService {

    @Autowired
    private DescriptionDAO descriptionDAO;

    @Override
    public void saveDescription(Description description) {
        descriptionDAO.saveDescription(description);
    }

    @Override
    public Description getDescription(Long id) {
        return descriptionDAO.getDescription(id);
    }

    @Override
    public void deleteDescription(Long id) {
        descriptionDAO.deleteDescription(id);
    }
}
