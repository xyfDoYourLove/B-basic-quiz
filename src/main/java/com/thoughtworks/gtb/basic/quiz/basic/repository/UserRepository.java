package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.common.MockDataBase;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

  public Optional<User> findUserById(long id) {
   return MockDataBase.USER_LIST
            .stream()
            .filter(item -> item.getId() == id)
            .findFirst();
  }
}
