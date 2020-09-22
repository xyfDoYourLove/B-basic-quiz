package com.thoughtworks.gtb.basic.quiz.basic.user.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.EducationConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.dto.EducationDto;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
import com.thoughtworks.gtb.basic.quiz.basic.service.EducationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EducationServiceTest {

  private EducationService educationService;

  @Mock
  private EducationRepository educationRepository;

  @Mock
  private EducationConvertUtil educationConvertUtil;

  EducationDto educationDto1;
  EducationDto educationDto2;
  EducationDto educationDto3;
  Education education;
  UserDto userDto;

  @BeforeEach
  void setUp() {
    Mockito.reset(educationRepository);
    Mockito.reset(educationConvertUtil);
    educationService = new EducationService(educationRepository, educationConvertUtil);

    userDto = UserDto.builder()
            .id(1)
            .build();

    education = Education.builder()
            .title("test")
            .year(2020)
            .description("test")
            .userId(1L)
            .build();

    educationDto1 = EducationDto.builder()
            .title("test")
            .year(2020)
            .description("test")
            .user(userDto)
            .build();
    educationDto2 = EducationDto.builder()
            .title("test")
            .year(2020)
            .description("test")
            .user(userDto)
            .build();
    educationDto3 = EducationDto.builder()
            .title("test")
            .year(2020)
            .description("test")
            .user(userDto)
            .build();
  }

  @Nested
  class WhenFindEducations{

    @Test
    void should_return_education_list_given_userId() {

      when(educationRepository.findAllByUser(userDto)).thenReturn(Arrays.asList(educationDto1, educationDto2, educationDto3));

      List<Education> educationsByUserId = educationService.findEducationsByUserId(1L);

      assertEquals(3, educationsByUserId.size());

    }

  }


  @Nested
  class WhenAddEducation{

    @Test
    void should_add_education_given_userId_and_education() {

      educationService.addEducation(1L, education);

      verify(educationRepository).save(any());
    }
  }

}
