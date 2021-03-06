package com.thoughtworks.gtb.basic.quiz.basic.service;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
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
    // GTB: - 没有处理 user id 实际上不存在的场景
    education.setUserId(userId);
    educationRepository.save(education);
  }
}
