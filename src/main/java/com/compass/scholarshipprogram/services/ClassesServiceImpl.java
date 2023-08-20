package com.compass.scholarshipprogram.services;

import java.util.List;
import java.util.Optional;

import com.compass.scholarshipprogram.model.Description;
import com.compass.scholarshipprogram.repositories.DescriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.repositories.ClassesRepository;

@Service
@Component
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;

    private final DescriptionRepository descriptionRepository;

    public ClassesServiceImpl(ClassesRepository classesRepository, DescriptionRepository descriptionRepository) {
        this.classesRepository = classesRepository;
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public Classes save(Classes classes) {

        if(classes.getDescriptionId() != null) {
            Optional<Description> description = descriptionRepository.findById(classes.getDescriptionId().getId());
            classes.setDescriptionId(description.get());
        }

        return classesRepository.save(classes);
    }

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(long theId) {
        Optional<Classes> result = classesRepository.findById(theId);

        Classes theClasses = null;

        if (result.isPresent()) {
            theClasses = result.get();
            theClasses.setName(result.get().getName());
        } else {

            throw new RuntimeException("Did not find class id - " + theId);
        }

        return theClasses;
    }


    @Override
    public void deleteById(long theId) { classesRepository.deleteById(theId); }
}
