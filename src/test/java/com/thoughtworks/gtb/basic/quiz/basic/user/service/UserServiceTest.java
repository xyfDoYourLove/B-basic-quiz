package com.thoughtworks.gtb.basic.quiz.basic.user.service;

import com.thoughtworks.gtb.basic.quiz.basic.common.ExceptionMessageConstant;
import com.thoughtworks.gtb.basic.quiz.basic.common.UserConvertUtil;
import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.dto.EducationDto;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import com.thoughtworks.gtb.basic.quiz.basic.exception.UserNotExistException;
import com.thoughtworks.gtb.basic.quiz.basic.repository.UserRepository;
import com.thoughtworks.gtb.basic.quiz.basic.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Nested;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserConvertUtil userConvertUtil;

  UserDto userDto;
  EducationDto educationDto1;
  EducationDto educationDto2;

  @BeforeEach
  void setUp() {
    Mockito.reset(userRepository);
    Mockito.reset(userConvertUtil);
    userService = new UserService(userRepository, userConvertUtil);

    educationDto1 = EducationDto.builder()
            .title("test")
            .year(2020)
            .description("test")
            .build();
    educationDto2 = EducationDto.builder()
            .title("test")
            .year(2020)
            .description("test")
            .build();

    userDto = UserDto.builder()
            .id(1L)
            .age(22)
            .name("xiao")
            .description("xiao test")
            .avatar("http://...")
            .educationDtos(Arrays.asList(educationDto1, educationDto2))
            .build();

  }


  @Nested
  class FindUserById {

    @Nested
    class whenUserExists {

      @Test
      void should_return_user_given_id() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userDto));

        userService.findUserById(anyLong());

        verify(userConvertUtil).DtoToUser(any());
      }

    }

    @Nested
    class whenUserNotExists {

      @Test
      void should_throw_exception_given_id() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        UserNotExistException existException = assertThrows(UserNotExistException.class, () -> {
          userService.findUserById(anyLong());
        });

        assertThat(existException.getMessage()).isEqualTo(ExceptionMessageConstant.USER_NOT_EXIST);
      }

    }
  }

  @Nested
  class WhenCreateUser {
    User user = User.builder()
            .id(1L)
            .age(22)
            .name("xiao")
            .description("xiao test")
            .avatar("http://...")
            .build();

    @Test
    void should_return_id_given_user() {
      when(userRepository.save(any())).thenReturn(userDto);

      assertEquals(user.getId(), userService.createUser(this.user));
    }

  }

}
