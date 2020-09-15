package com.thoughtworks.gtb.basic.quiz.basic.api;

import com.thoughtworks.gtb.basic.quiz.basic.domain.Education;
import com.thoughtworks.gtb.basic.quiz.basic.domain.User;
import com.thoughtworks.gtb.basic.quiz.basic.service.EducationService;
import com.thoughtworks.gtb.basic.quiz.basic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

  private final UserService userService;
  private final EducationService educationService;

  public UserController(UserService userService, EducationService educationService) {
    this.userService = userService;
    this.educationService = educationService;
  }

  @GetMapping(path = "/{id}")
  public User findUserById(@PathVariable long id) {
    return userService.findUserById(id);
  }

  @GetMapping(path = "/{id}/educations")
  public List<Education> findEducationsByUserId(@PathVariable long id) {
    return educationService.findEducationsByUserId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public long createUser(@RequestBody @Valid User user) {
    return userService.createUser(user);
  }

  @PostMapping(path = "/{user_id}/educations")
  @ResponseStatus(HttpStatus.CREATED)
  public void addEducation(@PathVariable long user_id, @RequestBody @Valid Education education) {
    educationService.addEducation(user_id, education);
  }

}
