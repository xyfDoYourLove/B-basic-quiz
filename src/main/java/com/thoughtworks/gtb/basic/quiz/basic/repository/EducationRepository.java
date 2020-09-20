package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;

import java.util.List;

public interface EducationRepository {

  List<Education> findEducationsByUserId(long userId);

  void save(Education education);

}
