package com.thoughtworks.gtb.basic.quiz.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  private long age;

  private String avatar;

  private String description;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<EducationDto> educationDtos;
}
