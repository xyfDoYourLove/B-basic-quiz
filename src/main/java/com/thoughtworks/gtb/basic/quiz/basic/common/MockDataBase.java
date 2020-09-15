package com.thoughtworks.gtb.basic.quiz.basic.common;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MockDataBase {

  private MockDataBase(){};

  public static final List<User> USER_LIST = new ArrayList<>();

  public static final List<Education> EDUCATION_LIST = new ArrayList<>();

}
