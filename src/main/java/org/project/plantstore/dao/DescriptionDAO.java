package org.project.plantstore.dao;

import org.project.plantstore.entity.Description;

import java.util.List;

public interface DescriptionDAO {

    List<Description> getDescriptions();

    void saveDescription(Description description);

    Description getDescription(Long id);

    void deleteDescription(Long id);
}
