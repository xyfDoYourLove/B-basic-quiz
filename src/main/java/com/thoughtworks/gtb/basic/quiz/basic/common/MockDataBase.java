package com.thoughtworks.gtb.basic.quiz.basic.common;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;

import java.util.ArrayList;
import java.util.List;

// GTB: 单纯是为了方便测试吗？还是有其他的意图？
public class MockDataBase {

  private MockDataBase(){};

  public static final List<User> USER_LIST = new ArrayList<>();

  public static final List<Education> EDUCATION_LIST = new ArrayList<>();

}
