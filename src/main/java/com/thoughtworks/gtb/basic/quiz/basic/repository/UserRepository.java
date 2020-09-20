package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDto, Long> {

}
