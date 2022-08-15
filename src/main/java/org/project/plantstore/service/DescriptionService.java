package org.project.plantstore.service;

import org.project.plantstore.entity.Description;

import java.util.List;

public interface DescriptionService {

    void saveDescription(Description description);

    Description getDescription(Long id);

    void deleteDescription(Long id);
}
