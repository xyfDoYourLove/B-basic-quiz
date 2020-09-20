package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
import com.thoughtworks.gtb.basic.quiz.basic.repository.memoryImpl.EducationRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

  private final EducationRepository educationRepository;

  public EducationService(EducationRepository educationRepository) {
    this.educationRepository = educationRepository;
  }

  public List<Education> findEducationsByUserId(long userId) {
    return educationRepository.findEducationsByUserId(userId);
  }

  public void addEducation(long userId, Education education) {
    education.setUserId(userId);
    educationRepository.save(education);
  }
}
