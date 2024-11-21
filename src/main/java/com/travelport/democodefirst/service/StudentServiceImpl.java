package com.travelport.democodefirst.service;

import com.travelport.democodefirst.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final List<Student> studentList = new ArrayList<>();

  @Override
  public List<Student> getAll() {
    return studentList;
  }

  @Override
  public Student create(Student student) {
    studentList.add(student);
    return student;
  }
}
