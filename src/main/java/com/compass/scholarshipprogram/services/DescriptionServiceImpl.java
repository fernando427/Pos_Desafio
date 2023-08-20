package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.Description;
import com.compass.scholarshipprogram.repositories.DescriptionRepository;

import java.util.Optional;

public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public Description findById(long theId) {
        Optional<Description> result = descriptionRepository.findById(theId);

        Description theDesc = null;

        if(result.isPresent()) {
            theDesc = result.get();
            theDesc.setName(result.get().getName());
        } else {
            throw new RuntimeException("Did not find description id - " + theId);
        }

        return theDesc;
    }
}
