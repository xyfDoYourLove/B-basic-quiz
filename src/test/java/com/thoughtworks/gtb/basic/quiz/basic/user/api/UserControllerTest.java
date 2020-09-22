package com.thoughtworks.gtb.basic.quiz.basic.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gtb.basic.quiz.basic.api.UserController;
import com.thoughtworks.gtb.basic.quiz.basic.common.EducationConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.common.MockDataBase;
import com.thoughtworks.gtb.basic.quiz.basic.common.UserConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.repository.EducationRepository;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserConvertUtil userConvertUtil;

  @Autowired
  EducationRepository educationRepository;

  @Autowired
  EducationConvertUtil educationConvertUtil;

  @BeforeEach
  public void setUp() {

    User user1 = new User(1, "xiao", 19, "imgurleeee", "descriptionssss");
    User user2 = new User(2, "xiao", 19, "imgurleeee", "descriptionssss");
    User user3 = new User(3, "xiao", 19, "imgurleeee", "descriptionssss");
    userRepository.save(userConvertUtil.UserToDto(user1));
    userRepository.save(userConvertUtil.UserToDto(user2));
    userRepository.save(userConvertUtil.UserToDto(user3));

    Education education1 = new Education(1, 2020, "title_title", "description_description_description");
    Education education2 = new Education(2, 2020, "title_title", "description_description_description");
    Education education3 = new Education(3, 2020, "title_title", "description_description_description");
    educationRepository.save(educationConvertUtil.EducationToDto(education1));
    educationRepository.save(educationConvertUtil.EducationToDto(education2));
    educationRepository.save(educationConvertUtil.EducationToDto(education3));
  }

  @Nested
  class GetUserById {

    @Nested
    class WhenIdLegal{
      @Test
      void should_get_user_single() throws Exception {
        long id = userRepository.findAll().get(0).getId();
        mockMvc.perform(get("/users/"+id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("xiao")))
                .andExpect(jsonPath("$.age", is(19)))
                .andExpect(jsonPath("$.avatar", is("imgurleeee")))
                .andExpect(jsonPath("$.description", is("descriptionssss")));
      }
    }

    @Nested
    class WhenIdIllegal{
      @Test
      void should_get_user_single() throws Exception {
        mockMvc.perform(get("/users/"+99999999))
                .andExpect(status().isNotFound());
      }
    }

  }

  @Nested
  class GetEducationsById {

    @Test
    void should_get_educations_when_get_by_id_given_user_id() throws Exception {
      long id = userRepository.findAll().get(0).getId();
      mockMvc.perform(get("/users/"+id+"/educations"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$[0].userId", is(1)))
              .andExpect(jsonPath("$[0].year", is(2020)))
              .andExpect(jsonPath("$[0].title", is("title_title")))
              .andExpect(jsonPath("$[0].description", is("description_description_description")));
    }

  }

  @Nested
  class PostUser{

    @Test
    void should_add_user_when_post_user_given_user() throws Exception {

      User user4 = new User(4, "xiao", 19, "imgurleeee", "descriptionssss");

      ObjectMapper objectMapper = new ObjectMapper();
      String jsonString = objectMapper.writeValueAsString(user4);

      mockMvc.perform(post("/users").content(jsonString).contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isCreated());
    }

  }

  @Nested
  class PostEducation{

    @Test
    void should_add_education_when_post_education_given_education() throws Exception {

      long id = userRepository.findAll().get(0).getId();
      Education education = new Education(id, 2020, "title", "description");

      ObjectMapper objectMapper = new ObjectMapper();
      String jsonString = objectMapper.writeValueAsString(education);

      mockMvc.perform(post("/users/"+id+"/educations").content(jsonString).contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isCreated());
    }

  }
}
