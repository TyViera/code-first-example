package com.travelport.democodefirst.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema
public class Student {

  @Length(min = 3)
  @Schema(description = "Student ID", example = "asadh", minLength = 3)
  private String id;

  @NotNull
  @Schema(description = "Student Name", example = "Joe", minLength = 2, maxLength = 35)
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
