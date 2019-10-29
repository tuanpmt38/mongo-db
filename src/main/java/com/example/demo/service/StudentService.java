package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentEditDto;
import com.example.demo.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

  Student save(StudentDto studentDto);


  List<Student> findAll();

  Optional<Student> findById(String id);
}
