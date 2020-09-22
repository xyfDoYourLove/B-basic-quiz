package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.dto.EducationDto;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<EducationDto, Long> {

  List<EducationDto> findAllByUser(UserDto userDto);

}
