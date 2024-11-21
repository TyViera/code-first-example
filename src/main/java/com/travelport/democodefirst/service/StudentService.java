package com.travelport.democodefirst.service;

import com.travelport.democodefirst.model.Student;
import java.util.List;

public interface StudentService {
  List<Student> getAll();

  Student create(Student student);
}
