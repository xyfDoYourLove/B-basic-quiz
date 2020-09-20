package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.EducationConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

  private final EducationRepository educationRepository;

  private final EducationConvertUtil educationConvertUtil;

  public EducationService(EducationRepository educationRepository, EducationConvertUtil educationConvertUtil) {
    this.educationRepository = educationRepository;
    this.educationConvertUtil = educationConvertUtil;
  }

  public List<Education> findEducationsByUserId(long userId) {
    return educationRepository.findAllByUser(UserDto.builder().id(userId).build())
            .stream()
            .map(educationConvertUtil::DtoToEducation)
            .collect(Collectors.toList());
  }

  public void addEducation(long userId, Education education) {
    education.setUserId(userId);
    educationRepository.save(educationConvertUtil.EducationToDto(education));
  }
}
