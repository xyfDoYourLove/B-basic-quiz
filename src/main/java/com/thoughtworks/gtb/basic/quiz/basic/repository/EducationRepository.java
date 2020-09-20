package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.dto.EducationDto;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<EducationDto, Long> {

  List<EducationDto> findAllByUser(UserDto userDto);

}
