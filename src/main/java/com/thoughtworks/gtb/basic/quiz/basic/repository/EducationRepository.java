package com.thoughtworks.gtb.basic.quiz.basic.repository;

import com.thoughtworks.gtb.basic.quiz.basic.common.MockDataBase;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EducationRepository {


  public List<Education> findEducationsByUserId(long userId) {
    return MockDataBase.EDUCATION_LIST
            .stream()
            .filter(item -> item.getUserId() == userId)
            .collect(Collectors.toList());
  }

  public void save(Education education) {
    MockDataBase.EDUCATION_LIST.add(education);
  }
}
