package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.exception.ParamIllegalException;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findUserById(long id) {
    Optional<User> first = userRepository.findUserById(id);
    if (first.isPresent()) {
      return first.get();
    }else {
      throw new ParamIllegalException(ExceptionMessageConstant.USER_NOT_EXIST);
    }
  }
}
