package com.thoughtworks.gtb.basic.quiz.basic.common;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.dto.EducationDto;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class EducationConvertUtil {

  private UserRepository userRepository;

  public EducationConvertUtil(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public EducationDto EducationToDto(Education education) {
    return EducationDto.builder()
            .title(education.getTitle())
            .year(education.getYear())
            .description(education.getDescription())
            .user(userRepository.findById(education.getUserId()).get())
            .build();
  }

  public Education DtoToEducation(EducationDto educationDto) {
    return Education.builder()
            .title(educationDto.getTitle())
            .year(educationDto.getYear())
            .description(educationDto.getDescription())
            .userId(educationDto.getUser().getId())
            .build();
  }

}
