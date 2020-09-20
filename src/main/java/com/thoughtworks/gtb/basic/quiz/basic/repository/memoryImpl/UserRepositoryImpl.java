package com.thoughtworks.gtb.basic.quiz.basic.repository.memoryImpl;

import com.thoughtworks.gtb.basic.quiz.basic.common.MockDataBase;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Override
  public Optional<User> findUserById(long id) {
    return MockDataBase.USER_LIST
            .stream()
            .filter(item -> item.getId() == id)
            .findFirst();
  }

  @Override
  public void save(User user) {
    MockDataBase.USER_LIST.add(user);
  }
}
