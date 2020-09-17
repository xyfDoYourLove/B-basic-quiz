package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.exception.UserNotExistException;
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
    // GTB: 用 Optional 的话，有更优雅的写法，自己再研究一下
    if (first.isPresent()) {
      return first.get();
    }else {
      throw new UserNotExistException(ExceptionMessageConstant.USER_NOT_EXIST);
    }
  }

  public long createUser(User user) {
    // GTB: - 这种生成的 id 的方法不好，简单自增的 long 类型字段就可以了
    user.setId(System.currentTimeMillis());
    userRepository.save(user);
    return user.getId();
  }
}
