package com.thoughtworks.gtb.basic.quiz.basic.common;

import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConvertUtil {

  public UserDto UserToDto (User user) {
    return UserDto.builder()
            .age(user.getAge())
            .avatar(user.getAvatar())
            .name(user.getName())
            .description(user.getDescription())
            .build();
  }

  public User DtoToUser(UserDto userDto) {
    return User.builder()
            .id(userDto.getId())
            .name(userDto.getName())
            .age(userDto.getAge())
            .avatar(userDto.getAvatar())
            .description(userDto.getDescription())
            .build();
  }

}
