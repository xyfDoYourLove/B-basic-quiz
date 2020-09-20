package com.thoughtworks.gtb.basic.quiz.basic.repository.memoryImpl;

import com.thoughtworks.gtb.basic.quiz.basic.common.MockDataBase;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EducationRepositoryImpl implements EducationRepository {

  @Override
  public List<Education> findEducationsByUserId(long userId) {
    return MockDataBase.EDUCATION_LIST
            .stream()
            .filter(item -> item.getUserId() == userId)
            .collect(Collectors.toList());
  }

  @Override
  public void save(Education education) {
    MockDataBase.EDUCATION_LIST.add(education);
  }
}
