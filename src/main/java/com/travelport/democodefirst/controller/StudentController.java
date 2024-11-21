package com.travelport.democodefirst.controller;

import com.travelport.democodefirst.model.Error;
import com.travelport.democodefirst.model.Student;
import com.travelport.democodefirst.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@Tag(name = "students", description = "the students API")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  @Operation(
      tags = "students",
      description = "List all students",
      summary = "xyz",
      operationId = "getAllStudents",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "successful operation",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = Student.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Error.class))
            })
      })
  public List<Student> getAll() {
    return studentService.getAll();
  }

  @PostMapping
  @Operation(
      operationId = "createStudent",
      summary = "Create a new student",
      tags = "students",
      requestBody =
          @io.swagger.v3.oas.annotations.parameters.RequestBody(
              content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Student.class))
              }),
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "student created",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Student.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "something failed",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Error.class))
            })
      })
  public Student create(@RequestBody Student student) {
    return studentService.create(student);
  }
}
