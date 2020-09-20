package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import com.thoughtworks.gtb.basic.quiz.basic.common.UserConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import com.thoughtworks.gtb.basic.quiz.basic.exception.UserNotExistException;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  private final UserConvertUtil userConvertUtil;

  public UserService(UserRepository userRepository, UserConvertUtil userConvertUtil) {
    this.userRepository = userRepository;
    this.userConvertUtil = userConvertUtil;
  }

  public User findUserById(long id) {
    Optional<UserDto> first = userRepository.findById(id);
    if (first.isPresent()) {
      return userConvertUtil.DtoToUser(first.get());
    }else {
      throw new UserNotExistException(ExceptionMessageConstant.USER_NOT_EXIST);
    }
  }

  public long createUser(User user) {
    UserDto userDto = userRepository.save(userConvertUtil.UserToDto(user));
    return userDto.getId();
  }
}
