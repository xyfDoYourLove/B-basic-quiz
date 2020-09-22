package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {

}
