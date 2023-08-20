package com.compass.scholarshipprogram.services;

import java.util.List;
import java.util.Optional;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.repositories.ClassesRepository;
import com.compass.scholarshipprogram.repositories.SquadRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.repositories.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ClassesRepository classesRepository;
  private final SquadRepository squadRepository;

  public UserServiceImpl(UserRepository userRepository, ClassesRepository classesRepository, SquadRepository squadRepository) {
    this.userRepository = userRepository;
    this.classesRepository = classesRepository;
    this.squadRepository = squadRepository;
  }

  @Override
  public User save(User user) {

    Optional<Classes> classes = classesRepository.findById(user.getClassId().getId());

    user.setClassId(classes.get());

    if(user.getSquadId() != null) {
      Optional<Squad> squad = squadRepository.findById(user.getSquadId().getId());
      user.setSquadId(squad.get());
    }

    return userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(long theId) {
    Optional<User> result = userRepository.findById(theId);

    User theUser = null;

    if (result.isPresent()) {
      theUser = result.get();
      theUser.setName(result.get().getName());
      theUser.setCity(result.get().getCity());
      theUser.setRole(result.get().getRole());
    } else {

      throw new RuntimeException("Did not find user id - " + theId);
    }

    return theUser;
  }

  @Override
  public void deleteById(long theId) {
    userRepository.deleteById(theId);
  }

}
