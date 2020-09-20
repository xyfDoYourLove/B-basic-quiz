package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.domain.User;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findUserById(long id);

  void save(User user);

}
